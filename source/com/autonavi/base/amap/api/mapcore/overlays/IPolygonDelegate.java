package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.interfaces.IPolygon;
import java.util.List;

public abstract interface IPolygonDelegate
  extends IPolygon, IOverlayDelegate
{
  public abstract List<LatLng> getHoles();
  
  public abstract boolean isGeodesic();
  
  public abstract void setGeodesic(boolean paramBoolean);
  
  public abstract void setHoles(List<LatLng> paramList)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\IPolygonDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */