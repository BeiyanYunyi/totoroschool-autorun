package com.amap.api.maps.model;

public class MultiPointOverlayOptions
{
  private float anchorU = 0.5F;
  private float anchorV = 0.5F;
  private BitmapDescriptor bitmapDescriptor;
  
  public MultiPointOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.anchorU = paramFloat1;
    this.anchorV = paramFloat2;
    return this;
  }
  
  public float getAnchorU()
  {
    return this.anchorU;
  }
  
  public float getAnchorV()
  {
    return this.anchorV;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.bitmapDescriptor;
  }
  
  public MultiPointOverlayOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.bitmapDescriptor = paramBitmapDescriptor;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\MultiPointOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */