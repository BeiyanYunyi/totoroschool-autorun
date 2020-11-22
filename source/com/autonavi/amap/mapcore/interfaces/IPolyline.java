package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolylineOptions;
import java.util.List;

public abstract interface IPolyline
  extends IOverlay
{
  public abstract int getColor()
    throws RemoteException;
  
  public abstract LatLng getNearestLatLng(LatLng paramLatLng);
  
  public abstract PolylineOptions getOptions();
  
  public abstract List<LatLng> getPoints()
    throws RemoteException;
  
  public abstract float getShownRatio();
  
  public abstract float getWidth()
    throws RemoteException;
  
  public abstract boolean isDottedLine();
  
  public abstract boolean isGeodesic();
  
  public abstract void setColor(int paramInt)
    throws RemoteException;
  
  public abstract void setCustemTextureIndex(List<Integer> paramList);
  
  public abstract void setCustomTexture(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setCustomTextureList(List<BitmapDescriptor> paramList);
  
  public abstract void setDottedLine(boolean paramBoolean);
  
  public abstract void setGeodesic(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setOptions(PolylineOptions paramPolylineOptions);
  
  public abstract void setPoints(List<LatLng> paramList)
    throws RemoteException;
  
  public abstract void setShowRange(float paramFloat1, float paramFloat2);
  
  public abstract void setShownRatio(float paramFloat);
  
  public abstract void setTransparency(float paramFloat);
  
  public abstract void setWidth(float paramFloat)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IPolyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */