package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class bt
{
  static int a = 1000;
  static boolean b = false;
  static int c = 20;
  private static WeakReference<bp> d;
  private static int e = 10;
  
  public static void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    for (;;)
    {
      try
      {
        a = paramInt1;
        b = paramBoolean;
        if (paramInt2 >= 10)
        {
          paramInt1 = paramInt2;
          if (paramInt2 <= 100)
          {
            c = paramInt1;
            if (paramInt1 / 5 > e) {
              e = c / 5;
            }
            return;
          }
        }
      }
      finally {}
      paramInt1 = 20;
    }
  }
  
  public static void a(Context paramContext)
  {
    aj.d().submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          bp localbp = bw.a(bt.a());
          bw.a(this.a, localbp, ah.i, bt.a, 2097152, "6");
          localbp.h = 14400000;
          if (localbp.g == null)
          {
            z localz = new z(new ab(new ad()));
            localbp.g = new ca(new bz(this.a, new ce(), localz, new String(x.a(10)), new Object[] { l.f(this.a), p.w(this.a), p.n(this.a), p.i(this.a), p.a(), Build.MANUFACTURER, Build.DEVICE, p.z(this.a), l.c(this.a), Build.MODEL, l.d(this.a), l.b(this.a) }));
          }
          if (TextUtils.isEmpty(localbp.i)) {
            localbp.i = "fKey";
          }
          localbp.f = new ci(this.a, localbp.h, localbp.i, new cg(this.a, bt.b, bt.b() * 1024, bt.c * 1024, "offLocKey"));
          bq.a(localbp);
          return;
        }
        catch (Throwable localThrowable)
        {
          aj.b(localThrowable, "ofm", "uold");
        }
      }
    });
  }
  
  public static void a(final bs parambs, Context paramContext)
  {
    try
    {
      aj.d().submit(new Runnable()
      {
        public final void run()
        {
          try
          {
            try
            {
              String str = Long.toString(System.currentTimeMillis());
              bp localbp = bw.a(bt.a());
              bw.a(this.a, localbp, ah.i, bt.a, 2097152, "6");
              if (localbp.e == null) {
                localbp.e = new z(new ab(new ad(new ab())));
              }
              bq.a(str, parambs.a(), localbp);
              return;
            }
            finally {}
            return;
          }
          catch (Throwable localThrowable)
          {
            aj.b(localThrowable, "ofm", "aple");
          }
        }
      });
      return;
    }
    finally
    {
      parambs = finally;
      throw parambs;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */