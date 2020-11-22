package c.a.a;

import c.a.af;
import c.a.ag;
import c.a.an;
import c.a.j;
import c.b.c;
import c.d.a.e;

public class d
  implements x, j
{
  private static final c a = c.a(d.class);
  private z b;
  private ab c;
  private int d;
  private int e;
  private c.d.a.d f;
  private o g;
  private int h;
  private byte[] i;
  private boolean j;
  
  private void e()
  {
    this.i = this.f.a(this.d, this.e - this.d);
    this.j = true;
  }
  
  public void a(af paramaf1, af paramaf2, af paramaf3)
  {
    if (!this.j) {
      e();
    }
    int k = 0;
    while (k < this.i.length)
    {
      int m = ag.a(this.i[k], this.i[(k + 1)]);
      int i1 = ag.a(this.i[(k + 2)], this.i[(k + 3)]);
      paramaf1 = an.a(m);
      if (paramaf1 == an.bi)
      {
        paramaf1 = this.i;
        m = k + 4;
        ag.a(paramaf2.a(ag.a(paramaf1[m], this.i[(k + 5)])), this.i, m);
      }
      else if (paramaf1 == an.bk)
      {
        paramaf1 = this.i;
        m = k + 12;
        ag.a(paramaf2.a(ag.a(paramaf1[m], this.i[(k + 13)])), this.i, m);
      }
      else if (paramaf1 == an.bj)
      {
        paramaf1 = this.i;
        m = k + 4;
        ag.a(paramaf3.a(ag.a(paramaf1[m], this.i[(k + 5)])), this.i, m);
      }
      else if (paramaf1 == an.bl)
      {
        int i2 = ag.a(this.i[(k + 4)], this.i[(k + 5)]);
        int n = k + 6;
        m = 0;
        while (m < i2)
        {
          paramaf1 = this.i;
          int i3 = n + 2;
          ag.a(paramaf2.a(ag.a(paramaf1[i3], this.i[(n + 3)])), this.i, i3);
          n += 4;
          m += 1;
        }
      }
      k += i1 + 4;
    }
  }
  
  public byte[] a()
  {
    return this.b.l_().a();
  }
  
  t b()
  {
    return this.g.a(this.h);
  }
  
  z c()
  {
    return this.b;
  }
  
  ab d()
  {
    return this.c;
  }
  
  public byte[] g()
  {
    if (!this.j) {
      e();
    }
    return this.i;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */