package c.e.a;

import c.a.a.q;
import c.a.ab;
import c.a.af;
import c.a.ag;
import c.a.ao;
import c.b.c;
import c.k;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class cw
  extends c.e.m
  implements ao, c.a.b.t
{
  private static c f = c.a(cw.class);
  private static Object y = new Object();
  private c.a.ar[] A;
  private c.a.ad g;
  private ae h;
  private ArrayList i;
  private ab j;
  private ad k;
  private ArrayList l;
  private ArrayList m;
  private HashMap n;
  private cc o;
  private boolean p;
  private boolean q;
  private c.m r;
  private ArrayList s;
  private q t;
  private cg u;
  private boolean v;
  private g w;
  private p x;
  private String[] z;
  
  public cw(OutputStream arg1, boolean paramBoolean, c.m paramm)
    throws IOException
  {
    this.h = new ae(???, paramm, null);
    this.i = new ArrayList();
    this.o = new cc();
    this.n = new HashMap();
    this.p = paramBoolean;
    this.q = false;
    this.v = false;
    this.r = paramm;
    this.s = new ArrayList();
    this.u = new cg();
    synchronized (y)
    {
      c.e.m.a.d();
      c.e.m.b.d();
      c.e.m.c.i();
      c.e.m.d.i();
      c.e.m.e.i();
      t.a.i();
      this.j = new ct(this);
      this.g = new cu(this.j, this.u);
      return;
    }
  }
  
  private c.e.l a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = new cv(paramString, this.h, this.g, this.o, this.r, this);
    if (paramInt <= 0)
    {
      this.i.add(0, paramString);
      paramInt = 0;
    }
    else if (paramInt > this.i.size())
    {
      paramInt = this.i.size();
      this.i.add(paramString);
    }
    else
    {
      this.i.add(paramInt, paramString);
    }
    if ((paramBoolean) && (this.k != null)) {
      this.k.c(paramInt);
    }
    if ((this.l != null) && (this.l.size() > 0))
    {
      ch localch = (ch)this.l.get(0);
      if (localch.c() == ch.a) {
        localch.a(this.i.size());
      }
    }
    return paramString;
  }
  
  private int c(String paramString)
  {
    String[] arrayOfString = d();
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      if (paramString.equals(arrayOfString[i1])) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void h()
  {
    af localaf1 = this.g.b();
    af localaf2 = this.g.c();
    af localaf3 = this.g.a(localaf1, localaf2);
    int i1 = 0;
    while (i1 < this.i.size())
    {
      ((cv)this.i.get(i1)).a(localaf3, localaf1, localaf2);
      i1 += 1;
    }
  }
  
  public int a(String paramString)
  {
    paramString = (bc)this.n.get(paramString);
    if (paramString != null) {
      return paramString.d();
    }
    return -1;
  }
  
  public c.d.a.a a()
  {
    return null;
  }
  
  public c.e.l a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true);
  }
  
  public String a(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.m.size())) {
      bool = true;
    } else {
      bool = false;
    }
    c.b.a.a(bool);
    return ((bc)this.m.get(paramInt)).c();
  }
  
  void a(c.a.a.r paramr)
  {
    if (this.t == null) {
      this.t = new q(c.a.a.ad.b);
    }
    this.t.a(paramr);
  }
  
  void a(c.a.g paramg, c.e.l paraml, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (this.m == null) {
      this.m = new ArrayList();
    }
    paraml = new bc(paramg, c(paraml.c()), b(paraml.c()), paramInt6, paramInt8, paramInt5, paramInt7, paramInt2, paramInt4, paramInt1, paramInt3, paramBoolean);
    this.m.add(paraml);
    this.n.put(paramg, paraml);
  }
  
  void a(c.a.g paramg, c.e.l paraml, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.m == null) {
      this.m = new ArrayList();
    }
    paraml = new bc(paramg, c(paraml.c()), b(paraml.c()), paramInt2, paramInt4, paramInt1, paramInt3, paramBoolean);
    this.m.add(paraml);
    this.n.put(paramg, paraml);
  }
  
  public int b(String paramString)
  {
    if (this.k == null)
    {
      this.k = new ad();
      this.l = new ArrayList();
      this.l.add(new ch(e(), this.r));
    }
    Object localObject1 = this.i.iterator();
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    while ((((Iterator)localObject1).hasNext()) && (i2 == 0)) {
      if (((cv)((Iterator)localObject1).next()).c().equals(paramString)) {
        i2 = 1;
      } else {
        i1 += 1;
      }
    }
    Object localObject2;
    if (i2 != 0)
    {
      localObject1 = (ch)this.l.get(0);
      if ((((ch)localObject1).c() != ch.a) || (((ch)localObject1).d() != e()))
      {
        localObject1 = f;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Cannot find sheet ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" in supbook record");
        ((c)localObject1).b(((StringBuilder)localObject2).toString());
      }
      return this.k.a(0, i1);
    }
    i1 = paramString.lastIndexOf(']');
    int i4 = paramString.lastIndexOf('[');
    i2 = -1;
    if ((i1 != -1) && (i4 != -1))
    {
      localObject1 = paramString.substring(i1 + 1);
      localObject2 = paramString.substring(i4 + 1, i1);
      paramString = paramString.substring(0, i4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)localObject2);
      localObject2 = localStringBuilder.toString();
      paramString = null;
      i4 = 0;
      i1 = i3;
      i3 = i4;
      while ((i1 < this.l.size()) && (i3 == 0))
      {
        paramString = (ch)this.l.get(i1);
        int i5 = i3;
        i4 = i2;
        if (paramString.c() == ch.b)
        {
          i5 = i3;
          i4 = i2;
          if (paramString.e().equals(localObject2))
          {
            i4 = i1;
            i5 = 1;
          }
        }
        i1 += 1;
        i3 = i5;
        i2 = i4;
      }
      if (i3 == 0)
      {
        paramString = new ch((String)localObject2, this.r);
        i2 = this.l.size();
        this.l.add(paramString);
      }
      i1 = paramString.a((String)localObject1);
      return this.k.a(i2, i1);
    }
    f.b("Square brackets");
    return -1;
  }
  
  public String b(int paramInt)
  {
    int i1 = this.k.a(paramInt);
    ch localch = (ch)this.l.get(i1);
    paramInt = this.k.b(paramInt);
    if (localch.c() == ch.a) {
      return c(paramInt).c();
    }
    if (localch.c() == ch.b)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localch.e());
      localStringBuilder.append(localch.b(paramInt));
      return localStringBuilder.toString();
    }
    f.b("Unknown Supbook 1");
    return "[UNKNOWN]";
  }
  
  public void b()
    throws IOException, at
  {
    this.h.a(this.p);
  }
  
  public c.e.l c(int paramInt)
  {
    return (c.e.l)this.i.get(paramInt);
  }
  
  public void c()
    throws IOException
  {
    int i4 = 0;
    int i1 = 0;
    Object localObject2;
    while (i1 < e())
    {
      localObject1 = (cv)c(i1);
      ((cv)localObject1).h();
      localObject2 = ((cv)localObject1).d().Q();
      if (localObject2 != null) {
        a(c.a.g.g, (c.e.l)localObject1, ((c.i)localObject2).a().b(), ((c.i)localObject2).a().j_(), ((c.i)localObject2).b().b(), ((c.i)localObject2).b().j_(), false);
      }
      localObject2 = ((cv)localObject1).d().R();
      localObject3 = ((cv)localObject1).d().S();
      if ((localObject2 != null) && (localObject3 != null)) {
        a(c.a.g.h, (c.e.l)localObject1, ((c.i)localObject2).a().b(), ((c.i)localObject2).a().j_(), ((c.i)localObject2).b().b(), ((c.i)localObject2).b().j_(), ((c.i)localObject3).a().b(), ((c.i)localObject3).a().j_(), ((c.i)localObject3).b().b(), ((c.i)localObject3).b().j_(), false);
      } else if (localObject2 != null) {
        a(c.a.g.h, (c.e.l)localObject1, ((c.i)localObject2).a().b(), ((c.i)localObject2).a().j_(), ((c.i)localObject2).b().b(), ((c.i)localObject2).b().j_(), false);
      } else if (localObject3 != null) {
        a(c.a.g.h, (c.e.l)localObject1, ((c.i)localObject3).a().b(), ((c.i)localObject3).a().j_(), ((c.i)localObject3).b().b(), ((c.i)localObject3).b().j_(), false);
      }
      i1 += 1;
    }
    if (!this.r.e()) {
      h();
    }
    Object localObject1 = new a(a.a);
    this.h.a((c.a.j)localObject1);
    if (this.r.n())
    {
      localObject1 = new cj();
      this.h.a((c.a.j)localObject1);
    }
    localObject1 = new ar();
    this.h.a((c.a.j)localObject1);
    localObject1 = new aw(0, 0);
    this.h.a((c.a.j)localObject1);
    localObject1 = new aq();
    this.h.a((c.a.j)localObject1);
    localObject1 = new cx(this.r.r());
    this.h.a((c.a.j)localObject1);
    localObject1 = new l();
    this.h.a((c.a.j)localObject1);
    localObject1 = new r();
    this.h.a((c.a.j)localObject1);
    if (this.r.o())
    {
      localObject1 = new z();
      this.h.a((c.a.j)localObject1);
    }
    localObject1 = new ci(e());
    this.h.a((c.a.j)localObject1);
    if (this.v)
    {
      localObject1 = new bf();
      this.h.a((c.a.j)localObject1);
    }
    if (this.w != null) {
      this.h.a(this.w);
    }
    localObject1 = new ah();
    this.h.a((c.a.j)localObject1);
    localObject1 = new cr(this.r.p());
    this.h.a((c.a.j)localObject1);
    localObject1 = new bp(this.q);
    this.h.a((c.a.j)localObject1);
    localObject1 = new bj(null);
    this.h.a((c.a.j)localObject1);
    localObject1 = new bo(false);
    this.h.a((c.a.j)localObject1);
    localObject1 = new bn();
    this.h.a((c.a.j)localObject1);
    i1 = 0;
    int i3 = 0;
    int i2 = 0;
    while ((i1 < e()) && (i3 == 0))
    {
      if (((cv)c(i1)).d().h())
      {
        i2 = i1;
        i3 = 1;
      }
      i1 += 1;
    }
    if (i3 == 0)
    {
      ((cv)c(0)).d().a(true);
      i2 = 0;
    }
    localObject1 = new cp(i2);
    this.h.a((c.a.j)localObject1);
    localObject1 = new b(false);
    this.h.a((c.a.j)localObject1);
    localObject1 = new al(this.r.q());
    this.h.a((c.a.j)localObject1);
    localObject1 = new bd(false);
    this.h.a((c.a.j)localObject1);
    localObject1 = new bk(false);
    this.h.a((c.a.j)localObject1);
    localObject1 = new br(this.r.m());
    this.h.a((c.a.j)localObject1);
    localObject1 = new d(true);
    this.h.a((c.a.j)localObject1);
    this.j.a(this.h);
    this.g.a(this.h);
    if (this.g.d() != null) {
      this.h.a(this.g.d());
    }
    localObject1 = new cl();
    this.h.a((c.a.j)localObject1);
    Object localObject3 = new int[e()];
    i1 = 0;
    while (i1 < e())
    {
      localObject3[i1] = this.h.a();
      localObject1 = c(i1);
      localObject2 = new f(((c.j)localObject1).c());
      if (((c.j)localObject1).d().g()) {
        ((f)localObject2).c();
      }
      if (((cv)this.i.get(i1)).j()) {
        ((f)localObject2).d();
      }
      this.h.a((c.a.j)localObject2);
      i1 += 1;
    }
    if (this.x == null)
    {
      localObject2 = c.a.p.a(this.r.i());
      localObject1 = localObject2;
      if (localObject2 == c.a.p.r)
      {
        localObject1 = f;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown country code ");
        ((StringBuilder)localObject2).append(this.r.i());
        ((StringBuilder)localObject2).append(" using ");
        ((StringBuilder)localObject2).append(c.a.p.a.b());
        ((c)localObject1).b(((StringBuilder)localObject2).toString());
        localObject1 = c.a.p.a;
      }
      localObject2 = c.a.p.a(this.r.j());
      this.x = new p((c.a.p)localObject1, (c.a.p)localObject2);
      if (localObject2 == c.a.p.r)
      {
        localObject1 = f;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown country code ");
        ((StringBuilder)localObject2).append(this.r.i());
        ((StringBuilder)localObject2).append(" using ");
        ((StringBuilder)localObject2).append(c.a.p.j.b());
        ((c)localObject1).b(((StringBuilder)localObject2).toString());
        localObject1 = c.a.p.j;
      }
    }
    this.h.a(this.x);
    if ((this.z != null) && (this.z.length > 0))
    {
      i1 = 0;
      while (i1 < this.z.length)
      {
        localObject1 = new ac(this.z[i1]);
        this.h.a((c.a.j)localObject1);
        i1 += 1;
      }
    }
    if (this.A != null)
    {
      i1 = 0;
      while (i1 < this.A.length)
      {
        this.h.a(this.A[i1]);
        i1 += 1;
      }
    }
    if (this.k != null)
    {
      i1 = 0;
      while (i1 < this.l.size())
      {
        localObject1 = (ch)this.l.get(i1);
        this.h.a((c.a.j)localObject1);
        i1 += 1;
      }
      this.h.a(this.k);
    }
    if (this.m != null)
    {
      i1 = 0;
      while (i1 < this.m.size())
      {
        localObject1 = (bc)this.m.get(i1);
        this.h.a((c.a.j)localObject1);
        i1 += 1;
      }
    }
    if (this.t != null) {
      this.t.a(this.h);
    }
    this.o.a(this.h);
    localObject1 = new y();
    this.h.a((c.a.j)localObject1);
    i1 = i4;
    while (i1 < e())
    {
      this.h.a(ag.a(this.h.a()), localObject3[i1] + 4);
      ((cv)c(i1)).e();
      i1 += 1;
    }
  }
  
  public String[] d()
  {
    String[] arrayOfString = new String[e()];
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      arrayOfString[i1] = c(i1).c();
      i1 += 1;
    }
    return arrayOfString;
  }
  
  public int e()
  {
    return this.i.size();
  }
  
  q f()
  {
    return this.t;
  }
  
  cg g()
  {
    return this.u;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */