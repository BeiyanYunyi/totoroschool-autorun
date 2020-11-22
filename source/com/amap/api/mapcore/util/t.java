package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class t
  extends m
{
  private static final PointF n = new PointF();
  private final a l;
  private boolean m;
  private PointF o;
  private PointF p;
  private PointF q = new PointF();
  private PointF r = new PointF();
  
  public t(Context paramContext, a parama)
  {
    super(paramContext);
    this.l = parama;
  }
  
  protected void a()
  {
    super.a();
    this.m = false;
    this.q.x = 0.0F;
    this.r.x = 0.0F;
    this.q.y = 0.0F;
    this.r.y = 0.0F;
  }
  
  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 3)
    {
      if (paramInt != 6) {
        return;
      }
      a(paramMotionEvent);
      if (!this.m) {
        this.l.b(this);
      }
      a();
      return;
    }
    a();
  }
  
  protected void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 5) {
      return;
    }
    a();
    this.g = MotionEvent.obtain(paramMotionEvent);
    this.k = 0L;
    a(paramMotionEvent);
    this.m = c(paramMotionEvent, paramInt2, paramInt3);
    if (!this.m) {
      this.f = this.l.a(this);
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
      paramMotionEvent = n;
    } else {
      paramMotionEvent = new PointF(this.o.x - this.p.x, this.o.y - this.p.y);
    }
    this.r = paramMotionEvent;
    paramMotionEvent = this.q;
    paramMotionEvent.x += this.r.x;
    paramMotionEvent = this.q;
    paramMotionEvent.y += this.r.y;
  }
  
  public float d()
  {
    return this.q.x;
  }
  
  public float e()
  {
    return this.q.y;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(t paramt);
    
    public abstract void b(t paramt);
  }
  
  public static class b
    implements t.a
  {
    public boolean a(t paramt)
    {
      return true;
    }
    
    public void b(t paramt) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */