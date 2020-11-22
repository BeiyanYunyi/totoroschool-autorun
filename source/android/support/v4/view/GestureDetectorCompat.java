package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat
{
  private final GestureDetectorCompatImpl mImpl;
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.mImpl = new GestureDetectorCompatImplJellybeanMr2(paramContext, paramOnGestureListener, paramHandler);
      return;
    }
    this.mImpl = new GestureDetectorCompatImplBase(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean isLongpressEnabled()
  {
    return this.mImpl.isLongpressEnabled();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mImpl.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean)
  {
    this.mImpl.setIsLongpressEnabled(paramBoolean);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.mImpl.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  static abstract interface GestureDetectorCompatImpl
  {
    public abstract boolean isLongpressEnabled();
    
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract void setIsLongpressEnabled(boolean paramBoolean);
    
    public abstract void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);
  }
  
  static class GestureDetectorCompatImplBase
    implements GestureDetectorCompat.GestureDetectorCompatImpl
  {
    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    private static final int LONGPRESS_TIMEOUT = ;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    MotionEvent mCurrentDownEvent;
    boolean mDeferConfirmSingleTap;
    GestureDetector.OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    final GestureDetector.OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;
    
    GestureDetectorCompatImplBase(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
    {
      if (paramHandler != null) {
        this.mHandler = new GestureHandler(paramHandler);
      } else {
        this.mHandler = new GestureHandler();
      }
      this.mListener = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      init(paramContext);
    }
    
    private void cancel()
    {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      this.mIsDoubleTapping = false;
      this.mStillDown = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mInLongPress) {
        this.mInLongPress = false;
      }
    }
    
    private void cancelTaps()
    {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mIsDoubleTapping = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mInLongPress) {
        this.mInLongPress = false;
      }
    }
    
    private void init(Context paramContext)
    {
      if (paramContext != null)
      {
        if (this.mListener != null)
        {
          this.mIsLongpressEnabled = true;
          paramContext = ViewConfiguration.get(paramContext);
          int i = paramContext.getScaledTouchSlop();
          int j = paramContext.getScaledDoubleTapSlop();
          this.mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
          this.mMaximumFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
          this.mTouchSlopSquare = (i * i);
          this.mDoubleTapSlopSquare = (j * j);
          return;
        }
        throw new IllegalArgumentException("OnGestureListener must not be null");
      }
      throw new IllegalArgumentException("Context must not be null");
    }
    
    private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
    {
      boolean bool2 = this.mAlwaysInBiggerTapRegion;
      boolean bool1 = false;
      if (!bool2) {
        return false;
      }
      if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT) {
        return false;
      }
      int i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      int j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
      if (i * i + j * j < this.mDoubleTapSlopSquare) {
        bool1 = true;
      }
      return bool1;
    }
    
    void dispatchLongPress()
    {
      this.mHandler.removeMessages(3);
      this.mDeferConfirmSingleTap = false;
      this.mInLongPress = true;
      this.mListener.onLongPress(this.mCurrentDownEvent);
    }
    
    public boolean isLongpressEnabled()
    {
      return this.mIsLongpressEnabled;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      int n = i & 0xFF;
      boolean bool3 = false;
      if (n == 6) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (i != 0) {
        j = paramMotionEvent.getActionIndex();
      } else {
        j = -1;
      }
      int m = paramMotionEvent.getPointerCount();
      int k = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (k < m)
      {
        if (j != k)
        {
          f2 += paramMotionEvent.getX(k);
          f1 += paramMotionEvent.getY(k);
        }
        k += 1;
      }
      if (i != 0) {
        i = m - 1;
      } else {
        i = m;
      }
      float f3 = i;
      f2 /= f3;
      f1 /= f3;
      switch (n)
      {
      case 4: 
      default: 
        return false;
      case 6: 
        this.mLastFocusX = f2;
        this.mDownFocusX = f2;
        this.mLastFocusY = f1;
        this.mDownFocusY = f1;
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        j = paramMotionEvent.getActionIndex();
        i = paramMotionEvent.getPointerId(j);
        f1 = this.mVelocityTracker.getXVelocity(i);
        f2 = this.mVelocityTracker.getYVelocity(i);
        i = 0;
        for (;;)
        {
          bool2 = bool3;
          if (i >= m) {
            break;
          }
          if (i != j)
          {
            k = paramMotionEvent.getPointerId(i);
            if (this.mVelocityTracker.getXVelocity(k) * f1 + this.mVelocityTracker.getYVelocity(k) * f2 < 0.0F)
            {
              this.mVelocityTracker.clear();
              return false;
            }
          }
          i += 1;
        }
      case 5: 
        this.mLastFocusX = f2;
        this.mDownFocusX = f2;
        this.mLastFocusY = f1;
        this.mDownFocusY = f1;
        cancelTaps();
        return false;
      case 3: 
        cancel();
        return false;
      case 2: 
        if (this.mInLongPress) {
          return false;
        }
        f3 = this.mLastFocusX - f2;
        float f4 = this.mLastFocusY - f1;
        if (this.mIsDoubleTapping) {
          return false | this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
        }
        if (this.mAlwaysInTapRegion)
        {
          i = (int)(f2 - this.mDownFocusX);
          j = (int)(f1 - this.mDownFocusY);
          i = i * i + j * j;
          if (i > this.mTouchSlopSquare)
          {
            bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
            this.mLastFocusX = f2;
            this.mLastFocusY = f1;
            this.mAlwaysInTapRegion = false;
            this.mHandler.removeMessages(3);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
          }
          else
          {
            bool2 = false;
          }
          bool3 = bool2;
          if (i > this.mTouchSlopSquare)
          {
            this.mAlwaysInBiggerTapRegion = false;
            bool3 = bool2;
          }
        }
        else
        {
          if (Math.abs(f3) < 1.0F)
          {
            bool2 = bool3;
            if (Math.abs(f4) < 1.0F) {
              break label1161;
            }
          }
          bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
          this.mLastFocusX = f2;
          this.mLastFocusY = f1;
          return bool2;
        }
      case 1: 
        this.mStillDown = false;
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.mIsDoubleTapping)
        {
          bool2 = this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
        }
        else
        {
          if (this.mInLongPress)
          {
            this.mHandler.removeMessages(3);
            this.mInLongPress = false;
          }
          else
          {
            if (this.mAlwaysInTapRegion)
            {
              bool2 = this.mListener.onSingleTapUp(paramMotionEvent);
              if ((this.mDeferConfirmSingleTap) && (this.mDoubleTapListener != null)) {
                this.mDoubleTapListener.onSingleTapConfirmed(paramMotionEvent);
              }
              break label828;
            }
            VelocityTracker localVelocityTracker = this.mVelocityTracker;
            i = paramMotionEvent.getPointerId(0);
            localVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            f1 = localVelocityTracker.getYVelocity(i);
            f2 = localVelocityTracker.getXVelocity(i);
            if ((Math.abs(f1) > this.mMinimumFlingVelocity) || (Math.abs(f2) > this.mMinimumFlingVelocity)) {
              break label810;
            }
          }
          bool2 = false;
          break label828;
          label810:
          bool2 = this.mListener.onFling(this.mCurrentDownEvent, paramMotionEvent, f2, f1);
        }
        label828:
        if (this.mPreviousUpEvent != null) {
          this.mPreviousUpEvent.recycle();
        }
        this.mPreviousUpEvent = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.mIsDoubleTapping = false;
        this.mDeferConfirmSingleTap = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        bool3 = bool2;
        return bool3;
      }
      boolean bool1;
      if (this.mDoubleTapListener != null)
      {
        bool2 = this.mHandler.hasMessages(3);
        if (bool2) {
          this.mHandler.removeMessages(3);
        }
        if ((this.mCurrentDownEvent != null) && (this.mPreviousUpEvent != null) && (bool2) && (isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, paramMotionEvent)))
        {
          this.mIsDoubleTapping = true;
          bool1 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
        }
        else
        {
          this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
        }
      }
      else
      {
        bool1 = false;
      }
      this.mLastFocusX = f2;
      this.mDownFocusX = f2;
      this.mLastFocusY = f1;
      this.mDownFocusY = f1;
      if (this.mCurrentDownEvent != null) {
        this.mCurrentDownEvent.recycle();
      }
      this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
      this.mAlwaysInTapRegion = true;
      this.mAlwaysInBiggerTapRegion = true;
      this.mStillDown = true;
      this.mInLongPress = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mIsLongpressEnabled)
      {
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
      }
      this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
      boolean bool2 = bool1 | this.mListener.onDown(paramMotionEvent);
      label1161:
      return bool2;
    }
    
    public void setIsLongpressEnabled(boolean paramBoolean)
    {
      this.mIsLongpressEnabled = paramBoolean;
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
    {
      this.mDoubleTapListener = paramOnDoubleTapListener;
    }
    
    private class GestureHandler
      extends Handler
    {
      GestureHandler() {}
      
      GestureHandler(Handler paramHandler)
      {
        super();
      }
      
      public void handleMessage(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown message ");
          localStringBuilder.append(paramMessage);
          throw new RuntimeException(localStringBuilder.toString());
        case 3: 
          if (GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener != null)
          {
            if (!GestureDetectorCompat.GestureDetectorCompatImplBase.this.mStillDown)
            {
              GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
              return;
            }
            GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
            return;
          }
          break;
        case 2: 
          GestureDetectorCompat.GestureDetectorCompatImplBase.this.dispatchLongPress();
          return;
        case 1: 
          GestureDetectorCompat.GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
        }
      }
    }
  }
  
  static class GestureDetectorCompatImplJellybeanMr2
    implements GestureDetectorCompat.GestureDetectorCompatImpl
  {
    private final GestureDetector mDetector;
    
    GestureDetectorCompatImplJellybeanMr2(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
    {
      this.mDetector = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
    }
    
    public boolean isLongpressEnabled()
    {
      return this.mDetector.isLongpressEnabled();
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return this.mDetector.onTouchEvent(paramMotionEvent);
    }
    
    public void setIsLongpressEnabled(boolean paramBoolean)
    {
      this.mDetector.setIsLongpressEnabled(paramBoolean);
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
    {
      this.mDetector.setOnDoubleTapListener(paramOnDoubleTapListener);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\GestureDetectorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */