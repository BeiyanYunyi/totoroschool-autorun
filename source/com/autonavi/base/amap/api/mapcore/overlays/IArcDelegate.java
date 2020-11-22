package com.autonavi.base.amap.api.mapcore.overlays;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.interfaces.IArc;

public abstract interface IArcDelegate
  extends IArc, IOverlayDelegate
{
  public abstract void setEnd(LatLng paramLatLng);
  
  public abstract void setPassed(LatLng paramLatLng);
  
  public abstract void setStart(LatLng paramLatLng);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\IArcDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */