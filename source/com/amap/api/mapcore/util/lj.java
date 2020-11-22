package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Hashtable;
import java.util.Random;
import org.json.JSONObject;

public final class lj
{
  static WifiManager a = null;
  private static int b;
  private static String[] c;
  private static Hashtable<String, Long> d = new Hashtable();
  private static SparseArray<String> e = null;
  private static String[] f = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  private static String g = "android.permission.ACCESS_BACKGROUND_LOCATION";
  private static boolean h = false;
  
  public static double a(double paramDouble)
  {
    paramDouble = (paramDouble * 1000000.0D);
    Double.isNaN(paramDouble);
    return paramDouble / 1000000.0D;
  }
  
  public static float a(float paramFloat)
  {
    double d1 = paramFloat;
    Double.isNaN(d1);
    d1 = (d1 * 100.0D);
    Double.isNaN(d1);
    return (float)(d1 / 100.0D);
  }
  
  public static float a(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length != 4) {
      return 0.0F;
    }
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(paramArrayOfDouble[0], paramArrayOfDouble[1], paramArrayOfDouble[2], paramArrayOfDouble[3], arrayOfFloat);
    return arrayOfFloat[0];
  }
  
  public static int a(int paramInt)
  {
    return paramInt * 2 - 113;
  }
  
  public static int a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return -1;
    }
    if (!paramNetworkInfo.isAvailable()) {
      return -1;
    }
    if (!paramNetworkInfo.isConnected()) {
      return -1;
    }
    return paramNetworkInfo.getType();
  }
  
  public static long a()
  {
    return System.currentTimeMillis();
  }
  
  public static Object a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getApplicationContext().getSystemService(paramString);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      lf.a(paramContext, "Utils", "getServ");
    }
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      if (c() < 17) {
        return b(paramContext, "android.provider.Settings$System");
      }
      boolean bool = b(paramContext, "android.provider.Settings$Global");
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ("00:00:00:00:00:00".equals(paramString)) {
      return false;
    }
    return !paramString.contains(" :");
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    return fw.a(paramJSONObject, paramString);
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= 2) {}
    }
    else
    {
      arrayOfByte = new byte[2];
    }
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    arrayOfByte[1] = ((byte)((paramInt & 0xFF00) >> 8));
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = fw.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      lf.a(paramArrayOfByte, "Utils", "gz");
    }
    return null;
  }
  
  public static String[] a(TelephonyManager paramTelephonyManager)
  {
    if (paramTelephonyManager != null) {
      paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
    } else {
      paramTelephonyManager = null;
    }
    String[] arrayOfString = { "0", "0" };
    if (TextUtils.isEmpty(paramTelephonyManager)) {}
    while ((!TextUtils.isDigitsOnly(paramTelephonyManager)) || (paramTelephonyManager.length() <= 4))
    {
      i = 0;
      break;
    }
    int i = 1;
    if (i != 0)
    {
      arrayOfString[0] = paramTelephonyManager.substring(0, 3);
      char[] arrayOfChar = paramTelephonyManager.substring(3).toCharArray();
      i = 0;
      while ((i < arrayOfChar.length) && (Character.isDigit(arrayOfChar[i]))) {
        i += 1;
      }
      arrayOfString[1] = paramTelephonyManager.substring(3, i + 3);
    }
    try
    {
      i = Integer.parseInt(arrayOfString[0]);
    }
    catch (Throwable paramTelephonyManager)
    {
      lf.a(paramTelephonyManager, "Utils", "getMccMnc");
      i = 0;
    }
    if (i == 0) {
      arrayOfString[0] = "0";
    }
    if ((!"0".equals(arrayOfString[0])) && (!"0".equals(arrayOfString[1])))
    {
      c = arrayOfString;
      return arrayOfString;
    }
    paramTelephonyManager = arrayOfString;
    if ("0".equals(arrayOfString[0]))
    {
      paramTelephonyManager = arrayOfString;
      if ("0".equals(arrayOfString[1]))
      {
        paramTelephonyManager = arrayOfString;
        if (c != null) {
          paramTelephonyManager = c;
        }
      }
    }
    return paramTelephonyManager;
  }
  
  public static double b(double paramDouble)
  {
    paramDouble = (paramDouble * 100.0D);
    Double.isNaN(paramDouble);
    return paramDouble / 100.0D;
  }
  
  public static long b()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    case 17: 
    default: 
      return "其他错误";
    case 19: 
      return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
    case 18: 
      return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
    case 15: 
      return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
    case 14: 
      return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
    case 13: 
      return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
    case 12: 
      return "缺少定位权限";
    case 11: 
      return "错误的基站信息，请检查是否插入SIM卡";
    case 10: 
      return "定位服务启动失败";
    case 9: 
      return "初始化异常";
    case 8: 
      return "其他错误";
    case 7: 
      return "KEY错误";
    case 6: 
      return "定位结果错误";
    case 5: 
      return "解析数据异常";
    case 4: 
      return "网络连接异常";
    case 3: 
      return "请求参数获取出现异常";
    case 2: 
      return "WIFI信息不足";
    case 1: 
      return "重要参数为空";
    }
    return "success";
  }
  
  public static String b(Context paramContext)
  {
    if (!TextUtils.isEmpty(lf.g)) {
      return lf.g;
    }
    CharSequence localCharSequence = null;
    if (paramContext == null) {
      return null;
    }
    Object localObject1 = fk.c(paramContext);
    Object localObject2;
    try
    {
      localObject1 = paramContext.getPackageManager().getPackageInfo((String)localObject1, 64);
    }
    catch (Throwable localThrowable1)
    {
      lf.a(localThrowable1, "Utils", "getAppName part");
      localObject2 = null;
    }
    try
    {
      if (TextUtils.isEmpty(lf.h)) {
        lf.h = null;
      }
    }
    catch (Throwable localThrowable2)
    {
      lf.a(localThrowable2, "Utils", "getAppName");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localObject2 != null)
    {
      if (((PackageInfo)localObject2).applicationInfo != null) {
        localCharSequence = ((PackageInfo)localObject2).applicationInfo.loadLabel(paramContext.getPackageManager());
      }
      if (localCharSequence != null) {
        localStringBuilder.append(localCharSequence.toString());
      }
      if (!TextUtils.isEmpty(((PackageInfo)localObject2).versionName)) {
        localStringBuilder.append(((PackageInfo)localObject2).versionName);
      }
    }
    paramContext = fk.c(paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      localStringBuilder.append(",");
      localStringBuilder.append(paramContext);
    }
    if (!TextUtils.isEmpty(lf.h))
    {
      localStringBuilder.append(",");
      localStringBuilder.append(lf.h);
    }
    paramContext = localStringBuilder.toString();
    lf.g = paramContext;
    return paramContext;
  }
  
  public static String b(TelephonyManager paramTelephonyManager)
  {
    SparseArray localSparseArray = e;
    int i = 0;
    if (localSparseArray == null)
    {
      localSparseArray = new SparseArray();
      e = localSparseArray;
      localSparseArray.append(0, "UNKWN");
      e.append(1, "GPRS");
      e.append(2, "EDGE");
      e.append(3, "UMTS");
      e.append(4, "CDMA");
      e.append(5, "EVDO_0");
      e.append(6, "EVDO_A");
      e.append(7, "1xRTT");
      e.append(8, "HSDPA");
      e.append(9, "HSUPA");
      e.append(10, "HSPA");
      e.append(11, "IDEN");
      e.append(12, "EVDO_B");
      e.append(13, "LTE");
      e.append(14, "EHRPD");
      e.append(15, "HSPAP");
    }
    if (paramTelephonyManager != null) {
      i = paramTelephonyManager.getNetworkType();
    }
    return (String)e.get(i, "UNKWN");
  }
  
  private static boolean b(Context paramContext, String paramString)
    throws Throwable
  {
    return ((Integer)lh.a(paramString, "getInt", new Object[] { paramContext.getContentResolver(), ((String)lh.a(paramString, "AIRPLANE_MODE_ON")).toString() }, new Class[] { ContentResolver.class, String.class })).intValue() == 1;
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= 4) {}
    }
    else
    {
      arrayOfByte = new byte[4];
    }
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramInt >> i * 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] b(String paramString)
  {
    return a(d(paramString), null);
  }
  
  public static int c()
  {
    if (b > 0) {
      return b;
    }
    try
    {
      i = lh.b("android.os.Build$VERSION", "SDK_INT");
      return i;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          int i = Integer.parseInt(lh.a("android.os.Build$VERSION", "SDK").toString());
          return i;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
      }
    }
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean c(Context paramContext)
  {
    if (paramContext == null) {
      return true;
    }
    if (a == null) {
      a = (WifiManager)a(paramContext, "wifi");
    }
    try
    {
      bool1 = a.isWifiEnabled();
    }
    catch (Throwable paramContext)
    {
      boolean bool1;
      for (;;) {}
    }
    bool1 = false;
    if ((!bool1) && (c() > 17)) {}
    try
    {
      boolean bool2 = "true".equals(String.valueOf(lh.a(a, "isScanAlwaysAvailable", new Object[0])));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return bool1;
  }
  
  public static byte[] c(String paramString)
  {
    return b(d(paramString), null);
  }
  
  public static int d(String paramString)
    throws NumberFormatException
  {
    return Integer.parseInt(paramString);
  }
  
  public static String d()
  {
    return Build.MODEL;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject2 = fp.n(paramContext);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("00:00:00:00:00:00")) {}
    }
    else
    {
      localObject1 = li.a(paramContext);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "00:00:00:00:00:00";
    }
    if (!h)
    {
      li.a(paramContext, (String)localObject2);
      h = true;
    }
    return (String)localObject2;
  }
  
  public static byte e(String paramString)
    throws NumberFormatException
  {
    return Byte.parseByte(paramString);
  }
  
  public static String e()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static boolean e(Context paramContext)
  {
    return (Build.VERSION.SDK_INT >= 28) && (paramContext.getApplicationInfo().targetSdkVersion >= 28);
  }
  
  public static int f()
  {
    return new Random().nextInt(65536) - 32768;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */