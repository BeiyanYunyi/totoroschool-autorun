package com.bumptech.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.f;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.resource.e.c;
import com.bumptech.glide.manager.m;
import java.io.InputStream;

public class b<ModelType>
  extends a<ModelType>
{
  private final l<ModelType, InputStream> g;
  private final l<ModelType, ParcelFileDescriptor> h;
  private final h.c i;
  
  b(Class<ModelType> paramClass, l<ModelType, InputStream> paraml, l<ModelType, ParcelFileDescriptor> paraml1, Context paramContext, e parame, m paramm, com.bumptech.glide.manager.g paramg, h.c paramc)
  {
    super(paramContext, paramClass, a(parame, paraml, paraml1, com.bumptech.glide.load.resource.d.a.class, com.bumptech.glide.load.resource.a.b.class, null), parame, paramm, paramg);
    this.g = paraml;
    this.h = paraml1;
    this.i = paramc;
  }
  
  private static <A, Z, R> com.bumptech.glide.e.e<A, com.bumptech.glide.load.c.g, Z, R> a(e parame, l<A, InputStream> paraml, l<A, ParcelFileDescriptor> paraml1, Class<Z> paramClass, Class<R> paramClass1, c<Z, R> paramc)
  {
    if ((paraml == null) && (paraml1 == null)) {
      return null;
    }
    Object localObject = paramc;
    if (paramc == null) {
      localObject = parame.a(paramClass, paramClass1);
    }
    parame = parame.b(com.bumptech.glide.load.c.g.class, paramClass);
    return new com.bumptech.glide.e.e(new f(paraml, paraml1), (c)localObject, parame);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */