package com.amap.api.maps.model;

public class RoutePara
{
  private int drivingRouteStyle = 0;
  private String endName;
  private LatLng endPoint;
  private String startName;
  private LatLng startPoint;
  private int transitRouteStyle = 0;
  
  public int getDrivingRouteStyle()
  {
    return this.drivingRouteStyle;
  }
  
  public String getEndName()
  {
    return this.endName;
  }
  
  public LatLng getEndPoint()
  {
    return this.endPoint;
  }
  
  public String getStartName()
  {
    return this.startName;
  }
  
  public LatLng getStartPoint()
  {
    return this.startPoint;
  }
  
  public int getTransitRouteStyle()
  {
    return this.transitRouteStyle;
  }
  
  public void setDrivingRouteStyle(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 9)) {
      this.drivingRouteStyle = paramInt;
    }
  }
  
  public void setEndName(String paramString)
  {
    this.endName = paramString;
  }
  
  public void setEndPoint(LatLng paramLatLng)
  {
    this.endPoint = paramLatLng;
  }
  
  public void setStartName(String paramString)
  {
    this.startName = paramString;
  }
  
  public void setStartPoint(LatLng paramLatLng)
  {
    this.startPoint = paramLatLng;
  }
  
  public void setTransitRouteStyle(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 6)) {
      this.transitRouteStyle = paramInt;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\RoutePara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */