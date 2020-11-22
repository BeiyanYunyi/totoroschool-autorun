package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.List;

public abstract class WeekView
  extends BaseWeekView
{
  public WeekView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected abstract void a(Canvas paramCanvas, b paramb, int paramInt);
  
  protected abstract void a(Canvas paramCanvas, b paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  protected abstract boolean a(Canvas paramCanvas, b paramb, int paramInt, boolean paramBoolean);
  
  public void onClick(View paramView)
  {
    if (!this.A) {
      return;
    }
    paramView = getIndex();
    if (paramView == null) {
      return;
    }
    if (b(paramView))
    {
      this.g.d.a(paramView, true);
      return;
    }
    if (!c(paramView))
    {
      if (this.g.e != null) {
        this.g.e.a(paramView);
      }
      return;
    }
    this.B = this.u.indexOf(paramView);
    if (this.g.i != null) {
      this.g.i.b(paramView, true);
    }
    if (this.t != null)
    {
      int i = c.a(paramView, this.g.X());
      this.t.b(i);
    }
    if (this.g.e != null) {
      this.g.e.a(paramView, true);
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.u.size() == 0) {
      return;
    }
    this.w = ((getWidth() - this.g.af() * 2) / 7);
    d();
    int i = 0;
    while (i < this.u.size())
    {
      int k = this.w * i + this.g.af();
      a(k);
      b localb = (b)this.u.get(i);
      boolean bool1;
      if (i == this.B) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool3 = localb.hasScheme();
      if (bool3)
      {
        boolean bool2;
        if (bool1) {
          bool2 = a(paramCanvas, localb, k, true);
        } else {
          bool2 = false;
        }
        if ((bool2) || (!bool1))
        {
          Paint localPaint = this.n;
          int j;
          if (localb.getSchemeColor() != 0) {
            j = localb.getSchemeColor();
          } else {
            j = this.g.m();
          }
          localPaint.setColor(j);
          a(paramCanvas, localb, k);
        }
      }
      else if (bool1)
      {
        a(paramCanvas, localb, k, false);
      }
      a(paramCanvas, localb, k, bool3, bool1);
      i += 1;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.g.h == null) {
      return false;
    }
    if (!this.A) {
      return false;
    }
    paramView = getIndex();
    if (paramView == null) {
      return false;
    }
    if (b(paramView))
    {
      this.g.d.a(paramView, true);
      return true;
    }
    if (!c(paramView))
    {
      if (this.g.h != null) {
        this.g.h.a(paramView);
      }
      return true;
    }
    if (this.g.ag())
    {
      if (this.g.h != null) {
        this.g.h.b(paramView);
      }
      return true;
    }
    this.B = this.u.indexOf(paramView);
    this.g.p = this.g.o;
    if (this.g.i != null) {
      this.g.i.b(paramView, true);
    }
    if (this.t != null)
    {
      int i = c.a(paramView, this.g.X());
      this.t.b(i);
    }
    if (this.g.e != null) {
      this.g.e.a(paramView, true);
    }
    if (this.g.h != null) {
      this.g.h.b(paramView);
    }
    invalidate();
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\WeekView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */