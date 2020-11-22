package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class ScaleGestureMapMessage
  extends AbstractGestureMapMessage
{
  private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = new Pools.SynchronizedPool(256);
  public int pivotX = 0;
  public int pivotY = 0;
  public float scaleDelta = 0.0F;
  
  public ScaleGestureMapMessage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    setParams(paramInt1, paramFloat, paramInt2, paramInt3);
  }
  
  public static void destory()
  {
    M_POOL.destory();
  }
  
  public static ScaleGestureMapMessage obtain(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    ScaleGestureMapMessage localScaleGestureMapMessage = (ScaleGestureMapMessage)M_POOL.acquire();
    if (localScaleGestureMapMessage == null) {
      return new ScaleGestureMapMessage(paramInt1, paramFloat, paramInt2, paramInt3);
    }
    localScaleGestureMapMessage.reset();
    localScaleGestureMapMessage.setParams(paramInt1, paramFloat, paramInt2, paramInt3);
    return localScaleGestureMapMessage;
  }
  
  private void setMapZoomer(GLMapState paramGLMapState)
  {
    float f = this.scaleDelta;
    paramGLMapState.setMapZoomer(paramGLMapState.getMapZoomer() + f);
    paramGLMapState.recalculate();
  }
  
  private void setParams(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    setState(paramInt1);
    this.scaleDelta = paramFloat;
    this.pivotX = paramInt2;
    this.pivotY = paramInt3;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
  
  public void runCameraUpdate(GLMapState paramGLMapState)
  {
    if (this.isUseAnchor)
    {
      setMapZoomer(paramGLMapState);
      return;
    }
    int i = this.pivotX;
    int j = this.pivotY;
    if (this.isGestureScaleByMapCenter)
    {
      i = this.width >> 1;
      j = this.height >> 1;
    }
    IPoint localIPoint2 = null;
    IPoint localIPoint1;
    if ((i <= 0) && (j <= 0))
    {
      localIPoint1 = null;
    }
    else
    {
      localIPoint1 = IPoint.obtain();
      localIPoint2 = IPoint.obtain();
      win2geo(paramGLMapState, i, j, localIPoint1);
      paramGLMapState.setMapGeoCenter(localIPoint1.x, localIPoint1.y);
    }
    setMapZoomer(paramGLMapState);
    if ((i > 0) || (j > 0))
    {
      win2geo(paramGLMapState, i, j, localIPoint2);
      if (localIPoint1 != null) {
        paramGLMapState.setMapGeoCenter(localIPoint1.x * 2 - localIPoint2.x, localIPoint1.y * 2 - localIPoint2.y);
      }
      paramGLMapState.recalculate();
    }
    if (localIPoint1 != null) {
      localIPoint1.recycle();
    }
    if (localIPoint2 != null) {
      localIPoint2.recycle();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\message\ScaleGestureMapMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */