package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class q
  extends o
{
  private static final PointF a = new PointF();
  private final a b;
  private PointF c;
  private PointF d;
  private PointF l = new PointF();
  private PointF m = new PointF();
  
  public q(Context paramContext, a parama)
  {
    super(paramContext);
    this.b = parama;
  }
  
  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    default: 
      
    case 2: 
      a(paramMotionEvent);
      if (this.i / this.j > 0.67F)
      {
        if (paramMotionEvent.getPointerCount() > 1) {
          return;
        }
        if (this.b.a(this))
        {
          this.g.recycle();
          this.g = MotionEvent.obtain(paramMotionEvent);
          return;
        }
      }
      break;
    case 1: 
    case 3: 
      this.b.c(this);
      a();
    }
  }
  
  protected void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 5) {
          return;
        }
        if (this.g != null) {
          this.g.recycle();
        }
        this.g = MotionEvent.obtain(paramMotionEvent);
        a(paramMotionEvent);
        return;
      }
      this.f = this.b.b(this);
      return;
    }
    a();
    this.g = MotionEvent.obtain(paramMotionEvent);
    this.k = 0L;
    a(paramMotionEvent);
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    Object localObject = this.g;
    this.c = b(paramMotionEvent);
    this.d = b((MotionEvent)localObject);
    int i;
    if (this.g.getPointerCount() != paramMotionEvent.getPointerCount()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = a;
    } else {
      localObject = new PointF(this.c.x - this.d.x, this.c.y - this.d.y);
    }
    this.m = ((PointF)localObject);
    if (i != 0)
    {
      this.g.recycle();
      this.g = MotionEvent.obtain(paramMotionEvent);
    }
    paramMotionEvent = this.l;
    paramMotionEvent.x += this.m.x;
    paramMotionEvent = this.l;
    paramMotionEvent.y += this.m.y;
  }
  
  public PointF d()
  {
    return this.m;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(q paramq);
    
    public abstract boolean b(q paramq);
    
    public abstract void c(q paramq);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */