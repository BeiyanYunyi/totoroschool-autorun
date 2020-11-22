package e.a.c;

import e.a.c;
import e.a.d;
import e.aa;
import e.aa.a;
import e.ab;
import e.ac;
import e.ac.a;
import e.ad;
import e.m;
import e.s.a;
import e.u;
import e.u.a;
import e.v;
import f.j;
import java.io.IOException;
import java.util.List;

public final class a
  implements u
{
  private final m a;
  
  public a(m paramm)
  {
    this.a = paramm;
  }
  
  private String a(List<e.l> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      e.l locall = (e.l)paramList.get(i);
      localStringBuilder.append(locall.a());
      localStringBuilder.append('=');
      localStringBuilder.append(locall.b());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public ac a(u.a parama)
    throws IOException
  {
    Object localObject1 = parama.a();
    Object localObject2 = ((aa)localObject1).e();
    Object localObject3 = ((aa)localObject1).d();
    if (localObject3 != null)
    {
      v localv = ((ab)localObject3).contentType();
      if (localv != null) {
        ((aa.a)localObject2).a("Content-Type", localv.toString());
      }
      long l = ((ab)localObject3).contentLength();
      if (l != -1L)
      {
        ((aa.a)localObject2).a("Content-Length", Long.toString(l));
        ((aa.a)localObject2).b("Transfer-Encoding");
      }
      else
      {
        ((aa.a)localObject2).a("Transfer-Encoding", "chunked");
        ((aa.a)localObject2).b("Content-Length");
      }
    }
    localObject3 = ((aa)localObject1).a("Host");
    int j = 0;
    if (localObject3 == null) {
      ((aa.a)localObject2).a("Host", c.a(((aa)localObject1).a(), false));
    }
    if (((aa)localObject1).a("Connection") == null) {
      ((aa.a)localObject2).a("Connection", "Keep-Alive");
    }
    int i = j;
    if (((aa)localObject1).a("Accept-Encoding") == null)
    {
      i = j;
      if (((aa)localObject1).a("Range") == null)
      {
        i = 1;
        ((aa.a)localObject2).a("Accept-Encoding", "gzip");
      }
    }
    localObject3 = this.a.a(((aa)localObject1).a());
    if (!((List)localObject3).isEmpty()) {
      ((aa.a)localObject2).a("Cookie", a((List)localObject3));
    }
    if (((aa)localObject1).a("User-Agent") == null) {
      ((aa.a)localObject2).a("User-Agent", d.a());
    }
    parama = parama.a(((aa.a)localObject2).a());
    e.a(this.a, ((aa)localObject1).a(), parama.f());
    localObject1 = parama.h().a((aa)localObject1);
    if ((i != 0) && ("gzip".equalsIgnoreCase(parama.a("Content-Encoding"))) && (e.b(parama)))
    {
      localObject2 = new j(parama.g().source());
      ((ac.a)localObject1).a(parama.f().b().b("Content-Encoding").b("Content-Length").a());
      ((ac.a)localObject1).a(new h(parama.a("Content-Type"), -1L, f.l.a((f.s)localObject2)));
    }
    return ((ac.a)localObject1).a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */