package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class p
  extends m
{
  private static final PointF l = new PointF();
  private final a m;
  private boolean n;
  private PointF o;
  private PointF p;
  private PointF q = new PointF();
  private PointF r = new PointF();
  
  public p(Context paramContext, a parama)
  {
    super(paramContext);
    this.m = parama;
  }
  
  protected void a()
  {
    super.a();
    this.n = false;
  }
  
  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 6)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 3: 
        if (!this.n) {
          this.m.c(this);
        }
        a();
        return;
      }
      a(paramMotionEvent);
      if ((this.i / this.j > 0.67F) && (this.m.a(this)))
      {
        this.g.recycle();
        this.g = MotionEvent.obtain(paramMotionEvent);
      }
    }
    else
    {
      a(paramMotionEvent);
      if (!this.n) {
        this.m.c(this);
      }
      a();
    }
  }
  
  protected void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 2)
    {
      switch (paramInt1)
      {
      default: 
        return;
      case 6: 
        boolean bool = this.n;
        return;
      }
      a();
      this.g = MotionEvent.obtain(paramMotionEvent);
      this.k = 0L;
      a(paramMotionEvent);
      this.n = c(paramMotionEvent, paramInt2, paramInt3);
      if (!this.n) {
        this.f = this.m.b(this);
      }
    }
    else
    {
      if (!this.n) {
        return;
      }
      this.n = c(paramMotionEvent, paramInt2, paramInt3);
      if (!this.n) {
        this.f = this.m.b(this);
      }
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    MotionEvent localMotionEvent = this.g;
    this.o = b(paramMotionEvent);
    this.p = b(localMotionEvent);
    int i;
    if (this.g.getPointerCount() != paramMotionEvent.getPointerCount()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramMotionEvent = l;
    } else {
      paramMotionEvent = new PointF(this.o.x - this.p.x, this.o.y - this.p.y);
    }
    this.r = paramMotionEvent;
    paramMotionEvent = this.q;
    paramMotionEvent.x += this.r.x;
    paramMotionEvent = this.q;
    paramMotionEvent.y += this.r.y;
  }
  
  public PointF d()
  {
    return this.r;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(p paramp);
    
    public abstract boolean b(p paramp);
    
    public abstract void c(p paramp);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */