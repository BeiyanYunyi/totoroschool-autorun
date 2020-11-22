package e;

import e.a.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a
{
  final t a;
  final o b;
  final SocketFactory c;
  final b d;
  final List<y> e;
  final List<k> f;
  final ProxySelector g;
  @Nullable
  final Proxy h;
  @Nullable
  final SSLSocketFactory i;
  @Nullable
  final HostnameVerifier j;
  @Nullable
  final g k;
  
  public a(String paramString, int paramInt, o paramo, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable g paramg, b paramb, @Nullable Proxy paramProxy, List<y> paramList, List<k> paramList1, ProxySelector paramProxySelector)
  {
    t.a locala = new t.a();
    String str;
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    }
    this.a = locala.a(str).d(paramString).a(paramInt).c();
    if (paramo != null)
    {
      this.b = paramo;
      if (paramSocketFactory != null)
      {
        this.c = paramSocketFactory;
        if (paramb != null)
        {
          this.d = paramb;
          if (paramList != null)
          {
            this.e = c.a(paramList);
            if (paramList1 != null)
            {
              this.f = c.a(paramList1);
              if (paramProxySelector != null)
              {
                this.g = paramProxySelector;
                this.h = paramProxy;
                this.i = paramSSLSocketFactory;
                this.j = paramHostnameVerifier;
                this.k = paramg;
                return;
              }
              throw new NullPointerException("proxySelector == null");
            }
            throw new NullPointerException("connectionSpecs == null");
          }
          throw new NullPointerException("protocols == null");
        }
        throw new NullPointerException("proxyAuthenticator == null");
      }
      throw new NullPointerException("socketFactory == null");
    }
    throw new NullPointerException("dns == null");
  }
  
  public t a()
  {
    return this.a;
  }
  
  boolean a(a parama)
  {
    return (this.b.equals(parama.b)) && (this.d.equals(parama.d)) && (this.e.equals(parama.e)) && (this.f.equals(parama.f)) && (this.g.equals(parama.g)) && (c.a(this.h, parama.h)) && (c.a(this.i, parama.i)) && (c.a(this.j, parama.j)) && (c.a(this.k, parama.k)) && (a().g() == parama.a().g());
  }
  
  public o b()
  {
    return this.b;
  }
  
  public SocketFactory c()
  {
    return this.c;
  }
  
  public b d()
  {
    return this.d;
  }
  
  public List<y> e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      t localt = this.a;
      paramObject = (a)paramObject;
      if ((localt.equals(((a)paramObject).a)) && (a((a)paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  public List<k> f()
  {
    return this.f;
  }
  
  public ProxySelector g()
  {
    return this.g;
  }
  
  @Nullable
  public Proxy h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    int i3 = this.a.hashCode();
    int i4 = this.b.hashCode();
    int i5 = this.d.hashCode();
    int i6 = this.e.hashCode();
    int i7 = this.f.hashCode();
    int i8 = this.g.hashCode();
    Proxy localProxy = this.h;
    int i2 = 0;
    int m;
    if (localProxy != null) {
      m = this.h.hashCode();
    } else {
      m = 0;
    }
    int n;
    if (this.i != null) {
      n = this.i.hashCode();
    } else {
      n = 0;
    }
    int i1;
    if (this.j != null) {
      i1 = this.j.hashCode();
    } else {
      i1 = 0;
    }
    if (this.k != null) {
      i2 = this.k.hashCode();
    }
    return (((((((((527 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  @Nullable
  public SSLSocketFactory i()
  {
    return this.i;
  }
  
  @Nullable
  public HostnameVerifier j()
  {
    return this.j;
  }
  
  @Nullable
  public g k()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Address{");
    localStringBuilder.append(this.a.f());
    localStringBuilder.append(":");
    localStringBuilder.append(this.a.g());
    if (this.h != null)
    {
      localStringBuilder.append(", proxy=");
      localStringBuilder.append(this.h);
    }
    else
    {
      localStringBuilder.append(", proxySelector=");
      localStringBuilder.append(this.g);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */