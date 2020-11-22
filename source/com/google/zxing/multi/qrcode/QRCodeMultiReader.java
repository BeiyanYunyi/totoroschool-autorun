package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class QRCodeMultiReader
  extends QRCodeReader
  implements MultipleBarcodeReader
{
  private static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
  private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
  
  private static List<Result> processStructuredAppend(List<Result> paramList)
  {
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((Result)((Iterator)localObject1).next()).getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE))
      {
        i = 1;
        break label49;
      }
    }
    int i = 0;
    label49:
    if (i == 0) {
      return paramList;
    }
    localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject3 = (Result)paramList.next();
      ((List)localObject1).add(localObject3);
      if (((Result)localObject3).getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
        ((List)localObject2).add(localObject3);
      }
    }
    Collections.sort((List)localObject2, new SAComparator(null));
    paramList = new StringBuilder();
    Object localObject3 = ((List)localObject2).iterator();
    int j = 0;
    i = 0;
    int m;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Result)((Iterator)localObject3).next();
      paramList.append(((Result)localObject4).getText());
      m = j + ((Result)localObject4).getRawBytes().length;
      j = m;
      if (((Result)localObject4).getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS))
      {
        localObject4 = ((Iterable)((Result)localObject4).getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)).iterator();
        k = i;
        for (;;)
        {
          j = m;
          i = k;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          k += ((byte[])((Iterator)localObject4).next()).length;
        }
      }
    }
    Object localObject4 = new byte[j];
    localObject3 = new byte[i];
    localObject2 = ((List)localObject2).iterator();
    int k = 0;
    j = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject5 = (Result)((Iterator)localObject2).next();
      System.arraycopy(((Result)localObject5).getRawBytes(), 0, localObject4, k, ((Result)localObject5).getRawBytes().length);
      int n = k + ((Result)localObject5).getRawBytes().length;
      k = n;
      if (((Result)localObject5).getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS))
      {
        localObject5 = ((Iterable)((Result)localObject5).getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)).iterator();
        m = j;
        for (;;)
        {
          k = n;
          j = m;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          byte[] arrayOfByte = (byte[])((Iterator)localObject5).next();
          System.arraycopy(arrayOfByte, 0, localObject3, m, arrayOfByte.length);
          m += arrayOfByte.length;
        }
      }
    }
    paramList = new Result(paramList.toString(), (byte[])localObject4, NO_POINTS, BarcodeFormat.QR_CODE);
    if (i > 0)
    {
      localObject2 = new ArrayList();
      ((Collection)localObject2).add(localObject3);
      paramList.putMetadata(ResultMetadataType.BYTE_SEGMENTS, localObject2);
    }
    ((List)localObject1).add(paramList);
    return (List<Result>)localObject1;
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException
  {
    return decodeMultiple(paramBinaryBitmap, null);
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException
  {
    ArrayList localArrayList = new ArrayList();
    paramBinaryBitmap = new MultiDetector(paramBinaryBitmap.getBlackMatrix()).detectMulti(paramMap);
    int j = paramBinaryBitmap.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramBinaryBitmap[i];
      try
      {
        DecoderResult localDecoderResult = getDecoder().decode(((DetectorResult)localObject1).getBits(), paramMap);
        localObject1 = ((DetectorResult)localObject1).getPoints();
        if ((localDecoderResult.getOther() instanceof QRCodeDecoderMetaData)) {
          ((QRCodeDecoderMetaData)localDecoderResult.getOther()).applyMirroredCorrection((ResultPoint[])localObject1);
        }
        localObject1 = new Result(localDecoderResult.getText(), localDecoderResult.getRawBytes(), (ResultPoint[])localObject1, BarcodeFormat.QR_CODE);
        Object localObject2 = localDecoderResult.getByteSegments();
        if (localObject2 != null) {
          ((Result)localObject1).putMetadata(ResultMetadataType.BYTE_SEGMENTS, localObject2);
        }
        localObject2 = localDecoderResult.getECLevel();
        if (localObject2 != null) {
          ((Result)localObject1).putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, localObject2);
        }
        if (localDecoderResult.hasStructuredAppend())
        {
          ((Result)localObject1).putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(localDecoderResult.getStructuredAppendSequenceNumber()));
          ((Result)localObject1).putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(localDecoderResult.getStructuredAppendParity()));
        }
        localArrayList.add(localObject1);
      }
      catch (ReaderException localReaderException)
      {
        for (;;) {}
      }
      i += 1;
    }
    if (localArrayList.isEmpty()) {
      return EMPTY_RESULT_ARRAY;
    }
    paramBinaryBitmap = processStructuredAppend(localArrayList);
    return (Result[])paramBinaryBitmap.toArray(new Result[paramBinaryBitmap.size()]);
  }
  
  private static final class SAComparator
    implements Serializable, Comparator<Result>
  {
    public int compare(Result paramResult1, Result paramResult2)
    {
      int i = ((Integer)paramResult1.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue();
      int j = ((Integer)paramResult2.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue();
      if (i < j) {
        return -1;
      }
      if (i > j) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\multi\qrcode\QRCodeMultiReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */