package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IGroundOverlay;

public abstract interface IGroundOverlayDelegate
  extends IGroundOverlay, IOverlayDelegate
{
  public abstract void reLoadTexture();
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\IGroundOverlayDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */