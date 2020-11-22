package e;

import e.a.g.f;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class x
  implements e.a, Cloneable
{
  static final List<y> a = e.a.c.a(new y[] { y.HTTP_2, y.HTTP_1_1 });
  static final List<k> b = e.a.c.a(new k[] { k.b, k.d });
  final int A;
  final int B;
  final int C;
  final int D;
  final n c;
  @Nullable
  final Proxy d;
  final List<y> e;
  final List<k> f;
  final List<u> g;
  final List<u> h;
  final p.a i;
  final ProxySelector j;
  final m k;
  @Nullable
  final c l;
  @Nullable
  final e.a.a.e m;
  final SocketFactory n;
  final SSLSocketFactory o;
  final e.a.j.c p;
  final HostnameVerifier q;
  final g r;
  final b s;
  final b t;
  final j u;
  final o v;
  final boolean w;
  final boolean x;
  final boolean y;
  final int z;
  
  static
  {
    e.a.a.a = new e.a.a()
    {
      public int a(ac.a paramAnonymousa)
      {
        return paramAnonymousa.c;
      }
      
      public e.a.b.c a(j paramAnonymousj, a paramAnonymousa, e.a.b.g paramAnonymousg, ae paramAnonymousae)
      {
        return paramAnonymousj.a(paramAnonymousa, paramAnonymousg, paramAnonymousae);
      }
      
      public e.a.b.d a(j paramAnonymousj)
      {
        return paramAnonymousj.a;
      }
      
      @Nullable
      public IOException a(e paramAnonymouse, @Nullable IOException paramAnonymousIOException)
      {
        return ((z)paramAnonymouse).a(paramAnonymousIOException);
      }
      
      public Socket a(j paramAnonymousj, a paramAnonymousa, e.a.b.g paramAnonymousg)
      {
        return paramAnonymousj.a(paramAnonymousa, paramAnonymousg);
      }
      
      public void a(k paramAnonymousk, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        paramAnonymousk.a(paramAnonymousSSLSocket, paramAnonymousBoolean);
      }
      
      public void a(s.a paramAnonymousa, String paramAnonymousString)
      {
        paramAnonymousa.a(paramAnonymousString);
      }
      
      public void a(s.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousa.b(paramAnonymousString1, paramAnonymousString2);
      }
      
      public boolean a(a paramAnonymousa1, a paramAnonymousa2)
      {
        return paramAnonymousa1.a(paramAnonymousa2);
      }
      
      public boolean a(j paramAnonymousj, e.a.b.c paramAnonymousc)
      {
        return paramAnonymousj.b(paramAnonymousc);
      }
      
      public void b(j paramAnonymousj, e.a.b.c paramAnonymousc)
      {
        paramAnonymousj.a(paramAnonymousc);
      }
    };
  }
  
  public x()
  {
    this(new a());
  }
  
  x(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = e.a.c.a(parama.e);
    this.h = e.a.c.a(parama.f);
    this.i = parama.g;
    this.j = parama.h;
    this.k = parama.i;
    this.l = parama.j;
    this.m = parama.k;
    this.n = parama.l;
    Object localObject = this.f.iterator();
    for (int i1 = 0;; i1 = 1)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label155;
      }
      k localk = (k)((Iterator)localObject).next();
      if ((i1 == 0) && (!localk.a())) {
        break;
      }
    }
    label155:
    if ((parama.m == null) && (i1 != 0))
    {
      localObject = e.a.c.a();
      this.o = a((X509TrustManager)localObject);
      this.p = e.a.j.c.a((X509TrustManager)localObject);
    }
    else
    {
      this.o = parama.m;
      this.p = parama.n;
    }
    if (this.o != null) {
      f.c().a(this.o);
    }
    this.q = parama.o;
    this.r = parama.p.a(this.p);
    this.s = parama.q;
    this.t = parama.r;
    this.u = parama.s;
    this.v = parama.t;
    this.w = parama.u;
    this.x = parama.v;
    this.y = parama.w;
    this.z = parama.x;
    this.A = parama.y;
    this.B = parama.z;
    this.C = parama.A;
    this.D = parama.B;
    if (!this.g.contains(null))
    {
      if (!this.h.contains(null)) {
        return;
      }
      parama = new StringBuilder();
      parama.append("Null network interceptor: ");
      parama.append(this.h);
      throw new IllegalStateException(parama.toString());
    }
    parama = new StringBuilder();
    parama.append("Null interceptor: ");
    parama.append(this.g);
    throw new IllegalStateException(parama.toString());
  }
  
  private static SSLSocketFactory a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = f.c().b();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw e.a.c.a("No System TLS", paramX509TrustManager);
    }
  }
  
  public a A()
  {
    return new a(this);
  }
  
  public int a()
  {
    return this.z;
  }
  
  public e a(aa paramaa)
  {
    return z.a(this, paramaa, false);
  }
  
  public int b()
  {
    return this.A;
  }
  
  public int c()
  {
    return this.B;
  }
  
  public int d()
  {
    return this.C;
  }
  
  public int e()
  {
    return this.D;
  }
  
  @Nullable
  public Proxy f()
  {
    return this.d;
  }
  
  public ProxySelector g()
  {
    return this.j;
  }
  
  public m h()
  {
    return this.k;
  }
  
  e.a.a.e i()
  {
    if (this.l != null) {
      return this.l.a;
    }
    return this.m;
  }
  
  public o j()
  {
    return this.v;
  }
  
  public SocketFactory k()
  {
    return this.n;
  }
  
  public SSLSocketFactory l()
  {
    return this.o;
  }
  
  public HostnameVerifier m()
  {
    return this.q;
  }
  
  public g n()
  {
    return this.r;
  }
  
  public b o()
  {
    return this.t;
  }
  
  public b p()
  {
    return this.s;
  }
  
  public j q()
  {
    return this.u;
  }
  
  public boolean r()
  {
    return this.w;
  }
  
  public boolean s()
  {
    return this.x;
  }
  
  public boolean t()
  {
    return this.y;
  }
  
  public n u()
  {
    return this.c;
  }
  
  public List<y> v()
  {
    return this.e;
  }
  
  public List<k> w()
  {
    return this.f;
  }
  
  public List<u> x()
  {
    return this.g;
  }
  
  public List<u> y()
  {
    return this.h;
  }
  
  public p.a z()
  {
    return this.i;
  }
  
  public static final class a
  {
    int A;
    int B;
    n a;
    @Nullable
    Proxy b;
    List<y> c;
    List<k> d;
    final List<u> e = new ArrayList();
    final List<u> f = new ArrayList();
    p.a g;
    ProxySelector h;
    m i;
    @Nullable
    c j;
    @Nullable
    e.a.a.e k;
    SocketFactory l;
    @Nullable
    SSLSocketFactory m;
    @Nullable
    e.a.j.c n;
    HostnameVerifier o;
    g p;
    b q;
    b r;
    j s;
    o t;
    boolean u;
    boolean v;
    boolean w;
    int x;
    int y;
    int z;
    
    public a()
    {
      this.a = new n();
      this.c = x.a;
      this.d = x.b;
      this.g = p.a(p.a);
      this.h = ProxySelector.getDefault();
      if (this.h == null) {
        this.h = new e.a.h.a();
      }
      this.i = m.a;
      this.l = SocketFactory.getDefault();
      this.o = e.a.j.d.a;
      this.p = g.a;
      this.q = b.a;
      this.r = b.a;
      this.s = new j();
      this.t = o.a;
      this.u = true;
      this.v = true;
      this.w = true;
      this.x = 0;
      this.y = 10000;
      this.z = 10000;
      this.A = 10000;
      this.B = 0;
    }
    
    a(x paramx)
    {
      this.a = paramx.c;
      this.b = paramx.d;
      this.c = paramx.e;
      this.d = paramx.f;
      this.e.addAll(paramx.g);
      this.f.addAll(paramx.h);
      this.g = paramx.i;
      this.h = paramx.j;
      this.i = paramx.k;
      this.k = paramx.m;
      this.j = paramx.l;
      this.l = paramx.n;
      this.m = paramx.o;
      this.n = paramx.p;
      this.o = paramx.q;
      this.p = paramx.r;
      this.q = paramx.s;
      this.r = paramx.t;
      this.s = paramx.u;
      this.t = paramx.v;
      this.u = paramx.w;
      this.v = paramx.x;
      this.w = paramx.y;
      this.x = paramx.z;
      this.y = paramx.A;
      this.z = paramx.B;
      this.A = paramx.C;
      this.B = paramx.D;
    }
    
    public a a(long paramLong, TimeUnit paramTimeUnit)
    {
      this.y = e.a.c.a("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public a a(u paramu)
    {
      if (paramu != null)
      {
        this.e.add(paramu);
        return this;
      }
      throw new IllegalArgumentException("interceptor == null");
    }
    
    public a a(@Nullable Proxy paramProxy)
    {
      this.b = paramProxy;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.w = paramBoolean;
      return this;
    }
    
    public x a()
    {
      return new x(this);
    }
    
    public a b(long paramLong, TimeUnit paramTimeUnit)
    {
      this.z = e.a.c.a("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public a b(u paramu)
    {
      if (paramu != null)
      {
        this.f.add(paramu);
        return this;
      }
      throw new IllegalArgumentException("interceptor == null");
    }
    
    public a c(long paramLong, TimeUnit paramTimeUnit)
    {
      this.A = e.a.c.a("timeout", paramLong, paramTimeUnit);
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */