package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader
  extends OneDReader
{
  private static final int[] DEFAULT_ALLOWED_LENGTHS = { 6, 8, 10, 12, 14 };
  private static final int[] END_PATTERN_REVERSED;
  private static final float MAX_AVG_VARIANCE = 0.38F;
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.78F;
  private static final int N = 1;
  static final int[][] PATTERNS;
  private static final int[] START_PATTERN = { 1, 1, 1, 1 };
  private static final int W = 3;
  private int narrowLineWidth = -1;
  
  static
  {
    END_PATTERN_REVERSED = new int[] { 1, 1, 3 };
    int[] arrayOfInt1 = { 1, 1, 3, 3, 1 };
    int[] arrayOfInt2 = { 3, 1, 1, 1, 3 };
    int[] arrayOfInt3 = { 1, 3, 1, 1, 3 };
    int[] arrayOfInt4 = { 3, 3, 1, 1, 1 };
    int[] arrayOfInt5 = { 1, 1, 3, 1, 3 };
    int[] arrayOfInt6 = { 1, 3, 3, 1, 1 };
    int[] arrayOfInt7 = { 1, 1, 1, 3, 3 };
    int[] arrayOfInt8 = { 3, 1, 1, 3, 1 };
    PATTERNS = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 3, 1, 3, 1, 1 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 1, 3, 1, 3, 1 } };
  }
  
  private static int decodeDigit(int[] paramArrayOfInt)
    throws NotFoundException
  {
    int k = PATTERNS.length;
    float f1 = 0.38F;
    int j = -1;
    int i = 0;
    while (i < k)
    {
      float f3 = patternMatchVariance(paramArrayOfInt, PATTERNS[i], 0.78F);
      float f2 = f1;
      if (f3 < f1)
      {
        j = i;
        f2 = f3;
      }
      i += 1;
      f1 = f2;
    }
    if (j >= 0) {
      return j;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static void decodeMiddle(BitArray paramBitArray, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
    throws NotFoundException
  {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    if (paramInt1 < paramInt2)
    {
      recordPattern(paramBitArray, paramInt1, arrayOfInt1);
      int k = 0;
      int i = 0;
      while (i < 5)
      {
        j = i * 2;
        arrayOfInt2[i] = arrayOfInt1[j];
        arrayOfInt3[i] = arrayOfInt1[(j + 1)];
        i += 1;
      }
      paramStringBuilder.append((char)(decodeDigit(arrayOfInt2) + 48));
      paramStringBuilder.append((char)(decodeDigit(arrayOfInt3) + 48));
      int m = arrayOfInt1.length;
      int j = paramInt1;
      i = k;
      for (;;)
      {
        paramInt1 = j;
        if (i >= m) {
          break;
        }
        j += arrayOfInt1[i];
        i += 1;
      }
    }
  }
  
  private static int[] findGuardPattern(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
    throws NotFoundException
  {
    int n = paramArrayOfInt.length;
    int[] arrayOfInt = new int[n];
    int i1 = paramBitArray.getSize();
    int i = paramInt;
    int k = 0;
    int m = 0;
    int j = paramInt;
    paramInt = i;
    i = m;
    while (j < i1)
    {
      if ((paramBitArray.get(j) ^ k))
      {
        arrayOfInt[i] += 1;
        m = paramInt;
      }
      else
      {
        int i2 = n - 1;
        if (i == i2)
        {
          if (patternMatchVariance(arrayOfInt, paramArrayOfInt, 0.78F) < 0.38F) {
            return new int[] { paramInt, j };
          }
          m = paramInt + (arrayOfInt[0] + arrayOfInt[1]);
          paramInt = n - 2;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, paramInt);
          arrayOfInt[paramInt] = 0;
          arrayOfInt[i2] = 0;
          paramInt = i - 1;
          i = m;
        }
        else
        {
          m = i + 1;
          i = paramInt;
          paramInt = m;
        }
        arrayOfInt[paramInt] = 1;
        k ^= 0x1;
        m = i;
        i = paramInt;
      }
      j += 1;
      paramInt = m;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int skipWhiteSpace(BitArray paramBitArray)
    throws NotFoundException
  {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    if (j != i) {
      return j;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private void validateQuietZone(BitArray paramBitArray, int paramInt)
    throws NotFoundException
  {
    int i = this.narrowLineWidth * 10;
    if (i >= paramInt) {
      i = paramInt;
    }
    paramInt -= 1;
    while ((i > 0) && (paramInt >= 0) && (!paramBitArray.get(paramInt)))
    {
      i -= 1;
      paramInt -= 1;
    }
    if (i == 0) {
      return;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  int[] decodeEnd(BitArray paramBitArray)
    throws NotFoundException
  {
    paramBitArray.reverse();
    try
    {
      int[] arrayOfInt = findGuardPattern(paramBitArray, skipWhiteSpace(paramBitArray), END_PATTERN_REVERSED);
      validateQuietZone(paramBitArray, arrayOfInt[0]);
      int i = arrayOfInt[0];
      arrayOfInt[0] = (paramBitArray.getSize() - arrayOfInt[1]);
      arrayOfInt[1] = (paramBitArray.getSize() - i);
      return arrayOfInt;
    }
    finally
    {
      paramBitArray.reverse();
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws FormatException, NotFoundException
  {
    int[] arrayOfInt = decodeStart(paramBitArray);
    Object localObject1 = decodeEnd(paramBitArray);
    Object localObject2 = new StringBuilder(20);
    decodeMiddle(paramBitArray, arrayOfInt[1], localObject1[0], (StringBuilder)localObject2);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramMap != null) {
      paramBitArray = (int[])paramMap.get(DecodeHintType.ALLOWED_LENGTHS);
    } else {
      paramBitArray = null;
    }
    paramMap = paramBitArray;
    if (paramBitArray == null) {
      paramMap = DEFAULT_ALLOWED_LENGTHS;
    }
    int n = ((String)localObject2).length();
    int i1 = paramMap.length;
    int i = 0;
    for (int j = 0; i < i1; j = k)
    {
      int m = paramMap[i];
      if (n == m)
      {
        i = 1;
        break label152;
      }
      k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
    }
    i = 0;
    label152:
    int k = i;
    if (i == 0)
    {
      k = i;
      if (n > j) {
        k = 1;
      }
    }
    if (k != 0)
    {
      float f1 = arrayOfInt[1];
      float f2 = paramInt;
      paramBitArray = new ResultPoint(f1, f2);
      paramMap = new ResultPoint(localObject1[0], f2);
      localObject1 = BarcodeFormat.ITF;
      return new Result((String)localObject2, null, new ResultPoint[] { paramBitArray, paramMap }, (BarcodeFormat)localObject1);
    }
    throw FormatException.getFormatInstance();
  }
  
  int[] decodeStart(BitArray paramBitArray)
    throws NotFoundException
  {
    int[] arrayOfInt = findGuardPattern(paramBitArray, skipWhiteSpace(paramBitArray), START_PATTERN);
    this.narrowLineWidth = ((arrayOfInt[1] - arrayOfInt[0]) / 4);
    validateQuietZone(paramBitArray, arrayOfInt[0]);
    return arrayOfInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\ITFReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */