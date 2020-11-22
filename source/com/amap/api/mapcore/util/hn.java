package com.amap.api.mapcore.util;

import android.content.Context;

public class hn
{
  private Context a;
  private volatile kc b = new kc();
  private String c = "9B5496EA3E76B481056A23AB5D66832A";
  private kh d = new kh(this.c);
  private gk.a e = new gk.a()
  {
    public final void a(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
    {
      hn.this.a(null);
    }
  };
  
  public static hn a()
  {
    return a.a;
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.a = paramContext.getApplicationContext();
  }
  
  public void a(Context paramContext)
  {
    a.a.b(paramContext);
  }
  
  public void a(Context paramContext, fv paramfv)
  {
    a(paramContext);
    if (hi.b(paramfv)) {
      this.d.a(paramContext, paramfv);
    }
    try
    {
      gk.b(paramContext, paramfv).a(a.a.e);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    paramString = this.d.a(this.a);
    try
    {
      this.b.a(this.a, paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    return this.b.a(this.a, paramString1, paramString3);
  }
  
  static final class a
  {
    public static hn a = new hn();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */