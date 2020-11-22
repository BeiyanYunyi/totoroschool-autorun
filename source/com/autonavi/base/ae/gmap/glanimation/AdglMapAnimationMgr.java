package com.autonavi.base.ae.gmap.glanimation;

import com.amap.api.maps.AMap.CancelableCallback;
import com.autonavi.base.ae.gmap.GLMapState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdglMapAnimationMgr
{
  private List<AbstractAdglAnimation> list = Collections.synchronizedList(new ArrayList());
  private AMap.CancelableCallback mCancelCallback;
  private MapAnimationListener mMapAnimationListener;
  
  public void addAnimation(AbstractAdglAnimation paramAbstractAdglAnimation, AMap.CancelableCallback paramCancelableCallback)
  {
    if (paramAbstractAdglAnimation == null) {
      return;
    }
    synchronized (this.list)
    {
      if ((!paramAbstractAdglAnimation.isOver()) && (this.list.size() > 0))
      {
        AbstractAdglAnimation localAbstractAdglAnimation = (AbstractAdglAnimation)this.list.get(this.list.size() - 1);
        if ((localAbstractAdglAnimation != null) && ((paramAbstractAdglAnimation instanceof AdglMapAnimGroup)) && ((localAbstractAdglAnimation instanceof AdglMapAnimGroup)) && (((AdglMapAnimGroup)paramAbstractAdglAnimation).typeEqueal((AdglMapAnimGroup)localAbstractAdglAnimation)) && (!((AdglMapAnimGroup)paramAbstractAdglAnimation).needMove)) {
          this.list.remove(localAbstractAdglAnimation);
        }
      }
      this.list.add(paramAbstractAdglAnimation);
      this.mCancelCallback = paramCancelableCallback;
      return;
    }
  }
  
  public void clearAnimations()
  {
    try
    {
      this.list.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void doAnimations(GLMapState paramGLMapState)
  {
    if (paramGLMapState == null) {
      return;
    }
    try
    {
      int i = this.list.size();
      if (i <= 0) {
        return;
      }
      AbstractAdglAnimation localAbstractAdglAnimation = (AbstractAdglAnimation)this.list.get(0);
      if (localAbstractAdglAnimation == null) {
        return;
      }
      if (localAbstractAdglAnimation.isOver())
      {
        if (this.mMapAnimationListener != null) {
          this.mMapAnimationListener.onMapAnimationFinish(this.mCancelCallback);
        }
        this.list.remove(localAbstractAdglAnimation);
      }
      else
      {
        localAbstractAdglAnimation.doAnimation(paramGLMapState);
      }
      return;
    }
    finally {}
  }
  
  public int getAnimationsCount()
  {
    try
    {
      int i = this.list.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public AMap.CancelableCallback getCancelCallback()
  {
    return this.mCancelCallback;
  }
  
  public void setMapAnimationListener(MapAnimationListener paramMapAnimationListener)
  {
    try
    {
      this.mMapAnimationListener = paramMapAnimationListener;
      return;
    }
    finally {}
  }
  
  public void setMapCoreListener() {}
  
  public static abstract interface MapAnimationListener
  {
    public abstract void onMapAnimationFinish(AMap.CancelableCallback paramCancelableCallback);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AdglMapAnimationMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */