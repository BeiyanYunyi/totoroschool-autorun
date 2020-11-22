package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  @Nullable
  private AnimatorSet currentAnimation;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected abstract AnimatorSet onCreateExpandedStateChangeAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  @CallSuper
  protected boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (this.currentAnimation != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.currentAnimation.cancel();
    }
    this.currentAnimation = onCreateExpandedStateChangeAnimation(paramView1, paramView2, paramBoolean1, bool);
    this.currentAnimation.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ExpandableTransformationBehavior.access$002(ExpandableTransformationBehavior.this, null);
      }
    });
    this.currentAnimation.start();
    if (!paramBoolean2) {
      this.currentAnimation.end();
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\transformation\ExpandableTransformationBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */