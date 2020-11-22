package com.autonavi.base.amap.mapcore.message;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;
import com.autonavi.base.ae.gmap.GLMapState;

public class HoverGestureMapMessage
  extends AbstractGestureMapMessage
{
  private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = new Pools.SynchronizedPool(256);
  public float angleDelta = 0.0F;
  
  public HoverGestureMapMessage(int paramInt, float paramFloat)
  {
    super(paramInt);
    this.angleDelta = paramFloat;
  }
  
  public static void destory()
  {
    M_POOL.destory();
  }
  
  public static HoverGestureMapMessage obtain(int paramInt, float paramFloat)
  {
    HoverGestureMapMessage localHoverGestureMapMessage = (HoverGestureMapMessage)M_POOL.acquire();
    if (localHoverGestureMapMessage == null) {
      localHoverGestureMapMessage = new HoverGestureMapMessage(paramInt, paramFloat);
    } else {
      localHoverGestureMapMessage.reset();
    }
    localHoverGestureMapMessage.setParams(paramInt, paramFloat);
    return localHoverGestureMapMessage;
  }
  
  private void setParams(int paramInt, float paramFloat)
  {
    setState(paramInt);
    this.angleDelta = paramFloat;
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
  
  public void runCameraUpdate(GLMapState paramGLMapState)
  {
    float f2 = paramGLMapState.getCameraDegree() + this.angleDelta;
    float f1;
    if (f2 < 0.0F)
    {
      f1 = 0.0F;
    }
    else if (f2 > 80.0F)
    {
      f1 = 80.0F;
    }
    else
    {
      f1 = f2;
      if (paramGLMapState.getCameraDegree() > 40.0F)
      {
        f1 = f2;
        if (f2 > 40.0F)
        {
          f1 = f2;
          if (paramGLMapState.getCameraDegree() > f2) {
            f1 = 40.0F;
          }
        }
      }
    }
    paramGLMapState.setCameraDegree(f1);
    paramGLMapState.recalculate();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\message\HoverGestureMapMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */