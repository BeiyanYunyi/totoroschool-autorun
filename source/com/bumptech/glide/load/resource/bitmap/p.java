package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.e;
import java.io.InputStream;

public class p
  implements e<InputStream, Bitmap>
{
  private final f a;
  private com.bumptech.glide.load.b.a.c b;
  private a c;
  private String d;
  
  public p(com.bumptech.glide.load.b.a.c paramc, a parama)
  {
    this(f.a, paramc, parama);
  }
  
  public p(f paramf, com.bumptech.glide.load.b.a.c paramc, a parama)
  {
    this.a = paramf;
    this.b = paramc;
    this.c = parama;
  }
  
  public k<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    return c.a(this.a.a(paramInputStream, this.b, paramInt1, paramInt2, this.c), this.b);
  }
  
  public String a()
  {
    if (this.d == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap");
      localStringBuilder.append(this.a.a());
      localStringBuilder.append(this.c.name());
      this.d = localStringBuilder.toString();
    }
    return this.d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */