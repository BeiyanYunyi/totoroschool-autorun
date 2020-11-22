package com.amap.api.mapcore.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class dw
{
  private static volatile dw c;
  private BlockingQueue<Runnable> a = new LinkedBlockingQueue();
  private ExecutorService b = null;
  
  private dw()
  {
    int i = Runtime.getRuntime().availableProcessors();
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    this.b = new ThreadPoolExecutor(i, i * 2, 1, localTimeUnit, this.a, new dk("AMapThreadUtil"), new ThreadPoolExecutor.AbortPolicy());
  }
  
  public static dw a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new dw();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static void b()
  {
    if (c != null)
    {
      try
      {
        c.b.shutdownNow();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      c.b = null;
      c = null;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.b != null) {
      try
      {
        this.b.execute(paramRunnable);
        return;
      }
      catch (Throwable paramRunnable)
      {
        paramRunnable.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */