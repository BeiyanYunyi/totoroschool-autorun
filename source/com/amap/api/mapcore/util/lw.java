package com.amap.api.mapcore.util;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;

class lw
  implements IProjectionDelegate
{
  private IAMapDelegate a;
  
  public lw(IAMapDelegate paramIAMapDelegate)
  {
    this.a = paramIAMapDelegate;
  }
  
  public TileProjection fromBoundsToTile(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if ((paramLatLngBounds != null) && (paramInt1 >= 0) && (paramInt1 <= 20) && (paramInt2 > 0))
    {
      IPoint localIPoint1 = IPoint.obtain();
      IPoint localIPoint2 = IPoint.obtain();
      this.a.latlon2Geo(paramLatLngBounds.southwest.latitude, paramLatLngBounds.southwest.longitude, localIPoint1);
      this.a.latlon2Geo(paramLatLngBounds.northeast.latitude, paramLatLngBounds.northeast.longitude, localIPoint2);
      int i = localIPoint1.x;
      paramInt1 = 20 - paramInt1;
      i = (i >> paramInt1) / paramInt2;
      int j = (localIPoint1.y >> paramInt1) / paramInt2;
      int k = (localIPoint2.x >> paramInt1) / paramInt2;
      int m = (localIPoint2.y >> paramInt1) / paramInt2;
      int n = localIPoint1.x;
      int i1 = localIPoint2.y;
      localIPoint1.recycle();
      localIPoint2.recycle();
      return new TileProjection(n - (i << paramInt1) * paramInt2 >> paramInt1, i1 - (m << paramInt1) * paramInt2 >> paramInt1, i, k, m, j);
    }
    return null;
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
    throws RemoteException
  {
    if (paramPoint == null) {
      return null;
    }
    DPoint localDPoint = DPoint.obtain();
    this.a.getPixel2LatLng(paramPoint.x, paramPoint.y, localDPoint);
    paramPoint = new LatLng(localDPoint.y, localDPoint.x);
    localDPoint.recycle();
    return paramPoint;
  }
  
  public AMapCameraInfo getCameraInfo()
  {
    return this.a.getCamerInfo();
  }
  
  public LatLngBounds getMapBounds(LatLng paramLatLng, float paramFloat)
    throws RemoteException
  {
    if ((this.a != null) && (paramLatLng != null)) {
      return this.a.getMapBounds(paramLatLng, paramFloat, 0.0F, 0.0F);
    }
    return null;
  }
  
  public VisibleRegion getVisibleRegion()
    throws RemoteException
  {
    int i = this.a.getMapWidth();
    int j = this.a.getMapHeight();
    LatLng localLatLng1 = fromScreenLocation(new Point(0, 0));
    LatLng localLatLng2 = fromScreenLocation(new Point(i, 0));
    LatLng localLatLng3 = fromScreenLocation(new Point(0, j));
    LatLng localLatLng4 = fromScreenLocation(new Point(i, j));
    return new VisibleRegion(localLatLng3, localLatLng4, localLatLng1, localLatLng2, LatLngBounds.builder().include(localLatLng3).include(localLatLng4).include(localLatLng1).include(localLatLng2).build());
  }
  
  public float toMapLenWithWin(int paramInt)
  {
    if (paramInt <= 0) {
      return 0.0F;
    }
    return this.a.toMapLenWithWin(paramInt);
  }
  
  public PointF toMapLocation(LatLng paramLatLng)
    throws RemoteException
  {
    if (paramLatLng == null) {
      return null;
    }
    FPoint localFPoint = FPoint.obtain();
    this.a.getLatLng2Map(paramLatLng.latitude, paramLatLng.longitude, localFPoint);
    paramLatLng = new PointF(localFPoint.x, localFPoint.y);
    localFPoint.recycle();
    return paramLatLng;
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
    throws RemoteException
  {
    if (paramLatLng == null) {
      return null;
    }
    IPoint localIPoint = IPoint.obtain();
    this.a.getLatLng2Pixel(paramLatLng.latitude, paramLatLng.longitude, localIPoint);
    paramLatLng = new Point(localIPoint.x, localIPoint.y);
    localIPoint.recycle();
    return paramLatLng;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */