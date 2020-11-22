package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.b.k;

public class c<T>
  implements k<T>
{
  protected final T a;
  
  public c(T paramT)
  {
    if (paramT != null)
    {
      this.a = paramT;
      return;
    }
    throw new NullPointerException("Data must not be null");
  }
  
  public final T b()
  {
    return (T)this.a;
  }
  
  public final int c()
  {
    return 1;
  }
  
  public void d() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */