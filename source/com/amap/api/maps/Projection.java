package com.amap.api.maps;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.interfaces.IProjection;

public class Projection
{
  private final IProjection a;
  
  public Projection(IProjection paramIProjection)
  {
    this.a = paramIProjection;
  }
  
  public TileProjection fromBoundsToTile(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2)
  {
    try
    {
      paramLatLngBounds = this.a.fromBoundsToTile(paramLatLngBounds, paramInt1, paramInt2);
      return paramLatLngBounds;
    }
    catch (Throwable paramLatLngBounds)
    {
      paramLatLngBounds.printStackTrace();
    }
    return null;
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    try
    {
      paramPoint = this.a.fromScreenLocation(paramPoint);
      return paramPoint;
    }
    catch (Throwable paramPoint)
    {
      paramPoint.printStackTrace();
    }
    return null;
  }
  
  public AMapCameraInfo getCameraInfo()
  {
    try
    {
      AMapCameraInfo localAMapCameraInfo = this.a.getCameraInfo();
      return localAMapCameraInfo;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public LatLngBounds getMapBounds(LatLng paramLatLng, float paramFloat)
  {
    try
    {
      paramLatLng = this.a.getMapBounds(paramLatLng, paramFloat);
      return paramLatLng;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
    return null;
  }
  
  public VisibleRegion getVisibleRegion()
  {
    try
    {
      VisibleRegion localVisibleRegion = this.a.getVisibleRegion();
      return localVisibleRegion;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  @Deprecated
  public PointF toMapLocation(LatLng paramLatLng)
  {
    try
    {
      paramLatLng = this.a.toMapLocation(paramLatLng);
      return paramLatLng;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
    return null;
  }
  
  public PointF toOpenGLLocation(LatLng paramLatLng)
  {
    try
    {
      paramLatLng = this.a.toMapLocation(paramLatLng);
      return paramLatLng;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
    return null;
  }
  
  public float toOpenGLWidth(int paramInt)
  {
    try
    {
      float f = this.a.toMapLenWithWin(paramInt);
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    try
    {
      paramLatLng = this.a.toScreenLocation(paramLatLng);
      return paramLatLng;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */