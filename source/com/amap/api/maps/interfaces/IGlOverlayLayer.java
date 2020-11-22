package com.amap.api.maps.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;

public abstract interface IGlOverlayLayer
{
  public abstract boolean IsCircleContainPoint(CircleOptions paramCircleOptions, LatLng paramLatLng);
  
  public abstract boolean IsPolygonContainsPoint(PolygonOptions paramPolygonOptions, LatLng paramLatLng);
  
  public abstract int getCurrentParticleNum(String paramString);
  
  public abstract LatLng getNearestLatLng(PolylineOptions paramPolylineOptions, LatLng paramLatLng);
  
  public abstract void prepareIcon(Object paramObject);
  
  public abstract void processCircleHoleOption(CircleOptions paramCircleOptions);
  
  public abstract void processPolygonHoleOption(PolygonOptions paramPolygonOptions);
  
  public abstract boolean removeOverlay(String paramString)
    throws RemoteException;
  
  public abstract void updateOption(String paramString, Object paramObject);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\interfaces\IGlOverlayLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */