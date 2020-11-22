package com.bumptech.glide.f;

public class f
  implements b, c
{
  private b a;
  private b b;
  private c c;
  
  public f()
  {
    this(null);
  }
  
  public f(c paramc)
  {
    this.c = paramc;
  }
  
  private boolean j()
  {
    return (this.c == null) || (this.c.a(this));
  }
  
  private boolean k()
  {
    return (this.c == null) || (this.c.b(this));
  }
  
  private boolean l()
  {
    return (this.c != null) && (this.c.c());
  }
  
  public void a()
  {
    this.a.a();
    this.b.a();
  }
  
  public void a(b paramb1, b paramb2)
  {
    this.a = paramb1;
    this.b = paramb2;
  }
  
  public boolean a(b paramb)
  {
    return (j()) && ((paramb.equals(this.a)) || (!this.a.h()));
  }
  
  public void b()
  {
    if (!this.b.f()) {
      this.b.b();
    }
    if (!this.a.f()) {
      this.a.b();
    }
  }
  
  public boolean b(b paramb)
  {
    return (k()) && (paramb.equals(this.a)) && (!c());
  }
  
  public void c(b paramb)
  {
    if (paramb.equals(this.b)) {
      return;
    }
    if (this.c != null) {
      this.c.c(this);
    }
    if (!this.b.g()) {
      this.b.d();
    }
  }
  
  public boolean c()
  {
    return (l()) || (h());
  }
  
  public void d()
  {
    this.b.d();
    this.a.d();
  }
  
  public void e()
  {
    this.a.e();
    this.b.e();
  }
  
  public boolean f()
  {
    return this.a.f();
  }
  
  public boolean g()
  {
    return (this.a.g()) || (this.b.g());
  }
  
  public boolean h()
  {
    return (this.a.h()) || (this.b.h());
  }
  
  public boolean i()
  {
    return this.a.i();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */