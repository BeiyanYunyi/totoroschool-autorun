package com.autonavi.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.particle.ColorGenerate;
import com.amap.api.maps.model.particle.ParticleEmissionModule;
import com.amap.api.maps.model.particle.ParticleOverLifeModule;
import com.amap.api.maps.model.particle.ParticleShapeModule;
import com.amap.api.maps.model.particle.VelocityGenerate;

public abstract interface IParticleLatyer
{
  public abstract void destroy();
  
  public abstract int getCurrentParticleNum();
  
  public abstract void pause();
  
  public abstract void setCustomTexture(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setDuration(long paramLong);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setMaxParticles(int paramInt);
  
  public abstract void setParticleEmission(ParticleEmissionModule paramParticleEmissionModule);
  
  public abstract void setParticleLifeTime(long paramLong);
  
  public abstract void setParticleOverLifeModule(ParticleOverLifeModule paramParticleOverLifeModule);
  
  public abstract void setParticleShapeModule(ParticleShapeModule paramParticleShapeModule);
  
  public abstract void setParticleStartSpeed(VelocityGenerate paramVelocityGenerate);
  
  public abstract void setPreWram(boolean paramBoolean);
  
  public abstract void setStartColor(ColorGenerate paramColorGenerate);
  
  public abstract void setStartParticleSize(int paramInt1, int paramInt2);
  
  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\api\mapcore\overlays\IParticleLatyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */