package com.totoro.school.view.calendar.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View.MeasureSpec;
import java.util.List;

public abstract class BaseMonthView
  extends BaseView
{
  MonthViewPager a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  
  public BaseMonthView(Context paramContext)
  {
    super(paramContext);
  }
  
  @SuppressLint({"WrongConstant"})
  private void k()
  {
    this.f = c.b(this.b, this.c, this.g.X());
    int i = c.a(this.b, this.c, this.g.X());
    int j = c.a(this.b, this.c);
    this.u = c.a(this.b, this.c, this.g.ae(), this.g.X());
    if (this.u.contains(this.g.ae())) {
      this.B = this.u.indexOf(this.g.ae());
    } else {
      this.B = this.u.indexOf(this.g.o);
    }
    if ((this.B > 0) && (this.g.d != null) && (this.g.d.a(this.g.o))) {
      this.B = -1;
    }
    if (this.g.T() == 0) {
      this.d = 6;
    } else {
      this.d = ((i + j + this.f) / 7);
    }
    h();
    invalidate();
  }
  
  protected final int a(b paramb)
  {
    return this.u.indexOf(paramb);
  }
  
  final void a()
  {
    this.d = c.a(this.b, this.c, this.g.X(), this.g.T());
    this.e = c.a(this.b, this.c, this.v, this.g.X(), this.g.T());
    invalidate();
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    k();
    this.e = c.a(paramInt1, paramInt2, this.v, this.g.X(), this.g.T());
  }
  
  final void b()
  {
    k();
    this.e = c.a(this.b, this.c, this.v, this.g.X(), this.g.T());
  }
  
  protected void b(int paramInt1, int paramInt2) {}
  
  void c()
  {
    super.c();
    this.e = c.a(this.b, this.c, this.v, this.g.X(), this.g.T());
  }
  
  protected void d() {}
  
  protected void e() {}
  
  protected b getIndex()
  {
    if (this.w != 0)
    {
      if (this.v == 0) {
        return null;
      }
      int j = (int)(this.y - this.g.af()) / this.w;
      int i = j;
      if (j >= 7) {
        i = 6;
      }
      i = (int)this.z / this.v * 7 + i;
      if ((i >= 0) && (i < this.u.size())) {
        return (b)this.u.get(i);
      }
      return null;
    }
    return null;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.d != 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.e, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  final void setSelectedCalendar(b paramb)
  {
    this.B = this.u.indexOf(paramb);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\BaseMonthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */