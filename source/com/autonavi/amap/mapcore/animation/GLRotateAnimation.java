package com.autonavi.amap.mapcore.animation;

public class GLRotateAnimation
  extends GLAnimation
{
  private float mFromDegrees = 0.0F;
  private float mToDegrees = 1.0F;
  
  public GLRotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.mFromDegrees = paramFloat1;
    this.mToDegrees = paramFloat2;
  }
  
  protected void applyTransformation(float paramFloat, GLTransformation paramGLTransformation)
  {
    paramGLTransformation.rotate = (this.mFromDegrees + (this.mToDegrees - this.mFromDegrees) * paramFloat);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLRotateAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */