package android.support.design.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class ImageMatrixProperty
  extends Property<ImageView, Matrix>
{
  private final Matrix matrix = new Matrix();
  
  public ImageMatrixProperty()
  {
    super(Matrix.class, "imageMatrixProperty");
  }
  
  public Matrix get(ImageView paramImageView)
  {
    this.matrix.set(paramImageView.getImageMatrix());
    return this.matrix;
  }
  
  public void set(ImageView paramImageView, Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\animation\ImageMatrixProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */