package com.loc;

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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class p
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
  
  /* Error */
  public static int A(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 54	com/loc/p:u	I
    //   3: ifeq +7 -> 10
    //   6: getstatic 54	com/loc/p:u	I
    //   9: ireturn
    //   10: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   13: istore_1
    //   14: iconst_0
    //   15: istore_2
    //   16: iload_1
    //   17: bipush 16
    //   19: if_icmplt +45 -> 64
    //   22: aload_0
    //   23: ldc 61
    //   25: invokevirtual 67	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast 69	android/app/ActivityManager
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +5 -> 38
    //   36: iconst_0
    //   37: ireturn
    //   38: new 71	android/app/ActivityManager$MemoryInfo
    //   41: dup
    //   42: invokespecial 74	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   45: astore_3
    //   46: aload_0
    //   47: aload_3
    //   48: invokevirtual 78	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   51: aload_3
    //   52: getfield 81	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   55: ldc2_w 82
    //   58: ldiv
    //   59: l2i
    //   60: istore_1
    //   61: goto +94 -> 155
    //   64: aconst_null
    //   65: astore_3
    //   66: aconst_null
    //   67: astore 4
    //   69: new 85	java/io/BufferedReader
    //   72: dup
    //   73: new 87	java/io/FileReader
    //   76: dup
    //   77: new 89	java/io/File
    //   80: dup
    //   81: ldc 91
    //   83: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokespecial 97	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   89: invokespecial 100	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   97: ldc 106
    //   99: invokevirtual 112	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   102: iconst_1
    //   103: aaload
    //   104: invokestatic 118	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   107: invokevirtual 122	java/lang/Integer:intValue	()I
    //   110: istore_1
    //   111: aload_0
    //   112: invokevirtual 125	java/io/BufferedReader:close	()V
    //   115: goto +40 -> 155
    //   118: astore_3
    //   119: aload_0
    //   120: astore 4
    //   122: aload_3
    //   123: astore_0
    //   124: goto +7 -> 131
    //   127: goto +16 -> 143
    //   130: astore_0
    //   131: aload 4
    //   133: ifnull +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 125	java/io/BufferedReader:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: iload_2
    //   144: istore_1
    //   145: aload_0
    //   146: ifnull +9 -> 155
    //   149: aload_0
    //   150: invokevirtual 125	java/io/BufferedReader:close	()V
    //   153: iload_2
    //   154: istore_1
    //   155: iload_1
    //   156: sipush 1024
    //   159: idiv
    //   160: istore_1
    //   161: iload_1
    //   162: putstatic 54	com/loc/p:u	I
    //   165: iload_1
    //   166: ireturn
    //   167: astore_0
    //   168: aload_3
    //   169: astore_0
    //   170: goto -27 -> 143
    //   173: astore_3
    //   174: goto -47 -> 127
    //   177: astore_0
    //   178: goto -63 -> 115
    //   181: astore_3
    //   182: goto -41 -> 141
    //   185: astore_0
    //   186: iload_2
    //   187: istore_1
    //   188: goto -33 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramContext	Context
    //   13	175	1	i1	int
    //   15	172	2	i2	int
    //   45	21	3	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   118	51	3	localObject	Object
    //   173	1	3	localThrowable	Throwable
    //   181	1	3	localIOException	java.io.IOException
    //   67	70	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   93	111	118	finally
    //   69	93	130	finally
    //   69	93	167	java/lang/Throwable
    //   93	111	173	java/lang/Throwable
    //   111	115	177	java/io/IOException
    //   136	141	181	java/io/IOException
    //   149	153	185	java/io/IOException
  }
  
  static String B(Context paramContext)
  {
    try
    {
      paramContext = G(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  /* Error */
  private static String D(Context paramContext)
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
    //   14: ldc -119
    //   16: invokestatic 142	com/loc/w:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   19: ifeq +219 -> 238
    //   22: aload 7
    //   24: astore 4
    //   26: ldc -112
    //   28: invokestatic 149	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   31: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +204 -> 238
    //   37: invokestatic 157	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   40: invokevirtual 160	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: astore_0
    //   44: new 162	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   51: astore 4
    //   53: aload 4
    //   55: aload_0
    //   56: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 4
    //   62: ldc -87
    //   64: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: new 89	java/io/File
    //   71: dup
    //   72: aload 4
    //   74: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore_0
    //   81: invokestatic 178	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   84: astore 4
    //   86: aload 4
    //   88: invokeinterface 183 1 0
    //   93: istore_3
    //   94: new 185	java/io/FileInputStream
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: astore_0
    //   103: aload 4
    //   105: aload_0
    //   106: ldc -68
    //   108: invokeinterface 192 3 0
    //   113: iconst_0
    //   114: istore_1
    //   115: goto +190 -> 305
    //   118: iload_1
    //   119: istore_2
    //   120: iload_1
    //   121: ifeq +84 -> 205
    //   124: aload 4
    //   126: invokeinterface 195 1 0
    //   131: astore 4
    //   133: aload_0
    //   134: invokevirtual 198	java/io/InputStream:close	()V
    //   137: aload 4
    //   139: areturn
    //   140: iconst_0
    //   141: istore_2
    //   142: goto +63 -> 205
    //   145: iload_1
    //   146: istore_2
    //   147: aload 4
    //   149: invokeinterface 201 1 0
    //   154: ifle +51 -> 205
    //   157: aload 4
    //   159: invokeinterface 201 1 0
    //   164: istore_3
    //   165: iconst_0
    //   166: istore_2
    //   167: iload_2
    //   168: iload_3
    //   169: if_icmpge +189 -> 358
    //   172: aload 4
    //   174: iload_2
    //   175: invokeinterface 205 2 0
    //   180: astore 5
    //   182: ldc -49
    //   184: aload 5
    //   186: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifne +160 -> 349
    //   192: ldc -47
    //   194: aload 5
    //   196: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +152 -> 351
    //   202: goto +147 -> 349
    //   205: aload 4
    //   207: invokeinterface 212 1 0
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
    //   247: invokevirtual 198	java/io/InputStream:close	()V
    //   250: goto +27 -> 277
    //   253: astore_0
    //   254: aload 5
    //   256: astore 4
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 198	java/io/InputStream:close	()V
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
  
  private static String E(Context paramContext)
  {
    boolean bool = w.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER);
    int i1 = 0;
    Object localObject;
    if (bool)
    {
      try
      {
        Class localClass = Class.forName(w.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
        localObject = localClass.newInstance();
        paramContext = localClass.getMethod(w.c("MZ2V0T0FJRA"), new Class[] { Context.class }).invoke(localObject, new Object[] { paramContext });
        if (paramContext == null) {
          break label225;
        }
        paramContext = (String)paramContext;
        k = paramContext;
        return paramContext;
      }
      catch (Throwable localThrowable1)
      {
        paramContext = "xm";
      }
      ag.a(localThrowable1, "oa", paramContext);
    }
    else
    {
      for (;;)
      {
        l = true;
        break label225;
        if (w.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER))
        {
          try
          {
            Intent localIntent = new Intent();
            localIntent.setAction(w.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
            localIntent.setPackage(w.c("UY29tLmh1YXdlaS5od2lk"));
            localObject = new a();
            if (paramContext.bindService(localIntent, (ServiceConnection)localObject, 1))
            {
              while ((i1 < 100) && (TextUtils.isEmpty(k)))
              {
                i1 += 1;
                Thread.sleep(15L);
              }
              paramContext.unbindService((ServiceConnection)localObject);
            }
            paramContext = k;
            return paramContext;
          }
          catch (Throwable localThrowable2)
          {
            paramContext = "hw";
          }
          break;
        }
        "OPPO".equalsIgnoreCase(Build.MANUFACTURER);
      }
    }
    label225:
    return k;
  }
  
  private static String F(Context paramContext)
    throws InvocationTargetException, IllegalAccessException
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    if ((w != null) && (!"".equals(w))) {
      return w;
    }
    if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
      return w;
    }
    paramContext = K(paramContext);
    if (paramContext == null) {
      return "";
    }
    Method localMethod = w.a(paramContext.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
    if (localMethod != null) {
      w = (String)localMethod.invoke(paramContext, new Object[0]);
    }
    if (w == null) {
      w = "";
    }
    return w;
  }
  
  private static String G(Context paramContext)
  {
    if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
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
  
  private static int H(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!b(paramContext, w.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
        return -1;
      }
      paramContext = I(paramContext);
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
  
  private static ConnectivityManager I(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  private static int J(Context paramContext)
  {
    if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
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
    try
    {
      paramContext = M(paramContext);
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    try
    {
      byte[] arrayOfByte = w.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
      paramContext = q.b(paramContext);
      paramContext = new String(q.a(w.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), paramContext, arrayOfByte), "UTF-8");
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
    //   0: ldc_w 389
    //   3: invokestatic 217	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   6: invokestatic 393	com/loc/s:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 4
    //   11: aload_0
    //   12: invokestatic 396	com/loc/p:N	(Landroid/content/Context;)Ljava/lang/String;
    //   15: astore_0
    //   16: aload_0
    //   17: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +6 -> 26
    //   23: ldc 14
    //   25: areturn
    //   26: new 162	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: aload_0
    //   36: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: getstatic 399	java/io/File:separator	Ljava/lang/String;
    //   44: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 401
    //   52: invokestatic 217	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: new 89	java/io/File
    //   62: dup
    //   63: aload_2
    //   64: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: ldc_w 403
    //   70: invokestatic 217	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokespecial 406	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 410	java/io/File:exists	()Z
    //   81: ifeq +220 -> 301
    //   84: aload_0
    //   85: invokevirtual 413	java/io/File:canRead	()Z
    //   88: ifne +6 -> 94
    //   91: goto +210 -> 301
    //   94: aload_0
    //   95: invokevirtual 417	java/io/File:length	()J
    //   98: lconst_0
    //   99: lcmp
    //   100: ifne +11 -> 111
    //   103: aload_0
    //   104: invokevirtual 420	java/io/File:delete	()Z
    //   107: pop
    //   108: ldc 14
    //   110: areturn
    //   111: aconst_null
    //   112: astore_3
    //   113: new 422	java/io/RandomAccessFile
    //   116: dup
    //   117: aload_0
    //   118: ldc_w 423
    //   121: invokespecial 426	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   124: astore_0
    //   125: sipush 1024
    //   128: newarray <illegal type>
    //   130: astore 5
    //   132: new 428	java/io/ByteArrayOutputStream
    //   135: dup
    //   136: invokespecial 429	java/io/ByteArrayOutputStream:<init>	()V
    //   139: astore_2
    //   140: aload_0
    //   141: aload 5
    //   143: invokevirtual 433	java/io/RandomAccessFile:read	([B)I
    //   146: istore_1
    //   147: iload_1
    //   148: iconst_m1
    //   149: if_icmpeq +14 -> 163
    //   152: aload_2
    //   153: aload 5
    //   155: iconst_0
    //   156: iload_1
    //   157: invokevirtual 437	java/io/ByteArrayOutputStream:write	([BII)V
    //   160: goto -20 -> 140
    //   163: new 108	java/lang/String
    //   166: dup
    //   167: aload_2
    //   168: invokevirtual 441	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   171: ldc_w 371
    //   174: invokespecial 387	java/lang/String:<init>	([BLjava/lang/String;)V
    //   177: astore_3
    //   178: aload_3
    //   179: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +62 -> 244
    //   185: aload_3
    //   186: ldc_w 443
    //   189: invokestatic 217	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   192: invokevirtual 446	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   195: ifeq +49 -> 244
    //   198: aload_3
    //   199: ldc_w 443
    //   202: invokestatic 217	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   205: invokevirtual 112	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   208: astore_3
    //   209: aload_3
    //   210: ifnull +34 -> 244
    //   213: aload_3
    //   214: arraylength
    //   215: iconst_2
    //   216: if_icmpne +28 -> 244
    //   219: aload 4
    //   221: aload_3
    //   222: iconst_0
    //   223: aaload
    //   224: invokestatic 449	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   227: ifeq +17 -> 244
    //   230: aload_3
    //   231: iconst_1
    //   232: aaload
    //   233: astore_3
    //   234: aload_2
    //   235: invokestatic 452	com/loc/p:a	(Ljava/io/Closeable;)V
    //   238: aload_0
    //   239: invokestatic 452	com/loc/p:a	(Ljava/io/Closeable;)V
    //   242: aload_3
    //   243: areturn
    //   244: aload_2
    //   245: invokestatic 452	com/loc/p:a	(Ljava/io/Closeable;)V
    //   248: aload_0
    //   249: invokestatic 452	com/loc/p:a	(Ljava/io/Closeable;)V
    //   252: goto +46 -> 298
    //   255: astore_3
    //   256: goto +21 -> 277
    //   259: goto +32 -> 291
    //   262: astore_2
    //   263: goto +6 -> 269
    //   266: astore_2
    //   267: aconst_null
    //   268: astore_0
    //   269: aconst_null
    //   270: astore 4
    //   272: aload_2
    //   273: astore_3
    //   274: aload 4
    //   276: astore_2
    //   277: aload_2
    //   278: invokestatic 452	com/loc/p:a	(Ljava/io/Closeable;)V
    //   281: aload_0
    //   282: invokestatic 452	com/loc/p:a	(Ljava/io/Closeable;)V
    //   285: aload_3
    //   286: athrow
    //   287: aconst_null
    //   288: astore_0
    //   289: aload_3
    //   290: astore_2
    //   291: aload_2
    //   292: invokestatic 452	com/loc/p:a	(Ljava/io/Closeable;)V
    //   295: goto -47 -> 248
    //   298: ldc 14
    //   300: areturn
    //   301: ldc 14
    //   303: areturn
    //   304: astore_0
    //   305: goto -18 -> 287
    //   308: astore_2
    //   309: aload_3
    //   310: astore_2
    //   311: goto -20 -> 291
    //   314: astore_3
    //   315: goto -56 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramContext	Context
    //   146	11	1	i1	int
    //   33	212	2	localObject1	Object
    //   262	1	2	localObject2	Object
    //   266	7	2	localObject3	Object
    //   276	16	2	localObject4	Object
    //   308	1	2	localThrowable1	Throwable
    //   310	1	2	localObject5	Object
    //   112	131	3	localObject6	Object
    //   255	1	3	localObject7	Object
    //   273	37	3	localObject8	Object
    //   314	1	3	localThrowable2	Throwable
    //   9	266	4	str	String
    //   130	24	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   140	147	255	finally
    //   152	160	255	finally
    //   163	209	255	finally
    //   213	230	255	finally
    //   125	140	262	finally
    //   113	125	266	finally
    //   113	125	304	java/lang/Throwable
    //   125	140	308	java/lang/Throwable
    //   140	147	314	java/lang/Throwable
    //   152	160	314	java/lang/Throwable
    //   163	209	314	java/lang/Throwable
    //   213	230	314	java/lang/Throwable
  }
  
  private static String N(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return null;
    }
    try
    {
      Object localObject2 = (StorageManager)paramContext.getSystemService("storage");
      Object localObject1 = Class.forName(w.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
      Object localObject3 = localObject2.getClass().getMethod(w.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
      paramContext = ((Class)localObject1).getMethod(w.c("FZ2V0UGF0aA"), new Class[0]);
      localObject1 = ((Class)localObject1).getMethod(w.c("DaXNSZW1vdmFibGU"), new Class[0]);
      localObject2 = ((Method)localObject3).invoke(localObject2, new Object[0]);
      int i2 = Array.getLength(localObject2);
      int i1 = 0;
      while (i1 < i2)
      {
        localObject3 = Array.get(localObject2, i1);
        String str = (String)paramContext.invoke(localObject3, new Object[0]);
        boolean bool = ((Boolean)((Method)localObject1).invoke(localObject3, new Object[0])).booleanValue();
        if (!bool) {
          return str;
        }
        i1 += 1;
      }
      return null;
    }
    catch (Throwable paramContext) {}
    return null;
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
      v localv = x.a();
      if (az.b(paramContext, localv))
      {
        paramContext = az.a(paramContext, localv, w.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
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
  
  public static String a(Context paramContext, String paramString)
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
        paramContext = K(paramContext);
        if (f == -1)
        {
          localObject = w.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
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
    localMethod = w.a(TelephonyManager.class, "MZ2V0SW1laQ=", new Class[] { Integer.TYPE });
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
    paramContext = paramContext.substring(0, paramContext.length() - 1);
    g = paramContext;
    return paramContext;
    return "";
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
  
  public static void a(String paramString)
  {
    i = paramString;
  }
  
  public static String b(final Context paramContext)
  {
    try
    {
      if (!TextUtils.isEmpty(b)) {
        return b;
      }
      Object localObject = L(paramContext);
      b = (String)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return b;
      }
      localObject = x.a();
      if (localObject == null) {
        return null;
      }
      if (az.b(paramContext, (v)localObject))
      {
        localObject = az.a(paramContext, (v)localObject, w.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
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
          aj.d().submit(new Runnable()
          {
            public final void run()
            {
              try
              {
                Object localObject = (Map)this.a.getMethod("getGetParams", new Class[0]).invoke(this.a, new Object[0]);
                if (localObject == null) {
                  return;
                }
                String str = (String)this.a.getMethod("getPostParam", new Class[] { String.class, String.class, String.class, String.class }).invoke(this.a, new Object[] { p.i(paramContext), p.w(paramContext), p.n(paramContext), p.z(paramContext) });
                if (TextUtils.isEmpty(str)) {
                  return;
                }
                bj.a();
                localObject = bj.a(new bi(str.getBytes(), (Map)localObject));
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
  
  private static boolean b(Context paramContext, String paramString)
  {
    return (paramContext != null) && (paramContext.checkCallingOrSelfPermission(paramString) == 0);
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
      paramContext = G(paramContext);
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
    String str = System.getProperty("os.arch");
    v = str;
    return str;
  }
  
  public static String d(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    try
    {
      paramContext = z(paramContext);
      if (paramContext != null)
      {
        if (paramContext.length() < 5) {
          return "";
        }
        paramContext = paramContext.substring(3, 5);
        return paramContext;
      }
      return "";
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
  
  public static int f(Context paramContext)
  {
    try
    {
      int i1 = H(paramContext);
      return i1;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  /* Error */
  private static String f()
  {
    // Byte code:
    //   0: invokestatic 628	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   3: invokestatic 634	java/util/Collections:list	(Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   6: invokeinterface 638 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface 643 1 0
    //   18: ifeq +141 -> 159
    //   21: aload_2
    //   22: invokeinterface 645 1 0
    //   27: checkcast 624	java/net/NetworkInterface
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 648	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   35: ldc_w 650
    //   38: invokevirtual 226	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   41: ifeq -29 -> 12
    //   44: aconst_null
    //   45: astore_2
    //   46: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 9
    //   51: if_icmplt +115 -> 166
    //   54: aload_3
    //   55: invokevirtual 653	java/net/NetworkInterface:getHardwareAddress	()[B
    //   58: astore_2
    //   59: goto +107 -> 166
    //   62: new 162	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   69: astore_3
    //   70: aload_2
    //   71: arraylength
    //   72: istore_1
    //   73: iconst_0
    //   74: istore_0
    //   75: iload_0
    //   76: iload_1
    //   77: if_icmpge +57 -> 134
    //   80: aload_2
    //   81: iload_0
    //   82: baload
    //   83: sipush 255
    //   86: iand
    //   87: invokestatic 656	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   90: invokevirtual 659	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   93: astore 4
    //   95: aload 4
    //   97: invokevirtual 518	java/lang/String:length	()I
    //   100: iconst_1
    //   101: if_icmpne +11 -> 112
    //   104: aload_3
    //   105: ldc_w 661
    //   108: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: aload 4
    //   115: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_3
    //   120: ldc_w 663
    //   123: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: iload_0
    //   128: iconst_1
    //   129: iadd
    //   130: istore_0
    //   131: goto -56 -> 75
    //   134: aload_3
    //   135: invokevirtual 664	java/lang/StringBuilder:length	()I
    //   138: ifle +14 -> 152
    //   141: aload_3
    //   142: aload_3
    //   143: invokevirtual 664	java/lang/StringBuilder:length	()I
    //   146: iconst_1
    //   147: isub
    //   148: invokevirtual 668	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_3
    //   153: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: astore_2
    //   157: aload_2
    //   158: areturn
    //   159: ldc 14
    //   161: areturn
    //   162: astore_2
    //   163: goto -4 -> 159
    //   166: aload_2
    //   167: ifnonnull -105 -> 62
    //   170: ldc 14
    //   172: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   74	57	0	i1	int
    //   72	6	1	i2	int
    //   11	147	2	localObject1	Object
    //   162	5	2	localException	Exception
    //   30	123	3	localObject2	Object
    //   93	21	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	12	162	java/lang/Exception
    //   12	44	162	java/lang/Exception
    //   46	59	162	java/lang/Exception
    //   62	73	162	java/lang/Exception
    //   80	112	162	java/lang/Exception
    //   112	127	162	java/lang/Exception
    //   134	152	162	java/lang/Exception
    //   152	157	162	java/lang/Exception
  }
  
  public static String g(Context paramContext)
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
        aj.d().submit(new Runnable()
        {
          public final void run()
          {
            p.C(this.a);
          }
        });
      }
      else
      {
        paramContext = E(paramContext);
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
      if (b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
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
          a = D(paramContext);
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
    if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
      return "";
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 26) {
        return (String)w.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
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
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), w.c(new String(x.a(13))));
      m = paramContext;
      if (paramContext == null) {
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
    String str2 = "";
    String str1 = str2;
    if (paramContext != null) {}
    try
    {
      if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
        return "";
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        return "";
      }
      str1 = str2;
      if (paramContext.isWifiEnabled()) {
        str1 = paramContext.getConnectionInfo().getBSSID();
      }
      return str1;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  static String m(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramContext != null) {}
    try
    {
      if (b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
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
      if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
        return o;
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        return "";
      }
      o = paramContext.getConnectionInfo().getMacAddress();
      if ((w.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(o)) || (w.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(o))) {
        o = f();
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
      if ((b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) && (b(paramContext, w.c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))))
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
      int i1 = H(paramContext);
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
    if (!b(paramContext, w.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
      return null;
    }
    paramContext = I(paramContext);
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
      if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
        return q;
      }
      TelephonyManager localTelephonyManager = K(paramContext);
      if (localTelephonyManager == null) {
        return "";
      }
      paramContext = w.a(localTelephonyManager.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
      if (Build.VERSION.SDK_INT >= 26) {
        paramContext = w.a(localTelephonyManager.getClass(), "QZ2V0SW1laQ==", new Class[0]);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(w(paramContext));
    localStringBuilder.append("#");
    localStringBuilder.append(b(paramContext));
    return localStringBuilder.toString();
  }
  
  public static String y(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    try
    {
      if ((r != null) && (!"".equals(r))) {
        return r;
      }
      if (!b(paramContext, w.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
        return r;
      }
      paramContext = K(paramContext);
      if (paramContext == null) {
        return "";
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        Method localMethod = w.a(paramContext.getClass(), "QZ2V0TWVpZA==", new Class[0]);
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
  
  public static String z(Context paramContext)
  {
    try
    {
      paramContext = F(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  static final class a
    implements ServiceConnection
  {
    /* Error */
    public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
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
      //   33: invokestatic 47	com/loc/p:b	(Ljava/lang/String;)Ljava/lang/String;
      //   36: pop
      //   37: aload_3
      //   38: invokevirtual 50	android/os/Parcel:recycle	()V
      //   41: aload_1
      //   42: invokevirtual 50	android/os/Parcel:recycle	()V
      //   45: return
      //   46: astore_2
      //   47: goto +25 -> 72
      //   50: astore_2
      //   51: invokestatic 54	com/loc/p:e	()Z
      //   54: pop
      //   55: aload_2
      //   56: ldc 56
      //   58: ldc 58
      //   60: invokestatic 63	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   63: aload_3
      //   64: invokevirtual 50	android/os/Parcel:recycle	()V
      //   67: aload_1
      //   68: invokevirtual 50	android/os/Parcel:recycle	()V
      //   71: return
      //   72: aload_3
      //   73: invokevirtual 50	android/os/Parcel:recycle	()V
      //   76: aload_1
      //   77: invokevirtual 50	android/os/Parcel:recycle	()V
      //   80: aload_2
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	a
      //   0	82	1	paramComponentName	ComponentName
      //   0	82	2	paramIBinder	android.os.IBinder
      //   7	66	3	localParcel	android.os.Parcel
      // Exception table:
      //   from	to	target	type
      //   8	37	46	finally
      //   51	63	46	finally
      //   8	37	50	java/lang/Throwable
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */