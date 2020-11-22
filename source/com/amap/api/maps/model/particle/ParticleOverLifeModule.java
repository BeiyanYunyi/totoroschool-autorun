package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.autonavi.amap.mapcore.AbstractNativeInstance;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

public class ParticleOverLifeModule
  extends AbstractNativeInstance
  implements Parcelable
{
  public static final Parcelable.Creator<ParticleOverLifeModule> CREATOR = new Parcelable.Creator()
  {
    public ParticleOverLifeModule a(Parcel paramAnonymousParcel)
    {
      return new ParticleOverLifeModule(paramAnonymousParcel);
    }
    
    public ParticleOverLifeModule[] a(int paramAnonymousInt)
    {
      return new ParticleOverLifeModule[paramAnonymousInt];
    }
  };
  private static final int TYPE_COLOR = 3;
  private static final int TYPE_ROTATE = 1;
  private static final int TYPE_SCALE = 2;
  private static final int TYPE_VEL = 0;
  private ColorGenerate colorGenerate;
  private boolean isNeedReloadColorGenerate = false;
  private boolean isNeedReloadRotationOverLife = false;
  private boolean isNeedReloadSizeOverLife = false;
  private boolean isNeedReloadVelocityGenerate = false;
  private VelocityGenerate overLife = null;
  private RotationOverLife rotateOverLife;
  private SizeOverLife sizeOverLife;
  private VelocityGenerate velocityOverLife = null;
  
  public ParticleOverLifeModule()
  {
    createNativeInstace();
  }
  
  protected ParticleOverLifeModule(Parcel paramParcel)
  {
    this.nativeInstance = paramParcel.readLong();
  }
  
  public void createNativeInstace()
  {
    try
    {
      this.nativeInstance = AMapNativeParticleSystem.nativeCreateParticleOverLifeModule();
      if (this.isNeedReloadVelocityGenerate)
      {
        setVelocityOverLife(this.overLife);
        this.isNeedReloadVelocityGenerate = false;
      }
      if (this.isNeedReloadRotationOverLife)
      {
        setRotateOverLife(this.rotateOverLife);
        this.isNeedReloadRotationOverLife = false;
      }
      if (this.isNeedReloadSizeOverLife)
      {
        setSizeOverLife(this.sizeOverLife);
        this.isNeedReloadSizeOverLife = false;
      }
      if (this.isNeedReloadColorGenerate)
      {
        setColorGenerate(this.colorGenerate);
        this.isNeedReloadColorGenerate = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.nativeInstance != 0L)
    {
      AMapNativeParticleSystem.nativeReleaseParticleOverLifeModule(this.nativeInstance);
      this.nativeInstance = 0L;
    }
  }
  
  public void setColorGenerate(ColorGenerate paramColorGenerate)
  {
    this.colorGenerate = paramColorGenerate;
    if (this.nativeInstance != 0L)
    {
      if (this.colorGenerate != null)
      {
        if (this.colorGenerate.getNativeInstance() == 0L) {
          this.colorGenerate.createNativeInstace();
        }
        AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.colorGenerate.getNativeInstance(), 3);
        return;
      }
      AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0L, 3);
      return;
    }
    this.isNeedReloadColorGenerate = true;
  }
  
  public void setRotateOverLife(RotationOverLife paramRotationOverLife)
  {
    this.rotateOverLife = paramRotationOverLife;
    if (this.nativeInstance != 0L)
    {
      if (this.rotateOverLife != null)
      {
        if (this.rotateOverLife.getNativeInstance() == 0L) {
          this.rotateOverLife.createNativeInstace();
        }
        AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.rotateOverLife.getNativeInstance(), 1);
        return;
      }
      AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0L, 1);
      return;
    }
    this.isNeedReloadRotationOverLife = true;
  }
  
  public void setSizeOverLife(SizeOverLife paramSizeOverLife)
  {
    this.sizeOverLife = paramSizeOverLife;
    if (this.nativeInstance != 0L)
    {
      if (this.sizeOverLife != null)
      {
        if (this.sizeOverLife.getNativeInstance() == 0L) {
          this.sizeOverLife.createNativeInstace();
        }
        AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.sizeOverLife.getNativeInstance(), 2);
        return;
      }
      AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0L, 2);
      return;
    }
    this.isNeedReloadSizeOverLife = true;
  }
  
  public void setVelocityOverLife(VelocityGenerate paramVelocityGenerate)
  {
    this.overLife = paramVelocityGenerate;
    this.velocityOverLife = paramVelocityGenerate;
    if (this.nativeInstance != 0L)
    {
      if (this.overLife != null)
      {
        if (this.overLife.getNativeInstance() == 0L) {
          this.overLife.createNativeInstace();
        }
        AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, this.overLife.getNativeInstance(), 0);
        return;
      }
      AMapNativeParticleSystem.nativeSetOverLifeItem(this.nativeInstance, 0L, 0);
      return;
    }
    this.isNeedReloadVelocityGenerate = true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.nativeInstance);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\ParticleOverLifeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */