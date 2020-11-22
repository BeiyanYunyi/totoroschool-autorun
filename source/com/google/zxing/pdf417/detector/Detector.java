package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Detector
{
  private static final int BARCODE_MIN_HEIGHT = 10;
  private static final int[] INDEXES_START_PATTERN = { 0, 4, 1, 5 };
  private static final int[] INDEXES_STOP_PATTERN = { 6, 2, 7, 3 };
  private static final float MAX_AVG_VARIANCE = 0.42F;
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.8F;
  private static final int MAX_PATTERN_DRIFT = 5;
  private static final int MAX_PIXEL_DRIFT = 3;
  private static final int ROW_STEP = 5;
  private static final int SKIPPED_ROW_COUNT_MAX = 25;
  private static final int[] START_PATTERN = { 8, 1, 1, 1, 1, 1, 1, 3 };
  private static final int[] STOP_PATTERN = { 7, 1, 1, 3, 1, 1, 1, 2, 1 };
  
  private static void copyToResult(ResultPoint[] paramArrayOfResultPoint1, ResultPoint[] paramArrayOfResultPoint2, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfResultPoint1[paramArrayOfInt[i]] = paramArrayOfResultPoint2[i];
      i += 1;
    }
  }
  
  public static PDF417DetectorResult detect(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean)
    throws NotFoundException
  {
    BitMatrix localBitMatrix = paramBinaryBitmap.getBlackMatrix();
    List localList = detect(paramBoolean, localBitMatrix);
    paramMap = localBitMatrix;
    paramBinaryBitmap = localList;
    if (localList.isEmpty())
    {
      paramMap = localBitMatrix.clone();
      paramMap.rotate180();
      paramBinaryBitmap = detect(paramBoolean, paramMap);
    }
    return new PDF417DetectorResult(paramMap, paramBinaryBitmap);
  }
  
  private static List<ResultPoint[]> detect(boolean paramBoolean, BitMatrix paramBitMatrix)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    for (int k = 0;; k = 1)
    {
      if (i >= paramBitMatrix.getHeight()) {
        break label212;
      }
      Object localObject = findVertices(paramBitMatrix, i, j);
      if ((localObject[0] == null) && (localObject[3] == null))
      {
        if (k == 0) {
          return localArrayList;
        }
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ResultPoint[] arrayOfResultPoint = (ResultPoint[])((Iterator)localObject).next();
          j = i;
          if (arrayOfResultPoint[1] != null) {
            j = (int)Math.max(i, arrayOfResultPoint[1].getY());
          }
          i = j;
          if (arrayOfResultPoint[3] != null) {
            i = Math.max(j, (int)arrayOfResultPoint[3].getY());
          }
        }
        i += 5;
        break;
      }
      localArrayList.add(localObject);
      if (!paramBoolean) {
        return localArrayList;
      }
      if (localObject[2] != null) {
        j = (int)localObject[2].getX();
      }
      for (i = (int)localObject[2].getY();; i = (int)localObject[4].getY())
      {
        break;
        j = (int)localObject[4].getX();
      }
    }
    label212:
    return localArrayList;
  }
  
  private static int[] findGuardPattern(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Arrays.fill(paramArrayOfInt2, 0, paramArrayOfInt2.length, 0);
    int m = paramArrayOfInt1.length;
    int i = 0;
    while ((paramBitMatrix.get(paramInt1, paramInt2)) && (paramInt1 > 0) && (i < 3))
    {
      paramInt1 -= 1;
      i += 1;
    }
    i = paramInt1;
    int k = 0;
    int j = paramInt1;
    paramInt1 = i;
    i = k;
    for (;;)
    {
      boolean bool = true;
      if (j >= paramInt3) {
        break;
      }
      if ((paramBitMatrix.get(j, paramInt2) ^ paramBoolean))
      {
        paramArrayOfInt2[i] += 1;
        k = paramInt1;
      }
      else
      {
        int n = m - 1;
        if (i == n)
        {
          if (patternMatchVariance(paramArrayOfInt2, paramArrayOfInt1, 0.8F) < 0.42F) {
            return new int[] { paramInt1, j };
          }
          k = paramInt1 + (paramArrayOfInt2[0] + paramArrayOfInt2[1]);
          paramInt1 = m - 2;
          System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, paramInt1);
          paramArrayOfInt2[paramInt1] = 0;
          paramArrayOfInt2[n] = 0;
          paramInt1 = i - 1;
          i = k;
        }
        else
        {
          k = i + 1;
          i = paramInt1;
          paramInt1 = k;
        }
        paramArrayOfInt2[paramInt1] = 1;
        if (!paramBoolean) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
        k = i;
        i = paramInt1;
      }
      j += 1;
      paramInt1 = k;
    }
    if ((i == m - 1) && (patternMatchVariance(paramArrayOfInt2, paramArrayOfInt1, 0.8F) < 0.42F)) {
      return new int[] { paramInt1, j - 1 };
    }
    return null;
  }
  
  private static ResultPoint[] findRowsWithPattern(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ResultPoint[] arrayOfResultPoint = new ResultPoint[4];
    int[] arrayOfInt2 = new int[paramArrayOfInt.length];
    int k;
    Object localObject;
    int[] arrayOfInt1;
    label91:
    float f1;
    float f2;
    for (;;)
    {
      k = 0;
      if (paramInt3 >= paramInt1) {
        break;
      }
      localObject = findGuardPattern(paramBitMatrix, paramInt4, paramInt3, paramInt2, false, paramArrayOfInt, arrayOfInt2);
      if (localObject != null)
      {
        i = paramInt3;
        for (;;)
        {
          paramInt3 = i;
          if (i <= 0) {
            break label91;
          }
          i -= 1;
          arrayOfInt1 = findGuardPattern(paramBitMatrix, paramInt4, i, paramInt2, false, paramArrayOfInt, arrayOfInt2);
          if (arrayOfInt1 == null) {
            break;
          }
          localObject = arrayOfInt1;
        }
        paramInt3 = i + 1;
        f1 = localObject[0];
        f2 = paramInt3;
        arrayOfResultPoint[0] = new ResultPoint(f1, f2);
        arrayOfResultPoint[1] = new ResultPoint(localObject[1], f2);
        i = 1;
        paramInt4 = paramInt3;
        break label157;
      }
      paramInt3 += 5;
    }
    int i = 0;
    paramInt4 = paramInt3;
    label157:
    paramInt3 = paramInt4 + 1;
    int j = paramInt3;
    if (i != 0)
    {
      localObject = new int[] { (int)arrayOfResultPoint[0].getX(), (int)arrayOfResultPoint[1].getX() };
      j = 0;
      i = paramInt3;
      paramInt3 = j;
      while (i < paramInt1)
      {
        int m = localObject[0];
        j = paramInt3;
        arrayOfInt1 = findGuardPattern(paramBitMatrix, m, i, paramInt2, false, paramArrayOfInt, arrayOfInt2);
        if ((arrayOfInt1 != null) && (Math.abs(localObject[0] - arrayOfInt1[0]) < 5) && (Math.abs(localObject[1] - arrayOfInt1[1]) < 5))
        {
          localObject = arrayOfInt1;
          paramInt3 = 0;
        }
        else
        {
          if (j > 25) {
            break;
          }
          paramInt3 = j + 1;
        }
        i += 1;
      }
      j = i - (paramInt3 + 1);
      f1 = localObject[0];
      f2 = j;
      arrayOfResultPoint[2] = new ResultPoint(f1, f2);
      arrayOfResultPoint[3] = new ResultPoint(localObject[1], f2);
    }
    if (j - paramInt4 < 10)
    {
      paramInt1 = k;
      while (paramInt1 < arrayOfResultPoint.length)
      {
        arrayOfResultPoint[paramInt1] = null;
        paramInt1 += 1;
      }
    }
    return arrayOfResultPoint;
  }
  
  private static ResultPoint[] findVertices(BitMatrix paramBitMatrix, int paramInt1, int paramInt2)
  {
    int i = paramBitMatrix.getHeight();
    int j = paramBitMatrix.getWidth();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[8];
    copyToResult(arrayOfResultPoint, findRowsWithPattern(paramBitMatrix, i, j, paramInt1, paramInt2, START_PATTERN), INDEXES_START_PATTERN);
    if (arrayOfResultPoint[4] != null)
    {
      paramInt2 = (int)arrayOfResultPoint[4].getX();
      paramInt1 = (int)arrayOfResultPoint[4].getY();
    }
    copyToResult(arrayOfResultPoint, findRowsWithPattern(paramBitMatrix, i, j, paramInt1, paramInt2, STOP_PATTERN), INDEXES_STOP_PATTERN);
    return arrayOfResultPoint;
  }
  
  private static float patternMatchVariance(int[] paramArrayOfInt1, int[] paramArrayOfInt2, float paramFloat)
  {
    int n = paramArrayOfInt1.length;
    int m = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < n)
    {
      k += paramArrayOfInt1[j];
      i += paramArrayOfInt2[j];
      j += 1;
    }
    if (k < i) {
      return Float.POSITIVE_INFINITY;
    }
    float f3 = k;
    float f4 = f3 / i;
    float f1 = 0.0F;
    i = m;
    while (i < n)
    {
      j = paramArrayOfInt1[i];
      float f2 = paramArrayOfInt2[i] * f4;
      float f5 = j;
      if (f5 > f2) {
        f2 = f5 - f2;
      } else {
        f2 -= f5;
      }
      if (f2 > paramFloat * f4) {
        return Float.POSITIVE_INFINITY;
      }
      f1 += f2;
      i += 1;
    }
    return f1 / f3;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */