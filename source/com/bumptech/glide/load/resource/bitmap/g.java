package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.File;

public class g
  implements com.bumptech.glide.e.b<ParcelFileDescriptor, Bitmap>
{
  private final e<File, Bitmap> a;
  private final h b;
  private final b c;
  private final com.bumptech.glide.load.b<ParcelFileDescriptor> d;
  
  public g(com.bumptech.glide.load.b.a.c paramc, com.bumptech.glide.load.a parama)
  {
    this.a = new com.bumptech.glide.load.resource.b.c(new p(paramc, parama));
    this.b = new h(paramc, parama);
    this.c = new b();
    this.d = com.bumptech.glide.load.resource.a.b();
  }
  
  public e<File, Bitmap> a()
  {
    return this.a;
  }
  
  public e<ParcelFileDescriptor, Bitmap> b()
  {
    return this.b;
  }
  
  public com.bumptech.glide.load.b<ParcelFileDescriptor> c()
  {
    return this.d;
  }
  
  public f<Bitmap> d()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */