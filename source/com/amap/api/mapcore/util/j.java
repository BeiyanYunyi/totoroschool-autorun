package com.amap.api.mapcore.util;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

public class j
  extends AbstractCameraUpdateMessage
{
  public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage)
  {
    paramAbstractCameraUpdateMessage.zoom += this.amount;
  }
  
  public void runCameraUpdate(IGLMapState paramIGLMapState)
  {
    this.zoom = (paramIGLMapState.getMapZoomer() + this.amount);
    this.zoom = dx.a(this.mapConfig, this.zoom);
    normalChange(paramIGLMapState);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */