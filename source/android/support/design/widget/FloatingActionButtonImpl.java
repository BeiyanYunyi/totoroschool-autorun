package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.R.animator;
import android.support.design.R.color;
import android.support.design.animation.AnimationUtils;
import android.support.design.animation.AnimatorSetCompat;
import android.support.design.animation.ImageMatrixProperty;
import android.support.design.animation.MatrixEvaluator;
import android.support.design.animation.MotionSpec;
import android.support.design.animation.MotionTiming;
import android.support.design.ripple.RippleUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FloatingActionButtonImpl
{
  static final int ANIM_STATE_HIDING = 1;
  static final int ANIM_STATE_NONE = 0;
  static final int ANIM_STATE_SHOWING = 2;
  static final long ELEVATION_ANIM_DELAY = 100L;
  static final long ELEVATION_ANIM_DURATION = 100L;
  static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] ENABLED_STATE_SET;
  static final int[] FOCUSED_ENABLED_STATE_SET;
  private static final float HIDE_ICON_SCALE = 0.0F;
  private static final float HIDE_OPACITY = 0.0F;
  private static final float HIDE_SCALE = 0.0F;
  static final int[] HOVERED_ENABLED_STATE_SET;
  static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET;
  static final int[] PRESSED_ENABLED_STATE_SET = { 16842919, 16842910 };
  private static final float SHOW_ICON_SCALE = 1.0F;
  private static final float SHOW_OPACITY = 1.0F;
  private static final float SHOW_SCALE = 1.0F;
  int animState = 0;
  CircularBorderDrawable borderDrawable;
  Drawable contentBackground;
  @Nullable
  Animator currentAnimator;
  @Nullable
  private MotionSpec defaultHideMotionSpec;
  @Nullable
  private MotionSpec defaultShowMotionSpec;
  float elevation;
  private ArrayList<Animator.AnimatorListener> hideListeners;
  @Nullable
  MotionSpec hideMotionSpec;
  float hoveredFocusedTranslationZ;
  float imageMatrixScale = 1.0F;
  int maxImageSize;
  private ViewTreeObserver.OnPreDrawListener preDrawListener;
  float pressedTranslationZ;
  Drawable rippleDrawable;
  private float rotation;
  ShadowDrawableWrapper shadowDrawable;
  final ShadowViewDelegate shadowViewDelegate;
  Drawable shapeDrawable;
  private ArrayList<Animator.AnimatorListener> showListeners;
  @Nullable
  MotionSpec showMotionSpec;
  private final StateListAnimator stateListAnimator;
  private final Matrix tmpMatrix = new Matrix();
  private final Rect tmpRect = new Rect();
  private final RectF tmpRectF1 = new RectF();
  private final RectF tmpRectF2 = new RectF();
  final VisibilityAwareImageButton view;
  
  static
  {
    HOVERED_FOCUSED_ENABLED_STATE_SET = new int[] { 16843623, 16842908, 16842910 };
    FOCUSED_ENABLED_STATE_SET = new int[] { 16842908, 16842910 };
    HOVERED_ENABLED_STATE_SET = new int[] { 16843623, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  FloatingActionButtonImpl(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    this.view = paramVisibilityAwareImageButton;
    this.shadowViewDelegate = paramShadowViewDelegate;
    this.stateListAnimator = new StateListAnimator();
    this.stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
    this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
    this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
    this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
    this.stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
    this.stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation()));
    this.rotation = this.view.getRotation();
  }
  
  private void calculateImageMatrixFromScale(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.view.getDrawable();
    if ((localDrawable != null) && (this.maxImageSize != 0))
    {
      RectF localRectF1 = this.tmpRectF1;
      RectF localRectF2 = this.tmpRectF2;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localRectF2.set(0.0F, 0.0F, this.maxImageSize, this.maxImageSize);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      paramMatrix.postScale(paramFloat, paramFloat, this.maxImageSize / 2.0F, this.maxImageSize / 2.0F);
    }
  }
  
  @NonNull
  private AnimatorSet createAnimator(@NonNull MotionSpec paramMotionSpec, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[] { paramFloat1 });
    paramMotionSpec.getTiming("opacity").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[] { paramFloat2 });
    paramMotionSpec.getTiming("scale").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[] { paramFloat2 });
    paramMotionSpec.getTiming("scale").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    calculateImageMatrixFromScale(paramFloat3, this.tmpMatrix);
    localObjectAnimator = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix[] { new Matrix(this.tmpMatrix) });
    paramMotionSpec.getTiming("iconScale").apply(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramMotionSpec = new AnimatorSet();
    AnimatorSetCompat.playTogether(paramMotionSpec, localArrayList);
    return paramMotionSpec;
  }
  
  private ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl paramShadowAnimatorImpl)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramShadowAnimatorImpl);
    localValueAnimator.addUpdateListener(paramShadowAnimatorImpl);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private void ensurePreDrawListener()
  {
    if (this.preDrawListener == null) {
      this.preDrawListener = new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          FloatingActionButtonImpl.this.onPreDraw();
          return true;
        }
      };
    }
  }
  
  private MotionSpec getDefaultHideMotionSpec()
  {
    if (this.defaultHideMotionSpec == null) {
      this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), R.animator.design_fab_hide_motion_spec);
    }
    return this.defaultHideMotionSpec;
  }
  
  private MotionSpec getDefaultShowMotionSpec()
  {
    if (this.defaultShowMotionSpec == null) {
      this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), R.animator.design_fab_show_motion_spec);
    }
    return this.defaultShowMotionSpec;
  }
  
  private boolean shouldAnimateVisibilityChange()
  {
    return (ViewCompat.isLaidOut(this.view)) && (!this.view.isInEditMode());
  }
  
  private void updateFromViewRotation()
  {
    if (Build.VERSION.SDK_INT == 19) {
      if (this.rotation % 90.0F != 0.0F)
      {
        if (this.view.getLayerType() != 1) {
          this.view.setLayerType(1, null);
        }
      }
      else if (this.view.getLayerType() != 0) {
        this.view.setLayerType(0, null);
      }
    }
    if (this.shadowDrawable != null) {
      this.shadowDrawable.setRotation(-this.rotation);
    }
    if (this.borderDrawable != null) {
      this.borderDrawable.setRotation(-this.rotation);
    }
  }
  
  public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.hideListeners == null) {
      this.hideListeners = new ArrayList();
    }
    this.hideListeners.add(paramAnimatorListener);
  }
  
  void addOnShowAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.showListeners == null) {
      this.showListeners = new ArrayList();
    }
    this.showListeners.add(paramAnimatorListener);
  }
  
  CircularBorderDrawable createBorderDrawable(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.view.getContext();
    CircularBorderDrawable localCircularBorderDrawable = newCircularDrawable();
    localCircularBorderDrawable.setGradientColors(ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_outer_color));
    localCircularBorderDrawable.setBorderWidth(paramInt);
    localCircularBorderDrawable.setBorderTint(paramColorStateList);
    return localCircularBorderDrawable;
  }
  
  GradientDrawable createShapeDrawable()
  {
    GradientDrawable localGradientDrawable = newGradientDrawableForShape();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  final Drawable getContentBackground()
  {
    return this.contentBackground;
  }
  
  float getElevation()
  {
    return this.elevation;
  }
  
  @Nullable
  final MotionSpec getHideMotionSpec()
  {
    return this.hideMotionSpec;
  }
  
  float getHoveredFocusedTranslationZ()
  {
    return this.hoveredFocusedTranslationZ;
  }
  
  void getPadding(Rect paramRect)
  {
    this.shadowDrawable.getPadding(paramRect);
  }
  
  float getPressedTranslationZ()
  {
    return this.pressedTranslationZ;
  }
  
  @Nullable
  final MotionSpec getShowMotionSpec()
  {
    return this.showMotionSpec;
  }
  
  void hide(@Nullable final InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeHidden()) {
      return;
    }
    if (this.currentAnimator != null) {
      this.currentAnimator.cancel();
    }
    if (shouldAnimateVisibilityChange())
    {
      if (this.hideMotionSpec != null) {
        localObject = this.hideMotionSpec;
      } else {
        localObject = getDefaultHideMotionSpec();
      }
      localObject = createAnimator((MotionSpec)localObject, 0.0F, 0.0F, 0.0F);
      ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
      {
        private boolean cancelled;
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.cancelled = true;
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.animState = 0;
          FloatingActionButtonImpl.this.currentAnimator = null;
          if (!this.cancelled)
          {
            paramAnonymousAnimator = FloatingActionButtonImpl.this.view;
            int i;
            if (paramBoolean) {
              i = 8;
            } else {
              i = 4;
            }
            paramAnonymousAnimator.internalSetVisibility(i, paramBoolean);
            if (paramInternalVisibilityChangedListener != null) {
              paramInternalVisibilityChangedListener.onHidden();
            }
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.view.internalSetVisibility(0, paramBoolean);
          FloatingActionButtonImpl.this.animState = 1;
          FloatingActionButtonImpl.this.currentAnimator = paramAnonymousAnimator;
          this.cancelled = false;
        }
      });
      if (this.hideListeners != null)
      {
        paramInternalVisibilityChangedListener = this.hideListeners.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    Object localObject = this.view;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 4;
    }
    ((VisibilityAwareImageButton)localObject).internalSetVisibility(i, paramBoolean);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.onHidden();
    }
  }
  
  boolean isOrWillBeHidden()
  {
    int i = this.view.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0)
    {
      if (this.animState == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.animState != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean isOrWillBeShown()
  {
    int i = this.view.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 0)
    {
      if (this.animState == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.animState != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  void jumpDrawableToCurrentState()
  {
    this.stateListAnimator.jumpToCurrentState();
  }
  
  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawable();
  }
  
  GradientDrawable newGradientDrawableForShape()
  {
    return new GradientDrawable();
  }
  
  void onAttachedToWindow()
  {
    if (requirePreDrawListener())
    {
      ensurePreDrawListener();
      this.view.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
    }
  }
  
  void onCompatShadowChanged() {}
  
  void onDetachedFromWindow()
  {
    if (this.preDrawListener != null)
    {
      this.view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
      this.preDrawListener = null;
    }
  }
  
  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    this.stateListAnimator.setState(paramArrayOfInt);
  }
  
  void onElevationsChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.shadowDrawable != null)
    {
      this.shadowDrawable.setShadowSize(paramFloat1, this.pressedTranslationZ + paramFloat1);
      updatePadding();
    }
  }
  
  void onPaddingUpdated(Rect paramRect) {}
  
  void onPreDraw()
  {
    float f = this.view.getRotation();
    if (this.rotation != f)
    {
      this.rotation = f;
      updateFromViewRotation();
    }
  }
  
  public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.hideListeners == null) {
      return;
    }
    this.hideListeners.remove(paramAnimatorListener);
  }
  
  void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.showListeners == null) {
      return;
    }
    this.showListeners.remove(paramAnimatorListener);
  }
  
  boolean requirePreDrawListener()
  {
    return true;
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.shapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.shapeDrawable, paramColorStateList1);
    if (paramMode != null) {
      DrawableCompat.setTintMode(this.shapeDrawable, paramMode);
    }
    this.rippleDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.rippleDrawable, RippleUtils.convertToRippleDrawableColor(paramColorStateList2));
    if (paramInt > 0)
    {
      this.borderDrawable = createBorderDrawable(paramInt, paramColorStateList1);
      paramColorStateList1 = new Drawable[3];
      paramColorStateList1[0] = this.borderDrawable;
      paramColorStateList1[1] = this.shapeDrawable;
      paramColorStateList1[2] = this.rippleDrawable;
    }
    else
    {
      this.borderDrawable = null;
      paramColorStateList1 = new Drawable[2];
      paramColorStateList1[0] = this.shapeDrawable;
      paramColorStateList1[1] = this.rippleDrawable;
    }
    this.contentBackground = new LayerDrawable(paramColorStateList1);
    this.shadowDrawable = new ShadowDrawableWrapper(this.view.getContext(), this.contentBackground, this.shadowViewDelegate.getRadius(), this.elevation, this.elevation + this.pressedTranslationZ);
    this.shadowDrawable.setAddPaddingForCorners(false);
    this.shadowViewDelegate.setBackgroundDrawable(this.shadowDrawable);
  }
  
  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.shapeDrawable != null) {
      DrawableCompat.setTintList(this.shapeDrawable, paramColorStateList);
    }
    if (this.borderDrawable != null) {
      this.borderDrawable.setBorderTint(paramColorStateList);
    }
  }
  
  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.shapeDrawable != null) {
      DrawableCompat.setTintMode(this.shapeDrawable, paramMode);
    }
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.elevation != paramFloat)
    {
      this.elevation = paramFloat;
      onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
    }
  }
  
  final void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.hideMotionSpec = paramMotionSpec;
  }
  
  final void setHoveredFocusedTranslationZ(float paramFloat)
  {
    if (this.hoveredFocusedTranslationZ != paramFloat)
    {
      this.hoveredFocusedTranslationZ = paramFloat;
      onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
    }
  }
  
  final void setImageMatrixScale(float paramFloat)
  {
    this.imageMatrixScale = paramFloat;
    Matrix localMatrix = this.tmpMatrix;
    calculateImageMatrixFromScale(paramFloat, localMatrix);
    this.view.setImageMatrix(localMatrix);
  }
  
  final void setMaxImageSize(int paramInt)
  {
    if (this.maxImageSize != paramInt)
    {
      this.maxImageSize = paramInt;
      updateImageMatrixScale();
    }
  }
  
  final void setPressedTranslationZ(float paramFloat)
  {
    if (this.pressedTranslationZ != paramFloat)
    {
      this.pressedTranslationZ = paramFloat;
      onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.rippleDrawable != null) {
      DrawableCompat.setTintList(this.rippleDrawable, RippleUtils.convertToRippleDrawableColor(paramColorStateList));
    }
  }
  
  final void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.showMotionSpec = paramMotionSpec;
  }
  
  void show(@Nullable final InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeShown()) {
      return;
    }
    if (this.currentAnimator != null) {
      this.currentAnimator.cancel();
    }
    if (shouldAnimateVisibilityChange())
    {
      if (this.view.getVisibility() != 0)
      {
        this.view.setAlpha(0.0F);
        this.view.setScaleY(0.0F);
        this.view.setScaleX(0.0F);
        setImageMatrixScale(0.0F);
      }
      if (this.showMotionSpec != null) {
        localObject = this.showMotionSpec;
      } else {
        localObject = getDefaultShowMotionSpec();
      }
      Object localObject = createAnimator((MotionSpec)localObject, 1.0F, 1.0F, 1.0F);
      ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.animState = 0;
          FloatingActionButtonImpl.this.currentAnimator = null;
          if (paramInternalVisibilityChangedListener != null) {
            paramInternalVisibilityChangedListener.onShown();
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.view.internalSetVisibility(0, paramBoolean);
          FloatingActionButtonImpl.this.animState = 2;
          FloatingActionButtonImpl.this.currentAnimator = paramAnonymousAnimator;
        }
      });
      if (this.showListeners != null)
      {
        paramInternalVisibilityChangedListener = this.showListeners.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    this.view.internalSetVisibility(0, paramBoolean);
    this.view.setAlpha(1.0F);
    this.view.setScaleY(1.0F);
    this.view.setScaleX(1.0F);
    setImageMatrixScale(1.0F);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.onShown();
    }
  }
  
  final void updateImageMatrixScale()
  {
    setImageMatrixScale(this.imageMatrixScale);
  }
  
  final void updatePadding()
  {
    Rect localRect = this.tmpRect;
    getPadding(localRect);
    onPaddingUpdated(localRect);
    this.shadowViewDelegate.setShadowPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private class DisabledElevationAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    DisabledElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return 0.0F;
    }
  }
  
  private class ElevateToHoveredFocusedTranslationZAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ElevateToHoveredFocusedTranslationZAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.hoveredFocusedTranslationZ;
    }
  }
  
  private class ElevateToPressedTranslationZAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ElevateToPressedTranslationZAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.pressedTranslationZ;
    }
  }
  
  static abstract interface InternalVisibilityChangedListener
  {
    public abstract void onHidden();
    
    public abstract void onShown();
  }
  
  private class ResetElevationAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ResetElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.elevation;
    }
  }
  
  private abstract class ShadowAnimatorImpl
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float shadowSizeEnd;
    private float shadowSizeStart;
    private boolean validValues;
    
    private ShadowAnimatorImpl() {}
    
    protected abstract float getTargetShadowSize();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      FloatingActionButtonImpl.this.shadowDrawable.setShadowSize(this.shadowSizeEnd);
      this.validValues = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.validValues)
      {
        this.shadowSizeStart = FloatingActionButtonImpl.this.shadowDrawable.getShadowSize();
        this.shadowSizeEnd = getTargetShadowSize();
        this.validValues = true;
      }
      FloatingActionButtonImpl.this.shadowDrawable.setShadowSize(this.shadowSizeStart + (this.shadowSizeEnd - this.shadowSizeStart) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\FloatingActionButtonImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */