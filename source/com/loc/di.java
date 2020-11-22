package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.CoordUtil;
import com.amap.api.location.DPoint;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class di
{
  static double a = 3.141592653589793D;
  private static final List<DPoint> b = new ArrayList(Arrays.asList(new DPoint[] { new DPoint(23.379947D, 119.757001D), new DPoint(24.983296D, 120.474496D), new DPoint(25.518722D, 121.359866D), new DPoint(25.41329D, 122.443582D), new DPoint(24.862708D, 122.288354D), new DPoint(24.461292D, 122.188319D), new DPoint(21.584761D, 120.968923D), new DPoint(21.830837D, 120.654445D) }));
  
  private static double a(double paramDouble)
  {
    return Math.sin(paramDouble * 3000.0D * (a / 180.0D)) * 2.0E-5D;
  }
  
  private static double a(double paramDouble1, double paramDouble2)
  {
    return Math.cos(paramDouble2 / 100000.0D) * (paramDouble1 / 18000.0D) + Math.sin(paramDouble1 / 100000.0D) * (paramDouble2 / 9000.0D);
  }
  
  public static DPoint a(Context paramContext, DPoint paramDPoint)
  {
    if (paramContext == null) {
      return null;
    }
    String str = o.a(paramContext, "libwgs2gcj.so");
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()) && (!CoordUtil.isLoadedSo())) {
      try
      {
        System.load(str);
        CoordUtil.setLoadedSo(true);
      }
      catch (Throwable localThrowable) {}
    }
    try
    {
      Method localMethod = o.class.getMethod("loadSoHappenException", new Class[] { Context.class, Throwable.class });
      if (!localMethod.isAccessible()) {
        localMethod.setAccessible(true);
      }
      localMethod.invoke(null, new Object[] { paramContext, localThrowable });
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    dg.a(localThrowable, "OffsetUtil", "offset");
    return a(paramDPoint, CoordUtil.isLoadedSo());
  }
  
  public static DPoint a(DPoint paramDPoint)
  {
    if (paramDPoint != null) {
      try
      {
        if (dg.a(paramDPoint.getLatitude(), paramDPoint.getLongitude())) {
          return b(paramDPoint);
        }
        if (dg.a(new DPoint(paramDPoint.getLatitude(), paramDPoint.getLongitude()), b))
        {
          DPoint localDPoint = b(paramDPoint);
          double d1 = localDPoint.getLatitude();
          double d2 = localDPoint.getLongitude();
          double d3 = d2 - 105.0D;
          double d4 = d1 - 35.0D;
          double d5 = d3 * 2.0D;
          double d6 = d3 * 0.1D;
          double d7 = d6 * d4;
          double d8 = Math.sqrt(Math.abs(d3));
          double d13 = 6.0D * d3;
          double d9 = (Math.sin(a * d13) * 20.0D + Math.sin(a * d5) * 20.0D) * 2.0D / 3.0D;
          double d10 = (Math.sin(a * d4) * 20.0D + Math.sin(d4 / 3.0D * a) * 40.0D) * 2.0D / 3.0D;
          double d11 = (Math.sin(d4 / 12.0D * a) * 160.0D + Math.sin(a * d4 / 30.0D) * 320.0D) * 2.0D / 3.0D;
          double d12 = Math.sqrt(Math.abs(d3));
          d13 = (Math.sin(d13 * a) * 20.0D + Math.sin(d5 * a) * 20.0D) * 2.0D / 3.0D;
          double d14 = (Math.sin(a * d3) * 20.0D + Math.sin(d3 / 3.0D * a) * 40.0D) * 2.0D / 3.0D;
          double d15 = (Math.sin(d3 / 12.0D * a) * 150.0D + Math.sin(d3 / 30.0D * a) * 300.0D) * 2.0D / 3.0D;
          double d16 = d1 / 180.0D * a;
          double d17 = Math.sin(d16);
          d17 = 1.0D - 0.006693421622965943D * d17 * d17;
          double d18 = Math.sqrt(d17);
          localDPoint = new DPoint((-100.0D + d5 + d4 * 3.0D + d4 * 0.2D * d4 + d7 + d8 * 0.2D + d9 + d10 + d11) * 180.0D / (6335552.717000426D / (d17 * d18) * a) + d1, d2 + (d3 + 300.0D + d4 * 2.0D + d6 * d3 + d7 + d12 * 0.1D + d13 + d14 + d15) * 180.0D / (6378245.0D / d18 * Math.cos(d16) * a));
          d3 = localDPoint.getLongitude();
          localDPoint = new DPoint(d1 * 2.0D - localDPoint.getLatitude(), d2 * 2.0D - d3);
          return localDPoint;
        }
        return paramDPoint;
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "OffsetUtil", "b2G");
      }
    }
    return paramDPoint;
  }
  
  /* Error */
  private static DPoint a(DPoint paramDPoint, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 167	com/amap/api/location/DPoint:getLatitude	()D
    //   4: aload_0
    //   5: invokevirtual 170	com/amap/api/location/DPoint:getLongitude	()D
    //   8: invokestatic 173	com/loc/dg:a	(DD)Z
    //   11: ifeq +148 -> 159
    //   14: iconst_2
    //   15: newarray <illegal type>
    //   17: astore 7
    //   19: iload_1
    //   20: ifeq +105 -> 125
    //   23: aload_0
    //   24: invokevirtual 170	com/amap/api/location/DPoint:getLongitude	()D
    //   27: dstore_2
    //   28: aload_0
    //   29: invokevirtual 167	com/amap/api/location/DPoint:getLatitude	()D
    //   32: dstore 4
    //   34: iconst_2
    //   35: newarray <illegal type>
    //   37: dup
    //   38: iconst_0
    //   39: dload_2
    //   40: dastore
    //   41: dup
    //   42: iconst_1
    //   43: dload 4
    //   45: dastore
    //   46: aload 7
    //   48: invokestatic 228	com/amap/api/location/CoordUtil:convertToGcj	([D[D)I
    //   51: istore 6
    //   53: iload 6
    //   55: ifeq +84 -> 139
    //   58: aload_0
    //   59: invokevirtual 170	com/amap/api/location/DPoint:getLongitude	()D
    //   62: dstore_2
    //   63: aload_0
    //   64: invokevirtual 167	com/amap/api/location/DPoint:getLatitude	()D
    //   67: dstore 4
    //   69: dload_2
    //   70: dload 4
    //   72: invokestatic 233	com/loc/do:a	(DD)[D
    //   75: astore 7
    //   77: goto +62 -> 139
    //   80: astore 7
    //   82: goto +28 -> 110
    //   85: astore 7
    //   87: aload 7
    //   89: ldc -104
    //   91: ldc -21
    //   93: invokestatic 159	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 170	com/amap/api/location/DPoint:getLongitude	()D
    //   100: dstore_2
    //   101: aload_0
    //   102: invokevirtual 167	com/amap/api/location/DPoint:getLatitude	()D
    //   105: dstore 4
    //   107: goto -38 -> 69
    //   110: aload_0
    //   111: invokevirtual 170	com/amap/api/location/DPoint:getLongitude	()D
    //   114: aload_0
    //   115: invokevirtual 167	com/amap/api/location/DPoint:getLatitude	()D
    //   118: invokestatic 233	com/loc/do:a	(DD)[D
    //   121: pop
    //   122: aload 7
    //   124: athrow
    //   125: aload_0
    //   126: invokevirtual 170	com/amap/api/location/DPoint:getLongitude	()D
    //   129: dstore_2
    //   130: aload_0
    //   131: invokevirtual 167	com/amap/api/location/DPoint:getLatitude	()D
    //   134: dstore 4
    //   136: goto -67 -> 69
    //   139: new 17	com/amap/api/location/DPoint
    //   142: dup
    //   143: aload 7
    //   145: iconst_1
    //   146: daload
    //   147: aload 7
    //   149: iconst_0
    //   150: daload
    //   151: invokespecial 25	com/amap/api/location/DPoint:<init>	(DD)V
    //   154: astore 7
    //   156: aload 7
    //   158: areturn
    //   159: aload_0
    //   160: areturn
    //   161: astore 7
    //   163: aload 7
    //   165: ldc -104
    //   167: ldc -19
    //   169: invokestatic 159	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramDPoint	DPoint
    //   0	174	1	paramBoolean	boolean
    //   27	103	2	d1	double
    //   32	103	4	d2	double
    //   51	3	6	i	int
    //   17	59	7	arrayOfDouble	double[]
    //   80	1	7	localObject	Object
    //   85	63	7	localThrowable1	Throwable
    //   154	3	7	localDPoint	DPoint
    //   161	3	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   34	53	80	finally
    //   87	96	80	finally
    //   34	53	85	java/lang/Throwable
    //   0	19	161	java/lang/Throwable
    //   23	34	161	java/lang/Throwable
    //   58	69	161	java/lang/Throwable
    //   69	77	161	java/lang/Throwable
    //   96	107	161	java/lang/Throwable
    //   110	125	161	java/lang/Throwable
    //   125	136	161	java/lang/Throwable
    //   139	156	161	java/lang/Throwable
  }
  
  private static double b(double paramDouble)
  {
    return Math.cos(paramDouble * 3000.0D * (a / 180.0D)) * 3.0E-6D;
  }
  
  private static double b(double paramDouble1, double paramDouble2)
  {
    return Math.sin(paramDouble2 / 100000.0D) * (paramDouble1 / 18000.0D) + Math.cos(paramDouble1 / 100000.0D) * (paramDouble2 / 9000.0D);
  }
  
  public static DPoint b(Context paramContext, DPoint paramDPoint)
  {
    try
    {
      if (!dg.a(paramDPoint.getLatitude(), paramDPoint.getLongitude())) {
        return paramDPoint;
      }
      double d2 = paramDPoint.getLongitude();
      double d1 = paramDPoint.getLatitude();
      d2 = (d2 * 100000.0D) % 36000000L;
      d1 = (d1 * 100000.0D) % 36000000L;
      double d3 = a(d2, d1);
      d3 = -d3;
      Double.isNaN(d2);
      int i = (int)(d3 + d2);
      d3 = b(d2, d1);
      d3 = -d3;
      Double.isNaN(d1);
      int j = (int)(d3 + d1);
      double d4 = i;
      d3 = j;
      d4 = a(d4, d3);
      d4 = -d4;
      Double.isNaN(d2);
      j = -1;
      if (d2 > 0.0D) {
        i = 1;
      } else {
        i = -1;
      }
      double d5 = i;
      Double.isNaN(d5);
      d2 = (int)(d4 + d2 + d5);
      d3 = b(d2, d3);
      d3 = -d3;
      Double.isNaN(d1);
      i = j;
      if (d1 > 0.0D) {
        i = 1;
      }
      d4 = i;
      Double.isNaN(d4);
      i = (int)(d3 + d1 + d4);
      Double.isNaN(d2);
      d1 = d2 / 100000.0D;
      d2 = i;
      Double.isNaN(d2);
      d2 /= 100000.0D;
      paramContext = a(paramContext, new DPoint(d2, d1));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "OffsetUtil", "marbar2G");
    }
    return paramDPoint;
  }
  
  private static DPoint b(DPoint paramDPoint)
  {
    double d2 = 0.006401062D;
    double d1 = 0.0060424805D;
    DPoint localDPoint1 = null;
    int i = 0;
    while (i < 2)
    {
      double d3 = paramDPoint.getLongitude();
      double d4 = paramDPoint.getLatitude();
      localDPoint1 = new DPoint();
      d2 = d3 - d2;
      d1 = d4 - d1;
      DPoint localDPoint2 = new DPoint();
      double d5 = Math.cos(b(d2) + Math.atan2(d1, d2));
      double d6 = a(d1);
      double d10 = d2 * d2 + d1 * d1;
      double d7 = Math.sqrt(d10);
      double d8 = Math.sin(b(d2) + Math.atan2(d1, d2));
      double d9 = a(d1);
      d10 = Math.sqrt(d10);
      localDPoint2.setLongitude(c(d5 * (d6 + d7) + 0.0065D));
      localDPoint2.setLatitude(c(d8 * (d9 + d10) + 0.006D));
      localDPoint1.setLongitude(c(d3 + d2 - localDPoint2.getLongitude()));
      localDPoint1.setLatitude(c(d4 + d1 - localDPoint2.getLatitude()));
      d2 = paramDPoint.getLongitude() - localDPoint1.getLongitude();
      d1 = paramDPoint.getLatitude() - localDPoint1.getLatitude();
      i += 1;
    }
    return localDPoint1;
  }
  
  private static double c(double paramDouble)
  {
    return new BigDecimal(paramDouble).setScale(8, 4).doubleValue();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */