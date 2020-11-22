package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;

public abstract interface IArc
  extends IOverlay
{
  public abstract int getStrokeColor()
    throws RemoteException;
  
  public abstract float getStrokeWidth()
    throws RemoteException;
  
  public abstract void setStrokeColor(int paramInt)
    throws RemoteException;
  
  public abstract void setStrokeWidth(float paramFloat)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IArc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */