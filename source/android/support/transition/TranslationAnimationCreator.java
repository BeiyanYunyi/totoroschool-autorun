package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

class TranslationAnimationCreator
{
  static Animator createAnimation(View paramView, TransitionValues paramTransitionValues, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TimeInterpolator paramTimeInterpolator)
  {
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    Object localObject = (int[])paramTransitionValues.view.getTag(R.id.transition_position);
    if (localObject != null)
    {
      paramFloat1 = localObject[0] - paramInt1 + f1;
      paramFloat2 = localObject[1] - paramInt2 + f2;
    }
    int i = Math.round(paramFloat1 - f1);
    int j = Math.round(paramFloat2 - f2);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    if ((paramFloat1 == paramFloat3) && (paramFloat2 == paramFloat4)) {
      return null;
    }
    localObject = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat3 }), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat2, paramFloat4 }) });
    paramView = new TransitionPositionListener(paramView, paramTransitionValues.view, paramInt1 + i, paramInt2 + j, f1, f2);
    ((ObjectAnimator)localObject).addListener(paramView);
    AnimatorUtils.addPauseListener((Animator)localObject, paramView);
    ((ObjectAnimator)localObject).setInterpolator(paramTimeInterpolator);
    return (Animator)localObject;
  }
  
  private static class TransitionPositionListener
    extends AnimatorListenerAdapter
  {
    private final View mMovingView;
    private float mPausedX;
    private float mPausedY;
    private final int mStartX;
    private final int mStartY;
    private final float mTerminalX;
    private final float mTerminalY;
    private int[] mTransitionPosition;
    private final View mViewInHierarchy;
    
    TransitionPositionListener(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      this.mMovingView = paramView1;
      this.mViewInHierarchy = paramView2;
      this.mStartX = (paramInt1 - Math.round(this.mMovingView.getTranslationX()));
      this.mStartY = (paramInt2 - Math.round(this.mMovingView.getTranslationY()));
      this.mTerminalX = paramFloat1;
      this.mTerminalY = paramFloat2;
      this.mTransitionPosition = ((int[])this.mViewInHierarchy.getTag(R.id.transition_position));
      if (this.mTransitionPosition != null) {
        this.mViewInHierarchy.setTag(R.id.transition_position, null);
      }
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      if (this.mTransitionPosition == null) {
        this.mTransitionPosition = new int[2];
      }
      this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
      this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
      this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.mMovingView.setTranslationX(this.mTerminalX);
      this.mMovingView.setTranslationY(this.mTerminalY);
    }
    
    public void onAnimationPause(Animator paramAnimator)
    {
      this.mPausedX = this.mMovingView.getTranslationX();
      this.mPausedY = this.mMovingView.getTranslationY();
      this.mMovingView.setTranslationX(this.mTerminalX);
      this.mMovingView.setTranslationY(this.mTerminalY);
    }
    
    public void onAnimationResume(Animator paramAnimator)
    {
      this.mMovingView.setTranslationX(this.mPausedX);
      this.mMovingView.setTranslationY(this.mPausedY);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\TranslationAnimationCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */