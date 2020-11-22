package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;

public class GLAnimation
  implements Cloneable
{
  public static final int ABSOLUTE = 0;
  public static final int INFINITE = -1;
  public static final int RELATIVE_TO_PARENT = 2;
  public static final int RELATIVE_TO_SELF = 1;
  public static final int RESTART = 1;
  public static final int REVERSE = 2;
  public static final int START_ON_FIRST_FRAME = -1;
  public static final int ZORDER_BOTTOM = -1;
  public static final int ZORDER_NORMAL = 0;
  public static final int ZORDER_TOP = 1;
  private int mBackgroundColor;
  boolean mCycleFlip = false;
  private boolean mDetachWallpaper = false;
  long mDuration = 500L;
  boolean mEnded = false;
  boolean mFillAfter = false;
  boolean mFillBefore = true;
  boolean mFillEnabled = false;
  boolean mInitialized = false;
  Interpolator mInterpolator;
  Animation.AnimationListener mListener;
  private Handler mListenerHandler;
  private boolean mMore = true;
  private Runnable mOnEnd;
  private Runnable mOnStart;
  private boolean mOneMoreTime = true;
  RectF mPreviousRegion = new RectF();
  GLTransformation mPreviousTransformation = new GLTransformation();
  RectF mRegion = new RectF();
  int mRepeatCount = 0;
  int mRepeatMode = 1;
  int mRepeated = 0;
  private float mScaleFactor = 1.0F;
  long mStartOffset;
  long mStartTime = -1L;
  boolean mStarted = false;
  private int mZAdjustment;
  
  public GLAnimation()
  {
    try
    {
      ensureInterpolator();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void fireAnimationEnd()
  {
    if (this.mListener != null)
    {
      if (this.mListenerHandler == null)
      {
        this.mListener.onAnimationEnd();
        return;
      }
      this.mListenerHandler.postAtFrontOfQueue(this.mOnEnd);
    }
  }
  
  private void fireAnimationRepeat() {}
  
  private void fireAnimationStart()
  {
    if (this.mListener != null)
    {
      if (this.mListenerHandler == null)
      {
        this.mListener.onAnimationStart();
        return;
      }
      this.mListenerHandler.postAtFrontOfQueue(this.mOnStart);
    }
  }
  
  protected void applyTransformation(float paramFloat, GLTransformation paramGLTransformation) {}
  
  public void cancel()
  {
    if ((this.mStarted) && (!this.mEnded))
    {
      fireAnimationEnd();
      this.mEnded = true;
    }
    this.mStartTime = Long.MIN_VALUE;
    this.mOneMoreTime = false;
    this.mMore = false;
  }
  
  public GLAnimation clone()
    throws CloneNotSupportedException
  {
    GLAnimation localGLAnimation = (GLAnimation)super.clone();
    localGLAnimation.mPreviousRegion = new RectF();
    localGLAnimation.mRegion = new RectF();
    localGLAnimation.mPreviousTransformation = new GLTransformation();
    return localGLAnimation;
  }
  
  public long computeDurationHint()
  {
    return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
  }
  
  public void detach()
  {
    if ((this.mStarted) && (!this.mEnded))
    {
      this.mEnded = true;
      fireAnimationEnd();
    }
  }
  
  protected void ensureInterpolator()
  {
    if (this.mInterpolator == null) {
      this.mInterpolator = new AccelerateDecelerateInterpolator();
    }
  }
  
  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }
  
  public boolean getDetachWallpaper()
  {
    return this.mDetachWallpaper;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public boolean getFillAfter()
  {
    return this.mFillAfter;
  }
  
  public boolean getFillBefore()
  {
    return this.mFillBefore;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public void getInvalidateRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4, RectF paramRectF, Transformation paramTransformation)
  {
    RectF localRectF1 = this.mRegion;
    RectF localRectF2 = this.mPreviousRegion;
    paramRectF.set(paramInt1, paramInt2, paramInt3, paramInt4);
    paramTransformation.getMatrix().mapRect(paramRectF);
    paramRectF.inset(-1.0F, -1.0F);
    localRectF1.set(paramRectF);
    paramRectF.union(localRectF2);
    localRectF2.set(localRectF1);
  }
  
  public int getRepeatCount()
  {
    return this.mRepeatCount;
  }
  
  public int getRepeatMode()
  {
    return this.mRepeatMode;
  }
  
  protected float getScaleFactor()
  {
    return this.mScaleFactor;
  }
  
  public long getStartOffset()
  {
    return this.mStartOffset;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public boolean getTransformation(long paramLong, GLTransformation paramGLTransformation)
  {
    if (this.mStartTime == -1L) {
      this.mStartTime = paramLong;
    }
    long l1 = getStartOffset();
    long l2 = this.mDuration;
    float f1;
    if (l2 != 0L) {
      f1 = (float)(paramLong - (this.mStartTime + l1)) / (float)l2;
    } else if (paramLong < this.mStartTime) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    int i;
    if (f1 >= 1.0F) {
      i = 1;
    } else {
      i = 0;
    }
    this.mMore = (i ^ 0x1);
    float f2 = f1;
    if (!this.mFillEnabled) {
      f2 = Math.max(Math.min(f1, 1.0F), 0.0F);
    }
    int j;
    if (((f2 < 0.0F) && (!this.mFillBefore)) || ((f2 > 1.0F) && (!this.mFillAfter))) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0)
    {
      if (!this.mStarted)
      {
        try
        {
          fireAnimationStart();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        this.mStarted = true;
      }
      f1 = f2;
      if (this.mFillEnabled) {
        f1 = Math.max(Math.min(f2, 1.0F), 0.0F);
      }
      f2 = f1;
      if (this.mCycleFlip) {
        f2 = 1.0F - f1;
      }
      applyTransformation(this.mInterpolator.getInterpolation(f2), paramGLTransformation);
    }
    if (i != 0) {
      if (this.mRepeatCount == this.mRepeated)
      {
        if (!this.mEnded)
        {
          this.mEnded = true;
          fireAnimationEnd();
        }
      }
      else
      {
        if (this.mRepeatCount > 0) {
          this.mRepeated += 1;
        }
        if (this.mRepeatMode == 2) {
          this.mCycleFlip ^= true;
        }
        this.mStartTime = -1L;
        this.mMore = true;
        fireAnimationRepeat();
      }
    }
    if ((!this.mMore) && (this.mOneMoreTime))
    {
      this.mOneMoreTime = false;
      return true;
    }
    return this.mMore;
  }
  
  public boolean getTransformation(long paramLong, GLTransformation paramGLTransformation, float paramFloat)
  {
    this.mScaleFactor = paramFloat;
    return getTransformation(paramLong, paramGLTransformation);
  }
  
  public int getZAdjustment()
  {
    return this.mZAdjustment;
  }
  
  public boolean hasAlpha()
  {
    return false;
  }
  
  public boolean hasEnded()
  {
    return this.mEnded;
  }
  
  protected boolean hasStarted()
  {
    return this.mStarted;
  }
  
  public void initialize()
  {
    reset();
    this.mInitialized = true;
  }
  
  public void initializeInvalidateRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mPreviousRegion;
    ((RectF)localObject).set(paramInt1, paramInt2, paramInt3, paramInt4);
    ((RectF)localObject).inset(-1.0F, -1.0F);
    if (this.mFillBefore)
    {
      localObject = this.mPreviousTransformation;
      applyTransformation(this.mInterpolator.getInterpolation(0.0F), (GLTransformation)localObject);
    }
  }
  
  public boolean isFillEnabled()
  {
    return this.mFillEnabled;
  }
  
  public boolean isInitialized()
  {
    return this.mInitialized;
  }
  
  public void reset()
  {
    this.mPreviousRegion.setEmpty();
    this.mPreviousTransformation.clear();
    this.mInitialized = false;
    this.mCycleFlip = false;
    this.mRepeated = 0;
    this.mMore = true;
    this.mOneMoreTime = true;
    this.mListenerHandler = null;
  }
  
  protected float resolveSize(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      return paramFloat;
    case 2: 
      return paramInt3 * paramFloat;
    case 1: 
      return paramInt2 * paramFloat;
    }
    return paramFloat;
  }
  
  public void restrictDuration(long paramLong)
  {
    if (this.mStartOffset > paramLong)
    {
      this.mStartOffset = paramLong;
      this.mDuration = 0L;
      this.mRepeatCount = 0;
      return;
    }
    long l2 = this.mDuration + this.mStartOffset;
    long l1 = l2;
    if (l2 > paramLong)
    {
      this.mDuration = (paramLong - this.mStartOffset);
      l1 = paramLong;
    }
    if (this.mDuration <= 0L)
    {
      this.mDuration = 0L;
      this.mRepeatCount = 0;
      return;
    }
    if ((this.mRepeatCount < 0) || (this.mRepeatCount > paramLong) || (this.mRepeatCount * l1 > paramLong))
    {
      this.mRepeatCount = ((int)(paramLong / l1) - 1);
      if (this.mRepeatCount < 0) {
        this.mRepeatCount = 0;
      }
    }
  }
  
  public void scaleCurrentDuration(float paramFloat)
  {
    this.mDuration = (((float)this.mDuration * paramFloat));
    this.mStartOffset = (((float)this.mStartOffset * paramFloat));
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.mListener = paramAnimationListener;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public void setDetachWallpaper(boolean paramBoolean)
  {
    this.mDetachWallpaper = paramBoolean;
  }
  
  public void setDuration(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.mDuration = l;
  }
  
  public void setFillAfter(boolean paramBoolean)
  {
    this.mFillAfter = paramBoolean;
  }
  
  public void setFillBefore(boolean paramBoolean)
  {
    this.mFillBefore = paramBoolean;
  }
  
  public void setFillEnabled(boolean paramBoolean)
  {
    this.mFillEnabled = paramBoolean;
  }
  
  public void setInterpolator(Context paramContext, int paramInt)
  {
    setInterpolator(AnimationUtils.loadInterpolator(paramContext, paramInt));
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public void setListenerHandler(Handler paramHandler)
  {
    if (this.mListenerHandler == null)
    {
      this.mOnStart = new Runnable()
      {
        public void run()
        {
          if (GLAnimation.this.mListener != null) {
            try
            {
              GLAnimation.this.mListener.onAnimationStart();
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      };
      this.mOnEnd = new Runnable()
      {
        public void run()
        {
          if (GLAnimation.this.mListener != null) {
            try
            {
              GLAnimation.this.mListener.onAnimationEnd();
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      };
    }
    this.mListenerHandler = paramHandler;
  }
  
  public void setRepeatCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -1;
    }
    this.mRepeatCount = i;
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.mRepeatMode = paramInt;
  }
  
  public void setStartOffset(long paramLong)
  {
    this.mStartOffset = paramLong;
  }
  
  public void setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
    this.mEnded = false;
    this.mStarted = false;
    this.mCycleFlip = false;
    this.mRepeated = 0;
    this.mMore = true;
  }
  
  public void setZAdjustment(int paramInt)
  {
    this.mZAdjustment = paramInt;
  }
  
  public void start()
  {
    setStartTime(-1L);
  }
  
  public void startNow()
  {
    setStartTime(AnimationUtils.currentAnimationTimeMillis());
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */