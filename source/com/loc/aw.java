package com.loc;

import android.content.Context;
import android.text.TextUtils;

public final class aw
  implements Thread.UncaughtExceptionHandler
{
  private static aw a;
  private Thread.UncaughtExceptionHandler b;
  private Context c;
  private v d;
  
  private aw(Context paramContext, v paramv)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramv;
    this.b = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  static aw a(Context paramContext, v paramv)
  {
    try
    {
      if (a == null) {
        a = new aw(paramContext, paramv);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject1 = w.a(paramThrowable);
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2;
        if (((((String)localObject1).contains("amapdynamic")) || (((String)localObject1).contains("admic"))) && (((String)localObject1).contains("com.amap.api")))
        {
          localObject2 = new an(this.c, ax.b());
          if (((String)localObject1).contains("loc")) {
            av.a((an)localObject2, this.c, "loc");
          }
          if (((String)localObject1).contains("navi")) {
            av.a((an)localObject2, this.c, "navi");
          }
          if (((String)localObject1).contains("sea")) {
            av.a((an)localObject2, this.c, "sea");
          }
          if (((String)localObject1).contains("2dmap")) {
            av.a((an)localObject2, this.c, "2dmap");
          }
          if (((String)localObject1).contains("3dmap")) {
            av.a((an)localObject2, this.c, "3dmap");
          }
        }
        else
        {
          String str;
          if (((String)localObject1).contains("com.autonavi.aps.amapapi.offline"))
          {
            localObject1 = new an(this.c, ax.b());
            localObject2 = this.c;
            str = "OfflineLocation";
          }
          for (;;)
          {
            av.a((an)localObject1, (Context)localObject2, str);
            break;
            if (((String)localObject1).contains("com.data.carrier_v4"))
            {
              localObject1 = new an(this.c, ax.b());
              localObject2 = this.c;
              str = "Collection";
            }
            else if ((!((String)localObject1).contains("com.autonavi.aps.amapapi.httpdns")) && (!((String)localObject1).contains("com.autonavi.httpdns")))
            {
              if (((String)localObject1).contains("com.amap.api.aiunet"))
              {
                localObject1 = new an(this.c, ax.b());
                localObject2 = this.c;
                str = "aiu";
              }
              else
              {
                if ((!((String)localObject1).contains("com.amap.co")) && (!((String)localObject1).contains("com.amap.opensdk.co")) && (!((String)localObject1).contains("com.amap.location"))) {
                  break;
                }
                localObject1 = new an(this.c, ax.b());
                localObject2 = this.c;
                str = "co";
              }
            }
            else
            {
              localObject1 = new an(this.c, ax.b());
              localObject2 = this.c;
              str = "HttpDNS";
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ag.a(localThrowable, "DynamicExceptionHandler", "uncaughtException");
      if (this.b != null) {
        this.b.uncaughtException(paramThread, paramThrowable);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */