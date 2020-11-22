package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.lf;

public class Inner_3dMap_locationOption
  implements Cloneable
{
  static String APIKEY = "";
  private static Inner_3dMap_Enum_LocationProtocol locationProtocol = Inner_3dMap_Enum_LocationProtocol.HTTP;
  private long httpTimeOut = lf.f;
  private long interval = 2000L;
  private boolean isGpsFirst = false;
  private boolean isKillProcess = false;
  private boolean isLocationCacheEnable = true;
  private boolean isMockEnable = false;
  private boolean isNeedAddress = true;
  private boolean isOffset = true;
  private boolean isOnceLocation = false;
  private boolean isOnceLocationLatest = false;
  private boolean isWifiActiveScan = true;
  private boolean isWifiScan = true;
  private boolean lastWifiActiveScan = true;
  private Inner_3dMap_Enum_LocationMode locationMode = Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
  private boolean sensorEnable = false;
  
  private Inner_3dMap_locationOption clone(Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    this.interval = paramInner_3dMap_locationOption.interval;
    this.isOnceLocation = paramInner_3dMap_locationOption.isOnceLocation;
    this.locationMode = paramInner_3dMap_locationOption.locationMode;
    this.isMockEnable = paramInner_3dMap_locationOption.isMockEnable;
    this.isKillProcess = paramInner_3dMap_locationOption.isKillProcess;
    this.isGpsFirst = paramInner_3dMap_locationOption.isGpsFirst;
    this.isNeedAddress = paramInner_3dMap_locationOption.isNeedAddress;
    this.isWifiActiveScan = paramInner_3dMap_locationOption.isWifiActiveScan;
    this.httpTimeOut = paramInner_3dMap_locationOption.httpTimeOut;
    this.isOffset = paramInner_3dMap_locationOption.isOffset;
    this.isLocationCacheEnable = paramInner_3dMap_locationOption.isLocationCacheEnable;
    this.isOnceLocationLatest = paramInner_3dMap_locationOption.isOnceLocationLatest;
    this.sensorEnable = paramInner_3dMap_locationOption.isSensorEnable();
    this.isWifiScan = paramInner_3dMap_locationOption.isWifiScan();
    return this;
  }
  
  public static String getAPIKEY()
  {
    return APIKEY;
  }
  
  public static void setLocationProtocol(Inner_3dMap_Enum_LocationProtocol paramInner_3dMap_Enum_LocationProtocol)
  {
    locationProtocol = paramInner_3dMap_Enum_LocationProtocol;
  }
  
  public Inner_3dMap_locationOption clone()
  {
    try
    {
      super.clone();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return new Inner_3dMap_locationOption().clone(this);
  }
  
  public long getHttpTimeOut()
  {
    return this.httpTimeOut;
  }
  
  public long getInterval()
  {
    return this.interval;
  }
  
  public Inner_3dMap_Enum_LocationMode getLocationMode()
  {
    return this.locationMode;
  }
  
  public Inner_3dMap_Enum_LocationProtocol getLocationProtocol()
  {
    return locationProtocol;
  }
  
  public boolean isGpsFirst()
  {
    return this.isGpsFirst;
  }
  
  public boolean isKillProcess()
  {
    return this.isKillProcess;
  }
  
  public boolean isLocationCacheEnable()
  {
    return this.isLocationCacheEnable;
  }
  
  public boolean isMockEnable()
  {
    return this.isMockEnable;
  }
  
  public boolean isNeedAddress()
  {
    return this.isNeedAddress;
  }
  
  public boolean isOffset()
  {
    return this.isOffset;
  }
  
  public boolean isOnceLocation()
  {
    if (this.isOnceLocationLatest) {
      return true;
    }
    return this.isOnceLocation;
  }
  
  public boolean isOnceLocationLatest()
  {
    return this.isOnceLocationLatest;
  }
  
  public boolean isSensorEnable()
  {
    return this.sensorEnable;
  }
  
  public boolean isWifiActiveScan()
  {
    return this.isWifiActiveScan;
  }
  
  public boolean isWifiScan()
  {
    return this.isWifiScan;
  }
  
  public Inner_3dMap_locationOption setGpsFirst(boolean paramBoolean)
  {
    this.isGpsFirst = paramBoolean;
    return this;
  }
  
  public void setHttpTimeOut(long paramLong)
  {
    this.httpTimeOut = paramLong;
  }
  
  public Inner_3dMap_locationOption setInterval(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 800L) {
      l = 800L;
    }
    this.interval = l;
    return this;
  }
  
  public Inner_3dMap_locationOption setKillProcess(boolean paramBoolean)
  {
    this.isKillProcess = paramBoolean;
    return this;
  }
  
  public void setLocationCacheEnable(boolean paramBoolean)
  {
    this.isLocationCacheEnable = paramBoolean;
  }
  
  public Inner_3dMap_locationOption setLocationMode(Inner_3dMap_Enum_LocationMode paramInner_3dMap_Enum_LocationMode)
  {
    this.locationMode = paramInner_3dMap_Enum_LocationMode;
    return this;
  }
  
  public void setMockEnable(boolean paramBoolean)
  {
    this.isMockEnable = paramBoolean;
  }
  
  public Inner_3dMap_locationOption setNeedAddress(boolean paramBoolean)
  {
    this.isNeedAddress = paramBoolean;
    return this;
  }
  
  public Inner_3dMap_locationOption setOffset(boolean paramBoolean)
  {
    this.isOffset = paramBoolean;
    return this;
  }
  
  public Inner_3dMap_locationOption setOnceLocation(boolean paramBoolean)
  {
    this.isOnceLocation = paramBoolean;
    return this;
  }
  
  public void setOnceLocationLatest(boolean paramBoolean)
  {
    this.isOnceLocationLatest = paramBoolean;
  }
  
  public void setSensorEnable(boolean paramBoolean)
  {
    this.sensorEnable = paramBoolean;
  }
  
  public void setWifiActiveScan(boolean paramBoolean)
  {
    this.isWifiActiveScan = paramBoolean;
    this.lastWifiActiveScan = paramBoolean;
  }
  
  public void setWifiScan(boolean paramBoolean)
  {
    this.isWifiScan = paramBoolean;
    if (this.isWifiScan) {}
    for (paramBoolean = this.lastWifiActiveScan;; paramBoolean = false)
    {
      this.isWifiActiveScan = paramBoolean;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("interval:");
    localStringBuilder.append(String.valueOf(this.interval));
    localStringBuilder.append("#");
    localStringBuilder.append("isOnceLocation:");
    localStringBuilder.append(String.valueOf(this.isOnceLocation));
    localStringBuilder.append("#");
    localStringBuilder.append("locationMode:");
    localStringBuilder.append(String.valueOf(this.locationMode));
    localStringBuilder.append("#");
    localStringBuilder.append("isMockEnable:");
    localStringBuilder.append(String.valueOf(this.isMockEnable));
    localStringBuilder.append("#");
    localStringBuilder.append("isKillProcess:");
    localStringBuilder.append(String.valueOf(this.isKillProcess));
    localStringBuilder.append("#");
    localStringBuilder.append("isGpsFirst:");
    localStringBuilder.append(String.valueOf(this.isGpsFirst));
    localStringBuilder.append("#");
    localStringBuilder.append("isNeedAddress:");
    localStringBuilder.append(String.valueOf(this.isNeedAddress));
    localStringBuilder.append("#");
    localStringBuilder.append("isWifiActiveScan:");
    localStringBuilder.append(String.valueOf(this.isWifiActiveScan));
    localStringBuilder.append("#");
    localStringBuilder.append("httpTimeOut:");
    localStringBuilder.append(String.valueOf(this.httpTimeOut));
    localStringBuilder.append("#");
    localStringBuilder.append("isOffset:");
    localStringBuilder.append(String.valueOf(this.isOffset));
    localStringBuilder.append("#");
    localStringBuilder.append("isLocationCacheEnable:");
    localStringBuilder.append(String.valueOf(this.isLocationCacheEnable));
    localStringBuilder.append("#");
    localStringBuilder.append("isLocationCacheEnable:");
    localStringBuilder.append(String.valueOf(this.isLocationCacheEnable));
    localStringBuilder.append("#");
    localStringBuilder.append("isOnceLocationLatest:");
    localStringBuilder.append(String.valueOf(this.isOnceLocationLatest));
    localStringBuilder.append("#");
    localStringBuilder.append("sensorEnable:");
    localStringBuilder.append(String.valueOf(this.sensorEnable));
    localStringBuilder.append("#");
    return localStringBuilder.toString();
  }
  
  public static enum Inner_3dMap_Enum_LocationMode
  {
    Battery_Saving,  Device_Sensors,  Hight_Accuracy;
    
    private Inner_3dMap_Enum_LocationMode() {}
  }
  
  public static enum Inner_3dMap_Enum_LocationProtocol
  {
    HTTP(0),  HTTPS(1);
    
    private int value;
    
    private Inner_3dMap_Enum_LocationProtocol(int paramInt)
    {
      this.value = paramInt;
    }
    
    public final int getValue()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\Inner_3dMap_locationOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */