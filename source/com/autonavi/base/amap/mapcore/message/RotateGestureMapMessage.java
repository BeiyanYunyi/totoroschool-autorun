package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class RotateGestureMapMessage
  extends AbstractGestureMapMessage
{
  private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = new Pools.SynchronizedPool(256);
  public float angleDelta = 0.0F;
  public int pivotX = 0;
  public int pivotY = 0;
  
  public RotateGestureMapMessage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    setParams(paramInt1, paramFloat, paramInt2, paramInt3);
    this.angleDelta = paramFloat;
    this.pivotX = paramInt2;
    this.pivotY = paramInt3;
  }
  
  public static void destory()
  {
    M_POOL.destory();
  }
  
  public static RotateGestureMapMessage obtain(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    RotateGestureMapMessage localRotateGestureMapMessage = (RotateGestureMapMessage)M_POOL.acquire();
    if (localRotateGestureMapMessage == null) {
      return new RotateGestureMapMessage(paramInt1, paramFloat, paramInt2, paramInt3);
    }
    localRotateGestureMapMessage.reset();
    localRotateGestureMapMessage.setParams(paramInt1, paramFloat, paramInt2, paramInt3);
    return localRotateGestureMapMessage;
  }
  
  private void setParams(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    setState(paramInt1);
    this.angleDelta = paramFloat;
    this.pivotX = paramInt2;
    this.pivotY = paramInt3;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
  
  public void runCameraUpdate(GLMapState paramGLMapState)
  {
    float f = this.angleDelta;
    f = paramGLMapState.getMapAngle() + f;
    if (this.isGestureScaleByMapCenter)
    {
      paramGLMapState.setMapAngle(f);
      paramGLMapState.recalculate();
      return;
    }
    int i = this.pivotX;
    int j = this.pivotY;
    if (this.isUseAnchor)
    {
      i = this.anchorX;
      j = this.anchorY;
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
    paramGLMapState.setMapAngle(f);
    paramGLMapState.recalculate();
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\message\RotateGestureMapMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */