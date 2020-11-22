package e.a.e;

import e.a.a;
import e.a.c.e;
import e.a.c.k;
import e.aa;
import e.ac;
import e.ac.a;
import e.ad;
import e.p;
import e.s.a;
import e.u.a;
import e.x;
import e.y;
import f.l;
import f.r;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class f
  implements e.a.c.c
{
  private static final List<String> b = e.a.c.a(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority" });
  private static final List<String> c = e.a.c.a(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade" });
  final e.a.b.g a;
  private final u.a d;
  private final g e;
  private i f;
  private final y g;
  
  public f(x paramx, u.a parama, e.a.b.g paramg, g paramg1)
  {
    this.d = parama;
    this.a = paramg;
    this.e = paramg1;
    if (paramx.v().contains(y.H2_PRIOR_KNOWLEDGE)) {
      paramx = y.H2_PRIOR_KNOWLEDGE;
    } else {
      paramx = y.HTTP_2;
    }
    this.g = paramx;
  }
  
  public static ac.a a(e.s params, y paramy)
    throws IOException
  {
    s.a locala = new s.a();
    int j = params.a();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      String str2 = params.a(i);
      String str1 = params.b(i);
      Object localObject2;
      if (str2.equals(":status"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("HTTP/1.1 ");
        ((StringBuilder)localObject1).append(str1);
        localObject2 = k.a(((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject2 = localObject1;
        if (!c.contains(str2))
        {
          a.a.a(locala, str2, str1);
          localObject2 = localObject1;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return new ac.a().a(paramy).a(((k)localObject1).b).a(((k)localObject1).c).a(locala.a());
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public static List<c> b(aa paramaa)
  {
    e.s locals = paramaa.c();
    ArrayList localArrayList = new ArrayList(locals.a() + 4);
    localArrayList.add(new c(c.c, paramaa.b()));
    localArrayList.add(new c(c.d, e.a.c.i.a(paramaa.a())));
    String str = paramaa.a("Host");
    if (str != null) {
      localArrayList.add(new c(c.f, str));
    }
    localArrayList.add(new c(c.e, paramaa.a().b()));
    int i = 0;
    int j = locals.a();
    while (i < j)
    {
      paramaa = f.f.encodeUtf8(locals.a(i).toLowerCase(Locale.US));
      if (!b.contains(paramaa.utf8())) {
        localArrayList.add(new c(paramaa, locals.b(i)));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public ac.a a(boolean paramBoolean)
    throws IOException
  {
    ac.a locala = a(this.f.d(), this.g);
    if ((paramBoolean) && (a.a.a(locala) == 100)) {
      return null;
    }
    return locala;
  }
  
  public ad a(ac paramac)
    throws IOException
  {
    this.a.c.f(this.a.b);
    return new e.a.c.h(paramac.a("Content-Type"), e.a(paramac), l.a(new a(this.f.g())));
  }
  
  public r a(aa paramaa, long paramLong)
  {
    return this.f.h();
  }
  
  public void a()
    throws IOException
  {
    this.e.b();
  }
  
  public void a(aa paramaa)
    throws IOException
  {
    if (this.f != null) {
      return;
    }
    boolean bool;
    if (paramaa.d() != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramaa = b(paramaa);
    this.f = this.e.a(paramaa, bool);
    this.f.e().a(this.d.d(), TimeUnit.MILLISECONDS);
    this.f.f().a(this.d.e(), TimeUnit.MILLISECONDS);
  }
  
  public void b()
    throws IOException
  {
    this.f.h().close();
  }
  
  public void c()
  {
    if (this.f != null) {
      this.f.b(b.CANCEL);
    }
  }
  
  class a
    extends f.h
  {
    boolean a = false;
    long b = 0L;
    
    a(f.s params)
    {
      super();
    }
    
    private void a(IOException paramIOException)
    {
      if (this.a) {
        return;
      }
      this.a = true;
      f.this.a.a(false, f.this, this.b, paramIOException);
    }
    
    public void close()
      throws IOException
    {
      super.close();
      a(null);
    }
    
    public long read(f.c paramc, long paramLong)
      throws IOException
    {
      try
      {
        paramLong = delegate().read(paramc, paramLong);
        if (paramLong > 0L) {
          this.b += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramc)
      {
        a(paramc);
        throw paramc;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */