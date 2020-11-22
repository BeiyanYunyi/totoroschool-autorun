package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLRotateAnimation;

public class RotateAnimation
  extends Animation
{
  public RotateAnimation(float paramFloat1, float paramFloat2)
  {
    this.glAnimation = new GLRotateAnimation(paramFloat1, paramFloat2, 0.0F, 0.0F, 0.0F);
  }
  
  public RotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.glAnimation = new GLRotateAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\animation\RotateAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */