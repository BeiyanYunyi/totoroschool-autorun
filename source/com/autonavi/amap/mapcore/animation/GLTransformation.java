package com.autonavi.amap.mapcore.animation;

public class GLTransformation
{
  public double alpha = NaN.0D;
  public double rotate = NaN.0D;
  public double scaleX = NaN.0D;
  public double scaleY = NaN.0D;
  public double x = NaN.0D;
  public double y = NaN.0D;
  
  public void clear()
  {
    this.x = NaN.0D;
    this.y = NaN.0D;
    this.alpha = NaN.0D;
    this.scaleX = NaN.0D;
    this.scaleY = NaN.0D;
    this.rotate = NaN.0D;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */