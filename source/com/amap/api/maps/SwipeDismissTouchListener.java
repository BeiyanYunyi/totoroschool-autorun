package com.amap.api.maps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class SwipeDismissTouchListener
  implements View.OnTouchListener
{
  public static final int A_HALF = 2;
  public static final int MIN_VIEW_WIDTH = 2;
  public static final int ONE_THIRD = 3;
  private int a;
  private int b;
  private int c;
  private long d;
  private View e;
  private DismissCallbacks f;
  private int g = 1;
  private float h;
  private float i;
  private boolean j;
  private int k;
  private Object l;
  private VelocityTracker m;
  private float n;
  private boolean o;
  private boolean p;
  
  public SwipeDismissTouchListener(View paramView, Object paramObject, DismissCallbacks paramDismissCallbacks)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramView.getContext());
    this.a = localViewConfiguration.getScaledTouchSlop();
    this.b = (localViewConfiguration.getScaledMinimumFlingVelocity() * 16);
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.d = paramView.getContext().getResources().getInteger(17694720);
    this.e = paramView;
    this.l = paramObject;
    this.f = paramDismissCallbacks;
  }
  
  private void a()
  {
    this.f.onDismiss(this.e, this.l);
    final ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    final int i1 = this.e.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, 1 }).setDuration(this.d);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SwipeDismissTouchListener.b(SwipeDismissTouchListener.this).setAlpha(0.0F);
        SwipeDismissTouchListener.b(SwipeDismissTouchListener.this).setTranslationX(0.0F);
        localLayoutParams.height = i1;
        SwipeDismissTouchListener.b(SwipeDismissTouchListener.this).setLayoutParams(localLayoutParams);
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        localLayoutParams.height = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        SwipeDismissTouchListener.b(SwipeDismissTouchListener.this).setLayoutParams(localLayoutParams);
      }
    });
    localValueAnimator.start();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.offsetLocation(this.n, 0.0F);
    if (this.g < 2) {
      this.g = this.e.getWidth();
    }
    int i1 = paramMotionEvent.getActionMasked();
    int i3 = 1;
    float f1;
    float f2;
    float f3;
    switch (i1)
    {
    default: 
      return false;
    case 3: 
      if (this.m == null) {
        return false;
      }
      this.e.animate().translationX(0.0F).alpha(1.0F).setDuration(this.d).setListener(null);
      this.m.recycle();
      this.m = null;
      this.n = 0.0F;
      this.h = 0.0F;
      this.i = 0.0F;
      this.j = false;
      return false;
    case 2: 
      if (this.m == null) {
        return false;
      }
      this.m.addMovement(paramMotionEvent);
      f1 = paramMotionEvent.getRawX() - this.h;
      f2 = paramMotionEvent.getRawY();
      f3 = this.i;
      if ((Math.abs(f1) > this.a) && (Math.abs(f2 - f3) < Math.abs(f1) / 2.0F))
      {
        this.j = true;
        if (f1 > 0.0F) {
          i1 = this.a;
        } else {
          i1 = -this.a;
        }
        this.k = i1;
        this.e.getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.o)
        {
          this.o = true;
          this.f.onNotifySwipe();
        }
        if (Math.abs(f1) > this.g / 3)
        {
          if (!this.p)
          {
            this.p = true;
            this.f.onNotifySwipe();
          }
        }
        else {
          this.p = false;
        }
        paramView = MotionEvent.obtain(paramMotionEvent);
        paramView.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
        this.e.onTouchEvent(paramView);
        paramView.recycle();
      }
      if (this.j)
      {
        this.n = f1;
        this.e.setTranslationX(f1 - this.k);
        this.e.setAlpha(Math.max(0.0F, Math.min(1.0F, 1.0F - Math.abs(f1) * 2.0F / this.g)));
        return true;
      }
      break;
    case 1: 
      if (this.m == null) {
        return false;
      }
      f1 = paramMotionEvent.getRawX() - this.h;
      this.m.addMovement(paramMotionEvent);
      this.m.computeCurrentVelocity(1000);
      f2 = this.m.getXVelocity();
      f3 = Math.abs(f2);
      float f4 = Math.abs(this.m.getYVelocity());
      int i2;
      if ((Math.abs(f1) > this.g / 2) && (this.j))
      {
        if (f1 > 0.0F) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        i3 = 1;
        i2 = i1;
        i1 = i3;
      }
      else
      {
        if ((this.b <= f3) && (f3 <= this.c) && (f4 < f3) && (this.j))
        {
          if (f2 < 0.0F) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (f1 < 0.0F) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i1 == i2) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          i2 = i1;
          if (this.m.getXVelocity() > 0.0F)
          {
            i2 = i3;
            break label646;
          }
        }
        else
        {
          i2 = 0;
        }
        i3 = 0;
        i1 = i2;
        i2 = i3;
      }
      if (i1 != 0)
      {
        paramView = this.e.animate();
        if (i2 != 0) {}
        for (i1 = this.g;; i1 = -this.g)
        {
          f1 = i1;
          break;
        }
        paramView.translationX(f1).alpha(0.0F).setDuration(50L).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            SwipeDismissTouchListener.a(SwipeDismissTouchListener.this);
          }
        });
      }
      else if (this.j)
      {
        this.e.animate().translationX(0.0F).alpha(1.0F).setDuration(this.d).setListener(null);
      }
      this.m.recycle();
      this.m = null;
      this.n = 0.0F;
      this.h = 0.0F;
      this.i = 0.0F;
      this.j = false;
      return false;
    case 0: 
      label646:
      this.h = paramMotionEvent.getRawX();
      this.i = paramMotionEvent.getRawY();
      if (this.f.canDismiss(this.l))
      {
        this.o = false;
        this.m = VelocityTracker.obtain();
        this.m.addMovement(paramMotionEvent);
      }
      return true;
    }
    return false;
  }
  
  public static abstract interface DismissCallbacks
  {
    public abstract boolean canDismiss(Object paramObject);
    
    public abstract void onDismiss(View paramView, Object paramObject);
    
    public abstract void onNotifySwipe();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\SwipeDismissTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */