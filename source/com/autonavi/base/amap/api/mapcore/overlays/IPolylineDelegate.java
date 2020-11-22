package com.autonavi.base.amap.api.mapcore.overlays;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.interfaces.IPolyline;
import java.util.List;

public abstract interface IPolylineDelegate
  extends IPolyline, IOverlayDelegate
{
  public abstract boolean contains(LatLng paramLatLng);
  
  public abstract void reLoadTexture();
  
  public abstract void setColorValues(List<Integer> paramList);
  
  public abstract void setCustomTextureList(List<BitmapDescriptor> paramList);
  
  public abstract void useGradient(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\IPolylineDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */