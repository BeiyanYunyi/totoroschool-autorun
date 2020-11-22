package com.amap.api.mapcore.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class fp
{
  static String a = "";
  static String b = "";
  public static boolean c = false;
  static String d = "";
  static boolean e = false;
  static int f = -1;
  static String g = "";
  static String h = "";
  private static String i;
  private static boolean j = false;
  private static String k = "";
  private static boolean l = false;
  private static String m = "";
  private static String n = "";
  private static String o = "";
  private static String p = "";
  private static String q = "";
  private static String r = "";
  private static boolean s = false;
  private static long t = 0L;
  private static int u = 0;
  private static String v;
  private static String w = "";
  
  static String A(Context paramContext)
  {
    try
    {
      paramContext = F(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  /* Error */
  private static String C(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 7
    //   11: astore 4
    //   13: aload_0
    //   14: ldc 60
    //   16: invokestatic 65	com/amap/api/mapcore/util/fw:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   19: ifeq +219 -> 238
    //   22: aload 7
    //   24: astore 4
    //   26: ldc 67
    //   28: invokestatic 73	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   31: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +204 -> 238
    //   37: invokestatic 83	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   40: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: astore_0
    //   44: new 90	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   51: astore 4
    //   53: aload 4
    //   55: aload_0
    //   56: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 4
    //   62: ldc 99
    //   64: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: new 85	java/io/File
    //   71: dup
    //   72: aload 4
    //   74: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore_0
    //   81: invokestatic 111	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   84: astore 4
    //   86: aload 4
    //   88: invokeinterface 117 1 0
    //   93: istore_3
    //   94: new 119	java/io/FileInputStream
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: astore_0
    //   103: aload 4
    //   105: aload_0
    //   106: ldc 124
    //   108: invokeinterface 128 3 0
    //   113: iconst_0
    //   114: istore_1
    //   115: goto +190 -> 305
    //   118: iload_1
    //   119: istore_2
    //   120: iload_1
    //   121: ifeq +84 -> 205
    //   124: aload 4
    //   126: invokeinterface 131 1 0
    //   131: astore 4
    //   133: aload_0
    //   134: invokevirtual 136	java/io/InputStream:close	()V
    //   137: aload 4
    //   139: areturn
    //   140: iconst_0
    //   141: istore_2
    //   142: goto +63 -> 205
    //   145: iload_1
    //   146: istore_2
    //   147: aload 4
    //   149: invokeinterface 139 1 0
    //   154: ifle +51 -> 205
    //   157: aload 4
    //   159: invokeinterface 139 1 0
    //   164: istore_3
    //   165: iconst_0
    //   166: istore_2
    //   167: iload_2
    //   168: iload_3
    //   169: if_icmpge +189 -> 358
    //   172: aload 4
    //   174: iload_2
    //   175: invokeinterface 143 2 0
    //   180: astore 5
    //   182: ldc -111
    //   184: aload 5
    //   186: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifne +160 -> 349
    //   192: ldc -109
    //   194: aload 5
    //   196: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +152 -> 351
    //   202: goto +147 -> 349
    //   205: aload 4
    //   207: invokeinterface 150 1 0
    //   212: istore_3
    //   213: iload_2
    //   214: istore_1
    //   215: goto +90 -> 305
    //   218: aload_0
    //   219: astore 4
    //   221: goto +17 -> 238
    //   224: astore 5
    //   226: aload_0
    //   227: astore 4
    //   229: aload 5
    //   231: astore_0
    //   232: goto +26 -> 258
    //   235: goto +35 -> 270
    //   238: aload 4
    //   240: ifnull +37 -> 277
    //   243: aload 4
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 136	java/io/InputStream:close	()V
    //   250: goto +27 -> 277
    //   253: astore_0
    //   254: aload 5
    //   256: astore 4
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 136	java/io/InputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: aload_0
    //   271: ifnull +6 -> 277
    //   274: goto -28 -> 246
    //   277: ldc 14
    //   279: areturn
    //   280: astore_0
    //   281: aload 6
    //   283: astore_0
    //   284: goto -14 -> 270
    //   287: astore 4
    //   289: goto -54 -> 235
    //   292: astore_0
    //   293: aload 4
    //   295: areturn
    //   296: astore_0
    //   297: goto -20 -> 277
    //   300: astore 4
    //   302: goto -34 -> 268
    //   305: iconst_1
    //   306: iload_3
    //   307: if_icmpeq -89 -> 218
    //   310: iload_1
    //   311: istore_2
    //   312: iload_3
    //   313: ifeq -108 -> 205
    //   316: iload_3
    //   317: tableswitch	default:+27->344, 2:+-172->145, 3:+-177->140, 4:+-199->118
    //   344: iload_1
    //   345: istore_2
    //   346: goto -141 -> 205
    //   349: iconst_1
    //   350: istore_1
    //   351: iload_2
    //   352: iconst_1
    //   353: iadd
    //   354: istore_2
    //   355: goto -188 -> 167
    //   358: iload_1
    //   359: istore_2
    //   360: goto -155 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramContext	Context
    //   114	245	1	i1	int
    //   119	241	2	i2	int
    //   93	224	3	i3	int
    //   11	253	4	localObject1	Object
    //   287	7	4	localThrowable1	Throwable
    //   300	1	4	localThrowable2	Throwable
    //   1	194	5	str	String
    //   224	31	5	localObject2	Object
    //   4	278	6	localObject3	Object
    //   7	16	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   103	113	224	finally
    //   124	133	224	finally
    //   147	165	224	finally
    //   172	192	224	finally
    //   192	202	224	finally
    //   205	213	224	finally
    //   13	22	253	finally
    //   26	103	253	finally
    //   13	22	280	java/lang/Throwable
    //   26	103	280	java/lang/Throwable
    //   103	113	287	java/lang/Throwable
    //   124	133	287	java/lang/Throwable
    //   147	165	287	java/lang/Throwable
    //   172	192	287	java/lang/Throwable
    //   192	202	287	java/lang/Throwable
    //   205	213	287	java/lang/Throwable
    //   133	137	292	java/lang/Throwable
    //   246	250	296	java/lang/Throwable
    //   263	268	300	java/lang/Throwable
  }
  
  private static String D(Context paramContext)
  {
    boolean bool = fw.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER);
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      try
      {
        localObject1 = Class.forName(fw.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
        localObject2 = ((Class)localObject1).newInstance();
        paramContext = ((Class)localObject1).getMethod(fw.c("MZ2V0T0FJRA"), new Class[] { Context.class }).invoke(localObject2, new Object[] { paramContext });
        if (paramContext == null) {
          break label238;
        }
        k = (String)paramContext;
        paramContext = k;
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        gg.a(paramContext, "oa", "xm");
        l = true;
      }
    }
    else
    {
      if (fw.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER)) {
        try
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setAction(fw.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
          ((Intent)localObject1).setPackage(fw.c("UY29tLmh1YXdlaS5od2lk"));
          localObject2 = new a();
          if (paramContext.bindService((Intent)localObject1, (ServiceConnection)localObject2, 1))
          {
            while ((i1 < 100) && (TextUtils.isEmpty(k)))
            {
              i1 += 1;
              Thread.sleep(15L);
            }
            paramContext.unbindService((ServiceConnection)localObject2);
          }
          paramContext = k;
          return paramContext;
        }
        catch (Throwable paramContext)
        {
          gg.a(paramContext, "oa", "hw");
          l = true;
        }
      }
      if ("OPPO".equalsIgnoreCase(Build.MANUFACTURER)) {
        l = true;
      } else {
        l = true;
      }
    }
    label238:
    return k;
  }
  
  private static String E(Context paramContext)
    throws InvocationTargetException, IllegalAccessException
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    if ((w != null) && (!"".equals(w))) {
      return w;
    }
    if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
      return w;
    }
    paramContext = K(paramContext);
    if (paramContext == null) {
      return "";
    }
    Method localMethod = fw.a(paramContext.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
    if (localMethod != null) {
      w = (String)localMethod.invoke(paramContext, new Object[0]);
    }
    if (w == null) {
      w = "";
    }
    return w;
  }
  
  private static String F(Context paramContext)
  {
    if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
      return null;
    }
    TelephonyManager localTelephonyManager = K(paramContext);
    if (localTelephonyManager == null) {
      return "";
    }
    String str = localTelephonyManager.getSimOperatorName();
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = localTelephonyManager.getNetworkOperatorName();
    }
    return paramContext;
  }
  
  private static int G(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!a(paramContext, fw.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
        return -1;
      }
      paramContext = H(paramContext);
      if (paramContext == null) {
        return -1;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return -1;
      }
      return paramContext.getType();
    }
    return -1;
  }
  
  private static ConnectivityManager H(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  private static String I(Context paramContext)
  {
    paramContext = y(paramContext);
    if (paramContext != null)
    {
      if (paramContext.length() < 5) {
        return "";
      }
      return paramContext.substring(3, 5);
    }
    return "";
  }
  
  private static int J(Context paramContext)
  {
    if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
      return -1;
    }
    paramContext = K(paramContext);
    if (paramContext == null) {
      return -1;
    }
    return paramContext.getNetworkType();
  }
  
  private static TelephonyManager K(Context paramContext)
  {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  private static String L(Context paramContext)
  {
    Object localObject = M(paramContext);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    try
    {
      paramContext = fw.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
      localObject = fq.b((String)localObject);
      paramContext = new String(fq.a(fw.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), (byte[])localObject, paramContext), "UTF-8");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  /* Error */
  private static String M(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 349
    //   3: invokestatic 155	com/amap/api/mapcore/util/fw:c	(Ljava/lang/String;)Ljava/lang/String;
    //   6: invokestatic 353	com/amap/api/mapcore/util/fs:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 5
    //   11: aload_0
    //   12: iconst_0
    //   13: invokestatic 356	com/amap/api/mapcore/util/fp:a	(Landroid/content/Context;Z)Ljava/lang/String;
    //   16: astore_0
    //   17: aload_0
    //   18: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +6 -> 27
    //   24: ldc 14
    //   26: areturn
    //   27: new 90	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   34: astore_2
    //   35: aload_2
    //   36: aload_0
    //   37: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_2
    //   42: getstatic 359	java/io/File:separator	Ljava/lang/String;
    //   45: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: ldc_w 361
    //   53: invokestatic 155	com/amap/api/mapcore/util/fw:c	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: new 85	java/io/File
    //   63: dup
    //   64: aload_2
    //   65: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc_w 363
    //   71: invokestatic 155	com/amap/api/mapcore/util/fw:c	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 370	java/io/File:exists	()Z
    //   82: ifeq +247 -> 329
    //   85: aload_0
    //   86: invokevirtual 373	java/io/File:canRead	()Z
    //   89: ifne +6 -> 95
    //   92: goto +237 -> 329
    //   95: aload_0
    //   96: invokevirtual 376	java/io/File:length	()J
    //   99: lconst_0
    //   100: lcmp
    //   101: ifne +11 -> 112
    //   104: aload_0
    //   105: invokevirtual 379	java/io/File:delete	()Z
    //   108: pop
    //   109: ldc 14
    //   111: areturn
    //   112: new 381	java/io/RandomAccessFile
    //   115: dup
    //   116: aload_0
    //   117: ldc_w 382
    //   120: invokespecial 385	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   123: astore_0
    //   124: sipush 1024
    //   127: newarray <illegal type>
    //   129: astore_2
    //   130: new 387	java/io/ByteArrayOutputStream
    //   133: dup
    //   134: invokespecial 388	java/io/ByteArrayOutputStream:<init>	()V
    //   137: astore_3
    //   138: aload_0
    //   139: aload_2
    //   140: invokevirtual 392	java/io/RandomAccessFile:read	([B)I
    //   143: istore_1
    //   144: iload_1
    //   145: iconst_m1
    //   146: if_icmpeq +13 -> 159
    //   149: aload_3
    //   150: aload_2
    //   151: iconst_0
    //   152: iload_1
    //   153: invokevirtual 396	java/io/ByteArrayOutputStream:write	([BII)V
    //   156: goto -18 -> 138
    //   159: new 75	java/lang/String
    //   162: dup
    //   163: aload_3
    //   164: invokevirtual 400	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   167: ldc_w 331
    //   170: invokespecial 347	java/lang/String:<init>	([BLjava/lang/String;)V
    //   173: astore 6
    //   175: aload_0
    //   176: astore 4
    //   178: aload_3
    //   179: astore_2
    //   180: aload 6
    //   182: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +89 -> 274
    //   188: aload_0
    //   189: astore 4
    //   191: aload_3
    //   192: astore_2
    //   193: aload 6
    //   195: ldc_w 402
    //   198: invokestatic 155	com/amap/api/mapcore/util/fw:c	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual 405	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   204: ifeq +70 -> 274
    //   207: aload 6
    //   209: ldc_w 402
    //   212: invokestatic 155	com/amap/api/mapcore/util/fw:c	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 409	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   218: astore 6
    //   220: aload_0
    //   221: astore 4
    //   223: aload_3
    //   224: astore_2
    //   225: aload 6
    //   227: ifnull +47 -> 274
    //   230: aload_0
    //   231: astore 4
    //   233: aload_3
    //   234: astore_2
    //   235: aload 6
    //   237: arraylength
    //   238: iconst_2
    //   239: if_icmpne +35 -> 274
    //   242: aload_0
    //   243: astore 4
    //   245: aload_3
    //   246: astore_2
    //   247: aload 5
    //   249: aload 6
    //   251: iconst_0
    //   252: aaload
    //   253: invokestatic 412	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   256: ifeq +18 -> 274
    //   259: aload 6
    //   261: iconst_1
    //   262: aaload
    //   263: astore_2
    //   264: aload_3
    //   265: invokestatic 415	com/amap/api/mapcore/util/fp:a	(Ljava/io/Closeable;)V
    //   268: aload_0
    //   269: invokestatic 415	com/amap/api/mapcore/util/fp:a	(Ljava/io/Closeable;)V
    //   272: aload_2
    //   273: areturn
    //   274: aload_2
    //   275: invokestatic 415	com/amap/api/mapcore/util/fp:a	(Ljava/io/Closeable;)V
    //   278: aload 4
    //   280: invokestatic 415	com/amap/api/mapcore/util/fp:a	(Ljava/io/Closeable;)V
    //   283: goto +43 -> 326
    //   286: astore_2
    //   287: goto +20 -> 307
    //   290: astore_2
    //   291: goto +14 -> 305
    //   294: aconst_null
    //   295: astore_2
    //   296: aload_0
    //   297: astore 4
    //   299: goto -25 -> 274
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_0
    //   305: aconst_null
    //   306: astore_3
    //   307: aload_3
    //   308: invokestatic 415	com/amap/api/mapcore/util/fp:a	(Ljava/io/Closeable;)V
    //   311: aload_0
    //   312: invokestatic 415	com/amap/api/mapcore/util/fp:a	(Ljava/io/Closeable;)V
    //   315: aload_2
    //   316: athrow
    //   317: aconst_null
    //   318: astore 4
    //   320: aload 4
    //   322: astore_2
    //   323: goto -49 -> 274
    //   326: ldc 14
    //   328: areturn
    //   329: ldc 14
    //   331: areturn
    //   332: astore_0
    //   333: goto -16 -> 317
    //   336: astore_2
    //   337: goto -43 -> 294
    //   340: astore_2
    //   341: aload_0
    //   342: astore 4
    //   344: aload_3
    //   345: astore_2
    //   346: goto -72 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramContext	Context
    //   143	10	1	i1	int
    //   34	241	2	localObject1	Object
    //   286	1	2	localObject2	Object
    //   290	1	2	localObject3	Object
    //   295	1	2	localObject4	Object
    //   302	14	2	localObject5	Object
    //   322	1	2	localObject6	Object
    //   336	1	2	localThrowable1	Throwable
    //   340	1	2	localThrowable2	Throwable
    //   345	1	2	localObject7	Object
    //   137	208	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   176	167	4	localContext	Context
    //   9	239	5	str	String
    //   173	87	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   138	144	286	finally
    //   149	156	286	finally
    //   159	175	286	finally
    //   180	188	286	finally
    //   193	220	286	finally
    //   235	242	286	finally
    //   247	259	286	finally
    //   124	138	290	finally
    //   112	124	302	finally
    //   112	124	332	java/lang/Throwable
    //   124	138	336	java/lang/Throwable
    //   138	144	340	java/lang/Throwable
    //   149	156	340	java/lang/Throwable
    //   159	175	340	java/lang/Throwable
    //   180	188	340	java/lang/Throwable
    //   193	220	340	java/lang/Throwable
    //   235	242	340	java/lang/Throwable
    //   247	259	340	java/lang/Throwable
  }
  
  public static String a()
  {
    return i;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      if (!TextUtils.isEmpty(d)) {
        return d;
      }
      fv localfv = ge.a();
      if (ha.a(paramContext, localfv))
      {
        paramContext = ha.a(paramContext, localfv, fw.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
        if (paramContext != null) {
          d = (String)paramContext.getMethod("getAdiuExtras", new Class[0]).invoke(paramContext, new Object[0]);
        }
        paramContext = d;
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          return "";
        }
        if (!TextUtils.isEmpty(g)) {
          return g;
        }
        if ((!paramBoolean) && (f >= 0) && (f < 2)) {
          return "";
        }
        paramContext = K(paramContext);
        if (f == -1)
        {
          localObject = fw.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
          if (localObject == null) {}
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        Method localMethod;
        int i1;
        continue;
      }
      try
      {
        f = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
      }
      catch (Throwable localThrowable) {}
    }
    f = 0;
    break label120;
    f = 0;
    label120:
    if ((!paramBoolean) && (f <= 1)) {
      return "";
    }
    localMethod = fw.a(TelephonyManager.class, "MZ2V0SW1laQ=", new Class[] { Integer.TYPE });
    if (localMethod == null)
    {
      f = 0;
      return "";
    }
    localObject = new StringBuilder();
    i1 = 0;
    try
    {
      while (i1 < f)
      {
        ((StringBuilder)localObject).append((String)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i1) }));
        ((StringBuilder)localObject).append(paramString);
        i1 += 1;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    paramContext = ((StringBuilder)localObject).toString();
    if (paramContext.length() == 0)
    {
      f = 0;
      return "";
    }
    g = paramContext.substring(0, paramContext.length() - 1);
    paramContext = g;
    return paramContext;
    return "";
  }
  
  private static String a(Context paramContext, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return null;
    }
    try
    {
      Object localObject2 = (StorageManager)paramContext.getSystemService("storage");
      Object localObject1 = Class.forName(fw.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
      Object localObject3 = localObject2.getClass().getMethod(fw.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
      paramContext = ((Class)localObject1).getMethod(fw.c("FZ2V0UGF0aA"), new Class[0]);
      localObject1 = ((Class)localObject1).getMethod(fw.c("DaXNSZW1vdmFibGU"), new Class[0]);
      localObject2 = ((Method)localObject3).invoke(localObject2, new Object[0]);
      int i2 = Array.getLength(localObject2);
      int i1 = 0;
      while (i1 < i2)
      {
        localObject3 = Array.get(localObject2, i1);
        String str = (String)paramContext.invoke(localObject3, new Object[0]);
        boolean bool = ((Boolean)((Method)localObject1).invoke(localObject3, new Object[0])).booleanValue();
        if (paramBoolean == bool) {
          return str;
        }
        i1 += 1;
      }
      return null;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  private static List<ScanResult> a(List<ScanResult> paramList)
  {
    int i3 = paramList.size();
    int i1 = 0;
    while (i1 < i3 - 1)
    {
      int i2 = 1;
      while (i2 < i3 - i1)
      {
        int i4 = i2 - 1;
        if (((ScanResult)paramList.get(i4)).level > ((ScanResult)paramList.get(i2)).level)
        {
          ScanResult localScanResult = (ScanResult)paramList.get(i4);
          paramList.set(i4, paramList.get(i2));
          paramList.set(i2, localScanResult);
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return paramList;
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    return (paramContext != null) && (paramContext.checkCallingOrSelfPermission(paramString) == 0);
  }
  
  public static String b(final Context paramContext)
  {
    try
    {
      if (!TextUtils.isEmpty(b)) {
        return b;
      }
      b = L(paramContext);
      if (!TextUtils.isEmpty(b)) {
        return b;
      }
      Object localObject = ge.a();
      if (localObject == null) {
        return null;
      }
      if (ha.a(paramContext, (fv)localObject))
      {
        localObject = ha.a(paramContext, (fv)localObject, fw.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
        if (localObject == null) {
          return b;
        }
        String str = (String)((Class)localObject).getMethod("getADIU", new Class[] { Context.class }).invoke(localObject, new Object[] { paramContext });
        if (!TextUtils.isEmpty(str))
        {
          b = str;
          return str;
        }
        if (!j)
        {
          j = true;
          gk.d().submit(new Runnable()
          {
            public void run()
            {
              try
              {
                Object localObject = (Map)this.a.getMethod("getGetParams", new Class[0]).invoke(this.a, new Object[0]);
                if (localObject == null) {
                  return;
                }
                String str = (String)this.a.getMethod("getPostParam", new Class[] { String.class, String.class, String.class, String.class }).invoke(this.a, new Object[] { fp.i(paramContext), fp.w(paramContext), fp.n(paramContext), fp.y(paramContext) });
                if (TextUtils.isEmpty(str)) {
                  return;
                }
                localObject = hx.a().a(new hw(str.getBytes(), (Map)localObject));
                this.a.getMethod("parseResult", new Class[] { Context.class, String.class }).invoke(this.a, new Object[] { paramContext, new String((byte[])localObject) });
                return;
              }
              catch (Throwable localThrowable) {}
            }
          });
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static void b()
  {
    try
    {
      if (Build.VERSION.SDK_INT > 14) {
        TrafficStats.class.getDeclaredMethod("setThreadStatsTag", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(40964) });
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static long c()
  {
    if (t != 0L) {
      return t;
    }
    try
    {
      StatFs localStatFs1 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
      StatFs localStatFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      long l1;
      long l2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = localStatFs1.getBlockCountLong() * localStatFs1.getBlockSizeLong() / 1048576L;
        l2 = localStatFs2.getBlockCountLong() * localStatFs2.getBlockSizeLong() / 1048576L;
      }
      else
      {
        l1 = localStatFs1.getBlockCount() * localStatFs1.getBlockSize() / 1048576L;
        l2 = localStatFs2.getBlockCount() * localStatFs2.getBlockSize() / 1048576L;
      }
      t = l1 + l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return t;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = F(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String d()
  {
    if (!TextUtils.isEmpty(v)) {
      return v;
    }
    v = System.getProperty("os.arch");
    return v;
  }
  
  public static String d(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    try
    {
      paramContext = I(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static int e(Context paramContext)
  {
    try
    {
      int i1 = J(paramContext);
      return i1;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  private static String e()
  {
    try
    {
      localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (NetworkInterface)((Iterator)localObject1).next();
      } while (!((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"));
      localObject1 = null;
      if (Build.VERSION.SDK_INT < 9) {
        break label169;
      }
      localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
    }
    catch (Exception localException)
    {
      label169:
      do
      {
        Object localObject1;
        Object localObject2;
        int i2;
        int i1;
        for (;;) {}
      } while (localException != null);
    }
    localObject2 = new StringBuilder();
    i2 = localObject1.length;
    i1 = 0;
    while (i1 < i2)
    {
      String str = Integer.toHexString(localObject1[i1] & 0xFF).toUpperCase();
      if (str.length() == 1) {
        ((StringBuilder)localObject2).append("0");
      }
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(":");
      i1 += 1;
    }
    if (((StringBuilder)localObject2).length() > 0) {
      ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
    }
    localObject1 = ((StringBuilder)localObject2).toString();
    return (String)localObject1;
    return "";
    return "";
  }
  
  public static int f(Context paramContext)
  {
    try
    {
      int i1 = G(paramContext);
      return i1;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      paramContext = E(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String h(Context paramContext)
  {
    try
    {
      if (l) {
        return "";
      }
      if (!TextUtils.isEmpty(k)) {
        return k;
      }
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        gk.d().submit(new Runnable()
        {
          public void run()
          {
            fp.B(this.a);
          }
        });
      }
      else
      {
        paramContext = D(paramContext);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return k;
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      if ((a != null) && (!"".equals(a))) {
        return a;
      }
      if (a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
        a = Settings.System.getString(paramContext.getContentResolver(), "mqBRboGZkQPcAkyk");
      }
      if ((a != null) && (!"".equals(a)))
      {
        String str = a;
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          a = C(paramContext);
          if (a == null) {
            return "";
          }
          return a;
          localThrowable = localThrowable;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  public static String j(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    if (!TextUtils.isEmpty(n)) {
      return n;
    }
    if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
      return "";
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 26) {
        return (String)fw.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        n = Build.SERIAL;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    if (n == null) {
      return "";
    }
    return n;
  }
  
  public static String k(Context paramContext)
  {
    if (!TextUtils.isEmpty(m)) {
      return m;
    }
    try
    {
      m = Settings.Secure.getString(paramContext.getContentResolver(), fw.c(new String(ge.a(13))));
      if (m == null) {
        return "";
      }
      paramContext = m;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return m;
  }
  
  static String l(Context paramContext)
  {
    String str = "";
    if (paramContext != null) {}
    try
    {
      if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
        return "";
      }
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (localWifiManager == null) {
        return "";
      }
      paramContext = str;
      if (localWifiManager.isWifiEnabled()) {
        paramContext = localWifiManager.getConnectionInfo().getBSSID();
      }
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
    return "";
  }
  
  static String m(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramContext != null) {}
    try
    {
      if (a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          return "";
        }
        if (paramContext.isWifiEnabled())
        {
          paramContext = paramContext.getScanResults();
          if ((paramContext != null) && (paramContext.size() != 0))
          {
            paramContext = a(paramContext);
            int i1 = 0;
            int i2 = 1;
            while ((i1 < paramContext.size()) && (i1 < 7))
            {
              ScanResult localScanResult = (ScanResult)paramContext.get(i1);
              if (i2 != 0) {
                i2 = 0;
              } else {
                localStringBuilder.append(";");
              }
              localStringBuilder.append(localScanResult.BSSID);
              i1 += 1;
            }
          }
          return localStringBuilder.toString();
        }
      }
      else
      {
        paramContext = localStringBuilder.toString();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return localStringBuilder.toString();
  }
  
  public static String n(Context paramContext)
  {
    try
    {
      if ((o != null) && (!"".equals(o))) {
        return o;
      }
      if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
        return o;
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        return "";
      }
      o = paramContext.getConnectionInfo().getMacAddress();
      if ((fw.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(o)) || (fw.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(o))) {
        o = e();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return o;
  }
  
  static String[] o(Context paramContext)
  {
    try
    {
      if ((a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) && (a(paramContext, fw.c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))))
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          return new String[] { "", "" };
        }
        paramContext = paramContext.getCellLocation();
        int i1;
        int i2;
        if ((paramContext instanceof GsmCellLocation))
        {
          paramContext = (GsmCellLocation)paramContext;
          i1 = paramContext.getCid();
          i2 = paramContext.getLac();
          paramContext = new StringBuilder();
          paramContext.append(i2);
          paramContext.append("||");
          paramContext.append(i1);
          return new String[] { paramContext.toString(), "gsm" };
        }
        if ((paramContext instanceof CdmaCellLocation))
        {
          paramContext = (CdmaCellLocation)paramContext;
          i1 = paramContext.getSystemId();
          i2 = paramContext.getNetworkId();
          int i3 = paramContext.getBaseStationId();
          paramContext = new StringBuilder();
          paramContext.append(i1);
          paramContext.append("||");
          paramContext.append(i2);
          paramContext.append("||");
          paramContext.append(i3);
          return new String[] { paramContext.toString(), "cdma" };
        }
      }
      else
      {
        return new String[] { "", "" };
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return new String[] { "", "" };
  }
  
  static String p(Context paramContext)
  {
    try
    {
      paramContext = K(paramContext);
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.getNetworkOperator();
      if (!TextUtils.isEmpty(paramContext))
      {
        if (paramContext.length() < 3) {
          return "";
        }
        paramContext = paramContext.substring(0, 3);
        return paramContext;
      }
      return "";
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  static String q(Context paramContext)
  {
    try
    {
      paramContext = K(paramContext);
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.getNetworkOperator();
      if (!TextUtils.isEmpty(paramContext))
      {
        if (paramContext.length() < 3) {
          return "";
        }
        paramContext = paramContext.substring(3);
        return paramContext;
      }
      return "";
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static int r(Context paramContext)
  {
    try
    {
      int i1 = J(paramContext);
      return i1;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return -1;
  }
  
  public static int s(Context paramContext)
  {
    try
    {
      int i1 = G(paramContext);
      return i1;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return -1;
  }
  
  public static NetworkInfo t(Context paramContext)
  {
    if (!a(paramContext, fw.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
      return null;
    }
    paramContext = H(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getActiveNetworkInfo();
  }
  
  static String u(Context paramContext)
  {
    try
    {
      paramContext = t(paramContext);
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getExtraInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  static String v(Context paramContext)
  {
    try
    {
      if ((p != null) && (!"".equals(p))) {
        return p;
      }
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext == null) {
        return "";
      }
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i1 = localDisplayMetrics.widthPixels;
      int i2 = localDisplayMetrics.heightPixels;
      if (i2 > i1)
      {
        paramContext = new StringBuilder();
        paramContext.append(i1);
        paramContext.append("*");
        paramContext.append(i2);
      }
      for (;;)
      {
        paramContext = paramContext.toString();
        break;
        paramContext = new StringBuilder();
        paramContext.append(i2);
        paramContext.append("*");
        paramContext.append(i1);
      }
      p = paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return p;
  }
  
  public static String w(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 29) {
        return "";
      }
      if ((q != null) && (!"".equals(q))) {
        return q;
      }
      if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
        return q;
      }
      TelephonyManager localTelephonyManager = K(paramContext);
      if (localTelephonyManager == null) {
        return "";
      }
      paramContext = fw.a(localTelephonyManager.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
      if (Build.VERSION.SDK_INT >= 26) {
        paramContext = fw.a(localTelephonyManager.getClass(), "QZ2V0SW1laQ==", new Class[0]);
      }
      if (paramContext != null) {
        q = (String)paramContext.invoke(localTelephonyManager, new Object[0]);
      }
      if (q == null) {
        q = "";
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return q;
  }
  
  public static String x(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    try
    {
      if ((r != null) && (!"".equals(r))) {
        return r;
      }
      if (!a(paramContext, fw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
        return r;
      }
      paramContext = K(paramContext);
      if (paramContext == null) {
        return "";
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        Method localMethod = fw.a(paramContext.getClass(), "QZ2V0TWVpZA==", new Class[0]);
        if (localMethod != null) {
          r = (String)localMethod.invoke(paramContext, new Object[0]);
        }
        if (r == null) {
          r = "";
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return r;
  }
  
  public static String y(Context paramContext)
  {
    try
    {
      paramContext = E(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  /* Error */
  public static int z(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 809	com/amap/api/mapcore/util/fp:u	I
    //   3: ifeq +7 -> 10
    //   6: getstatic 809	com/amap/api/mapcore/util/fp:u	I
    //   9: ireturn
    //   10: getstatic 256	android/os/Build$VERSION:SDK_INT	I
    //   13: istore_1
    //   14: iconst_0
    //   15: istore_2
    //   16: iload_1
    //   17: bipush 16
    //   19: if_icmplt +46 -> 65
    //   22: aload_0
    //   23: ldc_w 811
    //   26: invokevirtual 308	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 813	android/app/ActivityManager
    //   32: astore_0
    //   33: aload_0
    //   34: ifnonnull +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: new 815	android/app/ActivityManager$MemoryInfo
    //   42: dup
    //   43: invokespecial 816	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   46: astore_3
    //   47: aload_0
    //   48: aload_3
    //   49: invokevirtual 820	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   52: aload_3
    //   53: getfield 823	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   56: ldc2_w 824
    //   59: ldiv
    //   60: l2i
    //   61: istore_1
    //   62: goto +96 -> 158
    //   65: aconst_null
    //   66: astore_3
    //   67: aconst_null
    //   68: astore 4
    //   70: new 827	java/io/BufferedReader
    //   73: dup
    //   74: new 829	java/io/FileReader
    //   77: dup
    //   78: new 85	java/io/File
    //   81: dup
    //   82: ldc_w 831
    //   85: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokespecial 832	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   91: invokespecial 835	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 838	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   99: ldc_w 840
    //   102: invokevirtual 409	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   105: iconst_1
    //   106: aaload
    //   107: invokestatic 843	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   110: invokevirtual 448	java/lang/Integer:intValue	()I
    //   113: istore_1
    //   114: aload_0
    //   115: invokevirtual 844	java/io/BufferedReader:close	()V
    //   118: goto +40 -> 158
    //   121: astore_3
    //   122: aload_0
    //   123: astore 4
    //   125: aload_3
    //   126: astore_0
    //   127: goto +7 -> 134
    //   130: goto +16 -> 146
    //   133: astore_0
    //   134: aload 4
    //   136: ifnull +8 -> 144
    //   139: aload 4
    //   141: invokevirtual 844	java/io/BufferedReader:close	()V
    //   144: aload_0
    //   145: athrow
    //   146: iload_2
    //   147: istore_1
    //   148: aload_0
    //   149: ifnull +9 -> 158
    //   152: aload_0
    //   153: invokevirtual 844	java/io/BufferedReader:close	()V
    //   156: iload_2
    //   157: istore_1
    //   158: iload_1
    //   159: sipush 1024
    //   162: idiv
    //   163: putstatic 809	com/amap/api/mapcore/util/fp:u	I
    //   166: getstatic 809	com/amap/api/mapcore/util/fp:u	I
    //   169: ireturn
    //   170: astore_0
    //   171: aload_3
    //   172: astore_0
    //   173: goto -27 -> 146
    //   176: astore_3
    //   177: goto -47 -> 130
    //   180: astore_0
    //   181: goto -63 -> 118
    //   184: astore_3
    //   185: goto -41 -> 144
    //   188: astore_0
    //   189: iload_2
    //   190: istore_1
    //   191: goto -33 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramContext	Context
    //   13	178	1	i1	int
    //   15	175	2	i2	int
    //   46	21	3	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   121	51	3	localObject	Object
    //   176	1	3	localThrowable	Throwable
    //   184	1	3	localIOException	java.io.IOException
    //   68	72	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   95	114	121	finally
    //   70	95	133	finally
    //   70	95	170	java/lang/Throwable
    //   95	114	176	java/lang/Throwable
    //   114	118	180	java/io/IOException
    //   139	144	184	java/io/IOException
    //   152	156	188	java/io/IOException
  }
  
  static class a
    implements ServiceConnection
  {
    /* Error */
    public void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
    {
      // Byte code:
      //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_1
      //   4: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_1
      //   9: ldc 26
      //   11: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_2
      //   15: iconst_1
      //   16: aload_1
      //   17: aload_3
      //   18: iconst_0
      //   19: invokeinterface 36 5 0
      //   24: pop
      //   25: aload_3
      //   26: invokevirtual 39	android/os/Parcel:readException	()V
      //   29: aload_3
      //   30: invokevirtual 43	android/os/Parcel:readString	()Ljava/lang/String;
      //   33: invokestatic 46	com/amap/api/mapcore/util/fp:a	(Ljava/lang/String;)Ljava/lang/String;
      //   36: pop
      //   37: aload_3
      //   38: invokevirtual 49	android/os/Parcel:recycle	()V
      //   41: aload_1
      //   42: invokevirtual 49	android/os/Parcel:recycle	()V
      //   45: return
      //   46: astore_2
      //   47: goto +20 -> 67
      //   50: astore_2
      //   51: iconst_1
      //   52: invokestatic 52	com/amap/api/mapcore/util/fp:a	(Z)Z
      //   55: pop
      //   56: aload_2
      //   57: ldc 54
      //   59: ldc 56
      //   61: invokestatic 61	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   64: goto -27 -> 37
      //   67: aload_3
      //   68: invokevirtual 49	android/os/Parcel:recycle	()V
      //   71: aload_1
      //   72: invokevirtual 49	android/os/Parcel:recycle	()V
      //   75: aload_2
      //   76: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	77	0	this	a
      //   0	77	1	paramComponentName	ComponentName
      //   0	77	2	paramIBinder	android.os.IBinder
      //   7	61	3	localParcel	android.os.Parcel
      // Exception table:
      //   from	to	target	type
      //   8	37	46	finally
      //   51	64	46	finally
      //   8	37	50	java/lang/Throwable
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */