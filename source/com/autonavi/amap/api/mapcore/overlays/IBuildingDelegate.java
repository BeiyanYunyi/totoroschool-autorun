package com.autonavi.amap.api.mapcore.overlays;

import com.amap.api.maps.model.BuildingOverlayOptions;
import java.util.List;

public abstract interface IBuildingDelegate
{
  public abstract void destroy();
  
  public abstract List<BuildingOverlayOptions> getCustomOptions();
  
  public abstract BuildingOverlayOptions getDefaultOptions();
  
  public abstract String getId();
  
  public abstract float getZIndex();
  
  public abstract boolean isVisible();
  
  public abstract void setCustomOptions(List<BuildingOverlayOptions> paramList);
  
  public abstract void setDefaultOptions(BuildingOverlayOptions paramBuildingOverlayOptions);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(float paramFloat);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\api\mapcore\overlays\IBuildingDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */