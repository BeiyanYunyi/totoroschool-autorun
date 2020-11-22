package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.b.a.c;

public final class q
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
    case 8: 
      return 270;
    case 5: 
    case 6: 
      return 90;
    }
    return 180;
  }
  
  private static Bitmap.Config a(Bitmap paramBitmap)
  {
    if (paramBitmap.getConfig() != null) {
      return paramBitmap.getConfig();
    }
    return Bitmap.Config.ARGB_8888;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2)
  {
    if (paramBitmap2 == null) {
      return null;
    }
    if ((paramBitmap2.getWidth() == paramInt1) && (paramBitmap2.getHeight() == paramInt2)) {
      return paramBitmap2;
    }
    Matrix localMatrix = new Matrix();
    int i = paramBitmap2.getWidth();
    int j = paramBitmap2.getHeight();
    float f3 = 0.0F;
    float f1;
    float f2;
    if (i * paramInt2 > j * paramInt1)
    {
      f1 = paramInt2 / paramBitmap2.getHeight();
      f2 = (paramInt1 - paramBitmap2.getWidth() * f1) * 0.5F;
    }
    else
    {
      f1 = paramInt1 / paramBitmap2.getWidth();
      f3 = (paramInt2 - paramBitmap2.getHeight() * f1) * 0.5F;
      f2 = 0.0F;
    }
    localMatrix.setScale(f1, f1);
    localMatrix.postTranslate((int)(f2 + 0.5F), (int)(f3 + 0.5F));
    if (paramBitmap1 == null) {
      paramBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, a(paramBitmap2));
    }
    a(paramBitmap2, paramBitmap1);
    new Canvas(paramBitmap1).drawBitmap(paramBitmap2, localMatrix, new Paint(6));
    return paramBitmap1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, c paramc, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    a(paramInt, localMatrix);
    if (localMatrix.isIdentity()) {
      return paramBitmap;
    }
    RectF localRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    localMatrix.mapRect(localRectF);
    paramInt = Math.round(localRectF.width());
    int i = Math.round(localRectF.height());
    Bitmap.Config localConfig = a(paramBitmap);
    Bitmap localBitmap = paramc.a(paramInt, i, localConfig);
    paramc = localBitmap;
    if (localBitmap == null) {
      paramc = Bitmap.createBitmap(paramInt, i, localConfig);
    }
    localMatrix.postTranslate(-localRectF.left, -localRectF.top);
    new Canvas(paramc).drawBitmap(paramBitmap, localMatrix, new Paint(6));
    return paramc;
  }
  
  public static Bitmap a(Bitmap paramBitmap, c paramc, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "requested target size matches input, returning input");
      }
      return paramBitmap;
    }
    float f = Math.min(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight());
    int i = (int)(paramBitmap.getWidth() * f);
    int j = (int)(paramBitmap.getHeight() * f);
    if ((paramBitmap.getWidth() == i) && (paramBitmap.getHeight() == j))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "adjusted target size matches input, returning input");
      }
      return paramBitmap;
    }
    Object localObject2 = a(paramBitmap);
    Object localObject1 = paramc.a(i, j, (Bitmap.Config)localObject2);
    paramc = (c)localObject1;
    if (localObject1 == null) {
      paramc = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject2);
    }
    a(paramBitmap, paramc);
    if (Log.isLoggable("TransformationUtils", 2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("request: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("x");
      ((StringBuilder)localObject1).append(paramInt2);
      Log.v("TransformationUtils", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("toFit:   ");
      ((StringBuilder)localObject1).append(paramBitmap.getWidth());
      ((StringBuilder)localObject1).append("x");
      ((StringBuilder)localObject1).append(paramBitmap.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("toReuse: ");
      ((StringBuilder)localObject1).append(paramc.getWidth());
      ((StringBuilder)localObject1).append("x");
      ((StringBuilder)localObject1).append(paramc.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("minPct:   ");
      ((StringBuilder)localObject1).append(f);
      Log.v("TransformationUtils", ((StringBuilder)localObject1).toString());
    }
    localObject1 = new Canvas(paramc);
    localObject2 = new Matrix();
    ((Matrix)localObject2).setScale(f, f);
    ((Canvas)localObject1).drawBitmap(paramBitmap, (Matrix)localObject2, new Paint(6));
    return paramc;
  }
  
  static void a(int paramInt, Matrix paramMatrix)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8: 
      paramMatrix.setRotate(-90.0F);
      return;
    case 7: 
      paramMatrix.setRotate(-90.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 6: 
      paramMatrix.setRotate(90.0F);
      return;
    case 5: 
      paramMatrix.setRotate(90.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 4: 
      paramMatrix.setRotate(180.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      return;
    case 3: 
      paramMatrix.setRotate(180.0F);
      return;
    }
    paramMatrix.setScale(-1.0F, 1.0F);
  }
  
  @TargetApi(12)
  public static void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((Build.VERSION.SDK_INT >= 12) && (paramBitmap2 != null)) {
      paramBitmap2.setHasAlpha(paramBitmap1.hasAlpha());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */