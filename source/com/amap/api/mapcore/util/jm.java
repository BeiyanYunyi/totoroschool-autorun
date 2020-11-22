package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public final class jm
  extends jj
{
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = null;
  
  public jm(Context paramContext, fv paramfv)
  {
    super(paramContext, paramfv);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.equalsIgnoreCase("dex.png"));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.equalsIgnoreCase("assets.jar"));
  }
  
  protected final String a()
  {
    return "s";
  }
  
  public final String b()
  {
    kf localkf = this.b.a(d());
    String str;
    if (!TextUtils.isEmpty(this.c))
    {
      str = this.c;
    }
    else
    {
      this.c = ho.a(this.a, "SoPng");
      str = this.c;
    }
    return localkf.b(str).a();
  }
  
  public final String l()
  {
    kf localkf = this.b.a(d());
    String str;
    if (!TextUtils.isEmpty(this.d))
    {
      str = this.d;
    }
    else
    {
      this.d = ho.a(this.a, "DexPng");
      str = this.d;
    }
    return localkf.b(str).a();
  }
  
  public final String m()
  {
    kf localkf = this.b.a(d());
    String str;
    if (!TextUtils.isEmpty(this.e))
    {
      str = this.e;
    }
    else
    {
      this.e = ho.a(this.a, "assets");
      str = this.e;
    }
    return localkf.b(str).a();
  }
  
  public final String n()
  {
    if (!TextUtils.isEmpty(this.f)) {
      return this.f;
    }
    if (this.a == null) {
      return "";
    }
    this.f = this.b.a(i()).b(f()).a();
    return this.f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */