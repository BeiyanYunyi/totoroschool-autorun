package android.support.design.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.R.id;
import android.support.design.animation.AnimationUtils;
import android.support.design.animation.AnimatorSetCompat;
import android.support.design.animation.ArgbEvaluatorCompat;
import android.support.design.animation.ChildrenAlphaProperty;
import android.support.design.animation.DrawableAlphaProperty;
import android.support.design.animation.MotionSpec;
import android.support.design.animation.MotionTiming;
import android.support.design.animation.Positioning;
import android.support.design.circularreveal.CircularRevealCompat;
import android.support.design.circularreveal.CircularRevealHelper;
import android.support.design.circularreveal.CircularRevealWidget;
import android.support.design.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty;
import android.support.design.circularreveal.CircularRevealWidget.RevealInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior
  extends ExpandableTransformationBehavior
{
  private final int[] tmpArray = new int[2];
  private final Rect tmpRect = new Rect();
  private final RectF tmpRectF1 = new RectF();
  private final RectF tmpRectF2 = new RectF();
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @Nullable
  private ViewGroup calculateChildContentContainer(View paramView)
  {
    View localView = paramView.findViewById(R.id.mtrl_child_content_container);
    if (localView != null) {
      return toViewGroupOrNull(localView);
    }
    if ((!(paramView instanceof TransformationChildLayout)) && (!(paramView instanceof TransformationChildCard))) {
      return toViewGroupOrNull(paramView);
    }
    return toViewGroupOrNull(((ViewGroup)paramView).getChildAt(0));
  }
  
  private void calculateChildVisibleBoundsAtEndOfExpansion(View paramView, FabTransformationSpec paramFabTransformationSpec, MotionTiming paramMotionTiming1, MotionTiming paramMotionTiming2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, RectF paramRectF)
  {
    paramFloat1 = calculateValueOfAnimationAtEndOfExpansion(paramFabTransformationSpec, paramMotionTiming1, paramFloat1, paramFloat3);
    paramFloat2 = calculateValueOfAnimationAtEndOfExpansion(paramFabTransformationSpec, paramMotionTiming2, paramFloat2, paramFloat4);
    paramMotionTiming1 = this.tmpRect;
    paramView.getWindowVisibleDisplayFrame(paramMotionTiming1);
    paramFabTransformationSpec = this.tmpRectF1;
    paramFabTransformationSpec.set(paramMotionTiming1);
    paramMotionTiming1 = this.tmpRectF2;
    calculateWindowBounds(paramView, paramMotionTiming1);
    paramMotionTiming1.offset(paramFloat1, paramFloat2);
    paramMotionTiming1.intersect(paramFabTransformationSpec);
    paramRectF.set(paramMotionTiming1);
  }
  
  private float calculateRevealCenterX(View paramView1, View paramView2, Positioning paramPositioning)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    localRectF2.offset(-calculateTranslationX(paramView1, paramView2, paramPositioning), 0.0F);
    return localRectF1.centerX() - localRectF2.left;
  }
  
  private float calculateRevealCenterY(View paramView1, View paramView2, Positioning paramPositioning)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    localRectF2.offset(0.0F, -calculateTranslationY(paramView1, paramView2, paramPositioning));
    return localRectF1.centerY() - localRectF2.top;
  }
  
  private float calculateTranslationX(View paramView1, View paramView2, Positioning paramPositioning)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    int i = paramPositioning.gravity & 0x7;
    float f;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 5) {
          f = 0.0F;
        } else {
          f = localRectF2.right - localRectF1.right;
        }
      }
      else {
        f = localRectF2.left - localRectF1.left;
      }
    }
    else {
      f = localRectF2.centerX() - localRectF1.centerX();
    }
    return f + paramPositioning.xAdjustment;
  }
  
  private float calculateTranslationY(View paramView1, View paramView2, Positioning paramPositioning)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    int i = paramPositioning.gravity & 0x70;
    float f;
    if (i != 16)
    {
      if (i != 48)
      {
        if (i != 80) {
          f = 0.0F;
        } else {
          f = localRectF2.bottom - localRectF1.bottom;
        }
      }
      else {
        f = localRectF2.top - localRectF1.top;
      }
    }
    else {
      f = localRectF2.centerY() - localRectF1.centerY();
    }
    return f + paramPositioning.yAdjustment;
  }
  
  private float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec paramFabTransformationSpec, MotionTiming paramMotionTiming, float paramFloat1, float paramFloat2)
  {
    long l1 = paramMotionTiming.getDelay();
    long l2 = paramMotionTiming.getDuration();
    paramFabTransformationSpec = paramFabTransformationSpec.timings.getTiming("expansion");
    float f = (float)(paramFabTransformationSpec.getDelay() + paramFabTransformationSpec.getDuration() + 17L - l1) / (float)l2;
    return AnimationUtils.lerp(paramFloat1, paramFloat2, paramMotionTiming.getInterpolator().getInterpolation(f));
  }
  
  private void calculateWindowBounds(View paramView, RectF paramRectF)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = this.tmpArray;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private void createChildrenFadeAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof ViewGroup)) {
      return;
    }
    if (((paramView2 instanceof CircularRevealWidget)) && (CircularRevealHelper.STRATEGY == 0)) {
      return;
    }
    paramView1 = calculateChildContentContainer(paramView2);
    if (paramView1 == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        ChildrenAlphaProperty.CHILDREN_ALPHA.set(paramView1, Float.valueOf(0.0F));
      }
      paramView1 = ObjectAnimator.ofFloat(paramView1, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[] { 1.0F });
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView1, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[] { 0.0F });
    }
    paramFabTransformationSpec.timings.getTiming("contentFade").apply(paramView1);
    paramList.add(paramView1);
  }
  
  private void createColorAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof CircularRevealWidget)) {
      return;
    }
    paramView2 = (CircularRevealWidget)paramView2;
    int i = getBackgroundTint(paramView1);
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setCircularRevealScrimColor(i);
      }
      paramView1 = ObjectAnimator.ofInt(paramView2, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[] { 0xFFFFFF & i });
    }
    else
    {
      paramView1 = ObjectAnimator.ofInt(paramView2, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[] { i });
    }
    paramView1.setEvaluator(ArgbEvaluatorCompat.getInstance());
    paramFabTransformationSpec.timings.getTiming("color").apply(paramView1);
    paramList.add(paramView1);
  }
  
  @TargetApi(21)
  private void createElevationAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    float f = ViewCompat.getElevation(paramView2) - ViewCompat.getElevation(paramView1);
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setTranslationZ(-f);
      }
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
    }
    else
    {
      paramView1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { -f });
    }
    paramFabTransformationSpec.timings.getTiming("elevation").apply(paramView1);
    paramList.add(paramView1);
  }
  
  private void createExpansionAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, float paramFloat1, float paramFloat2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof CircularRevealWidget)) {
      return;
    }
    final CircularRevealWidget localCircularRevealWidget = (CircularRevealWidget)paramView2;
    float f2 = calculateRevealCenterX(paramView1, paramView2, paramFabTransformationSpec.positioning);
    float f3 = calculateRevealCenterY(paramView1, paramView2, paramFabTransformationSpec.positioning);
    ((FloatingActionButton)paramView1).getContentRect(this.tmpRect);
    float f1 = this.tmpRect.width() / 2.0F;
    MotionTiming localMotionTiming = paramFabTransformationSpec.timings.getTiming("expansion");
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        localCircularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(f2, f3, f1));
      }
      if (paramBoolean2) {
        f1 = localCircularRevealWidget.getRevealInfo().radius;
      }
      paramView1 = CircularRevealCompat.createCircularReveal(localCircularRevealWidget, f2, f3, MathUtils.distanceToFurthestCorner(f2, f3, 0.0F, 0.0F, paramFloat1, paramFloat2));
      paramView1.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramAnonymousAnimator = localCircularRevealWidget.getRevealInfo();
          paramAnonymousAnimator.radius = Float.MAX_VALUE;
          localCircularRevealWidget.setRevealInfo(paramAnonymousAnimator);
        }
      });
      createPreFillRadialExpansion(paramView2, localMotionTiming.getDelay(), (int)f2, (int)f3, f1, paramList);
    }
    else
    {
      paramFloat1 = localCircularRevealWidget.getRevealInfo().radius;
      paramView1 = CircularRevealCompat.createCircularReveal(localCircularRevealWidget, f2, f3, f1);
      long l = localMotionTiming.getDelay();
      int i = (int)f2;
      int j = (int)f3;
      createPreFillRadialExpansion(paramView2, l, i, j, paramFloat1, paramList);
      createPostFillRadialExpansion(paramView2, localMotionTiming.getDelay(), localMotionTiming.getDuration(), paramFabTransformationSpec.timings.getTotalDuration(), i, j, f1, paramList);
    }
    localMotionTiming.apply(paramView1);
    paramList.add(paramView1);
    paramList1.add(CircularRevealCompat.createCircularRevealListener(localCircularRevealWidget));
  }
  
  private void createIconFadeAnimation(View paramView1, final View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if ((paramView2 instanceof CircularRevealWidget))
    {
      if (!(paramView1 instanceof ImageView)) {
        return;
      }
      final CircularRevealWidget localCircularRevealWidget = (CircularRevealWidget)paramView2;
      final Drawable localDrawable = ((ImageView)paramView1).getDrawable();
      if (localDrawable == null) {
        return;
      }
      localDrawable.mutate();
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          localDrawable.setAlpha(255);
        }
        paramView1 = ObjectAnimator.ofInt(localDrawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[] { 0 });
      }
      else
      {
        paramView1 = ObjectAnimator.ofInt(localDrawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[] { 255 });
      }
      paramView1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          paramView2.invalidate();
        }
      });
      paramFabTransformationSpec.timings.getTiming("iconFade").apply(paramView1);
      paramList.add(paramView1);
      paramList1.add(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          localCircularRevealWidget.setCircularRevealOverlayDrawable(null);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          localCircularRevealWidget.setCircularRevealOverlayDrawable(localDrawable);
        }
      });
      return;
    }
  }
  
  private void createPostFillRadialExpansion(View paramView, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramLong1 += paramLong2;
      if (paramLong1 < paramLong3)
      {
        paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
        paramView.setStartDelay(paramLong1);
        paramView.setDuration(paramLong3 - paramLong1);
        paramList.add(paramView);
      }
    }
  }
  
  private void createPreFillRadialExpansion(View paramView, long paramLong, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramLong > 0L))
    {
      paramView = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      paramView.setStartDelay(0L);
      paramView.setDuration(paramLong);
      paramList.add(paramView);
    }
  }
  
  private void createTranslationAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1, RectF paramRectF)
  {
    float f1 = calculateTranslationX(paramView1, paramView2, paramFabTransformationSpec.positioning);
    float f2 = calculateTranslationY(paramView1, paramView2, paramFabTransformationSpec.positioning);
    if ((f1 != 0.0F) && (f2 != 0.0F))
    {
      if (((paramBoolean1) && (f2 < 0.0F)) || ((!paramBoolean1) && (f2 > 0.0F)))
      {
        paramView1 = paramFabTransformationSpec.timings.getTiming("translationXCurveUpwards");
        paramList1 = paramFabTransformationSpec.timings.getTiming("translationYCurveUpwards");
      }
      else
      {
        paramView1 = paramFabTransformationSpec.timings.getTiming("translationXCurveDownwards");
        paramList1 = paramFabTransformationSpec.timings.getTiming("translationYCurveDownwards");
      }
    }
    else
    {
      paramView1 = paramFabTransformationSpec.timings.getTiming("translationXLinear");
      paramList1 = paramFabTransformationSpec.timings.getTiming("translationYLinear");
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        paramView2.setTranslationX(-f1);
        paramView2.setTranslationY(-f2);
      }
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F });
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      calculateChildVisibleBoundsAtEndOfExpansion(paramView2, paramFabTransformationSpec, paramView1, paramList1, -f1, -f2, 0.0F, 0.0F, paramRectF);
      paramView2 = localObjectAnimator2;
      paramFabTransformationSpec = localObjectAnimator1;
    }
    else
    {
      paramRectF = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { -f1 });
      paramFabTransformationSpec = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { -f2 });
      paramView2 = paramRectF;
    }
    paramView1.apply(paramView2);
    paramList1.apply(paramFabTransformationSpec);
    paramList.add(paramView2);
    paramList.add(paramFabTransformationSpec);
  }
  
  private int getBackgroundTint(View paramView)
  {
    ColorStateList localColorStateList = ViewCompat.getBackgroundTintList(paramView);
    if (localColorStateList != null) {
      return localColorStateList.getColorForState(paramView.getDrawableState(), localColorStateList.getDefaultColor());
    }
    return 0;
  }
  
  @Nullable
  private ViewGroup toViewGroupOrNull(View paramView)
  {
    if ((paramView instanceof ViewGroup)) {
      return (ViewGroup)paramView;
    }
    return null;
  }
  
  @CallSuper
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    if (paramView1.getVisibility() != 8)
    {
      boolean bool2 = paramView2 instanceof FloatingActionButton;
      boolean bool1 = false;
      if (bool2)
      {
        int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
        if ((i == 0) || (i == paramView1.getId())) {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
  }
  
  @CallSuper
  public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.dodgeInsetEdges == 0) {
      paramLayoutParams.dodgeInsetEdges = 80;
    }
  }
  
  @NonNull
  protected AnimatorSet onCreateExpandedStateChangeAnimation(final View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = onCreateMotionSpec(paramView2.getContext(), paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Build.VERSION.SDK_INT >= 21) {
      createElevationAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    }
    RectF localRectF = this.tmpRectF1;
    createTranslationAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationSpec)localObject, localArrayList1, localArrayList2, localRectF);
    float f1 = localRectF.width();
    float f2 = localRectF.height();
    createIconFadeAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    createExpansionAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationSpec)localObject, f1, f2, localArrayList1, localArrayList2);
    createColorAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    createChildrenFadeAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, (FabTransformationSpec)localObject, localArrayList1, localArrayList2);
    localObject = new AnimatorSet();
    AnimatorSetCompat.playTogether((AnimatorSet)localObject, localArrayList1);
    ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!paramBoolean1)
        {
          paramView2.setVisibility(4);
          paramView1.setAlpha(1.0F);
          paramView1.setVisibility(0);
        }
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (paramBoolean1)
        {
          paramView2.setVisibility(0);
          paramView1.setAlpha(0.0F);
          paramView1.setVisibility(4);
        }
      }
    });
    int i = 0;
    int j = localArrayList2.size();
    while (i < j)
    {
      ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)localArrayList2.get(i));
      i += 1;
    }
    return (AnimatorSet)localObject;
  }
  
  protected abstract FabTransformationSpec onCreateMotionSpec(Context paramContext, boolean paramBoolean);
  
  protected static class FabTransformationSpec
  {
    public Positioning positioning;
    public MotionSpec timings;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\transformation\FabTransformationBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */