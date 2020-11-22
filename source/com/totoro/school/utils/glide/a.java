package com.totoro.school.utils.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.load.b.a.c;
import com.bumptech.glide.load.resource.bitmap.d;

public class a
  extends d
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  private static Bitmap a(c paramc, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - i) / 2, (paramBitmap.getHeight() - i) / 2, i, i);
    paramBitmap = paramc.a(i, i, Bitmap.Config.ARGB_8888);
    paramc = paramBitmap;
    if (paramBitmap == null) {
      paramc = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    }
    paramBitmap = new Canvas(paramc);
    Paint localPaint = new Paint();
    localPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    localPaint.setAntiAlias(true);
    float f = i / 2.0F;
    paramBitmap.drawCircle(f, f, f, localPaint);
    return paramc;
  }
  
  protected Bitmap a(c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return a(paramc, paramBitmap);
  }
  
  public String a()
  {
    return getClass().getName();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\glide\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */