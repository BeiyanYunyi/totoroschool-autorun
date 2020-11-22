package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;

public final class PDF417ScanningDecoder
{
  private static final int CODEWORD_SKEW_SIZE = 2;
  private static final int MAX_EC_CODEWORDS = 512;
  private static final int MAX_ERRORS = 3;
  private static final ErrorCorrection errorCorrection = new ErrorCorrection();
  
  private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn)
    throws NotFoundException, FormatException
  {
    if (paramDetectionResultRowIndicatorColumn == null) {
      return null;
    }
    int[] arrayOfInt = paramDetectionResultRowIndicatorColumn.getRowHeights();
    if (arrayOfInt == null) {
      return null;
    }
    int i1 = getMax(arrayOfInt);
    int m = arrayOfInt.length;
    int n = 0;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      j = arrayOfInt[k];
      i += i1 - j;
      if (j > 0)
      {
        j = i;
        break;
      }
      k += 1;
    }
    Codeword[] arrayOfCodeword = paramDetectionResultRowIndicatorColumn.getCodewords();
    i = 0;
    k = j;
    while ((k > 0) && (arrayOfCodeword[i] == null))
    {
      k -= 1;
      i += 1;
    }
    m = arrayOfInt.length - 1;
    i = n;
    for (;;)
    {
      j = i;
      if (m < 0) {
        break;
      }
      i += i1 - arrayOfInt[m];
      if (arrayOfInt[m] > 0)
      {
        j = i;
        break;
      }
      m -= 1;
    }
    i = arrayOfCodeword.length - 1;
    while ((j > 0) && (arrayOfCodeword[i] == null))
    {
      j -= 1;
      i -= 1;
    }
    return paramDetectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(k, j, paramDetectionResultRowIndicatorColumn.isLeft());
  }
  
  private static void adjustCodewordCount(DetectionResult paramDetectionResult, BarcodeValue[][] paramArrayOfBarcodeValue)
    throws NotFoundException
  {
    int[] arrayOfInt = paramArrayOfBarcodeValue[0][1].getValue();
    int i = paramDetectionResult.getBarcodeColumnCount() * paramDetectionResult.getBarcodeRowCount() - getNumberOfECCodeWords(paramDetectionResult.getBarcodeECLevel());
    if (arrayOfInt.length == 0)
    {
      if ((i >= 1) && (i <= 928))
      {
        paramArrayOfBarcodeValue[0][1].setValue(i);
        return;
      }
      throw NotFoundException.getNotFoundInstance();
    }
    if (arrayOfInt[0] != i) {
      paramArrayOfBarcodeValue[0][1].setValue(i);
    }
  }
  
  private static int adjustCodewordStartColumn(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      i = -1;
    } else {
      i = 1;
    }
    int j = i;
    int i = 0;
    int k = paramInt3;
    while (i < 2)
    {
      while (((paramBoolean) && (k >= paramInt1)) || ((!paramBoolean) && (k < paramInt2) && (paramBoolean == paramBitMatrix.get(k, paramInt4))))
      {
        if (Math.abs(paramInt3 - k) > 2) {
          return paramInt3;
        }
        k += j;
      }
      j = -j;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      i += 1;
    }
    return k;
  }
  
  private static boolean checkCodewordSkew(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 - 2 <= paramInt1) && (paramInt1 <= paramInt3 + 2);
  }
  
  private static int correctErrors(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    throws ChecksumException
  {
    if (((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= paramInt / 2 + 3)) && (paramInt >= 0) && (paramInt <= 512)) {
      return errorCorrection.decode(paramArrayOfInt1, paramInt, paramArrayOfInt2);
    }
    throw ChecksumException.getChecksumInstance();
  }
  
  private static BarcodeValue[][] createBarcodeMatrix(DetectionResult paramDetectionResult)
    throws FormatException
  {
    BarcodeValue[][] arrayOfBarcodeValue = (BarcodeValue[][])Array.newInstance(BarcodeValue.class, new int[] { paramDetectionResult.getBarcodeRowCount(), paramDetectionResult.getBarcodeColumnCount() + 2 });
    int i = 0;
    while (i < arrayOfBarcodeValue.length)
    {
      j = 0;
      while (j < arrayOfBarcodeValue[i].length)
      {
        arrayOfBarcodeValue[i][j] = new BarcodeValue();
        j += 1;
      }
      i += 1;
    }
    paramDetectionResult = paramDetectionResult.getDetectionResultColumns();
    int m = paramDetectionResult.length;
    i = 0;
    int j = 0;
    while (i < m)
    {
      Codeword[] arrayOfCodeword = paramDetectionResult[i];
      if (arrayOfCodeword != null)
      {
        arrayOfCodeword = arrayOfCodeword.getCodewords();
        int n = arrayOfCodeword.length;
        int k = 0;
        while (k < n)
        {
          Codeword localCodeword = arrayOfCodeword[k];
          if (localCodeword != null)
          {
            int i1 = localCodeword.getRowNumber();
            if (i1 >= 0) {
              if (i1 < arrayOfBarcodeValue.length) {
                arrayOfBarcodeValue[i1][j].setValue(localCodeword.getValue());
              } else {
                throw FormatException.getFormatInstance();
              }
            }
          }
          k += 1;
        }
      }
      j += 1;
      i += 1;
    }
    return arrayOfBarcodeValue;
  }
  
  private static DecoderResult createDecoderResult(DetectionResult paramDetectionResult)
    throws FormatException, ChecksumException, NotFoundException
  {
    Object localObject = createBarcodeMatrix(paramDetectionResult);
    adjustCodewordCount(paramDetectionResult, (BarcodeValue[][])localObject);
    ArrayList localArrayList1 = new ArrayList();
    int[] arrayOfInt1 = new int[paramDetectionResult.getBarcodeRowCount() * paramDetectionResult.getBarcodeColumnCount()];
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int k = 0;
    int i = 0;
    while (i < paramDetectionResult.getBarcodeRowCount())
    {
      int m;
      for (int j = 0; j < paramDetectionResult.getBarcodeColumnCount(); j = m)
      {
        int[] arrayOfInt2 = localObject[i];
        m = j + 1;
        arrayOfInt2 = arrayOfInt2[m].getValue();
        j = paramDetectionResult.getBarcodeColumnCount() * i + j;
        if (arrayOfInt2.length == 0)
        {
          localArrayList1.add(Integer.valueOf(j));
        }
        else if (arrayOfInt2.length == 1)
        {
          arrayOfInt1[j] = arrayOfInt2[0];
        }
        else
        {
          localArrayList3.add(Integer.valueOf(j));
          localArrayList2.add(arrayOfInt2);
        }
      }
      i += 1;
    }
    localObject = new int[localArrayList2.size()][];
    i = k;
    while (i < localObject.length)
    {
      localObject[i] = ((int[])localArrayList2.get(i));
      i += 1;
    }
    return createDecoderResultFromAmbiguousValues(paramDetectionResult.getBarcodeECLevel(), arrayOfInt1, PDF417Common.toIntArray(localArrayList1), PDF417Common.toIntArray(localArrayList3), (int[][])localObject);
  }
  
  private static DecoderResult createDecoderResultFromAmbiguousValues(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[][] paramArrayOfInt)
    throws FormatException, ChecksumException
  {
    int[] arrayOfInt = new int[paramArrayOfInt3.length];
    int i = 100;
    while (i > 0)
    {
      int j = 0;
      while (j < arrayOfInt.length)
      {
        paramArrayOfInt1[paramArrayOfInt3[j]] = paramArrayOfInt[j][arrayOfInt[j]];
        j += 1;
      }
      try
      {
        DecoderResult localDecoderResult = decodeCodewords(paramArrayOfInt1, paramInt, paramArrayOfInt2);
        return localDecoderResult;
      }
      catch (ChecksumException localChecksumException)
      {
        for (;;) {}
      }
      if (arrayOfInt.length != 0)
      {
        j = 0;
        while (j < arrayOfInt.length) {
          if (arrayOfInt[j] < paramArrayOfInt[j].length - 1)
          {
            arrayOfInt[j] += 1;
          }
          else
          {
            arrayOfInt[j] = 0;
            if (j != arrayOfInt.length - 1) {
              j += 1;
            } else {
              throw ChecksumException.getChecksumInstance();
            }
          }
        }
        i -= 1;
      }
      else
      {
        throw ChecksumException.getChecksumInstance();
      }
    }
    throw ChecksumException.getChecksumInstance();
  }
  
  public static DecoderResult decode(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
    throws NotFoundException, FormatException, ChecksumException
  {
    BoundingBox localBoundingBox = new BoundingBox(paramBitMatrix, paramResultPoint1, paramResultPoint2, paramResultPoint3, paramResultPoint4);
    paramResultPoint2 = null;
    Object localObject = paramResultPoint2;
    paramResultPoint4 = (ResultPoint)localObject;
    int i = 0;
    while (i < 2)
    {
      if (paramResultPoint1 != null) {
        paramResultPoint2 = getRowIndicatorColumn(paramBitMatrix, localBoundingBox, paramResultPoint1, true, paramInt1, paramInt2);
      }
      if (paramResultPoint3 != null) {
        paramResultPoint4 = getRowIndicatorColumn(paramBitMatrix, localBoundingBox, paramResultPoint3, false, paramInt1, paramInt2);
      }
      localObject = merge(paramResultPoint2, paramResultPoint4);
      if (localObject != null)
      {
        if ((i == 0) && (((DetectionResult)localObject).getBoundingBox() != null) && ((((DetectionResult)localObject).getBoundingBox().getMinY() < localBoundingBox.getMinY()) || (((DetectionResult)localObject).getBoundingBox().getMaxY() > localBoundingBox.getMaxY())))
        {
          localBoundingBox = ((DetectionResult)localObject).getBoundingBox();
          i += 1;
        }
        else
        {
          ((DetectionResult)localObject).setBoundingBox(localBoundingBox);
        }
      }
      else {
        throw NotFoundException.getNotFoundInstance();
      }
    }
    int i1 = ((DetectionResult)localObject).getBarcodeColumnCount() + 1;
    ((DetectionResult)localObject).setDetectionResultColumn(0, paramResultPoint2);
    ((DetectionResult)localObject).setDetectionResultColumn(i1, paramResultPoint4);
    boolean bool1;
    if (paramResultPoint2 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int j = 1;
    i = paramInt2;
    paramInt2 = j;
    while (paramInt2 <= i1)
    {
      int m;
      if (bool1) {
        m = paramInt2;
      } else {
        m = i1 - paramInt2;
      }
      if (((DetectionResult)localObject).getDetectionResultColumn(m) == null)
      {
        if ((m != 0) && (m != i1))
        {
          paramResultPoint1 = new DetectionResultColumn(localBoundingBox);
        }
        else
        {
          boolean bool2;
          if (m == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          paramResultPoint1 = new DetectionResultRowIndicatorColumn(localBoundingBox, bool2);
        }
        ((DetectionResult)localObject).setDetectionResultColumn(m, paramResultPoint1);
        int n = localBoundingBox.getMinY();
        j = paramInt1;
        int k = -1;
        paramInt1 = i;
        i = k;
        while (n <= localBoundingBox.getMaxY())
        {
          k = getStartColumn((DetectionResult)localObject, m, n, bool1);
          if ((k >= 0) && (k <= localBoundingBox.getMaxX())) {
            break label385;
          }
          if (i != -1)
          {
            k = i;
            label385:
            paramResultPoint2 = detectCodeword(paramBitMatrix, localBoundingBox.getMinX(), localBoundingBox.getMaxX(), bool1, k, n, j, paramInt1);
            if (paramResultPoint2 != null)
            {
              paramResultPoint1.setCodeword(n, paramResultPoint2);
              j = Math.min(j, paramResultPoint2.getWidth());
              paramInt1 = Math.max(paramInt1, paramResultPoint2.getWidth());
              i = k;
            }
          }
          n += 1;
        }
        i = paramInt1;
        paramInt1 = j;
      }
      paramInt2 += 1;
    }
    return createDecoderResult((DetectionResult)localObject);
  }
  
  private static DecoderResult decodeCodewords(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
    throws FormatException, ChecksumException
  {
    if (paramArrayOfInt1.length != 0)
    {
      int i = 1 << paramInt + 1;
      int j = correctErrors(paramArrayOfInt1, paramArrayOfInt2, i);
      verifyCodewordCount(paramArrayOfInt1, i);
      paramArrayOfInt1 = DecodedBitStreamParser.decode(paramArrayOfInt1, String.valueOf(paramInt));
      paramArrayOfInt1.setErrorsCorrected(Integer.valueOf(j));
      paramArrayOfInt1.setErasures(Integer.valueOf(paramArrayOfInt2.length));
      return paramArrayOfInt1;
    }
    throw FormatException.getFormatInstance();
  }
  
  private static Codeword detectCodeword(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt3 = adjustCodewordStartColumn(paramBitMatrix, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    paramBitMatrix = getModuleBitCount(paramBitMatrix, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    if (paramBitMatrix == null) {
      return null;
    }
    paramInt4 = PDF417Common.getBitCountSum(paramBitMatrix);
    if (paramBoolean)
    {
      paramInt2 = paramInt3 + paramInt4;
      paramInt1 = paramInt3;
      paramInt3 = paramInt2;
    }
    else
    {
      paramInt1 = 0;
      while (paramInt1 < paramBitMatrix.length / 2)
      {
        paramInt2 = paramBitMatrix[paramInt1];
        paramBitMatrix[paramInt1] = paramBitMatrix[(paramBitMatrix.length - 1 - paramInt1)];
        paramBitMatrix[(paramBitMatrix.length - 1 - paramInt1)] = paramInt2;
        paramInt1 += 1;
      }
      paramInt1 = paramInt3 - paramInt4;
    }
    if (!checkCodewordSkew(paramInt4, paramInt5, paramInt6)) {
      return null;
    }
    paramInt2 = PDF417CodewordDecoder.getDecodedValue(paramBitMatrix);
    paramInt4 = PDF417Common.getCodeword(paramInt2);
    if (paramInt4 == -1) {
      return null;
    }
    return new Codeword(paramInt1, paramInt3, getCodewordBucketNumber(paramInt2), paramInt4);
  }
  
  private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2)
  {
    if (paramDetectionResultRowIndicatorColumn1 != null)
    {
      paramDetectionResultRowIndicatorColumn1 = paramDetectionResultRowIndicatorColumn1.getBarcodeMetadata();
      if (paramDetectionResultRowIndicatorColumn1 != null)
      {
        if (paramDetectionResultRowIndicatorColumn2 != null)
        {
          paramDetectionResultRowIndicatorColumn2 = paramDetectionResultRowIndicatorColumn2.getBarcodeMetadata();
          if (paramDetectionResultRowIndicatorColumn2 == null) {
            return paramDetectionResultRowIndicatorColumn1;
          }
          if ((paramDetectionResultRowIndicatorColumn1.getColumnCount() != paramDetectionResultRowIndicatorColumn2.getColumnCount()) && (paramDetectionResultRowIndicatorColumn1.getErrorCorrectionLevel() != paramDetectionResultRowIndicatorColumn2.getErrorCorrectionLevel()) && (paramDetectionResultRowIndicatorColumn1.getRowCount() != paramDetectionResultRowIndicatorColumn2.getRowCount())) {
            return null;
          }
          return paramDetectionResultRowIndicatorColumn1;
        }
        return paramDetectionResultRowIndicatorColumn1;
      }
    }
    if (paramDetectionResultRowIndicatorColumn2 == null) {
      return null;
    }
    return paramDetectionResultRowIndicatorColumn2.getBarcodeMetadata();
  }
  
  private static int[] getBitCountForCodeword(int paramInt)
  {
    int[] arrayOfInt = new int[8];
    int k = arrayOfInt.length - 1;
    int j;
    for (int i = 0;; i = j)
    {
      int n = paramInt & 0x1;
      int m = k;
      j = i;
      if (n != i)
      {
        m = k - 1;
        if (m < 0) {
          return arrayOfInt;
        }
        j = n;
      }
      arrayOfInt[m] += 1;
      paramInt >>= 1;
      k = m;
    }
  }
  
  private static int getCodewordBucketNumber(int paramInt)
  {
    return getCodewordBucketNumber(getBitCountForCodeword(paramInt));
  }
  
  private static int getCodewordBucketNumber(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt[0] - paramArrayOfInt[2] + paramArrayOfInt[4] - paramArrayOfInt[6] + 9) % 9;
  }
  
  private static int getMax(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    int j = -1;
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, paramArrayOfInt[i]);
      i += 1;
    }
    return j;
  }
  
  private static int[] getModuleBitCount(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = new int[8];
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = -1;
    }
    boolean bool = paramBoolean;
    int j = 0;
    while (((paramBoolean) && (paramInt3 < paramInt2)) || ((!paramBoolean) && (paramInt3 >= paramInt1) && (j < arrayOfInt.length))) {
      if (paramBitMatrix.get(paramInt3, paramInt4) == bool)
      {
        arrayOfInt[j] += 1;
        paramInt3 += i;
      }
      else
      {
        j += 1;
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    if (j != arrayOfInt.length)
    {
      if (((paramBoolean) && (paramInt3 == paramInt2)) || ((!paramBoolean) && (paramInt3 == paramInt1) && (j == arrayOfInt.length - 1))) {
        return arrayOfInt;
      }
      return null;
    }
    return arrayOfInt;
  }
  
  private static int getNumberOfECCodeWords(int paramInt)
  {
    return 2 << paramInt;
  }
  
  private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix paramBitMatrix, BoundingBox paramBoundingBox, ResultPoint paramResultPoint, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DetectionResultRowIndicatorColumn localDetectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(paramBoundingBox, paramBoolean);
    int j = 0;
    while (j < 2)
    {
      int k;
      if (j == 0) {
        k = 1;
      } else {
        k = -1;
      }
      int i = (int)paramResultPoint.getX();
      int m = (int)paramResultPoint.getY();
      while ((m <= paramBoundingBox.getMaxY()) && (m >= paramBoundingBox.getMinY()))
      {
        Codeword localCodeword = detectCodeword(paramBitMatrix, 0, paramBitMatrix.getWidth(), paramBoolean, i, m, paramInt1, paramInt2);
        if (localCodeword != null)
        {
          localDetectionResultRowIndicatorColumn.setCodeword(m, localCodeword);
          if (paramBoolean) {
            i = localCodeword.getStartX();
          } else {
            i = localCodeword.getEndX();
          }
        }
        m += k;
      }
      j += 1;
    }
    return localDetectionResultRowIndicatorColumn;
  }
  
  private static int getStartColumn(DetectionResult paramDetectionResult, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = -1;
    }
    Object localObject1 = null;
    int j = paramInt1 - i;
    if (isValidBarcodeColumn(paramDetectionResult, j)) {
      localObject1 = paramDetectionResult.getDetectionResultColumn(j).getCodeword(paramInt2);
    }
    if (localObject1 != null)
    {
      if (paramBoolean) {
        return ((Codeword)localObject1).getEndX();
      }
      return ((Codeword)localObject1).getStartX();
    }
    localObject1 = paramDetectionResult.getDetectionResultColumn(paramInt1).getCodewordNearby(paramInt2);
    if (localObject1 != null)
    {
      if (paramBoolean) {
        return ((Codeword)localObject1).getStartX();
      }
      return ((Codeword)localObject1).getEndX();
    }
    if (isValidBarcodeColumn(paramDetectionResult, j)) {
      localObject1 = paramDetectionResult.getDetectionResultColumn(j).getCodewordNearby(paramInt2);
    }
    if (localObject1 != null)
    {
      if (paramBoolean) {
        return ((Codeword)localObject1).getEndX();
      }
      return ((Codeword)localObject1).getStartX();
    }
    j = 0;
    paramInt2 = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      j = paramInt2 - i;
      if (!isValidBarcodeColumn(paramDetectionResult, j)) {
        break;
      }
      localObject1 = paramDetectionResult.getDetectionResultColumn(j).getCodewords();
      int k = localObject1.length;
      paramInt2 = 0;
      while (paramInt2 < k)
      {
        Object localObject2 = localObject1[paramInt2];
        if (localObject2 != null)
        {
          if (paramBoolean) {
            paramInt2 = ((Codeword)localObject2).getEndX();
          } else {
            paramInt2 = ((Codeword)localObject2).getStartX();
          }
          return paramInt2 + i * paramInt1 * (((Codeword)localObject2).getEndX() - ((Codeword)localObject2).getStartX());
        }
        paramInt2 += 1;
      }
      paramInt1 += 1;
      paramInt2 = j;
    }
    if (paramBoolean) {
      return paramDetectionResult.getBoundingBox().getMinX();
    }
    return paramDetectionResult.getBoundingBox().getMaxX();
  }
  
  private static boolean isValidBarcodeColumn(DetectionResult paramDetectionResult, int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= paramDetectionResult.getBarcodeColumnCount() + 1);
  }
  
  private static DetectionResult merge(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2)
    throws NotFoundException, FormatException
  {
    if ((paramDetectionResultRowIndicatorColumn1 == null) && (paramDetectionResultRowIndicatorColumn2 == null)) {
      return null;
    }
    BarcodeMetadata localBarcodeMetadata = getBarcodeMetadata(paramDetectionResultRowIndicatorColumn1, paramDetectionResultRowIndicatorColumn2);
    if (localBarcodeMetadata == null) {
      return null;
    }
    return new DetectionResult(localBarcodeMetadata, BoundingBox.merge(adjustBoundingBox(paramDetectionResultRowIndicatorColumn1), adjustBoundingBox(paramDetectionResultRowIndicatorColumn2)));
  }
  
  public static String toString(BarcodeValue[][] paramArrayOfBarcodeValue)
  {
    Formatter localFormatter = new Formatter();
    int i = 0;
    while (i < paramArrayOfBarcodeValue.length)
    {
      localFormatter.format("Row %2d: ", new Object[] { Integer.valueOf(i) });
      int j = 0;
      while (j < paramArrayOfBarcodeValue[i].length)
      {
        BarcodeValue localBarcodeValue = paramArrayOfBarcodeValue[i][j];
        if (localBarcodeValue.getValue().length == 0) {
          localFormatter.format("        ", (Object[])null);
        } else {
          localFormatter.format("%4d(%2d)", new Object[] { Integer.valueOf(localBarcodeValue.getValue()[0]), localBarcodeValue.getConfidence(localBarcodeValue.getValue()[0]) });
        }
        j += 1;
      }
      localFormatter.format("%n", new Object[0]);
      i += 1;
    }
    paramArrayOfBarcodeValue = localFormatter.toString();
    localFormatter.close();
    return paramArrayOfBarcodeValue;
  }
  
  private static void verifyCodewordCount(int[] paramArrayOfInt, int paramInt)
    throws FormatException
  {
    if (paramArrayOfInt.length >= 4)
    {
      int i = paramArrayOfInt[0];
      if (i <= paramArrayOfInt.length)
      {
        if (i == 0)
        {
          if (paramInt < paramArrayOfInt.length)
          {
            paramArrayOfInt[0] = (paramArrayOfInt.length - paramInt);
            return;
          }
          throw FormatException.getFormatInstance();
        }
        return;
      }
      throw FormatException.getFormatInstance();
    }
    throw FormatException.getFormatInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\decoder\PDF417ScanningDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */