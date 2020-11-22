package com.amap.api.mapcore.util;

import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.Gradient;
import com.amap.api.maps.model.HeatMapItem;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeHeatMapLayer;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.Collection;
import java.util.Iterator;

public class bz
  implements IHeatMapLayer, IOverlayDelegate
{
  long a = -1L;
  private lo b;
  private boolean c = true;
  private String d;
  private float e = 0.0F;
  private boolean f;
  private cl g;
  private HeatMapLayerOptions h;
  private boolean i = false;
  
  public bz(lo paramlo)
  {
    try
    {
      this.i = false;
      this.b = paramlo;
      this.d = getId();
      return;
    }
    catch (Exception paramlo)
    {
      paramlo.printStackTrace();
    }
  }
  
  private boolean a()
  {
    if (this.h == null) {
      return false;
    }
    if (this.h.getData() != null)
    {
      if (this.h.getData().size() <= 0) {
        return false;
      }
      if (this.h.getGradient() == null) {
        return false;
      }
      if (this.h.getGradient().getColors() != null)
      {
        if (this.h.getGradient().getColors().length <= 0) {
          return false;
        }
        if (this.h.getGradient().getStartPoints() != null) {
          return this.h.getGradient().getStartPoints().length > 0;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public void a(cl paramcl)
  {
    this.g = paramcl;
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
    try
    {
      this.i = true;
      if (this.a != -1L)
      {
        AMapNativeHeatMapLayer.nativeDestroy(this.a);
        this.a = -1L;
      }
      return;
    }
    finally {}
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    try
    {
      if (this.i) {
        return;
      }
      if ((this.b != null) && (this.g == null)) {
        this.g = this.b.b();
      }
      if (this.g != null) {
        break label441;
      }
      return;
    }
    catch (Exception paramMapConfig)
    {
      paramMapConfig.printStackTrace();
    }
    if (!this.c) {
      return;
    }
    if (this.a != -1L) {}
    for (;;)
    {
      int j;
      try
      {
        if (this.a != -1L)
        {
          if ((this.f) && (a()))
          {
            double[] arrayOfDouble = new double[this.h.getData().size() * 3];
            Object localObject = this.h.getData();
            int k = ((Collection)localObject).size();
            localObject = ((Collection)localObject).iterator();
            double d1 = 0.0D;
            j = 0;
            if (((Iterator)localObject).hasNext())
            {
              WeightedLatLng localWeightedLatLng = (WeightedLatLng)((Iterator)localObject).next();
              if ((localWeightedLatLng != null) && (localWeightedLatLng.latLng != null))
              {
                int m = j * 3;
                arrayOfDouble[(m + 0)] = localWeightedLatLng.latLng.latitude;
                arrayOfDouble[(m + 1)] = localWeightedLatLng.latLng.longitude;
                arrayOfDouble[(m + 2)] = localWeightedLatLng.intensity;
                double d2 = localWeightedLatLng.latLng.latitude;
                double d3 = k;
                Double.isNaN(d3);
                d1 += d2 / d3;
                d2 = localWeightedLatLng.latLng.longitude;
                break label446;
              }
              Log.e("mapcore", "read file failed");
              break label446;
            }
            AMapNativeHeatMapLayer.nativeSetOptions(this.a, arrayOfDouble, (int)this.h.getMaxIntensity(), this.h.getSize(), this.h.getGradient().getColors(), this.h.getGradient().getStartPoints(), this.h.getMaxZoom(), this.h.getMinZoom(), this.h.getOpacity(), this.h.getGap(), this.h.getType(), d1);
            this.f = false;
          }
          AMapNativeHeatMapLayer.nativeRender(this.a, paramMapConfig.getViewMatrix(), paramMapConfig.getProjectionMatrix(), (int)paramMapConfig.getSX(), (int)paramMapConfig.getSY(), paramMapConfig.getSZ());
        }
        return;
      }
      finally {}
      this.a = AMapNativeHeatMapLayer.nativeCreate();
      if ((this.a != -1L) && (this.g != null))
      {
        AMapNativeHeatMapLayer.nativeSetGLShaderManager(this.a, this.g.a());
        return;
      }
      return;
      label441:
      if (paramMapConfig != null) {
        break;
      }
      return;
      label446:
      j += 1;
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return false;
  }
  
  public HeatMapItem getHeatMapItem(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    if (this.a != -1L)
    {
      paramLatLng = AMapNativeHeatMapLayer.nativeGetHeatMapItem(this.a, paramLatLng.latitude, paramLatLng.longitude);
      if ((paramLatLng != null) && ((paramLatLng instanceof HeatMapItem))) {
        return (HeatMapItem)paramLatLng;
      }
    }
    return null;
  }
  
  public String getId()
  {
    if (this.d == null) {
      this.d = this.b.a("HeatMapLayer");
    }
    return this.d;
  }
  
  public HeatMapLayerOptions getOptions()
  {
    return this.h;
  }
  
  public float getZIndex()
  {
    return this.e;
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
  {
    return this.c;
  }
  
  public void remove()
    throws RemoteException
  {
    if ((this.b != null) && (!this.b.a(this.d, true))) {
      destroy();
    }
  }
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setOptions(HeatMapLayerOptions paramHeatMapLayerOptions)
  {
    this.h = paramHeatMapLayerOptions;
    if (this.h != null)
    {
      this.e = this.h.getZIndex();
      this.c = this.h.isVisible();
    }
    this.f = true;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setZIndex(float paramFloat)
  {
    try
    {
      this.e = paramFloat;
      this.b.e();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */