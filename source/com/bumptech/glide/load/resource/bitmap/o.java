package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;

public class o
  implements com.bumptech.glide.e.b<InputStream, Bitmap>
{
  private final p a;
  private final b b;
  private final com.bumptech.glide.load.c.o c = new com.bumptech.glide.load.c.o();
  private final com.bumptech.glide.load.resource.b.c<Bitmap> d;
  
  public o(com.bumptech.glide.load.b.a.c paramc, a parama)
  {
    this.a = new p(paramc, parama);
    this.b = new b();
    this.d = new com.bumptech.glide.load.resource.b.c(this.a);
  }
  
  public e<File, Bitmap> a()
  {
    return this.d;
  }
  
  public e<InputStream, Bitmap> b()
  {
    return this.a;
  }
  
  public com.bumptech.glide.load.b<InputStream> c()
  {
    return this.c;
  }
  
  public f<Bitmap> d()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */