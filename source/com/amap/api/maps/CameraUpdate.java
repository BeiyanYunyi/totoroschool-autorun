package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

public final class CameraUpdate
{
  AbstractCameraUpdateMessage a;
  
  CameraUpdate(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage)
  {
    this.a = paramAbstractCameraUpdateMessage;
  }
  
  public AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\CameraUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */