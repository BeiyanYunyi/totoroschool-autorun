package com.amap.api.maps.model.particle;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import java.lang.ref.WeakReference;

public class ParticleOverlay
  extends BaseOverlay
{
  private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
  private ParticleOverlayOptions options;
  private IParticleLatyer overlayDelegate;
  
  public ParticleOverlay(IGlOverlayLayer paramIGlOverlayLayer, ParticleOverlayOptions paramParticleOverlayOptions)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.options = paramParticleOverlayOptions;
    this.overlayName = "";
  }
  
  public ParticleOverlay(IParticleLatyer paramIParticleLatyer)
  {
    this.overlayDelegate = paramIParticleLatyer;
  }
  
  private void a()
  {
    IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
    if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null)) {
      localIGlOverlayLayer.updateOption(this.overlayName, this.options);
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.destroy();
        return;
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localIGlOverlayLayer != null)
      {
        localIGlOverlayLayer.removeOverlay(this.overlayName);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int getCurrentParticleNum()
  {
    int i = 0;
    try
    {
      if (this.overlayDelegate != null) {
        return this.overlayDelegate.getCurrentParticleNum();
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localIGlOverlayLayer != null) {
        i = localIGlOverlayLayer.getCurrentParticleNum(this.overlayName);
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public void setDuration(long paramLong)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setDuration(paramLong);
        return;
      }
      if (this.options != null)
      {
        this.options.setDuration(paramLong);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setLoop(paramBoolean);
        return;
      }
      if (this.options != null)
      {
        this.options.setLoop(paramBoolean);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setMaxParticles(int paramInt)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setMaxParticles(paramInt);
        return;
      }
      if (this.options != null)
      {
        this.options.setMaxParticles(paramInt);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setParticleEmission(ParticleEmissionModule paramParticleEmissionModule)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setParticleEmission(paramParticleEmissionModule);
        return;
      }
      if (this.options != null)
      {
        this.options.setParticleEmissionModule(paramParticleEmissionModule);
        a();
        return;
      }
    }
    catch (Throwable paramParticleEmissionModule)
    {
      paramParticleEmissionModule.printStackTrace();
    }
  }
  
  public void setParticleLifeTime(long paramLong)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setParticleLifeTime(paramLong);
        return;
      }
      if (this.options != null)
      {
        this.options.setParticleLifeTime(paramLong);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setParticleOverLifeModule(ParticleOverLifeModule paramParticleOverLifeModule)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setParticleOverLifeModule(paramParticleOverLifeModule);
        return;
      }
      if (this.options != null)
      {
        this.options.setParticleOverLifeModule(paramParticleOverLifeModule);
        a();
        return;
      }
    }
    catch (Throwable paramParticleOverLifeModule)
    {
      paramParticleOverLifeModule.printStackTrace();
    }
  }
  
  public void setParticleShapeModule(ParticleShapeModule paramParticleShapeModule)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setParticleShapeModule(paramParticleShapeModule);
        return;
      }
      if (this.options != null)
      {
        this.options.setParticleShapeModule(paramParticleShapeModule);
        a();
        return;
      }
    }
    catch (Throwable paramParticleShapeModule)
    {
      paramParticleShapeModule.printStackTrace();
    }
  }
  
  public void setParticleStartSpeed(VelocityGenerate paramVelocityGenerate)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setParticleStartSpeed(paramVelocityGenerate);
        return;
      }
      if (this.options != null)
      {
        this.options.setParticleStartSpeed(paramVelocityGenerate);
        a();
        return;
      }
    }
    catch (Throwable paramVelocityGenerate)
    {
      paramVelocityGenerate.printStackTrace();
    }
  }
  
  public void setStartColor(ColorGenerate paramColorGenerate)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setStartColor(paramColorGenerate);
        return;
      }
      if (this.options != null)
      {
        this.options.setParticleStartColor(paramColorGenerate);
        a();
        return;
      }
    }
    catch (Throwable paramColorGenerate)
    {
      paramColorGenerate.printStackTrace();
    }
  }
  
  public void setStartParticleSize(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setStartParticleSize(paramInt1, paramInt2);
        return;
      }
      if (this.options != null)
      {
        this.options.setStartParticleSize(paramInt1, paramInt2);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      if (this.overlayDelegate != null)
      {
        this.overlayDelegate.setVisible(paramBoolean);
        return;
      }
      if (this.options != null)
      {
        this.options.setVisible(paramBoolean);
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\ParticleOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */