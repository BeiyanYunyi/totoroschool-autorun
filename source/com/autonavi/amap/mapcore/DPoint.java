package com.autonavi.amap.mapcore;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public class DPoint
{
  private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool(32);
  public double x;
  public double y;
  
  public DPoint() {}
  
  public DPoint(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public static DPoint obtain()
  {
    DPoint localDPoint = (DPoint)M_POOL.acquire();
    if (localDPoint == null) {
      return new DPoint();
    }
    localDPoint.set(0.0D, 0.0D);
    return localDPoint;
  }
  
  public static DPoint obtain(double paramDouble1, double paramDouble2)
  {
    DPoint localDPoint = (DPoint)M_POOL.acquire();
    if (localDPoint == null) {
      return new DPoint(paramDouble1, paramDouble2);
    }
    localDPoint.set(paramDouble1, paramDouble2);
    return localDPoint;
  }
  
  private void set(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\DPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */