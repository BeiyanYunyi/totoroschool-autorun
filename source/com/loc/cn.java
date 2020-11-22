package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;

public final class cn
{
  co a = null;
  long b = 0L;
  long c = 0L;
  int d = 0;
  long e = 0L;
  AMapLocation f = null;
  long g = 0L;
  private boolean h = true;
  
  private co b(co paramco)
  {
    if (dn.a(paramco))
    {
      int i;
      if ((this.h) && (df.b(paramco.getTime())))
      {
        if ((paramco.getLocationType() != 5) && (paramco.getLocationType() != 6)) {
          return paramco;
        }
        i = 4;
      }
      else
      {
        i = this.d;
      }
      paramco.setLocationType(i);
    }
    return paramco;
  }
  
  public final AMapLocation a(AMapLocation paramAMapLocation)
  {
    if (!dn.a(paramAMapLocation)) {
      return paramAMapLocation;
    }
    long l1 = dn.b();
    long l2 = this.g;
    this.g = dn.b();
    if (l1 - l2 > 5000L) {
      return paramAMapLocation;
    }
    if (this.f == null)
    {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    }
    if ((1 != this.f.getLocationType()) && (!"gps".equalsIgnoreCase(this.f.getProvider())))
    {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    }
    if ((this.f.getAltitude() == paramAMapLocation.getAltitude()) && (this.f.getLongitude() == paramAMapLocation.getLongitude()))
    {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    }
    l1 = Math.abs(paramAMapLocation.getTime() - this.f.getTime());
    if (30000L < l1)
    {
      this.f = paramAMapLocation;
      return paramAMapLocation;
    }
    float f1 = (this.f.getSpeed() + paramAMapLocation.getSpeed()) * (float)l1 / 2000.0F;
    if (dn.a(paramAMapLocation, this.f) > f1 + (this.f.getAccuracy() + paramAMapLocation.getAccuracy()) * 2.0F + 3000.0F) {
      return this.f;
    }
    this.f = paramAMapLocation;
    return paramAMapLocation;
  }
  
  public final co a(co paramco)
  {
    co localco = paramco;
    if (dn.b() - this.e > 30000L)
    {
      this.a = localco;
      this.e = dn.b();
      return this.a;
    }
    this.e = dn.b();
    if ((dn.a(this.a)) && (dn.a(paramco)))
    {
      if ((paramco.getTime() == this.a.getTime()) && (paramco.getAccuracy() < 300.0F)) {
        return localco;
      }
      if (!paramco.getProvider().equals("gps")) {
        break label119;
      }
    }
    label110:
    label119:
    while ((paramco.c() != this.a.c()) || ((!paramco.getBuildingId().equals(this.a.getBuildingId())) && (!TextUtils.isEmpty(paramco.getBuildingId()))))
    {
      this.b = dn.b();
      this.a = localco;
      break;
    }
    this.d = paramco.getLocationType();
    float f1 = dn.a(localco, this.a);
    float f2 = this.a.getAccuracy();
    float f3 = paramco.getAccuracy();
    float f4 = f3 - f2;
    long l1 = dn.b();
    long l2 = this.b;
    int k = 0;
    int i;
    if ((f2 <= 100.0F) && (f3 > 299.0F)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (f2 > 299.0F)
    {
      j = k;
      if (f3 > 299.0F) {
        j = 1;
      }
    }
    if ((i == 0) && (j == 0)) {
      if ((f3 >= 100.0F) || (f2 <= 299.0F)) {}
    }
    for (;;)
    {
      this.b = l1;
      this.a = localco;
      this.c = 0L;
      break;
      if (f3 <= 299.0F) {
        this.c = 0L;
      }
      if ((f1 < 10.0F) && (f1 > 0.1D) && (f3 > 5.0F)) {
        if (f4 < -300.0F) {}
      }
      label433:
      do
      {
        for (;;)
        {
          localco = b(this.a);
          break label110;
          if (f2 / f3 >= 2.0F)
          {
            this.b = l1;
            break label110;
            if (f4 < 300.0F) {
              break;
            }
            if (l1 - l2 >= 30000L)
            {
              break;
              if (this.c != 0L) {
                break label433;
              }
              this.c = l1;
            }
          }
        }
      } while (l1 - this.c <= 30000L);
    }
  }
  
  public final void a()
  {
    this.a = null;
    this.b = 0L;
    this.c = 0L;
    this.f = null;
    this.g = 0L;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */