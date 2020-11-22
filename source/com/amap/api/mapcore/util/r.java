package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class r
{
  private final Context a;
  private final a b;
  private boolean c;
  private MotionEvent d;
  private MotionEvent e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private long q;
  private final float r;
  private float s;
  private float t;
  private boolean u;
  private boolean v;
  private int w;
  private int x;
  private boolean y;
  
  public r(Context paramContext, a parama)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.a = paramContext;
    this.b = parama;
    this.r = localViewConfiguration.getScaledEdgeSlop();
  }
  
  private static float a(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramInt < 0) {
      return Float.MIN_VALUE;
    }
    if (paramInt == 0) {
      return paramMotionEvent.getRawX();
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getX();
    return paramMotionEvent.getX(paramInt) + (f1 - f2);
  }
  
  private int a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = paramMotionEvent.findPointerIndex(paramInt1);
    paramInt1 = 0;
    while (paramInt1 < i1)
    {
      if ((paramInt1 != paramInt2) && (paramInt1 != i2))
      {
        float f1 = this.r;
        float f2 = this.s;
        float f3 = this.t;
        float f4 = a(paramMotionEvent, paramInt1);
        float f5 = b(paramMotionEvent, paramInt1);
        if ((f4 >= f1) && (f5 >= f1) && (f4 <= f2) && (f5 <= f3)) {
          return paramInt1;
        }
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  private static float b(MotionEvent paramMotionEvent, int paramInt)
  {
    if (paramInt < 0) {
      return Float.MIN_VALUE;
    }
    if (paramInt == 0) {
      return paramMotionEvent.getRawY();
    }
    float f1 = paramMotionEvent.getRawY();
    float f2 = paramMotionEvent.getY();
    return paramMotionEvent.getY(paramInt) + (f1 - f2);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (this.e != null) {
      this.e.recycle();
    }
    this.e = MotionEvent.obtain(paramMotionEvent);
    this.l = -1.0F;
    this.m = -1.0F;
    this.n = -1.0F;
    MotionEvent localMotionEvent = this.d;
    int i1 = localMotionEvent.findPointerIndex(this.w);
    int i2 = localMotionEvent.findPointerIndex(this.x);
    int i3 = paramMotionEvent.findPointerIndex(this.w);
    int i4 = paramMotionEvent.findPointerIndex(this.x);
    if ((i1 >= 0) && (i2 >= 0) && (i3 >= 0) && (i4 >= 0))
    {
      float f1 = localMotionEvent.getX(i1);
      float f2 = localMotionEvent.getY(i1);
      float f3 = localMotionEvent.getX(i2);
      float f4 = localMotionEvent.getY(i2);
      float f5 = paramMotionEvent.getX(i3);
      float f6 = paramMotionEvent.getY(i3);
      float f8 = paramMotionEvent.getX(i4);
      float f7 = paramMotionEvent.getY(i4);
      f8 -= f5;
      f7 -= f6;
      this.h = (f3 - f1);
      this.i = (f4 - f2);
      this.j = f8;
      this.k = f7;
      this.f = (f5 + f8 * 0.5F);
      this.g = (f6 + f7 * 0.5F);
      this.q = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
      this.o = (paramMotionEvent.getPressure(i3) + paramMotionEvent.getPressure(i4));
      this.p = (localMotionEvent.getPressure(i1) + localMotionEvent.getPressure(i2));
      return;
    }
    this.v = true;
    if (this.c) {
      this.b.c(this);
    }
  }
  
  private void l()
  {
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.recycle();
      this.e = null;
    }
    this.u = false;
    this.c = false;
    this.w = -1;
    this.x = -1;
    this.v = false;
  }
  
  public MotionEvent a()
  {
    return this.e;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      l();
    }
    boolean bool = this.v;
    int i4 = 0;
    if (bool) {
      return false;
    }
    bool = this.c;
    int i3 = -1;
    int i2;
    if (!bool)
    {
      int i5;
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      switch (i1)
      {
      case 3: 
      case 4: 
      default: 
        return true;
      case 6: 
        if (!this.u) {
          break;
        }
        i2 = paramMotionEvent.getPointerCount();
        if (Build.VERSION.SDK_INT >= 8) {
          i1 = paramMotionEvent.getActionIndex();
        } else {
          i1 = 0;
        }
        i3 = paramMotionEvent.getPointerId(i1);
        if (i2 > 2)
        {
          if (i3 == this.w)
          {
            i1 = a(paramMotionEvent, this.x, i1);
            if (i1 < 0) {
              break;
            }
            this.w = paramMotionEvent.getPointerId(i1);
            return true;
          }
          if (i3 != this.x) {
            break;
          }
          i1 = a(paramMotionEvent, this.w, i1);
          if (i1 < 0) {
            break;
          }
          this.x = paramMotionEvent.getPointerId(i1);
          return true;
        }
        if (i3 == this.w) {
          i1 = this.x;
        } else {
          i1 = this.w;
        }
        i1 = paramMotionEvent.findPointerIndex(i1);
        if (i1 < 0)
        {
          this.v = true;
          if (this.c) {
            this.b.c(this);
          }
          return false;
        }
        this.w = paramMotionEvent.getPointerId(i1);
        this.y = true;
        this.x = -1;
        this.f = paramMotionEvent.getX(i1);
        this.g = paramMotionEvent.getY(i1);
        return true;
      case 5: 
        DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
        this.s = (localDisplayMetrics.widthPixels - this.r);
        this.t = (localDisplayMetrics.heightPixels - this.r);
        if (this.d != null) {
          this.d.recycle();
        }
        this.d = MotionEvent.obtain(paramMotionEvent);
        this.q = 0L;
        if (Build.VERSION.SDK_INT >= 8)
        {
          i4 = paramMotionEvent.getActionIndex();
          i5 = paramMotionEvent.findPointerIndex(this.w);
          this.x = paramMotionEvent.getPointerId(i4);
          if (i5 >= 0)
          {
            i2 = i4;
            i1 = i5;
            if (i5 != i4) {}
          }
          else
          {
            if (i5 != i4) {
              i3 = this.x;
            }
            i1 = a(paramMotionEvent, i3, i5);
            this.w = paramMotionEvent.getPointerId(i1);
            i2 = i4;
          }
        }
        else if (paramMotionEvent.getPointerCount() > 0)
        {
          i2 = paramMotionEvent.findPointerIndex(1);
          i1 = paramMotionEvent.findPointerIndex(this.w);
          this.x = paramMotionEvent.getPointerId(i2);
        }
        else
        {
          i2 = 0;
          i1 = 0;
        }
        this.y = false;
        b(paramMotionEvent);
        f1 = this.r;
        f2 = this.s;
        f3 = this.t;
        f4 = a(paramMotionEvent, i1);
        f5 = b(paramMotionEvent, i1);
        f6 = a(paramMotionEvent, i2);
        f7 = b(paramMotionEvent, i2);
        if ((f4 >= f1) && (f5 >= f1) && (f4 <= f2) && (f5 <= f3)) {
          i3 = 0;
        } else {
          i3 = 1;
        }
        if ((f6 >= f1) && (f7 >= f1) && (f6 <= f2) && (f7 <= f3)) {
          i4 = 0;
        } else {
          i4 = 1;
        }
        if ((i3 != 0) && (i4 != 0))
        {
          this.f = -1.0F;
          this.g = -1.0F;
          this.u = true;
          return true;
        }
        if (i3 != 0)
        {
          this.f = paramMotionEvent.getX(i2);
          this.g = paramMotionEvent.getY(i2);
          this.u = true;
          return true;
        }
        if (i4 != 0)
        {
          this.f = paramMotionEvent.getX(i1);
          this.g = paramMotionEvent.getY(i1);
          this.u = true;
          return true;
        }
        this.u = false;
        this.c = this.b.b(this);
        return true;
      case 2: 
        if (!this.u) {
          break;
        }
        f1 = this.r;
        f2 = this.s;
        f3 = this.t;
        i4 = paramMotionEvent.findPointerIndex(this.w);
        i5 = paramMotionEvent.findPointerIndex(this.x);
        f4 = a(paramMotionEvent, i4);
        f5 = b(paramMotionEvent, i4);
        f6 = a(paramMotionEvent, i5);
        f7 = b(paramMotionEvent, i5);
        if ((f4 >= f1) && (f5 >= f1) && (f4 <= f2) && (f5 <= f3)) {
          i2 = 0;
        } else {
          i2 = 1;
        }
        if ((f6 >= f1) && (f7 >= f1) && (f6 <= f2) && (f7 <= f3)) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if (i2 != 0)
        {
          i3 = a(paramMotionEvent, this.x, i4);
          if (i3 >= 0)
          {
            this.w = paramMotionEvent.getPointerId(i3);
            a(paramMotionEvent, i3);
            b(paramMotionEvent, i3);
            i4 = 0;
            i2 = i3;
            i3 = i4;
            break label1012;
          }
        }
        i3 = i2;
        i2 = i4;
        if (i1 != 0)
        {
          i4 = a(paramMotionEvent, this.w, i5);
          if (i4 >= 0)
          {
            this.x = paramMotionEvent.getPointerId(i4);
            a(paramMotionEvent, i4);
            b(paramMotionEvent, i4);
            i1 = 0;
            break label1069;
          }
        }
        i4 = i5;
        if ((i3 != 0) && (i1 != 0))
        {
          this.f = -1.0F;
          this.g = -1.0F;
          return true;
        }
        if (i3 != 0)
        {
          this.f = paramMotionEvent.getX(i4);
          this.g = paramMotionEvent.getY(i4);
          return true;
        }
        if (i1 != 0)
        {
          this.f = paramMotionEvent.getX(i2);
          this.g = paramMotionEvent.getY(i2);
          return true;
        }
        this.u = false;
        this.c = this.b.b(this);
        return true;
      case 1: 
        l();
        return true;
      case 0: 
        label1012:
        label1069:
        this.w = paramMotionEvent.getPointerId(0);
        this.y = true;
        return true;
      }
    }
    else
    {
      switch (i1)
      {
      case 4: 
      default: 
        return true;
      case 6: 
        i1 = paramMotionEvent.getPointerCount();
        if (Build.VERSION.SDK_INT >= 8) {
          i2 = paramMotionEvent.getActionIndex();
        } else {
          i2 = 0;
        }
        i3 = paramMotionEvent.getPointerId(i2);
        if (i1 > 2)
        {
          if (i3 == this.w)
          {
            i1 = a(paramMotionEvent, this.x, i2);
            if (i1 >= 0)
            {
              this.b.c(this);
              this.w = paramMotionEvent.getPointerId(i1);
              this.y = true;
              this.d = MotionEvent.obtain(paramMotionEvent);
              b(paramMotionEvent);
              this.c = this.b.b(this);
              i1 = i4;
              break label1453;
            }
          }
          else
          {
            i1 = i4;
            if (i3 != this.x) {
              break label1453;
            }
            i1 = a(paramMotionEvent, this.w, i2);
            if (i1 >= 0)
            {
              this.b.c(this);
              this.x = paramMotionEvent.getPointerId(i1);
              this.y = false;
              this.d = MotionEvent.obtain(paramMotionEvent);
              b(paramMotionEvent);
              this.c = this.b.b(this);
              i1 = i4;
              break label1453;
            }
          }
          i1 = 1;
          this.d.recycle();
          this.d = MotionEvent.obtain(paramMotionEvent);
          b(paramMotionEvent);
        }
        else
        {
          i1 = 1;
        }
        if (i1 != 0)
        {
          b(paramMotionEvent);
          if (i3 == this.w) {
            i1 = this.x;
          } else {
            i1 = this.w;
          }
          i2 = paramMotionEvent.findPointerIndex(i1);
          this.f = paramMotionEvent.getX(i2);
          this.g = paramMotionEvent.getY(i2);
          this.b.c(this);
          l();
          this.w = i1;
          this.y = true;
          return true;
        }
        break;
      case 5: 
        this.b.c(this);
        i1 = this.w;
        i2 = this.x;
        l();
        this.d = MotionEvent.obtain(paramMotionEvent);
        if (!this.y) {
          i1 = i2;
        }
        this.w = i1;
        if (Build.VERSION.SDK_INT >= 8) {
          this.x = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        } else {
          this.x = paramMotionEvent.getPointerId(1);
        }
        this.y = false;
        i1 = paramMotionEvent.findPointerIndex(this.w);
        if ((i1 < 0) || (this.w == this.x))
        {
          if (this.w != this.x) {
            i3 = this.x;
          }
          this.w = paramMotionEvent.getPointerId(a(paramMotionEvent, i3, i1));
        }
        b(paramMotionEvent);
        this.c = this.b.b(this);
        return true;
      case 3: 
        this.b.c(this);
        l();
        return true;
      case 2: 
        b(paramMotionEvent);
        if ((this.o / this.p > 0.67F) && (this.b.a(this)))
        {
          this.d.recycle();
          this.d = MotionEvent.obtain(paramMotionEvent);
          return true;
        }
        break;
      case 1: 
        label1453:
        l();
      }
    }
    return true;
  }
  
  public float b()
  {
    return this.f;
  }
  
  public float c()
  {
    return this.g;
  }
  
  public float d()
  {
    if (this.l == -1.0F)
    {
      float f1 = this.j;
      float f2 = this.k;
      this.l = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    }
    return this.l;
  }
  
  public float e()
  {
    return this.j;
  }
  
  public float f()
  {
    return this.k;
  }
  
  public float g()
  {
    if (this.m == -1.0F)
    {
      float f1 = this.h;
      float f2 = this.i;
      this.m = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    }
    return this.m;
  }
  
  public float h()
  {
    return this.h;
  }
  
  public float i()
  {
    return this.i;
  }
  
  public float j()
  {
    if (this.n == -1.0F) {
      this.n = (d() / g());
    }
    return this.n;
  }
  
  public long k()
  {
    return this.q;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(r paramr);
    
    public abstract boolean b(r paramr);
    
    public abstract void c(r paramr);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */