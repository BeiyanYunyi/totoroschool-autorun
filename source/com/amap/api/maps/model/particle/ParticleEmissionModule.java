package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AbstractNativeInstance;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

public class ParticleEmissionModule
  extends AbstractNativeInstance
{
  private final int rate;
  private final int rateTime;
  
  public ParticleEmissionModule(int paramInt1, int paramInt2)
  {
    this.rate = paramInt1;
    this.rateTime = paramInt2;
    createNativeInstace();
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateParticleEmissionModule(this.rate, this.rateTime);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.nativeInstance != 0L)
    {
      AMapNativeParticleSystem.nativeReleaseParticleEmissonModule(this.nativeInstance);
      this.nativeInstance = 0L;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\ParticleEmissionModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */