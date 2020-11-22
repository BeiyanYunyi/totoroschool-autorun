package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class bv
{
  static boolean a = false;
  static int b = 20;
  private static int c = 20;
  private static WeakReference<bp> d;
  
  public static void a(Context paramContext)
  {
    aj.d().submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          bp localbp = bw.a(bv.a());
          bw.a(this.a, localbp, ah.h, 1000, 307200, "2");
          if (localbp.g == null) {
            localbp.g = new bx(new cb(this.a, new by(new cc(new ce()))));
          }
          localbp.h = 3600000;
          if (TextUtils.isEmpty(localbp.i)) {
            localbp.i = "cKey";
          }
          if (localbp.f == null) {
            localbp.f = new ci(this.a, localbp.h, localbp.i, new cf(30, localbp.a, new cg(this.a, bv.a, bv.b() * 1024, bv.b * 1024, "staticUpdate")));
          }
          bq.a(localbp);
          return;
        }
        catch (Throwable localThrowable)
        {
          aj.b(localThrowable, "stm", "usd");
        }
      }
    });
  }
  
  public static void a(final bu parambu, Context paramContext)
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
              bv.a(this.a, parambu.a());
              return;
            }
            finally {}
            return;
          }
          catch (Throwable localThrowable)
          {
            aj.b(localThrowable, "stm", "as");
          }
        }
      });
      return;
    }
    finally
    {
      parambu = finally;
      throw parambu;
    }
  }
  
  /* Error */
  public static void a(List<bu> paramList, final Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokeinterface 132 1 0
    //   9: istore_2
    //   10: iload_2
    //   11: ifne +11 -> 22
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: astore_0
    //   19: goto +25 -> 44
    //   22: invokestatic 35	com/loc/aj:d	()Ljava/util/concurrent/ExecutorService;
    //   25: new 8	com/loc/bv$2
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 134	com/loc/bv$2:<init>	(Ljava/util/List;Landroid/content/Context;)V
    //   34: invokeinterface 43 2 0
    //   39: pop
    //   40: ldc 2
    //   42: monitorexit
    //   43: return
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    //   49: astore_3
    //   50: goto -28 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramList	List<bu>
    //   0	53	1	paramContext	Context
    //   9	2	2	i	int
    //   49	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	10	18	finally
    //   22	40	18	finally
    //   3	10	49	java/lang/Throwable
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */