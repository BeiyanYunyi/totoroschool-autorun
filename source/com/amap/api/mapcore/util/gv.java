package com.amap.api.mapcore.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class gv
{
  protected String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  int g;
  int h;
  private String i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = true;
  
  public gv(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramString3, false, paramBoolean);
  }
  
  public gv(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramString1;
    this.i = paramString2;
    this.j = paramBoolean1;
    this.l = paramBoolean2;
    try
    {
      paramString1 = paramString1.split("/");
      int m = paramString1.length;
      if (m <= 1) {
        return;
      }
      this.b = paramString1[(m - 1)];
      paramString1 = this.b.split("_");
      this.c = paramString1[0];
      this.d = paramString1[2];
      this.e = paramString1[1];
      this.g = Integer.parseInt(paramString1[3]);
      this.h = Integer.parseInt(paramString1[4].split("\\.")[0]);
      return;
    }
    catch (Throwable paramString1)
    {
      hd.a(paramString1, "DexDownloadItem", "DexDownloadItem");
    }
  }
  
  public static gv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new gv(null, null, null, true);
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new gv(paramString.optString("ak", ""), paramString.optString("bk", ""), "", true);
      return paramString;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DexDownloadItem#fromJson json ex ");
      localStringBuilder.append(paramString);
      hc.a(localStringBuilder.toString());
    }
    return new gv(null, null, null, true);
  }
  
  String a()
  {
    return this.a;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public String b()
  {
    return this.i;
  }
  
  String c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public boolean e()
  {
    return this.k;
  }
  
  public boolean f()
  {
    return this.l;
  }
  
  public String g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ak", this.a);
      localJSONObject.put("bk", this.f);
    }
    catch (JSONException localJSONException)
    {
      hc.a(localJSONException);
    }
    return localJSONObject.toString();
  }
  
  public boolean h()
  {
    if (TextUtils.isEmpty(this.c)) {
      return false;
    }
    if (!he.a(this.e)) {
      return false;
    }
    if (!he.a(this.d)) {
      return false;
    }
    if (this.h > 0) {
      return this.h > 0;
    }
    return false;
  }
  
  public String i()
  {
    return this.c;
  }
  
  public String j()
  {
    return this.d;
  }
  
  public String k()
  {
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */