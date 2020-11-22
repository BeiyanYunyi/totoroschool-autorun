package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.ripple.RippleUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class FloatingActionButtonImplLollipop
  extends FloatingActionButtonImpl
{
  private InsetDrawable insetDrawable;
  
  FloatingActionButtonImplLollipop(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
  }
  
  @NonNull
  private Animator createElevationAnimator(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
    return localAnimatorSet;
  }
  
  public float getElevation()
  {
    return this.view.getElevation();
  }
  
  void getPadding(Rect paramRect)
  {
    if (this.shadowViewDelegate.isCompatPaddingEnabled())
    {
      float f1 = this.shadowViewDelegate.getRadius();
      float f2 = getElevation() + this.pressedTranslationZ;
      int i = (int)Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(f2, f1, false));
      int j = (int)Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  void jumpDrawableToCurrentState() {}
  
  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawableLollipop();
  }
  
  GradientDrawable newGradientDrawableForShape()
  {
    return new AlwaysStatefulGradientDrawable();
  }
  
  void onCompatShadowChanged()
  {
    updatePadding();
  }
  
  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      if (this.view.isEnabled())
      {
        this.view.setElevation(this.elevation);
        if (this.view.isPressed())
        {
          this.view.setTranslationZ(this.pressedTranslationZ);
          return;
        }
        if ((!this.view.isFocused()) && (!this.view.isHovered()))
        {
          this.view.setTranslationZ(0.0F);
          return;
        }
        this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
        return;
      }
      this.view.setElevation(0.0F);
      this.view.setTranslationZ(0.0F);
    }
  }
  
  void onElevationsChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      this.view.refreshDrawableState();
    }
    else
    {
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat3));
      localStateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat2));
      localStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat2));
      localStateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[] { this.view.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
      localStateListAnimator.addState(ENABLED_STATE_SET, localAnimatorSet);
      localStateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(0.0F, 0.0F));
      this.view.setStateListAnimator(localStateListAnimator);
    }
    if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
      updatePadding();
    }
  }
  
  void onPaddingUpdated(Rect paramRect)
  {
    if (this.shadowViewDelegate.isCompatPaddingEnabled())
    {
      this.insetDrawable = new InsetDrawable(this.rippleDrawable, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.shadowViewDelegate.setBackgroundDrawable(this.insetDrawable);
      return;
    }
    this.shadowViewDelegate.setBackgroundDrawable(this.rippleDrawable);
  }
  
  boolean requirePreDrawListener()
  {
    return false;
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.shapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.shapeDrawable, paramColorStateList1);
    if (paramMode != null) {
      DrawableCompat.setTintMode(this.shapeDrawable, paramMode);
    }
    if (paramInt > 0)
    {
      this.borderDrawable = createBorderDrawable(paramInt, paramColorStateList1);
      paramColorStateList1 = new LayerDrawable(new Drawable[] { this.borderDrawable, this.shapeDrawable });
    }
    else
    {
      this.borderDrawable = null;
      paramColorStateList1 = this.shapeDrawable;
    }
    this.rippleDrawable = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(paramColorStateList2), paramColorStateList1, null);
    this.contentBackground = this.rippleDrawable;
    this.shadowViewDelegate.setBackgroundDrawable(this.rippleDrawable);
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    if ((this.rippleDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)this.rippleDrawable).setColor(RippleUtils.convertToRippleDrawableColor(paramColorStateList));
      return;
    }
    super.setRippleColor(paramColorStateList);
  }
  
  static class AlwaysStatefulGradientDrawable
    extends GradientDrawable
  {
    public boolean isStateful()
    {
      return true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\FloatingActionButtonImplLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */