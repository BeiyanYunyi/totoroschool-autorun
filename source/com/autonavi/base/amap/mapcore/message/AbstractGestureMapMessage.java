package com.autonavi.base.amap.mapcore.message;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.AbstractMapMessage;
import com.autonavi.base.ae.gmap.GLMapState;

public abstract class AbstractGestureMapMessage
  extends AbstractMapMessage
{
  public int anchorX;
  public int anchorY;
  public int height = 0;
  public boolean isGestureScaleByMapCenter = false;
  public boolean isUseAnchor = false;
  private int state = 0;
  public int width = 0;
  
  public AbstractGestureMapMessage(int paramInt)
  {
    this.state = paramInt;
  }
  
  protected IPoint getAnchorGeoPoint(GLMapState paramGLMapState, int paramInt1, int paramInt2)
  {
    IPoint localIPoint = IPoint.obtain();
    paramGLMapState.screenToP20Point(paramInt1, paramInt2, localIPoint);
    return localIPoint;
  }
  
  public int getMapGestureState()
  {
    return this.state;
  }
  
  public abstract int getType();
  
  public void reset()
  {
    this.width = 0;
    this.height = 0;
    this.state = 0;
    this.isGestureScaleByMapCenter = false;
    this.isUseAnchor = false;
    this.anchorX = 0;
    this.anchorY = 0;
  }
  
  public abstract void runCameraUpdate(GLMapState paramGLMapState);
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  protected void win2geo(GLMapState paramGLMapState, int paramInt1, int paramInt2, IPoint paramIPoint)
  {
    paramGLMapState.screenToP20Point(paramInt1, paramInt2, paramIPoint);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\message\AbstractGestureMapMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */