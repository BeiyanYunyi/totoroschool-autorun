package com.amap.api.mapcore.util;

import java.util.concurrent.ExecutorService;

public final class ke
{
  public static ke a()
  {
    return a.a;
  }
  
  public static void a(String paramString)
  {
    try
    {
      ho.c(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      ho.a(paramString, "cf");
    }
  }
  
  public final void b(final String paramString)
  {
    hb.b().a().submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          ho.c(paramString);
          return;
        }
        catch (Throwable localThrowable)
        {
          ho.a(localThrowable, "cfa");
        }
      }
    });
  }
  
  public final void c(final String paramString)
  {
    hb.b().a().submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          ho.b(paramString);
          return;
        }
        catch (Throwable localThrowable)
        {
          ho.a(localThrowable, "cda");
        }
      }
    });
  }
  
  static final class a
  {
    public static ke a = new ke();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */