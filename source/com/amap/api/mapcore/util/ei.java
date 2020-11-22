package com.amap.api.mapcore.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

public class ei
{
  Context a;
  Inner_3dMap_locationManagerBase b = null;
  Object c = null;
  boolean d = false;
  kl e = null;
  fv f = null;
  
  public ei(Context paramContext)
  {
    try
    {
      this.f = ku.a();
      this.e = new kl();
      a(paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        this.a = paramContext.getApplicationContext();
      }
      catch (Throwable paramContext)
      {
        Class localClass;
        lf.a(paramContext, "AMapLocationClient", "AMapLocationClient 1");
        return;
      }
      try
      {
        localClass = Class.forName("com.amap.api.location.AMapLocationClient");
        paramContext = new ComponentName(this.a, "com.amap.api.location.APSService");
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      try
      {
        paramContext = this.a.getPackageManager().getServiceInfo(paramContext, 128);
      }
      catch (Throwable paramContext) {}
    }
    paramContext = null;
    if ((localClass != null) && (paramContext != null))
    {
      this.d = true;
      break label73;
      this.d = false;
    }
    label73:
    if (this.d)
    {
      this.c = new AMapLocationClient(this.a);
      return;
    }
    this.b = b(this.a);
    return;
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private Inner_3dMap_locationManagerBase b(Context paramContext)
  {
    try
    {
      localObject1 = (Inner_3dMap_locationManagerBase)ha.a(paramContext, this.f, fw.c("YY29tLmFtYXAuYXBpLndyYXBwZXIuSW5uZXJfM2RNYXBfbG9jYXRpb25NYW5hZ2VyV3JhcHBlcg=="), ko.class, new Class[] { Context.class }, new Object[] { paramContext });
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = new ko(paramContext);
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ko(paramContext);
    }
    return (Inner_3dMap_locationManagerBase)localObject2;
  }
  
  public void a()
  {
    try
    {
      if (this.d)
      {
        ((AMapLocationClient)this.c).startLocation();
        return;
      }
      this.b.startLocation();
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "AMapLocationClient", "startLocation");
    }
  }
  
  public void a(Inner_3dMap_locationListener paramInner_3dMap_locationListener)
  {
    if (paramInner_3dMap_locationListener != null) {}
    try
    {
      if (this.d)
      {
        this.e.a(this.c, paramInner_3dMap_locationListener);
        return;
      }
      this.b.setLocationListener(paramInner_3dMap_locationListener);
      return;
    }
    catch (Throwable paramInner_3dMap_locationListener)
    {
      lf.a(paramInner_3dMap_locationListener, "AMapLocationClient", "setLocationListener");
    }
    throw new IllegalArgumentException("listener参数不能为null");
  }
  
  public void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    if (paramInner_3dMap_locationOption != null) {}
    try
    {
      if (this.d)
      {
        kl localkl = this.e;
        kl.a(this.c, paramInner_3dMap_locationOption);
        return;
      }
      this.b.setLocationOption(paramInner_3dMap_locationOption);
      return;
    }
    catch (Throwable paramInner_3dMap_locationOption)
    {
      lf.a(paramInner_3dMap_locationOption, "AMapLocationClient", "setLocationOption");
    }
    throw new IllegalArgumentException("LocationManagerOption参数不能为null");
  }
  
  public void b()
  {
    try
    {
      if (this.d)
      {
        ((AMapLocationClient)this.c).stopLocation();
        return;
      }
      this.b.stopLocation();
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "AMapLocationClient", "stopLocation");
    }
  }
  
  public void c()
  {
    try
    {
      if (this.d) {
        ((AMapLocationClient)this.c).onDestroy();
      } else {
        this.b.destroy();
      }
      if (this.e != null) {
        this.e = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "AMapLocationClient", "onDestroy");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */