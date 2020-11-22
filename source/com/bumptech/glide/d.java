package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.e.f;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.m;

public class d<ModelType, DataType, ResourceType>
  extends c<ModelType, DataType, ResourceType, ResourceType>
{
  private final l<ModelType, DataType> g;
  private final Class<DataType> h;
  private final Class<ResourceType> i;
  private final h.c j;
  
  d(Context paramContext, e parame, Class<ModelType> paramClass, l<ModelType, DataType> paraml, Class<DataType> paramClass1, Class<ResourceType> paramClass2, m paramm, g paramg, h.c paramc)
  {
    super(paramContext, paramClass, a(parame, paraml, paramClass1, paramClass2, com.bumptech.glide.load.resource.e.e.b()), paramClass2, parame, paramm, paramg);
    this.g = paraml;
    this.h = paramClass1;
    this.i = paramClass2;
    this.j = paramc;
  }
  
  private static <A, T, Z, R> f<A, T, Z, R> a(e parame, l<A, T> paraml, Class<T> paramClass, Class<Z> paramClass1, com.bumptech.glide.load.resource.e.c<Z, R> paramc)
  {
    return new com.bumptech.glide.e.e(paraml, paramc, parame.b(paramClass, paramClass1));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */