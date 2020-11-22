package com.pgyersdk.b.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class e
{
  public static Bitmap a(Activity paramActivity, View[] paramArrayOfView)
  {
    List localList;
    if (paramActivity != null)
    {
      localList = a.a(paramActivity);
      paramActivity = paramActivity.getWindow().getDecorView();
    }
    try
    {
      paramActivity = Bitmap.createBitmap(paramActivity.getWidth(), paramActivity.getHeight(), Bitmap.Config.ARGB_8888);
      a(localList, paramActivity, paramArrayOfView);
      return paramActivity;
    }
    catch (IllegalArgumentException paramActivity)
    {
      for (;;) {}
    }
    return null;
    throw new IllegalArgumentException("Parameter activity cannot be null");
  }
  
  private static ArrayList<View> a(View paramView, Canvas paramCanvas)
  {
    if (!(paramView instanceof ViewGroup))
    {
      paramCanvas = new ArrayList();
      paramCanvas.add(paramView);
      return paramCanvas;
    }
    ArrayList localArrayList1 = new ArrayList();
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int i = 0;
    while (i < localViewGroup.getChildCount())
    {
      View localView = localViewGroup.getChildAt(i);
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(paramView);
      localArrayList2.addAll(a(localView, paramCanvas));
      if ((Build.VERSION.SDK_INT >= 14) && ((localView instanceof TextureView))) {
        a((TextureView)localView, paramCanvas);
      }
      if ((localView instanceof GLSurfaceView)) {
        a((GLSurfaceView)localView, paramCanvas);
      }
      localArrayList1.addAll(localArrayList2);
      i += 1;
    }
    return localArrayList1;
  }
  
  private static void a(GLSurfaceView paramGLSurfaceView, Canvas paramCanvas)
  {
    if (paramGLSurfaceView.getWindowToken() != null)
    {
      int[] arrayOfInt = new int[2];
      paramGLSurfaceView.getLocationOnScreen(arrayOfInt);
      int m = paramGLSurfaceView.getWidth();
      int n = paramGLSurfaceView.getHeight();
      Object localObject = new int[(n + 0) * m];
      IntBuffer localIntBuffer = IntBuffer.wrap((int[])localObject);
      localIntBuffer.position(0);
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      paramGLSurfaceView.queueEvent(new d(m, n, localIntBuffer, localCountDownLatch));
      try
      {
        localCountDownLatch.await();
      }
      catch (InterruptedException paramGLSurfaceView)
      {
        paramGLSurfaceView.printStackTrace();
      }
      paramGLSurfaceView = new int[m * n];
      int j = 0;
      int i = 0;
      while (j < n)
      {
        int k = 0;
        while (k < m)
        {
          int i1 = localObject[(j * m + k)];
          paramGLSurfaceView[((n - i - 1) * m + k)] = (i1 & 0xFF00FF00 | i1 << 16 & 0xFF0000 | i1 >> 16 & 0xFF);
          k += 1;
        }
        j += 1;
        i += 1;
      }
      paramGLSurfaceView = Bitmap.createBitmap(paramGLSurfaceView, m, n, Bitmap.Config.ARGB_8888);
      localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
      paramCanvas.drawBitmap(paramGLSurfaceView, arrayOfInt[0], arrayOfInt[1], (Paint)localObject);
      paramGLSurfaceView.recycle();
    }
  }
  
  private static void a(TextureView paramTextureView, Canvas paramCanvas)
  {
    int[] arrayOfInt = new int[2];
    paramTextureView.getLocationOnScreen(arrayOfInt);
    paramTextureView = paramTextureView.getBitmap();
    if (paramTextureView != null)
    {
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
      paramCanvas.drawBitmap(paramTextureView, arrayOfInt[0], arrayOfInt[1], localPaint);
      paramTextureView.recycle();
    }
  }
  
  private static void a(b paramb, Bitmap paramBitmap, View[] paramArrayOfView)
  {
    int j = paramb.a().flags;
    int i = 0;
    if ((j & 0x2) == 2) {
      new Canvas(paramBitmap).drawARGB((int)(paramb.a().dimAmount * 255.0F), 0, 0, 0);
    }
    Canvas localCanvas = new Canvas(paramBitmap);
    localCanvas.translate(paramb.b(), paramb.c());
    paramBitmap = null;
    if (paramArrayOfView != null) {
      paramBitmap = new int[paramArrayOfView.length];
    }
    if (paramArrayOfView != null) {
      while (i < paramArrayOfView.length)
      {
        if (paramArrayOfView[i] != null)
        {
          paramBitmap[i] = paramArrayOfView[i].getVisibility();
          paramArrayOfView[i].setVisibility(4);
        }
        i += 1;
      }
    }
    paramb.d().draw(localCanvas);
    a(paramb.d(), localCanvas);
  }
  
  private static void a(List<b> paramList, Bitmap paramBitmap, View[] paramArrayOfView)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((b)paramList.next(), paramBitmap, paramArrayOfView);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */