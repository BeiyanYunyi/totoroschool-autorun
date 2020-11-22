package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

public class InfoWindowAnimationManager
{
  IInfoWindowManager a = null;
  
  public InfoWindowAnimationManager(IInfoWindowManager paramIInfoWindowManager)
  {
    this.a = paramIInfoWindowManager;
  }
  
  public void setInfoWindowAnimation(Animation paramAnimation, Animation.AnimationListener paramAnimationListener)
  {
    this.a.setInfoWindowAnimation(paramAnimation, paramAnimationListener);
  }
  
  public void setInfoWindowAppearAnimation(Animation paramAnimation)
  {
    this.a.setInfoWindowAppearAnimation(paramAnimation);
  }
  
  public void setInfoWindowBackColor(int paramInt)
  {
    this.a.setInfoWindowBackColor(paramInt);
  }
  
  public void setInfoWindowBackEnable(boolean paramBoolean)
  {
    this.a.setInfoWindowBackEnable(paramBoolean);
  }
  
  public void setInfoWindowBackScale(float paramFloat1, float paramFloat2)
  {
    this.a.setInfoWindowBackScale(paramFloat1, paramFloat2);
  }
  
  public void setInfoWindowDisappearAnimation(Animation paramAnimation)
  {
    this.a.setInfoWindowDisappearAnimation(paramAnimation);
  }
  
  public void setInfoWindowMovingAnimation(Animation paramAnimation)
  {
    this.a.setInfoWindowMovingAnimation(paramAnimation);
  }
  
  public void startAnimation()
  {
    this.a.startAnimation();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\InfoWindowAnimationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */