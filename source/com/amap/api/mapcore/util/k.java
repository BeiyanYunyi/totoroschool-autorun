package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CameraPosition.Builder;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

public class k
{
  public static AbstractCameraUpdateMessage a()
  {
    j localj = new j();
    localj.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
    localj.amount = 1.0F;
    return localj;
  }
  
  public static AbstractCameraUpdateMessage a(float paramFloat)
  {
    h localh = new h();
    localh.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
    localh.zoom = paramFloat;
    return localh;
  }
  
  public static AbstractCameraUpdateMessage a(float paramFloat1, float paramFloat2)
  {
    i locali = new i();
    locali.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
    locali.xPixel = paramFloat1;
    locali.yPixel = paramFloat2;
    return locali;
  }
  
  public static AbstractCameraUpdateMessage a(float paramFloat, Point paramPoint)
  {
    j localj = new j();
    localj.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
    localj.amount = paramFloat;
    localj.focus = paramPoint;
    return localj;
  }
  
  public static AbstractCameraUpdateMessage a(Point paramPoint)
  {
    h localh = new h();
    localh.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
    localh.geoPoint = new DPoint(paramPoint.x, paramPoint.y);
    return localh;
  }
  
  public static AbstractCameraUpdateMessage a(CameraPosition paramCameraPosition)
  {
    h localh = new h();
    localh.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
    if (paramCameraPosition != null)
    {
      if (paramCameraPosition.target == null) {
        return localh;
      }
      DPoint localDPoint = VirtualEarthProjection.latLongToPixelsDouble(paramCameraPosition.target.latitude, paramCameraPosition.target.longitude, 20);
      localh.geoPoint = new DPoint(localDPoint.x, localDPoint.y);
      localh.zoom = paramCameraPosition.zoom;
      localh.bearing = paramCameraPosition.bearing;
      localh.tilt = paramCameraPosition.tilt;
      localh.cameraPosition = paramCameraPosition;
      return localh;
    }
    return localh;
  }
  
  public static AbstractCameraUpdateMessage a(LatLng paramLatLng)
  {
    return a(CameraPosition.builder().target(paramLatLng).zoom(NaN.0F).bearing(NaN.0F).tilt(NaN.0F).build());
  }
  
  public static AbstractCameraUpdateMessage a(LatLng paramLatLng, float paramFloat)
  {
    return a(CameraPosition.builder().target(paramLatLng).zoom(paramFloat).bearing(NaN.0F).tilt(NaN.0F).build());
  }
  
  public static AbstractCameraUpdateMessage a(LatLngBounds paramLatLngBounds, int paramInt)
  {
    g localg = new g();
    localg.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
    localg.bounds = paramLatLngBounds;
    localg.paddingLeft = paramInt;
    localg.paddingRight = paramInt;
    localg.paddingTop = paramInt;
    localg.paddingBottom = paramInt;
    return localg;
  }
  
  public static AbstractCameraUpdateMessage a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    g localg = new g();
    localg.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
    localg.bounds = paramLatLngBounds;
    localg.paddingLeft = paramInt3;
    localg.paddingRight = paramInt3;
    localg.paddingTop = paramInt3;
    localg.paddingBottom = paramInt3;
    localg.width = paramInt1;
    localg.height = paramInt2;
    return localg;
  }
  
  public static AbstractCameraUpdateMessage a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    g localg = new g();
    localg.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
    localg.bounds = paramLatLngBounds;
    localg.paddingLeft = paramInt1;
    localg.paddingRight = paramInt2;
    localg.paddingTop = paramInt3;
    localg.paddingBottom = paramInt4;
    return localg;
  }
  
  public static AbstractCameraUpdateMessage b()
  {
    j localj = new j();
    localj.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
    localj.amount = -1.0F;
    return localj;
  }
  
  public static AbstractCameraUpdateMessage b(float paramFloat)
  {
    return a(paramFloat, null);
  }
  
  public static AbstractCameraUpdateMessage b(float paramFloat, Point paramPoint)
  {
    h localh = new h();
    localh.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
    localh.geoPoint = new DPoint(paramPoint.x, paramPoint.y);
    localh.bearing = paramFloat;
    return localh;
  }
  
  public static AbstractCameraUpdateMessage c()
  {
    return new h();
  }
  
  public static AbstractCameraUpdateMessage c(float paramFloat)
  {
    h localh = new h();
    localh.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
    localh.tilt = paramFloat;
    return localh;
  }
  
  public static AbstractCameraUpdateMessage d(float paramFloat)
  {
    h localh = new h();
    localh.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
    localh.bearing = paramFloat;
    return localh;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */