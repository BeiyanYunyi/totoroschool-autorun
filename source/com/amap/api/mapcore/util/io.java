package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class io
{
  private static WeakReference<ih> a;
  
  public static void a(Context paramContext)
  {
    gk.d().submit(new Runnable()
    {
      public void run()
      {
        try
        {
          ih localih = ip.a(io.a());
          ip.a(this.a, localih, gh.g, 1000, 307200, "2");
          if (localih.g == null) {
            localih.g = new iq(new iu(this.a, new ir(new iv(new ix()))));
          }
          localih.h = 3600000;
          if (TextUtils.isEmpty(localih.i)) {
            localih.i = "cKey";
          }
          if (localih.f == null) {
            localih.f = new jb(this.a, localih.h, localih.i, new iy(30, localih.a, new jd(this.a, false)));
          }
          ii.a(localih);
          return;
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "stm", "usd");
        }
      }
    });
  }
  
  public static void a(final in paramin, Context paramContext)
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
              io.a(this.a, paramin.a());
              return;
            }
            finally {}
            return;
          }
          catch (Throwable localThrowable)
          {
            gk.c(localThrowable, "stm", "as");
          }
        }
      });
      return;
    }
    finally
    {
      paramin = finally;
      throw paramin;
    }
  }
  
  private static void b(Context paramContext, byte[] paramArrayOfByte)
    throws IOException
  {
    ih localih = ip.a(a);
    ip.a(paramContext, localih, gh.g, 1000, 307200, "2");
    if (localih.e == null) {
      localih.e = new gc();
    }
    paramContext = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(paramContext.nextInt(100)));
    localStringBuilder.append(Long.toString(System.nanoTime()));
    paramContext = localStringBuilder.toString();
    try
    {
      ii.a(paramContext, paramArrayOfByte, localih);
      return;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "stm", "wts");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\io.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */