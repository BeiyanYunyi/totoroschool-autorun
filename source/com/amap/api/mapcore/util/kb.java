package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class kb
{
  private List<a> a = new ArrayList();
  
  public static kb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new kb();
    }
    kb localkb = new kb();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject = paramString.getJSONObject(i);
        localObject = new a(((JSONObject)localObject).optString("sk", ""), ((JSONObject)localObject).optString("dk", ""));
        localkb.a.add(localObject);
        i += 1;
      }
      return localkb;
    }
    catch (Throwable paramString) {}
    return localkb;
  }
  
  public final List<a> a()
  {
    return this.a;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      this.a.add(new a(paramString1, paramString2));
      return;
    }
  }
  
  public final String b()
  {
    JSONArray localJSONArray;
    int i;
    if ((this.a != null) && (this.a.size() != 0))
    {
      localJSONArray = new JSONArray();
      i = 0;
    }
    for (;;)
    {
      a locala;
      if (i < this.a.size()) {
        locala = (a)this.a.get(i);
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("sk", locala.a());
        localJSONObject.put("dk", locala.b());
        localJSONArray.put(localJSONObject);
        i += 1;
        continue;
        return localJSONArray.toString();
        return "";
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public static final class a
  {
    private String a;
    private String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public final String a()
    {
      return this.a;
    }
    
    public final String b()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */