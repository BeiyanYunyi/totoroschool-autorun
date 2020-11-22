package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.BarcodeMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class PDF417Writer
  implements Writer
{
  static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
  static final int WHITE_SPACE = 30;
  
  private static BitMatrix bitMatrixFromEncoder(PDF417 paramPDF417, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws WriterException
  {
    paramPDF417.generateBarcodeLogic(paramString, paramInt1);
    paramString = paramPDF417.getBarcodeMatrix().getScaledMatrix(1, 4);
    if (paramInt3 > paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i;
    if (paramString[0].length < paramString.length) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt1 ^ i) != 0)
    {
      paramString = rotateArray(paramString);
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    paramInt2 /= paramString[0].length;
    paramInt3 /= paramString.length;
    if (paramInt2 >= paramInt3) {
      paramInt2 = paramInt3;
    }
    if (paramInt2 > 1)
    {
      paramString = paramPDF417.getBarcodeMatrix().getScaledMatrix(paramInt2, paramInt2 * 4);
      paramPDF417 = paramString;
      if (paramInt1 != 0) {
        paramPDF417 = rotateArray(paramString);
      }
      return bitMatrixFrombitArray(paramPDF417, paramInt4);
    }
    return bitMatrixFrombitArray(paramString, paramInt4);
  }
  
  private static BitMatrix bitMatrixFrombitArray(byte[][] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[0].length;
    int j = paramInt * 2;
    BitMatrix localBitMatrix = new BitMatrix(i + j, paramArrayOfByte.length + j);
    localBitMatrix.clear();
    i = localBitMatrix.getHeight() - paramInt - 1;
    j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = 0;
      while (k < paramArrayOfByte[0].length)
      {
        if (paramArrayOfByte[j][k] == 1) {
          localBitMatrix.set(k + paramInt, i);
        }
        k += 1;
      }
      j += 1;
      i -= 1;
    }
    return localBitMatrix;
  }
  
  private static byte[][] rotateArray(byte[][] paramArrayOfByte)
  {
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { paramArrayOfByte[0].length, paramArrayOfByte.length });
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte.length;
      int j = 0;
      while (j < paramArrayOfByte[0].length)
      {
        arrayOfByte[j][(k - i - 1)] = paramArrayOfByte[i][j];
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2)
    throws WriterException
  {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramBarcodeFormat == BarcodeFormat.PDF_417)
    {
      paramBarcodeFormat = new PDF417();
      int i = 30;
      int j = 2;
      if (paramMap != null)
      {
        if (paramMap.containsKey(EncodeHintType.PDF417_COMPACT)) {
          paramBarcodeFormat.setCompact(((Boolean)paramMap.get(EncodeHintType.PDF417_COMPACT)).booleanValue());
        }
        if (paramMap.containsKey(EncodeHintType.PDF417_COMPACTION)) {
          paramBarcodeFormat.setCompaction((Compaction)paramMap.get(EncodeHintType.PDF417_COMPACTION));
        }
        if (paramMap.containsKey(EncodeHintType.PDF417_DIMENSIONS))
        {
          Dimensions localDimensions = (Dimensions)paramMap.get(EncodeHintType.PDF417_DIMENSIONS);
          paramBarcodeFormat.setDimensions(localDimensions.getMaxCols(), localDimensions.getMinCols(), localDimensions.getMaxRows(), localDimensions.getMinRows());
        }
        if (paramMap.containsKey(EncodeHintType.MARGIN)) {
          i = ((Number)paramMap.get(EncodeHintType.MARGIN)).intValue();
        }
        if (paramMap.containsKey(EncodeHintType.ERROR_CORRECTION)) {
          j = ((Number)paramMap.get(EncodeHintType.ERROR_CORRECTION)).intValue();
        }
        if (paramMap.containsKey(EncodeHintType.CHARACTER_SET)) {
          paramBarcodeFormat.setEncoding(Charset.forName((String)paramMap.get(EncodeHintType.CHARACTER_SET)));
        }
      }
      else
      {
        j = 2;
        i = 30;
      }
      return bitMatrixFromEncoder(paramBarcodeFormat, paramString, j, paramInt1, paramInt2, i);
    }
    paramString = new StringBuilder();
    paramString.append("Can only encode PDF_417, but got ");
    paramString.append(paramBarcodeFormat);
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\PDF417Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */