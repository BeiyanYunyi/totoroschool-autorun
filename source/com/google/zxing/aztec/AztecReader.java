package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.Map;

public final class AztecReader
  implements Reader
{
  public Result decode(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException, FormatException
  {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException
  {
    Detector localDetector = new Detector(paramBinaryBitmap.getBlackMatrix());
    int i = 0;
    Object localObject3 = null;
    FormatException localFormatException3;
    try
    {
      Object localObject1 = localDetector.detect(false);
      paramBinaryBitmap = ((AztecDetectorResult)localObject1).getPoints();
      try
      {
        localObject1 = new Decoder().decode((AztecDetectorResult)localObject1);
        localFormatException3 = null;
        localObject3 = localObject1;
        localObject1 = localFormatException3;
      }
      catch (FormatException localFormatException1) {}catch (NotFoundException localNotFoundException1) {}
      Object localObject2;
      localFormatException3 = null;
    }
    catch (FormatException localFormatException2)
    {
      paramBinaryBitmap = null;
      localFormatException3 = localFormatException2;
      localObject2 = null;
    }
    catch (NotFoundException localNotFoundException2)
    {
      paramBinaryBitmap = null;
    }
    Object localObject4 = localObject3;
    if (localObject3 == null) {
      try
      {
        localObject3 = localDetector.detect(true);
        paramBinaryBitmap = ((AztecDetectorResult)localObject3).getPoints();
        localObject4 = new Decoder().decode((AztecDetectorResult)localObject3);
      }
      catch (NotFoundException|FormatException paramBinaryBitmap)
      {
        if (localNotFoundException2 == null)
        {
          if (localFormatException3 != null) {
            throw localFormatException3;
          }
          throw paramBinaryBitmap;
        }
        throw localNotFoundException2;
      }
    }
    if (paramMap != null)
    {
      paramMap = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
      if (paramMap != null)
      {
        int j = paramBinaryBitmap.length;
        while (i < j)
        {
          paramMap.foundPossibleResultPoint(paramBinaryBitmap[i]);
          i += 1;
        }
      }
    }
    paramBinaryBitmap = new Result(((DecoderResult)localObject4).getText(), ((DecoderResult)localObject4).getRawBytes(), paramBinaryBitmap, BarcodeFormat.AZTEC);
    paramMap = ((DecoderResult)localObject4).getByteSegments();
    if (paramMap != null) {
      paramBinaryBitmap.putMetadata(ResultMetadataType.BYTE_SEGMENTS, paramMap);
    }
    paramMap = ((DecoderResult)localObject4).getECLevel();
    if (paramMap != null) {
      paramBinaryBitmap.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, paramMap);
    }
    return paramBinaryBitmap;
  }
  
  public void reset() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\aztec\AztecReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */