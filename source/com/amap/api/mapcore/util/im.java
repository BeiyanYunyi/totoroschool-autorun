package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class im
{
  static int a = 1000;
  static boolean b = false;
  static int c = 20;
  private static WeakReference<ih> d;
  private static int e = 10;
  
  @Deprecated
  public static void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      a = paramInt;
      b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(Context paramContext)
  {
    gk.d().submit(new Runnable()
    {
      public void run()
      {
        try
        {
          ih localih = ip.a(im.a());
          ip.a(this.a, localih, gh.h, im.a, 2097152, "6");
          localih.h = 14400000;
          if (localih.g == null)
          {
            fz localfz = new fz(new gb(new gd()));
            localih.g = new it(new is(this.a, new ix(), localfz, new String(ge.a(10)), new Object[] { fk.f(this.a), fp.w(this.a), fp.n(this.a), fp.i(this.a), fp.a(), Build.MANUFACTURER, Build.DEVICE, fp.y(this.a), fk.c(this.a), Build.MODEL, fk.d(this.a), fk.b(this.a) }));
          }
          if (TextUtils.isEmpty(localih.i)) {
            localih.i = "fKey";
          }
          localih.f = new jb(this.a, localih.h, localih.i, new iz(this.a, im.b, im.b() * 1024, im.c * 1024));
          ii.a(localih);
          return;
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "ofm", "uold");
        }
      }
    });
  }
  
  public static void a(final il paramil, Context paramContext)
  {
    try
    {
      gk.d().submit(new Runnable()
      {
        public void run()
        {
          try
          {
            try
            {
              String str = Long.toString(System.currentTimeMillis());
              ih localih = ip.a(im.a());
              ip.a(this.a, localih, gh.h, im.a, 2097152, "6");
              if (localih.e == null) {
                localih.e = new fz(new gb(new gd(new gb())));
              }
              ii.a(str, paramil.a(), localih);
              return;
            }
            finally {}
            return;
          }
          catch (Throwable localThrowable)
          {
            gk.c(localThrowable, "ofm", "aple");
          }
        }
      });
      return;
    }
    finally
    {
      paramil = finally;
      throw paramil;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\im.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */