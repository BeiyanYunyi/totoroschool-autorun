package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator
  implements Interpolator
{
  private final float mStepSize;
  private final float[] mValues;
  
  protected LookupTableInterpolator(float[] paramArrayOfFloat)
  {
    this.mValues = paramArrayOfFloat;
    this.mStepSize = (1.0F / (this.mValues.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.mValues.length - 1) * paramFloat), this.mValues.length - 2);
    paramFloat = (paramFloat - i * this.mStepSize) / this.mStepSize;
    return this.mValues[i] + paramFloat * (this.mValues[(i + 1)] - this.mValues[i]);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\animation\LookupTableInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */