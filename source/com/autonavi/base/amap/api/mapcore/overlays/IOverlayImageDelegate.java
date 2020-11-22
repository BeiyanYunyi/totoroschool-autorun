package com.autonavi.base.amap.api.mapcore.overlays;

import android.graphics.Rect;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.interfaces.IAnimation;

public abstract interface IOverlayImageDelegate
  extends IOverlayImage
{
  public abstract boolean calFPoint();
  
  public abstract boolean checkInBounds();
  
  public abstract void drawMarker(IAMapDelegate paramIAMapDelegate);
  
  public abstract void drawMarker(IAMapDelegate paramIAMapDelegate, float[] paramArrayOfFloat, int paramInt, float paramFloat);
  
  public abstract IAnimation getIAnimation();
  
  public abstract IMarkerAction getIMarkerAction();
  
  public abstract Rect getRect();
  
  public abstract int getTextureId();
  
  public abstract boolean isAllowLow();
  
  public abstract boolean isBelowMaskLayer();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract boolean isOnTap();
  
  public abstract void loadTexture(IAMapDelegate paramIAMapDelegate);
  
  public abstract void reLoadTexture();
  
  public abstract void setOnTap(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\overlays\IOverlayImageDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */