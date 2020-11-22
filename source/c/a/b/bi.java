package c.a.b;

import c.a.ao;
import c.m;
import java.util.Stack;

class bi
  implements at
{
  private static c.b.c a = c.b.c.a(bi.class);
  private byte[] b;
  private c.a c;
  private int d;
  private as e;
  private Stack f;
  private t g;
  private ao h;
  private m i;
  private ar j;
  
  public bi(byte[] paramArrayOfByte, c.a parama, t paramt, ao paramao, m paramm, ar paramar)
  {
    this.b = paramArrayOfByte;
    boolean bool = false;
    this.d = 0;
    this.c = parama;
    this.g = paramt;
    this.h = paramao;
    this.f = new Stack();
    this.i = paramm;
    this.j = paramar;
    if (this.h != null) {
      bool = true;
    }
    c.b.a.a(bool);
  }
  
  private void a(int paramInt)
    throws v
  {
    Stack localStack = new Stack();
    int k = this.d;
    while (this.d < k + paramInt)
    {
      int m = this.b[this.d];
      int n = this.d;
      boolean bool = true;
      this.d = (n + 1);
      Object localObject = bh.a(m);
      if (localObject != bh.N)
      {
        if (localObject == bh.N) {
          bool = false;
        }
        c.b.a.a(bool);
        if (localObject == bh.b)
        {
          localObject = new i(this.c);
          this.d += ((i)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.j)
        {
          localObject = new k();
          this.d += ((k)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.f)
        {
          localObject = new s();
          this.d += ((s)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.k)
        {
          localObject = new az(this.c);
          this.d += ((az)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.c)
        {
          localObject = new j(this.c, this.g);
          this.d += ((j)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.n)
        {
          localObject = new b();
          this.d += ((b)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.l)
        {
          localObject = new ay(this.c);
          this.d += ((ay)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.q)
        {
          localObject = new c(this.g);
          this.d += ((c)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.p)
        {
          localObject = new aj();
          this.d += ((aj)localObject).a(this.b, this.d);
          ((aj)localObject).a(this.j);
          this.f.push(localObject);
        }
        else if (localObject == bh.o)
        {
          localObject = new ak(this.h);
          this.d += ((ak)localObject).a(this.b, this.d);
          ((ak)localObject).a(this.j);
          this.f.push(localObject);
        }
        else if (localObject == bh.h)
        {
          localObject = new ab();
          this.d += ((ab)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.i)
        {
          localObject = new q();
          this.d += ((q)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.g)
        {
          localObject = new g();
          this.d += ((g)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.e)
        {
          localObject = new be(this.i);
          this.d += ((be)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.d)
        {
          localObject = new ah();
          this.d += ((ah)localObject).a(this.b, this.d);
          this.f.push(localObject);
        }
        else if (localObject == bh.r)
        {
          localObject = new bl();
          this.d += ((bl)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.s)
        {
          localObject = new bj();
          this.d += ((bj)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.t)
        {
          localObject = new au();
          this.d += ((au)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.w)
        {
          localObject = new bg();
          this.d += ((bg)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.v)
        {
          localObject = new a();
          this.d += ((a)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.x)
        {
          localObject = new ai();
          this.d += ((ai)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.y)
        {
          localObject = new p();
          this.d += ((p)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.A)
        {
          localObject = new o();
          this.d += ((o)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.z)
        {
          localObject = new aw();
          this.d += ((aw)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.B)
        {
          localObject = new ad();
          this.d += ((ad)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.C)
        {
          localObject = new ac();
          this.d += ((ac)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.F)
        {
          localObject = new aa();
          this.d += ((aa)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.E)
        {
          localObject = new z();
          this.d += ((z)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.G)
        {
          localObject = new al();
          this.d += ((al)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.D)
        {
          localObject = new r();
          this.d += ((r)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.u)
        {
          localObject = new aq();
          this.d += ((aq)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.L)
        {
          localObject = new e(this.i);
          this.d += ((e)localObject).a(this.b, this.d);
          if (((e)localObject).a()) {
            a((ap)localObject);
          } else if (((e)localObject).b()) {
            localStack.push(localObject);
          }
        }
        else if (localObject == bh.J)
        {
          localObject = new h(this.i);
          this.d += ((h)localObject).a(this.b, this.d);
          a((ap)localObject);
        }
        else if (localObject == bh.K)
        {
          bm localbm = new bm(this.i);
          this.d += localbm.a(this.b, this.d);
          if (localbm.a() != x.b)
          {
            a(localbm);
          }
          else
          {
            localbm.a(this.f);
            if (localStack.empty()) {
              localObject = new e(this.i);
            } else {
              localObject = (e)localStack.pop();
            }
            ((e)localObject).a(localbm);
            this.f.push(localObject);
          }
        }
        else if (localObject == bh.M)
        {
          a(new af());
        }
        else if (localObject == bh.m)
        {
          a(new ae());
        }
      }
      else
      {
        throw new v(v.UNRECOGNIZED_TOKEN, m);
      }
    }
  }
  
  private void a(ap paramap)
  {
    paramap.a(this.f);
    this.f.push(paramap);
  }
  
  private void a(bf parambf)
    throws v
  {
    this.d += parambf.a(this.b, this.d);
    Stack localStack = this.f;
    this.f = new Stack();
    a(parambf.a());
    as[] arrayOfas = new as[this.f.size()];
    int k = 0;
    while (!this.f.isEmpty())
    {
      arrayOfas[k] = ((as)this.f.pop());
      k += 1;
    }
    parambf.a(arrayOfas);
    this.f = localStack;
    this.f.push(parambf);
  }
  
  public void a()
    throws v
  {
    a(this.b.length);
    this.e = ((as)this.f.pop());
    c.b.a.a(this.f.empty());
  }
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    this.e.a(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public byte[] c()
  {
    return this.e.c();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */