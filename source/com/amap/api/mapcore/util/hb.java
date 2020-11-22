package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class hb
{
  private static final hb a = new hb();
  private static final ThreadFactory d = new b();
  private final Map<String, hf> b = new HashMap();
  private final Map<String, a> c = new HashMap();
  private ExecutorService e = null;
  
  public static hb b()
  {
    return a;
  }
  
  private boolean b(fv paramfv)
  {
    return (paramfv != null) && (!TextUtils.isEmpty(paramfv.b())) && (!TextUtils.isEmpty(paramfv.a()));
  }
  
  /* Error */
  a a(fv paramfv)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amap/api/mapcore/util/hb:c	Ljava/util/Map;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 60	com/amap/api/mapcore/util/hb:b	(Lcom/amap/api/mapcore/util/fv;)Z
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: monitorexit
    //   17: aconst_null
    //   18: areturn
    //   19: aload_1
    //   20: invokevirtual 55	com/amap/api/mapcore/util/fv:a	()Ljava/lang/String;
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 38	com/amap/api/mapcore/util/hb:c	Ljava/util/Map;
    //   29: aload 4
    //   31: invokeinterface 66 2 0
    //   36: checkcast 6	com/amap/api/mapcore/util/hb$a
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: aload_2
    //   43: ifnonnull +25 -> 68
    //   46: new 6	com/amap/api/mapcore/util/hb$a
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 69	com/amap/api/mapcore/util/hb$a:<init>	(Lcom/amap/api/mapcore/util/hb;)V
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 38	com/amap/api/mapcore/util/hb:c	Ljava/util/Map;
    //   59: aload 4
    //   61: aload_1
    //   62: invokeinterface 73 3 0
    //   67: pop
    //   68: aload_3
    //   69: monitorexit
    //   70: aload_1
    //   71: areturn
    //   72: astore_1
    //   73: aload_3
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_2
    //   79: astore_1
    //   80: goto -12 -> 68
    //   83: astore_2
    //   84: goto -16 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	hb
    //   0	87	1	paramfv	fv
    //   39	40	2	locala	a
    //   83	1	2	localThrowable	Throwable
    //   4	70	3	localMap	Map
    //   23	37	4	str	String
    // Exception table:
    //   from	to	target	type
    //   7	17	72	finally
    //   19	40	72	finally
    //   46	55	72	finally
    //   55	68	72	finally
    //   68	70	72	finally
    //   73	75	72	finally
    //   46	55	77	java/lang/Throwable
    //   55	68	83	java/lang/Throwable
  }
  
  /* Error */
  hf a(android.content.Context paramContext, fv paramfv)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 60	com/amap/api/mapcore/util/hb:b	(Lcom/amap/api/mapcore/util/fv;)Z
    //   5: ifeq +93 -> 98
    //   8: aload_1
    //   9: ifnonnull +6 -> 15
    //   12: goto +86 -> 98
    //   15: aload_2
    //   16: invokevirtual 55	com/amap/api/mapcore/util/fv:a	()Ljava/lang/String;
    //   19: astore 6
    //   21: aload_0
    //   22: getfield 36	com/amap/api/mapcore/util/hb:b	Ljava/util/Map;
    //   25: astore 5
    //   27: aload 5
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 36	com/amap/api/mapcore/util/hb:b	Ljava/util/Map;
    //   34: aload 6
    //   36: invokeinterface 66 2 0
    //   41: checkcast 78	com/amap/api/mapcore/util/hf
    //   44: astore 4
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: ifnonnull +36 -> 87
    //   54: new 80	com/amap/api/mapcore/util/hh
    //   57: dup
    //   58: aload_1
    //   59: invokevirtual 86	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   62: aload_2
    //   63: iconst_1
    //   64: invokespecial 89	com/amap/api/mapcore/util/hh:<init>	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;Z)V
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 36	com/amap/api/mapcore/util/hb:b	Ljava/util/Map;
    //   72: aload 6
    //   74: aload_3
    //   75: invokeinterface 73 3 0
    //   80: pop
    //   81: aload_1
    //   82: aload_2
    //   83: invokestatic 94	com/amap/api/mapcore/util/gx:a	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;)Lcom/amap/api/mapcore/util/gx;
    //   86: pop
    //   87: aload 5
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: astore_1
    //   93: aload 5
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    //   98: aconst_null
    //   99: areturn
    //   100: astore_1
    //   101: aload 4
    //   103: astore_3
    //   104: goto -17 -> 87
    //   107: astore_1
    //   108: goto -21 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	hb
    //   0	111	1	paramContext	android.content.Context
    //   0	111	2	paramfv	fv
    //   48	56	3	localObject	Object
    //   44	58	4	localhf	hf
    //   25	69	5	localMap	Map
    //   19	54	6	str	String
    // Exception table:
    //   from	to	target	type
    //   30	46	92	finally
    //   54	68	92	finally
    //   68	87	92	finally
    //   87	90	92	finally
    //   93	96	92	finally
    //   54	68	100	java/lang/Throwable
    //   68	87	107	java/lang/Throwable
  }
  
  public ExecutorService a()
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
  
  class a
  {
    volatile boolean a = false;
    volatile boolean b = false;
    
    a() {}
  }
  
  static final class b
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("amapD#");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramRunnable, localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */