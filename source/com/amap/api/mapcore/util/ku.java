package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.Inner_3dMap_location;

public final class ku
{
  static fv a = null;
  private static final String[] b = { "com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core" };
  private static final String[] c = { "com.amap.api.mapcore2d", "com.amap.api.maps2d" };
  private static final String[] d = { "com.amap.trace" };
  
  public static fv a()
    throws fj
  {
    if (a != null) {
      return a;
    }
    try
    {
      localObject1 = Class.forName("com.amap.api.maps.MapsInitializer");
    }
    catch (Throwable localThrowable3)
    {
      try
      {
        localObject2 = (String)lh.a((Class)localObject1, "getVersion", null, null);
        localStringBuilder = new StringBuilder("AMAP_SDK_Android_Map_");
        localStringBuilder.append((String)localObject2);
        a = new fv.a("3dmap", (String)localObject2, localStringBuilder.toString()).a(b).a();
        break label144;
        localObject2 = Class.forName("com.amap.api.maps2d.MapsInitializer");
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          try
          {
            localObject1 = (String)lh.a((Class)localObject2, "getVersion", null, null);
            StringBuilder localStringBuilder = new StringBuilder("AMAP_SDK_Android_2DMap_");
            localStringBuilder.append((String)localObject1);
            a = new fv.a("2dmap", (String)localObject1, localStringBuilder.toString()).a(c).a();
            localObject1 = localObject2;
            if (localObject1 != null) {}
          }
          catch (Throwable localThrowable3)
          {
            try
            {
              localObject1 = Class.forName("com.amap.trace.AMapTraceClient");
              continue;
              localObject1 = null;
              if (localObject1 == null) {}
            }
            catch (Throwable localThrowable3)
            {
              try
              {
                Object localObject1 = (String)lh.a((Class)localObject1, "getVersion", null, null);
                Object localObject2 = new StringBuilder("AMAP_TRACE_Android_");
                ((StringBuilder)localObject2).append((String)localObject1);
                a = new fv.a("trace", (String)localObject1, ((StringBuilder)localObject2).toString()).a(d).a();
                return a;
                localThrowable1 = localThrowable1;
                continue;
                localThrowable5 = localThrowable5;
                break label241;
                localThrowable2 = localThrowable2;
                continue;
                localThrowable3 = localThrowable3;
              }
              catch (Throwable localThrowable4) {}
            }
          }
        }
      }
    }
    localObject1 = null;
    if (localObject1 == null) {}
  }
  
  public static boolean a(le paramle)
  {
    if (paramle == null) {
      return false;
    }
    if (paramle.d().equals("8")) {
      return false;
    }
    if (paramle.d().equals("5")) {
      return false;
    }
    if (paramle.d().equals("6")) {
      return false;
    }
    return a(paramle);
  }
  
  public static boolean a(Inner_3dMap_location paramInner_3dMap_location)
  {
    double d1 = paramInner_3dMap_location.getLongitude();
    double d2 = paramInner_3dMap_location.getLatitude();
    boolean bool2 = false;
    boolean bool1;
    if (d1 == 0.0D)
    {
      bool1 = bool2;
      if (d2 == 0.0D) {}
    }
    else
    {
      bool1 = bool2;
      if (d1 <= 180.0D)
      {
        if (d2 > 90.0D) {
          return false;
        }
        bool1 = bool2;
        if (d1 >= -180.0D)
        {
          if (d2 < -90.0D) {
            return false;
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */