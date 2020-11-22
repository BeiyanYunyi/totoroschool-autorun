package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.CoordUtil;
import com.autonavi.amap.mapcore.DPoint;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l
{
  static double a = 3.141592653589793D;
  public static double b = 6378245.0D;
  public static double c = 0.006693421622965943D;
  private static boolean d = false;
  private static final double[] e = { 25.575374D, 120.391111D };
  private static final double[] f = { 21.405235D, 121.649046D };
  private static final List<LatLng> g = new ArrayList(Arrays.asList(new LatLng[] { new LatLng(23.379947D, 119.757001D), new LatLng(24.983296D, 120.474496D), new LatLng(25.518722D, 121.359866D), new LatLng(25.41329D, 122.443582D), new LatLng(24.862708D, 122.288354D), new LatLng(24.461292D, 122.188319D), new LatLng(21.584761D, 120.968923D), new LatLng(21.830837D, 120.654445D) }));
  
  private static double a(double paramDouble)
  {
    return Math.sin(paramDouble * 3000.0D * (a / 180.0D)) * 2.0E-5D;
  }
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    return Math.cos(paramDouble2 / 100000.0D) * (paramDouble1 / 18000.0D) + Math.sin(paramDouble1 / 100000.0D) * (paramDouble2 / 9000.0D);
  }
  
  private static double a(double paramDouble, int paramInt)
  {
    return new BigDecimal(paramDouble).setScale(paramInt, 4).doubleValue();
  }
  
  public static LatLng a(Context paramContext, LatLng paramLatLng)
  {
    if (paramContext == null) {
      return null;
    }
    if (!dq.a(paramLatLng.latitude, paramLatLng.longitude)) {
      return paramLatLng;
    }
    String str = fo.a(paramContext, "libwgs2gcj.so");
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()) && (!d)) {
      try
      {
        System.load(str);
        d = true;
      }
      catch (Throwable localThrowable)
      {
        fu.a(paramContext, localThrowable);
      }
    }
    paramContext = a(DPoint.obtain(paramLatLng.longitude, paramLatLng.latitude), d);
    paramLatLng = new LatLng(paramContext.y, paramContext.x, false);
    paramContext.recycle();
    return paramLatLng;
  }
  
  public static LatLng a(LatLng paramLatLng)
  {
    if (paramLatLng != null) {
      try
      {
        Object localObject;
        if (dq.a(paramLatLng.latitude, paramLatLng.longitude))
        {
          localObject = a(paramLatLng.longitude, paramLatLng.latitude, 2);
          LatLng localLatLng = new LatLng(((DPoint)localObject).y, ((DPoint)localObject).x, false);
          ((DPoint)localObject).recycle();
          return localLatLng;
        }
        if (c(paramLatLng.latitude, paramLatLng.longitude))
        {
          localObject = a(paramLatLng.longitude, paramLatLng.latitude, 2);
          localObject = h(((DPoint)localObject).y, ((DPoint)localObject).x);
          return (LatLng)localObject;
        }
        return paramLatLng;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return paramLatLng;
  }
  
  private static DPoint a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    DPoint localDPoint1 = DPoint.obtain();
    paramDouble3 = paramDouble1 - paramDouble3;
    paramDouble4 = paramDouble2 - paramDouble4;
    DPoint localDPoint2 = g(paramDouble3, paramDouble4);
    localDPoint1.x = a(paramDouble1 + paramDouble3 - localDPoint2.x, 8);
    localDPoint1.y = a(paramDouble2 + paramDouble4 - localDPoint2.y, 8);
    return localDPoint1;
  }
  
  private static DPoint a(double paramDouble1, double paramDouble2, int paramInt)
  {
    DPoint localDPoint = null;
    int i = 0;
    double d1 = 0.006401062D;
    double d2 = 0.0060424805D;
    while (i < paramInt)
    {
      localDPoint = a(paramDouble1, paramDouble2, d1, d2);
      d1 = paramDouble1 - localDPoint.x;
      d2 = paramDouble2 - localDPoint.y;
      i += 1;
    }
    return localDPoint;
  }
  
  private static DPoint a(DPoint paramDPoint, boolean paramBoolean)
  {
    try
    {
      if (dq.a(paramDPoint.y, paramDPoint.x))
      {
        double[] arrayOfDouble2 = new double[2];
        if (paramBoolean)
        {
          double d1 = paramDPoint.x;
          double d2 = paramDPoint.y;
          double[] arrayOfDouble1 = arrayOfDouble2;
          try
          {
            if (CoordUtil.convertToGcj(new double[] { d1, d2 }, arrayOfDouble2) == 0) {
              break label110;
            }
            arrayOfDouble1 = ki.a(paramDPoint.x, paramDPoint.y);
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
            localObject = ki.a(paramDPoint.x, paramDPoint.y);
          }
        }
        else
        {
          localObject = ki.a(paramDPoint.x, paramDPoint.y);
        }
        label110:
        paramDPoint.recycle();
        Object localObject = DPoint.obtain(localObject[0], localObject[1]);
        return (DPoint)localObject;
      }
      return paramDPoint;
    }
    catch (Throwable localThrowable2) {}
    return paramDPoint;
  }
  
  private static double b(double paramDouble)
  {
    return Math.cos(paramDouble * 3000.0D * (a / 180.0D)) * 3.0E-6D;
  }
  
  public static double b(double paramDouble1, double paramDouble2)
  {
    return Math.sin(paramDouble2 / 100000.0D) * (paramDouble1 / 18000.0D) + Math.cos(paramDouble1 / 100000.0D) * (paramDouble2 / 9000.0D);
  }
  
  public static LatLng b(Context paramContext, LatLng paramLatLng)
  {
    try
    {
      if (!dq.a(paramLatLng.latitude, paramLatLng.longitude)) {
        return paramLatLng;
      }
      DPoint localDPoint = f(paramLatLng.longitude, paramLatLng.latitude);
      paramContext = a(paramContext, new LatLng(localDPoint.y, localDPoint.x, false));
      localDPoint.recycle();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramLatLng;
  }
  
  public static boolean c(double paramDouble1, double paramDouble2)
  {
    return dx.a(new LatLng(paramDouble1, paramDouble2), g);
  }
  
  public static double d(double paramDouble1, double paramDouble2)
  {
    double d1 = paramDouble1 * 2.0D;
    return -100.0D + d1 + paramDouble2 * 3.0D + paramDouble2 * 0.2D * paramDouble2 + 0.1D * paramDouble1 * paramDouble2 + Math.sqrt(Math.abs(paramDouble1)) * 0.2D + (Math.sin(paramDouble1 * 6.0D * a) * 20.0D + Math.sin(d1 * a) * 20.0D) * 2.0D / 3.0D + (Math.sin(a * paramDouble2) * 20.0D + Math.sin(paramDouble2 / 3.0D * a) * 40.0D) * 2.0D / 3.0D + (Math.sin(paramDouble2 / 12.0D * a) * 160.0D + Math.sin(paramDouble2 * a / 30.0D) * 320.0D) * 2.0D / 3.0D;
  }
  
  public static double e(double paramDouble1, double paramDouble2)
  {
    double d1 = paramDouble1 * 0.1D;
    return paramDouble1 + 300.0D + paramDouble2 * 2.0D + d1 * paramDouble1 + d1 * paramDouble2 + Math.sqrt(Math.abs(paramDouble1)) * 0.1D + (Math.sin(6.0D * paramDouble1 * a) * 20.0D + Math.sin(paramDouble1 * 2.0D * a) * 20.0D) * 2.0D / 3.0D + (Math.sin(a * paramDouble1) * 20.0D + Math.sin(paramDouble1 / 3.0D * a) * 40.0D) * 2.0D / 3.0D + (Math.sin(paramDouble1 / 12.0D * a) * 150.0D + Math.sin(paramDouble1 / 30.0D * a) * 300.0D) * 2.0D / 3.0D;
  }
  
  private static DPoint f(double paramDouble1, double paramDouble2)
  {
    double d1 = (paramDouble1 * 100000.0D) % 36000000L;
    paramDouble1 = (paramDouble2 * 100000.0D) % 36000000L;
    paramDouble2 = -a(d1, paramDouble1);
    Double.isNaN(d1);
    int i = (int)(paramDouble2 + d1);
    paramDouble2 = -b(d1, paramDouble1);
    Double.isNaN(paramDouble1);
    int j = (int)(paramDouble2 + paramDouble1);
    double d2 = i;
    paramDouble2 = j;
    d2 = -a(d2, paramDouble2);
    Double.isNaN(d1);
    j = -1;
    if (d1 > 0.0D) {
      i = 1;
    } else {
      i = -1;
    }
    double d3 = i;
    Double.isNaN(d3);
    d1 = (int)(d2 + d1 + d3);
    paramDouble2 = -b(d1, paramDouble2);
    Double.isNaN(paramDouble1);
    i = j;
    if (paramDouble1 > 0.0D) {
      i = 1;
    }
    d2 = i;
    Double.isNaN(d2);
    i = (int)(paramDouble2 + paramDouble1 + d2);
    Double.isNaN(d1);
    paramDouble1 = d1 / 100000.0D;
    paramDouble2 = i;
    Double.isNaN(paramDouble2);
    return DPoint.obtain(paramDouble1, paramDouble2 / 100000.0D);
  }
  
  private static DPoint g(double paramDouble1, double paramDouble2)
  {
    DPoint localDPoint = DPoint.obtain();
    double d1 = Math.cos(b(paramDouble1) + Math.atan2(paramDouble2, paramDouble1));
    double d2 = a(paramDouble2);
    double d4 = paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2;
    double d3 = Math.sqrt(d4);
    paramDouble1 = Math.sin(b(paramDouble1) + Math.atan2(paramDouble2, paramDouble1));
    paramDouble2 = a(paramDouble2);
    d4 = Math.sqrt(d4);
    localDPoint.x = a(d1 * (d2 + d3) + 0.0065D, 8);
    localDPoint.y = a(paramDouble1 * (paramDouble2 + d4) + 0.006D, 8);
    return localDPoint;
  }
  
  private static LatLng h(double paramDouble1, double paramDouble2)
  {
    LatLng localLatLng = i(paramDouble1, paramDouble2);
    double d1 = localLatLng.longitude;
    return new LatLng(paramDouble1 * 2.0D - localLatLng.latitude, paramDouble2 * 2.0D - d1);
  }
  
  private static LatLng i(double paramDouble1, double paramDouble2)
  {
    double d2 = paramDouble2 - 105.0D;
    double d3 = paramDouble1 - 35.0D;
    double d1 = d(d2, d3);
    d2 = e(d2, d3);
    d3 = paramDouble1 / 180.0D * a;
    double d4 = Math.sin(d3);
    d4 = 1.0D - c * d4 * d4;
    double d5 = Math.sqrt(d4);
    return new LatLng(paramDouble1 + d1 * 180.0D / (b * (1.0D - c) / (d4 * d5) * a), paramDouble2 + d2 * 180.0D / (b / d5 * Math.cos(d3) * a));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */