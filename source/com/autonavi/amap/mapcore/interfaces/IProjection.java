package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

public abstract interface IProjection
{
  public abstract TileProjection fromBoundsToTile(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract LatLng fromScreenLocation(Point paramPoint)
    throws RemoteException;
  
  public abstract AMapCameraInfo getCameraInfo();
  
  public abstract LatLngBounds getMapBounds(LatLng paramLatLng, float paramFloat)
    throws RemoteException;
  
  public abstract VisibleRegion getVisibleRegion()
    throws RemoteException;
  
  public abstract float toMapLenWithWin(int paramInt)
    throws RemoteException;
  
  public abstract PointF toMapLocation(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract Point toScreenLocation(LatLng paramLatLng)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */