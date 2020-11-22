package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

public class SinglePointParticleShape
  extends ParticleShapeModule
{
  private float[] point_3 = new float[3];
  
  public SinglePointParticleShape(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramFloat1, paramFloat2, paramFloat3, false);
  }
  
  public SinglePointParticleShape(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.point_3[0] = paramFloat1;
    this.point_3[1] = paramFloat2;
    this.point_3[2] = paramFloat3;
    this.isUseRatio = paramBoolean;
    createNativeInstace();
    this.type = 0;
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateSinglePointParticleShape(this.point_3[0], this.point_3[1], this.point_3[2], this.isUseRatio);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public float[] getPoint()
  {
    return this.point_3;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\SinglePointParticleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */