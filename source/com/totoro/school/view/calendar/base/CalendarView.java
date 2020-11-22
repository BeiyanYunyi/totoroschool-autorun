package com.totoro.school.view.calendar.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CalendarView
  extends FrameLayout
{
  CalendarLayout a;
  private final d b;
  private MonthViewPager c;
  private WeekViewPager d;
  private View e;
  private YearViewPager f;
  private WeekBar g;
  
  public CalendarView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CalendarView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = new d(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    if (paramInt == this.c.getCurrentItem())
    {
      if ((this.b.e != null) && (this.b.aa() != 1)) {
        this.b.e.a(this.b.o, false);
      }
    }
    else {
      this.c.setCurrentItem(paramInt, false);
    }
    this.g.animate().translationY(0.0F).setInterpolator(new LinearInterpolator()).setDuration(280L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        CalendarView.d(CalendarView.this).setVisibility(0);
      }
    });
    this.c.animate().scaleX(1.0F).scaleY(1.0F).setDuration(180L).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        if (CalendarView.b(CalendarView.this).n != null) {
          CalendarView.b(CalendarView.this).n.a(true);
        }
        if (CalendarView.this.a != null)
        {
          CalendarView.this.a.h();
          if (CalendarView.this.a.c())
          {
            CalendarView.c(CalendarView.this).setVisibility(0);
          }
          else
          {
            CalendarView.a(CalendarView.this).setVisibility(0);
            CalendarView.this.a.e();
          }
        }
        else
        {
          CalendarView.c(CalendarView.this).setVisibility(0);
        }
        CalendarView.c(CalendarView.this).clearAnimation();
      }
    });
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131492923, this, true);
    Object localObject = (FrameLayout)findViewById(2131296396);
    this.d = ((WeekViewPager)findViewById(2131296726));
    this.d.setup(this.b);
    try
    {
      this.g = ((WeekBar)this.b.u().getConstructor(new Class[] { Context.class }).newInstance(new Object[] { getContext() }));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ((FrameLayout)localObject).addView(this.g, 2);
    this.g.setup(this.b);
    this.g.a(this.b.X());
    this.e = findViewById(2131296441);
    this.e.setBackgroundColor(this.b.q());
    localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).setMargins(this.b.r(), this.b.x(), this.b.r(), 0);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c = ((MonthViewPager)findViewById(2131296725));
    this.c.b = this.d;
    this.c.c = this.g;
    localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).setMargins(0, this.b.x() + c.a(paramContext, 1.0F), 0, 0);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.f = ((YearViewPager)findViewById(2131296586));
    this.f.setBackgroundColor(this.b.p());
    this.f.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        if (CalendarView.a(CalendarView.this).getVisibility() == 0) {
          return;
        }
        if (CalendarView.b(CalendarView.this).j != null) {
          CalendarView.b(CalendarView.this).j.a(paramAnonymousInt + CalendarView.b(CalendarView.this).y());
        }
      }
    });
    this.b.i = new f()
    {
      public void a(b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousb.getYear() == CalendarView.b(CalendarView.this).ae().getYear()) && (paramAnonymousb.getMonth() == CalendarView.b(CalendarView.this).ae().getMonth()) && (CalendarView.c(CalendarView.this).getCurrentItem() != CalendarView.b(CalendarView.this).b)) {
          return;
        }
        CalendarView.b(CalendarView.this).p = paramAnonymousb;
        if ((CalendarView.b(CalendarView.this).aa() == 0) || (paramAnonymousBoolean)) {
          CalendarView.b(CalendarView.this).o = paramAnonymousb;
        }
        CalendarView.a(CalendarView.this).a(CalendarView.b(CalendarView.this).p, false);
        CalendarView.c(CalendarView.this).b();
        if ((CalendarView.d(CalendarView.this) != null) && ((CalendarView.b(CalendarView.this).aa() == 0) || (paramAnonymousBoolean))) {
          CalendarView.d(CalendarView.this).a(paramAnonymousb, CalendarView.b(CalendarView.this).X(), paramAnonymousBoolean);
        }
      }
      
      public void b(b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        CalendarView.b(CalendarView.this).p = paramAnonymousb;
        if ((CalendarView.b(CalendarView.this).aa() == 0) || (paramAnonymousBoolean) || (CalendarView.b(CalendarView.this).p.equals(CalendarView.b(CalendarView.this).o))) {
          CalendarView.b(CalendarView.this).o = paramAnonymousb;
        }
        int i = paramAnonymousb.getYear();
        int j = CalendarView.b(CalendarView.this).y();
        int k = CalendarView.b(CalendarView.this).p.getMonth();
        int m = CalendarView.b(CalendarView.this).D();
        CalendarView.a(CalendarView.this).c();
        CalendarView.c(CalendarView.this).setCurrentItem((i - j) * 12 + k - m, false);
        CalendarView.c(CalendarView.this).b();
        if ((CalendarView.d(CalendarView.this) != null) && ((CalendarView.b(CalendarView.this).aa() == 0) || (paramAnonymousBoolean) || (CalendarView.b(CalendarView.this).p.equals(CalendarView.b(CalendarView.this).o)))) {
          CalendarView.d(CalendarView.this).a(paramAnonymousb, CalendarView.b(CalendarView.this).X(), paramAnonymousBoolean);
        }
      }
    };
    if (this.b.aa() == 0)
    {
      if (b(this.b.ae())) {
        this.b.o = this.b.am();
      } else {
        this.b.o = this.b.an();
      }
    }
    else {
      this.b.o = new b();
    }
    this.b.p = this.b.o;
    this.g.a(this.b.o, this.b.X(), false);
    this.c.setup(this.b);
    this.c.setCurrentItem(this.b.b);
    this.f.setOnMonthSelectedListener(new YearRecyclerView.a()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = CalendarView.b(CalendarView.this).y();
        int j = CalendarView.b(CalendarView.this).D();
        CalendarView.a(CalendarView.this, (paramAnonymousInt1 - i) * 12 + paramAnonymousInt2 - j);
        CalendarView.b(CalendarView.this).a = false;
      }
    });
    this.f.setup(this.b);
    this.d.a(this.b.am(), false);
  }
  
  private void setShowMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      return;
    }
    if (this.b.T() == paramInt) {
      return;
    }
    this.b.b(paramInt);
    this.d.e();
    this.c.d();
    this.d.a();
  }
  
  private void setWeekStart(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 7)) {
      return;
    }
    if (paramInt == this.b.X()) {
      return;
    }
    this.b.c(paramInt);
    this.g.a(paramInt);
    this.g.a(this.b.o, paramInt, false);
    this.d.f();
    this.c.e();
    this.f.b();
  }
  
  public final void a()
  {
    this.g.a(this.b.X());
    this.f.a();
    this.c.c();
    this.d.d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, false, true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = new b();
    localb.setYear(paramInt1);
    localb.setMonth(paramInt2);
    localb.setDay(paramInt3);
    if (!localb.isAvailable()) {
      return;
    }
    if (!b(localb)) {
      return;
    }
    if ((this.b.d != null) && (this.b.d.a(localb)))
    {
      this.b.d.a(localb, false);
      return;
    }
    if (this.d.getVisibility() == 0)
    {
      this.d.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      return;
    }
    this.c.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
  }
  
  public final void a(b paramb1, b paramb2)
  {
    if (this.b.aa() != 2) {
      return;
    }
    if (paramb1 != null)
    {
      if (paramb2 == null) {
        return;
      }
      if (a(paramb1))
      {
        if (this.b.d != null) {
          this.b.d.a(paramb1, false);
        }
        return;
      }
      if (a(paramb2))
      {
        if (this.b.d != null) {
          this.b.d.a(paramb2, false);
        }
        return;
      }
      int i = paramb2.differ(paramb1);
      if (i < 0) {
        return;
      }
      if (b(paramb1))
      {
        if (!b(paramb2)) {
          return;
        }
        if ((this.b.ab() != -1) && (this.b.ab() > i + 1))
        {
          if (this.b.f != null) {
            this.b.f.a(paramb2, true);
          }
          return;
        }
        if ((this.b.ac() != -1) && (this.b.ac() < i + 1))
        {
          if (this.b.f != null) {
            this.b.f.a(paramb2, false);
          }
          return;
        }
        if ((this.b.ab() == -1) && (i == 0))
        {
          this.b.r = paramb1;
          this.b.s = null;
          if (this.b.f != null) {
            this.b.f.b(paramb1, false);
          }
          a(paramb1.getYear(), paramb1.getMonth(), paramb1.getDay());
          return;
        }
        this.b.r = paramb1;
        this.b.s = paramb2;
        if (this.b.f != null)
        {
          this.b.f.b(paramb1, false);
          this.b.f.b(paramb2, true);
        }
        a(paramb1.getYear(), paramb1.getMonth(), paramb1.getDay());
        return;
      }
      return;
    }
  }
  
  protected final boolean a(b paramb)
  {
    return (this.b.d != null) && (this.b.d.a(paramb));
  }
  
  protected final boolean b(b paramb)
  {
    return (this.b != null) && (c.a(paramb, this.b));
  }
  
  public int getCurDay()
  {
    return this.b.ae().getDay();
  }
  
  public int getCurMonth()
  {
    return this.b.ae().getMonth();
  }
  
  public int getCurYear()
  {
    return this.b.ae().getYear();
  }
  
  public List<b> getCurrentMonthCalendars()
  {
    return this.c.getCurrentMonthCalendars();
  }
  
  public List<b> getCurrentWeekCalendars()
  {
    return this.d.getCurrentWeekCalendars();
  }
  
  public final int getMaxMultiSelectSize()
  {
    return this.b.ad();
  }
  
  public b getMaxRangeCalendar()
  {
    return this.b.ao();
  }
  
  public final int getMaxSelectRange()
  {
    return this.b.ac();
  }
  
  public b getMinRangeCalendar()
  {
    return this.b.an();
  }
  
  public final int getMinSelectRange()
  {
    return this.b.ab();
  }
  
  public MonthViewPager getMonthViewPager()
  {
    return this.c;
  }
  
  public final List<b> getMultiSelectCalendars()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b.q.size() == 0) {
      return localArrayList;
    }
    localArrayList.addAll(this.b.q.values());
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public final List<b> getSelectCalendarRange()
  {
    return this.b.ap();
  }
  
  public b getSelectedCalendar()
  {
    return this.b.o;
  }
  
  public WeekViewPager getWeekViewPager()
  {
    return this.d;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((getParent() != null) && ((getParent() instanceof CalendarLayout)))
    {
      this.a = ((CalendarLayout)getParent());
      this.c.a = this.a;
      this.d.a = this.a;
      this.a.a = this.g;
      this.a.setup(this.b);
      this.a.f();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    if ((this.b != null) && (this.b.ak()))
    {
      setCalendarItemHeight((i - this.b.x()) / 6);
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    Parcelable localParcelable = paramParcelable.getParcelable("super");
    this.b.o = ((b)paramParcelable.getSerializable("selected_calendar"));
    this.b.p = ((b)paramParcelable.getSerializable("index_calendar"));
    if (this.b.e != null) {
      this.b.e.a(this.b.o, false);
    }
    if (this.b.p != null) {
      a(this.b.p.getYear(), this.b.p.getMonth(), this.b.p.getDay());
    }
    a();
    super.onRestoreInstanceState(localParcelable);
  }
  
  @Nullable
  protected Parcelable onSaveInstanceState()
  {
    if (this.b == null) {
      return super.onSaveInstanceState();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("super", super.onSaveInstanceState());
    localBundle.putSerializable("selected_calendar", this.b.o);
    localBundle.putSerializable("index_calendar", this.b.p);
    return localBundle;
  }
  
  public final void setCalendarItemHeight(int paramInt)
  {
    if (this.b.C() == paramInt) {
      return;
    }
    this.b.a(paramInt);
    this.c.f();
    this.d.g();
    if (this.a == null) {
      return;
    }
    this.a.b();
  }
  
  public final void setMaxMultiSelectSize(int paramInt)
  {
    this.b.d(paramInt);
  }
  
  public final void setMonthView(Class<?> paramClass)
  {
    if (paramClass == null) {
      return;
    }
    if (this.b.s().equals(paramClass)) {
      return;
    }
    this.b.a(paramClass);
    this.c.a();
  }
  
  public final void setMonthViewScrollable(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public final void setOnCalendarInterceptListener(a parama)
  {
    if (parama == null) {
      this.b.d = null;
    }
    if (parama != null)
    {
      if (this.b.aa() == 0) {
        return;
      }
      this.b.d = parama;
      if (!parama.a(this.b.o)) {
        return;
      }
      this.b.o = new b();
      return;
    }
  }
  
  public void setOnCalendarLongClickListener(b paramb)
  {
    this.b.h = paramb;
  }
  
  public final void setOnCalendarMultiSelectListener(c paramc)
  {
    this.b.g = paramc;
  }
  
  public final void setOnCalendarRangeSelectListener(d paramd)
  {
    this.b.f = paramd;
  }
  
  public void setOnCalendarSelectListener(e parame)
  {
    this.b.e = parame;
    if (this.b.e == null) {
      return;
    }
    if (this.b.aa() != 0) {
      return;
    }
    if (!b(this.b.o)) {
      return;
    }
    this.b.al();
  }
  
  public void setOnMonthChangeListener(g paramg)
  {
    this.b.k = paramg;
  }
  
  public void setOnViewChangeListener(h paramh)
  {
    this.b.m = paramh;
  }
  
  public void setOnWeekChangeListener(i parami)
  {
    this.b.l = parami;
  }
  
  public void setOnYearChangeListener(j paramj)
  {
    this.b.j = paramj;
  }
  
  public void setOnYearViewChangeListener(k paramk)
  {
    this.b.n = paramk;
  }
  
  public final void setSchemeDate(Map<String, b> paramMap)
  {
    this.b.c = paramMap;
    this.b.al();
    this.f.a();
    this.c.c();
    this.d.d();
  }
  
  public final void setSelectEndCalendar(b paramb)
  {
    if (this.b.aa() != 2) {
      return;
    }
    if (this.b.r == null) {
      return;
    }
    a(this.b.r, paramb);
  }
  
  public final void setSelectStartCalendar(b paramb)
  {
    if (this.b.aa() != 2) {
      return;
    }
    if (paramb == null) {
      return;
    }
    if (!b(paramb))
    {
      if (this.b.f != null) {
        this.b.f.a(paramb, true);
      }
      return;
    }
    if (a(paramb))
    {
      if (this.b.d != null) {
        this.b.d.a(paramb, false);
      }
      return;
    }
    this.b.s = null;
    this.b.r = paramb;
    a(paramb.getYear(), paramb.getMonth(), paramb.getDay());
  }
  
  public final void setWeekBar(Class<?> paramClass)
  {
    if (paramClass == null) {
      return;
    }
    if (this.b.u().equals(paramClass)) {
      return;
    }
    this.b.b(paramClass);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131296396);
    localFrameLayout.removeView(this.g);
    try
    {
      this.g = ((WeekBar)paramClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { getContext() }));
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    localFrameLayout.addView(this.g, 2);
    this.g.setup(this.b);
    this.g.a(this.b.X());
    this.c.c = this.g;
    this.g.a(this.b.o, this.b.X(), false);
  }
  
  public final void setWeekView(Class<?> paramClass)
  {
    if (paramClass == null) {
      return;
    }
    if (this.b.u().equals(paramClass)) {
      return;
    }
    this.b.c(paramClass);
    this.d.b();
  }
  
  public final void setWeekViewScrollable(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }
  
  public final void setYearViewScrollable(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb, boolean paramBoolean);
    
    public abstract boolean a(b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void a(b paramb);
    
    public abstract void b(b paramb);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract void a(b paramb, boolean paramBoolean);
    
    public abstract void b(b paramb, boolean paramBoolean);
  }
  
  public static abstract interface e
  {
    public abstract void a(b paramb);
    
    public abstract void a(b paramb, boolean paramBoolean);
  }
  
  static abstract interface f
  {
    public abstract void a(b paramb, boolean paramBoolean);
    
    public abstract void b(b paramb, boolean paramBoolean);
  }
  
  public static abstract interface g
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
  
  public static abstract interface h
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface i
  {
    public abstract void a(List<b> paramList);
  }
  
  public static abstract interface j
  {
    public abstract void a(int paramInt);
  }
  
  public static abstract interface k
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\CalendarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */