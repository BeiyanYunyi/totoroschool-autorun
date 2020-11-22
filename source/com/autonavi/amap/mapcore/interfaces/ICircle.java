package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.LatLng;
import java.util.List;

public abstract interface ICircle
  extends IOverlay
{
  public abstract boolean contains(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract LatLng getCenter()
    throws RemoteException;
  
  public abstract int getDottedLineType();
  
  public abstract int getFillColor()
    throws RemoteException;
  
  public abstract List<BaseHoleOptions> getHoleOptions()
    throws RemoteException;
  
  public abstract double getRadius()
    throws RemoteException;
  
  public abstract int getStrokeColor()
    throws RemoteException;
  
  public abstract float getStrokeWidth()
    throws RemoteException;
  
  public abstract void setCenter(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract void setDottedLineType(int paramInt);
  
  public abstract void setFillColor(int paramInt)
    throws RemoteException;
  
  public abstract void setHoleOptions(List<BaseHoleOptions> paramList)
    throws RemoteException;
  
  public abstract void setRadius(double paramDouble)
    throws RemoteException;
  
  public abstract void setStrokeColor(int paramInt)
    throws RemoteException;
  
  public abstract void setStrokeWidth(float paramFloat)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\ICircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */