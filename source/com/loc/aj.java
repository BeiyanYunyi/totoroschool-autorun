package com.loc;

import android.content.Context;
import android.os.Looper;
import java.lang.ref.WeakReference;
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

public final class aj
  extends ag
  implements Thread.UncaughtExceptionHandler
{
  private static ExecutorService e;
  private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
  private static WeakReference<Context> g;
  private static final ThreadFactory h = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public final Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder("pama#");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramAnonymousRunnable, localStringBuilder.toString());
    }
  };
  private Context d;
  private List<Object> i;
  
  private aj(Context paramContext)
  {
    this.d = paramContext;
    try
    {
      this.b = Thread.getDefaultUncaughtExceptionHandler();
      if (this.b == null)
      {
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.c = true;
        return;
      }
      paramContext = this.b.toString();
      if ((!paramContext.startsWith("com.amap.apis.utils.core.dynamiccore")) && ((paramContext.indexOf("com.amap.api") != -1) || (paramContext.indexOf("com.loc") != -1)))
      {
        this.c = false;
        return;
      }
      Thread.setDefaultUncaughtExceptionHandler(this);
      this.c = true;
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static aj a(Context paramContext, v paramv)
    throws k
  {
    if (paramv != null) {}
    try
    {
      if (paramv.a() != null)
      {
        boolean bool = "".equals(paramv.a());
        if (!bool)
        {
          try
          {
            if (!f.add(Integer.valueOf(paramv.hashCode())))
            {
              paramContext = (aj)ag.a;
              return paramContext;
            }
            if (ag.a == null) {
              ag.a = new aj(paramContext);
            } else {
              ag.a.c = false;
            }
            ag.a.a(paramContext, paramv, ag.a.c);
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
          }
          paramContext = (aj)ag.a;
          return paramContext;
        }
      }
      throw new k("sdk name is invalid");
    }
    finally {}
    throw new k("sdk info is null");
  }
  
  public static void a(v paramv, String paramString, k paramk)
  {
    if (paramk != null) {
      a(paramv, paramString, paramk.c(), paramk.d(), paramk.e(), paramk.b());
    }
  }
  
  public static void a(v paramv, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramv, paramString1, paramString2, paramString3, "", paramString4);
  }
  
  public static void a(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (ag.a != null)
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
        ag.a.a(paramv, localStringBuilder.toString(), "networkError");
      }
      return;
    }
    catch (Throwable paramv) {}
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 178	com/loc/aj:e	Ljava/util/concurrent/ExecutorService;
    //   6: ifnull +11 -> 17
    //   9: getstatic 178	com/loc/aj:e	Ljava/util/concurrent/ExecutorService;
    //   12: invokeinterface 183 1 0
    //   17: invokestatic 187	com/loc/bf:a	()V
    //   20: goto +12 -> 32
    //   23: astore_0
    //   24: goto +58 -> 82
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   32: getstatic 126	com/loc/ag:a	Lcom/loc/ag;
    //   35: ifnull +30 -> 65
    //   38: invokestatic 56	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   41: getstatic 126	com/loc/ag:a	Lcom/loc/ag;
    //   44: if_acmpne +21 -> 65
    //   47: getstatic 126	com/loc/ag:a	Lcom/loc/ag;
    //   50: getfield 188	com/loc/ag:b	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   53: ifnull +12 -> 65
    //   56: getstatic 126	com/loc/ag:a	Lcom/loc/ag;
    //   59: getfield 188	com/loc/ag:b	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   62: invokestatic 64	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   65: aconst_null
    //   66: putstatic 126	com/loc/ag:a	Lcom/loc/ag;
    //   69: ldc 2
    //   71: monitorexit
    //   72: return
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   78: ldc 2
    //   80: monitorexit
    //   81: return
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	1	0	localObject	Object
    //   27	2	0	localThrowable1	Throwable
    //   73	13	0	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	17	23	finally
    //   17	20	23	finally
    //   28	32	23	finally
    //   32	65	23	finally
    //   65	69	23	finally
    //   74	78	23	finally
    //   3	17	27	java/lang/Throwable
    //   17	20	27	java/lang/Throwable
    //   32	65	73	java/lang/Throwable
    //   65	69	73	java/lang/Throwable
  }
  
  public static void b(v paramv, String paramString1, String paramString2)
  {
    try
    {
      if (ag.a != null) {
        ag.a.a(paramv, paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramv) {}
  }
  
  public static void b(Throwable paramThrowable, String paramString1, String paramString2)
  {
    try
    {
      if (ag.a != null) {
        ag.a.a(paramThrowable, 1, paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramThrowable) {}
  }
  
  public static void c()
  {
    if ((g != null) && (g.get() != null))
    {
      ah.a((Context)g.get());
      return;
    }
    if (ag.a != null) {
      ag.a.a();
    }
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
  
  protected final void a()
  {
    ah.a(this.d);
  }
  
  protected final void a(final Context paramContext, final v paramv, final boolean paramBoolean)
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
          public final void run()
          {
            try
            {
              synchronized ()
              {
                new as(paramContext, true).a(paramv);
                if (paramBoolean) {
                  ak.a(aj.a(aj.this));
                }
                return;
              }
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        });
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
  
  protected final void a(v paramv, String paramString1, String paramString2)
  {
    ak.a(paramv, this.d, paramString2, paramString1);
  }
  
  protected final void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2)
  {
    ak.a(this.d, paramThrowable, paramInt, paramString1, paramString2);
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    int j = 0;
    try
    {
      while ((j < this.i.size()) && (j < 10))
      {
        this.i.get(j);
        j += 1;
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Thread.setDefaultUncaughtExceptionHandler(this.b);
        this.b.uncaughtException(paramThread, paramThrowable);
        return;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
    }
    if (paramThrowable == null) {
      return;
    }
    a(paramThrowable, 0, null, null);
    if (this.b == null) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */