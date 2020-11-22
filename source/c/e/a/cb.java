package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import c.a.w;
import c.b.c;
import c.c.i;
import c.c.j;

class cb
  extends aq
{
  c a = c.a(cb.class);
  private byte[] b;
  private double c;
  private double d;
  private j e;
  private i f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  
  public cb(c.k paramk)
  {
    super(an.ai);
    this.e = paramk.a();
    this.f = paramk.b();
    this.c = paramk.e();
    this.d = paramk.f();
    this.g = paramk.c().a();
    this.l = paramk.m();
    this.m = paramk.n();
    this.j = paramk.k();
    this.k = paramk.l();
    this.i = paramk.j();
    this.h = paramk.i();
    this.n = paramk.J();
    this.o = true;
  }
  
  public byte[] a()
  {
    this.b = new byte[34];
    int i1 = this.g;
    byte[] arrayOfByte = this.b;
    int i2 = 0;
    ag.a(i1, arrayOfByte, 0);
    ag.a(this.h, this.b, 2);
    ag.a(this.i, this.b, 4);
    ag.a(this.j, this.b, 6);
    ag.a(this.k, this.b, 8);
    if (this.f == i.b) {
      i2 = 1;
    }
    i1 = i2;
    if (this.e == j.a) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (this.i != 0) {
      i2 = i1 | 0x80;
    }
    i1 = i2;
    if (!this.o) {
      i1 = i2 | 0x4;
    }
    ag.a(i1, this.b, 10);
    ag.a(this.l, this.b, 12);
    ag.a(this.m, this.b, 14);
    w.a(this.c, this.b, 16);
    w.a(this.d, this.b, 24);
    ag.a(this.n, this.b, 32);
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */