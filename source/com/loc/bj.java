package com.loc;

import android.text.TextUtils;
import java.net.Proxy;
import java.net.URLConnection;
import java.util.Map;

public final class bj
{
  public static int a = 0;
  public static String b = "";
  private static bj c;
  
  public static bj a()
  {
    if (c == null) {
      c = new bj();
    }
    return c;
  }
  
  public static bo a(bn parambn, boolean paramBoolean)
    throws k
  {
    if (parambn != null) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        if ((parambn.c() != null) && (!"".equals(parambn.c())))
        {
          if (parambn.e == null) {
            localObject1 = null;
          } else {
            localObject1 = parambn.e;
          }
          bm localbm = new bm(parambn.c, parambn.d, (Proxy)localObject1, paramBoolean);
          Object localObject1 = parambn.d();
          if ((localObject1 != null) && (localObject1.length != 0))
          {
            localObject1 = parambn.b_();
            if (localObject1 != null)
            {
              localObject1 = bm.a((Map)localObject1);
              localObject2 = new StringBuffer();
              ((StringBuffer)localObject2).append(parambn.c());
              ((StringBuffer)localObject2).append("?");
              ((StringBuffer)localObject2).append((String)localObject1);
              localObject1 = ((StringBuffer)localObject2).toString();
              continue;
            }
          }
          localObject1 = parambn.c();
          paramBoolean = parambn.k();
          String str = parambn.j();
          Map localMap = parambn.b();
          localObject2 = parambn.d();
          if ((localObject2 != null) && (localObject2.length != 0)) {
            break label241;
          }
          parambn = bm.a(parambn.b_());
          if (TextUtils.isEmpty(parambn)) {
            break label241;
          }
          parambn = w.a(parambn);
          return localbm.a((String)localObject1, paramBoolean, str, localMap, parambn);
        }
        throw new k("request url is empty");
      }
      catch (Throwable parambn)
      {
        parambn.printStackTrace();
        throw new k("未知的错误");
      }
      catch (k parambn)
      {
        throw parambn;
      }
      throw new k("requeust is null");
      label241:
      parambn = (bn)localObject2;
    }
  }
  
  public static byte[] a(bn parambn)
    throws k
  {
    try
    {
      parambn = a(parambn, true);
      if (parambn != null) {
        return parambn.a;
      }
      return null;
    }
    catch (k parambn)
    {
      throw parambn;
    }
    catch (Throwable parambn)
    {
      for (;;) {}
    }
    throw new k("未知的错误");
  }
  
  public static byte[] b(bn parambn)
    throws k
  {
    try
    {
      parambn = a(parambn, false);
      if (parambn != null) {
        return parambn.a;
      }
      return null;
    }
    catch (Throwable parambn)
    {
      ag.a(parambn, "bm", "msp");
      throw new k("未知的错误");
    }
    catch (k parambn)
    {
      throw parambn;
    }
  }
  
  public static abstract interface a
  {
    public abstract URLConnection a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */