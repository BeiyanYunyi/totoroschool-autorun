package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import org.json.JSONObject;

public final class le
  extends Inner_3dMap_location
{
  boolean a = true;
  private String b = null;
  private String c = "";
  private int d;
  private String e = "";
  private String f = "new";
  private JSONObject g = null;
  private String h = "";
  private String i = "";
  private long j = 0L;
  private String k = null;
  
  public le(String paramString)
  {
    super(paramString);
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (getProvider().equals("gps"))
      {
        this.d = 0;
        return;
      }
      if (paramString.equals("0"))
      {
        this.d = 0;
        return;
      }
      if (!paramString.equals("1")) {}
    }
    for (int m = 1;; m = -1)
    {
      this.d = m;
      return;
    }
  }
  
  public final String d()
  {
    return this.e;
  }
  
  public final void d(String paramString)
  {
    this.e = paramString;
  }
  
  public final JSONObject e()
  {
    return this.g;
  }
  
  public final void e(String paramString)
  {
    this.desc = paramString;
  }
  
  public final void setFloor(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString.replace("F", "");
      try
      {
        Integer.parseInt(str);
      }
      catch (Throwable paramString)
      {
        lf.a(paramString, "MapLocationModel", "setFloor");
        str = null;
      }
    }
    this.floor = str;
  }
  
  public final JSONObject toJson(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = super.toJson(paramInt);
      switch (paramInt)
      {
      case 1: 
        localJSONObject.put("retype", this.e);
        localJSONObject.put("cens", this.i);
        localJSONObject.put("poiid", this.buildingId);
        localJSONObject.put("floor", this.floor);
        localJSONObject.put("coord", this.d);
        localJSONObject.put("mcell", this.h);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("address", getAddress());
        if ((this.g != null) && (lj.a(localJSONObject, "offpct"))) {
          localJSONObject.put("offpct", this.g.getString("offpct"));
        }
      case 2: 
      case 3: 
        localJSONObject.put("type", this.f);
        localJSONObject.put("isReversegeo", this.a);
        return localJSONObject;
      }
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapLocationModel", "toStr");
      return null;
    }
    return localThrowable;
  }
  
  public final String toStr(int paramInt)
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = super.toJson(paramInt);
      localJSONObject.put("nb", this.k);
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapLocationModel", "toStr part2");
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    return ((JSONObject)localObject).toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\le.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */