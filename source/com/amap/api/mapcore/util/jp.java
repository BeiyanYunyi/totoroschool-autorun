package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class jp
{
  List<jo> a = new ArrayList();
  private String b;
  private String c;
  private String d;
  
  public jp() {}
  
  public jp(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.a = a(paramString1, paramString4);
  }
  
  private jp(String paramString1, String paramString2, String paramString3, List<jo> paramList)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.a = paramList;
  }
  
  private List<jo> a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONArray(paramString2);
      str = UUID.randomUUID().toString();
      localArrayList = new ArrayList();
      i = 0;
    }
    catch (JSONException paramString1)
    {
      try
      {
        ArrayList localArrayList;
        for (;;)
        {
          String str;
          int i;
          jo localjo = jo.c(paramString2.getString(i));
          localjo.a(str);
          localjo.b(paramString1);
          localArrayList.add(localjo);
          i += 1;
        }
        return localArrayList;
        for (;;)
        {
          return new ArrayList();
          paramString1 = paramString1;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
    if (i >= paramString2.length()) {}
  }
  
  public static jp b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new jp();
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new jp(paramString.optString("ak", ""), paramString.optString("bk", ""), paramString.optString("ik", ""), jo.d(paramString.optString("jk", "")));
      return paramString;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder("SoFile#fromJson json ex ");
      localStringBuilder.append(paramString);
      ho.a(localStringBuilder.toString());
    }
    return new jp();
  }
  
  public final jo a(String paramString)
  {
    if (this.a != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        jo localjo = (jo)localIterator.next();
        if (localjo.a().equals(paramString)) {
          return localjo;
        }
      }
      return null;
    }
    return null;
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final boolean a(jn paramjn)
  {
    if (paramjn == null) {
      return false;
    }
    if (this.a == null) {
      return false;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (jo)localIterator.next();
      String str = ((jo)localObject).a();
      localObject = ((jo)localObject).a;
      if (!TextUtils.isEmpty(str))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        if (!ho.d((String)localObject, paramjn.c(str))) {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final boolean b(jn paramjn)
  {
    if (paramjn == null) {
      return false;
    }
    int i;
    if (this.a != null)
    {
      if (this.a.size() == 0) {
        return true;
      }
      i = 0;
    }
    for (;;)
    {
      jo localjo;
      if ((i < this.a.size()) && (i < 20)) {
        localjo = (jo)this.a.get(i);
      }
      try
      {
        String str = paramjn.b(localjo.a());
        if (!ho.e(str)) {
          return false;
        }
        boolean bool = ho.d(localjo.a, str);
        if (!bool) {
          return false;
        }
        i += 1;
      }
      catch (Throwable paramjn) {}
    }
    return true;
    return true;
    return false;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final List<jo> d()
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    return this.a;
  }
  
  public final String e()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ak", this.b);
      localJSONObject.put("bk", this.c);
      localJSONObject.put("ik", this.d);
      localJSONObject.put("jk", jo.a(this.a));
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */