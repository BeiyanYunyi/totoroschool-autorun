package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader
  implements MultipleBarcodeReader
{
  private static final int MAX_DEPTH = 4;
  private static final int MIN_DIMENSION_TO_RECUR = 100;
  private final Reader delegate;
  
  public GenericMultipleBarcodeReader(Reader paramReader)
  {
    this.delegate = paramReader;
  }
  
  private void doDecodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, List<Result> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 4) {
      return;
    }
    try
    {
      Object localObject = this.delegate.decode(paramBinaryBitmap, paramMap);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((Result)localIterator.next()).getText().equals(((Result)localObject).getText()))
        {
          i = 1;
          break label71;
        }
      }
      int i = 0;
      label71:
      if (i == 0) {
        paramList.add(translateResultPoints((Result)localObject, paramInt1, paramInt2));
      }
      localObject = ((Result)localObject).getResultPoints();
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return;
        }
        int k = paramBinaryBitmap.getWidth();
        int j = paramBinaryBitmap.getHeight();
        float f4 = k;
        float f1 = j;
        int m = localObject.length;
        float f2 = 0.0F;
        float f5 = 0.0F;
        i = 0;
        while (i < m)
        {
          localIterator = localObject[i];
          float f8;
          float f9;
          float f7;
          if (localIterator == null)
          {
            f8 = f4;
            f9 = f1;
            f7 = f5;
          }
          else
          {
            f7 = localIterator.getX();
            float f6 = localIterator.getY();
            float f3 = f4;
            if (f7 < f4) {
              f3 = f7;
            }
            f4 = f1;
            if (f6 < f1) {
              f4 = f6;
            }
            f1 = f2;
            if (f7 > f2) {
              f1 = f7;
            }
            f8 = f3;
            f9 = f4;
            f2 = f1;
            f7 = f5;
            if (f6 > f5)
            {
              f7 = f6;
              f2 = f1;
              f9 = f4;
              f8 = f3;
            }
          }
          i += 1;
          f4 = f8;
          f1 = f9;
          f5 = f7;
        }
        if (f4 > 100.0F) {
          doDecodeMultiple(paramBinaryBitmap.crop(0, 0, (int)f4, j), paramMap, paramList, paramInt1, paramInt2, paramInt3 + 1);
        }
        if (f1 > 100.0F) {
          doDecodeMultiple(paramBinaryBitmap.crop(0, 0, k, (int)f1), paramMap, paramList, paramInt1, paramInt2, paramInt3 + 1);
        }
        if (f2 < k - 100)
        {
          i = (int)f2;
          doDecodeMultiple(paramBinaryBitmap.crop(i, 0, k - i, j), paramMap, paramList, paramInt1 + i, paramInt2, paramInt3 + 1);
        }
        if (f5 < j - 100)
        {
          i = (int)f5;
          doDecodeMultiple(paramBinaryBitmap.crop(0, i, k, j - i), paramMap, paramList, paramInt1, paramInt2 + i, paramInt3 + 1);
        }
        return;
      }
      return;
    }
    catch (ReaderException paramBinaryBitmap) {}
  }
  
  private static Result translateResultPoints(Result paramResult, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramResult.getResultPoints();
    if (localObject1 == null) {
      return paramResult;
    }
    ResultPoint[] arrayOfResultPoint = new ResultPoint[localObject1.length];
    int i = 0;
    while (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        arrayOfResultPoint[i] = new ResultPoint(((ResultPoint)localObject2).getX() + paramInt1, ((ResultPoint)localObject2).getY() + paramInt2);
      }
      i += 1;
    }
    localObject1 = new Result(paramResult.getText(), paramResult.getRawBytes(), arrayOfResultPoint, paramResult.getBarcodeFormat());
    ((Result)localObject1).putAllMetadata(paramResult.getResultMetadata());
    return (Result)localObject1;
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
    doDecodeMultiple(paramBinaryBitmap, paramMap, localArrayList, 0, 0, 0);
    if (!localArrayList.isEmpty()) {
      return (Result[])localArrayList.toArray(new Result[localArrayList.size()]);
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\multi\GenericMultipleBarcodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */