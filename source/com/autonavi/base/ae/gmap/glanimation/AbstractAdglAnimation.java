package com.autonavi.base.ae.gmap.glanimation;

public abstract class AbstractAdglAnimation
{
  public static final int DEFAULT_DURATION = 250;
  public static final int INTERPOLATOR_ACCELERATE = 1;
  public static final int INTERPOLATOR_ACCELERATE_DECELERATE = 3;
  public static final int INTERPOLATOR_BOUNCE = 4;
  public static final int INTERPOLATOR_DECELERATE = 2;
  public static final int INTERPOLATOR_DOUBLE_RAISE = 6;
  public static final int INTERPOLATOR_LINEAR = 0;
  public static final int INTERPOLATOR_OVERSHOOT = 5;
  public static final int INVALIDE_VALUE = -9999;
  protected int duration = 300;
  protected boolean isOver = false;
  protected long offsetTime = 0L;
  protected long startTime = -1L;
  
  public abstract void doAnimation(Object paramObject);
  
  public boolean isOver()
  {
    return this.isOver;
  }
  
  public boolean isValid()
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AbstractAdglAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */