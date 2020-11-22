package com.autonavi.amap.mapcore.interfaces;

public abstract interface ITileOverlay
{
  public abstract void clearTileCache();
  
  public abstract void destroy(boolean paramBoolean);
  
  public abstract boolean equalsRemote(ITileOverlay paramITileOverlay);
  
  public abstract String getId();
  
  public abstract float getZIndex();
  
  public abstract int hashCodeRemote();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(float paramFloat);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\ITileOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */