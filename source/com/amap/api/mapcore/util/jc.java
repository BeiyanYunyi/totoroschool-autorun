package com.amap.api.mapcore.util;

public abstract class jc
{
  jc a;
  
  public jc() {}
  
  public jc(jc paramjc)
  {
    this.a = paramjc;
  }
  
  private boolean d()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return true;
  }
  
  public void a(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
  
  protected abstract boolean a();
  
  public int b()
  {
    int i;
    if (this.a != null) {
      i = this.a.b();
    } else {
      i = Integer.MAX_VALUE;
    }
    return Math.min(Integer.MAX_VALUE, i);
  }
  
  public boolean c()
  {
    if (!d()) {
      return false;
    }
    return a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */