package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

public final class ByQuadrantReader
  implements Reader
{
  private final Reader delegate;
  
  public ByQuadrantReader(Reader paramReader)
  {
    this.delegate = paramReader;
  }
  
  private static void makeAbsolute(ResultPoint[] paramArrayOfResultPoint, int paramInt1, int paramInt2)
  {
    if (paramArrayOfResultPoint != null)
    {
      int i = 0;
      while (i < paramArrayOfResultPoint.length)
      {
        ResultPoint localResultPoint = paramArrayOfResultPoint[i];
        paramArrayOfResultPoint[i] = new ResultPoint(localResultPoint.getX() + paramInt1, localResultPoint.getY() + paramInt2);
        i += 1;
      }
    }
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException, ChecksumException, FormatException
  {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, ChecksumException, FormatException
  {
    int i = paramBinaryBitmap.getWidth();
    int j = paramBinaryBitmap.getHeight();
    i /= 2;
    j /= 2;
    try
    {
      localResult = this.delegate.decode(paramBinaryBitmap.crop(0, 0, i, j), paramMap);
      return localResult;
    }
    catch (NotFoundException localNotFoundException1)
    {
      Result localResult;
      label79:
      label115:
      label151:
      int k;
      int m;
      for (;;) {}
    }
    try
    {
      localResult = this.delegate.decode(paramBinaryBitmap.crop(i, 0, i, j), paramMap);
      makeAbsolute(localResult.getResultPoints(), i, 0);
      return localResult;
    }
    catch (NotFoundException localNotFoundException2)
    {
      break label79;
    }
    try
    {
      localResult = this.delegate.decode(paramBinaryBitmap.crop(0, j, i, j), paramMap);
      makeAbsolute(localResult.getResultPoints(), 0, j);
      return localResult;
    }
    catch (NotFoundException localNotFoundException3)
    {
      break label115;
    }
    try
    {
      localResult = this.delegate.decode(paramBinaryBitmap.crop(i, j, i, j), paramMap);
      makeAbsolute(localResult.getResultPoints(), i, j);
      return localResult;
    }
    catch (NotFoundException localNotFoundException4)
    {
      break label151;
    }
    k = i / 2;
    m = j / 2;
    paramBinaryBitmap = paramBinaryBitmap.crop(k, m, i, j);
    paramBinaryBitmap = this.delegate.decode(paramBinaryBitmap, paramMap);
    makeAbsolute(paramBinaryBitmap.getResultPoints(), k, m);
    return paramBinaryBitmap;
  }
  
  public void reset()
  {
    this.delegate.reset();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\multi\ByQuadrantReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */