package android.support.design.shape;

import android.support.design.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class TriangleEdgeTreatment
  extends EdgeTreatment
{
  private final boolean inside;
  private final float size;
  
  public TriangleEdgeTreatment(float paramFloat, boolean paramBoolean)
  {
    this.size = paramFloat;
    this.inside = paramBoolean;
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, ShapePath paramShapePath)
  {
    float f2 = paramFloat1 / 2.0F;
    paramShapePath.lineTo(f2 - this.size * paramFloat2, 0.0F);
    if (this.inside) {}
    for (float f1 = this.size;; f1 = -this.size) {
      break;
    }
    paramShapePath.lineTo(f2, f1 * paramFloat2);
    paramShapePath.lineTo(f2 + this.size * paramFloat2, 0.0F);
    paramShapePath.lineTo(paramFloat1, 0.0F);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\shape\TriangleEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */