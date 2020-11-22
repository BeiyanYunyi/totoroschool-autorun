package com.google.gson.b.a;

import com.google.gson.a.b;
import com.google.gson.b.c;
import com.google.gson.b.h;
import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.i;
import com.google.gson.q;
import com.google.gson.t;
import com.google.gson.u;

public final class d
  implements u
{
  private final c a;
  
  public d(c paramc)
  {
    this.a = paramc;
  }
  
  t<?> a(c paramc, e parame, a<?> parama, b paramb)
  {
    Object localObject = paramc.a(a.b(paramb.a())).a();
    if ((localObject instanceof t))
    {
      paramc = (t)localObject;
    }
    else if ((localObject instanceof u))
    {
      paramc = ((u)localObject).a(parame, parama);
    }
    else
    {
      boolean bool = localObject instanceof q;
      if ((!bool) && (!(localObject instanceof i)))
      {
        paramc = new StringBuilder();
        paramc.append("Invalid attempt to bind an instance of ");
        paramc.append(localObject.getClass().getName());
        paramc.append(" as a @JsonAdapter for ");
        paramc.append(parama.toString());
        paramc.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        throw new IllegalArgumentException(paramc.toString());
      }
      i locali = null;
      if (bool) {
        paramc = (q)localObject;
      } else {
        paramc = null;
      }
      if ((localObject instanceof i)) {
        locali = (i)localObject;
      }
      paramc = new l(paramc, locali, parame, parama, null);
    }
    parame = paramc;
    if (paramc != null)
    {
      parame = paramc;
      if (paramb.b()) {
        parame = paramc.a();
      }
    }
    return parame;
  }
  
  public <T> t<T> a(e parame, a<T> parama)
  {
    b localb = (b)parama.a().getAnnotation(b.class);
    if (localb == null) {
      return null;
    }
    return a(this.a, parame, parama, localb);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */