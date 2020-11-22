package com.bumptech.glide.load.resource.c;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.e;

class h
  implements e<a, Bitmap>
{
  private final com.bumptech.glide.load.b.a.c a;
  
  public h(com.bumptech.glide.load.b.a.c paramc)
  {
    this.a = paramc;
  }
  
  public k<Bitmap> a(a parama, int paramInt1, int paramInt2)
  {
    return com.bumptech.glide.load.resource.bitmap.c.a(parama.f(), this.a);
  }
  
  public String a()
  {
    return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */