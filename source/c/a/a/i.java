package c.a.a;

import c.a.am;
import c.b.a;
import c.b.c;
import c.m;
import java.io.IOException;

public class i
  implements r
{
  private static c a = c.a(i.class);
  private t b;
  private t c;
  private z d;
  private ab e;
  private boolean f = false;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private double l;
  private double m;
  private int n;
  private ad o = ad.b;
  private q p;
  private o q;
  private ae r;
  private int s;
  private z t;
  private al u;
  private aa v;
  private c.a.o w;
  private c.a.o x;
  private String y;
  private m z;
  
  public i(String paramString, int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.n = 1;
    this.r = ae.d;
    this.y = paramString;
    this.l = 3.0D;
    this.m = 4.0D;
  }
  
  private void h()
  {
    this.b = this.q.a(this.s);
    Object localObject = this.b;
    int i1 = 0;
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    u[] arrayOfu = this.b.b();
    localObject = (ag)this.b.b()[0];
    this.g = this.e.c();
    this.i = ((ag)localObject).b();
    this.r = ae.a(((ag)localObject).c());
    if (this.r == ae.e) {
      a.b("Unknown shape type");
    }
    localObject = null;
    while ((i1 < arrayOfu.length) && (localObject == null))
    {
      if (arrayOfu[i1].k() == w.m) {
        localObject = (e)arrayOfu[i1];
      }
      i1 += 1;
    }
    if (localObject == null)
    {
      a.b("client anchor not found");
    }
    else
    {
      this.j = ((int)((e)localObject).b() - 1);
      this.k = ((int)((e)localObject).c() + 1);
      this.l = (((e)localObject).d() - ((e)localObject).b());
      this.m = (((e)localObject).e() - ((e)localObject).c());
    }
    this.f = true;
  }
  
  private t i()
  {
    if (!this.f) {
      h();
    }
    return this.b;
  }
  
  public String a()
  {
    if (this.y == null)
    {
      boolean bool;
      if (this.w != null) {
        bool = true;
      } else {
        bool = false;
      }
      a.a(bool);
      byte[] arrayOfByte = this.w.a();
      if (arrayOfByte[0] == 0) {
        this.y = am.a(arrayOfByte, arrayOfByte.length - 1, 1, this.z);
      } else {
        this.y = am.a(arrayOfByte, (arrayOfByte.length - 1) / 2, 1);
      }
    }
    return this.y;
  }
  
  public void a(double paramDouble)
  {
    if (this.o == ad.a)
    {
      if (!this.f) {
        h();
      }
      this.o = ad.c;
    }
    this.l = paramDouble;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    if (this.o == ad.a) {
      this.o = ad.c;
    }
  }
  
  public void a(q paramq)
  {
    this.p = paramq;
  }
  
  public void a(c.e.a.ae paramae)
    throws IOException
  {
    if (this.o == ad.a)
    {
      paramae.a(this.e);
      if (this.t != null) {
        paramae.a(this.t);
      }
      paramae.a(this.u);
      paramae.a(this.w);
      if (this.x != null) {
        paramae.a(this.x);
      }
      return;
    }
    paramae.a(new ab(this.g, ab.w));
    paramae.a(new z(new g().a()));
    paramae.a(new al(a()));
    byte[] arrayOfByte = new byte[this.y.length() * 2 + 1];
    arrayOfByte[0] = 1;
    am.b(this.y, arrayOfByte, 1);
    paramae.a(new c.a.o(arrayOfByte));
    arrayOfByte = new byte[16];
    c.a.ag.a(0, arrayOfByte, 0);
    c.a.ag.a(0, arrayOfByte, 2);
    c.a.ag.a(this.y.length(), arrayOfByte, 8);
    c.a.ag.a(0, arrayOfByte, 10);
    paramae.a(new c.a.o(arrayOfByte));
  }
  
  public z b()
  {
    return this.d;
  }
  
  public void b(double paramDouble)
  {
    if (this.o == ad.a)
    {
      if (!this.f) {
        h();
      }
      this.o = ad.c;
    }
    this.m = paramDouble;
  }
  
  public void b(c.e.a.ae paramae)
    throws IOException
  {
    if (this.o == ad.a)
    {
      paramae.a(this.v);
      return;
    }
    paramae.a(new aa(this.j, this.k, this.g));
  }
  
  public t c()
  {
    if (!this.f) {
      h();
    }
    if (this.o == ad.a) {
      return i();
    }
    if (this.c == null)
    {
      this.c = new ah();
      Object localObject = new ag(this.r, this.i, 2560);
      this.c.a((u)localObject);
      localObject = new ac();
      ((ac)localObject).a(344, false, false, 0);
      ((ac)localObject).a(385, false, false, 134217808);
      ((ac)localObject).a(387, false, false, 134217808);
      ((ac)localObject).a(959, false, false, 131074);
      this.c.a((u)localObject);
      double d1 = this.j;
      Double.isNaN(d1);
      double d2 = this.k;
      Double.isNaN(d2);
      d2 = Math.max(0.0D, d2 - 0.6D);
      double d3 = this.j;
      Double.isNaN(d3);
      double d4 = this.l;
      double d5 = this.k;
      double d6 = this.m;
      Double.isNaN(d5);
      localObject = new e(d1 + 1.3D, d2, d3 + 1.3D + d4, d5 + d6, 1);
      this.c.a((u)localObject);
      localObject = new f();
      this.c.a((u)localObject);
      localObject = new g();
      this.c.a((u)localObject);
    }
    return this.c;
  }
  
  public ad d()
  {
    return this.o;
  }
  
  public String e()
  {
    a.a(false);
    return null;
  }
  
  public boolean f()
  {
    return this.d.c();
  }
  
  public boolean g()
  {
    return true;
  }
  
  public int hashCode()
  {
    return this.y.hashCode();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */