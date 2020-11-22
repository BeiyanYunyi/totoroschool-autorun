package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.IPoint;

public class MultiPointItem
{
  private String customerId = null;
  private IPoint iPoint;
  private LatLng latLng;
  private Object object;
  private String snippet;
  private String title;
  
  public MultiPointItem(LatLng paramLatLng)
  {
    this.latLng = paramLatLng;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof MultiPointItem))
    {
      if (this.customerId != null)
      {
        MultiPointItem localMultiPointItem = (MultiPointItem)paramObject;
        if (localMultiPointItem.getCustomerId() != null) {
          return this.customerId.equals(localMultiPointItem.getCustomerId());
        }
      }
      return super.equals(paramObject);
    }
    return false;
  }
  
  public String getCustomerId()
  {
    return this.customerId;
  }
  
  public IPoint getIPoint()
  {
    return this.iPoint;
  }
  
  public LatLng getLatLng()
  {
    return this.latLng;
  }
  
  public Object getObject()
  {
    return this.object;
  }
  
  public String getSnippet()
  {
    return this.snippet;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public void setCustomerId(String paramString)
  {
    this.customerId = paramString;
  }
  
  public void setIPoint(IPoint paramIPoint)
  {
    this.iPoint = paramIPoint;
  }
  
  public void setLatLng(LatLng paramLatLng)
  {
    this.latLng = paramLatLng;
  }
  
  public void setObject(Object paramObject)
  {
    this.object = paramObject;
  }
  
  public void setSnippet(String paramString)
  {
    this.snippet = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\MultiPointItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */