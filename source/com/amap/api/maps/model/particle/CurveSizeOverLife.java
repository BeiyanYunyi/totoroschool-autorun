package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

public class CurveSizeOverLife
  extends SizeOverLife
{
  private float x;
  private float y;
  private float z;
  
  public CurveSizeOverLife(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.type = 0;
    createNativeInstace();
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateCurveSizeOverLife(this.x, this.y, this.z);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public float getSizeX(float paramFloat)
  {
    return 0.0F;
  }
  
  public float getSizeY(float paramFloat)
  {
    return 0.0F;
  }
  
  public float getSizeZ(float paramFloat)
  {
    return 0.0F;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\CurveSizeOverLife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */