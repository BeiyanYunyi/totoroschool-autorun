package com.amap.api.maps.model;

import java.util.ArrayList;
import java.util.List;

public class GL3DModelOptions
{
  private BitmapDescriptor bitmapDescriptor;
  private int fixedLength;
  private LatLng latLng;
  private float rotate;
  private List<Float> textrueList = new ArrayList();
  private List<Float> vertextList = new ArrayList();
  
  public GL3DModelOptions angle(float paramFloat)
  {
    this.rotate = paramFloat;
    return this;
  }
  
  public float getAngle()
  {
    return this.rotate;
  }
  
  public BitmapDescriptor getBitmapDescriptor()
  {
    return this.bitmapDescriptor;
  }
  
  public LatLng getLatLng()
  {
    return this.latLng;
  }
  
  public int getModelFixedLength()
  {
    return this.fixedLength;
  }
  
  public List<Float> getTextrue()
  {
    return this.textrueList;
  }
  
  public List<Float> getVertext()
  {
    return this.vertextList;
  }
  
  public GL3DModelOptions position(LatLng paramLatLng)
  {
    this.latLng = paramLatLng;
    return this;
  }
  
  public GL3DModelOptions setModelFixedLength(int paramInt)
  {
    this.fixedLength = paramInt;
    return this;
  }
  
  public GL3DModelOptions textureDrawable(BitmapDescriptor paramBitmapDescriptor)
  {
    this.bitmapDescriptor = paramBitmapDescriptor;
    return this;
  }
  
  public GL3DModelOptions vertexData(List<Float> paramList1, List<Float> paramList2)
  {
    this.vertextList = paramList1;
    this.textrueList = paramList2;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\GL3DModelOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */