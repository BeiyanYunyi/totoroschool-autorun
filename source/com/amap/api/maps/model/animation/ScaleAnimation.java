package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLScaleAnimation;

public class ScaleAnimation
  extends Animation
{
  public ScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.glAnimation = new GLScaleAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    setFillMode(1);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\animation\ScaleAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */