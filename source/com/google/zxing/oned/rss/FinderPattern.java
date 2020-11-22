package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern
{
  private final ResultPoint[] resultPoints;
  private final int[] startEnd;
  private final int value;
  
  public FinderPattern(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    this.value = paramInt1;
    this.startEnd = paramArrayOfInt;
    float f1 = paramInt2;
    float f2 = paramInt4;
    this.resultPoints = new ResultPoint[] { new ResultPoint(f1, f2), new ResultPoint(paramInt3, f2) };
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof FinderPattern;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramObject = (FinderPattern)paramObject;
    if (this.value == ((FinderPattern)paramObject).value) {
      bool1 = true;
    }
    return bool1;
  }
  
  public ResultPoint[] getResultPoints()
  {
    return this.resultPoints;
  }
  
  public int[] getStartEnd()
  {
    return this.startEnd;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return this.value;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\FinderPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */