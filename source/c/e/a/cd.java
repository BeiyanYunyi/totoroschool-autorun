package c.e.a;

import c.a.a.af;
import c.a.a.d;
import c.a.l;
import c.a.s;
import c.e.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

final class cd
{
  private static c.b.c a = c.b.c.a(cd.class);
  private ae b;
  private bt[] c;
  private int d;
  private int e;
  private c.k f;
  private c.m g;
  private ArrayList h;
  private ArrayList i;
  private ArrayList j;
  private ArrayList k;
  private c.a.a l;
  private ArrayList m;
  private s n;
  private az o;
  private bh p;
  private g q;
  private c.a.ap r;
  private TreeSet s;
  private af t;
  private boolean u;
  private int v;
  private int w;
  private cv x;
  
  public cd(ae paramae, cv paramcv, c.m paramm)
  {
    this.b = paramae;
    this.x = paramcv;
    this.r = new c.a.ap();
    this.g = paramm;
    this.u = false;
    this.t = new af(paramm);
  }
  
  private c.a[] a(int paramInt)
  {
    int i1 = this.d - 1;
    int i3 = 0;
    int i2 = 0;
    while ((i1 >= 0) && (i2 == 0)) {
      if ((this.c[i1] != null) && (this.c[i1].a(paramInt) != null)) {
        i2 = 1;
      } else {
        i1 -= 1;
      }
    }
    c.a[] arrayOfa = new c.a[i1 + 1];
    i2 = i3;
    while (i2 <= i1)
    {
      j localj;
      if (this.c[i2] != null) {
        localj = this.c[i2].a(paramInt);
      } else {
        localj = null;
      }
      arrayOfa[i2] = localj;
      i2 += 1;
    }
    return arrayOfa;
  }
  
  private void d()
    throws IOException
  {
    if ((this.n != null) && (this.m.size() == 0))
    {
      this.n.a(this.b);
      return;
    }
    if ((this.n == null) && (this.m.size() > 0))
    {
      int i1;
      if (this.x.k() != null) {
        i1 = this.x.k().a();
      } else {
        i1 = -1;
      }
      this.n = new s(i1, this.x.i(), this.x.i(), this.g);
    }
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (j)localIterator.next();
      c.b localb = ((j)localObject).f();
      if (!localb.h().g()) {
        if (!localb.h().f())
        {
          localObject = new c.a.u(localb.h());
          this.n.a((c.a.u)localObject);
        }
        else if ((((j)localObject).b() == localb.h().b()) && (((j)localObject).j_() == localb.h().d()))
        {
          localObject = new c.a.u(localb.h());
          this.n.a((c.a.u)localObject);
        }
      }
    }
    this.n.a(this.b);
  }
  
  public void a()
    throws IOException
  {
    boolean bool;
    if (this.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    c.b.a.a(bool);
    if (this.u)
    {
      this.t.a(this.b);
      return;
    }
    Object localObject1 = new a(a.b);
    this.b.a((c.a.j)localObject1);
    int i2 = this.d / 32;
    int i1 = i2;
    if (this.d - i2 * 32 != 0) {
      i1 = i2 + 1;
    }
    int i7 = this.b.a();
    localObject1 = new ap(0, this.d, i1);
    this.b.a((c.a.j)localObject1);
    if (this.f.O())
    {
      localObject2 = new i(i.b);
      this.b.a((c.a.j)localObject2);
    }
    else
    {
      localObject2 = new i(i.a);
      this.b.a((c.a.j)localObject2);
    }
    Object localObject2 = new h(100);
    this.b.a((c.a.j)localObject2);
    localObject2 = new bq();
    this.b.a((c.a.j)localObject2);
    localObject2 = new as(false);
    this.b.a((c.a.j)localObject2);
    localObject2 = new w(0.001D);
    this.b.a((c.a.j)localObject2);
    localObject2 = new by(this.f.P());
    this.b.a((c.a.j)localObject2);
    localObject2 = new bm(this.f.G());
    this.b.a((c.a.j)localObject2);
    localObject2 = new bl(this.f.F());
    this.b.a((c.a.j)localObject2);
    localObject2 = new ai(true);
    this.b.a((c.a.j)localObject2);
    localObject2 = new aj();
    ((aj)localObject2).b(this.w + 1);
    ((aj)localObject2).a(this.v + 1);
    this.b.a((c.a.j)localObject2);
    i2 = this.f.y();
    if (this.f.y() != 255) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = new v(i2, bool);
    this.b.a((c.a.j)localObject2);
    if (this.v > 0) {
      this.r.b(true);
    }
    if (this.w > 0) {
      this.r.c(true);
    }
    this.r.a(this.f.u());
    this.b.a(this.r);
    if (this.h.size() > 0)
    {
      localObject2 = new int[this.h.size()];
      i2 = 0;
      while (i2 < localObject2.length)
      {
        localObject2[i2] = ((Integer)this.h.get(i2)).intValue();
        i2 += 1;
      }
      localObject2 = new an((int[])localObject2);
      this.b.a((c.a.j)localObject2);
    }
    if (this.i.size() > 0)
    {
      localObject2 = new int[this.i.size()];
      i2 = 0;
      while (i2 < localObject2.length)
      {
        localObject2[i2] = ((Integer)this.i.get(i2)).intValue();
        i2 += 1;
      }
      localObject2 = new cn((int[])localObject2);
      this.b.a((c.a.j)localObject2);
    }
    localObject2 = new ak(this.f.K().toString());
    this.b.a((c.a.j)localObject2);
    localObject2 = new ag(this.f.L().toString());
    this.b.a((c.a.j)localObject2);
    localObject2 = new am(this.f.M());
    this.b.a((c.a.j)localObject2);
    localObject2 = new cm(this.f.N());
    this.b.a((c.a.j)localObject2);
    if (this.f.p() != this.f.s())
    {
      localObject2 = new av(this.f.p());
      this.b.a((c.a.j)localObject2);
    }
    if (this.f.o() != this.f.s())
    {
      localObject2 = new bs(this.f.o());
      this.b.a((c.a.j)localObject2);
    }
    if (this.f.q() != this.f.t())
    {
      localObject2 = new ck(this.f.q());
      this.b.a((c.a.j)localObject2);
    }
    if (this.f.r() != this.f.t())
    {
      localObject2 = new e(this.f.r());
      this.b.a((c.a.j)localObject2);
    }
    if (this.p != null) {
      this.b.a(this.p);
    }
    localObject2 = new cb(this.f);
    this.b.a((c.a.j)localObject2);
    if (this.f.d())
    {
      localObject2 = new bp(this.f.d());
      this.b.a((c.a.j)localObject2);
      localObject2 = new bz(this.f.d());
      this.b.a((c.a.j)localObject2);
      localObject2 = new bg(this.f.d());
      this.b.a((c.a.j)localObject2);
      if (this.f.v() != null)
      {
        localObject2 = new bj(this.f.v());
        this.b.a((c.a.j)localObject2);
      }
      else if (this.f.w() != 0)
      {
        localObject2 = new bj(this.f.w());
        this.b.a((c.a.j)localObject2);
      }
    }
    ((ap)localObject1).b(this.b.a());
    localObject2 = new u(this.f.x());
    this.b.a((c.a.j)localObject2);
    localObject2 = this.x.i().g().a();
    Object localObject3 = this.x.i().g().f();
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext())
    {
      Object localObject4 = (m)localIterator.next();
      if (((m)localObject4).c() < 256) {
        this.b.a((c.a.j)localObject4);
      }
      c.a.as localas = ((m)localObject4).d();
      if ((localas != localObject2) && (((m)localObject4).c() < 256))
      {
        localObject4 = a(((m)localObject4).c());
        i2 = 0;
        while (i2 < localObject4.length)
        {
          if ((localObject4[i2] != null) && ((localObject4[i2].e() == localObject2) || (localObject4[i2].e() == localObject3))) {
            ((c.e.g)localObject4[i2]).a(localas);
          }
          i2 += 1;
        }
      }
    }
    if (this.l != null) {
      this.l.a(this.b);
    }
    localObject2 = new x(this.d, this.e);
    this.b.a((c.a.j)localObject2);
    i2 = 0;
    while (i2 < i1)
    {
      localObject2 = new q(this.b.a());
      int i4 = this.d;
      int i3 = i2 * 32;
      int i8 = Math.min(32, i4 - i3);
      i4 = i3;
      int i9;
      int i6;
      for (int i5 = 1;; i5 = i6)
      {
        i9 = i3 + i8;
        i6 = i3;
        if (i4 >= i9) {
          break;
        }
        i6 = i5;
        if (this.c[i4] != null)
        {
          this.c[i4].a(this.b);
          i6 = i5;
          if (i5 != 0)
          {
            ((q)localObject2).a(this.b.a());
            i6 = 0;
          }
        }
        i4 += 1;
      }
      while (i6 < i9)
      {
        if (this.c[i6] != null)
        {
          ((q)localObject2).b(this.b.a());
          this.c[i6].b(this.b);
        }
        i6 += 1;
      }
      ((ap)localObject1).a(this.b.a());
      ((q)localObject2).c(this.b.a());
      this.b.a((c.a.j)localObject2);
      i2 += 1;
    }
    if (!this.g.c()) {
      this.t.a(this.b);
    }
    localObject2 = new cq(this.f);
    this.b.a((c.a.j)localObject2);
    if ((this.f.H() == 0) && (this.f.I() == 0))
    {
      localObject2 = new ca(ca.d, 0, 0);
      this.b.a((c.a.j)localObject2);
    }
    else
    {
      localObject2 = new bi(this.f.H(), this.f.I());
      this.b.a((c.a.j)localObject2);
      localObject2 = new ca(ca.d, 0, 0);
      this.b.a((c.a.j)localObject2);
      if (this.f.H() != 0)
      {
        localObject2 = new ca(ca.b, this.f.H(), 0);
        this.b.a((c.a.j)localObject2);
      }
      if (this.f.I() != 0)
      {
        localObject2 = new ca(ca.c, 0, this.f.I());
        this.b.a((c.a.j)localObject2);
      }
      if ((this.f.H() != 0) && (this.f.I() != 0))
      {
        localObject2 = new ca(ca.a, this.f.H(), this.f.I());
        this.b.a((c.a.j)localObject2);
      }
      localObject2 = new co();
      this.b.a((c.a.j)localObject2);
    }
    if (this.f.z() != 100)
    {
      localObject2 = new bv(this.f.z());
      this.b.a((c.a.j)localObject2);
    }
    this.o.a(this.b);
    localObject2 = this.j.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c.e.k)((Iterator)localObject2).next();
      this.b.a((c.a.j)localObject3);
    }
    if (this.q != null) {
      this.b.a(this.q);
    }
    if ((this.n != null) || (this.m.size() > 0)) {
      d();
    }
    if ((this.k != null) && (this.k.size() > 0))
    {
      localObject2 = this.k.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((l)((Iterator)localObject2).next()).a(this.b);
      }
    }
    localObject2 = new y();
    this.b.a((c.a.j)localObject2);
    this.b.a(((ap)localObject1).a(), i7 + 4);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  void a(c.a.a parama)
  {
    this.l = parama;
  }
  
  void a(s params, ArrayList paramArrayList)
  {
    this.n = params;
    this.m = paramArrayList;
  }
  
  void a(bh parambh)
  {
    this.p = parambh;
  }
  
  void a(g paramg)
  {
    this.q = paramg;
  }
  
  void a(c.k paramk)
  {
    this.f = paramk;
  }
  
  void a(ArrayList paramArrayList)
  {
    this.k = paramArrayList;
  }
  
  void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.t.a(paramArrayList, paramBoolean);
  }
  
  void a(bt[] paramArrayOfbt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, az paramaz, TreeSet paramTreeSet, int paramInt1, int paramInt2)
  {
    this.c = paramArrayOfbt;
    this.h = paramArrayList1;
    this.i = paramArrayList2;
    this.j = paramArrayList3;
    this.o = paramaz;
    this.s = paramTreeSet;
    this.v = paramInt1;
    this.w = paramInt2;
  }
  
  d[] b()
  {
    return this.t.a();
  }
  
  void c()
  {
    c.i[] arrayOfi = this.o.a();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < arrayOfi.length)
    {
      Object localObject = arrayOfi[i1];
      c.a locala = ((c.i)localObject).a();
      c.a.as localas = (c.a.as)locala.e();
      if ((localas != null) && (localas.h() == true) && (!localas.l())) {
        try
        {
          k localk = new k(localas);
          localObject = ((c.i)localObject).b();
          localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
          localk.b(c.c.b.e, localas.a(c.c.b.e), localas.b(c.c.b.e));
          localk.b(c.c.b.c, localas.a(c.c.b.c), localas.b(c.c.b.c));
          if (locala.j_() == ((c.a)localObject).j_()) {
            localk.b(c.c.b.d, localas.a(c.c.b.d), localas.b(c.c.b.d));
          }
          if (locala.b() == ((c.a)localObject).b()) {
            localk.b(c.c.b.f, localas.a(c.c.b.f), localas.b(c.c.b.f));
          }
          int i2 = localArrayList.indexOf(localk);
          if (i2 != -1) {
            localk = (k)localArrayList.get(i2);
          } else {
            localArrayList.add(localk);
          }
          ((c.e.g)locala).a(localk);
          int i3;
          if (((c.a)localObject).j_() > locala.j_())
          {
            if (((c.a)localObject).b() != locala.b())
            {
              localk = new k(localas);
              localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
              localk.b(c.c.b.e, localas.a(c.c.b.e), localas.b(c.c.b.e));
              localk.b(c.c.b.d, localas.a(c.c.b.d), localas.b(c.c.b.d));
              i2 = localArrayList.indexOf(localk);
              if (i2 != -1) {
                localk = (k)localArrayList.get(i2);
              } else {
                localArrayList.add(localk);
              }
              this.x.a(new c.e.a(locala.b(), ((c.a)localObject).j_(), localk));
            }
            i2 = locala.j_() + 1;
            while (i2 < ((c.a)localObject).j_())
            {
              localk = new k(localas);
              localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
              localk.b(c.c.b.e, localas.a(c.c.b.e), localas.b(c.c.b.e));
              if (locala.b() == ((c.a)localObject).b()) {
                localk.b(c.c.b.f, localas.a(c.c.b.f), localas.b(c.c.b.f));
              }
              i3 = localArrayList.indexOf(localk);
              if (i3 != -1) {
                localk = (k)localArrayList.get(i3);
              } else {
                localArrayList.add(localk);
              }
              this.x.a(new c.e.a(locala.b(), i2, localk));
              i2 += 1;
            }
          }
          if (((c.a)localObject).b() > locala.b())
          {
            if (((c.a)localObject).j_() != locala.j_())
            {
              localk = new k(localas);
              localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
              localk.b(c.c.b.f, localas.a(c.c.b.f), localas.b(c.c.b.f));
              localk.b(c.c.b.c, localas.a(c.c.b.c), localas.b(c.c.b.c));
              i2 = localArrayList.indexOf(localk);
              if (i2 != -1) {
                localk = (k)localArrayList.get(i2);
              } else {
                localArrayList.add(localk);
              }
              this.x.a(new c.e.a(((c.a)localObject).b(), locala.j_(), localk));
            }
            i2 = locala.j_() + 1;
            while (i2 < ((c.a)localObject).j_())
            {
              localk = new k(localas);
              localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
              localk.b(c.c.b.f, localas.a(c.c.b.f), localas.b(c.c.b.f));
              i3 = localArrayList.indexOf(localk);
              if (i3 != -1) {
                localk = (k)localArrayList.get(i3);
              } else {
                localArrayList.add(localk);
              }
              this.x.a(new c.e.a(((c.a)localObject).b(), i2, localk));
              i2 += 1;
            }
            i2 = locala.b() + 1;
            while (i2 < ((c.a)localObject).b())
            {
              localk = new k(localas);
              localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
              localk.b(c.c.b.c, localas.a(c.c.b.c), localas.b(c.c.b.c));
              if (locala.j_() == ((c.a)localObject).j_()) {
                localk.b(c.c.b.d, localas.a(c.c.b.d), localas.b(c.c.b.d));
              }
              i3 = localArrayList.indexOf(localk);
              if (i3 != -1) {
                localk = (k)localArrayList.get(i3);
              } else {
                localArrayList.add(localk);
              }
              this.x.a(new c.e.a(i2, locala.j_(), localk));
              i2 += 1;
            }
          }
          if ((((c.a)localObject).b() > locala.b()) || (((c.a)localObject).j_() > locala.j_()))
          {
            localk = new k(localas);
            localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
            localk.b(c.c.b.f, localas.a(c.c.b.f), localas.b(c.c.b.f));
            localk.b(c.c.b.d, localas.a(c.c.b.d), localas.b(c.c.b.d));
            if (((c.a)localObject).j_() == locala.j_()) {
              localk.b(c.c.b.c, localas.a(c.c.b.c), localas.b(c.c.b.c));
            }
            if (((c.a)localObject).b() == locala.b()) {
              localk.b(c.c.b.e, localas.a(c.c.b.e), localas.b(c.c.b.e));
            }
            i2 = localArrayList.indexOf(localk);
            if (i2 != -1) {
              localk = (k)localArrayList.get(i2);
            } else {
              localArrayList.add(localk);
            }
            this.x.a(new c.e.a(((c.a)localObject).b(), ((c.a)localObject).j_(), localk));
            i2 = locala.b() + 1;
            while (i2 < ((c.a)localObject).b())
            {
              localk = new k(localas);
              localk.b(c.c.b.b, c.c.c.a, c.c.e.b);
              localk.b(c.c.b.d, localas.a(c.c.b.d), localas.b(c.c.b.d));
              if (locala.j_() == ((c.a)localObject).j_()) {
                localk.b(c.c.b.c, localas.a(c.c.b.c), localas.b(c.c.b.c));
              }
              i3 = localArrayList.indexOf(localk);
              if (i3 != -1) {
                localk = (k)localArrayList.get(i3);
              } else {
                localArrayList.add(localk);
              }
              this.x.a(new c.e.a(i2, ((c.a)localObject).j_(), localk));
              i2 += 1;
            }
          }
          i1 += 1;
        }
        catch (n localn)
        {
          a.b(localn.toString());
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */