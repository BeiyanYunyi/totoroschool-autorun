package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.RestrictTo;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale
  extends Transition
{
  private static final String PROPNAME_SCALE = "android:textscale:scale";
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    if ((paramTransitionValues.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramTransitionValues.view;
      paramTransitionValues.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(final ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null) && ((paramTransitionValues1.view instanceof TextView)))
    {
      if (!(paramTransitionValues2.view instanceof TextView)) {
        return null;
      }
      paramViewGroup = (TextView)paramTransitionValues2.view;
      paramTransitionValues1 = paramTransitionValues1.values;
      paramTransitionValues2 = paramTransitionValues2.values;
      Object localObject = paramTransitionValues1.get("android:textscale:scale");
      float f2 = 1.0F;
      float f1;
      if (localObject != null) {
        f1 = ((Float)paramTransitionValues1.get("android:textscale:scale")).floatValue();
      } else {
        f1 = 1.0F;
      }
      if (paramTransitionValues2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramTransitionValues2.get("android:textscale:scale")).floatValue();
      }
      if (f1 == f2) {
        return null;
      }
      paramTransitionValues1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
      paramTransitionValues1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramViewGroup.setScaleX(f);
          paramViewGroup.setScaleY(f);
        }
      });
      return paramTransitionValues1;
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\TextScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */