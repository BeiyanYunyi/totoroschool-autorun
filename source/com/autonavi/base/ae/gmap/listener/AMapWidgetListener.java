package com.autonavi.base.ae.gmap.listener;

public abstract interface AMapWidgetListener
{
  public abstract void invalidateCompassView();
  
  public abstract void invalidateScaleView();
  
  public abstract void invalidateZoomController(float paramFloat);
  
  public abstract void setFrontViewVisibility(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\listener\AMapWidgetListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */