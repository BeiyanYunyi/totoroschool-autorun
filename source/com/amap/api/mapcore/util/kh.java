package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class kh
{
  private fv a = null;
  
  public kh(String paramString)
  {
    try
    {
      this.a = new fv.a(paramString, "1.0", "1.0.0").a(new String[] { "info" }).a();
      return;
    }
    catch (fj paramString) {}
  }
  
  private static fv a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      String str1 = paramJSONObject.optString("a");
      String str2 = paramJSONObject.optString("b");
      String str3 = paramJSONObject.optString("c");
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONArray("d");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.getString(i));
        i += 1;
      }
      paramJSONObject = new fv.a(str1, str2, str1).a(str3).a((String[])localArrayList.toArray(new String[0])).a();
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject) {}
    return null;
  }
  
  private List<fv> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 0) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = null;
      try
      {
        fv localfv = a(paramJSONArray.getJSONObject(i));
        localObject = localfv;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private JSONArray a(List<fv> paramList)
  {
    if (paramList.size() == 0) {
      return new JSONArray();
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(a((fv)paramList.next()));
    }
    return localJSONArray;
  }
  
  private static JSONObject a(fv paramfv)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("a", paramfv.a());
      localJSONObject.put("b", paramfv.b());
      localJSONObject.put("c", paramfv.c());
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while ((paramfv.g() != null) && (i < paramfv.g().length))
      {
        localJSONArray.put(paramfv.g()[i]);
        i += 1;
      }
      localJSONObject.put("d", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException paramfv)
    {
      paramfv.printStackTrace();
    }
    return localJSONObject;
  }
  
  public final List<fv> a(Context paramContext)
  {
    paramContext = hp.a(paramContext, this.a, "rbck");
    try
    {
      paramContext = a(new JSONArray(paramContext));
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      for (;;) {}
    }
    return new ArrayList();
  }
  
  public final void a(Context paramContext, fv paramfv)
  {
    if (paramfv == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramfv);
    paramfv = a(localArrayList).toString();
    if (TextUtils.isEmpty(paramfv)) {
      return;
    }
    hp.a(paramContext, this.a, "rbck", paramfv);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */