package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

final class MatrixUtil
{
  private static final int[][] POSITION_ADJUSTMENT_PATTERN;
  private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
  private static final int[][] POSITION_DETECTION_PATTERN = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] TYPE_INFO_COORDINATES;
  private static final int TYPE_INFO_MASK_PATTERN = 21522;
  private static final int TYPE_INFO_POLY = 1335;
  private static final int VERSION_INFO_POLY = 7973;
  
  static
  {
    int[] arrayOfInt1 = { 1, 1, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 0, 1, 0, 1 };
    POSITION_ADJUSTMENT_PATTERN = new int[][] { arrayOfInt1, { 1, 0, 0, 0, 1 }, arrayOfInt2, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    int[] arrayOfInt3 = { 6, 26, -1, -1, -1, -1, -1 };
    int[] arrayOfInt4 = { 6, 34, -1, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt13 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 58, 86, 114, -1, -1 };
    int[] arrayOfInt15 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt16 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt17 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt18 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt19 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt20 = { 6, 32, 58, 84, 110, 136, 162 };
    int[] arrayOfInt21 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt22 = { 6, 30, 58, 86, 114, 142, 170 };
    POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][] { arrayOfInt1, arrayOfInt2, { 6, 22, -1, -1, -1, -1, -1 }, arrayOfInt3, { 6, 30, -1, -1, -1, -1, -1 }, arrayOfInt4, { 6, 22, 38, -1, -1, -1, -1 }, arrayOfInt5, arrayOfInt6, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, arrayOfInt7, { 6, 26, 46, 66, -1, -1, -1 }, arrayOfInt8, arrayOfInt9, arrayOfInt10, { 6, 30, 56, 82, -1, -1, -1 }, { 6, 30, 58, 86, -1, -1, -1 }, arrayOfInt11, arrayOfInt12, arrayOfInt13, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, arrayOfInt14, arrayOfInt15, arrayOfInt16, arrayOfInt17, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, arrayOfInt18, arrayOfInt19, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, arrayOfInt20, arrayOfInt21, arrayOfInt22 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 2 };
    arrayOfInt3 = new int[] { 8, 4 };
    arrayOfInt4 = new int[] { 8, 8 };
    arrayOfInt5 = new int[] { 7, 8 };
    arrayOfInt6 = new int[] { 5, 8 };
    arrayOfInt7 = new int[] { 4, 8 };
    arrayOfInt8 = new int[] { 3, 8 };
    TYPE_INFO_COORDINATES = new int[][] { arrayOfInt1, { 8, 1 }, arrayOfInt2, { 8, 3 }, arrayOfInt3, { 8, 5 }, { 8, 7 }, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 2, 8 }, { 1, 8 }, { 0, 8 } };
  }
  
  static void buildMatrix(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    clearMatrix(paramByteMatrix);
    embedBasicPatterns(paramVersion, paramByteMatrix);
    embedTypeInfo(paramErrorCorrectionLevel, paramInt, paramByteMatrix);
    maybeEmbedVersionInfo(paramVersion, paramByteMatrix);
    embedDataBits(paramBitArray, paramInt, paramByteMatrix);
  }
  
  static int calculateBCHCode(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      int i = findMSBSet(paramInt2);
      paramInt1 <<= i - 1;
      while (findMSBSet(paramInt1) >= i) {
        paramInt1 ^= paramInt2 << findMSBSet(paramInt1) - i;
      }
      return paramInt1;
    }
    throw new IllegalArgumentException("0 polynomial");
  }
  
  static void clearMatrix(ByteMatrix paramByteMatrix)
  {
    paramByteMatrix.clear((byte)-1);
  }
  
  static void embedBasicPatterns(Version paramVersion, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    embedPositionDetectionPatternsAndSeparators(paramByteMatrix);
    embedDarkDotAtLeftBottomCorner(paramByteMatrix);
    maybeEmbedPositionAdjustmentPatterns(paramVersion, paramByteMatrix);
    embedTimingPatterns(paramByteMatrix);
  }
  
  private static void embedDarkDotAtLeftBottomCorner(ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if (paramByteMatrix.get(8, paramByteMatrix.getHeight() - 8) != 0)
    {
      paramByteMatrix.set(8, paramByteMatrix.getHeight() - 8, 1);
      return;
    }
    throw new WriterException();
  }
  
  static void embedDataBits(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int k = paramByteMatrix.getWidth() - 1;
    int j = paramByteMatrix.getHeight() - 1;
    int i2 = 0;
    int m = -1;
    while (k > 0)
    {
      int n = k;
      int i = i2;
      int i1 = j;
      if (k == 6)
      {
        n = k - 1;
        i1 = j;
        i = i2;
      }
      while ((i1 >= 0) && (i1 < paramByteMatrix.getHeight()))
      {
        j = 0;
        while (j < 2)
        {
          k = n - j;
          if (isEmpty(paramByteMatrix.get(k, i1)))
          {
            boolean bool1;
            if (i < paramBitArray.getSize())
            {
              bool1 = paramBitArray.get(i);
              i += 1;
            }
            else
            {
              bool1 = false;
            }
            boolean bool2 = bool1;
            if (paramInt != -1)
            {
              bool2 = bool1;
              if (MaskUtil.getDataMaskBit(paramInt, k, i1)) {
                if (!bool1) {
                  bool2 = true;
                } else {
                  bool2 = false;
                }
              }
            }
            paramByteMatrix.set(k, i1, bool2);
          }
          j += 1;
        }
        i1 += m;
      }
      m = -m;
      j = i1 + m;
      k = n - 2;
      i2 = i;
    }
    if (i2 == paramBitArray.getSize()) {
      return;
    }
    paramByteMatrix = new StringBuilder();
    paramByteMatrix.append("Not all bits consumed: ");
    paramByteMatrix.append(i2);
    paramByteMatrix.append('/');
    paramByteMatrix.append(paramBitArray.getSize());
    throw new WriterException(paramByteMatrix.toString());
  }
  
  private static void embedHorizontalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = 0;
    while (i < 8)
    {
      int j = paramInt1 + i;
      if (isEmpty(paramByteMatrix.get(j, paramInt2)))
      {
        paramByteMatrix.set(j, paramInt2, 0);
        i += 1;
      }
      else
      {
        throw new WriterException();
      }
    }
  }
  
  private static void embedPositionAdjustmentPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramByteMatrix.set(paramInt1 + j, paramInt2 + i, POSITION_ADJUSTMENT_PATTERN[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void embedPositionDetectionPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramByteMatrix.set(paramInt1 + j, paramInt2 + i, POSITION_DETECTION_PATTERN[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = POSITION_DETECTION_PATTERN[0].length;
    embedPositionDetectionPattern(0, 0, paramByteMatrix);
    embedPositionDetectionPattern(paramByteMatrix.getWidth() - i, 0, paramByteMatrix);
    embedPositionDetectionPattern(0, paramByteMatrix.getWidth() - i, paramByteMatrix);
    embedHorizontalSeparationPattern(0, 7, paramByteMatrix);
    embedHorizontalSeparationPattern(paramByteMatrix.getWidth() - 8, 7, paramByteMatrix);
    embedHorizontalSeparationPattern(0, paramByteMatrix.getWidth() - 8, paramByteMatrix);
    embedVerticalSeparationPattern(7, 0, paramByteMatrix);
    embedVerticalSeparationPattern(paramByteMatrix.getHeight() - 7 - 1, 0, paramByteMatrix);
    embedVerticalSeparationPattern(7, paramByteMatrix.getHeight() - 7, paramByteMatrix);
  }
  
  private static void embedTimingPatterns(ByteMatrix paramByteMatrix)
  {
    int j;
    for (int i = 8; i < paramByteMatrix.getWidth() - 8; i = j)
    {
      j = i + 1;
      int k = j % 2;
      if (isEmpty(paramByteMatrix.get(i, 6))) {
        paramByteMatrix.set(i, 6, k);
      }
      if (isEmpty(paramByteMatrix.get(6, i))) {
        paramByteMatrix.set(6, i, k);
      }
    }
  }
  
  static void embedTypeInfo(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    BitArray localBitArray = new BitArray();
    makeTypeInfoBits(paramErrorCorrectionLevel, paramInt, localBitArray);
    paramInt = 0;
    while (paramInt < localBitArray.getSize())
    {
      boolean bool = localBitArray.get(localBitArray.getSize() - 1 - paramInt);
      paramByteMatrix.set(TYPE_INFO_COORDINATES[paramInt][0], TYPE_INFO_COORDINATES[paramInt][1], bool);
      if (paramInt < 8) {
        paramByteMatrix.set(paramByteMatrix.getWidth() - paramInt - 1, 8, bool);
      } else {
        paramByteMatrix.set(8, paramByteMatrix.getHeight() - 7 + (paramInt - 8), bool);
      }
      paramInt += 1;
    }
  }
  
  private static void embedVerticalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = 0;
    while (i < 7)
    {
      int j = paramInt2 + i;
      if (isEmpty(paramByteMatrix.get(paramInt1, j)))
      {
        paramByteMatrix.set(paramInt1, j, 0);
        i += 1;
      }
      else
      {
        throw new WriterException();
      }
    }
  }
  
  static int findMSBSet(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  private static boolean isEmpty(int paramInt)
  {
    return paramInt == -1;
  }
  
  static void makeTypeInfoBits(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, BitArray paramBitArray)
    throws WriterException
  {
    if (QRCode.isValidMaskPattern(paramInt))
    {
      paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
      paramBitArray.appendBits(paramInt, 5);
      paramBitArray.appendBits(calculateBCHCode(paramInt, 1335), 10);
      paramErrorCorrectionLevel = new BitArray();
      paramErrorCorrectionLevel.appendBits(21522, 15);
      paramBitArray.xor(paramErrorCorrectionLevel);
      if (paramBitArray.getSize() == 15) {
        return;
      }
      paramErrorCorrectionLevel = new StringBuilder();
      paramErrorCorrectionLevel.append("should not happen but we got: ");
      paramErrorCorrectionLevel.append(paramBitArray.getSize());
      throw new WriterException(paramErrorCorrectionLevel.toString());
    }
    throw new WriterException("Invalid mask pattern");
  }
  
  static void makeVersionInfoBits(Version paramVersion, BitArray paramBitArray)
    throws WriterException
  {
    paramBitArray.appendBits(paramVersion.getVersionNumber(), 6);
    paramBitArray.appendBits(calculateBCHCode(paramVersion.getVersionNumber(), 7973), 12);
    if (paramBitArray.getSize() == 18) {
      return;
    }
    paramVersion = new StringBuilder();
    paramVersion.append("should not happen but we got: ");
    paramVersion.append(paramBitArray.getSize());
    throw new WriterException(paramVersion.toString());
  }
  
  private static void maybeEmbedPositionAdjustmentPatterns(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    if (paramVersion.getVersionNumber() < 2) {
      return;
    }
    int i = paramVersion.getVersionNumber() - 1;
    paramVersion = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[i];
    int k = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[i].length;
    i = 0;
    while (i < k)
    {
      int j = 0;
      while (j < k)
      {
        int m = paramVersion[i];
        int n = paramVersion[j];
        if ((n != -1) && (m != -1) && (isEmpty(paramByteMatrix.get(n, m)))) {
          embedPositionAdjustmentPattern(n - 2, m - 2, paramByteMatrix);
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  static void maybeEmbedVersionInfo(Version paramVersion, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if (paramVersion.getVersionNumber() < 7) {
      return;
    }
    BitArray localBitArray = new BitArray();
    makeVersionInfoBits(paramVersion, localBitArray);
    int j = 0;
    int i = 17;
    while (j < 6)
    {
      int k = 0;
      while (k < 3)
      {
        boolean bool = localBitArray.get(i);
        i -= 1;
        paramByteMatrix.set(j, paramByteMatrix.getHeight() - 11 + k, bool);
        paramByteMatrix.set(paramByteMatrix.getHeight() - 11 + k, j, bool);
        k += 1;
      }
      j += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\encoder\MatrixUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */