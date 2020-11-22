package com.amap.api.mapcore.util;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class je
{
  private static je a;
  private ExecutorService b;
  private ConcurrentHashMap<jf, Future<?>> c = new ConcurrentHashMap();
  private jf.a d = new jf.a()
  {
    public void a(jf paramAnonymousjf) {}
    
    public void b(jf paramAnonymousjf)
    {
      je.a(je.this, paramAnonymousjf, false);
    }
    
    public void c(jf paramAnonymousjf)
    {
      je.a(je.this, paramAnonymousjf, true);
    }
  };
  
  private je(int paramInt)
  {
    try
    {
      this.b = new ThreadPoolExecutor(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256));
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "TPool", "ThreadPool");
      localThrowable.printStackTrace();
    }
  }
  
  public static je a(int paramInt)
  {
    try
    {
      if (a == null) {
        a = new je(paramInt);
      }
      je localje = a;
      return localje;
    }
    finally {}
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 66	com/amap/api/mapcore/util/je:a	Lcom/amap/api/mapcore/util/je;
    //   6: ifnull +33 -> 39
    //   9: getstatic 66	com/amap/api/mapcore/util/je:a	Lcom/amap/api/mapcore/util/je;
    //   12: invokespecial 69	com/amap/api/mapcore/util/je:b	()V
    //   15: aconst_null
    //   16: putstatic 66	com/amap/api/mapcore/util/je:a	Lcom/amap/api/mapcore/util/je;
    //   19: goto +20 -> 39
    //   22: astore_0
    //   23: goto +20 -> 43
    //   26: astore_0
    //   27: aload_0
    //   28: ldc 53
    //   30: ldc 71
    //   32: invokestatic 60	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: invokevirtual 63	java/lang/Throwable:printStackTrace	()V
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	1	0	localObject	Object
    //   26	21	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	19	22	finally
    //   27	39	22	finally
    //   3	19	26	java/lang/Throwable
  }
  
  /* Error */
  private void a(jf paramjf, Future<?> paramFuture)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/amap/api/mapcore/util/je:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 80	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: goto +20 -> 32
    //   15: astore_1
    //   16: goto +19 -> 35
    //   19: astore_1
    //   20: aload_1
    //   21: ldc 53
    //   23: ldc 82
    //   25: invokestatic 60	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 63	java/lang/Throwable:printStackTrace	()V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	je
    //   0	39	1	paramjf	jf
    //   0	39	2	paramFuture	Future<?>
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
    //   20	32	15	finally
    //   2	12	19	java/lang/Throwable
  }
  
  /* Error */
  private void a(jf paramjf, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/amap/api/mapcore/util/je:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 88	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 90	java/util/concurrent/Future
    //   13: astore_1
    //   14: iload_2
    //   15: ifeq +35 -> 50
    //   18: aload_1
    //   19: ifnull +31 -> 50
    //   22: aload_1
    //   23: iconst_1
    //   24: invokeinterface 94 2 0
    //   29: pop
    //   30: goto +20 -> 50
    //   33: astore_1
    //   34: goto +19 -> 53
    //   37: astore_1
    //   38: aload_1
    //   39: ldc 53
    //   41: ldc 96
    //   43: invokestatic 60	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokevirtual 63	java/lang/Throwable:printStackTrace	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	je
    //   0	57	1	paramjf	jf
    //   0	57	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   22	30	33	finally
    //   38	50	33	finally
    //   2	14	37	java/lang/Throwable
    //   22	30	37	java/lang/Throwable
  }
  
  public static je b(int paramInt)
  {
    return new je(paramInt);
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (jf)((Map.Entry)localIterator.next()).getKey();
        localObject = (Future)this.c.get(localObject);
        if (localObject != null) {
          try
          {
            ((Future)localObject).cancel(true);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      this.c.clear();
      this.b.shutdown();
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "TPool", "destroy");
      localThrowable.printStackTrace();
    }
  }
  
  /* Error */
  private boolean b(jf paramjf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/amap/api/mapcore/util/je:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 144	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: istore_2
    //   11: goto +22 -> 33
    //   14: astore_1
    //   15: goto +22 -> 37
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 53
    //   22: ldc -110
    //   24: invokestatic 60	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_1
    //   28: invokevirtual 63	java/lang/Throwable:printStackTrace	()V
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	je
    //   0	41	1	paramjf	jf
    //   10	26	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
    //   19	31	14	finally
    //   2	11	18	java/lang/Throwable
  }
  
  /* Error */
  public void a(jf paramjf)
    throws fj
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 153	com/amap/api/mapcore/util/je:b	(Lcom/amap/api/mapcore/util/jf;)Z
    //   5: ifeq +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 51	com/amap/api/mapcore/util/je:b	Ljava/util/concurrent/ExecutorService;
    //   13: ifnull +47 -> 60
    //   16: aload_0
    //   17: getfield 51	com/amap/api/mapcore/util/je:b	Ljava/util/concurrent/ExecutorService;
    //   20: invokeinterface 156 1 0
    //   25: ifeq +4 -> 29
    //   28: return
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 34	com/amap/api/mapcore/util/je:d	Lcom/amap/api/mapcore/util/jf$a;
    //   34: putfield 157	com/amap/api/mapcore/util/jf:d	Lcom/amap/api/mapcore/util/jf$a;
    //   37: aload_0
    //   38: getfield 51	com/amap/api/mapcore/util/je:b	Ljava/util/concurrent/ExecutorService;
    //   41: aload_1
    //   42: invokeinterface 161 2 0
    //   47: astore_2
    //   48: aload_2
    //   49: ifnonnull +4 -> 53
    //   52: return
    //   53: aload_0
    //   54: aload_1
    //   55: aload_2
    //   56: invokespecial 163	com/amap/api/mapcore/util/je:a	(Lcom/amap/api/mapcore/util/jf;Ljava/util/concurrent/Future;)V
    //   59: return
    //   60: return
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 63	java/lang/Throwable:printStackTrace	()V
    //   66: aload_1
    //   67: ldc 53
    //   69: ldc -91
    //   71: invokestatic 60	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   74: new 149	com/amap/api/mapcore/util/fj
    //   77: dup
    //   78: ldc -89
    //   80: invokespecial 170	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_1
    //   85: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	je
    //   0	86	1	paramjf	jf
    //   47	9	2	localFuture	Future
    // Exception table:
    //   from	to	target	type
    //   0	8	61	java/lang/Throwable
    //   9	28	61	java/lang/Throwable
    //   29	37	61	java/lang/Throwable
    //   37	48	61	java/lang/Throwable
    //   53	59	61	java/lang/Throwable
    //   37	48	84	java/util/concurrent/RejectedExecutionException
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\je.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */