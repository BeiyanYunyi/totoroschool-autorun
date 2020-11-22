package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ag
{
  private static int d = 5;
  private static int e = 1;
  private static final String[] f = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private Set<String> A;
  private int B = d;
  private boolean C;
  String a;
  String[] b = null;
  int c = 0;
  private Context g;
  private String h;
  private String i;
  private String j;
  private File k;
  private long l;
  private int m = 30000;
  private int n = 20000;
  private boolean o;
  private int p;
  private int q;
  private boolean r;
  private boolean s;
  private HttpURLConnection t;
  private String u;
  private TbsLogReport.TbsLogInfo v;
  private String w;
  private int x;
  private boolean y;
  private Handler z;
  
  public ag(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    this.v = TbsLogReport.a(this.g).a();
    this.A = new HashSet();
    paramContext = new StringBuilder();
    paramContext.append("tbs_downloading_");
    paramContext.append(this.g.getPackageName());
    this.u = paramContext.toString();
    am.a();
    this.k = am.t(this.g);
    if (this.k != null)
    {
      f();
      this.w = null;
      this.x = -1;
      return;
    }
    throw new NullPointerException("TbsCorePrivateDir is null!");
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.v.setDownConsumeTime(l1 - paramLong1);
    this.v.setDownloadSize(paramLong2);
    return l1;
  }
  
  @TargetApi(8)
  static File a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(k.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TbsApkDownloader.backupApkPath] Exception is ");
        localStringBuilder.append(paramContext.getMessage());
        TbsLog.e("TbsDownload", localStringBuilder.toString());
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    File localFile = new File(k.a(paramContext, paramInt));
    if (localFile.exists())
    {
      if (!localFile.isDirectory()) {
        return null;
      }
      if (TbsDownloader.getOverSea(paramContext)) {
        paramContext = "x5.oversea.tbs.org";
      } else {
        paramContext = "x5.tbs.org";
      }
      if (new File(localFile, paramContext).exists()) {
        return localFile;
      }
    }
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.p > this.B))
    {
      this.v.setErrorCode(paramInt);
      this.v.setFailDetail(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.p += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = m();
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    if (paramFile != null) {
      if (!paramFile.exists()) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        File localFile = a(paramContext);
        if (localFile != null)
        {
          if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1)
          {
            localObject = new File(localFile, "x5.tbs.decouple");
          }
          else
          {
            if (!TbsDownloader.getOverSea(paramContext)) {
              break label173;
            }
            localObject = "x5.oversea.tbs.org";
            localObject = new File(localFile, (String)localObject);
          }
          ((File)localObject).delete();
          k.b(paramFile, (File)localObject);
          if ((TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) != 1) && (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0) == a.a(paramContext, paramFile)))
          {
            localObject = new File(localFile, "x5.tbs.decouple");
            if (a.a(paramContext, paramFile) != a.a(paramContext, (File)localObject))
            {
              ((File)localObject).delete();
              k.b(paramFile, (File)localObject);
            }
          }
        }
        return;
      }
      catch (Exception paramFile)
      {
        return;
      }
      label173:
      Object localObject = "x5.tbs.org";
    }
  }
  
  private void a(String paramString)
  {
    paramString = new URL(paramString);
    if (this.t != null) {
      try
      {
        this.t.disconnect();
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initHttpRequest] mHttpRequest.disconnect() Throwable:");
        localStringBuilder.append(localThrowable.toString());
        TbsLog.e("TbsDownload", localStringBuilder.toString());
      }
    }
    this.t = ((HttpURLConnection)paramString.openConnection());
    this.t.setRequestProperty("User-Agent", TbsDownloader.a(this.g));
    this.t.setRequestProperty("Accept-Encoding", "identity");
    this.t.setRequestMethod("GET");
    this.t.setInstanceFollowRedirects(false);
    this.t.setConnectTimeout(this.n);
    this.t.setReadTimeout(this.m);
  }
  
  @TargetApi(8)
  static File b(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = a(paramContext, 4);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramContext, 2);
        }
        if (localObject2 == null)
        {
          paramContext = a(paramContext, 1);
          return paramContext;
        }
        return (File)localObject2;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[TbsApkDownloader.backupApkPath] Exception is ");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      TbsLog.e("TbsDownload", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    y.a(this.g);
    Object localObject2 = TbsDownloadConfig.getInstance(this.g);
    ((TbsDownloadConfig)localObject2).a.put("request_full_package", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject2).a.put("tbs_needdownload", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject2).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject2).commit();
    Object localObject1 = QbSdk.m;
    if (paramBoolean) {
      i1 = 100;
    } else {
      i1 = 120;
    }
    ((TbsListener)localObject1).onDownloadFinish(i1);
    int i1 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_responsecode", 0);
    TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0);
    if ((i1 != 3) && (i1 <= 10000))
    {
      i1 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
      am.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
      a(new File(this.k, "x5.tbs"), this.g);
      return;
    }
    File localFile = a(this.g);
    if (localFile != null)
    {
      if (TbsDownloader.getOverSea(this.g)) {
        localObject1 = "x5.oversea.tbs.org";
      } else {
        localObject1 = "x5.tbs.org";
      }
      localFile = new File(localFile, (String)localObject1);
      int i2 = a.a(this.g, localFile);
      localObject1 = new File(this.k, "x5.tbs");
      if (((File)localObject1).exists()) {
        localObject1 = ((File)localObject1).getAbsolutePath();
      } else {
        localObject1 = null;
      }
      int i3 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("operation", i1);
      ((Bundle)localObject2).putInt("old_core_ver", i2);
      ((Bundle)localObject2).putInt("new_core_ver", i3);
      ((Bundle)localObject2).putString("old_apk_location", localFile.getAbsolutePath());
      ((Bundle)localObject2).putString("new_apk_location", (String)localObject1);
      ((Bundle)localObject2).putString("diff_file_location", (String)localObject1);
      am.a().b(this.g, (Bundle)localObject2);
      return;
    }
    d();
    ((TbsDownloadConfig)localObject2).a.put("tbs_needdownload", Boolean.valueOf(true));
    ((TbsDownloadConfig)localObject2).commit();
  }
  
  private boolean b(int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject2 = new File(this.k, "x5.tbs");
        File localFile = a(this.g);
        if (localFile != null)
        {
          if (TbsDownloader.getOverSea(this.g))
          {
            Object localObject1 = "x5.oversea.tbs.org";
            localObject1 = new File(localFile, (String)localObject1);
            ((File)localObject2).delete();
            k.b((File)localObject1, (File)localObject2);
            if (!a.a(this.g, (File)localObject2, 0L, paramInt))
            {
              TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
              return false;
            }
            return true;
          }
        }
        else {
          return false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
        return false;
      }
      String str = "x5.tbs.org";
    }
  }
  
  public static void c(Context paramContext)
  {
    try
    {
      am.a();
      File localFile = am.t(paramContext);
      new File(localFile, "x5.tbs").delete();
      new File(localFile, "x5.tbs.temp").delete();
      paramContext = a(paramContext);
      if (paramContext != null)
      {
        new File(paramContext, "x5.tbs.org").delete();
        new File(paramContext, "x5.oversea.tbs.org").delete();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private boolean c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[TbsApkDownloader.deleteFile] isApk=");
    ((StringBuilder)localObject).append(paramBoolean);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = new File(this.k, "x5.tbs");
    } else {
      localObject = new File(this.k, "x5.tbs.temp");
    }
    paramBoolean = true;
    if (((File)localObject).exists()) {
      paramBoolean = ((File)localObject).delete();
    }
    return paramBoolean;
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
    ((StringBuilder)localObject1).append(paramBoolean1);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    Object localObject2 = this.k;
    if (!paramBoolean1) {
      localObject1 = "x5.tbs";
    } else {
      localObject1 = "x5.tbs.temp";
    }
    localObject2 = new File((File)localObject2, (String)localObject1);
    if (!((File)localObject2).exists()) {
      return false;
    }
    Object localObject3 = TbsDownloadConfig.getInstance(this.g).mPreferences;
    localObject1 = null;
    Object localObject4 = ((SharedPreferences)localObject3).getString("tbs_apk_md5", null);
    localObject3 = a.a((File)localObject2);
    if ((localObject4 != null) && (((String)localObject4).equals(localObject3)))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("[TbsApkDownloader.verifyTbsApk] md5(");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(") successful!");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject4).toString());
      long l1 = 0L;
      long l2 = l1;
      if (paramBoolean1)
      {
        long l3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
        l2 = l1;
        if (((File)localObject2).exists())
        {
          l2 = l1;
          if (l3 > 0L)
          {
            l1 = ((File)localObject2).length();
            l2 = l1;
            if (l3 != l1) {
              l2 = l1;
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
          ((StringBuilder)localObject1).append(paramBoolean1);
          ((StringBuilder)localObject1).append(" filelength failed");
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
          localObject1 = this.v;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("fileLength:");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(",contentLength:");
          ((StringBuilder)localObject2).append(l3);
          ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(((StringBuilder)localObject2).toString());
          return false;
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[TbsApkDownloader.verifyTbsApk] length(");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(") successful!");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject3).toString());
      int i2 = -1;
      int i1 = i2;
      if (paramBoolean2)
      {
        i1 = i2;
        if (!paramBoolean1)
        {
          i2 = a.a(this.g, (File)localObject2);
          int i3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
          i1 = i2;
          if (i3 != i2)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
            ((StringBuilder)localObject1).append(paramBoolean1);
            ((StringBuilder)localObject1).append(" versionCode failed");
            TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
            if (paramBoolean1)
            {
              localObject1 = this.v;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("fileVersion:");
              ((StringBuilder)localObject2).append(i2);
              ((StringBuilder)localObject2).append(",configVersion:");
              ((StringBuilder)localObject2).append(i3);
              ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(((StringBuilder)localObject2).toString());
            }
            return false;
          }
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(") successful!");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject3).toString());
      if ((paramBoolean2) && (!paramBoolean1))
      {
        localObject3 = b.a(this.g, (File)localObject2);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject3))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
          ((StringBuilder)localObject1).append(paramBoolean1);
          ((StringBuilder)localObject1).append(" signature failed");
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
          if (paramBoolean1)
          {
            localObject2 = this.v;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("signature:");
            if (localObject3 == null) {
              localObject1 = "null";
            } else {
              localObject1 = Integer.valueOf(((String)localObject3).length());
            }
            ((StringBuilder)localObject4).append(localObject1);
            ((TbsLogReport.TbsLogInfo)localObject2).setCheckErrorDetail(((StringBuilder)localObject4).toString());
          }
          return false;
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if (paramBoolean1)
      {
        try
        {
          paramBoolean1 = ((File)localObject2).renameTo(new File(this.k, "x5.tbs"));
        }
        catch (Exception localException)
        {
          paramBoolean1 = false;
        }
        paramBoolean2 = paramBoolean1;
        if (!paramBoolean1)
        {
          a(109, a(localException), true);
          return false;
        }
      }
      else
      {
        paramBoolean2 = false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsApkDownloader.verifyTbsApk] rename(");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(") successful!");
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" md5 failed");
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (paramBoolean1) {
      this.v.setCheckErrorDetail("fileMd5 not match");
    }
    return false;
  }
  
  private void f()
  {
    this.p = 0;
    this.q = 0;
    this.l = -1L;
    this.j = null;
    this.o = false;
    this.r = false;
    this.s = false;
    this.y = false;
  }
  
  private void g()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    Object localObject2;
    if (this.t != null)
    {
      if (!this.r) {
        this.v.setResolveIp(a(this.t.getURL()));
      }
      try
      {
        this.t.disconnect();
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[closeHttpRequest] mHttpRequest.disconnect() Throwable:");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
      }
      this.t = null;
    }
    int i1 = this.v.a;
    if ((!this.r) && (this.y))
    {
      this.v.setEventTime(System.currentTimeMillis());
      localObject2 = Apn.getApnInfo(this.g);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int i2 = Apn.getApnType(this.g);
      this.v.setApn((String)localObject1);
      this.v.setNetworkType(i2);
      if ((i2 != this.x) || (!((String)localObject1).equals(this.w))) {
        this.v.setNetworkChange(0);
      }
      if (((this.v.a == 0) || (this.v.a == 107)) && (this.v.getDownFinalFlag() == 0))
      {
        if (!Apn.isNetworkAvailable(this.g)) {}
        while (!l())
        {
          a(101, null, true);
          break;
        }
      }
      if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
        localObject1 = TbsLogReport.a(this.g);
      }
      for (localObject2 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;; localObject2 = TbsLogReport.EventType.TYPE_DOWNLOAD)
      {
        ((TbsLogReport)localObject1).a((TbsLogReport.EventType)localObject2, this.v);
        break;
        localObject1 = TbsLogReport.a(this.g);
      }
      this.v.resetArgs();
      if (i1 != 100) {
        QbSdk.m.onDownloadFinish(i1);
      }
    }
    else
    {
      TbsDownloader.a = false;
    }
  }
  
  private boolean h()
  {
    String str = k.a(this.g, 4);
    if (TbsDownloader.getOverSea(this.g)) {
      localObject = "x5.oversea.tbs.org";
    } else {
      localObject = "x5.tbs.org";
    }
    Object localObject = new File(str, (String)localObject);
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    return a.a(this.g, (File)localObject, 0L, i1);
  }
  
  private void i()
  {
    for (;;)
    {
      try
      {
        if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
          return;
        }
        String str2 = k.a(this.g, 4);
        if (!TbsDownloader.getOverSea(this.g)) {
          break label78;
        }
        Object localObject = "x5.oversea.tbs.org";
        localObject = new File(str2, (String)localObject);
        if (((File)localObject).exists())
        {
          ((File)localObject).delete();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label78:
      String str1 = "x5.tbs.org";
    }
  }
  
  private boolean j()
  {
    return new File(this.k, "x5.tbs.temp").exists();
  }
  
  private long k()
  {
    File localFile = new File(this.k, "x5.tbs.temp");
    if (localFile.exists()) {
      return localFile.length();
    }
    return 0L;
  }
  
  /* Error */
  private boolean l()
  {
    // Byte code:
    //   0: invokestatic 638	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 6
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: aconst_null
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 8
    //   17: new 105	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   24: astore 7
    //   26: aload 7
    //   28: ldc_w 640
    //   31: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: ldc_w 642
    //   40: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 6
    //   46: aload 7
    //   48: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 646	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   54: invokevirtual 652	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   57: astore 6
    //   59: new 654	java/io/InputStreamReader
    //   62: dup
    //   63: aload 6
    //   65: invokespecial 657	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: astore 7
    //   70: new 659	java/io/BufferedReader
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 662	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore 10
    //   81: iconst_0
    //   82: istore_1
    //   83: aload 10
    //   85: invokevirtual 665	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   88: astore 8
    //   90: iload 4
    //   92: istore_3
    //   93: aload 8
    //   95: ifnull +49 -> 144
    //   98: aload 8
    //   100: ldc_w 667
    //   103: invokevirtual 671	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   106: ifne +36 -> 142
    //   109: aload 8
    //   111: ldc_w 673
    //   114: invokevirtual 671	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   117: istore_3
    //   118: iload_3
    //   119: ifeq +6 -> 125
    //   122: goto +20 -> 142
    //   125: iload_1
    //   126: iconst_1
    //   127: iadd
    //   128: istore_2
    //   129: iload_2
    //   130: istore_1
    //   131: iload_2
    //   132: iconst_5
    //   133: if_icmplt -50 -> 83
    //   136: iload 4
    //   138: istore_3
    //   139: goto +5 -> 144
    //   142: iconst_1
    //   143: istore_3
    //   144: aload_0
    //   145: aload 6
    //   147: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   150: aload 10
    //   152: astore 6
    //   154: goto +128 -> 282
    //   157: astore 8
    //   159: aload 6
    //   161: astore 9
    //   163: aload 8
    //   165: astore 6
    //   167: aload 10
    //   169: astore 8
    //   171: goto +139 -> 310
    //   174: astore 9
    //   176: aload 6
    //   178: astore 8
    //   180: aload 10
    //   182: astore 6
    //   184: goto +84 -> 268
    //   187: astore 10
    //   189: aconst_null
    //   190: astore 8
    //   192: aload 6
    //   194: astore 9
    //   196: aload 10
    //   198: astore 6
    //   200: goto +110 -> 310
    //   203: astore 9
    //   205: aconst_null
    //   206: astore 10
    //   208: aload 6
    //   210: astore 8
    //   212: aload 10
    //   214: astore 6
    //   216: goto +52 -> 268
    //   219: astore 7
    //   221: aconst_null
    //   222: astore 8
    //   224: goto +98 -> 322
    //   227: astore 9
    //   229: aconst_null
    //   230: astore 10
    //   232: aload 10
    //   234: astore 7
    //   236: aload 6
    //   238: astore 8
    //   240: aload 10
    //   242: astore 6
    //   244: goto +24 -> 268
    //   247: astore 7
    //   249: aconst_null
    //   250: astore 6
    //   252: aload 6
    //   254: astore 8
    //   256: goto +66 -> 322
    //   259: astore 9
    //   261: aconst_null
    //   262: astore 7
    //   264: aload 7
    //   266: astore 6
    //   268: aload 9
    //   270: invokevirtual 676	java/lang/Throwable:printStackTrace	()V
    //   273: aload_0
    //   274: aload 8
    //   276: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   279: iload 5
    //   281: istore_3
    //   282: aload_0
    //   283: aload 7
    //   285: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   288: aload_0
    //   289: aload 6
    //   291: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   294: iload_3
    //   295: ireturn
    //   296: astore 10
    //   298: aload 8
    //   300: astore 9
    //   302: aload 6
    //   304: astore 8
    //   306: aload 10
    //   308: astore 6
    //   310: aload 7
    //   312: astore 10
    //   314: aload 6
    //   316: astore 7
    //   318: aload 9
    //   320: astore 6
    //   322: aload_0
    //   323: aload 6
    //   325: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   328: aload_0
    //   329: aload 10
    //   331: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   334: aload_0
    //   335: aload 8
    //   337: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   340: aload 7
    //   342: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	ag
    //   82	49	1	i1	int
    //   128	6	2	i2	int
    //   92	203	3	bool1	boolean
    //   9	128	4	bool2	boolean
    //   6	274	5	bool3	boolean
    //   3	321	6	localObject1	Object
    //   24	51	7	localObject2	Object
    //   219	1	7	localObject3	Object
    //   234	1	7	localObject4	Object
    //   247	1	7	localObject5	Object
    //   262	79	7	localObject6	Object
    //   15	95	8	str	String
    //   157	7	8	localObject7	Object
    //   169	167	8	localObject8	Object
    //   161	1	9	localObject9	Object
    //   174	1	9	localThrowable1	Throwable
    //   194	1	9	localObject10	Object
    //   203	1	9	localThrowable2	Throwable
    //   227	1	9	localThrowable3	Throwable
    //   259	10	9	localThrowable4	Throwable
    //   300	19	9	localObject11	Object
    //   12	169	10	localBufferedReader	java.io.BufferedReader
    //   187	10	10	localObject12	Object
    //   206	35	10	localObject13	Object
    //   296	11	10	localObject14	Object
    //   312	18	10	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   83	90	157	finally
    //   98	118	157	finally
    //   83	90	174	java/lang/Throwable
    //   98	118	174	java/lang/Throwable
    //   70	81	187	finally
    //   70	81	203	java/lang/Throwable
    //   59	70	219	finally
    //   59	70	227	java/lang/Throwable
    //   17	59	247	finally
    //   17	59	259	java/lang/Throwable
    //   268	273	296	finally
  }
  
  private long m()
  {
    switch (this.p)
    {
    default: 
      return 200000L;
    case 3: 
    case 4: 
      return 100000L;
    }
    return this.p * 20000L;
  }
  
  /* Error */
  private boolean n()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4: invokestatic 594	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   7: istore_1
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore 5
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_1
    //   17: iconst_3
    //   18: if_icmpne +8 -> 26
    //   21: iconst_1
    //   22: istore_2
    //   23: goto +5 -> 28
    //   26: iconst_0
    //   27: istore_2
    //   28: new 105	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: ldc_w 684
    //   42: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 6
    //   48: iload_2
    //   49: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc -58
    //   55: aload 6
    //   57: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aconst_null
    //   64: astore 8
    //   66: aconst_null
    //   67: astore 6
    //   69: iload_2
    //   70: ifeq +271 -> 341
    //   73: aload_0
    //   74: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   77: invokestatic 687	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   80: astore 9
    //   82: new 105	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   89: astore 7
    //   91: aload 7
    //   93: ldc_w 689
    //   96: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 7
    //   102: aload 9
    //   104: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc -58
    //   110: aload 7
    //   112: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: new 237	java/net/URL
    //   121: dup
    //   122: ldc_w 691
    //   125: invokespecial 316	java/net/URL:<init>	(Ljava/lang/String;)V
    //   128: invokevirtual 330	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   131: checkcast 320	java/net/HttpURLConnection
    //   134: astore 7
    //   136: aload 7
    //   138: iconst_0
    //   139: invokevirtual 351	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   142: aload 7
    //   144: sipush 10000
    //   147: invokevirtual 354	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   150: aload 7
    //   152: sipush 10000
    //   155: invokevirtual 357	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   158: aload 7
    //   160: iconst_0
    //   161: invokevirtual 694	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   164: aload 7
    //   166: invokevirtual 695	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   169: pop
    //   170: aload 7
    //   172: invokevirtual 698	java/net/HttpURLConnection:getResponseCode	()I
    //   175: istore_1
    //   176: new 105	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   183: astore 6
    //   185: aload 6
    //   187: ldc_w 700
    //   190: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: iload_1
    //   197: invokevirtual 515	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc -58
    //   203: aload 6
    //   205: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: iload_3
    //   212: istore_2
    //   213: iload_1
    //   214: sipush 204
    //   217: if_icmpne +5 -> 222
    //   220: iconst_1
    //   221: istore_2
    //   222: aload 9
    //   224: astore 6
    //   226: iload_2
    //   227: istore_3
    //   228: aload 7
    //   230: ifnull +117 -> 347
    //   233: iload_2
    //   234: istore_3
    //   235: aload 7
    //   237: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   240: aload 9
    //   242: astore 6
    //   244: iload_2
    //   245: istore_3
    //   246: goto +101 -> 347
    //   249: aload 9
    //   251: astore 6
    //   253: goto +94 -> 347
    //   256: astore 6
    //   258: goto +70 -> 328
    //   261: astore 8
    //   263: goto +26 -> 289
    //   266: astore 8
    //   268: aload 6
    //   270: astore 7
    //   272: aload 8
    //   274: astore 6
    //   276: goto +52 -> 328
    //   279: astore 6
    //   281: aload 8
    //   283: astore 7
    //   285: aload 6
    //   287: astore 8
    //   289: aload 7
    //   291: astore 6
    //   293: aload 8
    //   295: invokevirtual 676	java/lang/Throwable:printStackTrace	()V
    //   298: aload 9
    //   300: astore 6
    //   302: iload 4
    //   304: istore_3
    //   305: aload 7
    //   307: ifnull +40 -> 347
    //   310: iload 5
    //   312: istore_3
    //   313: aload 7
    //   315: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   318: aload 9
    //   320: astore 6
    //   322: iload 4
    //   324: istore_3
    //   325: goto +22 -> 347
    //   328: aload 7
    //   330: ifnull +8 -> 338
    //   333: aload 7
    //   335: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   338: aload 6
    //   340: athrow
    //   341: aconst_null
    //   342: astore 6
    //   344: iload 4
    //   346: istore_3
    //   347: iload_3
    //   348: ifne +68 -> 416
    //   351: aload 6
    //   353: invokestatic 705	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +60 -> 416
    //   359: aload_0
    //   360: getfield 103	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   363: aload 6
    //   365: invokeinterface 709 2 0
    //   370: ifne +46 -> 416
    //   373: aload_0
    //   374: getfield 103	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   377: aload 6
    //   379: invokeinterface 712 2 0
    //   384: pop
    //   385: aload_0
    //   386: invokespecial 714	com/tencent/smtt/sdk/ag:o	()V
    //   389: aload_0
    //   390: getfield 716	com/tencent/smtt/sdk/ag:z	Landroid/os/Handler;
    //   393: sipush 150
    //   396: aload 6
    //   398: invokevirtual 722	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   401: astore 7
    //   403: aload_0
    //   404: getfield 716	com/tencent/smtt/sdk/ag:z	Landroid/os/Handler;
    //   407: aload 7
    //   409: ldc2_w 723
    //   412: invokevirtual 728	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   415: pop
    //   416: iload_3
    //   417: ifeq +29 -> 446
    //   420: aload_0
    //   421: getfield 103	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   424: aload 6
    //   426: invokeinterface 709 2 0
    //   431: ifeq +15 -> 446
    //   434: aload_0
    //   435: getfield 103	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   438: aload 6
    //   440: invokeinterface 731 2 0
    //   445: pop
    //   446: iload_3
    //   447: ireturn
    //   448: astore 6
    //   450: goto -201 -> 249
    //   453: astore 7
    //   455: goto -117 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	ag
    //   7	211	1	i1	int
    //   22	223	2	bool1	boolean
    //   15	432	3	bool2	boolean
    //   9	336	4	bool3	boolean
    //   12	299	5	bool4	boolean
    //   35	217	6	localObject1	Object
    //   256	13	6	localObject2	Object
    //   274	1	6	localObject3	Object
    //   279	7	6	localThrowable1	Throwable
    //   291	148	6	localObject4	Object
    //   448	1	6	localException1	Exception
    //   89	319	7	localObject5	Object
    //   453	1	7	localException2	Exception
    //   64	1	8	localObject6	Object
    //   261	1	8	localThrowable2	Throwable
    //   266	16	8	localObject7	Object
    //   287	7	8	localThrowable3	Throwable
    //   80	239	9	str	String
    // Exception table:
    //   from	to	target	type
    //   136	211	256	finally
    //   136	211	261	java/lang/Throwable
    //   118	136	266	finally
    //   293	298	266	finally
    //   118	136	279	java/lang/Throwable
    //   235	240	448	java/lang/Exception
    //   313	318	448	java/lang/Exception
    //   333	338	453	java/lang/Exception
  }
  
  private void o()
  {
    if (this.z == null) {
      this.z = new ah(this, al.a().getLooper());
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      File localFile = new File(this.k, "x5.tbs");
      int i1 = a.a(this.g, localFile);
      if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean a()
  {
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    try
    {
      File localFile1 = new File(k.a(this.g, 4), "x5.tbs.decouple");
      if (localFile1.exists())
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      else
      {
        File localFile2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          k.b(localFile2, localFile1);
        }
      }
      if (a.a(this.g, localFile1, 0L, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        return am.a().e(this.g);
      }
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup no backup file !!!");
      localFile1 = new File(k.a(this.g, 4), "x5.tbs.decouple");
      if (localFile1.exists()) {
        localFile1.delete();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!n()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g)))) {
      return false;
    }
    if ((this.b != null) && (this.c >= 0) && (this.c < this.b.length))
    {
      String[] arrayOfString = this.b;
      int i1 = this.c;
      this.c = (i1 + 1);
      this.j = arrayOfString[i1];
      this.p = 0;
      this.q = 0;
      this.l = -1L;
      this.o = false;
      this.r = false;
      this.s = false;
      this.y = false;
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i2 = am.a().j(this.g);
    if (i1 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    for (Object localObject1 = "by default key";; localObject1 = "by new key")
    {
      this.a = ((String)localObject1);
      break;
    }
    if (i1 != 0)
    {
      if (i1 == i2) {
        return false;
      }
      if (paramBoolean2)
      {
        Object localObject3 = TbsDownloader.a(i1);
        if ((localObject3 != null) && (((File)localObject3).exists()))
        {
          String str = k.a(this.g, 4);
          if (TbsDownloader.getOverSea(this.g)) {
            localObject1 = "x5.oversea.tbs.org";
          } else {
            localObject1 = "x5.tbs.org";
          }
          localObject1 = new File(str, (String)localObject1);
          try
          {
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version_type", 0) != 1)
            {
              k.b((File)localObject3, (File)localObject1);
              i2 = 1;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        i2 = 0;
        if (h())
        {
          if (b(i1))
          {
            TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65322));
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(65322);
            b(false);
            if (i2 != 0)
            {
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("use local backup apk in startDownload");
              ((StringBuilder)localObject2).append(this.a);
              a(100, ((StringBuilder)localObject2).toString(), true);
              if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
                localObject2 = TbsLogReport.a(this.g);
              }
              for (localObject3 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;; localObject3 = TbsLogReport.EventType.TYPE_DOWNLOAD)
              {
                ((TbsLogReport)localObject2).a((TbsLogReport.EventType)localObject3, this.v);
                break;
                localObject2 = TbsLogReport.a(this.g);
              }
              this.v.resetArgs();
            }
            return true;
          }
        }
        else
        {
          i();
          if (!a.a(this.g, (File)localObject3, 0L, i1)) {
            k.b((File)localObject3);
          }
        }
      }
      if (c(false, paramBoolean2))
      {
        TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65322));
        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(65322);
        b(false);
        return true;
      }
      if ((!c(true)) && (!c(true)))
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(65235);
      }
    }
    return false;
  }
  
  public int b()
  {
    File localFile = a(this.g);
    if (localFile == null) {
      return 0;
    }
    Context localContext = this.g;
    String str;
    if (TbsDownloader.getOverSea(this.g)) {
      str = "x5.oversea.tbs.org";
    } else {
      str = "x5.tbs.org";
    }
    return a.a(localContext, new File(localFile, str));
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 126	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   3: aload_0
    //   4: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   7: invokevirtual 798	com/tencent/smtt/sdk/am:c	(Landroid/content/Context;)Z
    //   10: ifeq +33 -> 43
    //   13: iload_1
    //   14: ifne +29 -> 43
    //   17: iconst_0
    //   18: putstatic 628	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   25: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: astore 31
    //   30: sipush 65214
    //   33: istore 7
    //   35: aload 31
    //   37: iload 7
    //   39: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   42: return
    //   43: aload_0
    //   44: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   47: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   50: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   53: ldc_w 407
    //   56: iconst_0
    //   57: invokeinterface 298 3 0
    //   62: istore 7
    //   64: iload 7
    //   66: iconst_1
    //   67: if_icmpeq +24 -> 91
    //   70: iload 7
    //   72: iconst_2
    //   73: if_icmpeq +18 -> 91
    //   76: iload 7
    //   78: iconst_4
    //   79: if_icmpne +6 -> 85
    //   82: goto +9 -> 91
    //   85: iconst_0
    //   86: istore 9
    //   88: goto +6 -> 94
    //   91: iconst_1
    //   92: istore 9
    //   94: iload_2
    //   95: ifne +18 -> 113
    //   98: aload_0
    //   99: iload_1
    //   100: iload 9
    //   102: invokevirtual 800	com/tencent/smtt/sdk/ag:a	(ZZ)Z
    //   105: ifeq +8 -> 113
    //   108: iconst_0
    //   109: putstatic 628	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   112: return
    //   113: aload_0
    //   114: iload_1
    //   115: putfield 802	com/tencent/smtt/sdk/ag:C	Z
    //   118: aload_0
    //   119: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   122: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   125: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   128: astore 32
    //   130: aconst_null
    //   131: astore 31
    //   133: aload_0
    //   134: aload 32
    //   136: ldc_w 804
    //   139: aconst_null
    //   140: invokeinterface 475 3 0
    //   145: putfield 806	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   148: aload_0
    //   149: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   152: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   155: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   158: ldc_w 808
    //   161: aconst_null
    //   162: invokeinterface 475 3 0
    //   167: astore 32
    //   169: new 105	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   176: astore 33
    //   178: aload 33
    //   180: ldc_w 810
    //   183: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 33
    //   189: aload 32
    //   191: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc -58
    //   197: aload 33
    //   199: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: iconst_1
    //   203: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   211: aload_0
    //   212: iconst_0
    //   213: putfield 80	com/tencent/smtt/sdk/ag:c	I
    //   216: iload_1
    //   217: ifne +36 -> 253
    //   220: aload 32
    //   222: ifnull +31 -> 253
    //   225: ldc -4
    //   227: aload 32
    //   229: invokevirtual 816	java/lang/String:trim	()Ljava/lang/String;
    //   232: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifne +18 -> 253
    //   238: aload_0
    //   239: aload 32
    //   241: invokevirtual 816	java/lang/String:trim	()Ljava/lang/String;
    //   244: ldc_w 818
    //   247: invokevirtual 822	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   250: putfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   253: new 105	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   260: astore 33
    //   262: aload 33
    //   264: ldc_w 824
    //   267: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 33
    //   273: aload_0
    //   274: getfield 806	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   277: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 33
    //   283: ldc_w 826
    //   286: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 33
    //   292: aload 32
    //   294: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 33
    //   300: ldc_w 828
    //   303: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 33
    //   309: aload_0
    //   310: getfield 559	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   313: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 33
    //   319: ldc_w 830
    //   322: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 33
    //   328: aload_0
    //   329: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   332: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 33
    //   338: ldc_w 832
    //   341: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 33
    //   347: aload_0
    //   348: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   351: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: ldc -58
    //   357: aload 33
    //   359: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: getfield 806	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   369: ifnonnull +37 -> 406
    //   372: aload_0
    //   373: getfield 559	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   376: ifnonnull +30 -> 406
    //   379: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   382: bipush 110
    //   384: invokeinterface 405 2 0
    //   389: aload_0
    //   390: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   393: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   396: astore 31
    //   398: sipush 65234
    //   401: istore 7
    //   403: goto -368 -> 35
    //   406: aload_0
    //   407: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   410: ifnull +37 -> 447
    //   413: aload_0
    //   414: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   417: ifne +30 -> 447
    //   420: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   423: bipush 110
    //   425: invokeinterface 405 2 0
    //   430: aload_0
    //   431: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   434: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   437: astore 31
    //   439: sipush 65233
    //   442: istore 7
    //   444: goto -409 -> 35
    //   447: sipush 65232
    //   450: istore 7
    //   452: iload_1
    //   453: ifne +52 -> 505
    //   456: aload_0
    //   457: getfield 103	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   460: aload_0
    //   461: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   464: invokestatic 687	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   467: invokeinterface 709 2 0
    //   472: ifeq +33 -> 505
    //   475: ldc -58
    //   477: ldc_w 834
    //   480: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   486: bipush 110
    //   488: invokeinterface 405 2 0
    //   493: aload_0
    //   494: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   497: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   500: astore 31
    //   502: goto -467 -> 35
    //   505: aload_0
    //   506: invokespecial 133	com/tencent/smtt/sdk/ag:f	()V
    //   509: ldc -58
    //   511: ldc_w 836
    //   514: iconst_1
    //   515: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   518: aload_0
    //   519: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   522: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   525: invokevirtual 839	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   528: lstore 15
    //   530: aload_0
    //   531: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   534: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   537: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   540: astore 32
    //   542: lconst_0
    //   543: lstore 19
    //   545: aload 32
    //   547: ldc_w 841
    //   550: lconst_0
    //   551: invokeinterface 492 4 0
    //   556: lstore 17
    //   558: iload_1
    //   559: ifeq +17 -> 576
    //   562: getstatic 843	com/tencent/smtt/sdk/ag:e	I
    //   565: istore 7
    //   567: aload_0
    //   568: iload 7
    //   570: putfield 76	com/tencent/smtt/sdk/ag:B	I
    //   573: goto +11 -> 584
    //   576: getstatic 74	com/tencent/smtt/sdk/ag:d	I
    //   579: istore 7
    //   581: goto -14 -> 567
    //   584: iconst_0
    //   585: istore 11
    //   587: aload_0
    //   588: getfield 255	com/tencent/smtt/sdk/ag:p	I
    //   591: aload_0
    //   592: getfield 76	com/tencent/smtt/sdk/ag:B	I
    //   595: if_icmple +16 -> 611
    //   598: iload 11
    //   600: istore_1
    //   601: iload 9
    //   603: istore 11
    //   605: iload_1
    //   606: istore 9
    //   608: goto +5347 -> 5955
    //   611: aload_0
    //   612: getfield 553	com/tencent/smtt/sdk/ag:q	I
    //   615: bipush 8
    //   617: if_icmple +28 -> 645
    //   620: aload_0
    //   621: bipush 123
    //   623: aload 31
    //   625: iconst_1
    //   626: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   629: aload_0
    //   630: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   633: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   636: sipush 65230
    //   639: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   642: goto -44 -> 598
    //   645: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   648: lstore 27
    //   650: lload 17
    //   652: lstore 13
    //   654: iload_1
    //   655: ifne +429 -> 1084
    //   658: lload 17
    //   660: lstore 21
    //   662: lload 17
    //   664: lstore 23
    //   666: lload 27
    //   668: aload_0
    //   669: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   672: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   675: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   678: ldc_w 845
    //   681: lload 19
    //   683: invokeinterface 492 4 0
    //   688: lsub
    //   689: ldc2_w 846
    //   692: lcmp
    //   693: ifle +104 -> 797
    //   696: lload 17
    //   698: lstore 21
    //   700: lload 17
    //   702: lstore 23
    //   704: ldc -58
    //   706: ldc_w 849
    //   709: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: lload 17
    //   714: lstore 21
    //   716: lload 17
    //   718: lstore 23
    //   720: aload_0
    //   721: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   724: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   727: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   730: ldc_w 845
    //   733: lload 27
    //   735: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   738: invokeinterface 383 3 0
    //   743: pop
    //   744: lload 17
    //   746: lstore 21
    //   748: lload 17
    //   750: lstore 23
    //   752: aload_0
    //   753: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   756: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   759: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   762: ldc_w 841
    //   765: lload 19
    //   767: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   770: invokeinterface 383 3 0
    //   775: pop
    //   776: lload 17
    //   778: lstore 21
    //   780: lload 17
    //   782: lstore 23
    //   784: aload_0
    //   785: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   788: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   791: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   794: goto +178 -> 972
    //   797: lload 17
    //   799: lstore 21
    //   801: lload 17
    //   803: lstore 23
    //   805: new 105	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   812: astore 31
    //   814: lload 17
    //   816: lstore 21
    //   818: lload 17
    //   820: lstore 23
    //   822: aload 31
    //   824: ldc_w 856
    //   827: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: lload 17
    //   833: lstore 21
    //   835: lload 17
    //   837: lstore 23
    //   839: aload 31
    //   841: lload 17
    //   843: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: lload 17
    //   849: lstore 21
    //   851: lload 17
    //   853: lstore 23
    //   855: ldc -58
    //   857: aload 31
    //   859: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   865: lload 17
    //   867: lstore 19
    //   869: lload 17
    //   871: lload 15
    //   873: lcmp
    //   874: iflt +98 -> 972
    //   877: lload 17
    //   879: lstore 21
    //   881: lload 17
    //   883: lstore 23
    //   885: ldc -58
    //   887: ldc_w 858
    //   890: iconst_1
    //   891: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   894: lload 17
    //   896: lstore 21
    //   898: lload 17
    //   900: lstore 23
    //   902: aload_0
    //   903: bipush 112
    //   905: aconst_null
    //   906: iconst_1
    //   907: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   910: lload 17
    //   912: lstore 21
    //   914: lload 17
    //   916: lstore 23
    //   918: aload_0
    //   919: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   922: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   925: sipush 65229
    //   928: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   931: iload_1
    //   932: ifne -334 -> 598
    //   935: aload_0
    //   936: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   939: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   942: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   945: ldc_w 841
    //   948: lload 17
    //   950: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   953: invokeinterface 383 3 0
    //   958: pop
    //   959: aload_0
    //   960: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   963: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   966: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   969: goto -371 -> 598
    //   972: lload 19
    //   974: lstore 21
    //   976: lload 19
    //   978: lstore 23
    //   980: lload 19
    //   982: lstore 13
    //   984: aload_0
    //   985: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   988: invokestatic 860	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   991: ifne +93 -> 1084
    //   994: lload 19
    //   996: lstore 21
    //   998: lload 19
    //   1000: lstore 23
    //   1002: ldc -58
    //   1004: ldc_w 862
    //   1007: iconst_1
    //   1008: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1011: lload 19
    //   1013: lstore 21
    //   1015: lload 19
    //   1017: lstore 23
    //   1019: aload_0
    //   1020: bipush 105
    //   1022: aconst_null
    //   1023: iconst_1
    //   1024: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   1027: lload 19
    //   1029: lstore 21
    //   1031: lload 19
    //   1033: lstore 23
    //   1035: aload_0
    //   1036: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1039: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1042: sipush 65228
    //   1045: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1048: iload_1
    //   1049: ifne -451 -> 598
    //   1052: lload 19
    //   1054: lstore 17
    //   1056: goto -121 -> 935
    //   1059: astore 31
    //   1061: lload 21
    //   1063: lstore 17
    //   1065: goto +5288 -> 6353
    //   1068: astore 31
    //   1070: lload 23
    //   1072: lstore 13
    //   1074: iload 11
    //   1076: istore_2
    //   1077: iload 9
    //   1079: istore 12
    //   1081: goto +4657 -> 5738
    //   1084: lload 13
    //   1086: lstore 21
    //   1088: aload_0
    //   1089: iconst_1
    //   1090: putfield 567	com/tencent/smtt/sdk/ag:y	Z
    //   1093: lload 13
    //   1095: lstore 21
    //   1097: aload_0
    //   1098: getfield 559	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   1101: astore 31
    //   1103: aload 31
    //   1105: ifnull +20 -> 1125
    //   1108: lload 13
    //   1110: lstore 21
    //   1112: lload 13
    //   1114: lstore 23
    //   1116: aload_0
    //   1117: getfield 559	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   1120: astore 31
    //   1122: goto +13 -> 1135
    //   1125: lload 13
    //   1127: lstore 21
    //   1129: aload_0
    //   1130: getfield 806	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   1133: astore 31
    //   1135: lload 13
    //   1137: lstore 21
    //   1139: new 105	java/lang/StringBuilder
    //   1142: dup
    //   1143: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1146: astore 32
    //   1148: lload 13
    //   1150: lstore 21
    //   1152: aload 32
    //   1154: ldc_w 864
    //   1157: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: lload 13
    //   1163: lstore 21
    //   1165: aload 32
    //   1167: aload 31
    //   1169: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: pop
    //   1173: lload 13
    //   1175: lstore 21
    //   1177: aload 32
    //   1179: ldc_w 866
    //   1182: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: lload 13
    //   1188: lstore 21
    //   1190: aload 32
    //   1192: aload_0
    //   1193: getfield 255	com/tencent/smtt/sdk/ag:p	I
    //   1196: invokevirtual 515	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1199: pop
    //   1200: lload 13
    //   1202: lstore 21
    //   1204: ldc -58
    //   1206: aload 32
    //   1208: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: iconst_1
    //   1212: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1215: lload 13
    //   1217: lstore 21
    //   1219: aload 31
    //   1221: aload_0
    //   1222: getfield 868	com/tencent/smtt/sdk/ag:i	Ljava/lang/String;
    //   1225: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1228: istore_2
    //   1229: iload_2
    //   1230: ifne +20 -> 1250
    //   1233: lload 13
    //   1235: lstore 21
    //   1237: lload 13
    //   1239: lstore 23
    //   1241: aload_0
    //   1242: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1245: aload 31
    //   1247: invokevirtual 871	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1250: lload 13
    //   1252: lstore 21
    //   1254: aload_0
    //   1255: aload 31
    //   1257: putfield 868	com/tencent/smtt/sdk/ag:i	Ljava/lang/String;
    //   1260: lload 13
    //   1262: lstore 21
    //   1264: aload_0
    //   1265: aload 31
    //   1267: invokespecial 873	com/tencent/smtt/sdk/ag:a	(Ljava/lang/String;)V
    //   1270: lload 13
    //   1272: lstore 21
    //   1274: aload_0
    //   1275: getfield 561	com/tencent/smtt/sdk/ag:o	Z
    //   1278: istore_2
    //   1279: iload_2
    //   1280: ifne +417 -> 1697
    //   1283: lload 13
    //   1285: lstore 21
    //   1287: aload_0
    //   1288: invokespecial 875	com/tencent/smtt/sdk/ag:k	()J
    //   1291: lstore 17
    //   1293: lload 13
    //   1295: lstore 21
    //   1297: new 105	java/lang/StringBuilder
    //   1300: dup
    //   1301: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1304: astore 31
    //   1306: lload 13
    //   1308: lstore 21
    //   1310: aload 31
    //   1312: ldc_w 877
    //   1315: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: lload 13
    //   1321: lstore 21
    //   1323: aload 31
    //   1325: lload 17
    //   1327: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1330: pop
    //   1331: lload 13
    //   1333: lstore 21
    //   1335: ldc -58
    //   1337: aload 31
    //   1339: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1342: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1345: lload 13
    //   1347: lstore 21
    //   1349: aload_0
    //   1350: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   1353: lstore 19
    //   1355: lload 19
    //   1357: lconst_0
    //   1358: lcmp
    //   1359: ifgt +142 -> 1501
    //   1362: lload 13
    //   1364: lstore 21
    //   1366: new 105	java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1373: astore 31
    //   1375: lload 13
    //   1377: lstore 21
    //   1379: aload 31
    //   1381: ldc_w 879
    //   1384: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: lload 13
    //   1390: lstore 21
    //   1392: aload 31
    //   1394: lload 17
    //   1396: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: lload 13
    //   1402: lstore 21
    //   1404: ldc -58
    //   1406: aload 31
    //   1408: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1411: iconst_1
    //   1412: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1415: lload 13
    //   1417: lstore 21
    //   1419: aload_0
    //   1420: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   1423: astore 31
    //   1425: lload 13
    //   1427: lstore 21
    //   1429: new 105	java/lang/StringBuilder
    //   1432: dup
    //   1433: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1436: astore 32
    //   1438: lload 13
    //   1440: lstore 21
    //   1442: aload 32
    //   1444: ldc_w 881
    //   1447: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: lload 13
    //   1453: lstore 21
    //   1455: aload 32
    //   1457: lload 17
    //   1459: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1462: pop
    //   1463: lload 13
    //   1465: lstore 21
    //   1467: aload 32
    //   1469: ldc_w 883
    //   1472: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: pop
    //   1476: lload 13
    //   1478: lstore 21
    //   1480: aload 31
    //   1482: ldc_w 885
    //   1485: aload 32
    //   1487: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1490: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1493: goto +207 -> 1700
    //   1496: astore 31
    //   1498: goto +180 -> 1678
    //   1501: lload 13
    //   1503: lstore 21
    //   1505: new 105	java/lang/StringBuilder
    //   1508: dup
    //   1509: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1512: astore 31
    //   1514: lload 13
    //   1516: lstore 21
    //   1518: aload 31
    //   1520: ldc_w 887
    //   1523: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: pop
    //   1527: lload 13
    //   1529: lstore 21
    //   1531: aload 31
    //   1533: lload 17
    //   1535: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1538: pop
    //   1539: lload 13
    //   1541: lstore 21
    //   1543: aload 31
    //   1545: ldc_w 889
    //   1548: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: lload 13
    //   1554: lstore 21
    //   1556: aload 31
    //   1558: aload_0
    //   1559: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   1562: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1565: pop
    //   1566: lload 13
    //   1568: lstore 21
    //   1570: ldc -58
    //   1572: aload 31
    //   1574: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1577: iconst_1
    //   1578: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1581: lload 13
    //   1583: lstore 21
    //   1585: aload_0
    //   1586: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   1589: astore 31
    //   1591: lload 13
    //   1593: lstore 21
    //   1595: new 105	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1602: astore 32
    //   1604: lload 13
    //   1606: lstore 21
    //   1608: aload 32
    //   1610: ldc_w 881
    //   1613: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1616: pop
    //   1617: lload 13
    //   1619: lstore 21
    //   1621: aload 32
    //   1623: lload 17
    //   1625: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1628: pop
    //   1629: lload 13
    //   1631: lstore 21
    //   1633: aload 32
    //   1635: ldc_w 883
    //   1638: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1641: pop
    //   1642: lload 13
    //   1644: lstore 21
    //   1646: aload 32
    //   1648: aload_0
    //   1649: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   1652: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1655: pop
    //   1656: lload 13
    //   1658: lstore 21
    //   1660: aload 31
    //   1662: ldc_w 885
    //   1665: aload 32
    //   1667: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1670: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1673: goto +27 -> 1700
    //   1676: astore 31
    //   1678: iload 9
    //   1680: istore 12
    //   1682: goto +9 -> 1691
    //   1685: astore 31
    //   1687: iload 9
    //   1689: istore 12
    //   1691: iload 11
    //   1693: istore_2
    //   1694: goto +4044 -> 5738
    //   1697: lconst_0
    //   1698: lstore 17
    //   1700: iload 11
    //   1702: istore_2
    //   1703: iload 9
    //   1705: istore 10
    //   1707: lload 13
    //   1709: lstore 21
    //   1711: aload_0
    //   1712: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1715: astore 31
    //   1717: lload 17
    //   1719: lconst_0
    //   1720: lcmp
    //   1721: ifne +4673 -> 6394
    //   1724: iconst_0
    //   1725: istore 7
    //   1727: goto +3 -> 1730
    //   1730: lload 13
    //   1732: lstore 21
    //   1734: aload 31
    //   1736: iload 7
    //   1738: invokevirtual 892	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1741: lload 13
    //   1743: lstore 21
    //   1745: aload_0
    //   1746: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1749: invokestatic 594	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1752: istore 7
    //   1754: lload 13
    //   1756: lstore 21
    //   1758: aload_0
    //   1759: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1762: invokestatic 590	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1765: astore 31
    //   1767: lload 13
    //   1769: lstore 21
    //   1771: aload_0
    //   1772: getfield 135	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   1775: astore 32
    //   1777: aload 32
    //   1779: ifnonnull +43 -> 1822
    //   1782: lload 13
    //   1784: lstore 21
    //   1786: aload_0
    //   1787: getfield 137	com/tencent/smtt/sdk/ag:x	I
    //   1790: iconst_m1
    //   1791: if_icmpne +31 -> 1822
    //   1794: lload 13
    //   1796: lstore 21
    //   1798: aload_0
    //   1799: aload 31
    //   1801: putfield 135	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   1804: lload 13
    //   1806: lstore 21
    //   1808: aload_0
    //   1809: iload 7
    //   1811: putfield 137	com/tencent/smtt/sdk/ag:x	I
    //   1814: goto +77 -> 1891
    //   1817: astore 31
    //   1819: goto -141 -> 1678
    //   1822: lload 13
    //   1824: lstore 21
    //   1826: aload_0
    //   1827: getfield 137	com/tencent/smtt/sdk/ag:x	I
    //   1830: istore 8
    //   1832: iload 7
    //   1834: iload 8
    //   1836: if_icmpne +23 -> 1859
    //   1839: lload 13
    //   1841: lstore 21
    //   1843: aload 31
    //   1845: aload_0
    //   1846: getfield 135	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   1849: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1852: istore 12
    //   1854: iload 12
    //   1856: ifne +35 -> 1891
    //   1859: lload 13
    //   1861: lstore 21
    //   1863: aload_0
    //   1864: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1867: iconst_0
    //   1868: invokevirtual 603	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   1871: lload 13
    //   1873: lstore 21
    //   1875: aload_0
    //   1876: aload 31
    //   1878: putfield 135	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   1881: lload 13
    //   1883: lstore 21
    //   1885: aload_0
    //   1886: iload 7
    //   1888: putfield 137	com/tencent/smtt/sdk/ag:x	I
    //   1891: lload 13
    //   1893: lstore 21
    //   1895: aload_0
    //   1896: getfield 255	com/tencent/smtt/sdk/ag:p	I
    //   1899: istore 7
    //   1901: iload 7
    //   1903: iconst_1
    //   1904: if_icmplt +21 -> 1925
    //   1907: lload 13
    //   1909: lstore 21
    //   1911: aload_0
    //   1912: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   1915: ldc_w 894
    //   1918: aload_0
    //   1919: getfield 806	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   1922: invokevirtual 897	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1925: lload 13
    //   1927: lstore 21
    //   1929: aload_0
    //   1930: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   1933: invokevirtual 698	java/net/HttpURLConnection:getResponseCode	()I
    //   1936: istore 7
    //   1938: lload 13
    //   1940: lstore 21
    //   1942: new 105	java/lang/StringBuilder
    //   1945: dup
    //   1946: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1949: astore 31
    //   1951: lload 13
    //   1953: lstore 21
    //   1955: aload 31
    //   1957: ldc_w 899
    //   1960: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: pop
    //   1964: lload 13
    //   1966: lstore 21
    //   1968: aload 31
    //   1970: iload 7
    //   1972: invokevirtual 515	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1975: pop
    //   1976: lload 13
    //   1978: lstore 21
    //   1980: ldc -58
    //   1982: aload 31
    //   1984: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1987: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1990: lload 13
    //   1992: lstore 21
    //   1994: aload_0
    //   1995: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1998: iload 7
    //   2000: invokevirtual 902	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   2003: iload_1
    //   2004: ifne +101 -> 2105
    //   2007: lload 13
    //   2009: lstore 21
    //   2011: aload_0
    //   2012: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2015: invokestatic 211	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   2018: ifne +87 -> 2105
    //   2021: lload 13
    //   2023: lstore 21
    //   2025: aload_0
    //   2026: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2029: invokestatic 594	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2032: iconst_3
    //   2033: if_icmpeq +13 -> 2046
    //   2036: lload 13
    //   2038: lstore 21
    //   2040: invokestatic 763	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2043: ifeq +17 -> 2060
    //   2046: lload 13
    //   2048: lstore 21
    //   2050: aload_0
    //   2051: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2054: invokestatic 594	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2057: ifne +48 -> 2105
    //   2060: lload 13
    //   2062: lstore 21
    //   2064: aload_0
    //   2065: invokevirtual 904	com/tencent/smtt/sdk/ag:c	()V
    //   2068: lload 13
    //   2070: lstore 21
    //   2072: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2075: ifnull +17 -> 2092
    //   2078: lload 13
    //   2080: lstore 21
    //   2082: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2085: bipush 111
    //   2087: invokeinterface 405 2 0
    //   2092: lload 13
    //   2094: lstore 21
    //   2096: ldc -58
    //   2098: ldc_w 906
    //   2101: iconst_0
    //   2102: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2105: lload 13
    //   2107: lstore 21
    //   2109: aload_0
    //   2110: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   2113: istore 12
    //   2115: iload 12
    //   2117: ifeq +68 -> 2185
    //   2120: lload 13
    //   2122: lstore 21
    //   2124: aload_0
    //   2125: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2128: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2131: sipush 65227
    //   2134: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2137: iload_1
    //   2138: ifne +37 -> 2175
    //   2141: aload_0
    //   2142: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2145: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2148: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2151: ldc_w 841
    //   2154: lload 13
    //   2156: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2159: invokeinterface 383 3 0
    //   2164: pop
    //   2165: aload_0
    //   2166: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2169: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2172: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2175: iload 10
    //   2177: istore 11
    //   2179: iload_2
    //   2180: istore 9
    //   2182: goto +3773 -> 5955
    //   2185: iload 7
    //   2187: sipush 200
    //   2190: if_icmpeq +751 -> 2941
    //   2193: iload 7
    //   2195: sipush 206
    //   2198: if_icmpne +6 -> 2204
    //   2201: goto +740 -> 2941
    //   2204: iload 7
    //   2206: sipush 300
    //   2209: if_icmplt +140 -> 2349
    //   2212: iload 7
    //   2214: sipush 307
    //   2217: if_icmpgt +132 -> 2349
    //   2220: lload 13
    //   2222: lstore 21
    //   2224: aload_0
    //   2225: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   2228: ldc_w 908
    //   2231: invokevirtual 912	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2234: astore 31
    //   2236: lload 13
    //   2238: lstore 21
    //   2240: aload 31
    //   2242: invokestatic 705	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2245: ifne +68 -> 2313
    //   2248: lload 13
    //   2250: lstore 21
    //   2252: aload_0
    //   2253: aload 31
    //   2255: putfield 559	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   2258: lload 13
    //   2260: lstore 21
    //   2262: aload_0
    //   2263: aload_0
    //   2264: getfield 553	com/tencent/smtt/sdk/ag:q	I
    //   2267: iconst_1
    //   2268: iadd
    //   2269: putfield 553	com/tencent/smtt/sdk/ag:q	I
    //   2272: iload_1
    //   2273: ifne +37 -> 2310
    //   2276: aload_0
    //   2277: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2280: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2283: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2286: ldc_w 841
    //   2289: lload 13
    //   2291: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2294: invokeinterface 383 3 0
    //   2299: pop
    //   2300: aload_0
    //   2301: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2304: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2307: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2310: goto +4104 -> 6414
    //   2313: lload 13
    //   2315: lstore 21
    //   2317: aload_0
    //   2318: bipush 124
    //   2320: aconst_null
    //   2321: iconst_1
    //   2322: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   2325: lload 13
    //   2327: lstore 21
    //   2329: aload_0
    //   2330: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2333: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2336: sipush 65224
    //   2339: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2342: iload_1
    //   2343: ifne -168 -> 2175
    //   2346: goto -205 -> 2141
    //   2349: lload 13
    //   2351: lstore 21
    //   2353: aload_0
    //   2354: bipush 102
    //   2356: iload 7
    //   2358: invokestatic 915	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2361: iconst_0
    //   2362: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   2365: iload 7
    //   2367: sipush 416
    //   2370: if_icmpne +184 -> 2554
    //   2373: iload 10
    //   2375: istore 12
    //   2377: lload 13
    //   2379: lstore 21
    //   2381: aload_0
    //   2382: iconst_1
    //   2383: iload 12
    //   2385: invokespecial 791	com/tencent/smtt/sdk/ag:c	(ZZ)Z
    //   2388: istore 9
    //   2390: iload 9
    //   2392: ifeq +75 -> 2467
    //   2395: lload 13
    //   2397: lstore 21
    //   2399: aload_0
    //   2400: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2403: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2406: sipush 65322
    //   2409: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2412: iload_1
    //   2413: ifne +37 -> 2450
    //   2416: aload_0
    //   2417: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2420: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2423: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2426: ldc_w 841
    //   2429: lload 13
    //   2431: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2434: invokeinterface 383 3 0
    //   2439: pop
    //   2440: aload_0
    //   2441: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2444: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2447: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2450: iconst_1
    //   2451: istore 9
    //   2453: iload 12
    //   2455: istore 11
    //   2457: goto +3498 -> 5955
    //   2460: astore 31
    //   2462: iconst_1
    //   2463: istore_2
    //   2464: goto +3274 -> 5738
    //   2467: lload 13
    //   2469: lstore 21
    //   2471: aload_0
    //   2472: iconst_0
    //   2473: invokespecial 793	com/tencent/smtt/sdk/ag:c	(Z)Z
    //   2476: pop
    //   2477: lload 13
    //   2479: lstore 21
    //   2481: aload_0
    //   2482: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2485: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2488: sipush 65223
    //   2491: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2494: iload 12
    //   2496: istore 11
    //   2498: iload_2
    //   2499: istore 9
    //   2501: iload_1
    //   2502: ifne +3453 -> 5955
    //   2505: aload_0
    //   2506: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2509: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2512: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2515: ldc_w 841
    //   2518: lload 13
    //   2520: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2523: invokeinterface 383 3 0
    //   2528: pop
    //   2529: iload 10
    //   2531: istore 11
    //   2533: aload_0
    //   2534: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2537: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2540: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2543: iload_2
    //   2544: istore 9
    //   2546: goto +3409 -> 5955
    //   2549: astore 31
    //   2551: goto +383 -> 2934
    //   2554: iload 10
    //   2556: istore 9
    //   2558: iload 7
    //   2560: sipush 403
    //   2563: if_icmpeq +11 -> 2574
    //   2566: iload 7
    //   2568: sipush 406
    //   2571: if_icmpne +49 -> 2620
    //   2574: lload 13
    //   2576: lstore 21
    //   2578: aload_0
    //   2579: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   2582: ldc2_w 554
    //   2585: lcmp
    //   2586: ifne +34 -> 2620
    //   2589: lload 13
    //   2591: lstore 21
    //   2593: aload_0
    //   2594: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2597: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2600: sipush 65222
    //   2603: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2606: iload 9
    //   2608: istore 11
    //   2610: iload_2
    //   2611: istore 9
    //   2613: iload_1
    //   2614: ifne +3341 -> 5955
    //   2617: goto -112 -> 2505
    //   2620: iload 7
    //   2622: sipush 202
    //   2625: if_icmpne +44 -> 2669
    //   2628: iload_1
    //   2629: ifne +3785 -> 6414
    //   2632: aload_0
    //   2633: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2636: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2639: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2642: ldc_w 841
    //   2645: lload 13
    //   2647: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2650: invokeinterface 383 3 0
    //   2655: pop
    //   2656: aload_0
    //   2657: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2660: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2663: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2666: goto +3748 -> 6414
    //   2669: lload 13
    //   2671: lstore 21
    //   2673: aload_0
    //   2674: getfield 255	com/tencent/smtt/sdk/ag:p	I
    //   2677: aload_0
    //   2678: getfield 76	com/tencent/smtt/sdk/ag:B	I
    //   2681: if_icmpge +74 -> 2755
    //   2684: iload 7
    //   2686: sipush 503
    //   2689: if_icmpne +66 -> 2755
    //   2692: lload 13
    //   2694: lstore 21
    //   2696: aload_0
    //   2697: aload_0
    //   2698: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   2701: ldc_w 917
    //   2704: invokevirtual 912	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2707: invokestatic 921	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2710: invokespecial 923	com/tencent/smtt/sdk/ag:a	(J)V
    //   2713: lload 13
    //   2715: lstore 21
    //   2717: aload_0
    //   2718: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   2721: ifeq +3679 -> 6400
    //   2724: lload 13
    //   2726: lstore 21
    //   2728: aload_0
    //   2729: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2732: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2735: sipush 65227
    //   2738: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2741: iload 9
    //   2743: istore 11
    //   2745: iload_2
    //   2746: istore 9
    //   2748: iload_1
    //   2749: ifne +3206 -> 5955
    //   2752: goto -247 -> 2505
    //   2755: lload 13
    //   2757: lstore 21
    //   2759: aload_0
    //   2760: getfield 255	com/tencent/smtt/sdk/ag:p	I
    //   2763: aload_0
    //   2764: getfield 76	com/tencent/smtt/sdk/ag:B	I
    //   2767: if_icmpge +86 -> 2853
    //   2770: iload 7
    //   2772: sipush 408
    //   2775: if_icmpeq +27 -> 2802
    //   2778: iload 7
    //   2780: sipush 504
    //   2783: if_icmpeq +19 -> 2802
    //   2786: iload 7
    //   2788: sipush 502
    //   2791: if_icmpeq +11 -> 2802
    //   2794: iload 7
    //   2796: sipush 408
    //   2799: if_icmpne +54 -> 2853
    //   2802: lload 13
    //   2804: lstore 21
    //   2806: aload_0
    //   2807: lconst_0
    //   2808: invokespecial 923	com/tencent/smtt/sdk/ag:a	(J)V
    //   2811: lload 13
    //   2813: lstore 21
    //   2815: aload_0
    //   2816: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   2819: ifeq +3588 -> 6407
    //   2822: lload 13
    //   2824: lstore 21
    //   2826: aload_0
    //   2827: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2830: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2833: sipush 65227
    //   2836: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2839: iload 9
    //   2841: istore 11
    //   2843: iload_2
    //   2844: istore 9
    //   2846: iload_1
    //   2847: ifne +3108 -> 5955
    //   2850: goto -233 -> 2617
    //   2853: lload 13
    //   2855: lstore 21
    //   2857: aload_0
    //   2858: invokespecial 875	com/tencent/smtt/sdk/ag:k	()J
    //   2861: lconst_0
    //   2862: lcmp
    //   2863: ifgt +38 -> 2901
    //   2866: lload 13
    //   2868: lstore 21
    //   2870: aload_0
    //   2871: getfield 561	com/tencent/smtt/sdk/ag:o	Z
    //   2874: ifne +27 -> 2901
    //   2877: iload 7
    //   2879: sipush 410
    //   2882: if_icmpeq +19 -> 2901
    //   2885: lload 13
    //   2887: lstore 21
    //   2889: aload_0
    //   2890: iconst_1
    //   2891: putfield 561	com/tencent/smtt/sdk/ag:o	Z
    //   2894: iload_1
    //   2895: ifne +3519 -> 6414
    //   2898: goto -266 -> 2632
    //   2901: lload 13
    //   2903: lstore 21
    //   2905: aload_0
    //   2906: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2909: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2912: sipush 65221
    //   2915: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2918: iload 9
    //   2920: istore 11
    //   2922: iload_2
    //   2923: istore 9
    //   2925: iload_1
    //   2926: ifne +3029 -> 5955
    //   2929: goto -424 -> 2505
    //   2932: astore 31
    //   2934: iload 10
    //   2936: istore 12
    //   2938: goto -1247 -> 1691
    //   2941: iload 10
    //   2943: istore 12
    //   2945: lload 13
    //   2947: lstore 21
    //   2949: aload_0
    //   2950: aload_0
    //   2951: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   2954: invokevirtual 926	java/net/HttpURLConnection:getContentLength	()I
    //   2957: i2l
    //   2958: lload 17
    //   2960: ladd
    //   2961: putfield 557	com/tencent/smtt/sdk/ag:l	J
    //   2964: lload 13
    //   2966: lstore 21
    //   2968: new 105	java/lang/StringBuilder
    //   2971: dup
    //   2972: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2975: astore 31
    //   2977: lload 13
    //   2979: lstore 21
    //   2981: aload 31
    //   2983: ldc_w 928
    //   2986: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2989: pop
    //   2990: lload 13
    //   2992: lstore 21
    //   2994: aload 31
    //   2996: aload_0
    //   2997: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   3000: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3003: pop
    //   3004: lload 13
    //   3006: lstore 21
    //   3008: ldc -58
    //   3010: aload 31
    //   3012: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3015: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3018: lload 13
    //   3020: lstore 21
    //   3022: aload_0
    //   3023: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3026: aload_0
    //   3027: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   3030: invokevirtual 931	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   3033: lload 13
    //   3035: lstore 21
    //   3037: aload_0
    //   3038: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3041: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3044: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3047: ldc_w 488
    //   3050: lconst_0
    //   3051: invokeinterface 492 4 0
    //   3056: lstore 19
    //   3058: lload 19
    //   3060: lconst_0
    //   3061: lcmp
    //   3062: ifeq +312 -> 3374
    //   3065: lload 13
    //   3067: lstore 21
    //   3069: aload_0
    //   3070: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   3073: lload 19
    //   3075: lcmp
    //   3076: ifeq +298 -> 3374
    //   3079: lload 13
    //   3081: lstore 21
    //   3083: new 105	java/lang/StringBuilder
    //   3086: dup
    //   3087: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   3090: astore 31
    //   3092: lload 13
    //   3094: lstore 21
    //   3096: aload 31
    //   3098: ldc_w 933
    //   3101: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3104: pop
    //   3105: lload 13
    //   3107: lstore 21
    //   3109: aload 31
    //   3111: lload 19
    //   3113: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3116: pop
    //   3117: lload 13
    //   3119: lstore 21
    //   3121: aload 31
    //   3123: ldc_w 935
    //   3126: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3129: pop
    //   3130: lload 13
    //   3132: lstore 21
    //   3134: aload 31
    //   3136: aload_0
    //   3137: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   3140: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3143: pop
    //   3144: lload 13
    //   3146: lstore 21
    //   3148: ldc -58
    //   3150: aload 31
    //   3152: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3155: iconst_1
    //   3156: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3159: iload_1
    //   3160: ifne +169 -> 3329
    //   3163: lload 13
    //   3165: lstore 21
    //   3167: aload_0
    //   3168: invokespecial 360	com/tencent/smtt/sdk/ag:n	()Z
    //   3171: ifne +27 -> 3198
    //   3174: lload 13
    //   3176: lstore 21
    //   3178: invokestatic 763	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   3181: ifeq +148 -> 3329
    //   3184: lload 13
    //   3186: lstore 21
    //   3188: aload_0
    //   3189: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3192: invokestatic 609	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3195: ifeq +134 -> 3329
    //   3198: lload 13
    //   3200: lstore 21
    //   3202: aload_0
    //   3203: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   3206: ifnull +22 -> 3228
    //   3209: lload 13
    //   3211: lstore 21
    //   3213: aload_0
    //   3214: iconst_0
    //   3215: invokevirtual 937	com/tencent/smtt/sdk/ag:a	(Z)Z
    //   3218: ifeq +10 -> 3228
    //   3221: iload_1
    //   3222: ifne +3192 -> 6414
    //   3225: goto -593 -> 2632
    //   3228: lload 13
    //   3230: lstore 21
    //   3232: new 105	java/lang/StringBuilder
    //   3235: dup
    //   3236: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   3239: astore 31
    //   3241: lload 13
    //   3243: lstore 21
    //   3245: aload 31
    //   3247: ldc_w 939
    //   3250: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3253: pop
    //   3254: lload 13
    //   3256: lstore 21
    //   3258: aload 31
    //   3260: lload 19
    //   3262: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3265: pop
    //   3266: lload 13
    //   3268: lstore 21
    //   3270: aload 31
    //   3272: ldc_w 935
    //   3275: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3278: pop
    //   3279: lload 13
    //   3281: lstore 21
    //   3283: aload 31
    //   3285: aload_0
    //   3286: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   3289: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3292: pop
    //   3293: lload 13
    //   3295: lstore 21
    //   3297: aload_0
    //   3298: bipush 113
    //   3300: aload 31
    //   3302: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3305: iconst_1
    //   3306: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   3309: lload 13
    //   3311: lstore 21
    //   3313: aload_0
    //   3314: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3317: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3320: sipush 65226
    //   3323: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3326: goto +34 -> 3360
    //   3329: lload 13
    //   3331: lstore 21
    //   3333: aload_0
    //   3334: bipush 101
    //   3336: ldc_w 941
    //   3339: iconst_1
    //   3340: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   3343: lload 13
    //   3345: lstore 21
    //   3347: aload_0
    //   3348: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3351: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3354: sipush 65232
    //   3357: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3360: iload 12
    //   3362: istore 11
    //   3364: iload_2
    //   3365: istore 9
    //   3367: iload_1
    //   3368: ifne +2587 -> 5955
    //   3371: goto -754 -> 2617
    //   3374: lload 13
    //   3376: lstore 21
    //   3378: ldc -58
    //   3380: ldc_w 943
    //   3383: invokestatic 456	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3386: aload_0
    //   3387: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   3390: invokevirtual 695	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3393: astore 32
    //   3395: aload 32
    //   3397: ifnull +1546 -> 4943
    //   3400: aload_0
    //   3401: getfield 318	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   3404: invokevirtual 946	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3407: astore 31
    //   3409: aload 31
    //   3411: ifnull +28 -> 3439
    //   3414: aload 31
    //   3416: ldc_w 948
    //   3419: invokevirtual 671	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3422: ifeq +17 -> 3439
    //   3425: new 950	java/util/zip/GZIPInputStream
    //   3428: dup
    //   3429: aload 32
    //   3431: invokespecial 951	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3434: astore 31
    //   3436: goto +45 -> 3481
    //   3439: aload 31
    //   3441: ifnull +36 -> 3477
    //   3444: aload 31
    //   3446: ldc_w 953
    //   3449: invokevirtual 671	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3452: ifeq +25 -> 3477
    //   3455: new 955	java/util/zip/InflaterInputStream
    //   3458: dup
    //   3459: aload 32
    //   3461: new 957	java/util/zip/Inflater
    //   3464: dup
    //   3465: iconst_1
    //   3466: invokespecial 959	java/util/zip/Inflater:<init>	(Z)V
    //   3469: invokespecial 962	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3472: astore 31
    //   3474: goto +7 -> 3481
    //   3477: aload 32
    //   3479: astore 31
    //   3481: sipush 8192
    //   3484: newarray <illegal type>
    //   3486: astore 34
    //   3488: new 964	java/io/FileOutputStream
    //   3491: dup
    //   3492: new 172	java/io/File
    //   3495: dup
    //   3496: aload_0
    //   3497: getfield 131	com/tencent/smtt/sdk/ag:k	Ljava/io/File;
    //   3500: ldc_w 460
    //   3503: invokespecial 218	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3506: iconst_1
    //   3507: invokespecial 967	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3510: astore 33
    //   3512: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   3515: lstore 19
    //   3517: lload 17
    //   3519: lstore 21
    //   3521: lload 17
    //   3523: lstore 25
    //   3525: lload 19
    //   3527: lstore 17
    //   3529: aload_0
    //   3530: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   3533: istore 9
    //   3535: iload 9
    //   3537: ifeq +129 -> 3666
    //   3540: lload 13
    //   3542: lstore 17
    //   3544: iload_2
    //   3545: istore 9
    //   3547: lload 13
    //   3549: lstore 19
    //   3551: iload_2
    //   3552: istore 10
    //   3554: ldc -58
    //   3556: ldc_w 969
    //   3559: iconst_1
    //   3560: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3563: lload 13
    //   3565: lstore 17
    //   3567: iload_2
    //   3568: istore 9
    //   3570: lload 13
    //   3572: lstore 19
    //   3574: iload_2
    //   3575: istore 10
    //   3577: aload_0
    //   3578: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3581: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3584: astore 34
    //   3586: sipush 65227
    //   3589: istore 7
    //   3591: lload 13
    //   3593: lstore 17
    //   3595: iload_2
    //   3596: istore 9
    //   3598: lload 13
    //   3600: lstore 19
    //   3602: iload_2
    //   3603: istore 10
    //   3605: aload 34
    //   3607: iload 7
    //   3609: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3612: iconst_0
    //   3613: istore 7
    //   3615: goto +1025 -> 4640
    //   3618: astore 34
    //   3620: lload 17
    //   3622: lstore 13
    //   3624: iload 9
    //   3626: istore_2
    //   3627: aload 32
    //   3629: astore 35
    //   3631: aload 34
    //   3633: astore 32
    //   3635: aload 31
    //   3637: astore 34
    //   3639: aload 35
    //   3641: astore 31
    //   3643: goto +2807 -> 6450
    //   3646: astore 35
    //   3648: lload 19
    //   3650: lstore 13
    //   3652: aload 32
    //   3654: astore 34
    //   3656: aload 35
    //   3658: astore 32
    //   3660: iload 10
    //   3662: istore_2
    //   3663: goto +2806 -> 6469
    //   3666: lload 17
    //   3668: lstore 29
    //   3670: aload 31
    //   3672: aload 34
    //   3674: iconst_0
    //   3675: sipush 8192
    //   3678: invokevirtual 975	java/io/InputStream:read	([BII)I
    //   3681: istore 7
    //   3683: iload 7
    //   3685: ifgt +179 -> 3864
    //   3688: lload 13
    //   3690: lstore 17
    //   3692: iload_2
    //   3693: istore 9
    //   3695: lload 13
    //   3697: lstore 19
    //   3699: iload_2
    //   3700: istore 10
    //   3702: aload_0
    //   3703: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   3706: ifnull +86 -> 3792
    //   3709: lload 13
    //   3711: lstore 17
    //   3713: iload_2
    //   3714: istore 9
    //   3716: lload 13
    //   3718: lstore 19
    //   3720: iload_2
    //   3721: istore 10
    //   3723: aload_0
    //   3724: iconst_1
    //   3725: iload 12
    //   3727: invokespecial 791	com/tencent/smtt/sdk/ag:c	(ZZ)Z
    //   3730: ifne +62 -> 3792
    //   3733: iload_1
    //   3734: ifne +31 -> 3765
    //   3737: lload 13
    //   3739: lstore 17
    //   3741: iload_2
    //   3742: istore 9
    //   3744: lload 13
    //   3746: lstore 19
    //   3748: iload_2
    //   3749: istore 10
    //   3751: aload_0
    //   3752: iconst_0
    //   3753: invokevirtual 937	com/tencent/smtt/sdk/ag:a	(Z)Z
    //   3756: ifeq +9 -> 3765
    //   3759: iconst_1
    //   3760: istore 7
    //   3762: goto -147 -> 3615
    //   3765: lload 13
    //   3767: lstore 17
    //   3769: iload_2
    //   3770: istore 9
    //   3772: lload 13
    //   3774: lstore 19
    //   3776: iload_2
    //   3777: istore 10
    //   3779: aload_0
    //   3780: iconst_1
    //   3781: putfield 565	com/tencent/smtt/sdk/ag:s	Z
    //   3784: iconst_0
    //   3785: istore 7
    //   3787: iconst_0
    //   3788: istore_2
    //   3789: goto +851 -> 4640
    //   3792: lload 13
    //   3794: lstore 17
    //   3796: iload_2
    //   3797: istore 9
    //   3799: lload 13
    //   3801: lstore 19
    //   3803: iload_2
    //   3804: istore 10
    //   3806: aload_0
    //   3807: iconst_1
    //   3808: putfield 565	com/tencent/smtt/sdk/ag:s	Z
    //   3811: lload 13
    //   3813: lstore 17
    //   3815: iload_2
    //   3816: istore 9
    //   3818: lload 13
    //   3820: lstore 19
    //   3822: iload_2
    //   3823: istore 10
    //   3825: aload_0
    //   3826: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   3829: ifnull +5 -> 3834
    //   3832: iconst_1
    //   3833: istore_2
    //   3834: lload 13
    //   3836: lstore 17
    //   3838: iload_2
    //   3839: istore 9
    //   3841: lload 13
    //   3843: lstore 19
    //   3845: iload_2
    //   3846: istore 10
    //   3848: aload_0
    //   3849: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3852: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3855: sipush 65225
    //   3858: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3861: goto -249 -> 3612
    //   3864: aload 33
    //   3866: aload 34
    //   3868: iconst_0
    //   3869: iload 7
    //   3871: invokevirtual 979	java/io/FileOutputStream:write	([BII)V
    //   3874: aload 33
    //   3876: invokevirtual 982	java/io/FileOutputStream:flush	()V
    //   3879: iload_1
    //   3880: ifne +441 -> 4321
    //   3883: lload 13
    //   3885: iload 7
    //   3887: i2l
    //   3888: ladd
    //   3889: lstore 13
    //   3891: lload 13
    //   3893: lload 15
    //   3895: lcmp
    //   3896: iflt +195 -> 4091
    //   3899: lload 13
    //   3901: lstore 17
    //   3903: iload_2
    //   3904: istore 9
    //   3906: lload 13
    //   3908: lstore 19
    //   3910: iload_2
    //   3911: istore 10
    //   3913: ldc -58
    //   3915: ldc_w 858
    //   3918: iconst_1
    //   3919: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3922: lload 13
    //   3924: lstore 17
    //   3926: iload_2
    //   3927: istore 9
    //   3929: lload 13
    //   3931: lstore 19
    //   3933: iload_2
    //   3934: istore 10
    //   3936: new 105	java/lang/StringBuilder
    //   3939: dup
    //   3940: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   3943: astore 34
    //   3945: lload 13
    //   3947: lstore 17
    //   3949: iload_2
    //   3950: istore 9
    //   3952: lload 13
    //   3954: lstore 19
    //   3956: iload_2
    //   3957: istore 10
    //   3959: aload 34
    //   3961: ldc_w 984
    //   3964: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3967: pop
    //   3968: lload 13
    //   3970: lstore 17
    //   3972: iload_2
    //   3973: istore 9
    //   3975: lload 13
    //   3977: lstore 19
    //   3979: iload_2
    //   3980: istore 10
    //   3982: aload 34
    //   3984: lload 13
    //   3986: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3989: pop
    //   3990: lload 13
    //   3992: lstore 17
    //   3994: iload_2
    //   3995: istore 9
    //   3997: lload 13
    //   3999: lstore 19
    //   4001: iload_2
    //   4002: istore 10
    //   4004: aload 34
    //   4006: ldc_w 986
    //   4009: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4012: pop
    //   4013: lload 13
    //   4015: lstore 17
    //   4017: iload_2
    //   4018: istore 9
    //   4020: lload 13
    //   4022: lstore 19
    //   4024: iload_2
    //   4025: istore 10
    //   4027: aload 34
    //   4029: lload 15
    //   4031: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4034: pop
    //   4035: lload 13
    //   4037: lstore 17
    //   4039: iload_2
    //   4040: istore 9
    //   4042: lload 13
    //   4044: lstore 19
    //   4046: iload_2
    //   4047: istore 10
    //   4049: aload_0
    //   4050: bipush 112
    //   4052: aload 34
    //   4054: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4057: iconst_1
    //   4058: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   4061: lload 13
    //   4063: lstore 17
    //   4065: iload_2
    //   4066: istore 9
    //   4068: lload 13
    //   4070: lstore 19
    //   4072: iload_2
    //   4073: istore 10
    //   4075: aload_0
    //   4076: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4079: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4082: sipush 65229
    //   4085: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4088: goto -476 -> 3612
    //   4091: lload 13
    //   4093: lstore 17
    //   4095: iload_2
    //   4096: istore 9
    //   4098: lload 13
    //   4100: lstore 19
    //   4102: iload_2
    //   4103: istore 10
    //   4105: lload 13
    //   4107: lstore 23
    //   4109: aload_0
    //   4110: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4113: invokestatic 860	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   4116: ifne +209 -> 4325
    //   4119: lload 13
    //   4121: lstore 17
    //   4123: iload_2
    //   4124: istore 9
    //   4126: lload 13
    //   4128: lstore 19
    //   4130: iload_2
    //   4131: istore 10
    //   4133: ldc -58
    //   4135: ldc_w 988
    //   4138: iconst_1
    //   4139: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4142: lload 13
    //   4144: lstore 17
    //   4146: iload_2
    //   4147: istore 9
    //   4149: lload 13
    //   4151: lstore 19
    //   4153: iload_2
    //   4154: istore 10
    //   4156: new 105	java/lang/StringBuilder
    //   4159: dup
    //   4160: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   4163: astore 34
    //   4165: lload 13
    //   4167: lstore 17
    //   4169: iload_2
    //   4170: istore 9
    //   4172: lload 13
    //   4174: lstore 19
    //   4176: iload_2
    //   4177: istore 10
    //   4179: aload 34
    //   4181: ldc_w 990
    //   4184: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4187: pop
    //   4188: lload 13
    //   4190: lstore 17
    //   4192: iload_2
    //   4193: istore 9
    //   4195: lload 13
    //   4197: lstore 19
    //   4199: iload_2
    //   4200: istore 10
    //   4202: aload 34
    //   4204: invokestatic 992	com/tencent/smtt/utils/y:a	()J
    //   4207: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4210: pop
    //   4211: lload 13
    //   4213: lstore 17
    //   4215: iload_2
    //   4216: istore 9
    //   4218: lload 13
    //   4220: lstore 19
    //   4222: iload_2
    //   4223: istore 10
    //   4225: aload 34
    //   4227: ldc_w 994
    //   4230: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4233: pop
    //   4234: lload 13
    //   4236: lstore 17
    //   4238: iload_2
    //   4239: istore 9
    //   4241: lload 13
    //   4243: lstore 19
    //   4245: iload_2
    //   4246: istore 10
    //   4248: aload 34
    //   4250: aload_0
    //   4251: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4254: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4257: invokevirtual 997	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4260: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4263: pop
    //   4264: lload 13
    //   4266: lstore 17
    //   4268: iload_2
    //   4269: istore 9
    //   4271: lload 13
    //   4273: lstore 19
    //   4275: iload_2
    //   4276: istore 10
    //   4278: aload_0
    //   4279: bipush 105
    //   4281: aload 34
    //   4283: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4286: iconst_1
    //   4287: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   4290: lload 13
    //   4292: lstore 17
    //   4294: iload_2
    //   4295: istore 9
    //   4297: lload 13
    //   4299: lstore 19
    //   4301: iload_2
    //   4302: istore 10
    //   4304: aload_0
    //   4305: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4308: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4311: astore 34
    //   4313: sipush 65228
    //   4316: istore 7
    //   4318: goto -727 -> 3591
    //   4321: lload 13
    //   4323: lstore 23
    //   4325: lload 23
    //   4327: lstore 13
    //   4329: iload 7
    //   4331: i2l
    //   4332: lstore 17
    //   4334: aload_0
    //   4335: lload 27
    //   4337: lload 17
    //   4339: invokespecial 999	com/tencent/smtt/sdk/ag:a	(JJ)J
    //   4342: lstore 27
    //   4344: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   4347: lstore 23
    //   4349: lload 25
    //   4351: lload 17
    //   4353: ladd
    //   4354: lstore 19
    //   4356: lload 23
    //   4358: lload 29
    //   4360: lsub
    //   4361: ldc2_w 1000
    //   4364: lcmp
    //   4365: ifle +421 -> 4786
    //   4368: new 105	java/lang/StringBuilder
    //   4371: dup
    //   4372: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   4375: astore 35
    //   4377: aload 35
    //   4379: ldc_w 1003
    //   4382: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4385: pop
    //   4386: aload 35
    //   4388: lload 19
    //   4390: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4393: pop
    //   4394: aload 35
    //   4396: ldc_w 889
    //   4399: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4402: pop
    //   4403: lload 15
    //   4405: lstore 17
    //   4407: aload 35
    //   4409: aload_0
    //   4410: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   4413: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4416: pop
    //   4417: ldc -58
    //   4419: aload 35
    //   4421: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4424: iconst_1
    //   4425: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4428: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4431: astore 35
    //   4433: aload 35
    //   4435: ifnull +91 -> 4526
    //   4438: lload 19
    //   4440: l2d
    //   4441: dstore_3
    //   4442: aload_0
    //   4443: getfield 557	com/tencent/smtt/sdk/ag:l	J
    //   4446: lstore 25
    //   4448: lload 25
    //   4450: l2d
    //   4451: dstore 5
    //   4453: dload_3
    //   4454: invokestatic 1009	java/lang/Double:isNaN	(D)Z
    //   4457: pop
    //   4458: dload 5
    //   4460: invokestatic 1009	java/lang/Double:isNaN	(D)Z
    //   4463: pop
    //   4464: dload_3
    //   4465: dload 5
    //   4467: ddiv
    //   4468: ldc2_w 1010
    //   4471: dmul
    //   4472: d2i
    //   4473: istore 7
    //   4475: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4478: iload 7
    //   4480: invokeinterface 1014 2 0
    //   4485: goto +41 -> 4526
    //   4488: astore 34
    //   4490: aload 32
    //   4492: astore 35
    //   4494: aload 34
    //   4496: astore 32
    //   4498: aload 31
    //   4500: astore 34
    //   4502: lload 17
    //   4504: lstore 15
    //   4506: goto +1112 -> 5618
    //   4509: astore 35
    //   4511: aload 32
    //   4513: astore 34
    //   4515: aload 35
    //   4517: astore 32
    //   4519: lload 17
    //   4521: lstore 15
    //   4523: goto +566 -> 5089
    //   4526: iload_1
    //   4527: ifne +242 -> 4769
    //   4530: lload 19
    //   4532: lload 21
    //   4534: lsub
    //   4535: ldc2_w 1015
    //   4538: lcmp
    //   4539: ifle +230 -> 4769
    //   4542: aload_0
    //   4543: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4546: invokestatic 211	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4549: ifne +213 -> 4762
    //   4552: aload_0
    //   4553: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4556: invokestatic 594	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4559: istore 7
    //   4561: iload 7
    //   4563: iconst_3
    //   4564: if_icmpeq +13 -> 4577
    //   4567: invokestatic 763	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4570: istore 9
    //   4572: iload 9
    //   4574: ifeq +13 -> 4587
    //   4577: aload_0
    //   4578: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4581: invokestatic 594	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4584: ifne +175 -> 4759
    //   4587: aload_0
    //   4588: invokevirtual 904	com/tencent/smtt/sdk/ag:c	()V
    //   4591: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4594: astore 34
    //   4596: aload 34
    //   4598: ifnull +13 -> 4611
    //   4601: getstatic 400	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4604: bipush 111
    //   4606: invokeinterface 405 2 0
    //   4611: ldc -58
    //   4613: ldc_w 1018
    //   4616: iconst_0
    //   4617: invokestatic 813	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4620: aload_0
    //   4621: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4624: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4627: astore 34
    //   4629: aload 34
    //   4631: sipush 65232
    //   4634: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4637: iconst_0
    //   4638: istore 7
    //   4640: iload 7
    //   4642: ifeq +84 -> 4726
    //   4645: iload_2
    //   4646: istore 9
    //   4648: lload 13
    //   4650: lstore 21
    //   4652: lload 15
    //   4654: lstore 19
    //   4656: lload 13
    //   4658: lstore 17
    //   4660: aload_0
    //   4661: aload 33
    //   4663: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4666: iload_2
    //   4667: istore 9
    //   4669: lload 13
    //   4671: lstore 21
    //   4673: lload 15
    //   4675: lstore 19
    //   4677: lload 13
    //   4679: lstore 17
    //   4681: aload_0
    //   4682: aload 31
    //   4684: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4687: iload_2
    //   4688: istore 9
    //   4690: lload 13
    //   4692: lstore 21
    //   4694: lload 15
    //   4696: lstore 19
    //   4698: lload 13
    //   4700: lstore 17
    //   4702: aload_0
    //   4703: aload 32
    //   4705: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4708: iload_2
    //   4709: istore 9
    //   4711: lload 13
    //   4713: lstore 19
    //   4715: lload 15
    //   4717: lstore 17
    //   4719: iload_1
    //   4720: ifne +869 -> 5589
    //   4723: goto +821 -> 5544
    //   4726: goto +223 -> 4949
    //   4729: astore 34
    //   4731: aload 32
    //   4733: astore 35
    //   4735: aload 34
    //   4737: astore 32
    //   4739: aload 31
    //   4741: astore 34
    //   4743: aload 35
    //   4745: astore 31
    //   4747: lload 17
    //   4749: lstore 15
    //   4751: goto +320 -> 5071
    //   4754: astore 34
    //   4756: goto +48 -> 4804
    //   4759: goto +3 -> 4762
    //   4762: lload 19
    //   4764: lstore 21
    //   4766: goto +3 -> 4769
    //   4769: lload 23
    //   4771: lstore 17
    //   4773: goto +17 -> 4790
    //   4776: astore 34
    //   4778: goto -1151 -> 3627
    //   4781: astore 34
    //   4783: goto +21 -> 4804
    //   4786: lload 29
    //   4788: lstore 17
    //   4790: lload 19
    //   4792: lstore 25
    //   4794: goto -1265 -> 3529
    //   4797: astore 34
    //   4799: goto -1172 -> 3627
    //   4802: astore 34
    //   4804: aload 32
    //   4806: astore 35
    //   4808: aload 34
    //   4810: astore 32
    //   4812: aload 35
    //   4814: astore 34
    //   4816: goto +273 -> 5089
    //   4819: astore 34
    //   4821: aload 32
    //   4823: astore 35
    //   4825: aload 34
    //   4827: astore 32
    //   4829: goto +26 -> 4855
    //   4832: astore 35
    //   4834: aload 32
    //   4836: astore 34
    //   4838: aload 35
    //   4840: astore 32
    //   4842: goto +34 -> 4876
    //   4845: astore 34
    //   4847: aload 32
    //   4849: astore 35
    //   4851: aload 34
    //   4853: astore 32
    //   4855: aload 31
    //   4857: astore 34
    //   4859: aload 35
    //   4861: astore 31
    //   4863: goto +208 -> 5071
    //   4866: astore 35
    //   4868: aload 32
    //   4870: astore 34
    //   4872: aload 35
    //   4874: astore 32
    //   4876: goto +213 -> 5089
    //   4879: astore 33
    //   4881: goto +13 -> 4894
    //   4884: astore 33
    //   4886: goto +39 -> 4925
    //   4889: astore 33
    //   4891: aconst_null
    //   4892: astore 31
    //   4894: aload 32
    //   4896: astore 35
    //   4898: aconst_null
    //   4899: astore 36
    //   4901: aload 33
    //   4903: astore 32
    //   4905: aload 31
    //   4907: astore 34
    //   4909: aload 36
    //   4911: astore 33
    //   4913: aload 35
    //   4915: astore 31
    //   4917: goto +154 -> 5071
    //   4920: astore 33
    //   4922: aconst_null
    //   4923: astore 31
    //   4925: aload 32
    //   4927: astore 34
    //   4929: aconst_null
    //   4930: astore 35
    //   4932: aload 33
    //   4934: astore 32
    //   4936: aload 35
    //   4938: astore 33
    //   4940: goto +149 -> 5089
    //   4943: aconst_null
    //   4944: astore 31
    //   4946: aconst_null
    //   4947: astore 33
    //   4949: lload 13
    //   4951: lstore 21
    //   4953: aload_0
    //   4954: aload 33
    //   4956: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4959: lload 13
    //   4961: lstore 21
    //   4963: aload_0
    //   4964: aload 31
    //   4966: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4969: lload 13
    //   4971: lstore 21
    //   4973: aload_0
    //   4974: aload 32
    //   4976: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4979: lload 13
    //   4981: lstore 21
    //   4983: aload_0
    //   4984: getfield 565	com/tencent/smtt/sdk/ag:s	Z
    //   4987: ifne +20 -> 5007
    //   4990: lload 13
    //   4992: lstore 21
    //   4994: aload_0
    //   4995: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4998: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5001: sipush 65217
    //   5004: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5007: iload_1
    //   5008: ifne +37 -> 5045
    //   5011: aload_0
    //   5012: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5015: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5018: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5021: ldc_w 841
    //   5024: lload 13
    //   5026: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5029: invokeinterface 383 3 0
    //   5034: pop
    //   5035: aload_0
    //   5036: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5039: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5042: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5045: iload 12
    //   5047: istore 11
    //   5049: iload_2
    //   5050: istore 9
    //   5052: goto +903 -> 5955
    //   5055: astore 31
    //   5057: goto +681 -> 5738
    //   5060: astore 32
    //   5062: aconst_null
    //   5063: astore 34
    //   5065: aconst_null
    //   5066: astore 33
    //   5068: aconst_null
    //   5069: astore 31
    //   5071: aload 31
    //   5073: astore 35
    //   5075: goto +543 -> 5618
    //   5078: astore 32
    //   5080: aconst_null
    //   5081: astore 31
    //   5083: aconst_null
    //   5084: astore 33
    //   5086: aconst_null
    //   5087: astore 34
    //   5089: aload 32
    //   5091: invokevirtual 1019	java/io/IOException:printStackTrace	()V
    //   5094: aload 32
    //   5096: instanceof 1021
    //   5099: ifne +342 -> 5441
    //   5102: aload 32
    //   5104: instanceof 1023
    //   5107: ifeq +6 -> 5113
    //   5110: goto +331 -> 5441
    //   5113: iload_1
    //   5114: ifne +195 -> 5309
    //   5117: aload_0
    //   5118: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5121: invokestatic 860	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   5124: ifne +185 -> 5309
    //   5127: new 105	java/lang/StringBuilder
    //   5130: dup
    //   5131: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   5134: astore 32
    //   5136: aload 32
    //   5138: ldc_w 990
    //   5141: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5144: pop
    //   5145: aload 32
    //   5147: invokestatic 992	com/tencent/smtt/utils/y:a	()J
    //   5150: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5153: pop
    //   5154: aload 32
    //   5156: ldc_w 994
    //   5159: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5162: pop
    //   5163: aload 32
    //   5165: aload_0
    //   5166: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5169: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5172: invokevirtual 997	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   5175: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5178: pop
    //   5179: aload_0
    //   5180: bipush 105
    //   5182: aload 32
    //   5184: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5187: iconst_1
    //   5188: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5191: aload_0
    //   5192: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5195: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5198: sipush 65228
    //   5201: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5204: iload_2
    //   5205: istore 9
    //   5207: lload 13
    //   5209: lstore 21
    //   5211: lload 15
    //   5213: lstore 19
    //   5215: lload 13
    //   5217: lstore 17
    //   5219: aload_0
    //   5220: aload 33
    //   5222: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5225: iload_2
    //   5226: istore 9
    //   5228: lload 13
    //   5230: lstore 21
    //   5232: lload 15
    //   5234: lstore 19
    //   5236: lload 13
    //   5238: lstore 17
    //   5240: aload_0
    //   5241: aload 31
    //   5243: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5246: iload_2
    //   5247: istore 9
    //   5249: lload 13
    //   5251: lstore 21
    //   5253: lload 15
    //   5255: lstore 19
    //   5257: lload 13
    //   5259: lstore 17
    //   5261: aload_0
    //   5262: aload 34
    //   5264: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5267: iload 12
    //   5269: istore 11
    //   5271: iload_2
    //   5272: istore 9
    //   5274: iload_1
    //   5275: ifne +680 -> 5955
    //   5278: iload 12
    //   5280: istore 11
    //   5282: aload_0
    //   5283: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5286: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5289: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5292: ldc_w 841
    //   5295: lload 13
    //   5297: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5300: invokeinterface 383 3 0
    //   5305: pop
    //   5306: goto -2773 -> 2533
    //   5309: aload_0
    //   5310: lconst_0
    //   5311: invokespecial 923	com/tencent/smtt/sdk/ag:a	(J)V
    //   5314: aload_0
    //   5315: invokespecial 1025	com/tencent/smtt/sdk/ag:j	()Z
    //   5318: ifne +27 -> 5345
    //   5321: bipush 106
    //   5323: istore 7
    //   5325: aload_0
    //   5326: aload 32
    //   5328: invokespecial 543	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5331: astore 32
    //   5333: aload_0
    //   5334: iload 7
    //   5336: aload 32
    //   5338: iconst_0
    //   5339: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5342: goto +18 -> 5360
    //   5345: bipush 104
    //   5347: istore 7
    //   5349: aload_0
    //   5350: aload 32
    //   5352: invokespecial 543	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5355: astore 32
    //   5357: goto -24 -> 5333
    //   5360: iload_2
    //   5361: istore 9
    //   5363: lload 13
    //   5365: lstore 21
    //   5367: lload 15
    //   5369: lstore 19
    //   5371: lload 13
    //   5373: lstore 17
    //   5375: aload_0
    //   5376: aload 33
    //   5378: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5381: iload_2
    //   5382: istore 9
    //   5384: lload 13
    //   5386: lstore 21
    //   5388: lload 15
    //   5390: lstore 19
    //   5392: lload 13
    //   5394: lstore 17
    //   5396: aload_0
    //   5397: aload 31
    //   5399: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5402: iload_2
    //   5403: istore 9
    //   5405: lload 13
    //   5407: lstore 21
    //   5409: lload 15
    //   5411: lstore 19
    //   5413: lload 13
    //   5415: lstore 17
    //   5417: aload_0
    //   5418: aload 34
    //   5420: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5423: iload_2
    //   5424: istore 9
    //   5426: lload 13
    //   5428: lstore 19
    //   5430: lload 15
    //   5432: lstore 17
    //   5434: iload_1
    //   5435: ifne +154 -> 5589
    //   5438: goto +106 -> 5544
    //   5441: aload_0
    //   5442: ldc_w 1026
    //   5445: putfield 70	com/tencent/smtt/sdk/ag:m	I
    //   5448: aload_0
    //   5449: lconst_0
    //   5450: invokespecial 923	com/tencent/smtt/sdk/ag:a	(J)V
    //   5453: aload_0
    //   5454: bipush 103
    //   5456: aload_0
    //   5457: aload 32
    //   5459: invokespecial 543	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5462: iconst_0
    //   5463: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5466: iload_2
    //   5467: istore 9
    //   5469: lload 13
    //   5471: lstore 21
    //   5473: lload 15
    //   5475: lstore 19
    //   5477: lload 13
    //   5479: lstore 17
    //   5481: aload_0
    //   5482: aload 33
    //   5484: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5487: iload_2
    //   5488: istore 9
    //   5490: lload 13
    //   5492: lstore 21
    //   5494: lload 15
    //   5496: lstore 19
    //   5498: lload 13
    //   5500: lstore 17
    //   5502: aload_0
    //   5503: aload 31
    //   5505: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5508: iload_2
    //   5509: istore 9
    //   5511: lload 13
    //   5513: lstore 21
    //   5515: lload 15
    //   5517: lstore 19
    //   5519: lload 13
    //   5521: lstore 17
    //   5523: aload_0
    //   5524: aload 34
    //   5526: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5529: iload_2
    //   5530: istore 9
    //   5532: lload 13
    //   5534: lstore 19
    //   5536: lload 15
    //   5538: lstore 17
    //   5540: iload_1
    //   5541: ifne +48 -> 5589
    //   5544: aload_0
    //   5545: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5548: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5551: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5554: ldc_w 841
    //   5557: lload 13
    //   5559: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5562: invokeinterface 383 3 0
    //   5567: pop
    //   5568: aload_0
    //   5569: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5572: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5575: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5578: lload 15
    //   5580: lstore 17
    //   5582: lload 13
    //   5584: lstore 19
    //   5586: iload_2
    //   5587: istore 9
    //   5589: iload 9
    //   5591: istore 11
    //   5593: lload 19
    //   5595: lstore 13
    //   5597: lload 17
    //   5599: lstore 15
    //   5601: iload 12
    //   5603: istore 9
    //   5605: goto +816 -> 6421
    //   5608: astore 32
    //   5610: aload 34
    //   5612: astore 35
    //   5614: aload 31
    //   5616: astore 34
    //   5618: iload_2
    //   5619: istore 9
    //   5621: lload 13
    //   5623: lstore 21
    //   5625: lload 15
    //   5627: lstore 19
    //   5629: lload 13
    //   5631: lstore 17
    //   5633: aload_0
    //   5634: aload 33
    //   5636: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5639: iload_2
    //   5640: istore 9
    //   5642: lload 13
    //   5644: lstore 21
    //   5646: lload 15
    //   5648: lstore 19
    //   5650: lload 13
    //   5652: lstore 17
    //   5654: aload_0
    //   5655: aload 34
    //   5657: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5660: iload_2
    //   5661: istore 9
    //   5663: lload 13
    //   5665: lstore 21
    //   5667: lload 15
    //   5669: lstore 19
    //   5671: lload 13
    //   5673: lstore 17
    //   5675: aload_0
    //   5676: aload 35
    //   5678: invokespecial 675	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   5681: iload_2
    //   5682: istore 9
    //   5684: lload 13
    //   5686: lstore 21
    //   5688: lload 15
    //   5690: lstore 19
    //   5692: lload 13
    //   5694: lstore 17
    //   5696: aload 32
    //   5698: athrow
    //   5699: astore 31
    //   5701: iload 9
    //   5703: istore_2
    //   5704: lload 21
    //   5706: lstore 13
    //   5708: lload 19
    //   5710: lstore 15
    //   5712: goto +26 -> 5738
    //   5715: astore 31
    //   5717: goto +5 -> 5722
    //   5720: astore 31
    //   5722: iload 10
    //   5724: istore 12
    //   5726: goto +9 -> 5735
    //   5729: astore 31
    //   5731: iload 9
    //   5733: istore 12
    //   5735: iload 11
    //   5737: istore_2
    //   5738: lload 13
    //   5740: lstore 17
    //   5742: aload 31
    //   5744: instanceof 1028
    //   5747: ifeq +127 -> 5874
    //   5750: iload_1
    //   5751: ifne +123 -> 5874
    //   5754: lload 13
    //   5756: lstore 17
    //   5758: aload_0
    //   5759: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   5762: ifnull +112 -> 5874
    //   5765: lload 13
    //   5767: lstore 17
    //   5769: aload_0
    //   5770: iconst_0
    //   5771: invokevirtual 937	com/tencent/smtt/sdk/ag:a	(Z)Z
    //   5774: ifeq +100 -> 5874
    //   5777: lload 13
    //   5779: lstore 17
    //   5781: new 105	java/lang/StringBuilder
    //   5784: dup
    //   5785: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   5788: astore 32
    //   5790: lload 13
    //   5792: lstore 17
    //   5794: aload 32
    //   5796: ldc_w 1030
    //   5799: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5802: pop
    //   5803: lload 13
    //   5805: lstore 17
    //   5807: aload 32
    //   5809: aload_0
    //   5810: getfield 559	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   5813: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5816: pop
    //   5817: lload 13
    //   5819: lstore 17
    //   5821: aload 32
    //   5823: ldc_w 1032
    //   5826: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5829: pop
    //   5830: lload 13
    //   5832: lstore 17
    //   5834: aload 32
    //   5836: aload 31
    //   5838: invokevirtual 326	java/lang/Throwable:toString	()Ljava/lang/String;
    //   5841: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5844: pop
    //   5845: lload 13
    //   5847: lstore 17
    //   5849: ldc -58
    //   5851: aload 32
    //   5853: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5856: invokestatic 203	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5859: lload 13
    //   5861: lstore 17
    //   5863: aload_0
    //   5864: bipush 125
    //   5866: aconst_null
    //   5867: iconst_1
    //   5868: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5871: goto +402 -> 6273
    //   5874: lload 13
    //   5876: lstore 17
    //   5878: aload 31
    //   5880: invokevirtual 676	java/lang/Throwable:printStackTrace	()V
    //   5883: lload 13
    //   5885: lstore 17
    //   5887: aload_0
    //   5888: lconst_0
    //   5889: invokespecial 923	com/tencent/smtt/sdk/ag:a	(J)V
    //   5892: lload 13
    //   5894: lstore 17
    //   5896: aload_0
    //   5897: bipush 107
    //   5899: aload_0
    //   5900: aload 31
    //   5902: invokespecial 543	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5905: iconst_0
    //   5906: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5909: lload 13
    //   5911: lstore 17
    //   5913: aload_0
    //   5914: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   5917: ifeq +356 -> 6273
    //   5920: lload 13
    //   5922: lstore 17
    //   5924: aload_0
    //   5925: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5928: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5931: sipush 65227
    //   5934: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5937: iload 12
    //   5939: istore 11
    //   5941: iload_2
    //   5942: istore 9
    //   5944: iload_1
    //   5945: ifne +10 -> 5955
    //   5948: iload 12
    //   5950: istore 11
    //   5952: goto -670 -> 5282
    //   5955: aload_0
    //   5956: getfield 563	com/tencent/smtt/sdk/ag:r	Z
    //   5959: ifne +309 -> 6268
    //   5962: iload 9
    //   5964: istore_1
    //   5965: aload_0
    //   5966: getfield 565	com/tencent/smtt/sdk/ag:s	Z
    //   5969: ifeq +155 -> 6124
    //   5972: iload 9
    //   5974: istore_1
    //   5975: aload_0
    //   5976: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   5979: ifnonnull +19 -> 5998
    //   5982: iload 9
    //   5984: istore_1
    //   5985: iload 9
    //   5987: ifne +11 -> 5998
    //   5990: aload_0
    //   5991: iconst_1
    //   5992: iload 11
    //   5994: invokespecial 791	com/tencent/smtt/sdk/ag:c	(ZZ)Z
    //   5997: istore_1
    //   5998: aload_0
    //   5999: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6002: astore 31
    //   6004: iload_1
    //   6005: ifeq +9 -> 6014
    //   6008: iconst_1
    //   6009: istore 7
    //   6011: goto +6 -> 6017
    //   6014: iconst_0
    //   6015: istore 7
    //   6017: aload 31
    //   6019: iload 7
    //   6021: invokevirtual 1035	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   6024: iload 11
    //   6026: ifne +25 -> 6051
    //   6029: aload_0
    //   6030: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6033: astore 31
    //   6035: iload_1
    //   6036: ifeq +9 -> 6045
    //   6039: iconst_1
    //   6040: istore 7
    //   6042: goto +18 -> 6060
    //   6045: iconst_2
    //   6046: istore 7
    //   6048: goto +12 -> 6060
    //   6051: aload_0
    //   6052: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6055: astore 31
    //   6057: iconst_0
    //   6058: istore 7
    //   6060: aload 31
    //   6062: iload 7
    //   6064: invokevirtual 1038	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6067: iload_1
    //   6068: ifeq +34 -> 6102
    //   6071: aload_0
    //   6072: iconst_1
    //   6073: invokespecial 782	com/tencent/smtt/sdk/ag:b	(Z)V
    //   6076: aload_0
    //   6077: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6080: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6083: sipush 65219
    //   6086: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6089: aload_0
    //   6090: bipush 100
    //   6092: ldc_w 1040
    //   6095: iconst_1
    //   6096: invokespecial 545	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   6099: goto +25 -> 6124
    //   6102: aload_0
    //   6103: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6106: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6109: sipush 65218
    //   6112: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6115: aload_0
    //   6116: iconst_0
    //   6117: invokespecial 793	com/tencent/smtt/sdk/ag:c	(Z)Z
    //   6120: pop
    //   6121: goto +3 -> 6124
    //   6124: iconst_0
    //   6125: istore 7
    //   6127: aload_0
    //   6128: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6131: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6134: astore 31
    //   6136: iload_1
    //   6137: ifeq +43 -> 6180
    //   6140: aload 31
    //   6142: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6145: ldc_w 1042
    //   6148: iconst_0
    //   6149: invokeinterface 298 3 0
    //   6154: istore 8
    //   6156: aload 31
    //   6158: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6161: ldc_w 1042
    //   6164: iload 8
    //   6166: iconst_1
    //   6167: iadd
    //   6168: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6171: invokeinterface 383 3 0
    //   6176: pop
    //   6177: goto +66 -> 6243
    //   6180: aload 31
    //   6182: getfield 290	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6185: ldc_w 1044
    //   6188: iconst_0
    //   6189: invokeinterface 298 3 0
    //   6194: istore 8
    //   6196: aload 31
    //   6198: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6201: astore 32
    //   6203: iload 8
    //   6205: iconst_1
    //   6206: iadd
    //   6207: istore 8
    //   6209: aload 32
    //   6211: ldc_w 1044
    //   6214: iload 8
    //   6216: invokestatic 392	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6219: invokeinterface 383 3 0
    //   6224: pop
    //   6225: iload 8
    //   6227: aload 31
    //   6229: invokevirtual 1047	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6232: if_icmpne +11 -> 6243
    //   6235: aload_0
    //   6236: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6239: iconst_2
    //   6240: invokevirtual 892	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6243: aload 31
    //   6245: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6248: aload_0
    //   6249: getfield 98	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6252: astore 31
    //   6254: iload_1
    //   6255: ifeq +6 -> 6261
    //   6258: iconst_1
    //   6259: istore 7
    //   6261: aload 31
    //   6263: iload 7
    //   6265: invokevirtual 1050	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   6268: aload_0
    //   6269: invokespecial 1052	com/tencent/smtt/sdk/ag:g	()V
    //   6272: return
    //   6273: lload 13
    //   6275: lstore 17
    //   6277: aload_0
    //   6278: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6281: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6284: sipush 65220
    //   6287: invokevirtual 780	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6290: iload_1
    //   6291: ifne +37 -> 6328
    //   6294: aload_0
    //   6295: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6298: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6301: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6304: ldc_w 841
    //   6307: lload 13
    //   6309: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6312: invokeinterface 383 3 0
    //   6317: pop
    //   6318: aload_0
    //   6319: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6322: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6325: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6328: aconst_null
    //   6329: astore 31
    //   6331: lconst_0
    //   6332: lstore 19
    //   6334: iload 12
    //   6336: istore 9
    //   6338: lload 13
    //   6340: lstore 17
    //   6342: iload_2
    //   6343: istore 11
    //   6345: goto -5758 -> 587
    //   6348: astore 31
    //   6350: goto -5285 -> 1065
    //   6353: iload_1
    //   6354: ifne +37 -> 6391
    //   6357: aload_0
    //   6358: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6361: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6364: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6367: ldc_w 841
    //   6370: lload 17
    //   6372: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6375: invokeinterface 383 3 0
    //   6380: pop
    //   6381: aload_0
    //   6382: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6385: invokestatic 286	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6388: invokevirtual 395	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6391: aload 31
    //   6393: athrow
    //   6394: iconst_1
    //   6395: istore 7
    //   6397: goto -4667 -> 1730
    //   6400: iload_1
    //   6401: ifne +13 -> 6414
    //   6404: goto -3772 -> 2632
    //   6407: iload_1
    //   6408: ifne +6 -> 6414
    //   6411: goto -3779 -> 2632
    //   6414: iload 10
    //   6416: istore 9
    //   6418: iload_2
    //   6419: istore 11
    //   6421: aconst_null
    //   6422: astore 31
    //   6424: lconst_0
    //   6425: lstore 19
    //   6427: lload 13
    //   6429: lstore 17
    //   6431: goto -5844 -> 587
    //   6434: astore 35
    //   6436: aload 32
    //   6438: astore 31
    //   6440: aconst_null
    //   6441: astore 34
    //   6443: aconst_null
    //   6444: astore 33
    //   6446: aload 35
    //   6448: astore 32
    //   6450: goto -1379 -> 5071
    //   6453: astore 35
    //   6455: aconst_null
    //   6456: astore 31
    //   6458: aconst_null
    //   6459: astore 33
    //   6461: aload 32
    //   6463: astore 34
    //   6465: aload 35
    //   6467: astore 32
    //   6469: goto -1380 -> 5089
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6472	0	this	ag
    //   0	6472	1	paramBoolean1	boolean
    //   0	6472	2	paramBoolean2	boolean
    //   4441	24	3	d1	double
    //   4451	15	5	d2	double
    //   33	6363	7	i1	int
    //   1830	4403	8	i2	int
    //   86	6331	9	bool1	boolean
    //   1705	4710	10	bool2	boolean
    //   585	5835	11	bool3	boolean
    //   1079	5256	12	bool4	boolean
    //   652	5776	13	l1	long
    //   528	5183	15	l2	long
    //   556	5874	17	l3	long
    //   543	5883	19	l4	long
    //   660	5045	21	l5	long
    //   664	4106	23	l6	long
    //   3523	1270	25	l7	long
    //   648	3695	27	l8	long
    //   3668	1119	29	l9	long
    //   28	830	31	localObject1	Object
    //   1059	1	31	localObject2	Object
    //   1068	1	31	localThrowable1	Throwable
    //   1101	380	31	localObject3	Object
    //   1496	1	31	localThrowable2	Throwable
    //   1512	149	31	localObject4	Object
    //   1676	1	31	localThrowable3	Throwable
    //   1685	1	31	localThrowable4	Throwable
    //   1715	85	31	localObject5	Object
    //   1817	60	31	localThrowable5	Throwable
    //   1949	305	31	localObject6	Object
    //   2460	1	31	localThrowable6	Throwable
    //   2549	1	31	localThrowable7	Throwable
    //   2932	1	31	localThrowable8	Throwable
    //   2975	1990	31	localObject7	Object
    //   5055	1	31	localThrowable9	Throwable
    //   5069	546	31	localCloseable	Closeable
    //   5699	1	31	localThrowable10	Throwable
    //   5715	1	31	localThrowable11	Throwable
    //   5720	1	31	localThrowable12	Throwable
    //   5729	172	31	localThrowable13	Throwable
    //   6002	328	31	localObject8	Object
    //   6348	44	31	localObject9	Object
    //   6422	35	31	localObject10	Object
    //   128	4847	32	localObject11	Object
    //   5060	1	32	localObject12	Object
    //   5078	25	32	localIOException1	IOException
    //   5134	324	32	localObject13	Object
    //   5608	89	32	localObject14	Object
    //   5788	680	32	localObject15	Object
    //   176	4486	33	localObject16	Object
    //   4879	1	33	localObject17	Object
    //   4884	1	33	localIOException2	IOException
    //   4889	13	33	localObject18	Object
    //   4911	1	33	localObject19	Object
    //   4920	13	33	localIOException3	IOException
    //   4938	1522	33	localObject20	Object
    //   3486	120	34	localObject21	Object
    //   3618	14	34	localObject22	Object
    //   3637	675	34	localObject23	Object
    //   4488	7	34	localObject24	Object
    //   4500	130	34	localObject25	Object
    //   4729	7	34	localObject26	Object
    //   4741	1	34	localObject27	Object
    //   4754	1	34	localIOException4	IOException
    //   4776	1	34	localObject28	Object
    //   4781	1	34	localIOException5	IOException
    //   4797	1	34	localObject29	Object
    //   4802	7	34	localIOException6	IOException
    //   4814	1	34	localObject30	Object
    //   4819	7	34	localObject31	Object
    //   4836	1	34	localObject32	Object
    //   4845	7	34	localObject33	Object
    //   4857	1607	34	localObject34	Object
    //   3629	11	35	localObject35	Object
    //   3646	11	35	localIOException7	IOException
    //   4375	118	35	localObject36	Object
    //   4509	7	35	localIOException8	IOException
    //   4733	91	35	localObject37	Object
    //   4832	7	35	localIOException9	IOException
    //   4849	11	35	localObject38	Object
    //   4866	7	35	localIOException10	IOException
    //   4896	781	35	localObject39	Object
    //   6434	13	35	localObject40	Object
    //   6453	13	35	localIOException11	IOException
    //   4899	11	36	localObject41	Object
    // Exception table:
    //   from	to	target	type
    //   666	696	1059	finally
    //   704	712	1059	finally
    //   720	744	1059	finally
    //   752	776	1059	finally
    //   784	794	1059	finally
    //   805	814	1059	finally
    //   822	831	1059	finally
    //   839	847	1059	finally
    //   855	865	1059	finally
    //   885	894	1059	finally
    //   902	910	1059	finally
    //   918	931	1059	finally
    //   984	994	1059	finally
    //   1002	1011	1059	finally
    //   1019	1027	1059	finally
    //   1035	1048	1059	finally
    //   1088	1093	1059	finally
    //   1097	1103	1059	finally
    //   1116	1122	1059	finally
    //   1129	1135	1059	finally
    //   1139	1148	1059	finally
    //   1152	1161	1059	finally
    //   1165	1173	1059	finally
    //   1177	1186	1059	finally
    //   1190	1200	1059	finally
    //   1204	1215	1059	finally
    //   1219	1229	1059	finally
    //   1241	1250	1059	finally
    //   1254	1260	1059	finally
    //   1264	1270	1059	finally
    //   1274	1279	1059	finally
    //   1287	1293	1059	finally
    //   1297	1306	1059	finally
    //   1310	1319	1059	finally
    //   1323	1331	1059	finally
    //   1335	1345	1059	finally
    //   1349	1355	1059	finally
    //   1366	1375	1059	finally
    //   1379	1388	1059	finally
    //   1392	1400	1059	finally
    //   1404	1415	1059	finally
    //   1419	1425	1059	finally
    //   1429	1438	1059	finally
    //   1442	1451	1059	finally
    //   1455	1463	1059	finally
    //   1467	1476	1059	finally
    //   1480	1493	1059	finally
    //   1505	1514	1059	finally
    //   1518	1527	1059	finally
    //   1531	1539	1059	finally
    //   1543	1552	1059	finally
    //   1556	1566	1059	finally
    //   1570	1581	1059	finally
    //   1585	1591	1059	finally
    //   1595	1604	1059	finally
    //   1608	1617	1059	finally
    //   1621	1629	1059	finally
    //   1633	1642	1059	finally
    //   1646	1656	1059	finally
    //   1660	1673	1059	finally
    //   1711	1717	1059	finally
    //   1734	1741	1059	finally
    //   1745	1754	1059	finally
    //   1758	1767	1059	finally
    //   1771	1777	1059	finally
    //   1786	1794	1059	finally
    //   1798	1804	1059	finally
    //   1808	1814	1059	finally
    //   1826	1832	1059	finally
    //   1843	1854	1059	finally
    //   1863	1871	1059	finally
    //   1875	1881	1059	finally
    //   1885	1891	1059	finally
    //   1895	1901	1059	finally
    //   1911	1925	1059	finally
    //   1929	1938	1059	finally
    //   1942	1951	1059	finally
    //   1955	1964	1059	finally
    //   1968	1976	1059	finally
    //   1980	1990	1059	finally
    //   1994	2003	1059	finally
    //   2011	2021	1059	finally
    //   2025	2036	1059	finally
    //   2040	2046	1059	finally
    //   2050	2060	1059	finally
    //   2064	2068	1059	finally
    //   2072	2078	1059	finally
    //   2082	2092	1059	finally
    //   2096	2105	1059	finally
    //   2109	2115	1059	finally
    //   2124	2137	1059	finally
    //   2224	2236	1059	finally
    //   2240	2248	1059	finally
    //   2252	2258	1059	finally
    //   2262	2272	1059	finally
    //   2317	2325	1059	finally
    //   2329	2342	1059	finally
    //   2353	2365	1059	finally
    //   2381	2390	1059	finally
    //   2399	2412	1059	finally
    //   2471	2477	1059	finally
    //   2481	2494	1059	finally
    //   2578	2589	1059	finally
    //   2593	2606	1059	finally
    //   2673	2684	1059	finally
    //   2696	2713	1059	finally
    //   2717	2724	1059	finally
    //   2728	2741	1059	finally
    //   2759	2770	1059	finally
    //   2806	2811	1059	finally
    //   2815	2822	1059	finally
    //   2826	2839	1059	finally
    //   2857	2866	1059	finally
    //   2870	2877	1059	finally
    //   2889	2894	1059	finally
    //   2905	2918	1059	finally
    //   2949	2964	1059	finally
    //   2968	2977	1059	finally
    //   2981	2990	1059	finally
    //   2994	3004	1059	finally
    //   3008	3018	1059	finally
    //   3022	3033	1059	finally
    //   3037	3058	1059	finally
    //   3069	3079	1059	finally
    //   3083	3092	1059	finally
    //   3096	3105	1059	finally
    //   3109	3117	1059	finally
    //   3121	3130	1059	finally
    //   3134	3144	1059	finally
    //   3148	3159	1059	finally
    //   3167	3174	1059	finally
    //   3178	3184	1059	finally
    //   3188	3198	1059	finally
    //   3202	3209	1059	finally
    //   3213	3221	1059	finally
    //   3232	3241	1059	finally
    //   3245	3254	1059	finally
    //   3258	3266	1059	finally
    //   3270	3279	1059	finally
    //   3283	3293	1059	finally
    //   3297	3309	1059	finally
    //   3313	3326	1059	finally
    //   3333	3343	1059	finally
    //   3347	3360	1059	finally
    //   3378	3386	1059	finally
    //   4953	4959	1059	finally
    //   4963	4969	1059	finally
    //   4973	4979	1059	finally
    //   4983	4990	1059	finally
    //   4994	5007	1059	finally
    //   666	696	1068	java/lang/Throwable
    //   704	712	1068	java/lang/Throwable
    //   720	744	1068	java/lang/Throwable
    //   752	776	1068	java/lang/Throwable
    //   784	794	1068	java/lang/Throwable
    //   805	814	1068	java/lang/Throwable
    //   822	831	1068	java/lang/Throwable
    //   839	847	1068	java/lang/Throwable
    //   855	865	1068	java/lang/Throwable
    //   885	894	1068	java/lang/Throwable
    //   902	910	1068	java/lang/Throwable
    //   918	931	1068	java/lang/Throwable
    //   984	994	1068	java/lang/Throwable
    //   1002	1011	1068	java/lang/Throwable
    //   1019	1027	1068	java/lang/Throwable
    //   1035	1048	1068	java/lang/Throwable
    //   1116	1122	1068	java/lang/Throwable
    //   1241	1250	1068	java/lang/Throwable
    //   1366	1375	1496	java/lang/Throwable
    //   1379	1388	1496	java/lang/Throwable
    //   1392	1400	1496	java/lang/Throwable
    //   1404	1415	1496	java/lang/Throwable
    //   1419	1425	1496	java/lang/Throwable
    //   1429	1438	1496	java/lang/Throwable
    //   1442	1451	1496	java/lang/Throwable
    //   1455	1463	1496	java/lang/Throwable
    //   1467	1476	1496	java/lang/Throwable
    //   1480	1493	1496	java/lang/Throwable
    //   1349	1355	1676	java/lang/Throwable
    //   1505	1514	1676	java/lang/Throwable
    //   1518	1527	1676	java/lang/Throwable
    //   1531	1539	1676	java/lang/Throwable
    //   1543	1552	1676	java/lang/Throwable
    //   1287	1293	1685	java/lang/Throwable
    //   1297	1306	1685	java/lang/Throwable
    //   1310	1319	1685	java/lang/Throwable
    //   1323	1331	1685	java/lang/Throwable
    //   1335	1345	1685	java/lang/Throwable
    //   1556	1566	1817	java/lang/Throwable
    //   1570	1581	1817	java/lang/Throwable
    //   1585	1591	1817	java/lang/Throwable
    //   1595	1604	1817	java/lang/Throwable
    //   1608	1617	1817	java/lang/Throwable
    //   1621	1629	1817	java/lang/Throwable
    //   1633	1642	1817	java/lang/Throwable
    //   1646	1656	1817	java/lang/Throwable
    //   1660	1673	1817	java/lang/Throwable
    //   1786	1794	1817	java/lang/Throwable
    //   1798	1804	1817	java/lang/Throwable
    //   1808	1814	1817	java/lang/Throwable
    //   1843	1854	1817	java/lang/Throwable
    //   1911	1925	1817	java/lang/Throwable
    //   2011	2021	1817	java/lang/Throwable
    //   2025	2036	1817	java/lang/Throwable
    //   2040	2046	1817	java/lang/Throwable
    //   2050	2060	1817	java/lang/Throwable
    //   2064	2068	1817	java/lang/Throwable
    //   2072	2078	1817	java/lang/Throwable
    //   2082	2092	1817	java/lang/Throwable
    //   2096	2105	1817	java/lang/Throwable
    //   2124	2137	1817	java/lang/Throwable
    //   2224	2236	1817	java/lang/Throwable
    //   2240	2248	1817	java/lang/Throwable
    //   2252	2258	1817	java/lang/Throwable
    //   2262	2272	1817	java/lang/Throwable
    //   2317	2325	1817	java/lang/Throwable
    //   2329	2342	1817	java/lang/Throwable
    //   2399	2412	2460	java/lang/Throwable
    //   2381	2390	2549	java/lang/Throwable
    //   2471	2477	2549	java/lang/Throwable
    //   2481	2494	2549	java/lang/Throwable
    //   2578	2589	2549	java/lang/Throwable
    //   2593	2606	2549	java/lang/Throwable
    //   2673	2684	2549	java/lang/Throwable
    //   2696	2713	2549	java/lang/Throwable
    //   2717	2724	2549	java/lang/Throwable
    //   2728	2741	2549	java/lang/Throwable
    //   2759	2770	2549	java/lang/Throwable
    //   2806	2811	2549	java/lang/Throwable
    //   2815	2822	2549	java/lang/Throwable
    //   2826	2839	2549	java/lang/Throwable
    //   2857	2866	2549	java/lang/Throwable
    //   2870	2877	2549	java/lang/Throwable
    //   2889	2894	2549	java/lang/Throwable
    //   2905	2918	2549	java/lang/Throwable
    //   3069	3079	2549	java/lang/Throwable
    //   3083	3092	2549	java/lang/Throwable
    //   3096	3105	2549	java/lang/Throwable
    //   3109	3117	2549	java/lang/Throwable
    //   3121	3130	2549	java/lang/Throwable
    //   3134	3144	2549	java/lang/Throwable
    //   3148	3159	2549	java/lang/Throwable
    //   3167	3174	2549	java/lang/Throwable
    //   3178	3184	2549	java/lang/Throwable
    //   3188	3198	2549	java/lang/Throwable
    //   3202	3209	2549	java/lang/Throwable
    //   3213	3221	2549	java/lang/Throwable
    //   3232	3241	2549	java/lang/Throwable
    //   3245	3254	2549	java/lang/Throwable
    //   3258	3266	2549	java/lang/Throwable
    //   3270	3279	2549	java/lang/Throwable
    //   3283	3293	2549	java/lang/Throwable
    //   3297	3309	2549	java/lang/Throwable
    //   3313	3326	2549	java/lang/Throwable
    //   3333	3343	2549	java/lang/Throwable
    //   3347	3360	2549	java/lang/Throwable
    //   2353	2365	2932	java/lang/Throwable
    //   3554	3563	3618	finally
    //   3577	3586	3618	finally
    //   3605	3612	3618	finally
    //   3702	3709	3618	finally
    //   3723	3733	3618	finally
    //   3751	3759	3618	finally
    //   3779	3784	3618	finally
    //   3806	3811	3618	finally
    //   3825	3832	3618	finally
    //   3848	3861	3618	finally
    //   3913	3922	3618	finally
    //   3936	3945	3618	finally
    //   3959	3968	3618	finally
    //   3982	3990	3618	finally
    //   4004	4013	3618	finally
    //   4027	4035	3618	finally
    //   4049	4061	3618	finally
    //   4075	4088	3618	finally
    //   4109	4119	3618	finally
    //   4133	4142	3618	finally
    //   4156	4165	3618	finally
    //   4179	4188	3618	finally
    //   4202	4211	3618	finally
    //   4225	4234	3618	finally
    //   4248	4264	3618	finally
    //   4278	4290	3618	finally
    //   4304	4313	3618	finally
    //   3554	3563	3646	java/io/IOException
    //   3577	3586	3646	java/io/IOException
    //   3605	3612	3646	java/io/IOException
    //   3702	3709	3646	java/io/IOException
    //   3723	3733	3646	java/io/IOException
    //   3751	3759	3646	java/io/IOException
    //   3779	3784	3646	java/io/IOException
    //   3806	3811	3646	java/io/IOException
    //   3825	3832	3646	java/io/IOException
    //   3848	3861	3646	java/io/IOException
    //   3913	3922	3646	java/io/IOException
    //   3936	3945	3646	java/io/IOException
    //   3959	3968	3646	java/io/IOException
    //   3982	3990	3646	java/io/IOException
    //   4004	4013	3646	java/io/IOException
    //   4027	4035	3646	java/io/IOException
    //   4049	4061	3646	java/io/IOException
    //   4075	4088	3646	java/io/IOException
    //   4109	4119	3646	java/io/IOException
    //   4133	4142	3646	java/io/IOException
    //   4156	4165	3646	java/io/IOException
    //   4179	4188	3646	java/io/IOException
    //   4202	4211	3646	java/io/IOException
    //   4225	4234	3646	java/io/IOException
    //   4248	4264	3646	java/io/IOException
    //   4278	4290	3646	java/io/IOException
    //   4304	4313	3646	java/io/IOException
    //   4442	4448	4488	finally
    //   4475	4485	4488	finally
    //   4567	4572	4488	finally
    //   4601	4611	4488	finally
    //   4442	4448	4509	java/io/IOException
    //   4475	4485	4509	java/io/IOException
    //   4567	4572	4509	java/io/IOException
    //   4601	4611	4509	java/io/IOException
    //   4629	4637	4729	finally
    //   4629	4637	4754	java/io/IOException
    //   4407	4433	4776	finally
    //   4542	4561	4776	finally
    //   4577	4587	4776	finally
    //   4587	4596	4776	finally
    //   4611	4629	4776	finally
    //   4407	4433	4781	java/io/IOException
    //   4542	4561	4781	java/io/IOException
    //   4577	4587	4781	java/io/IOException
    //   4587	4596	4781	java/io/IOException
    //   4611	4629	4781	java/io/IOException
    //   4334	4349	4797	finally
    //   4368	4403	4797	finally
    //   4334	4349	4802	java/io/IOException
    //   4368	4403	4802	java/io/IOException
    //   3529	3535	4819	finally
    //   3670	3683	4819	finally
    //   3864	3879	4819	finally
    //   3529	3535	4832	java/io/IOException
    //   3670	3683	4832	java/io/IOException
    //   3864	3879	4832	java/io/IOException
    //   3512	3517	4845	finally
    //   3512	3517	4866	java/io/IOException
    //   3481	3512	4879	finally
    //   3481	3512	4884	java/io/IOException
    //   3400	3409	4889	finally
    //   3400	3409	4920	java/io/IOException
    //   4953	4959	5055	java/lang/Throwable
    //   4963	4969	5055	java/lang/Throwable
    //   4973	4979	5055	java/lang/Throwable
    //   4983	4990	5055	java/lang/Throwable
    //   4994	5007	5055	java/lang/Throwable
    //   3386	3395	5060	finally
    //   3386	3395	5078	java/io/IOException
    //   5089	5110	5608	finally
    //   5117	5204	5608	finally
    //   5309	5321	5608	finally
    //   5325	5333	5608	finally
    //   5333	5342	5608	finally
    //   5349	5357	5608	finally
    //   5441	5466	5608	finally
    //   4660	4666	5699	java/lang/Throwable
    //   4681	4687	5699	java/lang/Throwable
    //   4702	4708	5699	java/lang/Throwable
    //   5219	5225	5699	java/lang/Throwable
    //   5240	5246	5699	java/lang/Throwable
    //   5261	5267	5699	java/lang/Throwable
    //   5375	5381	5699	java/lang/Throwable
    //   5396	5402	5699	java/lang/Throwable
    //   5417	5423	5699	java/lang/Throwable
    //   5481	5487	5699	java/lang/Throwable
    //   5502	5508	5699	java/lang/Throwable
    //   5523	5529	5699	java/lang/Throwable
    //   5633	5639	5699	java/lang/Throwable
    //   5654	5660	5699	java/lang/Throwable
    //   5675	5681	5699	java/lang/Throwable
    //   5696	5699	5699	java/lang/Throwable
    //   2949	2964	5715	java/lang/Throwable
    //   2968	2977	5715	java/lang/Throwable
    //   2981	2990	5715	java/lang/Throwable
    //   2994	3004	5715	java/lang/Throwable
    //   3008	3018	5715	java/lang/Throwable
    //   3022	3033	5715	java/lang/Throwable
    //   3037	3058	5715	java/lang/Throwable
    //   3378	3386	5715	java/lang/Throwable
    //   1711	1717	5720	java/lang/Throwable
    //   1734	1741	5720	java/lang/Throwable
    //   1745	1754	5720	java/lang/Throwable
    //   1758	1767	5720	java/lang/Throwable
    //   1771	1777	5720	java/lang/Throwable
    //   1826	1832	5720	java/lang/Throwable
    //   1863	1871	5720	java/lang/Throwable
    //   1875	1881	5720	java/lang/Throwable
    //   1885	1891	5720	java/lang/Throwable
    //   1895	1901	5720	java/lang/Throwable
    //   1929	1938	5720	java/lang/Throwable
    //   1942	1951	5720	java/lang/Throwable
    //   1955	1964	5720	java/lang/Throwable
    //   1968	1976	5720	java/lang/Throwable
    //   1980	1990	5720	java/lang/Throwable
    //   1994	2003	5720	java/lang/Throwable
    //   2109	2115	5720	java/lang/Throwable
    //   1088	1093	5729	java/lang/Throwable
    //   1097	1103	5729	java/lang/Throwable
    //   1129	1135	5729	java/lang/Throwable
    //   1139	1148	5729	java/lang/Throwable
    //   1152	1161	5729	java/lang/Throwable
    //   1165	1173	5729	java/lang/Throwable
    //   1177	1186	5729	java/lang/Throwable
    //   1190	1200	5729	java/lang/Throwable
    //   1204	1215	5729	java/lang/Throwable
    //   1219	1229	5729	java/lang/Throwable
    //   1254	1260	5729	java/lang/Throwable
    //   1264	1270	5729	java/lang/Throwable
    //   1274	1279	5729	java/lang/Throwable
    //   4660	4666	6348	finally
    //   4681	4687	6348	finally
    //   4702	4708	6348	finally
    //   5219	5225	6348	finally
    //   5240	5246	6348	finally
    //   5261	5267	6348	finally
    //   5375	5381	6348	finally
    //   5396	5402	6348	finally
    //   5417	5423	6348	finally
    //   5481	5487	6348	finally
    //   5502	5508	6348	finally
    //   5523	5529	6348	finally
    //   5633	5639	6348	finally
    //   5654	5660	6348	finally
    //   5675	5681	6348	finally
    //   5696	5699	6348	finally
    //   5742	5750	6348	finally
    //   5758	5765	6348	finally
    //   5769	5777	6348	finally
    //   5781	5790	6348	finally
    //   5794	5803	6348	finally
    //   5807	5817	6348	finally
    //   5821	5830	6348	finally
    //   5834	5845	6348	finally
    //   5849	5859	6348	finally
    //   5863	5871	6348	finally
    //   5878	5883	6348	finally
    //   5887	5892	6348	finally
    //   5896	5909	6348	finally
    //   5913	5920	6348	finally
    //   5924	5937	6348	finally
    //   6277	6290	6348	finally
    //   3414	3436	6434	finally
    //   3444	3474	6434	finally
    //   3414	3436	6453	java/io/IOException
    //   3444	3474	6453	java/io/IOException
  }
  
  public void c()
  {
    this.r = true;
    if (TbsShareManager.isThirdPartyApp(this.g))
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo = TbsLogReport.a(this.g).a();
      localTbsLogInfo.setErrorCode(65227);
      localTbsLogInfo.setFailDetail(new Exception());
      TbsLogReport localTbsLogReport;
      if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
        localTbsLogReport = TbsLogReport.a(this.g);
      }
      for (TbsLogReport.EventType localEventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;; localEventType = TbsLogReport.EventType.TYPE_DOWNLOAD)
      {
        localTbsLogReport.a(localEventType, localTbsLogInfo);
        return;
        localTbsLogReport = TbsLogReport.a(this.g);
      }
    }
  }
  
  public void d()
  {
    c();
    c(false);
    c(true);
  }
  
  public boolean e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=");
    localStringBuilder.append(this.C);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    return this.C;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */