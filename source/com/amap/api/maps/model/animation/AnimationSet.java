package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;

public class AnimationSet
  extends Animation
{
  public AnimationSet(boolean paramBoolean)
  {
    this.glAnimation = new GLAnimationSet(paramBoolean);
  }
  
  public void addAnimation(Animation paramAnimation)
  {
    ((GLAnimationSet)this.glAnimation).addAnimation(paramAnimation);
  }
  
  public void cleanAnimation()
  {
    ((GLAnimationSet)this.glAnimation).cleanAnimation();
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\animation\AnimationSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */