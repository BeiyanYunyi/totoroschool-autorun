package com.amap.api.mapcore.util;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class hx
{
  public static int a = 0;
  public static String b = "";
  private static hx c;
  
  public static hx a()
  {
    if (c == null) {
      c = new hx();
    }
    return c;
  }
  
  public ie a(ic paramic, boolean paramBoolean)
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
      paramic = new ia(paramic.a, paramic.b, localProxy, paramBoolean).a(paramic.b(), paramic.isIPRequest(), paramic.getIPDNSName(), paramic.getRequestHead(), paramic.c(), paramic.isIgnoreGZip());
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
  
  public byte[] a(ic paramic)
    throws fj
  {
    try
    {
      paramic = a(paramic, true);
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
      gg.a(paramic, "bm", "msp");
      throw new fj("未知的错误");
    }
    catch (fj paramic)
    {
      throw paramic;
    }
  }
  
  protected void c(ic paramic)
    throws fj
  {
    if (paramic != null)
    {
      if ((paramic.getURL() != null) && (!"".equals(paramic.getURL()))) {
        return;
      }
      throw new fj("request url is empty");
    }
    throw new fj("requeust is null");
  }
  
  public static abstract interface a
  {
    public abstract URLConnection a(Proxy paramProxy, URL paramURL);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */