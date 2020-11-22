package com.amap.api.maps.model;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;

public class HeatMapLayer
{
  private IHeatMapLayer mHeatMapLayer;
  
  public HeatMapLayer(IHeatMapLayer paramIHeatMapLayer)
  {
    this.mHeatMapLayer = paramIHeatMapLayer;
  }
  
  public void destroy()
  {
    try
    {
      this.mHeatMapLayer.remove();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof HeatMapLayer)) {
        return false;
      }
      try
      {
        boolean bool = this.mHeatMapLayer.equalsRemote(((HeatMapLayer)paramObject).mHeatMapLayer);
        return bool;
      }
      catch (Throwable paramObject)
      {
        ((Throwable)paramObject).printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public HeatMapItem getHeatMapItem(LatLng paramLatLng)
  {
    try
    {
      paramLatLng = this.mHeatMapLayer.getHeatMapItem(paramLatLng);
      return paramLatLng;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
    return null;
  }
  
  public String getId()
  {
    try
    {
      String str = this.mHeatMapLayer.getId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return null;
  }
  
  public HeatMapLayerOptions getOptions()
  {
    try
    {
      HeatMapLayerOptions localHeatMapLayerOptions = this.mHeatMapLayer.getOptions();
      return localHeatMapLayerOptions;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getZIndex()
  {
    try
    {
      float f = this.mHeatMapLayer.getZIndex();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return 0.0F;
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.mHeatMapLayer.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return 0;
  }
  
  public boolean isVisible()
  {
    try
    {
      boolean bool = this.mHeatMapLayer.isVisible();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  public void setOptions(HeatMapLayerOptions paramHeatMapLayerOptions)
  {
    try
    {
      this.mHeatMapLayer.setOptions(paramHeatMapLayerOptions);
      return;
    }
    catch (Throwable paramHeatMapLayerOptions)
    {
      paramHeatMapLayerOptions.printStackTrace();
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      this.mHeatMapLayer.setVisible(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    try
    {
      this.mHeatMapLayer.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\HeatMapLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */