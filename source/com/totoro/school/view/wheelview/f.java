package com.totoro.school.view.wheelview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class f
  extends GestureDetector.SimpleOnGestureListener
{
  final WheelView a;
  
  f(WheelView paramWheelView)
  {
    this.a = paramWheelView;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.a.a(paramFloat2);
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\wheelview\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */