package com.autonavi.base.amap.api.mapcore.infowindow;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.v;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;

public abstract interface IInfoWindowAction
{
  public abstract void hideInfoWindow();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract boolean onInfoWindowTap(MotionEvent paramMotionEvent);
  
  public abstract void redrawInfoWindow();
  
  public abstract void setInfoWindowAdapterManager(v paramv);
  
  public abstract void showInfoWindow(BaseOverlayImp paramBaseOverlayImp)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\infowindow\IInfoWindowAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */