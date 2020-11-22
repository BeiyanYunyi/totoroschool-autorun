package com.totoro.school.utilpub.network.b;

import com.totoro.school.utils.h;
import e.aa;
import e.aa.a;
import e.ab;
import e.ac;
import e.ac.a;
import e.ad;
import e.t;
import e.u;
import e.u.a;
import e.v;
import f.c;
import f.d;
import java.io.IOException;

public class a
  implements u
{
  public ac a(u.a parama)
    throws IOException
  {
    Object localObject2 = parama.a();
    String str = ((aa)localObject2).a().toString();
    v localv = v.b("application/json");
    if (!str.contains("CGTService.svc"))
    {
      parama = parama.a(((aa)localObject2).e().a());
      localObject1 = ad.create(localv, parama.g().string());
      parama = parama.h().a((ad)localObject1).a();
      parama.close();
      return parama;
    }
    Object localObject1 = ((aa)localObject2).d();
    if (localObject1 != null)
    {
      localObject3 = new c();
      ((ab)localObject1).writeTo((d)localObject3);
      localObject1 = ((c)localObject3).o();
      ((c)localObject3).close();
    }
    else
    {
      localObject1 = "";
    }
    Object localObject3 = com.totoro.school.utilpub.network.a.a.a((String)localObject1);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("\"");
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append("\"");
    localObject4 = ab.create(localv, ((StringBuilder)localObject4).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HttpCommonInterceptor 加密前报文：");
    localStringBuilder.append((String)localObject1);
    h.a("test", localStringBuilder.toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("HttpCommonInterceptor 加密后报文：");
    ((StringBuilder)localObject1).append((String)localObject3);
    h.a("test", ((StringBuilder)localObject1).toString());
    parama = parama.a(((aa)localObject2).e().a("Content-Type", ((ab)localObject4).contentType().toString()).a(((aa)localObject2).b(), (ab)localObject4).a(str).a());
    localObject1 = parama.g();
    localObject2 = com.totoro.school.utilpub.network.a.a.b(((ad)localObject1).string());
    ((ad)localObject1).close();
    localObject1 = ad.create(localv, (String)localObject2);
    parama = parama.h().a((ad)localObject1).a();
    parama.close();
    return parama;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */