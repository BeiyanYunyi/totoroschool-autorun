package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.e;
import com.bumptech.glide.h.h;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.g;

public abstract class d
  implements g<Bitmap>
{
  private com.bumptech.glide.load.b.a.c a;
  
  public d(Context paramContext)
  {
    this(e.a(paramContext).a());
  }
  
  public d(com.bumptech.glide.load.b.a.c paramc)
  {
    this.a = paramc;
  }
  
  protected abstract Bitmap a(com.bumptech.glide.load.b.a.c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public final k<Bitmap> a(k<Bitmap> paramk, int paramInt1, int paramInt2)
  {
    if (h.a(paramInt1, paramInt2))
    {
      Bitmap localBitmap1 = (Bitmap)paramk.b();
      int i = paramInt1;
      if (paramInt1 == Integer.MIN_VALUE) {
        i = localBitmap1.getWidth();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == Integer.MIN_VALUE) {
        paramInt1 = localBitmap1.getHeight();
      }
      Bitmap localBitmap2 = a(this.a, localBitmap1, i, paramInt1);
      if (localBitmap1.equals(localBitmap2)) {
        return paramk;
      }
      return c.a(localBitmap2, this.a);
    }
    paramk = new StringBuilder();
    paramk.append("Cannot apply transformation on width: ");
    paramk.append(paramInt1);
    paramk.append(" or height: ");
    paramk.append(paramInt2);
    paramk.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
    throw new IllegalArgumentException(paramk.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */