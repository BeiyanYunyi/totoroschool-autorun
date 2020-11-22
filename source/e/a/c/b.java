package e.a.c;

import e.aa;
import e.ab;
import e.ac;
import e.ac.a;
import e.ad;
import e.p;
import e.u;
import e.u.a;
import f.d;
import f.l;
import f.r;
import java.io.IOException;
import java.net.ProtocolException;

public final class b
  implements u
{
  private final boolean a;
  
  public b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public ac a(u.a parama)
    throws IOException
  {
    g localg1 = (g)parama;
    c localc = localg1.g();
    e.a.b.g localg = localg1.f();
    e.a.b.c localc1 = (e.a.b.c)localg1.b();
    aa localaa = localg1.a();
    long l = System.currentTimeMillis();
    localg1.i().c(localg1.h());
    localc.a(localaa);
    localg1.i().a(localg1.h(), localaa);
    boolean bool = f.c(localaa.b());
    d locald = null;
    Object localObject = null;
    parama = locald;
    if (bool)
    {
      parama = locald;
      if (localaa.d() != null)
      {
        if ("100-continue".equalsIgnoreCase(localaa.a("Expect")))
        {
          localc.a();
          localg1.i().e(localg1.h());
          localObject = localc.a(true);
        }
        if (localObject == null)
        {
          localg1.i().d(localg1.h());
          parama = new a(localc.a(localaa, localaa.d().contentLength()));
          locald = l.a(parama);
          localaa.d().writeTo(locald);
          locald.close();
          localg1.i().a(localg1.h(), parama.a);
          parama = (u.a)localObject;
        }
        else
        {
          parama = (u.a)localObject;
          if (!localc1.f())
          {
            localg.e();
            parama = (u.a)localObject;
          }
        }
      }
    }
    localc.b();
    localObject = parama;
    if (parama == null)
    {
      localg1.i().e(localg1.h());
      localObject = localc.a(false);
    }
    parama = ((ac.a)localObject).a(localaa).a(localg.c().e()).a(l).b(System.currentTimeMillis()).a();
    int j = parama.b();
    int i = j;
    if (j == 100)
    {
      parama = localc.a(false).a(localaa).a(localg.c().e()).a(l).b(System.currentTimeMillis()).a();
      i = parama.b();
    }
    localg1.i().a(localg1.h(), parama);
    if ((this.a) && (i == 101)) {
      parama = parama.h().a(e.a.c.c).a();
    } else {
      parama = parama.h().a(localc.a(parama)).a();
    }
    if (("close".equalsIgnoreCase(parama.a().a("Connection"))) || ("close".equalsIgnoreCase(parama.a("Connection")))) {
      localg.e();
    }
    if (((i != 204) && (i != 205)) || (parama.g().contentLength() <= 0L)) {
      return parama;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HTTP ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" had non-zero Content-Length: ");
    ((StringBuilder)localObject).append(parama.g().contentLength());
    throw new ProtocolException(((StringBuilder)localObject).toString());
  }
  
  static final class a
    extends f.g
  {
    long a;
    
    a(r paramr)
    {
      super();
    }
    
    public void a(f.c paramc, long paramLong)
      throws IOException
    {
      super.a(paramc, paramLong);
      this.a += paramLong;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */