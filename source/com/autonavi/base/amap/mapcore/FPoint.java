package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;
import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public class FPoint
  extends PointF
{
  private static final Pools.SynchronizedPool<FPoint> M_POOL = new Pools.SynchronizedPool(32);
  
  public FPoint() {}
  
  public FPoint(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public static FPoint obtain()
  {
    FPoint localFPoint = (FPoint)M_POOL.acquire();
    if (localFPoint == null) {
      return new FPoint();
    }
    localFPoint.set(0.0F, 0.0F);
    return localFPoint;
  }
  
  public static FPoint obtain(float paramFloat1, float paramFloat2)
  {
    FPoint localFPoint = (FPoint)M_POOL.acquire();
    if (localFPoint == null) {
      return new FPoint(paramFloat1, paramFloat2);
    }
    localFPoint.set(paramFloat1, paramFloat2);
    return localFPoint;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (FPoint)paramObject;
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.x == ((FPoint)paramObject).x)
    {
      bool1 = bool2;
      if (this.y == ((FPoint)paramObject).y) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    Float.floatToIntBits(this.x);
    return Float.floatToIntBits(this.y) * 37;
  }
  
  public void recycle()
  {
    M_POOL.release(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\FPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */