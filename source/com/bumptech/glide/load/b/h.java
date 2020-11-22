package com.bumptech.glide.load.b;

import android.os.Looper;
import com.bumptech.glide.load.c;

class h<Z>
  implements k<Z>
{
  private final k<Z> a;
  private final boolean b;
  private a c;
  private c d;
  private int e;
  private boolean f;
  
  h(k<Z> paramk, boolean paramBoolean)
  {
    if (paramk != null)
    {
      this.a = paramk;
      this.b = paramBoolean;
      return;
    }
    throw new NullPointerException("Wrapped resource must not be null");
  }
  
  void a(c paramc, a parama)
  {
    this.d = paramc;
    this.c = parama;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public Z b()
  {
    return (Z)this.a.b();
  }
  
  public int c()
  {
    return this.a.c();
  }
  
  public void d()
  {
    if (this.e <= 0)
    {
      if (!this.f)
      {
        this.f = true;
        this.a.d();
        return;
      }
      throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
    }
    throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
  }
  
  void e()
  {
    if (!this.f)
    {
      if (Looper.getMainLooper().equals(Looper.myLooper()))
      {
        this.e += 1;
        return;
      }
      throw new IllegalThreadStateException("Must call acquire on the main thread");
    }
    throw new IllegalStateException("Cannot acquire a recycled resource");
  }
  
  void f()
  {
    if (this.e > 0)
    {
      if (Looper.getMainLooper().equals(Looper.myLooper()))
      {
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
          this.c.b(this.d, this);
        }
        return;
      }
      throw new IllegalThreadStateException("Must call release on the main thread");
    }
    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
  }
  
  static abstract interface a
  {
    public abstract void b(c paramc, h<?> paramh);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */