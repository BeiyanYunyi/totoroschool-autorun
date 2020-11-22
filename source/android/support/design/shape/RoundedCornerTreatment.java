package android.support.design.shape;

import android.support.design.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class RoundedCornerTreatment
  extends CornerTreatment
{
  private final float radius;
  
  public RoundedCornerTreatment(float paramFloat)
  {
    this.radius = paramFloat;
  }
  
  public void getCornerPath(float paramFloat1, float paramFloat2, ShapePath paramShapePath)
  {
    paramShapePath.reset(0.0F, this.radius * paramFloat2);
    paramShapePath.addArc(0.0F, 0.0F, this.radius * 2.0F * paramFloat2, this.radius * 2.0F * paramFloat2, paramFloat1 + 180.0F, 90.0F);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\shape\RoundedCornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */