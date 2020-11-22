package com.amap.api.mapcore.util;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;

public class h
  extends AbstractCameraUpdateMessage
{
  public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage)
  {
    DPoint localDPoint;
    if (this.geoPoint == null) {
      localDPoint = paramAbstractCameraUpdateMessage.geoPoint;
    } else {
      localDPoint = this.geoPoint;
    }
    paramAbstractCameraUpdateMessage.geoPoint = localDPoint;
    float f;
    if (Float.isNaN(this.zoom)) {
      f = paramAbstractCameraUpdateMessage.zoom;
    } else {
      f = this.zoom;
    }
    paramAbstractCameraUpdateMessage.zoom = f;
    if (Float.isNaN(this.bearing)) {
      f = paramAbstractCameraUpdateMessage.bearing;
    } else {
      f = this.bearing;
    }
    paramAbstractCameraUpdateMessage.bearing = f;
    if (Float.isNaN(this.tilt)) {
      f = paramAbstractCameraUpdateMessage.tilt;
    } else {
      f = this.tilt;
    }
    paramAbstractCameraUpdateMessage.tilt = f;
  }
  
  public void runCameraUpdate(IGLMapState paramIGLMapState)
  {
    normalChange(paramIGLMapState);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */