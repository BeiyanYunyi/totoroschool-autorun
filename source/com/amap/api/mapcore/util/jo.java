package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class jo
{
  String a;
  private String b;
  private String c;
  private String d;
  
  public jo() {}
  
  private jo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramString3;
    this.d = paramString4;
  }
  
  private static String a(jo paramjo)
  {
    if (paramjo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mk", paramjo.c);
      localJSONObject.put("ek", paramjo.a);
      localJSONObject.put("nk", paramjo.d);
      localJSONObject.put("sk", paramjo.b);
      return localJSONObject.toString();
    }
    catch (JSONException paramjo)
    {
      for (;;) {}
    }
  }
  
  public static String a(List<jo> paramList)
  {
    if (paramList == null) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramList.size())
    {
      jo localjo = (jo)paramList.get(i);
      try
      {
        localJSONArray.put(i, a(localjo));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i += 1;
    }
    return localJSONArray.toString();
  }
  
  public static jo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new jo();
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new jo("", "", paramString.optString("md5", ""), paramString.optString("so_file_name", ""));
      return paramString;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder("SoFile#fromJson json ex ");
      localStringBuilder.append(paramString);
      ho.a(localStringBuilder.toString());
    }
    return new jo();
  }
  
  public static List<jo> d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(e(paramString.getString(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static jo e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new jo();
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optString("mk", "");
      String str1 = paramString.optString("ek", "");
      String str2 = paramString.optString("nk", "");
      paramString = new jo(paramString.optString("sk", ""), (String)localObject, str1, str2);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder("SoFile#fromJson json ex ");
      ((StringBuilder)localObject).append(paramString);
      ho.a(((StringBuilder)localObject).toString());
    }
    return new jo();
  }
  
  public final String a()
  {
    return this.d;
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
  }
  
  public final void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */