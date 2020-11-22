package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class h
{
  static AMapLocation j;
  static long k;
  static Object l = new Object();
  static long q = 0L;
  static boolean t = false;
  static boolean u = false;
  private long A = 0L;
  private int B = 0;
  private int C = 0;
  private GpsStatus D = null;
  private GpsStatus.Listener E = new GpsStatus.Listener()
  {
    public final void onGpsStatusChanged(int paramAnonymousInt)
    {
      try
      {
        if (h.this.b == null) {
          return;
        }
        h.a(h.this, h.this.b.getGpsStatus(h.a(h.this)));
        m = 0;
        n = 0;
        k = 0;
        switch (paramAnonymousInt)
        {
        default: 
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        int m;
        int n;
        int k;
        int i;
        int j;
        dg.a(localThrowable2, "GpsLocation", "onGpsStatusChanged");
        return;
      }
      i = m;
      j = n;
      try
      {
        if (h.a(h.this) != null)
        {
          i = m;
          Object localObject = h.a(h.this).getSatellites();
          j = n;
          if (localObject != null)
          {
            i = m;
            localObject = ((Iterable)localObject).iterator();
            i = m;
            m = h.a(h.this).getMaxSatellites();
            paramAnonymousInt = k;
            for (;;)
            {
              i = paramAnonymousInt;
              j = paramAnonymousInt;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              j = paramAnonymousInt;
              if (paramAnonymousInt >= m) {
                break;
              }
              i = paramAnonymousInt;
              boolean bool = ((GpsSatellite)((Iterator)localObject).next()).usedInFix();
              if (bool) {
                paramAnonymousInt += 1;
              }
            }
          }
        }
        h.b(h.this, 0);
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        j = i;
        h.b(h.this, j);
        return;
      }
      return;
    }
  };
  private String F = null;
  private boolean G = false;
  private int H = 0;
  private boolean I = false;
  Handler a;
  LocationManager b;
  AMapLocationClientOption c;
  long d = 0L;
  boolean e = false;
  cn f = null;
  int g = 240;
  int h = 80;
  AMapLocation i = null;
  long m = 0L;
  float n = 0.0F;
  Object o = new Object();
  Object p = new Object();
  AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
  boolean s = true;
  long v = 0L;
  int w = 0;
  LocationListener x = null;
  public AMapLocation y = null;
  private Context z;
  
  public h(Context paramContext, Handler paramHandler)
  {
    this.z = paramContext;
    this.a = paramHandler;
    try
    {
      this.b = ((LocationManager)this.z.getSystemService("location"));
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "GpsLocation", "<init>");
    }
    this.f = new cn();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    try
    {
      if ((this.a != null) && (this.c.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors))
      {
        Message localMessage = Message.obtain();
        AMapLocation localAMapLocation = new AMapLocation("");
        localAMapLocation.setProvider("gps");
        localAMapLocation.setErrorCode(paramInt2);
        localAMapLocation.setLocationDetail(paramString);
        localAMapLocation.setLocationType(1);
        localMessage.obj = localAMapLocation;
        localMessage.what = paramInt1;
        this.a.sendMessageDelayed(localMessage, paramLong);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  private void a(AMapLocation paramAMapLocation)
  {
    if ((paramAMapLocation.getErrorCode() == 15) && (!AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.c.getLocationMode()))) {
      return;
    }
    if ((this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors)) && (this.c.getDeviceModeDistanceFilter() > 0.0F))
    {
      b(paramAMapLocation);
      return;
    }
    if (dn.b() - this.v >= this.c.getInterval() - 200L)
    {
      this.v = dn.b();
      b(paramAMapLocation);
    }
  }
  
  private static boolean a(LocationManager paramLocationManager)
  {
    try
    {
      if (t) {
        return u;
      }
      paramLocationManager = paramLocationManager.getAllProviders();
      if ((paramLocationManager != null) && (paramLocationManager.size() > 0)) {
        u = paramLocationManager.contains("gps");
      } else {
        u = false;
      }
      t = true;
      boolean bool = u;
      return bool;
    }
    catch (Throwable paramLocationManager)
    {
      for (;;) {}
    }
    return u;
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      ArrayList localArrayList1 = dn.d(paramString);
      ArrayList localArrayList2 = dn.d(this.F);
      boolean bool1 = bool2;
      if (localArrayList1.size() >= 8)
      {
        bool1 = bool2;
        if (localArrayList2.size() >= 8) {
          bool1 = dn.a(this.F, paramString);
        }
      }
      return bool1;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void b(AMapLocation paramAMapLocation)
  {
    if (this.a != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramAMapLocation;
      localMessage.what = 2;
      this.a.sendMessage(localMessage);
    }
  }
  
  private static boolean e()
  {
    try
    {
      boolean bool = ((Boolean)dj.a(w.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), w.c("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return false;
  }
  
  private AMapLocation f()
  {
    for (;;)
    {
      try
      {
        if (!dn.a(this.i)) {
          return null;
        }
        if (!df.p()) {
          return null;
        }
        if (e())
        {
          ??? = new JSONObject((String)dj.a(w.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), w.c("UZ2V0TmF2aUxvY2F0aW9u"), null, null));
          l1 = ((JSONObject)???).optLong("time");
          if (!this.I)
          {
            this.I = true;
            dk.a("useNaviLoc", "use NaviLoc");
          }
          if (dn.a() - l1 <= 5500L)
          {
            d1 = ((JSONObject)???).optDouble("lat", 0.0D);
            d2 = ((JSONObject)???).optDouble("lng", 0.0D);
            f3 = 0.0F;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        long l1;
        double d1;
        double d2;
        float f3;
        float f1;
        double d3;
        float f2;
        float f4;
        AMapLocation localAMapLocation;
        return null;
      }
      try
      {
        f1 = Float.parseFloat(((JSONObject)???).optString("accuracy", "0"));
      }
      catch (NumberFormatException localNumberFormatException2) {}
    }
    f1 = 0.0F;
    d3 = ((JSONObject)???).optDouble("altitude", 0.0D);
    try
    {
      f2 = Float.parseFloat(((JSONObject)???).optString("bearing", "0"));
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      for (;;) {}
    }
    f2 = 0.0F;
    try
    {
      f4 = Float.parseFloat(((JSONObject)???).optString("speed", "0"));
      f3 = f4 * 10.0F / 36.0F;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;) {}
    }
    localAMapLocation = new AMapLocation("lbs");
    localAMapLocation.setLocationType(9);
    localAMapLocation.setLatitude(d1);
    localAMapLocation.setLongitude(d2);
    localAMapLocation.setAccuracy(f1);
    localAMapLocation.setAltitude(d3);
    localAMapLocation.setBearing(f2);
    localAMapLocation.setSpeed(f3);
    localAMapLocation.setTime(l1);
    localAMapLocation.setCoordType("GCJ02");
    if (dn.a(localAMapLocation, this.i) <= 300.0F) {
      synchronized (this.p)
      {
        this.i.setLongitude(d2);
        this.i.setLatitude(d1);
        this.i.setAccuracy(f1);
        this.i.setBearing(f2);
        this.i.setSpeed(f3);
        this.i.setTime(l1);
        this.i.setCoordType("GCJ02");
        return localAMapLocation;
      }
    }
    return null;
  }
  
  public final AMapLocation a(AMapLocation paramAMapLocation, String arg2)
  {
    if (this.i == null) {
      return paramAMapLocation;
    }
    if ((!this.c.isMockEnable()) && (this.i.isMock())) {
      return paramAMapLocation;
    }
    if (!dn.a(this.i)) {
      return paramAMapLocation;
    }
    AMapLocation localAMapLocation = f();
    if ((localAMapLocation != null) && (dn.a(localAMapLocation)))
    {
      localAMapLocation.setTrustedLevel(2);
      return localAMapLocation;
    }
    float f2 = this.i.getSpeed();
    float f1 = f2;
    if (f2 == 0.0F)
    {
      f1 = f2;
      if (this.m > 0L)
      {
        f1 = f2;
        if (this.m < 8L)
        {
          f1 = f2;
          if (this.n > 0.0F) {
            f1 = this.n / (float)this.m;
          }
        }
      }
    }
    if ((paramAMapLocation != null) && (dn.a(paramAMapLocation)))
    {
      if (paramAMapLocation.getAccuracy() < 200.0F)
      {
        this.H += 1;
        if ((this.F == null) && (this.H >= 2)) {
          this.G = true;
        }
        if (f1 > 5.0F)
        {
          l1 = 10000L;
          break label256;
        }
        l1 = 15000L;
        break label256;
      }
      if (!TextUtils.isEmpty(this.F))
      {
        this.G = false;
        this.H = 0;
      }
      if (f1 > 5.0F)
      {
        l1 = 20000L;
        break label256;
      }
    }
    long l1 = 30000L;
    label256:
    long l2 = dn.b() - this.d;
    if (l2 > 30000L) {
      return paramAMapLocation;
    }
    if (l2 >= l1)
    {
      if ((this.G) && (a(???)))
      {
        paramAMapLocation = this.i.clone();
        paramAMapLocation.setTrustedLevel(3);
        return paramAMapLocation;
      }
      this.F = null;
      this.H = 0;
      synchronized (this.p)
      {
        this.i = null;
        this.m = 0L;
        this.n = 0.0F;
        return paramAMapLocation;
      }
    }
    if ((this.F == null) && (this.H >= 2)) {
      this.F = ???;
    }
    paramAMapLocation = this.i.clone();
    paramAMapLocation.setTrustedLevel(2);
    return paramAMapLocation;
  }
  
  public final void a()
  {
    if (this.b == null) {
      return;
    }
    try
    {
      if (this.x != null)
      {
        this.b.removeUpdates(this.x);
        ((a)this.x).a();
        this.x = null;
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        if (this.E != null) {
          this.b.removeGpsStatusListener(this.E);
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            if (this.a != null) {
              this.a.removeMessages(8);
            }
            this.C = 0;
            this.A = 0L;
            this.v = 0L;
            this.d = 0L;
            this.B = 0;
            this.w = 0;
            this.f.a();
            this.i = null;
            this.m = 0L;
            this.n = 0.0F;
            this.F = null;
            this.I = false;
            return;
            localThrowable1 = localThrowable1;
            continue;
            localThrowable2 = localThrowable2;
          }
        }
        catch (Throwable localThrowable3)
        {
          for (;;) {}
        }
      }
    }
  }
  
  /* Error */
  public final void a(AMapLocationClientOption paramAMapLocationClientOption)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   5: aload_0
    //   6: getfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   9: ifnonnull +14 -> 23
    //   12: aload_0
    //   13: new 166	com/amap/api/location/AMapLocationClientOption
    //   16: dup
    //   17: invokespecial 572	com/amap/api/location/AMapLocationClientOption:<init>	()V
    //   20: putfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   23: aload_0
    //   24: getfield 134	com/loc/h:z	Landroid/content/Context;
    //   27: ldc_w 574
    //   30: ldc_w 576
    //   33: getstatic 66	com/loc/h:q	J
    //   36: invokestatic 581	com/loc/dm:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   39: putstatic 66	com/loc/h:q	J
    //   42: aload_0
    //   43: getfield 148	com/loc/h:b	Landroid/location/LocationManager;
    //   46: ifnonnull +4 -> 50
    //   49: return
    //   50: invokestatic 236	com/loc/dn:b	()J
    //   53: getstatic 381	com/loc/h:k	J
    //   56: lsub
    //   57: ldc2_w 582
    //   60: lcmp
    //   61: ifgt +45 -> 106
    //   64: getstatic 387	com/loc/h:j	Lcom/amap/api/location/AMapLocation;
    //   67: invokestatic 252	com/loc/dn:a	(Lcom/amap/api/location/AMapLocation;)Z
    //   70: ifeq +36 -> 106
    //   73: aload_0
    //   74: getfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   77: invokevirtual 281	com/amap/api/location/AMapLocationClientOption:isMockEnable	()Z
    //   80: ifne +12 -> 92
    //   83: getstatic 387	com/loc/h:j	Lcom/amap/api/location/AMapLocation;
    //   86: invokevirtual 535	com/amap/api/location/AMapLocation:isMock	()Z
    //   89: ifne +17 -> 106
    //   92: aload_0
    //   93: invokestatic 236	com/loc/dn:b	()J
    //   96: putfield 78	com/loc/h:d	J
    //   99: aload_0
    //   100: getstatic 387	com/loc/h:j	Lcom/amap/api/location/AMapLocation;
    //   103: invokespecial 312	com/loc/h:a	(Lcom/amap/api/location/AMapLocation;)V
    //   106: aload_0
    //   107: iconst_1
    //   108: putfield 107	com/loc/h:s	Z
    //   111: invokestatic 589	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   114: astore 6
    //   116: aload 6
    //   118: astore_1
    //   119: aload 6
    //   121: ifnonnull +11 -> 132
    //   124: aload_0
    //   125: getfield 134	com/loc/h:z	Landroid/content/Context;
    //   128: invokevirtual 592	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   131: astore_1
    //   132: aload_0
    //   133: invokestatic 236	com/loc/dn:b	()J
    //   136: putfield 76	com/loc/h:A	J
    //   139: aload_0
    //   140: getfield 148	com/loc/h:b	Landroid/location/LocationManager;
    //   143: invokestatic 594	com/loc/h:a	(Landroid/location/LocationManager;)Z
    //   146: istore_3
    //   147: iload_3
    //   148: ifeq +198 -> 346
    //   151: invokestatic 498	com/loc/dn:a	()J
    //   154: getstatic 66	com/loc/h:q	J
    //   157: lsub
    //   158: ldc2_w 595
    //   161: lcmp
    //   162: iflt +39 -> 201
    //   165: aload_0
    //   166: getfield 148	com/loc/h:b	Landroid/location/LocationManager;
    //   169: ldc -65
    //   171: ldc_w 598
    //   174: aconst_null
    //   175: invokevirtual 602	android/location/LocationManager:sendExtraCommand	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   178: pop
    //   179: invokestatic 498	com/loc/dn:a	()J
    //   182: putstatic 66	com/loc/h:q	J
    //   185: aload_0
    //   186: getfield 134	com/loc/h:z	Landroid/content/Context;
    //   189: ldc_w 574
    //   192: ldc_w 576
    //   195: getstatic 66	com/loc/h:q	J
    //   198: invokestatic 605	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V
    //   201: aload_0
    //   202: getfield 113	com/loc/h:x	Landroid/location/LocationListener;
    //   205: ifnonnull +15 -> 220
    //   208: aload_0
    //   209: new 8	com/loc/h$a
    //   212: dup
    //   213: aload_0
    //   214: invokespecial 606	com/loc/h$a:<init>	(Lcom/loc/h;)V
    //   217: putfield 113	com/loc/h:x	Landroid/location/LocationListener;
    //   220: aload_0
    //   221: getfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   224: invokevirtual 170	com/amap/api/location/AMapLocationClientOption:getLocationMode	()Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   227: getstatic 176	com/amap/api/location/AMapLocationClientOption$AMapLocationMode:Device_Sensors	Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   230: invokevirtual 225	com/amap/api/location/AMapLocationClientOption$AMapLocationMode:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +60 -> 293
    //   236: aload_0
    //   237: getfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   240: invokevirtual 229	com/amap/api/location/AMapLocationClientOption:getDeviceModeDistanceFilter	()F
    //   243: fconst_0
    //   244: fcmpl
    //   245: ifle +48 -> 293
    //   248: aload_0
    //   249: getfield 148	com/loc/h:b	Landroid/location/LocationManager;
    //   252: astore 6
    //   254: aload_0
    //   255: getfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   258: invokevirtual 239	com/amap/api/location/AMapLocationClientOption:getInterval	()J
    //   261: lstore 4
    //   263: aload_0
    //   264: getfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   267: invokevirtual 229	com/amap/api/location/AMapLocationClientOption:getDeviceModeDistanceFilter	()F
    //   270: fstore_2
    //   271: aload_0
    //   272: getfield 113	com/loc/h:x	Landroid/location/LocationListener;
    //   275: astore 7
    //   277: aload 6
    //   279: ldc -65
    //   281: lload 4
    //   283: fload_2
    //   284: aload 7
    //   286: aload_1
    //   287: invokevirtual 610	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   290: goto +25 -> 315
    //   293: aload_0
    //   294: getfield 148	com/loc/h:b	Landroid/location/LocationManager;
    //   297: astore 6
    //   299: ldc2_w 611
    //   302: lstore 4
    //   304: fconst_0
    //   305: fstore_2
    //   306: aload_0
    //   307: getfield 113	com/loc/h:x	Landroid/location/LocationListener;
    //   310: astore 7
    //   312: goto -35 -> 277
    //   315: aload_0
    //   316: getfield 148	com/loc/h:b	Landroid/location/LocationManager;
    //   319: aload_0
    //   320: getfield 122	com/loc/h:E	Landroid/location/GpsStatus$Listener;
    //   323: invokevirtual 616	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   326: pop
    //   327: aload_0
    //   328: bipush 8
    //   330: bipush 14
    //   332: ldc_w 618
    //   335: aload_0
    //   336: getfield 164	com/loc/h:c	Lcom/amap/api/location/AMapLocationClientOption;
    //   339: invokevirtual 621	com/amap/api/location/AMapLocationClientOption:getHttpTimeOut	()J
    //   342: invokespecial 623	com/loc/h:a	(IILjava/lang/String;J)V
    //   345: return
    //   346: aload_0
    //   347: bipush 8
    //   349: bipush 14
    //   351: ldc_w 625
    //   354: lconst_0
    //   355: invokespecial 623	com/loc/h:a	(IILjava/lang/String;J)V
    //   358: return
    //   359: astore_1
    //   360: aload_1
    //   361: ldc -106
    //   363: ldc_w 627
    //   366: invokestatic 156	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   369: return
    //   370: astore_1
    //   371: aload_0
    //   372: iconst_0
    //   373: putfield 107	com/loc/h:s	Z
    //   376: aconst_null
    //   377: sipush 2121
    //   380: invokestatic 284	com/loc/dk:a	(Ljava/lang/String;I)V
    //   383: new 629	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 630	java/lang/StringBuilder:<init>	()V
    //   390: astore 6
    //   392: aload 6
    //   394: aload_1
    //   395: invokevirtual 634	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   398: invokevirtual 638	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 6
    //   404: ldc_w 640
    //   407: invokevirtual 638	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_0
    //   412: iconst_2
    //   413: bipush 12
    //   415: aload 6
    //   417: invokevirtual 643	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: lconst_0
    //   421: invokespecial 623	com/loc/h:a	(IILjava/lang/String;J)V
    //   424: return
    //   425: astore_1
    //   426: goto -384 -> 42
    //   429: astore 6
    //   431: goto -230 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	h
    //   0	434	1	paramAMapLocationClientOption	AMapLocationClientOption
    //   270	36	2	f1	float
    //   146	2	3	bool	boolean
    //   261	42	4	l1	long
    //   114	302	6	localObject	Object
    //   429	1	6	localThrowable	Throwable
    //   275	36	7	localLocationListener	LocationListener
    // Exception table:
    //   from	to	target	type
    //   50	92	359	java/lang/Throwable
    //   92	106	359	java/lang/Throwable
    //   106	116	359	java/lang/Throwable
    //   124	132	359	java/lang/Throwable
    //   132	147	359	java/lang/Throwable
    //   201	220	359	java/lang/Throwable
    //   220	277	359	java/lang/Throwable
    //   277	290	359	java/lang/Throwable
    //   293	299	359	java/lang/Throwable
    //   306	312	359	java/lang/Throwable
    //   315	345	359	java/lang/Throwable
    //   346	358	359	java/lang/Throwable
    //   50	92	370	java/lang/SecurityException
    //   92	106	370	java/lang/SecurityException
    //   106	116	370	java/lang/SecurityException
    //   124	132	370	java/lang/SecurityException
    //   132	147	370	java/lang/SecurityException
    //   151	201	370	java/lang/SecurityException
    //   201	220	370	java/lang/SecurityException
    //   220	277	370	java/lang/SecurityException
    //   277	290	370	java/lang/SecurityException
    //   293	299	370	java/lang/SecurityException
    //   306	312	370	java/lang/SecurityException
    //   315	345	370	java/lang/SecurityException
    //   346	358	370	java/lang/SecurityException
    //   23	42	425	java/lang/Throwable
    //   151	201	429	java/lang/Throwable
  }
  
  public final boolean b()
  {
    return dn.b() - this.d <= 2800L;
  }
  
  @SuppressLint({"NewApi"})
  public final int c()
  {
    if (this.b == null) {
      return 1;
    }
    if (!a(this.b)) {
      return 1;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      if (!this.b.isProviderEnabled("gps")) {
        return 2;
      }
    }
    else
    {
      int i1 = Settings.Secure.getInt(this.z.getContentResolver(), "location_mode", 0);
      if (i1 == 0) {
        return 2;
      }
      if (i1 == 2) {
        return 3;
      }
    }
    if (!this.s) {
      return 4;
    }
    return 0;
  }
  
  public final int d()
  {
    return this.C;
  }
  
  static final class a
    implements LocationListener
  {
    private h a;
    
    a(h paramh)
    {
      this.a = paramh;
    }
    
    final void a()
    {
      this.a = null;
    }
    
    public final void onLocationChanged(Location paramLocation)
    {
      try
      {
        if (this.a != null) {
          h.a(this.a, paramLocation);
        }
        return;
      }
      catch (Throwable paramLocation) {}
    }
    
    public final void onProviderDisabled(String paramString)
    {
      try
      {
        if (this.a != null) {
          h.a(this.a, paramString);
        }
        return;
      }
      catch (Throwable paramString) {}
    }
    
    public final void onProviderEnabled(String paramString) {}
    
    public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      try
      {
        if (this.a != null) {
          h.a(this.a, paramInt);
        }
        return;
      }
      catch (Throwable paramString) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */