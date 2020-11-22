package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode;

public class w
  implements LocationSource, Inner_3dMap_locationListener
{
  boolean a = false;
  long b = 2000L;
  private Bundle c = null;
  private LocationSource.OnLocationChangedListener d;
  private ei e;
  private Inner_3dMap_locationOption f;
  private Context g;
  
  public w(Context paramContext)
  {
    this.g = paramContext;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.f != null) && (this.e != null))
    {
      this.e.c();
      this.e = new ei(this.g);
      this.e.a(this);
      this.f.setOnceLocation(paramBoolean);
      if (!paramBoolean) {
        this.f.setInterval(this.b);
      }
      this.e.a(this.f);
      this.e.a();
    }
    this.a = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0))
    {
      a(false);
      return;
    }
    a(true);
  }
  
  public void a(long paramLong)
  {
    if ((this.f != null) && (this.e != null) && (this.f.getInterval() != paramLong))
    {
      this.f.setInterval(paramLong);
      this.e.a(this.f);
    }
    this.b = paramLong;
  }
  
  public void activate(LocationSource.OnLocationChangedListener paramOnLocationChangedListener)
  {
    this.d = paramOnLocationChangedListener;
    if (this.e == null)
    {
      this.e = new ei(this.g);
      this.f = new Inner_3dMap_locationOption();
      this.e.a(this);
      this.f.setInterval(this.b);
      this.f.setOnceLocation(this.a);
      this.f.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
      this.e.a(this.f);
      this.e.a();
    }
  }
  
  public void deactivate()
  {
    this.d = null;
    if (this.e != null)
    {
      this.e.b();
      this.e.c();
    }
    this.e = null;
  }
  
  public void onLocationChanged(Inner_3dMap_location paramInner_3dMap_location)
  {
    try
    {
      if ((this.d != null) && (paramInner_3dMap_location != null))
      {
        this.c = paramInner_3dMap_location.getExtras();
        if (this.c == null) {
          this.c = new Bundle();
        }
        this.c.putInt("errorCode", paramInner_3dMap_location.getErrorCode());
        this.c.putString("errorInfo", paramInner_3dMap_location.getErrorInfo());
        this.c.putInt("locationType", paramInner_3dMap_location.getLocationType());
        this.c.putFloat("Accuracy", paramInner_3dMap_location.getAccuracy());
        this.c.putString("AdCode", paramInner_3dMap_location.getAdCode());
        this.c.putString("Address", paramInner_3dMap_location.getAddress());
        this.c.putString("AoiName", paramInner_3dMap_location.getAoiName());
        this.c.putString("City", paramInner_3dMap_location.getCity());
        this.c.putString("CityCode", paramInner_3dMap_location.getCityCode());
        this.c.putString("Country", paramInner_3dMap_location.getCountry());
        this.c.putString("District", paramInner_3dMap_location.getDistrict());
        this.c.putString("Street", paramInner_3dMap_location.getStreet());
        this.c.putString("StreetNum", paramInner_3dMap_location.getStreetNum());
        this.c.putString("PoiName", paramInner_3dMap_location.getPoiName());
        this.c.putString("Province", paramInner_3dMap_location.getProvince());
        this.c.putFloat("Speed", paramInner_3dMap_location.getSpeed());
        this.c.putString("Floor", paramInner_3dMap_location.getFloor());
        this.c.putFloat("Bearing", paramInner_3dMap_location.getBearing());
        this.c.putString("BuildingId", paramInner_3dMap_location.getBuildingId());
        this.c.putDouble("Altitude", paramInner_3dMap_location.getAltitude());
        paramInner_3dMap_location.setExtras(this.c);
        this.d.onLocationChanged(paramInner_3dMap_location);
        return;
      }
    }
    catch (Throwable paramInner_3dMap_location)
    {
      paramInner_3dMap_location.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */