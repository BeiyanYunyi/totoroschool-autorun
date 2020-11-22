package e;

import java.io.Closeable;
import javax.annotation.Nullable;

public final class ac
  implements Closeable
{
  final aa a;
  final y b;
  final int c;
  final String d;
  @Nullable
  final r e;
  final s f;
  @Nullable
  final ad g;
  @Nullable
  final ac h;
  @Nullable
  final ac i;
  @Nullable
  final ac j;
  final long k;
  final long l;
  @Nullable
  private volatile d m;
  
  ac(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f.a();
    this.g = parama.g;
    this.h = parama.h;
    this.i = parama.i;
    this.j = parama.j;
    this.k = parama.k;
    this.l = parama.l;
  }
  
  public aa a()
  {
    return this.a;
  }
  
  @Nullable
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  @Nullable
  public String a(String paramString1, @Nullable String paramString2)
  {
    paramString1 = this.f.a(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return (this.c >= 200) && (this.c < 300);
  }
  
  public void close()
  {
    if (this.g != null)
    {
      this.g.close();
      return;
    }
    throw new IllegalStateException("response is not eligible for a body and must not be closed");
  }
  
  public String d()
  {
    return this.d;
  }
  
  @Nullable
  public r e()
  {
    return this.e;
  }
  
  public s f()
  {
    return this.f;
  }
  
  @Nullable
  public ad g()
  {
    return this.g;
  }
  
  public a h()
  {
    return new a(this);
  }
  
  @Nullable
  public ac i()
  {
    return this.j;
  }
  
  public d j()
  {
    d locald = this.m;
    if (locald != null) {
      return locald;
    }
    locald = d.a(this.f);
    this.m = locald;
    return locald;
  }
  
  public long k()
  {
    return this.k;
  }
  
  public long l()
  {
    return this.l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response{protocol=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.a.a());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    @Nullable
    aa a;
    @Nullable
    y b;
    int c = -1;
    String d;
    @Nullable
    r e;
    s.a f;
    @Nullable
    ad g;
    @Nullable
    ac h;
    @Nullable
    ac i;
    @Nullable
    ac j;
    long k;
    long l;
    
    public a()
    {
      this.f = new s.a();
    }
    
    a(ac paramac)
    {
      this.a = paramac.a;
      this.b = paramac.b;
      this.c = paramac.c;
      this.d = paramac.d;
      this.e = paramac.e;
      this.f = paramac.f.b();
      this.g = paramac.g;
      this.h = paramac.h;
      this.i = paramac.i;
      this.j = paramac.j;
      this.k = paramac.k;
      this.l = paramac.l;
    }
    
    private void a(String paramString, ac paramac)
    {
      if (paramac.g == null)
      {
        if (paramac.h == null)
        {
          if (paramac.i == null)
          {
            if (paramac.j == null) {
              return;
            }
            paramac = new StringBuilder();
            paramac.append(paramString);
            paramac.append(".priorResponse != null");
            throw new IllegalArgumentException(paramac.toString());
          }
          paramac = new StringBuilder();
          paramac.append(paramString);
          paramac.append(".cacheResponse != null");
          throw new IllegalArgumentException(paramac.toString());
        }
        paramac = new StringBuilder();
        paramac.append(paramString);
        paramac.append(".networkResponse != null");
        throw new IllegalArgumentException(paramac.toString());
      }
      paramac = new StringBuilder();
      paramac.append(paramString);
      paramac.append(".body != null");
      throw new IllegalArgumentException(paramac.toString());
    }
    
    private void d(ac paramac)
    {
      if (paramac.g == null) {
        return;
      }
      throw new IllegalArgumentException("priorResponse.body != null");
    }
    
    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.k = paramLong;
      return this;
    }
    
    public a a(aa paramaa)
    {
      this.a = paramaa;
      return this;
    }
    
    public a a(@Nullable ac paramac)
    {
      if (paramac != null) {
        a("networkResponse", paramac);
      }
      this.h = paramac;
      return this;
    }
    
    public a a(@Nullable ad paramad)
    {
      this.g = paramad;
      return this;
    }
    
    public a a(@Nullable r paramr)
    {
      this.e = paramr;
      return this;
    }
    
    public a a(s params)
    {
      this.f = params.b();
      return this;
    }
    
    public a a(y paramy)
    {
      this.b = paramy;
      return this;
    }
    
    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.f.c(paramString1, paramString2);
      return this;
    }
    
    public ac a()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          if (this.c >= 0)
          {
            if (this.d != null) {
              return new ac(this);
            }
            throw new IllegalStateException("message == null");
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("code < 0: ");
          localStringBuilder.append(this.c);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        throw new IllegalStateException("protocol == null");
      }
      throw new IllegalStateException("request == null");
    }
    
    public a b(long paramLong)
    {
      this.l = paramLong;
      return this;
    }
    
    public a b(@Nullable ac paramac)
    {
      if (paramac != null) {
        a("cacheResponse", paramac);
      }
      this.i = paramac;
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.f.a(paramString1, paramString2);
      return this;
    }
    
    public a c(@Nullable ac paramac)
    {
      if (paramac != null) {
        d(paramac);
      }
      this.j = paramac;
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */