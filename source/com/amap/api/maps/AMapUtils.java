package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.amap.api.mapcore.util.fj;
import com.amap.api.mapcore.util.fk;
import com.amap.api.mapcore.util.fm;
import com.amap.api.mapcore.util.fv;
import com.amap.api.mapcore.util.fv.a;
import com.amap.api.mapcore.util.lk;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import java.util.List;
import java.util.Locale;

public class AMapUtils
{
  public static final int BUS_COMFORT = 4;
  public static final int BUS_MONEY_LITTLE = 1;
  public static final int BUS_NO_SUBWAY = 5;
  public static final int BUS_TIME_FIRST = 0;
  public static final int BUS_TRANSFER_LITTLE = 2;
  public static final int BUS_WALK_LITTLE = 3;
  public static final int DRIVING_AVOID_CONGESTION = 4;
  public static final int DRIVING_DEFAULT = 0;
  public static final int DRIVING_NO_HIGHWAY = 3;
  public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
  public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
  public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
  public static final int DRIVING_SAVE_MONEY = 1;
  public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
  public static final int DRIVING_SHORT_DISTANCE = 2;
  
  private static String a(NaviPara paramNaviPara, Context paramContext)
  {
    return String.format(Locale.US, "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d", new Object[] { fk.b(paramContext), Double.valueOf(paramNaviPara.getTargetPoint().latitude), Double.valueOf(paramNaviPara.getTargetPoint().longitude), Integer.valueOf(paramNaviPara.getNaviStyle()) });
  }
  
  private static String a(PoiPara paramPoiPara, Context paramContext)
  {
    String str = String.format(Locale.US, "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0", new Object[] { fk.b(paramContext), paramPoiPara.getKeywords() });
    paramContext = str;
    if (paramPoiPara.getCenter() != null)
    {
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append("&lat=");
      paramContext.append(paramPoiPara.getCenter().latitude);
      paramContext.append("&lon=");
      paramContext.append(paramPoiPara.getCenter().longitude);
      paramContext = paramContext.toString();
    }
    return paramContext;
  }
  
  private static void a(RoutePara paramRoutePara, Context paramContext, int paramInt)
    throws AMapException
  {
    if ((!a(paramContext)) || (a(paramRoutePara))) {}
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(276824064);
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.parse(b(paramRoutePara, paramContext, paramInt)));
      localIntent.setPackage("com.autonavi.minimap");
      new a("oan", paramContext).start();
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramRoutePara)
    {
      for (;;) {}
    }
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
    throw new AMapException("非法参数");
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.autonavi.minimap", 0);
      return paramContext != null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static boolean a(RoutePara paramRoutePara)
  {
    return (paramRoutePara.getStartPoint() != null) && (paramRoutePara.getEndPoint() != null) && (paramRoutePara.getStartName() != null) && (paramRoutePara.getStartName().trim().length() > 0) && (paramRoutePara.getEndName() != null) && (paramRoutePara.getEndName().trim().length() > 0);
  }
  
  private static String b(RoutePara paramRoutePara, Context paramContext, int paramInt)
  {
    String str = String.format(Locale.US, "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d", new Object[] { fk.b(paramContext), Double.valueOf(paramRoutePara.getStartPoint().latitude), Double.valueOf(paramRoutePara.getStartPoint().longitude), paramRoutePara.getStartName(), Double.valueOf(paramRoutePara.getEndPoint().latitude), Double.valueOf(paramRoutePara.getEndPoint().longitude), paramRoutePara.getEndName(), Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append("&m=");
      paramContext.append(paramRoutePara.getTransitRouteStyle());
      return paramContext.toString();
    }
    paramContext = str;
    if (paramInt == 2)
    {
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append("&m=");
      paramContext.append(paramRoutePara.getDrivingRouteStyle());
      paramContext = paramContext.toString();
    }
    return paramContext;
  }
  
  public static float calculateArea(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if ((paramLatLng1 != null) && (paramLatLng2 != null)) {
      try
      {
        double d3 = Math.sin(paramLatLng1.latitude * 3.141592653589793D / 180.0D);
        double d4 = Math.sin(paramLatLng2.latitude * 3.141592653589793D / 180.0D);
        double d1 = paramLatLng2.longitude;
        double d2 = paramLatLng1.longitude;
        d2 = (d1 - d2) / 360.0D;
        d1 = d2;
        if (d2 < 0.0D) {
          d1 = d2 + 1.0D;
        }
        return (float)((d3 - d4) * 2.5560394669790553E14D * d1);
      }
      catch (Throwable paramLatLng1)
      {
        paramLatLng1.printStackTrace();
        return 0.0F;
      }
    }
    try
    {
      throw new AMapException("非法坐标值");
    }
    catch (AMapException paramLatLng1)
    {
      paramLatLng1.printStackTrace();
    }
    return 0.0F;
  }
  
  public static float calculateArea(List<LatLng> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 3))
    {
      double d1 = 0.0D;
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        LatLng localLatLng1 = (LatLng)paramList.get(i);
        i += 1;
        LatLng localLatLng2 = (LatLng)paramList.get(i % j);
        double d2 = localLatLng1.longitude;
        double d3 = Math.cos(localLatLng1.latitude * 0.017453292519943295D);
        double d4 = localLatLng1.latitude;
        double d5 = localLatLng2.longitude;
        double d6 = Math.cos(localLatLng2.latitude * 0.017453292519943295D);
        d1 += d2 * 111319.49079327357D * d3 * (localLatLng2.latitude * 111319.49079327357D) - d5 * 111319.49079327357D * d6 * (d4 * 111319.49079327357D);
      }
      return (float)Math.abs(d1 / 2.0D);
    }
    return 0.0F;
  }
  
  public static float calculateLineDistance(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if ((paramLatLng1 != null) && (paramLatLng2 != null)) {
      try
      {
        double d4 = paramLatLng1.longitude;
        double d3 = paramLatLng1.latitude;
        double d2 = paramLatLng2.longitude;
        double d1 = paramLatLng2.latitude;
        double d5 = d4 * 0.01745329251994329D;
        double d6 = d3 * 0.01745329251994329D;
        d3 = d2 * 0.01745329251994329D;
        d4 = d1 * 0.01745329251994329D;
        d1 = Math.sin(d5);
        d2 = Math.sin(d6);
        d5 = Math.cos(d5);
        d6 = Math.cos(d6);
        double d7 = Math.sin(d3);
        double d8 = Math.sin(d4);
        d3 = Math.cos(d3);
        d4 = Math.cos(d4);
        paramLatLng1 = new double[3];
        paramLatLng2 = new double[3];
        paramLatLng1[0] = (d5 * d6);
        paramLatLng1[1] = (d6 * d1);
        paramLatLng1[2] = d2;
        paramLatLng2[0] = (d3 * d4);
        paramLatLng2[1] = (d4 * d7);
        paramLatLng2[2] = d8;
        d1 = Math.asin(Math.sqrt((paramLatLng1[0] - paramLatLng2[0]) * (paramLatLng1[0] - paramLatLng2[0]) + (paramLatLng1[1] - paramLatLng2[1]) * (paramLatLng1[1] - paramLatLng2[1]) + (paramLatLng1[2] - paramLatLng2[2]) * (paramLatLng1[2] - paramLatLng2[2])) / 2.0D);
        return (float)(d1 * 1.27420015798544E7D);
      }
      catch (Throwable paramLatLng1)
      {
        paramLatLng1.printStackTrace();
        return 0.0F;
      }
    }
    try
    {
      throw new AMapException("非法坐标值");
    }
    catch (AMapException paramLatLng1)
    {
      paramLatLng1.printStackTrace();
    }
    return 0.0F;
  }
  
  public static void getLatestAMapApp(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(276824064);
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.parse("http://wap.amap.com/"));
      new a("glaa", paramContext).start();
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void openAMapDrivingRoute(RoutePara paramRoutePara, Context paramContext)
    throws AMapException
  {
    a(paramRoutePara, paramContext, 2);
  }
  
  public static void openAMapNavi(NaviPara paramNaviPara, Context paramContext)
    throws AMapException
  {
    if ((!a(paramContext)) || (paramNaviPara.getTargetPoint() != null)) {}
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(276824064);
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.parse(a(paramNaviPara, paramContext)));
      localIntent.setPackage("com.autonavi.minimap");
      new a("oan", paramContext).start();
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramNaviPara)
    {
      for (;;) {}
    }
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
    throw new AMapException("非法参数");
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
  }
  
  public static void openAMapPoiNearbySearch(PoiPara paramPoiPara, Context paramContext)
    throws AMapException
  {
    if ((!a(paramContext)) || ((paramPoiPara.getKeywords() != null) && (paramPoiPara.getKeywords().trim().length() > 0))) {}
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(276824064);
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setData(Uri.parse(a(paramPoiPara, paramContext)));
      localIntent.setPackage("com.autonavi.minimap");
      new a("oan", paramContext).start();
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramPoiPara)
    {
      for (;;) {}
    }
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
    throw new AMapException("非法参数");
    throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
  }
  
  public static void openAMapTransitRoute(RoutePara paramRoutePara, Context paramContext)
    throws AMapException
  {
    a(paramRoutePara, paramContext, 1);
  }
  
  public static void openAMapWalkingRoute(RoutePara paramRoutePara, Context paramContext)
    throws AMapException
  {
    a(paramRoutePara, paramContext, 4);
  }
  
  static class a
    extends Thread
  {
    String a = "";
    Context b;
    
    public a(String paramString, Context paramContext)
    {
      this.a = paramString;
      if (paramContext != null) {
        this.b = paramContext.getApplicationContext();
      }
    }
    
    public void run()
    {
      if (this.b != null) {
        try
        {
          fv localfv = new fv.a(this.a, "7.1.0", lk.c).a(new String[] { "com.amap.api.maps" }).a();
          fm.a(this.b, localfv);
          interrupt();
          return;
        }
        catch (fj localfj)
        {
          localfj.printStackTrace();
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\AMapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */