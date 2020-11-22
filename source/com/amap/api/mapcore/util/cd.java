package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.particle.ColorGenerate;
import com.amap.api.maps.model.particle.ParticleEmissionModule;
import com.amap.api.maps.model.particle.ParticleOverLifeModule;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.amap.api.maps.model.particle.ParticleShapeModule;
import com.amap.api.maps.model.particle.VelocityGenerate;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cd
  implements IParticleLatyer, IOverlayDelegate
{
  float a = 1.0F;
  int b = 0;
  int c = 0;
  private long d = 0L;
  private cl e;
  private lo f;
  private boolean g = true;
  private float h = 1.0F;
  private String i;
  private BitmapDescriptor j;
  private boolean k = false;
  private List<lu> l = new ArrayList();
  private int m = 0;
  private ParticleOverlayOptions n = new ParticleOverlayOptions();
  private boolean o = false;
  private float p = -1.0F;
  private float q = -1.0F;
  private float[] r = new float[16];
  private float[] s = new float[16];
  private float[] t = new float[16];
  
  public cd(lo paramlo)
  {
    this.f = paramlo;
    try
    {
      this.i = getId();
      return;
    }
    catch (RemoteException paramlo)
    {
      gk.c(paramlo, "ParticleLayerDelegateImp", "create");
      paramlo.printStackTrace();
    }
  }
  
  private int a()
  {
    if (!this.k)
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 12) {
        bool = true;
      } else {
        bool = false;
      }
      int i1 = a(bool, this.j);
      this.k = true;
      return i1;
    }
    return this.m;
  }
  
  private int a(boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor)
  {
    b();
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.f.a(paramBitmapDescriptor);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        i1 = ((lu)localObject2).k();
        a((lu)localObject2);
        return i1;
      }
    }
    else
    {
      localObject1 = null;
    }
    int i2 = 0;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new lu(paramBitmapDescriptor, 0);
    }
    paramBitmapDescriptor = paramBitmapDescriptor.getBitmap();
    int i1 = i2;
    if (paramBitmapDescriptor != null)
    {
      i1 = i2;
      if (!paramBitmapDescriptor.isRecycled())
      {
        i1 = c();
        ((lu)localObject2).a(i1);
        if (paramBoolean) {
          this.f.g().addTextureItem((lu)localObject2);
        }
        a((lu)localObject2);
        dx.b(i1, paramBitmapDescriptor, true);
      }
    }
    return i1;
  }
  
  private void a(lu paramlu)
  {
    if (paramlu != null)
    {
      this.l.add(paramlu);
      paramlu.l();
    }
  }
  
  private void b()
  {
    if (this.l != null)
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        lu locallu = (lu)localIterator.next();
        if ((locallu != null) && (this.f != null)) {
          this.f.a(locallu);
        }
      }
      this.l.clear();
    }
  }
  
  private int c()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    GLES20.glGenTextures(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  private void d()
  {
    if (this.d != 0L)
    {
      setMaxParticles(this.n.getMaxParticles());
      setDuration(this.n.getDuration());
      setLoop(this.n.isLoop());
      setPreWram(true);
      setParticleLifeTime(this.n.getParticleLifeTime());
      setParticleStartSpeed(this.n.getParticleStartSpeed());
      if (this.n.getParticleEmissionModule() != null) {
        setParticleEmission(this.n.getParticleEmissionModule());
      }
      if (this.n.getParticleShapeModule() != null) {
        setParticleShapeModule(this.n.getParticleShapeModule());
      }
      if (this.n.getParticleStartColor() != null) {
        setStartColor(this.n.getParticleStartColor());
      }
      if (this.n.getParticleOverLifeModule() != null) {
        setParticleOverLifeModule(this.n.getParticleOverLifeModule());
      }
      setStartParticleSize(this.n.getStartParticleW(), this.n.getstartParticleH());
    }
  }
  
  public void a(ParticleOverlayOptions paramParticleOverlayOptions)
  {
    if (paramParticleOverlayOptions != null) {}
    try
    {
      setCustomTexture(paramParticleOverlayOptions.getIcon());
      this.n.setMaxParticles(paramParticleOverlayOptions.getMaxParticles());
      this.n.setLoop(paramParticleOverlayOptions.isLoop());
      this.n.setDuration(paramParticleOverlayOptions.getDuration());
      this.n.setParticleLifeTime(paramParticleOverlayOptions.getParticleLifeTime());
      this.n.setParticleEmissionModule(paramParticleOverlayOptions.getParticleEmissionModule());
      this.n.setParticleShapeModule(paramParticleOverlayOptions.getParticleShapeModule());
      this.n.setParticleStartSpeed(paramParticleOverlayOptions.getParticleStartSpeed());
      this.n.setParticleStartColor(paramParticleOverlayOptions.getParticleStartColor());
      this.n.setParticleOverLifeModule(paramParticleOverlayOptions.getParticleOverLifeModule());
      this.n.setStartParticleSize(paramParticleOverlayOptions.getStartParticleW(), paramParticleOverlayOptions.getstartParticleH());
      this.n.zIndex(paramParticleOverlayOptions.getZIndex());
      this.h = this.n.getZIndex();
      this.n.setVisible(paramParticleOverlayOptions.isVisibile());
      this.g = this.n.isVisibile();
      this.o = true;
      return;
    }
    finally
    {
      for (;;) {}
    }
    throw paramParticleOverlayOptions;
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    return false;
  }
  
  public boolean checkInBounds()
  {
    return true;
  }
  
  public void destroy()
  {
    Object localObject;
    if ((this.l != null) && (this.l.size() > 0))
    {
      int i1 = 0;
      while (i1 < this.l.size())
      {
        localObject = (lu)this.l.get(i1);
        if (localObject != null)
        {
          if (this.f != null) {
            this.f.a((lu)localObject);
          }
          if (this.f.g() != null) {
            this.f.g().removeTextureItem(((lu)localObject).o());
          }
        }
        i1 += 1;
      }
      this.l.clear();
    }
    if (this.j != null)
    {
      localObject = this.j.getBitmap();
      if (localObject != null)
      {
        ((Bitmap)localObject).recycle();
        this.j = null;
      }
    }
    if (this.d != 0L) {
      AMapNativeParticleSystem.nativeDestroy(this.d);
    }
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    if (this.e == null) {
      this.e = this.f.b();
    }
    if (this.e == null) {
      return;
    }
    if (this.d == 0L)
    {
      this.d = AMapNativeParticleSystem.nativeCreate();
      if ((this.d != 0L) && (this.e != null)) {
        AMapNativeParticleSystem.nativeSetGLShaderManager(this.d, this.e.a());
      }
    }
    if (this.d != 0L) {
      try
      {
        if (this.o)
        {
          d();
          this.o = false;
        }
        this.m = a();
        if (this.m == 0) {
          return;
        }
        AMapNativeParticleSystem.nativeSetTextureId(this.d, this.m);
        if (this.f != null) {
          this.f.a(false);
        }
        if ((this.b != paramMapConfig.getMapWidth()) || (this.c != paramMapConfig.getMapHeight()))
        {
          this.b = paramMapConfig.getMapWidth();
          this.c = paramMapConfig.getMapHeight();
          float f1;
          if (this.b > this.c) {
            f1 = this.b;
          }
          for (int i1 = this.c;; i1 = this.b)
          {
            f1 /= i1;
            break;
            f1 = this.c;
          }
          this.a = f1;
          if (this.b > this.c)
          {
            this.p = (-this.a);
            this.q = 1.0F;
          }
          else
          {
            this.p = -1.0F;
            this.q = this.a;
          }
          Matrix.orthoM(this.r, 0, this.p, -this.p, -this.q, this.q, 3.0F, 7.0F);
          Matrix.setLookAtM(this.s, 0, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
        }
        Matrix.multiplyMM(this.t, 0, this.r, 0, this.s, 0);
        Matrix.translateM(this.t, 0, this.p, this.q, 0.0F);
        Matrix.scaleM(this.t, 0, Math.abs(this.p * 2.0F) / this.b, Math.abs(this.q * 2.0F) / this.c, 0.0F);
        AMapNativeParticleSystem.nativeRender(this.d, (float[])this.t.clone(), paramMapConfig.getProjectionMatrix(), (int)paramMapConfig.getSX(), (int)paramMapConfig.getSY(), paramMapConfig.getSZ(), this.b, this.c);
        return;
      }
      finally {}
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return false;
  }
  
  public int getCurrentParticleNum()
  {
    if (this.d != 0L) {
      return AMapNativeParticleSystem.getCurrentParticleNum(this.d);
    }
    return 0;
  }
  
  public String getId()
    throws RemoteException
  {
    if (this.i == null) {
      this.i = this.f.a("Particle");
    }
    return this.i;
  }
  
  public float getZIndex()
    throws RemoteException
  {
    return this.h;
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    return 0;
  }
  
  public boolean isAboveMaskLayer()
  {
    return false;
  }
  
  public boolean isDrawFinish()
  {
    return false;
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    return this.g;
  }
  
  public void pause() {}
  
  public void remove()
    throws RemoteException
  {}
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setCustomTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor == null) {
      return;
    }
    try
    {
      if (paramBitmapDescriptor.equals(this.j)) {
        return;
      }
      this.k = false;
      this.j = paramBitmapDescriptor;
      return;
    }
    finally {}
  }
  
  public void setDuration(long paramLong)
  {
    if (this.n != null) {
      this.n.setDuration(paramLong);
    }
    if (this.d != 0L)
    {
      AMapNativeParticleSystem.setDuration(this.d, paramLong);
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.n != null) {
      this.n.setLoop(paramBoolean);
    }
    if (this.d != 0L)
    {
      AMapNativeParticleSystem.setLoop(this.d, paramBoolean);
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setMaxParticles(int paramInt)
  {
    if (this.n != null) {
      this.n.setMaxParticles(paramInt);
    }
    if (this.d != 0L)
    {
      AMapNativeParticleSystem.setMaxParticles(this.d, paramInt);
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setParticleEmission(ParticleEmissionModule paramParticleEmissionModule)
  {
    if (this.n != null) {
      this.n.setParticleEmissionModule(paramParticleEmissionModule);
    }
    if ((this.d != 0L) && (paramParticleEmissionModule != null))
    {
      if (paramParticleEmissionModule.getNativeInstance() == 0L) {
        paramParticleEmissionModule.createNativeInstace();
      }
      AMapNativeParticleSystem.setParticleEmission(this.d, paramParticleEmissionModule.getNativeInstance());
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setParticleLifeTime(long paramLong)
  {
    if (this.n != null) {
      this.n.setParticleLifeTime(paramLong);
    }
    if (this.d != 0L)
    {
      AMapNativeParticleSystem.setParticleLifeTime(this.d, paramLong);
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setParticleOverLifeModule(ParticleOverLifeModule paramParticleOverLifeModule)
  {
    if (this.n != null) {
      this.n.setParticleOverLifeModule(paramParticleOverLifeModule);
    }
    if ((this.d != 0L) && (paramParticleOverLifeModule != null))
    {
      if (paramParticleOverLifeModule.getNativeInstance() == 0L) {
        paramParticleOverLifeModule.createNativeInstace();
      }
      AMapNativeParticleSystem.setParticleOverLifeModule(this.d, paramParticleOverLifeModule.getNativeInstance());
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setParticleShapeModule(ParticleShapeModule paramParticleShapeModule)
  {
    if (this.n != null) {
      this.n.setParticleShapeModule(paramParticleShapeModule);
    }
    if ((this.d != 0L) && (paramParticleShapeModule != null))
    {
      if (paramParticleShapeModule.getNativeInstance() == 0L) {
        paramParticleShapeModule.createNativeInstace();
      }
      AMapNativeParticleSystem.setParticleShapeModule(this.d, paramParticleShapeModule.getNativeInstance());
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setParticleStartSpeed(VelocityGenerate paramVelocityGenerate)
  {
    if (this.n != null) {
      this.n.setParticleStartSpeed(paramVelocityGenerate);
    }
    if ((this.d != 0L) && (paramVelocityGenerate != null))
    {
      if (paramVelocityGenerate.getNativeInstance() == 0L) {
        paramVelocityGenerate.createNativeInstace();
      }
      AMapNativeParticleSystem.setParticleStartSpeed(this.d, paramVelocityGenerate.getNativeInstance());
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setPreWram(boolean paramBoolean)
  {
    if (this.d != 0L) {
      AMapNativeParticleSystem.setPreWram(this.d, paramBoolean);
    }
  }
  
  public void setStartColor(ColorGenerate paramColorGenerate)
  {
    if (this.n != null) {
      this.n.setParticleStartColor(paramColorGenerate);
    }
    if ((this.d != 0L) && (paramColorGenerate != null))
    {
      if (paramColorGenerate.getNativeInstance() == 0L) {
        paramColorGenerate.createNativeInstace();
      }
      AMapNativeParticleSystem.setStartColor(this.d, paramColorGenerate.getNativeInstance());
      return;
    }
    if (this.n != null) {
      try
      {
        this.o = true;
        return;
      }
      finally {}
    }
  }
  
  public void setStartParticleSize(int paramInt1, int paramInt2)
  {
    if (this.n != null) {
      this.n.setStartParticleSize(paramInt1, paramInt2);
    }
    if (this.d != 0L) {
      AMapNativeParticleSystem.setStartParticleSize(this.d, paramInt1, paramInt2);
    }
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    this.g = paramBoolean;
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    this.h = paramFloat;
  }
  
  public void start() {}
  
  public void stop() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */