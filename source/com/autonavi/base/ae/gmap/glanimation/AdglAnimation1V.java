package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;

public class AdglAnimation1V
  extends AbstractAdglAnimation
{
  private float curValue;
  private AbstractAdglAnimationParam1V v1Param = null;
  
  public AdglAnimation1V(int paramInt)
  {
    reset();
    this.duration = paramInt;
    this.curValue = 0.0F;
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
    if (this.v1Param != null)
    {
      this.v1Param.setNormalizedTime(f1);
      this.curValue = this.v1Param.getCurValue();
    }
  }
  
  public float getCurValue()
  {
    return this.curValue;
  }
  
  public float getEndValue()
  {
    if (this.v1Param != null) {
      return this.v1Param.getToValue();
    }
    return 0.0F;
  }
  
  public float getStartValue()
  {
    if (this.v1Param != null) {
      return this.v1Param.getFromValue();
    }
    return 0.0F;
  }
  
  public void reset()
  {
    this.isOver = false;
    this.duration = 0;
    if (this.v1Param != null) {
      this.v1Param.reset();
    }
  }
  
  public void setAnimationValue(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (this.v1Param == null) {
      this.v1Param = new AbstractAdglAnimationParam1V();
    }
    this.v1Param.reset();
    this.v1Param.setInterpolatorType(paramInt, 1.0F);
    this.v1Param.setFromValue(paramFloat1);
    this.v1Param.setToValue(paramFloat2);
    this.startTime = SystemClock.uptimeMillis();
    this.isOver = false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AdglAnimation1V.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */