package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.v;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  public static boolean DOWNLOAD_OVERSEA_TBS = false;
  public static final String LOGTAG = "TbsDownload";
  static boolean a;
  private static String b;
  private static Context c;
  private static Handler d;
  private static String e;
  private static Object f = new byte[0];
  private static ag g;
  private static HandlerThread h;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static long l = -1L;
  
  protected static File a(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int n = arrayOfString.length;
    Object localObject1 = null;
    int m = 0;
    while (m < n)
    {
      Object localObject2 = arrayOfString[m];
      if (!((String)localObject2).equals(c.getApplicationInfo().packageName))
      {
        localObject2 = k.a(c, (String)localObject2, 4, false);
        if (getOverSea(c)) {
          localObject1 = "x5.oversea.tbs.org";
        } else {
          localObject1 = "x5.tbs.org";
        }
        localObject2 = new File((String)localObject2, (String)localObject1);
        if (((File)localObject2).exists())
        {
          if (a.a(c, (File)localObject2) == paramInt)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("local tbs version fond,path = ");
            ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
            TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
            return (File)localObject2;
          }
          localObject1 = "version is not match";
        }
        else
        {
          localObject1 = "can not find local backup core file";
        }
        TbsLog.i("TbsDownload", (String)localObject1);
        localObject1 = localObject2;
      }
      m += 1;
    }
    return (File)localObject1;
  }
  
  static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    Locale localLocale = Locale.getDefault();
    StringBuffer localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      String str;
      label73:
      for (;;) {}
    }
    if (paramContext == null) {
      paramContext = "1.0";
    }
    for (;;)
    {
      localStringBuffer.append(paramContext);
      break label73;
      if (paramContext.length() <= 0) {
        break;
      }
    }
    localStringBuffer.append("; ");
    paramContext = localLocale.getLanguage();
    if (paramContext != null)
    {
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext == null) {
        break label131;
      }
      localStringBuffer.append("-");
      paramContext = paramContext.toLowerCase();
    }
    else
    {
      paramContext = "en";
    }
    localStringBuffer.append(paramContext);
    label131:
    if ("REL".equals(Build.VERSION.CODENAME)) {
      paramContext = Build.MODEL;
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    if (paramContext == null) {
      paramContext = "; ";
    }
    for (;;)
    {
      localStringBuffer.append(paramContext);
      break;
      if (paramContext.length() <= 0) {
        break;
      }
      localStringBuffer.append("; ");
    }
    if (Build.ID == null) {
      paramContext = "";
    } else {
      paramContext = Build.ID;
    }
    paramContext = paramContext.replaceAll("[一-龥]", "");
    if (paramContext == null)
    {
      localStringBuffer.append(" Build/");
      paramContext = "00";
    }
    for (;;)
    {
      localStringBuffer.append(paramContext);
      break;
      if (paramContext.length() <= 0) {
        break;
      }
      localStringBuffer.append(" Build/");
    }
    paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
    b = paramContext;
    return paramContext;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static void a(boolean paramBoolean, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    int m;
    if (Build.VERSION.SDK_INT < 8) {
      m = -102;
    }
    for (;;)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(m);
      return false;
      if ((!QbSdk.c) && (TbsShareManager.isThirdPartyApp(c)) && (!c()))
      {
        if (paramTbsDownloaderCallback != null) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        return false;
      }
      if (!localTbsDownloadConfig.mPreferences.contains("is_oversea"))
      {
        boolean bool = paramBoolean;
        if (paramBoolean)
        {
          bool = paramBoolean;
          if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
          {
            TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
            bool = false;
          }
        }
        localTbsDownloadConfig.a.put("is_oversea", Boolean.valueOf(bool));
        localTbsDownloadConfig.commit();
        j = bool;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needDownload-first-called--isoversea = ");
        localStringBuilder.append(bool);
        TbsLog.i("TbsDownload", localStringBuilder.toString());
      }
      if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
      {
        paramContext = new StringBuilder();
        paramContext.append("needDownload- return false,  because of  version is ");
        paramContext.append(Build.VERSION.SDK_INT);
        paramContext.append(", and overea");
        TbsLog.i("TbsDownload", paramContext.toString());
        if (paramTbsDownloaderCallback != null) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        m = -103;
      }
      else
      {
        e = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
        if (TextUtils.isEmpty(e)) {
          break;
        }
      }
      try
      {
        paramContext = Pattern.compile("i686|mips|x86_64").matcher(e);
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
      paramContext = null;
      if ((paramContext == null) || (!paramContext.find())) {
        break;
      }
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      m = -104;
    }
    return true;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = TbsDownloadConfig.getInstance(paramContext);
    Object localObject1;
    if (!paramBoolean1)
    {
      paramContext = ((TbsDownloadConfig)localObject2).mPreferences.getString("app_versionname", null);
      int m = ((TbsDownloadConfig)localObject2).mPreferences.getInt("app_versioncode", 0);
      localObject1 = ((TbsDownloadConfig)localObject2).mPreferences.getString("app_metadata", null);
      String str1 = b.a(c);
      int n = b.b(c);
      String str2 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.needSendQueryRequest] appVersionName=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" oldAppVersionName=");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(" appVersionCode=");
      localStringBuilder.append(n);
      localStringBuilder.append(" oldAppVersionCode=");
      localStringBuilder.append(m);
      localStringBuilder.append(" appMetadata=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" oldAppVersionMetadata=");
      localStringBuilder.append((String)localObject1);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      long l2 = System.currentTimeMillis();
      long l3 = ((TbsDownloadConfig)localObject2).mPreferences.getLong("last_check", 0L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
      localStringBuilder.append(l3);
      localStringBuilder.append(" timeNow=");
      localStringBuilder.append(l2);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      if (paramBoolean2)
      {
        paramBoolean1 = ((TbsDownloadConfig)localObject2).mPreferences.contains("last_check");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=");
        localStringBuilder.append(paramBoolean1);
        TbsLog.i("TbsDownload", localStringBuilder.toString());
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
        else
        {
          l1 = l3;
        }
      }
      else
      {
        l1 = l3;
      }
      l3 = ((TbsDownloadConfig)localObject2).mPreferences.getLong("last_request_success", 0L);
      long l4 = ((TbsDownloadConfig)localObject2).mPreferences.getLong("count_request_fail_in_24hours", 0L);
      long l5 = ((TbsDownloadConfig)localObject2).getRetryInterval();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("retryInterval = ");
      ((StringBuilder)localObject2).append(l5);
      ((StringBuilder)localObject2).append(" s");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      long l1 = l2 - l1;
      l5 *= 1000L;
      if (l1 > l5) {}
      for (;;)
      {
        paramContext = null;
        paramBoolean1 = true;
        break label781;
        if ((!TbsShareManager.isThirdPartyApp(c)) || (l3 <= 0L) || (l2 - l3 <= l5) || (l4 >= 11L)) {
          if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!e()))
          {
            am.a().d(c);
          }
          else
          {
            if ((str1 == null) || (n == 0) || (str2 == null)) {
              break;
            }
            if ((str1.equals(paramContext)) && (n == m)) {
              if (str2.equals(localObject1)) {
                break label777;
              }
            }
          }
        }
      }
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("timeNow - timeLastCheck is ");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" TbsShareManager.findCoreForThirdPartyApp(sAppContext) is ");
        ((StringBuilder)localObject2).append(TbsShareManager.findCoreForThirdPartyApp(c));
        ((StringBuilder)localObject2).append(" sendRequestWithSameHostCoreVersion() is ");
        ((StringBuilder)localObject2).append(e());
        ((StringBuilder)localObject2).append(" appVersionName is ");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" appVersionCode is ");
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append(" appMetadata is ");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(" oldAppVersionName is ");
        ((StringBuilder)localObject2).append(paramContext);
        ((StringBuilder)localObject2).append(" oldAppVersionCode is ");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" oldAppVersionMetadata is ");
        ((StringBuilder)localObject2).append((String)localObject1);
        paramContext = ((StringBuilder)localObject2).toString();
      }
      else
      {
        label777:
        paramContext = null;
      }
      paramBoolean1 = false;
    }
    else
    {
      label781:
      paramContext = null;
      paramBoolean1 = true;
    }
    if ((!paramBoolean1) && (TbsShareManager.isThirdPartyApp(c)))
    {
      localObject1 = TbsLogReport.a(c).a();
      ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-119);
      ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail(paramContext);
      TbsLogReport.a(c).a(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
    }
    return paramBoolean1;
  }
  
  @TargetApi(11)
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[TbsDownloader.readResponse] response=");
    ((StringBuilder)localObject1).append(paramString);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramBoolean1) {}
      for (paramInt = -108;; paramInt = 65328)
      {
        localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
        break;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] return #1,response is empty...");
      return false;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    int m = localJSONObject.getInt("RET");
    if (m != 0)
    {
      if (paramBoolean1) {}
      for (paramInt = -109;; paramInt = 65327)
      {
        localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
        break;
      }
      paramString = new StringBuilder();
      paramString.append("[TbsDownloader.readResponse] return #2,returnCode=");
      paramString.append(m);
      TbsLog.i("TbsDownload", paramString.toString());
      return false;
    }
    int i5 = localJSONObject.getInt("RESPONSECODE");
    String str2 = localJSONObject.getString("DOWNLOADURL");
    String str3 = localJSONObject.optString("URLLIST", "");
    int i4 = localJSONObject.getInt("TBSAPKSERVERVERSION");
    int i6 = localJSONObject.getInt("DOWNLOADMAXFLOW");
    int i7 = localJSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
    int i8 = localJSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
    int i9 = localJSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
    long l3 = localJSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
    long l4 = localJSONObject.getLong("TBSAPKFILESIZE");
    long l2 = localJSONObject.optLong("RETRY_INTERVAL", 0L);
    int i10 = localJSONObject.optInt("FLOWCTR", -1);
    try
    {
      m = localJSONObject.getInt("USEBBACKUPVER");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        continue;
        boolean bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
      }
    }
    m = 0;
    localTbsDownloadConfig.a.put("use_backup_version", Integer.valueOf(m));
    if ((paramBoolean1) && (QbSdk.i) && (TbsShareManager.isThirdPartyApp(c)))
    {
      try
      {
        m = localJSONObject.optInt("BUGLY", 0);
        paramString = TbsExtensionFunctionManager.getInstance();
        localObject1 = c;
        if (m == 1) {
          bool = true;
        } else {
          bool = false;
        }
        try
        {
          paramString.setFunctionEnable((Context)localObject1, "bugly_switch.txt", bool);
        }
        catch (Throwable paramString) {}
        localObject1 = new StringBuilder();
      }
      catch (Throwable paramString) {}
      ((StringBuilder)localObject1).append("throwable:");
      ((StringBuilder)localObject1).append(paramString.toString());
      TbsLog.i("qbsdk", ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean1) {
      try
      {
        m = localJSONObject.optInt("TEMPLATESWITCH", 0);
        if ((m & 0x1) == 0) {
          break label3179;
        }
        bool = true;
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "cookie_switch.txt", bool);
        paramString = new StringBuilder();
        paramString.append("useCookieCompatiable:");
        paramString.append(bool);
        TbsLog.w("TbsDownload", paramString.toString());
        if ((m & 0x2) == 0) {
          break label3185;
        }
        bool = true;
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "disable_get_apk_version_switch.txt", bool);
        paramString = new StringBuilder();
        paramString.append("disableGetApkVersionByReadFile:");
        paramString.append(bool);
        TbsLog.w("TbsDownload", paramString.toString());
        if ((m & 0x4) == 0) {
          break label3191;
        }
        bool = true;
        QbSdk.setDisableUnpreinitBySwitch(bool);
        paramString = new StringBuilder();
        paramString.append("disableUnpreinitBySwitch:");
        paramString.append(bool);
        TbsLog.i("TbsDownload", paramString.toString());
        if ((m & 0x8) == 0) {
          break label3197;
        }
        bool = true;
        QbSdk.setDisableUseHostBackupCoreBySwitch(bool);
        paramString = new StringBuilder();
        paramString.append("disableUseHostBackupCoreBySwitch:");
        paramString.append(bool);
        TbsLog.i("TbsDownload", paramString.toString());
      }
      catch (Throwable paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("throwable:");
        ((StringBuilder)localObject1).append(paramString.toString());
        TbsLog.i("qbsdk", ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        paramString = localJSONObject.getString("PKGMD5");
      }
      catch (Exception paramString)
      {
        int n;
        int i1;
        continue;
      }
      try
      {
        n = localJSONObject.getInt("RESETX5");
      }
      catch (Exception localException1)
      {
        continue;
      }
      try
      {
        i1 = localJSONObject.getInt("UPLOADLOG");
      }
      catch (Exception localException2)
      {
        continue;
      }
      try
      {
        bool = localJSONObject.has("RESETTOKEN");
        if (!bool) {}
      }
      catch (Exception localException3)
      {
        continue;
      }
      try
      {
        m = localJSONObject.getInt("RESETTOKEN");
        if (m != 0) {
          m = 1;
        } else {
          m = 0;
        }
      }
      catch (Exception localException4) {}
    }
    break label878;
    m = 0;
    for (;;)
    {
      try
      {
        if (localJSONObject.has("SETTOKEN")) {
          localObject1 = localJSONObject.getString("SETTOKEN");
        } else {
          localObject1 = "";
        }
      }
      catch (Exception localException5)
      {
        int i2;
        Object localObject2;
        int i3;
        continue;
      }
      try
      {
        if (localJSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK"))
        {
          i2 = localJSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK");
          if (i2 == 0)
          {
            bool = false;
            continue;
          }
        }
        bool = true;
      }
      catch (Exception localException8)
      {
        str1 = paramString;
        paramString = localException5;
      }
    }
    localObject1 = "";
    localObject2 = paramString;
    paramString = (String)localObject1;
    break label920;
    label878:
    localObject1 = "";
    m = 0;
    localObject2 = paramString;
    paramString = (String)localObject1;
    break label920;
    localObject2 = paramString;
    break label911;
    break label905;
    paramString = null;
    label905:
    n = 0;
    localObject2 = paramString;
    label911:
    paramString = "";
    m = 0;
    i1 = 0;
    label920:
    localObject1 = paramString;
    bool = true;
    paramString = (String)localObject2;
    try
    {
      i3 = localJSONObject.getInt("RESETDECOUPLECORE");
    }
    catch (Exception localException9)
    {
      for (;;) {}
    }
    i3 = 0;
    try
    {
      i2 = localJSONObject.getInt("RESETTODECOUPLECORE");
    }
    catch (Exception localException10)
    {
      label3067:
      for (;;) {}
    }
    i2 = 0;
    localObject2 = f;
    if (m != 0)
    {
      for (;;)
      {
        try
        {
          localTbsDownloadConfig.a.put("tbs_deskey_token", "");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() == 96))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("&");
            localStringBuilder.append(o.c());
            localObject1 = localStringBuilder.toString();
            localTbsDownloadConfig.a.put("tbs_deskey_token", localObject1);
          }
          if (n == 1)
          {
            if (paramBoolean1)
            {
              paramInt = -110;
              localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
            }
            else
            {
              paramInt = 65326;
              continue;
            }
            paramString = c;
            if (i2 == 1) {
              paramBoolean2 = true;
            } else {
              paramBoolean2 = false;
            }
            QbSdk.reset(paramString, paramBoolean2);
            paramString = new StringBuilder();
            paramString.append("[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=");
            paramString.append(paramBoolean1);
            paramString = paramString.toString();
            TbsLog.i("TbsDownload", paramString);
            return false;
          }
          if (!bool) {
            localTbsDownloadConfig.setTbsCoreLoadRenameFileLockEnable(bool);
          }
          if (i3 == 1) {
            QbSdk.resetDecoupleCore(c);
          }
          if (i1 == 1)
          {
            d.removeMessages(104);
            Message.obtain(d, 104).sendToTarget();
          }
          long l1;
          if (i10 == 1)
          {
            l1 = l2;
            if (l2 > 604800L) {
              l1 = 604800L;
            }
            if (l1 > 0L) {}
          }
          else
          {
            l1 = 86400L;
          }
          if (getRetryIntervalInSeconds() >= 0L) {
            l1 = getRetryIntervalInSeconds();
          }
          localTbsDownloadConfig.a.put("retry_interval", Long.valueOf(l1));
          if (!paramBoolean1) {}
        }
        finally
        {
          continue;
        }
        try
        {
          m = localJSONObject.getInt("DECOUPLECOREVERSION");
        }
        catch (Exception localException6)
        {
          continue;
        }
        m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
        break label3210;
        m = 0;
        try
        {
          n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0);
        }
        catch (Exception localException7)
        {
          continue;
        }
        n = 0;
        i1 = m;
        if (paramBoolean1)
        {
          i1 = m;
          if (!TbsShareManager.isThirdPartyApp(c))
          {
            i1 = m;
            if (m == 0) {
              i1 = am.a().i(c);
            }
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("in response decoupleCoreVersion is ");
        ((StringBuilder)localObject1).append(i1);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        localTbsDownloadConfig.a.put("tbs_decouplecoreversion", Integer.valueOf(i1));
        localTbsDownloadConfig.a.put("tbs_downloaddecouplecore", Integer.valueOf(n));
        if (!TbsShareManager.isThirdPartyApp(c)) {
          if ((i1 > 0) && (i1 != am.a().i(c)) && (i1 == am.a().j(c))) {
            am.a().o(c);
          } else if (i1 != 0) {}
        }
        try
        {
          k.b(am.a().q(c));
        }
        catch (Throwable localThrowable)
        {
          String str1;
          continue;
        }
        if ((TextUtils.isEmpty(str2)) && (TbsShareManager.isThirdPartyApp(c)))
        {
          localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
          localTbsDownloadConfig.commit();
          if (paramBoolean1) {
            TbsShareManager.writeCoreInfoForThirdPartyApp(c, i4, false);
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] return #4,current app is third app...");
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("in response responseCode is ");
        ((StringBuilder)localObject1).append(i5);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        if (i5 == 0)
        {
          localTbsDownloadConfig.a.put("tbs_responsecode", Integer.valueOf(i5));
          localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
          if (paramBoolean1)
          {
            localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
          }
          else
          {
            localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65325));
            localTbsDownloadConfig.setDownloadInterruptCode(65325);
          }
          localTbsDownloadConfig.commit();
          if (!TbsShareManager.isThirdPartyApp(c)) {
            startDecoupleCoreIfNeeded();
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] return #5,responseCode=0");
          return false;
        }
        i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        if (i1 > i4)
        {
          g.d();
          am.a().p(c);
        }
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          i2 = am.a().h(c);
          if (i2 >= i4) {
            m = 1;
          } else {
            m = 0;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("tmpCoreVersion is ");
          ((StringBuilder)localObject1).append(i2);
          ((StringBuilder)localObject1).append(" tbsDownloadVersion is");
          ((StringBuilder)localObject1).append(i4);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        }
        else
        {
          m = 0;
        }
        if (((paramInt < i4) && (!TextUtils.isEmpty(str2)) && (m == 0)) || (n == 1)) {
          continue;
        }
        localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
        if (paramBoolean1)
        {
          if (TextUtils.isEmpty(str2))
          {
            paramString = localTbsDownloadConfig.a;
            m = -124;
            paramString.put("tbs_download_interrupt_code_reason", Integer.valueOf(m));
          }
          else
          {
            if (i4 <= 0)
            {
              paramString = localTbsDownloadConfig.a;
              m = -125;
              continue;
            }
            if (paramInt >= i4)
            {
              paramString = localTbsDownloadConfig.a;
              m = -127;
              continue;
            }
            paramString = localTbsDownloadConfig.a;
            m = -112;
            continue;
          }
        }
        else
        {
          m = 65324;
          if (TextUtils.isEmpty(str2)) {
            m = 65319;
          } else if (i4 <= 0) {
            m = 65318;
          } else if (paramInt >= i4) {
            m = 65317;
          }
          localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(m));
          localTbsDownloadConfig.setDownloadInterruptCode(m);
        }
        localTbsDownloadConfig.commit();
        paramString = new StringBuilder();
        paramString.append("version error or downloadUrl empty ,return ahead tbsLocalVersion=");
        paramString.append(paramInt);
        paramString.append(" tbsDownloadVersion=");
        paramString.append(i4);
        paramString.append(" tbsLastDownloadVersion=");
        paramString.append(i1);
        paramString.append(" downloadUrl=");
        paramString.append(str2);
        paramString = paramString.toString();
      }
      if (!str2.equals(localTbsDownloadConfig.mPreferences.getString("tbs_downloadurl", null)))
      {
        g.d();
        localTbsDownloadConfig.a.put("tbs_download_failed_retrytimes", Integer.valueOf(0));
        localTbsDownloadConfig.a.put("tbs_download_success_retrytimes", Integer.valueOf(0));
      }
      localTbsDownloadConfig.a.put("tbs_download_version", Integer.valueOf(i4));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("put KEY_TBS_DOWNLOAD_V is ");
      ((StringBuilder)localObject1).append(i4);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      if (i4 > 0)
      {
        if (n == 1) {
          localTbsDownloadConfig.a.put("tbs_download_version_type", Integer.valueOf(1));
        } else {
          localTbsDownloadConfig.a.put("tbs_download_version_type", Integer.valueOf(0));
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("put KEY_TBS_DOWNLOAD_V_TYPE is ");
        ((StringBuilder)localObject1).append(n);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      }
      localTbsDownloadConfig.a.put("tbs_downloadurl", str2);
      localTbsDownloadConfig.a.put("tbs_downloadurl_list", str3);
      localTbsDownloadConfig.a.put("tbs_responsecode", Integer.valueOf(i5));
      localTbsDownloadConfig.a.put("tbs_download_maxflow", Integer.valueOf(i6));
      localTbsDownloadConfig.a.put("tbs_download_min_free_space", Integer.valueOf(i7));
      localTbsDownloadConfig.a.put("tbs_download_success_max_retrytimes", Integer.valueOf(i8));
      localTbsDownloadConfig.a.put("tbs_download_failed_max_retrytimes", Integer.valueOf(i9));
      localTbsDownloadConfig.a.put("tbs_single_timeout", Long.valueOf(l3));
      localTbsDownloadConfig.a.put("tbs_apkfilesize", Long.valueOf(l4));
      localTbsDownloadConfig.commit();
      if (paramString != null) {
        localTbsDownloadConfig.a.put("tbs_apk_md5", paramString);
      }
      if ((!paramBoolean2) && (am.a().b(c, i4)))
      {
        if (paramBoolean1)
        {
          localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-113));
        }
        else
        {
          localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65323));
          localTbsDownloadConfig.setDownloadInterruptCode(65323);
        }
        localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
        paramString = "[TbsDownloader.readResponse] ##6 set needDownload=false";
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", paramString);
        break label3067;
        if (!paramBoolean2)
        {
          paramString = g;
          if ((i5 != 1) && (i5 != 2)) {
            bool = false;
          } else {
            bool = true;
          }
          if (paramString.a(paramBoolean2, bool))
          {
            localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
            localObject2 = TbsLogReport.a(c).a();
            ((TbsLogReport.TbsLogInfo)localObject2).setErrorCode(100);
            paramString = new StringBuilder();
            paramString.append("use local backup apk in needDownload");
            paramString.append(g.a);
            ((TbsLogReport.TbsLogInfo)localObject2).setFailDetail(paramString.toString());
            if (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
              paramString = TbsLogReport.a(c);
            }
            for (localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;; localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD)
            {
              paramString.a((TbsLogReport.EventType)localObject1, (TbsLogReport.TbsLogInfo)localObject2);
              break;
              paramString = TbsLogReport.a(c);
            }
            paramString = "[TbsDownloader.readResponse] ##7 set needDownload=false";
            continue;
          }
        }
        if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) != 1) || (!g.a())) {
          break;
        }
        localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
        localObject2 = TbsLogReport.a(c).a();
        ((TbsLogReport.TbsLogInfo)localObject2).setErrorCode(100);
        paramString = new StringBuilder();
        paramString.append("installDecoupleCoreFromBackup");
        paramString.append(g.a);
        ((TbsLogReport.TbsLogInfo)localObject2).setFailDetail(paramString.toString());
        if (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
          paramString = TbsLogReport.a(c);
        }
        for (localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;; localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD)
        {
          paramString.a((TbsLogReport.EventType)localObject1, (TbsLogReport.TbsLogInfo)localObject2);
          break;
          paramString = TbsLogReport.a(c);
        }
        paramString = "[TbsDownloader.readResponse] ##8 set needDownload=false";
      }
      if (!paramBoolean1) {
        localTbsDownloadConfig.setDownloadInterruptCode(65320);
      }
      localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(true));
      TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] ##9 set needDownload=true");
      if (localJSONObject.optInt("stop_pre_oat", 0) == 1) {
        localTbsDownloadConfig.a.put("tbs_stop_preoat", Boolean.valueOf(true));
      }
      localTbsDownloadConfig.commit();
      return true;
      throw paramString;
    }
  }
  
  protected static File b(int paramInt)
  {
    Object localObject2 = TbsShareManager.getCoreProviderAppList();
    int n = localObject2.length;
    Object localObject1 = null;
    int m = 0;
    while (m < n)
    {
      String str1 = localObject2[m];
      String str2 = k.a(c, str1, 4, false);
      if (getOverSea(c)) {
        localObject1 = "x5.oversea.tbs.org";
      } else {
        localObject1 = "x5.tbs.org";
      }
      localObject1 = new File(str2, (String)localObject1);
      if ((((File)localObject1).exists()) && (a.a(c, (File)localObject1) == paramInt)) {}
      for (localObject2 = new StringBuilder();; localObject2 = new StringBuilder())
      {
        ((StringBuilder)localObject2).append("local tbs version fond,path = ");
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
        return (File)localObject1;
        localObject1 = new File(k.a(c, str1, 4, false), "x5.tbs.decouple");
        if ((!((File)localObject1).exists()) || (a.a(c, (File)localObject1) != paramInt)) {
          break;
        }
      }
      m += 1;
    }
    return (File)localObject1;
  }
  
  private static JSONObject b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @TargetApi(11)
  static void b(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.a(paramContext).d();
    ag.c(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11) {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
    } else {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
    }
    localSharedPreferences.edit().clear().commit();
    if (Build.VERSION.SDK_INT >= 11) {
      paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
    } else {
      paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
    }
    paramContext.edit().clear().commit();
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return c(paramBoolean1, paramBoolean2, false);
  }
  
  private static boolean c()
  {
    try
    {
      String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        int i1 = TbsShareManager.getSharedTbsCoreVersion(c, str);
        if (i1 > 0) {
          return true;
        }
        m += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static boolean c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((QbSdk.n != null) && (QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false"))) {}
    for (Object localObject1 = "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";; localObject1 = "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!")
    {
      TbsLog.i("TbsDownload", (String)localObject1);
      return false;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[TbsDownloader.sendRequest]isQuery: ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(" forDecoupleCore is ");
      ((StringBuilder)localObject1).append(paramBoolean3);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      if (!am.a().c(c)) {
        break;
      }
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    Object localObject2 = k.a(c, 1);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    } else {
      localObject1 = "x5.tbs.org";
    }
    localObject2 = new File((String)localObject2, (String)localObject1);
    Object localObject3 = k.a(c, 2);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    } else {
      localObject1 = "x5.tbs.org";
    }
    localObject3 = new File((String)localObject3, (String)localObject1);
    Object localObject4 = k.a(c, 3);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    } else {
      localObject1 = "x5.tbs.org";
    }
    localObject4 = new File((String)localObject4, (String)localObject1);
    String str = k.a(c, 4);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    } else {
      localObject1 = "x5.tbs.org";
    }
    localObject1 = new File(str, (String)localObject1);
    if (!((File)localObject1).exists()) {
      if (((File)localObject4).exists()) {
        ((File)localObject4).renameTo((File)localObject1);
      } else if (((File)localObject3).exists()) {
        ((File)localObject3).renameTo((File)localObject1);
      } else if (((File)localObject2).exists()) {
        ((File)localObject2).renameTo((File)localObject1);
      }
    }
    if (e == null)
    {
      e = b.a();
      localTbsDownloadConfig.a.put("device_cpuabi", e);
      localTbsDownloadConfig.commit();
    }
    if (!TextUtils.isEmpty(e)) {
      localObject1 = null;
    }
    try
    {
      localObject2 = Pattern.compile("i686|mips|x86_64").matcher(e);
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      int m;
      for (;;) {}
    }
    if ((localObject1 != null) && (((Matcher)localObject1).find()))
    {
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject1 = TbsLogReport.a(c).a();
        if (paramBoolean1)
        {
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
        }
        else
        {
          localTbsDownloadConfig.setDownloadInterruptCode(65331);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(65331);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mycpu is ");
        ((StringBuilder)localObject2).append(e);
        ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail(((StringBuilder)localObject2).toString());
        TbsLogReport.a(c).a(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
      }
      else if (paramBoolean1)
      {
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
      }
      else
      {
        localTbsDownloadConfig.setDownloadInterruptCode(65331);
      }
      m = 1;
    }
    else
    {
      m = 0;
    }
    localObject1 = b(paramBoolean1, paramBoolean2, paramBoolean3);
    try
    {
      n = ((JSONObject)localObject1).getInt("TBSV");
    }
    catch (Exception localException2)
    {
      int n;
      long l2;
      long l3;
      long l4;
      long l5;
      long l1;
      for (;;) {}
    }
    n = -1;
    if ((m != 0) || (n != -1))
    {
      l2 = System.currentTimeMillis();
      if (TbsShareManager.isThirdPartyApp(c))
      {
        l3 = localTbsDownloadConfig.mPreferences.getLong("request_fail", 0L);
        l4 = localTbsDownloadConfig.mPreferences.getLong("count_request_fail_in_24hours", 0L);
        l5 = localTbsDownloadConfig.getRetryInterval();
        l1 = 1L;
        if (l2 - l3 < l5 * 1000L) {
          l1 = l4 + 1L;
        }
        localTbsDownloadConfig.a.put("count_request_fail_in_24hours", Long.valueOf(l1));
      }
      localTbsDownloadConfig.a.put("last_check", Long.valueOf(l2));
      localTbsDownloadConfig.a.put("request_fail", Long.valueOf(l2));
      localTbsDownloadConfig.a.put("app_versionname", b.a(c));
      localTbsDownloadConfig.a.put("app_versioncode", Integer.valueOf(b.b(c)));
      localTbsDownloadConfig.a.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      localTbsDownloadConfig.commit();
      if (m != 0) {
        return false;
      }
    }
    if (n != -1)
    {
      try
      {
        if ((c != null) && ("com.tencent.mm".equals(c.getApplicationInfo().packageName)) && (!paramBoolean3) && ((((JSONObject)localObject1).getInt("FUNCTION") == 0) || (((JSONObject)localObject1).getInt("FUNCTION") == 1)))
        {
          localObject2 = TbsLogReport.a(c).a();
          ((TbsLogReport.TbsLogInfo)localObject2).setErrorCode(127);
          TbsLogReport.a(c).a(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject2);
        }
        localObject2 = v.a(c).d();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[TbsDownloader.sendRequest] postUrl=");
        ((StringBuilder)localObject3).append((String)localObject2);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject3).toString());
        paramBoolean2 = a(n.a((String)localObject2, ((JSONObject)localObject1).toString().getBytes("utf-8"), new ak(localTbsDownloadConfig, paramBoolean1), false), n, paramBoolean1, paramBoolean2);
        return paramBoolean2;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (!paramBoolean1) {}
      }
      for (m = -106;; m = 65330)
      {
        localTbsDownloadConfig.setDownloadInterruptCode(m);
        break;
      }
    }
    return false;
  }
  
  private static void d()
  {
    for (;;)
    {
      try
      {
        if (h == null) {
          h = al.a();
        }
      }
      finally {}
      try
      {
        g = new ag(c);
        d = new aj(h.getLooper());
      }
      catch (Exception localException) {}
    }
    i = true;
    TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
    return;
  }
  
  private static boolean e()
  {
    try
    {
      JSONArray localJSONArray = f();
      boolean bool = TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      return bool;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static JSONArray f()
  {
    if (TbsShareManager.isThirdPartyApp(c))
    {
      JSONArray localJSONArray = new JSONArray();
      boolean bool = QbSdk.getOnlyDownload();
      int i1 = 1;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (bool)
      {
        localObject1 = new String[1];
        localObject1[0] = c.getApplicationContext().getPackageName();
      }
      else
      {
        localObject2 = TbsShareManager.getCoreProviderAppList();
        localObject3 = c.getApplicationContext().getPackageName();
        localObject1 = localObject2;
        if (((String)localObject3).equals(TbsShareManager.f(c)))
        {
          m = localObject2.length;
          localObject1 = new String[m + 1];
          System.arraycopy(localObject2, 0, localObject1, 0, m);
          localObject1[m] = localObject3;
        }
      }
      int i2 = localObject1.length;
      int m = 0;
      int i3;
      int n;
      while (m < i2)
      {
        localObject2 = localObject1[m];
        i3 = TbsShareManager.getSharedTbsCoreVersion(c, (String)localObject2);
        if (i3 > 0)
        {
          localObject3 = TbsShareManager.getPackageContext(c, (String)localObject2);
          if ((localObject3 != null) && (!am.a().f((Context)localObject3)))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("host check failed,packageName = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            TbsLog.e("TbsDownload", ((StringBuilder)localObject3).toString());
          }
          else
          {
            n = 0;
            while (n < localJSONArray.length())
            {
              if (localJSONArray.optInt(n) == i3)
              {
                n = 1;
                break label247;
              }
              n += 1;
            }
            n = 0;
            label247:
            if (n == 0) {
              localJSONArray.put(i3);
            }
          }
        }
        m += 1;
      }
      i2 = localObject1.length;
      m = 0;
      while (m < i2)
      {
        localObject2 = localObject1[m];
        i3 = TbsShareManager.getCoreShareDecoupleCoreVersion(c, (String)localObject2);
        if (i3 > 0)
        {
          localObject3 = TbsShareManager.getPackageContext(c, (String)localObject2);
          if ((localObject3 != null) && (!am.a().f((Context)localObject3)))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("host check failed,packageName = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            TbsLog.e("TbsDownload", ((StringBuilder)localObject3).toString());
          }
          else
          {
            n = 0;
            while (n < localJSONArray.length())
            {
              if (localJSONArray.optInt(n) == i3)
              {
                n = 1;
                break label399;
              }
              n += 1;
            }
            n = 0;
            label399:
            if (n == 0) {
              localJSONArray.put(i3);
            }
          }
        }
        m += 1;
      }
      if (!QbSdk.mDisableUseHostBackupCore)
      {
        i2 = localObject1.length;
        m = 0;
        while (m < i2)
        {
          localObject3 = localObject1[m];
          i3 = TbsShareManager.getBackupCoreVersion(c, (String)localObject3);
          if (i3 > 0)
          {
            localObject2 = TbsShareManager.getPackageContext(c, (String)localObject3);
            if ((localObject2 == null) || (am.a().f((Context)localObject2))) {}
          }
          for (localObject2 = new StringBuilder();; localObject2 = new StringBuilder())
          {
            ((StringBuilder)localObject2).append("host check failed,packageName = ");
            ((StringBuilder)localObject2).append((String)localObject3);
            TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
            break label670;
            n = 0;
            while (n < localJSONArray.length())
            {
              if (localJSONArray.optInt(n) == i3)
              {
                n = 1;
                break label557;
              }
              n += 1;
            }
            n = 0;
            label557:
            if (n == 0) {
              localJSONArray.put(i3);
            }
            i3 = TbsShareManager.getBackupDecoupleCoreVersion(c, (String)localObject3);
            if (i3 <= 0) {
              break label670;
            }
            localObject2 = TbsShareManager.getPackageContext(c, (String)localObject3);
            if ((localObject2 == null) || (am.a().f((Context)localObject2))) {
              break;
            }
          }
          n = 0;
          while (n < localJSONArray.length())
          {
            if (localJSONArray.optInt(n) == i3)
            {
              n = 1;
              break label658;
            }
            n += 1;
          }
          n = 0;
          label658:
          if (n == 0) {
            localJSONArray.put(i3);
          }
          label670:
          m += 1;
        }
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null)
      {
        n = am.a().a(TbsShareManager.getHostCorePathAppDefined());
        m = 0;
        while (m < localJSONArray.length())
        {
          if (localJSONArray.optInt(m) == n)
          {
            m = i1;
            break label728;
          }
          m += 1;
        }
        m = 0;
        label728:
        if (m == 0) {
          localJSONArray.put(n);
        }
      }
      return localJSONArray;
    }
    return null;
  }
  
  private static boolean g()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    int m;
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      m = -115;
    }
    for (;;)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(m);
      return false;
      if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
        m = -116;
      }
      else if (!k.b(c))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
        m = -117;
      }
      else
      {
        if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) > 86400000L) {
          break;
        }
        long l1 = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TbsDownloader.needStartDownload] downloadFlow=");
        localStringBuilder.append(l1);
        TbsLog.i("TbsDownload", localStringBuilder.toString());
        if (l1 < localTbsDownloadConfig.getDownloadMaxflow()) {
          break;
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        m = -120;
      }
    }
    return true;
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    return am.a().i(c);
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    return am.a().i(paramContext);
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      if (!k)
      {
        k = true;
        paramContext = TbsDownloadConfig.getInstance(paramContext);
        if (paramContext.mPreferences.contains("is_oversea"))
        {
          j = paramContext.mPreferences.getBoolean("is_oversea", false);
          paramContext = new StringBuilder();
          paramContext.append("[TbsDownloader.getOverSea]  first called. sOverSea = ");
          paramContext.append(j);
          TbsLog.i("TbsDownload", paramContext.toString());
        }
        paramContext = new StringBuilder();
        paramContext.append("[TbsDownloader.getOverSea]  sOverSea = ");
        paramContext.append(j);
        TbsLog.i("TbsDownload", paramContext.toString());
      }
      boolean bool = j;
      return bool;
    }
    finally {}
  }
  
  public static long getRetryIntervalInSeconds()
  {
    return l;
  }
  
  public static HandlerThread getsTbsHandlerThread()
  {
    return h;
  }
  
  private static JSONArray h()
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = arrayOfString.length;
    int m = 0;
    while (m < i1)
    {
      Object localObject = arrayOfString[m];
      String str = k.a(c, (String)localObject, 4, false);
      if (getOverSea(c)) {
        localObject = "x5.oversea.tbs.org";
      } else {
        localObject = "x5.tbs.org";
      }
      localObject = new File(str, (String)localObject);
      if (((File)localObject).exists())
      {
        long l1 = a.a(c, (File)localObject);
        if (l1 > 0L)
        {
          int n = 0;
          while (n < localJSONArray.length())
          {
            if (localJSONArray.optInt(n) == l1)
            {
              n = 1;
              break label137;
            }
            n += 1;
          }
          n = 0;
          label137:
          if (n == 0) {
            localJSONArray.put(l1);
          }
        }
      }
      m += 1;
    }
    return localJSONArray;
  }
  
  public static boolean isDownloadForeground()
  {
    return (g != null) && (g.e());
  }
  
  public static boolean isDownloading()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.isDownloading] is ");
      localStringBuilder.append(a);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    return needDownload(paramContext, paramBoolean, false, null);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[TbsDownloader.needDownload] oversea=");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(",isDownloadForeground=");
    ((StringBuilder)localObject).append(paramBoolean2);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    TbsLog.initIfNeed(paramContext);
    if (am.b)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      paramContext = new StringBuilder();
      paramTbsDownloaderCallback = "[TbsDownloader.needDownload]#1,return ";
    }
    for (;;)
    {
      paramContext.append(paramTbsDownloaderCallback);
      paramContext.append(false);
      TbsLog.i("TbsDownload", paramContext.toString());
      return false;
      TbsLog.app_extra("TbsDownload", paramContext);
      c = paramContext.getApplicationContext();
      localObject = TbsDownloadConfig.getInstance(c);
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-100);
      if (!a(c, paramBoolean1, paramTbsDownloaderCallback))
      {
        paramContext = new StringBuilder();
        paramTbsDownloaderCallback = "[TbsDownloader.needDownload]#2,return ";
      }
      else
      {
        d();
        if (!i) {
          break;
        }
        if (paramTbsDownloaderCallback != null) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-105);
        paramContext = new StringBuilder();
        paramTbsDownloaderCallback = "[TbsDownloader.needDownload]#3,return ";
      }
    }
    boolean bool = a(c, paramBoolean2, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsDownloader.needDownload],needSendRequest=");
    localStringBuilder.append(bool);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (bool)
    {
      a(paramBoolean2, paramTbsDownloaderCallback);
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-114);
    }
    d.removeMessages(102);
    Message.obtain(d, 102).sendToTarget();
    if ((!QbSdk.c) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    else
    {
      paramBoolean2 = ((TbsDownloadConfig)localObject).mPreferences.contains("tbs_needdownload");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.needDownload] hasNeedDownloadKey=");
      localStringBuilder.append(paramBoolean2);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      if ((!paramBoolean2) && (!TbsShareManager.isThirdPartyApp(paramContext))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false);
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needDownload]#4,needDownload=");
    paramContext.append(paramBoolean1);
    paramContext.append(",hasNeedDownloadKey=");
    paramContext.append(paramBoolean2);
    TbsLog.i("TbsDownload", paramContext.toString());
    if (paramBoolean1)
    {
      if (!g())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
        paramBoolean1 = false;
      }
      else
      {
        ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-118);
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      }
    }
    else
    {
      int m = am.a().n(c);
      paramContext = new StringBuilder();
      paramContext.append("[TbsDownloader.needDownload]#7,tbsLocalVersion=");
      paramContext.append(m);
      paramContext.append(",needSendRequest=");
      paramContext.append(bool);
      TbsLog.i("TbsDownload", paramContext.toString());
      if ((!bool) && (m > 0)) {}
      for (m = -119;; m = -121)
      {
        ((TbsDownloadConfig)localObject).setDownloadInterruptCode(m);
        break;
        d.removeMessages(103);
        if ((m <= 0) && (!bool)) {
          paramContext = Message.obtain(d, 103, 0, 0, c);
        } else {
          paramContext = Message.obtain(d, 103, 1, 0, c);
        }
        paramContext.sendToTarget();
      }
    }
    if ((!bool) && (paramTbsDownloaderCallback != null)) {
      paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needDownload] needDownload=");
    paramContext.append(paramBoolean1);
    TbsLog.i("TbsDownload", paramContext.toString());
    return paramBoolean1;
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    if (TbsShareManager.isThirdPartyApp(c)) {
      return false;
    }
    if (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
      return false;
    }
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000L) {
      return false;
    }
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    return (m > 0) && (m != am.a().i(c)) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != m);
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean, null)) {
      return false;
    }
    int m = am.a().n(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needSendRequest] localTbsVersion=");
    paramContext.append(m);
    TbsLog.i("TbsDownload", paramContext.toString());
    if (m > 0) {
      return false;
    }
    paramContext = c;
    boolean bool = true;
    if (a(paramContext, false, true)) {
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsDownloader.needSendRequest] hasNeedDownloadKey=");
    localStringBuilder.append(paramBoolean);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (!paramBoolean) {
      paramBoolean = true;
    } else {
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needSendRequest] needDownload=");
    paramContext.append(paramBoolean);
    TbsLog.i("TbsDownload", paramContext.toString());
    if ((paramBoolean) && (g())) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needSendRequest] ret=");
    paramContext.append(paramBoolean);
    TbsLog.i("TbsDownload", paramContext.toString());
    return paramBoolean;
  }
  
  public static void setAppContext(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      c = paramContext.getApplicationContext();
    }
  }
  
  public static void setRetryIntervalInSeconds(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    if (paramContext.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
      l = paramLong;
    }
    paramContext = new StringBuilder();
    paramContext.append("mRetryIntervalInSeconds is ");
    paramContext.append(l);
    TbsLog.i("TbsDownload", paramContext.toString());
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c)) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
    if (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
      return false;
    }
    if (d == null) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000L) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    Object localObject;
    if ((m > 0) && (m != am.a().i(c)))
    {
      if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == m) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) != 1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is ");
        ((StringBuilder)localObject).append(TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0));
        ((StringBuilder)localObject).append(" deCoupleCoreVersion is ");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" KEY_TBS_DOWNLOAD_V_TYPE is ");
        m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0);
      }
      else
      {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
        a = true;
        d.removeMessages(108);
        localObject = Message.obtain(d, 108, QbSdk.m);
        ((Message)localObject).arg1 = 0;
        ((Message)localObject).sendToTarget();
        TbsDownloadConfig.getInstance(c).a.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
        return true;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(" getTbsCoreShareDecoupleCoreVersion is ");
      m = am.a().i(c);
    }
    ((StringBuilder)localObject).append(m);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    return false;
  }
  
  public static void startDownload(Context paramContext)
  {
    startDownload(paramContext, false);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void stopDownload()
  {
    if (i) {
      return;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
    if (g != null) {
      g.c();
    }
    if (d != null)
    {
      d.removeMessages(100);
      d.removeMessages(101);
      d.removeMessages(108);
    }
  }
  
  public static abstract interface TbsDownloaderCallback
  {
    public abstract void onNeedDownloadFinish(boolean paramBoolean, int paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */