package com.totoro.school.view.calendar.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.totoro.school.R.styleable;

public class CalendarLayout
  extends LinearLayout
{
  WeekBar a;
  MonthViewPager b;
  CalendarView c;
  WeekViewPager d;
  YearViewPager e;
  ViewGroup f;
  private int g;
  private int h;
  private boolean i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n = 0;
  private float o;
  private float p;
  private float q;
  private boolean r = false;
  private int s;
  private VelocityTracker t;
  private int u;
  private int v;
  private d w;
  
  public CalendarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CalendarLayout);
    this.s = paramAttributeSet.getResourceId(0, 0);
    this.h = paramAttributeSet.getInt(2, 0);
    this.k = paramAttributeSet.getInt(1, 0);
    this.j = paramAttributeSet.getInt(3, 0);
    paramAttributeSet.recycle();
    this.t = VelocityTracker.obtain();
    paramContext = ViewConfiguration.get(paramContext);
    this.l = paramContext.getScaledTouchSlop();
    this.u = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private int a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = paramMotionEvent.findPointerIndex(paramInt);
    if (paramInt == -1) {
      this.g = -1;
    }
    return paramInt;
  }
  
  private void a(b paramb)
  {
    a(c.b(paramb, this.w.X()) + paramb.getDay() - 1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      l();
    }
    this.d.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  private int getCalendarViewHeight()
  {
    if (this.b.getVisibility() == 0) {
      return this.w.x() + this.b.getHeight();
    }
    return this.w.x() + this.w.C();
  }
  
  private void i()
  {
    float f1 = this.f.getTranslationY() * 1.0F / this.m;
    this.b.setTranslationY(this.n * f1);
  }
  
  private void j()
  {
    k();
    if ((this.d != null) && (this.d.getAdapter() != null))
    {
      this.d.getAdapter().notifyDataSetChanged();
      this.d.setVisibility(0);
    }
    this.b.setVisibility(4);
  }
  
  private void k()
  {
    if (this.d.getVisibility() == 0) {
      return;
    }
    if ((this.w != null) && (this.w.m != null) && (!this.i)) {
      this.w.m.a(false);
    }
  }
  
  private void l()
  {
    if (this.b.getVisibility() == 0) {
      return;
    }
    if ((this.w != null) && (this.w.m != null) && (this.i)) {
      this.w.m.a(true);
    }
  }
  
  void a()
  {
    b localb = this.w.p;
    if (this.w.T() == 0) {
      this.m = (this.v * 5);
    } else {
      this.m = (c.b(localb.getYear(), localb.getMonth(), this.v, this.w.X()) - this.v);
    }
    if (this.d.getVisibility() == 0)
    {
      if (this.f == null) {
        return;
      }
      this.f.setTranslationY(-this.m);
    }
  }
  
  final void a(int paramInt)
  {
    this.n = (((paramInt + 7) / 7 - 1) * this.v);
  }
  
  final void b()
  {
    this.v = this.w.C();
    if (this.f == null) {
      return;
    }
    b localb = this.w.p;
    b(c.a(localb, this.w.X()));
    if (this.w.T() == 0) {
      this.m = (this.v * 5);
    } else {
      this.m = (c.b(localb.getYear(), localb.getMonth(), this.v, this.w.X()) - this.v);
    }
    i();
    if (this.d.getVisibility() == 0) {
      this.f.setTranslationY(-this.m);
    }
  }
  
  final void b(int paramInt)
  {
    this.n = ((paramInt - 1) * this.v);
  }
  
  public final boolean c()
  {
    return this.b.getVisibility() == 0;
  }
  
  public boolean c(int paramInt)
  {
    if ((!this.r) && (this.k != 1))
    {
      if (this.f == null) {
        return false;
      }
      if (this.b.getVisibility() != 0)
      {
        l();
        this.i = false;
        this.b.setVisibility(0);
      }
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.f, "translationY", new float[] { this.f.getTranslationY(), 0.0F });
      localObjectAnimator.setDuration(paramInt);
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * 1.0F / CalendarLayout.a(CalendarLayout.this);
          CalendarLayout.this.b.setTranslationY(CalendarLayout.b(CalendarLayout.this) * f);
          CalendarLayout.this.b.setAlpha(1.0F + f);
          CalendarLayout.this.d.setAlpha(Math.abs(f));
          CalendarLayout.a(CalendarLayout.this, true);
        }
      });
      localObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          CalendarLayout.a(CalendarLayout.this, false);
          if (CalendarLayout.c(CalendarLayout.this) == 2) {
            CalendarLayout.this.requestLayout();
          }
          CalendarLayout.b(CalendarLayout.this, true);
          if ((CalendarLayout.d(CalendarLayout.this).m != null) && (CalendarLayout.e(CalendarLayout.this))) {
            CalendarLayout.d(CalendarLayout.this).m.a(true);
          }
          CalendarLayout.c(CalendarLayout.this, false);
        }
      });
      localObjectAnimator.start();
      return true;
    }
    return false;
  }
  
  public boolean d()
  {
    return c(240);
  }
  
  public boolean d(int paramInt)
  {
    if (this.j == 2) {
      requestLayout();
    }
    if (!this.r)
    {
      if (this.f == null) {
        return false;
      }
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.f, "translationY", new float[] { this.f.getTranslationY(), -this.m });
      localObjectAnimator.setDuration(paramInt);
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * 1.0F / CalendarLayout.a(CalendarLayout.this);
          CalendarLayout.this.b.setTranslationY(CalendarLayout.b(CalendarLayout.this) * f);
          CalendarLayout.this.b.setAlpha(1.0F + f);
          CalendarLayout.this.d.setVisibility(0);
          CalendarLayout.this.d.setAlpha(Math.abs(f));
          CalendarLayout.a(CalendarLayout.this, true);
        }
      });
      localObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          CalendarLayout.a(CalendarLayout.this, false);
          CalendarLayout.f(CalendarLayout.this);
          CalendarLayout.c(CalendarLayout.this, true);
        }
      });
      localObjectAnimator.start();
      return true;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.r) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.j == 2) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if ((this.e != null) && (this.c != null) && (this.c.getVisibility() != 8) && (this.f != null) && (this.f.getVisibility() == 0))
    {
      if ((this.k != 2) && (this.k != 1))
      {
        if ((this.e.getVisibility() != 0) && (!this.w.a))
        {
          int i1 = paramMotionEvent.getAction();
          float f1 = paramMotionEvent.getY();
          if ((i1 == 2) && (f1 - this.p > 0.0F) && (this.f.getTranslationY() == -this.m) && (g()))
          {
            requestDisallowInterceptTouchEvent(false);
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean e()
  {
    return d(240);
  }
  
  final void f()
  {
    if (((this.h == 1) || (this.k == 1)) && (this.k != 2))
    {
      if (this.f == null)
      {
        this.d.setVisibility(0);
        this.b.setVisibility(8);
        return;
      }
      post(new Runnable()
      {
        public void run()
        {
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(CalendarLayout.this.f, "translationY", new float[] { CalendarLayout.this.f.getTranslationY(), -CalendarLayout.a(CalendarLayout.this) });
          localObjectAnimator.setDuration(0L);
          localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue() * 1.0F / CalendarLayout.a(CalendarLayout.this);
              CalendarLayout.this.b.setTranslationY(CalendarLayout.b(CalendarLayout.this) * f);
              CalendarLayout.a(CalendarLayout.this, true);
            }
          });
          localObjectAnimator.addListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              super.onAnimationEnd(paramAnonymous2Animator);
              CalendarLayout.a(CalendarLayout.this, false);
              CalendarLayout.c(CalendarLayout.this, true);
              CalendarLayout.f(CalendarLayout.this);
              if (CalendarLayout.d(CalendarLayout.this) != null)
              {
                if (CalendarLayout.d(CalendarLayout.this).m == null) {
                  return;
                }
                CalendarLayout.d(CalendarLayout.this).m.a(false);
                return;
              }
            }
          });
          localObjectAnimator.start();
        }
      });
      return;
    }
    if (this.w.m == null) {
      return;
    }
    post(new Runnable()
    {
      public void run()
      {
        CalendarLayout.d(CalendarLayout.this).m.a(true);
      }
    });
  }
  
  protected boolean g()
  {
    if ((this.f instanceof a)) {
      return ((a)this.f).a();
    }
    boolean bool1 = this.f instanceof RecyclerView;
    boolean bool2 = false;
    if (bool1) {
      return ((RecyclerView)this.f).computeVerticalScrollOffset() == 0;
    }
    if ((this.f instanceof AbsListView))
    {
      AbsListView localAbsListView = (AbsListView)this.f;
      bool1 = bool2;
      if (localAbsListView.getFirstVisiblePosition() == 0)
      {
        bool1 = bool2;
        if (localAbsListView.getChildAt(0).getTop() == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return this.f.getScrollY() == 0;
  }
  
  @SuppressLint({"NewApi"})
  final void h()
  {
    if (this.f == null) {
      return;
    }
    this.f.setTranslationY(getHeight() - this.b.getHeight());
    this.f.setVisibility(0);
    this.f.animate().translationY(0.0F).setDuration(180L).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
      }
    });
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((MonthViewPager)findViewById(2131296725));
    this.d = ((WeekViewPager)findViewById(2131296726));
    if (getChildCount() > 0) {
      this.c = ((CalendarView)getChildAt(0));
    }
    this.f = ((ViewGroup)findViewById(this.s));
    this.e = ((YearViewPager)findViewById(2131296586));
    if (this.f != null) {
      this.f.setOverScrollMode(2);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.r) {
      return true;
    }
    if (this.j == 2) {
      return false;
    }
    if ((this.e != null) && (this.c != null) && (this.c.getVisibility() != 8) && (this.f != null) && (this.f.getVisibility() == 0))
    {
      if (this.k != 2)
      {
        if (this.k == 1) {
          return false;
        }
        if ((this.e.getVisibility() != 0) && (!this.w.a))
        {
          int i1 = paramMotionEvent.getAction();
          float f1 = paramMotionEvent.getY();
          float f2 = paramMotionEvent.getX();
          if (i1 != 0)
          {
            if (i1 == 2)
            {
              float f3 = f1 - this.p;
              float f4 = this.q;
              if ((f3 < 0.0F) && (this.f.getTranslationY() == -this.m)) {
                return false;
              }
              if ((f3 > 0.0F) && (this.f.getTranslationY() == -this.m) && (f1 >= this.w.C() + this.w.x()) && (!g())) {
                return false;
              }
              if ((f3 > 0.0F) && (this.f.getTranslationY() == 0.0F) && (f1 >= c.a(getContext(), 98.0F))) {
                return false;
              }
              if ((Math.abs(f3) > Math.abs(f2 - f4)) && (((f3 > 0.0F) && (this.f.getTranslationY() <= 0.0F)) || ((f3 < 0.0F) && (this.f.getTranslationY() >= -this.m))))
              {
                this.p = f1;
                return true;
              }
            }
          }
          else
          {
            this.g = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.o = f1;
            this.p = f1;
            this.q = f2;
          }
          return super.onInterceptTouchEvent(paramMotionEvent);
        }
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.f != null) && (this.c != null))
    {
      int i1 = this.w.p.getYear();
      int i2 = this.w.p.getMonth();
      int i5 = c.a(getContext(), 1.0F) + this.w.x();
      int i3 = c.a(i1, i2, this.w.C(), this.w.X(), this.w.T()) + i5;
      int i4 = View.MeasureSpec.getSize(paramInt2);
      if (this.w.ak())
      {
        super.onMeasure(paramInt1, paramInt2);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i4 - i5 - this.w.C(), 1073741824);
        this.f.measure(paramInt1, paramInt2);
        this.f.layout(this.f.getLeft(), this.f.getTop(), this.f.getRight(), this.f.getBottom());
        return;
      }
      if ((i3 >= i4) && (this.b.getHeight() > 0))
      {
        i1 = View.MeasureSpec.makeMeasureSpec(i3 + i5 + this.w.x(), 1073741824);
        i2 = i3;
      }
      else
      {
        i2 = i4;
        i1 = paramInt2;
        if (i3 < i4)
        {
          i2 = i4;
          i1 = paramInt2;
          if (this.b.getHeight() > 0)
          {
            i1 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            i2 = i4;
          }
        }
      }
      if ((this.k != 2) && (this.c.getVisibility() != 8))
      {
        if ((this.j == 2) && (!this.r))
        {
          if (c()) {
            paramInt2 = i2 - i3;
          } else {
            paramInt2 = i2 - i5 - this.v;
          }
        }
        else {
          paramInt2 = i2 - i5 - this.v;
        }
      }
      else
      {
        if (this.c.getVisibility() == 8) {
          paramInt2 = 0;
        } else {
          paramInt2 = this.c.getHeight();
        }
        paramInt2 = i2 - paramInt2;
      }
      super.onMeasure(paramInt1, i1);
      View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    Parcelable localParcelable = paramParcelable.getParcelable("super");
    if (paramParcelable.getBoolean("isExpand")) {
      post(new Runnable()
      {
        public void run()
        {
          CalendarLayout.this.c(0);
        }
      });
    } else {
      post(new Runnable()
      {
        public void run()
        {
          CalendarLayout.this.d(0);
        }
      });
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  @Nullable
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("super", super.onSaveInstanceState());
    localBundle.putBoolean("isExpand", c());
    return localBundle;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.j != 2) && (this.k != 2))
    {
      if (this.k == 1) {
        return false;
      }
      if (this.w == null) {
        return false;
      }
      if (this.w.a) {
        return false;
      }
      if ((this.f != null) && (this.c != null))
      {
        if (this.c.getVisibility() == 8) {
          return false;
        }
        int i1 = paramMotionEvent.getAction();
        float f1 = paramMotionEvent.getY();
        this.t.addMovement(paramMotionEvent);
        switch (i1)
        {
        case 4: 
        default: 
          break;
        case 5: 
          this.g = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          if (this.g == 0) {
            this.p = paramMotionEvent.getY(this.g);
          }
          break;
        case 3: 
        case 6: 
          i1 = a(paramMotionEvent, this.g);
          if (this.g != -1) {
            this.p = paramMotionEvent.getY(i1);
          }
          break;
        case 2: 
          a(paramMotionEvent, this.g);
          if (this.g == -1)
          {
            this.p = f1;
            this.g = 1;
          }
          float f2 = f1 - this.p;
          if ((f2 < 0.0F) && (this.f.getTranslationY() == -this.m))
          {
            this.p = f1;
            paramMotionEvent.setAction(0);
            dispatchTouchEvent(paramMotionEvent);
            this.d.setVisibility(0);
            this.b.setVisibility(4);
            if ((!this.i) && (this.w.m != null)) {
              this.w.m.a(false);
            }
            this.i = true;
            return false;
          }
          a(false);
          if ((f2 > 0.0F) && (this.f.getTranslationY() + f2 >= 0.0F))
          {
            this.f.setTranslationY(0.0F);
            i();
            this.p = f1;
            return super.onTouchEvent(paramMotionEvent);
          }
          if ((f2 < 0.0F) && (this.f.getTranslationY() + f2 <= -this.m))
          {
            this.f.setTranslationY(-this.m);
            i();
            this.p = f1;
            return super.onTouchEvent(paramMotionEvent);
          }
          this.f.setTranslationY(this.f.getTranslationY() + f2);
          i();
          this.p = f1;
          break;
        case 1: 
          VelocityTracker localVelocityTracker = this.t;
          localVelocityTracker.computeCurrentVelocity(1000, this.u);
          f1 = localVelocityTracker.getYVelocity();
          if ((this.f.getTranslationY() != 0.0F) && (this.f.getTranslationY() != this.m))
          {
            if (Math.abs(f1) >= 800.0F)
            {
              if (f1 < 0.0F) {
                e();
              } else {
                d();
              }
              return super.onTouchEvent(paramMotionEvent);
            }
            if (paramMotionEvent.getY() - this.o > 0.0F) {
              d();
            } else {
              e();
            }
          }
          else
          {
            d();
          }
          break;
        case 0: 
          this.g = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          this.o = f1;
          this.p = f1;
          return true;
        }
        return super.onTouchEvent(paramMotionEvent);
      }
      return false;
    }
    return false;
  }
  
  final void setup(d paramd)
  {
    this.w = paramd;
    this.v = this.w.C();
    if (paramd.o.isAvailable()) {
      paramd = paramd.o;
    } else {
      paramd = paramd.am();
    }
    a(paramd);
    a();
  }
  
  public static abstract interface a
  {
    public abstract boolean a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\CalendarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */