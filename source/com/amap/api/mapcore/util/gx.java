package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public class gx
  implements Thread.UncaughtExceptionHandler
{
  private static gx a;
  private Thread.UncaughtExceptionHandler b;
  private Context c;
  private fv d;
  
  private gx(Context paramContext, fv paramfv)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramfv;
    this.b = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  static gx a(Context paramContext, fv paramfv)
  {
    try
    {
      if (a == null) {
        a = new gx(paramContext, paramfv);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  void a(Throwable paramThrowable)
  {
    paramThrowable = fw.a(paramThrowable);
    try
    {
      if (!TextUtils.isEmpty(paramThrowable)) {
        if (((paramThrowable.contains("amapdynamic")) || (paramThrowable.contains("admic"))) && (paramThrowable.contains("com.amap.api")))
        {
          go localgo = new go(this.c, gy.a());
          if (paramThrowable.contains("loc")) {
            gw.a(localgo, this.c, "loc");
          }
          if (paramThrowable.contains("navi")) {
            gw.a(localgo, this.c, "navi");
          }
          if (paramThrowable.contains("sea")) {
            gw.a(localgo, this.c, "sea");
          }
          if (paramThrowable.contains("2dmap")) {
            gw.a(localgo, this.c, "2dmap");
          }
          if (paramThrowable.contains("3dmap")) {
            gw.a(localgo, this.c, "3dmap");
          }
        }
        else
        {
          if (paramThrowable.contains("com.autonavi.aps.amapapi.offline"))
          {
            gw.a(new go(this.c, gy.a()), this.c, "OfflineLocation");
            return;
          }
          if (paramThrowable.contains("com.data.carrier_v4"))
          {
            gw.a(new go(this.c, gy.a()), this.c, "Collection");
            return;
          }
          if ((!paramThrowable.contains("com.autonavi.aps.amapapi.httpdns")) && (!paramThrowable.contains("com.autonavi.httpdns")))
          {
            if (paramThrowable.contains("com.amap.api.aiunet"))
            {
              gw.a(new go(this.c, gy.a()), this.c, "aiu");
              return;
            }
            if ((paramThrowable.contains("com.amap.co")) || (paramThrowable.contains("com.amap.opensdk.co")) || (paramThrowable.contains("com.amap.location"))) {
              gw.a(new go(this.c, gy.a()), this.c, "co");
            }
          }
          else
          {
            gw.a(new go(this.c, gy.a()), this.c, "HttpDNS");
            return;
          }
        }
      }
    }
    catch (Throwable paramThrowable)
    {
      gg.a(paramThrowable, "DynamicExceptionHandler", "uncaughtException");
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThrowable);
    if (this.b != null) {
      this.b.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */