package com.amap.api.mapcore.util;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

public final class kl
{
  public static Inner_3dMap_location a;
  kj b = null;
  
  private static AMapLocationClientOption a(Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    AMapLocationClientOption localAMapLocationClientOption = new AMapLocationClientOption();
    localAMapLocationClientOption.setInterval(paramInner_3dMap_locationOption.getInterval());
    AMapLocationClientOption.AMapLocationMode localAMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    switch (1.a[paramInner_3dMap_locationOption.getLocationMode().ordinal()])
    {
    case 3: 
    default: 
      localAMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
      break;
    case 2: 
      localAMapLocationMode = AMapLocationClientOption.AMapLocationMode.Device_Sensors;
      break;
    case 1: 
      localAMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
    }
    localAMapLocationClientOption.setLocationMode(localAMapLocationMode);
    localAMapLocationClientOption.setLocationCacheEnable(paramInner_3dMap_locationOption.isLocationCacheEnable());
    localAMapLocationClientOption.setOnceLocation(paramInner_3dMap_locationOption.isOnceLocation());
    localAMapLocationClientOption.setNeedAddress(paramInner_3dMap_locationOption.isNeedAddress());
    return localAMapLocationClientOption;
  }
  
  public static Inner_3dMap_location a(AMapLocation paramAMapLocation)
  {
    Inner_3dMap_location localInner_3dMap_location = new Inner_3dMap_location("");
    if (paramAMapLocation != null) {
      try
      {
        localInner_3dMap_location.setLatitude(paramAMapLocation.getLatitude());
        localInner_3dMap_location.setLongitude(paramAMapLocation.getLongitude());
        localInner_3dMap_location.setAccuracy(paramAMapLocation.getAccuracy());
        localInner_3dMap_location.setBearing(paramAMapLocation.getBearing());
        localInner_3dMap_location.setAltitude(paramAMapLocation.getAltitude());
        localInner_3dMap_location.setProvider(paramAMapLocation.getProvider());
        localInner_3dMap_location.setSpeed(paramAMapLocation.getSpeed());
        localInner_3dMap_location.setTime(paramAMapLocation.getTime());
        localInner_3dMap_location.setErrorCode(paramAMapLocation.getErrorCode());
        localInner_3dMap_location.setErrorInfo(paramAMapLocation.getErrorInfo());
        localInner_3dMap_location.setLocationType(paramAMapLocation.getLocationType());
        localInner_3dMap_location.setLocationDetail(paramAMapLocation.getLocationDetail());
        localInner_3dMap_location.setProvince(paramAMapLocation.getProvince());
        localInner_3dMap_location.setCity(paramAMapLocation.getCity());
        localInner_3dMap_location.setCityCode(paramAMapLocation.getCityCode());
        localInner_3dMap_location.setCountry(paramAMapLocation.getCountry());
        localInner_3dMap_location.setDistrict(paramAMapLocation.getDistrict());
        localInner_3dMap_location.setAddress(paramAMapLocation.getAddress());
        localInner_3dMap_location.setAdCode(paramAMapLocation.getAdCode());
        localInner_3dMap_location.setExtras(paramAMapLocation.getExtras());
        localInner_3dMap_location.setRoad(paramAMapLocation.getRoad());
        return localInner_3dMap_location;
      }
      catch (Throwable paramAMapLocation)
      {
        lf.a(paramAMapLocation, "Util", "converterLocation");
      }
    }
    return localInner_3dMap_location;
  }
  
  public static void a(Object paramObject, Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    if (paramObject == null) {
      return;
    }
    paramInner_3dMap_locationOption = a(paramInner_3dMap_locationOption);
    ((AMapLocationClient)paramObject).setLocationOption(paramInner_3dMap_locationOption);
  }
  
  public final void a(Object paramObject, Inner_3dMap_locationListener paramInner_3dMap_locationListener)
  {
    if (this.b == null) {
      this.b = new kj();
    }
    this.b.a(paramInner_3dMap_locationListener);
    ((AMapLocationClient)paramObject).setLocationListener(this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */