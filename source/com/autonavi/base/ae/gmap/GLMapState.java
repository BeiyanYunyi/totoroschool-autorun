package com.autonavi.base.ae.gmap;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.FPoint;

public class GLMapState
  implements IGLMapState
{
  private boolean isNewInstance = false;
  private long nativeEngineInstance = 0L;
  private long nativeStateInstance = 0L;
  
  public GLMapState(int paramInt, long paramLong)
  {
    if (paramLong != 0L)
    {
      this.nativeEngineInstance = paramLong;
      this.nativeStateInstance = nativeNewInstance(paramInt, paramLong);
      this.isNewInstance = true;
    }
  }
  
  public GLMapState(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 0L)
    {
      this.nativeEngineInstance = paramLong1;
      this.nativeStateInstance = paramLong2;
      this.isNewInstance = true;
    }
  }
  
  public static float calMapZoomScalefactor(int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeCalMapZoomScalefactor(paramInt1, paramInt2, paramInt3);
  }
  
  public static void geo2LonLat(int paramInt1, int paramInt2, DPoint paramDPoint)
  {
    DPoint localDPoint = VirtualEarthProjection.pixelsToLatLong(paramInt1, paramInt2, 20);
    paramDPoint.x = localDPoint.x;
    paramDPoint.y = localDPoint.y;
    localDPoint.recycle();
  }
  
  public static void lonlat2Geo(double paramDouble1, double paramDouble2, IPoint paramIPoint)
  {
    Point localPoint = VirtualEarthProjection.latLongToPixels(paramDouble2, paramDouble1, 20);
    paramIPoint.x = localPoint.x;
    paramIPoint.y = localPoint.y;
  }
  
  public static native float nativeCalMapZoomScalefactor(int paramInt1, int paramInt2, float paramFloat);
  
  public static native float nativeGetCameraDegree(long paramLong);
  
  public static native float nativeGetGLUnitWithWin(long paramLong, int paramInt);
  
  public static native float nativeGetMapAngle(long paramLong);
  
  public static native void nativeGetMapCenter(long paramLong, Point paramPoint);
  
  public static native double nativeGetMapCenterXDouble(long paramLong);
  
  public static native double nativeGetMapCenterYDouble(long paramLong);
  
  public static native float nativeGetMapZoomer(long paramLong);
  
  public static native void nativeGetPixel20Bound(long paramLong, Rect paramRect, int paramInt1, int paramInt2);
  
  public static native void nativeGetProjectionMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public static native float nativeGetSkyHeight(long paramLong);
  
  public static native void nativeGetViewMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public static native long nativeNewInstance(int paramInt, long paramLong);
  
  public static native void nativeP20ToScreenPoint(long paramLong, int paramInt1, int paramInt2, int paramInt3, PointF paramPointF);
  
  public static native void nativeRecalculate(long paramLong);
  
  public static native void nativeScreenToP20Point(long paramLong, float paramFloat1, float paramFloat2, Point paramPoint);
  
  public static native void nativeSetCameraDegree(long paramLong, float paramFloat);
  
  public static native void nativeSetMapAngle(long paramLong, float paramFloat);
  
  public static native void nativeSetMapCenter(long paramLong, double paramDouble1, double paramDouble2);
  
  private static native void nativeSetMapState(int paramInt, long paramLong1, long paramLong2);
  
  public static native void nativeSetMapZoomer(long paramLong, float paramFloat);
  
  public static native void nativeStateDestroy(long paramLong);
  
  public float getCameraDegree()
  {
    if (this.nativeStateInstance != 0L) {
      return nativeGetCameraDegree(this.nativeStateInstance);
    }
    return 0.0F;
  }
  
  public float getGLUnitWithWin(int paramInt)
  {
    if (this.nativeStateInstance != 0L) {
      return nativeGetGLUnitWithWin(this.nativeStateInstance, paramInt);
    }
    return 0.0F;
  }
  
  public float getMapAngle()
  {
    if (this.nativeStateInstance != 0L) {
      return nativeGetMapAngle(this.nativeStateInstance);
    }
    return 0.0F;
  }
  
  public DPoint getMapGeoCenter()
  {
    DPoint localDPoint = new DPoint();
    localDPoint.x = nativeGetMapCenterXDouble(this.nativeStateInstance);
    localDPoint.y = nativeGetMapCenterYDouble(this.nativeStateInstance);
    return localDPoint;
  }
  
  public void getMapGeoCenter(IPoint paramIPoint)
  {
    nativeGetMapCenter(this.nativeStateInstance, paramIPoint);
  }
  
  public double getMapGeoCenterX()
  {
    return nativeGetMapCenterXDouble(this.nativeStateInstance);
  }
  
  public double getMapGeoCenterY()
  {
    return nativeGetMapCenterXDouble(this.nativeStateInstance);
  }
  
  public float getMapLenWithWin(int paramInt)
  {
    return getGLUnitWithWin(paramInt);
  }
  
  public float getMapZoomer()
  {
    if (this.nativeStateInstance != 0L) {
      return nativeGetMapZoomer(this.nativeStateInstance);
    }
    return 0.0F;
  }
  
  public long getNativeInstance()
  {
    return this.nativeStateInstance;
  }
  
  public void getPixel20Bound(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.nativeStateInstance != 0L) {
      nativeGetPixel20Bound(this.nativeStateInstance, paramRect, paramInt1, paramInt2);
    }
  }
  
  public void getProjectionMatrix(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length == 16)) {
      nativeGetProjectionMatrix(this.nativeStateInstance, paramArrayOfFloat);
    }
  }
  
  public float getSkyHeight()
  {
    if (this.nativeStateInstance != 0L) {
      return nativeGetSkyHeight(this.nativeStateInstance);
    }
    return 0.0F;
  }
  
  public void getViewMatrix(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length == 16)) {
      nativeGetViewMatrix(this.nativeStateInstance, paramArrayOfFloat);
    }
  }
  
  public void p20ToScreenPoint(int paramInt1, int paramInt2, FPoint paramFPoint)
  {
    if (this.nativeStateInstance != 0L) {
      nativeP20ToScreenPoint(this.nativeStateInstance, paramInt1, paramInt2, 0, paramFPoint);
    }
  }
  
  public void recalculate()
  {
    if (this.nativeStateInstance != 0L) {
      nativeRecalculate(this.nativeStateInstance);
    }
  }
  
  public void recycle()
  {
    if ((this.nativeStateInstance != 0L) && (this.isNewInstance)) {
      nativeStateDestroy(this.nativeStateInstance);
    }
    this.nativeStateInstance = 0L;
  }
  
  public void reset()
  {
    if (this.nativeStateInstance != 0L) {
      recycle();
    }
    if (this.nativeEngineInstance != 0L) {
      this.nativeStateInstance = nativeNewInstance(1, this.nativeEngineInstance);
    }
  }
  
  public void screenToP20Point(int paramInt1, int paramInt2, Point paramPoint)
  {
    if (this.nativeStateInstance != 0L) {
      nativeScreenToP20Point(this.nativeStateInstance, paramInt1, paramInt2, paramPoint);
    }
  }
  
  public void setCameraDegree(float paramFloat)
  {
    if (this.nativeStateInstance != 0L) {
      nativeSetCameraDegree(this.nativeStateInstance, paramFloat);
    }
  }
  
  public void setMapAngle(float paramFloat)
  {
    if (this.nativeStateInstance != 0L) {
      nativeSetMapAngle(this.nativeStateInstance, paramFloat);
    }
  }
  
  public void setMapGeoCenter(double paramDouble1, double paramDouble2)
  {
    if (this.nativeStateInstance != 0L) {
      nativeSetMapCenter(this.nativeStateInstance, paramDouble1, paramDouble2);
    }
  }
  
  public void setMapZoomer(float paramFloat)
  {
    if (this.nativeStateInstance != 0L) {
      nativeSetMapZoomer(this.nativeStateInstance, paramFloat);
    }
  }
  
  public void setNativeMapengineState(int paramInt, long paramLong)
  {
    if (paramLong != 0L)
    {
      if (this.nativeStateInstance == 0L) {
        return;
      }
      this.nativeEngineInstance = paramLong;
      nativeSetMapState(paramInt, paramLong, this.nativeStateInstance);
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("instance: ");
    localStringBuilder.append(this.nativeStateInstance);
    localStringBuilder.append(" center: ");
    localStringBuilder.append(getMapGeoCenter().x);
    localStringBuilder.append(" , ");
    localStringBuilder.append(getMapGeoCenter().y);
    localStringBuilder.append(" bearing:");
    localStringBuilder.append(getCameraDegree());
    localStringBuilder.append("  tilt:");
    localStringBuilder.append(getMapAngle());
    localStringBuilder.append("  zoom:");
    localStringBuilder.append(getMapZoomer());
    localStringBuilder.append("  ");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\GLMapState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */