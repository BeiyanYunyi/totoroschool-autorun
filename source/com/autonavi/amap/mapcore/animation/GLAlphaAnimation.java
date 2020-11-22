package com.autonavi.amap.mapcore.animation;

public class GLAlphaAnimation
  extends GLAnimation
{
  public float mCurAlpha = 0.0F;
  public float mFromAlpha = 0.0F;
  public float mToAlpha = 1.0F;
  
  public GLAlphaAnimation(float paramFloat1, float paramFloat2)
  {
    this.mFromAlpha = paramFloat1;
    this.mToAlpha = paramFloat2;
  }
  
  protected void applyTransformation(float paramFloat, GLTransformation paramGLTransformation)
  {
    float f = this.mFromAlpha;
    this.mCurAlpha = (f + (this.mToAlpha - f) * paramFloat);
    paramGLTransformation.alpha = this.mCurAlpha;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\animation\GLAlphaAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */