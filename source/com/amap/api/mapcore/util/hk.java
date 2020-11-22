package com.amap.api.mapcore.util;

import android.content.Context;
import org.json.JSONObject;

public class hk
{
  private fv a;
  private String b;
  private String c;
  private String d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  private hk(fv paramfv, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    this.a = paramfv;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramBoolean3;
  }
  
  public static hk a(fv paramfv, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    return new hk(paramfv, paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramString3);
  }
  
  public fv a()
  {
    return this.a;
  }
  
  public String a(Context paramContext)
  {
    paramContext = fw.a(paramContext);
    try
    {
      paramContext = new JSONObject(this.d).optJSONObject(paramContext).optString("dexmd5", "");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String b(Context paramContext)
  {
    paramContext = fw.a(paramContext);
    try
    {
      paramContext = new JSONObject(this.d).optJSONObject(paramContext).optString("assetsmd5", "");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String c(Context paramContext)
  {
    paramContext = fw.a(paramContext);
    try
    {
      paramContext = new JSONObject(this.d).optJSONObject(paramContext).optString("so_md5_vals", "");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public String d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */