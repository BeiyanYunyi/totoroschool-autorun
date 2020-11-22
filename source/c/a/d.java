package c.a;

import c.a.a.h;
import c.a.a.i;
import c.e.a.j;

public class d
{
  public static c.b.c a = c.b.c.a(d.class);
  public static final a b = new a(q.l);
  public static final a c = new a(q.m);
  public static final a d = new a(q.n);
  public static final a e = new a(q.o);
  public static final a f = new a(q.p);
  public static final a g = new a(q.q);
  public static final a h = new a(q.r);
  public static final a i = new a(q.s);
  private String j;
  private double k;
  private double l;
  private i m;
  private h n;
  private u o;
  private q p;
  private boolean q;
  private boolean r;
  private j s;
  
  private void i()
  {
    this.o = null;
    this.p = null;
    this.q = false;
    this.n = null;
    this.r = false;
  }
  
  protected String a()
  {
    return this.j;
  }
  
  public void a(h paramh)
  {
    this.n = paramh;
  }
  
  public final void a(i parami)
  {
    this.m = parami;
  }
  
  public void a(d paramd)
  {
    if (this.r)
    {
      paramd = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Attempting to share a data validation on cell ");
      localStringBuilder.append(c.c.a(this.s));
      localStringBuilder.append(" which already has a data validation");
      paramd.b(localStringBuilder.toString());
      return;
    }
    i();
    this.p = paramd.h();
    this.o = null;
    this.r = true;
    this.q = paramd.q;
    this.n = paramd.n;
  }
  
  public final void a(j paramj)
  {
    this.s = paramj;
  }
  
  public double b()
  {
    return this.k;
  }
  
  public double c()
  {
    return this.l;
  }
  
  public void d()
  {
    this.j = null;
    if (this.m != null)
    {
      this.s.a(this.m);
      this.m = null;
    }
  }
  
  public void e()
  {
    if (!this.r) {
      return;
    }
    q localq = h();
    if (localq.f())
    {
      c.b.c localc = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot remove data validation from ");
      localStringBuilder.append(c.c.a(this.s));
      localStringBuilder.append(" as it is part of the shared reference ");
      localStringBuilder.append(c.c.a(localq.b(), localq.d()));
      localStringBuilder.append("-");
      localStringBuilder.append(c.c.a(localq.c(), localq.e()));
      localc.b(localStringBuilder.toString());
      return;
    }
    this.s.k();
    i();
  }
  
  public boolean f()
  {
    return this.r;
  }
  
  public boolean g()
  {
    return this.q;
  }
  
  public q h()
  {
    if (this.p != null) {
      return this.p;
    }
    if (this.o != null)
    {
      this.p = new q(this.o.h());
      return this.p;
    }
    return null;
  }
  
  protected static class a
  {
    private static a[] b = new a[0];
    private q.a a;
    
    a(q.a parama)
    {
      this.a = parama;
      parama = b;
      b = new a[parama.length + 1];
      System.arraycopy(parama, 0, b, 0, parama.length);
      b[parama.length] = this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */