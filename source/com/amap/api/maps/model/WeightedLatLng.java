package com.amap.api.maps.model;

import com.amap.api.mapcore.util.dx;
import com.autonavi.amap.mapcore.DPoint;

public class WeightedLatLng
{
  public static final double DEFAULT_INTENSITY = 1.0D;
  public final double intensity;
  public final LatLng latLng;
  private DPoint mPoint;
  
  public WeightedLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 1.0D);
  }
  
  public WeightedLatLng(LatLng paramLatLng, double paramDouble)
  {
    if (paramLatLng != null)
    {
      this.latLng = paramLatLng;
      this.mPoint = dx.a(paramLatLng);
      if (paramDouble >= 0.0D)
      {
        this.intensity = paramDouble;
        return;
      }
      this.intensity = 1.0D;
      return;
    }
    throw new IllegalArgumentException("latLng can not null");
  }
  
  protected DPoint getPoint()
  {
    return this.mPoint;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\WeightedLatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */