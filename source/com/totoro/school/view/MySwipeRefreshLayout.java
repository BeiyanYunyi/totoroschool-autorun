package com.totoro.school.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class MySwipeRefreshLayout
  extends SwipeRefreshLayout
{
  private float a;
  private float b;
  private boolean c;
  private final int d;
  
  public MySwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      break;
    case 2: 
      if (this.c) {
        return false;
      }
      float f2 = paramMotionEvent.getY();
      float f1 = Math.abs(paramMotionEvent.getX() - this.b);
      f2 = Math.abs(f2 - this.a);
      if ((f1 > this.d) && (f1 > f2))
      {
        this.c = true;
        return false;
      }
      break;
    case 1: 
    case 3: 
      this.c = false;
      break;
    case 0: 
      this.a = paramMotionEvent.getY();
      this.b = paramMotionEvent.getX();
      this.c = false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\MySwipeRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */