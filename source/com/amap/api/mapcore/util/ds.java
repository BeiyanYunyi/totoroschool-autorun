package com.amap.api.mapcore.util;

import com.amap.api.maps.model.LatLng;

public class ds
{
  private static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return paramLatLng1.longitude * paramLatLng2.latitude - paramLatLng2.longitude * paramLatLng1.latitude;
  }
  
  private static double a(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    return a(b(paramLatLng3, paramLatLng1), b(paramLatLng2, paramLatLng1));
  }
  
  public static boolean a(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4)
  {
    double d1 = a(paramLatLng3, paramLatLng4, paramLatLng1);
    double d2 = a(paramLatLng3, paramLatLng4, paramLatLng2);
    double d3 = a(paramLatLng1, paramLatLng2, paramLatLng3);
    double d4 = a(paramLatLng1, paramLatLng2, paramLatLng4);
    int i;
    if (((d1 > 0.0D) && (d2 < 0.0D)) || ((d1 < 0.0D) && (d2 > 0.0D) && (((d3 > 0.0D) && (d4 < 0.0D)) || ((d3 < 0.0D) && (d4 > 0.0D))))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    if ((d1 == 0.0D) && (b(paramLatLng3, paramLatLng4, paramLatLng1))) {
      return true;
    }
    if ((d2 == 0.0D) && (b(paramLatLng3, paramLatLng4, paramLatLng2))) {
      return true;
    }
    if ((d3 == 0.0D) && (b(paramLatLng1, paramLatLng2, paramLatLng3))) {
      return true;
    }
    return (d4 == 0.0D) && (b(paramLatLng1, paramLatLng2, paramLatLng4));
  }
  
  private static LatLng b(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return new LatLng(paramLatLng2.latitude - paramLatLng1.latitude, paramLatLng2.longitude - paramLatLng1.longitude);
  }
  
  private static boolean b(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    double d1;
    if (paramLatLng1.longitude - paramLatLng2.longitude > 0.0D) {
      d1 = paramLatLng1.longitude;
    } else {
      d1 = paramLatLng2.longitude;
    }
    double d2;
    if (paramLatLng1.longitude - paramLatLng2.longitude < 0.0D) {
      d2 = paramLatLng1.longitude;
    } else {
      d2 = paramLatLng2.longitude;
    }
    double d3;
    if (paramLatLng1.latitude - paramLatLng2.latitude > 0.0D) {
      d3 = paramLatLng1.latitude;
    } else {
      d3 = paramLatLng2.latitude;
    }
    double d4;
    if (paramLatLng1.latitude - paramLatLng2.latitude < 0.0D) {
      d4 = paramLatLng1.latitude;
    } else {
      d4 = paramLatLng2.latitude;
    }
    return (d2 <= paramLatLng3.longitude) && (paramLatLng3.longitude <= d1) && (d4 <= paramLatLng3.latitude) && (paramLatLng3.latitude <= d3);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */