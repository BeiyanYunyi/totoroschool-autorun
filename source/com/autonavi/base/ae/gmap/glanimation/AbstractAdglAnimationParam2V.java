package com.autonavi.base.ae.gmap.glanimation;

public class AbstractAdglAnimationParam2V
  extends AbstractAdglAnimationParam
{
  public double fromXValue;
  public double fromYValue;
  public double toXValue;
  public double toYValue;
  
  public AbstractAdglAnimationParam2V()
  {
    reset();
  }
  
  public void checkParam()
  {
    this.needToCaculate = false;
    if ((this.hasFromValue) && (this.hasToValue))
    {
      double d1 = this.toXValue;
      double d2 = this.fromXValue;
      double d3 = this.toYValue;
      double d4 = this.fromYValue;
      if ((Math.abs(d1 - d2) > 1.0E-4D) || (Math.abs(d3 - d4) > 1.0E-4D)) {
        this.needToCaculate = true;
      }
    }
    this.hasCheckedParam = true;
  }
  
  public double getCurXValue()
  {
    double d1 = this.fromXValue;
    double d2 = this.toXValue;
    double d3 = this.fromXValue;
    double d4 = this.mult;
    Double.isNaN(d4);
    return d1 + (d2 - d3) * d4;
  }
  
  public double getCurYValue()
  {
    double d1 = this.fromYValue;
    double d2 = this.toYValue;
    double d3 = this.fromYValue;
    double d4 = this.mult;
    Double.isNaN(d4);
    return d1 + (d2 - d3) * d4;
  }
  
  public double getFromXValue()
  {
    return this.fromXValue;
  }
  
  public double getFromYValue()
  {
    return this.fromYValue;
  }
  
  public double getToXValue()
  {
    return this.toXValue;
  }
  
  public double getToYValue()
  {
    return this.toYValue;
  }
  
  public void reset()
  {
    super.reset();
    this.fromXValue = 0.0D;
    this.toXValue = 0.0D;
    this.fromYValue = 0.0D;
    this.toYValue = 0.0D;
  }
  
  public void setFromValue(double paramDouble1, double paramDouble2)
  {
    this.fromXValue = paramDouble1;
    this.fromYValue = paramDouble2;
    this.hasFromValue = true;
    this.hasCheckedParam = false;
  }
  
  public void setToValue(double paramDouble1, double paramDouble2)
  {
    this.toXValue = paramDouble1;
    this.toYValue = paramDouble2;
    this.hasToValue = true;
    this.hasCheckedParam = false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AbstractAdglAnimationParam2V.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */