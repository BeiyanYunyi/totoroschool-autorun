package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimation;

public class AlphaAnimation
  extends Animation
{
  public AlphaAnimation(float paramFloat1, float paramFloat2)
  {
    this.glAnimation = new GLAlphaAnimation(paramFloat1, paramFloat2);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\animation\AlphaAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */