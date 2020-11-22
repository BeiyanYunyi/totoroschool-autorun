package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;
import java.util.Random;

public class RandomColorBetWeenTwoConstants
  extends ColorGenerate
{
  private float a;
  private float a1;
  private float b;
  private float b1;
  private float[] color = { 1.0F, 1.0F, 1.0F, 1.0F };
  private float g;
  private float g1;
  private float r;
  private float r1;
  private Random random = new Random();
  
  public RandomColorBetWeenTwoConstants(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    this.r = (paramFloat1 / 255.0F);
    this.g = (paramFloat2 / 255.0F);
    this.b = (paramFloat3 / 255.0F);
    this.a = (paramFloat4 / 255.0F);
    this.r1 = (paramFloat5 / 255.0F);
    this.g1 = (paramFloat6 / 255.0F);
    this.b1 = (paramFloat7 / 255.0F);
    this.a1 = (paramFloat8 / 255.0F);
    createNativeInstace();
    this.type = 0;
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateRandomColorBetWeenTwoConstants(this.r, this.g, this.b, this.a, this.r1, this.g1, this.b1, this.a1);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public float[] getColor()
  {
    this.color[0] = (this.random.nextFloat() * (this.r1 - this.r) + this.r);
    this.color[1] = (this.random.nextFloat() * (this.g1 - this.g) + this.g);
    this.color[2] = (this.random.nextFloat() * (this.b1 - this.b) + this.b);
    this.color[3] = (this.random.nextFloat() * (this.a1 - this.a) + this.a);
    return this.color;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\RandomColorBetWeenTwoConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */