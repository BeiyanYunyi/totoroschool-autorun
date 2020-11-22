package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  bj a = null;
  
  public b(Context paramContext)
  {
    try
    {
      r.a().a(paramContext);
      this.a = bj.a();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = b(paramContext, paramString2, null, null, null, null, null, null);
    paramString2.put("extensions", "all");
    return a(paramContext, paramString1, paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString2 = b(paramContext, paramString2, paramString3, paramString4, paramString5, null, null, null);
    paramString2.put("children", "1");
    paramString2.put("page", "1");
    paramString2.put("extensions", "base");
    return a(paramContext, paramString1, paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString2 = b(paramContext, paramString2, paramString3, null, paramString4, paramString5, paramString6, paramString7);
    paramString2.put("children", "1");
    paramString2.put("page", "1");
    paramString2.put("extensions", "base");
    return a(paramContext, paramString1, paramString2);
  }
  
  private static String a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    try
    {
      HashMap localHashMap = new HashMap(16);
      da localda = new da();
      localHashMap.clear();
      localHashMap.put("Content-Type", "application/x-www-form-urlencoded");
      localHashMap.put("Connection", "Keep-Alive");
      localHashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.8.0");
      String str1 = n.a();
      String str2 = n.a(paramContext, str1, w.b(paramMap));
      paramMap.put("ts", str1);
      paramMap.put("scode", str2);
      localda.b(paramMap);
      localda.a(localHashMap);
      localda.a(paramString);
      localda.a(t.a(paramContext));
      localda.a(dg.f);
      localda.b(dg.f);
      try
      {
        if (dn.k(paramContext))
        {
          localda.a(paramString.replace("http:", "https:"));
          paramContext = bj.a(localda);
        }
        else
        {
          paramContext = bj.b(localda);
        }
        paramContext = new String(paramContext, "utf-8");
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        dg.a(paramContext, "GeoFenceNetManager", "post");
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Map<String, String> b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("key", l.f(paramContext));
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("keywords", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("types", paramString2);
    }
    if ((!TextUtils.isEmpty(paramString5)) && (!TextUtils.isEmpty(paramString6)))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString6);
      paramContext.append(",");
      paramContext.append(paramString5);
      localHashMap.put("location", paramContext.toString());
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("city", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("offset", paramString4);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      localHashMap.put("radius", paramString7);
    }
    return localHashMap;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */