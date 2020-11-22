package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;

public abstract interface IOverlay
{
  public abstract void destroy();
  
  public abstract boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException;
  
  public abstract String getId()
    throws RemoteException;
  
  public abstract float getZIndex()
    throws RemoteException;
  
  public abstract int hashCodeRemote()
    throws RemoteException;
  
  public abstract boolean isAboveMaskLayer();
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract void remove()
    throws RemoteException;
  
  public abstract void setAboveMaskLayer(boolean paramBoolean);
  
  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZIndex(float paramFloat)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */