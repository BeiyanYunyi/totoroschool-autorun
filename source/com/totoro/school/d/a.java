package com.totoro.school.d;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.amap.api.maps.model.LatLng;
import com.totoro.school.MyApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
  implements AMapLocationListener
{
  private static final String a = "a";
  private static volatile a b;
  private AMapLocationClient c;
  private AMapLocation d;
  
  public static a a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new a();
        }
      }
      finally {}
    }
    return b;
  }
  
  public float a(DPoint paramDPoint1, DPoint paramDPoint2)
  {
    return CoordinateConverter.calculateLineDistance(paramDPoint1, paramDPoint2);
  }
  
  public void b()
  {
    if (this.c == null)
    {
      this.c = new AMapLocationClient(MyApplication.a().getApplicationContext());
      this.c.setLocationListener(this);
    }
    AMapLocationClientOption localAMapLocationClientOption = new AMapLocationClientOption();
    localAMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    localAMapLocationClientOption.setInterval(3000L);
    localAMapLocationClientOption.setNeedAddress(true);
    localAMapLocationClientOption.setMockEnable(false);
    this.c.setLocationOption(localAMapLocationClientOption);
    this.c.startLocation();
  }
  
  public DPoint c()
  {
    if (this.d == null) {
      return null;
    }
    return new DPoint(this.d.getLatitude(), this.d.getLongitude());
  }
  
  public void d()
  {
    this.d = null;
    if (this.c != null)
    {
      this.c.stopLocation();
      this.c.onDestroy();
      this.c = null;
    }
  }
  
  public void onLocationChanged(AMapLocation paramAMapLocation)
  {
    if ((paramAMapLocation != null) && (paramAMapLocation.getErrorCode() == 0))
    {
      this.d = paramAMapLocation;
      com.totoro.school.utilpub.a.a.a().a(new LatLng(paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude()));
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramAMapLocation.getTime()));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */