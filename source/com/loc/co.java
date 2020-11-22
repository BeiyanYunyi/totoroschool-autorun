package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import org.json.JSONObject;

public final class co
  extends AMapLocation
{
  protected String d = "";
  boolean e = true;
  String f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
  private String g = null;
  private String h = "";
  private int i;
  private String j = "";
  private String k = "new";
  private JSONObject l = null;
  private String m = "";
  private String n = "";
  private String o = null;
  
  public co(String paramString)
  {
    super(paramString);
  }
  
  public final String a()
  {
    return this.g;
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.l = paramJSONObject;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final String b()
  {
    return this.h;
  }
  
  public final void b(String paramString)
  {
    this.h = paramString;
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i1;
      try
      {
        dg.a(this, paramJSONObject);
        this.k = paramJSONObject.optString("type", this.k);
        this.j = paramJSONObject.optString("retype", this.j);
        String str1 = paramJSONObject.optString("cens", this.n);
        if (!TextUtils.isEmpty(str1))
        {
          String[] arrayOfString = str1.split("\\*");
          int i2 = arrayOfString.length;
          i1 = 0;
          if (i1 < i2)
          {
            String str2 = arrayOfString[i1];
            if (TextUtils.isEmpty(str2)) {
              break label299;
            }
            arrayOfString = str2.split(",");
            setLongitude(dn.f(arrayOfString[0]));
            setLatitude(dn.f(arrayOfString[1]));
            setAccuracy(dn.h(arrayOfString[2]));
          }
          this.n = str1;
        }
        else
        {
          this.d = paramJSONObject.optString("desc", this.d);
          c(paramJSONObject.optString("coord", String.valueOf(this.i)));
          this.m = paramJSONObject.optString("mcell", this.m);
          this.e = paramJSONObject.optBoolean("isReversegeo", this.e);
          this.f = paramJSONObject.optString("geoLanguage", this.f);
          if (dn.a(paramJSONObject, "poiid")) {
            setBuildingId(paramJSONObject.optString("poiid"));
          }
          if (dn.a(paramJSONObject, "pid")) {
            setBuildingId(paramJSONObject.optString("pid"));
          }
          if (dn.a(paramJSONObject, "floor")) {
            setFloor(paramJSONObject.optString("floor"));
          }
          if (dn.a(paramJSONObject, "flr")) {
            setFloor(paramJSONObject.optString("flr"));
          }
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        dg.a(paramJSONObject, "AmapLoc", "AmapLoc");
        return;
      }
      label299:
      i1 += 1;
    }
  }
  
  public final int c()
  {
    return this.i;
  }
  
  public final void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0"))
      {
        i1 = 0;
        break label37;
      }
      if (paramString.equals("1"))
      {
        i1 = 1;
        break label37;
      }
    }
    int i1 = -1;
    label37:
    this.i = i1;
    if (this.i == 0) {}
    for (paramString = "WGS84";; paramString = "GCJ02")
    {
      super.setCoordType(paramString);
      return;
    }
  }
  
  public final String d()
  {
    return this.j;
  }
  
  public final void d(String paramString)
  {
    this.j = paramString;
  }
  
  public final String e()
  {
    return this.k;
  }
  
  public final void e(String paramString)
  {
    this.k = paramString;
  }
  
  public final JSONObject f()
  {
    return this.l;
  }
  
  public final void f(String paramString)
  {
    this.f = paramString;
  }
  
  public final String g()
  {
    return this.m;
  }
  
  public final void g(String paramString)
  {
    this.d = paramString;
  }
  
  public final co h()
  {
    Object localObject = this.m;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = ((String)localObject).split(",");
    if (localObject.length != 3) {
      return null;
    }
    co localco = new co("");
    localco.setProvider(getProvider());
    localco.setLongitude(dn.f(localObject[0]));
    localco.setLatitude(dn.f(localObject[1]));
    localco.setAccuracy(dn.g(localObject[2]));
    localco.setCityCode(getCityCode());
    localco.setAdCode(getAdCode());
    localco.setCountry(getCountry());
    localco.setProvince(getProvince());
    localco.setCity(getCity());
    localco.setTime(getTime());
    localco.k = this.k;
    localco.c(String.valueOf(this.i));
    if (!dn.a(localco)) {
      return null;
    }
    return localco;
  }
  
  public final void h(String paramString)
  {
    this.o = paramString;
  }
  
  public final boolean i()
  {
    return this.e;
  }
  
  public final String j()
  {
    return this.f;
  }
  
  public final String k()
  {
    return this.o;
  }
  
  public final JSONObject toJson(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = super.toJson(paramInt);
      switch (paramInt)
      {
      case 1: 
        localJSONObject.put("retype", this.j);
        localJSONObject.put("cens", this.n);
        localJSONObject.put("coord", this.i);
        localJSONObject.put("mcell", this.m);
        localJSONObject.put("desc", this.d);
        localJSONObject.put("address", getAddress());
        if ((this.l != null) && (dn.a(localJSONObject, "offpct"))) {
          localJSONObject.put("offpct", this.l.getString("offpct"));
        }
      case 2: 
      case 3: 
        localJSONObject.put("type", this.k);
        localJSONObject.put("isReversegeo", this.e);
        localJSONObject.put("geoLanguage", this.f);
        return localJSONObject;
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AmapLoc", "toStr");
      return null;
    }
    return localThrowable;
  }
  
  public final String toStr()
  {
    return toStr(1);
  }
  
  public final String toStr(int paramInt)
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = toJson(paramInt);
      localJSONObject.put("nb", this.o);
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocation", "toStr part2");
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    return ((JSONObject)localObject).toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */