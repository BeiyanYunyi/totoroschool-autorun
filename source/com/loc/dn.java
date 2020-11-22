package com.loc;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

public final class dn
{
  static WifiManager a = null;
  private static int b;
  private static String[] c;
  private static String[] d = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  private static String e = "android.permission.ACCESS_BACKGROUND_LOCATION";
  private static boolean f = false;
  
  public static double a(double paramDouble)
  {
    return b(paramDouble);
  }
  
  public static float a(float paramFloat)
  {
    double d1 = paramFloat;
    Double.isNaN(d1);
    d1 = (d1 * 100.0D);
    Double.isNaN(d1);
    return (float)(d1 / 100.0D);
  }
  
  public static float a(AMapLocation paramAMapLocation1, AMapLocation paramAMapLocation2)
  {
    return a(new double[] { paramAMapLocation1.getLatitude(), paramAMapLocation1.getLongitude(), paramAMapLocation2.getLatitude(), paramAMapLocation2.getLongitude() });
  }
  
  public static float a(DPoint paramDPoint1, DPoint paramDPoint2)
  {
    return a(new double[] { paramDPoint1.getLatitude(), paramDPoint1.getLongitude(), paramDPoint2.getLatitude(), paramDPoint2.getLongitude() });
  }
  
  public static float a(double[] paramArrayOfDouble)
  {
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
      dg.a(paramContext, "Utils", "getServ");
    }
    return null;
  }
  
  public static String a(long paramLong, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "yyyy-MM-dd HH:mm:ss";
    }
    try
    {
      paramString = new SimpleDateFormat(str, Locale.CHINA);
      try
      {
        paramString.applyPattern(str);
      }
      catch (Throwable localThrowable1) {}
      dg.a(localThrowable2, "Utils", "formatUTC");
    }
    catch (Throwable localThrowable2)
    {
      paramString = null;
    }
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    if (paramString == null) {
      return "NULL";
    }
    return paramString.format(Long.valueOf(l));
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    String str1 = a(paramLong1, "yyyyMMdd");
    String str2 = a(paramLong2, "yyyyMMdd");
    if ((!"NULL".equals(str1)) && (!"NULL".equals(str2))) {
      return str1.equals(str2);
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      if (c() < 17) {
        return c(paramContext, "android.provider.Settings$System");
      }
      boolean bool = c(paramContext, "android.provider.Settings$Global");
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  /* Error */
  public static boolean a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: ldc -82
    //   11: ldc -80
    //   13: ldc -78
    //   15: invokevirtual 182	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   18: astore 6
    //   20: aload_0
    //   21: ifnull +155 -> 176
    //   24: aconst_null
    //   25: astore 4
    //   27: aload_0
    //   28: invokevirtual 187	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   31: ifne +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: new 189	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   43: astore 5
    //   45: aload 5
    //   47: ldc -63
    //   49: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 5
    //   55: aload_1
    //   56: invokevirtual 201	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 5
    //   65: aload 6
    //   67: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: ldc -53
    //   75: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: aload 5
    //   82: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aconst_null
    //   86: invokevirtual 210	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore_0
    //   90: aload_0
    //   91: ifnull +99 -> 190
    //   94: aload_0
    //   95: invokeinterface 215 1 0
    //   100: ifeq +90 -> 190
    //   103: aload_0
    //   104: iconst_0
    //   105: invokeinterface 218 2 0
    //   110: ifle +80 -> 190
    //   113: iconst_1
    //   114: istore_2
    //   115: goto +3 -> 118
    //   118: aload 5
    //   120: iconst_0
    //   121: aload 5
    //   123: invokevirtual 221	java/lang/StringBuilder:length	()I
    //   126: invokevirtual 225	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: iload_2
    //   131: istore_3
    //   132: aload_0
    //   133: ifnull +41 -> 174
    //   136: aload_0
    //   137: invokeinterface 228 1 0
    //   142: iload_2
    //   143: ireturn
    //   144: astore_1
    //   145: aload 4
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull +9 -> 158
    //   152: aload_0
    //   153: invokeinterface 228 1 0
    //   158: aload_1
    //   159: athrow
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +9 -> 172
    //   166: aload_0
    //   167: invokeinterface 228 1 0
    //   172: iconst_1
    //   173: istore_3
    //   174: iload_3
    //   175: ireturn
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_0
    //   179: goto -19 -> 160
    //   182: astore_1
    //   183: goto -21 -> 162
    //   186: astore_1
    //   187: goto -39 -> 148
    //   190: iconst_0
    //   191: istore_2
    //   192: goto -74 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   0	195	1	paramString	String
    //   114	78	2	bool1	boolean
    //   131	44	3	bool2	boolean
    //   25	121	4	localObject	Object
    //   43	79	5	localStringBuilder	StringBuilder
    //   18	48	6	str	String
    // Exception table:
    //   from	to	target	type
    //   27	34	144	finally
    //   36	90	144	finally
    //   27	34	178	java/lang/Throwable
    //   36	90	178	java/lang/Throwable
    //   94	113	182	java/lang/Throwable
    //   118	130	182	java/lang/Throwable
    //   94	113	186	finally
    //   118	130	186	finally
  }
  
  public static boolean a(Location paramLocation, int paramInt)
  {
    Boolean localBoolean2 = Boolean.valueOf(false);
    Object localObject = localBoolean2;
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      localObject = (Boolean)dj.a(paramLocation, "isFromMockProvider", new Object[0]);
      if (((Boolean)localObject).booleanValue()) {
        return true;
      }
      localObject = paramLocation.getExtras();
      int i;
      if (localObject != null) {
        i = ((Bundle)localObject).getInt("satellites");
      } else {
        i = 0;
      }
      if (i <= 0) {
        return true;
      }
      return (paramInt == 0) && (paramLocation.getAltitude() == 0.0D) && (paramLocation.getBearing() == 0.0F) && (paramLocation.getSpeed() == 0.0F);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Boolean localBoolean1 = localBoolean2;
      }
    }
  }
  
  public static boolean a(AMapLocation paramAMapLocation)
  {
    if (paramAMapLocation == null) {
      return false;
    }
    if (paramAMapLocation.getErrorCode() != 0) {
      return false;
    }
    return b(paramAMapLocation);
  }
  
  public static boolean a(co paramco)
  {
    if (paramco == null) {
      return false;
    }
    if ("8".equals(paramco.d())) {
      return false;
    }
    if ("5".equals(paramco.d())) {
      return false;
    }
    if ("6".equals(paramco.d())) {
      return false;
    }
    return b(paramco);
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
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = d(paramString1);
      paramString2 = paramString2.toString().split("#");
      int j = 0;
      int k = 0;
      int n;
      for (int i = 0; j < paramString2.length; i = n)
      {
        int m;
        if (!paramString2[j].contains(",nb"))
        {
          m = k;
          n = i;
          if (!paramString2[j].contains(",access")) {}
        }
        else
        {
          k += 1;
          m = k;
          n = i;
          if (paramString1.contains(paramString2[j]))
          {
            n = i + 1;
            m = k;
          }
        }
        j += 1;
        k = m;
      }
      j = paramString1.size();
      double d1 = i * 2;
      double d2 = j + k;
      Double.isNaN(d2);
      if (d1 >= d2 * 0.618D) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    return w.a(paramJSONObject, paramString);
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
    while (i < 8)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return w.b(paramArrayOfByte);
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
      dg.a(paramTelephonyManager, "Utils", "getMccMnc");
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
    paramDouble = (paramDouble * 1000000.0D);
    Double.isNaN(paramDouble);
    return paramDouble / 1000000.0D;
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
    if (!TextUtils.isEmpty(dg.g)) {
      return dg.g;
    }
    CharSequence localCharSequence = null;
    if (paramContext == null) {
      return null;
    }
    Object localObject1 = l.c(paramContext);
    Object localObject2;
    try
    {
      localObject1 = paramContext.getPackageManager().getPackageInfo((String)localObject1, 64);
    }
    catch (Throwable localThrowable1)
    {
      dg.a(localThrowable1, "Utils", "getAppName part");
      localObject2 = null;
    }
    try
    {
      if (TextUtils.isEmpty(dg.h)) {
        dg.h = null;
      }
    }
    catch (Throwable localThrowable2)
    {
      dg.a(localThrowable2, "Utils", "getAppName");
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
    paramContext = l.c(paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      localStringBuilder.append(",");
      localStringBuilder.append(paramContext);
    }
    if (!TextUtils.isEmpty(dg.h))
    {
      localStringBuilder.append(",");
      localStringBuilder.append(dg.h);
    }
    paramContext = localStringBuilder.toString();
    dg.g = paramContext;
    return paramContext;
  }
  
  public static String b(TelephonyManager paramTelephonyManager)
  {
    j = 0;
    i = j;
    if (paramTelephonyManager != null) {}
    try
    {
      i = paramTelephonyManager.getNetworkType();
    }
    catch (Throwable paramTelephonyManager)
    {
      for (;;)
      {
        i = j;
      }
    }
    switch (i)
    {
    default: 
      return "UNKWN";
    case 15: 
      return "HSPAP";
    case 14: 
      return "EHRPD";
    case 13: 
      return "LTE";
    case 12: 
      return "EVDO_B";
    case 11: 
      return "IDEN";
    case 10: 
      return "HSPA";
    case 9: 
      return "HSUPA";
    case 8: 
      return "HSDPA";
    case 7: 
      return "1xRTT";
    case 6: 
      return "EVDO_A";
    case 5: 
      return "EVDO_0";
    case 4: 
      return "CDMA";
    case 3: 
      return "UMTS";
    case 2: 
      return "EDGE";
    case 1: 
      return "GPRS";
    }
    return "UNKWN";
  }
  
  /* Error */
  public static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 7
    //   11: astore_3
    //   12: new 499	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 501	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload 7
    //   23: astore_3
    //   24: aload_0
    //   25: invokevirtual 504	java/io/File:exists	()Z
    //   28: ifeq +312 -> 340
    //   31: aload 7
    //   33: astore_3
    //   34: aload_0
    //   35: invokevirtual 507	java/io/File:isDirectory	()Z
    //   38: ifeq +4 -> 42
    //   41: return
    //   42: aload_1
    //   43: astore 4
    //   45: aload 7
    //   47: astore_3
    //   48: aload_1
    //   49: getstatic 510	java/io/File:separator	Ljava/lang/String;
    //   52: invokevirtual 513	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   55: ifne +47 -> 102
    //   58: aload 7
    //   60: astore_3
    //   61: new 189	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   68: astore 4
    //   70: aload 7
    //   72: astore_3
    //   73: aload 4
    //   75: aload_1
    //   76: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 7
    //   82: astore_3
    //   83: aload 4
    //   85: getstatic 510	java/io/File:separator	Ljava/lang/String;
    //   88: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 7
    //   94: astore_3
    //   95: aload 4
    //   97: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 4
    //   102: aload 7
    //   104: astore_3
    //   105: new 515	java/util/zip/ZipInputStream
    //   108: dup
    //   109: new 517	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 520	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   117: invokespecial 523	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 527	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   125: astore 6
    //   127: aload 6
    //   129: ifnull +188 -> 317
    //   132: sipush 1024
    //   135: newarray <illegal type>
    //   137: astore_3
    //   138: aload 6
    //   140: invokevirtual 532	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +169 -> 317
    //   151: aload_0
    //   152: ldc_w 534
    //   155: invokevirtual 295	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   158: ifeq +6 -> 164
    //   161: goto +156 -> 317
    //   164: aload 6
    //   166: invokevirtual 535	java/util/zip/ZipEntry:isDirectory	()Z
    //   169: ifeq +6 -> 175
    //   172: goto -51 -> 121
    //   175: new 189	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   182: astore 6
    //   184: aload 6
    //   186: aload 4
    //   188: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 6
    //   194: aload_0
    //   195: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: new 499	java/io/File
    //   202: dup
    //   203: aload 6
    //   205: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 501	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: astore_0
    //   212: new 499	java/io/File
    //   215: dup
    //   216: aload_0
    //   217: invokevirtual 538	java/io/File:getParent	()Ljava/lang/String;
    //   220: invokespecial 501	java/io/File:<init>	(Ljava/lang/String;)V
    //   223: astore 6
    //   225: aload 6
    //   227: invokevirtual 504	java/io/File:exists	()Z
    //   230: ifne +9 -> 239
    //   233: aload 6
    //   235: invokevirtual 541	java/io/File:mkdirs	()Z
    //   238: pop
    //   239: new 543	java/io/FileOutputStream
    //   242: dup
    //   243: aload_0
    //   244: invokespecial 544	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   247: astore_0
    //   248: aload_1
    //   249: aload_3
    //   250: iconst_0
    //   251: sipush 1024
    //   254: invokevirtual 548	java/util/zip/ZipInputStream:read	([BII)I
    //   257: istore_2
    //   258: iload_2
    //   259: iconst_m1
    //   260: if_icmpeq +13 -> 273
    //   263: aload_0
    //   264: aload_3
    //   265: iconst_0
    //   266: iload_2
    //   267: invokevirtual 552	java/io/FileOutputStream:write	([BII)V
    //   270: goto -22 -> 248
    //   273: aload_0
    //   274: invokevirtual 555	java/io/FileOutputStream:flush	()V
    //   277: aload_0
    //   278: invokevirtual 556	java/io/FileOutputStream:close	()V
    //   281: goto -160 -> 121
    //   284: astore 4
    //   286: aload_0
    //   287: astore_3
    //   288: aload 4
    //   290: astore_0
    //   291: goto +7 -> 298
    //   294: astore_0
    //   295: aload 5
    //   297: astore_3
    //   298: aload_3
    //   299: ifnull +7 -> 306
    //   302: aload_3
    //   303: invokevirtual 556	java/io/FileOutputStream:close	()V
    //   306: aload_0
    //   307: athrow
    //   308: aconst_null
    //   309: astore_0
    //   310: aload_0
    //   311: ifnull -190 -> 121
    //   314: goto -37 -> 277
    //   317: aload_1
    //   318: invokevirtual 559	java/util/zip/ZipInputStream:closeEntry	()V
    //   321: aload_1
    //   322: invokevirtual 560	java/util/zip/ZipInputStream:close	()V
    //   325: return
    //   326: astore_0
    //   327: aload_1
    //   328: astore_3
    //   329: goto +44 -> 373
    //   332: astore_3
    //   333: aload_1
    //   334: astore_0
    //   335: aload_3
    //   336: astore_1
    //   337: goto +12 -> 349
    //   340: return
    //   341: astore_0
    //   342: goto +31 -> 373
    //   345: astore_1
    //   346: aload 6
    //   348: astore_0
    //   349: aload_0
    //   350: astore_3
    //   351: aload_1
    //   352: ldc 106
    //   354: ldc_w 562
    //   357: invokestatic 113	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_0
    //   361: ifnull +11 -> 372
    //   364: aload_0
    //   365: invokevirtual 559	java/util/zip/ZipInputStream:closeEntry	()V
    //   368: aload_0
    //   369: invokevirtual 560	java/util/zip/ZipInputStream:close	()V
    //   372: return
    //   373: aload_3
    //   374: ifnull +11 -> 385
    //   377: aload_3
    //   378: invokevirtual 559	java/util/zip/ZipInputStream:closeEntry	()V
    //   381: aload_3
    //   382: invokevirtual 560	java/util/zip/ZipInputStream:close	()V
    //   385: aload_0
    //   386: athrow
    //   387: astore_0
    //   388: goto -80 -> 308
    //   391: astore_3
    //   392: goto -82 -> 310
    //   395: astore_0
    //   396: goto -275 -> 121
    //   399: astore_3
    //   400: goto -94 -> 306
    //   403: astore_0
    //   404: return
    //   405: astore_0
    //   406: return
    //   407: astore_1
    //   408: goto -23 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramString1	String
    //   0	411	1	paramString2	String
    //   257	10	2	i	int
    //   11	318	3	localObject1	Object
    //   332	4	3	localThrowable1	Throwable
    //   350	32	3	str	String
    //   391	1	3	localException	Exception
    //   399	1	3	localThrowable2	Throwable
    //   43	144	4	localObject2	Object
    //   284	5	4	localObject3	Object
    //   7	289	5	localObject4	Object
    //   4	343	6	localObject5	Object
    //   1	102	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   248	258	284	finally
    //   263	270	284	finally
    //   273	277	284	finally
    //   132	161	294	finally
    //   164	172	294	finally
    //   175	239	294	finally
    //   239	248	294	finally
    //   121	127	326	finally
    //   277	281	326	finally
    //   302	306	326	finally
    //   306	308	326	finally
    //   121	127	332	java/lang/Throwable
    //   306	308	332	java/lang/Throwable
    //   12	21	341	finally
    //   24	31	341	finally
    //   34	41	341	finally
    //   48	58	341	finally
    //   61	70	341	finally
    //   73	80	341	finally
    //   83	92	341	finally
    //   95	102	341	finally
    //   105	121	341	finally
    //   351	360	341	finally
    //   12	21	345	java/lang/Throwable
    //   24	31	345	java/lang/Throwable
    //   34	41	345	java/lang/Throwable
    //   48	58	345	java/lang/Throwable
    //   61	70	345	java/lang/Throwable
    //   73	80	345	java/lang/Throwable
    //   83	92	345	java/lang/Throwable
    //   95	102	345	java/lang/Throwable
    //   105	121	345	java/lang/Throwable
    //   132	161	387	java/lang/Exception
    //   164	172	387	java/lang/Exception
    //   175	239	387	java/lang/Exception
    //   239	248	387	java/lang/Exception
    //   248	258	391	java/lang/Exception
    //   263	270	391	java/lang/Exception
    //   273	277	391	java/lang/Exception
    //   277	281	395	java/lang/Throwable
    //   302	306	399	java/lang/Throwable
    //   317	325	403	java/lang/Throwable
    //   364	372	405	java/lang/Throwable
    //   377	385	407	java/lang/Throwable
  }
  
  public static boolean b(long paramLong1, long paramLong2)
  {
    if (!a(paramLong1, paramLong2)) {
      return false;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.CHINA);
    localCalendar.setTimeInMillis(paramLong1);
    int i = localCalendar.get(11);
    localCalendar.setTimeInMillis(paramLong2);
    int j = localCalendar.get(11);
    if (i > 12)
    {
      if (j > 12) {
        return true;
      }
    }
    else if (j <= 12) {
      return true;
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getApplicationContext().getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 256);
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    return paramContext != null;
  }
  
  public static boolean b(AMapLocation paramAMapLocation)
  {
    double d1 = paramAMapLocation.getLongitude();
    double d2 = paramAMapLocation.getLatitude();
    boolean bool2 = false;
    if ((d1 == 0.0D) && (d2 == 0.0D)) {
      return false;
    }
    boolean bool1 = bool2;
    if (d1 <= 180.0D)
    {
      if (d2 > 90.0D) {
        return false;
      }
      bool1 = bool2;
      if (d1 >= -180.0D)
      {
        if (d2 < -90.0D) {
          return false;
        }
        bool1 = true;
      }
    }
    return bool1;
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
    return a(Integer.parseInt(paramString), null);
  }
  
  public static double c(double paramDouble)
  {
    paramDouble = (paramDouble * 100.0D);
    Double.isNaN(paramDouble);
    return paramDouble / 100.0D;
  }
  
  public static int c()
  {
    if (b > 0) {
      return b;
    }
    try
    {
      i = dj.b("android.os.Build$VERSION", "SDK_INT");
      return i;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          int i = Integer.parseInt(dj.a("android.os.Build$VERSION", "SDK").toString());
          return i;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
      }
    }
    return 0;
  }
  
  public static NetworkInfo c(Context paramContext)
  {
    try
    {
      paramContext = p.t(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "Utils", "getNetWorkInfo");
    }
    return null;
  }
  
  private static boolean c(Context paramContext, String paramString)
    throws Throwable
  {
    return ((Integer)dj.a(paramString, "getInt", new Object[] { paramContext.getContentResolver(), ((String)dj.a(paramString, "AIRPLANE_MODE_ON")).toString() }, new Class[] { ContentResolver.class, String.class })).intValue() == 1;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (paramString1.exists())
    {
      if (!paramString1.isDirectory()) {
        return false;
      }
      paramString1 = paramString1.listFiles();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if ((((File)localObject).isDirectory()) && (((File)localObject).getName().equals(paramString2))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static byte[] c(String paramString)
  {
    return b(Integer.parseInt(paramString), null);
  }
  
  public static int d()
  {
    return new Random().nextInt(65536) - 32768;
  }
  
  public static ArrayList<String> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("#");
      int i = 0;
      while (i < paramString.length)
      {
        if ((paramString[i].contains(",nb")) || (paramString[i].contains(",access"))) {
          localArrayList.add(paramString[i]);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      paramContext = c(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnectedOrConnecting();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static String e()
  {
    try
    {
      String str = q.b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static void e(String paramString)
  {
    Object localObject1 = paramString;
    for (;;)
    {
      int i;
      try
      {
        if (!paramString.endsWith(File.separator))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(File.separator);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramString = new File((String)localObject1);
        if (paramString.exists())
        {
          if (!paramString.isDirectory()) {
            return;
          }
          localObject1 = paramString.listFiles();
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            if (((File)localObject2).isDirectory()) {
              e(((File)localObject2).getAbsolutePath());
            } else {
              ((File)localObject2).delete();
            }
          }
          else
          {
            paramString.delete();
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.processName.equals(l.c(paramContext)))
        {
          int i = localRunningAppProcessInfo.importance;
          if (i != 100) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "Utils", "isApplicationBroughtToBackground");
    }
    return true;
  }
  
  public static double f(String paramString)
    throws NumberFormatException
  {
    return Double.parseDouble(paramString);
  }
  
  public static boolean f(Context paramContext)
  {
    String[] arrayOfString;
    int k;
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.getApplicationInfo().targetSdkVersion >= 23))
    {
      paramContext = (Application)paramContext;
      arrayOfString = d;
      k = arrayOfString.length;
      i = 0;
    }
    while (i < k)
    {
      String str = arrayOfString[i];
      try
      {
        j = dj.b(paramContext.getBaseContext(), "checkSelfPermission", new Object[] { str });
      }
      catch (Throwable localThrowable)
      {
        int j;
        for (;;) {}
      }
      j = 0;
      if (j != 0) {
        return false;
      }
      i += 1;
      continue;
      arrayOfString = d;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (paramContext.checkCallingOrSelfPermission(arrayOfString[i]) != 0) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static float g(String paramString)
    throws NumberFormatException
  {
    return Float.parseFloat(paramString);
  }
  
  public static boolean g(Context paramContext)
  {
    int i = paramContext.getApplicationInfo().targetSdkVersion;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 29) {
      paramContext = (Application)paramContext;
    }
    try
    {
      i = dj.b(paramContext.getBaseContext(), "checkSelfPermission", new Object[] { e });
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    i = 0;
    bool1 = bool2;
    if (i != 0) {
      bool1 = false;
    }
    return bool1;
  }
  
  public static int h(String paramString)
    throws NumberFormatException
  {
    return Integer.parseInt(paramString);
  }
  
  @SuppressLint({"NewApi"})
  public static boolean h(Context paramContext)
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
      boolean bool2 = "true".equals(String.valueOf(dj.a(a, "isScanAlwaysAvailable", new Object[0])));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return bool1;
  }
  
  public static int i(String paramString)
    throws NumberFormatException
  {
    return Integer.parseInt(paramString, 16);
  }
  
  public static String i(Context paramContext)
  {
    NetworkInfo localNetworkInfo = c(paramContext);
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting()))
    {
      paramContext = "UNKNOWN";
      int i = localNetworkInfo.getType();
      if (i == 1) {
        return "WIFI";
      }
      if (i == 0)
      {
        String str = localNetworkInfo.getSubtypeName();
        switch (localNetworkInfo.getSubtype())
        {
        default: 
          if (!"GSM".equalsIgnoreCase(str)) {}
          break;
        case 13: 
          return "4G";
        }
        do
        {
          do
          {
            return "3G";
            return "2G";
          } while (("TD-SCDMA".equalsIgnoreCase(str)) || ("WCDMA".equalsIgnoreCase(str)));
          paramContext = str;
        } while ("CDMA2000".equalsIgnoreCase(str));
      }
      return paramContext;
    }
    return "DISCONNECTED";
  }
  
  public static byte j(String paramString)
    throws NumberFormatException
  {
    return Byte.parseByte(paramString);
  }
  
  public static String j(Context paramContext)
  {
    Object localObject2 = p.n(paramContext);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("00:00:00:00:00:00")) {}
    }
    else
    {
      localObject1 = "00:00:00:00:00:00";
      if (paramContext != null) {
        localObject1 = dm.b(paramContext, "pref", "smac", "00:00:00:00:00:00");
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "00:00:00:00:00:00";
    }
    if (!f)
    {
      if ((paramContext != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        dm.a(paramContext, "pref", "smac", (String)localObject2);
      }
      f = true;
    }
    return (String)localObject2;
  }
  
  public static boolean k(Context paramContext)
  {
    return (Build.VERSION.SDK_INT >= 28) && (paramContext.getApplicationInfo().targetSdkVersion >= 28);
  }
  
  public static boolean l(Context paramContext)
  {
    try
    {
      ComponentName localComponentName = new ComponentName(paramContext, "com.amap.api.location.APSService");
      paramContext = paramContext.getPackageManager().getServiceInfo(localComponentName, 128);
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    return paramContext != null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */