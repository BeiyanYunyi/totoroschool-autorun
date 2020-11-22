package android.support.design.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.animation.AnimatorSetCompat;
import android.support.design.animation.MotionTiming;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior
  extends ExpandableTransformationBehavior
{
  public static final long COLLAPSE_DELAY = 0L;
  public static final long COLLAPSE_DURATION = 150L;
  public static final long EXPAND_DELAY = 75L;
  public static final long EXPAND_DURATION = 150L;
  private final MotionTiming collapseTiming = new MotionTiming(0L, 150L);
  private final MotionTiming expandTiming = new MotionTiming(75L, 150L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void createScrimAnimation(View paramView, boolean paramBoolean1, boolean paramBoolean2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (paramBoolean1) {
      paramList1 = this.expandTiming;
    } else {
      paramList1 = this.collapseTiming;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView.setAlpha(0.0F);
      }
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F });
    }
    else
    {
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F });
    }
    paramList1.apply(paramView);
    paramList.add(paramView);
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }
  
  @NonNull
  protected AnimatorSet onCreateExpandedStateChangeAnimation(View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    paramView1 = new ArrayList();
    createScrimAnimation(paramView2, paramBoolean1, paramBoolean2, paramView1, new ArrayList());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    AnimatorSetCompat.playTogether(localAnimatorSet, paramView1);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!paramBoolean1) {
          paramView2.setVisibility(4);
        }
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (paramBoolean1) {
          paramView2.setVisibility(0);
        }
      }
    });
    return localAnimatorSet;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\transformation\FabTransformationScrimBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */