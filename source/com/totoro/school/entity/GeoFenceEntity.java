package com.totoro.school.entity;

import com.amap.api.location.DPoint;

public class GeoFenceEntity
{
  public static final long RADIUS = 200L;
  private double Latitude;
  private double Longitude;
  private String id;
  private String name;
  
  public DPoint getDPoint()
  {
    return new DPoint(this.Latitude, this.Longitude);
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public double getLatitude()
  {
    return this.Latitude;
  }
  
  public double getLongitude()
  {
    return this.Longitude;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.Latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.Longitude = paramDouble;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\GeoFenceEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */