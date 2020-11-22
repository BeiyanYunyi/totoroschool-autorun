package com.bumptech.glide.load.resource.d;

import com.bumptech.glide.load.b.k;

public class b
  implements k<a>
{
  private final a a;
  
  public b(a parama)
  {
    if (parama != null)
    {
      this.a = parama;
      return;
    }
    throw new NullPointerException("Data must not be null");
  }
  
  public a a()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.a.a();
  }
  
  public void d()
  {
    k localk = this.a.b();
    if (localk != null) {
      localk.d();
    }
    localk = this.a.c();
    if (localk != null) {
      localk.d();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */