package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

public class ConstantRotationOverLife
  extends RotationOverLife
{
  private float rotate = 0.0F;
  
  public ConstantRotationOverLife(float paramFloat)
  {
    this.rotate = paramFloat;
    this.type = 0;
    createNativeInstace();
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateConstantRotationOverLife(this.rotate);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public float getRotate()
  {
    return this.rotate;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\ConstantRotationOverLife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */