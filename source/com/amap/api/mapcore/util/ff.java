package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public class ff
  extends View
{
  private String a = "";
  private int b = 0;
  private IAMapDelegate c;
  private Paint d;
  private Paint e;
  private Rect f;
  private IPoint g;
  private float h = 0.0F;
  private final int[] i = { 10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5 };
  
  public ff(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    super(paramContext);
    this.c = paramIAMapDelegate;
    this.d = new Paint();
    this.f = new Rect();
    this.d.setAntiAlias(true);
    this.d.setColor(-16777216);
    this.d.setStrokeWidth(lk.a * 2.0F);
    this.d.setStyle(Paint.Style.STROKE);
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setColor(-16777216);
    this.e.setTextSize(lk.a * 20.0F);
    this.h = dr.a(paramContext, 1.0F);
    this.g = new IPoint();
  }
  
  public void a()
  {
    this.d = null;
    this.e = null;
    this.f = null;
    this.a = null;
    this.g = null;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(0);
      b();
      return;
    }
    a("");
    a(0);
    setVisibility(8);
  }
  
  public void b()
  {
    if (this.c == null) {
      return;
    }
    try
    {
      float f1 = this.c.getPreciseLevel(1);
      this.c.getGeoCenter(1, this.g);
      if (this.g == null) {
        return;
      }
      DPoint localDPoint = VirtualEarthProjection.pixelsToLatLong(this.g.x, this.g.y, 20);
      float f2 = this.c.getMapZoomScale();
      double d1 = (float)(Math.cos(localDPoint.y * 3.141592653589793D / 180.0D) * 2.0D * 3.141592653589793D * 6378137.0D / (Math.pow(2.0D, f1) * 256.0D));
      Object localObject = this.i;
      int j = (int)f1;
      int k = localObject[j];
      double d2 = k;
      double d3 = f2;
      Double.isNaN(d1);
      Double.isNaN(d3);
      Double.isNaN(d2);
      k = (int)(d2 / (d1 * d3));
      localObject = dx.a(this.i[j]);
      a(k);
      a((String)localObject);
      localDPoint.recycle();
      invalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "AMapDelegateImpGLSurfaceView", "changeScaleState");
      localThrowable.printStackTrace();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.a != null) && (!"".equals(this.a)))
    {
      if (this.b == 0) {
        return;
      }
      Point localPoint = this.c.getWaterMarkerPositon();
      if (localPoint == null) {
        return;
      }
      this.e.getTextBounds(this.a, 0, this.a.length(), this.f);
      int j = localPoint.x;
      int k = localPoint.y - this.f.height() + 5;
      paramCanvas.drawText(this.a, (this.b - this.f.width()) / 2 + j, k, this.e);
      int m = this.f.height();
      float f1 = j;
      float f2 = k + (m - 5);
      paramCanvas.drawLine(f1, f2 - this.h * 2.0F, f1, f2 + lk.a, this.d);
      paramCanvas.drawLine(f1, f2, this.b + j, f2, this.d);
      paramCanvas.drawLine(this.b + j, f2 - this.h * 2.0F, j + this.b, f2 + lk.a, this.d);
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */