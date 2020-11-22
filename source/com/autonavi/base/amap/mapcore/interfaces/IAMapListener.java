package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;

public abstract interface IAMapListener
{
  public abstract void afterAnimation();
  
  public abstract void afterDrawFrame(int paramInt, GLMapState paramGLMapState);
  
  public abstract void afterDrawLabel(int paramInt, GLMapState paramGLMapState);
  
  public abstract void afterRendererOver(int paramInt, GLMapState paramGLMapState);
  
  public abstract void beforeDrawLabel(int paramInt, GLMapState paramGLMapState);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\interfaces\IAMapListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */