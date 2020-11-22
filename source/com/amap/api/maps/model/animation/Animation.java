package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAnimation;

public abstract class Animation
{
  public static final int FILL_MODE_BACKWARDS = 1;
  public static final int FILL_MODE_FORWARDS = 0;
  public static final int INFINITE = -1;
  public static final int RESTART = 1;
  public static final int REVERSE = 2;
  private int a = 0;
  public GLAnimation glAnimation = null;
  
  private void a(boolean paramBoolean)
  {
    if (this.glAnimation != null) {
      this.glAnimation.setFillEnabled(paramBoolean);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.glAnimation != null) {
      this.glAnimation.setFillAfter(paramBoolean);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.glAnimation != null) {
      this.glAnimation.setFillBefore(paramBoolean);
    }
  }
  
  public int getFillMode()
  {
    return this.a;
  }
  
  public int getRepeatCount()
  {
    if (this.glAnimation != null) {
      return this.glAnimation.getRepeatCount();
    }
    return 0;
  }
  
  public int getRepeatMode()
  {
    if (this.glAnimation != null) {
      return this.glAnimation.getRepeatMode();
    }
    return 1;
  }
  
  public void setAnimationListener(AnimationListener paramAnimationListener)
  {
    this.glAnimation.setAnimationListener(paramAnimationListener);
  }
  
  public abstract void setDuration(long paramLong);
  
  public void setFillMode(int paramInt)
  {
    this.a = paramInt;
    if (this.a == 0)
    {
      b(true);
      c(false);
      a(false);
      return;
    }
    b(false);
    a(true);
    c(true);
  }
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
  
  public void setRepeatCount(int paramInt)
  {
    if (this.glAnimation != null) {
      this.glAnimation.setRepeatCount(paramInt);
    }
  }
  
  public void setRepeatMode(int paramInt)
  {
    if (this.glAnimation != null) {
      this.glAnimation.setRepeatMode(paramInt);
    }
  }
  
  public static abstract interface AnimationListener
  {
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\animation\Animation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */