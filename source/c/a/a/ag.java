package c.a.a;

import c.b.c;

class ag
  extends s
{
  private static c a = c.a(ag.class);
  private byte[] b;
  private int c;
  private int d;
  private int e;
  
  public ag(ae paramae, int paramInt1, int paramInt2)
  {
    super(w.k);
    c(2);
    this.c = paramae.a();
    this.d = paramInt1;
    this.e = paramInt2;
    b(this.c);
  }
  
  public ag(v paramv)
  {
    super(paramv);
    this.c = j();
    paramv = l();
    this.d = c.a.ag.a(paramv[0], paramv[1], paramv[2], paramv[3]);
    this.e = c.a.ag.a(paramv[4], paramv[5], paramv[6], paramv[7]);
  }
  
  byte[] a()
  {
    this.b = new byte[8];
    c.a.ag.b(this.d, this.b, 0);
    c.a.ag.b(this.e, this.b, 4);
    return a(this.b);
  }
  
  int b()
  {
    return this.d;
  }
  
  int c()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */