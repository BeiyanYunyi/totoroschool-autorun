package com.amap.api.maps;

import android.location.Location;

public abstract interface LocationSource
{
  public abstract void activate(OnLocationChangedListener paramOnLocationChangedListener);
  
  public abstract void deactivate();
  
  public static abstract interface OnLocationChangedListener
  {
    public abstract void onLocationChanged(Location paramLocation);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\LocationSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */