package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.base.amap.mapcore.FPoint;

public abstract interface IMarkerDelegate
  extends IMarker, IOverlayImageDelegate
{
  public abstract FPoint anchorUVoff();
  
  public abstract IPoint getAnchor();
  
  public abstract BitmapDescriptor getBitmapDescriptor();
  
  public abstract int getHeight();
  
  public abstract int getInfoWindowOffsetX();
  
  public abstract int getInfoWindowOffsetY();
  
  public abstract FPoint getMapPosition();
  
  public abstract int getRealInfoWindowOffsetX();
  
  public abstract int getRealInfoWindowOffsetY();
  
  public abstract LatLng getRealPosition();
  
  public abstract int getWidth();
  
  public abstract boolean isContains();
  
  public abstract boolean isDestory();
  
  public abstract boolean isInfoWindowEnable();
  
  public abstract boolean isViewMode();
  
  public abstract void setInfoWindowOffset(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void setInfoWindowShown(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\IMarkerDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */