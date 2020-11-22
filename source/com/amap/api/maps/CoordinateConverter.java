package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.dq;
import com.amap.api.mapcore.util.dv;
import com.amap.api.mapcore.util.gk;
import com.amap.api.mapcore.util.l;
import com.amap.api.maps.model.LatLng;

public class CoordinateConverter
{
  private Context a;
  private CoordType b = null;
  private LatLng c = null;
  
  public CoordinateConverter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static boolean isAMapDataAvailable(double paramDouble1, double paramDouble2)
  {
    return dq.a(paramDouble1, paramDouble2);
  }
  
  public LatLng convert()
  {
    Object localObject = this.b;
    LatLng localLatLng = null;
    if (localObject == null) {
      return null;
    }
    if (this.c == null) {
      return null;
    }
    localObject = "";
    for (;;)
    {
      try
      {
        switch (1.a[this.b.ordinal()])
        {
        case 7: 
          localObject = "gps";
          localLatLng = l.a(this.a, this.c);
          break;
        case 6: 
          localObject = "google";
          localLatLng = this.c;
          break;
        case 5: 
          localObject = "aliyun";
          localLatLng = this.c;
          break;
        case 4: 
          localObject = "sosomap";
          localLatLng = this.c;
          break;
        case 3: 
          localObject = "mapabc";
          localLatLng = this.c;
          break;
        case 2: 
          localLatLng = l.b(this.a, this.c);
          localObject = "mapbar";
          break;
        case 1: 
          localLatLng = l.a(this.c);
          localObject = "baidu";
          dv.a(this.a, (String)localObject);
          return localLatLng;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        gk.c(localThrowable, "CoordinateConverter", "convert");
        return this.c;
      }
    }
  }
  
  public CoordinateConverter coord(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public CoordinateConverter from(CoordType paramCoordType)
  {
    this.b = paramCoordType;
    return this;
  }
  
  public static enum CoordType
  {
    static
    {
      GPS = new CoordType("GPS", 2);
      MAPABC = new CoordType("MAPABC", 3);
      SOSOMAP = new CoordType("SOSOMAP", 4);
    }
    
    private CoordType() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\CoordinateConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */