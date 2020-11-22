package com.bumptech.glide.load.resource.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.j;

public class b
  implements c<Bitmap, j>
{
  private final Resources a;
  private final com.bumptech.glide.load.b.a.c b;
  
  public b(Resources paramResources, com.bumptech.glide.load.b.a.c paramc)
  {
    this.a = paramResources;
    this.b = paramc;
  }
  
  public com.bumptech.glide.load.b.k<j> a(com.bumptech.glide.load.b.k<Bitmap> paramk)
  {
    return new com.bumptech.glide.load.resource.bitmap.k(new j(this.a, (Bitmap)paramk.b()), this.b);
  }
  
  public String a()
  {
    return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */