package com.autonavi.amap.mapcore.animation;

public class GLScaleAnimation
  extends GLAnimation
{
  private float mFromX;
  private float mFromY;
  private float mPivotX;
  private float mPivotY;
  private float mToX;
  private float mToY;
  
  public GLScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mFromX = paramFloat1;
    this.mToX = paramFloat2;
    this.mFromY = paramFloat3;
    this.mToY = paramFloat4;
    this.mPivotX = 0.0F;
    this.mPivotY = 0.0F;
  }
  
  protected void applyTransformation(float paramFloat, GLTransformation paramGLTransformation)
  {
    float f1 = this.mFromX;
    float f2 = 1.0F;
    if ((f1 == 1.0F) && (this.mToX == 1.0F)) {
      f1 = 1.0F;
    } else {
      f1 = this.mFromX + (this.mToX - this.mFromX) * paramFloat;
    }
    if ((this.mFromY != 1.0F) || (this.mToY != 1.0F)) {
      f2 = this.mFromY + (this.mToY - this.mFromY) * paramFloat;
    }
    if ((this.mPivotX == 0.0F) && (this.mPivotY == 0.0F))
    {
      paramGLTransformation.scaleX = f1;
      paramGLTransformation.scaleY = f2;
      return;
    }
    paramGLTransformation.scaleX = f1;
    paramGLTransformation.scaleY = f2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLScaleAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */