package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode;
import org.json.JSONArray;
import org.json.JSONObject;

public final class kr
{
  private static int m = 200;
  private static boolean n = true;
  Context a = null;
  kk b = null;
  ks c = null;
  b d = null;
  Handler e = null;
  Handler f = null;
  boolean g = false;
  boolean h = false;
  Inner_3dMap_locationOption i = null;
  final int j = 500;
  final int k = 30;
  Object l = new Object();
  private JSONArray o = null;
  
  public kr(Context paramContext, Handler paramHandler)
  {
    if (paramContext != null) {}
    try
    {
      this.a = paramContext.getApplicationContext();
      this.f = paramHandler;
      this.i = new Inner_3dMap_locationOption();
      f();
      e();
      return;
    }
    catch (Throwable paramContext)
    {
      lf.a(paramContext, "LocationService", "<init>");
    }
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private void a(Inner_3dMap_location paramInner_3dMap_location)
  {
    do
    {
      try
      {
        if (n) {
          continue;
        }
        return;
      }
      catch (Throwable paramInner_3dMap_location)
      {
        JSONObject localJSONObject;
        lf.a(paramInner_3dMap_location, "LocationService", "recordOfflineLocLog");
        return;
      }
      if (paramInner_3dMap_location.getErrorCode() == 0)
      {
        if (paramInner_3dMap_location.getLocationType() != 1) {
          return;
        }
        if (this.o == null) {
          this.o = new JSONArray();
        }
        localJSONObject = new JSONObject();
        localJSONObject.put("lon", paramInner_3dMap_location.getLongitude());
        localJSONObject.put("lat", paramInner_3dMap_location.getLatitude());
        localJSONObject.put("type", 0);
        localJSONObject.put("timestamp", lj.a());
        this.o = this.o.put(localJSONObject);
        if (this.o.length() >= m) {
          h();
        }
      }
      return;
    } while (paramInner_3dMap_location != null);
  }
  
  private void e()
  {
    this.d = new b("locServiceAction");
    this.d.setPriority(5);
    this.d.start();
    this.e = new a(this.d.getLooper());
  }
  
  private void f()
  {
    try
    {
      if (this.i == null) {
        this.i = new Inner_3dMap_locationOption();
      }
      if (this.h) {
        return;
      }
      this.b = new kk(this.a);
      this.c = new ks(this.a);
      this.c.a(this.i);
      g();
      this.h = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "LocationService", "init");
    }
  }
  
  private void g()
  {
    try
    {
      n = li.b(this.a, "maploc", "ue");
      int i1 = li.a(this.a, "maploc", "opn");
      m = i1;
      if (i1 > 500) {
        m = 500;
      }
      if (m < 30) {
        m = 30;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "LocationService", "getSPConfig");
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/amap/api/mapcore/util/kr:o	Lorg/json/JSONArray;
    //   6: ifnull +48 -> 54
    //   9: aload_0
    //   10: getfield 68	com/amap/api/mapcore/util/kr:o	Lorg/json/JSONArray;
    //   13: invokevirtual 152	org/json/JSONArray:length	()I
    //   16: ifle +38 -> 54
    //   19: invokestatic 209	com/amap/api/mapcore/util/lf:b	()Lcom/amap/api/mapcore/util/fv;
    //   22: astore_1
    //   23: new 211	com/amap/api/mapcore/util/il
    //   26: dup
    //   27: aload_0
    //   28: getfield 46	com/amap/api/mapcore/util/kr:a	Landroid/content/Context;
    //   31: aload_1
    //   32: aload_0
    //   33: getfield 68	com/amap/api/mapcore/util/kr:o	Lorg/json/JSONArray;
    //   36: invokevirtual 215	org/json/JSONArray:toString	()Ljava/lang/String;
    //   39: invokespecial 218	com/amap/api/mapcore/util/il:<init>	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 46	com/amap/api/mapcore/util/kr:a	Landroid/content/Context;
    //   46: invokestatic 223	com/amap/api/mapcore/util/im:a	(Lcom/amap/api/mapcore/util/il;Landroid/content/Context;)V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 68	com/amap/api/mapcore/util/kr:o	Lorg/json/JSONArray;
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: goto +15 -> 73
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 92
    //   65: ldc -31
    //   67: invokestatic 98	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	kr
    //   22	10	1	localfv	fv
    //   57	1	1	localObject	Object
    //   61	15	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	54	57	finally
    //   62	70	57	finally
    //   2	54	61	java/lang/Throwable
  }
  
  private void i()
  {
    synchronized (this.l)
    {
      if (this.e != null) {
        this.e.removeCallbacksAndMessages(null);
      }
      this.e = null;
      return;
    }
  }
  
  private void j()
  {
    synchronized (this.l)
    {
      if (this.e != null) {
        this.e.removeMessages(1);
      }
      return;
    }
  }
  
  public final void a()
  {
    try
    {
      f();
      if ((!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving)) && (!this.g))
      {
        this.g = true;
        this.b.a();
      }
      if (this.e != null) {
        this.e.sendEmptyMessage(1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "LocationService", "getLocation");
    }
  }
  
  public final void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    this.i = paramInner_3dMap_locationOption;
    if (this.i == null) {
      this.i = new Inner_3dMap_locationOption();
    }
    if (this.c != null) {
      this.c.a(paramInner_3dMap_locationOption);
    }
  }
  
  final void b()
  {
    Inner_3dMap_location localInner_3dMap_location = null;
    try
    {
      if ((this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving)) && (this.g))
      {
        this.b.b();
        this.g = false;
      }
      if (this.b.c()) {
        localInner_3dMap_location = this.b.d();
      } else if (!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors)) {
        localInner_3dMap_location = this.c.a();
      }
      if ((this.f != null) && (localInner_3dMap_location != null))
      {
        Message localMessage = Message.obtain();
        localMessage.obj = localInner_3dMap_location;
        localMessage.what = 1;
        this.f.sendMessage(localMessage);
      }
      a(localInner_3dMap_location);
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "LocationService", "doGetLocation");
    }
  }
  
  public final void c()
  {
    this.g = false;
    try
    {
      j();
      if (this.b != null) {
        this.b.b();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "LocationService", "stopLocation");
    }
  }
  
  public final void d()
  {
    for (;;)
    {
      try
      {
        c();
        i();
        if (this.d != null)
        {
          int i1 = Build.VERSION.SDK_INT;
          if (i1 < 18) {}
        }
      }
      catch (Throwable localThrowable1)
      {
        b localb;
        lf.a(localThrowable1, "LocationService", "destroy");
        return;
      }
      try
      {
        lh.a(this.d, HandlerThread.class, "quitSafely", new Object[0]);
      }
      catch (Throwable localThrowable2) {}
    }
    for (localb = this.d;; localb = this.d)
    {
      localb.quit();
      break;
    }
    this.d = null;
    this.c.b();
    this.g = false;
    this.h = false;
    h();
  }
  
  public final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
        return;
      }
      kr.this.b();
    }
  }
  
  static final class b
    extends HandlerThread
  {
    public b(String paramString)
    {
      super();
    }
    
    protected final void onLooperPrepared()
    {
      super.onLooperPrepared();
    }
    
    public final void run()
    {
      try
      {
        super.run();
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */