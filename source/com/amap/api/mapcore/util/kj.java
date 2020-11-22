package com.amap.api.mapcore.util;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;

public final class kj
  implements AMapLocationListener
{
  public Inner_3dMap_locationListener a = null;
  
  public final void a(Inner_3dMap_locationListener paramInner_3dMap_locationListener)
  {
    this.a = paramInner_3dMap_locationListener;
  }
  
  public final void onLocationChanged(AMapLocation paramAMapLocation)
  {
    try
    {
      paramAMapLocation = kl.a(paramAMapLocation);
      if (ku.a(paramAMapLocation)) {
        kl.a = paramAMapLocation;
      }
      if (this.a != null) {
        this.a.onLocationChanged(paramAMapLocation);
      }
      return;
    }
    catch (Throwable paramAMapLocation)
    {
      lf.a(paramAMapLocation, "LocationListener", "onLocationChanged");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */