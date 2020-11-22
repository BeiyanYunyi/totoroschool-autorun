package com.amap.api.fence;

import java.util.List;

public abstract interface GeoFenceListener
{
  public abstract void onGeoFenceCreateFinished(List<GeoFence> paramList, int paramInt, String paramString);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\fence\GeoFenceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */