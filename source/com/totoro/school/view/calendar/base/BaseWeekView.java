package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.view.View.MeasureSpec;
import java.util.Calendar;
import java.util.List;

public abstract class BaseWeekView
  extends BaseView
{
  public BaseWeekView(Context paramContext)
  {
    super(paramContext);
  }
  
  final int a(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    while (i < this.u.size())
    {
      boolean bool = c((b)this.u.get(i));
      if ((paramBoolean) && (bool)) {
        return i;
      }
      if ((!paramBoolean) && (!bool)) {
        return i - 1;
      }
      i += 1;
    }
    i = j;
    if (paramBoolean) {
      i = 6;
    }
    return i;
  }
  
  final void a()
  {
    invalidate();
  }
  
  protected void a(int paramInt) {}
  
  final void a(b paramb, boolean paramBoolean)
  {
    if ((this.t != null) && (this.g.i != null) && (this.u != null))
    {
      if (this.u.size() == 0) {
        return;
      }
      int i = c.c(paramb, this.g.X());
      if (this.u.contains(this.g.ae())) {
        i = c.c(this.g.ae(), this.g.X());
      }
      Object localObject2 = (b)this.u.get(i);
      Object localObject1 = localObject2;
      if (this.g.aa() != 0) {
        if (this.u.contains(this.g.o))
        {
          localObject1 = this.g.o;
        }
        else
        {
          this.B = -1;
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (!c((b)localObject1))
      {
        i = a(a((b)localObject1));
        localObject2 = (b)this.u.get(i);
      }
      ((b)localObject2).setCurrentDay(((b)localObject2).equals(this.g.ae()));
      this.g.i.b((b)localObject2, false);
      int j = c.a((b)localObject2, this.g.X());
      this.t.b(j);
      if ((this.g.e != null) && (paramBoolean) && (this.g.aa() == 0)) {
        this.g.e.a((b)localObject2, false);
      }
      this.t.a();
      if (this.g.aa() == 0) {
        this.B = i;
      }
      if ((!this.g.a) && (this.g.p != null) && (paramb.getYear() != this.g.p.getYear()) && (this.g.j != null)) {
        this.g.j.a(this.g.p.getYear());
      }
      this.g.p = ((b)localObject2);
      invalidate();
      return;
    }
  }
  
  final boolean a(b paramb)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.g.y(), this.g.D() - 1, this.g.ai());
    long l = localCalendar.getTimeInMillis();
    localCalendar.set(paramb.getYear(), paramb.getMonth() - 1, paramb.getDay());
    return localCalendar.getTimeInMillis() < l;
  }
  
  final void b()
  {
    int i = ((Integer)getTag()).intValue();
    b localb = c.b(this.g.y(), this.g.D(), this.g.ai(), i + 1, this.g.X());
    setSelectedCalendar(this.g.o);
    setup(localb);
  }
  
  protected void d() {}
  
  protected void e() {}
  
  protected b getIndex()
  {
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
  
  final void k()
  {
    if (!this.u.contains(this.g.o))
    {
      this.B = -1;
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.v, 1073741824));
  }
  
  final void setSelectedCalendar(b paramb)
  {
    if ((this.g.aa() == 1) && (!paramb.equals(this.g.o))) {
      return;
    }
    this.B = this.u.indexOf(paramb);
  }
  
  final void setup(b paramb)
  {
    this.u = c.a(paramb, this.g, this.g.X());
    h();
    invalidate();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\BaseWeekView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */