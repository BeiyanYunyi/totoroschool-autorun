package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

public class GLTranslateAnimation
  extends GLAnimation
{
  public double mCurXDelta = 0.0D;
  public double mCurYDelta = 0.0D;
  public double mFromXDelta = 0.0D;
  public double mFromYDelta = 0.0D;
  public double mToXDelta = 0.0D;
  public double mToYDelta = 0.0D;
  
  public GLTranslateAnimation(LatLng paramLatLng)
  {
    this.mToXDelta = paramLatLng.longitude;
    this.mToYDelta = paramLatLng.latitude;
  }
  
  protected void applyTransformation(float paramFloat, GLTransformation paramGLTransformation)
  {
    this.mCurXDelta = this.mFromXDelta;
    this.mCurYDelta = this.mFromYDelta;
    double d1;
    double d2;
    double d3;
    double d4;
    if (this.mFromXDelta != this.mToXDelta)
    {
      d1 = this.mFromXDelta;
      d2 = this.mToXDelta;
      d3 = this.mFromXDelta;
      d4 = paramFloat;
      Double.isNaN(d4);
      this.mCurXDelta = (d1 + (d2 - d3) * d4);
    }
    if (this.mFromYDelta != this.mToYDelta)
    {
      d1 = this.mFromYDelta;
      d2 = this.mToYDelta;
      d3 = this.mFromYDelta;
      d4 = paramFloat;
      Double.isNaN(d4);
      this.mCurYDelta = (d1 + (d2 - d3) * d4);
    }
    paramGLTransformation.x = this.mCurXDelta;
    paramGLTransformation.y = this.mCurYDelta;
  }
  
  public void setFromPoint(LatLng paramLatLng)
  {
    this.mFromXDelta = paramLatLng.longitude;
    this.mFromYDelta = paramLatLng.latitude;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLTranslateAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */