package android.support.design.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.annotation.RestrictTo;
import java.util.List;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorSetCompat
{
  public static void playTogether(AnimatorSet paramAnimatorSet, List<Animator> paramList)
  {
    int j = paramList.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      localObject = (Animator)paramList.get(i);
      l = Math.max(l, ((Animator)localObject).getStartDelay() + ((Animator)localObject).getDuration());
      i += 1;
    }
    Object localObject = ValueAnimator.ofInt(new int[] { 0, 0 });
    ((Animator)localObject).setDuration(l);
    paramList.add(0, localObject);
    paramAnimatorSet.playTogether(paramList);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\animation\AnimatorSetCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */