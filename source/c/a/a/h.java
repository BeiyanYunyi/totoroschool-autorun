package c.a.a;

import c.b.a;
import c.b.c;
import java.io.IOException;

public class h
  implements r
{
  private static c a = c.a(h.class);
  private t b;
  private z c;
  private ab d;
  private boolean e = false;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = 1;
  private ad l = ad.b;
  private q m;
  private o n;
  private ae o = ae.c;
  private int p;
  
  private void h()
  {
    this.b = this.n.a(this.p);
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
    this.f = this.d.c();
    this.h = ((ag)localObject).b();
    this.o = ae.a(((ag)localObject).c());
    if (this.o == ae.e) {
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
      a.b("Client anchor not found");
    }
    else
    {
      this.i = ((int)((e)localObject).b());
      this.j = ((int)((e)localObject).c());
    }
    this.e = true;
  }
  
  private t i()
  {
    if (!this.e) {
      h();
    }
    return this.b;
  }
  
  public final int a()
  {
    if (!this.e) {
      h();
    }
    return this.f;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    if (this.l == ad.a) {
      this.l = ad.c;
    }
  }
  
  public void a(q paramq)
  {
    this.m = paramq;
  }
  
  public void a(c.e.a.ae paramae)
    throws IOException
  {
    if (this.l == ad.a)
    {
      paramae.a(this.d);
      return;
    }
    paramae.a(new ab(this.f, ab.t));
  }
  
  public z b()
  {
    return this.c;
  }
  
  public void b(c.e.a.ae paramae) {}
  
  public t c()
  {
    if (!this.e) {
      h();
    }
    if (this.l == ad.a) {
      return i();
    }
    ah localah = new ah();
    localah.a(new ag(this.o, this.h, 2560));
    ac localac = new ac();
    localac.a(127, false, false, 17039620);
    localac.a(191, false, false, 524296);
    localac.a(511, false, false, 524288);
    localac.a(959, false, false, 131072);
    localah.a(localac);
    localah.a(new e(this.i, this.j, this.i + 1, this.j + 1, 1));
    localah.a(new f());
    return localah;
  }
  
  public ad d()
  {
    return this.l;
  }
  
  public String e()
  {
    a.a(false);
    return null;
  }
  
  public boolean f()
  {
    return this.c.c();
  }
  
  public boolean g()
  {
    return false;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */