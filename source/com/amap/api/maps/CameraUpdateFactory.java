package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.mapcore.util.k;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

public final class CameraUpdateFactory
{
  public static CameraUpdate changeBearing(float paramFloat)
  {
    return new CameraUpdate(k.d(paramFloat % 360.0F));
  }
  
  public static CameraUpdate changeBearingGeoCenter(float paramFloat, IPoint paramIPoint)
  {
    if (paramIPoint == null)
    {
      Log.w("CameraUpdateFactory", "geoPoint is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.b(paramFloat % 360.0F, new Point(paramIPoint.x, paramIPoint.y)));
  }
  
  public static CameraUpdate changeLatLng(LatLng paramLatLng)
  {
    if (paramLatLng == null)
    {
      Log.w("CameraUpdateFactory", "target is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.a(VirtualEarthProjection.latLongToPixels(paramLatLng.latitude, paramLatLng.longitude, 20)));
  }
  
  public static CameraUpdate changeTilt(float paramFloat)
  {
    return new CameraUpdate(k.c(paramFloat));
  }
  
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    if (paramCameraPosition == null)
    {
      Log.w("CameraUpdateFactory", "cameraPosition is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.a(paramCameraPosition));
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    if (paramLatLng == null)
    {
      Log.w("CameraUpdateFactory", "latLng is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.a(paramLatLng));
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    if (paramLatLngBounds == null)
    {
      Log.w("CameraUpdateFactory", "bounds is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.a(paramLatLngBounds, paramInt));
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLatLngBounds == null)
    {
      Log.w("CameraUpdateFactory", "bounds is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.a(paramLatLngBounds, paramInt1, paramInt2, paramInt3));
  }
  
  public static CameraUpdate newLatLngBoundsRect(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramLatLngBounds == null)
    {
      Log.w("CameraUpdateFactory", "bounds is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.a(paramLatLngBounds, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    if (paramLatLng == null)
    {
      Log.w("CameraUpdateFactory", "target is null");
      return new CameraUpdate(k.c());
    }
    return new CameraUpdate(k.a(paramLatLng, paramFloat));
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    return new CameraUpdate(k.a(paramFloat1, paramFloat2));
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    return new CameraUpdate(k.b(paramFloat));
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    return new CameraUpdate(k.a(paramFloat, paramPoint));
  }
  
  public static CameraUpdate zoomIn()
  {
    return new CameraUpdate(k.a());
  }
  
  public static CameraUpdate zoomOut()
  {
    return new CameraUpdate(k.b());
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    return new CameraUpdate(k.a(paramFloat));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\CameraUpdateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */