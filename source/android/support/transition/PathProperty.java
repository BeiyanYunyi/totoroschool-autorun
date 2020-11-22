package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T>
  extends Property<T, Float>
{
  private float mCurrentFraction;
  private final float mPathLength;
  private final PathMeasure mPathMeasure;
  private final PointF mPointF = new PointF();
  private final float[] mPosition = new float[2];
  private final Property<T, PointF> mProperty;
  
  PathProperty(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.mProperty = paramProperty;
    this.mPathMeasure = new PathMeasure(paramPath, false);
    this.mPathLength = this.mPathMeasure.getLength();
  }
  
  public Float get(T paramT)
  {
    return Float.valueOf(this.mCurrentFraction);
  }
  
  public void set(T paramT, Float paramFloat)
  {
    this.mCurrentFraction = paramFloat.floatValue();
    this.mPathMeasure.getPosTan(this.mPathLength * paramFloat.floatValue(), this.mPosition, null);
    this.mPointF.x = this.mPosition[0];
    this.mPointF.y = this.mPosition[1];
    this.mProperty.set(paramT, this.mPointF);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\PathProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */