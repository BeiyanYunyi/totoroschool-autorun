package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.annotation.RestrictTo;
import android.util.StateSet;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator
{
  private final Animator.AnimatorListener animationListener = new AnimatorListenerAdapter()
  {
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (StateListAnimator.this.runningAnimator == paramAnonymousAnimator) {
        StateListAnimator.this.runningAnimator = null;
      }
    }
  };
  private Tuple lastMatch = null;
  ValueAnimator runningAnimator = null;
  private final ArrayList<Tuple> tuples = new ArrayList();
  
  private void cancel()
  {
    if (this.runningAnimator != null)
    {
      this.runningAnimator.cancel();
      this.runningAnimator = null;
    }
  }
  
  private void start(Tuple paramTuple)
  {
    this.runningAnimator = paramTuple.animator;
    this.runningAnimator.start();
  }
  
  public void addState(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new Tuple(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.animationListener);
    this.tuples.add(paramArrayOfInt);
  }
  
  public void jumpToCurrentState()
  {
    if (this.runningAnimator != null)
    {
      this.runningAnimator.end();
      this.runningAnimator = null;
    }
  }
  
  public void setState(int[] paramArrayOfInt)
  {
    int j = this.tuples.size();
    int i = 0;
    while (i < j)
    {
      Tuple localTuple = (Tuple)this.tuples.get(i);
      if (StateSet.stateSetMatches(localTuple.specs, paramArrayOfInt))
      {
        paramArrayOfInt = localTuple;
        break label55;
      }
      i += 1;
    }
    paramArrayOfInt = null;
    label55:
    if (paramArrayOfInt == this.lastMatch) {
      return;
    }
    if (this.lastMatch != null) {
      cancel();
    }
    this.lastMatch = paramArrayOfInt;
    if (paramArrayOfInt != null) {
      start(paramArrayOfInt);
    }
  }
  
  static class Tuple
  {
    final ValueAnimator animator;
    final int[] specs;
    
    Tuple(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.specs = paramArrayOfInt;
      this.animator = paramValueAnimator;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\StateListAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */