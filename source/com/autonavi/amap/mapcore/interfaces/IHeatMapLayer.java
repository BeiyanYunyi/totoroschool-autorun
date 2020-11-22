package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.HeatMapItem;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.LatLng;

public abstract interface IHeatMapLayer
  extends IOverlay
{
  public abstract HeatMapItem getHeatMapItem(LatLng paramLatLng);
  
  public abstract HeatMapLayerOptions getOptions();
  
  public abstract void setOptions(HeatMapLayerOptions paramHeatMapLayerOptions);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IHeatMapLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */