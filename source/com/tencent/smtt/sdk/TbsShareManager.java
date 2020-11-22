package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager
{
  private static Context a;
  private static boolean b = false;
  private static String c;
  private static String d;
  private static int e = 0;
  private static String f;
  private static boolean g = false;
  private static boolean h = false;
  private static String i;
  private static boolean j = false;
  private static boolean k = false;
  public static boolean mHasQueryed = false;
  
  static int a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, paramBoolean);
    return e;
  }
  
  static String a()
  {
    return d;
  }
  
  static void a(Context paramContext)
  {
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      localObject = new TbsLinuxToolsJni(paramContext);
      a(paramContext, (TbsLinuxToolsJni)localObject, am.a().r(paramContext));
      paramContext = am.a().s(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareTbsCore tbsShareDir is ");
      localStringBuilder.append(paramContext.getAbsolutePath());
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
      ((TbsLinuxToolsJni)localObject).a(paramContext.getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareTbsCore tbsShareDir error is ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      ((StringBuilder)localObject).append(" ## ");
      ((StringBuilder)localObject).append(paramContext.getCause());
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isDirectory()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareAllDirsAndFiles dir is ");
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
      paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
      File[] arrayOfFile = paramFile.listFiles();
      int n = arrayOfFile.length;
      int m = 0;
      while (m < n)
      {
        paramFile = arrayOfFile[m];
        if (paramFile.isFile())
        {
          if (paramFile.getAbsolutePath().indexOf(".so") > 0) {
            paramFile = paramFile.getAbsolutePath();
          }
          for (localObject = "755";; localObject = "644")
          {
            paramTbsLinuxToolsJni.a(paramFile, (String)localObject);
            break;
            paramFile = paramFile.getAbsolutePath();
          }
        }
        if (paramFile.isDirectory()) {
          a(paramContext, paramTbsLinuxToolsJni, paramFile);
        } else {
          TbsLog.e("TbsShareManager", "unknown file type.", true);
        }
        m += 1;
      }
    }
  }
  
  static void b(Context paramContext)
  {
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), am.a().q(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    if (i(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static String c(Context paramContext)
  {
    j(paramContext);
    return d;
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ldc -96
    //   9: invokestatic 164	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: new 166	java/io/BufferedInputStream
    //   23: dup
    //   24: new 168	java/io/FileInputStream
    //   27: dup
    //   28: aload 6
    //   30: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_3
    //   37: new 176	java/util/Properties
    //   40: dup
    //   41: invokespecial 177	java/util/Properties:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: aload_3
    //   49: invokevirtual 180	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: aload 5
    //   54: ldc -74
    //   56: iconst_0
    //   57: invokestatic 186	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   60: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   63: pop
    //   64: iload_1
    //   65: ifeq +61 -> 126
    //   68: invokestatic 57	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   71: aload_0
    //   72: invokevirtual 61	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   75: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: astore 7
    //   80: aload_0
    //   81: invokevirtual 196	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   84: invokevirtual 199	android/content/Context:getPackageName	()Ljava/lang/String;
    //   87: astore 8
    //   89: aload_0
    //   90: invokestatic 204	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   93: istore_2
    //   94: aload 5
    //   96: ldc -50
    //   98: aload 8
    //   100: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   103: pop
    //   104: aload 5
    //   106: ldc -48
    //   108: aload 7
    //   110: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   113: pop
    //   114: aload 5
    //   116: ldc -46
    //   118: iload_2
    //   119: invokestatic 213	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   122: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   125: pop
    //   126: new 215	java/io/BufferedOutputStream
    //   129: dup
    //   130: new 217	java/io/FileOutputStream
    //   133: dup
    //   134: aload 6
    //   136: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   139: invokespecial 221	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   142: astore_0
    //   143: aload 5
    //   145: aload_0
    //   146: aconst_null
    //   147: invokevirtual 225	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   150: aload_3
    //   151: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   154: aload_0
    //   155: invokevirtual 229	java/io/BufferedOutputStream:close	()V
    //   158: return
    //   159: astore 4
    //   161: goto +55 -> 216
    //   164: astore 4
    //   166: goto +11 -> 177
    //   169: astore_0
    //   170: goto +56 -> 226
    //   173: astore 4
    //   175: aconst_null
    //   176: astore_0
    //   177: goto +16 -> 193
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_3
    //   183: goto +43 -> 226
    //   186: astore 4
    //   188: aconst_null
    //   189: astore_0
    //   190: aload 5
    //   192: astore_3
    //   193: aload 4
    //   195: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   198: aload_3
    //   199: ifnull +7 -> 206
    //   202: aload_3
    //   203: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   206: aload_0
    //   207: ifnull +6 -> 213
    //   210: goto -56 -> 154
    //   213: return
    //   214: astore 4
    //   216: aload_0
    //   217: astore 5
    //   219: aload 4
    //   221: astore_0
    //   222: aload 5
    //   224: astore 4
    //   226: aload_3
    //   227: ifnull +7 -> 234
    //   230: aload_3
    //   231: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   234: aload 4
    //   236: ifnull +8 -> 244
    //   239: aload 4
    //   241: invokevirtual 229	java/io/BufferedOutputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_3
    //   247: goto -93 -> 154
    //   250: astore_0
    //   251: return
    //   252: astore_3
    //   253: goto -47 -> 206
    //   256: astore_3
    //   257: goto -23 -> 234
    //   260: astore_3
    //   261: goto -17 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   0	264	1	paramBoolean	boolean
    //   93	26	2	m	int
    //   36	195	3	localObject1	Object
    //   246	1	3	localException1	Exception
    //   252	1	3	localException2	Exception
    //   256	1	3	localException3	Exception
    //   260	1	3	localException4	Exception
    //   1	1	4	localObject2	Object
    //   159	1	4	localObject3	Object
    //   164	1	4	localThrowable1	Throwable
    //   173	1	4	localThrowable2	Throwable
    //   186	8	4	localThrowable3	Throwable
    //   214	6	4	localObject4	Object
    //   224	16	4	localObject5	Object
    //   4	219	5	localObject6	Object
    //   12	123	6	localFile	File
    //   78	31	7	str1	String
    //   87	12	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   143	150	159	finally
    //   143	150	164	java/lang/Throwable
    //   37	64	169	finally
    //   68	126	169	finally
    //   126	143	169	finally
    //   37	64	173	java/lang/Throwable
    //   68	126	173	java/lang/Throwable
    //   126	143	173	java/lang/Throwable
    //   6	14	180	finally
    //   20	37	180	finally
    //   6	14	186	java/lang/Throwable
    //   20	37	186	java/lang/Throwable
    //   193	198	214	finally
    //   150	154	246	java/lang/Exception
    //   154	158	250	java/lang/Exception
    //   202	206	252	java/lang/Exception
    //   230	234	256	java/lang/Exception
    //   239	244	260	java/lang/Exception
  }
  
  static int d(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  static Context e(Context paramContext)
  {
    j(paramContext);
    String str = f;
    Context localContext = null;
    if (str != null)
    {
      localContext = getPackageContext(paramContext, f);
      if (!am.a().f(localContext)) {
        return null;
      }
    }
    return localContext;
  }
  
  /* Error */
  static String f(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc -96
    //   6: invokestatic 164	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: aconst_null
    //   18: areturn
    //   19: new 166	java/io/BufferedInputStream
    //   22: dup
    //   23: new 168	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_0
    //   37: new 176	java/util/Properties
    //   40: dup
    //   41: invokespecial 177	java/util/Properties:<init>	()V
    //   44: astore_3
    //   45: aload_2
    //   46: astore_0
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 180	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: aload_2
    //   53: astore_0
    //   54: aload_3
    //   55: ldc -50
    //   57: ldc -14
    //   59: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_2
    //   64: astore_0
    //   65: ldc -14
    //   67: aload_3
    //   68: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: istore_1
    //   72: iload_1
    //   73: ifne +12 -> 85
    //   76: aload_2
    //   77: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_3
    //   84: areturn
    //   85: aload_2
    //   86: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   89: ldc 2
    //   91: monitorexit
    //   92: aconst_null
    //   93: areturn
    //   94: astore_3
    //   95: goto +12 -> 107
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +30 -> 131
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: astore_0
    //   109: aload_3
    //   110: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   121: ldc 2
    //   123: monitorexit
    //   124: aconst_null
    //   125: areturn
    //   126: astore_3
    //   127: aload_0
    //   128: astore_2
    //   129: aload_3
    //   130: astore_0
    //   131: aload_2
    //   132: ifnull +14 -> 146
    //   135: aload_2
    //   136: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   139: goto +7 -> 146
    //   142: astore_0
    //   143: goto +5 -> 148
    //   146: aload_0
    //   147: athrow
    //   148: ldc 2
    //   150: monitorexit
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: goto -74 -> 80
    //   157: astore_0
    //   158: goto -69 -> 89
    //   161: astore_0
    //   162: goto -41 -> 121
    //   165: astore_2
    //   166: goto -20 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramContext	Context
    //   71	2	1	bool	boolean
    //   34	102	2	localObject1	Object
    //   165	1	2	localException	Exception
    //   44	40	3	localObject2	Object
    //   94	1	3	localThrowable1	Throwable
    //   104	6	3	localThrowable2	Throwable
    //   126	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	45	94	java/lang/Throwable
    //   47	52	94	java/lang/Throwable
    //   54	63	94	java/lang/Throwable
    //   65	72	94	java/lang/Throwable
    //   3	10	98	finally
    //   19	35	98	finally
    //   3	10	104	java/lang/Throwable
    //   19	35	104	java/lang/Throwable
    //   37	45	126	finally
    //   47	52	126	finally
    //   54	63	126	finally
    //   65	72	126	finally
    //   109	113	126	finally
    //   76	80	142	finally
    //   85	89	142	finally
    //   117	121	142	finally
    //   135	139	142	finally
    //   146	148	142	finally
    //   76	80	153	java/lang/Exception
    //   85	89	157	java/lang/Exception
    //   117	121	161	java/lang/Exception
    //   135	139	165	java/lang/Exception
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    n(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("core_info mAvailableCoreVersion is ");
    ((StringBuilder)localObject).append(e);
    ((StringBuilder)localObject).append(" mAvailableCorePath is ");
    ((StringBuilder)localObject).append(d);
    ((StringBuilder)localObject).append(" mSrcPackageName is ");
    ((StringBuilder)localObject).append(f);
    TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
    if (f == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    if ((f != null) && (f.equals("AppDefined")))
    {
      if (e != am.a().a(c))
      {
        e = 0;
        d = null;
        f = null;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check AppDefined core is error src is ");
        ((StringBuilder)localObject).append(e);
        ((StringBuilder)localObject).append(" dest is ");
        ((StringBuilder)localObject).append(am.a().a(c));
      }
    }
    else {
      for (localObject = ((StringBuilder)localObject).toString();; localObject = "core_info error checkCoreInfo is false and checkCoreInOthers is false ")
      {
        TbsLog.i("TbsShareManager", (String)localObject);
        break;
        if ((k(paramContext)) || (l(paramContext))) {
          break;
        }
        e = 0;
        d = null;
        f = null;
      }
    }
    if (e > 0)
    {
      localObject = paramContext.getApplicationInfo();
      int m;
      if ((!"com.tencent.android.qqdownloader".equals(((ApplicationInfo)localObject).packageName)) && (!"com.jd.jrapp".equals(((ApplicationInfo)localObject).packageName))) {
        m = 0;
      } else {
        m = 1;
      }
      boolean bool;
      if (m == 0) {
        bool = QbSdk.a(paramContext, e);
      } else {
        bool = false;
      }
      if ((bool) || (g))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
      }
    }
    return e;
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    if (paramContext != null)
    {
      if (am.a().a(paramContext, null)) {
        return false;
      }
      int m = getSharedTbsCoreVersion(paramContext, "com.tencent.tbs");
      if (m > 0)
      {
        Object localObject = getPackageContext(paramContext, "com.tencent.tbs");
        localObject = am.a().r((Context)localObject).getAbsolutePath();
        writeProperties(paramContext, Integer.toString(m), "com.tencent.tbs", (String)localObject, "1");
        return true;
      }
    }
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean)
  {
    for (;;)
    {
      int m;
      try
      {
        if (!isThirdPartyApp(paramContext)) {
          return;
        }
        if (QbSdk.getOnlyDownload()) {
          return;
        }
        Object localObject = am.a().s(paramContext);
        if (localObject == null) {
          return;
        }
        if ((paramBoolean) && (new File((File)localObject, "core_info").exists())) {
          return;
        }
        if (c != null)
        {
          m = am.a().a(c);
          if (m > 0)
          {
            d = c;
            f = "AppDefined";
            e = m;
            writeProperties(paramContext, Integer.toString(e), f, d, Integer.toString(1));
            return;
          }
        }
        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
        int i1 = h(paramContext);
        int i2 = am.a().j(paramContext);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("forceToLoadX5ForThirdApp coreVersionFromConfig is ");
        ((StringBuilder)localObject).append(i1);
        TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("forceToLoadX5ForThirdApp coreVersionFromCoreShare is ");
        ((StringBuilder)localObject).append(i2);
        TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
        localObject = getCoreProviderAppList();
        int i3 = localObject.length;
        int n = 0;
        m = 0;
        String str;
        int i4;
        Context localContext;
        if (m < i3)
        {
          str = localObject[m];
          i4 = getCoreShareDecoupleCoreVersion(paramContext, str);
          if ((i4 >= i1) && (i4 >= i2) && (i4 > 0))
          {
            localContext = getPackageContext(paramContext, str);
            d = am.a().c(paramContext, localContext).getAbsolutePath();
            f = str;
            e = i4;
            if (QbSdk.canLoadX5FirstTimeThirdApp(paramContext))
            {
              m = b.b(paramContext);
              TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
              writeProperties(paramContext, Integer.toString(e), f, d, Integer.toString(m));
              return;
            }
            e = 0;
            d = null;
            f = null;
          }
        }
        else
        {
          i3 = localObject.length;
          m = 0;
          if (m < i3)
          {
            str = localObject[m];
            i4 = getSharedTbsCoreVersion(paramContext, str);
            if ((i4 < i1) || (i4 < i2) || (i4 <= 0)) {
              break label784;
            }
            localContext = getPackageContext(paramContext, str);
            d = am.a().b(paramContext, localContext).getAbsolutePath();
            f = str;
            e = i4;
            if (QbSdk.canLoadX5FirstTimeThirdApp(paramContext))
            {
              m = b.b(paramContext);
              writeProperties(paramContext, Integer.toString(e), f, d, Integer.toString(m));
              return;
            }
            e = 0;
            d = null;
            f = null;
            break label784;
          }
          if (!QbSdk.mDisableUseHostBackupCore) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread())
            {
              i3 = localObject.length;
              m = n;
              if (m < i3)
              {
                str = localObject[m];
                n = getBackupCoreVersion(paramContext, str);
                if ((n >= i1) && (n >= i2) && (n > 0))
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("find host backup core to unzip forceload coreVersion is ");
                  ((StringBuilder)localObject).append(n);
                  ((StringBuilder)localObject).append(" packageName is ");
                  ((StringBuilder)localObject).append(str);
                  TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
                  localObject = getBackupCoreFile(paramContext, str);
                  paramBoolean = am.a().a(paramContext, (File)localObject);
                  TbsLog.i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
                  if (!paramBoolean) {
                    break label791;
                  }
                  am.a().a(paramContext, n);
                  am.a().c(paramContext, true);
                  return;
                }
                n = getBackupDecoupleCoreVersion(paramContext, str);
                if ((n < i1) || (n < i2) || (n <= 0)) {
                  break label793;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("find host backup core to unzip forceload decouple coreVersion is ");
                ((StringBuilder)localObject).append(n);
                ((StringBuilder)localObject).append(" packageName is ");
                ((StringBuilder)localObject).append(str);
                TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
                localObject = getBackupCoreFile(paramContext, str);
                paramBoolean = am.a().a(paramContext, (File)localObject);
                TbsLog.i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
                if (!paramBoolean) {
                  break label792;
                }
                am.a().a(paramContext, n);
                am.a().c(paramContext, true);
              }
            }
            else
            {
              TbsLog.i("TbsShareManager", "in mainthread so do not find host backup core to install ");
            }
          }
          return;
        }
      }
      catch (Exception paramContext)
      {
        return;
      }
      m += 1;
      continue;
      label784:
      m += 1;
      continue;
      label791:
      return;
      label792:
      return;
      label793:
      m += 1;
    }
  }
  
  static String g(Context paramContext)
  {
    try
    {
      n(paramContext);
      if (d != null)
      {
        if (TextUtils.isEmpty(d)) {
          return null;
        }
        paramContext = new StringBuilder(d);
        paramContext.append(File.separator);
        paramContext.append("res.apk");
        return paramContext.toString();
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTbsResourcesPath exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      Log.e("", localStringBuilder.toString());
    }
    return null;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(k.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.org");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      int m = a.b(new File(new File(k.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.org"));
      return m;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(k.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.decouple");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      int m = a.b(new File(new File(k.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.decouple"));
      return m;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public static boolean getCoreDisabled()
  {
    return g;
  }
  
  public static boolean getCoreFormOwn()
  {
    return j;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone" };
  }
  
  public static int getCoreShareDecoupleCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString);
    if (paramContext != null) {
      return am.a().i(paramContext);
    }
    return 0;
  }
  
  public static String getHostCorePathAppDefined()
  {
    return c;
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    long l1 = 0L;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      long l2;
      long l3;
      if (str.equalsIgnoreCase("com.tencent.mm"))
      {
        l2 = getSharedTbsCoreVersion(paramContext, str);
        l3 = 10000000000L;
      }
      for (l2 *= l3;; l2 = getSharedTbsCoreVersion(paramContext, str))
      {
        l2 = l1 + l2;
        break label119;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l2 = getSharedTbsCoreVersion(paramContext, str);
          l3 = 100000L;
          break;
        }
        l2 = l1;
        if (!str.equalsIgnoreCase("com.qzone")) {
          break label119;
        }
      }
      label119:
      m += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString);
    if (paramContext != null) {
      return am.a().j(paramContext);
    }
    return 0;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = am.a().s(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists()) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  static int h(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 41
    //   5: ldc_w 486
    //   8: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: ldc -96
    //   14: invokestatic 164	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   17: astore_0
    //   18: aload_0
    //   19: ifnonnull +16 -> 35
    //   22: ldc 41
    //   24: ldc_w 488
    //   27: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: new 166	java/io/BufferedInputStream
    //   38: dup
    //   39: new 168	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_0
    //   53: new 176	java/util/Properties
    //   56: dup
    //   57: invokespecial 177	java/util/Properties:<init>	()V
    //   60: astore_3
    //   61: aload_2
    //   62: astore_0
    //   63: aload_3
    //   64: aload_2
    //   65: invokevirtual 180	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   68: aload_2
    //   69: astore_0
    //   70: aload_3
    //   71: ldc_w 490
    //   74: ldc -14
    //   76: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_3
    //   80: aload_2
    //   81: astore_0
    //   82: ldc -14
    //   84: aload_3
    //   85: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +41 -> 129
    //   91: aload_2
    //   92: astore_0
    //   93: ldc 41
    //   95: ldc_w 492
    //   98: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_2
    //   102: astore_0
    //   103: aload_3
    //   104: invokestatic 495	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: iconst_0
    //   108: invokestatic 501	java/lang/Math:max	(II)I
    //   111: istore_1
    //   112: aload_2
    //   113: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   116: goto +8 -> 124
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   124: ldc 2
    //   126: monitorexit
    //   127: iload_1
    //   128: ireturn
    //   129: aload_2
    //   130: astore_0
    //   131: ldc 41
    //   133: ldc_w 503
    //   136: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_2
    //   140: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   143: goto +8 -> 151
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   151: ldc 2
    //   153: monitorexit
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_3
    //   157: goto +12 -> 169
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_2
    //   163: goto +47 -> 210
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: astore_0
    //   171: aload_3
    //   172: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   175: aload_2
    //   176: ifnull +15 -> 191
    //   179: aload_2
    //   180: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   183: goto +8 -> 191
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   191: ldc 41
    //   193: ldc_w 505
    //   196: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: ldc 2
    //   201: monitorexit
    //   202: bipush -2
    //   204: ireturn
    //   205: astore_3
    //   206: aload_0
    //   207: astore_2
    //   208: aload_3
    //   209: astore_0
    //   210: aload_2
    //   211: ifnull +15 -> 226
    //   214: aload_2
    //   215: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   218: goto +8 -> 226
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   226: aload_0
    //   227: athrow
    //   228: astore_0
    //   229: ldc 2
    //   231: monitorexit
    //   232: aload_0
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramContext	Context
    //   111	17	1	m	int
    //   50	165	2	localObject1	Object
    //   221	2	2	localException	Exception
    //   60	44	3	localObject2	Object
    //   156	1	3	localThrowable1	Throwable
    //   166	6	3	localThrowable2	Throwable
    //   205	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   112	116	119	java/lang/Exception
    //   139	143	146	java/lang/Exception
    //   53	61	156	java/lang/Throwable
    //   63	68	156	java/lang/Throwable
    //   70	80	156	java/lang/Throwable
    //   82	91	156	java/lang/Throwable
    //   93	101	156	java/lang/Throwable
    //   103	112	156	java/lang/Throwable
    //   131	139	156	java/lang/Throwable
    //   11	18	160	finally
    //   22	30	160	finally
    //   35	51	160	finally
    //   11	18	166	java/lang/Throwable
    //   22	30	166	java/lang/Throwable
    //   35	51	166	java/lang/Throwable
    //   179	183	186	java/lang/Exception
    //   53	61	205	finally
    //   63	68	205	finally
    //   70	80	205	finally
    //   82	91	205	finally
    //   93	101	205	finally
    //   103	112	205	finally
    //   131	139	205	finally
    //   171	175	205	finally
    //   214	218	221	java/lang/Exception
    //   3	11	228	finally
    //   112	116	228	finally
    //   120	124	228	finally
    //   139	143	228	finally
    //   147	151	228	finally
    //   179	183	228	finally
    //   187	191	228	finally
    //   191	199	228	finally
    //   214	218	228	finally
    //   222	226	228	finally
    //   226	228	228	finally
  }
  
  static boolean i(Context paramContext)
  {
    try
    {
      if (e == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (e == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        return false;
      }
      if (c == null)
      {
        if ((e != 0) && (getSharedTbsCoreVersion(paramContext, f) == e)) {
          return true;
        }
      }
      else if ((e != 0) && (am.a().a(c) == e)) {
        return true;
      }
      if (l(paramContext)) {
        return true;
      }
      TbsCoreLoadStat localTbsCoreLoadStat = TbsCoreLoadStat.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAvailableCoreVersion=");
      localStringBuilder.append(e);
      localStringBuilder.append("; mSrcPackageName=");
      localStringBuilder.append(f);
      localStringBuilder.append("; getSharedTbsCoreVersion(ctx, mSrcPackageName) is ");
      localStringBuilder.append(getSharedTbsCoreVersion(paramContext, f));
      localStringBuilder.append("; getHostCoreVersions is ");
      localStringBuilder.append(getHostCoreVersions(paramContext));
      localTbsCoreLoadStat.a(paramContext, 418, new Throwable(localStringBuilder.toString()));
      d = null;
      e = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.addLog(992, null, new Object[0]);
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    try
    {
      if ((a != null) && (a.equals(paramContext.getApplicationContext())))
      {
        paramContext = new StringBuilder();
        paramContext.append("isThirdPartyApp return sIsThirdPartyApp is ");
        paramContext.append(b);
        TbsLog.i("TbsShareManager", paramContext.toString());
        return b;
      }
      a = paramContext.getApplicationContext();
      paramContext = a.getPackageName();
      Object localObject = getCoreProviderAppList();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("isThirdPartyApp packageName is ");
      localStringBuilder1.append(paramContext);
      TbsLog.i("TbsShareManager", localStringBuilder1.toString());
      int n = localObject.length;
      int m = 0;
      while (m < n)
      {
        localStringBuilder1 = localObject[m];
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("isThirdPartyApp appPackageName is ");
        localStringBuilder2.append(localStringBuilder1);
        TbsLog.i("TbsShareManager", localStringBuilder2.toString());
        if (paramContext.equals(localStringBuilder1))
        {
          b = false;
          paramContext = new StringBuilder();
          paramContext.append("isThirdPartyApp return false appPackageName is ");
          paramContext.append(localStringBuilder1);
          TbsLog.i("TbsShareManager", paramContext.toString());
          return false;
        }
        m += 1;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isThirdPartyApp error ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      ((StringBuilder)localObject).append(" ## ");
      ((StringBuilder)localObject).append(paramContext.getCause());
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
      paramContext.printStackTrace();
      b = true;
      TbsLog.i("TbsShareManager", "isThirdPartyApp return true ");
    }
  }
  
  static boolean j(Context paramContext)
  {
    return b(paramContext, true);
  }
  
  private static boolean k(Context paramContext)
  {
    if (f == null) {
      return false;
    }
    if (e == getSharedTbsCoreVersion(paramContext, f)) {
      return true;
    }
    return e == getCoreShareDecoupleCoreVersion(paramContext, f);
  }
  
  private static boolean l(Context paramContext)
  {
    if (QbSdk.getOnlyDownload()) {
      return false;
    }
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    int m = 0;
    String str;
    Context localContext;
    while (m < n)
    {
      str = arrayOfString[m];
      if ((e > 0) && (e == getSharedTbsCoreVersion(paramContext, str)))
      {
        localContext = getPackageContext(paramContext, str);
        if (am.a().f(paramContext))
        {
          d = am.a().b(paramContext, localContext).getAbsolutePath();
          f = str;
          return true;
        }
      }
      m += 1;
    }
    n = arrayOfString.length;
    m = 0;
    while (m < n)
    {
      str = arrayOfString[m];
      if ((e > 0) && (e == getCoreShareDecoupleCoreVersion(paramContext, str)))
      {
        localContext = getPackageContext(paramContext, str);
        if (am.a().f(paramContext))
        {
          d = am.a().c(paramContext, localContext).getAbsolutePath();
          f = str;
          m = h(paramContext);
          if (e >= m) {
            writeProperties(paramContext, Integer.toString(e), f, d, Integer.toString(0));
          }
          return true;
        }
      }
      m += 1;
    }
    return false;
  }
  
  private static boolean m(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  /* Error */
  private static void n(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 559	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: ldc -96
    //   18: invokestatic 164	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnonnull +7 -> 30
    //   26: ldc 2
    //   28: monitorexit
    //   29: return
    //   30: new 166	java/io/BufferedInputStream
    //   33: dup
    //   34: new 168	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_0
    //   48: new 176	java/util/Properties
    //   51: dup
    //   52: invokespecial 177	java/util/Properties:<init>	()V
    //   55: astore_3
    //   56: aload_2
    //   57: astore_0
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 180	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   63: aload_2
    //   64: astore_0
    //   65: aload_3
    //   66: ldc_w 490
    //   69: ldc -14
    //   71: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 4
    //   76: aload_2
    //   77: astore_0
    //   78: ldc -14
    //   80: aload 4
    //   82: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifne +17 -> 102
    //   88: aload_2
    //   89: astore_0
    //   90: aload 4
    //   92: invokestatic 495	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: iconst_0
    //   96: invokestatic 501	java/lang/Math:max	(II)I
    //   99: putstatic 33	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   102: aload_2
    //   103: astore_0
    //   104: aload_3
    //   105: ldc -50
    //   107: ldc -14
    //   109: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 4
    //   114: aload_2
    //   115: astore_0
    //   116: ldc -14
    //   118: aload 4
    //   120: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +10 -> 133
    //   126: aload_2
    //   127: astore_0
    //   128: aload 4
    //   130: putstatic 234	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   133: aload_2
    //   134: astore_0
    //   135: getstatic 234	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   138: ifnull +43 -> 181
    //   141: aload_2
    //   142: astore_0
    //   143: getstatic 538	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   146: ifnull +35 -> 181
    //   149: aload_2
    //   150: astore_0
    //   151: getstatic 234	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   154: getstatic 538	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   157: invokevirtual 199	android/content/Context:getPackageName	()Ljava/lang/String;
    //   160: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifeq +12 -> 175
    //   166: aload_2
    //   167: astore_0
    //   168: iconst_1
    //   169: putstatic 452	com/tencent/smtt/sdk/TbsShareManager:j	Z
    //   172: goto +9 -> 181
    //   175: aload_2
    //   176: astore_0
    //   177: iconst_0
    //   178: putstatic 452	com/tencent/smtt/sdk/TbsShareManager:j	Z
    //   181: aload_2
    //   182: astore_0
    //   183: aload_3
    //   184: ldc -48
    //   186: ldc -14
    //   188: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 4
    //   193: aload_2
    //   194: astore_0
    //   195: ldc -14
    //   197: aload 4
    //   199: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifne +10 -> 212
    //   205: aload_2
    //   206: astore_0
    //   207: aload 4
    //   209: putstatic 36	com/tencent/smtt/sdk/TbsShareManager:d	Ljava/lang/String;
    //   212: aload_2
    //   213: astore_0
    //   214: aload_3
    //   215: ldc -46
    //   217: ldc -14
    //   219: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   222: astore 4
    //   224: aload_2
    //   225: astore_0
    //   226: ldc -14
    //   228: aload 4
    //   230: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifne +10 -> 243
    //   236: aload_2
    //   237: astore_0
    //   238: aload 4
    //   240: putstatic 561	com/tencent/smtt/sdk/TbsShareManager:i	Ljava/lang/String;
    //   243: aload_2
    //   244: astore_0
    //   245: aload_3
    //   246: ldc -74
    //   248: ldc_w 563
    //   251: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: invokestatic 568	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   257: putstatic 302	com/tencent/smtt/sdk/TbsShareManager:g	Z
    //   260: aload_2
    //   261: astore_0
    //   262: iconst_1
    //   263: putstatic 559	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   266: aload_2
    //   267: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   270: goto +45 -> 315
    //   273: astore_0
    //   274: aload_0
    //   275: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   278: goto +37 -> 315
    //   281: astore_3
    //   282: goto +12 -> 294
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_2
    //   288: goto +36 -> 324
    //   291: astore_3
    //   292: aconst_null
    //   293: astore_2
    //   294: aload_2
    //   295: astore_0
    //   296: aload_3
    //   297: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   300: aload_2
    //   301: ifnull +14 -> 315
    //   304: aload_2
    //   305: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   308: goto +7 -> 315
    //   311: astore_0
    //   312: goto -38 -> 274
    //   315: ldc 2
    //   317: monitorexit
    //   318: return
    //   319: astore_3
    //   320: aload_0
    //   321: astore_2
    //   322: aload_3
    //   323: astore_0
    //   324: aload_2
    //   325: ifnull +15 -> 340
    //   328: aload_2
    //   329: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   332: goto +8 -> 340
    //   335: astore_2
    //   336: aload_2
    //   337: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   340: aload_0
    //   341: athrow
    //   342: astore_0
    //   343: ldc 2
    //   345: monitorexit
    //   346: aload_0
    //   347: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramContext	Context
    //   6	2	1	bool	boolean
    //   45	284	2	localObject1	Object
    //   335	2	2	localException	Exception
    //   55	191	3	localProperties	java.util.Properties
    //   281	1	3	localThrowable1	Throwable
    //   291	6	3	localThrowable2	Throwable
    //   319	4	3	localObject2	Object
    //   74	165	4	str	String
    // Exception table:
    //   from	to	target	type
    //   266	270	273	java/lang/Exception
    //   48	56	281	java/lang/Throwable
    //   58	63	281	java/lang/Throwable
    //   65	76	281	java/lang/Throwable
    //   78	88	281	java/lang/Throwable
    //   90	102	281	java/lang/Throwable
    //   104	114	281	java/lang/Throwable
    //   116	126	281	java/lang/Throwable
    //   128	133	281	java/lang/Throwable
    //   135	141	281	java/lang/Throwable
    //   143	149	281	java/lang/Throwable
    //   151	166	281	java/lang/Throwable
    //   168	172	281	java/lang/Throwable
    //   177	181	281	java/lang/Throwable
    //   183	193	281	java/lang/Throwable
    //   195	205	281	java/lang/Throwable
    //   207	212	281	java/lang/Throwable
    //   214	224	281	java/lang/Throwable
    //   226	236	281	java/lang/Throwable
    //   238	243	281	java/lang/Throwable
    //   245	260	281	java/lang/Throwable
    //   262	266	281	java/lang/Throwable
    //   15	22	285	finally
    //   30	46	285	finally
    //   15	22	291	java/lang/Throwable
    //   30	46	291	java/lang/Throwable
    //   304	308	311	java/lang/Exception
    //   48	56	319	finally
    //   58	63	319	finally
    //   65	76	319	finally
    //   78	88	319	finally
    //   90	102	319	finally
    //   104	114	319	finally
    //   116	126	319	finally
    //   128	133	319	finally
    //   135	141	319	finally
    //   143	149	319	finally
    //   151	166	319	finally
    //   168	172	319	finally
    //   177	181	319	finally
    //   183	193	319	finally
    //   195	205	319	finally
    //   207	212	319	finally
    //   214	224	319	finally
    //   226	236	319	finally
    //   238	243	319	finally
    //   245	260	319	finally
    //   262	266	319	finally
    //   296	300	319	finally
    //   328	332	335	java/lang/Exception
    //   3	7	342	finally
    //   266	270	342	finally
    //   274	278	342	finally
    //   304	308	342	finally
    //   328	332	342	finally
    //   336	340	342	finally
    //   340	342	342	finally
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    c = paramString;
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersion is ");
        ((StringBuilder)localObject1).append(paramInt);
        TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
        if (paramInt == 0)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65135);
          return;
        }
        m = h(paramContext);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersionFromConfig is ");
        ((StringBuilder)localObject1).append(m);
        TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
        if (m < 0)
        {
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65134);
          return;
        }
        if (paramInt == m)
        {
          c(paramContext, paramBoolean);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65133);
          return;
        }
        if (paramInt < m)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65132);
          return;
        }
        m = am.a().j(paramContext);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is ");
        ((StringBuilder)localObject1).append(m);
        TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
        if (paramInt < m)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65132);
          return;
        }
        boolean bool = QbSdk.getOnlyDownload();
        int n = 0;
        if (bool)
        {
          localObject1 = new String[1];
          localObject1[0] = paramContext.getApplicationContext().getPackageName();
        }
        else
        {
          localObject1 = getCoreProviderAppList();
          if (!paramBoolean) {
            break label1459;
          }
          localObject1 = new String[1];
          localObject1[0] = paramContext.getApplicationContext().getPackageName();
        }
        Object localObject2;
        Object localObject3;
        if (c != null)
        {
          if (paramInt == am.a().a(c))
          {
            writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
            try
            {
              localObject1 = getTbsShareFile(paramContext, "core_info");
              if ((!h) && (localObject1 != null))
              {
                localObject2 = new TbsLinuxToolsJni(a);
                ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject2).a(am.a().s(paramContext).getAbsolutePath(), "755");
                h = true;
              }
            }
            catch (Throwable paramContext)
            {
              paramContext.printStackTrace();
            }
            return;
          }
          if (paramInt > am.a().a(c))
          {
            i1 = localObject1.length;
            m = 0;
            if (m < i1)
            {
              localObject2 = localObject1[m];
              if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
              {
                localObject3 = getPackageContext(paramContext, (String)localObject2);
                localObject2 = am.a().r((Context)localObject3).getAbsolutePath();
                b.b(paramContext);
                if (am.a().f((Context)localObject3))
                {
                  localObject1 = new File(c);
                  localObject2 = new File((String)localObject2);
                  localObject3 = new bb();
                  try
                  {
                    k.a((File)localObject2, (File)localObject1, (FileFilter)localObject3);
                    writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
                    localObject1 = getTbsShareFile(paramContext, "core_info");
                    if ((!h) && (localObject1 != null))
                    {
                      localObject2 = new TbsLinuxToolsJni(a);
                      ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
                      ((TbsLinuxToolsJni)localObject2).a(am.a().s(paramContext).getAbsolutePath(), "755");
                      h = true;
                    }
                  }
                  catch (Throwable paramContext)
                  {
                    paramContext.printStackTrace();
                  }
                  return;
                }
              }
              m += 1;
              continue;
            }
          }
        }
        int i1 = localObject1.length;
        m = 0;
        if (m < i1)
        {
          localObject2 = localObject1[m];
          int i2;
          if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
          {
            Object localObject4 = getPackageContext(paramContext, (String)localObject2);
            localObject3 = am.a().r((Context)localObject4).getAbsolutePath();
            i2 = b.b(paramContext);
            if (am.a().f((Context)localObject4))
            {
              if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("thirdAPP pre--> delete old core_share Directory:");
                ((StringBuilder)localObject4).append(paramInt);
                TbsLog.i("TbsShareManager", ((StringBuilder)localObject4).toString());
                localObject4 = am.a().r(paramContext);
                try
                {
                  k.b((File)localObject4);
                  TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                }
                catch (Throwable localThrowable3)
                {
                  localThrowable3.printStackTrace();
                }
              }
              writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, (String)localObject3, Integer.toString(i2));
              try
              {
                localObject2 = getTbsShareFile(paramContext, "core_info");
                if ((h) || (localObject2 == null)) {
                  break label1462;
                }
                localObject3 = new TbsLinuxToolsJni(a);
                ((TbsLinuxToolsJni)localObject3).a(((File)localObject2).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject3).a(am.a().s(paramContext).getAbsolutePath(), "755");
                h = true;
              }
              catch (Throwable localThrowable1) {}
              localThrowable1.printStackTrace();
              break label1462;
            }
          }
          else if (paramInt == getCoreShareDecoupleCoreVersion(paramContext, localThrowable1))
          {
            Object localObject5 = getPackageContext(paramContext, localThrowable1);
            localObject3 = am.a().q((Context)localObject5).getAbsolutePath();
            i2 = b.b(paramContext);
            if (am.a().f((Context)localObject5))
            {
              if (!localThrowable1.equals(paramContext.getApplicationContext().getPackageName()))
              {
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("thirdAPP pre--> delete old core_share Directory:");
                ((StringBuilder)localObject5).append(paramInt);
                TbsLog.i("TbsShareManager", ((StringBuilder)localObject5).toString());
                localObject5 = am.a().r(paramContext);
                try
                {
                  k.b((File)localObject5);
                  TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                }
                catch (Throwable localThrowable4)
                {
                  localThrowable4.printStackTrace();
                }
              }
              writeProperties(paramContext, Integer.toString(paramInt), localThrowable1, (String)localObject3, Integer.toString(i2));
              try
              {
                File localFile = getTbsShareFile(paramContext, "core_info");
                if ((h) || (localFile == null)) {
                  break label1462;
                }
                localObject3 = new TbsLinuxToolsJni(a);
                ((TbsLinuxToolsJni)localObject3).a(localFile.getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject3).a(am.a().s(paramContext).getAbsolutePath(), "755");
                h = true;
              }
              catch (Throwable localThrowable2) {}
              continue;
            }
          }
          m += 1;
          continue;
        }
        m = 0;
        if ((!QbSdk.mDisableUseHostBackupCore) && (m == 0))
        {
          TbsLog.i("TbsShareManager", "find host backup core to unzip #1");
          i1 = localObject1.length;
          m = n;
          if (m < i1)
          {
            String str = localObject1[m];
            if (paramInt == getBackupCoreVersion(paramContext, str))
            {
              localObject3 = getPackageContext(paramContext, str);
              if (am.a().f((Context)localObject3))
              {
                localObject3 = getBackupCoreFile(paramContext, str);
                if (a.a(paramContext, (File)localObject3, 0L, paramInt))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("find host backup core to unzip normal coreVersion is ");
                  ((StringBuilder)localObject1).append(paramInt);
                  ((StringBuilder)localObject1).append(" packageName is ");
                  ((StringBuilder)localObject1).append(str);
                  TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
                  if (!am.a().a(paramContext, (File)localObject3)) {
                    continue;
                  }
                  am.a().a(paramContext, paramInt);
                  localObject1 = am.a();
                  ((am)localObject1).c(paramContext, true);
                  continue;
                }
              }
            }
            else if (paramInt == getBackupDecoupleCoreVersion(paramContext, str))
            {
              localObject3 = getPackageContext(paramContext, str);
              if (am.a().f((Context)localObject3))
              {
                localObject3 = getBackupDecoupleCoreFile(paramContext, str);
                if (a.a(paramContext, (File)localObject3, 0L, paramInt))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("find host backup core to unzip decouple coreVersion is ");
                  ((StringBuilder)localObject1).append(paramInt);
                  ((StringBuilder)localObject1).append(" packageName is ");
                  ((StringBuilder)localObject1).append(str);
                  TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
                  if (!am.a().a(paramContext, (File)localObject3)) {
                    continue;
                  }
                  am.a().a(paramContext, paramInt);
                  localObject1 = am.a();
                  continue;
                }
              }
            }
            m += 1;
            continue;
          }
        }
        return;
      }
      finally {}
      label1459:
      continue;
      label1462:
      int m = 1;
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: new 69	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 616
    //   14: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_1
    //   21: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 618
    //   30: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: ldc_w 620
    //   46: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 6
    //   52: aload_3
    //   53: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 41
    //   59: aload 6
    //   61: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: new 69	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   74: astore 6
    //   76: aload 6
    //   78: ldc_w 622
    //   81: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 6
    //   87: new 39	java/lang/Throwable
    //   90: dup
    //   91: ldc_w 624
    //   94: invokespecial 531	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   97: invokestatic 430	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   100: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: ldc 41
    //   106: aload 6
    //   108: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aconst_null
    //   115: astore 6
    //   117: aconst_null
    //   118: astore 7
    //   120: aload_0
    //   121: ldc -96
    //   123: invokestatic 164	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   126: astore 8
    //   128: aload 8
    //   130: ifnonnull +16 -> 146
    //   133: getstatic 538	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   136: invokestatic 580	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   139: sipush 65131
    //   142: invokevirtual 584	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   145: return
    //   146: new 166	java/io/BufferedInputStream
    //   149: dup
    //   150: new 168	java/io/FileInputStream
    //   153: dup
    //   154: aload 8
    //   156: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   159: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   162: astore_0
    //   163: new 176	java/util/Properties
    //   166: dup
    //   167: invokespecial 177	java/util/Properties:<init>	()V
    //   170: astore 7
    //   172: aload 7
    //   174: aload_0
    //   175: invokevirtual 180	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   178: aload_1
    //   179: invokestatic 495	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   182: istore 5
    //   184: goto +6 -> 190
    //   187: iconst_0
    //   188: istore 5
    //   190: iload 5
    //   192: ifeq +56 -> 248
    //   195: aload 7
    //   197: ldc_w 490
    //   200: aload_1
    //   201: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   204: pop
    //   205: aload 7
    //   207: ldc -74
    //   209: iconst_0
    //   210: invokestatic 186	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   213: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   216: pop
    //   217: aload 7
    //   219: ldc -50
    //   221: aload_2
    //   222: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   225: pop
    //   226: aload 7
    //   228: ldc -48
    //   230: aload_3
    //   231: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   234: pop
    //   235: aload 7
    //   237: ldc -46
    //   239: aload 4
    //   241: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   244: pop
    //   245: goto +15 -> 260
    //   248: aload 7
    //   250: ldc -74
    //   252: iconst_1
    //   253: invokestatic 186	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   256: invokevirtual 190	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   259: pop
    //   260: new 215	java/io/BufferedOutputStream
    //   263: dup
    //   264: new 217	java/io/FileOutputStream
    //   267: dup
    //   268: aload 8
    //   270: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   273: invokespecial 221	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   276: astore_1
    //   277: aload 7
    //   279: aload_1
    //   280: aconst_null
    //   281: invokevirtual 225	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   284: iconst_0
    //   285: putstatic 559	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   288: getstatic 538	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   291: invokestatic 580	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   294: sipush 65130
    //   297: invokevirtual 584	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   300: aload_0
    //   301: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   304: goto +8 -> 312
    //   307: astore_0
    //   308: aload_0
    //   309: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   312: aload_1
    //   313: invokevirtual 229	java/io/BufferedOutputStream:close	()V
    //   316: return
    //   317: astore_0
    //   318: aload_0
    //   319: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   322: return
    //   323: astore_3
    //   324: aload_0
    //   325: astore_2
    //   326: aload_3
    //   327: astore_0
    //   328: goto +73 -> 401
    //   331: astore_2
    //   332: goto +35 -> 367
    //   335: astore_3
    //   336: aload 6
    //   338: astore_1
    //   339: aload_0
    //   340: astore_2
    //   341: aload_3
    //   342: astore_0
    //   343: goto +58 -> 401
    //   346: astore_2
    //   347: aconst_null
    //   348: astore_1
    //   349: goto +18 -> 367
    //   352: astore_0
    //   353: aconst_null
    //   354: astore_2
    //   355: aload 6
    //   357: astore_1
    //   358: goto +43 -> 401
    //   361: astore_2
    //   362: aconst_null
    //   363: astore_1
    //   364: aload 7
    //   366: astore_0
    //   367: aload_2
    //   368: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   371: aload_0
    //   372: ifnull +15 -> 387
    //   375: aload_0
    //   376: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   379: goto +8 -> 387
    //   382: astore_0
    //   383: aload_0
    //   384: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   387: aload_1
    //   388: ifnull +7 -> 395
    //   391: aload_1
    //   392: invokevirtual 229	java/io/BufferedOutputStream:close	()V
    //   395: return
    //   396: astore_3
    //   397: aload_0
    //   398: astore_2
    //   399: aload_3
    //   400: astore_0
    //   401: aload_2
    //   402: ifnull +15 -> 417
    //   405: aload_2
    //   406: invokevirtual 228	java/io/BufferedInputStream:close	()V
    //   409: goto +8 -> 417
    //   412: astore_2
    //   413: aload_2
    //   414: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   417: aload_1
    //   418: ifnull +15 -> 433
    //   421: aload_1
    //   422: invokevirtual 229	java/io/BufferedOutputStream:close	()V
    //   425: goto +8 -> 433
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 478	java/lang/Exception:printStackTrace	()V
    //   433: aload_0
    //   434: athrow
    //   435: astore 9
    //   437: goto -250 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramContext	Context
    //   0	440	1	paramString1	String
    //   0	440	2	paramString2	String
    //   0	440	3	paramString3	String
    //   0	440	4	paramString4	String
    //   182	9	5	m	int
    //   7	349	6	localStringBuilder	StringBuilder
    //   118	247	7	localProperties	java.util.Properties
    //   126	143	8	localFile	File
    //   435	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   300	304	307	java/lang/Exception
    //   312	316	317	java/lang/Exception
    //   391	395	317	java/lang/Exception
    //   277	300	323	finally
    //   277	300	331	java/lang/Throwable
    //   163	178	335	finally
    //   178	184	335	finally
    //   195	245	335	finally
    //   248	260	335	finally
    //   260	277	335	finally
    //   163	178	346	java/lang/Throwable
    //   178	184	346	java/lang/Throwable
    //   195	245	346	java/lang/Throwable
    //   248	260	346	java/lang/Throwable
    //   260	277	346	java/lang/Throwable
    //   120	128	352	finally
    //   133	145	352	finally
    //   146	163	352	finally
    //   120	128	361	java/lang/Throwable
    //   133	145	361	java/lang/Throwable
    //   146	163	361	java/lang/Throwable
    //   375	379	382	java/lang/Exception
    //   367	371	396	finally
    //   405	409	412	java/lang/Exception
    //   421	425	428	java/lang/Exception
    //   178	184	435	java/lang/Exception
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsShareManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */