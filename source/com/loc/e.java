package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.location.UmidtokenInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class e
  implements LocationManagerBase
{
  private static boolean C = true;
  private static boolean E = false;
  private boolean A;
  private volatile boolean B;
  private boolean D;
  private i F;
  private ServiceConnection G;
  AMapLocationClientOption a;
  public c b;
  h c;
  ArrayList<AMapLocationListener> d;
  boolean e;
  public boolean f;
  j g;
  Messenger h;
  Messenger i;
  Intent j;
  int k;
  b l;
  boolean m;
  AMapLocationClientOption.AMapLocationMode n;
  Object o;
  dk p;
  boolean q;
  f r;
  String s;
  AMapLocationQualityReport t;
  boolean u;
  boolean v;
  a w;
  String x;
  boolean y;
  private Context z;
  
  /* Error */
  public e(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 81	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 83	com/amap/api/location/AMapLocationClientOption
    //   8: dup
    //   9: invokespecial 84	com/amap/api/location/AMapLocationClientOption:<init>	()V
    //   12: putfield 86	com/loc/e:a	Lcom/amap/api/location/AMapLocationClientOption;
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield 88	com/loc/e:c	Lcom/loc/h;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 90	com/loc/e:A	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 92	com/loc/e:B	Z
    //   30: aload_0
    //   31: new 94	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 95	java/util/ArrayList:<init>	()V
    //   38: putfield 97	com/loc/e:d	Ljava/util/ArrayList;
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 99	com/loc/e:e	Z
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 101	com/loc/e:f	Z
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 103	com/loc/e:h	Landroid/os/Messenger;
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 105	com/loc/e:i	Landroid/os/Messenger;
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 107	com/loc/e:j	Landroid/content/Intent;
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 109	com/loc/e:k	I
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 111	com/loc/e:D	Z
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 113	com/loc/e:l	Lcom/loc/e$b;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 115	com/loc/e:m	Z
    //   86: aload_0
    //   87: getstatic 120	com/amap/api/location/AMapLocationClientOption$AMapLocationMode:Hight_Accuracy	Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   90: putfield 122	com/loc/e:n	Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   93: aload_0
    //   94: new 4	java/lang/Object
    //   97: dup
    //   98: invokespecial 81	java/lang/Object:<init>	()V
    //   101: putfield 124	com/loc/e:o	Ljava/lang/Object;
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 126	com/loc/e:p	Lcom/loc/dk;
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield 128	com/loc/e:q	Z
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 130	com/loc/e:r	Lcom/loc/f;
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 132	com/loc/e:F	Lcom/loc/i;
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 134	com/loc/e:s	Ljava/lang/String;
    //   129: aload_0
    //   130: new 8	com/loc/e$1
    //   133: dup
    //   134: aload_0
    //   135: invokespecial 137	com/loc/e$1:<init>	(Lcom/loc/e;)V
    //   138: putfield 139	com/loc/e:G	Landroid/content/ServiceConnection;
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 143	com/loc/e:u	Z
    //   151: aload_0
    //   152: iconst_0
    //   153: putfield 145	com/loc/e:v	Z
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 147	com/loc/e:w	Lcom/loc/e$a;
    //   161: aload_0
    //   162: aconst_null
    //   163: putfield 149	com/loc/e:x	Ljava/lang/String;
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 151	com/loc/e:y	Z
    //   171: aload_0
    //   172: aload_1
    //   173: putfield 153	com/loc/e:z	Landroid/content/Context;
    //   176: aload_0
    //   177: aload_2
    //   178: putfield 107	com/loc/e:j	Landroid/content/Intent;
    //   181: invokestatic 158	com/loc/dg:d	()Z
    //   184: ifeq +15 -> 199
    //   187: invokestatic 161	com/loc/dg:b	()Lcom/loc/v;
    //   190: astore_1
    //   191: aload_0
    //   192: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   195: aload_1
    //   196: invokestatic 166	com/loc/dl:a	(Landroid/content/Context;Lcom/loc/v;)V
    //   199: invokestatic 172	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   202: ifnonnull +27 -> 229
    //   205: new 18	com/loc/e$c
    //   208: dup
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   214: invokevirtual 177	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   217: invokespecial 180	com/loc/e$c:<init>	(Lcom/loc/e;Landroid/os/Looper;)V
    //   220: astore_1
    //   221: aload_0
    //   222: aload_1
    //   223: putfield 182	com/loc/e:b	Lcom/loc/e$c;
    //   226: goto +24 -> 250
    //   229: new 18	com/loc/e$c
    //   232: dup
    //   233: aload_0
    //   234: invokespecial 183	com/loc/e$c:<init>	(Lcom/loc/e;)V
    //   237: astore_1
    //   238: goto -17 -> 221
    //   241: astore_1
    //   242: aload_1
    //   243: ldc -71
    //   245: ldc -69
    //   247: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_0
    //   251: new 192	com/loc/j
    //   254: dup
    //   255: aload_0
    //   256: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   259: invokespecial 195	com/loc/j:<init>	(Landroid/content/Context;)V
    //   262: putfield 197	com/loc/e:g	Lcom/loc/j;
    //   265: goto +12 -> 277
    //   268: astore_1
    //   269: aload_1
    //   270: ldc -71
    //   272: ldc -57
    //   274: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload_0
    //   278: new 15	com/loc/e$b
    //   281: dup
    //   282: ldc -55
    //   284: aload_0
    //   285: invokespecial 204	com/loc/e$b:<init>	(Ljava/lang/String;Lcom/loc/e;)V
    //   288: putfield 113	com/loc/e:l	Lcom/loc/e$b;
    //   291: aload_0
    //   292: getfield 113	com/loc/e:l	Lcom/loc/e$b;
    //   295: iconst_5
    //   296: invokevirtual 208	com/loc/e$b:setPriority	(I)V
    //   299: aload_0
    //   300: getfield 113	com/loc/e:l	Lcom/loc/e$b;
    //   303: invokevirtual 211	com/loc/e$b:start	()V
    //   306: aload_0
    //   307: aload_0
    //   308: aload_0
    //   309: getfield 113	com/loc/e:l	Lcom/loc/e$b;
    //   312: invokevirtual 214	com/loc/e$b:getLooper	()Landroid/os/Looper;
    //   315: invokespecial 217	com/loc/e:a	(Landroid/os/Looper;)Lcom/loc/e$a;
    //   318: putfield 147	com/loc/e:w	Lcom/loc/e$a;
    //   321: goto +12 -> 333
    //   324: astore_1
    //   325: aload_1
    //   326: ldc -71
    //   328: ldc -37
    //   330: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_0
    //   334: new 221	com/loc/h
    //   337: dup
    //   338: aload_0
    //   339: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   342: aload_0
    //   343: getfield 182	com/loc/e:b	Lcom/loc/e$c;
    //   346: invokespecial 224	com/loc/h:<init>	(Landroid/content/Context;Landroid/os/Handler;)V
    //   349: putfield 88	com/loc/e:c	Lcom/loc/h;
    //   352: goto +12 -> 364
    //   355: astore_1
    //   356: aload_1
    //   357: ldc -71
    //   359: ldc -30
    //   361: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload_0
    //   365: getfield 126	com/loc/e:p	Lcom/loc/dk;
    //   368: ifnonnull +14 -> 382
    //   371: aload_0
    //   372: new 228	com/loc/dk
    //   375: dup
    //   376: invokespecial 229	com/loc/dk:<init>	()V
    //   379: putfield 126	com/loc/e:p	Lcom/loc/dk;
    //   382: return
    //   383: astore_1
    //   384: goto -185 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	e
    //   0	387	1	paramContext	Context
    //   0	387	2	paramIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   199	221	241	java/lang/Throwable
    //   221	226	241	java/lang/Throwable
    //   229	238	241	java/lang/Throwable
    //   250	265	268	java/lang/Throwable
    //   269	277	324	java/lang/Throwable
    //   277	321	324	java/lang/Throwable
    //   333	352	355	java/lang/Throwable
    //   187	199	383	java/lang/Throwable
  }
  
  private co a(cl paramcl)
  {
    if (this.a.isLocationCacheEnable()) {
      try
      {
        paramcl = paramcl.g();
        return paramcl;
      }
      catch (Throwable paramcl)
      {
        dg.a(paramcl, "ALManager", "doFirstCacheLoc");
      }
    }
    return null;
  }
  
  private a a(Looper paramLooper)
  {
    synchronized (this.o)
    {
      this.w = new a(paramLooper);
      paramLooper = this.w;
      return paramLooper;
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.o)
    {
      if (this.w != null) {
        this.w.removeMessages(paramInt);
      }
      return;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    try
    {
      localBundle = new Bundle();
      if (TextUtils.isEmpty(this.s)) {
        this.s = dg.b(this.z);
      }
      localBundle.putString("c", this.s);
      paramBundle = Message.obtain();
      paramBundle.what = paramInt;
      paramBundle.setData(localBundle);
      paramBundle.replyTo = this.i;
      if (this.h != null) {
        this.h.send(paramBundle);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;) {}
    }
    if (((paramBundle instanceof IllegalStateException)) && (paramBundle.getMessage().contains("sending message to a Handler on a dead thread"))) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (((paramBundle instanceof RemoteException)) || (paramInt != 0))
    {
      this.h = null;
      this.A = false;
    }
    dg.a(paramBundle, "ALManager", "sendLocMessage");
  }
  
  private void a(int paramInt, Object paramObject, long paramLong)
  {
    synchronized (this.o)
    {
      if (this.w != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = paramInt;
        if ((paramObject instanceof Bundle)) {
          localMessage.setData((Bundle)paramObject);
        } else {
          localMessage.obj = paramObject;
        }
        this.w.sendMessageDelayed(localMessage, paramLong);
      }
      return;
    }
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    if (this.z != null) {
      if ((Build.VERSION.SDK_INT >= 26) && (paramBoolean)) {
        if (!h())
        {
          Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
          return;
        }
      }
    }
    try
    {
      this.z.getClass().getMethod("startForegroundService", new Class[] { Intent.class }).invoke(this.z, new Object[] { paramIntent });
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    this.z.startService(paramIntent);
    this.y = true;
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject4 = null;
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        paramBundle.setClassLoader(AMapLocation.class.getClassLoader());
        AMapLocation localAMapLocation2 = (AMapLocation)paramBundle.getParcelable("loc");
        this.x = paramBundle.getString("nb");
        Object localObject3 = (d)paramBundle.getParcelable("statics");
        AMapLocation localAMapLocation1 = localAMapLocation2;
        paramBundle = (Bundle)localObject3;
        if (localAMapLocation2 != null)
        {
          localAMapLocation1 = localAMapLocation2;
          paramBundle = (Bundle)localObject3;
          localObject1 = localObject3;
        }
        try
        {
          if (localAMapLocation2.getErrorCode() == 0)
          {
            localAMapLocation1 = localAMapLocation2;
            paramBundle = (Bundle)localObject3;
            localObject1 = localObject3;
            if (this.c != null)
            {
              localObject1 = localObject3;
              this.c.w = 0;
              localAMapLocation1 = localAMapLocation2;
              paramBundle = (Bundle)localObject3;
              localObject1 = localObject3;
              if (!TextUtils.isEmpty(localAMapLocation2.getAdCode()))
              {
                localObject1 = localObject3;
                this.c.y = localAMapLocation2;
                localAMapLocation1 = localAMapLocation2;
                paramBundle = (Bundle)localObject3;
              }
            }
          }
          localObject3 = localAMapLocation1;
          localObject1 = paramBundle;
          if (this.c != null)
          {
            localObject1 = paramBundle;
            localObject3 = this.c.a(localAMapLocation1, this.x);
          }
          localAMapLocation1 = null;
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable2)
        {
          paramBundle = (Bundle)localObject1;
          localObject1 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        paramBundle = null;
        continue;
      }
      dg.a((Throwable)localObject1, "AmapLocationManager", "resultLbsLocationSuccess");
      Object localObject2 = localObject1;
      localObject1 = localObject4;
      a((AMapLocation)localObject1, (Throwable)localObject2, paramBundle);
      return;
      paramBundle = null;
      localObject2 = paramBundle;
    }
  }
  
  /* Error */
  private void a(AMapLocation paramAMapLocation, Throwable paramThrowable, d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 158	com/loc/dg:d	()Z
    //   5: ifeq +44 -> 49
    //   8: aload_1
    //   9: ifnonnull +40 -> 49
    //   12: aload_2
    //   13: ifnull +20 -> 33
    //   16: aload_0
    //   17: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   20: ldc_w 362
    //   23: aload_2
    //   24: invokevirtual 290	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   27: invokestatic 401	com/loc/dl:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   37: ldc_w 362
    //   40: ldc_w 403
    //   43: invokestatic 401	com/loc/dl:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: ifnonnull +27 -> 79
    //   55: new 352	com/amap/api/location/AMapLocation
    //   58: dup
    //   59: ldc_w 405
    //   62: invokespecial 408	com/amap/api/location/AMapLocation:<init>	(Ljava/lang/String;)V
    //   65: astore_2
    //   66: aload_2
    //   67: bipush 8
    //   69: invokevirtual 411	com/amap/api/location/AMapLocation:setErrorCode	(I)V
    //   72: aload_2
    //   73: ldc_w 413
    //   76: invokevirtual 416	com/amap/api/location/AMapLocation:setLocationDetail	(Ljava/lang/String;)V
    //   79: ldc_w 418
    //   82: aload_2
    //   83: invokevirtual 421	com/amap/api/location/AMapLocation:getProvider	()Ljava/lang/String;
    //   86: invokevirtual 425	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   89: ifne +10 -> 99
    //   92: aload_2
    //   93: ldc_w 427
    //   96: invokevirtual 430	com/amap/api/location/AMapLocation:setProvider	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   103: ifnonnull +14 -> 117
    //   106: aload_0
    //   107: new 432	com/amap/api/location/AMapLocationQualityReport
    //   110: dup
    //   111: invokespecial 433	com/amap/api/location/AMapLocationQualityReport:<init>	()V
    //   114: putfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   117: aload_0
    //   118: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   121: aload_0
    //   122: getfield 86	com/loc/e:a	Lcom/amap/api/location/AMapLocationClientOption;
    //   125: invokevirtual 437	com/amap/api/location/AMapLocationClientOption:getLocationMode	()Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   128: invokevirtual 441	com/amap/api/location/AMapLocationQualityReport:setLocationMode	(Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;)V
    //   131: aload_0
    //   132: getfield 88	com/loc/e:c	Lcom/loc/h;
    //   135: ifnull +31 -> 166
    //   138: aload_0
    //   139: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   142: aload_0
    //   143: getfield 88	com/loc/e:c	Lcom/loc/h;
    //   146: invokevirtual 443	com/loc/h:d	()I
    //   149: invokevirtual 446	com/amap/api/location/AMapLocationQualityReport:setGPSSatellites	(I)V
    //   152: aload_0
    //   153: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   156: aload_0
    //   157: getfield 88	com/loc/e:c	Lcom/loc/h;
    //   160: invokevirtual 448	com/loc/h:c	()I
    //   163: invokevirtual 451	com/amap/api/location/AMapLocationQualityReport:setGpsStatus	(I)V
    //   166: aload_0
    //   167: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   170: invokestatic 456	com/loc/dn:h	(Landroid/content/Context;)Z
    //   173: istore 4
    //   175: aload_0
    //   176: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   179: iload 4
    //   181: invokevirtual 460	com/amap/api/location/AMapLocationQualityReport:setWifiAble	(Z)V
    //   184: aload_0
    //   185: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   188: aload_0
    //   189: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   192: invokestatic 462	com/loc/dn:i	(Landroid/content/Context;)Ljava/lang/String;
    //   195: invokevirtual 465	com/amap/api/location/AMapLocationQualityReport:setNetworkType	(Ljava/lang/String;)V
    //   198: aload_2
    //   199: invokevirtual 468	com/amap/api/location/AMapLocation:getLocationType	()I
    //   202: iconst_1
    //   203: if_icmpeq +16 -> 219
    //   206: ldc_w 418
    //   209: aload_2
    //   210: invokevirtual 421	com/amap/api/location/AMapLocation:getProvider	()Ljava/lang/String;
    //   213: invokevirtual 425	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   216: ifeq +11 -> 227
    //   219: aload_0
    //   220: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   223: lconst_0
    //   224: invokevirtual 472	com/amap/api/location/AMapLocationQualityReport:setNetUseTime	(J)V
    //   227: aload_3
    //   228: ifnull +14 -> 242
    //   231: aload_0
    //   232: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   235: aload_3
    //   236: invokevirtual 475	com/loc/d:a	()J
    //   239: invokevirtual 472	com/amap/api/location/AMapLocationQualityReport:setNetUseTime	(J)V
    //   242: aload_0
    //   243: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   246: getstatic 477	com/loc/e:E	Z
    //   249: invokevirtual 480	com/amap/api/location/AMapLocationQualityReport:setInstallHighDangerMockApp	(Z)V
    //   252: aload_2
    //   253: aload_0
    //   254: getfield 141	com/loc/e:t	Lcom/amap/api/location/AMapLocationQualityReport;
    //   257: invokevirtual 484	com/amap/api/location/AMapLocation:setLocationQualityReport	(Lcom/amap/api/location/AMapLocationQualityReport;)V
    //   260: aload_0
    //   261: getfield 92	com/loc/e:B	Z
    //   264: ifeq +119 -> 383
    //   267: aload_0
    //   268: getfield 149	com/loc/e:x	Ljava/lang/String;
    //   271: astore_1
    //   272: new 247	android/os/Bundle
    //   275: dup
    //   276: invokespecial 248	android/os/Bundle:<init>	()V
    //   279: astore 5
    //   281: aload 5
    //   283: ldc_w 362
    //   286: aload_2
    //   287: invokevirtual 488	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   290: aload 5
    //   292: ldc_w 490
    //   295: aload_1
    //   296: invokevirtual 262	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_0
    //   300: sipush 1014
    //   303: aload 5
    //   305: lconst_0
    //   306: invokespecial 492	com/loc/e:a	(ILjava/lang/Object;J)V
    //   309: aload_3
    //   310: ifnull +10 -> 320
    //   313: aload_3
    //   314: invokestatic 494	com/loc/dn:b	()J
    //   317: invokevirtual 496	com/loc/d:d	(J)V
    //   320: aload_0
    //   321: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   324: aload_2
    //   325: aload_3
    //   326: invokestatic 499	com/loc/dk:a	(Landroid/content/Context;Lcom/amap/api/location/AMapLocation;Lcom/loc/d;)V
    //   329: aload_0
    //   330: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   333: aload_2
    //   334: invokestatic 502	com/loc/dk:a	(Landroid/content/Context;Lcom/amap/api/location/AMapLocation;)V
    //   337: aload_2
    //   338: invokevirtual 506	com/amap/api/location/AMapLocation:clone	()Lcom/amap/api/location/AMapLocation;
    //   341: astore_1
    //   342: aload_0
    //   343: getfield 182	com/loc/e:b	Lcom/loc/e$c;
    //   346: invokevirtual 509	com/loc/e$c:obtainMessage	()Landroid/os/Message;
    //   349: astore_2
    //   350: aload_2
    //   351: bipush 10
    //   353: putfield 271	android/os/Message:what	I
    //   356: aload_2
    //   357: aload_1
    //   358: putfield 305	android/os/Message:obj	Ljava/lang/Object;
    //   361: aload_0
    //   362: getfield 182	com/loc/e:b	Lcom/loc/e$c;
    //   365: aload_2
    //   366: invokevirtual 513	com/loc/e$c:sendMessage	(Landroid/os/Message;)Z
    //   369: pop
    //   370: goto +13 -> 383
    //   373: astore_1
    //   374: aload_1
    //   375: ldc -71
    //   377: ldc_w 515
    //   380: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_0
    //   384: getfield 115	com/loc/e:m	Z
    //   387: ifeq +16 -> 403
    //   390: invokestatic 158	com/loc/dg:d	()Z
    //   393: istore 4
    //   395: iload 4
    //   397: ifne +6 -> 403
    //   400: aload_0
    //   401: monitorexit
    //   402: return
    //   403: aload_0
    //   404: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   407: invokestatic 517	com/loc/dl:b	(Landroid/content/Context;)V
    //   410: aload_0
    //   411: getfield 86	com/loc/e:a	Lcom/amap/api/location/AMapLocationClientOption;
    //   414: invokevirtual 520	com/amap/api/location/AMapLocationClientOption:isOnceLocation	()Z
    //   417: ifeq +7 -> 424
    //   420: aload_0
    //   421: invokespecial 522	com/loc/e:d	()V
    //   424: aload_0
    //   425: monitorexit
    //   426: return
    //   427: astore_1
    //   428: goto +16 -> 444
    //   431: astore_1
    //   432: aload_1
    //   433: ldc -71
    //   435: ldc_w 524
    //   438: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   441: aload_0
    //   442: monitorexit
    //   443: return
    //   444: aload_0
    //   445: monitorexit
    //   446: aload_1
    //   447: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	e
    //   0	448	1	paramAMapLocation	AMapLocation
    //   0	448	2	paramThrowable	Throwable
    //   0	448	3	paramd	d
    //   173	223	4	bool	boolean
    //   279	25	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   260	309	373	java/lang/Throwable
    //   313	320	373	java/lang/Throwable
    //   320	370	373	java/lang/Throwable
    //   2	8	427	finally
    //   16	30	427	finally
    //   33	46	427	finally
    //   55	79	427	finally
    //   79	99	427	finally
    //   99	117	427	finally
    //   117	166	427	finally
    //   166	219	427	finally
    //   219	227	427	finally
    //   231	242	427	finally
    //   242	260	427	finally
    //   260	309	427	finally
    //   313	320	427	finally
    //   320	370	427	finally
    //   374	383	427	finally
    //   383	395	427	finally
    //   403	424	427	finally
    //   432	441	427	finally
    //   2	8	431	java/lang/Throwable
    //   16	30	431	java/lang/Throwable
    //   33	46	431	java/lang/Throwable
    //   55	79	431	java/lang/Throwable
    //   79	99	431	java/lang/Throwable
    //   99	117	431	java/lang/Throwable
    //   117	166	431	java/lang/Throwable
    //   166	219	431	java/lang/Throwable
    //   219	227	431	java/lang/Throwable
    //   231	242	431	java/lang/Throwable
    //   242	260	431	java/lang/Throwable
    //   374	383	431	java/lang/Throwable
    //   383	395	431	java/lang/Throwable
    //   403	424	431	java/lang/Throwable
  }
  
  private static void a(cl paramcl, co paramco)
  {
    if (paramco != null) {
      try
      {
        if (paramco.getErrorCode() == 0)
        {
          paramcl.b(paramco);
          return;
        }
      }
      catch (Throwable paramcl)
      {
        dg.a(paramcl, "ALManager", "apsLocation:doFirstAddCache");
      }
    }
  }
  
  /* Error */
  private co b(cl paramcl)
  {
    // Byte code:
    //   0: new 376	com/loc/d
    //   3: dup
    //   4: invokespecial 646	com/loc/d:<init>	()V
    //   7: astore 8
    //   9: iconst_0
    //   10: istore_2
    //   11: aconst_null
    //   12: astore 7
    //   14: aload 8
    //   16: invokestatic 494	com/loc/dn:b	()J
    //   19: invokevirtual 648	com/loc/d:c	(J)V
    //   22: invokestatic 651	com/amap/api/location/AMapLocationClientOption:getAPIKEY	()Ljava/lang/String;
    //   25: astore 4
    //   27: aload 4
    //   29: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +27 -> 59
    //   35: aload_0
    //   36: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   39: aload 4
    //   41: invokestatic 656	com/loc/m:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   44: goto +15 -> 59
    //   47: astore 4
    //   49: aload 4
    //   51: ldc -71
    //   53: ldc_w 658
    //   56: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokestatic 663	com/amap/api/location/UmidtokenInfo:getUmidtoken	()Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +23 -> 92
    //   72: aload 4
    //   74: invokestatic 667	com/loc/p:a	(Ljava/lang/String;)V
    //   77: goto +15 -> 92
    //   80: astore 4
    //   82: aload 4
    //   84: ldc -71
    //   86: ldc_w 669
    //   89: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: aload_0
    //   94: getfield 153	com/loc/e:z	Landroid/content/Context;
    //   97: invokevirtual 671	com/loc/cl:a	(Landroid/content/Context;)V
    //   100: aload_1
    //   101: aload_0
    //   102: getfield 86	com/loc/e:a	Lcom/amap/api/location/AMapLocationClientOption;
    //   105: invokevirtual 674	com/loc/cl:a	(Lcom/amap/api/location/AMapLocationClientOption;)V
    //   108: aload_1
    //   109: aload 8
    //   111: invokevirtual 677	com/loc/cl:b	(Lcom/loc/d;)V
    //   114: goto +15 -> 129
    //   117: astore 4
    //   119: aload 4
    //   121: ldc -71
    //   123: ldc_w 679
    //   126: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   129: invokestatic 683	com/loc/df:s	()Z
    //   132: istore_3
    //   133: aload_0
    //   134: aload_1
    //   135: invokespecial 685	com/loc/e:a	(Lcom/loc/cl;)Lcom/loc/co;
    //   138: astore 5
    //   140: aload 5
    //   142: astore 4
    //   144: aload 5
    //   146: ifnonnull +60 -> 206
    //   149: aload_1
    //   150: iload_3
    //   151: iconst_1
    //   152: ixor
    //   153: aload 8
    //   155: invokevirtual 688	com/loc/cl:a	(ZLcom/loc/d;)Lcom/loc/co;
    //   158: astore 4
    //   160: iload_3
    //   161: ifne +17 -> 178
    //   164: aload_1
    //   165: aload 4
    //   167: invokestatic 690	com/loc/e:a	(Lcom/loc/cl;Lcom/loc/co;)V
    //   170: goto +8 -> 178
    //   173: astore 6
    //   175: goto +14 -> 189
    //   178: iconst_1
    //   179: istore_2
    //   180: goto +26 -> 206
    //   183: astore 6
    //   185: aload 5
    //   187: astore 4
    //   189: aload 4
    //   191: astore 5
    //   193: aload 6
    //   195: ldc -71
    //   197: ldc_w 692
    //   200: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   203: goto -25 -> 178
    //   206: aload 4
    //   208: ifnull +37 -> 245
    //   211: aload 4
    //   213: astore 5
    //   215: aload 4
    //   217: invokevirtual 694	com/loc/co:k	()Ljava/lang/String;
    //   220: astore 7
    //   222: aload 4
    //   224: astore 5
    //   226: aload 4
    //   228: invokevirtual 695	com/loc/co:clone	()Lcom/amap/api/location/AMapLocation;
    //   231: astore 6
    //   233: aload 7
    //   235: astore 5
    //   237: goto +15 -> 252
    //   240: astore 4
    //   242: goto +230 -> 472
    //   245: aconst_null
    //   246: astore 5
    //   248: aload 7
    //   250: astore 6
    //   252: aload 6
    //   254: astore 7
    //   256: aload_0
    //   257: getfield 86	com/loc/e:a	Lcom/amap/api/location/AMapLocationClientOption;
    //   260: invokevirtual 233	com/amap/api/location/AMapLocationClientOption:isLocationCacheEnable	()Z
    //   263: ifeq +57 -> 320
    //   266: aload 6
    //   268: astore 7
    //   270: aload_0
    //   271: getfield 197	com/loc/e:g	Lcom/loc/j;
    //   274: ifnull +46 -> 320
    //   277: aload_0
    //   278: getfield 197	com/loc/e:g	Lcom/loc/j;
    //   281: aload 6
    //   283: aload 5
    //   285: aload_0
    //   286: getfield 86	com/loc/e:a	Lcom/amap/api/location/AMapLocationClientOption;
    //   289: invokevirtual 698	com/amap/api/location/AMapLocationClientOption:getLastLocationLifeCycle	()J
    //   292: invokevirtual 701	com/loc/j:a	(Lcom/amap/api/location/AMapLocation;Ljava/lang/String;J)Lcom/amap/api/location/AMapLocation;
    //   295: astore 7
    //   297: goto +23 -> 320
    //   300: astore 7
    //   302: aload 4
    //   304: astore 5
    //   306: aload 7
    //   308: ldc -71
    //   310: ldc_w 703
    //   313: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 6
    //   318: astore 7
    //   320: new 247	android/os/Bundle
    //   323: dup
    //   324: invokespecial 248	android/os/Bundle:<init>	()V
    //   327: astore 5
    //   329: aload 7
    //   331: ifnull +36 -> 367
    //   334: aload 5
    //   336: ldc_w 362
    //   339: aload 7
    //   341: invokevirtual 488	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   344: aload 5
    //   346: ldc_w 368
    //   349: aload 4
    //   351: invokevirtual 694	com/loc/co:k	()Ljava/lang/String;
    //   354: invokevirtual 262	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 5
    //   359: ldc_w 374
    //   362: aload 8
    //   364: invokevirtual 488	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   367: aload_0
    //   368: aload 5
    //   370: invokespecial 705	com/loc/e:a	(Landroid/os/Bundle;)V
    //   373: goto +19 -> 392
    //   376: astore 6
    //   378: aload 4
    //   380: astore 5
    //   382: aload 6
    //   384: ldc -71
    //   386: ldc_w 707
    //   389: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 4
    //   394: astore 5
    //   396: iload_2
    //   397: ifeq +58 -> 455
    //   400: aload 4
    //   402: astore 5
    //   404: iload_3
    //   405: ifeq +50 -> 455
    //   408: aload_1
    //   409: invokevirtual 709	com/loc/cl:c	()V
    //   412: aload_1
    //   413: aload_1
    //   414: iconst_1
    //   415: new 376	com/loc/d
    //   418: dup
    //   419: invokespecial 646	com/loc/d:<init>	()V
    //   422: invokevirtual 688	com/loc/cl:a	(ZLcom/loc/d;)Lcom/loc/co;
    //   425: invokestatic 690	com/loc/e:a	(Lcom/loc/cl;Lcom/loc/co;)V
    //   428: aload 4
    //   430: astore 5
    //   432: goto +23 -> 455
    //   435: astore 6
    //   437: aload 4
    //   439: astore 5
    //   441: aload 6
    //   443: ldc -71
    //   445: ldc_w 711
    //   448: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload 4
    //   453: astore 5
    //   455: aload_1
    //   456: invokevirtual 713	com/loc/cl:e	()V
    //   459: aload 5
    //   461: areturn
    //   462: astore 4
    //   464: goto +21 -> 485
    //   467: astore 4
    //   469: aconst_null
    //   470: astore 5
    //   472: aload 4
    //   474: ldc -71
    //   476: ldc_w 715
    //   479: invokestatic 190	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -27 -> 455
    //   485: aload_1
    //   486: invokevirtual 713	com/loc/cl:e	()V
    //   489: aload 4
    //   491: athrow
    //   492: astore_1
    //   493: aload 5
    //   495: areturn
    //   496: astore_1
    //   497: goto -8 -> 489
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	e
    //   0	500	1	paramcl	cl
    //   10	387	2	i1	int
    //   132	273	3	bool	boolean
    //   25	15	4	str1	String
    //   47	3	4	localThrowable1	Throwable
    //   62	11	4	str2	String
    //   80	3	4	localThrowable2	Throwable
    //   117	3	4	localThrowable3	Throwable
    //   142	85	4	localObject1	Object
    //   240	212	4	localThrowable4	Throwable
    //   462	1	4	localObject2	Object
    //   467	23	4	localThrowable5	Throwable
    //   138	356	5	localObject3	Object
    //   173	1	6	localThrowable6	Throwable
    //   183	11	6	localThrowable7	Throwable
    //   231	86	6	localObject4	Object
    //   376	7	6	localThrowable8	Throwable
    //   435	7	6	localThrowable9	Throwable
    //   12	284	7	localObject5	Object
    //   300	7	7	localThrowable10	Throwable
    //   318	22	7	localObject6	Object
    //   7	356	8	locald	d
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/lang/Throwable
    //   59	77	80	java/lang/Throwable
    //   92	114	117	java/lang/Throwable
    //   164	170	173	java/lang/Throwable
    //   149	160	183	java/lang/Throwable
    //   193	203	240	java/lang/Throwable
    //   215	222	240	java/lang/Throwable
    //   226	233	240	java/lang/Throwable
    //   306	316	240	java/lang/Throwable
    //   382	392	240	java/lang/Throwable
    //   441	451	240	java/lang/Throwable
    //   256	266	300	java/lang/Throwable
    //   270	297	300	java/lang/Throwable
    //   320	329	376	java/lang/Throwable
    //   334	367	376	java/lang/Throwable
    //   367	373	376	java/lang/Throwable
    //   408	428	435	java/lang/Throwable
    //   14	22	462	finally
    //   22	44	462	finally
    //   49	59	462	finally
    //   59	77	462	finally
    //   82	92	462	finally
    //   92	114	462	finally
    //   119	129	462	finally
    //   129	140	462	finally
    //   149	160	462	finally
    //   164	170	462	finally
    //   193	203	462	finally
    //   215	222	462	finally
    //   226	233	462	finally
    //   256	266	462	finally
    //   270	297	462	finally
    //   306	316	462	finally
    //   320	329	462	finally
    //   334	367	462	finally
    //   367	373	462	finally
    //   382	392	462	finally
    //   408	428	462	finally
    //   441	451	462	finally
    //   472	482	462	finally
    //   14	22	467	java/lang/Throwable
    //   49	59	467	java/lang/Throwable
    //   82	92	467	java/lang/Throwable
    //   119	129	467	java/lang/Throwable
    //   129	140	467	java/lang/Throwable
    //   455	459	492	java/lang/Throwable
    //   485	489	496	java/lang/Throwable
  }
  
  private boolean b()
  {
    boolean bool = false;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (this.h == null)
        {
          Thread.sleep(100L);
          int i2 = i1 + 1;
          i1 = i2;
          if (i2 < 50) {
            continue;
          }
        }
        if (this.h == null)
        {
          Message localMessage = Message.obtain();
          Bundle localBundle = new Bundle();
          AMapLocation localAMapLocation = new AMapLocation("");
          localAMapLocation.setErrorCode(10);
          if (dn.l(this.z.getApplicationContext())) {
            break label187;
          }
          String str1 = "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003";
          localAMapLocation.setLocationDetail(str1);
          localBundle.putParcelable("loc", localAMapLocation);
          localMessage.setData(localBundle);
          localMessage.what = 1;
          this.b.sendMessage(localMessage);
        }
        else
        {
          bool = true;
        }
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "ALManager", "checkAPSManager");
      }
      if (!bool)
      {
        if (!dn.l(this.z.getApplicationContext())) {}
        for (i1 = 2103;; i1 = 2101)
        {
          dk.a(null, i1);
          return bool;
        }
      }
      return bool;
      label187:
      String str2 = "启动ApsServcie失败#1001";
    }
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          this.a = new AMapLocationClientOption();
        }
        boolean bool = this.B;
        if (bool) {
          return;
        }
        this.B = true;
        int i1 = 2.a[this.a.getLocationMode().ordinal()];
        long l2 = 0L;
        switch (i1)
        {
        case 3: 
          a(1015, null, 0L);
          long l1 = l2;
          if (this.a.isGpsFirst())
          {
            l1 = l2;
            if (this.a.isOnceLocation()) {
              l1 = this.a.getGpsFirstTimeout();
            }
          }
          a(1016, null, l1);
          break;
        case 2: 
          a(1016);
          a(1015, null, 0L);
          return;
        case 1: 
          a(1017, null, 0L);
          a(1016, null, 0L);
          return;
          return;
        }
      }
      finally {}
    }
  }
  
  private void d()
  {
    try
    {
      a(1025);
      if (this.c != null) {
        this.c.a();
      }
      a(1016);
      this.B = false;
      this.k = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "stopLocation");
    }
  }
  
  private void e()
  {
    if (this.a.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors)
    {
      long l2 = this.a.getInterval();
      long l1 = 1000L;
      if (l2 >= 1000L) {
        l1 = this.a.getInterval();
      }
      a(1016, null, l1);
    }
  }
  
  private void f()
  {
    try
    {
      if (this.i == null) {
        this.i = new Messenger(this.b);
      }
      Intent localIntent = g();
      try
      {
        this.z.bindService(localIntent, this.G, 1);
        return;
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "ALManager", "startServiceImpl");
        return;
      }
      return;
    }
    catch (Throwable localThrowable2) {}
  }
  
  private Intent g()
  {
    if (this.j == null) {
      this.j = new Intent(this.z, APSService.class);
    }
    String str2;
    try
    {
      String str1;
      if (!TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY())) {
        str1 = AMapLocationClientOption.getAPIKEY();
      } else {
        str1 = l.f(this.z);
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "startServiceImpl p2");
      str2 = "";
    }
    this.j.putExtra("a", str2);
    this.j.putExtra("b", l.c(this.z));
    this.j.putExtra("d", UmidtokenInfo.getUmidtoken());
    this.j.putExtra("f", AMapLocationClientOption.isDownloadCoordinateConvertLibrary());
    return this.j;
  }
  
  private boolean h()
  {
    int i1;
    if (dn.k(this.z)) {
      i1 = -1;
    }
    try
    {
      int i2 = dj.b(((Application)this.z.getApplicationContext()).getBaseContext(), "checkSelfPermission", new Object[] { "android.permission.FOREGROUND_SERVICE" });
      i1 = i2;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    if (i1 != 0) {
      return false;
    }
    return true;
  }
  
  final void a()
  {
    a(12, null);
    C = true;
    this.f = true;
    this.A = false;
    this.q = false;
    d();
    if (this.p != null) {
      this.p.b(this.z);
    }
    dk.a(this.z);
    if (this.r != null) {
      this.r.d.sendEmptyMessage(11);
    } else if (this.G != null) {
      this.z.unbindService(this.G);
    }
    try
    {
      if (this.y) {
        this.z.stopService(g());
      }
      this.y = false;
      if (this.d != null)
      {
        this.d.clear();
        this.d = null;
      }
      this.G = null;
      synchronized (this.o)
      {
        if (this.w != null) {
          this.w.removeCallbacksAndMessages(null);
        }
        this.w = null;
        if ((this.l == null) || (Build.VERSION.SDK_INT >= 18)) {}
        try
        {
          dj.a(this.l, HandlerThread.class, "quitSafely", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          for (;;) {}
        }
        this.l.quit();
        this.l = null;
        if (this.b != null) {
          this.b.removeCallbacksAndMessages(null);
        }
        if (this.g != null)
        {
          this.g.c();
          this.g = null;
        }
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;) {}
    }
  }
  
  public void disableBackgroundLocation(boolean paramBoolean)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("j", paramBoolean);
      a(1024, localBundle, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "disableBackgroundLocation");
    }
  }
  
  public void enableBackgroundLocation(int paramInt, Notification paramNotification)
  {
    if (paramInt != 0)
    {
      if (paramNotification == null) {
        return;
      }
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("i", paramInt);
        localBundle.putParcelable("h", paramNotification);
        a(1023, localBundle, 0L);
        return;
      }
      catch (Throwable paramNotification)
      {
        dg.a(paramNotification, "ALManager", "disableBackgroundLocation");
      }
    }
  }
  
  public AMapLocation getLastKnownLocation()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      if (this.g != null)
      {
        localObject1 = this.g.b();
        if (localObject1 != null) {
          try
          {
            ((AMapLocation)localObject1).setTrustedLevel(3);
          }
          catch (Throwable localThrowable1)
          {
            break label40;
          }
        }
        return (AMapLocation)localObject1;
      }
    }
    catch (Throwable localThrowable2)
    {
      localObject1 = localObject2;
      label40:
      dg.a(localThrowable2, "ALManager", "getLastKnownLocation");
    }
    return (AMapLocation)localObject1;
  }
  
  public boolean isStarted()
  {
    return this.A;
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.F != null)
      {
        this.F.b();
        this.F = null;
      }
      a(1011, null, 0L);
      this.m = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "onDestroy");
    }
  }
  
  public void setLocationListener(AMapLocationListener paramAMapLocationListener)
  {
    try
    {
      a(1002, paramAMapLocationListener, 0L);
      return;
    }
    catch (Throwable paramAMapLocationListener)
    {
      dg.a(paramAMapLocationListener, "ALManager", "setLocationListener");
    }
  }
  
  public void setLocationOption(AMapLocationClientOption paramAMapLocationClientOption)
  {
    try
    {
      a(1018, paramAMapLocationClientOption.clone(), 0L);
      return;
    }
    catch (Throwable paramAMapLocationClientOption)
    {
      dg.a(paramAMapLocationClientOption, "ALManager", "setLocationOption");
    }
  }
  
  public void startAssistantLocation()
  {
    try
    {
      a(1008, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "startAssistantLocation");
    }
  }
  
  public void startAssistantLocation(WebView paramWebView)
  {
    if (this.F == null) {
      this.F = new i(this.z, paramWebView);
    }
    this.F.a();
  }
  
  public void startLocation()
  {
    try
    {
      a(1003, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "startLocation");
    }
  }
  
  public void stopAssistantLocation()
  {
    try
    {
      if (this.F != null)
      {
        this.F.b();
        this.F = null;
      }
      a(1009, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "stopAssistantLocation");
    }
  }
  
  public void stopLocation()
  {
    try
    {
      a(1004, null, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "ALManager", "stopLocation");
    }
  }
  
  public void unRegisterLocationListener(AMapLocationListener paramAMapLocationListener)
  {
    try
    {
      a(1005, paramAMapLocationListener, 0L);
      return;
    }
    catch (Throwable paramAMapLocationListener)
    {
      dg.a(paramAMapLocationListener, "ALManager", "unRegisterLocationListener");
    }
  }
  
  public final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      for (;;)
      {
        try
        {
          super.handleMessage(paramMessage);
          i = paramMessage.what;
          switch (i)
          {
          case 12: 
            localObject1 = "handleMessage ACTION_REBOOT_GPS_LOCATION";
            paramMessage = (Message)localObject1;
            try
            {
              localObject3 = e.this.c;
              paramMessage = (Message)localObject1;
              if (dn.b() - ((h)localObject3).d <= 300000L) {
                break;
              }
              i = 1;
              if (i != 0)
              {
                paramMessage = (Message)localObject1;
                e.this.c.a();
                paramMessage = (Message)localObject1;
                e.this.c.a(e.this.a);
              }
              paramMessage = (Message)localObject1;
              e.a(e.this, 1025, 300000L);
              return;
            }
            catch (Throwable localThrowable1) {}
            localObject1 = "handleMessage ACTION_DISABLE_BACKGROUND";
          case 11: 
            try
            {
              e.d(e.this, paramMessage);
              return;
            }
            catch (Throwable localThrowable3)
            {
              paramMessage = (Message)localObject2;
              Object localObject2 = localThrowable3;
            }
            localObject1 = "handleMessage ACTION_ENABLE_BACKGROUND";
            e.c(e.this, paramMessage);
            return;
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          Object localObject3;
          paramMessage = null;
        }
        localObject3 = "handleMessage SET_OPTION";
        localObject1 = localObject3;
        e.this.a = ((AMapLocationClientOption)paramMessage.obj);
        localObject1 = localObject3;
        if (e.this.a != null)
        {
          localObject1 = localObject3;
          e.f(e.this);
        }
        return;
        localObject1 = "handleMessage STOP_GPS_LOCATION";
        paramMessage = (Message)localObject1;
        e.this.c.a();
        paramMessage = (Message)localObject1;
        e.e(e.this);
        return;
        localObject1 = "handleMessage START_LBS_LOCATION";
        paramMessage = (Message)localObject1;
        if (e.this.c.b())
        {
          paramMessage = (Message)localObject1;
          e.a(e.this, 1016, 1000L);
          return;
        }
        paramMessage = (Message)localObject1;
        e.d(e.this);
        return;
        localObject1 = "handleMessage START_GPS_LOCATION";
        paramMessage = (Message)localObject1;
        e.this.c.a(e.this.a);
        paramMessage = (Message)localObject1;
        e.a(e.this, 1025, 300000L);
        return;
        localObject1 = "handleMessage ACTION_SAVE_LAST_LOCATION";
        e.b(e.this, paramMessage);
        return;
        paramMessage = "handleMessage DESTROY";
        e.this.a();
        return;
        paramMessage = "handleMessage STOP_SOCKET";
        e.h(e.this);
        return;
        paramMessage = "handleMessage START_SOCKET";
        e.g(e.this);
        return;
        localObject1 = "handleMessage REMOVE_LISTENER";
        e.b(e.this, (AMapLocationListener)paramMessage.obj);
        return;
        paramMessage = "handleMessage STOP_LOCATION";
        e.c(e.this);
        return;
        paramMessage = "handleMessage START_LOCATION";
        e.b(e.this);
        return;
        localObject2 = "handleMessage SET_LISTENER";
        e.a(e.this, (AMapLocationListener)paramMessage.obj);
        return;
        localObject2 = "handleMessage ACTION_GPS_LOCATIONSUCCESS";
        e.a(e.this, paramMessage);
        return;
        localObject3 = "handleMessage ACTION_LBS_LOCATIONSUCCES";
        localObject2 = localObject3;
        paramMessage = paramMessage.getData();
        localObject2 = localObject3;
        e.b(e.this, paramMessage);
        return;
        Object localObject4 = paramMessage;
        if (paramMessage == null) {
          localObject4 = "handleMessage";
        }
        dg.a(localThrowable2, "AMapLocationManage$MHandlerr", (String)localObject4);
        return;
        switch (i)
        {
        }
        switch (i)
        {
        }
        return;
        int i = 0;
      }
    }
  }
  
  static final class b
    extends HandlerThread
  {
    e a = null;
    
    public b(String paramString, e parame)
    {
      super();
      this.a = parame;
    }
    
    protected final void onLooperPrepared()
    {
      try
      {
        this.a.g.a();
        e.a(this.a);
        super.onLooperPrepared();
        return;
      }
      catch (Throwable localThrowable) {}
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
  
  public final class c
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
        super.handleMessage(paramMessage);
        if ((e.this.m) && (!dg.d())) {
          return;
        }
        switch (paramMessage.what)
        {
        case 10: 
          localObject2 = "handleMessage RESULT_LBS_ON_CALLBACK";
          ??? = localObject2;
        case 9: 
        case 8: 
        case 7: 
        case 6: 
        case 5: 
        case 3: 
        case 2: 
        case 1: 
          try
          {
            paramMessage = (AMapLocation)paramMessage.obj;
            ??? = localObject2;
            e.a(e.this, paramMessage);
            return;
          }
          catch (Throwable paramMessage) {}
          ??? = "handleMessage RESULT_INSTALLED_MOCK_APP";
          e.a(paramMessage.getData().getBoolean("installMockApp"));
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        Object localObject3;
        label323:
        ??? = null;
        Object localObject2 = ???;
        if (??? != null) {
          break label439;
        }
        localObject2 = "handleMessage";
        label439:
        dg.a(paramMessage, "AmapLocationManager$MainHandler", (String)localObject2);
        return;
      }
      dk.a(null, 2141);
      break label323;
      localObject2 = "handleMessage RESULT_NGPS_ABLE";
      ??? = localObject2;
      paramMessage = paramMessage.getData();
      ??? = localObject2;
      e.b(e.this, paramMessage.getBoolean("ngpsAble"));
      return;
      localObject2 = "handleMessage RESULT_GPS_GEO_SUCCESS";
      ??? = localObject2;
      localObject3 = paramMessage.getData();
      ??? = localObject2;
      if (e.this.c != null)
      {
        ??? = localObject2;
        paramMessage = e.this.c;
        if (localObject3 != null) {
          try
          {
            ((Bundle)localObject3).setClassLoader(AMapLocation.class.getClassLoader());
            paramMessage.g = ((Bundle)localObject3).getInt("I_MAX_GEO_DIS");
            paramMessage.h = ((Bundle)localObject3).getInt("I_MIN_GEO_DIS");
            localObject3 = (AMapLocation)((Bundle)localObject3).getParcelable("loc");
            if (!TextUtils.isEmpty(((AMapLocation)localObject3).getAdCode())) {
              synchronized (paramMessage.o)
              {
                paramMessage.y = ((AMapLocation)localObject3);
                return;
              }
            }
            return;
          }
          catch (Throwable paramMessage)
          {
            ??? = localObject2;
            dg.a(paramMessage, "GpsLocation", "setLastGeoLocation");
          }
        }
        localObject2 = "handleMessage RESULT_GPS_LOCATIONCHANGE";
        ??? = localObject2;
        paramMessage = paramMessage.getData();
        ??? = localObject2;
        paramMessage.putBundle("optBundle", dg.a(e.this.a));
        ??? = localObject2;
        e.a(e.this, paramMessage);
        return;
        localObject2 = "handleMessage RESULT_GPS_LOCATIONSUCCESS";
        ??? = localObject2;
        localObject3 = Message.obtain();
        ??? = localObject2;
        ((Message)localObject3).what = 12;
        ??? = localObject2;
        ((Message)localObject3).obj = paramMessage.obj;
        ??? = localObject2;
        e.this.w.sendMessage((Message)localObject3);
        return;
        localObject2 = "handleMessage RESULT_LBS_LOCATIONSUCCESS";
        ??? = localObject2;
        localObject3 = e.this.w.obtainMessage();
        ??? = localObject2;
        ((Message)localObject3).what = 11;
        ??? = localObject2;
        ((Message)localObject3).setData(paramMessage.getData());
        ??? = localObject2;
        e.this.w.sendMessage((Message)localObject3);
        return;
      }
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */