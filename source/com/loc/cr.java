package com.loc;

import java.util.Locale;
import org.json.JSONObject;

public final class cr
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = -113;
  public int k = 0;
  public short l = 0;
  public long m = 0L;
  public boolean n = false;
  public int o = 32767;
  public boolean p = true;
  
  public cr(int paramInt, boolean paramBoolean)
  {
    this.k = paramInt;
    this.n = paramBoolean;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.k);
      localJSONObject.put("registered", this.n);
      localJSONObject.put("mcc", this.a);
      localJSONObject.put("mnc", this.b);
      localJSONObject.put("lac", this.c);
      localJSONObject.put("cid", this.d);
      localJSONObject.put("sid", this.g);
      localJSONObject.put("nid", this.h);
      localJSONObject.put("bid", this.i);
      localJSONObject.put("sig", this.j);
      localJSONObject.put("pci", this.o);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "cgi", "toJson");
    }
    return localJSONObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof cr))
    {
      paramObject = (cr)paramObject;
      switch (((cr)paramObject).k)
      {
      default: 
        return false;
      case 4: 
        if (this.k != 4) {
          return false;
        }
        return (((cr)paramObject).c == this.c) && (((cr)paramObject).d == this.d) && (((cr)paramObject).b == this.b);
      case 3: 
        if (this.k != 3) {
          return false;
        }
        return (((cr)paramObject).c == this.c) && (((cr)paramObject).d == this.d) && (((cr)paramObject).b == this.b);
      case 2: 
        if (this.k != 2) {
          return false;
        }
        return (((cr)paramObject).i == this.i) && (((cr)paramObject).h == this.h) && (((cr)paramObject).g == this.g);
      }
      if (this.k != 1) {
        return false;
      }
      if ((((cr)paramObject).c == this.c) && (((cr)paramObject).d == this.d) && (((cr)paramObject).b == this.b)) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i3 = String.valueOf(this.k).hashCode();
    int i1;
    if (this.k == 2) {
      i1 = String.valueOf(this.i).hashCode() + String.valueOf(this.h).hashCode();
    }
    for (int i2 = this.g;; i2 = this.b)
    {
      return i3 + (i1 + String.valueOf(i2).hashCode());
      i1 = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
    }
  }
  
  public final String toString()
  {
    Locale localLocale;
    String str;
    Object[] arrayOfObject;
    switch (this.k)
    {
    default: 
      return "unknown";
    case 4: 
      localLocale = Locale.CHINA;
      str = "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d";
      arrayOfObject = new Object[8];
      arrayOfObject[0] = Integer.valueOf(this.c);
      arrayOfObject[1] = Integer.valueOf(this.d);
      arrayOfObject[2] = Integer.valueOf(this.b);
      arrayOfObject[3] = Boolean.valueOf(this.p);
      arrayOfObject[4] = Integer.valueOf(this.j);
      arrayOfObject[5] = Short.valueOf(this.l);
      arrayOfObject[6] = Boolean.valueOf(this.n);
      arrayOfObject[7] = Integer.valueOf(this.o);
      break;
    case 3: 
      localLocale = Locale.CHINA;
      str = "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d";
      arrayOfObject = new Object[8];
      arrayOfObject[0] = Integer.valueOf(this.c);
      arrayOfObject[1] = Integer.valueOf(this.d);
      arrayOfObject[2] = Integer.valueOf(this.b);
      arrayOfObject[3] = Boolean.valueOf(this.p);
      arrayOfObject[4] = Integer.valueOf(this.j);
      arrayOfObject[5] = Short.valueOf(this.l);
      arrayOfObject[6] = Boolean.valueOf(this.n);
      arrayOfObject[7] = Integer.valueOf(this.o);
      break;
    case 2: 
      localLocale = Locale.CHINA;
      str = "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b";
      arrayOfObject = new Object[7];
      arrayOfObject[0] = Integer.valueOf(this.i);
      arrayOfObject[1] = Integer.valueOf(this.h);
      arrayOfObject[2] = Integer.valueOf(this.g);
      arrayOfObject[3] = Boolean.valueOf(this.p);
      arrayOfObject[4] = Integer.valueOf(this.j);
      arrayOfObject[5] = Short.valueOf(this.l);
      arrayOfObject[6] = Boolean.valueOf(this.n);
      break;
    case 1: 
      localLocale = Locale.CHINA;
      str = "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
      arrayOfObject = new Object[7];
      arrayOfObject[0] = Integer.valueOf(this.c);
      arrayOfObject[1] = Integer.valueOf(this.d);
      arrayOfObject[2] = Integer.valueOf(this.b);
      arrayOfObject[3] = Boolean.valueOf(this.p);
      arrayOfObject[4] = Integer.valueOf(this.j);
      arrayOfObject[5] = Short.valueOf(this.l);
      arrayOfObject[6] = Boolean.valueOf(this.n);
    }
    return String.format(localLocale, str, arrayOfObject);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */