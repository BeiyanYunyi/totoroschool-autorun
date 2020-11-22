package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.NonNull;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class Fade
  extends Visibility
{
  public static final int IN = 1;
  private static final String LOG_TAG = "Fade";
  public static final int OUT = 2;
  private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";
  
  public Fade() {}
  
  public Fade(int paramInt)
  {
    setMode(paramInt);
  }
  
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.FADE);
    setMode(TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, getMode()));
    paramContext.recycle();
  }
  
  private Animator createAnimation(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    ViewUtils.setTransitionAlpha(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ViewUtils.TRANSITION_ALPHA, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new FadeAnimatorListener(paramView));
    addListener(new TransitionListenerAdapter()
    {
      public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
      {
        ViewUtils.setTransitionAlpha(paramView, 1.0F);
        ViewUtils.clearNonTransitionAlpha(paramView);
        paramAnonymousTransition.removeListener(this);
      }
    });
    return localObjectAnimator;
  }
  
  private static float getStartAlpha(TransitionValues paramTransitionValues, float paramFloat)
  {
    float f = paramFloat;
    if (paramTransitionValues != null)
    {
      paramTransitionValues = (Float)paramTransitionValues.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramTransitionValues != null) {
        f = paramTransitionValues.floatValue();
      }
    }
    return f;
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    super.captureStartValues(paramTransitionValues);
    paramTransitionValues.values.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.getTransitionAlpha(paramTransitionValues.view)));
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    float f1 = 0.0F;
    float f2 = getStartAlpha(paramTransitionValues1, 0.0F);
    if (f2 != 1.0F) {
      f1 = f2;
    }
    return createAnimation(paramView, f1, 1.0F);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    ViewUtils.saveNonTransitionAlpha(paramView);
    return createAnimation(paramView, getStartAlpha(paramTransitionValues1, 1.0F), 0.0F);
  }
  
  private static class FadeAnimatorListener
    extends AnimatorListenerAdapter
  {
    private boolean mLayerTypeChanged = false;
    private final View mView;
    
    FadeAnimatorListener(View paramView)
    {
      this.mView = paramView;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      ViewUtils.setTransitionAlpha(this.mView, 1.0F);
      if (this.mLayerTypeChanged) {
        this.mView.setLayerType(0, null);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if ((ViewCompat.hasOverlappingRendering(this.mView)) && (this.mView.getLayerType() == 0))
      {
        this.mLayerTypeChanged = true;
        this.mView.setLayerType(2, null);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\Fade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */