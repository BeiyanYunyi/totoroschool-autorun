package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.mapcore.MapConfig;

public abstract interface IOverlayDelegate
  extends IOverlay
{
  public abstract boolean calMapFPoint()
    throws RemoteException;
  
  public abstract boolean checkInBounds();
  
  public abstract void draw(MapConfig paramMapConfig)
    throws RemoteException;
  
  public abstract boolean isDrawFinish();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\IOverlayDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */