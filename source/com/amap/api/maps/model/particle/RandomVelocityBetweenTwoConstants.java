package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;
import java.util.Random;

public class RandomVelocityBetweenTwoConstants
  extends VelocityGenerate
{
  private Random random;
  private float x1;
  private float x2;
  private float y1;
  private float y2;
  private float z1;
  private float z2;
  
  public RandomVelocityBetweenTwoConstants(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.x1 = paramFloat1;
    this.y1 = paramFloat2;
    this.z1 = paramFloat3;
    this.x2 = paramFloat4;
    this.y2 = paramFloat5;
    this.z2 = paramFloat6;
    this.random = new Random();
    createNativeInstace();
    this.type = 0;
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateRandomVelocityBetweenTwoConstants(this.x1, this.y1, this.z1, this.x2, this.y2, this.z2);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public float getX()
  {
    return this.random.nextFloat() * (this.x2 - this.x1) + this.x1;
  }
  
  public float getY()
  {
    return this.random.nextFloat() * (this.y2 - this.y1) + this.y1;
  }
  
  public float getZ()
  {
    return this.random.nextFloat() * (this.z2 - this.z1) + this.z1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\RandomVelocityBetweenTwoConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */