package com.totoro.school.zxing.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;

public final class c
{
  static final int a;
  private static final String b = "c";
  private static c c;
  private final Context d;
  private final b e;
  private Camera f;
  private Rect g;
  private Rect h;
  private Rect i;
  private boolean j;
  private boolean k;
  private final boolean l;
  private final f m;
  private final a n;
  private int o;
  
  static
  {
    try
    {
      i1 = Integer.parseInt(Build.VERSION.SDK);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i1;
      for (;;) {}
    }
    i1 = 10000;
    a = i1;
  }
  
  private c(Context paramContext)
  {
    boolean bool = false;
    this.o = 0;
    this.d = paramContext;
    this.e = new b(paramContext);
    if (Integer.parseInt(Build.VERSION.SDK) > 3) {
      bool = true;
    }
    this.l = bool;
    this.m = new f(this.e, this.l);
    this.n = new a();
  }
  
  public static c a()
  {
    return c;
  }
  
  public static void a(Context paramContext)
  {
    if (c == null) {
      c = new c(paramContext);
    }
  }
  
  public Rect a(int paramInt)
  {
    if ((this.h == null) || (this.o != paramInt))
    {
      this.o = paramInt;
      if (this.f == null) {
        return null;
      }
      Object localObject1 = this.e.b();
      if (localObject1 == null) {
        return null;
      }
      Object localObject2 = this.d.getResources().getDisplayMetrics();
      double d1 = 0.65D;
      if (paramInt == 1) {
        d1 = 0.8D;
      }
      double d2 = ((DisplayMetrics)localObject2).widthPixels;
      Double.isNaN(d2);
      int i2 = (int)(d2 * d1);
      d1 = i2;
      Double.isNaN(d1);
      int i3 = (int)(d1 * 1.0D);
      int i4 = (((Point)localObject1).x - i2) / 2;
      int i1 = (((Point)localObject1).y - i3) / 2;
      if (paramInt == 1) {
        i1 = 200;
      }
      this.h = new Rect(i4, i1, i2 + i4, i3 + i1);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Calculated framing rect: ");
      ((StringBuilder)localObject2).append(this.h);
      Log.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    return this.h;
  }
  
  public e a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Rect localRect = f();
    int i1 = this.e.c();
    String str = this.e.d();
    switch (i1)
    {
    default: 
      if ("yuv420p".equals(str)) {
        return new e(paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height());
      }
      break;
    case 16: 
    case 17: 
      return new e(paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height());
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Unsupported picture format: ");
    paramArrayOfByte.append(i1);
    paramArrayOfByte.append('/');
    paramArrayOfByte.append(str);
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public void a(Handler paramHandler, int paramInt)
  {
    if ((this.f != null) && (this.k))
    {
      this.m.a(paramHandler, paramInt);
      if (this.l)
      {
        this.f.setOneShotPreviewCallback(this.m);
        return;
      }
      this.f.setPreviewCallback(this.m);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
    throws IOException
  {
    if (this.f == null)
    {
      this.f = Camera.open();
      if (this.f != null)
      {
        this.f.setPreviewDisplay(paramSurfaceHolder);
        if (!this.j)
        {
          this.j = true;
          this.e.a(this.f);
        }
        this.e.b(this.f);
        d.a();
        return;
      }
      throw new IOException();
    }
  }
  
  public void b()
  {
    if (this.f != null)
    {
      d.b();
      this.f.release();
      this.f = null;
    }
  }
  
  public void b(Handler paramHandler, int paramInt)
  {
    if ((this.f != null) && (this.k))
    {
      this.n.a(paramHandler, paramInt);
      this.f.autoFocus(this.n);
    }
  }
  
  public void c()
  {
    if ((this.f != null) && (!this.k))
    {
      this.f.startPreview();
      this.k = true;
    }
  }
  
  public void d()
  {
    if ((this.f != null) && (this.k))
    {
      if (!this.l) {
        this.f.setPreviewCallback(null);
      }
      this.f.stopPreview();
      this.m.a(null, 0);
      this.n.a(null, 0);
      this.k = false;
    }
  }
  
  public Rect e()
  {
    if (this.g == null)
    {
      if (this.f == null) {
        return null;
      }
      Object localObject1 = this.e.b();
      if (localObject1 == null) {
        return null;
      }
      Object localObject2 = this.d.getResources().getDisplayMetrics();
      double d1 = ((DisplayMetrics)localObject2).widthPixels;
      Double.isNaN(d1);
      int i2 = (int)(d1 * 0.65D);
      d1 = i2;
      Double.isNaN(d1);
      int i1 = (int)(d1 * 1.0D);
      i2 = (((Point)localObject1).x - i2) / 2;
      i1 = (((Point)localObject1).y - i1) / 2;
      this.g = new Rect(0, 0, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Calculated framing rect: ");
      ((StringBuilder)localObject2).append(this.g);
      Log.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    return this.g;
  }
  
  public Rect f()
  {
    if (this.i == null)
    {
      Rect localRect = new Rect(e());
      Point localPoint1 = this.e.a();
      Point localPoint2 = this.e.b();
      localRect.left = (localRect.left * localPoint1.y / localPoint2.x);
      localRect.right = (localRect.right * localPoint1.y / localPoint2.x);
      localRect.top = (localRect.top * localPoint1.x / localPoint2.y);
      localRect.bottom = (localRect.bottom * localPoint1.x / localPoint2.y);
      this.i = localRect;
    }
    return this.i;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */