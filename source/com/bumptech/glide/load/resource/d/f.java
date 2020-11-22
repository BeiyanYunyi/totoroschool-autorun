package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.a.c;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.c.e;

public class f
  implements g<a>
{
  private final g<Bitmap> a;
  private final g<com.bumptech.glide.load.resource.c.b> b;
  
  public f(c paramc, g<Bitmap> paramg)
  {
    this(paramg, new e(paramg, paramc));
  }
  
  f(g<Bitmap> paramg, g<com.bumptech.glide.load.resource.c.b> paramg1)
  {
    this.a = paramg;
    this.b = paramg1;
  }
  
  public k<a> a(k<a> paramk, int paramInt1, int paramInt2)
  {
    k localk1 = ((a)paramk.b()).b();
    k localk2 = ((a)paramk.b()).c();
    if ((localk1 != null) && (this.a != null))
    {
      localk2 = this.a.a(localk1, paramInt1, paramInt2);
      if (!localk1.equals(localk2)) {
        return new b(new a(localk2, ((a)paramk.b()).c()));
      }
    }
    else if ((localk2 != null) && (this.b != null))
    {
      localk1 = this.b.a(localk2, paramInt1, paramInt2);
      if (!localk2.equals(localk1)) {
        return new b(new a(((a)paramk.b()).b(), localk1));
      }
    }
    return paramk;
  }
  
  public String a()
  {
    return this.a.a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */