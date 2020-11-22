package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;

public class g
  implements com.bumptech.glide.e.b<com.bumptech.glide.load.c.g, a>
{
  private final com.bumptech.glide.load.e<File, a> a;
  private final com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, a> b;
  private final f<a> c;
  private final com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> d;
  
  public g(com.bumptech.glide.e.b<com.bumptech.glide.load.c.g, Bitmap> paramb, com.bumptech.glide.e.b<InputStream, com.bumptech.glide.load.resource.c.b> paramb1, com.bumptech.glide.load.b.a.c paramc)
  {
    paramc = new c(paramb.b(), paramb1.b(), paramc);
    this.a = new com.bumptech.glide.load.resource.b.c(new e(paramc));
    this.b = paramc;
    this.c = new d(paramb.d(), paramb1.d());
    this.d = paramb.c();
  }
  
  public com.bumptech.glide.load.e<File, a> a()
  {
    return this.a;
  }
  
  public com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, a> b()
  {
    return this.b;
  }
  
  public com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> c()
  {
    return this.d;
  }
  
  public f<a> d()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */