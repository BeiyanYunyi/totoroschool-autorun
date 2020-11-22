package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.ITileOverlay;

public final class TileOverlay
{
  private ITileOverlay mTileOverlayDelegate;
  
  public TileOverlay(ITileOverlay paramITileOverlay)
  {
    this.mTileOverlayDelegate = paramITileOverlay;
  }
  
  public void clearTileCache()
  {
    this.mTileOverlayDelegate.clearTileCache();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof TileOverlay)) {
        return false;
      }
      try
      {
        boolean bool = this.mTileOverlayDelegate.equalsRemote(((TileOverlay)paramObject).mTileOverlayDelegate);
        return bool;
      }
      catch (Throwable paramObject)
      {
        ((Throwable)paramObject).printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public String getId()
  {
    return this.mTileOverlayDelegate.getId();
  }
  
  public float getZIndex()
  {
    return this.mTileOverlayDelegate.getZIndex();
  }
  
  public int hashCode()
  {
    return this.mTileOverlayDelegate.hashCodeRemote();
  }
  
  public boolean isVisible()
  {
    return this.mTileOverlayDelegate.isVisible();
  }
  
  public void remove()
  {
    this.mTileOverlayDelegate.remove();
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.mTileOverlayDelegate.setVisible(paramBoolean);
  }
  
  public void setZIndex(float paramFloat)
  {
    this.mTileOverlayDelegate.setZIndex(paramFloat);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TileOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */