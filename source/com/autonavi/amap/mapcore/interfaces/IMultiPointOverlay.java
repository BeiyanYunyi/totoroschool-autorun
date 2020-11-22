package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.MultiPointItem;
import com.autonavi.amap.mapcore.IPoint;
import java.util.List;

public abstract interface IMultiPointOverlay
{
  public abstract void addItem(MultiPointItem paramMultiPointItem);
  
  public abstract void addItems(List<MultiPointItem> paramList);
  
  public abstract void destroy(boolean paramBoolean);
  
  public abstract String getId()
    throws RemoteException;
  
  public abstract MultiPointItem onClick(IPoint paramIPoint);
  
  public abstract void remove(boolean paramBoolean);
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setVisible(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IMultiPointOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */