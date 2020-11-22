package com.autonavi.base.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.animation.GLAnimation;

public abstract interface IAnimation
{
  public abstract void setAnimation(GLAnimation paramGLAnimation);
  
  public abstract void setAnimationListener(Animation.AnimationListener paramAnimationListener);
  
  public abstract boolean startAnimation();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\interfaces\IAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */