package com.totoro.school.view.calendar.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;

public final class YearViewPager
  extends ViewPager
{
  private int b;
  private boolean c;
  private d d;
  private YearRecyclerView.a e;
  
  public YearViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public YearViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int a(Context paramContext, View paramView)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if ((!a) && (paramContext == null)) {
      throw new AssertionError();
    }
    int i = paramContext.getDefaultDisplay().getHeight();
    paramContext = new int[2];
    paramView.getLocationInWindow(paramContext);
    paramView.getLocationOnScreen(paramContext);
    return i - paramContext[1];
  }
  
  final void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((YearRecyclerView)getChildAt(i)).b();
      i += 1;
    }
  }
  
  final void b()
  {
    int i = 0;
    while (i < getChildCount())
    {
      YearRecyclerView localYearRecyclerView = (YearRecyclerView)getChildAt(i);
      localYearRecyclerView.a();
      localYearRecyclerView.b();
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.d.W()) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(a(getContext(), this), 1073741824));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.d.W()) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if (Math.abs(getCurrentItem() - paramInt) > 1)
    {
      super.setCurrentItem(paramInt, false);
      return;
    }
    super.setCurrentItem(paramInt, false);
  }
  
  final void setOnMonthSelectedListener(YearRecyclerView.a parama)
  {
    this.e = parama;
  }
  
  void setup(d paramd)
  {
    this.d = paramd;
    this.b = (this.d.z() - this.d.y() + 1);
    setAdapter(new PagerAdapter()
    {
      public void destroyItem(@NonNull ViewGroup paramAnonymousViewGroup, int paramAnonymousInt, @NonNull Object paramAnonymousObject)
      {
        paramAnonymousViewGroup.removeView((View)paramAnonymousObject);
      }
      
      public int getCount()
      {
        return YearViewPager.a(YearViewPager.this);
      }
      
      public int getItemPosition(@NonNull Object paramAnonymousObject)
      {
        if (YearViewPager.b(YearViewPager.this)) {
          return -2;
        }
        return super.getItemPosition(paramAnonymousObject);
      }
      
      @NonNull
      public Object instantiateItem(@NonNull ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        YearRecyclerView localYearRecyclerView = new YearRecyclerView(YearViewPager.this.getContext());
        paramAnonymousViewGroup.addView(localYearRecyclerView);
        localYearRecyclerView.setup(YearViewPager.c(YearViewPager.this));
        localYearRecyclerView.setOnMonthSelectedListener(YearViewPager.d(YearViewPager.this));
        localYearRecyclerView.a(paramAnonymousInt + YearViewPager.c(YearViewPager.this).y());
        return localYearRecyclerView;
      }
      
      public boolean isViewFromObject(@NonNull View paramAnonymousView, @NonNull Object paramAnonymousObject)
      {
        return paramAnonymousView == paramAnonymousObject;
      }
    });
    setCurrentItem(this.d.ae().getYear() - this.d.y());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\YearViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */