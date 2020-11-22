package c.a.a;

import c.a.ag;
import c.b.c;

class e
  extends s
{
  private static final c a = c.a(e.class);
  private byte[] b;
  private int c;
  private double d;
  private double e;
  private double f;
  private double g;
  
  public e(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    super(w.m);
    this.d = paramDouble1;
    this.e = paramDouble2;
    this.f = paramDouble3;
    this.g = paramDouble4;
    this.c = paramInt;
  }
  
  public e(v paramv)
  {
    super(paramv);
    paramv = l();
    this.c = ag.a(paramv[0], paramv[1]);
    int i = ag.a(paramv[2], paramv[3]);
    int j = ag.a(paramv[4], paramv[5]);
    double d1 = i;
    double d2 = j;
    Double.isNaN(d2);
    d2 /= 1024.0D;
    Double.isNaN(d1);
    this.d = (d1 + d2);
    i = ag.a(paramv[6], paramv[7]);
    j = ag.a(paramv[8], paramv[9]);
    d1 = i;
    d2 = j;
    Double.isNaN(d2);
    d2 /= 256.0D;
    Double.isNaN(d1);
    this.e = (d1 + d2);
    i = ag.a(paramv[10], paramv[11]);
    j = ag.a(paramv[12], paramv[13]);
    d1 = i;
    d2 = j;
    Double.isNaN(d2);
    d2 /= 1024.0D;
    Double.isNaN(d1);
    this.f = (d1 + d2);
    i = ag.a(paramv[14], paramv[15]);
    j = ag.a(paramv[16], paramv[17]);
    d1 = i;
    d2 = j;
    Double.isNaN(d2);
    d2 /= 256.0D;
    Double.isNaN(d1);
    this.g = (d1 + d2);
  }
  
  byte[] a()
  {
    this.b = new byte[18];
    ag.a(this.c, this.b, 0);
    ag.a((int)this.d, this.b, 2);
    double d1 = this.d;
    double d2 = (int)this.d;
    Double.isNaN(d2);
    ag.a((int)((d1 - d2) * 1024.0D), this.b, 4);
    ag.a((int)this.e, this.b, 6);
    d1 = this.e;
    d2 = (int)this.e;
    Double.isNaN(d2);
    ag.a((int)((d1 - d2) * 256.0D), this.b, 8);
    ag.a((int)this.f, this.b, 10);
    d1 = this.f;
    d2 = (int)this.f;
    Double.isNaN(d2);
    ag.a((int)((d1 - d2) * 1024.0D), this.b, 12);
    ag.a((int)this.g, this.b, 14);
    d1 = this.g;
    d2 = (int)this.g;
    Double.isNaN(d2);
    ag.a((int)((d1 - d2) * 256.0D), this.b, 16);
    return a(this.b);
  }
  
  double b()
  {
    return this.d;
  }
  
  double c()
  {
    return this.e;
  }
  
  double d()
  {
    return this.f;
  }
  
  double e()
  {
    return this.g;
  }
  
  int f()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */