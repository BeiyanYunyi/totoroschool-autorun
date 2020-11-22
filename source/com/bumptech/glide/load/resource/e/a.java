package com.bumptech.glide.load.resource.e;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.resource.a.b;
import com.bumptech.glide.load.resource.bitmap.j;

public class a
  implements c<com.bumptech.glide.load.resource.d.a, b>
{
  private final c<Bitmap, j> a;
  
  public a(c<Bitmap, j> paramc)
  {
    this.a = paramc;
  }
  
  public k<b> a(k<com.bumptech.glide.load.resource.d.a> paramk)
  {
    paramk = (com.bumptech.glide.load.resource.d.a)paramk.b();
    k localk = paramk.b();
    if (localk != null) {
      return this.a.a(localk);
    }
    return paramk.c();
  }
  
  public String a()
  {
    return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */