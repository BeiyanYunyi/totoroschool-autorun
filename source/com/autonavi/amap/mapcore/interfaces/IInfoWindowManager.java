package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;

public abstract interface IInfoWindowManager
{
  public abstract void setInfoWindowAnimation(Animation paramAnimation, Animation.AnimationListener paramAnimationListener);
  
  public abstract void setInfoWindowAppearAnimation(Animation paramAnimation);
  
  public abstract void setInfoWindowBackColor(int paramInt);
  
  public abstract void setInfoWindowBackEnable(boolean paramBoolean);
  
  public abstract void setInfoWindowBackScale(float paramFloat1, float paramFloat2);
  
  public abstract void setInfoWindowDisappearAnimation(Animation paramAnimation);
  
  public abstract void setInfoWindowMovingAnimation(Animation paramAnimation);
  
  public abstract void startAnimation();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IInfoWindowManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */