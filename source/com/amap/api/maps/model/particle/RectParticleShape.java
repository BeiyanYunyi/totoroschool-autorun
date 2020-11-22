package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

public class RectParticleShape
  extends ParticleShapeModule
{
  private final float bottom;
  private final float left;
  private final float right;
  private final float top;
  
  public RectParticleShape(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
    this.isUseRatio = paramBoolean;
    createNativeInstace();
    this.type = 1;
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateRectParticleShape(this.left, this.top, this.right, this.bottom, this.isUseRatio);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public float[] getPoint()
  {
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\RectParticleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */