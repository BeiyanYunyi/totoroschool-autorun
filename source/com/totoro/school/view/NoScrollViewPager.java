package com.totoro.school.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager
  extends ViewPager
{
  private boolean a = true;
  
  public NoScrollViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public NoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setCurrentItem(int paramInt)
  {
    super.setCurrentItem(paramInt);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    super.setCurrentItem(paramInt, paramBoolean);
  }
  
  public void setNoScroll(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\NoScrollViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */