package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.RequiresApi;
import android.support.design.R.attr;
import android.support.design.R.integer;
import android.support.design.internal.ThemeEnforcement;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

@RequiresApi(21)
class ViewUtilsLollipop
{
  private static final int[] STATE_LIST_ANIM_ATTRS = { 16843848 };
  
  static void setBoundsViewOutlineProvider(View paramView)
  {
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
  }
  
  static void setDefaultAppBarLayoutStateListAnimator(View paramView, float paramFloat)
  {
    int i = paramView.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    int j = R.attr.state_liftable;
    int k = -R.attr.state_lifted;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F });
    long l = i;
    localObjectAnimator = localObjectAnimator.setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766, j, k }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    paramView.setStateListAnimator(localStateListAnimator);
  }
  
  static void setStateListAnimatorFromAttrs(View paramView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Context localContext = paramView.getContext();
    paramAttributeSet = ThemeEnforcement.obtainStyledAttributes(localContext, paramAttributeSet, STATE_LIST_ANIM_ATTRS, paramInt1, paramInt2, new int[0]);
    try
    {
      if (paramAttributeSet.hasValue(0)) {
        paramView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(localContext, paramAttributeSet.getResourceId(0, 0)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\ViewUtilsLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */