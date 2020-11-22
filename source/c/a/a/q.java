package c.a.a;

import c.b.c;
import c.e.a.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class q
  implements x
{
  private static c a = c.a(q.class);
  private byte[] b;
  private t c;
  private a d;
  private boolean e;
  private ArrayList f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  private ad k;
  private HashMap l;
  private int m;
  private int n;
  
  public q(ad paramad)
  {
    this.k = paramad;
    boolean bool;
    if (paramad == ad.b) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    this.f = new ArrayList();
    this.l = new HashMap();
    this.j = false;
    this.m = 1;
    this.n = 1024;
  }
  
  private void c()
  {
    boolean bool2 = false;
    v localv = new v(this, 0);
    c.b.a.a(localv.a());
    this.c = new t(localv);
    if (this.c.g() == this.b.length) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    c.b.a.a(bool1);
    boolean bool1 = bool2;
    if (this.c.k() == w.b) {
      bool1 = true;
    }
    c.b.a.a(bool1);
    this.e = true;
  }
  
  private a d()
  {
    if (this.d == null)
    {
      if (!this.e) {
        c();
      }
      u[] arrayOfu = this.c.b();
      if ((arrayOfu.length > 1) && (arrayOfu[1].k() == w.c)) {
        this.d = ((a)arrayOfu[1]);
      }
    }
    return this.d;
  }
  
  public void a(r paramr)
  {
    if (this.k == ad.a)
    {
      this.k = ad.c;
      localObject = d();
      u[] arrayOfu = this.c.b();
      boolean bool = false;
      this.i = (((l)arrayOfu[0]).a(1).a - this.g - 1);
      int i1;
      if (localObject != null) {
        i1 = ((a)localObject).h_();
      } else {
        i1 = 0;
      }
      this.g = i1;
      if (localObject != null)
      {
        if (this.g == ((a)localObject).h_()) {
          bool = true;
        }
        c.b.a.a(bool);
      }
    }
    if (!(paramr instanceof n))
    {
      this.m += 1;
      this.n += 1;
      paramr.a(this);
      paramr.a(this.m, this.g + 1, this.n);
      if (this.f.size() > this.m)
      {
        paramr = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("drawings length ");
        ((StringBuilder)localObject).append(this.f.size());
        ((StringBuilder)localObject).append(" exceeds the max object id ");
        ((StringBuilder)localObject).append(this.m);
        paramr.b(((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = (n)paramr;
    paramr = (n)this.l.get(paramr.e());
    if (paramr == null)
    {
      this.m += 1;
      this.n += 1;
      this.f.add(localObject);
      ((n)localObject).a(this);
      ((n)localObject).a(this.m, this.g + 1, this.n);
      this.g += 1;
      this.l.put(((n)localObject).e(), localObject);
      return;
    }
    paramr.a(paramr.j() + 1);
    ((n)localObject).a(this);
    ((n)localObject).a(paramr.a(), paramr.i(), paramr.h());
  }
  
  public void a(ae paramae)
    throws IOException
  {
    Object localObject1 = this.k;
    Object localObject2 = ad.b;
    int i1 = 0;
    Object localObject3;
    Object localObject4;
    if (localObject1 == localObject2)
    {
      localObject1 = new m();
      localObject2 = new l(this.g + this.h + 1, this.g);
      ((l)localObject2).a(1, 0);
      ((l)localObject2).a(this.g + 1, 0);
      ((m)localObject1).a((u)localObject2);
      localObject2 = new a();
      localObject3 = this.f.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if ((localObject4 instanceof n))
        {
          ((a)localObject2).a(new b((n)localObject4));
          i1 += 1;
        }
      }
      if (i1 > 0)
      {
        ((a)localObject2).a(i1);
        ((m)localObject1).a((u)localObject2);
      }
      ((m)localObject1).a(new ac());
      ((m)localObject1).a(new ak());
      this.b = ((m)localObject1).a();
    }
    else if (this.k == ad.c)
    {
      localObject1 = new m();
      localObject2 = new l(this.g + this.h + 1, this.g);
      ((l)localObject2).a(1, 0);
      ((l)localObject2).a(this.i + this.g + 1, 0);
      ((m)localObject1).a((u)localObject2);
      localObject2 = new a();
      ((a)localObject2).a(this.g);
      localObject3 = d();
      if (localObject3 != null)
      {
        localObject3 = ((a)localObject3).b();
        i1 = 0;
        while (i1 < localObject3.length)
        {
          ((a)localObject2).a((b)localObject3[i1]);
          i1 += 1;
        }
      }
      localObject3 = this.f.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (r)((Iterator)localObject3).next();
        if ((localObject4 instanceof n))
        {
          localObject4 = (n)localObject4;
          if (((n)localObject4).d() == ad.b) {
            ((a)localObject2).a(new b((n)localObject4));
          }
        }
      }
      ((m)localObject1).a((u)localObject2);
      localObject2 = new ac();
      ((ac)localObject2).a(191, false, false, 524296);
      ((ac)localObject2).a(385, false, false, 134217737);
      ((ac)localObject2).a(448, false, false, 134217792);
      ((m)localObject1).a((u)localObject2);
      ((m)localObject1).a(new ak());
      this.b = ((m)localObject1).a();
    }
    paramae.a(new y(this.b));
  }
  
  public byte[] a()
  {
    return this.b;
  }
  
  byte[] a(int paramInt)
  {
    this.g = d().h_();
    int i1 = this.g;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt <= i1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    c.b.a.a(bool1);
    if (this.k != ad.a)
    {
      bool1 = bool2;
      if (this.k != ad.c) {}
    }
    else
    {
      bool1 = true;
    }
    c.b.a.a(bool1);
    return ((b)d().b()[(paramInt - 1)]).b();
  }
  
  public boolean b()
  {
    return this.j;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */