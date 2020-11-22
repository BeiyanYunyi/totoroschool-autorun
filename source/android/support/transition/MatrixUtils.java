package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;

class MatrixUtils
{
  static final Matrix IDENTITY_MATRIX = new Matrix()
  {
    void oops()
    {
      throw new IllegalStateException("Matrix can not be modified");
    }
    
    public boolean postConcat(Matrix paramAnonymousMatrix)
    {
      oops();
      return false;
    }
    
    public boolean postRotate(float paramAnonymousFloat)
    {
      oops();
      return false;
    }
    
    public boolean postRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
    {
      oops();
      return false;
    }
    
    public boolean postScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
      return false;
    }
    
    public boolean postScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      oops();
      return false;
    }
    
    public boolean postSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
      return false;
    }
    
    public boolean postSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      oops();
      return false;
    }
    
    public boolean postTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
      return false;
    }
    
    public boolean preConcat(Matrix paramAnonymousMatrix)
    {
      oops();
      return false;
    }
    
    public boolean preRotate(float paramAnonymousFloat)
    {
      oops();
      return false;
    }
    
    public boolean preRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
    {
      oops();
      return false;
    }
    
    public boolean preScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
      return false;
    }
    
    public boolean preScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      oops();
      return false;
    }
    
    public boolean preSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
      return false;
    }
    
    public boolean preSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      oops();
      return false;
    }
    
    public boolean preTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
      return false;
    }
    
    public void reset()
    {
      oops();
    }
    
    public void set(Matrix paramAnonymousMatrix)
    {
      oops();
    }
    
    public boolean setConcat(Matrix paramAnonymousMatrix1, Matrix paramAnonymousMatrix2)
    {
      oops();
      return false;
    }
    
    public boolean setPolyToPoly(float[] paramAnonymousArrayOfFloat1, int paramAnonymousInt1, float[] paramAnonymousArrayOfFloat2, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      oops();
      return false;
    }
    
    public boolean setRectToRect(RectF paramAnonymousRectF1, RectF paramAnonymousRectF2, Matrix.ScaleToFit paramAnonymousScaleToFit)
    {
      oops();
      return false;
    }
    
    public void setRotate(float paramAnonymousFloat)
    {
      oops();
    }
    
    public void setRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
    {
      oops();
    }
    
    public void setScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
    }
    
    public void setScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      oops();
    }
    
    public void setSinCos(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
    }
    
    public void setSinCos(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      oops();
    }
    
    public void setSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
    }
    
    public void setSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      oops();
    }
    
    public void setTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      oops();
    }
    
    public void setValues(float[] paramAnonymousArrayOfFloat)
    {
      oops();
    }
  };
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\MatrixUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */