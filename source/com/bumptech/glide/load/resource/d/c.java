package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.resource.bitmap.n;
import java.io.IOException;
import java.io.InputStream;

public class c
  implements e<g, a>
{
  private static final b a = new b();
  private static final a b = new a();
  private final e<g, Bitmap> c;
  private final e<InputStream, com.bumptech.glide.load.resource.c.b> d;
  private final com.bumptech.glide.load.b.a.c e;
  private final b f;
  private final a g;
  private String h;
  
  public c(e<g, Bitmap> parame, e<InputStream, com.bumptech.glide.load.resource.c.b> parame1, com.bumptech.glide.load.b.a.c paramc)
  {
    this(parame, parame1, paramc, a, b);
  }
  
  c(e<g, Bitmap> parame, e<InputStream, com.bumptech.glide.load.resource.c.b> parame1, com.bumptech.glide.load.b.a.c paramc, b paramb, a parama)
  {
    this.c = parame;
    this.d = parame1;
    this.e = paramc;
    this.f = paramb;
    this.g = parama;
  }
  
  private a a(g paramg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramg.a() != null) {
      return b(paramg, paramInt1, paramInt2, paramArrayOfByte);
    }
    return b(paramg, paramInt1, paramInt2);
  }
  
  private a a(InputStream paramInputStream, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInputStream = this.d.a(paramInputStream, paramInt1, paramInt2);
    if (paramInputStream != null)
    {
      com.bumptech.glide.load.resource.c.b localb = (com.bumptech.glide.load.resource.c.b)paramInputStream.b();
      if (localb.e() > 1) {
        return new a(null, paramInputStream);
      }
      return new a(new com.bumptech.glide.load.resource.bitmap.c(localb.b(), this.e), null);
    }
    return null;
  }
  
  private a b(g paramg, int paramInt1, int paramInt2)
    throws IOException
  {
    k localk = this.c.a(paramg, paramInt1, paramInt2);
    paramg = null;
    if (localk != null) {
      paramg = new a(localk, null);
    }
    return paramg;
  }
  
  private a b(g paramg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws IOException
  {
    InputStream localInputStream = this.g.a(paramg.a(), paramArrayOfByte);
    localInputStream.mark(2048);
    paramArrayOfByte = this.f.a(localInputStream);
    localInputStream.reset();
    if (paramArrayOfByte == ImageHeaderParser.ImageType.GIF) {
      paramArrayOfByte = a(localInputStream, paramInt1, paramInt2);
    } else {
      paramArrayOfByte = null;
    }
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = b(new g(localInputStream, paramg.b()), paramInt1, paramInt2);
    }
    return (a)localObject;
  }
  
  public k<a> a(g paramg, int paramInt1, int paramInt2)
    throws IOException
  {
    com.bumptech.glide.h.a locala = com.bumptech.glide.h.a.a();
    byte[] arrayOfByte = locala.b();
    try
    {
      paramg = a(paramg, paramInt1, paramInt2, arrayOfByte);
      locala.a(arrayOfByte);
      if (paramg != null) {
        return new b(paramg);
      }
      return null;
    }
    finally
    {
      locala.a(arrayOfByte);
    }
  }
  
  public String a()
  {
    if (this.h == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.a());
      localStringBuilder.append(this.c.a());
      this.h = localStringBuilder.toString();
    }
    return this.h;
  }
  
  static class a
  {
    public InputStream a(InputStream paramInputStream, byte[] paramArrayOfByte)
    {
      return new n(paramInputStream, paramArrayOfByte);
    }
  }
  
  static class b
  {
    public ImageHeaderParser.ImageType a(InputStream paramInputStream)
      throws IOException
    {
      return new ImageHeaderParser(paramInputStream).b();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */