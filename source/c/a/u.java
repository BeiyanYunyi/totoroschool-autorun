package c.a;

import c.a.b.t;
import c.b.c;
import c.m;

public class u
  extends aq
{
  private static c a = c.a(u.class);
  private byte[] b;
  private q c;
  private ao d;
  private t e;
  private m f;
  private s g;
  
  public u(q paramq)
  {
    super(an.be);
    this.c = paramq;
  }
  
  private void i()
  {
    if (this.c == null) {
      this.c = new q(this.b, this.e, this.d, this.f);
    }
  }
  
  void a(s params)
  {
    this.g = params;
  }
  
  public byte[] a()
  {
    if (this.c == null) {
      return this.b;
    }
    return this.c.a();
  }
  
  public int c()
  {
    if (this.c == null) {
      i();
    }
    return this.c.b();
  }
  
  public int d()
  {
    if (this.c == null) {
      i();
    }
    return this.c.c();
  }
  
  public int e()
  {
    if (this.c == null) {
      i();
    }
    return this.c.d();
  }
  
  public int f()
  {
    if (this.c == null) {
      i();
    }
    return this.c.e();
  }
  
  q h()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */