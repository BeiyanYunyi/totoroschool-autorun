package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Map;

public final class lb
  extends hy
{
  Map<String, String> f = null;
  String g = "";
  byte[] h = null;
  byte[] i = null;
  boolean j = false;
  String k = null;
  Map<String, String> l = null;
  boolean m = false;
  private String n = "";
  
  public lb(Context paramContext, fv paramfv)
  {
    super(paramContext, paramfv);
  }
  
  public final void a()
  {
    this.j = true;
  }
  
  public final void a(String paramString)
  {
    this.k = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.l = paramMap;
  }
  
  public final void b(String paramString)
  {
    this.g = paramString;
  }
  
  public final void b(Map<String, String> paramMap)
  {
    this.f = paramMap;
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
  }
  
  public final byte[] d()
  {
    return this.h;
  }
  
  public final byte[] e()
  {
    return this.i;
  }
  
  public final boolean g()
  {
    return this.j;
  }
  
  protected final String getIPDNSName()
  {
    return this.n;
  }
  
  public final Map<String, String> getParams()
  {
    return this.l;
  }
  
  public final Map<String, String> getRequestHead()
  {
    return this.f;
  }
  
  public final String getURL()
  {
    return this.g;
  }
  
  public final String i()
  {
    return this.k;
  }
  
  protected final boolean j()
  {
    return this.m;
  }
  
  public final void k()
  {
    this.m = true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */