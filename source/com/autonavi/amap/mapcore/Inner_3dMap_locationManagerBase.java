package com.autonavi.amap.mapcore;

public abstract interface Inner_3dMap_locationManagerBase
{
  public abstract void destroy();
  
  public abstract Inner_3dMap_location getLastKnownLocation();
  
  public abstract void setLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener);
  
  public abstract void setLocationOption(Inner_3dMap_locationOption paramInner_3dMap_locationOption);
  
  public abstract void startLocation();
  
  public abstract void stopLocation();
  
  public abstract void unRegisterLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\Inner_3dMap_locationManagerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */