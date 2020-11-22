package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;

public class AdglAnimation2V
  extends AbstractAdglAnimation
{
  private double curValue1;
  private double curValue2;
  private AbstractAdglAnimationParam2V v2Param = null;
  
  public AdglAnimation2V(int paramInt)
  {
    reset();
    this.duration = paramInt;
    this.curValue1 = 0.0D;
    this.curValue2 = 0.0D;
  }
  
  public void doAnimation(Object paramObject)
  {
    if (this.isOver) {
      return;
    }
    this.offsetTime = (SystemClock.uptimeMillis() - this.startTime);
    float f2 = (float)this.offsetTime / this.duration;
    float f1;
    if (f2 > 1.0F)
    {
      this.isOver = true;
      f1 = 1.0F;
    }
    else
    {
      f1 = f2;
      if (f2 < 0.0F)
      {
        this.isOver = true;
        return;
      }
    }
    if (this.v2Param != null)
    {
      this.v2Param.setNormalizedTime(f1);
      this.curValue1 = this.v2Param.getCurXValue();
      this.curValue2 = this.v2Param.getCurYValue();
    }
  }
  
  public double getCurValue(int paramInt)
  {
    if (paramInt == 0) {
      return this.curValue1;
    }
    return this.curValue2;
  }
  
  public double getEndValue(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.v2Param != null) {
        return this.v2Param.getToXValue();
      }
      return 0.0D;
    }
    if (this.v2Param != null) {
      return this.v2Param.getToYValue();
    }
    return 0.0D;
  }
  
  public double getStartValue(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.v2Param != null) {
        return this.v2Param.getFromXValue();
      }
      return 0.0D;
    }
    if (this.v2Param != null) {
      return this.v2Param.getFromYValue();
    }
    return 0.0D;
  }
  
  public void reset()
  {
    this.isOver = false;
    this.duration = 0;
    this.curValue1 = 0.0D;
    this.curValue2 = 0.0D;
    if (this.v2Param != null) {
      this.v2Param.reset();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AdglAnimation2V.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */