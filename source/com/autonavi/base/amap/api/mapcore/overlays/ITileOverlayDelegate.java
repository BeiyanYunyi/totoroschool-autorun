package com.autonavi.base.amap.api.mapcore.overlays;

import com.autonavi.amap.mapcore.interfaces.ITileOverlay;

public abstract interface ITileOverlayDelegate
  extends ITileOverlay
{
  public abstract void drawTiles();
  
  public abstract void onFling(boolean paramBoolean);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void reLoadTexture();
  
  public abstract void refresh(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\ITileOverlayDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */