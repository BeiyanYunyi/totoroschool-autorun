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
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.List;

public final class WeekViewPager
  extends ViewPager
{
  CalendarLayout a;
  private boolean b;
  private int c;
  private d d;
  private boolean e = false;
  
  public WeekViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WeekViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void h()
  {
    this.c = c.a(this.d.y(), this.d.D(), this.d.ai(), this.d.z(), this.d.E(), this.d.aj(), this.d.X());
    setAdapter(new a(null));
    addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        if (WeekViewPager.this.getVisibility() != 0)
        {
          WeekViewPager.a(WeekViewPager.this, false);
          return;
        }
        if (WeekViewPager.a(WeekViewPager.this))
        {
          WeekViewPager.a(WeekViewPager.this, false);
          return;
        }
        BaseWeekView localBaseWeekView = (BaseWeekView)WeekViewPager.this.findViewWithTag(Integer.valueOf(paramAnonymousInt));
        if (localBaseWeekView != null)
        {
          b localb;
          if (WeekViewPager.b(WeekViewPager.this).aa() != 0) {
            localb = WeekViewPager.b(WeekViewPager.this).p;
          } else {
            localb = WeekViewPager.b(WeekViewPager.this).o;
          }
          localBaseWeekView.a(localb, WeekViewPager.a(WeekViewPager.this) ^ true);
          if (WeekViewPager.b(WeekViewPager.this).l != null) {
            WeekViewPager.b(WeekViewPager.this).l.a(WeekViewPager.this.getCurrentWeekCalendars());
          }
        }
        WeekViewPager.a(WeekViewPager.this, false);
      }
    });
  }
  
  private void i()
  {
    if (getAdapter() == null) {
      return;
    }
    getAdapter().notifyDataSetChanged();
  }
  
  void a()
  {
    this.c = c.a(this.d.y(), this.d.D(), this.d.ai(), this.d.z(), this.d.E(), this.d.aj(), this.d.X());
    i();
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = true;
    b localb = new b();
    localb.setYear(paramInt1);
    localb.setMonth(paramInt2);
    localb.setDay(paramInt3);
    localb.setCurrentDay(localb.equals(this.d.ae()));
    e.a(localb);
    this.d.p = localb;
    this.d.o = localb;
    this.d.al();
    a(localb, paramBoolean1);
    if (this.d.i != null) {
      this.d.i.b(localb, false);
    }
    if ((this.d.e != null) && (paramBoolean2)) {
      this.d.e.a(localb, false);
    }
    paramInt1 = c.a(localb, this.d.X());
    this.a.b(paramInt1);
  }
  
  void a(b paramb, boolean paramBoolean)
  {
    int i = c.a(paramb, this.d.y(), this.d.D(), this.d.ai(), this.d.X());
    boolean bool = true;
    i -= 1;
    if (getCurrentItem() == i) {
      bool = false;
    }
    this.e = bool;
    setCurrentItem(i, paramBoolean);
    BaseWeekView localBaseWeekView = (BaseWeekView)findViewWithTag(Integer.valueOf(i));
    if (localBaseWeekView != null)
    {
      localBaseWeekView.setSelectedCalendar(paramb);
      localBaseWeekView.invalidate();
    }
  }
  
  void b()
  {
    this.b = true;
    i();
    this.b = false;
  }
  
  void c()
  {
    if (this.d.aa() == 0) {
      return;
    }
    int i = 0;
    while (i < getChildCount())
    {
      ((BaseWeekView)getChildAt(i)).k();
      i += 1;
    }
  }
  
  void d()
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((BaseWeekView)getChildAt(i)).i();
      i += 1;
    }
  }
  
  void e()
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((BaseWeekView)getChildAt(i)).a();
      i += 1;
    }
  }
  
  void f()
  {
    if (getAdapter() == null) {
      return;
    }
    int i = getAdapter().getCount();
    this.c = c.a(this.d.y(), this.d.D(), this.d.ai(), this.d.z(), this.d.E(), this.d.aj(), this.d.X());
    if (i != this.c)
    {
      this.b = true;
      getAdapter().notifyDataSetChanged();
    }
    i = 0;
    while (i < getChildCount())
    {
      ((BaseWeekView)getChildAt(i)).b();
      i += 1;
    }
    this.b = false;
    a(this.d.o, false);
  }
  
  final void g()
  {
    int i = 0;
    while (i < getChildCount())
    {
      BaseWeekView localBaseWeekView = (BaseWeekView)getChildAt(i);
      localBaseWeekView.c();
      localBaseWeekView.requestLayout();
      i += 1;
    }
  }
  
  List<b> getCurrentWeekCalendars()
  {
    List localList = c.b(this.d.p, this.d);
    this.d.a(localList);
    return localList;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.d.V()) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.d.C(), 1073741824));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.d.V()) && (super.onTouchEvent(paramMotionEvent));
  }
  
  void setup(d paramd)
  {
    this.d = paramd;
    h();
  }
  
  private class a
    extends PagerAdapter
  {
    private a() {}
    
    public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
    {
      paramObject = (BaseWeekView)paramObject;
      ((BaseWeekView)paramObject).e();
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return WeekViewPager.c(WeekViewPager.this);
    }
    
    public int getItemPosition(@NonNull Object paramObject)
    {
      if (WeekViewPager.d(WeekViewPager.this)) {
        return -2;
      }
      return super.getItemPosition(paramObject);
    }
    
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
      b localb = c.b(WeekViewPager.b(WeekViewPager.this).y(), WeekViewPager.b(WeekViewPager.this).D(), WeekViewPager.b(WeekViewPager.this).ai(), paramInt + 1, WeekViewPager.b(WeekViewPager.this).X());
      try
      {
        BaseWeekView localBaseWeekView = (BaseWeekView)WeekViewPager.b(WeekViewPager.this).t().getConstructor(new Class[] { Context.class }).newInstance(new Object[] { WeekViewPager.this.getContext() });
        localBaseWeekView.t = WeekViewPager.this.a;
        localBaseWeekView.setup(WeekViewPager.b(WeekViewPager.this));
        localBaseWeekView.setup(localb);
        localBaseWeekView.setTag(Integer.valueOf(paramInt));
        localBaseWeekView.setSelectedCalendar(WeekViewPager.b(WeekViewPager.this).o);
        paramViewGroup.addView(localBaseWeekView);
        return localBaseWeekView;
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      return new DefaultWeekView(WeekViewPager.this.getContext());
    }
    
    public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
    {
      return paramView.equals(paramObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\WeekViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */