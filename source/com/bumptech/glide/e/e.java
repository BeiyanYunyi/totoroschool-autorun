package com.bumptech.glide.e;

import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.resource.e.c;
import java.io.File;

public class e<A, T, Z, R>
  implements f<A, T, Z, R>
{
  private final l<A, T> a;
  private final c<Z, R> b;
  private final b<T, Z> c;
  
  public e(l<A, T> paraml, c<Z, R> paramc, b<T, Z> paramb)
  {
    if (paraml != null)
    {
      this.a = paraml;
      if (paramc != null)
      {
        this.b = paramc;
        if (paramb != null)
        {
          this.c = paramb;
          return;
        }
        throw new NullPointerException("DataLoadProvider must not be null");
      }
      throw new NullPointerException("Transcoder must not be null");
    }
    throw new NullPointerException("ModelLoader must not be null");
  }
  
  public com.bumptech.glide.load.e<File, Z> a()
  {
    return this.c.a();
  }
  
  public com.bumptech.glide.load.e<T, Z> b()
  {
    return this.c.b();
  }
  
  public com.bumptech.glide.load.b<T> c()
  {
    return this.c.c();
  }
  
  public com.bumptech.glide.load.f<Z> d()
  {
    return this.c.d();
  }
  
  public l<A, T> e()
  {
    return this.a;
  }
  
  public c<Z, R> f()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */