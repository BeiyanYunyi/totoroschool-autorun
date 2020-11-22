package com.amap.api.mapcore.util;

import com.amap.api.maps.model.BitmapDescriptor;

public class lu
{
  private String a;
  private BitmapDescriptor b;
  private int c;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 1.0F;
  private float g = 1.0F;
  private boolean h = false;
  private float i = 0.0F;
  private float j = 0.0F;
  private float k = 0.0F;
  private float l = 0.0F;
  private int m = 0;
  
  public lu(BitmapDescriptor paramBitmapDescriptor, int paramInt)
  {
    this.b = paramBitmapDescriptor;
    this.c = paramInt;
    this.a = dp.a();
  }
  
  public void a(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public float b()
  {
    return this.k;
  }
  
  public void b(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public float c()
  {
    return this.l;
  }
  
  public void c(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public float d()
  {
    return this.i;
  }
  
  public void d(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public float e()
  {
    return this.j;
  }
  
  public void e(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public float f()
  {
    return this.e;
  }
  
  public void f(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public float g()
  {
    return this.d;
  }
  
  public void g(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public float h()
  {
    return this.f;
  }
  
  public void h(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public float i()
  {
    return this.g;
  }
  
  public BitmapDescriptor j()
  {
    return this.b;
  }
  
  public int k()
  {
    return this.c;
  }
  
  public void l()
  {
    this.m += 1;
  }
  
  public void m()
  {
    this.m -= 1;
  }
  
  public int n()
  {
    return this.m;
  }
  
  public String o()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */