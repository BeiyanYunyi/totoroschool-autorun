package com.autonavi.base.ae.gmap.gloverlay;

public class GLOverlayTexture
{
  public int mAnchor;
  public float mAnchorXRatio;
  public float mAnchorYRatio;
  public int mHeight;
  public int mResHeight;
  public int mResId = 0;
  public int mResWidth;
  public int mWidth;
  
  public GLOverlayTexture(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    this.mResId = paramInt1;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    this.mResWidth = paramInt3;
    this.mResHeight = paramInt4;
    this.mAnchor = paramInt2;
    this.mAnchorXRatio = paramFloat1;
    this.mAnchorYRatio = paramFloat2;
  }
  
  public GLOverlayTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mResId = paramInt1;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    this.mResWidth = paramInt3;
    this.mResHeight = paramInt4;
    this.mAnchor = paramInt2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\gloverlay\GLOverlayTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */