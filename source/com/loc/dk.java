package com.loc;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dk
{
  static AMapLocation g = null;
  static boolean h = false;
  private static List<bu> i = new ArrayList();
  private static JSONArray j = null;
  public SparseArray<Long> a = new SparseArray();
  public int b = -1;
  public long c = 0L;
  String[] d = { "ol", "cl", "gl", "ha", "bs", "ds" };
  public int e = -1;
  public long f = -1L;
  
  public static void a(long paramLong1, long paramLong2)
  {
    try
    {
      if (h) {
        return;
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("gpsTime:");
      localStringBuffer.append(dn.a(paramLong1, "yyyy-MM-dd HH:mm:ss.SSS"));
      localStringBuffer.append(",");
      localStringBuffer.append("sysTime:");
      localStringBuffer.append(dn.a(paramLong2, "yyyy-MM-dd HH:mm:ss.SSS"));
      localStringBuffer.append(",");
      paramLong2 = df.G();
      String str = "0";
      if (0L != paramLong2) {
        str = dn.a(paramLong2, "yyyy-MM-dd HH:mm:ss.SSS");
      }
      localStringBuffer.append("serverTime:");
      localStringBuffer.append(str);
      a("checkgpstime", localStringBuffer.toString());
      if ((0L != paramLong2) && (Math.abs(paramLong1 - paramLong2) < 31536000000L))
      {
        localStringBuffer.append(", correctError");
        a("checkgpstimeerror", localStringBuffer.toString());
      }
      localStringBuffer.delete(0, localStringBuffer.length());
      h = true;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +90 -> 94
    //   7: invokestatic 140	com/loc/df:g	()Z
    //   10: ifne +6 -> 16
    //   13: goto +81 -> 94
    //   16: getstatic 35	com/loc/dk:i	Ljava/util/List;
    //   19: ifnull +45 -> 64
    //   22: getstatic 35	com/loc/dk:i	Ljava/util/List;
    //   25: invokeinterface 145 1 0
    //   30: ifle +34 -> 64
    //   33: new 30	java/util/ArrayList
    //   36: dup
    //   37: invokespecial 33	java/util/ArrayList:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: getstatic 35	com/loc/dk:i	Ljava/util/List;
    //   45: invokeinterface 149 2 0
    //   50: pop
    //   51: aload_1
    //   52: aload_0
    //   53: invokestatic 154	com/loc/bv:a	(Ljava/util/List;Landroid/content/Context;)V
    //   56: getstatic 35	com/loc/dk:i	Ljava/util/List;
    //   59: invokeinterface 157 1 0
    //   64: aload_0
    //   65: invokestatic 159	com/loc/dk:f	(Landroid/content/Context;)V
    //   68: ldc 2
    //   70: monitorexit
    //   71: return
    //   72: astore_0
    //   73: goto +16 -> 89
    //   76: astore_0
    //   77: aload_0
    //   78: ldc -95
    //   80: ldc -93
    //   82: invokestatic 168	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   85: ldc 2
    //   87: monitorexit
    //   88: return
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    //   94: ldc 2
    //   96: monitorexit
    //   97: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   40	12	1	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   7	13	72	finally
    //   16	64	72	finally
    //   64	68	72	finally
    //   77	85	72	finally
    //   7	13	76	java/lang/Throwable
    //   16	64	76	java/lang/Throwable
    //   64	68	76	java/lang/Throwable
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (paramInt1 != -1)
    {
      if (paramInt2 == -1) {
        return;
      }
      if (paramContext != null) {
        try
        {
          if (!df.g()) {
            return;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("param_int_first", paramInt1);
          localJSONObject.put("param_int_second", paramInt2);
          localJSONObject.put("param_long_first", paramLong1);
          localJSONObject.put("param_long_second", paramLong2);
          a(paramContext, "O012", localJSONObject);
          return;
        }
        catch (Throwable paramContext) {}
      }
      try
      {
        dg.a(paramContext, "ReportUtil", "applyStatisticsEx");
        return;
      }
      catch (Throwable paramContext)
      {
        dg.a(paramContext, "ReportUtil", "reportServiceAliveTime");
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramContext != null) {
      try
      {
        if (!df.g()) {
          return;
        }
        int k = Long.valueOf(paramLong).intValue();
        String str = "domestic";
        if (!paramBoolean) {
          str = "abroad";
        }
        if (paramContext != null) {
          try
          {
            if (!df.g()) {
              return;
            }
            JSONObject localJSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
              localJSONObject.put("param_string_first", str);
            }
            if (!TextUtils.isEmpty(null)) {
              localJSONObject.put("param_string_second", null);
            }
            if (k != Integer.MAX_VALUE) {
              localJSONObject.put("param_int_first", k);
            }
            a(paramContext, "O015", localJSONObject);
            return;
          }
          catch (Throwable paramContext)
          {
            dg.a(paramContext, "ReportUtil", "applyStatisticsEx");
          }
        }
        return;
      }
      catch (Throwable paramContext)
      {
        dg.a(paramContext, "ReportUtil", "reportGPSLocUseTime");
      }
    }
  }
  
  /* Error */
  public static void a(Context paramContext, AMapLocation paramAMapLocation)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 232	com/loc/dn:a	(Lcom/amap/api/location/AMapLocation;)Z
    //   7: istore 4
    //   9: iload 4
    //   11: ifne +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: aload_1
    //   19: invokevirtual 237	com/amap/api/location/AMapLocation:getLocationType	()I
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_2
    //   26: tableswitch	default:+312->338, 1:+332->358, 2:+327->353, 3:+312->338, 4:+327->353, 5:+312->338, 6:+312->338, 7:+312->338, 8:+322->348, 9:+317->343
    //   76: iload_3
    //   77: ifeq +234 -> 311
    //   80: getstatic 37	com/loc/dk:j	Lorg/json/JSONArray;
    //   83: ifnonnull +13 -> 96
    //   86: new 239	org/json/JSONArray
    //   89: dup
    //   90: invokespecial 240	org/json/JSONArray:<init>	()V
    //   93: putstatic 37	com/loc/dk:j	Lorg/json/JSONArray;
    //   96: new 171	org/json/JSONObject
    //   99: dup
    //   100: invokespecial 172	org/json/JSONObject:<init>	()V
    //   103: astore 5
    //   105: aload 5
    //   107: ldc -14
    //   109: aload_1
    //   110: invokevirtual 246	com/amap/api/location/AMapLocation:getLongitude	()D
    //   113: invokestatic 249	com/loc/dn:b	(D)D
    //   116: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload 5
    //   122: ldc -2
    //   124: aload_1
    //   125: invokevirtual 257	com/amap/api/location/AMapLocation:getLatitude	()D
    //   128: invokestatic 249	com/loc/dn:b	(D)D
    //   131: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload 5
    //   137: ldc_w 259
    //   140: iload_2
    //   141: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload 5
    //   147: ldc_w 261
    //   150: invokestatic 263	com/loc/dn:a	()J
    //   153: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   156: pop
    //   157: aload_1
    //   158: invokevirtual 266	com/amap/api/location/AMapLocation:getCoordType	()Ljava/lang/String;
    //   161: ldc_w 268
    //   164: invokevirtual 272	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   167: ifeq +16 -> 183
    //   170: aload 5
    //   172: ldc_w 274
    //   175: iconst_1
    //   176: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   179: pop
    //   180: goto +13 -> 193
    //   183: aload 5
    //   185: ldc_w 274
    //   188: iconst_2
    //   189: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   192: pop
    //   193: iload_2
    //   194: ifne +90 -> 284
    //   197: new 171	org/json/JSONObject
    //   200: dup
    //   201: invokespecial 172	org/json/JSONObject:<init>	()V
    //   204: astore 6
    //   206: aload 6
    //   208: ldc_w 276
    //   211: aload_1
    //   212: invokevirtual 280	com/amap/api/location/AMapLocation:getAccuracy	()F
    //   215: f2d
    //   216: invokestatic 282	com/loc/dn:c	(D)D
    //   219: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload 6
    //   225: ldc_w 284
    //   228: aload_1
    //   229: invokevirtual 287	com/amap/api/location/AMapLocation:getAltitude	()D
    //   232: invokestatic 282	com/loc/dn:c	(D)D
    //   235: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   238: pop
    //   239: aload 6
    //   241: ldc_w 289
    //   244: aload_1
    //   245: invokevirtual 292	com/amap/api/location/AMapLocation:getBearing	()F
    //   248: f2d
    //   249: invokestatic 282	com/loc/dn:c	(D)D
    //   252: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload 6
    //   258: ldc_w 294
    //   261: aload_1
    //   262: invokevirtual 297	com/amap/api/location/AMapLocation:getSpeed	()F
    //   265: f2d
    //   266: invokestatic 282	com/loc/dn:c	(D)D
    //   269: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   272: pop
    //   273: aload 5
    //   275: ldc_w 299
    //   278: aload 6
    //   280: invokevirtual 221	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   283: pop
    //   284: getstatic 37	com/loc/dk:j	Lorg/json/JSONArray;
    //   287: aload 5
    //   289: invokevirtual 302	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   292: astore_1
    //   293: aload_1
    //   294: putstatic 37	com/loc/dk:j	Lorg/json/JSONArray;
    //   297: aload_1
    //   298: invokevirtual 303	org/json/JSONArray:length	()I
    //   301: invokestatic 305	com/loc/df:h	()I
    //   304: if_icmplt +7 -> 311
    //   307: aload_0
    //   308: invokestatic 159	com/loc/dk:f	(Landroid/content/Context;)V
    //   311: ldc 2
    //   313: monitorexit
    //   314: return
    //   315: astore_0
    //   316: goto +17 -> 333
    //   319: astore_0
    //   320: aload_0
    //   321: ldc -95
    //   323: ldc_w 307
    //   326: invokestatic 168	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   329: ldc 2
    //   331: monitorexit
    //   332: return
    //   333: ldc 2
    //   335: monitorexit
    //   336: aload_0
    //   337: athrow
    //   338: iconst_0
    //   339: istore_2
    //   340: goto -264 -> 76
    //   343: iconst_2
    //   344: istore_2
    //   345: goto +15 -> 360
    //   348: iconst_3
    //   349: istore_2
    //   350: goto +10 -> 360
    //   353: iconst_1
    //   354: istore_2
    //   355: goto +5 -> 360
    //   358: iconst_0
    //   359: istore_2
    //   360: iconst_1
    //   361: istore_3
    //   362: goto -286 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramContext	Context
    //   0	365	1	paramAMapLocation	AMapLocation
    //   22	338	2	k	int
    //   24	338	3	m	int
    //   7	3	4	bool	boolean
    //   103	185	5	localJSONObject1	JSONObject
    //   204	75	6	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   3	9	315	finally
    //   18	23	315	finally
    //   80	96	315	finally
    //   96	180	315	finally
    //   183	193	315	finally
    //   197	284	315	finally
    //   284	311	315	finally
    //   320	329	315	finally
    //   3	9	319	java/lang/Throwable
    //   18	23	319	java/lang/Throwable
    //   80	96	319	java/lang/Throwable
    //   96	180	319	java/lang/Throwable
    //   183	193	319	java/lang/Throwable
    //   197	284	319	java/lang/Throwable
    //   284	311	319	java/lang/Throwable
  }
  
  public static void a(Context paramContext, AMapLocation paramAMapLocation, d paramd)
  {
    if (paramAMapLocation == null) {
      return;
    }
    for (;;)
    {
      String str;
      int m;
      Object localObject;
      try
      {
        if (!"gps".equalsIgnoreCase(paramAMapLocation.getProvider()))
        {
          if (paramAMapLocation.getLocationType() == 1) {
            return;
          }
          str = "domestic";
          boolean bool = dn.a(paramAMapLocation);
          m = 0;
          if (bool)
          {
            if (dg.a(paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude())) {
              break label438;
            }
            break label433;
          }
          if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(dg.a)) {
            break label438;
          }
          break label433;
          if (paramAMapLocation.getErrorCode() != 0)
          {
            k = paramAMapLocation.getErrorCode();
            if (k == 11) {
              break label462;
            }
          }
        }
        switch (k)
        {
        default: 
          switch (paramAMapLocation.getLocationType())
          {
          default: 
            m = paramAMapLocation.getErrorCode();
            if (paramContext != null) {
              try
              {
                if (!df.g()) {
                  return;
                }
                paramAMapLocation = new JSONObject();
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  paramAMapLocation.put("param_string_first", localObject);
                }
                if (!TextUtils.isEmpty(str)) {
                  paramAMapLocation.put("param_string_second", str);
                }
                if (k != Integer.MAX_VALUE) {
                  paramAMapLocation.put("param_int_first", k);
                }
                if (m != Integer.MAX_VALUE) {
                  paramAMapLocation.put("param_int_second", m);
                }
                if (paramd != null)
                {
                  if (!TextUtils.isEmpty(paramd.c())) {
                    paramAMapLocation.put("dns", paramd.c());
                  }
                  if (!TextUtils.isEmpty(paramd.d())) {
                    paramAMapLocation.put("domain", paramd.d());
                  }
                  if (!TextUtils.isEmpty(paramd.e())) {
                    paramAMapLocation.put("type", paramd.e());
                  }
                  if (!TextUtils.isEmpty(paramd.f())) {
                    paramAMapLocation.put("reason", paramd.f());
                  }
                  if (!TextUtils.isEmpty(paramd.b())) {
                    paramAMapLocation.put("ip", paramd.b());
                  }
                  if (paramd.g() > 0L) {
                    paramAMapLocation.put("ctime", String.valueOf(paramd.g()));
                  }
                  if (paramd.a() > 0L) {
                    paramAMapLocation.put("ntime", String.valueOf(paramd.a()));
                  }
                }
                a(paramContext, "O016", paramAMapLocation);
                return;
              }
              catch (Throwable paramContext)
              {
                dg.a(paramContext, "ReportUtil", "applyStatisticsEx");
              }
            }
            return;
          }
          break;
        }
      }
      catch (Throwable paramContext)
      {
        dg.a(paramContext, "ReportUtil", "reportBatting");
        return;
      }
      label433:
      int k = 1;
      break label440;
      label438:
      k = 0;
      label440:
      if (k != 0)
      {
        str = "abroad";
        continue;
        localObject = "cache";
        k = m;
        continue;
        label462:
        localObject = "net";
        k = m;
        continue;
        localObject = "cache";
        break label486;
        localObject = "net";
        label486:
        k = 1;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    if (paramContext != null) {
      try
      {
        if (!df.g()) {
          return;
        }
        paramString = new bu(paramContext, "loc", "4.8.0", paramString);
        if (paramJSONObject != null) {
          paramString.a(paramJSONObject.toString());
        }
        i.add(paramString);
        if (i.size() >= 30)
        {
          paramString = new ArrayList();
          paramString.addAll(i);
          bv.a(paramString, paramContext);
          i.clear();
        }
        return;
      }
      catch (Throwable paramContext)
      {
        dg.a(paramContext, "ReportUtil", "applyStatistics");
      }
    }
  }
  
  public static void a(AMapLocation paramAMapLocation1, AMapLocation paramAMapLocation2)
  {
    try
    {
      if (g == null)
      {
        if (!dn.a(paramAMapLocation1))
        {
          g = paramAMapLocation2;
          return;
        }
        g = paramAMapLocation1.clone();
      }
      if ((dn.a(g)) && (dn.a(paramAMapLocation2)))
      {
        paramAMapLocation2 = paramAMapLocation2.clone();
        if ((g.getLocationType() != 1) && (g.getLocationType() != 9) && (!"gps".equalsIgnoreCase(g.getProvider())) && (g.getLocationType() != 7) && (paramAMapLocation2.getLocationType() != 1) && (paramAMapLocation2.getLocationType() != 9) && (!"gps".equalsIgnoreCase(paramAMapLocation2.getProvider())) && (paramAMapLocation2.getLocationType() != 7))
        {
          long l2 = Math.abs(paramAMapLocation2.getTime() - g.getTime()) / 1000L;
          long l1 = l2;
          if (l2 <= 0L) {
            l1 = 1L;
          }
          if (l1 <= 1800L)
          {
            float f1 = dn.a(g, paramAMapLocation2);
            float f2 = f1 / (float)l1;
            if ((f1 > 30000.0F) && (f2 > 1000.0F))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(g.getLatitude());
              localStringBuilder.append(",");
              localStringBuilder.append(g.getLongitude());
              localStringBuilder.append(",");
              localStringBuilder.append(g.getAccuracy());
              localStringBuilder.append(",");
              localStringBuilder.append(g.getLocationType());
              localStringBuilder.append(",");
              if (paramAMapLocation1.getTime() != 0L) {
                localStringBuilder.append(dn.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
              } else {
                localStringBuilder.append(g.getTime());
              }
              localStringBuilder.append("#");
              localStringBuilder.append(paramAMapLocation2.getLatitude());
              localStringBuilder.append(",");
              localStringBuilder.append(paramAMapLocation2.getLongitude());
              localStringBuilder.append(",");
              localStringBuilder.append(paramAMapLocation2.getAccuracy());
              localStringBuilder.append(",");
              localStringBuilder.append(paramAMapLocation2.getLocationType());
              localStringBuilder.append(",");
              if (paramAMapLocation2.getTime() != 0L) {
                localStringBuilder.append(dn.a(paramAMapLocation2.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
              } else {
                localStringBuilder.append(paramAMapLocation2.getTime());
              }
              a("bigshiftstatistics", localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
            }
          }
        }
        g = paramAMapLocation2;
      }
      return;
    }
    catch (Throwable paramAMapLocation1) {}
  }
  
  public static void a(String paramString, int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    default: 
      break;
    case 2152: 
      str = "MaybeMockGPSLoc";
      break;
    case 2151: 
      str = "MaybeMockNetLoc";
      break;
    case 2141: 
      str = "NoEnoughStatellites";
      break;
    case 2133: 
      str = "NoCgiAndWifiOff";
      break;
    case 2132: 
      str = "AirPlaneModeAndWifiOff";
      break;
    case 2131: 
      str = "NoCgiOAndWifiInfo";
      break;
    case 2121: 
      str = "NotLocPermission";
      break;
    case 2111: 
      str = "ErrorCgiInfo";
      break;
    case 2103: 
      str = "NotConfigAPSService";
      break;
    case 2102: 
      str = "AuthClientScodeFail";
      break;
    case 2101: 
      str = "BindAPSServiceException";
      break;
    case 2091: 
      str = "InitException";
      break;
    case 2081: 
      str = "LocalLocException";
      break;
    case 2062: 
      str = "ServerLocFail";
      break;
    case 2061: 
      str = "ServerRetypeError";
      break;
    case 2054: 
      str = "ParserDataException";
      break;
    case 2053: 
      str = "DecryptResponseException";
      break;
    case 2052: 
      str = "MaybeIntercepted";
      break;
    case 2051: 
      str = "NeedLoginNetWork\t";
      break;
    case 2041: 
      str = "ResponseResultIsNull";
      break;
    case 2031: 
      str = "CreateApsReqException";
      break;
    case 2022: 
      str = "OnlyOneWifiButNotMain";
      break;
    case 2021: 
      str = "OnlyMainWifi";
      break;
    case 2011: 
      str = "ContextIsNull";
    }
    a(paramString, String.valueOf(paramInt), str);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      aj.b(dg.b(), paramString2, paramString1);
      return;
    }
    catch (Throwable paramString1)
    {
      dg.a(paramString1, "ReportUtil", "reportLog");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      aj.a(dg.b(), "/mobile/binary", paramString3, paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    try
    {
      if ((paramThrowable instanceof k)) {
        aj.a(dg.b(), paramString, (k)paramThrowable);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static boolean a(Context paramContext, v paramv)
  {
    try
    {
      boolean bool = az.b(paramContext, paramv);
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static void f(Context paramContext)
  {
    try
    {
      if ((j != null) && (j.length() > 0))
      {
        bt.a(new bs(paramContext, dg.b(), j.toString()), paramContext);
        j = null;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "ReportUtil", "writeOfflineLocLog");
    }
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.b == paramInt) {
        return;
      }
      if ((this.b != -1) && (this.b != paramInt))
      {
        l1 = dn.b();
        long l2 = this.c;
        long l3 = ((Long)this.a.get(this.b, Long.valueOf(0L))).longValue();
        this.a.append(this.b, Long.valueOf(l1 - l2 + l3));
      }
      long l1 = dm.b(paramContext, "pref", this.d[paramInt], 0L);
      this.c = (dn.b() - l1);
      this.b = paramInt;
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "ReportUtil", "setLocationType");
    }
  }
  
  public final void a(Context paramContext, AMapLocationClientOption paramAMapLocationClientOption)
  {
    for (;;)
    {
      try
      {
        switch (1.a[paramAMapLocationClientOption.getLocationMode().ordinal()])
        {
        default: 
          if (this.e == k) {
            return;
          }
          if ((this.e != -1) && (this.e != k))
          {
            l1 = dn.b();
            long l2 = this.f;
            long l3 = ((Long)this.a.get(this.e, Long.valueOf(0L))).longValue();
            this.a.append(this.e, Long.valueOf(l1 - l2 + l3));
          }
          long l1 = dm.b(paramContext, "pref", this.d[k], 0L);
          this.f = (dn.b() - l1);
          this.e = k;
          return;
        }
      }
      catch (Throwable paramContext)
      {
        dg.a(paramContext, "ReportUtil", "setLocationMode");
        return;
      }
      int k = -1;
      continue;
      k = 3;
      continue;
      k = 5;
      continue;
      k = 4;
    }
  }
  
  public final void b(Context paramContext)
  {
    for (;;)
    {
      int k;
      try
      {
        l1 = dn.b();
        long l2 = this.c;
        if (this.b != -1)
        {
          l3 = ((Long)this.a.get(this.b, Long.valueOf(0L))).longValue();
          this.a.append(this.b, Long.valueOf(l1 - l2 + l3));
        }
        l1 = dn.b();
        l2 = this.f;
        if (this.e == -1) {
          break label213;
        }
        long l3 = ((Long)this.a.get(this.e, Long.valueOf(0L))).longValue();
        this.a.append(this.e, Long.valueOf(l1 - l2 + l3));
      }
      catch (Throwable paramContext)
      {
        long l1;
        dg.a(paramContext, "ReportUtil", "saveLocationTypeAndMode");
        return;
      }
      if (k < this.d.length)
      {
        l1 = ((Long)this.a.get(k, Long.valueOf(0L))).longValue();
        if ((l1 > 0L) && (l1 > dm.b(paramContext, "pref", this.d[k], 0L))) {
          dm.a(paramContext, "pref", this.d[k], l1);
        }
        k += 1;
      }
      else
      {
        return;
        label213:
        k = 0;
      }
    }
  }
  
  public final int c(Context paramContext)
  {
    try
    {
      long l1 = dm.b(paramContext, "pref", this.d[2], 0L);
      long l3 = dm.b(paramContext, "pref", this.d[0], 0L);
      long l2 = dm.b(paramContext, "pref", this.d[1], 0L);
      if ((l1 == 0L) && (l3 == 0L) && (l2 == 0L)) {
        return -1;
      }
      l3 -= l1;
      l2 -= l1;
      if (l1 > l3)
      {
        if (l1 > l2) {
          return 2;
        }
        return 1;
      }
      if (l3 > l2) {
        return 0;
      }
      return 1;
    }
    catch (Throwable paramContext) {}
    return -1;
  }
  
  public final int d(Context paramContext)
  {
    try
    {
      long l1 = dm.b(paramContext, "pref", this.d[3], 0L);
      long l2 = dm.b(paramContext, "pref", this.d[4], 0L);
      long l3 = dm.b(paramContext, "pref", this.d[5], 0L);
      if ((l1 == 0L) && (l2 == 0L) && (l3 == 0L)) {
        return -1;
      }
      if (l1 > l2)
      {
        if (l1 > l3) {
          return 3;
        }
        return 5;
      }
      if (l2 > l3) {
        return 4;
      }
      return 5;
    }
    catch (Throwable paramContext) {}
    return -1;
  }
  
  public final void e(Context paramContext)
  {
    int k = 0;
    try
    {
      while (k < this.d.length)
      {
        dm.a(paramContext, "pref", this.d[k], 0L);
        k += 1;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */