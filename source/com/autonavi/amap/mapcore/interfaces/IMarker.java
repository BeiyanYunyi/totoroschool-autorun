package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;

public abstract interface IMarker
  extends IOverlayImage
{
  public abstract IPoint getGeoPoint();
  
  public abstract IMarkerAction getIMarkerAction();
  
  public abstract ArrayList<BitmapDescriptor> getIcons()
    throws RemoteException;
  
  public abstract int getPeriod()
    throws RemoteException;
  
  public abstract String getSnippet()
    throws RemoteException;
  
  public abstract String getTitle()
    throws RemoteException;
  
  public abstract void hideInfoWindow()
    throws RemoteException;
  
  public abstract boolean isDraggable();
  
  public abstract boolean isFlat();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract boolean isPerspective()
    throws RemoteException;
  
  public abstract boolean isRemoved();
  
  public abstract void set2Top()
    throws RemoteException;
  
  public abstract void setAnimation(Animation paramAnimation);
  
  public abstract void setAnimationListener(Animation.AnimationListener paramAnimationListener);
  
  public abstract void setBelowMaskLayer(boolean paramBoolean);
  
  public abstract void setDraggable(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setFlat(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setGeoPoint(IPoint paramIPoint);
  
  public abstract void setIcon(BitmapDescriptor paramBitmapDescriptor)
    throws RemoteException;
  
  public abstract void setIcons(ArrayList<BitmapDescriptor> paramArrayList)
    throws RemoteException;
  
  public abstract void setPeriod(int paramInt)
    throws RemoteException;
  
  public abstract void setPerspective(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setPositionByPixels(int paramInt1, int paramInt2);
  
  public abstract void setSnippet(String paramString)
    throws RemoteException;
  
  public abstract void setTitle(String paramString)
    throws RemoteException;
  
  public abstract void showInfoWindow()
    throws RemoteException;
  
  public abstract boolean startAnimation();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */