package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private static final int INVALID_POINTER = -1;
  private int activePointerId = -1;
  private Runnable flingRunnable;
  private boolean isBeingDragged;
  private int lastMotionY;
  OverScroller scroller;
  private int touchSlop = -1;
  private VelocityTracker velocityTracker;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ensureVelocityTracker()
  {
    if (this.velocityTracker == null) {
      this.velocityTracker = VelocityTracker.obtain();
    }
  }
  
  boolean canDragView(V paramV)
  {
    return false;
  }
  
  final boolean fling(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.flingRunnable != null)
    {
      paramV.removeCallbacks(this.flingRunnable);
      this.flingRunnable = null;
    }
    if (this.scroller == null) {
      this.scroller = new OverScroller(paramV.getContext());
    }
    this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.scroller.computeScrollOffset())
    {
      this.flingRunnable = new FlingRunnable(paramCoordinatorLayout, paramV);
      ViewCompat.postOnAnimation(paramV, this.flingRunnable);
      return true;
    }
    onFlingFinished(paramCoordinatorLayout, paramV);
    return false;
  }
  
  int getMaxDragOffset(V paramV)
  {
    return -paramV.getHeight();
  }
  
  int getScrollRangeForDragFling(V paramV)
  {
    return paramV.getHeight();
  }
  
  int getTopBottomOffsetForScrollingSibling()
  {
    return getTopAndBottomOffset();
  }
  
  void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.touchSlop < 0) {
      this.touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.isBeingDragged)) {
      return true;
    }
    int i;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      break;
    case 2: 
      i = this.activePointerId;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        if (i != -1)
        {
          i = (int)paramMotionEvent.getY(i);
          if (Math.abs(i - this.lastMotionY) > this.touchSlop)
          {
            this.isBeingDragged = true;
            this.lastMotionY = i;
          }
        }
      }
      break;
    case 1: 
    case 3: 
      this.isBeingDragged = false;
      this.activePointerId = -1;
      if (this.velocityTracker != null)
      {
        this.velocityTracker.recycle();
        this.velocityTracker = null;
      }
      break;
    case 0: 
      this.isBeingDragged = false;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((canDragView(paramV)) && (paramCoordinatorLayout.isPointInChildBounds(paramV, i, j)))
      {
        this.lastMotionY = j;
        this.activePointerId = paramMotionEvent.getPointerId(0);
        ensureVelocityTracker();
      }
      break;
    }
    if (this.velocityTracker != null) {
      this.velocityTracker.addMovement(paramMotionEvent);
    }
    return this.isBeingDragged;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.touchSlop < 0) {
      this.touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      break;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.activePointerId);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.lastMotionY - k;
      i = j;
      if (!this.isBeingDragged)
      {
        i = j;
        if (Math.abs(j) > this.touchSlop)
        {
          this.isBeingDragged = true;
          if (j > 0) {
            i = j - this.touchSlop;
          } else {
            i = j + this.touchSlop;
          }
        }
      }
      if (!this.isBeingDragged) {
        break label328;
      }
      this.lastMotionY = k;
      scroll(paramCoordinatorLayout, paramV, i, getMaxDragOffset(paramV), 0);
      break;
    case 1: 
      if (this.velocityTracker != null)
      {
        this.velocityTracker.addMovement(paramMotionEvent);
        this.velocityTracker.computeCurrentVelocity(1000);
        float f = this.velocityTracker.getYVelocity(this.activePointerId);
        fling(paramCoordinatorLayout, paramV, -getScrollRangeForDragFling(paramV), 0, f);
      }
    case 3: 
      this.isBeingDragged = false;
      this.activePointerId = -1;
      if (this.velocityTracker == null) {
        break label328;
      }
      this.velocityTracker.recycle();
      this.velocityTracker = null;
      break;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramCoordinatorLayout.isPointInChildBounds(paramV, i, j)) && (canDragView(paramV)))
    {
      this.lastMotionY = j;
      this.activePointerId = paramMotionEvent.getPointerId(0);
      ensureVelocityTracker();
    }
    else
    {
      return false;
    }
    label328:
    if (this.velocityTracker != null) {
      this.velocityTracker.addMovement(paramMotionEvent);
    }
    return true;
  }
  
  final int scroll(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, getTopBottomOffsetForScrollingSibling() - paramInt1, paramInt2, paramInt3);
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getTopAndBottomOffset();
    if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
    {
      paramInt1 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      if (i != paramInt1)
      {
        setTopAndBottomOffset(paramInt1);
        return i - paramInt1;
      }
    }
    return 0;
  }
  
  private class FlingRunnable
    implements Runnable
  {
    private final V layout;
    private final CoordinatorLayout parent;
    
    FlingRunnable(V paramV)
    {
      this.parent = paramV;
      View localView;
      this.layout = localView;
    }
    
    public void run()
    {
      if ((this.layout != null) && (HeaderBehavior.this.scroller != null))
      {
        if (HeaderBehavior.this.scroller.computeScrollOffset())
        {
          HeaderBehavior.this.setHeaderTopBottomOffset(this.parent, this.layout, HeaderBehavior.this.scroller.getCurrY());
          ViewCompat.postOnAnimation(this.layout, this);
          return;
        }
        HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\HeaderBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */