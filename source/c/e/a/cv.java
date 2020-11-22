package c.e.a;

import c.a.a.r;
import c.a.ad;
import c.a.af;
import c.a.as;
import c.a.s;
import c.a.x;
import c.b;
import c.c.f;
import c.e.i;
import c.e.l;
import c.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class cv
  implements l
{
  private static final char[] F = { 42, 58, 63, 92 };
  private static final String[] G = { "png" };
  private static c.b.c a = c.b.c.a(cv.class);
  private int A;
  private k B;
  private cd C;
  private c.m D;
  private cw E;
  private String b = a(paramString);
  private ae c;
  private bt[] d;
  private ad e;
  private cc f;
  private TreeSet g;
  private TreeSet h;
  private ArrayList i;
  private az j;
  private int k;
  private int l;
  private bh m;
  private g n;
  private boolean o;
  private s p;
  private ArrayList q;
  private ArrayList r;
  private ArrayList s;
  private ArrayList t;
  private ArrayList u;
  private c.a.a v;
  private ArrayList w;
  private c.a.a.h x;
  private boolean y;
  private int z;
  
  public cv(String paramString, ae paramae, ad paramad, cc paramcc, c.m paramm, cw paramcw)
  {
    this.c = paramae;
    this.d = new bt[0];
    this.k = 0;
    this.l = 0;
    this.o = false;
    this.E = paramcw;
    this.e = paramad;
    this.f = paramcc;
    this.D = paramm;
    this.y = false;
    this.g = new TreeSet(new a(null));
    this.h = new TreeSet();
    this.i = new ArrayList();
    this.j = new az(this);
    this.q = new ArrayList();
    this.r = new ArrayList();
    this.s = new ArrayList();
    this.t = new ArrayList();
    this.u = new ArrayList();
    this.w = new ArrayList();
    this.B = new k(this);
    this.C = new cd(this.c, this, this.D);
  }
  
  private String a(String paramString)
  {
    int i1 = paramString.length();
    int i2 = 0;
    Object localObject = paramString;
    StringBuilder localStringBuilder;
    if (i1 > 31)
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Sheet name ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" too long - truncating");
      ((c.b.c)localObject).b(localStringBuilder.toString());
      localObject = paramString.substring(0, 31);
    }
    i1 = i2;
    paramString = (String)localObject;
    if (((String)localObject).charAt(0) == '\'')
    {
      a.b("Sheet naming cannot start with ' - removing");
      paramString = ((String)localObject).substring(1);
      i1 = i2;
    }
    while (i1 < F.length)
    {
      localObject = paramString.replace(F[i1], '@');
      if (paramString != localObject)
      {
        paramString = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(F[i1]);
        localStringBuilder.append(" is not a valid character within a sheet name - replacing");
        paramString.b(localStringBuilder.toString());
      }
      i1 += 1;
      paramString = (String)localObject;
    }
    return paramString;
  }
  
  private void c(int paramInt)
  {
    m localm = b(paramInt);
    f localf1 = localm.d().m();
    f localf3 = c.e.m.c.m();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.k; i2 = i3)
    {
      Object localObject = null;
      if (this.d[i1] != null) {
        localObject = this.d[i1].a(paramInt);
      }
      i3 = i2;
      if (localObject != null)
      {
        String str = ((c.a)localObject).d();
        f localf2 = ((c.a)localObject).e().m();
        localObject = localf2;
        if (localf2.equals(localf3)) {
          localObject = localf1;
        }
        int i5 = ((f)localObject).f();
        int i4 = str.length();
        if (!((f)localObject).i())
        {
          i3 = i4;
          if (((f)localObject).h() <= 400) {}
        }
        else
        {
          i3 = i4 + 2;
        }
        i3 = Math.max(i2, i3 * i5 * 256);
      }
      i1 += 1;
    }
    localm.a(i2 / localf3.f());
  }
  
  private void l()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      c(((Integer)localIterator.next()).intValue());
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  public c.a a(int paramInt1, int paramInt2)
  {
    return b(paramInt1, paramInt2);
  }
  
  bt a(int paramInt)
    throws bu
  {
    if (paramInt < 65536)
    {
      if (paramInt >= this.d.length)
      {
        localObject = this.d;
        this.d = new bt[Math.max(localObject.length + 10, paramInt + 1)];
        System.arraycopy(localObject, 0, this.d, 0, localObject.length);
      }
      bt localbt = this.d[paramInt];
      Object localObject = localbt;
      if (localbt == null)
      {
        localObject = new bt(paramInt, this);
        this.d[paramInt] = localObject;
      }
      return (bt)localObject;
    }
    throw new bu();
  }
  
  void a(c.a.a.h paramh)
  {
    this.x = paramh;
  }
  
  void a(r paramr)
  {
    this.s.add(paramr);
    boolean bool;
    if (!(paramr instanceof c.a.a.n)) {
      bool = true;
    } else {
      bool = false;
    }
    c.b.a.a(bool);
  }
  
  void a(af paramaf1, af paramaf2, af paramaf3)
  {
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((m)((Iterator)localObject).next()).a(paramaf1);
    }
    int i2 = 0;
    int i1 = 0;
    while (i1 < this.d.length)
    {
      if (this.d[i1] != null) {
        this.d[i1].a(paramaf1);
      }
      i1 += 1;
    }
    localObject = g();
    i1 = i2;
    while (i1 < localObject.length)
    {
      localObject[i1].a(paramaf1, paramaf2, paramaf3);
      i1 += 1;
    }
  }
  
  void a(j paramj)
  {
    if (this.p != null) {
      this.p.a(paramj.b(), paramj.j_());
    }
    if ((this.w != null) && (!this.w.remove(paramj)))
    {
      c.b.c localc = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not remove validated cell ");
      localStringBuilder.append(c.c.a(paramj));
      localc.b(localStringBuilder.toString());
    }
  }
  
  public void a(c.e.g paramg)
    throws c.e.n, bu
  {
    if ((paramg.c() == c.d.a) && (paramg != null) && (paramg.e() == null)) {
      return;
    }
    j localj1 = (j)paramg;
    if (!localj1.h())
    {
      int i2 = paramg.j_();
      bt localbt = a(i2);
      j localj2 = localbt.a(localj1.b());
      int i1;
      if ((localj2 != null) && (localj2.f() != null) && (localj2.f().h() != null) && (localj2.f().h().f())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      Object localObject1;
      Object localObject2;
      if ((paramg.f() != null) && (paramg.f().f()) && (i1 != 0))
      {
        paramg = localj2.f().h();
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Cannot add cell at ");
        ((StringBuilder)localObject2).append(c.c.a(localj1));
        ((StringBuilder)localObject2).append(" because it is part of the shared cell validation group ");
        ((StringBuilder)localObject2).append(c.c.a(paramg.b(), paramg.d()));
        ((StringBuilder)localObject2).append("-");
        ((StringBuilder)localObject2).append(c.c.a(paramg.c(), paramg.e()));
        ((c.b.c)localObject1).b(((StringBuilder)localObject2).toString());
        return;
      }
      if (i1 != 0)
      {
        localObject2 = paramg.k_();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new c.e.h();
          paramg.a((c.e.h)localObject1);
        }
        ((c.e.h)localObject1).a(localj2.f());
      }
      localbt.a(localj1);
      this.k = Math.max(i2 + 1, this.k);
      this.l = Math.max(this.l, localbt.c());
      localj1.a(this.e, this.f, this);
      return;
    }
    throw new at(at.cellReferenced);
  }
  
  public int b()
  {
    return this.l;
  }
  
  m b(int paramInt)
  {
    Iterator localIterator = this.g.iterator();
    Object localObject2 = null;
    int i1 = 0;
    Object localObject1 = null;
    while ((localIterator.hasNext()) && (i1 == 0))
    {
      m localm = (m)localIterator.next();
      localObject1 = localm;
      if (localm.c() >= paramInt)
      {
        i1 = 1;
        localObject1 = localm;
      }
    }
    if (i1 == 0) {
      return null;
    }
    if (((m)localObject1).c() == paramInt) {
      localObject2 = localObject1;
    }
    return (m)localObject2;
  }
  
  public c.e.g b(int paramInt1, int paramInt2)
  {
    j localj;
    if ((paramInt2 < this.d.length) && (this.d[paramInt2] != null)) {
      localj = this.d[paramInt2].a(paramInt1);
    } else {
      localj = null;
    }
    Object localObject = localj;
    if (localj == null) {
      localObject = new x(paramInt1, paramInt2);
    }
    return (c.e.g)localObject;
  }
  
  void b(r paramr)
  {
    int i1 = this.s.size();
    this.s.remove(paramr);
    int i2 = this.s.size();
    boolean bool = true;
    this.y = true;
    if (i2 != i1 - 1) {
      bool = false;
    }
    c.b.a.a(bool);
  }
  
  void b(j paramj)
  {
    this.w.add(paramj);
  }
  
  public String c()
  {
    return this.b;
  }
  
  public k d()
  {
    return this.B;
  }
  
  public void e()
    throws IOException
  {
    boolean bool2 = this.y;
    boolean bool1 = bool2;
    if (this.E.f() != null) {
      bool1 = bool2 | this.E.f().b();
    }
    if (this.h.size() > 0) {
      l();
    }
    this.C.a(this.d, this.q, this.r, this.i, this.j, this.g, this.z, this.A);
    this.C.a(a(), b());
    this.C.a(this.B);
    this.C.a(this.m);
    this.C.a(this.s, bool1);
    this.C.a(this.n);
    this.C.a(this.p, this.w);
    this.C.a(this.u);
    this.C.a(this.v);
    this.C.a();
  }
  
  c.m f()
  {
    return this.D;
  }
  
  c.a.a.d[] g()
  {
    return this.C.b();
  }
  
  void h()
  {
    this.C.a(this.d, this.q, this.r, this.i, this.j, this.g, this.z, this.A);
    this.C.a(a(), b());
    this.C.c();
  }
  
  cw i()
  {
    return this.E;
  }
  
  boolean j()
  {
    return this.o;
  }
  
  c.a.a.h k()
  {
    return this.x;
  }
  
  private static class a
    implements Comparator
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      if (paramObject1 == paramObject2) {
        return 0;
      }
      c.b.a.a(paramObject1 instanceof m);
      c.b.a.a(paramObject2 instanceof m);
      paramObject1 = (m)paramObject1;
      paramObject2 = (m)paramObject2;
      return ((m)paramObject1).c() - ((m)paramObject2).c();
    }
    
    public boolean equals(Object paramObject)
    {
      return paramObject == this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */