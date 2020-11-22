package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class fm
{
  public static int a = -1;
  public static String b = "";
  private static fv c;
  private static String d = "http://apiinit.amap.com/v3/log/init";
  private static String e;
  
  private static String a()
  {
    return d;
  }
  
  private static Map<String, String> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("resType", "json");
      localHashMap.put("encode", "UTF-8");
      String str = fn.a();
      localHashMap.put("ts", str);
      localHashMap.put("key", fk.f(paramContext));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resType=json&encode=UTF-8&key=");
      localStringBuilder.append(fk.f(paramContext));
      localHashMap.put("scode", fn.a(paramContext, str, fw.d(localStringBuilder.toString())));
      return localHashMap;
    }
    catch (Throwable paramContext)
    {
      gg.a(paramContext, "Auth", "gParams");
    }
    return localHashMap;
  }
  
  @Deprecated
  public static boolean a(Context paramContext, fv paramfv)
  {
    try
    {
      boolean bool = a(paramContext, paramfv, false);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static boolean a(Context paramContext, fv paramfv, boolean paramBoolean)
  {
    c = paramfv;
    try
    {
      paramfv = a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("Content-Type", "application/x-www-form-urlencoded");
      localHashMap.put("Accept-Encoding", "gzip");
      localHashMap.put("Connection", "Keep-Alive");
      localHashMap.put("User-Agent", c.d());
      localHashMap.put("X-INFO", fn.b(paramContext));
      localHashMap.put("logversion", "2.1");
      localHashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { c.b(), c.a() }));
      hx localhx = hx.a();
      fx localfx = new fx();
      localfx.setProxy(ft.a(paramContext));
      localfx.a(localHashMap);
      localfx.b(a(paramContext));
      localfx.a(paramfv);
      paramBoolean = a(localhx.b(localfx));
      return paramBoolean;
    }
    catch (Throwable paramContext)
    {
      gg.a(paramContext, "Auth", "getAuth");
    }
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    try
    {
      paramArrayOfByte = new JSONObject(fw.a(paramArrayOfByte));
      if (paramArrayOfByte.has("status"))
      {
        i = paramArrayOfByte.getInt("status");
        if (i == 1) {
          a = 1;
        } else if (i == 0) {
          a = 0;
        }
      }
      if (paramArrayOfByte.has("info")) {
        b = paramArrayOfByte.getString("info");
      }
      if (a == 0) {
        Log.i("AuthFailure", b);
      }
      int i = a;
      return i == 1;
    }
    catch (Throwable paramArrayOfByte)
    {
      gg.a(paramArrayOfByte, "Auth", "lData");
      return false;
    }
    catch (JSONException paramArrayOfByte)
    {
      gg.a(paramArrayOfByte, "Auth", "lData");
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */