package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

public abstract interface INavigateArrow
  extends IOverlay
{
  public abstract List<LatLng> getPoints()
    throws RemoteException;
  
  public abstract int getSideColor()
    throws RemoteException;
  
  public abstract int getTopColor()
    throws RemoteException;
  
  public abstract float getWidth()
    throws RemoteException;
  
  public abstract boolean is3DModel();
  
  public abstract void set3DModel(boolean paramBoolean);
  
  public abstract void setPoints(List<LatLng> paramList)
    throws RemoteException;
  
  public abstract void setSideColor(int paramInt)
    throws RemoteException;
  
  public abstract void setTopColor(int paramInt)
    throws RemoteException;
  
  public abstract void setWidth(float paramFloat)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\INavigateArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */