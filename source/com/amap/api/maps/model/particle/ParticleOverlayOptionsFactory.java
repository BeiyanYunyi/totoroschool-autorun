package com.amap.api.maps.model.particle;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public class ParticleOverlayOptionsFactory
{
  public static final int PARTICLE_TYPE_HAZE = 3;
  public static final int PARTICLE_TYPE_RAIN = 1;
  public static final int PARTICLE_TYPE_SNOWY = 2;
  public static final int PARTICLE_TYPE_SUNNY = 0;
  
  private static List<ParticleOverlayOptions> a()
  {
    ArrayList localArrayList = new ArrayList();
    ParticleOverlayOptions localParticleOverlayOptions = new ParticleOverlayOptions();
    localParticleOverlayOptions.setLoop(false);
    localParticleOverlayOptions.setMaxParticles(1);
    localParticleOverlayOptions.setDuration(10000L);
    localParticleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, (int)10000L));
    localParticleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.5F, 0.5F, 0.0F, true));
    localParticleOverlayOptions.setParticleLifeTime(10000L);
    localParticleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-10.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F));
    BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromAsset("map_custom/particle/fog.png");
    if (localBitmapDescriptor != null)
    {
      localParticleOverlayOptions.icon(localBitmapDescriptor);
      localParticleOverlayOptions.setStartParticleSize(localBitmapDescriptor.getWidth() * 5, localBitmapDescriptor.getWidth() * 5);
    }
    localArrayList.add(localParticleOverlayOptions);
    localParticleOverlayOptions = new ParticleOverlayOptions();
    localParticleOverlayOptions.setMaxParticles(1000);
    localParticleOverlayOptions.setDuration(10000L);
    localParticleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(30, (int)2500L));
    localParticleOverlayOptions.setLoop(true);
    localParticleOverlayOptions.setParticleShapeModule(new RectParticleShape(0.5F, 0.5F, 1.0F, 1.0F, true));
    localParticleOverlayOptions.setParticleLifeTime(10000L);
    localParticleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-100.0F, -100.0F, -1.0F, -200.0F, 100.0F, 1.0F));
    localBitmapDescriptor = BitmapDescriptorFactory.fromAsset("map_custom/particle/haze.png");
    if (localBitmapDescriptor != null)
    {
      localParticleOverlayOptions.icon(localBitmapDescriptor);
      localParticleOverlayOptions.setStartParticleSize(localBitmapDescriptor.getWidth(), localBitmapDescriptor.getHeight());
    }
    localParticleOverlayOptions.setParticleStartColor(new RandomColorBetWeenTwoConstants(255.0F, 255.0F, 255.0F, 102.0F, 255.0F, 255.0F, 255.0F, 255.0F));
    localArrayList.add(localParticleOverlayOptions);
    return localArrayList;
  }
  
  private static ParticleOverlayOptions b()
  {
    ParticleOverlayOptions localParticleOverlayOptions = new ParticleOverlayOptions();
    localParticleOverlayOptions.setMaxParticles(1000);
    localParticleOverlayOptions.setDuration(5000L);
    localParticleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(20, 1000));
    localParticleOverlayOptions.setLoop(true);
    localParticleOverlayOptions.setParticleShapeModule(new RectParticleShape(0.0F, 0.0F, 1.0F, 0.1F, true));
    localParticleOverlayOptions.setParticleLifeTime(10000L);
    localParticleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-50.0F, 100.0F, 0.0F, 50.0F, 200.0F, 0.0F));
    BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromAsset("map_custom/particle/snow.png");
    if (localBitmapDescriptor != null)
    {
      localParticleOverlayOptions.icon(localBitmapDescriptor);
      localParticleOverlayOptions.setStartParticleSize(localBitmapDescriptor.getWidth(), localBitmapDescriptor.getHeight());
    }
    return localParticleOverlayOptions;
  }
  
  private static ParticleOverlayOptions c()
  {
    ParticleOverlayOptions localParticleOverlayOptions = new ParticleOverlayOptions();
    localParticleOverlayOptions.setMaxParticles(1000);
    localParticleOverlayOptions.setDuration(5000L);
    localParticleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(100, 1000));
    localParticleOverlayOptions.setLoop(true);
    localParticleOverlayOptions.setParticleLifeTime(5000L);
    localParticleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(10.0F, 1000.0F, 0.0F, 100.0F, 1000.0F, 0.0F));
    localParticleOverlayOptions.setParticleShapeModule(new RectParticleShape(0.0F, 0.0F, 1.0F, 0.1F, true));
    BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromAsset("map_custom/particle/rain.png");
    if (localBitmapDescriptor != null)
    {
      localParticleOverlayOptions.icon(localBitmapDescriptor);
      localParticleOverlayOptions.setStartParticleSize(localBitmapDescriptor.getWidth() * 2, localBitmapDescriptor.getHeight() * 2);
    }
    return localParticleOverlayOptions;
  }
  
  private static List<ParticleOverlayOptions> d()
  {
    ArrayList localArrayList = new ArrayList();
    ParticleOverlayOptions localParticleOverlayOptions = new ParticleOverlayOptions();
    localParticleOverlayOptions.setMaxParticles(1);
    localParticleOverlayOptions.setDuration(10000L);
    int i = (int)2500L;
    localParticleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, i));
    localParticleOverlayOptions.setLoop(true);
    localParticleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.0F, 0.0F, 0.0F));
    localParticleOverlayOptions.setParticleLifeTime(10000L);
    localParticleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
    localParticleOverlayOptions.setParticleOverLifeModule(new ParticleOverLifeModule());
    localParticleOverlayOptions.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_0.png"));
    localParticleOverlayOptions.setStartParticleSize(1000, 1000);
    localArrayList.add(localParticleOverlayOptions);
    localParticleOverlayOptions = new ParticleOverlayOptions();
    localParticleOverlayOptions.setMaxParticles(1);
    localParticleOverlayOptions.setDuration(10000L);
    localParticleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, i));
    localParticleOverlayOptions.setLoop(true);
    localParticleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.0F, 0.0F, 0.0F));
    localParticleOverlayOptions.setParticleLifeTime(10000L);
    localParticleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
    ParticleOverLifeModule localParticleOverLifeModule = new ParticleOverLifeModule();
    localParticleOverLifeModule.setRotateOverLife(new ConstantRotationOverLife(45.0F));
    localParticleOverlayOptions.setParticleOverLifeModule(localParticleOverLifeModule);
    localParticleOverlayOptions.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_1.png"));
    localParticleOverlayOptions.setStartParticleSize(1000, 1000);
    localArrayList.add(localParticleOverlayOptions);
    return localArrayList;
  }
  
  public static List<ParticleOverlayOptions> defaultOptions(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    switch (paramInt)
    {
    default: 
      return localArrayList;
    case 3: 
      localArrayList.addAll(a());
      return localArrayList;
    case 2: 
      localArrayList.add(b());
      return localArrayList;
    case 1: 
      localArrayList.add(c());
      return localArrayList;
    }
    localArrayList.addAll(d());
    return localArrayList;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\particle\ParticleOverlayOptionsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */