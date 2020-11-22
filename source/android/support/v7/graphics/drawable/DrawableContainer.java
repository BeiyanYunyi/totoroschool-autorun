package android.support.v7.graphics.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.DisplayMetrics;
import android.util.SparseArray;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private static final boolean DEBUG = false;
  private static final boolean DEFAULT_DITHER = true;
  private static final String TAG = "DrawableContainer";
  private int mAlpha = 255;
  private Runnable mAnimationRunnable;
  private BlockInvalidateCallback mBlockInvalidateCallback;
  private int mCurIndex = -1;
  private Drawable mCurrDrawable;
  private DrawableContainerState mDrawableContainerState;
  private long mEnterAnimationEnd;
  private long mExitAnimationEnd;
  private boolean mHasAlpha;
  private Rect mHotspotBounds;
  private Drawable mLastDrawable;
  private int mLastIndex = -1;
  private boolean mMutated;
  
  private void initializeDrawableForDisplay(Drawable paramDrawable)
  {
    if (this.mBlockInvalidateCallback == null) {
      this.mBlockInvalidateCallback = new BlockInvalidateCallback();
    }
    paramDrawable.setCallback(this.mBlockInvalidateCallback.wrap(paramDrawable.getCallback()));
    try
    {
      if ((this.mDrawableContainerState.mEnterFadeDuration <= 0) && (this.mHasAlpha)) {
        paramDrawable.setAlpha(this.mAlpha);
      }
      if (this.mDrawableContainerState.mHasColorFilter)
      {
        paramDrawable.setColorFilter(this.mDrawableContainerState.mColorFilter);
      }
      else
      {
        if (this.mDrawableContainerState.mHasTintList) {
          DrawableCompat.setTintList(paramDrawable, this.mDrawableContainerState.mTintList);
        }
        if (this.mDrawableContainerState.mHasTintMode) {
          DrawableCompat.setTintMode(paramDrawable, this.mDrawableContainerState.mTintMode);
        }
      }
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setDither(this.mDrawableContainerState.mDither);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setBounds(getBounds());
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(getLayoutDirection());
      }
      if (Build.VERSION.SDK_INT >= 19) {
        paramDrawable.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
      }
      Rect localRect = this.mHotspotBounds;
      if ((Build.VERSION.SDK_INT >= 21) && (localRect != null)) {
        paramDrawable.setHotspotBounds(localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
      return;
    }
    finally
    {
      paramDrawable.setCallback(this.mBlockInvalidateCallback.unwrap());
    }
  }
  
  @SuppressLint({"WrongConstant"})
  @TargetApi(23)
  private boolean needsMirroring()
  {
    return (isAutoMirrored()) && (getLayoutDirection() == 1);
  }
  
  static int resolveDensity(@Nullable Resources paramResources, int paramInt)
  {
    if (paramResources != null) {
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 160;
    }
    return i;
  }
  
  void animate(boolean paramBoolean)
  {
    int j = 1;
    this.mHasAlpha = true;
    long l = SystemClock.uptimeMillis();
    if (this.mCurrDrawable != null)
    {
      if (this.mEnterAnimationEnd != 0L) {
        if (this.mEnterAnimationEnd <= l)
        {
          this.mCurrDrawable.setAlpha(this.mAlpha);
          this.mEnterAnimationEnd = 0L;
        }
        else
        {
          i = (int)((this.mEnterAnimationEnd - l) * 255L) / this.mDrawableContainerState.mEnterFadeDuration;
          this.mCurrDrawable.setAlpha((255 - i) * this.mAlpha / 255);
          i = 1;
          break label111;
        }
      }
    }
    else {
      this.mEnterAnimationEnd = 0L;
    }
    int i = 0;
    label111:
    if (this.mLastDrawable != null)
    {
      if (this.mExitAnimationEnd != 0L) {
        if (this.mExitAnimationEnd <= l)
        {
          this.mLastDrawable.setVisible(false, false);
          this.mLastDrawable = null;
          this.mLastIndex = -1;
          this.mExitAnimationEnd = 0L;
        }
        else
        {
          i = (int)((this.mExitAnimationEnd - l) * 255L) / this.mDrawableContainerState.mExitFadeDuration;
          this.mLastDrawable.setAlpha(i * this.mAlpha / 255);
          i = j;
        }
      }
    }
    else {
      this.mExitAnimationEnd = 0L;
    }
    if ((paramBoolean) && (i != 0)) {
      scheduleSelf(this.mAnimationRunnable, l + 16L);
    }
  }
  
  @RequiresApi(21)
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    this.mDrawableContainerState.applyTheme(paramTheme);
  }
  
  @RequiresApi(21)
  public boolean canApplyTheme()
  {
    return this.mDrawableContainerState.canApplyTheme();
  }
  
  void clearMutated()
  {
    this.mDrawableContainerState.clearMutated();
    this.mMutated = false;
  }
  
  DrawableContainerState cloneConstantState()
  {
    return this.mDrawableContainerState;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.draw(paramCanvas);
    }
    if (this.mLastDrawable != null) {
      this.mLastDrawable.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.mDrawableContainerState.canConstantState())
    {
      this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
      return this.mDrawableContainerState;
    }
    return null;
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    return this.mCurrDrawable;
  }
  
  int getCurrentIndex()
  {
    return this.mCurIndex;
  }
  
  public void getHotspotBounds(@NonNull Rect paramRect)
  {
    if (this.mHotspotBounds != null)
    {
      paramRect.set(this.mHotspotBounds);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantHeight();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantWidth();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumHeight();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumWidth();
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    if ((this.mCurrDrawable != null) && (this.mCurrDrawable.isVisible())) {
      return this.mDrawableContainerState.getOpacity();
    }
    return -2;
  }
  
  @RequiresApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    Rect localRect = this.mDrawableContainerState.getConstantPadding();
    int i;
    boolean bool;
    if (localRect != null)
    {
      paramRect.set(localRect);
      i = localRect.left;
      int j = localRect.top;
      int k = localRect.bottom;
      if ((localRect.right | i | j | k) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else if (this.mCurrDrawable != null)
    {
      bool = this.mCurrDrawable.getPadding(paramRect);
    }
    else
    {
      bool = super.getPadding(paramRect);
    }
    if (needsMirroring())
    {
      i = paramRect.left;
      paramRect.left = paramRect.right;
      paramRect.right = i;
    }
    return bool;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (this.mDrawableContainerState != null) {
      this.mDrawableContainerState.invalidateCache();
    }
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.mDrawableContainerState.mAutoMirrored;
  }
  
  public boolean isStateful()
  {
    return this.mDrawableContainerState.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    int i;
    if (this.mLastDrawable != null)
    {
      this.mLastDrawable.jumpToCurrentState();
      this.mLastDrawable = null;
      this.mLastIndex = -1;
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (this.mCurrDrawable != null)
    {
      this.mCurrDrawable.jumpToCurrentState();
      if (this.mHasAlpha) {
        this.mCurrDrawable.setAlpha(this.mAlpha);
      }
    }
    if (this.mExitAnimationEnd != 0L)
    {
      this.mExitAnimationEnd = 0L;
      i = 1;
    }
    if (this.mEnterAnimationEnd != 0L)
    {
      this.mEnterAnimationEnd = 0L;
      i = 1;
    }
    if (i != 0) {
      invalidateSelf();
    }
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      DrawableContainerState localDrawableContainerState = cloneConstantState();
      localDrawableContainerState.mutate();
      setConstantState(localDrawableContainerState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mLastDrawable != null) {
      this.mLastDrawable.setBounds(paramRect);
    }
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    return this.mDrawableContainerState.setLayoutDirection(paramInt, getCurrentIndex());
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mLastDrawable != null) {
      return this.mLastDrawable.setLevel(paramInt);
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mLastDrawable != null) {
      return this.mLastDrawable.setState(paramArrayOfInt);
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.mCurIndex) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.mDrawableContainerState.mExitFadeDuration > 0)
    {
      if (this.mLastDrawable != null) {
        this.mLastDrawable.setVisible(false, false);
      }
      if (this.mCurrDrawable != null)
      {
        this.mLastDrawable = this.mCurrDrawable;
        this.mLastIndex = this.mCurIndex;
        this.mExitAnimationEnd = (this.mDrawableContainerState.mExitFadeDuration + l);
      }
      else
      {
        this.mLastDrawable = null;
        this.mLastIndex = -1;
        this.mExitAnimationEnd = 0L;
      }
    }
    else if (this.mCurrDrawable != null)
    {
      this.mCurrDrawable.setVisible(false, false);
    }
    if ((paramInt >= 0) && (paramInt < this.mDrawableContainerState.mNumChildren))
    {
      Drawable localDrawable = this.mDrawableContainerState.getChild(paramInt);
      this.mCurrDrawable = localDrawable;
      this.mCurIndex = paramInt;
      if (localDrawable != null)
      {
        if (this.mDrawableContainerState.mEnterFadeDuration > 0) {
          this.mEnterAnimationEnd = (l + this.mDrawableContainerState.mEnterFadeDuration);
        }
        initializeDrawableForDisplay(localDrawable);
      }
    }
    else
    {
      this.mCurrDrawable = null;
      this.mCurIndex = -1;
    }
    if ((this.mEnterAnimationEnd != 0L) || (this.mExitAnimationEnd != 0L))
    {
      if (this.mAnimationRunnable == null) {
        this.mAnimationRunnable = new Runnable()
        {
          public void run()
          {
            DrawableContainer.this.animate(true);
            DrawableContainer.this.invalidateSelf();
          }
        };
      } else {
        unscheduleSelf(this.mAnimationRunnable);
      }
      animate(true);
    }
    invalidateSelf();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.mHasAlpha) || (this.mAlpha != paramInt))
    {
      this.mHasAlpha = true;
      this.mAlpha = paramInt;
      if (this.mCurrDrawable != null)
      {
        if (this.mEnterAnimationEnd == 0L)
        {
          this.mCurrDrawable.setAlpha(paramInt);
          return;
        }
        animate(false);
      }
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mAutoMirrored != paramBoolean)
    {
      this.mDrawableContainerState.mAutoMirrored = paramBoolean;
      if (this.mCurrDrawable != null) {
        DrawableCompat.setAutoMirrored(this.mCurrDrawable, this.mDrawableContainerState.mAutoMirrored);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableContainerState.mHasColorFilter = true;
    if (this.mDrawableContainerState.mColorFilter != paramColorFilter)
    {
      this.mDrawableContainerState.mColorFilter = paramColorFilter;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setColorFilter(paramColorFilter);
      }
    }
  }
  
  protected void setConstantState(DrawableContainerState paramDrawableContainerState)
  {
    this.mDrawableContainerState = paramDrawableContainerState;
    if (this.mCurIndex >= 0)
    {
      this.mCurrDrawable = paramDrawableContainerState.getChild(this.mCurIndex);
      if (this.mCurrDrawable != null) {
        initializeDrawableForDisplay(this.mCurrDrawable);
      }
    }
    this.mLastIndex = -1;
    this.mLastDrawable = null;
  }
  
  void setCurrentIndex(int paramInt)
  {
    selectDrawable(paramInt);
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mDither != paramBoolean)
    {
      this.mDrawableContainerState.mDither = paramBoolean;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
      }
    }
  }
  
  public void setEnterFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mEnterFadeDuration = paramInt;
  }
  
  public void setExitFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mExitFadeDuration = paramInt;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.mCurrDrawable != null) {
      DrawableCompat.setHotspot(this.mCurrDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mHotspotBounds == null) {
      this.mHotspotBounds = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      this.mHotspotBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.mCurrDrawable != null) {
      DrawableCompat.setHotspotBounds(this.mCurrDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.mDrawableContainerState.mHasTintList = true;
    if (this.mDrawableContainerState.mTintList != paramColorStateList)
    {
      this.mDrawableContainerState.mTintList = paramColorStateList;
      DrawableCompat.setTintList(this.mCurrDrawable, paramColorStateList);
    }
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    this.mDrawableContainerState.mHasTintMode = true;
    if (this.mDrawableContainerState.mTintMode != paramMode)
    {
      this.mDrawableContainerState.mTintMode = paramMode;
      DrawableCompat.setTintMode(this.mCurrDrawable, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.mLastDrawable != null) {
      this.mLastDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  final void updateDensity(Resources paramResources)
  {
    this.mDrawableContainerState.updateDensity(paramResources);
  }
  
  static class BlockInvalidateCallback
    implements Drawable.Callback
  {
    private Drawable.Callback mCallback;
    
    public void invalidateDrawable(@NonNull Drawable paramDrawable) {}
    
    public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
    {
      if (this.mCallback != null) {
        this.mCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
    {
      if (this.mCallback != null) {
        this.mCallback.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
    
    public Drawable.Callback unwrap()
    {
      Drawable.Callback localCallback = this.mCallback;
      this.mCallback = null;
      return localCallback;
    }
    
    public BlockInvalidateCallback wrap(Drawable.Callback paramCallback)
    {
      this.mCallback = paramCallback;
      return this;
    }
  }
  
  static abstract class DrawableContainerState
    extends Drawable.ConstantState
  {
    boolean mAutoMirrored;
    boolean mCanConstantState;
    int mChangingConfigurations;
    boolean mCheckedConstantSize;
    boolean mCheckedConstantState;
    boolean mCheckedOpacity;
    boolean mCheckedPadding;
    boolean mCheckedStateful;
    int mChildrenChangingConfigurations;
    ColorFilter mColorFilter;
    int mConstantHeight;
    int mConstantMinimumHeight;
    int mConstantMinimumWidth;
    Rect mConstantPadding;
    boolean mConstantSize;
    int mConstantWidth;
    int mDensity = 160;
    boolean mDither;
    SparseArray<Drawable.ConstantState> mDrawableFutures;
    Drawable[] mDrawables;
    int mEnterFadeDuration;
    int mExitFadeDuration;
    boolean mHasColorFilter;
    boolean mHasTintList;
    boolean mHasTintMode;
    int mLayoutDirection;
    boolean mMutated;
    int mNumChildren;
    int mOpacity;
    final DrawableContainer mOwner;
    Resources mSourceRes;
    boolean mStateful;
    ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    boolean mVariablePadding;
    
    DrawableContainerState(DrawableContainerState paramDrawableContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
    {
      int j = 0;
      this.mVariablePadding = false;
      this.mConstantSize = false;
      this.mDither = true;
      this.mEnterFadeDuration = 0;
      this.mExitFadeDuration = 0;
      this.mOwner = paramDrawableContainer;
      if (paramResources != null) {
        paramDrawableContainer = paramResources;
      } else if (paramDrawableContainerState != null) {
        paramDrawableContainer = paramDrawableContainerState.mSourceRes;
      } else {
        paramDrawableContainer = null;
      }
      this.mSourceRes = paramDrawableContainer;
      int i;
      if (paramDrawableContainerState != null) {
        i = paramDrawableContainerState.mDensity;
      } else {
        i = 0;
      }
      this.mDensity = DrawableContainer.resolveDensity(paramResources, i);
      if (paramDrawableContainerState != null)
      {
        this.mChangingConfigurations = paramDrawableContainerState.mChangingConfigurations;
        this.mChildrenChangingConfigurations = paramDrawableContainerState.mChildrenChangingConfigurations;
        this.mCheckedConstantState = true;
        this.mCanConstantState = true;
        this.mVariablePadding = paramDrawableContainerState.mVariablePadding;
        this.mConstantSize = paramDrawableContainerState.mConstantSize;
        this.mDither = paramDrawableContainerState.mDither;
        this.mMutated = paramDrawableContainerState.mMutated;
        this.mLayoutDirection = paramDrawableContainerState.mLayoutDirection;
        this.mEnterFadeDuration = paramDrawableContainerState.mEnterFadeDuration;
        this.mExitFadeDuration = paramDrawableContainerState.mExitFadeDuration;
        this.mAutoMirrored = paramDrawableContainerState.mAutoMirrored;
        this.mColorFilter = paramDrawableContainerState.mColorFilter;
        this.mHasColorFilter = paramDrawableContainerState.mHasColorFilter;
        this.mTintList = paramDrawableContainerState.mTintList;
        this.mTintMode = paramDrawableContainerState.mTintMode;
        this.mHasTintList = paramDrawableContainerState.mHasTintList;
        this.mHasTintMode = paramDrawableContainerState.mHasTintMode;
        if (paramDrawableContainerState.mDensity == this.mDensity)
        {
          if (paramDrawableContainerState.mCheckedPadding)
          {
            this.mConstantPadding = new Rect(paramDrawableContainerState.mConstantPadding);
            this.mCheckedPadding = true;
          }
          if (paramDrawableContainerState.mCheckedConstantSize)
          {
            this.mConstantWidth = paramDrawableContainerState.mConstantWidth;
            this.mConstantHeight = paramDrawableContainerState.mConstantHeight;
            this.mConstantMinimumWidth = paramDrawableContainerState.mConstantMinimumWidth;
            this.mConstantMinimumHeight = paramDrawableContainerState.mConstantMinimumHeight;
            this.mCheckedConstantSize = true;
          }
        }
        if (paramDrawableContainerState.mCheckedOpacity)
        {
          this.mOpacity = paramDrawableContainerState.mOpacity;
          this.mCheckedOpacity = true;
        }
        if (paramDrawableContainerState.mCheckedStateful)
        {
          this.mStateful = paramDrawableContainerState.mStateful;
          this.mCheckedStateful = true;
        }
        paramDrawableContainer = paramDrawableContainerState.mDrawables;
        this.mDrawables = new Drawable[paramDrawableContainer.length];
        this.mNumChildren = paramDrawableContainerState.mNumChildren;
        paramDrawableContainerState = paramDrawableContainerState.mDrawableFutures;
        if (paramDrawableContainerState != null) {
          this.mDrawableFutures = paramDrawableContainerState.clone();
        } else {
          this.mDrawableFutures = new SparseArray(this.mNumChildren);
        }
        int k = this.mNumChildren;
        i = j;
        while (i < k)
        {
          if (paramDrawableContainer[i] != null)
          {
            paramDrawableContainerState = paramDrawableContainer[i].getConstantState();
            if (paramDrawableContainerState != null) {
              this.mDrawableFutures.put(i, paramDrawableContainerState);
            } else {
              this.mDrawables[i] = paramDrawableContainer[i];
            }
          }
          i += 1;
        }
      }
      this.mDrawables = new Drawable[10];
      this.mNumChildren = 0;
    }
    
    private void createAllFutures()
    {
      if (this.mDrawableFutures != null)
      {
        int j = this.mDrawableFutures.size();
        int i = 0;
        while (i < j)
        {
          int k = this.mDrawableFutures.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.mDrawableFutures.valueAt(i);
          this.mDrawables[k] = prepareDrawable(localConstantState.newDrawable(this.mSourceRes));
          i += 1;
        }
        this.mDrawableFutures = null;
      }
    }
    
    private Drawable prepareDrawable(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.mOwner);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.mNumChildren;
      if (i >= this.mDrawables.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.mOwner);
      this.mDrawables[i] = paramDrawable;
      this.mNumChildren += 1;
      int j = this.mChildrenChangingConfigurations;
      this.mChildrenChangingConfigurations = (paramDrawable.getChangingConfigurations() | j);
      invalidateCache();
      this.mConstantPadding = null;
      this.mCheckedPadding = false;
      this.mCheckedConstantSize = false;
      this.mCheckedConstantState = false;
      return i;
    }
    
    @RequiresApi(21)
    final void applyTheme(Resources.Theme paramTheme)
    {
      if (paramTheme != null)
      {
        createAllFutures();
        int j = this.mNumChildren;
        Drawable[] arrayOfDrawable = this.mDrawables;
        int i = 0;
        while (i < j)
        {
          if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
          {
            arrayOfDrawable[i].applyTheme(paramTheme);
            this.mChildrenChangingConfigurations |= arrayOfDrawable[i].getChangingConfigurations();
          }
          i += 1;
        }
        updateDensity(paramTheme.getResources());
      }
    }
    
    @RequiresApi(21)
    public boolean canApplyTheme()
    {
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfDrawable[i];
        if (localObject != null)
        {
          if (((Drawable)localObject).canApplyTheme()) {
            return true;
          }
        }
        else
        {
          localObject = (Drawable.ConstantState)this.mDrawableFutures.get(i);
          if ((localObject != null) && (((Drawable.ConstantState)localObject).canApplyTheme())) {
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    
    public boolean canConstantState()
    {
      try
      {
        if (this.mCheckedConstantState)
        {
          boolean bool = this.mCanConstantState;
          return bool;
        }
        createAllFutures();
        this.mCheckedConstantState = true;
        int j = this.mNumChildren;
        Drawable[] arrayOfDrawable = this.mDrawables;
        int i = 0;
        while (i < j)
        {
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.mCanConstantState = false;
            return false;
          }
          i += 1;
        }
        this.mCanConstantState = true;
        return true;
      }
      finally {}
    }
    
    final void clearMutated()
    {
      this.mMutated = false;
    }
    
    protected void computeConstantSize()
    {
      this.mCheckedConstantSize = true;
      createAllFutures();
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      this.mConstantHeight = -1;
      this.mConstantWidth = -1;
      int i = 0;
      this.mConstantMinimumHeight = 0;
      this.mConstantMinimumWidth = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.mConstantWidth) {
          this.mConstantWidth = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.mConstantHeight) {
          this.mConstantHeight = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.mConstantMinimumWidth) {
          this.mConstantMinimumWidth = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.mConstantMinimumHeight) {
          this.mConstantMinimumHeight = k;
        }
        i += 1;
      }
    }
    
    final int getCapacity()
    {
      return this.mDrawables.length;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Drawable localDrawable = this.mDrawables[paramInt];
      if (localDrawable != null) {
        return localDrawable;
      }
      if (this.mDrawableFutures != null)
      {
        int i = this.mDrawableFutures.indexOfKey(paramInt);
        if (i >= 0)
        {
          localDrawable = prepareDrawable(((Drawable.ConstantState)this.mDrawableFutures.valueAt(i)).newDrawable(this.mSourceRes));
          this.mDrawables[paramInt] = localDrawable;
          this.mDrawableFutures.removeAt(i);
          if (this.mDrawableFutures.size() == 0) {
            this.mDrawableFutures = null;
          }
          return localDrawable;
        }
      }
      return null;
    }
    
    public final int getChildCount()
    {
      return this.mNumChildren;
    }
    
    public final int getConstantHeight()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantHeight;
    }
    
    public final int getConstantMinimumHeight()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantMinimumHeight;
    }
    
    public final int getConstantMinimumWidth()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantMinimumWidth;
    }
    
    public final Rect getConstantPadding()
    {
      if (this.mVariablePadding) {
        return null;
      }
      if ((this.mConstantPadding == null) && (!this.mCheckedPadding))
      {
        createAllFutures();
        Rect localRect = new Rect();
        int j = this.mNumChildren;
        Drawable[] arrayOfDrawable = this.mDrawables;
        Object localObject1 = null;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject1;
          if (arrayOfDrawable[i].getPadding(localRect))
          {
            Object localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Rect(0, 0, 0, 0);
            }
            if (localRect.left > ((Rect)localObject2).left) {
              ((Rect)localObject2).left = localRect.left;
            }
            if (localRect.top > ((Rect)localObject2).top) {
              ((Rect)localObject2).top = localRect.top;
            }
            if (localRect.right > ((Rect)localObject2).right) {
              ((Rect)localObject2).right = localRect.right;
            }
            localObject3 = localObject2;
            if (localRect.bottom > ((Rect)localObject2).bottom)
            {
              ((Rect)localObject2).bottom = localRect.bottom;
              localObject3 = localObject2;
            }
          }
          i += 1;
          localObject1 = localObject3;
        }
        this.mCheckedPadding = true;
        this.mConstantPadding = ((Rect)localObject1);
        return (Rect)localObject1;
      }
      return this.mConstantPadding;
    }
    
    public final int getConstantWidth()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantWidth;
    }
    
    public final int getEnterFadeDuration()
    {
      return this.mEnterFadeDuration;
    }
    
    public final int getExitFadeDuration()
    {
      return this.mExitFadeDuration;
    }
    
    public final int getOpacity()
    {
      if (this.mCheckedOpacity) {
        return this.mOpacity;
      }
      createAllFutures();
      int m = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      if (m > 0) {
        i = arrayOfDrawable[0].getOpacity();
      } else {
        i = -2;
      }
      int k = 1;
      int j = i;
      int i = k;
      while (i < m)
      {
        j = Drawable.resolveOpacity(j, arrayOfDrawable[i].getOpacity());
        i += 1;
      }
      this.mOpacity = j;
      this.mCheckedOpacity = true;
      return j;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.mDrawables, 0, arrayOfDrawable, 0, paramInt1);
      this.mDrawables = arrayOfDrawable;
    }
    
    void invalidateCache()
    {
      this.mCheckedOpacity = false;
      this.mCheckedStateful = false;
    }
    
    public final boolean isConstantSize()
    {
      return this.mConstantSize;
    }
    
    public final boolean isStateful()
    {
      if (this.mCheckedStateful) {
        return this.mStateful;
      }
      createAllFutures();
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      boolean bool2 = false;
      int i = 0;
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          break;
        }
        if (arrayOfDrawable[i].isStateful())
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
      this.mStateful = bool1;
      this.mCheckedStateful = true;
      return bool1;
    }
    
    void mutate()
    {
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.mMutated = true;
    }
    
    public final void setConstantSize(boolean paramBoolean)
    {
      this.mConstantSize = paramBoolean;
    }
    
    public final void setEnterFadeDuration(int paramInt)
    {
      this.mEnterFadeDuration = paramInt;
    }
    
    public final void setExitFadeDuration(int paramInt)
    {
      this.mExitFadeDuration = paramInt;
    }
    
    final boolean setLayoutDirection(int paramInt1, int paramInt2)
    {
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      boolean bool3;
      for (boolean bool2 = false; i < j; bool2 = bool3)
      {
        bool3 = bool2;
        if (arrayOfDrawable[i] != null)
        {
          boolean bool1;
          if (Build.VERSION.SDK_INT >= 23) {
            bool1 = arrayOfDrawable[i].setLayoutDirection(paramInt1);
          } else {
            bool1 = false;
          }
          bool3 = bool2;
          if (i == paramInt2) {
            bool3 = bool1;
          }
        }
        i += 1;
      }
      this.mLayoutDirection = paramInt1;
      return bool2;
    }
    
    public final void setVariablePadding(boolean paramBoolean)
    {
      this.mVariablePadding = paramBoolean;
    }
    
    final void updateDensity(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.mSourceRes = paramResources;
        int i = DrawableContainer.resolveDensity(paramResources, this.mDensity);
        int j = this.mDensity;
        this.mDensity = i;
        if (j != i)
        {
          this.mCheckedConstantSize = false;
          this.mCheckedPadding = false;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\graphics\drawable\DrawableContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */