package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class MoveGestureMapMessage
  extends AbstractGestureMapMessage
{
  private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = new Pools.SynchronizedPool(1024);
  static int newCount;
  public float touchDeltaX = 0.0F;
  public float touchDeltaY = 0.0F;
  
  public MoveGestureMapMessage(int paramInt, float paramFloat1, float paramFloat2)
  {
    super(paramInt);
    this.touchDeltaX = paramFloat1;
    this.touchDeltaY = paramFloat2;
    newCount += 1;
  }
  
  public static void destory()
  {
    M_POOL.destory();
  }
  
  public static MoveGestureMapMessage obtain(int paramInt, float paramFloat1, float paramFloat2)
  {
    try
    {
      MoveGestureMapMessage localMoveGestureMapMessage = (MoveGestureMapMessage)M_POOL.acquire();
      if (localMoveGestureMapMessage == null)
      {
        localMoveGestureMapMessage = new MoveGestureMapMessage(paramInt, paramFloat1, paramFloat2);
      }
      else
      {
        localMoveGestureMapMessage.reset();
        localMoveGestureMapMessage.setParams(paramInt, paramFloat1, paramFloat2);
      }
      return localMoveGestureMapMessage;
    }
    finally {}
  }
  
  private void setParams(int paramInt, float paramFloat1, float paramFloat2)
  {
    setState(paramInt);
    this.touchDeltaX = paramFloat1;
    this.touchDeltaY = paramFloat2;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
  
  public void runCameraUpdate(GLMapState paramGLMapState)
  {
    int j = (int)this.touchDeltaX;
    int i = (int)this.touchDeltaY;
    float f1 = this.width >> 1;
    float f2 = this.height >> 1;
    if (this.isUseAnchor)
    {
      f1 = this.anchorX;
      f2 = this.anchorY;
    }
    j = (int)(f1 - j);
    i = (int)(f2 - i);
    IPoint localIPoint = IPoint.obtain();
    win2geo(paramGLMapState, j, i, localIPoint);
    paramGLMapState.setMapGeoCenter(localIPoint.x, localIPoint.y);
    paramGLMapState.recalculate();
    localIPoint.recycle();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\message\MoveGestureMapMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */