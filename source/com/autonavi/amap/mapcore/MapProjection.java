package com.autonavi.amap.mapcore;

import android.graphics.Point;

public class MapProjection
{
  public static void geo2LonLat(int paramInt1, int paramInt2, DPoint paramDPoint)
  {
    DPoint localDPoint = VirtualEarthProjection.pixelsToLatLong(paramInt1, paramInt2, 20);
    paramDPoint.x = localDPoint.x;
    paramDPoint.y = localDPoint.y;
    localDPoint.recycle();
  }
  
  public static void lonlat2Geo(double paramDouble1, double paramDouble2, IPoint paramIPoint)
  {
    Point localPoint = VirtualEarthProjection.latLongToPixels(paramDouble2, paramDouble1, 20);
    paramIPoint.x = localPoint.x;
    paramIPoint.y = localPoint.y;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\MapProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */