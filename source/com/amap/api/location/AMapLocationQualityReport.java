package com.amap.api.location;

import com.loc.dg;

public class AMapLocationQualityReport
  implements Cloneable
{
  public static final int GPS_STATUS_MODE_SAVING = 3;
  public static final int GPS_STATUS_NOGPSPERMISSION = 4;
  public static final int GPS_STATUS_NOGPSPROVIDER = 1;
  public static final int GPS_STATUS_OFF = 2;
  public static final int GPS_STATUS_OK = 0;
  AMapLocationClientOption.AMapLocationMode a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
  private boolean b = false;
  private int c = 2;
  private int d = 0;
  private String e = "UNKNOWN";
  private long f = 0L;
  private boolean g = false;
  
  protected AMapLocationQualityReport clone()
  {
    AMapLocationQualityReport localAMapLocationQualityReport = new AMapLocationQualityReport();
    try
    {
      super.clone();
      try
      {
        localAMapLocationQualityReport.setGpsStatus(this.c);
        localAMapLocationQualityReport.setGPSSatellites(this.d);
        localAMapLocationQualityReport.setWifiAble(this.b);
        localAMapLocationQualityReport.setNetUseTime(this.f);
        localAMapLocationQualityReport.setNetworkType(this.e);
        localAMapLocationQualityReport.setLocationMode(this.a);
        localAMapLocationQualityReport.setInstallHighDangerMockApp(this.g);
        return localAMapLocationQualityReport;
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "AMapLocationQualityReport", "clone");
        return localAMapLocationQualityReport;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;) {}
    }
  }
  
  public String getAdviseMessage()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (this.a != AMapLocationClientOption.AMapLocationMode.Battery_Saving)
    {
      if (this.c != 0) {
        switch (this.c)
        {
        default: 
          break;
        case 4: 
          str = "您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n";
          break;
        case 3: 
          str = "您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n";
          break;
        case 2: 
          str = "您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n";
          break;
        }
      }
      for (str = "您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n";; str = "当前GPS信号弱，位置更新可能会延迟\n")
      {
        localStringBuffer.append(str);
        break;
        if ((this.a != AMapLocationClientOption.AMapLocationMode.Device_Sensors) || (this.d >= 4)) {
          break;
        }
      }
    }
    if (this.a != AMapLocationClientOption.AMapLocationMode.Device_Sensors)
    {
      if ("DISCONNECTED".equals(this.e)) {}
      for (str = "您的设备未连接到网络，无法进行网络定位\n";; str = "您的设备网络状态不太好，网络定位可能会有延迟\n")
      {
        localStringBuffer.append(str);
        break;
        if (!"2G".equals(this.e)) {
          break;
        }
      }
      if (!this.b) {
        localStringBuffer.append("您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n");
      }
    }
    return localStringBuffer.toString();
  }
  
  public int getGPSSatellites()
  {
    return this.d;
  }
  
  public int getGPSStatus()
  {
    return this.c;
  }
  
  public long getNetUseTime()
  {
    return this.f;
  }
  
  public String getNetworkType()
  {
    return this.e;
  }
  
  public boolean isInstalledHighDangerMockApp()
  {
    return this.g;
  }
  
  public boolean isWifiAble()
  {
    return this.b;
  }
  
  public void setGPSSatellites(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setGpsStatus(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setInstallHighDangerMockApp(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setLocationMode(AMapLocationClientOption.AMapLocationMode paramAMapLocationMode)
  {
    this.a = paramAMapLocationMode;
  }
  
  public void setNetUseTime(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void setNetworkType(String paramString)
  {
    this.e = paramString;
  }
  
  public void setWifiAble(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\AMapLocationQualityReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */