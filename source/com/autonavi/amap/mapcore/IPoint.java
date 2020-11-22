package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public class IPoint
  extends Point
  implements Cloneable
{
  private static final Pools.SynchronizedPool<IPoint> M_POOL = new Pools.SynchronizedPool(32);
  
  public IPoint() {}
  
  public IPoint(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public static IPoint obtain()
  {
    IPoint localIPoint = (IPoint)M_POOL.acquire();
    if (localIPoint == null) {
      return new IPoint();
    }
    localIPoint.set(0, 0);
    return localIPoint;
  }
  
  public static IPoint obtain(int paramInt1, int paramInt2)
  {
    IPoint localIPoint = (IPoint)M_POOL.acquire();
    if (localIPoint == null) {
      return new IPoint(paramInt1, paramInt2);
    }
    localIPoint.set(paramInt1, paramInt2);
    return localIPoint;
  }
  
  public Object clone()
  {
    try
    {
      IPoint localIPoint = (IPoint)super.clone();
      return localIPoint;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\IPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */