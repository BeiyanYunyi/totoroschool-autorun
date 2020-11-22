package com.autonavi.base.ae.gmap.glanimation;

public class AbstractAdglAnimationParam1V
  extends AbstractAdglAnimationParam
{
  private float fromValue;
  private float toValue;
  
  public AbstractAdglAnimationParam1V()
  {
    reset();
  }
  
  public void checkParam()
  {
    this.needToCaculate = false;
    if ((this.hasFromValue) && (this.hasToValue) && (Math.abs(this.toValue - this.fromValue) > 1.0E-4D)) {
      this.needToCaculate = true;
    }
    this.hasCheckedParam = true;
  }
  
  public float getCurValue()
  {
    return this.fromValue + (this.toValue - this.fromValue) * this.mult;
  }
  
  public float getFromValue()
  {
    return this.fromValue;
  }
  
  public float getToValue()
  {
    return this.toValue;
  }
  
  public void reset()
  {
    super.reset();
    this.fromValue = 0.0F;
    this.toValue = 0.0F;
  }
  
  public void setFromValue(float paramFloat)
  {
    this.fromValue = paramFloat;
    this.hasFromValue = true;
    this.hasCheckedParam = false;
  }
  
  public void setToValue(float paramFloat)
  {
    this.toValue = paramFloat;
    this.hasToValue = true;
    this.hasCheckedParam = false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AbstractAdglAnimationParam1V.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */