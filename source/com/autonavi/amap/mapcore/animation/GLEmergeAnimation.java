package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

public class GLEmergeAnimation
  extends GLAnimation
{
  public LatLng mStartPoint;
  
  public GLEmergeAnimation(LatLng paramLatLng)
  {
    this.mStartPoint = paramLatLng;
  }
  
  protected void applyTransformation(float paramFloat, GLTransformation paramGLTransformation) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLEmergeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */