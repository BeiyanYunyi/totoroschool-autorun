package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;

public abstract interface IMarkerAction
{
  public abstract float getAlpha();
  
  public abstract int getDisplayLevel();
  
  public abstract MarkerOptions getOptions();
  
  public abstract boolean isClickable();
  
  public abstract boolean isInfoWindowAutoOverturn();
  
  public abstract boolean isInfoWindowEnable();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setAutoOverturnInfoWindow(boolean paramBoolean);
  
  public abstract void setClickable(boolean paramBoolean);
  
  public abstract void setDisplayLevel(int paramInt);
  
  public abstract void setFixingPointEnable(boolean paramBoolean);
  
  public abstract void setInfoWindowEnable(boolean paramBoolean);
  
  public abstract void setMarkerOptions(MarkerOptions paramMarkerOptions);
  
  public abstract void setPositionNotUpdate(LatLng paramLatLng);
  
  public abstract void setRotateAngleNotUpdate(float paramFloat);
  
  public abstract void setSnippet(String paramString);
  
  public abstract void setTitle(String paramString);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IMarkerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */