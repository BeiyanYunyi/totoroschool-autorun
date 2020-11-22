package com.bumptech.glide.load.resource.e;

import com.bumptech.glide.h.g;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static final g a = new g();
  private final Map<g, c<?, ?>> b = new HashMap();
  
  public <Z, R> c<Z, R> a(Class<Z> paramClass, Class<R> paramClass1)
  {
    if (paramClass.equals(paramClass1)) {
      return e.b();
    }
    synchronized (a)
    {
      a.a(paramClass, paramClass1);
      c localc = (c)this.b.get(a);
      if (localc != null) {
        return localc;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("No transcoder registered for ");
      ((StringBuilder)???).append(paramClass);
      ((StringBuilder)???).append(" and ");
      ((StringBuilder)???).append(paramClass1);
      throw new IllegalArgumentException(((StringBuilder)???).toString());
    }
  }
  
  public <Z, R> void a(Class<Z> paramClass, Class<R> paramClass1, c<Z, R> paramc)
  {
    this.b.put(new g(paramClass, paramClass1), paramc);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */