package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.h.h;
import com.bumptech.glide.load.b.k;

public class c
  implements k<Bitmap>
{
  private final Bitmap a;
  private final com.bumptech.glide.load.b.a.c b;
  
  public c(Bitmap paramBitmap, com.bumptech.glide.load.b.a.c paramc)
  {
    if (paramBitmap != null)
    {
      if (paramc != null)
      {
        this.a = paramBitmap;
        this.b = paramc;
        return;
      }
      throw new NullPointerException("BitmapPool must not be null");
    }
    throw new NullPointerException("Bitmap must not be null");
  }
  
  public static c a(Bitmap paramBitmap, com.bumptech.glide.load.b.a.c paramc)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new c(paramBitmap, paramc);
  }
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public int c()
  {
    return h.a(this.a);
  }
  
  public void d()
  {
    if (!this.b.a(this.a)) {
      this.a.recycle();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */