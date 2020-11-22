package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.MotionEvent;

public abstract class o
{
  protected final Context e;
  protected boolean f;
  protected MotionEvent g;
  protected MotionEvent h;
  protected float i;
  protected float j;
  protected long k;
  
  public o(Context paramContext)
  {
    this.e = paramContext;
  }
  
  public static PointF b(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getPointerCount();
    float f2 = 0.0F;
    int m = 0;
    float f1 = 0.0F;
    while (m < n)
    {
      f2 += paramMotionEvent.getX(m);
      f1 += paramMotionEvent.getY(m);
      m += 1;
    }
    float f3 = n;
    return new PointF(f2 / f3, f1 / f3);
  }
  
  protected void a()
  {
    if (this.g != null)
    {
      this.g.recycle();
      this.g = null;
    }
    if (this.h != null)
    {
      this.h.recycle();
      this.h = null;
    }
    this.f = false;
  }
  
  protected abstract void a(int paramInt, MotionEvent paramMotionEvent);
  
  protected abstract void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2, int paramInt3);
  
  protected void a(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = this.g;
    if (this.h != null)
    {
      this.h.recycle();
      this.h = null;
    }
    this.h = MotionEvent.obtain(paramMotionEvent);
    this.k = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.i = paramMotionEvent.getPressure(paramMotionEvent.getActionIndex());
      this.j = localMotionEvent.getPressure(localMotionEvent.getActionIndex());
      return;
    }
    this.i = paramMotionEvent.getPressure(0);
    this.j = localMotionEvent.getPressure(0);
  }
  
  public long b()
  {
    return this.k;
  }
  
  public MotionEvent c()
  {
    return this.h;
  }
  
  public boolean d(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (!this.f) {
      a(m, paramMotionEvent, paramInt1, paramInt2);
    } else {
      a(m, paramMotionEvent);
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */