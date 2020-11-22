package com.google.zxing.common;

import com.google.zxing.ResultPoint;

public class DetectorResult
{
  private final BitMatrix bits;
  private final ResultPoint[] points;
  
  public DetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint)
  {
    this.bits = paramBitMatrix;
    this.points = paramArrayOfResultPoint;
  }
  
  public final BitMatrix getBits()
  {
    return this.bits;
  }
  
  public final ResultPoint[] getPoints()
  {
    return this.points;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\DetectorResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */