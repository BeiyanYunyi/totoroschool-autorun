package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import java.util.ArrayList;
import java.util.List;

public class GLAnimationSet
  extends GLAnimation
{
  private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
  private static final int PROPERTY_DURATION_MASK = 32;
  private static final int PROPERTY_FILL_AFTER_MASK = 1;
  private static final int PROPERTY_FILL_BEFORE_MASK = 2;
  private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
  private static final int PROPERTY_REPEAT_MODE_MASK = 4;
  private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
  private static final int PROPERTY_START_OFFSET_MASK = 8;
  private ArrayList<GLAnimation> mAnimations = new ArrayList();
  private boolean mDirty;
  private int mFlags = 0;
  private boolean mHasAlpha;
  private long mLastEnd;
  private GLTransformation mTempTransformation = new GLTransformation();
  
  public GLAnimationSet(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    init();
  }
  
  private void init()
  {
    this.mStartTime = 0L;
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlags = (paramInt | this.mFlags);
      return;
    }
    this.mFlags = ((paramInt ^ 0xFFFFFFFF) & this.mFlags);
  }
  
  public void addAnimation(Animation paramAnimation)
  {
    this.mAnimations.add(paramAnimation.glAnimation);
    int i = this.mFlags;
    int j = 0;
    if ((i & 0x40) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramAnimation.glAnimation.willChangeTransformationMatrix())) {
      this.mFlags |= 0x40;
    }
    i = j;
    if ((this.mFlags & 0x80) == 0) {
      i = 1;
    }
    if ((i != 0) && (paramAnimation.glAnimation.willChangeBounds())) {
      this.mFlags |= 0x80;
    }
    if ((this.mFlags & 0x20) == 32)
    {
      this.mLastEnd = (this.mStartOffset + this.mDuration);
    }
    else if (this.mAnimations.size() == 1)
    {
      this.mDuration = (paramAnimation.glAnimation.getStartOffset() + paramAnimation.glAnimation.getDuration());
      this.mLastEnd = (this.mStartOffset + this.mDuration);
    }
    else
    {
      this.mLastEnd = Math.max(this.mLastEnd, paramAnimation.glAnimation.getStartOffset() + paramAnimation.glAnimation.getDuration());
      this.mDuration = (this.mLastEnd - this.mStartOffset);
    }
    this.mDirty = true;
  }
  
  public void cleanAnimation()
  {
    this.mAnimations.clear();
  }
  
  public GLAnimationSet clone()
    throws CloneNotSupportedException
  {
    GLAnimationSet localGLAnimationSet = (GLAnimationSet)super.clone();
    localGLAnimationSet.mTempTransformation = new GLTransformation();
    localGLAnimationSet.mAnimations = new ArrayList();
    int j = this.mAnimations.size();
    ArrayList localArrayList = this.mAnimations;
    int i = 0;
    while (i < j)
    {
      localGLAnimationSet.mAnimations.add(((GLAnimation)localArrayList.get(i)).clone());
      i += 1;
    }
    return localGLAnimationSet;
  }
  
  public long computeDurationHint()
  {
    int i = this.mAnimations.size();
    ArrayList localArrayList = this.mAnimations;
    i -= 1;
    long l2;
    for (long l1 = 0L; i >= 0; l1 = l2)
    {
      long l3 = ((GLAnimation)localArrayList.get(i)).computeDurationHint();
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      i -= 1;
    }
    return l1;
  }
  
  public List<GLAnimation> getAnimations()
  {
    return this.mAnimations;
  }
  
  public long getDuration()
  {
    ArrayList localArrayList = this.mAnimations;
    int k = localArrayList.size();
    int i = this.mFlags;
    int j = 0;
    if ((i & 0x20) == 32) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return this.mDuration;
    }
    long l = 0L;
    i = j;
    while (i < k)
    {
      l = Math.max(l, ((GLAnimation)localArrayList.get(i)).getDuration());
      i += 1;
    }
    return l;
  }
  
  public long getStartTime()
  {
    int j = this.mAnimations.size();
    ArrayList localArrayList = this.mAnimations;
    long l = Long.MAX_VALUE;
    int i = 0;
    while (i < j)
    {
      l = Math.min(l, ((GLAnimation)localArrayList.get(i)).getStartTime());
      i += 1;
    }
    return l;
  }
  
  public boolean getTransformation(long paramLong, GLTransformation paramGLTransformation)
  {
    if (!this.mInitialized) {
      initialize();
    }
    int i = this.mAnimations.size();
    ArrayList localArrayList = this.mAnimations;
    GLTransformation localGLTransformation = this.mTempTransformation;
    paramGLTransformation.clear();
    int j = i - 1;
    i = 0;
    boolean bool1 = false;
    boolean bool2 = true;
    while (j >= 0)
    {
      GLAnimation localGLAnimation = (GLAnimation)localArrayList.get(j);
      localGLTransformation.clear();
      if ((!localGLAnimation.getTransformation(paramLong, paramGLTransformation, getScaleFactor())) && (!bool1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if ((i == 0) && (!localGLAnimation.hasStarted())) {
        i = 0;
      } else {
        i = 1;
      }
      if ((localGLAnimation.hasEnded()) && (bool2)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      j -= 1;
    }
    if (i != 0) {}
    try
    {
      if (!this.mStarted)
      {
        if (this.mListener != null) {
          this.mListener.onAnimationStart();
        }
        this.mStarted = true;
      }
      if (bool2 == this.mEnded) {
        break label234;
      }
      if (this.mListener != null) {
        this.mListener.onAnimationEnd();
      }
      this.mEnded = bool2;
      return bool1;
    }
    catch (Throwable paramGLTransformation)
    {
      for (;;) {}
    }
    paramGLTransformation.printStackTrace();
    label234:
    return bool1;
  }
  
  public boolean hasAlpha()
  {
    if (this.mDirty)
    {
      int i = 0;
      this.mHasAlpha = false;
      this.mDirty = false;
      int j = this.mAnimations.size();
      ArrayList localArrayList = this.mAnimations;
      while (i < j)
      {
        if (((GLAnimation)localArrayList.get(i)).hasAlpha())
        {
          this.mHasAlpha = true;
          break;
        }
        i += 1;
      }
    }
    return this.mHasAlpha;
  }
  
  public void initialize()
  {
    super.initialize();
    int i = this.mFlags;
    int i1 = 1;
    if ((i & 0x20) == 32) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((this.mFlags & 0x1) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((this.mFlags & 0x2) == 2) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if ((this.mFlags & 0x4) == 4) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((this.mFlags & 0x10) == 16) {
      n = 1;
    } else {
      n = 0;
    }
    if ((this.mFlags & 0x8) != 8) {
      i1 = 0;
    }
    if (n != 0) {
      ensureInterpolator();
    }
    ArrayList localArrayList = this.mAnimations;
    int i3 = localArrayList.size();
    long l1 = this.mDuration;
    boolean bool1 = this.mFillAfter;
    boolean bool2 = this.mFillBefore;
    int i4 = this.mRepeatMode;
    Interpolator localInterpolator = this.mInterpolator;
    long l2 = this.mStartOffset;
    int i2 = 0;
    while (i2 < i3)
    {
      GLAnimation localGLAnimation = (GLAnimation)localArrayList.get(i2);
      if (i != 0) {
        localGLAnimation.setDuration(l1);
      }
      if (j != 0) {
        localGLAnimation.setFillAfter(bool1);
      }
      if (k != 0) {
        localGLAnimation.setFillBefore(bool2);
      }
      if (m != 0) {
        localGLAnimation.setRepeatMode(i4);
      }
      if (n != 0) {
        localGLAnimation.setInterpolator(localInterpolator);
      }
      if (i1 != 0) {
        localGLAnimation.setStartOffset(localGLAnimation.getStartOffset() + l2);
      }
      localGLAnimation.initialize();
      i2 += 1;
    }
  }
  
  public void reset()
  {
    super.reset();
  }
  
  public void restrictDuration(long paramLong)
  {
    super.restrictDuration(paramLong);
    ArrayList localArrayList = this.mAnimations;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((GLAnimation)localArrayList.get(i)).restrictDuration(paramLong);
      i += 1;
    }
  }
  
  public void scaleCurrentDuration(float paramFloat)
  {
    ArrayList localArrayList = this.mAnimations;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((GLAnimation)localArrayList.get(i)).scaleCurrentDuration(paramFloat);
      i += 1;
    }
  }
  
  public void setDuration(long paramLong)
  {
    this.mFlags |= 0x20;
    super.setDuration(paramLong);
    this.mLastEnd = (this.mStartOffset + this.mDuration);
  }
  
  public void setFillAfter(boolean paramBoolean)
  {
    this.mFlags |= 0x1;
    super.setFillAfter(paramBoolean);
  }
  
  public void setFillBefore(boolean paramBoolean)
  {
    this.mFlags |= 0x2;
    super.setFillBefore(paramBoolean);
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.mFlags |= 0x4;
    super.setRepeatMode(paramInt);
  }
  
  public void setStartOffset(long paramLong)
  {
    this.mFlags |= 0x8;
    super.setStartOffset(paramLong);
  }
  
  public void setStartTime(long paramLong)
  {
    super.setStartTime(paramLong);
    int j = this.mAnimations.size();
    ArrayList localArrayList = this.mAnimations;
    int i = 0;
    while (i < j)
    {
      ((GLAnimation)localArrayList.get(i)).setStartTime(paramLong);
      i += 1;
    }
  }
  
  public boolean willChangeBounds()
  {
    return (this.mFlags & 0x80) == 128;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return (this.mFlags & 0x40) == 64;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLAnimationSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */