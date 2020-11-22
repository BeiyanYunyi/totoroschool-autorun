package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class gk
  extends gg
  implements Thread.UncaughtExceptionHandler
{
  private static ExecutorService e;
  private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
  private static WeakReference<Context> g;
  private static final ThreadFactory h = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pama#");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramAnonymousRunnable, localStringBuilder.toString());
    }
  };
  private Context d;
  private List<a> i;
  
  private gk(Context paramContext, fv paramfv)
  {
    this.d = paramContext;
    f();
  }
  
  public static gk a(Context paramContext, fv paramfv)
    throws fj
  {
    if (paramfv != null) {}
    try
    {
      if (paramfv.a() != null)
      {
        boolean bool = "".equals(paramfv.a());
        if (!bool)
        {
          try
          {
            if (!f.add(Integer.valueOf(paramfv.hashCode())))
            {
              paramContext = (gk)gg.a;
              return paramContext;
            }
            if (gg.a == null) {
              gg.a = new gk(paramContext, paramfv);
            } else {
              gg.a.c = false;
            }
            gg.a.a(paramContext, paramfv, gg.a.c);
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
          }
          paramContext = (gk)gg.a;
          return paramContext;
        }
      }
      throw new fj("sdk name is invalid");
    }
    finally {}
    throw new fj("sdk info is null");
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      g = new WeakReference(paramContext.getApplicationContext());
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, fv paramfv, String paramString1, String paramString2, String paramString3)
  {
    gl.a(paramContext, paramfv, paramString1, 0, paramString2, paramString3);
  }
  
  public static void a(fv paramfv, String paramString, fj paramfj)
  {
    if (paramfj != null) {
      a(paramfv, paramString, paramfj.c(), paramfj.d(), paramfj.e(), paramfj.b());
    }
  }
  
  public static void a(fv paramfv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (gg.a != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("path:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",type:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(",gsid:");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(",csid:");
        localStringBuilder.append(paramString4);
        localStringBuilder.append(",code:");
        localStringBuilder.append(paramString5);
        gg.a.a(paramfv, localStringBuilder.toString(), "networkError");
      }
      return;
    }
    catch (Throwable paramfv) {}
  }
  
  private void a(Thread paramThread, Throwable paramThrowable)
  {
    int j = 0;
    try
    {
      while ((j < this.i.size()) && (j < 10))
      {
        a locala = (a)this.i.get(j);
        if (locala != null) {
          locala.a(paramThread, paramThrowable);
        }
        j += 1;
      }
      return;
    }
    catch (Throwable paramThread) {}
  }
  
  public static gk b(Context paramContext, fv paramfv)
    throws fj
  {
    try
    {
      if (gg.a == null) {
        gg.a = new gk(paramContext, paramfv);
      }
      paramContext = (gk)gg.a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 184	com/amap/api/mapcore/util/gk:e	Ljava/util/concurrent/ExecutorService;
    //   6: ifnull +11 -> 17
    //   9: getstatic 184	com/amap/api/mapcore/util/gk:e	Ljava/util/concurrent/ExecutorService;
    //   12: invokeinterface 189 1 0
    //   17: invokestatic 193	com/amap/api/mapcore/util/hs:a	()V
    //   20: goto +12 -> 32
    //   23: astore_0
    //   24: goto +57 -> 81
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 102	java/lang/Throwable:printStackTrace	()V
    //   32: getstatic 90	com/amap/api/mapcore/util/gg:a	Lcom/amap/api/mapcore/util/gg;
    //   35: ifnull +30 -> 65
    //   38: invokestatic 199	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   41: getstatic 90	com/amap/api/mapcore/util/gg:a	Lcom/amap/api/mapcore/util/gg;
    //   44: if_acmpne +21 -> 65
    //   47: getstatic 90	com/amap/api/mapcore/util/gg:a	Lcom/amap/api/mapcore/util/gg;
    //   50: getfield 202	com/amap/api/mapcore/util/gg:b	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   53: ifnull +12 -> 65
    //   56: getstatic 90	com/amap/api/mapcore/util/gg:a	Lcom/amap/api/mapcore/util/gg;
    //   59: getfield 202	com/amap/api/mapcore/util/gg:b	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   62: invokestatic 206	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   65: aconst_null
    //   66: putstatic 90	com/amap/api/mapcore/util/gg:a	Lcom/amap/api/mapcore/util/gg;
    //   69: goto +8 -> 77
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 102	java/lang/Throwable:printStackTrace	()V
    //   77: ldc 2
    //   79: monitorexit
    //   80: return
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	1	0	localObject	Object
    //   27	2	0	localThrowable1	Throwable
    //   72	13	0	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	17	23	finally
    //   17	20	23	finally
    //   28	32	23	finally
    //   32	65	23	finally
    //   65	69	23	finally
    //   73	77	23	finally
    //   3	17	27	java/lang/Throwable
    //   17	20	27	java/lang/Throwable
    //   32	65	72	java/lang/Throwable
    //   65	69	72	java/lang/Throwable
  }
  
  public static void b(Context paramContext, fv paramfv, String paramString1, String paramString2, String paramString3)
  {
    gl.a(paramContext, paramfv, paramString1, 1, paramString2, paramString3);
  }
  
  public static void b(fv paramfv, String paramString1, String paramString2)
  {
    try
    {
      if (gg.a != null) {
        gg.a.a(paramfv, paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramfv) {}
  }
  
  public static void c()
  {
    if ((g != null) && (g.get() != null))
    {
      gh.a((Context)g.get());
      return;
    }
    if (gg.a != null) {
      gg.a.a();
    }
  }
  
  public static void c(Throwable paramThrowable, String paramString1, String paramString2)
  {
    try
    {
      if (gg.a != null) {
        gg.a.a(paramThrowable, 1, paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramThrowable) {}
  }
  
  public static ExecutorService d()
  {
    try
    {
      try
      {
        if ((e == null) || (e.isShutdown())) {
          e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
        }
      }
      finally
      {
        break label65;
      }
    }
    catch (Throwable localThrowable)
    {
      ExecutorService localExecutorService;
      label65:
      for (;;) {}
    }
    localExecutorService = e;
    return localExecutorService;
    throw localExecutorService;
  }
  
  public static gk e()
  {
    try
    {
      gk localgk = (gk)gg.a;
      return localgk;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void f()
  {
    try
    {
      this.b = Thread.getDefaultUncaughtExceptionHandler();
      if (this.b == null)
      {
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.c = true;
        return;
      }
      String str = this.b.toString();
      if ((!str.startsWith("com.amap.apis.utils.core.dynamiccore")) && ((str.indexOf("com.amap.api") != -1) || (str.indexOf("com.loc") != -1)))
      {
        this.c = false;
        return;
      }
      Thread.setDefaultUncaughtExceptionHandler(this);
      this.c = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void a()
  {
    gh.a(this.d);
  }
  
  protected void a(final Context paramContext, final fv paramfv, final boolean paramBoolean)
  {
    try
    {
      ExecutorService localExecutorService = d();
      if (localExecutorService != null)
      {
        if (localExecutorService.isShutdown()) {
          return;
        }
        localExecutorService.submit(new Runnable()
        {
          public void run()
          {
            try
            {
              synchronized ()
              {
                new gt(paramContext, true).a(paramfv);
                if (paramBoolean)
                {
                  gl.a(gk.a(gk.this));
                  return;
                }
              }
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        });
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (RejectedExecutionException paramContext) {}
  }
  
  protected void a(fv paramfv, String paramString1, String paramString2)
  {
    gl.a(paramfv, this.d, paramString2, paramString1);
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(parama);
  }
  
  protected void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2)
  {
    gl.a(this.d, paramThrowable, paramInt, paramString1, paramString2);
  }
  
  public void b(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if (paramThrowable == null) {
      return;
    }
    try
    {
      a(paramThrowable, 1, paramString1, paramString2);
      return;
    }
    catch (Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThread, paramThrowable);
    if (paramThrowable == null) {
      return;
    }
    a(paramThrowable, 0, null, null);
    if (this.b != null) {}
    try
    {
      Thread.setDefaultUncaughtExceptionHandler(this.b);
      this.b.uncaughtException(paramThread, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Thread paramThread, Throwable paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */