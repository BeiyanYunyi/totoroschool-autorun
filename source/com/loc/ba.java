package com.loc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ba
{
  private static final ba a = new ba();
  private static final ThreadFactory d = new b();
  private final Map<String, bc> b = new HashMap();
  private final Map<String, a> c = new HashMap();
  private ExecutorService e = null;
  
  public static ba b()
  {
    return a;
  }
  
  private static boolean b(v paramv)
  {
    return (paramv != null) && (!TextUtils.isEmpty(paramv.b())) && (!TextUtils.isEmpty(paramv.a()));
  }
  
  /* Error */
  final a a(v paramv)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/loc/ba:c	Ljava/util/Map;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: invokestatic 60	com/loc/ba:b	(Lcom/loc/v;)Z
    //   11: ifne +7 -> 18
    //   14: aload_3
    //   15: monitorexit
    //   16: aconst_null
    //   17: areturn
    //   18: aload_1
    //   19: invokevirtual 55	com/loc/v:a	()Ljava/lang/String;
    //   22: astore 4
    //   24: aload_0
    //   25: getfield 38	com/loc/ba:c	Ljava/util/Map;
    //   28: aload 4
    //   30: invokeinterface 66 2 0
    //   35: checkcast 6	com/loc/ba$a
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: ifnonnull +25 -> 67
    //   45: new 6	com/loc/ba$a
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 69	com/loc/ba$a:<init>	(Lcom/loc/ba;)V
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 38	com/loc/ba:c	Ljava/util/Map;
    //   58: aload 4
    //   60: aload_1
    //   61: invokeinterface 73 3 0
    //   66: pop
    //   67: aload_3
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: aload_3
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aload_2
    //   78: astore_1
    //   79: goto -12 -> 67
    //   82: astore_2
    //   83: goto -16 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ba
    //   0	86	1	paramv	v
    //   38	40	2	locala	a
    //   82	1	2	localThrowable	Throwable
    //   4	69	3	localMap	Map
    //   22	37	4	str	String
    // Exception table:
    //   from	to	target	type
    //   7	16	71	finally
    //   18	39	71	finally
    //   45	54	71	finally
    //   54	67	71	finally
    //   67	69	71	finally
    //   72	74	71	finally
    //   45	54	76	java/lang/Throwable
    //   54	67	82	java/lang/Throwable
  }
  
  /* Error */
  final bc a(android.content.Context paramContext, v paramv)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 60	com/loc/ba:b	(Lcom/loc/v;)Z
    //   4: ifeq +92 -> 96
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: goto +85 -> 96
    //   14: aload_2
    //   15: invokevirtual 55	com/loc/v:a	()Ljava/lang/String;
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 36	com/loc/ba:b	Ljava/util/Map;
    //   24: astore 5
    //   26: aload 5
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 36	com/loc/ba:b	Ljava/util/Map;
    //   33: aload 6
    //   35: invokeinterface 66 2 0
    //   40: checkcast 78	com/loc/bc
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: ifnonnull +35 -> 85
    //   53: new 80	com/loc/be
    //   56: dup
    //   57: aload_1
    //   58: invokevirtual 86	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   61: aload_2
    //   62: invokespecial 89	com/loc/be:<init>	(Landroid/content/Context;Lcom/loc/v;)V
    //   65: astore_3
    //   66: aload_0
    //   67: getfield 36	com/loc/ba:b	Ljava/util/Map;
    //   70: aload 6
    //   72: aload_3
    //   73: invokeinterface 73 3 0
    //   78: pop
    //   79: aload_1
    //   80: aload_2
    //   81: invokestatic 94	com/loc/aw:a	(Landroid/content/Context;Lcom/loc/v;)Lcom/loc/aw;
    //   84: pop
    //   85: aload 5
    //   87: monitorexit
    //   88: aload_3
    //   89: areturn
    //   90: astore_1
    //   91: aload 5
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: aconst_null
    //   97: areturn
    //   98: astore_1
    //   99: aload 4
    //   101: astore_3
    //   102: goto -17 -> 85
    //   105: astore_1
    //   106: goto -21 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	ba
    //   0	109	1	paramContext	android.content.Context
    //   0	109	2	paramv	v
    //   47	55	3	localObject	Object
    //   43	57	4	localbc	bc
    //   24	68	5	localMap	Map
    //   18	53	6	str	String
    // Exception table:
    //   from	to	target	type
    //   29	45	90	finally
    //   53	66	90	finally
    //   66	85	90	finally
    //   85	88	90	finally
    //   91	94	90	finally
    //   53	66	98	java/lang/Throwable
    //   66	85	105	java/lang/Throwable
  }
  
  public final ExecutorService a()
  {
    try
    {
      if ((this.e == null) || (this.e.isShutdown())) {
        this.e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), d);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return this.e;
  }
  
  final class a
  {
    volatile boolean a = false;
    volatile boolean b = false;
    
    a() {}
  }
  
  static final class b
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public final Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder("amapD#");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramRunnable, localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */