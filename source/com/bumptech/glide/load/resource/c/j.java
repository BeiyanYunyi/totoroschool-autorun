package com.bumptech.glide.load.resource.c;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.OutputStream;

public class j
  implements f<b>
{
  private static final a a = new a();
  private final a.a b;
  private final com.bumptech.glide.load.b.a.c c;
  private final a d;
  
  public j(com.bumptech.glide.load.b.a.c paramc)
  {
    this(paramc, a);
  }
  
  j(com.bumptech.glide.load.b.a.c paramc, a parama)
  {
    this.c = paramc;
    this.b = new a(paramc);
    this.d = parama;
  }
  
  private com.bumptech.glide.b.a a(byte[] paramArrayOfByte)
  {
    Object localObject = this.d.a();
    ((com.bumptech.glide.b.d)localObject).a(paramArrayOfByte);
    localObject = ((com.bumptech.glide.b.d)localObject).b();
    com.bumptech.glide.b.a locala = this.d.a(this.b);
    locala.a((com.bumptech.glide.b.c)localObject, paramArrayOfByte);
    locala.a();
    return locala;
  }
  
  private k<Bitmap> a(Bitmap paramBitmap, g<Bitmap> paramg, b paramb)
  {
    paramBitmap = this.d.a(paramBitmap, this.c);
    paramg = paramg.a(paramBitmap, paramb.getIntrinsicWidth(), paramb.getIntrinsicHeight());
    if (!paramBitmap.equals(paramg)) {
      paramBitmap.d();
    }
    return paramg;
  }
  
  private boolean a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      if (Log.isLoggable("GifEncoder", 3)) {
        Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public String a()
  {
    return "";
  }
  
  public boolean a(k<b> paramk, OutputStream paramOutputStream)
  {
    long l = com.bumptech.glide.h.d.a();
    paramk = (b)paramk.b();
    g localg = paramk.c();
    if ((localg instanceof com.bumptech.glide.load.resource.d)) {
      return a(paramk.d(), paramOutputStream);
    }
    com.bumptech.glide.b.a locala = a(paramk.d());
    com.bumptech.glide.c.a locala1 = this.d.b();
    if (!locala1.a(paramOutputStream)) {
      return false;
    }
    int i = 0;
    while (i < locala.c())
    {
      paramOutputStream = a(locala.f(), localg, paramk);
      try
      {
        bool = locala1.a((Bitmap)paramOutputStream.b());
        if (!bool) {
          return false;
        }
        locala1.a(locala.a(locala.d()));
        locala.a();
        paramOutputStream.d();
        i += 1;
      }
      finally
      {
        paramOutputStream.d();
      }
    }
    boolean bool = locala1.a();
    if (Log.isLoggable("GifEncoder", 2))
    {
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("Encoded gif with ");
      paramOutputStream.append(locala.c());
      paramOutputStream.append(" frames and ");
      paramOutputStream.append(paramk.d().length);
      paramOutputStream.append(" bytes in ");
      paramOutputStream.append(com.bumptech.glide.h.d.a(l));
      paramOutputStream.append(" ms");
      Log.v("GifEncoder", paramOutputStream.toString());
    }
    return bool;
  }
  
  static class a
  {
    public com.bumptech.glide.b.a a(a.a parama)
    {
      return new com.bumptech.glide.b.a(parama);
    }
    
    public com.bumptech.glide.b.d a()
    {
      return new com.bumptech.glide.b.d();
    }
    
    public k<Bitmap> a(Bitmap paramBitmap, com.bumptech.glide.load.b.a.c paramc)
    {
      return new com.bumptech.glide.load.resource.bitmap.c(paramBitmap, paramc);
    }
    
    public com.bumptech.glide.c.a b()
    {
      return new com.bumptech.glide.c.a();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */