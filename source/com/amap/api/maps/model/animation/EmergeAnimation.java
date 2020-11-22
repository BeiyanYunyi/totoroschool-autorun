package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLEmergeAnimation;

public class EmergeAnimation
  extends Animation
{
  public EmergeAnimation(LatLng paramLatLng)
  {
    this.glAnimation = new GLEmergeAnimation(paramLatLng);
  }
  
  public void setDuration(long paramLong)
  {
    this.glAnimation.setDuration(paramLong);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.glAnimation.setInterpolator(paramInterpolator);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\animation\EmergeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */