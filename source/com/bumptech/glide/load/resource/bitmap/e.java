package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.load.b.a.c;

public class e
  extends d
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public e(c paramc)
  {
    super(paramc);
  }
  
  protected Bitmap a(c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap.getConfig() != null) {
      localObject = paramBitmap.getConfig();
    } else {
      localObject = Bitmap.Config.ARGB_8888;
    }
    Object localObject = paramc.a(paramInt1, paramInt2, (Bitmap.Config)localObject);
    paramBitmap = q.a((Bitmap)localObject, paramBitmap, paramInt1, paramInt2);
    if ((localObject != null) && (localObject != paramBitmap) && (!paramc.a((Bitmap)localObject))) {
      ((Bitmap)localObject).recycle();
    }
    return paramBitmap;
  }
  
  public String a()
  {
    return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */