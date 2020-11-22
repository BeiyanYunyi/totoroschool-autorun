package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5F;
  private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0F;
  private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5F;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  public static final int SWIPE_DIRECTION_ANY = 2;
  public static final int SWIPE_DIRECTION_END_TO_START = 1;
  public static final int SWIPE_DIRECTION_START_TO_END = 0;
  float alphaEndSwipeDistance = 0.5F;
  float alphaStartSwipeDistance = 0.0F;
  private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback()
  {
    private static final int INVALID_POINTER_ID = -1;
    private int activePointerId = -1;
    private int originalCapturedViewLeft;
    
    private boolean shouldDismiss(View paramAnonymousView, float paramAnonymousFloat)
    {
      boolean bool = false;
      if (paramAnonymousFloat != 0.0F)
      {
        if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1) {
          i = 1;
        } else {
          i = 0;
        }
        if (SwipeDismissBehavior.this.swipeDirection == 2) {
          return true;
        }
        if (SwipeDismissBehavior.this.swipeDirection == 0)
        {
          if (i != 0)
          {
            if (paramAnonymousFloat >= 0.0F) {}
          }
          else {
            while (paramAnonymousFloat > 0.0F) {
              return true;
            }
          }
          return false;
        }
        if (SwipeDismissBehavior.this.swipeDirection == 1)
        {
          if (i != 0)
          {
            if (paramAnonymousFloat <= 0.0F) {}
          }
          else {
            while (paramAnonymousFloat < 0.0F) {
              return true;
            }
          }
          return false;
        }
        return false;
      }
      int i = paramAnonymousView.getLeft();
      int j = this.originalCapturedViewLeft;
      int k = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.dragDismissThreshold);
      if (Math.abs(i - j) >= k) {
        bool = true;
      }
      return bool;
    }
    
    public int clampViewPositionHorizontal(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1) {
        paramAnonymousInt2 = 1;
      } else {
        paramAnonymousInt2 = 0;
      }
      int i;
      if (SwipeDismissBehavior.this.swipeDirection == 0)
      {
        if (paramAnonymousInt2 != 0)
        {
          i = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
          paramAnonymousInt2 = this.originalCapturedViewLeft;
        }
        else
        {
          i = this.originalCapturedViewLeft;
          paramAnonymousInt2 = this.originalCapturedViewLeft;
          paramAnonymousInt2 = paramAnonymousView.getWidth() + paramAnonymousInt2;
        }
      }
      else if (SwipeDismissBehavior.this.swipeDirection == 1)
      {
        if (paramAnonymousInt2 != 0)
        {
          i = this.originalCapturedViewLeft;
          paramAnonymousInt2 = this.originalCapturedViewLeft;
          paramAnonymousInt2 = paramAnonymousView.getWidth() + paramAnonymousInt2;
        }
        else
        {
          i = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
          paramAnonymousInt2 = this.originalCapturedViewLeft;
        }
      }
      else
      {
        i = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
        paramAnonymousInt2 = this.originalCapturedViewLeft;
        paramAnonymousInt2 = paramAnonymousView.getWidth() + paramAnonymousInt2;
      }
      return SwipeDismissBehavior.clamp(i, paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public int clampViewPositionVertical(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }
    
    public void onViewCaptured(View paramAnonymousView, int paramAnonymousInt)
    {
      this.activePointerId = paramAnonymousInt;
      this.originalCapturedViewLeft = paramAnonymousView.getLeft();
      paramAnonymousView = paramAnonymousView.getParent();
      if (paramAnonymousView != null) {
        paramAnonymousView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public void onViewDragStateChanged(int paramAnonymousInt)
    {
      if (SwipeDismissBehavior.this.listener != null) {
        SwipeDismissBehavior.this.listener.onDragStateChanged(paramAnonymousInt);
      }
    }
    
    public void onViewPositionChanged(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      float f1 = this.originalCapturedViewLeft + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.alphaStartSwipeDistance;
      float f2 = this.originalCapturedViewLeft + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.alphaEndSwipeDistance;
      float f3 = paramAnonymousInt1;
      if (f3 <= f1)
      {
        paramAnonymousView.setAlpha(1.0F);
        return;
      }
      if (f3 >= f2)
      {
        paramAnonymousView.setAlpha(0.0F);
        return;
      }
      paramAnonymousView.setAlpha(SwipeDismissBehavior.clamp(0.0F, 1.0F - SwipeDismissBehavior.fraction(f1, f2, f3), 1.0F));
    }
    
    public void onViewReleased(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      this.activePointerId = -1;
      int i = paramAnonymousView.getWidth();
      boolean bool;
      if (shouldDismiss(paramAnonymousView, paramAnonymousFloat1))
      {
        if (paramAnonymousView.getLeft() < this.originalCapturedViewLeft) {
          i = this.originalCapturedViewLeft - i;
        } else {
          i = this.originalCapturedViewLeft + i;
        }
        bool = true;
      }
      else
      {
        i = this.originalCapturedViewLeft;
        bool = false;
      }
      if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i, paramAnonymousView.getTop()))
      {
        ViewCompat.postOnAnimation(paramAnonymousView, new SwipeDismissBehavior.SettleRunnable(SwipeDismissBehavior.this, paramAnonymousView, bool));
        return;
      }
      if ((bool) && (SwipeDismissBehavior.this.listener != null)) {
        SwipeDismissBehavior.this.listener.onDismiss(paramAnonymousView);
      }
    }
    
    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      return (this.activePointerId == -1) && (SwipeDismissBehavior.this.canSwipeDismissView(paramAnonymousView));
    }
  };
  float dragDismissThreshold = 0.5F;
  private boolean interceptingEvents;
  OnDismissListener listener;
  private float sensitivity = 0.0F;
  private boolean sensitivitySet;
  int swipeDirection = 2;
  ViewDragHelper viewDragHelper;
  
  static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private void ensureViewDragHelper(ViewGroup paramViewGroup)
  {
    if (this.viewDragHelper == null)
    {
      if (this.sensitivitySet) {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.sensitivity, this.dragCallback);
      } else {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.dragCallback);
      }
      this.viewDragHelper = paramViewGroup;
    }
  }
  
  static float fraction(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  public boolean canSwipeDismissView(@NonNull View paramView)
  {
    return true;
  }
  
  public int getDragState()
  {
    if (this.viewDragHelper != null) {
      return this.viewDragHelper.getViewDragState();
    }
    return 0;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool = this.interceptingEvents;
    int i = paramMotionEvent.getActionMasked();
    if (i != 3) {
      switch (i)
      {
      default: 
        break;
      case 0: 
        this.interceptingEvents = paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        bool = this.interceptingEvents;
        break;
      }
    } else {
      this.interceptingEvents = false;
    }
    if (bool)
    {
      ensureViewDragHelper(paramCoordinatorLayout);
      return this.viewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.viewDragHelper != null)
    {
      this.viewDragHelper.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setDragDismissDistance(float paramFloat)
  {
    this.dragDismissThreshold = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setEndAlphaSwipeDistance(float paramFloat)
  {
    this.alphaEndSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setListener(OnDismissListener paramOnDismissListener)
  {
    this.listener = paramOnDismissListener;
  }
  
  public void setSensitivity(float paramFloat)
  {
    this.sensitivity = paramFloat;
    this.sensitivitySet = true;
  }
  
  public void setStartAlphaSwipeDistance(float paramFloat)
  {
    this.alphaStartSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setSwipeDirection(int paramInt)
  {
    this.swipeDirection = paramInt;
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(View paramView);
    
    public abstract void onDragStateChanged(int paramInt);
  }
  
  private class SettleRunnable
    implements Runnable
  {
    private final boolean dismiss;
    private final View view;
    
    SettleRunnable(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.dismiss = paramBoolean;
    }
    
    public void run()
    {
      if ((SwipeDismissBehavior.this.viewDragHelper != null) && (SwipeDismissBehavior.this.viewDragHelper.continueSettling(true)))
      {
        ViewCompat.postOnAnimation(this.view, this);
        return;
      }
      if ((this.dismiss) && (SwipeDismissBehavior.this.listener != null)) {
        SwipeDismissBehavior.this.listener.onDismiss(this.view);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\SwipeDismissBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */