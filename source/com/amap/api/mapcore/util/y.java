package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.IPoint;

public class y
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt3;
    this.c = paramInt2;
    this.d = paramInt4;
    this.e = ((paramInt1 + paramInt2) / 2);
    this.f = ((paramInt3 + paramInt4) / 2);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (this.a <= paramInt1) && (paramInt1 <= this.c) && (this.b <= paramInt2) && (paramInt2 <= this.d);
  }
  
  public boolean a(y paramy)
  {
    if (paramy == null) {
      return false;
    }
    return b(paramy.a, paramy.c, paramy.b, paramy.d);
  }
  
  public boolean a(IPoint paramIPoint)
  {
    if (paramIPoint == null) {
      return false;
    }
    return a(paramIPoint.x, paramIPoint.y);
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 < this.c) && (this.a < paramInt2) && (paramInt3 < this.d) && (this.b < paramInt4);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */