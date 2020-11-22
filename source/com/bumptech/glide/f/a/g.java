package com.bumptech.glide.f.a;

public class g<R>
  implements d<R>
{
  private final f.a a;
  private c<R> b;
  
  g(f.a parama)
  {
    this.a = parama;
  }
  
  public c<R> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramBoolean2))
    {
      if (this.b == null) {
        this.b = new f(this.a);
      }
      return this.b;
    }
    return e.b();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */