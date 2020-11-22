package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.List;

public abstract class MonthView
  extends BaseMonthView
{
  public MonthView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt2 * this.w + this.g.af();
    int i = paramInt1 * this.v;
    b(paramInt2, i);
    paramInt1 = this.B;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt3 == paramInt1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = paramb.hasScheme();
    if (bool3)
    {
      if (bool1) {
        bool2 = a(paramCanvas, paramb, paramInt2, i, true);
      }
      if ((bool2) || (!bool1))
      {
        Paint localPaint = this.n;
        if (paramb.getSchemeColor() != 0) {
          paramInt1 = paramb.getSchemeColor();
        } else {
          paramInt1 = this.g.m();
        }
        localPaint.setColor(paramInt1);
        a(paramCanvas, paramb, paramInt2, i);
      }
    }
    else if (bool1)
    {
      a(paramCanvas, paramb, paramInt2, i, false);
    }
    a(paramCanvas, paramb, paramInt2, i, bool3, bool1);
  }
  
  protected abstract void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2);
  
  protected abstract void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  protected abstract boolean a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public void onClick(View paramView)
  {
    if (!this.A) {
      return;
    }
    paramView = getIndex();
    if (paramView == null) {
      return;
    }
    if ((this.g.T() == 1) && (!paramView.isCurrentMonth())) {
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
    if ((!paramView.isCurrentMonth()) && (this.a != null))
    {
      int i = this.a.getCurrentItem();
      if (this.B < 7) {
        i -= 1;
      } else {
        i += 1;
      }
      this.a.setCurrentItem(i);
    }
    if (this.g.i != null) {
      this.g.i.a(paramView, true);
    }
    if (this.t != null) {
      if (paramView.isCurrentMonth()) {
        this.t.a(this.u.indexOf(paramView));
      } else {
        this.t.b(c.a(paramView, this.g.X()));
      }
    }
    if (this.g.e != null) {
      this.g.e.a(paramView, true);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d == 0) {
      return;
    }
    this.w = ((getWidth() - this.g.af() * 2) / 7);
    d();
    int m = this.d;
    int i = 0;
    int j = 0;
    while (j < this.d)
    {
      int k = 0;
      while (k < 7)
      {
        b localb = (b)this.u.get(i);
        if (this.g.T() == 1)
        {
          if (i > this.u.size() - this.f) {
            return;
          }
          if (!localb.isCurrentMonth())
          {
            i += 1;
            break label157;
          }
        }
        else if ((this.g.T() == 2) && (i >= m * 7))
        {
          return;
        }
        a(paramCanvas, localb, j, k, i);
        i += 1;
        label157:
        k += 1;
      }
      j += 1;
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
    if ((this.g.T() == 1) && (!paramView.isCurrentMonth())) {
      return false;
    }
    if (b(paramView))
    {
      this.g.d.a(paramView, true);
      return false;
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
    if ((!paramView.isCurrentMonth()) && (this.a != null))
    {
      int i = this.a.getCurrentItem();
      if (this.B < 7) {
        i -= 1;
      } else {
        i += 1;
      }
      this.a.setCurrentItem(i);
    }
    if (this.g.i != null) {
      this.g.i.a(paramView, true);
    }
    if (this.t != null) {
      if (paramView.isCurrentMonth()) {
        this.t.a(this.u.indexOf(paramView));
      } else {
        this.t.b(c.a(paramView, this.g.X()));
      }
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\MonthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */