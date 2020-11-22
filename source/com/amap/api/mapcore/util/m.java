package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public abstract class m
  extends o
{
  protected float a;
  protected float b;
  protected float c;
  protected float d;
  private final float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q = 0.0F;
  private float r = 0.0F;
  private float s = 0.0F;
  private float t = 0.0F;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.l = ViewConfiguration.get(paramContext).getScaledEdgeSlop();
  }
  
  protected static float a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramInt2;
    float f2 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getRawX();
    if (paramInt1 < paramMotionEvent.getPointerCount()) {
      return paramMotionEvent.getX(paramInt1) + (f1 + f2 - f3);
    }
    return 0.0F;
  }
  
  protected static float b(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramInt2;
    float f2 = paramMotionEvent.getY();
    float f3 = paramMotionEvent.getRawY();
    if (paramInt1 < paramMotionEvent.getPointerCount()) {
      return paramMotionEvent.getY(paramInt1) + (f1 + f2 - f3);
    }
    return 0.0F;
  }
  
  public PointF a(int paramInt)
  {
    if (paramInt == 0) {
      return new PointF(this.q, this.r);
    }
    return new PointF(this.s, this.t);
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    MotionEvent localMotionEvent = this.g;
    int i = this.g.getPointerCount();
    int j = paramMotionEvent.getPointerCount();
    if (j == 2)
    {
      if (j != i) {
        return;
      }
      this.o = -1.0F;
      this.p = -1.0F;
      float f1 = localMotionEvent.getX(0);
      float f2 = localMotionEvent.getY(0);
      float f3 = localMotionEvent.getX(1);
      float f4 = localMotionEvent.getY(1);
      this.a = (f3 - f1);
      this.b = (f4 - f2);
      float f5 = paramMotionEvent.getX(0);
      float f6 = paramMotionEvent.getY(0);
      float f7 = paramMotionEvent.getX(1);
      float f8 = paramMotionEvent.getY(1);
      this.c = (f7 - f5);
      this.d = (f8 - f6);
      this.q = (f5 - f1);
      this.r = (f6 - f2);
      this.s = (f7 - f3);
      this.t = (f8 - f4);
      return;
    }
  }
  
  protected boolean c(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = this.e.getResources().getDisplayMetrics();
    this.m = (localDisplayMetrics.widthPixels - this.l);
    this.n = (localDisplayMetrics.heightPixels - this.l);
    float f1 = this.l;
    float f2 = this.m;
    float f3 = this.n;
    float f4 = paramMotionEvent.getRawX();
    float f5 = paramMotionEvent.getRawY();
    float f6 = a(paramMotionEvent, 1, paramInt1);
    float f7 = b(paramMotionEvent, 1, paramInt2);
    if ((f4 >= f1) && (f5 >= f1) && (f4 <= f2) && (f5 <= f3)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if ((f6 >= f1) && (f7 >= f1) && (f6 <= f2) && (f7 <= f3)) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      return true;
    }
    if (paramInt1 != 0) {
      return true;
    }
    return paramInt2 != 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */