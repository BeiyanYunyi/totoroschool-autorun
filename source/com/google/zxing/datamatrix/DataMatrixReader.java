package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

public final class DataMatrixReader
  implements Reader
{
  private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
  private final Decoder decoder = new Decoder();
  
  private static BitMatrix extractPureBits(BitMatrix paramBitMatrix)
    throws NotFoundException
  {
    Object localObject = paramBitMatrix.getTopLeftOnBit();
    int[] arrayOfInt = paramBitMatrix.getBottomRightOnBit();
    if ((localObject != null) && (arrayOfInt != null))
    {
      int k = moduleSize((int[])localObject, paramBitMatrix);
      int m = localObject[1];
      int i = arrayOfInt[1];
      int n = localObject[0];
      int i1 = (arrayOfInt[0] - n + 1) / k;
      int i2 = (i - m + 1) / k;
      if ((i1 > 0) && (i2 > 0))
      {
        int i3 = k / 2;
        localObject = new BitMatrix(i1, i2);
        i = 0;
        while (i < i2)
        {
          int j = 0;
          while (j < i1)
          {
            if (paramBitMatrix.get(j * k + (n + i3), i * k + (m + i3))) {
              ((BitMatrix)localObject).set(j, i);
            }
            j += 1;
          }
          i += 1;
        }
        return (BitMatrix)localObject;
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int moduleSize(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
    throws NotFoundException
  {
    int j = paramBitMatrix.getWidth();
    int i = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    while ((i < j) && (paramBitMatrix.get(i, k))) {
      i += 1;
    }
    if (i != j)
    {
      i -= paramArrayOfInt[0];
      if (i != 0) {
        return i;
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException, ChecksumException, FormatException
  {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, ChecksumException, FormatException
  {
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.PURE_BARCODE)))
    {
      paramBinaryBitmap = extractPureBits(paramBinaryBitmap.getBlackMatrix());
      paramBinaryBitmap = this.decoder.decode(paramBinaryBitmap);
      paramMap = NO_POINTS;
    }
    else
    {
      paramMap = new Detector(paramBinaryBitmap.getBlackMatrix()).detect();
      paramBinaryBitmap = this.decoder.decode(paramMap.getBits());
      paramMap = paramMap.getPoints();
    }
    paramMap = new Result(paramBinaryBitmap.getText(), paramBinaryBitmap.getRawBytes(), paramMap, BarcodeFormat.DATA_MATRIX);
    List localList = paramBinaryBitmap.getByteSegments();
    if (localList != null) {
      paramMap.putMetadata(ResultMetadataType.BYTE_SEGMENTS, localList);
    }
    paramBinaryBitmap = paramBinaryBitmap.getECLevel();
    if (paramBinaryBitmap != null) {
      paramMap.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, paramBinaryBitmap);
    }
    return paramMap;
  }
  
  public void reset() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\DataMatrixReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */