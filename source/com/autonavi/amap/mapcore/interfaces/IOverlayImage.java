package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;

public abstract interface IOverlayImage
{
  public abstract void destroy(boolean paramBoolean);
  
  public abstract boolean equalsRemote(IOverlayImage paramIOverlayImage)
    throws RemoteException;
  
  public abstract float getAnchorU();
  
  public abstract float getAnchorV();
  
  public abstract String getId()
    throws RemoteException;
  
  public abstract Object getObject();
  
  public abstract LatLng getPosition()
    throws RemoteException;
  
  public abstract float getRotateAngle();
  
  public abstract float getZIndex();
  
  public abstract int hashCodeRemote();
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract boolean remove()
    throws RemoteException;
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException;
  
  public abstract void setObject(Object paramObject);
  
  public abstract void setPosition(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract void setRotateAngle(float paramFloat)
    throws RemoteException;
  
  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZIndex(float paramFloat);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IOverlayImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */