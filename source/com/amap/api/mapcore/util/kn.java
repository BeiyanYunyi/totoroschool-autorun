package com.amap.api.mapcore.util;

import android.text.TextUtils;

public final class kn
{
  private static kn b;
  long a = 0L;
  private le c = null;
  private long d = 0L;
  private long e = 0L;
  
  public static kn a()
  {
    try
    {
      if (b == null) {
        b = new kn();
      }
      kn localkn = b;
      return localkn;
    }
    finally {}
  }
  
  public static le b(le paramle)
  {
    return paramle;
  }
  
  public final le a(le paramle)
  {
    if (lj.b() - this.a > 30000L)
    {
      this.c = paramle;
      this.a = lj.b();
      return this.c;
    }
    this.a = lj.b();
    if ((ku.a(this.c)) && (ku.a(paramle)))
    {
      if ((paramle.getTime() == this.c.getTime()) && (paramle.getAccuracy() < 300.0F)) {
        return paramle;
      }
      if (!paramle.getProvider().equalsIgnoreCase("gps")) {
        break label113;
      }
    }
    label98:
    label113:
    float f4;
    long l1;
    long l2;
    label404:
    label409:
    do
    {
      for (this.d = lj.b();; this.d = l1)
      {
        this.c = paramle;
        break;
        if ((paramle.c() != this.c.c()) || ((!paramle.getBuildingId().equals(this.c.getBuildingId())) && (!TextUtils.isEmpty(paramle.getBuildingId())))) {
          break label98;
        }
        float f1 = lj.a(new double[] { paramle.getLatitude(), paramle.getLongitude(), this.c.getLatitude(), this.c.getLongitude() });
        float f2 = this.c.getAccuracy();
        float f3 = paramle.getAccuracy();
        f4 = f3 - f2;
        l1 = lj.b();
        l2 = this.d;
        if (((f2 < 101.0F) && (f3 > 299.0F)) || ((f2 > 299.0F) && (f3 > 299.0F))) {
          if (this.e == 0L) {
            this.e = l1;
          } else if (l1 - this.e <= 30000L) {}
        }
        while ((f3 < 101.0F) && (f2 > 299.0F))
        {
          this.d = l1;
          this.c = paramle;
          this.e = 0L;
          break;
          return this.c;
        }
        if (f3 <= 299.0F) {
          this.e = 0L;
        }
        if ((f1 >= 10.0F) || (f1 <= 0.1D) || (f3 <= 5.0F)) {
          break label409;
        }
        if (f4 >= -300.0F) {
          return this.c;
        }
        if (f2 / f3 < 2.0F) {
          break label404;
        }
      }
      return this.c;
    } while ((f4 < 300.0F) || (l1 - l2 >= 30000L));
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */