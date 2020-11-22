package com.autonavi.amap.mapcore;

import android.graphics.Point;

public class VirtualEarthProjection
{
  public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7D;
  public static final int EARTH_RADIUS_IN_METERS = 6378137;
  private static final int KMA_MAX_MAP_SIZE = 268435456;
  private static final double K_EARTH_CIRCLE = 4.0075016E7D;
  private static final double K_EARTH_CIRCLE_2 = 2.0037508E7D;
  public static final int MAXZOOMLEVEL = 20;
  public static final double MAX_LATITUDE = 85.0511287798D;
  public static final double MAX_LONGITUDE = 360.0D;
  public static final double MIN_LATITUDE = -85.0511287798D;
  public static final double MIN_LONGITUDE = -360.0D;
  public static final int PIXELS_PER_TILE = 256;
  public static final int TILE_SPLIT_LEVEL = 0;
  
  public static double clip(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.min(Math.max(paramDouble1, paramDouble2), paramDouble3);
  }
  
  private static double degToRad(double paramDouble)
  {
    return paramDouble * 0.017453292519943295D;
  }
  
  public static Point latLongToPixels(double paramDouble1, double paramDouble2, int paramInt)
  {
    Point localPoint = new Point();
    double d = clip(paramDouble1, -85.0511287798D, 85.0511287798D);
    paramDouble1 = degToRad(clip(paramDouble2, -360.0D, 360.0D));
    paramDouble2 = Math.sin(degToRad(d));
    paramDouble2 = Math.log((paramDouble2 + 1.0D) / (1.0D - paramDouble2)) * 6378137.0D / 2.0D;
    paramDouble1 = (paramDouble1 * 6378137.0D + 2.0037508E7D) / 0.14929106831550598D;
    paramDouble2 = (2.0037508E7D - paramDouble2) / 0.14929106831550598D;
    localPoint.x = ((int)paramDouble1);
    localPoint.y = ((int)paramDouble2);
    return localPoint;
  }
  
  public static Point latLongToPixels(int paramInt1, int paramInt2, int paramInt3)
  {
    double d1 = paramInt2;
    Double.isNaN(d1);
    d1 /= 3600000.0D;
    double d2 = paramInt1;
    Double.isNaN(d2);
    return latLongToPixels(d1, d2 / 3600000.0D, paramInt3);
  }
  
  public static DPoint latLongToPixelsDouble(double paramDouble1, double paramDouble2, int paramInt)
  {
    DPoint localDPoint = new DPoint();
    double d = clip(paramDouble1, -85.0511287798D, 85.0511287798D);
    paramDouble1 = degToRad(clip(paramDouble2, -360.0D, 360.0D));
    paramDouble2 = Math.sin(degToRad(d));
    paramDouble2 = Math.log((paramDouble2 + 1.0D) / (1.0D - paramDouble2)) * 6378137.0D / 2.0D;
    paramDouble1 = (paramDouble1 * 6378137.0D + 2.0037508E7D) / 0.14929106831550598D;
    paramDouble2 = (2.0037508E7D - paramDouble2) / 0.14929106831550598D;
    localDPoint.x = paramDouble1;
    localDPoint.y = paramDouble2;
    return localDPoint;
  }
  
  public static DPoint pixelsToLatLong(double paramDouble1, double paramDouble2, int paramInt)
  {
    DPoint localDPoint = DPoint.obtain();
    localDPoint.x = radToDeg((paramDouble1 * 0.14929106831550598D - 2.0037508E7D) / 6378137.0D);
    paramDouble1 = Math.exp((2.0037508E7D - paramDouble2 * 0.14929106831550598D) / 6378137.0D * 2.0D);
    localDPoint.y = radToDeg(Math.asin((paramDouble1 - 1.0D) / (paramDouble1 + 1.0D)));
    return localDPoint;
  }
  
  public static DPoint pixelsToLatLong(long paramLong1, long paramLong2, int paramInt)
  {
    DPoint localDPoint = DPoint.obtain();
    double d1 = paramLong1;
    Double.isNaN(d1);
    double d2 = paramLong2;
    Double.isNaN(d2);
    localDPoint.x = radToDeg((d1 * 0.14929106831550598D - 2.0037508E7D) / 6378137.0D);
    d1 = Math.exp((2.0037508E7D - d2 * 0.14929106831550598D) / 6378137.0D * 2.0D);
    localDPoint.y = radToDeg(Math.asin((d1 - 1.0D) / (d1 + 1.0D)));
    return localDPoint;
  }
  
  private static double radToDeg(double paramDouble)
  {
    return paramDouble * 57.29577951308232D;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\VirtualEarthProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */