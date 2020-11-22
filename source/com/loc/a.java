package com.loc;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.fence.GeoFenceManagerBase;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
public class a
  implements GeoFenceManagerBase
{
  private static boolean A = false;
  dk a = null;
  Context b = null;
  PendingIntent c = null;
  String d = null;
  GeoFenceListener e = null;
  volatile int f = 1;
  ArrayList<GeoFence> g = new ArrayList();
  c h = null;
  Object i = new Object();
  Object j = new Object();
  a k = null;
  b l = null;
  volatile boolean m = false;
  volatile boolean n = false;
  volatile boolean o = false;
  b p = null;
  c q = null;
  AMapLocationClient r = null;
  volatile AMapLocation s = null;
  long t = 0L;
  AMapLocationClientOption u = null;
  int v = 0;
  AMapLocationListener w = new AMapLocationListener()
  {
    public final void onLocationChanged(AMapLocation paramAnonymousAMapLocation)
    {
      for (;;)
      {
        try
        {
          if (a.this.y) {
            return;
          }
          if (!a.this.o) {
            return;
          }
          a.this.s = paramAnonymousAMapLocation;
          if (paramAnonymousAMapLocation != null)
          {
            j = paramAnonymousAMapLocation.getErrorCode();
            if (paramAnonymousAMapLocation.getErrorCode() == 0)
            {
              a.this.t = dn.b();
              a.this.a(5, null, 0L);
              i = 1;
            }
            else
            {
              i = paramAnonymousAMapLocation.getErrorCode();
              localObject = paramAnonymousAMapLocation.getErrorInfo();
              StringBuilder localStringBuilder = new StringBuilder("locationDetail:");
              localStringBuilder.append(paramAnonymousAMapLocation.getLocationDetail());
              a.a("定位失败", i, (String)localObject, new String[] { localStringBuilder.toString() });
              i = 0;
            }
            if (i != 0)
            {
              a.this.v = 0;
              a.this.a(6, null, 0L);
              return;
            }
            paramAnonymousAMapLocation = new Bundle();
            if (!a.this.m)
            {
              a.this.a(7);
              paramAnonymousAMapLocation.putLong("interval", 2000L);
              a.this.a(8, paramAnonymousAMapLocation, 2000L);
            }
            Object localObject = a.this;
            ((a)localObject).v += 1;
            if (a.this.v >= 3)
            {
              paramAnonymousAMapLocation.putInt("location_errorcode", j);
              a.this.a(1002, paramAnonymousAMapLocation);
            }
            return;
          }
        }
        catch (Throwable paramAnonymousAMapLocation)
        {
          return;
        }
        int i = 0;
        int j = 8;
      }
    }
  };
  final int x = 3;
  volatile boolean y = false;
  private Object z = new Object();
  
  public a(Context paramContext)
  {
    try
    {
      this.b = paramContext.getApplicationContext();
      f();
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "GeoFenceManger", "<init>");
    }
  }
  
  static float a(DPoint paramDPoint, List<DPoint> paramList)
  {
    float f1 = Float.MAX_VALUE;
    float f2 = f1;
    if (paramDPoint != null)
    {
      f2 = f1;
      if (paramList != null)
      {
        f2 = f1;
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          for (;;)
          {
            f2 = f1;
            if (!paramList.hasNext()) {
              break;
            }
            f1 = Math.min(f1, dn.a(paramDPoint, (DPoint)paramList.next()));
          }
        }
      }
    }
    return f2;
  }
  
  private int a(List<GeoFence> paramList)
  {
    try
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((GeoFence)paramList.next());
      }
      return 0;
    }
    catch (Throwable paramList)
    {
      dg.a(paramList, "GeoFenceManager", "addGeoFenceList");
      a("添加围栏失败", 8, paramList.getMessage(), new String[0]);
    }
    return 8;
  }
  
  private static Bundle a(GeoFence paramGeoFence, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localBundle.putString("fenceid", str);
    localBundle.putString("customId", paramString2);
    localBundle.putInt("event", paramInt1);
    localBundle.putInt("location_errorcode", paramInt2);
    localBundle.putParcelable("fence", paramGeoFence);
    return localBundle;
  }
  
  static void a(String paramString1, int paramInt, String paramString2, String... paramVarArgs)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("===========================================\n");
    StringBuilder localStringBuilder = new StringBuilder("              ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("                ");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append("\n");
    localStringBuffer.append("-------------------------------------------\n");
    paramString1 = new StringBuilder("errorCode:");
    paramString1.append(paramInt);
    localStringBuffer.append(paramString1.toString());
    localStringBuffer.append("\n");
    paramString1 = new StringBuilder("错误信息:");
    paramString1.append(paramString2);
    localStringBuffer.append(paramString1.toString());
    localStringBuffer.append("\n");
    if (paramVarArgs.length > 0)
    {
      int i1 = paramVarArgs.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        localStringBuffer.append(paramVarArgs[paramInt]);
        localStringBuffer.append("\n");
        paramInt += 1;
      }
    }
    localStringBuffer.append("===========================================\n");
    Log.i("fenceErrLog", localStringBuffer.toString());
  }
  
  private static boolean a(GeoFence paramGeoFence, int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramInt & 0x1) == 1) {
      bool1 = bool2;
    }
    try
    {
      if (paramGeoFence.getStatus() == 1) {
        bool1 = true;
      }
      bool2 = bool1;
      if ((paramInt & 0x2) == 2)
      {
        bool2 = bool1;
        bool3 = bool1;
        if (paramGeoFence.getStatus() == 2) {
          bool2 = true;
        }
      }
      bool3 = bool2;
      if ((paramInt & 0x4) != 4) {
        break label91;
      }
      bool3 = bool2;
      paramInt = paramGeoFence.getStatus();
      bool3 = bool2;
      if (paramInt != 3) {
        break label91;
      }
      return true;
    }
    catch (Throwable paramGeoFence)
    {
      for (;;) {}
    }
    dg.a(paramGeoFence, "Utils", "remindStatus");
    label91:
    return bool3;
  }
  
  private static boolean a(AMapLocation paramAMapLocation, GeoFence paramGeoFence)
  {
    for (;;)
    {
      try
      {
        if ((dn.a(paramAMapLocation)) && (paramGeoFence != null) && (paramGeoFence.getPointList() != null) && (!paramGeoFence.getPointList().isEmpty())) {}
        Object localObject;
        switch (paramGeoFence.getType())
        {
        case 1: 
        case 3: 
          paramGeoFence = paramGeoFence.getPointList().iterator();
          bool1 = false;
          try
          {
            if (paramGeoFence.hasNext())
            {
              localObject = (List)paramGeoFence.next();
              boolean bool2;
              if (((List)localObject).size() < 3) {
                bool2 = false;
              } else {
                bool2 = dg.a(new DPoint(paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude()), (List)localObject);
              }
              if (bool2) {
                bool1 = true;
              }
            }
            else
            {
              return bool1;
            }
          }
          catch (Throwable paramAMapLocation) {}
        case 0: 
        case 2: 
          localObject = paramGeoFence.getCenter();
          float f1 = paramGeoFence.getRadius();
          float f2 = dn.a(new double[] { ((DPoint)localObject).getLatitude(), ((DPoint)localObject).getLongitude(), paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude() });
          int i1;
          if (f2 <= f1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          return i1 != 0;
        }
      }
      catch (Throwable paramAMapLocation)
      {
        boolean bool1 = false;
        dg.a(paramAMapLocation, "Utils", "isInGeoFence");
        return bool1;
      }
    }
  }
  
  static float b(DPoint paramDPoint, List<DPoint> paramList)
  {
    float f3 = Float.MIN_VALUE;
    float f1 = Float.MIN_VALUE;
    float f2 = f3;
    if (paramDPoint != null)
    {
      f2 = f3;
      if (paramList != null)
      {
        f2 = f3;
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          for (;;)
          {
            f2 = f1;
            if (!paramList.hasNext()) {
              break;
            }
            f1 = Math.max(f1, dn.a(paramDPoint, (DPoint)paramList.next()));
          }
        }
      }
    }
    return f2;
  }
  
  private static DPoint b(List<DPoint> paramList)
  {
    DPoint localDPoint1 = new DPoint();
    if (paramList != null) {
      try
      {
        Iterator localIterator = paramList.iterator();
        double d2 = 0.0D;
        DPoint localDPoint2;
        for (double d1 = 0.0D; localIterator.hasNext(); d1 += localDPoint2.getLongitude())
        {
          localDPoint2 = (DPoint)localIterator.next();
          d2 += localDPoint2.getLatitude();
        }
        int i1 = paramList.size();
        double d3 = i1;
        Double.isNaN(d3);
        d2 /= d3;
        d2 = dn.b(d2);
        i1 = paramList.size();
        d3 = i1;
        Double.isNaN(d3);
        d1 /= d3;
        paramList = new DPoint(d2, dn.b(d1));
        return paramList;
      }
      catch (Throwable paramList)
      {
        dg.a(paramList, "GeoFenceUtil", "getPolygonCenter");
      }
    }
    return localDPoint1;
  }
  
  /* Error */
  private void b(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 209	android/os/Bundle
    //   3: dup
    //   4: invokespecial 210	android/os/Bundle:<init>	()V
    //   7: astore 13
    //   9: iconst_0
    //   10: istore 11
    //   12: iconst_0
    //   13: istore 10
    //   15: iload 10
    //   17: istore 8
    //   19: iload 11
    //   21: istore 9
    //   23: new 90	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 91	java/util/ArrayList:<init>	()V
    //   30: astore 14
    //   32: aload_2
    //   33: ifnull +1027 -> 1060
    //   36: iload 10
    //   38: istore 8
    //   40: iload 11
    //   42: istore 9
    //   44: aload_2
    //   45: invokevirtual 352	android/os/Bundle:isEmpty	()Z
    //   48: ifne +1012 -> 1060
    //   51: iload 10
    //   53: istore 8
    //   55: iload 11
    //   57: istore 9
    //   59: new 90	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 91	java/util/ArrayList:<init>	()V
    //   66: astore 16
    //   68: iload 10
    //   70: istore 8
    //   72: iload 11
    //   74: istore 9
    //   76: aload_2
    //   77: ldc -36
    //   79: invokevirtual 356	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 15
    //   84: iload 10
    //   86: istore 8
    //   88: iload 11
    //   90: istore 9
    //   92: aload_2
    //   93: ldc_w 358
    //   96: invokevirtual 356	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 18
    //   101: iload 10
    //   103: istore 8
    //   105: iload 11
    //   107: istore 9
    //   109: aload_2
    //   110: ldc_w 360
    //   113: invokevirtual 356	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 19
    //   118: iload 10
    //   120: istore 8
    //   122: iload 11
    //   124: istore 9
    //   126: aload_2
    //   127: ldc_w 362
    //   130: invokevirtual 356	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 20
    //   135: iload 10
    //   137: istore 8
    //   139: iload 11
    //   141: istore 9
    //   143: aload_2
    //   144: ldc_w 364
    //   147: invokevirtual 368	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   150: checkcast 171	com/amap/api/location/DPoint
    //   153: astore 21
    //   155: iload 10
    //   157: istore 8
    //   159: iload 11
    //   161: istore 9
    //   163: aload_2
    //   164: ldc_w 370
    //   167: bipush 10
    //   169: invokevirtual 374	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   172: istore 12
    //   174: iload 10
    //   176: istore 8
    //   178: iload 11
    //   180: istore 9
    //   182: aload_2
    //   183: ldc_w 376
    //   186: ldc_w 377
    //   189: invokevirtual 381	android/os/Bundle:getFloat	(Ljava/lang/String;F)F
    //   192: fstore 7
    //   194: iload 10
    //   196: istore 8
    //   198: iload 11
    //   200: istore 9
    //   202: aload 18
    //   204: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifeq +932 -> 1139
    //   210: goto +923 -> 1133
    //   213: iload 10
    //   215: istore 8
    //   217: iload 11
    //   219: istore 9
    //   221: aload 21
    //   223: invokevirtual 324	com/amap/api/location/DPoint:getLatitude	()D
    //   226: ldc2_w 387
    //   229: dcmpl
    //   230: ifgt +63 -> 293
    //   233: iload 10
    //   235: istore 8
    //   237: iload 11
    //   239: istore 9
    //   241: aload 21
    //   243: invokevirtual 324	com/amap/api/location/DPoint:getLatitude	()D
    //   246: ldc2_w 389
    //   249: dcmpg
    //   250: iflt +43 -> 293
    //   253: iload 10
    //   255: istore 8
    //   257: iload 11
    //   259: istore 9
    //   261: aload 21
    //   263: invokevirtual 325	com/amap/api/location/DPoint:getLongitude	()D
    //   266: ldc2_w 391
    //   269: dcmpl
    //   270: ifgt +23 -> 293
    //   273: iload 10
    //   275: istore 8
    //   277: iload 11
    //   279: istore 9
    //   281: aload 21
    //   283: invokevirtual 325	com/amap/api/location/DPoint:getLongitude	()D
    //   286: ldc2_w 393
    //   289: dcmpg
    //   290: ifge +885 -> 1175
    //   293: iload 10
    //   295: istore 8
    //   297: iload 11
    //   299: istore 9
    //   301: new 245	java/lang/StringBuilder
    //   304: dup
    //   305: ldc_w 396
    //   308: invokespecial 250	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: astore_2
    //   312: iload 10
    //   314: istore 8
    //   316: iload 11
    //   318: istore 9
    //   320: aload_2
    //   321: aload 21
    //   323: invokevirtual 324	com/amap/api/location/DPoint:getLatitude	()D
    //   326: invokevirtual 399	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: iload 10
    //   332: istore 8
    //   334: iload 11
    //   336: istore 9
    //   338: aload_2
    //   339: ldc_w 401
    //   342: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: iload 10
    //   348: istore 8
    //   350: iload 11
    //   352: istore 9
    //   354: aload_2
    //   355: aload 21
    //   357: invokevirtual 325	com/amap/api/location/DPoint:getLongitude	()D
    //   360: invokevirtual 399	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: iload 10
    //   366: istore 8
    //   368: iload 11
    //   370: istore 9
    //   372: ldc -60
    //   374: iconst_0
    //   375: aload_2
    //   376: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: iconst_0
    //   380: anewarray 202	java/lang/String
    //   383: invokestatic 205	com/loc/a:a	(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)V
    //   386: goto +747 -> 1133
    //   389: iload 10
    //   391: istore 8
    //   393: iload 11
    //   395: istore 9
    //   397: aload 20
    //   399: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   402: ifeq +773 -> 1175
    //   405: goto +728 -> 1133
    //   408: iload 8
    //   410: ifeq +810 -> 1220
    //   413: iload 10
    //   415: istore 8
    //   417: iload 11
    //   419: istore 9
    //   421: new 209	android/os/Bundle
    //   424: dup
    //   425: invokespecial 210	android/os/Bundle:<init>	()V
    //   428: astore 17
    //   430: iload 10
    //   432: istore 8
    //   434: iload 11
    //   436: istore 9
    //   438: aload 17
    //   440: ldc -36
    //   442: aload 15
    //   444: invokevirtual 218	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: iload 10
    //   449: istore 8
    //   451: iload 11
    //   453: istore 9
    //   455: aload 17
    //   457: ldc_w 403
    //   460: aload_0
    //   461: getfield 82	com/loc/a:d	Ljava/lang/String;
    //   464: invokevirtual 218	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload 17
    //   469: ldc_w 405
    //   472: ldc2_w 406
    //   475: invokevirtual 411	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   478: aload 17
    //   480: ldc_w 413
    //   483: aload_0
    //   484: getfield 88	com/loc/a:f	I
    //   487: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   490: iload_1
    //   491: tableswitch	default:+25->516, 1:+123->614, 2:+46->537, 3:+30->521
    //   516: aconst_null
    //   517: astore_2
    //   518: goto +132 -> 650
    //   521: aload_0
    //   522: getfield 78	com/loc/a:b	Landroid/content/Context;
    //   525: ldc_w 415
    //   528: aload 18
    //   530: invokestatic 420	com/loc/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   533: astore_2
    //   534: goto +116 -> 650
    //   537: aload 21
    //   539: invokevirtual 324	com/amap/api/location/DPoint:getLatitude	()D
    //   542: invokestatic 345	com/loc/dn:b	(D)D
    //   545: dstore_3
    //   546: aload 21
    //   548: invokevirtual 325	com/amap/api/location/DPoint:getLongitude	()D
    //   551: invokestatic 345	com/loc/dn:b	(D)D
    //   554: dstore 5
    //   556: fload 7
    //   558: invokestatic 426	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   561: invokevirtual 429	java/lang/Float:intValue	()I
    //   564: istore 8
    //   566: aload 17
    //   568: ldc_w 431
    //   571: ldc_w 432
    //   574: invokevirtual 436	android/os/Bundle:putFloat	(Ljava/lang/String;F)V
    //   577: aload_0
    //   578: getfield 78	com/loc/a:b	Landroid/content/Context;
    //   581: ldc_w 438
    //   584: aload 18
    //   586: aload 20
    //   588: iload 12
    //   590: invokestatic 441	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   593: dload_3
    //   594: invokestatic 444	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   597: dload 5
    //   599: invokestatic 444	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   602: iload 8
    //   604: invokestatic 441	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   607: invokestatic 447	com/loc/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   610: astore_2
    //   611: goto +39 -> 650
    //   614: aload 17
    //   616: ldc_w 431
    //   619: ldc_w 448
    //   622: invokevirtual 436	android/os/Bundle:putFloat	(Ljava/lang/String;F)V
    //   625: aload_0
    //   626: getfield 78	com/loc/a:b	Landroid/content/Context;
    //   629: ldc_w 450
    //   632: aload 18
    //   634: aload 20
    //   636: aload 19
    //   638: iload 12
    //   640: invokestatic 441	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   643: invokestatic 453	com/loc/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   646: astore_2
    //   647: goto +3 -> 650
    //   650: iconst_4
    //   651: istore 8
    //   653: aload_2
    //   654: ifnull +546 -> 1200
    //   657: iconst_1
    //   658: iload_1
    //   659: if_icmpne +529 -> 1188
    //   662: aload_2
    //   663: aload 16
    //   665: aload 17
    //   667: invokestatic 458	com/loc/c:a	(Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)I
    //   670: istore 8
    //   672: goto +3 -> 675
    //   675: iconst_2
    //   676: iload_1
    //   677: if_icmpne +13 -> 690
    //   680: aload_2
    //   681: aload 16
    //   683: aload 17
    //   685: invokestatic 458	com/loc/c:a	(Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)I
    //   688: istore 8
    //   690: iconst_3
    //   691: iload_1
    //   692: if_icmpne +502 -> 1194
    //   695: aload_0
    //   696: getfield 113	com/loc/a:q	Lcom/loc/c;
    //   699: aload_2
    //   700: aload 16
    //   702: aload 17
    //   704: invokevirtual 460	com/loc/c:b	(Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)I
    //   707: istore 8
    //   709: goto +3 -> 712
    //   712: iload 8
    //   714: sipush 10000
    //   717: if_icmpne +53 -> 770
    //   720: aload 16
    //   722: invokeinterface 156 1 0
    //   727: ifeq +9 -> 736
    //   730: bipush 16
    //   732: istore_1
    //   733: goto +293 -> 1026
    //   736: aload_0
    //   737: aload 16
    //   739: invokespecial 462	com/loc/a:a	(Ljava/util/List;)I
    //   742: istore_1
    //   743: iload_1
    //   744: ifne +20 -> 764
    //   747: iload_1
    //   748: istore 8
    //   750: iload_1
    //   751: istore 9
    //   753: aload 14
    //   755: aload 16
    //   757: invokevirtual 466	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   760: pop
    //   761: goto +265 -> 1026
    //   764: iload_1
    //   765: istore 8
    //   767: goto +433 -> 1200
    //   770: bipush 7
    //   772: istore_1
    //   773: iload 8
    //   775: iconst_1
    //   776: if_icmpeq +201 -> 977
    //   779: iload 8
    //   781: bipush 7
    //   783: if_icmpeq +194 -> 977
    //   786: iload 8
    //   788: tableswitch	default:+24->812, 4:+189->977, 5:+189->977
    //   812: iload 8
    //   814: tableswitch	default:+22->836, 16:+163->977, 17:+163->977
    //   836: iload 8
    //   838: tableswitch	default:+86->924, 10000:+134->972, 10001:+142->980, 10002:+142->980, 10003:+129->967, 10004:+129->967, 10005:+129->967, 10006:+129->967, 10007:+142->980, 10008:+142->980, 10009:+142->980, 10010:+129->967, 10011:+129->967, 10012:+142->980, 10013:+142->980, 10014:+129->967, 10015:+129->967, 10016:+129->967, 10017:+129->967
    //   924: iload 8
    //   926: tableswitch	default:+30->956, 20000:+36->962, 20001:+36->962, 20002:+36->962, 20003:+30->956
    //   956: bipush 8
    //   958: istore_1
    //   959: goto +21 -> 980
    //   962: iconst_1
    //   963: istore_1
    //   964: goto +16 -> 980
    //   967: iconst_4
    //   968: istore_1
    //   969: goto +11 -> 980
    //   972: iconst_0
    //   973: istore_1
    //   974: goto +6 -> 980
    //   977: iload 8
    //   979: istore_1
    //   980: iload_1
    //   981: ifeq +216 -> 1197
    //   984: new 245	java/lang/StringBuilder
    //   987: dup
    //   988: ldc_w 468
    //   991: invokespecial 250	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   994: astore_2
    //   995: aload_2
    //   996: iload_1
    //   997: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: aload_2
    //   1002: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: astore_2
    //   1006: iconst_0
    //   1007: istore 9
    //   1009: iconst_0
    //   1010: istore 8
    //   1012: ldc -60
    //   1014: iload_1
    //   1015: aload_2
    //   1016: iconst_0
    //   1017: anewarray 202	java/lang/String
    //   1020: invokestatic 205	com/loc/a:a	(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)V
    //   1023: goto +174 -> 1197
    //   1026: iload_1
    //   1027: istore 8
    //   1029: iload_1
    //   1030: istore 9
    //   1032: aload 13
    //   1034: ldc -36
    //   1036: aload 15
    //   1038: invokevirtual 218	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1041: iload_1
    //   1042: istore 8
    //   1044: iload_1
    //   1045: istore 9
    //   1047: aload 13
    //   1049: ldc_w 470
    //   1052: aload 14
    //   1054: invokevirtual 474	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1057: goto +5 -> 1062
    //   1060: iconst_1
    //   1061: istore_1
    //   1062: aload 13
    //   1064: ldc_w 476
    //   1067: iload_1
    //   1068: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1071: aload_0
    //   1072: sipush 1000
    //   1075: aload 13
    //   1077: invokevirtual 478	com/loc/a:a	(ILandroid/os/Bundle;)V
    //   1080: return
    //   1081: astore_2
    //   1082: goto +30 -> 1112
    //   1085: astore_2
    //   1086: iload 9
    //   1088: istore 8
    //   1090: aload_2
    //   1091: ldc -64
    //   1093: ldc_w 480
    //   1096: invokestatic 148	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1099: aload 13
    //   1101: ldc_w 476
    //   1104: bipush 8
    //   1106: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1109: goto -38 -> 1071
    //   1112: aload 13
    //   1114: ldc_w 476
    //   1117: iload 8
    //   1119: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1122: aload_0
    //   1123: sipush 1000
    //   1126: aload 13
    //   1128: invokevirtual 478	com/loc/a:a	(ILandroid/os/Bundle;)V
    //   1131: aload_2
    //   1132: athrow
    //   1133: iconst_0
    //   1134: istore 8
    //   1136: goto -728 -> 408
    //   1139: iload_1
    //   1140: tableswitch	default:+24->1164, 1:+-751->389, 2:+27->1167
    //   1164: goto +11 -> 1175
    //   1167: aload 21
    //   1169: ifnonnull -956 -> 213
    //   1172: goto -39 -> 1133
    //   1175: iconst_1
    //   1176: istore 8
    //   1178: goto -770 -> 408
    //   1181: astore_2
    //   1182: iconst_0
    //   1183: istore 8
    //   1185: goto -73 -> 1112
    //   1188: iconst_0
    //   1189: istore 8
    //   1191: goto -516 -> 675
    //   1194: goto -482 -> 712
    //   1197: goto -171 -> 1026
    //   1200: iload 8
    //   1202: istore_1
    //   1203: goto -177 -> 1026
    //   1206: astore_2
    //   1207: iconst_0
    //   1208: istore 8
    //   1210: goto -128 -> 1082
    //   1213: astore_2
    //   1214: iconst_0
    //   1215: istore 8
    //   1217: goto -127 -> 1090
    //   1220: iconst_1
    //   1221: istore_1
    //   1222: goto -196 -> 1026
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1225	0	this	a
    //   0	1225	1	paramInt	int
    //   0	1225	2	paramBundle	Bundle
    //   545	49	3	d1	double
    //   554	44	5	d2	double
    //   192	365	7	f1	float
    //   17	1199	8	i1	int
    //   21	1066	9	i2	int
    //   13	435	10	i3	int
    //   10	442	11	i4	int
    //   172	467	12	i5	int
    //   7	1120	13	localBundle1	Bundle
    //   30	1023	14	localArrayList1	ArrayList
    //   82	955	15	str1	String
    //   66	690	16	localArrayList2	ArrayList
    //   428	275	17	localBundle2	Bundle
    //   99	534	18	str2	String
    //   116	521	19	str3	String
    //   133	502	20	str4	String
    //   153	1015	21	localDPoint	DPoint
    // Exception table:
    //   from	to	target	type
    //   23	32	1081	finally
    //   44	51	1081	finally
    //   59	68	1081	finally
    //   76	84	1081	finally
    //   92	101	1081	finally
    //   109	118	1081	finally
    //   126	135	1081	finally
    //   143	155	1081	finally
    //   163	174	1081	finally
    //   182	194	1081	finally
    //   202	210	1081	finally
    //   221	233	1081	finally
    //   241	253	1081	finally
    //   261	273	1081	finally
    //   281	293	1081	finally
    //   301	312	1081	finally
    //   320	330	1081	finally
    //   338	346	1081	finally
    //   354	364	1081	finally
    //   372	386	1081	finally
    //   397	405	1081	finally
    //   421	430	1081	finally
    //   438	447	1081	finally
    //   455	467	1081	finally
    //   753	761	1081	finally
    //   1012	1023	1081	finally
    //   1032	1041	1081	finally
    //   1047	1057	1081	finally
    //   1090	1099	1081	finally
    //   23	32	1085	java/lang/Throwable
    //   44	51	1085	java/lang/Throwable
    //   59	68	1085	java/lang/Throwable
    //   76	84	1085	java/lang/Throwable
    //   92	101	1085	java/lang/Throwable
    //   109	118	1085	java/lang/Throwable
    //   126	135	1085	java/lang/Throwable
    //   143	155	1085	java/lang/Throwable
    //   163	174	1085	java/lang/Throwable
    //   182	194	1085	java/lang/Throwable
    //   202	210	1085	java/lang/Throwable
    //   221	233	1085	java/lang/Throwable
    //   241	253	1085	java/lang/Throwable
    //   261	273	1085	java/lang/Throwable
    //   281	293	1085	java/lang/Throwable
    //   301	312	1085	java/lang/Throwable
    //   320	330	1085	java/lang/Throwable
    //   338	346	1085	java/lang/Throwable
    //   354	364	1085	java/lang/Throwable
    //   372	386	1085	java/lang/Throwable
    //   397	405	1085	java/lang/Throwable
    //   421	430	1085	java/lang/Throwable
    //   438	447	1085	java/lang/Throwable
    //   455	467	1085	java/lang/Throwable
    //   753	761	1085	java/lang/Throwable
    //   1012	1023	1085	java/lang/Throwable
    //   1032	1041	1085	java/lang/Throwable
    //   1047	1057	1085	java/lang/Throwable
    //   521	534	1181	finally
    //   537	611	1181	finally
    //   614	647	1181	finally
    //   662	672	1181	finally
    //   680	690	1181	finally
    //   695	709	1181	finally
    //   720	730	1181	finally
    //   736	743	1181	finally
    //   467	490	1206	finally
    //   984	1006	1206	finally
    //   467	490	1213	java/lang/Throwable
    //   521	534	1213	java/lang/Throwable
    //   537	611	1213	java/lang/Throwable
    //   614	647	1213	java/lang/Throwable
    //   662	672	1213	java/lang/Throwable
    //   680	690	1213	java/lang/Throwable
    //   695	709	1213	java/lang/Throwable
    //   720	730	1213	java/lang/Throwable
    //   736	743	1213	java/lang/Throwable
    //   984	1006	1213	java/lang/Throwable
  }
  
  private static boolean b(AMapLocation paramAMapLocation, GeoFence paramGeoFence)
  {
    boolean bool = true;
    try
    {
      if (a(paramAMapLocation, paramGeoFence))
      {
        if (paramGeoFence.getEnterTime() == -1L)
        {
          if (paramGeoFence.getStatus() != 1)
          {
            paramGeoFence.setEnterTime(dn.b());
            paramGeoFence.setStatus(1);
            return true;
          }
        }
        else if ((paramGeoFence.getStatus() != 3) && (dn.b() - paramGeoFence.getEnterTime() > 600000L))
        {
          paramGeoFence.setStatus(3);
          return true;
        }
      }
      else
      {
        int i1 = paramGeoFence.getStatus();
        if (i1 != 2) {
          try
          {
            paramGeoFence.setStatus(2);
            paramGeoFence.setEnterTime(-1L);
            return true;
          }
          catch (Throwable paramAMapLocation) {}
        }
      }
      return false;
    }
    catch (Throwable paramAMapLocation)
    {
      bool = false;
      dg.a(paramAMapLocation, "Utils", "isFenceStatusChanged");
    }
    return bool;
  }
  
  private void f()
  {
    if (!this.o) {
      this.o = true;
    }
    if (this.n) {
      return;
    }
    try
    {
      if (Looper.myLooper() == null) {}
      for (c localc = new c(this.b.getMainLooper());; localc = new c())
      {
        this.h = localc;
        break;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      dg.a(localThrowable1, "GeoFenceManger", "init 1");
      try
      {
        this.l = new b("fenceActionThread");
        this.l.setPriority(5);
        this.l.start();
        this.k = new a(this.l.getLooper());
      }
      catch (Throwable localThrowable2)
      {
        dg.a(localThrowable2, "GeoFenceManger", "init 2");
      }
      try
      {
        this.p = new b(this.b);
        this.q = new c();
        this.u = new AMapLocationClientOption();
        this.r = new AMapLocationClient(this.b);
        this.u.setLocationCacheEnable(true);
        this.u.setNeedAddress(false);
        this.r.setLocationListener(this.w);
        if (this.a == null) {
          this.a = new dk();
        }
      }
      catch (Throwable localThrowable3)
      {
        dg.a(localThrowable3, "GeoFenceManger", "initBase");
      }
      this.n = true;
      try
      {
        if ((this.d != null) && (this.c == null)) {
          createPendingIntent(this.d);
        }
      }
      catch (Throwable localThrowable4)
      {
        dg.a(localThrowable4, "GeoFenceManger", "init 4");
      }
      if (!A)
      {
        A = true;
        dk.a(this.b, "O020", null);
      }
    }
  }
  
  final int a(GeoFence paramGeoFence)
  {
    try
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      if (!this.g.contains(paramGeoFence))
      {
        this.g.add(paramGeoFence);
        return 0;
      }
      return 17;
    }
    catch (Throwable paramGeoFence)
    {
      dg.a(paramGeoFence, "GeoFenceManager", "addGeoFence2List");
      a("添加围栏失败", 8, paramGeoFence.getMessage(), new String[0]);
    }
    return 8;
  }
  
  final GeoFence a(Bundle paramBundle, boolean paramBoolean)
  {
    GeoFence localGeoFence = new GeoFence();
    ArrayList localArrayList = new ArrayList();
    DPoint localDPoint = new DPoint();
    if (paramBoolean)
    {
      localGeoFence.setType(1);
      localArrayList = paramBundle.getParcelableArrayList("pointList");
      if (localArrayList != null) {
        localDPoint = b(localArrayList);
      }
      localGeoFence.setMaxDis2Center(b(localDPoint, localArrayList));
      localGeoFence.setMinDis2Center(a(localDPoint, localArrayList));
    }
    else
    {
      localGeoFence.setType(0);
      localDPoint = (DPoint)paramBundle.getParcelable("centerPoint");
      if (localDPoint != null) {
        localArrayList.add(localDPoint);
      }
      float f2 = paramBundle.getFloat("fenceRadius", 1000.0F);
      float f1 = f2;
      if (f2 <= 0.0F) {
        f1 = 1000.0F;
      }
      localGeoFence.setRadius(f1);
      localGeoFence.setMinDis2Center(f1);
      localGeoFence.setMaxDis2Center(f1);
    }
    localGeoFence.setActivatesAction(this.f);
    localGeoFence.setCustomId(paramBundle.getString("customId"));
    paramBundle = new ArrayList();
    paramBundle.add(localArrayList);
    localGeoFence.setPointList(paramBundle);
    localGeoFence.setCenter(localDPoint);
    localGeoFence.setPendingIntentAction(this.d);
    localGeoFence.setExpiration(-1L);
    localGeoFence.setPendingIntent(this.c);
    paramBundle = new StringBuilder();
    paramBundle.append(c.a());
    localGeoFence.setFenceId(paramBundle.toString());
    if (this.a != null) {
      this.a.a(this.b, 2);
    }
    return localGeoFence;
  }
  
  final void a()
  {
    try
    {
      if (!this.n) {
        return;
      }
      if (this.g != null)
      {
        this.g.clear();
        this.g = null;
      }
      boolean bool = this.o;
      if (bool) {
        return;
      }
      try
      {
        synchronized (this.i)
        {
          if (this.k != null) {
            this.k.removeCallbacksAndMessages(null);
          }
          this.k = null;
        }
        this.m = false;
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "GeoFenceManager", "destroyActionHandler");
        if (this.r != null)
        {
          this.r.stopLocation();
          this.r.onDestroy();
        }
        this.r = null;
        if (this.l != null) {
          if (Build.VERSION.SDK_INT >= 18) {
            this.l.quitSafely();
          } else {
            this.l.quit();
          }
        }
        this.l = null;
        this.p = null;
        synchronized (this.z)
        {
          if (this.c != null) {
            this.c.cancel();
          }
          this.c = null;
          try
          {
            synchronized (this.j)
            {
              if (this.h != null) {
                this.h.removeCallbacksAndMessages(null);
              }
              this.h = null;
            }
            if (this.a == null) {
              break label255;
            }
          }
          catch (Throwable localThrowable2)
          {
            dg.a(localThrowable2, "GeoFenceManager", "destroyResultHandler");
          }
          this.a.b(this.b);
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      label255:
      for (;;) {}
    }
    this.n = false;
  }
  
  final void a(int paramInt)
  {
    try
    {
      synchronized (this.i)
      {
        if (this.k != null) {
          this.k.removeMessages(paramInt);
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceManager", "removeActionHandlerMessage");
    }
  }
  
  final void a(int paramInt, Bundle paramBundle)
  {
    try
    {
      synchronized (this.j)
      {
        if (this.h != null)
        {
          Message localMessage = this.h.obtainMessage();
          localMessage.what = paramInt;
          localMessage.setData(paramBundle);
          this.h.sendMessage(localMessage);
        }
        return;
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      dg.a(paramBundle, "GeoFenceManager", "sendResultHandlerMessage");
    }
  }
  
  final void a(int paramInt, Bundle paramBundle, long paramLong)
  {
    try
    {
      synchronized (this.i)
      {
        if (this.k != null)
        {
          Message localMessage = this.k.obtainMessage();
          localMessage.what = paramInt;
          localMessage.setData(paramBundle);
          this.k.sendMessageDelayed(localMessage, paramLong);
        }
        return;
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      dg.a(paramBundle, "GeoFenceManager", "sendActionHandlerMessage");
    }
  }
  
  final void a(Bundle paramBundle)
  {
    int i1 = 1;
    if (paramBundle != null) {}
    try
    {
      i1 = paramBundle.getInt("activatesAction", 1);
      if (this.f != i1)
      {
        if ((this.g != null) && (!this.g.isEmpty()))
        {
          paramBundle = this.g.iterator();
          while (paramBundle.hasNext())
          {
            GeoFence localGeoFence = (GeoFence)paramBundle.next();
            localGeoFence.setStatus(0);
            localGeoFence.setEnterTime(-1L);
          }
        }
        b();
      }
      this.f = i1;
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;) {}
    }
    dg.a(paramBundle, "GeoFenceManager", "doSetActivatesAction");
  }
  
  final void a(AMapLocation paramAMapLocation)
  {
    try
    {
      if (this.y) {
        return;
      }
      if (this.g != null)
      {
        if (this.g.isEmpty()) {
          return;
        }
        if ((paramAMapLocation != null) && (paramAMapLocation.getErrorCode() == 0))
        {
          Iterator localIterator = this.g.iterator();
          while (localIterator.hasNext())
          {
            GeoFence localGeoFence = (GeoFence)localIterator.next();
            if ((localGeoFence.isAble()) && (b(paramAMapLocation, localGeoFence)) && (a(localGeoFence, this.f)))
            {
              localGeoFence.setCurrentLocation(paramAMapLocation);
              Bundle localBundle = new Bundle();
              localBundle.putParcelable("geoFence", localGeoFence);
              a(1001, localBundle);
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramAMapLocation)
    {
      dg.a(paramAMapLocation, "GeoFenceManager", "doCheckFence");
    }
  }
  
  public void addDistrictGeoFence(String paramString1, String paramString2)
  {
    try
    {
      f();
      Bundle localBundle = new Bundle();
      localBundle.putString("keyWords", paramString1);
      localBundle.putString("customId", paramString2);
      a(4, localBundle, 0L);
      return;
    }
    catch (Throwable paramString1)
    {
      dg.a(paramString1, "GeoFenceManager", "addDistricetGeoFence");
    }
  }
  
  public void addKeywordGeoFence(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    for (;;)
    {
      int i1;
      try
      {
        f();
        i1 = paramInt;
        if (paramInt > 0) {
          break label95;
        }
        i1 = 10;
      }
      catch (Throwable paramString1)
      {
        Bundle localBundle;
        dg.a(paramString1, "GeoFenceManager", "addKeywordGeoFence");
        return;
      }
      localBundle = new Bundle();
      localBundle.putString("keyWords", paramString1);
      localBundle.putString("poiType", paramString2);
      localBundle.putString("city", paramString3);
      localBundle.putInt("searchSize", paramInt);
      localBundle.putString("customId", paramString4);
      a(2, localBundle, 0L);
      return;
      label95:
      paramInt = i1;
      if (i1 > 25) {
        paramInt = 25;
      }
    }
  }
  
  public void addNearbyGeoFence(String paramString1, String paramString2, DPoint paramDPoint, float paramFloat, int paramInt, String paramString3)
  {
    for (;;)
    {
      try
      {
        f();
        if (paramFloat <= 0.0F) {
          break label112;
        }
        f1 = paramFloat;
        if (paramFloat <= 50000.0F) {
          break label117;
        }
      }
      catch (Throwable paramString1)
      {
        Bundle localBundle;
        dg.a(paramString1, "GeoFenceManager", "addNearbyGeoFence");
        return;
      }
      localBundle = new Bundle();
      localBundle.putString("keyWords", paramString1);
      localBundle.putString("poiType", paramString2);
      localBundle.putParcelable("centerPoint", paramDPoint);
      localBundle.putFloat("aroundRadius", f1);
      localBundle.putInt("searchSize", paramInt);
      localBundle.putString("customId", paramString3);
      a(3, localBundle, 0L);
      return;
      label112:
      float f1 = 3000.0F;
      label117:
      int i1 = paramInt;
      if (paramInt <= 0) {
        i1 = 10;
      }
      paramInt = i1;
      if (i1 > 25) {
        paramInt = 25;
      }
    }
  }
  
  public void addPolygonGeoFence(List<DPoint> paramList, String paramString)
  {
    try
    {
      f();
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("pointList", new ArrayList(paramList));
      localBundle.putString("customId", paramString);
      a(1, localBundle, 0L);
      return;
    }
    catch (Throwable paramList)
    {
      dg.a(paramList, "GeoFenceManager", "addPolygonGeoFence");
    }
  }
  
  public void addRoundGeoFence(DPoint paramDPoint, float paramFloat, String paramString)
  {
    try
    {
      f();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("centerPoint", paramDPoint);
      localBundle.putFloat("fenceRadius", paramFloat);
      localBundle.putString("customId", paramString);
      a(0, localBundle, 0L);
      return;
    }
    catch (Throwable paramDPoint)
    {
      dg.a(paramDPoint, "GeoFenceManager", "addRoundGeoFence");
    }
  }
  
  final void b()
  {
    if (this.y) {
      return;
    }
    if (this.k != null)
    {
      int i2 = 0;
      int i1 = i2;
      if (this.s != null)
      {
        i1 = i2;
        if (dn.a(this.s))
        {
          i1 = i2;
          if (dn.b() - this.t < 10000L) {
            i1 = 1;
          }
        }
      }
      if (i1 != 0)
      {
        a(6, null, 0L);
        a(5, null, 0L);
        return;
      }
      a(7);
      a(7, null, 0L);
    }
  }
  
  final void b(int paramInt)
  {
    try
    {
      if (this.b != null) {
        synchronized (this.z)
        {
          if (this.c == null) {
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtras(a(null, null, null, 4, paramInt));
          this.c.send(this.b, 0, localIntent);
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceManager", "resultRemindLocationError");
    }
  }
  
  final void b(Bundle paramBundle)
  {
    b(2, paramBundle);
  }
  
  final void b(GeoFence paramGeoFence)
  {
    try
    {
      synchronized (this.z)
      {
        if (this.b != null)
        {
          if ((this.c == null) && (paramGeoFence.getPendingIntent() == null)) {
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtras(a(paramGeoFence, paramGeoFence.getFenceId(), paramGeoFence.getCustomId(), paramGeoFence.getStatus(), 0));
          if (this.d != null) {
            localIntent.setAction(this.d);
          }
          localIntent.setPackage(l.c(this.b));
          PendingIntent localPendingIntent;
          if (paramGeoFence.getPendingIntent() != null) {
            localPendingIntent = paramGeoFence.getPendingIntent();
          }
          for (paramGeoFence = this.b;; paramGeoFence = this.b)
          {
            localPendingIntent.send(paramGeoFence, 0, localIntent);
            break;
            localPendingIntent = this.c;
          }
        }
        return;
      }
      return;
    }
    catch (Throwable paramGeoFence)
    {
      dg.a(paramGeoFence, "GeoFenceManager", "resultTriggerGeoFence");
    }
  }
  
  final void c()
  {
    try
    {
      if (this.m) {
        a(8);
      }
      if (this.r != null) {
        this.r.stopLocation();
      }
      this.m = false;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  final void c(Bundle paramBundle)
  {
    b(1, paramBundle);
  }
  
  public PendingIntent createPendingIntent(String paramString)
  {
    try
    {
      synchronized (this.z)
      {
        Object localObject2 = new Intent(paramString);
        ((Intent)localObject2).setPackage(l.c(this.b));
        this.c = PendingIntent.getBroadcast(this.b, 0, (Intent)localObject2, 0);
        this.d = paramString;
        if ((this.g != null) && (!this.g.isEmpty()))
        {
          paramString = this.g.iterator();
          if (paramString.hasNext())
          {
            localObject2 = (GeoFence)paramString.next();
            ((GeoFence)localObject2).setPendingIntent(this.c);
            ((GeoFence)localObject2).setPendingIntentAction(this.d);
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      dg.a(paramString, "GeoFenceManager", "createPendingIntent");
      return this.c;
    }
  }
  
  final void d()
  {
    float f1;
    label330:
    do
    {
      try
      {
        if (this.y) {
          return;
        }
        if (!dn.a(this.s)) {
          return;
        }
        Object localObject1 = this.s;
        Object localObject2 = this.g;
        if ((localObject1 == null) || (((AMapLocation)localObject1).getErrorCode() != 0) || (localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label330;
        }
        localObject1 = new DPoint(((AMapLocation)localObject1).getLatitude(), ((AMapLocation)localObject1).getLongitude());
        localObject2 = ((List)localObject2).iterator();
        f1 = Float.MAX_VALUE;
        while (((Iterator)localObject2).hasNext())
        {
          GeoFence localGeoFence = (GeoFence)((Iterator)localObject2).next();
          if (localGeoFence.isAble())
          {
            float f3 = dn.a((DPoint)localObject1, localGeoFence.getCenter());
            if ((f3 > localGeoFence.getMinDis2Center()) && (f3 < localGeoFence.getMaxDis2Center()))
            {
              f1 = 0.0F;
              break;
            }
            float f2 = f1;
            if (f3 > localGeoFence.getMaxDis2Center()) {
              f2 = Math.min(f1, f3 - localGeoFence.getMaxDis2Center());
            }
            f1 = f2;
            if (f3 < localGeoFence.getMinDis2Center())
            {
              f1 = Math.min(f2, localGeoFence.getMinDis2Center() - f3);
              continue;
              if (f1 < 1000.0F)
              {
                a(7);
                localObject1 = new Bundle();
                ((Bundle)localObject1).putLong("interval", 2000L);
                a(8, (Bundle)localObject1, 500L);
                return;
              }
              if (f1 < 5000.0F)
              {
                c();
                a(7);
                a(7, null, 10000L);
                return;
              }
              c();
              a(7);
              a(7, null, ((f1 - 4000.0F) / 100.0F * 1000.0F));
              return;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "GeoFenceManager", "doCheckLocationPolicy");
        return;
      }
      continue;
      f1 = Float.MAX_VALUE;
    } while (f1 != Float.MAX_VALUE);
  }
  
  final void d(Bundle paramBundle)
  {
    b(3, paramBundle);
  }
  
  final void e()
  {
    try
    {
      a(7);
      a(8);
      if (this.r != null) {
        this.r.stopLocation();
      }
      this.m = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceManager", "doPauseGeoFence");
    }
  }
  
  final void e(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        if (paramBundle.isEmpty()) {
          return;
        }
        String str = paramBundle.getString("fid");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        int i2 = 1;
        boolean bool = paramBundle.getBoolean("ab", true);
        if ((this.g != null) && (!this.g.isEmpty()))
        {
          paramBundle = this.g.iterator();
          while (paramBundle.hasNext())
          {
            GeoFence localGeoFence = (GeoFence)paramBundle.next();
            if (localGeoFence.getFenceId().equals(str)) {
              localGeoFence.setAble(bool);
            }
          }
        }
        if (!bool)
        {
          int i1 = i2;
          if (this.g != null) {
            if (this.g.isEmpty())
            {
              i1 = i2;
            }
            else
            {
              paramBundle = this.g.iterator();
              do
              {
                i1 = i2;
                if (!paramBundle.hasNext()) {
                  break;
                }
              } while (!((GeoFence)paramBundle.next()).isAble());
              i1 = 0;
            }
          }
          if (i1 != 0) {
            e();
          }
        }
        else
        {
          b();
        }
        return;
      }
      catch (Throwable paramBundle)
      {
        dg.a(paramBundle, "GeoFenceManager", "doSetGeoFenceAble");
      }
    }
  }
  
  final void f(Bundle paramBundle)
  {
    try
    {
      if (this.g != null)
      {
        paramBundle = (GeoFence)paramBundle.getParcelable("fc");
        if (this.g.contains(paramBundle)) {
          this.g.remove(paramBundle);
        }
        if (this.g.size() <= 0)
        {
          a();
          return;
        }
        b();
      }
      return;
    }
    catch (Throwable paramBundle) {}
  }
  
  public List<GeoFence> getAllGeoFence()
  {
    try
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      ArrayList localArrayList = (ArrayList)this.g.clone();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return new ArrayList();
  }
  
  public boolean isPause()
  {
    return this.y;
  }
  
  public void pauseGeoFence()
  {
    try
    {
      f();
      this.y = true;
      a(13, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceManager", "pauseGeoFence");
    }
  }
  
  public void removeGeoFence()
  {
    try
    {
      this.o = false;
      a(10, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceManager", "removeGeoFence");
    }
  }
  
  public boolean removeGeoFence(GeoFence paramGeoFence)
  {
    try
    {
      if ((this.g != null) && (!this.g.isEmpty()))
      {
        if (this.g.contains(paramGeoFence))
        {
          if (this.g.size() == 1) {
            this.o = false;
          }
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("fc", paramGeoFence);
          a(11, localBundle, 0L);
          return true;
        }
      }
      else
      {
        this.o = false;
        a(10, null, 0L);
        return true;
      }
    }
    catch (Throwable paramGeoFence)
    {
      dg.a(paramGeoFence, "GeoFenceManager", "removeGeoFence(GeoFence)");
      return false;
    }
    return false;
  }
  
  public void resumeGeoFence()
  {
    try
    {
      f();
      if (this.y)
      {
        this.y = false;
        b();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceManager", "resumeGeoFence");
    }
  }
  
  public void setActivateAction(int paramInt)
  {
    for (;;)
    {
      try
      {
        f();
        if (paramInt <= 7)
        {
          i1 = paramInt;
          if (paramInt > 0)
          {
            Bundle localBundle = new Bundle();
            localBundle.putInt("activatesAction", i1);
            a(9, localBundle, 0L);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "GeoFenceManager", "setActivateAction");
        return;
      }
      int i1 = 1;
    }
  }
  
  public void setGeoFenceAble(String paramString, boolean paramBoolean)
  {
    try
    {
      f();
      Bundle localBundle = new Bundle();
      localBundle.putString("fid", paramString);
      localBundle.putBoolean("ab", paramBoolean);
      a(12, localBundle, 0L);
      return;
    }
    catch (Throwable paramString)
    {
      dg.a(paramString, "GeoFenceManager", "setGeoFenceAble");
    }
  }
  
  public void setGeoFenceListener(GeoFenceListener paramGeoFenceListener)
  {
    try
    {
      this.e = paramGeoFenceListener;
      return;
    }
    catch (Throwable paramGeoFenceListener) {}
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i;
      int k;
      int j;
      try
      {
        i = paramMessage.what;
        k = 1;
        j = 1;
        switch (i)
        {
        case 13: 
          a.this.e();
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        Object localObject1;
        a locala;
        Object localObject2;
        ArrayList localArrayList;
        Object localObject3;
        return;
      }
      a.this.e(paramMessage.getData());
      return;
      a.this.f(paramMessage.getData());
      return;
      a.this.a();
      return;
      a.this.a(paramMessage.getData());
      return;
      localObject1 = a.this;
      paramMessage = paramMessage.getData();
      try
      {
        if (((a)localObject1).r != null)
        {
          long l2 = 2000L;
          long l1 = l2;
          if (paramMessage != null)
          {
            l1 = l2;
            if (!paramMessage.isEmpty()) {
              l1 = paramMessage.getLong("interval", 2000L);
            }
          }
          ((a)localObject1).u.setOnceLocation(false);
          ((a)localObject1).u.setInterval(l1);
          ((a)localObject1).r.setLocationOption(((a)localObject1).u);
          if (!((a)localObject1).m)
          {
            ((a)localObject1).r.stopLocation();
            ((a)localObject1).r.startLocation();
            ((a)localObject1).m = true;
          }
        }
        return;
      }
      catch (Throwable paramMessage)
      {
        dg.a(paramMessage, "GeoFenceManager", "doStartContinueLocation");
        return;
      }
      paramMessage = a.this;
      try
      {
        if (paramMessage.r != null)
        {
          paramMessage.c();
          paramMessage.u.setOnceLocation(true);
          paramMessage.r.setLocationOption(paramMessage.u);
          paramMessage.r.startLocation();
        }
        return;
      }
      catch (Throwable paramMessage)
      {
        dg.a(paramMessage, "GeoFenceManager", "doStartOnceLocation");
        return;
      }
      a.this.a(a.this.s);
      return;
      a.this.d();
      return;
      a.this.d(paramMessage.getData());
      return;
      a.this.b(paramMessage.getData());
      return;
      a.this.c(paramMessage.getData());
      return;
      locala = a.this;
      localObject2 = paramMessage.getData();
      try
      {
        localArrayList = new ArrayList();
        if ((localObject2 == null) || (((Bundle)localObject2).isEmpty())) {
          break label831;
        }
        localObject3 = ((Bundle)localObject2).getParcelableArrayList("pointList");
        localObject1 = ((Bundle)localObject2).getString("customId");
        i = j;
        paramMessage = (Message)localObject1;
        if (localObject3 != null) {
          if (((List)localObject3).size() <= 2)
          {
            i = j;
            paramMessage = (Message)localObject1;
          }
          else
          {
            localObject2 = locala.a((Bundle)localObject2, true);
            j = locala.a((GeoFence)localObject2);
            i = j;
            paramMessage = (Message)localObject1;
            if (j == 0)
            {
              localArrayList.add(localObject2);
              i = j;
              paramMessage = (Message)localObject1;
            }
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("customId", paramMessage);
        ((Bundle)localObject1).putInt("errorCode", i);
        ((Bundle)localObject1).putParcelableArrayList("resultList", localArrayList);
        locala.a(1000, (Bundle)localObject1);
        return;
      }
      catch (Throwable paramMessage)
      {
        dg.a(paramMessage, "GeoFenceManager", "doAddGeoFencePolygon");
        return;
      }
      locala = a.this;
      localObject3 = paramMessage.getData();
      for (;;)
      {
        try
        {
          localArrayList = new ArrayList();
          if ((localObject3 == null) || (((Bundle)localObject3).isEmpty())) {
            break label839;
          }
          localObject2 = (DPoint)((Bundle)localObject3).getParcelable("centerPoint");
          localObject1 = ((Bundle)localObject3).getString("customId");
          i = k;
          paramMessage = (Message)localObject1;
          if (localObject2 != null) {
            if ((((DPoint)localObject2).getLatitude() <= 90.0D) && (((DPoint)localObject2).getLatitude() >= -90.0D) && (((DPoint)localObject2).getLongitude() <= 180.0D) && (((DPoint)localObject2).getLongitude() >= -180.0D))
            {
              localObject2 = locala.a((Bundle)localObject3, false);
              j = locala.a((GeoFence)localObject2);
              i = j;
              paramMessage = (Message)localObject1;
              if (j == 0)
              {
                localArrayList.add(localObject2);
                i = j;
                paramMessage = (Message)localObject1;
              }
            }
            else
            {
              paramMessage = new StringBuilder("经纬度错误，传入的纬度：");
              paramMessage.append(((DPoint)localObject2).getLatitude());
              paramMessage.append("传入的经度:");
              paramMessage.append(((DPoint)localObject2).getLongitude());
              a.a("添加围栏失败", 1, paramMessage.toString(), new String[0]);
              i = k;
              paramMessage = (Message)localObject1;
            }
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("errorCode", i);
          ((Bundle)localObject1).putParcelableArrayList("resultList", localArrayList);
          ((Bundle)localObject1).putString("customId", paramMessage);
          locala.a(1000, (Bundle)localObject1);
          return;
        }
        catch (Throwable paramMessage)
        {
          dg.a(paramMessage, "GeoFenceManager", "doAddGeoFenceRound");
          return;
        }
        return;
        label831:
        paramMessage = "";
        i = j;
        break;
        label839:
        paramMessage = "";
        i = k;
      }
    }
  }
  
  static final class b
    extends HandlerThread
  {
    public b(String paramString)
    {
      super();
    }
    
    public final void run()
    {
      try
      {
        super.run();
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  final class c
    extends Handler
  {
    public c() {}
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      try
      {
        Object localObject2 = paramMessage.getData();
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          return;
        case 1002: 
          try
          {
            i = ((Bundle)localObject2).getInt("location_errorcode");
            a.this.b(i);
            return;
          }
          catch (Throwable paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        case 1001: 
          try
          {
            paramMessage = (GeoFence)((Bundle)localObject2).getParcelable("geoFence");
            a.this.b(paramMessage);
            return;
          }
          catch (Throwable paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
        a locala = a.this;
        if (localObject2 != null) {
          try
          {
            if (!((Bundle)localObject2).isEmpty())
            {
              i = ((Bundle)localObject2).getInt("errorCode");
              Object localObject1 = ((Bundle)localObject2).getParcelableArrayList("resultList");
              paramMessage = (Message)localObject1;
              if (localObject1 == null) {
                paramMessage = new ArrayList();
              }
              localObject2 = ((Bundle)localObject2).getString("customId");
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              if (locala.e != null) {
                locala.e.onGeoFenceCreateFinished((ArrayList)paramMessage.clone(), i, (String)localObject1);
              }
              if (i == 0)
              {
                locala.b();
                return;
              }
            }
          }
          catch (Throwable paramMessage)
          {
            dg.a(paramMessage, "GeoFenceManager", "resultAddGeoFenceFinished");
          }
        }
        return;
      }
      catch (Throwable paramMessage) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */