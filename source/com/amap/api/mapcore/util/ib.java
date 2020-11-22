package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Proxy;
import java.util.Map;

public class ib
  extends hx
{
  private static ib c;
  private je d;
  private Handler e;
  
  private ib(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      this.d = je.b(paramInt);
      if (Looper.myLooper() == null)
      {
        this.e = new a(Looper.getMainLooper(), null);
        return;
      }
      this.e = new a();
      return;
    }
    catch (Throwable localThrowable2)
    {
      Throwable localThrowable1;
      for (;;) {}
    }
    gk.c(localThrowable1, "NetManger", "NetManger1");
    localThrowable1.printStackTrace();
  }
  
  public static ib a(boolean paramBoolean)
  {
    return a(paramBoolean, 5);
  }
  
  /* Error */
  private static ib a(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 64	com/amap/api/mapcore/util/ib:c	Lcom/amap/api/mapcore/util/ib;
    //   6: ifnonnull +18 -> 24
    //   9: new 2	com/amap/api/mapcore/util/ib
    //   12: dup
    //   13: iload_0
    //   14: iload_1
    //   15: invokespecial 66	com/amap/api/mapcore/util/ib:<init>	(ZI)V
    //   18: putstatic 64	com/amap/api/mapcore/util/ib:c	Lcom/amap/api/mapcore/util/ib;
    //   21: goto +38 -> 59
    //   24: iload_0
    //   25: ifeq +34 -> 59
    //   28: getstatic 64	com/amap/api/mapcore/util/ib:c	Lcom/amap/api/mapcore/util/ib;
    //   31: getfield 30	com/amap/api/mapcore/util/ib:d	Lcom/amap/api/mapcore/util/je;
    //   34: ifnonnull +25 -> 59
    //   37: getstatic 64	com/amap/api/mapcore/util/ib:c	Lcom/amap/api/mapcore/util/ib;
    //   40: iload_1
    //   41: invokestatic 28	com/amap/api/mapcore/util/je:b	(I)Lcom/amap/api/mapcore/util/je;
    //   44: putfield 30	com/amap/api/mapcore/util/ib:d	Lcom/amap/api/mapcore/util/je;
    //   47: goto +12 -> 59
    //   50: astore_2
    //   51: goto +17 -> 68
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   59: getstatic 64	com/amap/api/mapcore/util/ib:c	Lcom/amap/api/mapcore/util/ib;
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
    //   62	10	2	localib	ib
    // Exception table:
    //   from	to	target	type
    //   3	21	50	finally
    //   28	47	50	finally
    //   55	59	50	finally
    //   59	63	50	finally
    //   3	21	54	java/lang/Throwable
    //   28	47	54	java/lang/Throwable
  }
  
  private void a(fj paramfj, id paramid)
  {
    ig localig = new ig();
    localig.a = paramfj;
    localig.b = paramid;
    paramfj = Message.obtain();
    paramfj.obj = localig;
    paramfj.what = 1;
    this.e.sendMessage(paramfj);
  }
  
  private void a(ie paramie, id paramid)
  {
    paramid.a(paramie.b, paramie.a);
    paramie = new ig();
    paramie.b = paramid;
    paramid = Message.obtain();
    paramid.obj = paramie;
    paramid.what = 0;
    this.e.sendMessage(paramid);
  }
  
  public static ib b()
  {
    return a(true, 5);
  }
  
  public Map<String, String> b(ic paramic, boolean paramBoolean)
    throws fj
  {
    try
    {
      c(paramic);
      Proxy localProxy;
      if (paramic.c == null) {
        localProxy = null;
      } else {
        localProxy = paramic.c;
      }
      paramic = new ia(paramic.a, paramic.b, localProxy, paramBoolean).a(paramic.getURL(), paramic.isIPRequest(), paramic.getIPDNSName(), paramic.getRequestHead(), paramic.getParams(), paramic.isIgnoreGZip());
      return paramic;
    }
    catch (Throwable paramic)
    {
      paramic.printStackTrace();
      throw new fj("未知的错误");
    }
    catch (fj paramic)
    {
      throw paramic;
    }
  }
  
  public byte[] b(ic paramic)
    throws fj
  {
    try
    {
      paramic = a(paramic, false);
      if (paramic != null) {
        return paramic.a;
      }
      return null;
    }
    catch (Throwable paramic)
    {
      paramic.printStackTrace();
      gk.e().b(paramic, "NetManager", "makeSyncPostRequest");
      throw new fj("未知的错误");
    }
    catch (fj paramic)
    {
      throw paramic;
    }
  }
  
  public ie c(ic paramic, boolean paramBoolean)
    throws fj
  {
    try
    {
      c(paramic);
      Proxy localProxy;
      if (paramic.c == null) {
        localProxy = null;
      } else {
        localProxy = paramic.c;
      }
      paramic = new ia(paramic.a, paramic.b, localProxy, paramBoolean).b(paramic.getURL(), paramic.isIPRequest(), paramic.getIPDNSName(), paramic.getRequestHead(), paramic.getParams(), paramic.isIgnoreGZip());
      return paramic;
    }
    catch (Throwable paramic)
    {
      paramic.printStackTrace();
      throw new fj("未知的错误");
    }
    catch (fj paramic)
    {
      throw paramic;
    }
  }
  
  public byte[] d(ic paramic)
    throws fj
  {
    try
    {
      paramic = c(paramic, false);
      if (paramic != null) {
        return paramic.a;
      }
      return null;
    }
    catch (fj paramic)
    {
      throw paramic;
    }
    catch (Throwable paramic)
    {
      for (;;) {}
    }
    throw new fj("未知的错误");
  }
  
  public byte[] e(ic paramic)
    throws fj
  {
    try
    {
      paramic = c(paramic, true);
      if (paramic != null) {
        return paramic.a;
      }
      return null;
    }
    catch (fj paramic)
    {
      throw paramic;
    }
    catch (Throwable paramic)
    {
      for (;;) {}
    }
    throw new fj("未知的错误");
  }
  
  static class a
    extends Handler
  {
    public a() {}
    
    private a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1: 
          paramMessage = (ig)paramMessage.obj;
          paramMessage.b.a(paramMessage.a);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      ((ig)paramMessage.obj).b.a();
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */