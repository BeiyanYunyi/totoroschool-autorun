package com.totoro.school.view.calendar.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.reflect.Constructor;
import java.util.List;

public final class MonthViewPager
  extends ViewPager
{
  CalendarLayout a;
  WeekViewPager b;
  WeekBar c;
  private boolean d;
  private int e;
  private d f;
  private int g;
  private int h;
  private int i;
  private boolean j = false;
  
  public MonthViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MonthViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.f.T() == 0)
    {
      this.i = (this.f.C() * 6);
      getLayoutParams().height = this.i;
      return;
    }
    if (this.a != null)
    {
      if (getVisibility() != 0)
      {
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        localLayoutParams.height = c.a(paramInt1, paramInt2, this.f.C(), this.f.X(), this.f.T());
        setLayoutParams(localLayoutParams);
      }
      this.a.a();
    }
    this.i = c.a(paramInt1, paramInt2, this.f.C(), this.f.X(), this.f.T());
    if (paramInt2 == 1)
    {
      this.h = c.a(paramInt1 - 1, 12, this.f.C(), this.f.X(), this.f.T());
      this.g = c.a(paramInt1, 2, this.f.C(), this.f.X(), this.f.T());
      return;
    }
    this.h = c.a(paramInt1, paramInt2 - 1, this.f.C(), this.f.X(), this.f.T());
    if (paramInt2 == 12)
    {
      this.g = c.a(paramInt1 + 1, 1, this.f.C(), this.f.X(), this.f.T());
      return;
    }
    this.g = c.a(paramInt1, paramInt2 + 1, this.f.C(), this.f.X(), this.f.T());
  }
  
  private void g()
  {
    this.e = ((this.f.z() - this.f.y()) * 12 - this.f.D() + 1 + this.f.E());
    setAdapter(new a(null));
    addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        if (MonthViewPager.a(MonthViewPager.this).T() == 0) {
          return;
        }
        if (paramAnonymousInt1 < MonthViewPager.this.getCurrentItem()) {
          paramAnonymousInt1 = (int)(MonthViewPager.b(MonthViewPager.this) * (1.0F - paramAnonymousFloat) + MonthViewPager.c(MonthViewPager.this) * paramAnonymousFloat);
        } else {
          paramAnonymousInt1 = (int)(MonthViewPager.c(MonthViewPager.this) * (1.0F - paramAnonymousFloat) + MonthViewPager.d(MonthViewPager.this) * paramAnonymousFloat);
        }
        ViewGroup.LayoutParams localLayoutParams = MonthViewPager.this.getLayoutParams();
        localLayoutParams.height = paramAnonymousInt1;
        MonthViewPager.this.setLayoutParams(localLayoutParams);
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        b localb = c.a(paramAnonymousInt, MonthViewPager.a(MonthViewPager.this));
        if (MonthViewPager.this.getVisibility() == 0)
        {
          if ((!MonthViewPager.a(MonthViewPager.this).a) && (MonthViewPager.a(MonthViewPager.this).p != null) && (localb.getYear() != MonthViewPager.a(MonthViewPager.this).p.getYear()) && (MonthViewPager.a(MonthViewPager.this).j != null)) {
            MonthViewPager.a(MonthViewPager.this).j.a(localb.getYear());
          }
          MonthViewPager.a(MonthViewPager.this).p = localb;
        }
        if (MonthViewPager.a(MonthViewPager.this).k != null) {
          MonthViewPager.a(MonthViewPager.this).k.a(localb.getYear(), localb.getMonth());
        }
        if (MonthViewPager.this.b.getVisibility() == 0)
        {
          MonthViewPager.a(MonthViewPager.this, localb.getYear(), localb.getMonth());
          return;
        }
        if (MonthViewPager.a(MonthViewPager.this).aa() == 0)
        {
          if (!localb.isCurrentMonth()) {
            MonthViewPager.a(MonthViewPager.this).o = localb;
          } else {
            MonthViewPager.a(MonthViewPager.this).o = c.c(localb, MonthViewPager.a(MonthViewPager.this));
          }
          MonthViewPager.a(MonthViewPager.this).p = MonthViewPager.a(MonthViewPager.this).o;
        }
        else if ((MonthViewPager.a(MonthViewPager.this).r != null) && (MonthViewPager.a(MonthViewPager.this).r.isSameMonth(MonthViewPager.a(MonthViewPager.this).p)))
        {
          MonthViewPager.a(MonthViewPager.this).p = MonthViewPager.a(MonthViewPager.this).r;
        }
        else if (localb.isSameMonth(MonthViewPager.a(MonthViewPager.this).o))
        {
          MonthViewPager.a(MonthViewPager.this).p = MonthViewPager.a(MonthViewPager.this).o;
        }
        MonthViewPager.a(MonthViewPager.this).al();
        if ((!MonthViewPager.e(MonthViewPager.this)) && (MonthViewPager.a(MonthViewPager.this).aa() == 0))
        {
          MonthViewPager.this.c.a(MonthViewPager.a(MonthViewPager.this).o, MonthViewPager.a(MonthViewPager.this).X(), false);
          if (MonthViewPager.a(MonthViewPager.this).e != null) {
            MonthViewPager.a(MonthViewPager.this).e.a(MonthViewPager.a(MonthViewPager.this).o, false);
          }
        }
        BaseMonthView localBaseMonthView = (BaseMonthView)MonthViewPager.this.findViewWithTag(Integer.valueOf(paramAnonymousInt));
        if (localBaseMonthView != null)
        {
          paramAnonymousInt = localBaseMonthView.a(MonthViewPager.a(MonthViewPager.this).p);
          if (MonthViewPager.a(MonthViewPager.this).aa() == 0) {
            localBaseMonthView.B = paramAnonymousInt;
          }
          if ((paramAnonymousInt >= 0) && (MonthViewPager.this.a != null)) {
            MonthViewPager.this.a.a(paramAnonymousInt);
          }
          localBaseMonthView.invalidate();
        }
        MonthViewPager.this.b.a(MonthViewPager.a(MonthViewPager.this).p, false);
        MonthViewPager.a(MonthViewPager.this, localb.getYear(), localb.getMonth());
        MonthViewPager.a(MonthViewPager.this, false);
      }
    });
  }
  
  private void h()
  {
    if (getAdapter() == null) {
      return;
    }
    getAdapter().notifyDataSetChanged();
  }
  
  void a()
  {
    this.d = true;
    h();
    this.d = false;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.j = true;
    b localb = new b();
    localb.setYear(paramInt1);
    localb.setMonth(paramInt2);
    localb.setDay(paramInt3);
    localb.setCurrentDay(localb.equals(this.f.ae()));
    e.a(localb);
    this.f.p = localb;
    this.f.o = localb;
    this.f.al();
    paramInt1 = (localb.getYear() - this.f.y()) * 12 + localb.getMonth() - this.f.D();
    if (getCurrentItem() == paramInt1) {
      this.j = false;
    }
    setCurrentItem(paramInt1, paramBoolean1);
    BaseMonthView localBaseMonthView = (BaseMonthView)findViewWithTag(Integer.valueOf(paramInt1));
    if (localBaseMonthView != null)
    {
      localBaseMonthView.setSelectedCalendar(this.f.p);
      localBaseMonthView.invalidate();
      if (this.a != null) {
        this.a.a(localBaseMonthView.a(this.f.p));
      }
    }
    if (this.a != null)
    {
      paramInt1 = c.a(localb, this.f.X());
      this.a.b(paramInt1);
    }
    if ((this.f.e != null) && (paramBoolean2)) {
      this.f.e.a(localb, false);
    }
    if (this.f.i != null) {
      this.f.i.a(localb, false);
    }
    b();
  }
  
  void b()
  {
    int k = 0;
    while (k < getChildCount())
    {
      BaseMonthView localBaseMonthView = (BaseMonthView)getChildAt(k);
      localBaseMonthView.setSelectedCalendar(this.f.o);
      localBaseMonthView.invalidate();
      k += 1;
    }
  }
  
  void c()
  {
    int k = 0;
    while (k < getChildCount())
    {
      ((BaseMonthView)getChildAt(k)).i();
      k += 1;
    }
  }
  
  void d()
  {
    int k = 0;
    while (k < getChildCount())
    {
      localObject = (BaseMonthView)getChildAt(k);
      ((BaseMonthView)localObject).a();
      ((BaseMonthView)localObject).requestLayout();
      k += 1;
    }
    if (this.f.T() == 0)
    {
      this.i = (this.f.C() * 6);
      this.g = this.i;
      this.h = this.i;
    }
    else
    {
      a(this.f.o.getYear(), this.f.o.getMonth());
    }
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = this.i;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.a != null) {
      this.a.a();
    }
  }
  
  void e()
  {
    int k = 0;
    while (k < getChildCount())
    {
      localObject = (BaseMonthView)getChildAt(k);
      ((BaseMonthView)localObject).b();
      ((BaseMonthView)localObject).requestLayout();
      k += 1;
    }
    a(this.f.o.getYear(), this.f.o.getMonth());
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = this.i;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.a != null)
    {
      k = c.a(this.f.o, this.f.X());
      this.a.b(k);
    }
    b();
  }
  
  final void f()
  {
    int k = 0;
    while (k < getChildCount())
    {
      localObject = (BaseMonthView)getChildAt(k);
      ((BaseMonthView)localObject).c();
      ((BaseMonthView)localObject).requestLayout();
      k += 1;
    }
    k = this.f.p.getYear();
    int m = this.f.p.getMonth();
    this.i = c.a(k, m, this.f.C(), this.f.X(), this.f.T());
    if (m == 1)
    {
      this.h = c.a(k - 1, 12, this.f.C(), this.f.X(), this.f.T());
      this.g = c.a(k, 2, this.f.C(), this.f.X(), this.f.T());
    }
    else
    {
      this.h = c.a(k, m - 1, this.f.C(), this.f.X(), this.f.T());
      if (m == 12) {
        this.g = c.a(k + 1, 1, this.f.C(), this.f.X(), this.f.T());
      } else {
        this.g = c.a(k, m + 1, this.f.C(), this.f.X(), this.f.T());
      }
    }
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = this.i;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  List<b> getCurrentMonthCalendars()
  {
    BaseMonthView localBaseMonthView = (BaseMonthView)findViewWithTag(Integer.valueOf(getCurrentItem()));
    if (localBaseMonthView == null) {
      return null;
    }
    return localBaseMonthView.u;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.f.U()) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.f.U()) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, true);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if (Math.abs(getCurrentItem() - paramInt) > 1)
    {
      super.setCurrentItem(paramInt, false);
      return;
    }
    super.setCurrentItem(paramInt, paramBoolean);
  }
  
  void setup(d paramd)
  {
    this.f = paramd;
    a(this.f.ae().getYear(), this.f.ae().getMonth());
    paramd = getLayoutParams();
    paramd.height = this.i;
    setLayoutParams(paramd);
    g();
  }
  
  private final class a
    extends PagerAdapter
  {
    private a() {}
    
    public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
    {
      paramObject = (BaseView)paramObject;
      ((BaseView)paramObject).e();
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return MonthViewPager.f(MonthViewPager.this);
    }
    
    public int getItemPosition(@NonNull Object paramObject)
    {
      if (MonthViewPager.g(MonthViewPager.this)) {
        return -2;
      }
      return super.getItemPosition(paramObject);
    }
    
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
      int i = (MonthViewPager.a(MonthViewPager.this).D() + paramInt - 1) / 12;
      int j = MonthViewPager.a(MonthViewPager.this).y();
      int k = MonthViewPager.a(MonthViewPager.this).D();
      try
      {
        BaseMonthView localBaseMonthView = (BaseMonthView)MonthViewPager.a(MonthViewPager.this).s().getConstructor(new Class[] { Context.class }).newInstance(new Object[] { MonthViewPager.this.getContext() });
        localBaseMonthView.a = MonthViewPager.this;
        localBaseMonthView.t = MonthViewPager.this.a;
        localBaseMonthView.setup(MonthViewPager.a(MonthViewPager.this));
        localBaseMonthView.setTag(Integer.valueOf(paramInt));
        localBaseMonthView.a(i + j, (k + paramInt - 1) % 12 + 1);
        localBaseMonthView.setSelectedCalendar(MonthViewPager.a(MonthViewPager.this).o);
        paramViewGroup.addView(localBaseMonthView);
        return localBaseMonthView;
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      return new DefaultMonthView(MonthViewPager.this.getContext());
    }
    
    public boolean isViewFromObject(View paramView, @NonNull Object paramObject)
    {
      return paramView.equals(paramObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\MonthViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */