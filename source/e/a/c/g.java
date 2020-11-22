package e.a.c;

import e.aa;
import e.ac;
import e.e;
import e.i;
import e.p;
import e.u;
import e.u.a;
import java.io.IOException;
import java.util.List;

public final class g
  implements u.a
{
  private final List<u> a;
  private final e.a.b.g b;
  private final c c;
  private final e.a.b.c d;
  private final int e;
  private final aa f;
  private final e g;
  private final p h;
  private final int i;
  private final int j;
  private final int k;
  private int l;
  
  public g(List<u> paramList, e.a.b.g paramg, c paramc, e.a.b.c paramc1, int paramInt1, aa paramaa, e parame, p paramp, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramList;
    this.d = paramc1;
    this.b = paramg;
    this.c = paramc;
    this.e = paramInt1;
    this.f = paramaa;
    this.g = parame;
    this.h = paramp;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
  }
  
  public aa a()
  {
    return this.f;
  }
  
  public ac a(aa paramaa)
    throws IOException
  {
    return a(paramaa, this.b, this.c, this.d);
  }
  
  public ac a(aa paramaa, e.a.b.g paramg, c paramc, e.a.b.c paramc1)
    throws IOException
  {
    if (this.e < this.a.size())
    {
      this.l += 1;
      if ((this.c != null) && (!this.d.a(paramaa.a())))
      {
        paramaa = new StringBuilder();
        paramaa.append("network interceptor ");
        paramaa.append(this.a.get(this.e - 1));
        paramaa.append(" must retain the same host and port");
        throw new IllegalStateException(paramaa.toString());
      }
      if ((this.c != null) && (this.l > 1))
      {
        paramaa = new StringBuilder();
        paramaa.append("network interceptor ");
        paramaa.append(this.a.get(this.e - 1));
        paramaa.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramaa.toString());
      }
      paramg = new g(this.a, paramg, paramc, paramc1, this.e + 1, paramaa, this.g, this.h, this.i, this.j, this.k);
      paramaa = (u)this.a.get(this.e);
      paramc1 = paramaa.a(paramg);
      if ((paramc != null) && (this.e + 1 < this.a.size()) && (paramg.l != 1))
      {
        paramg = new StringBuilder();
        paramg.append("network interceptor ");
        paramg.append(paramaa);
        paramg.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramg.toString());
      }
      if (paramc1 != null)
      {
        if (paramc1.g() != null) {
          return paramc1;
        }
        paramg = new StringBuilder();
        paramg.append("interceptor ");
        paramg.append(paramaa);
        paramg.append(" returned a response with no body");
        throw new IllegalStateException(paramg.toString());
      }
      paramg = new StringBuilder();
      paramg.append("interceptor ");
      paramg.append(paramaa);
      paramg.append(" returned null");
      throw new NullPointerException(paramg.toString());
    }
    throw new AssertionError();
  }
  
  public i b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public int e()
  {
    return this.k;
  }
  
  public e.a.b.g f()
  {
    return this.b;
  }
  
  public c g()
  {
    return this.c;
  }
  
  public e h()
  {
    return this.g;
  }
  
  public p i()
  {
    return this.h;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */