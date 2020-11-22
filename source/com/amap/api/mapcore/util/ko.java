package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode;
import java.util.ArrayList;
import java.util.Iterator;

public class ko
  implements Inner_3dMap_locationManagerBase
{
  Context a = null;
  ArrayList<Inner_3dMap_locationListener> b = new ArrayList();
  Object c = new Object();
  Handler d = null;
  a e = null;
  Handler f = null;
  Inner_3dMap_locationOption g = new Inner_3dMap_locationOption();
  kr h = null;
  Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode i = Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
  boolean j = false;
  
  public ko(Context paramContext)
  {
    if (paramContext != null)
    {
      this.a = paramContext.getApplicationContext();
      e();
      return;
    }
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private Handler a(Looper paramLooper)
  {
    synchronized (this.c)
    {
      this.f = new kp(paramLooper, this);
      paramLooper = this.f;
      return paramLooper;
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.c)
    {
      if (this.f != null) {
        this.f.removeMessages(paramInt);
      }
      return;
    }
  }
  
  private void a(int paramInt, Object paramObject, long paramLong)
  {
    synchronized (this.c)
    {
      if (this.f != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = paramInt;
        localMessage.obj = paramObject;
        this.f.sendMessageDelayed(localMessage, paramLong);
      }
      return;
    }
  }
  
  private void e()
  {
    try
    {
      if (Looper.myLooper() == null) {}
      for (kq localkq = new kq(this.a.getMainLooper(), this);; localkq = new kq(this))
      {
        this.d = localkq;
        break;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      lf.a(localThrowable1, "MapLocationManager", "initResultHandler");
      try
      {
        this.e = new a("locaitonClientActionThread", this);
        this.e.setPriority(5);
        this.e.start();
        this.f = a(this.e.getLooper());
        return;
      }
      catch (Throwable localThrowable2)
      {
        lf.a(localThrowable2, "MapLocationManager", "initActionThreadAndActionHandler");
      }
    }
  }
  
  private void f()
  {
    synchronized (this.c)
    {
      if (this.f != null) {
        this.f.removeCallbacksAndMessages(null);
      }
      this.f = null;
      return;
    }
  }
  
  final void a()
  {
    try
    {
      if (this.j) {
        return;
      }
      this.j = true;
      a(1005, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapLocationManager", "doStartLocation");
    }
  }
  
  final void a(Inner_3dMap_location paramInner_3dMap_location)
  {
    if (paramInner_3dMap_location != null) {}
    for (;;)
    {
      try
      {
        if (ku.a(paramInner_3dMap_location)) {
          kl.a = paramInner_3dMap_location;
        }
        if (this.j)
        {
          if (!"gps".equalsIgnoreCase(paramInner_3dMap_location.getProvider())) {
            paramInner_3dMap_location.setProvider("lbs");
          }
          paramInner_3dMap_location.setAltitude(lj.b(paramInner_3dMap_location.getAltitude()));
          paramInner_3dMap_location.setBearing(lj.a(paramInner_3dMap_location.getBearing()));
          paramInner_3dMap_location.setSpeed(lj.a(paramInner_3dMap_location.getSpeed()));
          Iterator localIterator = this.b.iterator();
          if (localIterator.hasNext()) {
            localInner_3dMap_locationListener = (Inner_3dMap_locationListener)localIterator.next();
          }
        }
      }
      catch (Throwable paramInner_3dMap_location)
      {
        Inner_3dMap_locationListener localInner_3dMap_locationListener;
        continue;
      }
      try
      {
        localInner_3dMap_locationListener.onLocationChanged(paramInner_3dMap_location);
      }
      catch (Throwable localThrowable) {}
      if (this.g.isOnceLocation()) {
        c();
      }
      return;
      lf.a(paramInner_3dMap_location, "MapLocationManager", "callBackLocation");
      return;
    }
  }
  
  final void a(Inner_3dMap_locationListener paramInner_3dMap_locationListener)
  {
    if (paramInner_3dMap_locationListener != null) {}
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (this.b.contains(paramInner_3dMap_locationListener)) {
        return;
      }
      this.b.add(paramInner_3dMap_locationListener);
      return;
    }
    catch (Throwable paramInner_3dMap_locationListener)
    {
      lf.a(paramInner_3dMap_locationListener, "MapLocationManager", "doSetLocationListener");
      return;
    }
    throw new IllegalArgumentException("listener参数不能为null");
  }
  
  final void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    this.g = paramInner_3dMap_locationOption;
    if (this.g == null) {
      this.g = new Inner_3dMap_locationOption();
    }
    if (this.h != null) {
      this.h.a(this.g);
    }
    if ((this.j) && (!this.i.equals(paramInner_3dMap_locationOption.getLocationMode())))
    {
      c();
      a();
    }
    this.i = this.g.getLocationMode();
  }
  
  /* Error */
  final void b()
  {
    // Byte code:
    //   0: ldc2_w 275
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 55	com/amap/api/mapcore/util/ko:h	Lcom/amap/api/mapcore/util/kr;
    //   8: ifnull +10 -> 18
    //   11: aload_0
    //   12: getfield 55	com/amap/api/mapcore/util/ko:h	Lcom/amap/api/mapcore/util/kr;
    //   15: invokevirtual 277	com/amap/api/mapcore/util/kr:a	()V
    //   18: aload_0
    //   19: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   22: invokevirtual 244	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:isOnceLocation	()Z
    //   25: ifne +96 -> 121
    //   28: aload_0
    //   29: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   32: invokevirtual 281	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:getInterval	()J
    //   35: ldc2_w 275
    //   38: lcmp
    //   39: ifge +6 -> 45
    //   42: goto +11 -> 53
    //   45: aload_0
    //   46: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   49: invokevirtual 281	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:getInterval	()J
    //   52: lstore_1
    //   53: aload_0
    //   54: sipush 1005
    //   57: aconst_null
    //   58: lload_1
    //   59: invokespecial 160	com/amap/api/mapcore/util/ko:a	(ILjava/lang/Object;J)V
    //   62: return
    //   63: astore_3
    //   64: goto +58 -> 122
    //   67: astore_3
    //   68: aload_3
    //   69: ldc -127
    //   71: ldc_w 283
    //   74: invokestatic 136	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   81: invokevirtual 244	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:isOnceLocation	()Z
    //   84: ifne +37 -> 121
    //   87: aload_0
    //   88: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   91: invokevirtual 281	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:getInterval	()J
    //   94: ldc2_w 275
    //   97: lcmp
    //   98: ifge +6 -> 104
    //   101: goto +11 -> 112
    //   104: aload_0
    //   105: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   108: invokevirtual 281	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:getInterval	()J
    //   111: lstore_1
    //   112: aload_0
    //   113: sipush 1005
    //   116: aconst_null
    //   117: lload_1
    //   118: invokespecial 160	com/amap/api/mapcore/util/ko:a	(ILjava/lang/Object;J)V
    //   121: return
    //   122: aload_0
    //   123: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   126: invokevirtual 244	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:isOnceLocation	()Z
    //   129: ifne +37 -> 166
    //   132: aload_0
    //   133: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   136: invokevirtual 281	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:getInterval	()J
    //   139: ldc2_w 275
    //   142: lcmp
    //   143: ifge +6 -> 149
    //   146: goto +11 -> 157
    //   149: aload_0
    //   150: getfield 53	com/amap/api/mapcore/util/ko:g	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   153: invokevirtual 281	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:getInterval	()J
    //   156: lstore_1
    //   157: aload_0
    //   158: sipush 1005
    //   161: aconst_null
    //   162: lload_1
    //   163: invokespecial 160	com/amap/api/mapcore/util/ko:a	(ILjava/lang/Object;J)V
    //   166: aload_3
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	ko
    //   3	160	1	l	long
    //   63	1	3	localObject	Object
    //   67	100	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   4	18	63	finally
    //   68	77	63	finally
    //   4	18	67	java/lang/Throwable
  }
  
  final void b(Inner_3dMap_locationListener paramInner_3dMap_locationListener)
  {
    if (paramInner_3dMap_locationListener != null) {}
    try
    {
      if ((!this.b.isEmpty()) && (this.b.contains(paramInner_3dMap_locationListener))) {
        this.b.remove(paramInner_3dMap_locationListener);
      }
      if (this.b.isEmpty()) {
        c();
      }
      return;
    }
    catch (Throwable paramInner_3dMap_locationListener)
    {
      for (;;) {}
    }
    lf.a(paramInner_3dMap_locationListener, "MapLocationManager", "doUnregisterListener");
  }
  
  final void c()
  {
    try
    {
      this.j = false;
      a(1004);
      a(1005);
      if (this.h != null) {
        this.h.c();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapLocationManager", "doStopLocation");
    }
  }
  
  final void d()
  {
    c();
    if (this.h != null) {
      this.h.d();
    }
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    f();
    if ((this.e == null) || (Build.VERSION.SDK_INT >= 18)) {}
    try
    {
      lh.a(this.e, HandlerThread.class, "quitSafely", new Object[0]);
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    this.e.quit();
    this.e = null;
    if (this.d != null)
    {
      this.d.removeCallbacksAndMessages(null);
      this.d = null;
    }
  }
  
  public void destroy()
  {
    try
    {
      a(1007, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapLocationManager", "stopLocation");
    }
  }
  
  public Inner_3dMap_location getLastKnownLocation()
  {
    return kl.a;
  }
  
  public void setLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener)
  {
    try
    {
      a(1002, paramInner_3dMap_locationListener, 0L);
      return;
    }
    catch (Throwable paramInner_3dMap_locationListener)
    {
      lf.a(paramInner_3dMap_locationListener, "MapLocationManager", "setLocationListener");
    }
  }
  
  public void setLocationOption(Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    try
    {
      a(1001, paramInner_3dMap_locationOption, 0L);
      return;
    }
    catch (Throwable paramInner_3dMap_locationOption)
    {
      lf.a(paramInner_3dMap_locationOption, "LocationClientManager", "setLocationOption");
    }
  }
  
  public void startLocation()
  {
    try
    {
      a(1004, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapLocationManager", "startLocation");
    }
  }
  
  public void stopLocation()
  {
    try
    {
      a(1006, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapLocationManager", "stopLocation");
    }
  }
  
  public void unRegisterLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener)
  {
    try
    {
      a(1003, paramInner_3dMap_locationListener, 0L);
      return;
    }
    catch (Throwable paramInner_3dMap_locationListener)
    {
      lf.a(paramInner_3dMap_locationListener, "MapLocationManager", "stopLocation");
    }
  }
  
  static final class a
    extends HandlerThread
  {
    ko a;
    
    public a(String paramString, ko paramko)
    {
      super();
      this.a = paramko;
    }
    
    protected final void onLooperPrepared()
    {
      try
      {
        this.a.h = new kr(this.a.a, this.a.d);
        super.onLooperPrepared();
        return;
      }
      catch (Throwable localThrowable) {}
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */