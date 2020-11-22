package com.amap.api.mapcore.util;

import android.location.Location;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

class gi
  implements LocationSource.OnLocationChangedListener
{
  Location a;
  private IAMapDelegate b;
  
  gi(IAMapDelegate paramIAMapDelegate)
  {
    this.b = paramIAMapDelegate;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    this.a = paramLocation;
    try
    {
      if (this.b.isMyLocationEnabled())
      {
        this.b.showMyLocationOverlay(paramLocation);
        return;
      }
    }
    catch (Throwable paramLocation)
    {
      gk.c(paramLocation, "AMapOnLocationChangedListener", "onLocationChanged");
      paramLocation.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */