package android.support.design.animation;

import android.animation.TimeInterpolator;
import android.support.annotation.RestrictTo;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils
{
  public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
  public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR;
  public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
  public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR;
  
  static
  {
    FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  public static int lerp(int paramInt1, int paramInt2, float paramFloat)
  {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\animation\AnimationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */