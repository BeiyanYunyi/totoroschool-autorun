package android.support.design.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.design.internal.Experimental;
import java.util.ArrayList;
import java.util.List;

@Experimental("The shapes API is currently experimental and subject to change")
public class ShapePath
{
  public float endX;
  public float endY;
  private final List<PathOperation> operations = new ArrayList();
  public float startX;
  public float startY;
  
  public ShapePath()
  {
    reset(0.0F, 0.0F);
  }
  
  public ShapePath(float paramFloat1, float paramFloat2)
  {
    reset(paramFloat1, paramFloat2);
  }
  
  public void addArc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    PathArcOperation localPathArcOperation = new PathArcOperation(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    localPathArcOperation.startAngle = paramFloat5;
    localPathArcOperation.sweepAngle = paramFloat6;
    this.operations.add(localPathArcOperation);
    float f = (paramFloat3 - paramFloat1) / 2.0F;
    double d = paramFloat5 + paramFloat6;
    this.endX = ((paramFloat1 + paramFloat3) * 0.5F + f * (float)Math.cos(Math.toRadians(d)));
    this.endY = ((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(d)));
  }
  
  public void applyToPath(Matrix paramMatrix, Path paramPath)
  {
    int j = this.operations.size();
    int i = 0;
    while (i < j)
    {
      ((PathOperation)this.operations.get(i)).applyToPath(paramMatrix, paramPath);
      i += 1;
    }
  }
  
  public void lineTo(float paramFloat1, float paramFloat2)
  {
    PathLineOperation localPathLineOperation = new PathLineOperation();
    PathLineOperation.access$002(localPathLineOperation, paramFloat1);
    PathLineOperation.access$102(localPathLineOperation, paramFloat2);
    this.operations.add(localPathLineOperation);
    this.endX = paramFloat1;
    this.endY = paramFloat2;
  }
  
  public void quadToPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    PathQuadOperation localPathQuadOperation = new PathQuadOperation();
    localPathQuadOperation.controlX = paramFloat1;
    localPathQuadOperation.controlY = paramFloat2;
    localPathQuadOperation.endX = paramFloat3;
    localPathQuadOperation.endY = paramFloat4;
    this.operations.add(localPathQuadOperation);
    this.endX = paramFloat3;
    this.endY = paramFloat4;
  }
  
  public void reset(float paramFloat1, float paramFloat2)
  {
    this.startX = paramFloat1;
    this.startY = paramFloat2;
    this.endX = paramFloat1;
    this.endY = paramFloat2;
    this.operations.clear();
  }
  
  public static class PathArcOperation
    extends ShapePath.PathOperation
  {
    private static final RectF rectF = new RectF();
    public float bottom;
    public float left;
    public float right;
    public float startAngle;
    public float sweepAngle;
    public float top;
    
    public PathArcOperation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.left = paramFloat1;
      this.top = paramFloat2;
      this.right = paramFloat3;
      this.bottom = paramFloat4;
    }
    
    public void applyToPath(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.matrix;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      rectF.set(this.left, this.top, this.right, this.bottom);
      paramPath.arcTo(rectF, this.startAngle, this.sweepAngle, false);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static class PathLineOperation
    extends ShapePath.PathOperation
  {
    private float x;
    private float y;
    
    public void applyToPath(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.matrix;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.lineTo(this.x, this.y);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static abstract class PathOperation
  {
    protected final Matrix matrix = new Matrix();
    
    public abstract void applyToPath(Matrix paramMatrix, Path paramPath);
  }
  
  public static class PathQuadOperation
    extends ShapePath.PathOperation
  {
    public float controlX;
    public float controlY;
    public float endX;
    public float endY;
    
    public void applyToPath(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.matrix;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.quadTo(this.controlX, this.controlY, this.endX, this.endY);
      paramPath.transform(paramMatrix);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\shape\ShapePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */