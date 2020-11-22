package android.support.design.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class MotionTiming
{
  private long delay = 0L;
  private long duration = 300L;
  @Nullable
  private TimeInterpolator interpolator = null;
  private int repeatCount = 0;
  private int repeatMode = 1;
  
  public MotionTiming(long paramLong1, long paramLong2)
  {
    this.delay = paramLong1;
    this.duration = paramLong2;
  }
  
  public MotionTiming(long paramLong1, long paramLong2, @NonNull TimeInterpolator paramTimeInterpolator)
  {
    this.delay = paramLong1;
    this.duration = paramLong2;
    this.interpolator = paramTimeInterpolator;
  }
  
  static MotionTiming createFromAnimator(ValueAnimator paramValueAnimator)
  {
    MotionTiming localMotionTiming = new MotionTiming(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), getInterpolatorCompat(paramValueAnimator));
    localMotionTiming.repeatCount = paramValueAnimator.getRepeatCount();
    localMotionTiming.repeatMode = paramValueAnimator.getRepeatMode();
    return localMotionTiming;
  }
  
  private static TimeInterpolator getInterpolatorCompat(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getInterpolator();
    if ((!(paramValueAnimator instanceof AccelerateDecelerateInterpolator)) && (paramValueAnimator != null))
    {
      if ((paramValueAnimator instanceof AccelerateInterpolator)) {
        return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
      }
      if ((paramValueAnimator instanceof DecelerateInterpolator)) {
        return AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
      }
      return paramValueAnimator;
    }
    return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
  }
  
  public void apply(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(getDelay());
    paramAnimator.setDuration(getDuration());
    paramAnimator.setInterpolator(getInterpolator());
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = (ValueAnimator)paramAnimator;
      paramAnimator.setRepeatCount(getRepeatCount());
      paramAnimator.setRepeatMode(getRepeatMode());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MotionTiming)paramObject;
      if (getDelay() != ((MotionTiming)paramObject).getDelay()) {
        return false;
      }
      if (getDuration() != ((MotionTiming)paramObject).getDuration()) {
        return false;
      }
      if (getRepeatCount() != ((MotionTiming)paramObject).getRepeatCount()) {
        return false;
      }
      if (getRepeatMode() != ((MotionTiming)paramObject).getRepeatMode()) {
        return false;
      }
      return getInterpolator().getClass().equals(((MotionTiming)paramObject).getInterpolator().getClass());
    }
    return false;
  }
  
  public long getDelay()
  {
    return this.delay;
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public TimeInterpolator getInterpolator()
  {
    if (this.interpolator != null) {
      return this.interpolator;
    }
    return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
  }
  
  public int getRepeatCount()
  {
    return this.repeatCount;
  }
  
  public int getRepeatMode()
  {
    return this.repeatMode;
  }
  
  public int hashCode()
  {
    return ((((int)(getDelay() ^ getDelay() >>> 32) * 31 + (int)(getDuration() ^ getDuration() >>> 32)) * 31 + getInterpolator().getClass().hashCode()) * 31 + getRepeatCount()) * 31 + getRepeatMode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" delay: ");
    localStringBuilder.append(getDelay());
    localStringBuilder.append(" duration: ");
    localStringBuilder.append(getDuration());
    localStringBuilder.append(" interpolator: ");
    localStringBuilder.append(getInterpolator().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(getRepeatCount());
    localStringBuilder.append(" repeatMode: ");
    localStringBuilder.append(getRepeatMode());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\animation\MotionTiming.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */