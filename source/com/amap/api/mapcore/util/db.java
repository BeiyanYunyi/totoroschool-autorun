package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;

public class db
{
  public final double a;
  public final double b;
  public final double c;
  public final double d;
  public final double e;
  public final double f;
  
  public db(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a = paramDouble1;
    this.b = paramDouble3;
    this.c = paramDouble2;
    this.d = paramDouble4;
    this.e = ((paramDouble1 + paramDouble2) / 2.0D);
    this.f = ((paramDouble3 + paramDouble4) / 2.0D);
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    return (this.a <= paramDouble1) && (paramDouble1 <= this.c) && (this.b <= paramDouble2) && (paramDouble2 <= this.d);
  }
  
  public boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (paramDouble1 < this.c) && (this.a < paramDouble2) && (paramDouble3 < this.d) && (this.b < paramDouble4);
  }
  
  public boolean a(db paramdb)
  {
    return a(paramdb.a, paramdb.c, paramdb.b, paramdb.d);
  }
  
  public boolean a(DPoint paramDPoint)
  {
    return a(paramDPoint.x, paramDPoint.y);
  }
  
  public boolean b(db paramdb)
  {
    return (paramdb.a >= this.a) && (paramdb.c <= this.c) && (paramdb.b >= this.b) && (paramdb.d <= this.d);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */