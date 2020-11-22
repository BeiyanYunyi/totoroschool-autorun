package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.t;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static boolean A = false;
  private static boolean B = false;
  private static TbsListener C;
  private static TbsListener D;
  private static boolean E = false;
  public static final int EXTENSION_INIT_FAILURE = -99999;
  private static boolean F = false;
  public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  public static final int QBMODE = 2;
  public static final String SVNVERSION = "jnizz";
  public static final int TBSMODE = 1;
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  static boolean a = false;
  static boolean b = false;
  static boolean c = true;
  static String d;
  static boolean e = false;
  static long f = 0L;
  static long g = 0L;
  static Object h = new Object();
  static boolean i = true;
  static boolean j = true;
  static boolean k = false;
  static volatile boolean l = false;
  static TbsListener m;
  public static boolean mDisableUseHostBackupCore = false;
  static Map<String, Object> n = null;
  private static int o = 0;
  private static String p = "";
  private static Class<?> q;
  private static Object r;
  private static boolean s = false;
  public static boolean sIsVersionPrinted = false;
  private static String[] t;
  private static String u = "NULL";
  private static String v = "UNKNOWN";
  private static int w = 0;
  private static int x = 170;
  private static String y = null;
  private static String z = null;
  
  static
  {
    l = a;
    mDisableUseHostBackupCore = false;
    A = false;
    B = true;
    C = null;
    D = null;
    E = false;
    F = false;
    m = new n();
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      paramContext = TbsLogReport.a(paramContext);
    }
    for (paramBundle = "initForPatch return false!";; paramBundle = "incrUpdate return null!")
    {
      paramContext.a(216, paramBundle);
      return null;
      paramBundle = r.a(r, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
      if (paramBundle != null) {
        return (Bundle)paramBundle;
      }
      paramContext = TbsLogReport.a(paramContext);
    }
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      return Integer.valueOf(-99999);
    }
    paramContext = r.a(r, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
    if (paramContext != null) {
      return paramContext;
    }
    return null;
  }
  
  static String a()
  {
    return p;
  }
  
  static void a(Context paramContext, String paramString)
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      a = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceSysWebViewInner: ");
      localStringBuilder.append(paramString);
      v = localStringBuilder.toString();
      paramString = new StringBuilder();
      paramString.append("QbSdk.SysWebViewForcedInner...");
      paramString.append(v);
      TbsLog.e("QbSdk", paramString.toString());
      TbsCoreLoadStat.getInstance().a(paramContext, 401, new Throwable(v));
      return;
    }
    finally {}
  }
  
  static boolean a(Context paramContext)
  {
    try
    {
      if (q != null) {
        return true;
      }
      Object localObject2 = am.a().r(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      localObject1 = new File((File)localObject2, "tbs_sdk_extension_dex.jar");
      if (!((File)localObject1).exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("new DexLoader #3 dexFile is ");
      ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
      TbsLog.i("QbSdk", ((StringBuilder)localObject3).toString());
      localObject3 = ((File)localObject1).getParent();
      String str = ((File)localObject1).getAbsolutePath();
      localObject2 = ((File)localObject2).getAbsolutePath();
      q = new DexLoader((String)localObject3, paramContext, new String[] { str }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
      return true;
    }
    catch (Throwable paramContext)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initExtension sys WebView: ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 20000);
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((n != null) && (n.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD)) && (n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return true;
    }
    if (!c(paramContext)) {
      return true;
    }
    paramContext = r.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43612), Integer.valueOf(paramInt2) });
    if (paramContext != null) {}
    do
    {
      return ((Boolean)paramContext).booleanValue();
      paramContext = r.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43612) });
    } while (paramContext != null);
    return true;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43612; SDK_VERSION_NAME: 3.6.0.1315");
      sIsVersionPrinted = true;
    }
    Object localObject1;
    if ((a) && (!paramBoolean))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QbSdk init: ");
      ((StringBuilder)localObject1).append(v);
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString(), false);
      TbsCoreLoadStat.getInstance().a(paramContext, 414, new Throwable(v));
      return false;
    }
    if (b)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable(u));
      return false;
    }
    if (!B) {
      d(paramContext);
    }
    int i1;
    try
    {
      localObject2 = am.a().r(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
        TbsCoreLoadStat.getInstance().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        if ((o != 0) && (o != TbsShareManager.d(paramContext)))
        {
          q = null;
          r = null;
          TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
          localObject1 = TbsCoreLoadStat.getInstance();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sTbsVersion: ");
          ((StringBuilder)localObject2).append(o);
          ((StringBuilder)localObject2).append("; AvailableTbsCoreVersion: ");
          ((StringBuilder)localObject2).append(TbsShareManager.d(paramContext));
          ((TbsCoreLoadStat)localObject1).a(paramContext, 302, new Throwable(((StringBuilder)localObject2).toString()));
          return false;
        }
        i1 = TbsShareManager.d(paramContext);
      }
      int i2;
      do
      {
        o = i1;
        break;
        if (o == 0) {
          break label1074;
        }
        i2 = am.a().a(true, paramContext);
        i1 = i2;
      } while (o == i2);
      q = null;
      r = null;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=");
      ((StringBuilder)localObject1).append(i2);
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString(), true);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QbSdk init (false) not isThirdPartyApp sTbsVersion=");
      ((StringBuilder)localObject1).append(o);
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString(), true);
      localObject1 = TbsCoreLoadStat.getInstance();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sTbsVersion: ");
      ((StringBuilder)localObject2).append(o);
      ((StringBuilder)localObject2).append("; tbsCoreInstalledVer: ");
      ((StringBuilder)localObject2).append(i2);
      ((TbsCoreLoadStat)localObject1).a(paramContext, 303, new Throwable(((StringBuilder)localObject2).toString()));
      return false;
      if (q != null) {
        return true;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        if (TbsShareManager.j(paramContext))
        {
          localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        }
        else
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
          return false;
        }
      }
      else {
        localObject1 = new File(am.a().r(paramContext), "tbs_sdk_extension_dex.jar");
      }
      paramBoolean = ((File)localObject1).exists();
      if (!paramBoolean) {
        try
        {
          TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
          i2 = am.a().j(paramContext);
          if (new File(((File)localObject1).getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
            if (i2 > 0)
            {
              localObject1 = TbsCoreLoadStat.getInstance();
              i1 = 4131;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("tbs_sdk_extension_dex not exist(with fusion dex)!");
              ((StringBuilder)localObject2).append(i2);
              localObject2 = new Exception(((StringBuilder)localObject2).toString());
            }
          }
          for (;;)
          {
            ((TbsCoreLoadStat)localObject1).a(paramContext, i1, (Throwable)localObject2);
            return false;
            localObject1 = TbsCoreLoadStat.getInstance();
            i1 = 4132;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("tbs_sdk_extension_dex not exist(with fusion dex)!");
            ((StringBuilder)localObject2).append(i2);
            localObject2 = new Exception(((StringBuilder)localObject2).toString());
            continue;
            if (i2 > 0)
            {
              localObject1 = TbsCoreLoadStat.getInstance();
              i1 = 4121;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("tbs_sdk_extension_dex not exist(without fusion dex)!");
              ((StringBuilder)localObject2).append(i2);
              localObject2 = new Exception(((StringBuilder)localObject2).toString());
            }
            else
            {
              localObject1 = TbsCoreLoadStat.getInstance();
              i1 = 4122;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("tbs_sdk_extension_dex not exist(without fusion dex)!");
              ((StringBuilder)localObject2).append(i2);
              localObject2 = new Exception(((StringBuilder)localObject2).toString());
            }
          }
          if (TbsShareManager.getHostCorePathAppDefined() == null) {
            break label855;
          }
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          return false;
        }
      }
      localObject2 = TbsShareManager.getHostCorePathAppDefined();
    }
    catch (Throwable localThrowable2)
    {
      label855:
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QbSdk init Throwable: ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(localThrowable2));
      TbsLog.e("QbSdk", ((StringBuilder)localObject2).toString());
      TbsCoreLoadStat.getInstance().a(paramContext, 306, localThrowable2);
      return false;
    }
    localObject2 = ((File)localObject2).getAbsolutePath();
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbSdk init optDirExtension #1 is ");
      localStringBuilder.append((String)localObject2);
      TbsLog.i("QbSdk", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("new DexLoader #1 dexFile is ");
      localStringBuilder.append(localThrowable1.getAbsolutePath());
      TbsLog.i("QbSdk", localStringBuilder.toString());
      q = new DexLoader(localThrowable1.getParent(), paramContext, new String[] { localThrowable1.getAbsolutePath() }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, localThrowable1.getParent());
      r.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
      label1074:
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 349	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore_2
    //   11: iload 7
    //   13: ifeq +22 -> 35
    //   16: aload_0
    //   17: invokestatic 418	com/tencent/smtt/sdk/TbsShareManager:i	(Landroid/content/Context;)Z
    //   20: ifne +15 -> 35
    //   23: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   26: aload_0
    //   27: sipush 302
    //   30: invokevirtual 421	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: iload_1
    //   37: invokestatic 423	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Z)Z
    //   40: ifne +13 -> 53
    //   43: ldc -48
    //   45: ldc_w 425
    //   48: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: getstatic 160	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   56: astore 8
    //   58: iconst_1
    //   59: istore 5
    //   61: aload 8
    //   63: ldc_w 427
    //   66: iconst_1
    //   67: anewarray 164	java/lang/Class
    //   70: dup
    //   71: iconst_0
    //   72: getstatic 315	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   75: aastore
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: ldc_w 316
    //   85: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 173	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnull +1084 -> 1180
    //   99: aload 8
    //   101: instanceof 186
    //   104: ifeq +19 -> 123
    //   107: aload 8
    //   109: checkcast 186	java/lang/String
    //   112: ldc_w 429
    //   115: invokevirtual 433	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   118: ifeq +5 -> 123
    //   121: iconst_0
    //   122: ireturn
    //   123: aload 8
    //   125: instanceof 168
    //   128: ifne +65 -> 193
    //   131: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   134: astore 9
    //   136: new 192	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   143: astore 10
    //   145: aload 10
    //   147: ldc 75
    //   149: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 10
    //   155: aload 8
    //   157: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 9
    //   163: aload_0
    //   164: sipush 330
    //   167: new 221	java/lang/Throwable
    //   170: dup
    //   171: aload 10
    //   173: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   179: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   182: ldc_w 438
    //   185: ldc_w 440
    //   188: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: iconst_0
    //   192: ireturn
    //   193: aload 8
    //   195: checkcast 168	android/os/Bundle
    //   198: astore 9
    //   200: aload 9
    //   202: invokevirtual 443	android/os/Bundle:isEmpty	()Z
    //   205: ifeq +65 -> 270
    //   208: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   211: astore 9
    //   213: new 192	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   220: astore 10
    //   222: aload 10
    //   224: ldc 75
    //   226: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 10
    //   232: aload 8
    //   234: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 9
    //   240: aload_0
    //   241: sipush 331
    //   244: new 221	java/lang/Throwable
    //   247: dup
    //   248: aload 10
    //   250: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   256: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   259: ldc_w 438
    //   262: ldc_w 445
    //   265: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: iconst_0
    //   269: ireturn
    //   270: iconst_m1
    //   271: istore_3
    //   272: aload 9
    //   274: ldc_w 447
    //   277: iconst_m1
    //   278: invokevirtual 451	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   281: istore 4
    //   283: iload 4
    //   285: istore_3
    //   286: goto +44 -> 330
    //   289: astore 8
    //   291: new 192	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   298: astore 10
    //   300: aload 10
    //   302: ldc_w 453
    //   305: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 10
    //   311: aload 8
    //   313: invokevirtual 454	java/lang/Exception:toString	()Ljava/lang/String;
    //   316: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc -48
    //   322: aload 10
    //   324: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: iload_3
    //   331: ifne +8 -> 339
    //   334: iconst_1
    //   335: istore_1
    //   336: goto +5 -> 341
    //   339: iconst_0
    //   340: istore_1
    //   341: aload_0
    //   342: invokestatic 349	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   345: ifeq +84 -> 429
    //   348: aload_0
    //   349: invokestatic 354	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   352: invokestatic 459	com/tencent/smtt/sdk/o:a	(I)V
    //   355: aload_0
    //   356: invokestatic 354	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   359: invokestatic 462	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   362: putstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   365: getstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   368: invokevirtual 466	java/lang/String:length	()I
    //   371: iconst_5
    //   372: if_icmpne +38 -> 410
    //   375: new 192	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   382: astore 8
    //   384: aload 8
    //   386: ldc_w 468
    //   389: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 8
    //   395: getstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   398: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 8
    //   404: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: putstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   410: getstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   413: invokevirtual 466	java/lang/String:length	()I
    //   416: bipush 6
    //   418: if_icmpeq +267 -> 685
    //   421: ldc 75
    //   423: putstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   426: goto +259 -> 685
    //   429: getstatic 473	android/os/Build$VERSION:SDK_INT	I
    //   432: bipush 12
    //   434: if_icmplt +24 -> 458
    //   437: aload 9
    //   439: ldc_w 475
    //   442: ldc_w 468
    //   445: invokevirtual 479	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   448: astore 8
    //   450: aload 8
    //   452: putstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   455: goto +34 -> 489
    //   458: aload 9
    //   460: ldc_w 475
    //   463: invokevirtual 482	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   466: putstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   469: getstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   472: ifnonnull +17 -> 489
    //   475: ldc_w 468
    //   478: astore 8
    //   480: goto -30 -> 450
    //   483: ldc_w 468
    //   486: putstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   489: getstatic 189	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   492: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   495: putstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   498: goto +7 -> 505
    //   501: iconst_0
    //   502: putstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   505: getstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   508: invokestatic 459	com/tencent/smtt/sdk/o:a	(I)V
    //   511: getstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   514: ifne +25 -> 539
    //   517: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   520: aload_0
    //   521: sipush 307
    //   524: new 221	java/lang/Throwable
    //   527: dup
    //   528: ldc_w 488
    //   531: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   534: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   537: iconst_0
    //   538: ireturn
    //   539: getstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   542: ifle +16 -> 558
    //   545: iload 5
    //   547: istore 4
    //   549: getstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   552: sipush 25442
    //   555: if_icmple +22 -> 577
    //   558: getstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   561: sipush 25472
    //   564: if_icmpne +10 -> 574
    //   567: iload 5
    //   569: istore 4
    //   571: goto +6 -> 577
    //   574: iconst_0
    //   575: istore 4
    //   577: iload 4
    //   579: ifeq +106 -> 685
    //   582: new 192	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   589: astore 8
    //   591: aload 8
    //   593: ldc_w 490
    //   596: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 8
    //   602: getstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   605: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: ldc_w 492
    //   612: aload 8
    //   614: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: invokestatic 234	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   623: aload_0
    //   624: invokevirtual 237	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   627: invokestatic 497	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   630: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   633: astore 8
    //   635: new 192	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   642: astore 9
    //   644: aload 9
    //   646: ldc_w 490
    //   649: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload 9
    //   655: getstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   658: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 8
    //   664: aload_0
    //   665: sipush 307
    //   668: new 221	java/lang/Throwable
    //   671: dup
    //   672: aload 9
    //   674: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   680: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   683: iconst_0
    //   684: ireturn
    //   685: aload 9
    //   687: ldc_w 499
    //   690: invokevirtual 503	android/os/Bundle:getStringArray	(Ljava/lang/String;)[Ljava/lang/String;
    //   693: putstatic 505	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   696: getstatic 505	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   699: instanceof 506
    //   702: ifne +58 -> 760
    //   705: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   708: astore 8
    //   710: new 192	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   717: astore 9
    //   719: aload 9
    //   721: ldc_w 508
    //   724: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 9
    //   730: getstatic 505	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   733: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 8
    //   739: aload_0
    //   740: sipush 307
    //   743: new 221	java/lang/Throwable
    //   746: dup
    //   747: aload 9
    //   749: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   755: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   758: iconst_0
    //   759: ireturn
    //   760: aload 9
    //   762: ldc_w 510
    //   765: invokevirtual 482	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   768: putstatic 512	com/tencent/smtt/sdk/QbSdk:d	Ljava/lang/String;
    //   771: aconst_null
    //   772: astore 9
    //   774: aload 9
    //   776: astore 8
    //   778: iload_3
    //   779: ifeq +36 -> 815
    //   782: getstatic 160	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   785: ldc_w 514
    //   788: iconst_0
    //   789: anewarray 164	java/lang/Class
    //   792: iconst_0
    //   793: anewarray 4	java/lang/Object
    //   796: invokestatic 173	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   799: astore 8
    //   801: goto +14 -> 815
    //   804: astore 8
    //   806: aload 8
    //   808: invokevirtual 515	java/lang/Exception:printStackTrace	()V
    //   811: aload 9
    //   813: astore 8
    //   815: iload_3
    //   816: tableswitch	default:+28->844, -2:+219->1035, -1:+99->915, 0:+345->1161
    //   844: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   847: astore 9
    //   849: new 192	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   856: astore 10
    //   858: aload 10
    //   860: ldc_w 517
    //   863: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload 10
    //   869: aload 8
    //   871: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload 10
    //   877: ldc_w 519
    //   880: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload 10
    //   886: iload_3
    //   887: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload 9
    //   893: aload_0
    //   894: sipush 415
    //   897: new 221	java/lang/Throwable
    //   900: dup
    //   901: aload 10
    //   903: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   909: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   912: goto +249 -> 1161
    //   915: aload 8
    //   917: instanceof 178
    //   920: ifeq +60 -> 980
    //   923: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   926: astore 9
    //   928: aload 8
    //   930: checkcast 178	java/lang/Integer
    //   933: invokevirtual 522	java/lang/Integer:intValue	()I
    //   936: istore_3
    //   937: new 192	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   944: astore 10
    //   946: aload 10
    //   948: ldc_w 517
    //   951: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload 10
    //   957: aload 8
    //   959: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: new 221	java/lang/Throwable
    //   966: dup
    //   967: aload 10
    //   969: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   975: astore 8
    //   977: goto +120 -> 1097
    //   980: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   983: astore 9
    //   985: new 192	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   992: astore 10
    //   994: aload 10
    //   996: ldc_w 517
    //   999: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload 10
    //   1005: aload 8
    //   1007: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload 9
    //   1013: aload_0
    //   1014: sipush 307
    //   1017: new 221	java/lang/Throwable
    //   1020: dup
    //   1021: aload 10
    //   1023: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1029: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1032: goto +129 -> 1161
    //   1035: aload 8
    //   1037: instanceof 178
    //   1040: ifeq +69 -> 1109
    //   1043: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1046: astore 9
    //   1048: aload 8
    //   1050: checkcast 178	java/lang/Integer
    //   1053: invokevirtual 522	java/lang/Integer:intValue	()I
    //   1056: istore_3
    //   1057: new 192	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1064: astore 10
    //   1066: aload 10
    //   1068: ldc_w 517
    //   1071: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: aload 10
    //   1077: aload 8
    //   1079: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: new 221	java/lang/Throwable
    //   1086: dup
    //   1087: aload 10
    //   1089: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1095: astore 8
    //   1097: aload 9
    //   1099: aload_0
    //   1100: iload_3
    //   1101: aload 8
    //   1103: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1106: goto +55 -> 1161
    //   1109: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1112: astore 9
    //   1114: sipush 404
    //   1117: istore_3
    //   1118: new 192	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1125: astore 10
    //   1127: aload 10
    //   1129: ldc_w 517
    //   1132: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload 10
    //   1138: aload 8
    //   1140: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: new 221	java/lang/Throwable
    //   1147: dup
    //   1148: aload 10
    //   1150: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokespecial 224	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1156: astore 8
    //   1158: goto -61 -> 1097
    //   1161: goto +243 -> 1404
    //   1164: astore 8
    //   1166: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1169: aload_0
    //   1170: sipush 329
    //   1173: aload 8
    //   1175: invokevirtual 227	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1178: iconst_0
    //   1179: ireturn
    //   1180: getstatic 160	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   1183: astore 8
    //   1185: getstatic 315	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1188: astore 9
    //   1190: invokestatic 526	com/tencent/smtt/sdk/a:a	()I
    //   1193: istore_3
    //   1194: aload 8
    //   1196: ldc_w 528
    //   1199: iconst_1
    //   1200: anewarray 164	java/lang/Class
    //   1203: dup
    //   1204: iconst_0
    //   1205: aload 9
    //   1207: aastore
    //   1208: iconst_1
    //   1209: anewarray 4	java/lang/Object
    //   1212: dup
    //   1213: iconst_0
    //   1214: iload_3
    //   1215: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1218: aastore
    //   1219: invokestatic 173	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1222: astore 8
    //   1224: aload 8
    //   1226: ifnull +165 -> 1391
    //   1229: aload 8
    //   1231: instanceof 186
    //   1234: ifeq +19 -> 1253
    //   1237: aload 8
    //   1239: checkcast 186	java/lang/String
    //   1242: ldc_w 429
    //   1245: invokevirtual 433	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1248: ifeq +5 -> 1253
    //   1251: iconst_0
    //   1252: ireturn
    //   1253: iload 6
    //   1255: istore_1
    //   1256: aload 8
    //   1258: instanceof 318
    //   1261: ifeq +143 -> 1404
    //   1264: invokestatic 530	com/tencent/smtt/sdk/o:e	()I
    //   1267: putstatic 351	com/tencent/smtt/sdk/QbSdk:o	I
    //   1270: aload_0
    //   1271: invokestatic 530	com/tencent/smtt/sdk/o:e	()I
    //   1274: invokestatic 532	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;I)Z
    //   1277: istore 6
    //   1279: aload 8
    //   1281: checkcast 318	java/lang/Boolean
    //   1284: astore_0
    //   1285: iload_2
    //   1286: istore_1
    //   1287: aload_0
    //   1288: invokevirtual 321	java/lang/Boolean:booleanValue	()Z
    //   1291: ifeq +12 -> 1303
    //   1294: iload_2
    //   1295: istore_1
    //   1296: iload 6
    //   1298: ifne +5 -> 1303
    //   1301: iconst_1
    //   1302: istore_1
    //   1303: iload_1
    //   1304: ifne +85 -> 1389
    //   1307: ldc_w 438
    //   1310: ldc_w 534
    //   1313: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1316: new 192	java/lang/StringBuilder
    //   1319: dup
    //   1320: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1323: astore 8
    //   1325: aload 8
    //   1327: ldc_w 536
    //   1330: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload 8
    //   1336: iload 6
    //   1338: invokevirtual 539	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: ldc_w 438
    //   1345: aload 8
    //   1347: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: invokestatic 541	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1353: new 192	java/lang/StringBuilder
    //   1356: dup
    //   1357: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1360: astore 8
    //   1362: aload 8
    //   1364: ldc_w 543
    //   1367: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: aload 8
    //   1373: aload_0
    //   1374: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: ldc_w 438
    //   1381: aload 8
    //   1383: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1386: invokestatic 541	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1389: iload_1
    //   1390: ireturn
    //   1391: invokestatic 219	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1394: aload_0
    //   1395: sipush 308
    //   1398: invokevirtual 421	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   1401: iload 6
    //   1403: istore_1
    //   1404: iload_1
    //   1405: ifne +12 -> 1417
    //   1408: ldc_w 438
    //   1411: ldc_w 545
    //   1414: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1417: iload_1
    //   1418: ireturn
    //   1419: astore 8
    //   1421: goto -938 -> 483
    //   1424: astore 8
    //   1426: goto -925 -> 501
    //   1429: astore_0
    //   1430: iconst_0
    //   1431: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1432	0	paramContext	Context
    //   0	1432	1	paramBoolean1	boolean
    //   0	1432	2	paramBoolean2	boolean
    //   271	944	3	i1	int
    //   281	297	4	i2	int
    //   59	509	5	i3	int
    //   7	1395	6	bool1	boolean
    //   4	8	7	bool2	boolean
    //   56	177	8	localObject1	Object
    //   289	23	8	localException1	Exception
    //   382	418	8	localObject2	Object
    //   804	3	8	localException2	Exception
    //   813	344	8	localObject3	Object
    //   1164	10	8	localThrowable	Throwable
    //   1183	199	8	localObject4	Object
    //   1419	1	8	localException3	Exception
    //   1424	1	8	localNumberFormatException	NumberFormatException
    //   134	1072	9	localObject5	Object
    //   143	1006	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   272	283	289	java/lang/Exception
    //   782	801	804	java/lang/Exception
    //   685	696	1164	java/lang/Throwable
    //   429	450	1419	java/lang/Exception
    //   450	455	1419	java/lang/Exception
    //   458	475	1419	java/lang/Exception
    //   489	498	1424	java/lang/NumberFormatException
    //   760	771	1429	java/lang/Exception
  }
  
  /* Error */
  private static int b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 241	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 548
    //   8: iconst_0
    //   9: invokevirtual 552	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   12: aload_1
    //   13: invokespecial 246	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_0
    //   18: invokevirtual 250	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: new 241	java/io/File
    //   29: dup
    //   30: aload_0
    //   31: ldc_w 554
    //   34: invokespecial 246	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 250	java/io/File:exists	()Z
    //   42: ifne +5 -> 47
    //   45: iconst_0
    //   46: ireturn
    //   47: new 556	java/io/BufferedInputStream
    //   50: dup
    //   51: new 558	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 560	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 563	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_0
    //   63: new 565	java/util/Properties
    //   66: dup
    //   67: invokespecial 566	java/util/Properties:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_0
    //   73: invokevirtual 569	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   76: aload_1
    //   77: ldc_w 571
    //   80: invokevirtual 574	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   86: istore_2
    //   87: aload_0
    //   88: invokevirtual 577	java/io/BufferedInputStream:close	()V
    //   91: iload_2
    //   92: ireturn
    //   93: astore_3
    //   94: aload_0
    //   95: astore_1
    //   96: aload_3
    //   97: astore_0
    //   98: goto +6 -> 104
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 577	java/io/BufferedInputStream:close	()V
    //   112: aload_0
    //   113: athrow
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 577	java/io/BufferedInputStream:close	()V
    //   124: iconst_0
    //   125: ireturn
    //   126: astore_0
    //   127: goto -13 -> 114
    //   130: astore_1
    //   131: goto -15 -> 116
    //   134: astore_0
    //   135: iload_2
    //   136: ireturn
    //   137: astore_1
    //   138: goto -26 -> 112
    //   141: astore_0
    //   142: iconst_0
    //   143: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramString	String
    //   86	50	2	i1	int
    //   93	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   63	87	93	finally
    //   47	63	101	finally
    //   47	63	126	java/lang/Throwable
    //   63	87	130	java/lang/Throwable
    //   87	91	134	java/lang/Exception
    //   108	112	137	java/lang/Exception
    //   120	124	141	java/lang/Exception
  }
  
  protected static String b()
  {
    Object localObject = bt.a();
    if ((localObject != null) && (((bt)localObject).b()))
    {
      localObject = ((bt)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String))) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      if (paramContext.getApplicationInfo().packageName.contains("com.tencent.portfolio"))
      {
        TbsLog.i("QbSdk", "clearPluginConfigFile #1");
        localObject = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("app_versionname", null);
        String str = paramContext.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearPluginConfigFile oldAppVersionName is ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" newAppVersionName is ");
        localStringBuilder.append(str);
        TbsLog.i("QbSdk", localStringBuilder.toString());
        if ((localObject != null) && (!((String)localObject).contains(str)))
        {
          paramContext = paramContext.getSharedPreferences("plugin_setting", 0);
          if (paramContext != null)
          {
            paramContext = paramContext.edit();
            paramContext.clear();
            paramContext.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
          }
        }
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearPluginConfigFile error is ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      TbsLog.i("QbSdk", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private static boolean c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (q != null) {
          return true;
        }
        localObject2 = am.a().r(paramContext);
        if (localObject2 == null)
        {
          TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
          return false;
        }
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          if (TbsShareManager.j(paramContext))
          {
            localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
          }
          else
          {
            TbsCoreLoadStat.getInstance().a(paramContext, 304);
            return false;
          }
        }
        else {
          localObject1 = new File(am.a().r(paramContext), "tbs_sdk_extension_dex.jar");
        }
        if (!((File)localObject1).exists())
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
          return false;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
          localObject2 = TbsShareManager.getHostCorePathAppDefined();
        } else {
          localObject2 = ((File)localObject2).getAbsolutePath();
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initForX5DisableConfig sys WebView: ");
        ((StringBuilder)localObject1).append(Log.getStackTraceString(paramContext));
        TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString());
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbSdk init optDirExtension #3 is ");
      localStringBuilder.append((String)localObject2);
      TbsLog.i("QbSdk", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("new DexLoader #4 dexFile is ");
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      TbsLog.i("QbSdk", localStringBuilder.toString());
      q = new DexLoader(((File)localObject1).getParent(), paramContext, new String[] { ((File)localObject1).getAbsolutePath() }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
      r.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
    }
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = r.a(r, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    TbsCoreLoadStat localTbsCoreLoadStat;
    int i1;
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        break label70;
      }
      localTbsCoreLoadStat = TbsCoreLoadStat.getInstance();
      i1 = 313;
    }
    else
    {
      localTbsCoreLoadStat = TbsCoreLoadStat.getInstance();
      i1 = 314;
    }
    localTbsCoreLoadStat.a(paramContext, i1);
    label70:
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    return a(paramContext, false, false);
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    label337:
    for (;;)
    {
      try
      {
        if ((paramContext.getApplicationInfo().packageName.contains("com.moji.mjweather")) && (Build.VERSION.SDK_INT == 19)) {
          return true;
        }
        if (q == null)
        {
          localObject = am.a().r(paramContext);
          if (localObject == null)
          {
            TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
            return false;
          }
          File localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
          if (!localFile.exists())
          {
            TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
            return false;
          }
          if (TbsShareManager.getHostCorePathAppDefined() != null)
          {
            localObject = TbsShareManager.getHostCorePathAppDefined();
            break label337;
          }
          localObject = ((File)localObject).getAbsolutePath();
          break label337;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("QbSdk init optDirExtension #2 is ");
          localStringBuilder.append((String)localObject);
          TbsLog.i("QbSdk", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("new DexLoader #2 dexFile is ");
          localStringBuilder.append(localFile.getAbsolutePath());
          TbsLog.i("QbSdk", localStringBuilder.toString());
          q = new DexLoader(localFile.getParent(), paramContext, new String[] { localFile.getAbsolutePath() }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
          if (r == null)
          {
            if ((TbsShareManager.e(paramContext) == null) && (TbsShareManager.getHostCorePathAppDefined() == null))
            {
              TbsLogReport.a(paramContext.getApplicationContext()).b(227, "host context is null!");
              return false;
            }
            loadTBSSDKExtension(paramContext, localFile.getParent());
          }
        }
        paramContext = r.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
        if ((paramContext != null) && ((paramContext instanceof Boolean)))
        {
          boolean bool = ((Boolean)paramContext).booleanValue();
          return bool;
        }
        return false;
      }
      catch (Throwable paramContext)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("canLoadX5FirstTimeThirdApp sys WebView: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramContext));
        TbsLog.e("QbSdk", ((StringBuilder)localObject).toString());
        return false;
      }
    }
  }
  
  public static void canOpenFile(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    new h(paramContext, paramString, paramValueCallback).start();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!a(paramContext, false)) {}
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 108	com/tencent/smtt/sdk/QbSdk:w	I
    //   3: ifne +9 -> 12
    //   6: invokestatic 526	com/tencent/smtt/sdk/a:a	()I
    //   9: putstatic 108	com/tencent/smtt/sdk/QbSdk:w	I
    //   12: new 192	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   19: astore 7
    //   21: aload 7
    //   23: ldc_w 731
    //   26: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 7
    //   32: getstatic 108	com/tencent/smtt/sdk/QbSdk:w	I
    //   35: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc -48
    //   41: aload 7
    //   43: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 262	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: getstatic 473	android/os/Build$VERSION:SDK_INT	I
    //   52: istore_1
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_1
    //   56: bipush 7
    //   58: if_icmplt +489 -> 547
    //   61: getstatic 108	com/tencent/smtt/sdk/QbSdk:w	I
    //   64: getstatic 110	com/tencent/smtt/sdk/QbSdk:x	I
    //   67: if_icmpge +5 -> 72
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: ifnonnull +5 -> 78
    //   76: iconst_0
    //   77: ireturn
    //   78: aconst_null
    //   79: astore 9
    //   81: aconst_null
    //   82: astore 7
    //   84: aconst_null
    //   85: astore 11
    //   87: aconst_null
    //   88: astore 10
    //   90: new 556	java/io/BufferedInputStream
    //   93: dup
    //   94: new 558	java/io/FileInputStream
    //   97: dup
    //   98: new 241	java/io/File
    //   101: dup
    //   102: invokestatic 234	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   105: aload_0
    //   106: invokevirtual 237	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   109: ldc_w 554
    //   112: invokespecial 246	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   115: invokespecial 560	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: invokespecial 563	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: astore 8
    //   123: new 565	java/util/Properties
    //   126: dup
    //   127: invokespecial 566	java/util/Properties:<init>	()V
    //   130: astore 7
    //   132: aload 7
    //   134: aload 8
    //   136: invokevirtual 569	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   139: aload 7
    //   141: ldc_w 733
    //   144: invokevirtual 574	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 11
    //   149: aload 7
    //   151: ldc_w 735
    //   154: invokevirtual 574	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 12
    //   159: aload 11
    //   161: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   164: istore_1
    //   165: aload 12
    //   167: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: istore_3
    //   171: getstatic 738	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   174: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   177: istore 4
    //   179: iload 4
    //   181: iload_1
    //   182: if_icmpgt +256 -> 438
    //   185: iload 4
    //   187: iload_3
    //   188: if_icmpge +6 -> 194
    //   191: goto +247 -> 438
    //   194: aload 7
    //   196: ldc_w 475
    //   199: invokevirtual 574	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   205: istore_3
    //   206: aload 8
    //   208: invokevirtual 577	java/io/BufferedInputStream:close	()V
    //   211: aload 10
    //   213: astore 7
    //   215: new 558	java/io/FileInputStream
    //   218: dup
    //   219: new 241	java/io/File
    //   222: dup
    //   223: aload_0
    //   224: invokestatic 740	com/tencent/smtt/sdk/am:t	(Landroid/content/Context;)Ljava/io/File;
    //   227: ldc_w 742
    //   230: invokespecial 246	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   233: invokespecial 560	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   236: astore 8
    //   238: new 565	java/util/Properties
    //   241: dup
    //   242: invokespecial 566	java/util/Properties:<init>	()V
    //   245: astore 7
    //   247: aload 7
    //   249: aload 8
    //   251: invokevirtual 569	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   254: aload 7
    //   256: ldc_w 744
    //   259: invokevirtual 574	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   265: istore 4
    //   267: aload 7
    //   269: ldc_w 746
    //   272: invokevirtual 574	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   275: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   278: istore 5
    //   280: iload_2
    //   281: istore_1
    //   282: iload_3
    //   283: ldc_w 747
    //   286: if_icmpeq +89 -> 375
    //   289: iload 4
    //   291: ldc_w 747
    //   294: if_icmpne +295 -> 589
    //   297: iload_2
    //   298: istore_1
    //   299: goto +76 -> 375
    //   302: iload_2
    //   303: istore_1
    //   304: iload_3
    //   305: iload 4
    //   307: if_icmpne +68 -> 375
    //   310: iload 5
    //   312: ifle +17 -> 329
    //   315: iload 5
    //   317: aload_0
    //   318: invokestatic 751	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   321: if_icmpeq +8 -> 329
    //   324: iload_2
    //   325: istore_1
    //   326: goto +49 -> 375
    //   329: iload_2
    //   330: istore_1
    //   331: aload 7
    //   333: ldc_w 753
    //   336: invokevirtual 574	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokestatic 756	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   342: ifeq +33 -> 375
    //   345: aload_0
    //   346: invokevirtual 707	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   349: invokestatic 622	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   352: getfield 626	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   355: ldc_w 758
    //   358: iconst_0
    //   359: invokeinterface 762 3 0
    //   364: istore 6
    //   366: iload_2
    //   367: istore_1
    //   368: iload 6
    //   370: ifne +5 -> 375
    //   373: iconst_1
    //   374: istore_1
    //   375: aload 8
    //   377: invokevirtual 765	java/io/InputStream:close	()V
    //   380: goto +42 -> 422
    //   383: astore_0
    //   384: goto +42 -> 426
    //   387: aload 8
    //   389: astore_0
    //   390: goto +11 -> 401
    //   393: astore_0
    //   394: aload 7
    //   396: astore 8
    //   398: goto +28 -> 426
    //   401: aload_0
    //   402: astore 7
    //   404: ldc -48
    //   406: ldc_w 767
    //   409: invokestatic 262	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_0
    //   413: ifnull +7 -> 420
    //   416: aload_0
    //   417: invokevirtual 765	java/io/InputStream:close	()V
    //   420: iconst_1
    //   421: istore_1
    //   422: iload_1
    //   423: iconst_1
    //   424: ixor
    //   425: ireturn
    //   426: aload 8
    //   428: ifnull +8 -> 436
    //   431: aload 8
    //   433: invokevirtual 765	java/io/InputStream:close	()V
    //   436: aload_0
    //   437: athrow
    //   438: new 192	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   445: astore_0
    //   446: aload_0
    //   447: ldc_w 769
    //   450: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload_0
    //   455: iload 4
    //   457: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: ldc -48
    //   463: aload_0
    //   464: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 262	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 8
    //   472: invokevirtual 577	java/io/BufferedInputStream:close	()V
    //   475: iconst_0
    //   476: ireturn
    //   477: astore_0
    //   478: goto +57 -> 535
    //   481: astore 7
    //   483: aload 8
    //   485: astore_0
    //   486: aload 7
    //   488: astore 8
    //   490: goto +16 -> 506
    //   493: astore_0
    //   494: aload 7
    //   496: astore 8
    //   498: goto +37 -> 535
    //   501: astore 8
    //   503: aload 11
    //   505: astore_0
    //   506: aload_0
    //   507: astore 7
    //   509: aload 8
    //   511: invokevirtual 401	java/lang/Throwable:printStackTrace	()V
    //   514: aload_0
    //   515: astore 7
    //   517: ldc -48
    //   519: ldc_w 771
    //   522: invokestatic 262	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_0
    //   526: ifnull +7 -> 533
    //   529: aload_0
    //   530: invokevirtual 577	java/io/BufferedInputStream:close	()V
    //   533: iconst_0
    //   534: ireturn
    //   535: aload 8
    //   537: ifnull +8 -> 545
    //   540: aload 8
    //   542: invokevirtual 577	java/io/BufferedInputStream:close	()V
    //   545: aload_0
    //   546: athrow
    //   547: iconst_0
    //   548: ireturn
    //   549: astore 7
    //   551: goto -340 -> 211
    //   554: astore_0
    //   555: aload 9
    //   557: astore_0
    //   558: goto -157 -> 401
    //   561: astore_0
    //   562: goto -175 -> 387
    //   565: astore_0
    //   566: goto -144 -> 422
    //   569: astore_0
    //   570: goto -150 -> 420
    //   573: astore 7
    //   575: goto -139 -> 436
    //   578: astore_0
    //   579: iconst_0
    //   580: ireturn
    //   581: astore_0
    //   582: iconst_0
    //   583: ireturn
    //   584: astore 7
    //   586: goto -41 -> 545
    //   589: iload_3
    //   590: iload 4
    //   592: if_icmple -290 -> 302
    //   595: iload_2
    //   596: istore_1
    //   597: goto -222 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	paramContext	Context
    //   52	545	1	i1	int
    //   54	542	2	i2	int
    //   170	423	3	i3	int
    //   177	416	4	i4	int
    //   278	44	5	i5	int
    //   364	5	6	bool	boolean
    //   19	384	7	localObject1	Object
    //   481	14	7	localThrowable1	Throwable
    //   507	9	7	localContext	Context
    //   549	1	7	localException1	Exception
    //   573	1	7	localException2	Exception
    //   584	1	7	localException3	Exception
    //   121	376	8	localObject2	Object
    //   501	40	8	localThrowable2	Throwable
    //   79	477	9	localObject3	Object
    //   88	124	10	localObject4	Object
    //   85	419	11	str1	String
    //   157	9	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   238	280	383	finally
    //   315	324	383	finally
    //   331	366	383	finally
    //   215	238	393	finally
    //   404	412	393	finally
    //   123	179	477	finally
    //   194	206	477	finally
    //   438	470	477	finally
    //   123	179	481	java/lang/Throwable
    //   194	206	481	java/lang/Throwable
    //   438	470	481	java/lang/Throwable
    //   90	123	493	finally
    //   509	514	493	finally
    //   517	525	493	finally
    //   90	123	501	java/lang/Throwable
    //   206	211	549	java/lang/Exception
    //   215	238	554	java/lang/Throwable
    //   238	280	561	java/lang/Throwable
    //   315	324	561	java/lang/Throwable
    //   331	366	561	java/lang/Throwable
    //   375	380	565	java/lang/Exception
    //   416	420	569	java/lang/Exception
    //   431	436	573	java/lang/Exception
    //   470	475	578	java/lang/Exception
    //   529	533	581	java/lang/Exception
    //   540	545	584	java/lang/Exception
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = r;
    Class localClass = Integer.TYPE;
    boolean bool2 = false;
    paramContext = r.a(paramContext, "canUseVideoFeatrue", new Class[] { localClass }, new Object[] { Integer.valueOf(paramInt) });
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if ((paramContext instanceof Boolean)) {
        bool1 = ((Boolean)paramContext).booleanValue();
      }
    }
    return bool1;
  }
  
  public static void checkTbsValidity(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (!t.a(paramContext))
    {
      TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
      TbsCoreLoadStat.getInstance().a(paramContext, 419);
      forceSysWebView();
    }
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("clearAllWebViewCache(");
    ((StringBuilder)localObject1).append(paramContext);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(")");
    TbsLog.i("QbSdk", ((StringBuilder)localObject1).toString());
    int i1 = 0;
    try
    {
      localObject1 = new WebView(paramContext).getWebViewClientExtension();
      if (localObject1 == null) {
        break label147;
      }
      try
      {
        localObject1 = bt.a();
        if ((localObject1 != null) && (((bt)localObject1).b())) {
          ((bt)localObject1).c().a(paramContext, paramBoolean);
        }
        i1 = 1;
      }
      catch (Throwable localThrowable1)
      {
        i1 = 1;
      }
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      i1 = 0;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("clearAllWebViewCache exception 2 -- ");
    localStringBuilder.append(Log.getStackTraceString(localThrowable2));
    TbsLog.e("QbSdk", localStringBuilder.toString());
    label147:
    if (i1 != 0)
    {
      TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
      return;
    }
    try
    {
      localObject2 = new android.webkit.WebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((android.webkit.WebView)localObject2).removeJavascriptInterface("searchBoxJavaBridge_");
        ((android.webkit.WebView)localObject2).removeJavascriptInterface("accessibility");
        ((android.webkit.WebView)localObject2).removeJavascriptInterface("accessibilityTraversal");
      }
      ((android.webkit.WebView)localObject2).clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      return;
    }
    catch (Throwable paramContext)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("clearAllWebViewCache exception 1 -- ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void closeFileReader(Context paramContext)
  {
    bt localbt = bt.a();
    localbt.a(paramContext);
    if (localbt.b()) {
      localbt.c().p();
    }
  }
  
  public static void continueLoadSo(Context paramContext)
  {
    if (("com.tencent.mm".equals(getCurrentProcessName(paramContext))) && (WebView.mWebViewCreated)) {
      r.a(r, "continueLoadSo", new Class[0], new Object[0]);
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localbt.c().b();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      paramString1 = new StringBuilder();
      paramString1.append("qbsdk after createMiniQBShortCut ret: ");
      paramString1.append(paramContext);
      TbsLog.e("QbSdk", paramString1.toString());
      if (paramContext != null) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static void d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 124	com/tencent/smtt/sdk/QbSdk:B	Z
    //   4: iconst_0
    //   5: istore 5
    //   7: aconst_null
    //   8: astore 7
    //   10: aload 7
    //   12: astore 8
    //   14: getstatic 473	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 11
    //   19: if_icmplt +20 -> 39
    //   22: aload 7
    //   24: astore 8
    //   26: aload_0
    //   27: ldc_w 909
    //   30: iconst_4
    //   31: invokevirtual 656	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   34: astore 7
    //   36: goto +605 -> 641
    //   39: aload 7
    //   41: astore 8
    //   43: aload_0
    //   44: ldc_w 909
    //   47: iconst_0
    //   48: invokevirtual 656	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   51: astore 7
    //   53: goto +588 -> 641
    //   56: aload 7
    //   58: astore 8
    //   60: aload 7
    //   62: ldc_w 911
    //   65: iconst_m1
    //   66: invokeinterface 912 3 0
    //   71: istore_3
    //   72: iload_3
    //   73: iflt +18 -> 91
    //   76: iload_3
    //   77: iconst_1
    //   78: iadd
    //   79: istore_3
    //   80: iload_3
    //   81: iconst_4
    //   82: if_icmple +4 -> 86
    //   85: return
    //   86: iload_3
    //   87: istore_1
    //   88: goto +5 -> 93
    //   91: iconst_m1
    //   92: istore_1
    //   93: invokestatic 234	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   96: aload_0
    //   97: invokevirtual 385	com/tencent/smtt/sdk/am:j	(Landroid/content/Context;)I
    //   100: istore_2
    //   101: iload_2
    //   102: ifgt +4 -> 106
    //   105: return
    //   106: iload_3
    //   107: iconst_4
    //   108: if_icmpgt +28 -> 136
    //   111: aload 7
    //   113: invokeinterface 660 1 0
    //   118: ldc_w 911
    //   121: iload_3
    //   122: invokeinterface 916 3 0
    //   127: invokeinterface 668 1 0
    //   132: pop
    //   133: goto +3 -> 136
    //   136: aload 7
    //   138: ldc_w 918
    //   141: iconst_m1
    //   142: invokeinterface 912 3 0
    //   147: istore 6
    //   149: aload 7
    //   151: astore 8
    //   153: iload_1
    //   154: istore_3
    //   155: iload_2
    //   156: istore 4
    //   158: iload 6
    //   160: iflt +104 -> 264
    //   163: aload 7
    //   165: invokeinterface 660 1 0
    //   170: astore 8
    //   172: iload 6
    //   174: iconst_1
    //   175: iadd
    //   176: istore_3
    //   177: aload 8
    //   179: ldc_w 918
    //   182: iload_3
    //   183: invokeinterface 916 3 0
    //   188: invokeinterface 668 1 0
    //   193: pop
    //   194: goto +85 -> 279
    //   197: astore 8
    //   199: goto +15 -> 214
    //   202: astore 9
    //   204: iconst_m1
    //   205: istore_1
    //   206: aload 8
    //   208: astore 7
    //   210: aload 9
    //   212: astore 8
    //   214: iconst_m1
    //   215: istore_2
    //   216: new 192	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   223: astore 9
    //   225: aload 9
    //   227: ldc_w 920
    //   230: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 9
    //   236: aload 8
    //   238: invokestatic 287	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   241: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc -48
    //   247: aload 9
    //   249: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: iload_2
    //   256: istore 4
    //   258: iload_1
    //   259: istore_3
    //   260: aload 7
    //   262: astore 8
    //   264: iconst_m1
    //   265: istore 6
    //   267: iload 4
    //   269: istore_2
    //   270: iload_3
    //   271: istore_1
    //   272: iload 6
    //   274: istore_3
    //   275: aload 8
    //   277: astore 7
    //   279: iload_3
    //   280: iconst_3
    //   281: if_icmple +206 -> 487
    //   284: aload 7
    //   286: ldc_w 922
    //   289: iconst_m1
    //   290: invokeinterface 912 3 0
    //   295: istore_1
    //   296: aload 7
    //   298: invokeinterface 660 1 0
    //   303: astore 7
    //   305: iload_1
    //   306: iload_2
    //   307: if_icmpne +75 -> 382
    //   310: invokestatic 234	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   313: aload_0
    //   314: invokevirtual 237	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   317: iconst_0
    //   318: invokestatic 925	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   321: aload_0
    //   322: invokestatic 930	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   325: invokevirtual 932	com/tencent/smtt/sdk/ai:a	()Ljava/io/File;
    //   328: astore_0
    //   329: aload_0
    //   330: ifnull +8 -> 338
    //   333: aload_0
    //   334: iconst_0
    //   335: invokestatic 925	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   338: new 192	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   345: astore_0
    //   346: aload_0
    //   347: ldc_w 934
    //   350: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload_0
    //   355: iload_2
    //   356: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_0
    //   361: ldc_w 936
    //   364: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_0
    //   369: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: astore_0
    //   373: ldc -48
    //   375: aload_0
    //   376: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: goto +47 -> 426
    //   382: new 192	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   389: astore_0
    //   390: aload_0
    //   391: ldc_w 938
    //   394: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_0
    //   399: iload_2
    //   400: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_0
    //   405: ldc_w 940
    //   408: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_0
    //   413: iload_1
    //   414: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_0
    //   419: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore_0
    //   423: goto -50 -> 373
    //   426: aload 7
    //   428: ldc_w 942
    //   431: iload_1
    //   432: invokeinterface 916 3 0
    //   437: pop
    //   438: aload 7
    //   440: invokeinterface 668 1 0
    //   445: pop
    //   446: return
    //   447: astore_0
    //   448: new 192	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   455: astore 7
    //   457: aload 7
    //   459: ldc_w 944
    //   462: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 7
    //   468: aload_0
    //   469: invokestatic 287	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   472: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: ldc -48
    //   478: aload 7
    //   480: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: return
    //   487: iload_1
    //   488: ifle +37 -> 525
    //   491: iload_1
    //   492: iconst_3
    //   493: if_icmpgt +32 -> 525
    //   496: ldc -48
    //   498: ldc_w 946
    //   501: invokestatic 262	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: invokestatic 582	com/tencent/smtt/sdk/bt:a	()Lcom/tencent/smtt/sdk/bt;
    //   507: aload_0
    //   508: invokevirtual 869	com/tencent/smtt/sdk/bt:a	(Landroid/content/Context;)V
    //   511: ldc -48
    //   513: ldc_w 948
    //   516: invokestatic 262	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: iload 5
    //   521: istore_1
    //   522: goto +5 -> 527
    //   525: iconst_m1
    //   526: istore_1
    //   527: aload 7
    //   529: ldc_w 918
    //   532: iconst_m1
    //   533: invokeinterface 912 3 0
    //   538: istore_2
    //   539: iload_2
    //   540: ifle +69 -> 609
    //   543: aload 7
    //   545: invokeinterface 660 1 0
    //   550: ldc_w 918
    //   553: iload_2
    //   554: iconst_1
    //   555: isub
    //   556: invokeinterface 916 3 0
    //   561: invokeinterface 668 1 0
    //   566: pop
    //   567: goto +42 -> 609
    //   570: astore_0
    //   571: new 192	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   578: astore 7
    //   580: aload 7
    //   582: ldc_w 950
    //   585: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 7
    //   591: aload_0
    //   592: invokestatic 287	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   595: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: ldc -48
    //   601: aload 7
    //   603: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 213	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   609: new 192	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   616: astore_0
    //   617: aload_0
    //   618: ldc_w 952
    //   621: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload_0
    //   626: iload_1
    //   627: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: ldc -48
    //   633: aload_0
    //   634: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 262	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: return
    //   641: goto -585 -> 56
    //   644: astore 8
    //   646: goto -430 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	paramContext	Context
    //   87	540	1	i1	int
    //   100	456	2	i2	int
    //   71	211	3	i3	int
    //   156	112	4	i4	int
    //   5	515	5	i5	int
    //   147	126	6	i6	int
    //   8	594	7	localObject1	Object
    //   12	166	8	localObject2	Object
    //   197	10	8	localThrowable1	Throwable
    //   212	64	8	localObject3	Object
    //   644	1	8	localThrowable2	Throwable
    //   202	9	9	localThrowable3	Throwable
    //   223	25	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   93	101	197	java/lang/Throwable
    //   14	22	202	java/lang/Throwable
    //   26	36	202	java/lang/Throwable
    //   43	53	202	java/lang/Throwable
    //   60	72	202	java/lang/Throwable
    //   284	305	447	java/lang/Throwable
    //   310	329	447	java/lang/Throwable
    //   333	338	447	java/lang/Throwable
    //   338	373	447	java/lang/Throwable
    //   373	379	447	java/lang/Throwable
    //   382	423	447	java/lang/Throwable
    //   426	446	447	java/lang/Throwable
    //   527	539	570	java/lang/Throwable
    //   543	567	570	java/lang/Throwable
    //   111	133	644	java/lang/Throwable
    //   136	149	644	java/lang/Throwable
    //   163	172	644	java/lang/Throwable
    //   177	194	644	java/lang/Throwable
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      if (localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static void disAllowThirdAppDownload()
  {
    c = false;
  }
  
  public static void disableAutoCreateX5Webview()
  {
    j = false;
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      try
      {
        localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
        return;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void forceSysWebView()
  {
    b = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SysWebViewForcedByOuter: ");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    u = localStringBuilder.toString();
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l1 = 0L;
    if (paramContext != null) {
      l1 = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l1;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    int i1 = Process.myPid();
    Object localObject = "";
    Iterator localIterator = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    paramContext = (Context)localObject;
    while (localIterator.hasNext())
    {
      localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i1) {
        paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
      }
    }
    return paramContext;
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    boolean bool = t instanceof String[];
    int i1 = 0;
    if (bool)
    {
      int i2 = t.length;
      paramContext1 = new String[i2];
      while (i1 < i2)
      {
        paramContext2 = new StringBuilder();
        paramContext2.append(paramString);
        paramContext2.append(t[i1]);
        paramContext1[i1] = paramContext2.toString();
        i1 += 1;
      }
      return paramContext1;
    }
    paramContext1 = r.a(r, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if (!(paramContext1 instanceof String[])) {
      paramContext1 = new String[] { "" };
    }
    return (String[])paramContext1;
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return E;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return b;
  }
  
  public static boolean getJarFilesAndLibraryPath(Context paramContext)
  {
    if (r == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
      return false;
    }
    Object localObject = (Bundle)r.a(r, "canLoadX5CoreAndNotLoadSo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43612) });
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getJarFilesAndLibraryPath bundle is null and coreverison is ");
      ((StringBuilder)localObject).append(am.a().a(true, paramContext));
      TbsLog.i("QbSdk", ((StringBuilder)localObject).toString());
      return false;
    }
    t = ((Bundle)localObject).getStringArray("tbs_jarfiles");
    d = ((Bundle)localObject).getString("tbs_librarypath");
    return true;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    bt localbt = bt.a();
    localbt.a(paramContext);
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().f();
    }
    return null;
  }
  
  public static boolean getOnlyDownload()
  {
    return k;
  }
  
  public static String getQQBuildNumber()
  {
    return z;
  }
  
  public static Map<String, Object> getSettings()
  {
    return n;
  }
  
  public static boolean getTBSInstalling()
  {
    return F;
  }
  
  public static String getTID()
  {
    return y;
  }
  
  public static String getTbsResourcesPath(Context paramContext)
  {
    return TbsShareManager.g(paramContext);
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.a(paramContext, false);
    }
    int i1 = am.a().j(paramContext);
    if ((i1 == 0) && (ai.a(paramContext).c() == 3)) {
      reset(paramContext);
    }
    return i1;
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.a(paramContext, false);
    }
    int i1 = am.a().k(paramContext);
    if ((i1 == 0) && (ai.a(paramContext).c() == 3)) {
      reset(paramContext);
    }
    return i1;
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public static void initForinitAndNotLoadSo(Context paramContext)
  {
    if (q == null)
    {
      Object localObject = am.a().r(paramContext);
      if (localObject == null) {}
      File localFile;
      for (paramContext = "QbSdk initForinitAndNotLoadSo optDir == null";; paramContext = "QbSdk initForinitAndNotLoadSo dexFile.exists()=false")
      {
        Log.e("QbSdk", paramContext);
        return;
        localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
        if (localFile.exists()) {
          break;
        }
      }
      localObject = ((File)localObject).getAbsolutePath();
      q = new DexLoader(localFile.getParent(), paramContext, new String[] { localFile.getAbsolutePath() }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
    }
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (n == null)
    {
      n = paramMap;
      return;
    }
    try
    {
      n.putAll(paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static void initX5Environment(Context paramContext, PreInitCallback paramPreInitCallback)
  {
    if (paramContext == null) {
      return;
    }
    b(paramContext);
    D = new l(paramContext, paramPreInitCallback);
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      am.a().c(paramContext, true);
    }
    TbsDownloader.needDownload(paramContext, false, false, new m(paramContext, paramPreInitCallback));
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    o localo = o.a(true);
    localo.b(paramContext, false, false);
    if ((localo != null) && (localo.c())) {
      return localo.b().a(paramContext, paramString1, paramString2, paramBundle);
    }
    return false;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    String str = paramString1;
    Intent localIntent;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      Context localContext = paramWebView.getContext();
      int i1 = paramString1.indexOf("url=");
      if (i1 > 0) {
        paramIntent = paramString1.substring(i1 + 4);
      } else {
        paramIntent = null;
      }
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent)) {
        paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";
      } else {
        paramString1 = paramIntent;
      }
      if (d.a(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) == 0) {
        break label191;
      }
      paramString1 = bt.a();
      localIntent = paramIntent;
      if (paramString1 != null)
      {
        localIntent = paramIntent;
        if (paramString1.b())
        {
          localIntent = paramIntent;
          if (paramString1.c().a(localContext, paramIntent, null, paramString2, null) == 0) {
            return true;
          }
        }
      }
    }
    paramWebView.loadUrl(localIntent);
    label191:
    return false;
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = bt.a();
    if ((paramString2 != null) && (paramString2.b()))
    {
      paramString1 = paramString2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramString1 != null)
      {
        paramContext = Boolean.valueOf(false);
        if ((paramString1 instanceof Boolean)) {
          paramContext = (Boolean)paramString1;
        }
        return paramContext.booleanValue();
      }
    }
    return false;
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    o localo = o.a(false);
    boolean bool1 = bool2;
    if (localo != null)
    {
      bool1 = bool2;
      if (localo.h()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (ai.a(paramContext).c() == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return false;
    }
    if (!c(paramContext)) {
      return true;
    }
    int i1 = am.a().j(paramContext);
    paramContext = r.a(r, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i1), Integer.valueOf(43612) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    if (r != null) {
      return;
    }
    if (q == null) {
      TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
    }
    try
    {
      localObject1 = q.getConstructor(new Class[] { Context.class, Context.class, String.class, String.class, String.class });
      i1 = 1;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        int i1;
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label261;
        }
        localObject3 = TbsShareManager.e(paramContext);
        if ((localObject3 != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) {
          break label107;
        }
        TbsLogReport.a(paramContext.getApplicationContext()).b(227, "host context is null!");
        return;
        label107:
        if (i1 != 0) {
          break label215;
        }
        if (localObject3 != null) {
          break label175;
        }
        paramString = q.getConstructor(new Class[] { Context.class, Context.class, String.class });
        Object localObject1 = new Object[3];
        localObject1[0] = paramContext;
        localObject1[1] = localObject3;
        localObject1[2] = TbsShareManager.getHostCorePathAppDefined();
        for (paramContext = (Context)localObject1;; paramContext = (Context)localObject1)
        {
          paramContext = paramString.newInstance(paramContext);
          label170:
          r = paramContext;
          return;
          label175:
          paramString = q.getConstructor(new Class[] { Context.class, Context.class });
          localObject1 = new Object[2];
          localObject1[0] = paramContext;
          localObject1[1] = localObject3;
        }
        label215:
        localObject2 = new Object[5];
        localObject2[0] = paramContext;
        localObject2[1] = localObject3;
        localObject2[2] = TbsShareManager.getHostCorePathAppDefined();
        localObject2[3] = paramString;
        localObject2[4] = null;
        for (paramContext = (Context)localObject2;; paramContext = (Context)localObject3)
        {
          paramContext = ((Constructor)localObject1).newInstance(paramContext);
          break label170;
          label261:
          if (i1 == 0)
          {
            paramString = q.getConstructor(new Class[] { Context.class, Context.class });
            localObject1 = new Object[2];
            localObject1[0] = paramContext;
            localObject1[1] = paramContext;
            paramContext = (Context)localObject1;
            break;
          }
          if ((!"com.tencent.mm".equals(getCurrentProcessName(paramContext))) || (WebView.mWebViewCreated)) {
            break label375;
          }
          localObject2 = "notLoadSo";
          localObject3 = new Object[5];
          localObject3[0] = paramContext;
          localObject3[1] = paramContext;
          localObject3[2] = null;
          localObject3[3] = paramString;
          localObject3[4] = localObject2;
        }
        localThrowable = localThrowable;
      }
      catch (Throwable paramContext)
      {
        return;
      }
    }
    localObject1 = null;
    i1 = 0;
    for (;;)
    {
      Object localObject3;
      label375:
      Object localObject2 = null;
    }
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(Context paramContext, PreInitCallback paramPreInitCallback)
  {
    try
    {
      TbsLog.initIfNeed(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preInit -- processName: ");
      localStringBuilder.append(getCurrentProcessName(paramContext));
      TbsLog.i("QbSdk", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("preInit -- stack: ");
      localStringBuilder.append(Log.getStackTraceString(new Throwable("#")));
      TbsLog.i("QbSdk", localStringBuilder.toString());
      l = a;
      if (!s)
      {
        paramContext = new k(paramContext, new j(Looper.getMainLooper(), paramPreInitCallback, paramContext));
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        s = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void reset(Context paramContext)
  {
    reset(paramContext, false);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((!paramBoolean) || (TbsShareManager.isThirdPartyApp(paramContext))) {
          break label194;
        }
        i1 = am.a().i(paramContext);
        int i2 = am.a().j(paramContext);
        if ((i1 <= 43300) || (i1 == i2)) {
          break label194;
        }
        i1 = 1;
        TbsDownloader.b(paramContext);
        com.tencent.smtt.utils.k.a(paramContext.getDir("tbs", 0), false, "core_share_decouple");
        TbsLog.i("QbSdk", "delete downloaded apk success", true);
        am.a.set(Integer.valueOf(0));
        localObject = new File(paramContext.getFilesDir(), "bugly_switch.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (i1 != 0)
        {
          com.tencent.smtt.utils.k.b(am.a().q(paramContext), am.a().u(paramContext));
          am.a().b(paramContext);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QbSdk reset exception:");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramContext));
        TbsLog.e("QbSdk", ((StringBuilder)localObject).toString());
      }
      return;
      label194:
      int i1 = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      com.tencent.smtt.utils.k.b(am.a().q(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbSdk resetDecoupleCore exception:");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", localStringBuilder.toString());
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.startsWith("QQ:"))
    {
      paramString = paramString.substring("QQ:".length());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0000000000000000".substring(paramString.length()));
      localStringBuilder.append(paramString);
      y = localStringBuilder.toString();
    }
  }
  
  public static void setDisableUnpreinitBySwitch(boolean paramBoolean)
  {
    A = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is ");
    localStringBuilder.append(A);
    TbsLog.i("QbSdk", localStringBuilder.toString());
  }
  
  public static void setDisableUseHostBackupCoreBySwitch(boolean paramBoolean)
  {
    mDisableUseHostBackupCore = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is ");
    localStringBuilder.append(mDisableUseHostBackupCore);
    TbsLog.i("QbSdk", localStringBuilder.toString());
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    E = paramBoolean;
  }
  
  public static void setOnlyDownload(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    z = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    C = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().a(paramContext, 501);
    if (paramContext == null) {
      return -100;
    }
    bt localbt = bt.a();
    localbt.a(paramContext);
    if (localbt.b())
    {
      if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
        return -101;
      }
      int i1 = localbt.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
      if (i1 == 0)
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 503);
      }
      else
      {
        paramContext = TbsLogReport.a(paramContext);
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(i1);
        paramContext.b(504, paramString.toString());
      }
      paramContext = new StringBuilder();
      paramContext.append("startMiniQBToLoadUrl  ret = ");
      paramContext.append(i1);
      Log.e("QbSdk", paramContext.toString());
      return i1;
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 502);
    Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return d.a(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return d.a(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    boolean bool = false;
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = bt.a();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((bt)localObject).b())
          {
            localObject = ((bt)localObject).c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    if (d.a(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return false;
    }
    bt localbt = bt.a();
    localbt.a(paramContext);
    if ((paramHashMap != null) && ("5".equals(paramHashMap.get("PosID"))) && (localbt.b())) {
      Bundle localBundle = (Bundle)localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
    }
    if (d.a(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
    {
      if (localbt.b())
      {
        if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
          return false;
        }
        if (localbt.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public static void unForceSysWebView()
  {
    b = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean unPreInit(Context paramContext)
  {
    try
    {
      TbsLog.i("QbSdk", "unPreInit -- begin");
      if (("com.tencent.mm".equals(getCurrentProcessName(paramContext))) && (!A) && (!WebView.mWebViewCreated) && ((b(paramContext, "core_unzip_tmp") == 1) || (b(paramContext, "core_copy_tmp") == 1)))
      {
        TbsLog.i("QbSdk", "unPreInit -- do");
        q = null;
        r = null;
        o.a(true).a();
        am.a().g(paramContext);
        bt.a().c(paramContext);
        s = false;
        TbsLog.i("QbSdk", "unPreInit -- return true");
        return true;
      }
      TbsLog.i("QbSdk", "unPreInit -- return false");
      return false;
    }
    finally {}
  }
  
  public static boolean useSoftWare()
  {
    if (r == null) {
      return false;
    }
    Object localObject2 = r.a(r, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = r;
      localObject2 = Integer.TYPE;
      int i1 = a.a();
      localObject1 = r.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i1) });
    }
    if (localObject1 == null) {
      return false;
    }
    return ((Boolean)localObject1).booleanValue();
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void onCoreInitFinished();
    
    public abstract void onViewInitFinished(boolean paramBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\QbSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */