package com.amap.api.mapcore.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol;

public final class ks
{
  Context a = null;
  boolean b = false;
  String c = null;
  long d = 0L;
  private ky e = null;
  private kx f = null;
  private a g = null;
  private la h = null;
  private ConnectivityManager i = null;
  private lc j = null;
  private StringBuilder k = new StringBuilder();
  private Inner_3dMap_locationOption l = null;
  private le m = null;
  private final String n = "\"status\":\"0\"";
  private final String o = "</body></html>";
  
  public ks(Context paramContext)
  {
    try
    {
      this.a = paramContext.getApplicationContext();
      lj.b(this.a);
      a(this.a);
      this.l = new Inner_3dMap_locationOption();
      if (this.e == null)
      {
        paramContext = (WifiManager)lj.a(this.a, "wifi");
        this.e = new ky(this.a, paramContext);
        this.e.a(this.b);
      }
      if (this.f == null) {
        this.f = new kx(this.a);
      }
      if (this.h == null) {
        this.h = la.a(this.a);
      }
      if (this.i == null) {
        this.i = ((ConnectivityManager)lj.a(this.a, "connectivity"));
      }
      this.j = new lc();
      c();
      return;
    }
    catch (Throwable paramContext)
    {
      lf.a(paramContext, "MapNetLocation", "<init>");
    }
  }
  
  private static le a(le paramle, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (paramVarArgs[0].equals("shake")) {
        return kn.a().a(paramle);
      }
      le localle = paramle;
      if (paramVarArgs[0].equals("fusion"))
      {
        kn.a();
        localle = kn.b(paramle);
      }
      return localle;
    }
    return kn.a().a(paramle);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission(fw.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
        this.b = true;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private boolean a(long paramLong)
  {
    if (lj.b() - paramLong < 800L)
    {
      paramLong = 0L;
      if (ku.a(this.m)) {
        paramLong = lj.a() - this.m.getTime();
      }
      if (paramLong <= 10000L) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    try
    {
      if (this.g == null) {
        this.g = new a((byte)0);
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
      this.a.registerReceiver(this.g, localIntentFilter);
      this.e.b(false);
      this.f.f();
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "MapNetLocation", "initBroadcastListener");
    }
  }
  
  /* Error */
  private le d()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: new 184	com/amap/api/mapcore/util/le
    //   3: dup
    //   4: ldc -38
    //   6: invokespecial 220	com/amap/api/mapcore/util/le:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 45	com/amap/api/mapcore/util/ks:e	Lcom/amap/api/mapcore/util/ky;
    //   15: ifnull +23 -> 38
    //   18: aload_0
    //   19: getfield 45	com/amap/api/mapcore/util/ks:e	Lcom/amap/api/mapcore/util/ky;
    //   22: invokevirtual 223	com/amap/api/mapcore/util/ky:g	()Z
    //   25: ifeq +13 -> 38
    //   28: aload 4
    //   30: bipush 15
    //   32: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   35: aload 4
    //   37: areturn
    //   38: aload_0
    //   39: getfield 55	com/amap/api/mapcore/util/ks:j	Lcom/amap/api/mapcore/util/lc;
    //   42: ifnonnull +14 -> 56
    //   45: aload_0
    //   46: new 124	com/amap/api/mapcore/util/lc
    //   49: dup
    //   50: invokespecial 125	com/amap/api/mapcore/util/lc:<init>	()V
    //   53: putfield 55	com/amap/api/mapcore/util/ks:j	Lcom/amap/api/mapcore/util/lc;
    //   56: aload_0
    //   57: getfield 55	com/amap/api/mapcore/util/ks:j	Lcom/amap/api/mapcore/util/lc;
    //   60: aload_0
    //   61: getfield 43	com/amap/api/mapcore/util/ks:a	Landroid/content/Context;
    //   64: aload_0
    //   65: getfield 64	com/amap/api/mapcore/util/ks:l	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   68: invokevirtual 230	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:isNeedAddress	()Z
    //   71: aload_0
    //   72: getfield 64	com/amap/api/mapcore/util/ks:l	Lcom/autonavi/amap/mapcore/Inner_3dMap_locationOption;
    //   75: invokevirtual 233	com/autonavi/amap/mapcore/Inner_3dMap_locationOption:isOffset	()Z
    //   78: aload_0
    //   79: getfield 47	com/amap/api/mapcore/util/ks:f	Lcom/amap/api/mapcore/util/kx;
    //   82: aload_0
    //   83: getfield 45	com/amap/api/mapcore/util/ks:e	Lcom/amap/api/mapcore/util/ky;
    //   86: aload_0
    //   87: getfield 53	com/amap/api/mapcore/util/ks:i	Landroid/net/ConnectivityManager;
    //   90: aload_0
    //   91: getfield 66	com/amap/api/mapcore/util/ks:c	Ljava/lang/String;
    //   94: invokevirtual 236	com/amap/api/mapcore/util/lc:a	(Landroid/content/Context;ZZLcom/amap/api/mapcore/util/kx;Lcom/amap/api/mapcore/util/ky;Landroid/net/ConnectivityManager;Ljava/lang/String;)V
    //   97: new 238	com/amap/api/mapcore/util/kt
    //   100: dup
    //   101: invokespecial 239	com/amap/api/mapcore/util/kt:<init>	()V
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: ldc -38
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 55	com/amap/api/mapcore/util/ks:j	Lcom/amap/api/mapcore/util/lc;
    //   114: invokevirtual 242	com/amap/api/mapcore/util/lc:a	()[B
    //   117: astore 5
    //   119: aload_0
    //   120: getfield 51	com/amap/api/mapcore/util/ks:h	Lcom/amap/api/mapcore/util/la;
    //   123: aload_0
    //   124: getfield 43	com/amap/api/mapcore/util/ks:a	Landroid/content/Context;
    //   127: aload 5
    //   129: invokestatic 245	com/amap/api/mapcore/util/lf:a	()Ljava/lang/String;
    //   132: invokevirtual 248	com/amap/api/mapcore/util/la:a	(Landroid/content/Context;[BLjava/lang/String;)Lcom/amap/api/mapcore/util/lb;
    //   135: astore 5
    //   137: aload_0
    //   138: getfield 51	com/amap/api/mapcore/util/ks:h	Lcom/amap/api/mapcore/util/la;
    //   141: aload 5
    //   143: invokevirtual 251	com/amap/api/mapcore/util/la:a	(Lcom/amap/api/mapcore/util/lb;)Lcom/amap/api/mapcore/util/ie;
    //   146: astore 5
    //   148: aload 5
    //   150: ifnull +15 -> 165
    //   153: aload 5
    //   155: getfield 256	com/amap/api/mapcore/util/ie:a	[B
    //   158: astore_2
    //   159: aload 5
    //   161: getfield 257	com/amap/api/mapcore/util/ie:c	Ljava/lang/String;
    //   164: astore_1
    //   165: aload_2
    //   166: ifnull +714 -> 880
    //   169: aload_2
    //   170: arraylength
    //   171: ifne +6 -> 177
    //   174: goto +706 -> 880
    //   177: new 142	java/lang/String
    //   180: dup
    //   181: aload_2
    //   182: ldc_w 259
    //   185: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   188: astore 6
    //   190: aload 6
    //   192: ldc 72
    //   194: invokevirtual 266	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +16 -> 213
    //   200: aload_3
    //   201: aload 6
    //   203: aload_0
    //   204: getfield 43	com/amap/api/mapcore/util/ks:a	Landroid/content/Context;
    //   207: aload 5
    //   209: invokevirtual 269	com/amap/api/mapcore/util/kt:a	(Ljava/lang/String;Landroid/content/Context;Lcom/amap/api/mapcore/util/ie;)Lcom/amap/api/mapcore/util/le;
    //   212: areturn
    //   213: aload 6
    //   215: ldc 76
    //   217: invokevirtual 266	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +110 -> 330
    //   223: aload 4
    //   225: iconst_5
    //   226: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   229: aload_0
    //   230: getfield 45	com/amap/api/mapcore/util/ks:e	Lcom/amap/api/mapcore/util/ky;
    //   233: ifnull +29 -> 262
    //   236: aload_0
    //   237: getfield 45	com/amap/api/mapcore/util/ks:e	Lcom/amap/api/mapcore/util/ky;
    //   240: aload_0
    //   241: getfield 53	com/amap/api/mapcore/util/ks:i	Landroid/net/ConnectivityManager;
    //   244: invokevirtual 272	com/amap/api/mapcore/util/ky:a	(Landroid/net/ConnectivityManager;)Z
    //   247: ifeq +15 -> 262
    //   250: aload_0
    //   251: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   254: astore_2
    //   255: ldc_w 274
    //   258: astore_3
    //   259: goto +12 -> 271
    //   262: aload_0
    //   263: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   266: astore_2
    //   267: ldc_w 276
    //   270: astore_3
    //   271: aload_2
    //   272: aload_3
    //   273: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_1
    //   278: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   281: ifne +34 -> 315
    //   284: aload_0
    //   285: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   288: astore_2
    //   289: new 59	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 287
    //   296: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: astore_3
    //   300: aload_3
    //   301: aload_1
    //   302: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_2
    //   307: aload_3
    //   308: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 4
    //   317: aload_0
    //   318: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   321: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   327: aload 4
    //   329: areturn
    //   330: aload_2
    //   331: invokestatic 299	com/amap/api/mapcore/util/kz:a	([B)[B
    //   334: astore_2
    //   335: aload_2
    //   336: ifnonnull +73 -> 409
    //   339: aload 4
    //   341: iconst_5
    //   342: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   345: aload_0
    //   346: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   349: ldc_w 301
    //   352: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_1
    //   357: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +34 -> 394
    //   363: aload_0
    //   364: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   367: astore_2
    //   368: new 59	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 287
    //   375: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: astore_3
    //   379: aload_3
    //   380: aload_1
    //   381: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_2
    //   386: aload_3
    //   387: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 4
    //   396: aload_0
    //   397: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   400: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   406: aload 4
    //   408: areturn
    //   409: aload_3
    //   410: aload_2
    //   411: invokevirtual 304	com/amap/api/mapcore/util/kt:a	([B)Lcom/amap/api/mapcore/util/le;
    //   414: astore_3
    //   415: aload_3
    //   416: ifnonnull +83 -> 499
    //   419: new 184	com/amap/api/mapcore/util/le
    //   422: dup
    //   423: ldc -38
    //   425: invokespecial 220	com/amap/api/mapcore/util/le:<init>	(Ljava/lang/String;)V
    //   428: astore_2
    //   429: aload_2
    //   430: iconst_5
    //   431: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   434: aload_0
    //   435: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   438: ldc_w 306
    //   441: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne +37 -> 486
    //   452: aload_0
    //   453: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   456: astore_3
    //   457: new 59	java/lang/StringBuilder
    //   460: dup
    //   461: ldc_w 287
    //   464: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: astore 4
    //   469: aload 4
    //   471: aload_1
    //   472: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_3
    //   477: aload 4
    //   479: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload_2
    //   487: aload_0
    //   488: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   491: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   497: aload_2
    //   498: areturn
    //   499: aload_0
    //   500: aload_3
    //   501: invokevirtual 307	com/amap/api/mapcore/util/le:a	()Ljava/lang/String;
    //   504: putfield 66	com/amap/api/mapcore/util/ks:c	Ljava/lang/String;
    //   507: aload_3
    //   508: invokevirtual 311	com/amap/api/mapcore/util/le:getErrorCode	()I
    //   511: ifeq +51 -> 562
    //   514: aload_1
    //   515: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   518: ifne +42 -> 560
    //   521: new 59	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   528: astore_2
    //   529: aload_2
    //   530: aload_3
    //   531: invokevirtual 314	com/amap/api/mapcore/util/le:getLocationDetail	()Ljava/lang/String;
    //   534: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_2
    //   539: ldc_w 287
    //   542: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload_2
    //   547: aload_1
    //   548: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload_3
    //   553: aload_2
    //   554: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   560: aload_3
    //   561: areturn
    //   562: aload_3
    //   563: invokestatic 180	com/amap/api/mapcore/util/ku:a	(Lcom/amap/api/mapcore/util/le;)Z
    //   566: ifeq +183 -> 749
    //   569: aload_3
    //   570: invokevirtual 317	com/amap/api/mapcore/util/le:e	()Lorg/json/JSONObject;
    //   573: pop
    //   574: aload_3
    //   575: invokevirtual 311	com/amap/api/mapcore/util/le:getErrorCode	()I
    //   578: ifne +169 -> 747
    //   581: aload_3
    //   582: invokevirtual 320	com/amap/api/mapcore/util/le:getLocationType	()I
    //   585: ifne +162 -> 747
    //   588: ldc_w 322
    //   591: aload_3
    //   592: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   595: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifne +80 -> 678
    //   601: ldc_w 326
    //   604: aload_3
    //   605: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   608: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   611: ifne +67 -> 678
    //   614: ldc_w 328
    //   617: aload_3
    //   618: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   621: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +54 -> 678
    //   627: ldc_w 330
    //   630: aload_3
    //   631: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   634: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   637: ifne +41 -> 678
    //   640: ldc_w 332
    //   643: aload_3
    //   644: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   647: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   650: ifne +28 -> 678
    //   653: ldc_w 334
    //   656: aload_3
    //   657: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   660: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   663: ifeq +6 -> 669
    //   666: goto +12 -> 678
    //   669: aload_3
    //   670: bipush 6
    //   672: invokevirtual 337	com/amap/api/mapcore/util/le:setLocationType	(I)V
    //   675: goto +8 -> 683
    //   678: aload_3
    //   679: iconst_5
    //   680: invokevirtual 337	com/amap/api/mapcore/util/le:setLocationType	(I)V
    //   683: aload_0
    //   684: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   687: aload_3
    //   688: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   691: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload_1
    //   696: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   699: ifne +37 -> 736
    //   702: aload_0
    //   703: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   706: astore_2
    //   707: new 59	java/lang/StringBuilder
    //   710: dup
    //   711: ldc_w 287
    //   714: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   717: astore 4
    //   719: aload 4
    //   721: aload_1
    //   722: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: aload 4
    //   729: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload_3
    //   737: aload_0
    //   738: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   741: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   747: aload_3
    //   748: areturn
    //   749: aload_3
    //   750: invokevirtual 339	com/amap/api/mapcore/util/le:b	()Ljava/lang/String;
    //   753: astore_2
    //   754: aload_3
    //   755: bipush 6
    //   757: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   760: aload_0
    //   761: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   764: astore 4
    //   766: new 59	java/lang/StringBuilder
    //   769: dup
    //   770: ldc_w 341
    //   773: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   776: astore 5
    //   778: aload 5
    //   780: aload_3
    //   781: invokevirtual 324	com/amap/api/mapcore/util/le:d	()Ljava/lang/String;
    //   784: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload 5
    //   790: ldc_w 343
    //   793: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload_2
    //   798: ifnull +6 -> 804
    //   801: goto +7 -> 808
    //   804: ldc_w 345
    //   807: astore_2
    //   808: aload 5
    //   810: aload_2
    //   811: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 4
    //   817: aload 5
    //   819: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload_1
    //   827: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   830: ifne +37 -> 867
    //   833: aload_0
    //   834: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   837: astore_2
    //   838: new 59	java/lang/StringBuilder
    //   841: dup
    //   842: ldc_w 287
    //   845: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   848: astore 4
    //   850: aload 4
    //   852: aload_1
    //   853: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload_2
    //   858: aload 4
    //   860: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload_3
    //   868: aload_0
    //   869: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   872: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   878: aload_3
    //   879: areturn
    //   880: aload 4
    //   882: iconst_4
    //   883: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   886: aload_0
    //   887: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   890: ldc_w 347
    //   893: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_1
    //   898: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   901: ifne +34 -> 935
    //   904: aload_0
    //   905: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   908: astore_2
    //   909: new 59	java/lang/StringBuilder
    //   912: dup
    //   913: ldc_w 287
    //   916: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   919: astore_3
    //   920: aload_3
    //   921: aload_1
    //   922: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload_2
    //   927: aload_3
    //   928: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload 4
    //   937: aload_0
    //   938: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   941: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   947: aload 4
    //   949: areturn
    //   950: astore_1
    //   951: aload_1
    //   952: ldc -127
    //   954: ldc_w 349
    //   957: invokestatic 135	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   960: aload 4
    //   962: iconst_4
    //   963: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   966: aload_0
    //   967: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   970: ldc_w 347
    //   973: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload 4
    //   979: aload_0
    //   980: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   983: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   989: aload 4
    //   991: areturn
    //   992: astore_1
    //   993: aload_1
    //   994: ldc -127
    //   996: ldc_w 351
    //   999: invokestatic 135	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1002: aload 4
    //   1004: iconst_3
    //   1005: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   1008: aload_0
    //   1009: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   1012: astore_2
    //   1013: new 59	java/lang/StringBuilder
    //   1016: dup
    //   1017: ldc_w 353
    //   1020: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1023: astore_3
    //   1024: aload_3
    //   1025: aload_1
    //   1026: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1029: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload_2
    //   1034: aload_3
    //   1035: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: pop
    //   1042: aload 4
    //   1044: aload_0
    //   1045: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   1048: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   1054: aload 4
    //   1056: areturn
    //   1057: astore_1
    //   1058: aload_1
    //   1059: ldc -127
    //   1061: ldc_w 358
    //   1064: invokestatic 135	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1067: aload_0
    //   1068: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   1071: astore_2
    //   1072: new 59	java/lang/StringBuilder
    //   1075: dup
    //   1076: ldc_w 360
    //   1079: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1082: astore_3
    //   1083: aload_3
    //   1084: aload_1
    //   1085: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1088: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload_2
    //   1093: aload_3
    //   1094: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1097: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: aload 4
    //   1103: iconst_3
    //   1104: invokevirtual 227	com/amap/api/mapcore/util/le:setErrorCode	(I)V
    //   1107: aload 4
    //   1109: aload_0
    //   1110: getfield 62	com/amap/api/mapcore/util/ks:k	Ljava/lang/StringBuilder;
    //   1113: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: invokevirtual 294	com/amap/api/mapcore/util/le:setLocationDetail	(Ljava/lang/String;)V
    //   1119: aload 4
    //   1121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1122	0	this	ks
    //   109	813	1	str1	String
    //   950	2	1	localThrowable1	Throwable
    //   992	34	1	localThrowable2	Throwable
    //   1057	28	1	localThrowable3	Throwable
    //   106	987	2	localObject1	Object
    //   104	990	3	localObject2	Object
    //   9	1111	4	localObject3	Object
    //   117	701	5	localObject4	Object
    //   188	26	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   119	148	950	java/lang/Throwable
    //   153	165	950	java/lang/Throwable
    //   110	119	992	java/lang/Throwable
    //   38	56	1057	java/lang/Throwable
    //   56	97	1057	java/lang/Throwable
  }
  
  public final Inner_3dMap_location a()
  {
    if (this.k.length() > 0) {
      this.k.delete(0, this.k.length());
    }
    if ((a(this.d)) && (ku.a(this.m))) {
      return this.m;
    }
    this.d = lj.b();
    if (this.a == null)
    {
      this.k.append("context is null");
      Inner_3dMap_location localInner_3dMap_location = new Inner_3dMap_location("");
      localInner_3dMap_location.setErrorCode(1);
      localInner_3dMap_location.setLocationDetail(this.k.toString());
      return localInner_3dMap_location;
    }
    try
    {
      this.f.f();
    }
    catch (Throwable localThrowable1)
    {
      lf.a(localThrowable1, "MapNetLocation", "getLocation getCgiListParam");
    }
    try
    {
      this.e.b(true);
    }
    catch (Throwable localThrowable2)
    {
      lf.a(localThrowable2, "MapNetLocation", "getLocation getScanResultsParam");
    }
    try
    {
      this.m = d();
      this.m = a(this.m, new String[0]);
    }
    catch (Throwable localThrowable3)
    {
      lf.a(localThrowable3, "MapNetLocation", "getLocation getScanResultsParam");
    }
    return this.m;
  }
  
  public final void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption)
  {
    this.l = paramInner_3dMap_locationOption;
    if (this.l == null) {
      this.l = new Inner_3dMap_locationOption();
    }
    try
    {
      paramInner_3dMap_locationOption = this.e;
      this.l.isWifiActiveScan();
      paramInner_3dMap_locationOption.c(this.l.isWifiScan());
    }
    catch (Throwable paramInner_3dMap_locationOption)
    {
      for (;;)
      {
        try
        {
          this.h.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS));
          return;
        }
        catch (Throwable paramInner_3dMap_locationOption) {}
        paramInner_3dMap_locationOption = paramInner_3dMap_locationOption;
      }
    }
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 57	com/amap/api/mapcore/util/ks:b	Z
    //   5: aload_0
    //   6: aconst_null
    //   7: putfield 66	com/amap/api/mapcore/util/ks:c	Ljava/lang/String;
    //   10: aload_0
    //   11: getfield 43	com/amap/api/mapcore/util/ks:a	Landroid/content/Context;
    //   14: ifnull +21 -> 35
    //   17: aload_0
    //   18: getfield 49	com/amap/api/mapcore/util/ks:g	Lcom/amap/api/mapcore/util/ks$a;
    //   21: ifnull +14 -> 35
    //   24: aload_0
    //   25: getfield 43	com/amap/api/mapcore/util/ks:a	Landroid/content/Context;
    //   28: aload_0
    //   29: getfield 49	com/amap/api/mapcore/util/ks:g	Lcom/amap/api/mapcore/util/ks$a;
    //   32: invokevirtual 416	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   35: aload_0
    //   36: getfield 47	com/amap/api/mapcore/util/ks:f	Lcom/amap/api/mapcore/util/kx;
    //   39: ifnull +10 -> 49
    //   42: aload_0
    //   43: getfield 47	com/amap/api/mapcore/util/ks:f	Lcom/amap/api/mapcore/util/kx;
    //   46: invokevirtual 418	com/amap/api/mapcore/util/kx:g	()V
    //   49: aload_0
    //   50: getfield 45	com/amap/api/mapcore/util/ks:e	Lcom/amap/api/mapcore/util/ky;
    //   53: ifnull +10 -> 63
    //   56: aload_0
    //   57: getfield 45	com/amap/api/mapcore/util/ks:e	Lcom/amap/api/mapcore/util/ky;
    //   60: invokevirtual 420	com/amap/api/mapcore/util/ky:h	()V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 49	com/amap/api/mapcore/util/ks:g	Lcom/amap/api/mapcore/util/ks$a;
    //   68: return
    //   69: astore_1
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 49	com/amap/api/mapcore/util/ks:g	Lcom/amap/api/mapcore/util/ks$a;
    //   75: aload_1
    //   76: athrow
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 49	com/amap/api/mapcore/util/ks:g	Lcom/amap/api/mapcore/util/ks$a;
    //   82: return
    //   83: astore_1
    //   84: goto -7 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	ks
    //   69	7	1	localObject	Object
    //   83	1	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	35	69	finally
    //   35	49	69	finally
    //   49	63	69	finally
    //   10	35	83	java/lang/Throwable
    //   35	49	83	java/lang/Throwable
    //   49	63	83	java/lang/Throwable
  }
  
  private final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext != null)
      {
        if (paramIntent == null) {
          return;
        }
        try
        {
          paramContext = paramIntent.getAction();
          if (TextUtils.isEmpty(paramContext)) {
            return;
          }
          if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
          {
            if (ks.a(ks.this) != null) {
              ks.a(ks.this).c();
            }
          }
          else if ((paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED")) && (ks.a(ks.this) != null)) {
            ks.a(ks.this).d();
          }
          return;
        }
        catch (Throwable paramContext)
        {
          lf.a(paramContext, "MapNetLocation", "onReceive");
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */