package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;

public abstract interface IUiSettings
{
  public abstract float getLogoMarginRate(int paramInt)
    throws RemoteException;
  
  public abstract int getLogoPosition()
    throws RemoteException;
  
  public abstract int getZoomPosition()
    throws RemoteException;
  
  public abstract boolean isCompassEnabled()
    throws RemoteException;
  
  public abstract boolean isGestureScaleByMapCenter()
    throws RemoteException;
  
  public abstract boolean isIndoorSwitchEnabled()
    throws RemoteException;
  
  public abstract boolean isLogoEnable();
  
  public abstract boolean isMyLocationButtonEnabled()
    throws RemoteException;
  
  public abstract boolean isRotateGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isScaleControlsEnabled()
    throws RemoteException;
  
  public abstract boolean isScrollGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isTiltGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomControlsEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomInByScreenCenter()
    throws RemoteException;
  
  public abstract void requestRefreshLogo();
  
  public abstract void setAllGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setCompassEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setGestureScaleByMapCenter(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setIndoorSwitchEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setLogoBottomMargin(int paramInt)
    throws RemoteException;
  
  public abstract void setLogoEnable(boolean paramBoolean);
  
  public abstract void setLogoLeftMargin(int paramInt)
    throws RemoteException;
  
  public abstract void setLogoMarginRate(int paramInt, float paramFloat)
    throws RemoteException;
  
  public abstract void setLogoPosition(int paramInt)
    throws RemoteException;
  
  public abstract void setMyLocationButtonEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setRotateGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setScaleControlsEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setScrollGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setTiltGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomControlsEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomInByScreenCenter(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomPosition(int paramInt)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IUiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */