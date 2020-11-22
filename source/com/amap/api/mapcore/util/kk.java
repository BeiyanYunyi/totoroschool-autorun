package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public final class kk
{
  Context a;
  LocationManager b;
  volatile long c = 0L;
  volatile boolean d = false;
  boolean e = false;
  volatile Inner_3dMap_location f = null;
  Object g = null;
  boolean h = false;
  boolean i = false;
  LocationListener j = new LocationListener()
  {
    public final void onLocationChanged(Location paramAnonymousLocation)
    {
      if (paramAnonymousLocation == null) {
        return;
      }
      try
      {
        Inner_3dMap_location localInner_3dMap_location = new Inner_3dMap_location(paramAnonymousLocation);
        localInner_3dMap_location.setProvider("gps");
        localInner_3dMap_location.setLocationType(1);
        paramAnonymousLocation = paramAnonymousLocation.getExtras();
        int i = 0;
        if (paramAnonymousLocation != null) {
          i = paramAnonymousLocation.getInt("satellites");
        }
        localInner_3dMap_location.setSatellites(i);
        localInner_3dMap_location.setTime(lg.a(localInner_3dMap_location.getTime(), System.currentTimeMillis()));
        kk.this.f = localInner_3dMap_location;
        kk.this.c = lj.b();
        kk.this.d = true;
        return;
      }
      catch (Throwable paramAnonymousLocation)
      {
        lf.a(paramAnonymousLocation, "MAPGPSLocation", "onLocationChanged");
      }
    }
    
    public final void onProviderDisabled(String paramAnonymousString)
    {
      try
      {
        if ("gps".equals(paramAnonymousString)) {
          kk.this.d = false;
        }
        return;
      }
      catch (Throwable paramAnonymousString)
      {
        lf.a(paramAnonymousString, "MAPGPSLocation", "onProviderDisabled");
      }
    }
    
    public final void onProviderEnabled(String paramAnonymousString) {}
    
    public final void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
  };
  
  public kk(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.a = paramContext;
    e();
    try
    {
      if ((this.g == null) && (!this.i))
      {
        if (this.h) {}
        for (Object localObject = Class.forName("com.amap.api.maps.CoordinateConverter").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });; localObject = Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]))
        {
          this.g = localObject;
          break;
        }
        if (paramContext == null) {
          this.i = true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    if (this.b == null) {
      this.b = ((LocationManager)this.a.getSystemService("location"));
    }
  }
  
  private void e()
  {
    try
    {
      if (Class.forName("com.amap.api.maps.CoordinateConverter") != null) {
        this.h = true;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: invokestatic 94	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: astore_2
    //   4: aload_2
    //   5: astore_1
    //   6: aload_2
    //   7: ifnonnull +11 -> 18
    //   10: aload_0
    //   11: getfield 51	com/amap/api/mapcore/util/kk:a	Landroid/content/Context;
    //   14: invokevirtual 97	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   17: astore_1
    //   18: new 99	android/os/Bundle
    //   21: dup
    //   22: invokespecial 100	android/os/Bundle:<init>	()V
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 77	com/amap/api/mapcore/util/kk:b	Landroid/location/LocationManager;
    //   30: ldc 102
    //   32: ldc 104
    //   34: aload_2
    //   35: invokevirtual 108	android/location/LocationManager:sendExtraCommand	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   38: pop
    //   39: aload_0
    //   40: getfield 77	com/amap/api/mapcore/util/kk:b	Landroid/location/LocationManager;
    //   43: ldc 102
    //   45: ldc2_w 109
    //   48: fconst_0
    //   49: aload_0
    //   50: getfield 49	com/amap/api/mapcore/util/kk:j	Landroid/location/LocationListener;
    //   53: aload_1
    //   54: invokevirtual 114	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   57: return
    //   58: astore_1
    //   59: aload_1
    //   60: ldc 116
    //   62: ldc 117
    //   64: invokestatic 122	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   67: return
    //   68: astore_1
    //   69: return
    //   70: astore_2
    //   71: goto -32 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	kk
    //   5	49	1	localObject1	Object
    //   58	2	1	localThrowable1	Throwable
    //   68	1	1	localSecurityException	SecurityException
    //   3	32	2	localObject2	Object
    //   70	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	4	58	java/lang/Throwable
    //   10	18	58	java/lang/Throwable
    //   18	26	58	java/lang/Throwable
    //   39	57	58	java/lang/Throwable
    //   0	4	68	java/lang/SecurityException
    //   10	18	68	java/lang/SecurityException
    //   18	26	68	java/lang/SecurityException
    //   26	39	68	java/lang/SecurityException
    //   39	57	68	java/lang/SecurityException
    //   26	39	70	java/lang/Throwable
  }
  
  private void g()
  {
    this.d = false;
    this.c = 0L;
    this.f = null;
  }
  
  public final void a()
  {
    if (!this.e)
    {
      f();
      this.e = true;
    }
  }
  
  public final void b()
  {
    this.e = false;
    g();
    if (this.b == null) {
      return;
    }
    if (this.j != null) {
      this.b.removeUpdates(this.j);
    }
  }
  
  public final boolean c()
  {
    if (this.d)
    {
      if (lj.b() - this.c <= 10000L) {
        return true;
      }
      this.f = null;
    }
    return false;
  }
  
  public final Inner_3dMap_location d()
  {
    if (this.f == null) {
      return null;
    }
    Inner_3dMap_location localInner_3dMap_location = this.f.clone();
    if ((localInner_3dMap_location != null) && (localInner_3dMap_location.getErrorCode() == 0)) {}
    try
    {
      Object localObject1;
      if (this.g != null)
      {
        if (lf.a(localInner_3dMap_location.getLatitude(), localInner_3dMap_location.getLongitude()))
        {
          localObject1 = new Object[1];
          localObject1[0] = "GPS";
          Object localObject2 = new Class[1];
          localObject2[0] = String.class;
          Object[] arrayOfObject;
          if (this.h)
          {
            localObject1 = lh.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", (Object[])localObject1, (Class[])localObject2);
            localObject2 = Class.forName("com.amap.api.maps.model.LatLng").getConstructor(new Class[] { Double.TYPE, Double.TYPE });
            arrayOfObject = new Object[2];
            arrayOfObject[0] = Double.valueOf(localInner_3dMap_location.getLatitude());
            arrayOfObject[1] = Double.valueOf(localInner_3dMap_location.getLongitude());
          }
          for (;;)
          {
            localObject2 = ((Constructor)localObject2).newInstance(arrayOfObject);
            break;
            localObject1 = lh.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", (Object[])localObject1, (Class[])localObject2);
            localObject2 = Class.forName("com.amap.api.maps2d.model.LatLng").getConstructor(new Class[] { Double.TYPE, Double.TYPE });
            arrayOfObject = new Object[2];
            arrayOfObject[0] = Double.valueOf(localInner_3dMap_location.getLatitude());
            arrayOfObject[1] = Double.valueOf(localInner_3dMap_location.getLongitude());
          }
          lh.a(this.g, "coord", new Object[] { localObject2 });
          lh.a(this.g, "from", new Object[] { localObject1 });
          localObject1 = lh.a(this.g, "convert", new Object[0]);
          double d1 = ((Double)localObject1.getClass().getDeclaredField("latitude").get(localObject1)).doubleValue();
          double d2 = ((Double)localObject1.getClass().getDeclaredField("longitude").get(localObject1)).doubleValue();
          localInner_3dMap_location.setLatitude(d1);
          localInner_3dMap_location.setLongitude(d2);
          return localInner_3dMap_location;
        }
      }
      else if ((this.i) && (lf.a(localInner_3dMap_location.getLatitude(), localInner_3dMap_location.getLongitude())))
      {
        localObject1 = ki.a(localInner_3dMap_location.getLongitude(), localInner_3dMap_location.getLatitude());
        if (localObject1 != null)
        {
          localInner_3dMap_location.setLatitude(localObject1[1]);
          localInner_3dMap_location.setLongitude(localObject1[0]);
        }
      }
      return localInner_3dMap_location;
    }
    catch (Throwable localThrowable) {}
    return localInner_3dMap_location;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */