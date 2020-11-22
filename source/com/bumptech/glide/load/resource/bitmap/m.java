package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.h;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;

public class m
  implements com.bumptech.glide.e.b<g, Bitmap>
{
  private final l a;
  private final e<File, Bitmap> b;
  private final f<Bitmap> c;
  private final h d;
  
  public m(com.bumptech.glide.e.b<InputStream, Bitmap> paramb, com.bumptech.glide.e.b<ParcelFileDescriptor, Bitmap> paramb1)
  {
    this.c = paramb.d();
    this.d = new h(paramb.c(), paramb1.c());
    this.b = paramb.a();
    this.a = new l(paramb.b(), paramb1.b());
  }
  
  public e<File, Bitmap> a()
  {
    return this.b;
  }
  
  public e<g, Bitmap> b()
  {
    return this.a;
  }
  
  public com.bumptech.glide.load.b<g> c()
  {
    return this.d;
  }
  
  public f<Bitmap> d()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */