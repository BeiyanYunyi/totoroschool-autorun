package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BitmapDescriptor;

public class ParticleOverlayOptions
  extends BaseOptions
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ParticleOverlayOptions> CREATOR = new Parcelable.Creator()
  {
    public ParticleOverlayOptions a(Parcel paramAnonymousParcel)
    {
      return new ParticleOverlayOptions(paramAnonymousParcel);
    }
    
    public ParticleOverlayOptions[] a(int paramAnonymousInt)
    {
      return new ParticleOverlayOptions[paramAnonymousInt];
    }
  };
  private BitmapDescriptor bitmapDescriptor;
  private String bitmapSymbol;
  private long duration;
  private boolean isParticleEmissionModuleUpdate;
  private boolean isParticleOverLifeModuleUpdate;
  private boolean isParticleShapeModuleUpdate;
  private boolean isStartColorUpdate;
  private boolean isStartSpeedUpdate;
  private boolean loop;
  private int maxParticles = 100;
  private ParticleEmissionModule particleEmissionModule;
  private long particleLifeTime;
  private ParticleOverLifeModule particleOverLifeModule;
  private ParticleShapeModule particleShapeModule;
  private ColorGenerate startColor;
  private int startParticleH;
  private int startParticleW;
  private VelocityGenerate startSpeed;
  private final String type;
  private boolean visibile;
  private float zIndex = 1.0F;
  
  public ParticleOverlayOptions()
  {
    this.loop = true;
    this.duration = 5000L;
    this.particleLifeTime = 5000L;
    this.startSpeed = null;
    this.startParticleW = 32;
    this.startParticleH = 32;
    this.visibile = true;
    this.isParticleEmissionModuleUpdate = false;
    this.isParticleShapeModuleUpdate = false;
    this.isStartSpeedUpdate = false;
    this.isStartColorUpdate = false;
    this.isParticleOverLifeModuleUpdate = false;
    this.type = "ParticleOptions";
  }
  
  protected ParticleOverlayOptions(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.loop = true;
    this.duration = 5000L;
    this.particleLifeTime = 5000L;
    this.startSpeed = null;
    this.startParticleW = 32;
    this.startParticleH = 32;
    this.visibile = true;
    this.isParticleEmissionModuleUpdate = false;
    this.isParticleShapeModuleUpdate = false;
    this.isStartSpeedUpdate = false;
    this.isStartColorUpdate = false;
    this.isParticleOverLifeModuleUpdate = false;
    this.type = "ParticleOptions";
    this.bitmapDescriptor = ((BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
    this.bitmapSymbol = this.bitmapDescriptor.getId();
    this.zIndex = paramParcel.readFloat();
    this.maxParticles = paramParcel.readInt();
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.loop = bool1;
    this.duration = paramParcel.readLong();
    this.particleLifeTime = paramParcel.readLong();
    this.startParticleW = paramParcel.readInt();
    this.startParticleH = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.visibile = bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.bitmapDescriptor;
  }
  
  public int getMaxParticles()
  {
    return this.maxParticles;
  }
  
  public ParticleEmissionModule getParticleEmissionModule()
  {
    return this.particleEmissionModule;
  }
  
  public long getParticleLifeTime()
  {
    return this.particleLifeTime;
  }
  
  public ParticleOverLifeModule getParticleOverLifeModule()
  {
    return this.particleOverLifeModule;
  }
  
  public ParticleShapeModule getParticleShapeModule()
  {
    return this.particleShapeModule;
  }
  
  public ColorGenerate getParticleStartColor()
  {
    return this.startColor;
  }
  
  public VelocityGenerate getParticleStartSpeed()
  {
    return this.startSpeed;
  }
  
  public int getStartParticleW()
  {
    return this.startParticleW;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public int getstartParticleH()
  {
    return this.startParticleH;
  }
  
  public ParticleOverlayOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    try
    {
      this.bitmapDescriptor = paramBitmapDescriptor;
      this.bitmapSymbol = this.bitmapDescriptor.getId();
      return this;
    }
    catch (Throwable paramBitmapDescriptor)
    {
      paramBitmapDescriptor.printStackTrace();
    }
    return this;
  }
  
  public boolean isLoop()
  {
    return this.loop;
  }
  
  public boolean isVisibile()
  {
    return this.visibile;
  }
  
  public ParticleOverlayOptions setDuration(long paramLong)
  {
    this.duration = paramLong;
    return this;
  }
  
  public ParticleOverlayOptions setLoop(boolean paramBoolean)
  {
    this.loop = paramBoolean;
    return this;
  }
  
  public ParticleOverlayOptions setMaxParticles(int paramInt)
  {
    this.maxParticles = paramInt;
    return this;
  }
  
  public ParticleOverlayOptions setParticleEmissionModule(ParticleEmissionModule paramParticleEmissionModule)
  {
    this.particleEmissionModule = paramParticleEmissionModule;
    this.isParticleEmissionModuleUpdate = true;
    return this;
  }
  
  public ParticleOverlayOptions setParticleLifeTime(long paramLong)
  {
    this.particleLifeTime = paramLong;
    return this;
  }
  
  public ParticleOverlayOptions setParticleOverLifeModule(ParticleOverLifeModule paramParticleOverLifeModule)
  {
    this.particleOverLifeModule = paramParticleOverLifeModule;
    this.isParticleOverLifeModuleUpdate = true;
    return this;
  }
  
  public ParticleOverlayOptions setParticleShapeModule(ParticleShapeModule paramParticleShapeModule)
  {
    this.particleShapeModule = paramParticleShapeModule;
    this.isParticleShapeModuleUpdate = true;
    return this;
  }
  
  public ParticleOverlayOptions setParticleStartColor(ColorGenerate paramColorGenerate)
  {
    this.startColor = paramColorGenerate;
    this.isStartColorUpdate = true;
    return this;
  }
  
  public ParticleOverlayOptions setParticleStartSpeed(VelocityGenerate paramVelocityGenerate)
  {
    this.startSpeed = paramVelocityGenerate;
    this.isStartSpeedUpdate = true;
    return this;
  }
  
  public ParticleOverlayOptions setStartParticleSize(int paramInt1, int paramInt2)
  {
    this.startParticleW = paramInt1;
    this.startParticleH = paramInt2;
    return this;
  }
  
  public ParticleOverlayOptions setVisible(boolean paramBoolean)
  {
    this.visibile = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.bitmapDescriptor, paramInt);
    paramParcel.writeFloat(this.zIndex);
    paramParcel.writeInt(this.maxParticles);
    paramParcel.writeByte((byte)this.loop);
    paramParcel.writeLong(this.duration);
    paramParcel.writeLong(this.particleLifeTime);
    paramParcel.writeInt(this.startParticleW);
    paramParcel.writeInt(this.startParticleH);
    paramParcel.writeByte((byte)this.visibile);
  }
  
  public ParticleOverlayOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\ParticleOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */