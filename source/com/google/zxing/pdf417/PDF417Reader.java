package com.google.zxing.pdf417;

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
import com.google.zxing.common.DecoderResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class PDF417Reader
  implements Reader, MultipleBarcodeReader
{
  private static Result[] decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean)
    throws NotFoundException, FormatException, ChecksumException
  {
    ArrayList localArrayList = new ArrayList();
    paramBinaryBitmap = Detector.detect(paramBinaryBitmap, paramMap, paramBoolean);
    paramMap = paramBinaryBitmap.getPoints().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (ResultPoint[])paramMap.next();
      Object localObject1 = PDF417ScanningDecoder.decode(paramBinaryBitmap.getBits(), localObject2[4], localObject2[5], localObject2[6], localObject2[7], getMinCodewordWidth((ResultPoint[])localObject2), getMaxCodewordWidth((ResultPoint[])localObject2));
      localObject2 = new Result(((DecoderResult)localObject1).getText(), ((DecoderResult)localObject1).getRawBytes(), (ResultPoint[])localObject2, BarcodeFormat.PDF_417);
      ((Result)localObject2).putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, ((DecoderResult)localObject1).getECLevel());
      localObject1 = (PDF417ResultMetadata)((DecoderResult)localObject1).getOther();
      if (localObject1 != null) {
        ((Result)localObject2).putMetadata(ResultMetadataType.PDF417_EXTRA_METADATA, localObject1);
      }
      localArrayList.add(localObject2);
    }
    return (Result[])localArrayList.toArray(new Result[localArrayList.size()]);
  }
  
  private static int getMaxCodewordWidth(ResultPoint[] paramArrayOfResultPoint)
  {
    return Math.max(Math.max(getMaxWidth(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), getMaxWidth(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) * 17 / 18), Math.max(getMaxWidth(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), getMaxWidth(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) * 17 / 18));
  }
  
  private static int getMaxWidth(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    if ((paramResultPoint1 != null) && (paramResultPoint2 != null)) {
      return (int)Math.abs(paramResultPoint1.getX() - paramResultPoint2.getX());
    }
    return 0;
  }
  
  private static int getMinCodewordWidth(ResultPoint[] paramArrayOfResultPoint)
  {
    return Math.min(Math.min(getMinWidth(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), getMinWidth(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) * 17 / 18), Math.min(getMinWidth(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), getMinWidth(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) * 17 / 18));
  }
  
  private static int getMinWidth(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    if ((paramResultPoint1 != null) && (paramResultPoint2 != null)) {
      return (int)Math.abs(paramResultPoint1.getX() - paramResultPoint2.getX());
    }
    return Integer.MAX_VALUE;
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException, FormatException, ChecksumException
  {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException, ChecksumException
  {
    paramBinaryBitmap = decode(paramBinaryBitmap, paramMap, false);
    if ((paramBinaryBitmap != null) && (paramBinaryBitmap.length != 0) && (paramBinaryBitmap[0] != null)) {
      return paramBinaryBitmap[0];
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException
  {
    return decodeMultiple(paramBinaryBitmap, null);
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException
  {
    try
    {
      paramBinaryBitmap = decode(paramBinaryBitmap, paramMap, true);
      return paramBinaryBitmap;
    }
    catch (FormatException|ChecksumException paramBinaryBitmap)
    {
      for (;;) {}
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\PDF417Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */