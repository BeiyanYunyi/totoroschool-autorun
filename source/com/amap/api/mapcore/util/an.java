package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class an
{
  private static an a;
  private je b;
  private LinkedHashMap<String, jf> c = new LinkedHashMap();
  private boolean d = true;
  
  private an(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      try
      {
        this.b = je.a(paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static an a(int paramInt)
  {
    return a(true, paramInt);
  }
  
  /* Error */
  private static an a(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 44	com/amap/api/mapcore/util/an:a	Lcom/amap/api/mapcore/util/an;
    //   6: ifnonnull +18 -> 24
    //   9: new 2	com/amap/api/mapcore/util/an
    //   12: dup
    //   13: iload_0
    //   14: iload_1
    //   15: invokespecial 46	com/amap/api/mapcore/util/an:<init>	(ZI)V
    //   18: putstatic 44	com/amap/api/mapcore/util/an:a	Lcom/amap/api/mapcore/util/an;
    //   21: goto +38 -> 59
    //   24: iload_0
    //   25: ifeq +34 -> 59
    //   28: getstatic 44	com/amap/api/mapcore/util/an:a	Lcom/amap/api/mapcore/util/an;
    //   31: getfield 34	com/amap/api/mapcore/util/an:b	Lcom/amap/api/mapcore/util/je;
    //   34: ifnonnull +25 -> 59
    //   37: getstatic 44	com/amap/api/mapcore/util/an:a	Lcom/amap/api/mapcore/util/an;
    //   40: iload_1
    //   41: invokestatic 32	com/amap/api/mapcore/util/je:a	(I)Lcom/amap/api/mapcore/util/je;
    //   44: putfield 34	com/amap/api/mapcore/util/an:b	Lcom/amap/api/mapcore/util/je;
    //   47: goto +12 -> 59
    //   50: astore_2
    //   51: goto +17 -> 68
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 37	java/lang/Throwable:printStackTrace	()V
    //   59: getstatic 44	com/amap/api/mapcore/util/an:a	Lcom/amap/api/mapcore/util/an;
    //   62: astore_2
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_2
    //   67: areturn
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramBoolean	boolean
    //   0	73	1	paramInt	int
    //   50	1	2	localObject	Object
    //   54	2	2	localThrowable	Throwable
    //   62	10	2	localan	an
    // Exception table:
    //   from	to	target	type
    //   3	21	50	finally
    //   28	47	50	finally
    //   55	59	50	finally
    //   59	63	50	finally
    //   3	21	54	java/lang/Throwable
    //   28	47	54	java/lang/Throwable
  }
  
  public static void c()
  {
    a = null;
  }
  
  public void a()
  {
    synchronized (this.c)
    {
      if (this.c.size() < 1) {
        return;
      }
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localEntry.getKey();
        ((aj)localEntry.getValue()).a();
      }
      this.c.clear();
      return;
    }
  }
  
  public void a(am paramam)
  {
    synchronized (this.c)
    {
      aj localaj = (aj)this.c.get(paramam.b());
      if (localaj == null) {
        return;
      }
      localaj.a();
      this.c.remove(paramam.b());
      return;
    }
  }
  
  public void a(am paramam, Context arg2, AMap paramAMap)
    throws fj
  {
    je localje = this.b;
    if (!this.c.containsKey(paramam.b()))
    {
      paramAMap = new aj((be)paramam, ???.getApplicationContext(), paramAMap);
      synchronized (this.c)
      {
        this.c.put(paramam.b(), paramAMap);
      }
    }
    this.b.a((jf)this.c.get(paramam.b()));
  }
  
  public void b()
  {
    a();
    je.a();
    this.b = null;
    c();
  }
  
  public void b(am paramam)
  {
    aj localaj = (aj)this.c.get(paramam.b());
    if (localaj != null) {
      synchronized (this.c)
      {
        localaj.b();
        this.c.remove(paramam.b());
        return;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */