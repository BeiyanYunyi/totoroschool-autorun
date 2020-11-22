package e.a.a;

import e.a.a;
import e.a.c.e;
import e.aa;
import e.aa.a;
import e.ac;
import e.ac.a;
import e.s;
import e.s.a;
import e.t;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class c
{
  @Nullable
  public final aa a;
  @Nullable
  public final ac b;
  
  c(aa paramaa, ac paramac)
  {
    this.a = paramaa;
    this.b = paramac;
  }
  
  public static boolean a(ac paramac, aa paramaa)
  {
    int i = paramac.b();
    boolean bool2 = false;
    switch (i)
    {
    default: 
      return false;
    case 302: 
    case 307: 
      if ((paramac.a("Expires") == null) && (paramac.j().c() == -1) && (!paramac.j().e()) && (!paramac.j().d())) {
        break;
      }
    case 200: 
    case 203: 
    case 204: 
    case 300: 
    case 301: 
    case 308: 
    case 404: 
    case 405: 
    case 410: 
    case 414: 
    case 501: 
      boolean bool1 = bool2;
      if (!paramac.j().b())
      {
        bool1 = bool2;
        if (!paramaa.f().b()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public static class a
  {
    final long a;
    final aa b;
    final ac c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;
    
    public a(long paramLong, aa paramaa, ac paramac)
    {
      this.a = paramLong;
      this.b = paramaa;
      this.c = paramac;
      if (paramac != null)
      {
        this.i = paramac.k();
        this.j = paramac.l();
        paramaa = paramac.f();
        int m = 0;
        int n = paramaa.a();
        while (m < n)
        {
          paramac = paramaa.a(m);
          String str = paramaa.b(m);
          if ("Date".equalsIgnoreCase(paramac))
          {
            this.d = e.a.c.d.a(str);
            this.e = str;
          }
          else if ("Expires".equalsIgnoreCase(paramac))
          {
            this.h = e.a.c.d.a(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramac))
          {
            this.f = e.a.c.d.a(str);
            this.g = str;
          }
          else if ("ETag".equalsIgnoreCase(paramac))
          {
            this.k = str;
          }
          else if ("Age".equalsIgnoreCase(paramac))
          {
            this.l = e.b(str, -1);
          }
          m += 1;
        }
      }
    }
    
    private static boolean a(aa paramaa)
    {
      return (paramaa.a("If-Modified-Since") != null) || (paramaa.a("If-None-Match") != null);
    }
    
    private c b()
    {
      if (this.c == null) {
        return new c(this.b, null);
      }
      if ((this.b.g()) && (this.c.e() == null)) {
        return new c(this.b, null);
      }
      if (!c.a(this.c, this.b)) {
        return new c(this.b, null);
      }
      Object localObject1 = this.b.f();
      if ((!((e.d)localObject1).a()) && (!a(this.b)))
      {
        Object localObject2 = this.c.j();
        long l5 = d();
        long l2 = c();
        long l1 = l2;
        if (((e.d)localObject1).c() != -1) {
          l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((e.d)localObject1).c()));
        }
        int m = ((e.d)localObject1).h();
        long l4 = 0L;
        if (m != -1) {
          l2 = TimeUnit.SECONDS.toMillis(((e.d)localObject1).h());
        } else {
          l2 = 0L;
        }
        long l3 = l4;
        if (!((e.d)localObject2).f())
        {
          l3 = l4;
          if (((e.d)localObject1).g() != -1) {
            l3 = TimeUnit.SECONDS.toMillis(((e.d)localObject1).g());
          }
        }
        if (!((e.d)localObject2).a())
        {
          l2 += l5;
          if (l2 < l3 + l1)
          {
            localObject1 = this.c.h();
            if (l2 >= l1) {
              ((ac.a)localObject1).b("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if ((l5 > 86400000L) && (e())) {
              ((ac.a)localObject1).b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new c(null, ((ac.a)localObject1).a());
          }
        }
        if (this.k != null)
        {
          localObject1 = "If-None-Match";
          localObject2 = this.k;
        }
        else if (this.f != null)
        {
          localObject1 = "If-Modified-Since";
          localObject2 = this.g;
        }
        else
        {
          if (this.d == null) {
            break label436;
          }
          localObject1 = "If-Modified-Since";
          localObject2 = this.e;
        }
        s.a locala = this.b.c().b();
        a.a.a(locala, (String)localObject1, (String)localObject2);
        return new c(this.b.e().a(locala.a()).a(), this.c);
        label436:
        return new c(this.b, null);
      }
      return new c(this.b, null);
    }
    
    private long c()
    {
      Object localObject = this.c.j();
      if (((e.d)localObject).c() != -1) {
        return TimeUnit.SECONDS.toMillis(((e.d)localObject).c());
      }
      localObject = this.h;
      long l1 = 0L;
      long l2;
      if (localObject != null)
      {
        if (this.d != null) {
          l2 = this.d.getTime();
        } else {
          l2 = this.j;
        }
        l2 = this.h.getTime() - l2;
        if (l2 > 0L) {
          l1 = l2;
        }
        return l1;
      }
      if ((this.f != null) && (this.c.a().a().l() == null))
      {
        if (this.d != null) {
          l2 = this.d.getTime();
        } else {
          l2 = this.i;
        }
        l2 -= this.f.getTime();
        if (l2 > 0L) {
          l1 = l2 / 10L;
        }
        return l1;
      }
      return 0L;
    }
    
    private long d()
    {
      Date localDate = this.d;
      long l1 = 0L;
      if (localDate != null) {
        l1 = Math.max(0L, this.j - this.d.getTime());
      }
      long l2 = l1;
      if (this.l != -1) {
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l));
      }
      return l2 + (this.j - this.i) + (this.a - this.j);
    }
    
    private boolean e()
    {
      return (this.c.j().c() == -1) && (this.h == null);
    }
    
    public c a()
    {
      c localc = b();
      if ((localc.a != null) && (this.b.f().i())) {
        return new c(null, null);
      }
      return localc;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */