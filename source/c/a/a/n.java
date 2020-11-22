package c.a.a;

import c.b.a;
import c.b.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class n
  implements r
{
  public static a a = new a(1);
  public static a b = new a(2);
  public static a c = new a(3);
  private static c d = c.a(n.class);
  private t e;
  private z f;
  private ab g;
  private boolean h;
  private File i;
  private byte[] j;
  private int k;
  private int l;
  private double m;
  private double n;
  private double o;
  private double p;
  private int q;
  private ad r;
  private q s;
  private o t;
  private ae u;
  private int v;
  private int w;
  private a x;
  
  private void m()
  {
    this.e = this.t.a(this.w);
    Object localObject = this.e;
    int i1 = 0;
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    u[] arrayOfu = this.e.b();
    localObject = (ag)this.e.b()[0];
    this.v = ((ag)localObject).b();
    this.k = this.g.c();
    this.u = ae.a(((ag)localObject).c());
    if (this.u == ae.e) {
      d.b("Unknown shape type");
    }
    localObject = (ac)this.e.b()[1];
    if (((ac)localObject).a(260) != null) {
      this.l = ((ac)localObject).a(260).d;
    }
    if (((ac)localObject).a(261) != null)
    {
      this.i = new File(((ac)localObject).a(261).e);
    }
    else if (this.u == ae.b)
    {
      d.b("no filename property for drawing");
      this.i = new File(Integer.toString(this.l));
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
      d.b("client anchor not found");
    }
    else
    {
      this.m = ((e)localObject).b();
      this.n = ((e)localObject).c();
      this.o = (((e)localObject).d() - this.m);
      this.p = (((e)localObject).e() - this.n);
      this.x = a.a(((e)localObject).f());
    }
    if (this.l == 0) {
      d.b("linked drawings are not supported");
    }
    this.h = true;
  }
  
  private t n()
  {
    if (!this.h) {
      m();
    }
    return this.e;
  }
  
  public final int a()
  {
    if (!this.h) {
      m();
    }
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    this.v = paramInt3;
    if (this.r == ad.a) {
      this.r = ad.c;
    }
  }
  
  public void a(q paramq)
  {
    this.s = paramq;
  }
  
  public void a(c.e.a.ae paramae)
    throws IOException
  {
    if (this.r == ad.a)
    {
      paramae.a(this.g);
      return;
    }
    paramae.a(new ab(this.k, ab.i));
  }
  
  public z b()
  {
    return this.f;
  }
  
  public void b(c.e.a.ae paramae)
    throws IOException
  {}
  
  public t c()
  {
    if (!this.h) {
      m();
    }
    if (this.r == ad.a) {
      return n();
    }
    ah localah = new ah();
    localah.a(new ag(this.u, this.v, 2560));
    ac localac = new ac();
    localac.a(260, true, false, this.l);
    if (this.u == ae.b)
    {
      if (this.i != null) {}
      for (String str = this.i.getPath();; str = "") {
        break;
      }
      localac.a(261, true, true, str.length() * 2, str);
      localac.a(447, false, false, 65536);
      localac.a(959, false, false, 524288);
      localah.a(localac);
    }
    localah.a(new e(this.m, this.n, this.m + this.o, this.n + this.p, this.x.a()));
    localah.a(new f());
    return localah;
  }
  
  public ad d()
  {
    return this.r;
  }
  
  public String e()
  {
    if (this.i == null)
    {
      if (this.l != 0) {
        return Integer.toString(this.l);
      }
      return "__new__image__";
    }
    return this.i.getPath();
  }
  
  public boolean f()
  {
    return this.f.c();
  }
  
  public boolean g()
  {
    return false;
  }
  
  public int h()
  {
    if (!this.h) {
      m();
    }
    return this.v;
  }
  
  public final int i()
  {
    if (!this.h) {
      m();
    }
    return this.l;
  }
  
  public int j()
  {
    return this.q;
  }
  
  public byte[] k()
  {
    boolean bool;
    if ((this.r != ad.a) && (this.r != ad.c)) {
      bool = false;
    } else {
      bool = true;
    }
    a.a(bool);
    if (!this.h) {
      m();
    }
    return this.s.a(this.l);
  }
  
  public byte[] l()
    throws IOException
  {
    if ((this.r != ad.a) && (this.r != ad.c))
    {
      Object localObject1 = this.r;
      Object localObject2 = ad.b;
      boolean bool2 = true;
      boolean bool1;
      if (localObject1 == localObject2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      a.a(bool1);
      if (this.i == null)
      {
        if (this.j != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        a.a(bool1);
        return this.j;
      }
      localObject1 = new byte[(int)this.i.length()];
      localObject2 = new FileInputStream(this.i);
      ((FileInputStream)localObject2).read((byte[])localObject1, 0, localObject1.length);
      ((FileInputStream)localObject2).close();
      return (byte[])localObject1;
    }
    return k();
  }
  
  protected static class a
  {
    private static a[] b = new a[0];
    private int a;
    
    a(int paramInt)
    {
      this.a = paramInt;
      a[] arrayOfa = b;
      b = new a[arrayOfa.length + 1];
      System.arraycopy(arrayOfa, 0, b, 0, arrayOfa.length);
      b[arrayOfa.length] = this;
    }
    
    static a a(int paramInt)
    {
      a locala = n.a;
      int i = 0;
      while (i < b.length)
      {
        if (b[i].a() == paramInt) {
          return b[i];
        }
        i += 1;
      }
      return locala;
    }
    
    int a()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */