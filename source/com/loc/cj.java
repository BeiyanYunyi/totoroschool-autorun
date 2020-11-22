package com.loc;

public abstract class cj
{
  cj a;
  
  public cj() {}
  
  public cj(cj paramcj)
  {
    this.a = paramcj;
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
  
  public final boolean c()
  {
    boolean bool;
    if (this.a != null) {
      bool = this.a.c();
    } else {
      bool = true;
    }
    if (!bool) {
      return false;
    }
    return a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */