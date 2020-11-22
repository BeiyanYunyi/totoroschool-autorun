package com.totoro.school.recyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.b.a.c;
import com.bumptech.glide.load.resource.bitmap.d;

public class a
  extends d
{
  private static float a;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext);
    a = Resources.getSystem().getDisplayMetrics().density * paramInt;
  }
  
  private static Bitmap a(c paramc, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = paramc.a(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramc = (c)localObject;
    if (localObject == null) {
      paramc = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }
    localObject = new Canvas(paramc);
    Paint localPaint = new Paint();
    localPaint.setShader(new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    localPaint.setAntiAlias(true);
    ((Canvas)localObject).drawRoundRect(new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight()), a, a, localPaint);
    return paramc;
  }
  
  protected Bitmap a(c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return a(paramc, paramBitmap);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(Math.round(a));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\recyclerView\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */