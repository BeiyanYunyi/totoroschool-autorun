package com.amap.api.maps.model;

public class HeatMapItem
{
  private LatLng center;
  private int[] indexes;
  private double intensity;
  
  public LatLng getCenter()
  {
    return this.center;
  }
  
  public int[] getIndexes()
  {
    return this.indexes;
  }
  
  public double getIntensity()
  {
    return this.intensity;
  }
  
  public void setCenter(double paramDouble1, double paramDouble2)
  {
    this.center = new LatLng(paramDouble1, paramDouble2);
  }
  
  public void setIndexes(int[] paramArrayOfInt)
  {
    this.indexes = paramArrayOfInt;
  }
  
  public void setIntensity(double paramDouble)
  {
    this.intensity = paramDouble;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\HeatMapItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */