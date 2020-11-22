package c.e.a;

import c.a.a.i;
import c.a.a.r;
import c.a.ad;
import c.a.ag;
import c.a.ai;
import c.a.an;
import c.a.aq;
import c.a.as;
import c.a.b.v;
import c.a.q;
import c.b;
import c.b.a;
import c.c.d;
import c.e.g;
import c.e.m;

public abstract class j
  extends aq
  implements g
{
  private static c.b.c a = c.b.c.a(j.class);
  private int b;
  private int c;
  private as d;
  private ad e;
  private boolean f;
  private cv g;
  private c.e.h h;
  private boolean i;
  
  protected j(an paraman, int paramInt1, int paramInt2)
  {
    this(paraman, paramInt1, paramInt2, m.c);
    this.i = false;
  }
  
  protected j(an paraman, int paramInt1, int paramInt2, d paramd)
  {
    super(paraman);
    this.b = paramInt2;
    this.c = paramInt1;
    this.d = ((as)paramd);
    this.f = false;
    this.i = false;
  }
  
  private void l()
  {
    cg localcg = this.g.i().g();
    this.d = localcg.a(this.d);
    try
    {
      if (this.d.k()) {
        break label61;
      }
      this.e.a(this.d);
      return;
    }
    catch (ai localai)
    {
      label61:
      for (;;) {}
    }
    a.b("Maximum number of format records exceeded.  Using default format.");
    this.d = localcg.a();
  }
  
  public final void a(i parami)
  {
    this.g.b(parami);
  }
  
  void a(ad paramad, cc paramcc, cv paramcv)
  {
    this.f = true;
    this.g = paramcv;
    this.e = paramad;
    l();
    j();
  }
  
  public void a(d paramd)
  {
    this.d = ((as)paramd);
    if (!this.f) {
      return;
    }
    boolean bool;
    if (this.e != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    l();
  }
  
  public void a(c.e.h paramh)
  {
    if (this.h != null)
    {
      c.b.c localc = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current cell features for ");
      localStringBuilder.append(c.c.a(this));
      localStringBuilder.append(" not null - overwriting");
      localc.b(localStringBuilder.toString());
      if ((this.h.f()) && (this.h.h() != null) && (this.h.h().f()))
      {
        paramh = this.h.h();
        localc = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot add cell features to ");
        localStringBuilder.append(c.c.a(this));
        localStringBuilder.append(" because it is part of the shared cell validation ");
        localStringBuilder.append("group ");
        localStringBuilder.append(c.c.a(paramh.b(), paramh.d()));
        localStringBuilder.append("-");
        localStringBuilder.append(c.c.a(paramh.c(), paramh.e()));
        localc.b(localStringBuilder.toString());
        return;
      }
    }
    this.h = paramh;
    paramh.a(this);
    if (this.f) {
      j();
    }
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[6];
    ag.a(this.b, arrayOfByte, 0);
    ag.a(this.c, arrayOfByte, 2);
    ag.a(this.d.j(), arrayOfByte, 4);
    return arrayOfByte;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public d e()
  {
    return this.d;
  }
  
  public b f()
  {
    return this.h;
  }
  
  final boolean h()
  {
    return this.f;
  }
  
  final int i()
  {
    return this.d.j();
  }
  
  public final void j()
  {
    if (this.h == null) {
      return;
    }
    if (this.i == true)
    {
      this.i = false;
      return;
    }
    Object localObject;
    if (this.h.a() != null)
    {
      localObject = new i(this.h.a(), this.c, this.b);
      ((i)localObject).a(this.h.b());
      ((i)localObject).b(this.h.c());
      this.g.a((r)localObject);
      this.g.i().a((r)localObject);
      this.h.a((i)localObject);
    }
    if (this.h.f()) {}
    try
    {
      this.h.h().a(this.c, this.b, this.g.i(), this.g.i(), this.g.f());
    }
    catch (v localv)
    {
      for (;;) {}
    }
    a.a(false);
    this.g.b(this);
    if (!this.h.g()) {
      return;
    }
    if (this.g.k() == null)
    {
      localObject = new c.a.a.h();
      this.g.a((r)localObject);
      this.g.i().a((r)localObject);
      this.g.a((c.a.a.h)localObject);
    }
    this.h.a(this.g.k());
  }
  
  public int j_()
  {
    return this.b;
  }
  
  public final void k()
  {
    this.g.a(this);
  }
  
  public c.e.h k_()
  {
    return this.h;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */