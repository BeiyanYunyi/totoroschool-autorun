package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class hl
{
  private static String j = "";
  private static HashMap<String, String> k = new HashMap();
  private gv a;
  private jp b;
  private String c;
  private String d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h = false;
  private String i = "";
  
  public hl(gv paramgv, jp paramjp, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    this.a = paramgv;
    this.b = paramjp;
    this.c = paramString1;
    this.d = paramString2;
    this.g = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramBoolean3;
    this.i = paramString3;
  }
  
  public static hl a()
  {
    return new hl(null, null, null, null, false, false, false, "");
  }
  
  public static hl a(Context paramContext, fv paramfv)
  {
    if ((paramContext != null) && (paramfv != null) && (!TextUtils.isEmpty(paramfv.a())))
    {
      Object localObject = paramfv.a();
      localObject = (String)k.get(localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return a((String)localObject);
      }
      localObject = new StringBuilder("INFO_KEY");
      ((StringBuilder)localObject).append(paramfv.a());
      localObject = ((StringBuilder)localObject).toString();
      paramContext = jg.a(paramContext, k(), (String)localObject);
      k.put(paramfv.a(), paramContext);
      return a(paramContext);
    }
    return null;
  }
  
  public static hl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return a();
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("fk", "");
      String str1 = ((JSONObject)localObject).optString("fs", "");
      boolean bool1 = ((JSONObject)localObject).optBoolean("fh", false);
      boolean bool2 = ((JSONObject)localObject).optBoolean("fj", false);
      boolean bool3 = ((JSONObject)localObject).optBoolean("fm", false);
      String str2 = ((JSONObject)localObject).optString("fl", "");
      String str3 = ((JSONObject)localObject).optString("fn", "");
      boolean bool4 = ((JSONObject)localObject).optBoolean("cck", false);
      localObject = ((JSONObject)localObject).optString("fi", "");
      paramString = new hl(gv.a(paramString), jp.b(str1), str2, str3, bool3, bool1, bool2, (String)localObject);
      paramString.a(bool4);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
    return a();
  }
  
  public static boolean a(Context paramContext, hl paramhl, fv paramfv)
  {
    if (paramContext != null)
    {
      if (paramhl == null) {
        return false;
      }
      if (!fw.a(paramContext).equals(paramhl.i)) {
        return false;
      }
      if (!paramhl.a(paramContext)) {
        c(paramContext, paramfv);
      }
      if (paramhl.b == null) {
        return true;
      }
      paramContext = jn.a(paramContext, paramfv);
      return paramhl.b.b(paramContext);
    }
    return false;
  }
  
  public static boolean b(Context paramContext, hl paramhl, fv paramfv)
  {
    paramContext = ji.a(paramContext, paramfv);
    return ho.d(paramhl.g(), paramContext.b());
  }
  
  public static void c(Context paramContext, fv paramfv)
  {
    if (paramContext == null) {
      return;
    }
    k.remove(paramfv.a());
    Object localObject = new StringBuilder("INFO_KEY");
    ((StringBuilder)localObject).append(paramfv.a());
    paramfv = ((StringBuilder)localObject).toString();
    localObject = k();
    if ((paramContext != null) && (!TextUtils.isEmpty(paramfv)))
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      paramContext = paramContext.getSharedPreferences((String)localObject, 0).edit();
      paramContext.putString(paramfv, "");
      paramContext.commit();
      return;
    }
  }
  
  private static String k()
  {
    if (!TextUtils.isEmpty(j)) {
      return j;
    }
    String str = fs.b("f15cdcf9a06f9fb7f7c0d49ec3c22393");
    j = str;
    return str;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(Context paramContext)
  {
    if (this.a != null)
    {
      if (!this.a.h()) {
        return false;
      }
      paramContext = this.b;
      if (paramContext == null) {}
      while ((TextUtils.isEmpty(paramContext.a())) || (!jh.a(paramContext.c())) || (!jh.a(paramContext.b())) || (paramContext.d() == null) || (paramContext.d().size() == 0))
      {
        m = 0;
        break;
      }
      int m = 1;
      return m != 0;
    }
    return false;
  }
  
  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.a != null) {
        localJSONObject.put("fk", this.a.g());
      }
      if (this.b != null) {
        localJSONObject.put("fs", this.b.e());
      }
      localJSONObject.put("fm", this.g);
      localJSONObject.put("fh", this.e);
      localJSONObject.put("fj", this.f);
      localJSONObject.put("fl", this.c);
      localJSONObject.put("fn", this.d);
      localJSONObject.put("cck", this.h);
      localJSONObject.put("fi", this.i);
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    return localJSONObject.toString();
  }
  
  public void b(Context paramContext, fv paramfv)
  {
    if (paramContext == null) {
      return;
    }
    String str = b();
    Object localObject = new StringBuilder("INFO_KEY");
    ((StringBuilder)localObject).append(paramfv.a());
    localObject = ((StringBuilder)localObject).toString();
    k.put(paramfv.a(), str);
    jg.a(paramContext, k(), (String)localObject, str);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public gv c()
  {
    return this.a;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public jp d()
  {
    return this.b;
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public boolean h()
  {
    return this.e;
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public boolean j()
  {
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */