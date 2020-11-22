package com.bumptech.glide.load.resource.c;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.g;

public class e
  implements g<b>
{
  private final g<Bitmap> a;
  private final com.bumptech.glide.load.b.a.c b;
  
  public e(g<Bitmap> paramg, com.bumptech.glide.load.b.a.c paramc)
  {
    this.a = paramg;
    this.b = paramc;
  }
  
  public k<b> a(k<b> paramk, int paramInt1, int paramInt2)
  {
    b localb = (b)paramk.b();
    Bitmap localBitmap = ((b)paramk.b()).b();
    Object localObject = new com.bumptech.glide.load.resource.bitmap.c(localBitmap, this.b);
    localObject = (Bitmap)this.a.a((k)localObject, paramInt1, paramInt2).b();
    if (!localObject.equals(localBitmap)) {
      return new d(new b(localb, (Bitmap)localObject, this.a));
    }
    return paramk;
  }
  
  public String a()
  {
    return this.a.a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */