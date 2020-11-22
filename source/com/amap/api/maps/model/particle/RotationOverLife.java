package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AbstractNativeInstance;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

public abstract class RotationOverLife
  extends AbstractNativeInstance
{
  protected final int TYPE_CONSTANTROTATIONOVERLIFE = 0;
  protected final int TYPE_DEFAULT = -1;
  protected int type = -1;
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.nativeInstance != 0L)
    {
      AMapNativeParticleSystem.nativeReleaseRotationOverLife(this.nativeInstance);
      this.nativeInstance = 0L;
    }
  }
  
  public abstract float getRotate();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\RotationOverLife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */