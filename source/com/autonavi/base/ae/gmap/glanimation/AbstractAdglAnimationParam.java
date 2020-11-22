package com.autonavi.base.ae.gmap.glanimation;

public abstract class AbstractAdglAnimationParam
{
  protected float factor = 1.0F;
  protected boolean hasCheckedParam = false;
  protected boolean hasFromValue = false;
  protected boolean hasToValue = false;
  protected int interpolationType = 0;
  protected float mult;
  protected boolean needToCaculate = false;
  protected float normalizedTime;
  
  static float bounce(float paramFloat)
  {
    return paramFloat * paramFloat * 8.0F;
  }
  
  public abstract void checkParam();
  
  public float getCurMult()
  {
    return this.mult;
  }
  
  public int getInterpolatorType()
  {
    return this.interpolationType;
  }
  
  public boolean needToCaculate()
  {
    if (!this.hasCheckedParam) {
      checkParam();
    }
    return (this.hasCheckedParam) && (this.needToCaculate);
  }
  
  public void reset()
  {
    this.hasCheckedParam = false;
    this.needToCaculate = false;
    this.interpolationType = 0;
    this.factor = 1.0F;
    this.hasCheckedParam = false;
    this.needToCaculate = false;
    this.hasFromValue = false;
    this.hasToValue = false;
  }
  
  public void setInterpolatorType(int paramInt, float paramFloat)
  {
    this.interpolationType = paramInt;
    this.factor = paramFloat;
  }
  
  public void setNormalizedTime(float paramFloat)
  {
    this.normalizedTime = paramFloat;
    float f = paramFloat;
    switch (this.interpolationType)
    {
    default: 
    case 6: 
      do
      {
        do
        {
          f = 0.0F;
          break;
        } while (paramFloat < 0.0F);
        if (paramFloat < 0.25F)
        {
          f = paramFloat * 4.0F;
          break;
        }
        if (paramFloat < 0.5F)
        {
          f = 2.0F - paramFloat * 4.0F;
          break;
        }
        if (paramFloat < 0.75F)
        {
          f = paramFloat * 4.0F - 2.0F;
          break;
        }
      } while (paramFloat > 1.0F);
      f = 4.0F - paramFloat * 4.0F;
      break;
    case 5: 
      paramFloat -= 1.0F;
      f = paramFloat * paramFloat * (3.0F * paramFloat + 2.0F) + 1.0F;
      break;
    case 4: 
      paramFloat *= 1.1226F;
      if (paramFloat < 0.3535F) {
        f = bounce(paramFloat);
      } else if (paramFloat < 0.7408F) {
        f = bounce(paramFloat - 0.54719F) + 0.7F;
      } else if (paramFloat < 0.9644F) {
        f = bounce(paramFloat - 0.8526F) + 0.9F;
      } else {
        f = bounce(paramFloat - 1.0435F) + 0.95F;
      }
      break;
    case 3: 
      double d = paramFloat + 1.0F;
      Double.isNaN(d);
      f = (float)(Math.cos(d * 3.141592653589793D) / 2.0D + 0.5D);
      break;
    case 2: 
      if (this.factor == 1.0F)
      {
        paramFloat = 1.0F - paramFloat;
        f = 1.0F - paramFloat * paramFloat;
      }
      else
      {
        f = (float)(1.0D - Math.pow(1.0F - paramFloat, this.factor * 2.0F));
      }
      break;
    case 1: 
      f = (float)Math.pow(paramFloat, this.factor * 2.0F);
    }
    this.mult = f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AbstractAdglAnimationParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */