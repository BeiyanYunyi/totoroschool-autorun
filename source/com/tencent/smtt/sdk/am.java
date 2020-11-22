package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.y;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class am
{
  public static ThreadLocal<Integer> a;
  static boolean b = false;
  static final FileFilter c = new ao();
  private static am d;
  private static final ReentrantLock i = new ReentrantLock();
  private static final Lock j = new ReentrantLock();
  private static FileLock l = null;
  private static Handler m;
  private static final Long[][] n;
  private static int o = 0;
  private static boolean p = false;
  private int e = 0;
  private FileLock f;
  private FileOutputStream g;
  private boolean h = false;
  private boolean k = false;
  
  static
  {
    a = new an();
    m = null;
    n = new Long[][] { { Long.valueOf(44006L), Long.valueOf(39094008L) }, { Long.valueOf(44005L), Long.valueOf(39094008L) }, { Long.valueOf(43910L), Long.valueOf(38917816L) }, { Long.valueOf(44027L), Long.valueOf(39094008L) }, { Long.valueOf(44028L), Long.valueOf(39094008L) }, { Long.valueOf(44029L), Long.valueOf(39094008L) }, { Long.valueOf(44030L), Long.valueOf(39094008L) }, { Long.valueOf(44032L), Long.valueOf(39094008L) }, { Long.valueOf(44033L), Long.valueOf(39094008L) }, { Long.valueOf(44034L), Long.valueOf(39094008L) }, { Long.valueOf(43909L), Long.valueOf(38917816L) } };
  }
  
  private am()
  {
    if (m == null) {
      m = new ap(this, al.a().getLooper());
    }
  }
  
  private void A(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!z(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      C(paramContext);
      D(paramContext);
      TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
        TbsShareManager.a(paramContext);
      }
      else
      {
        TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
      }
      ai.a(paramContext).a(0);
      ai.a(paramContext).b(0);
      ai.a(paramContext).d(0);
      ai.a(paramContext).a("incrupdate_retry_num", 0);
      ai.a(paramContext).b(0, 3);
      ai.a(paramContext).a("");
      ai.a(paramContext).c(-1);
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        int i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
        if ((i1 > 0) && (i1 != a().i(paramContext)) && (i1 == a().j(paramContext)))
        {
          o(paramContext);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is ");
          localStringBuilder1.append(i1);
          localStringBuilder1.append(" getTbsCoreShareDecoupleCoreVersion is ");
          localStringBuilder1.append(a().i(paramContext));
          localStringBuilder1.append(" getTbsCoreInstalledVerInNolock is ");
          localStringBuilder1.append(a().j(paramContext));
          TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        }
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
      }
      a.set(Integer.valueOf(0));
      o = 0;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      TbsLogReport localTbsLogReport = TbsLogReport.a(paramContext);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("exception when renameing from unzip:");
      localStringBuilder2.append(localThrowable.toString());
      localTbsLogReport.a(219, localStringBuilder2.toString());
      TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
    }
    g(paramContext);
  }
  
  private void B(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!z(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      C(paramContext);
      E(paramContext);
      TbsShareManager.a(paramContext);
      ai.a(paramContext).a(0, 3);
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        int i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
        if ((i1 > 0) && (i1 != a().i(paramContext)) && (i1 == a().j(paramContext)))
        {
          o(paramContext);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is ");
          localStringBuilder1.append(i1);
          localStringBuilder1.append(" getTbsCoreShareDecoupleCoreVersion is ");
          localStringBuilder1.append(a().i(paramContext));
          localStringBuilder1.append(" getTbsCoreInstalledVerInNolock is ");
          localStringBuilder1.append(a().j(paramContext));
          TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        }
      }
      a.set(Integer.valueOf(0));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport localTbsLogReport = TbsLogReport.a(paramContext);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("exception when renameing from copy:");
      localStringBuilder2.append(localException.toString());
      localTbsLogReport.a(219, localStringBuilder2.toString());
    }
    g(paramContext);
  }
  
  private void C(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    k.a(r(paramContext), false);
  }
  
  private void D(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    Object localObject = u(paramContext);
    File localFile = r(paramContext);
    if (localObject != null)
    {
      if (localFile == null) {
        return;
      }
      boolean bool = ((File)localObject).renameTo(localFile);
      if ((paramContext != null) && ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)))
      {
        if (bool) {
          localObject = TbsLogReport.a(paramContext);
        }
        for (int i1 = 230;; i1 = 231)
        {
          ((TbsLogReport)localObject).a(i1, " ");
          break;
          localObject = TbsLogReport.a(paramContext);
        }
      }
      g(paramContext, false);
    }
  }
  
  private void E(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = w(paramContext);
    File localFile2 = r(paramContext);
    if (localFile1 != null)
    {
      if (localFile2 == null) {
        return;
      }
      localFile1.renameTo(localFile2);
      g(paramContext, false);
    }
  }
  
  private void F(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = u(paramContext);
    if (localFile != null) {
      k.a(localFile, false);
    }
    ai.a(paramContext).b(0, 5);
    ai.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
  }
  
  static am a()
  {
    try
    {
      if (d == null) {
        try
        {
          if (d == null) {
            d = new am();
          }
        }
        finally {}
      }
      am localam = d;
      return localam;
    }
    finally {}
  }
  
  /* Error */
  private void a(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: new 306	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 366	java/io/File:delete	()Z
    //   11: pop
    //   12: new 216	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: ldc_w 368
    //   26: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: ldc_w 370
    //   42: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 127
    //   48: aload 4
    //   50: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: iconst_1
    //   54: invokestatic 372	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   57: new 306	java/io/File
    //   60: dup
    //   61: aload_3
    //   62: ldc_w 374
    //   65: iconst_0
    //   66: invokevirtual 378	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   69: ldc_w 380
    //   72: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual 386	java/io/File:canRead	()Z
    //   80: ifeq +257 -> 337
    //   83: new 306	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: ldc_w 388
    //   91: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 9
    //   96: new 390	java/util/Properties
    //   99: dup
    //   100: invokespecial 391	java/util/Properties:<init>	()V
    //   103: astore 8
    //   105: aconst_null
    //   106: astore 7
    //   108: aconst_null
    //   109: astore 5
    //   111: aconst_null
    //   112: astore 6
    //   114: new 393	java/io/BufferedInputStream
    //   117: dup
    //   118: new 395	java/io/FileInputStream
    //   121: dup
    //   122: aload 9
    //   124: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   127: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   130: astore_2
    //   131: aload_2
    //   132: astore_3
    //   133: aload 7
    //   135: astore 4
    //   137: aload 8
    //   139: aload_2
    //   140: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   143: aload_2
    //   144: astore_3
    //   145: aload 7
    //   147: astore 4
    //   149: new 406	java/io/BufferedOutputStream
    //   152: dup
    //   153: new 408	java/io/FileOutputStream
    //   156: dup
    //   157: aload 9
    //   159: invokespecial 409	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   162: invokespecial 412	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   165: astore 5
    //   167: aload 8
    //   169: ldc_w 414
    //   172: ldc_w 416
    //   175: invokevirtual 420	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   178: pop
    //   179: aload 8
    //   181: aload 5
    //   183: aconst_null
    //   184: invokevirtual 424	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   187: ldc 127
    //   189: ldc_w 426
    //   192: iconst_1
    //   193: invokestatic 372	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload 5
    //   198: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   201: goto +8 -> 209
    //   204: astore_3
    //   205: aload_3
    //   206: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   209: aload_2
    //   210: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   213: return
    //   214: astore 4
    //   216: goto +84 -> 300
    //   219: astore_3
    //   220: aload 5
    //   222: astore 6
    //   224: aload_3
    //   225: astore 5
    //   227: goto +19 -> 246
    //   230: astore 5
    //   232: goto +14 -> 246
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_2
    //   239: goto +61 -> 300
    //   242: astore 5
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: astore_3
    //   248: aload 6
    //   250: astore 4
    //   252: aload 5
    //   254: invokevirtual 254	java/lang/Throwable:printStackTrace	()V
    //   257: aload 6
    //   259: ifnull +16 -> 275
    //   262: aload 6
    //   264: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   267: goto +8 -> 275
    //   270: astore_3
    //   271: aload_3
    //   272: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   275: aload_2
    //   276: ifnull +61 -> 337
    //   279: aload_2
    //   280: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   283: return
    //   284: astore_2
    //   285: aload_2
    //   286: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   289: return
    //   290: astore_2
    //   291: aload 4
    //   293: astore 5
    //   295: aload_2
    //   296: astore 4
    //   298: aload_3
    //   299: astore_2
    //   300: aload 5
    //   302: ifnull +16 -> 318
    //   305: aload 5
    //   307: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   310: goto +8 -> 318
    //   313: astore_3
    //   314: aload_3
    //   315: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   318: aload_2
    //   319: ifnull +15 -> 334
    //   322: aload_2
    //   323: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   326: goto +8 -> 334
    //   329: astore_2
    //   330: aload_2
    //   331: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   334: aload 4
    //   336: athrow
    //   337: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	am
    //   0	338	1	paramInt	int
    //   0	338	2	paramString	String
    //   0	338	3	paramContext	Context
    //   19	129	4	localObject1	Object
    //   214	1	4	localObject2	Object
    //   235	1	4	localObject3	Object
    //   250	85	4	localObject4	Object
    //   109	117	5	localObject5	Object
    //   230	1	5	localThrowable1	Throwable
    //   242	11	5	localThrowable2	Throwable
    //   293	13	5	localObject6	Object
    //   112	151	6	localObject7	Object
    //   106	40	7	localObject8	Object
    //   103	77	8	localProperties	java.util.Properties
    //   94	64	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   196	201	204	java/io/IOException
    //   167	196	214	finally
    //   167	196	219	java/lang/Throwable
    //   137	143	230	java/lang/Throwable
    //   149	167	230	java/lang/Throwable
    //   114	131	235	finally
    //   114	131	242	java/lang/Throwable
    //   262	267	270	java/io/IOException
    //   209	213	284	java/io/IOException
    //   279	283	284	java/io/IOException
    //   137	143	290	finally
    //   149	167	290	finally
    //   252	257	290	finally
    //   305	310	313	java/io/IOException
    //   322	326	329	java/io/IOException
  }
  
  public static void a(Context paramContext)
  {
    if (!y(paramContext))
    {
      if (d(paramContext, "core_unzip_tmp"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
        paramContext = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
      }
      for (;;)
      {
        TbsLog.e("TbsInstaller", paramContext);
        return;
        if (d(paramContext, "core_share_backup_tmp"))
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
          paramContext = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
        }
        else
        {
          if (!d(paramContext, "core_copy_tmp")) {
            break;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
          paramContext = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME";
        }
      }
    }
  }
  
  /* Error */
  @TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4: sipush 65012
    //   7: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 473	com/tencent/smtt/sdk/am:c	(Landroid/content/Context;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: new 216	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   26: astore 13
    //   28: aload 13
    //   30: ldc_w 475
    //   33: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 13
    //   39: iload_3
    //   40: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 127
    //   46: aload 13
    //   48: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: getstatic 480	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 11
    //   59: if_icmplt +16 -> 75
    //   62: aload_2
    //   63: ldc_w 482
    //   66: iconst_4
    //   67: invokevirtual 486	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   70: astore 13
    //   72: goto +13 -> 85
    //   75: aload_2
    //   76: ldc_w 482
    //   79: iconst_0
    //   80: invokevirtual 486	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   83: astore 13
    //   85: aload 13
    //   87: ldc_w 488
    //   90: iconst_m1
    //   91: invokeinterface 204 3 0
    //   96: iload_3
    //   97: if_icmpne +57 -> 154
    //   100: new 216	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: ldc_w 490
    //   112: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_2
    //   117: iload_3
    //   118: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: ldc_w 492
    //   126: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc 127
    //   132: aload_2
    //   133: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_1
    //   140: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   143: astore_1
    //   144: sipush 65011
    //   147: istore_3
    //   148: aload_1
    //   149: iload_3
    //   150: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   153: return
    //   154: aload_0
    //   155: aload_2
    //   156: invokevirtual 495	com/tencent/smtt/sdk/am:x	(Landroid/content/Context;)Z
    //   159: ifne +15 -> 174
    //   162: aload_1
    //   163: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   166: astore_1
    //   167: sipush 65010
    //   170: istore_3
    //   171: goto -23 -> 148
    //   174: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   177: invokeinterface 500 1 0
    //   182: istore 8
    //   184: new 216	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   191: astore 13
    //   193: aload 13
    //   195: ldc_w 502
    //   198: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 13
    //   204: iload 8
    //   206: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc 127
    //   212: aload 13
    //   214: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: iload 8
    //   222: ifeq +1963 -> 2185
    //   225: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   228: invokevirtual 508	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   231: aload_2
    //   232: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   235: ldc_w 510
    //   238: invokevirtual 513	com/tencent/smtt/sdk/ai:c	(Ljava/lang/String;)I
    //   241: istore 4
    //   243: aload_2
    //   244: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   247: ldc_w 515
    //   250: invokevirtual 517	com/tencent/smtt/sdk/ai:b	(Ljava/lang/String;)I
    //   253: istore 5
    //   255: iload 4
    //   257: iload_3
    //   258: if_icmpne +43 -> 301
    //   261: getstatic 520	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   264: sipush 220
    //   267: invokeinterface 525 2 0
    //   272: aload_1
    //   273: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   276: sipush 65008
    //   279: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   282: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   285: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   288: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   291: invokeinterface 529 1 0
    //   296: aload_0
    //   297: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   300: return
    //   301: aload_0
    //   302: aload_2
    //   303: invokevirtual 212	com/tencent/smtt/sdk/am:j	(Landroid/content/Context;)I
    //   306: istore 6
    //   308: new 216	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   315: astore 13
    //   317: aload 13
    //   319: ldc_w 533
    //   322: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 13
    //   328: iload 6
    //   330: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: ldc 127
    //   336: aload 13
    //   338: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: iload 6
    //   346: iload_3
    //   347: if_icmpne +79 -> 426
    //   350: getstatic 520	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   353: sipush 220
    //   356: invokeinterface 525 2 0
    //   361: aload_1
    //   362: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   365: sipush 65008
    //   368: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   371: new 216	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   378: astore 13
    //   380: aload 13
    //   382: ldc_w 535
    //   385: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 13
    //   391: iload 6
    //   393: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 127
    //   399: aload 13
    //   401: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   410: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   413: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   416: invokeinterface 529 1 0
    //   421: aload_0
    //   422: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   425: return
    //   426: aload_2
    //   427: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   430: invokevirtual 538	com/tencent/smtt/sdk/ai:b	()I
    //   433: istore 7
    //   435: iload 7
    //   437: ifle +1763 -> 2200
    //   440: iload_3
    //   441: iload 7
    //   443: if_icmpgt +6 -> 449
    //   446: goto +1754 -> 2200
    //   449: aload_0
    //   450: aload_2
    //   451: invokevirtual 540	com/tencent/smtt/sdk/am:p	(Landroid/content/Context;)V
    //   454: goto +1760 -> 2214
    //   457: aload_0
    //   458: aload_2
    //   459: invokevirtual 540	com/tencent/smtt/sdk/am:p	(Landroid/content/Context;)V
    //   462: ldc 127
    //   464: ldc_w 542
    //   467: iconst_1
    //   468: invokestatic 372	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   471: iconst_m1
    //   472: istore 4
    //   474: aload_2
    //   475: invokestatic 544	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   478: ifne +108 -> 586
    //   481: invokestatic 549	com/tencent/smtt/utils/y:a	()J
    //   484: lstore 9
    //   486: aload_2
    //   487: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   490: invokevirtual 552	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   493: lstore 11
    //   495: aload_1
    //   496: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   499: sipush 65007
    //   502: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   505: aload_2
    //   506: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   509: astore 13
    //   511: new 216	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   518: astore 14
    //   520: aload 14
    //   522: ldc_w 554
    //   525: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 14
    //   531: lload 9
    //   533: invokevirtual 557	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 14
    //   539: ldc_w 559
    //   542: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 14
    //   548: lload 11
    //   550: invokevirtual 557	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 13
    //   556: sipush 210
    //   559: aload 14
    //   561: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   567: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   570: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   573: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   576: invokeinterface 529 1 0
    //   581: aload_0
    //   582: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   585: return
    //   586: iload 4
    //   588: ifle +100 -> 688
    //   591: aload_2
    //   592: invokestatic 153	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   595: ifne +35 -> 630
    //   598: aload_2
    //   599: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   602: getfield 196	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   605: ldc_w 561
    //   608: iconst_0
    //   609: invokeinterface 204 3 0
    //   614: iconst_1
    //   615: if_icmpne +15 -> 630
    //   618: iload_3
    //   619: aload_0
    //   620: aload_2
    //   621: invokevirtual 210	com/tencent/smtt/sdk/am:i	(Landroid/content/Context;)I
    //   624: if_icmpeq +6 -> 630
    //   627: goto +61 -> 688
    //   630: new 216	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   637: astore 13
    //   639: aload 13
    //   641: ldc_w 563
    //   644: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 13
    //   650: aload_0
    //   651: aload_2
    //   652: invokevirtual 210	com/tencent/smtt/sdk/am:i	(Landroid/content/Context;)I
    //   655: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: ldc 127
    //   661: aload 13
    //   663: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   672: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   675: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   678: invokeinterface 529 1 0
    //   683: aload_0
    //   684: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   687: return
    //   688: iload 4
    //   690: ifne +77 -> 767
    //   693: aload_2
    //   694: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   697: ldc_w 565
    //   700: invokevirtual 513	com/tencent/smtt/sdk/ai:c	(Ljava/lang/String;)I
    //   703: istore 4
    //   705: iload 4
    //   707: iconst_2
    //   708: if_icmple +45 -> 753
    //   711: aload_2
    //   712: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   715: sipush 211
    //   718: ldc_w 567
    //   721: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   724: aload_1
    //   725: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   728: sipush 65006
    //   731: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   734: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   737: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   740: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   743: invokeinterface 529 1 0
    //   748: aload_0
    //   749: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   752: return
    //   753: aload_2
    //   754: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   757: ldc_w 565
    //   760: iload 4
    //   762: iconst_1
    //   763: iadd
    //   764: invokevirtual 176	com/tencent/smtt/sdk/ai:a	(Ljava/lang/String;I)V
    //   767: aload_0
    //   768: aload_1
    //   769: invokevirtual 294	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   772: astore 14
    //   774: aload_2
    //   775: invokestatic 153	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   778: ifne +33 -> 811
    //   781: aload_2
    //   782: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   785: getfield 196	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   788: ldc_w 561
    //   791: iconst_0
    //   792: invokeinterface 204 3 0
    //   797: iconst_1
    //   798: if_icmpne +13 -> 811
    //   801: aload_0
    //   802: aload_2
    //   803: invokevirtual 570	com/tencent/smtt/sdk/am:q	(Landroid/content/Context;)Ljava/io/File;
    //   806: astore 13
    //   808: goto +10 -> 818
    //   811: aload_0
    //   812: aload_2
    //   813: invokevirtual 344	com/tencent/smtt/sdk/am:w	(Landroid/content/Context;)Ljava/io/File;
    //   816: astore 13
    //   818: aload 14
    //   820: ifnull +1159 -> 1979
    //   823: aload 13
    //   825: ifnull +1154 -> 1979
    //   828: aload_2
    //   829: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   832: iload_3
    //   833: iconst_0
    //   834: invokevirtual 282	com/tencent/smtt/sdk/ai:a	(II)V
    //   837: new 572	com/tencent/smtt/utils/x
    //   840: dup
    //   841: invokespecial 573	com/tencent/smtt/utils/x:<init>	()V
    //   844: astore 15
    //   846: aload 15
    //   848: aload 14
    //   850: invokevirtual 575	com/tencent/smtt/utils/x:a	(Ljava/io/File;)V
    //   853: invokestatic 580	java/lang/System:currentTimeMillis	()J
    //   856: lstore 9
    //   858: aload_1
    //   859: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   862: sipush 64985
    //   865: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   868: aload 14
    //   870: aload 13
    //   872: getstatic 95	com/tencent/smtt/sdk/am:c	Ljava/io/FileFilter;
    //   875: invokestatic 583	com/tencent/smtt/utils/k:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   878: istore 8
    //   880: aload_2
    //   881: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   884: getfield 196	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   887: ldc_w 561
    //   890: iconst_0
    //   891: invokeinterface 204 3 0
    //   896: iconst_1
    //   897: if_icmpne +7 -> 904
    //   900: aload_2
    //   901: invokestatic 585	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   904: new 216	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   911: astore 16
    //   913: aload 16
    //   915: ldc_w 587
    //   918: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 16
    //   924: invokestatic 580	java/lang/System:currentTimeMillis	()J
    //   927: lload 9
    //   929: lsub
    //   930: invokevirtual 557	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: ldc 127
    //   936: aload 16
    //   938: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   944: iload 8
    //   946: ifeq +984 -> 1930
    //   949: aload 15
    //   951: aload 14
    //   953: invokevirtual 589	com/tencent/smtt/utils/x:b	(Ljava/io/File;)V
    //   956: aload 15
    //   958: invokevirtual 591	com/tencent/smtt/utils/x:a	()Z
    //   961: ifne +59 -> 1020
    //   964: ldc 127
    //   966: ldc_w 593
    //   969: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   972: aload 13
    //   974: iconst_1
    //   975: invokestatic 299	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   978: aload_2
    //   979: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   982: sipush 213
    //   985: ldc_w 595
    //   988: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   991: aload_1
    //   992: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   995: sipush 65005
    //   998: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1001: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1004: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1007: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   1010: invokeinterface 529 1 0
    //   1015: aload_0
    //   1016: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   1019: return
    //   1020: new 306	java/io/File
    //   1023: dup
    //   1024: aload 13
    //   1026: ldc_w 597
    //   1029: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1032: astore 15
    //   1034: new 390	java/util/Properties
    //   1037: dup
    //   1038: invokespecial 391	java/util/Properties:<init>	()V
    //   1041: astore 14
    //   1043: aload 15
    //   1045: invokevirtual 600	java/io/File:exists	()Z
    //   1048: ifeq +52 -> 1100
    //   1051: new 393	java/io/BufferedInputStream
    //   1054: dup
    //   1055: new 395	java/io/FileInputStream
    //   1058: dup
    //   1059: aload 15
    //   1061: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1064: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1067: astore 15
    //   1069: aload 14
    //   1071: aload 15
    //   1073: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   1076: iconst_1
    //   1077: istore 4
    //   1079: goto +27 -> 1106
    //   1082: astore 14
    //   1084: goto +823 -> 1907
    //   1087: astore 17
    //   1089: aload 14
    //   1091: astore 16
    //   1093: aload 15
    //   1095: astore 14
    //   1097: goto +85 -> 1182
    //   1100: iconst_0
    //   1101: istore 4
    //   1103: aconst_null
    //   1104: astore 15
    //   1106: iload 4
    //   1108: istore 5
    //   1110: aload 14
    //   1112: astore 16
    //   1114: aload 15
    //   1116: ifnull +94 -> 1210
    //   1119: aload 15
    //   1121: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   1124: iload 4
    //   1126: istore 5
    //   1128: aload 14
    //   1130: astore 16
    //   1132: goto +78 -> 1210
    //   1135: astore 15
    //   1137: aload 15
    //   1139: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   1142: iload 4
    //   1144: istore 5
    //   1146: aload 14
    //   1148: astore 16
    //   1150: goto +60 -> 1210
    //   1153: astore 15
    //   1155: aload 14
    //   1157: astore 16
    //   1159: goto +16 -> 1175
    //   1162: astore 14
    //   1164: aconst_null
    //   1165: astore 15
    //   1167: goto +740 -> 1907
    //   1170: astore 15
    //   1172: aconst_null
    //   1173: astore 16
    //   1175: aconst_null
    //   1176: astore 14
    //   1178: aload 15
    //   1180: astore 17
    //   1182: aload 17
    //   1184: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   1187: aload 14
    //   1189: ifnull +1064 -> 2253
    //   1192: aload 14
    //   1194: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   1197: goto +1056 -> 2253
    //   1200: astore 14
    //   1202: aload 14
    //   1204: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   1207: goto +1046 -> 2253
    //   1210: iload 5
    //   1212: ifeq +1056 -> 2268
    //   1215: aload 13
    //   1217: invokevirtual 604	java/io/File:listFiles	()[Ljava/io/File;
    //   1220: astore 15
    //   1222: aload_1
    //   1223: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1226: sipush 64984
    //   1229: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1232: iconst_0
    //   1233: istore 4
    //   1235: iload 4
    //   1237: aload 15
    //   1239: arraylength
    //   1240: if_icmpge +1028 -> 2268
    //   1243: aload 15
    //   1245: iload 4
    //   1247: aaload
    //   1248: astore 14
    //   1250: ldc_w 597
    //   1253: aload 14
    //   1255: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   1258: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1261: ifne +998 -> 2259
    //   1264: aload 14
    //   1266: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   1269: ldc_w 609
    //   1272: invokevirtual 613	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1275: ifne +984 -> 2259
    //   1278: ldc_w 388
    //   1281: aload 14
    //   1283: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   1286: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1289: ifne +970 -> 2259
    //   1292: aload 14
    //   1294: invokevirtual 616	java/io/File:isDirectory	()Z
    //   1297: ifne +962 -> 2259
    //   1300: aload 14
    //   1302: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   1305: ldc_w 618
    //   1308: invokevirtual 613	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1311: ifeq +6 -> 1317
    //   1314: goto +945 -> 2259
    //   1317: aload 14
    //   1319: invokestatic 623	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1322: astore 17
    //   1324: aload 16
    //   1326: aload 14
    //   1328: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   1331: ldc -75
    //   1333: invokevirtual 627	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1336: astore 18
    //   1338: aload 18
    //   1340: ldc -75
    //   1342: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1345: ifne +64 -> 1409
    //   1348: aload 17
    //   1350: aload 18
    //   1352: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1355: ifeq +54 -> 1409
    //   1358: new 216	java/lang/StringBuilder
    //   1361: dup
    //   1362: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1365: astore 17
    //   1367: aload 17
    //   1369: ldc_w 629
    //   1372: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: pop
    //   1376: aload 17
    //   1378: aload 14
    //   1380: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   1383: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: pop
    //   1387: aload 17
    //   1389: ldc_w 631
    //   1392: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: ldc 127
    //   1398: aload 17
    //   1400: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1406: goto +853 -> 2259
    //   1409: new 216	java/lang/StringBuilder
    //   1412: dup
    //   1413: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1416: astore 15
    //   1418: aload 15
    //   1420: ldc_w 633
    //   1423: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: pop
    //   1427: aload 15
    //   1429: aload 14
    //   1431: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   1434: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload 15
    //   1440: ldc_w 631
    //   1443: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: pop
    //   1447: aload 15
    //   1449: ldc_w 635
    //   1452: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: pop
    //   1456: aload 15
    //   1458: aload 18
    //   1460: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: aload 15
    //   1466: ldc_w 637
    //   1469: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: aload 15
    //   1475: aload 17
    //   1477: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: ldc 127
    //   1483: aload 15
    //   1485: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1488: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1491: iconst_0
    //   1492: istore 8
    //   1494: goto +3 -> 1497
    //   1497: new 216	java/lang/StringBuilder
    //   1500: dup
    //   1501: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1504: astore 14
    //   1506: aload 14
    //   1508: ldc_w 639
    //   1511: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: pop
    //   1515: aload 14
    //   1517: iload 8
    //   1519: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1522: pop
    //   1523: ldc 127
    //   1525: aload 14
    //   1527: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1530: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1533: iload 5
    //   1535: ifeq +64 -> 1599
    //   1538: iload 8
    //   1540: ifne +59 -> 1599
    //   1543: ldc 127
    //   1545: ldc_w 641
    //   1548: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1551: aload 13
    //   1553: iconst_1
    //   1554: invokestatic 299	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   1557: aload_2
    //   1558: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1561: sipush 213
    //   1564: ldc_w 643
    //   1567: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1570: aload_1
    //   1571: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1574: sipush 65004
    //   1577: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1580: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1583: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1586: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   1589: invokeinterface 529 1 0
    //   1594: aload_0
    //   1595: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   1598: return
    //   1599: ldc 127
    //   1601: ldc_w 645
    //   1604: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1607: aload_0
    //   1608: aload_2
    //   1609: iconst_1
    //   1610: invokespecial 339	com/tencent/smtt/sdk/am:g	(Landroid/content/Context;Z)V
    //   1613: aload_1
    //   1614: invokestatic 649	com/tencent/smtt/sdk/ag:b	(Landroid/content/Context;)Ljava/io/File;
    //   1617: astore 15
    //   1619: aload 15
    //   1621: ifnull +41 -> 1662
    //   1624: aload 15
    //   1626: invokevirtual 600	java/io/File:exists	()Z
    //   1629: ifeq +33 -> 1662
    //   1632: aload_2
    //   1633: invokestatic 654	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1636: ifeq +638 -> 2274
    //   1639: ldc_w 656
    //   1642: astore 14
    //   1644: goto +3 -> 1647
    //   1647: new 306	java/io/File
    //   1650: dup
    //   1651: aload 15
    //   1653: aload 14
    //   1655: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1658: aload_2
    //   1659: invokestatic 659	com/tencent/smtt/sdk/ag:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1662: aload_2
    //   1663: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   1666: iload_3
    //   1667: iconst_1
    //   1668: invokevirtual 282	com/tencent/smtt/sdk/ai:a	(II)V
    //   1671: aload_0
    //   1672: getfield 107	com/tencent/smtt/sdk/am:k	Z
    //   1675: ifeq +27 -> 1702
    //   1678: aload_2
    //   1679: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1682: astore 14
    //   1684: ldc_w 661
    //   1687: astore 15
    //   1689: aload 14
    //   1691: sipush 220
    //   1694: aload 15
    //   1696: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1699: goto +17 -> 1716
    //   1702: aload_2
    //   1703: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1706: astore 14
    //   1708: ldc_w 663
    //   1711: astore 15
    //   1713: goto -24 -> 1689
    //   1716: aload_1
    //   1717: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1720: sipush 65003
    //   1723: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1726: new 216	java/lang/StringBuilder
    //   1729: dup
    //   1730: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1733: astore 14
    //   1735: aload 14
    //   1737: ldc_w 665
    //   1740: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: pop
    //   1744: aload 14
    //   1746: iload_3
    //   1747: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1750: pop
    //   1751: ldc 127
    //   1753: aload 14
    //   1755: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1758: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1761: getstatic 480	android/os/Build$VERSION:SDK_INT	I
    //   1764: bipush 11
    //   1766: if_icmplt +16 -> 1782
    //   1769: aload_2
    //   1770: ldc_w 482
    //   1773: iconst_4
    //   1774: invokevirtual 486	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1777: astore 14
    //   1779: goto +13 -> 1792
    //   1782: aload_2
    //   1783: ldc_w 482
    //   1786: iconst_0
    //   1787: invokevirtual 486	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1790: astore 14
    //   1792: aload 14
    //   1794: invokeinterface 669 1 0
    //   1799: astore 14
    //   1801: aload 14
    //   1803: ldc_w 671
    //   1806: iconst_0
    //   1807: invokeinterface 677 3 0
    //   1812: pop
    //   1813: aload 14
    //   1815: ldc_w 679
    //   1818: iconst_0
    //   1819: invokeinterface 677 3 0
    //   1824: pop
    //   1825: aload 14
    //   1827: ldc_w 681
    //   1830: iload_3
    //   1831: invokeinterface 677 3 0
    //   1836: pop
    //   1837: aload 14
    //   1839: invokeinterface 684 1 0
    //   1844: pop
    //   1845: goto +44 -> 1889
    //   1848: astore 14
    //   1850: new 216	java/lang/StringBuilder
    //   1853: dup
    //   1854: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1857: astore 15
    //   1859: aload 15
    //   1861: ldc_w 686
    //   1864: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1867: pop
    //   1868: aload 15
    //   1870: aload 14
    //   1872: invokestatic 692	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1875: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: pop
    //   1879: ldc 127
    //   1881: aload 15
    //   1883: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1889: aload_2
    //   1890: invokestatic 694	com/tencent/smtt/utils/y:a	(Landroid/content/Context;)Z
    //   1893: pop
    //   1894: goto +141 -> 2035
    //   1897: astore 16
    //   1899: aload 14
    //   1901: astore 15
    //   1903: aload 16
    //   1905: astore 14
    //   1907: aload 15
    //   1909: ifnull +18 -> 1927
    //   1912: aload 15
    //   1914: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   1917: goto +10 -> 1927
    //   1920: astore 15
    //   1922: aload 15
    //   1924: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   1927: aload 14
    //   1929: athrow
    //   1930: ldc 127
    //   1932: ldc_w 696
    //   1935: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1938: aload_2
    //   1939: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   1942: iload_3
    //   1943: iconst_2
    //   1944: invokevirtual 282	com/tencent/smtt/sdk/ai:a	(II)V
    //   1947: aload 13
    //   1949: iconst_0
    //   1950: invokestatic 299	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   1953: aload_1
    //   1954: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1957: sipush 65002
    //   1960: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1963: aload_2
    //   1964: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1967: sipush 212
    //   1970: ldc_w 698
    //   1973: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1976: goto +59 -> 2035
    //   1979: aload 14
    //   1981: ifnonnull +26 -> 2007
    //   1984: aload_2
    //   1985: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1988: sipush 213
    //   1991: ldc_w 700
    //   1994: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1997: aload_1
    //   1998: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2001: sipush 65001
    //   2004: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2007: aload 13
    //   2009: ifnonnull +26 -> 2035
    //   2012: aload_2
    //   2013: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2016: sipush 214
    //   2019: ldc_w 702
    //   2022: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   2025: aload_1
    //   2026: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2029: sipush 65000
    //   2032: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2035: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2038: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2041: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   2044: invokeinterface 529 1 0
    //   2049: aload_0
    //   2050: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   2053: return
    //   2054: astore_1
    //   2055: goto +110 -> 2165
    //   2058: astore 13
    //   2060: aconst_null
    //   2061: astore 15
    //   2063: aload 13
    //   2065: astore 14
    //   2067: aload_2
    //   2068: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2071: sipush 215
    //   2074: aload 14
    //   2076: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   2079: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   2082: aload_1
    //   2083: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2086: sipush 64999
    //   2089: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2092: aload 15
    //   2094: iconst_0
    //   2095: invokestatic 299	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   2098: aload_2
    //   2099: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   2102: iconst_0
    //   2103: iconst_m1
    //   2104: invokevirtual 282	com/tencent/smtt/sdk/ai:a	(II)V
    //   2107: goto -72 -> 2035
    //   2110: astore_1
    //   2111: new 216	java/lang/StringBuilder
    //   2114: dup
    //   2115: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   2118: astore_2
    //   2119: aload_2
    //   2120: ldc_w 704
    //   2123: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: pop
    //   2127: aload_2
    //   2128: aload_1
    //   2129: invokevirtual 707	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2132: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: pop
    //   2136: aload_2
    //   2137: ldc_w 709
    //   2140: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: pop
    //   2144: aload_2
    //   2145: aload_1
    //   2146: invokevirtual 713	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   2149: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2152: pop
    //   2153: ldc 127
    //   2155: aload_2
    //   2156: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2159: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2162: goto -127 -> 2035
    //   2165: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2168: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2171: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   2174: invokeinterface 529 1 0
    //   2179: aload_0
    //   2180: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   2183: aload_1
    //   2184: athrow
    //   2185: aload_0
    //   2186: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   2189: aload_1
    //   2190: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2193: sipush 64998
    //   2196: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2199: return
    //   2200: iload 4
    //   2202: ifle +12 -> 2214
    //   2205: iload_3
    //   2206: iload 4
    //   2208: if_icmple +6 -> 2214
    //   2211: goto -1762 -> 449
    //   2214: iload 5
    //   2216: istore 4
    //   2218: iload 5
    //   2220: iconst_3
    //   2221: if_icmpne -1747 -> 474
    //   2224: iload 5
    //   2226: istore 4
    //   2228: iload 6
    //   2230: ifle -1756 -> 474
    //   2233: iload_3
    //   2234: iload 6
    //   2236: if_icmpgt -1779 -> 457
    //   2239: iload 5
    //   2241: istore 4
    //   2243: iload_3
    //   2244: ldc_w 717
    //   2247: if_icmpne -1773 -> 474
    //   2250: goto -1793 -> 457
    //   2253: iconst_1
    //   2254: istore 5
    //   2256: goto -1046 -> 1210
    //   2259: iload 4
    //   2261: iconst_1
    //   2262: iadd
    //   2263: istore 4
    //   2265: goto -1030 -> 1235
    //   2268: iconst_1
    //   2269: istore 8
    //   2271: goto -774 -> 1497
    //   2274: ldc_w 719
    //   2277: astore 14
    //   2279: goto -632 -> 1647
    //   2282: astore 14
    //   2284: aload 13
    //   2286: astore 15
    //   2288: goto -221 -> 2067
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2291	0	this	am
    //   0	2291	1	paramContext1	Context
    //   0	2291	2	paramContext2	Context
    //   0	2291	3	paramInt	int
    //   241	2023	4	i1	int
    //   253	2002	5	i2	int
    //   306	1931	6	i3	int
    //   433	11	7	i4	int
    //   182	2088	8	bool	boolean
    //   484	444	9	l1	long
    //   493	56	11	l2	long
    //   26	1982	13	localObject1	Object
    //   2058	227	13	localException1	Exception
    //   518	552	14	localObject2	Object
    //   1082	8	14	localObject3	Object
    //   1095	61	14	localObject4	Object
    //   1162	1	14	localObject5	Object
    //   1176	17	14	localObject6	Object
    //   1200	3	14	localIOException1	java.io.IOException
    //   1248	590	14	localObject7	Object
    //   1848	52	14	localThrowable	Throwable
    //   1905	373	14	localObject8	Object
    //   2282	1	14	localException2	Exception
    //   844	276	15	localObject9	Object
    //   1135	3	15	localIOException2	java.io.IOException
    //   1153	1	15	localException3	Exception
    //   1165	1	15	localObject10	Object
    //   1170	9	15	localException4	Exception
    //   1220	693	15	localObject11	Object
    //   1920	3	15	localIOException3	java.io.IOException
    //   2061	226	15	localObject12	Object
    //   911	414	16	localObject13	Object
    //   1897	7	16	localObject14	Object
    //   1087	1	17	localException5	Exception
    //   1180	296	17	localObject15	Object
    //   1336	123	18	str	String
    // Exception table:
    //   from	to	target	type
    //   1069	1076	1082	finally
    //   1069	1076	1087	java/lang/Exception
    //   1119	1124	1135	java/io/IOException
    //   1043	1069	1153	java/lang/Exception
    //   1020	1043	1162	finally
    //   1043	1069	1162	finally
    //   1020	1043	1170	java/lang/Exception
    //   1192	1197	1200	java/io/IOException
    //   1792	1845	1848	java/lang/Throwable
    //   1182	1187	1897	finally
    //   1912	1917	1920	java/io/IOException
    //   231	255	2054	finally
    //   261	282	2054	finally
    //   301	344	2054	finally
    //   350	407	2054	finally
    //   426	435	2054	finally
    //   449	454	2054	finally
    //   457	471	2054	finally
    //   474	567	2054	finally
    //   591	627	2054	finally
    //   630	669	2054	finally
    //   693	705	2054	finally
    //   711	734	2054	finally
    //   753	767	2054	finally
    //   767	808	2054	finally
    //   811	818	2054	finally
    //   828	904	2054	finally
    //   904	944	2054	finally
    //   949	1001	2054	finally
    //   1119	1124	2054	finally
    //   1137	1142	2054	finally
    //   1192	1197	2054	finally
    //   1202	1207	2054	finally
    //   1215	1232	2054	finally
    //   1235	1243	2054	finally
    //   1250	1314	2054	finally
    //   1317	1406	2054	finally
    //   1409	1491	2054	finally
    //   1497	1533	2054	finally
    //   1543	1580	2054	finally
    //   1599	1619	2054	finally
    //   1624	1639	2054	finally
    //   1647	1662	2054	finally
    //   1662	1684	2054	finally
    //   1689	1699	2054	finally
    //   1702	1708	2054	finally
    //   1716	1779	2054	finally
    //   1782	1792	2054	finally
    //   1792	1845	2054	finally
    //   1850	1889	2054	finally
    //   1889	1894	2054	finally
    //   1912	1917	2054	finally
    //   1922	1927	2054	finally
    //   1927	1930	2054	finally
    //   1930	1976	2054	finally
    //   1984	2007	2054	finally
    //   2012	2035	2054	finally
    //   2067	2092	2054	finally
    //   2092	2107	2054	finally
    //   2111	2162	2054	finally
    //   231	255	2058	java/lang/Exception
    //   261	282	2058	java/lang/Exception
    //   301	344	2058	java/lang/Exception
    //   350	407	2058	java/lang/Exception
    //   426	435	2058	java/lang/Exception
    //   449	454	2058	java/lang/Exception
    //   457	471	2058	java/lang/Exception
    //   474	567	2058	java/lang/Exception
    //   591	627	2058	java/lang/Exception
    //   630	669	2058	java/lang/Exception
    //   693	705	2058	java/lang/Exception
    //   711	734	2058	java/lang/Exception
    //   753	767	2058	java/lang/Exception
    //   767	808	2058	java/lang/Exception
    //   811	818	2058	java/lang/Exception
    //   2092	2107	2110	java/lang/Exception
    //   828	904	2282	java/lang/Exception
    //   904	944	2282	java/lang/Exception
    //   949	1001	2282	java/lang/Exception
    //   1119	1124	2282	java/lang/Exception
    //   1137	1142	2282	java/lang/Exception
    //   1192	1197	2282	java/lang/Exception
    //   1202	1207	2282	java/lang/Exception
    //   1215	1232	2282	java/lang/Exception
    //   1235	1243	2282	java/lang/Exception
    //   1250	1314	2282	java/lang/Exception
    //   1317	1406	2282	java/lang/Exception
    //   1409	1491	2282	java/lang/Exception
    //   1497	1533	2282	java/lang/Exception
    //   1543	1580	2282	java/lang/Exception
    //   1599	1619	2282	java/lang/Exception
    //   1624	1639	2282	java/lang/Exception
    //   1647	1662	2282	java/lang/Exception
    //   1662	1684	2282	java/lang/Exception
    //   1689	1699	2282	java/lang/Exception
    //   1702	1708	2282	java/lang/Exception
    //   1716	1779	2282	java/lang/Exception
    //   1782	1792	2282	java/lang/Exception
    //   1792	1845	2282	java/lang/Exception
    //   1850	1889	2282	java/lang/Exception
    //   1889	1894	2282	java/lang/Exception
    //   1912	1917	2282	java/lang/Exception
    //   1922	1927	2282	java/lang/Exception
    //   1927	1930	2282	java/lang/Exception
    //   1930	1976	2282	java/lang/Exception
    //   1984	2007	2282	java/lang/Exception
    //   2012	2035	2282	java/lang/Exception
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 127
    //   2: ldc_w 730
    //   5: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_2
    //   9: invokestatic 732	com/tencent/smtt/utils/k:c	(Ljava/io/File;)Z
    //   12: ifne +34 -> 46
    //   15: aload_1
    //   16: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   19: sipush 204
    //   22: ldc_w 734
    //   25: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   28: aload_1
    //   29: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   32: astore_1
    //   33: sipush 65016
    //   36: istore 4
    //   38: aload_1
    //   39: iload 4
    //   41: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: iconst_1
    //   47: istore 6
    //   49: iconst_1
    //   50: istore 5
    //   52: aload_1
    //   53: ldc_w 374
    //   56: iconst_0
    //   57: invokevirtual 378	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   60: astore 9
    //   62: iload_3
    //   63: ifeq +20 -> 83
    //   66: new 306	java/io/File
    //   69: dup
    //   70: aload 9
    //   72: ldc_w 736
    //   75: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   78: astore 9
    //   80: goto +17 -> 97
    //   83: new 306	java/io/File
    //   86: dup
    //   87: aload 9
    //   89: ldc_w 380
    //   92: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   95: astore 9
    //   97: aload 9
    //   99: invokevirtual 600	java/io/File:exists	()Z
    //   102: ifeq +72 -> 174
    //   105: aload_1
    //   106: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   109: getfield 196	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   112: ldc_w 561
    //   115: iconst_0
    //   116: invokeinterface 204 3 0
    //   121: iconst_1
    //   122: if_icmpeq +52 -> 174
    //   125: aload 9
    //   127: invokestatic 737	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   130: goto +44 -> 174
    //   133: astore 9
    //   135: new 216	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   142: astore 10
    //   144: aload 10
    //   146: ldc_w 739
    //   149: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 10
    //   155: aload 9
    //   157: invokestatic 692	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   160: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 127
    //   166: aload 10
    //   168: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: iload_3
    //   175: ifeq +13 -> 188
    //   178: aload_0
    //   179: aload_1
    //   180: invokevirtual 742	com/tencent/smtt/sdk/am:v	(Landroid/content/Context;)Ljava/io/File;
    //   183: astore 9
    //   185: goto +10 -> 195
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual 304	com/tencent/smtt/sdk/am:u	(Landroid/content/Context;)Ljava/io/File;
    //   193: astore 9
    //   195: aload 9
    //   197: ifnonnull +29 -> 226
    //   200: aload_1
    //   201: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   204: sipush 205
    //   207: ldc_w 744
    //   210: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   213: aload_1
    //   214: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   217: astore_1
    //   218: sipush 65015
    //   221: istore 4
    //   223: goto -185 -> 38
    //   226: aload 9
    //   228: invokestatic 746	com/tencent/smtt/utils/k:a	(Ljava/io/File;)Z
    //   231: pop
    //   232: iload_3
    //   233: ifeq +9 -> 242
    //   236: aload 9
    //   238: iconst_1
    //   239: invokestatic 299	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   242: aload_2
    //   243: aload 9
    //   245: invokestatic 749	com/tencent/smtt/utils/k:a	(Ljava/io/File;Ljava/io/File;)Z
    //   248: istore 8
    //   250: iload 8
    //   252: istore 7
    //   254: iload 8
    //   256: ifeq +12 -> 268
    //   259: aload_0
    //   260: aload 9
    //   262: aload_1
    //   263: invokespecial 752	com/tencent/smtt/sdk/am:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   266: istore 7
    //   268: iload_3
    //   269: ifeq +84 -> 353
    //   272: aload 9
    //   274: invokevirtual 756	java/io/File:list	()[Ljava/lang/String;
    //   277: astore_2
    //   278: iconst_0
    //   279: istore 4
    //   281: iload 4
    //   283: aload_2
    //   284: arraylength
    //   285: if_icmpge +47 -> 332
    //   288: new 306	java/io/File
    //   291: dup
    //   292: aload 9
    //   294: aload_2
    //   295: iload 4
    //   297: aaload
    //   298: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   301: astore 10
    //   303: aload 10
    //   305: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   308: ldc_w 609
    //   311: invokevirtual 613	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   314: ifeq +9 -> 323
    //   317: aload 10
    //   319: invokevirtual 366	java/io/File:delete	()Z
    //   322: pop
    //   323: iload 4
    //   325: iconst_1
    //   326: iadd
    //   327: istore 4
    //   329: goto -48 -> 281
    //   332: new 306	java/io/File
    //   335: dup
    //   336: aload_1
    //   337: invokestatic 759	com/tencent/smtt/sdk/am:t	(Landroid/content/Context;)Ljava/io/File;
    //   340: ldc_w 761
    //   343: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   346: invokevirtual 366	java/io/File:delete	()Z
    //   349: pop
    //   350: goto +3 -> 353
    //   353: iload 7
    //   355: ifne +56 -> 411
    //   358: aload 9
    //   360: invokestatic 737	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   363: aload_1
    //   364: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   367: sipush 65014
    //   370: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   373: new 216	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   380: astore_2
    //   381: aload_2
    //   382: ldc_w 763
    //   385: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: aload 9
    //   392: invokevirtual 600	java/io/File:exists	()Z
    //   395: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: ldc 127
    //   401: aload_2
    //   402: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: goto +35 -> 443
    //   411: aload_0
    //   412: aload_1
    //   413: iconst_1
    //   414: invokespecial 339	com/tencent/smtt/sdk/am:g	(Landroid/content/Context;Z)V
    //   417: iload_3
    //   418: ifeq +25 -> 443
    //   421: aload_0
    //   422: aload_1
    //   423: invokevirtual 570	com/tencent/smtt/sdk/am:q	(Landroid/content/Context;)Ljava/io/File;
    //   426: astore_2
    //   427: aload_2
    //   428: iconst_1
    //   429: invokestatic 299	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   432: aload 9
    //   434: aload_2
    //   435: invokevirtual 310	java/io/File:renameTo	(Ljava/io/File;)Z
    //   438: pop
    //   439: aload_1
    //   440: invokestatic 585	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   443: ldc 127
    //   445: ldc_w 765
    //   448: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: iload 7
    //   453: ireturn
    //   454: astore_1
    //   455: goto +293 -> 748
    //   458: astore_2
    //   459: aload_1
    //   460: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   463: sipush 65013
    //   466: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   469: aload_1
    //   470: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   473: sipush 207
    //   476: aload_2
    //   477: invokevirtual 768	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/Throwable;)V
    //   480: aload 9
    //   482: ifnull +20 -> 502
    //   485: aload 9
    //   487: invokevirtual 600	java/io/File:exists	()Z
    //   490: istore_3
    //   491: iload_3
    //   492: ifeq +10 -> 502
    //   495: iload 5
    //   497: istore 4
    //   499: goto +6 -> 505
    //   502: iconst_0
    //   503: istore 4
    //   505: iload 4
    //   507: ifeq +86 -> 593
    //   510: aload 9
    //   512: ifnull +81 -> 593
    //   515: aload 9
    //   517: invokestatic 737	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   520: new 216	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   527: astore_1
    //   528: aload_1
    //   529: ldc_w 770
    //   532: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload_1
    //   537: aload 9
    //   539: invokevirtual 600	java/io/File:exists	()Z
    //   542: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: ldc 127
    //   548: aload_1
    //   549: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: goto +38 -> 593
    //   558: astore_1
    //   559: new 216	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   566: astore_2
    //   567: aload_2
    //   568: ldc_w 772
    //   571: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_2
    //   576: aload_1
    //   577: invokestatic 692	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   580: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: ldc 127
    //   586: aload_2
    //   587: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: ldc 127
    //   595: ldc_w 765
    //   598: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: iconst_0
    //   602: ireturn
    //   603: astore_2
    //   604: aload_1
    //   605: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   608: sipush 65013
    //   611: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   614: aload_1
    //   615: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   618: sipush 206
    //   621: aload_2
    //   622: invokevirtual 768	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/Throwable;)V
    //   625: aload 9
    //   627: ifnull +20 -> 647
    //   630: aload 9
    //   632: invokevirtual 600	java/io/File:exists	()Z
    //   635: istore_3
    //   636: iload_3
    //   637: ifeq +10 -> 647
    //   640: iload 6
    //   642: istore 4
    //   644: goto +6 -> 650
    //   647: iconst_0
    //   648: istore 4
    //   650: iload 4
    //   652: ifeq +86 -> 738
    //   655: aload 9
    //   657: ifnull +81 -> 738
    //   660: aload 9
    //   662: invokestatic 737	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   665: new 216	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   672: astore_1
    //   673: aload_1
    //   674: ldc_w 770
    //   677: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload_1
    //   682: aload 9
    //   684: invokevirtual 600	java/io/File:exists	()Z
    //   687: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: ldc 127
    //   693: aload_1
    //   694: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: goto +38 -> 738
    //   703: astore_1
    //   704: new 216	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   711: astore_2
    //   712: aload_2
    //   713: ldc_w 772
    //   716: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload_2
    //   721: aload_1
    //   722: invokestatic 692	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   725: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: ldc 127
    //   731: aload_2
    //   732: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: ldc 127
    //   740: ldc_w 765
    //   743: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: iconst_0
    //   747: ireturn
    //   748: ldc 127
    //   750: ldc_w 765
    //   753: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload_1
    //   757: athrow
    //   758: astore_2
    //   759: goto -406 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	am
    //   0	762	1	paramContext	Context
    //   0	762	2	paramFile	File
    //   0	762	3	paramBoolean	boolean
    //   36	615	4	i1	int
    //   50	446	5	i2	int
    //   47	594	6	i3	int
    //   252	200	7	bool1	boolean
    //   248	7	8	bool2	boolean
    //   60	66	9	localFile1	File
    //   133	23	9	localThrowable	Throwable
    //   183	500	9	localFile2	File
    //   142	176	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	62	133	java/lang/Throwable
    //   66	80	133	java/lang/Throwable
    //   83	97	133	java/lang/Throwable
    //   97	130	133	java/lang/Throwable
    //   226	232	454	finally
    //   236	242	454	finally
    //   242	250	454	finally
    //   259	268	454	finally
    //   272	278	454	finally
    //   281	323	454	finally
    //   332	350	454	finally
    //   358	408	454	finally
    //   411	417	454	finally
    //   421	443	454	finally
    //   459	480	454	finally
    //   485	491	454	finally
    //   604	625	454	finally
    //   630	636	454	finally
    //   226	232	458	java/lang/Exception
    //   236	242	458	java/lang/Exception
    //   242	250	458	java/lang/Exception
    //   259	268	458	java/lang/Exception
    //   272	278	458	java/lang/Exception
    //   281	323	458	java/lang/Exception
    //   358	408	458	java/lang/Exception
    //   411	417	458	java/lang/Exception
    //   421	443	458	java/lang/Exception
    //   515	555	558	java/lang/Throwable
    //   226	232	603	java/io/IOException
    //   236	242	603	java/io/IOException
    //   242	250	603	java/io/IOException
    //   259	268	603	java/io/IOException
    //   272	278	603	java/io/IOException
    //   281	323	603	java/io/IOException
    //   332	350	603	java/io/IOException
    //   358	408	603	java/io/IOException
    //   411	417	603	java/io/IOException
    //   421	443	603	java/io/IOException
    //   660	700	703	java/lang/Throwable
    //   332	350	758	java/lang/Exception
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: new 216	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 774
    //   14: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_1
    //   21: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 776
    //   30: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 127
    //   43: aload 6
    //   45: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 9
    //   57: aconst_null
    //   58: astore 6
    //   60: aload 7
    //   62: astore_2
    //   63: new 306	java/io/File
    //   66: dup
    //   67: aload_1
    //   68: ldc_w 597
    //   71: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore 10
    //   76: aload 7
    //   78: astore_2
    //   79: new 390	java/util/Properties
    //   82: dup
    //   83: invokespecial 391	java/util/Properties:<init>	()V
    //   86: astore 8
    //   88: aload 7
    //   90: astore_2
    //   91: aload 10
    //   93: invokevirtual 600	java/io/File:exists	()Z
    //   96: ifeq +62 -> 158
    //   99: aload 7
    //   101: astore_2
    //   102: new 393	java/io/BufferedInputStream
    //   105: dup
    //   106: new 395	java/io/FileInputStream
    //   109: dup
    //   110: aload 10
    //   112: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: astore 6
    //   120: aload 8
    //   122: aload 6
    //   124: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   127: aload 6
    //   129: astore_2
    //   130: iconst_1
    //   131: istore 4
    //   133: goto +31 -> 164
    //   136: astore_1
    //   137: aload 6
    //   139: astore_2
    //   140: goto +477 -> 617
    //   143: astore 7
    //   145: aload 6
    //   147: astore_2
    //   148: aload 8
    //   150: astore 6
    //   152: aload_2
    //   153: astore 8
    //   155: goto +78 -> 233
    //   158: iconst_0
    //   159: istore 4
    //   161: aload 6
    //   163: astore_2
    //   164: iload 4
    //   166: istore 5
    //   168: aload 8
    //   170: astore 6
    //   172: aload_2
    //   173: ifnull +89 -> 262
    //   176: aload_2
    //   177: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   180: iload 4
    //   182: istore 5
    //   184: aload 8
    //   186: astore 6
    //   188: goto +74 -> 262
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   196: iload 4
    //   198: istore 5
    //   200: aload 8
    //   202: astore 6
    //   204: goto +58 -> 262
    //   207: astore 7
    //   209: aload 8
    //   211: astore 6
    //   213: aload 9
    //   215: astore 8
    //   217: goto +16 -> 233
    //   220: astore_1
    //   221: goto +396 -> 617
    //   224: astore 7
    //   226: aconst_null
    //   227: astore 6
    //   229: aload 9
    //   231: astore 8
    //   233: aload 8
    //   235: astore_2
    //   236: aload 7
    //   238: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   241: aload 8
    //   243: ifnull +16 -> 259
    //   246: aload 8
    //   248: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   251: goto +8 -> 259
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   259: iconst_1
    //   260: istore 5
    //   262: new 216	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   269: astore_2
    //   270: aload_2
    //   271: ldc_w 778
    //   274: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: iload 5
    //   281: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: ldc 127
    //   287: aload_2
    //   288: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: iload 5
    //   296: ifeq +256 -> 552
    //   299: aload_1
    //   300: invokevirtual 604	java/io/File:listFiles	()[Ljava/io/File;
    //   303: astore_2
    //   304: iconst_0
    //   305: istore_3
    //   306: iload_3
    //   307: aload_2
    //   308: arraylength
    //   309: if_icmpge +243 -> 552
    //   312: aload_2
    //   313: iload_3
    //   314: aaload
    //   315: astore_1
    //   316: ldc_w 597
    //   319: aload_1
    //   320: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   323: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifne +219 -> 545
    //   329: aload_1
    //   330: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   333: ldc_w 609
    //   336: invokevirtual 613	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   339: ifne +206 -> 545
    //   342: ldc_w 388
    //   345: aload_1
    //   346: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   349: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   352: ifne +193 -> 545
    //   355: aload_1
    //   356: invokevirtual 616	java/io/File:isDirectory	()Z
    //   359: ifne +186 -> 545
    //   362: aload_1
    //   363: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   366: ldc_w 618
    //   369: invokevirtual 613	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   372: ifeq +6 -> 378
    //   375: goto +170 -> 545
    //   378: aload_1
    //   379: invokestatic 623	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   382: astore 7
    //   384: aload 6
    //   386: aload_1
    //   387: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   390: ldc -75
    //   392: invokevirtual 627	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   395: astore 8
    //   397: aload 8
    //   399: ldc -75
    //   401: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   404: ifne +63 -> 467
    //   407: aload 8
    //   409: aload 7
    //   411: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   414: ifeq +53 -> 467
    //   417: new 216	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   424: astore 7
    //   426: aload 7
    //   428: ldc_w 629
    //   431: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 7
    //   437: aload_1
    //   438: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   441: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 7
    //   447: ldc_w 631
    //   450: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: ldc 127
    //   456: aload 7
    //   458: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: goto +81 -> 545
    //   467: new 216	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   474: astore_2
    //   475: aload_2
    //   476: ldc_w 633
    //   479: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_2
    //   484: aload_1
    //   485: invokevirtual 607	java/io/File:getName	()Ljava/lang/String;
    //   488: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_2
    //   493: ldc_w 631
    //   496: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_2
    //   501: ldc_w 635
    //   504: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_2
    //   509: aload 8
    //   511: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_2
    //   516: ldc_w 637
    //   519: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_2
    //   524: aload 7
    //   526: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: ldc 127
    //   532: aload_2
    //   533: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: iconst_0
    //   540: istore 4
    //   542: goto +13 -> 555
    //   545: iload_3
    //   546: iconst_1
    //   547: iadd
    //   548: istore_3
    //   549: goto -243 -> 306
    //   552: iconst_1
    //   553: istore 4
    //   555: new 216	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   562: astore_1
    //   563: aload_1
    //   564: ldc_w 780
    //   567: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload_1
    //   572: iload 4
    //   574: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: ldc 127
    //   580: aload_1
    //   581: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: iload 5
    //   589: ifeq +18 -> 607
    //   592: iload 4
    //   594: ifne +13 -> 607
    //   597: ldc 127
    //   599: ldc_w 782
    //   602: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: iconst_0
    //   606: ireturn
    //   607: ldc 127
    //   609: ldc_w 784
    //   612: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: iconst_1
    //   616: ireturn
    //   617: aload_2
    //   618: ifnull +15 -> 633
    //   621: aload_2
    //   622: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   625: goto +8 -> 633
    //   628: astore_2
    //   629: aload_2
    //   630: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   633: aload_1
    //   634: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	this	am
    //   0	635	1	paramFile	File
    //   0	635	2	paramContext	Context
    //   305	244	3	i1	int
    //   131	462	4	bool1	boolean
    //   166	422	5	bool2	boolean
    //   7	378	6	localObject1	Object
    //   52	48	7	localObject2	Object
    //   143	1	7	localException1	Exception
    //   207	1	7	localException2	Exception
    //   224	13	7	localException3	Exception
    //   382	143	7	localObject3	Object
    //   86	424	8	localObject4	Object
    //   55	175	9	localObject5	Object
    //   74	37	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   120	127	136	finally
    //   120	127	143	java/lang/Exception
    //   176	180	191	java/io/IOException
    //   91	99	207	java/lang/Exception
    //   102	120	207	java/lang/Exception
    //   63	76	220	finally
    //   79	88	220	finally
    //   91	99	220	finally
    //   102	120	220	finally
    //   236	241	220	finally
    //   63	76	224	java/lang/Exception
    //   79	88	224	java/lang/Exception
    //   246	251	254	java/io/IOException
    //   621	625	628	java/io/IOException
  }
  
  @TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65035);
    if (c(paramContext))
    {
      TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65034);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsApkPath=");
    ((StringBuilder)localObject1).append(paramString);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=");
    ((StringBuilder)localObject1).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject1).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread currentProcessId=");
    ((StringBuilder)localObject1).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread currentThreadName=");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (Build.VERSION.SDK_INT >= 11) {
      localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
    } else {
      localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
    }
    if (((SharedPreferences)localObject1).getInt("tbs_precheck_disable_version", -1) == paramInt)
    {
      paramString = new StringBuilder();
      paramString.append("TbsInstaller-installTbsCoreInThread -- version:");
      paramString.append(paramInt);
      paramString.append(" is disabled by preload_x5_check!");
      TbsLog.e("TbsInstaller", paramString.toString());
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65033);
      return;
    }
    if (!k.b(paramContext))
    {
      long l1 = y.a();
      long l2 = TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace();
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65032);
      paramContext = TbsLogReport.a(paramContext);
      paramString = new StringBuilder();
      paramString.append("rom is not enough when installing tbs core! curAvailROM=");
      paramString.append(l1);
      paramString.append(",minReqRom=");
      paramString.append(l2);
      paramContext.a(210, paramString.toString());
      return;
    }
    if (!x(paramContext))
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65031);
      return;
    }
    boolean bool = j.tryLock();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread locked =");
    ((StringBuilder)localObject1).append(bool);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (bool)
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65029);
      i.lock();
    }
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      try
      {
        i1 = ai.a(paramContext).c("copy_core_ver");
        i2 = ai.a(paramContext).b();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =");
        ((StringBuilder)localObject1).append(i1);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =");
        ((StringBuilder)localObject1).append(i2);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =");
        ((StringBuilder)localObject1).append(paramInt);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        if ((i2 <= 0) || (paramInt <= i2)) {
          break label2367;
        }
        p(paramContext);
        i2 = ai.a(paramContext).c();
        i3 = j(paramContext);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread installStatus1=");
        ((StringBuilder)localObject1).append(i2);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=");
        ((StringBuilder)localObject1).append(i3);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        if ((i2 < 0) || (i2 >= 2)) {
          break label2381;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
        i3 = 1;
        i1 = i2;
        i2 = i3;
        continue;
        p(paramContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
        i1 = -1;
        break label2420;
        TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65028);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread installStatus2=");
        ((StringBuilder)localObject1).append(i1);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        Object localObject2;
        if (i1 < 1)
        {
          TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65027);
          if (i2 != 0)
          {
            i3 = ai.a(paramContext).c("unzip_retry_num");
            if (i3 > 10)
            {
              TbsLogReport.a(paramContext).a(201, "exceed unzip retry num!");
              F(paramContext);
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65026);
              return;
            }
            ai.a(paramContext).b(i3 + 1);
          }
          if (paramString == null)
          {
            localObject2 = ai.a(paramContext).d("install_apk_path");
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              TbsLogReport.a(paramContext).a(202, "apk path is null!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65025);
            }
          }
          else
          {
            localObject1 = paramString;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("TbsInstaller-installTbsCoreInThread apkPath =");
          ((StringBuilder)localObject2).append((String)localObject1);
          TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
          int i4 = b(paramContext, (String)localObject1);
          if (i4 == 0)
          {
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65024);
            TbsLogReport.a(paramContext).a(203, "apk version is 0!");
            return;
          }
          ai.a(paramContext).a("install_apk_path", (String)localObject1);
          ai.a(paramContext).b(i4, 0);
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(64988);
          if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1)
          {
            if (!a(paramContext, new File((String)localObject1), true)) {
              TbsLogReport.a(paramContext).a(207, "unzipTbsApk failed", TbsLogReport.EventType.TYPE_INSTALL_DECOUPLE);
            }
          }
          else if (!b(paramContext, new File((String)localObject1)))
          {
            TbsLogReport.a(paramContext).a(207, "unzipTbsApk failed");
            return;
          }
          if (i2 != 0)
          {
            i3 = ai.a(paramContext).b("unlzma_status");
            if (i3 > 5)
            {
              TbsLogReport.a(paramContext).a(223, "exceed unlzma retry num!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(64983);
              F(paramContext);
              ag.c(paramContext);
              TbsDownloadConfig.getInstance(paramContext).a.put("tbs_needdownload", Boolean.valueOf(true));
              TbsDownloadConfig.getInstance(paramContext).a.put("request_full_package", Boolean.valueOf(true));
              TbsDownloadConfig.getInstance(paramContext).commit();
              return;
            }
            ai.a(paramContext).d(i3 + 1);
          }
          TbsLog.i("TbsInstaller", "unlzma begin");
          i3 = TbsDownloadConfig.getInstance().mPreferences.getInt("tbs_responsecode", 0);
          if (j(paramContext) != 0)
          {
            localObject1 = QbSdk.a(paramContext, "can_unlzma", null);
            if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
              break label2426;
            }
            bool = ((Boolean)localObject1).booleanValue();
            if (bool)
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("responseCode", i3);
              if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1)
              {
                localObject1 = q(paramContext).getAbsolutePath();
                ((Bundle)localObject2).putString("unzip_temp_path", (String)localObject1);
              }
              else
              {
                localObject1 = u(paramContext).getAbsolutePath();
                continue;
              }
              localObject1 = QbSdk.a(paramContext, "unlzma", (Bundle)localObject2);
              if (localObject1 == null)
              {
                TbsLog.i("TbsInstaller", "unlzma return null");
                localObject1 = TbsLogReport.a(paramContext);
                localObject2 = "unlzma is null";
                ((TbsLogReport)localObject1).a(222, (String)localObject2);
              }
              else
              {
                if ((localObject1 instanceof Boolean))
                {
                  if (((Boolean)localObject1).booleanValue())
                  {
                    TbsLog.i("TbsInstaller", "unlzma success");
                    break label2432;
                  }
                  TbsLog.i("TbsInstaller", "unlzma return false");
                  localObject1 = TbsLogReport.a(paramContext);
                  localObject2 = "unlzma return false";
                  continue;
                }
                if ((localObject1 instanceof Bundle)) {
                  break label2432;
                }
                if ((localObject1 instanceof Throwable))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("unlzma failure because Throwable");
                  ((StringBuilder)localObject2).append(Log.getStackTraceString((Throwable)localObject1));
                  TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
                  TbsLogReport.a(paramContext).a(222, (Throwable)localObject1);
                }
              }
              i3 = 0;
              if (i3 == 0) {
                return;
              }
            }
          }
          TbsLog.i("TbsInstaller", "unlzma finished");
          ai.a(paramContext).b(i4, 1);
          i3 = i4;
        }
        else
        {
          if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) != 1) {
            break label2438;
          }
          if (paramString == null)
          {
            localObject2 = ai.a(paramContext).d("install_apk_path");
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              TbsLogReport.a(paramContext).a(202, "apk path is null!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65025);
            }
          }
          else
          {
            localObject1 = paramString;
          }
          a(paramContext, new File((String)localObject1), true);
          break label2438;
        }
        if (i1 < 2)
        {
          if (i2 != 0)
          {
            i1 = ai.a(paramContext).c("dexopt_retry_num");
            if (i1 > 10)
            {
              TbsLogReport.a(paramContext).a(208, "exceed dexopt retry num!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65022);
              F(paramContext);
              return;
            }
            ai.a(paramContext).a(i1 + 1);
          }
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(64987);
          if (!e(paramContext, 0))
          {
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65021);
            return;
          }
          ai.a(paramContext).b(i3, 2);
          TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("STEP 2/2 installation completed! you can restart! version:");
          ((StringBuilder)localObject1).append(paramInt);
          TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65020);
          if (Build.VERSION.SDK_INT >= 11) {
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
          } else {
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
          }
          try
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject1).putInt("tbs_preload_x5_counter", 0);
            ((SharedPreferences.Editor)localObject1).putInt("tbs_preload_x5_recorder", 0);
            ((SharedPreferences.Editor)localObject1).putInt("tbs_preload_x5_version", paramInt);
            ((SharedPreferences.Editor)localObject1).commit();
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65019);
          }
          catch (Throwable localThrowable)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Init tbs_preload_x5_counter#1 exception:");
            ((StringBuilder)localObject2).append(Log.getStackTraceString(localThrowable));
            TbsLog.e("TbsInstaller", ((StringBuilder)localObject2).toString());
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65018);
            continue;
          }
          if (paramInt == 88888888) {
            a(paramInt, paramString, paramContext);
          }
          bool = this.k;
          paramInt = 221;
          if (bool)
          {
            paramString = TbsLogReport.a(paramContext);
            if (ai.a(paramContext).d() != 1) {
              break label2444;
            }
            break label2448;
            paramContext.a(paramInt, paramString);
          }
          else
          {
            paramString = TbsLogReport.a(paramContext);
            if (ai.a(paramContext).d() != 1) {
              break label2461;
            }
            break label2465;
          }
        }
        else if (i1 == 2)
        {
          QbSdk.m.onInstallFinish(200);
        }
        i.unlock();
        j.unlock();
      }
      finally
      {
        i.unlock();
        j.unlock();
        b();
      }
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65017);
      b();
      return;
      label2367:
      if ((i1 > 0) && (paramInt > i1))
      {
        continue;
        label2381:
        i1 = i2;
        if (i2 == 3)
        {
          i1 = i2;
          if (i3 > 0)
          {
            if (paramInt > i3) {
              continue;
            }
            i1 = i2;
            if (paramInt == 88888888) {
              continue;
            }
          }
        }
        label2420:
        i2 = 0;
        continue;
        label2426:
        bool = false;
        continue;
        label2432:
        i3 = 1;
        continue;
        label2438:
        i3 = 0;
        continue;
        label2444:
        paramInt = 200;
        label2448:
        String str = "continueInstallWithout core success";
        paramContext = paramString;
        paramString = str;
        continue;
        label2461:
        paramInt = 200;
        label2465:
        str = "success";
        paramContext = paramString;
        paramString = str;
      }
    }
  }
  
  private boolean b(Context paramContext, File paramFile)
  {
    return a(paramContext, paramFile, false);
  }
  
  /* Error */
  private boolean c(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: new 964	com/tencent/smtt/sdk/au
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 967	com/tencent/smtt/sdk/au:<init>	(Lcom/tencent/smtt/sdk/am;)V
    //   9: invokevirtual 970	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: arraylength
    //   17: istore 4
    //   19: getstatic 480	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 16
    //   24: if_icmpge +33 -> 57
    //   27: aload_1
    //   28: invokevirtual 973	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: ifnull +26 -> 57
    //   34: aload_1
    //   35: invokevirtual 973	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: ldc_w 975
    //   41: invokevirtual 978	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifeq +9 -> 57
    //   51: ldc2_w 979
    //   54: invokestatic 984	java/lang/Thread:sleep	(J)V
    //   57: aload_1
    //   58: invokevirtual 988	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   61: astore 7
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: iload 4
    //   68: if_icmpge +73 -> 141
    //   71: new 216	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   78: astore 8
    //   80: aload 8
    //   82: ldc_w 990
    //   85: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: aload 6
    //   93: iload_3
    //   94: aaload
    //   95: invokevirtual 926	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   98: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 127
    //   104: aload 8
    //   106: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: new 992	dalvik/system/DexClassLoader
    //   115: dup
    //   116: aload 6
    //   118: iload_3
    //   119: aaload
    //   120: invokevirtual 926	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: aload_2
    //   124: invokevirtual 926	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: aconst_null
    //   128: aload 7
    //   130: invokespecial 995	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   133: pop
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: istore_3
    //   138: goto -73 -> 65
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   148: aload_1
    //   149: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   152: sipush 209
    //   155: aload_2
    //   156: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   159: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   162: ldc 127
    //   164: ldc_w 997
    //   167: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: iconst_0
    //   171: ireturn
    //   172: astore 7
    //   174: goto -117 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	am
    //   0	177	1	paramContext	Context
    //   0	177	2	paramFile	File
    //   64	74	3	i1	int
    //   17	52	4	i2	int
    //   44	3	5	bool	boolean
    //   12	105	6	arrayOfFile	File[]
    //   61	68	7	localClassLoader	ClassLoader
    //   172	1	7	localException	Exception
    //   78	27	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	46	143	java/lang/Exception
    //   57	63	143	java/lang/Exception
    //   71	134	143	java/lang/Exception
    //   51	57	172	java/lang/Exception
  }
  
  private boolean d(Context paramContext, File paramFile)
  {
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = g.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.a(paramContext).a(226, "can not find oat command");
        return false;
      }
      paramFile = paramFile.listFiles(new av(this));
      int i2 = paramFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2 = paramFile[i1];
        localObject2 = ((File)localObject2).getName().substring(0, ((File)localObject2).getName().length() - 4);
        localObject3 = ((String)localObject1).replaceAll("tbs_sdk_extension_dex", (String)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/system/bin/dex2oat ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(" --dex-location=");
        localStringBuilder.append(a().r(paramContext));
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".jar");
        localObject2 = localStringBuilder.toString();
        Runtime.getRuntime().exec((String)localObject2).waitFor();
        i1 += 1;
      }
      return true;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      TbsLogReport.a(paramContext).a(226, paramFile);
    }
    return false;
  }
  
  private static boolean d(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), paramString);
    if (!paramContext.exists()) {}
    for (paramContext = "TbsInstaller-isPrepareTbsCore, #1";; paramContext = "TbsInstaller-isPrepareTbsCore, #2")
    {
      TbsLog.i("TbsInstaller", paramContext);
      return false;
      if (new File(paramContext, "tbs.conf").exists()) {
        break;
      }
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
    return true;
  }
  
  /* Error */
  private boolean d(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: ldc_w 1062
    //   7: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: iconst_0
    //   11: istore 6
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore 7
    //   19: iload 8
    //   21: istore 5
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 495	com/tencent/smtt/sdk/am:x	(Landroid/content/Context;)Z
    //   28: istore 9
    //   30: iload 9
    //   32: ifne +7 -> 39
    //   35: aload_0
    //   36: monitorexit
    //   37: iconst_0
    //   38: ireturn
    //   39: iload 8
    //   41: istore 5
    //   43: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   46: invokevirtual 1063	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   49: istore 9
    //   51: iload 8
    //   53: istore 5
    //   55: new 216	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   62: astore 10
    //   64: iload 8
    //   66: istore 5
    //   68: aload 10
    //   70: ldc_w 1065
    //   73: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: iload 8
    //   79: istore 5
    //   81: aload 10
    //   83: iload 9
    //   85: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: iload 8
    //   91: istore 5
    //   93: ldc 127
    //   95: aload 10
    //   97: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: iload 9
    //   105: ifeq +179 -> 284
    //   108: aload_1
    //   109: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   112: ldc_w 515
    //   115: invokevirtual 517	com/tencent/smtt/sdk/ai:b	(Ljava/lang/String;)I
    //   118: istore_3
    //   119: aload_0
    //   120: iconst_0
    //   121: aload_1
    //   122: invokevirtual 1068	com/tencent/smtt/sdk/am:a	(ZLandroid/content/Context;)I
    //   125: istore 4
    //   127: new 216	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   134: astore 10
    //   136: aload 10
    //   138: ldc_w 1070
    //   141: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 10
    //   147: iload_3
    //   148: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 127
    //   154: aload 10
    //   156: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: new 216	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   169: astore 10
    //   171: aload 10
    //   173: ldc_w 1072
    //   176: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 10
    //   182: iload 4
    //   184: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc 127
    //   190: aload 10
    //   192: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: iload 7
    //   200: istore 6
    //   202: iload_3
    //   203: iconst_1
    //   204: if_icmpne +48 -> 252
    //   207: iload 4
    //   209: ifne +23 -> 232
    //   212: ldc 127
    //   214: ldc_w 1074
    //   217: iconst_1
    //   218: invokestatic 372	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   221: aload_0
    //   222: aload_1
    //   223: invokespecial 1076	com/tencent/smtt/sdk/am:B	(Landroid/content/Context;)V
    //   226: iconst_1
    //   227: istore 6
    //   229: goto +23 -> 252
    //   232: iload 7
    //   234: istore 6
    //   236: iload_2
    //   237: ifeq +15 -> 252
    //   240: ldc 127
    //   242: ldc_w 1078
    //   245: iconst_1
    //   246: invokestatic 372	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   249: goto -28 -> 221
    //   252: iload 6
    //   254: istore 5
    //   256: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   259: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   262: goto +22 -> 284
    //   265: astore 10
    //   267: iload 8
    //   269: istore 5
    //   271: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   274: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   277: iload 8
    //   279: istore 5
    //   281: aload 10
    //   283: athrow
    //   284: iload 6
    //   286: istore 5
    //   288: aload_0
    //   289: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   292: iload 6
    //   294: istore 5
    //   296: goto +62 -> 358
    //   299: astore_1
    //   300: goto +63 -> 363
    //   303: astore 10
    //   305: aload_1
    //   306: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   309: sipush 215
    //   312: aload 10
    //   314: invokevirtual 262	java/lang/Throwable:toString	()Ljava/lang/String;
    //   317: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   320: new 216	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   327: astore 11
    //   329: aload 11
    //   331: ldc_w 1080
    //   334: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 11
    //   340: aload 10
    //   342: invokestatic 692	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   345: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: aload 11
    //   352: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 354	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   358: aload_0
    //   359: monitorexit
    //   360: iload 5
    //   362: ireturn
    //   363: aload_1
    //   364: athrow
    //   365: astore_1
    //   366: aload_0
    //   367: monitorexit
    //   368: aload_1
    //   369: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	am
    //   0	370	1	paramContext	Context
    //   0	370	2	paramBoolean	boolean
    //   118	87	3	i1	int
    //   125	83	4	i2	int
    //   21	340	5	bool1	boolean
    //   11	282	6	bool2	boolean
    //   17	216	7	bool3	boolean
    //   14	264	8	bool4	boolean
    //   28	76	9	bool5	boolean
    //   62	129	10	localStringBuilder1	StringBuilder
    //   265	17	10	localObject	Object
    //   303	38	10	localThrowable	Throwable
    //   327	24	11	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   108	198	265	finally
    //   212	221	265	finally
    //   221	226	265	finally
    //   240	249	265	finally
    //   23	30	299	finally
    //   43	51	299	finally
    //   55	64	299	finally
    //   68	77	299	finally
    //   81	89	299	finally
    //   93	103	299	finally
    //   256	262	299	finally
    //   271	277	299	finally
    //   281	284	299	finally
    //   288	292	299	finally
    //   305	358	299	finally
    //   23	30	303	java/lang/Throwable
    //   43	51	303	java/lang/Throwable
    //   55	64	303	java/lang/Throwable
    //   68	77	303	java/lang/Throwable
    //   81	89	303	java/lang/Throwable
    //   93	103	303	java/lang/Throwable
    //   256	262	303	java/lang/Throwable
    //   271	277	303	java/lang/Throwable
    //   281	284	303	java/lang/Throwable
    //   288	292	303	java/lang/Throwable
    //   2	10	365	finally
    //   363	365	365	finally
  }
  
  private boolean e(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-doTbsDexOpt start - dirMode: ");
    ((StringBuilder)localObject).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    int i3 = 0;
    switch (paramInt)
    {
    default: 
      break;
    }
    for (;;)
    {
      try
      {
        localObject = r(paramContext);
        continue;
        localObject = w(paramContext);
        continue;
        if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
          return true;
        }
        localObject = u(paramContext);
        try
        {
          String str = System.getProperty("java.vm.version");
          if (str == null) {
            break label350;
          }
          bool = str.startsWith("2");
          if (!bool) {
            break label350;
          }
          paramInt = 1;
        }
        catch (Throwable localThrowable)
        {
          TbsLogReport.a(paramContext).a(226, localThrowable);
          break label350;
        }
        if (Build.VERSION.SDK_INT != 23) {
          break label355;
        }
        i1 = 1;
        boolean bool = TbsDownloadConfig.getInstance(paramContext).mPreferences.getBoolean("tbs_stop_preoat", false);
        int i2 = i3;
        if (paramInt != 0)
        {
          i2 = i3;
          if (i1 != 0)
          {
            i2 = i3;
            if (!bool) {
              i2 = 1;
            }
          }
        }
        if ((i2 != 0) && (d(paramContext, (File)localObject)))
        {
          TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
          return true;
        }
        if (paramInt != 0)
        {
          TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
          continue;
        }
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
        return c(paramContext, (File)localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        TbsLogReport.a(paramContext).a(209, localException.toString());
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDexoptOrDexoat mode error: ");
      ((StringBuilder)localObject).append(paramInt);
      TbsLog.e("TbsInstaller", ((StringBuilder)localObject).toString());
      return false;
      label350:
      paramInt = 0;
      continue;
      label355:
      int i1 = 0;
    }
  }
  
  private boolean e(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    return paramContext != null;
  }
  
  private boolean e(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {}
    try
    {
      if ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)) {
        TbsLogReport.a(paramContext).a(229, " ");
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =");
      localStringBuilder1.append(paramBoolean);
      TbsLog.i("TbsInstaller", localStringBuilder1.toString());
      TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
      boolean bool2 = false;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool1 = bool4;
      try
      {
        boolean bool5 = x(paramContext);
        if (!bool5) {
          return false;
        }
        bool1 = bool4;
        TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
        bool1 = bool4;
        bool5 = i.tryLock();
        bool1 = bool4;
        localStringBuilder1 = new StringBuilder();
        bool1 = bool4;
        localStringBuilder1.append("TbsInstaller-enableTbsCoreFromUnzip locked=");
        bool1 = bool4;
        localStringBuilder1.append(bool5);
        bool1 = bool4;
        TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        if (bool5) {
          try
          {
            int i1 = ai.a(paramContext).c();
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("TbsInstaller-enableTbsCoreFromUnzip installStatus=");
            localStringBuilder1.append(i1);
            TbsLog.i("TbsInstaller", localStringBuilder1.toString());
            int i2 = a(false, paramContext);
            bool2 = bool3;
            if (i1 == 2)
            {
              TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
              if (i2 == 0) {
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
              }
              for (;;)
              {
                A(paramContext);
                bool2 = true;
                break;
                bool2 = bool3;
                if (!paramBoolean) {
                  break;
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
              }
            }
            bool1 = bool2;
            i.unlock();
          }
          finally
          {
            bool1 = bool4;
            i.unlock();
            bool1 = bool4;
          }
        }
        bool1 = bool2;
        b();
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("TbsInstaller::enableTbsCoreFromUnzip Exception: ");
        localStringBuilder2.append(localException);
        QbSdk.a(paramContext, localStringBuilder2.toString());
        localException.printStackTrace();
      }
      return bool1;
    }
    finally
    {
      for (;;) {}
    }
    throw paramContext;
  }
  
  private Context f(Context paramContext, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=");
    ((StringBuilder)localObject1).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (paramInt <= 0) {
      return null;
    }
    localObject1 = TbsShareManager.getCoreProviderAppList();
    int i1 = 0;
    while (i1 < localObject1.length)
    {
      if ((!paramContext.getPackageName().equalsIgnoreCase(localObject1[i1])) && (e(paramContext, localObject1[i1])))
      {
        Object localObject2 = a(paramContext, localObject1[i1]);
        if (localObject2 != null) {
          if (!f((Context)localObject2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("TbsInstaller--getTbsCoreHostContext ");
            ((StringBuilder)localObject2).append(localObject1[i1]);
            ((StringBuilder)localObject2).append(" illegal signature go on next");
            TbsLog.e("TbsInstaller", ((StringBuilder)localObject2).toString());
          }
          else
          {
            int i2 = j((Context)localObject2);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=");
            localStringBuilder.append(i2);
            TbsLog.i("TbsInstaller", localStringBuilder.toString());
            if ((i2 != 0) && (i2 == paramInt))
            {
              paramContext = new StringBuilder();
              paramContext.append("TbsInstaller-getTbsCoreHostContext targetApp=");
              paramContext.append(localObject1[i1]);
              TbsLog.i("TbsInstaller", paramContext.toString());
              return (Context)localObject2;
            }
          }
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  private boolean f(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  private void g(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      TbsLogReport.a(paramContext).a(225, "setTmpFolderCoreToRead context is null");
      return;
    }
    try
    {
      File localFile = new File(paramContext.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
      if (paramBoolean)
      {
        if (localFile.exists()) {
          return;
        }
        localFile.createNewFile();
        return;
      }
      k.b(localFile);
      return;
    }
    catch (Exception localException)
    {
      paramContext = TbsLogReport.a(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTmpFolderCoreToRead Exception message is ");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(" Exception cause is ");
      localStringBuilder.append(localException.getCause());
      paramContext.a(225, localStringBuilder.toString());
    }
  }
  
  static File t(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  private static boolean y(Context paramContext)
  {
    if (paramContext == null) {}
    for (paramContext = "TbsInstaller-getTmpFolderCoreToRead, #1";; paramContext = "TbsInstaller-getTmpFolderCoreToRead, #4")
    {
      TbsLog.i("TbsInstaller", paramContext);
      return true;
      try
      {
        if (new File(paramContext.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists())
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
          return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
        return false;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  private boolean z(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    bool = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ");
    localStringBuilder.append(bool);
    TbsLog.i("TbsInstaller", localStringBuilder.toString());
    if (!bool) {}
    for (paramContext = bt.a().b(paramContext);; paramContext = k.f(paramContext))
    {
      l = paramContext;
      break;
    }
    if (l == null)
    {
      TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
      return false;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
    return true;
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: new 306	java/io/File
    //   14: dup
    //   15: new 306	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: ldc_w 388
    //   26: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 600	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: new 390	java/util/Properties
    //   42: dup
    //   43: invokespecial 391	java/util/Properties:<init>	()V
    //   46: astore 5
    //   48: new 393	java/io/BufferedInputStream
    //   51: dup
    //   52: new 395	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_1
    //   71: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   74: aload 5
    //   76: ldc_w 1209
    //   79: invokevirtual 1210	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +9 -> 93
    //   87: aload_1
    //   88: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_3
    //   94: invokestatic 1213	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   97: istore_2
    //   98: aload_1
    //   99: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   102: iload_2
    //   103: ireturn
    //   104: astore 4
    //   106: aload_1
    //   107: astore_3
    //   108: aload 4
    //   110: astore_1
    //   111: goto +7 -> 118
    //   114: goto +14 -> 128
    //   117: astore_1
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: aload 4
    //   141: astore_1
    //   142: goto -14 -> 128
    //   145: astore_3
    //   146: goto -32 -> 114
    //   149: astore_1
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_1
    //   153: iload_2
    //   154: ireturn
    //   155: astore_3
    //   156: goto -30 -> 126
    //   159: astore_1
    //   160: iconst_0
    //   161: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	am
    //   0	162	1	paramString	String
    //   97	57	2	i1	int
    //   10	113	3	str	String
    //   145	1	3	localException	Exception
    //   155	1	3	localIOException	java.io.IOException
    //   7	1	4	localObject1	Object
    //   104	36	4	localObject2	Object
    //   46	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   64	83	104	finally
    //   93	98	104	finally
    //   11	37	117	finally
    //   39	64	117	finally
    //   11	37	138	java/lang/Exception
    //   39	64	138	java/lang/Exception
    //   64	83	145	java/lang/Exception
    //   93	98	145	java/lang/Exception
    //   87	91	149	java/io/IOException
    //   98	102	152	java/io/IOException
    //   122	126	155	java/io/IOException
    //   132	136	159	java/io/IOException
  }
  
  public int a(boolean paramBoolean, Context paramContext)
  {
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(j(paramContext)));
    }
    return ((Integer)a.get()).intValue();
  }
  
  Context a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    g(paramContext, true);
    ai.a(paramContext).b(paramInt, 2);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramContext == null) {
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 3;
      localMessage.obj = new Object[] { paramContext, paramBundle };
      m.sendMessage(localMessage);
    }
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore tbsApkPath=");
    ((StringBuilder)localObject).append(paramString);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore tbsCoreTargetVer=");
    ((StringBuilder)localObject).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore currentProcessId=");
    ((StringBuilder)localObject).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore currentThreadName=");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new Message();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage((Message)localObject);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i6 = 1;
    if (paramBoolean) {
      this.k = true;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject1).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentProcessId=");
    ((StringBuilder)localObject1).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentThreadName=");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (!x(paramContext)) {
      return;
    }
    if (i.tryLock()) {}
    try
    {
      i4 = ai.a(paramContext).c();
      i1 = ai.a(paramContext).b();
      localObject1 = ai.a(paramContext).d("install_apk_path");
      i2 = ai.a(paramContext).c("copy_core_ver");
      i3 = ai.a(paramContext).b("copy_status");
      i.unlock();
    }
    finally
    {
      i.unlock();
    }
    int i4 = -1;
    int i1 = 0;
    int i2 = 0;
    int i3 = -1;
    b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore installStatus=");
    ((StringBuilder)localObject2).append(i4);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=");
    ((StringBuilder)localObject2).append(i1);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore tbsApkPath=");
    ((StringBuilder)localObject2).append((String)localObject1);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=");
    ((StringBuilder)localObject2).append(i2);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore copyStatus=");
    ((StringBuilder)localObject2).append(i3);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      c(paramContext, TbsShareManager.a(paramContext, false));
      return;
    }
    int i7 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
    int i5 = i6;
    if (i7 != 1)
    {
      i5 = i6;
      if (i7 != 2) {
        if (i7 == 4) {
          i5 = i6;
        } else {
          i5 = 0;
        }
      }
    }
    if ((i5 == 0) && (i7 != 0))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("operation", 10001);
      a(paramContext, (Bundle)localObject2);
    }
    if ((i4 > -1) && (i4 < 2)) {
      a(paramContext, (String)localObject1, i1);
    }
    if (i3 == 0) {
      b(paramContext, i2);
    }
  }
  
  public boolean a(Context paramContext1, Context paramContext2)
  {
    try
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
      boolean bool = p;
      if (bool == true) {
        return true;
      }
      p = true;
      new aq(this, paramContext2, paramContext1).start();
      return true;
    }
    finally {}
  }
  
  public boolean a(Context paramContext, File paramFile)
  {
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp #1");
    boolean bool = a(paramContext, paramFile, false);
    paramContext = new StringBuilder();
    paramContext.append("unzipTbsCoreToThirdAppTmp result is ");
    paramContext.append(bool);
    TbsLog.i("TbsInstaller", paramContext.toString());
    return bool;
  }
  
  public boolean a(Context paramContext, File[] paramArrayOfFile)
  {
    return false;
  }
  
  int b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      return paramContext.versionCode;
    }
    return 0;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(paramContext2.getDir("tbs", 0), "core_share");
    if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir())) {
      return null;
    }
    return paramContext2;
  }
  
  void b()
  {
    try
    {
      int i1 = this.e;
      this.e = (i1 - 1);
      if ((i1 <= 1) && (this.h))
      {
        TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
        k.a(this.f, this.g);
        this.h = false;
        return;
      }
      TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
      return;
    }
    finally {}
  }
  
  public void b(Context paramContext)
  {
    g(paramContext, true);
    ai.a(paramContext).b(i(paramContext), 2);
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 473	com/tencent/smtt/sdk/am:c	(Landroid/content/Context;)Z
    //   5: ifeq +18 -> 23
    //   8: aload_1
    //   9: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   12: astore_1
    //   13: sipush 64997
    //   16: istore_3
    //   17: aload_1
    //   18: iload_3
    //   19: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   22: return
    //   23: ldc 127
    //   25: ldc_w 1317
    //   28: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_2
    //   32: ifnull +1333 -> 1365
    //   35: aload_1
    //   36: ifnonnull +4 -> 40
    //   39: return
    //   40: aload_1
    //   41: invokestatic 544	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   44: ifne +89 -> 133
    //   47: invokestatic 549	com/tencent/smtt/utils/y:a	()J
    //   50: lstore 5
    //   52: aload_1
    //   53: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   56: invokevirtual 552	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   59: lstore 7
    //   61: aload_1
    //   62: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   65: astore_2
    //   66: new 216	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   73: astore 10
    //   75: aload 10
    //   77: ldc_w 1319
    //   80: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 10
    //   86: lload 5
    //   88: invokevirtual 557	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 10
    //   94: ldc_w 559
    //   97: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 10
    //   103: lload 7
    //   105: invokevirtual 557	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_2
    //   110: sipush 210
    //   113: aload 10
    //   115: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   121: aload_1
    //   122: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   125: astore_1
    //   126: sipush 64996
    //   129: istore_3
    //   130: goto -113 -> 17
    //   133: aload_0
    //   134: aload_1
    //   135: invokevirtual 495	com/tencent/smtt/sdk/am:x	(Landroid/content/Context;)Z
    //   138: ifne +15 -> 153
    //   141: aload_1
    //   142: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   145: astore_1
    //   146: sipush 64995
    //   149: istore_3
    //   150: goto -133 -> 17
    //   153: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 500 1 0
    //   161: istore 9
    //   163: new 216	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   170: astore 10
    //   172: aload 10
    //   174: ldc_w 1321
    //   177: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 10
    //   183: iload 9
    //   185: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 127
    //   191: aload 10
    //   193: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iload 9
    //   201: ifeq +1150 -> 1351
    //   204: aconst_null
    //   205: astore 12
    //   207: aconst_null
    //   208: astore 11
    //   210: iconst_1
    //   211: invokestatic 1325	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   214: aload_0
    //   215: aload_1
    //   216: invokevirtual 212	com/tencent/smtt/sdk/am:j	(Landroid/content/Context;)I
    //   219: ifle +715 -> 934
    //   222: aload_1
    //   223: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   226: invokevirtual 962	com/tencent/smtt/sdk/ai:d	()I
    //   229: iconst_1
    //   230: if_icmpne +6 -> 236
    //   233: goto +701 -> 934
    //   236: aload_1
    //   237: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   240: getfield 196	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   243: ldc_w 908
    //   246: iconst_0
    //   247: invokeinterface 204 3 0
    //   252: istore 4
    //   254: iload 4
    //   256: iconst_1
    //   257: if_icmpeq +1114 -> 1371
    //   260: iload 4
    //   262: iconst_2
    //   263: if_icmpeq +1108 -> 1371
    //   266: iload 4
    //   268: iconst_4
    //   269: if_icmpne +1097 -> 1366
    //   272: goto +1099 -> 1371
    //   275: iload_3
    //   276: ifne +450 -> 726
    //   279: iload 4
    //   281: ifeq +445 -> 726
    //   284: aload_1
    //   285: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   288: ldc -83
    //   290: invokevirtual 513	com/tencent/smtt/sdk/ai:c	(Ljava/lang/String;)I
    //   293: istore_3
    //   294: iload_3
    //   295: iconst_5
    //   296: if_icmple +160 -> 456
    //   299: ldc 127
    //   301: ldc_w 1327
    //   304: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_2
    //   308: ldc_w 1329
    //   311: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 10
    //   316: aload_2
    //   317: ldc_w 1334
    //   320: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   323: astore 13
    //   325: aload_2
    //   326: ldc_w 1336
    //   329: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore_2
    //   333: aload 10
    //   335: invokestatic 1012	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   338: ifne +15 -> 353
    //   341: new 306	java/io/File
    //   344: dup
    //   345: aload 10
    //   347: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   350: invokestatic 737	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   353: aload 13
    //   355: invokestatic 1012	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   358: ifne +15 -> 373
    //   361: new 306	java/io/File
    //   364: dup
    //   365: aload 13
    //   367: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   370: invokestatic 737	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   373: aload_2
    //   374: invokestatic 1012	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +14 -> 391
    //   380: new 306	java/io/File
    //   383: dup
    //   384: aload_2
    //   385: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   388: invokestatic 737	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   391: aload_1
    //   392: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   395: getfield 884	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   398: ldc_w 886
    //   401: iconst_1
    //   402: invokestatic 891	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   405: invokeinterface 897 3 0
    //   410: pop
    //   411: aload_1
    //   412: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   415: invokevirtual 901	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   418: aload_1
    //   419: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   422: sipush 224
    //   425: ldc_w 1338
    //   428: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   431: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   434: invokeinterface 529 1 0
    //   439: aload_0
    //   440: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   443: ldc 127
    //   445: ldc_w 1340
    //   448: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: iconst_0
    //   452: invokestatic 1325	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   455: return
    //   456: aload_1
    //   457: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   460: ldc -83
    //   462: iload_3
    //   463: iconst_1
    //   464: iadd
    //   465: invokevirtual 176	com/tencent/smtt/sdk/ai:a	(Ljava/lang/String;I)V
    //   468: aload_1
    //   469: invokestatic 759	com/tencent/smtt/sdk/am:t	(Landroid/content/Context;)Ljava/io/File;
    //   472: astore 10
    //   474: aload 10
    //   476: ifnull +250 -> 726
    //   479: new 306	java/io/File
    //   482: dup
    //   483: aload 10
    //   485: ldc_w 761
    //   488: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   491: invokevirtual 600	java/io/File:exists	()Z
    //   494: ifeq +232 -> 726
    //   497: aload_1
    //   498: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   501: sipush 64986
    //   504: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   507: aload_1
    //   508: aload_2
    //   509: invokestatic 1343	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   512: astore 10
    //   514: aload 10
    //   516: ifnonnull +84 -> 600
    //   519: aload_1
    //   520: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   523: astore 11
    //   525: new 216	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   532: astore 12
    //   534: aload 12
    //   536: ldc_w 1345
    //   539: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 12
    //   545: aload_2
    //   546: ldc_w 1347
    //   549: invokevirtual 1349	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   552: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 11
    //   558: sipush 228
    //   561: aload 12
    //   563: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   569: iconst_1
    //   570: istore_3
    //   571: goto +160 -> 731
    //   574: astore 11
    //   576: aload 10
    //   578: astore_2
    //   579: aload 11
    //   581: astore 10
    //   583: goto +555 -> 1138
    //   586: astore 11
    //   588: aload 10
    //   590: astore_2
    //   591: iconst_1
    //   592: istore_3
    //   593: aload 11
    //   595: astore 10
    //   597: goto +383 -> 980
    //   600: aload 10
    //   602: ldc_w 1351
    //   605: invokevirtual 1349	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   608: istore_3
    //   609: aload_1
    //   610: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   613: astore 11
    //   615: new 216	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   622: astore 12
    //   624: aload 12
    //   626: ldc_w 1353
    //   629: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 12
    //   635: iload_3
    //   636: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 12
    //   642: ldc_w 1355
    //   645: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 12
    //   651: aload_2
    //   652: ldc_w 1347
    //   655: invokevirtual 1349	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   658: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 11
    //   664: sipush 228
    //   667: aload 12
    //   669: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   675: goto +56 -> 731
    //   678: astore 11
    //   680: aload 10
    //   682: astore_2
    //   683: aload 11
    //   685: astore 10
    //   687: goto +458 -> 1145
    //   690: astore 11
    //   692: aload 10
    //   694: astore_2
    //   695: aload 11
    //   697: astore 10
    //   699: goto +281 -> 980
    //   702: astore 11
    //   704: aload 10
    //   706: astore_2
    //   707: aload 11
    //   709: astore 10
    //   711: goto +257 -> 968
    //   714: astore 11
    //   716: aload 10
    //   718: astore_2
    //   719: aload 11
    //   721: astore 10
    //   723: goto +255 -> 978
    //   726: aconst_null
    //   727: astore 10
    //   729: iconst_2
    //   730: istore_3
    //   731: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   734: invokeinterface 529 1 0
    //   739: aload_0
    //   740: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   743: iload_3
    //   744: ifne +86 -> 830
    //   747: ldc 127
    //   749: ldc_w 1357
    //   752: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   755: aload_1
    //   756: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   759: ldc -83
    //   761: iconst_0
    //   762: invokevirtual 176	com/tencent/smtt/sdk/ai:a	(Ljava/lang/String;I)V
    //   765: aload_1
    //   766: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   769: sipush 64992
    //   772: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   775: aload_1
    //   776: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   779: iconst_0
    //   780: iconst_m1
    //   781: invokevirtual 179	com/tencent/smtt/sdk/ai:b	(II)V
    //   784: aload_1
    //   785: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   788: iconst_1
    //   789: invokevirtual 186	com/tencent/smtt/sdk/ai:c	(I)V
    //   792: aload 10
    //   794: ldc_w 1359
    //   797: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   800: astore_2
    //   801: new 306	java/io/File
    //   804: dup
    //   805: aload_2
    //   806: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   809: aload_1
    //   810: invokestatic 659	com/tencent/smtt/sdk/ag:a	(Ljava/io/File;Landroid/content/Context;)V
    //   813: aload_0
    //   814: aload_1
    //   815: aload_2
    //   816: aload 10
    //   818: ldc_w 1361
    //   821: invokevirtual 1349	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   824: invokespecial 727	com/tencent/smtt/sdk/am:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   827: goto +102 -> 929
    //   830: iload_3
    //   831: iconst_2
    //   832: if_icmpne +14 -> 846
    //   835: ldc 127
    //   837: ldc_w 1340
    //   840: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   843: goto +86 -> 929
    //   846: aload_1
    //   847: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   850: sipush 64990
    //   853: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   856: ldc 127
    //   858: ldc_w 1363
    //   861: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   864: aload_1
    //   865: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   868: getfield 884	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   871: ldc_w 886
    //   874: iconst_1
    //   875: invokestatic 891	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   878: invokeinterface 897 3 0
    //   883: pop
    //   884: aload_1
    //   885: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   888: invokevirtual 901	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   891: aload_1
    //   892: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   895: astore_1
    //   896: new 216	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   903: astore_2
    //   904: aload_2
    //   905: ldc_w 1365
    //   908: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload_2
    //   913: iload_3
    //   914: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload_1
    //   919: sipush 217
    //   922: aload_2
    //   923: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   929: iconst_0
    //   930: invokestatic 1325	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   933: return
    //   934: iconst_0
    //   935: invokestatic 1325	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   938: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   941: invokeinterface 529 1 0
    //   946: aload_0
    //   947: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   950: ldc 127
    //   952: ldc_w 1340
    //   955: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   958: iconst_0
    //   959: invokestatic 1325	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   962: return
    //   963: astore 10
    //   965: aload 11
    //   967: astore_2
    //   968: iconst_2
    //   969: istore_3
    //   970: goto +175 -> 1145
    //   973: astore 10
    //   975: aload 12
    //   977: astore_2
    //   978: iconst_2
    //   979: istore_3
    //   980: new 216	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   987: astore 11
    //   989: aload 11
    //   991: ldc_w 1367
    //   994: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: aload 11
    //   1000: aload 10
    //   1002: invokestatic 692	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1005: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: pop
    //   1009: ldc 127
    //   1011: aload 11
    //   1013: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1019: aload 10
    //   1021: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   1024: aload_1
    //   1025: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1028: sipush 64993
    //   1031: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1034: aload_1
    //   1035: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1038: sipush 218
    //   1041: aload 10
    //   1043: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   1046: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1049: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   1052: invokeinterface 529 1 0
    //   1057: aload_0
    //   1058: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   1061: aload_1
    //   1062: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1065: sipush 64990
    //   1068: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1071: ldc 127
    //   1073: ldc_w 1363
    //   1076: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1079: aload_1
    //   1080: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1083: getfield 884	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1086: ldc_w 886
    //   1089: iconst_1
    //   1090: invokestatic 891	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1093: invokeinterface 897 3 0
    //   1098: pop
    //   1099: aload_1
    //   1100: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1103: invokevirtual 901	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1106: aload_1
    //   1107: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1110: astore_1
    //   1111: new 216	java/lang/StringBuilder
    //   1114: dup
    //   1115: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1118: astore_2
    //   1119: aload_2
    //   1120: ldc_w 1365
    //   1123: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload_2
    //   1128: iconst_1
    //   1129: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1132: pop
    //   1133: goto -215 -> 918
    //   1136: astore 10
    //   1138: iconst_1
    //   1139: istore_3
    //   1140: goto +5 -> 1145
    //   1143: astore 10
    //   1145: getstatic 43	com/tencent/smtt/sdk/am:j	Ljava/util/concurrent/locks/Lock;
    //   1148: invokeinterface 529 1 0
    //   1153: aload_0
    //   1154: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   1157: iload_3
    //   1158: ifeq +105 -> 1263
    //   1161: iload_3
    //   1162: iconst_2
    //   1163: if_icmpne +14 -> 1177
    //   1166: ldc 127
    //   1168: ldc_w 1340
    //   1171: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1174: goto +170 -> 1344
    //   1177: aload_1
    //   1178: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1181: sipush 64990
    //   1184: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1187: ldc 127
    //   1189: ldc_w 1363
    //   1192: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1195: aload_1
    //   1196: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1199: getfield 884	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1202: ldc_w 886
    //   1205: iconst_1
    //   1206: invokestatic 891	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1209: invokeinterface 897 3 0
    //   1214: pop
    //   1215: aload_1
    //   1216: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1219: invokevirtual 901	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1222: aload_1
    //   1223: invokestatic 259	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1226: astore_1
    //   1227: new 216	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1234: astore_2
    //   1235: aload_2
    //   1236: ldc_w 1365
    //   1239: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: pop
    //   1243: aload_2
    //   1244: iload_3
    //   1245: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload_1
    //   1250: sipush 217
    //   1253: aload_2
    //   1254: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1260: goto +84 -> 1344
    //   1263: ldc 127
    //   1265: ldc_w 1357
    //   1268: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1271: aload_1
    //   1272: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   1275: ldc -83
    //   1277: iconst_0
    //   1278: invokevirtual 176	com/tencent/smtt/sdk/ai:a	(Ljava/lang/String;I)V
    //   1281: aload_1
    //   1282: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1285: sipush 64992
    //   1288: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1291: aload_1
    //   1292: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   1295: iconst_0
    //   1296: iconst_m1
    //   1297: invokevirtual 179	com/tencent/smtt/sdk/ai:b	(II)V
    //   1300: aload_1
    //   1301: invokestatic 164	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ai;
    //   1304: iconst_1
    //   1305: invokevirtual 186	com/tencent/smtt/sdk/ai:c	(I)V
    //   1308: aload_2
    //   1309: ldc_w 1359
    //   1312: invokevirtual 1332	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1315: astore 11
    //   1317: new 306	java/io/File
    //   1320: dup
    //   1321: aload 11
    //   1323: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1326: aload_1
    //   1327: invokestatic 659	com/tencent/smtt/sdk/ag:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1330: aload_0
    //   1331: aload_1
    //   1332: aload 11
    //   1334: aload_2
    //   1335: ldc_w 1361
    //   1338: invokevirtual 1349	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1341: invokespecial 727	com/tencent/smtt/sdk/am:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1344: iconst_0
    //   1345: invokestatic 1325	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1348: aload 10
    //   1350: athrow
    //   1351: aload_1
    //   1352: invokestatic 192	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1355: sipush 64989
    //   1358: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1361: aload_0
    //   1362: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   1365: return
    //   1366: iconst_0
    //   1367: istore_3
    //   1368: goto -1093 -> 275
    //   1371: iconst_1
    //   1372: istore_3
    //   1373: goto -1098 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1376	0	this	am
    //   0	1376	1	paramContext	Context
    //   0	1376	2	paramBundle	Bundle
    //   16	1357	3	i1	int
    //   252	28	4	i2	int
    //   50	37	5	l1	long
    //   59	45	7	l2	long
    //   161	39	9	bool	boolean
    //   73	744	10	localObject1	Object
    //   963	1	10	localObject2	Object
    //   973	69	10	localException1	Exception
    //   1136	1	10	localObject3	Object
    //   1143	206	10	localObject4	Object
    //   208	349	11	localTbsLogReport1	TbsLogReport
    //   574	6	11	localObject5	Object
    //   586	8	11	localException2	Exception
    //   613	50	11	localTbsLogReport2	TbsLogReport
    //   678	6	11	localObject6	Object
    //   690	6	11	localException3	Exception
    //   702	6	11	localObject7	Object
    //   714	252	11	localException4	Exception
    //   987	346	11	localObject8	Object
    //   205	771	12	localStringBuilder	StringBuilder
    //   323	43	13	str	String
    // Exception table:
    //   from	to	target	type
    //   519	569	574	finally
    //   519	569	586	java/lang/Exception
    //   609	675	678	finally
    //   609	675	690	java/lang/Exception
    //   600	609	702	finally
    //   600	609	714	java/lang/Exception
    //   210	233	963	finally
    //   236	254	963	finally
    //   284	294	963	finally
    //   299	353	963	finally
    //   353	373	963	finally
    //   373	391	963	finally
    //   391	431	963	finally
    //   456	474	963	finally
    //   479	514	963	finally
    //   934	938	963	finally
    //   210	233	973	java/lang/Exception
    //   236	254	973	java/lang/Exception
    //   284	294	973	java/lang/Exception
    //   299	353	973	java/lang/Exception
    //   353	373	973	java/lang/Exception
    //   373	391	973	java/lang/Exception
    //   391	431	973	java/lang/Exception
    //   456	474	973	java/lang/Exception
    //   479	514	973	java/lang/Exception
    //   934	938	973	java/lang/Exception
    //   1024	1049	1136	finally
    //   980	1024	1143	finally
  }
  
  public void b(Context paramContext, boolean paramBoolean)
  {
    TbsLog.i("TbsInstaller", "tryInstallTbsCore #1");
    if (QbSdk.b) {
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      return;
    }
    if (!y(paramContext)) {
      return;
    }
    TbsLog.i("TbsInstaller", "tryInstallTbsCore #2 ");
    if ((d(paramContext, "core_unzip_tmp")) && (e(paramContext, paramBoolean))) {
      paramContext = "tryInstallTbsCore, enableTbsCoreFromUnzip!!";
    }
    for (;;)
    {
      TbsLog.i("TbsInstaller", paramContext, true);
      return;
      if ((d(paramContext, "core_share_backup_tmp")) && (f(paramContext, paramBoolean)))
      {
        paramContext = "tryInstallTbsCore, enableTbsCoreFromBackup!!";
      }
      else
      {
        if ((!d(paramContext, "core_copy_tmp")) || (!d(paramContext, paramBoolean))) {
          break;
        }
        paramContext = "tryInstallTbsCore, enableTbsCoreFromCopy!!";
      }
    }
    TbsLog.i("TbsInstaller", "tryInstallTbsCore, no need ", true);
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installLocalTbsCore targetTbsCoreVer=");
    ((StringBuilder)localObject).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installLocalTbsCore currentProcessId=");
    ((StringBuilder)localObject).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installLocalTbsCore currentThreadName=");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = f(paramContext, paramInt);
    if (localObject != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localObject, paramContext, Integer.valueOf(paramInt) };
      m.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  File c(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(paramContext2.getDir("tbs", 0), "core_share_decouple");
    if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir())) {
      return null;
    }
    return paramContext2;
  }
  
  /* Error */
  public String c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 1012	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: iload_3
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 306	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 294	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   23: ldc_w 388
    //   26: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 600	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: aconst_null
    //   38: areturn
    //   39: new 390	java/util/Properties
    //   42: dup
    //   43: invokespecial 391	java/util/Properties:<init>	()V
    //   46: astore 5
    //   48: new 393	java/io/BufferedInputStream
    //   51: dup
    //   52: new 395	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_1
    //   71: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   74: aload 5
    //   76: aload_2
    //   77: invokevirtual 1210	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   85: aload_2
    //   86: areturn
    //   87: astore 4
    //   89: aload_1
    //   90: astore_2
    //   91: aload 4
    //   93: astore_1
    //   94: goto +7 -> 101
    //   97: astore_1
    //   98: aload 4
    //   100: astore_2
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: goto -13 -> 111
    //   127: astore_2
    //   128: goto -15 -> 113
    //   131: astore_1
    //   132: aload_2
    //   133: areturn
    //   134: astore_2
    //   135: goto -26 -> 109
    //   138: astore_1
    //   139: aconst_null
    //   140: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	am
    //   0	141	1	paramContext	Context
    //   0	141	2	paramString	String
    //   4	5	3	bool	boolean
    //   6	1	4	localObject1	Object
    //   87	12	4	localObject2	Object
    //   46	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   64	81	87	finally
    //   14	37	97	finally
    //   39	64	97	finally
    //   14	37	123	java/lang/Exception
    //   39	64	123	java/lang/Exception
    //   64	81	127	java/lang/Exception
    //   81	85	131	java/io/IOException
    //   105	109	134	java/io/IOException
    //   117	121	138	java/io/IOException
  }
  
  void c(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {
      return;
    }
    int i1 = j(paramContext);
    if (i1 == paramInt) {
      return;
    }
    Context localContext = TbsShareManager.e(paramContext);
    if ((localContext == null) && (TbsShareManager.getHostCorePathAppDefined() == null))
    {
      if (i1 <= 0)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
        QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
      }
    }
    else
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
      a(paramContext, localContext);
    }
  }
  
  void c(Context paramContext, boolean paramBoolean)
  {
    if (QbSdk.b) {
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      return;
    }
    try
    {
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        File localFile = v(paramContext);
        if ((localFile != null) && (localFile.exists()))
        {
          k.a(localFile, false);
          new File(t(paramContext), "x5.tbs").delete();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
    if (!y(paramContext)) {
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
    if ((d(paramContext, "core_unzip_tmp")) && (e(paramContext, paramBoolean))) {
      paramContext = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!";
    }
    for (;;)
    {
      TbsLog.i("TbsInstaller", paramContext, true);
      return;
      if ((d(paramContext, "core_share_backup_tmp")) && (f(paramContext, paramBoolean)))
      {
        paramContext = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!";
      }
      else
      {
        if ((!d(paramContext, "core_copy_tmp")) || (!d(paramContext, paramBoolean))) {
          break;
        }
        paramContext = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!";
      }
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
  }
  
  /* Error */
  boolean c(Context paramContext)
  {
    // Byte code:
    //   0: new 306	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 294	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 388
    //   12: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 7
    //   17: aload 7
    //   19: invokevirtual 600	java/io/File:exists	()Z
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_2
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 390	java/util/Properties
    //   34: dup
    //   35: invokespecial 391	java/util/Properties:<init>	()V
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: new 393	java/io/BufferedInputStream
    //   49: dup
    //   50: new 395	java/io/FileInputStream
    //   53: dup
    //   54: aload 7
    //   56: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_1
    //   63: aload 8
    //   65: aload_1
    //   66: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload 8
    //   71: ldc_w 414
    //   74: ldc_w 1428
    //   77: invokevirtual 627	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 1431	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   83: invokevirtual 916	java/lang/Boolean:booleanValue	()Z
    //   86: istore 4
    //   88: iload_3
    //   89: istore_2
    //   90: iload 4
    //   92: ifeq +26 -> 118
    //   95: iload_3
    //   96: istore_2
    //   97: invokestatic 580	java/lang/System:currentTimeMillis	()J
    //   100: aload 7
    //   102: invokevirtual 1434	java/io/File:lastModified	()J
    //   105: lsub
    //   106: ldc2_w 1435
    //   109: lcmp
    //   110: ifle +8 -> 118
    //   113: iconst_1
    //   114: istore_2
    //   115: goto +3 -> 118
    //   118: new 216	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   125: astore 5
    //   127: aload 5
    //   129: ldc_w 1438
    //   132: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: iload 4
    //   140: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 5
    //   146: ldc_w 1440
    //   149: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 5
    //   155: iload_2
    //   156: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: ldc 127
    //   162: aload 5
    //   164: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: iload 4
    //   172: iload_2
    //   173: iconst_1
    //   174: ixor
    //   175: iand
    //   176: istore_2
    //   177: iload_2
    //   178: istore_3
    //   179: aload_1
    //   180: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   183: iload_2
    //   184: ireturn
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   190: iload_3
    //   191: ireturn
    //   192: astore 5
    //   194: goto +51 -> 245
    //   197: astore 5
    //   199: aload_1
    //   200: astore 6
    //   202: aload 5
    //   204: astore_1
    //   205: goto +16 -> 221
    //   208: astore 6
    //   210: aload 5
    //   212: astore_1
    //   213: aload 6
    //   215: astore 5
    //   217: goto +28 -> 245
    //   220: astore_1
    //   221: iconst_0
    //   222: istore_2
    //   223: aload 6
    //   225: astore 5
    //   227: aload_1
    //   228: invokevirtual 254	java/lang/Throwable:printStackTrace	()V
    //   231: aload 6
    //   233: ifnull +10 -> 243
    //   236: iload_2
    //   237: istore_3
    //   238: aload 6
    //   240: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   243: iload_2
    //   244: ireturn
    //   245: aload_1
    //   246: ifnull +15 -> 261
    //   249: aload_1
    //   250: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   253: goto +8 -> 261
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 430	java/io/IOException:printStackTrace	()V
    //   261: aload 5
    //   263: athrow
    //   264: astore 5
    //   266: aload_1
    //   267: astore 6
    //   269: aload 5
    //   271: astore_1
    //   272: iload 4
    //   274: istore_2
    //   275: goto -52 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	am
    //   0	278	1	paramContext	Context
    //   22	253	2	bool1	boolean
    //   24	214	3	bool2	boolean
    //   86	187	4	bool3	boolean
    //   44	119	5	localStringBuilder	StringBuilder
    //   192	1	5	localObject1	Object
    //   197	14	5	localThrowable1	Throwable
    //   215	47	5	localObject2	Object
    //   264	6	5	localThrowable2	Throwable
    //   41	160	6	localContext1	Context
    //   208	31	6	localObject3	Object
    //   267	1	6	localContext2	Context
    //   15	86	7	localFile	File
    //   38	32	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   179	183	185	java/io/IOException
    //   238	243	185	java/io/IOException
    //   63	88	192	finally
    //   97	113	192	finally
    //   118	170	192	finally
    //   63	88	197	java/lang/Throwable
    //   46	63	208	finally
    //   227	231	208	finally
    //   46	63	220	java/lang/Throwable
    //   249	253	256	java/io/IOException
    //   97	113	264	java/lang/Throwable
    //   118	170	264	java/lang/Throwable
  }
  
  /* Error */
  public void d(Context paramContext)
  {
    // Byte code:
    //   0: new 306	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 294	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 388
    //   12: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_2
    //   16: new 390	java/util/Properties
    //   19: dup
    //   20: invokespecial 391	java/util/Properties:<init>	()V
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_3
    //   30: new 393	java/io/BufferedInputStream
    //   33: dup
    //   34: new 395	java/io/FileInputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_1
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: new 406	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 408	java/io/FileOutputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 409	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 412	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_2
    //   68: aload 5
    //   70: ldc_w 414
    //   73: ldc_w 1428
    //   76: invokevirtual 420	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 5
    //   82: aload_2
    //   83: aconst_null
    //   84: invokevirtual 424	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   87: aload_2
    //   88: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   95: return
    //   96: astore 4
    //   98: aload_2
    //   99: astore_3
    //   100: aload_1
    //   101: astore_2
    //   102: aload 4
    //   104: astore_1
    //   105: goto +25 -> 130
    //   108: goto +48 -> 156
    //   111: astore 4
    //   113: aload_1
    //   114: astore_2
    //   115: aload 4
    //   117: astore_1
    //   118: goto +12 -> 130
    //   121: aload 4
    //   123: astore_2
    //   124: goto +32 -> 156
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_3
    //   131: ifnull +10 -> 141
    //   134: aload_3
    //   135: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   138: goto +3 -> 141
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   149: aload_1
    //   150: athrow
    //   151: aconst_null
    //   152: astore_1
    //   153: aload 4
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +10 -> 167
    //   160: aload_2
    //   161: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   164: goto +3 -> 167
    //   167: aload_1
    //   168: ifnull +6 -> 174
    //   171: goto -80 -> 91
    //   174: return
    //   175: astore_1
    //   176: return
    //   177: astore_1
    //   178: goto -27 -> 151
    //   181: astore_2
    //   182: goto -61 -> 121
    //   185: astore_3
    //   186: goto -78 -> 108
    //   189: astore_2
    //   190: goto -99 -> 91
    //   193: astore_3
    //   194: goto -53 -> 141
    //   197: astore_2
    //   198: goto -49 -> 149
    //   201: astore_2
    //   202: goto -35 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	am
    //   0	205	1	paramContext	Context
    //   15	146	2	localObject1	Object
    //   181	1	2	localThrowable1	Throwable
    //   189	1	2	localIOException1	java.io.IOException
    //   197	1	2	localIOException2	java.io.IOException
    //   201	1	2	localIOException3	java.io.IOException
    //   29	106	3	localObject2	Object
    //   185	1	3	localThrowable2	Throwable
    //   193	1	3	localIOException4	java.io.IOException
    //   26	1	4	localObject3	Object
    //   96	7	4	localObject4	Object
    //   111	43	4	localObject5	Object
    //   23	58	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   68	87	96	finally
    //   46	68	111	finally
    //   30	46	127	finally
    //   0	25	175	java/lang/Throwable
    //   87	91	175	java/lang/Throwable
    //   91	95	175	java/io/IOException
    //   91	95	175	java/lang/Throwable
    //   134	138	175	java/lang/Throwable
    //   145	149	175	java/lang/Throwable
    //   149	151	175	java/lang/Throwable
    //   160	164	175	java/lang/Throwable
    //   30	46	177	java/lang/Throwable
    //   46	68	181	java/lang/Throwable
    //   68	87	185	java/lang/Throwable
    //   87	91	189	java/io/IOException
    //   134	138	193	java/io/IOException
    //   145	149	197	java/io/IOException
    //   160	164	201	java/io/IOException
  }
  
  boolean d(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = TbsShareManager.isThirdPartyApp(paramContext);
        File localFile;
        Object localObject;
        if (bool)
        {
          if (TbsShareManager.j(paramContext))
          {
            localFile = new File(TbsShareManager.c(paramContext));
            localObject = localFile;
            if (localFile.getAbsolutePath().contains("com.tencent.tbs")) {
              return true;
            }
          }
          else
          {
            TbsLog.e("TbsInstaller", "321");
            return false;
          }
        }
        else {
          localObject = r(paramContext);
        }
        int i1;
        if (localObject != null)
        {
          Long[][] arrayOfLong = n;
          int i2 = arrayOfLong.length;
          i1 = 0;
          if (i1 >= i2) {
            break;
          }
          localFile = arrayOfLong[i1];
          if (paramInt == localFile[0].intValue())
          {
            localObject = new File((File)localObject, "libmttwebview.so");
            if ((((File)localObject).exists()) && (((File)localObject).length() == localFile[1].longValue()))
            {
              paramContext = new StringBuilder();
              paramContext.append("check so success: ");
              paramContext.append(paramInt);
              paramContext.append("; file: ");
              paramContext.append(localObject);
              TbsLog.d("TbsInstaller", paramContext.toString());
              break;
            }
            if (!bool) {
              k.b(paramContext.getDir("tbs", 0));
            }
            a.set(Integer.valueOf(0));
            paramContext = "322";
            TbsLog.e("TbsInstaller", paramContext);
            return false;
          }
        }
        else
        {
          paramContext = "323";
          continue;
        }
        i1 += 1;
      }
      catch (Throwable paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ISTBSCORELEGAL exception getMessage is ");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        TbsLog.e("TbsInstaller", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ISTBSCORELEGAL exception getCause is ");
        ((StringBuilder)localObject).append(paramContext.getCause());
        TbsLog.e("TbsInstaller", ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  public boolean e(Context paramContext)
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new File(k.a(paramContext, 4), "x5.tbs.decouple");
        File localFile1 = a().v(paramContext);
        k.a(localFile1);
        k.a(localFile1, true);
        k.a((File)localObject, localFile1);
        localObject = localFile1.list();
        i1 = 0;
        if (i1 < localObject.length)
        {
          File localFile2 = new File(localFile1, localObject[i1]);
          if (localFile2.getName().endsWith(".dex")) {
            localFile2.delete();
          }
        }
        else
        {
          a().g(paramContext, true);
          localObject = q(paramContext);
          k.a((File)localObject, true);
          localFile1.renameTo((File)localObject);
          TbsShareManager.b(paramContext);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      i1 += 1;
    }
  }
  
  boolean f(Context paramContext)
  {
    if (TbsShareManager.getHostCorePathAppDefined() != null) {
      return true;
    }
    try
    {
      Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
      if (paramContext.getPackageName().equals("com.tencent.mtt"))
      {
        if (!localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        if (!localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
      {
        if (!localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.tbs"))
      {
        if (!localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.qzone"))
      {
        if (!localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.qqpimsecure"))
      {
        boolean bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
    return false;
  }
  
  public void g(Context paramContext)
  {
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      for (;;) {}
    }
    bool = true;
    if (!bool) {
      return;
    }
    if (l != null) {
      k.a(paramContext, l);
    }
  }
  
  /* Error */
  int h(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 304	com/tencent/smtt/sdk/am:u	(Landroid/content/Context;)Ljava/io/File;
    //   10: astore_1
    //   11: new 216	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   18: astore 5
    //   20: aload 5
    //   22: ldc_w 1515
    //   25: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 5
    //   31: aload_1
    //   32: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 127
    //   38: aload 5
    //   40: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: new 306	java/io/File
    //   49: dup
    //   50: aload_1
    //   51: ldc_w 388
    //   54: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 600	java/io/File:exists	()Z
    //   62: ifne +5 -> 67
    //   65: iconst_0
    //   66: ireturn
    //   67: new 390	java/util/Properties
    //   70: dup
    //   71: invokespecial 391	java/util/Properties:<init>	()V
    //   74: astore 5
    //   76: new 393	java/io/BufferedInputStream
    //   79: dup
    //   80: new 395	java/io/FileInputStream
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   91: astore_1
    //   92: aload 5
    //   94: aload_1
    //   95: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   98: aload_1
    //   99: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   102: aload 5
    //   104: ldc_w 1209
    //   107: invokevirtual 1210	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_3
    //   111: aload_3
    //   112: ifnonnull +9 -> 121
    //   115: aload_1
    //   116: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload_3
    //   122: invokestatic 1213	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: istore_2
    //   126: aload_1
    //   127: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   130: iload_2
    //   131: ireturn
    //   132: astore 4
    //   134: aload_1
    //   135: astore_3
    //   136: aload 4
    //   138: astore_1
    //   139: goto +7 -> 146
    //   142: goto +14 -> 156
    //   145: astore_1
    //   146: aload_3
    //   147: ifnull +7 -> 154
    //   150: aload_3
    //   151: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_1
    //   167: aload 4
    //   169: astore_1
    //   170: goto -14 -> 156
    //   173: astore_3
    //   174: goto -32 -> 142
    //   177: astore_1
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_1
    //   181: iload_2
    //   182: ireturn
    //   183: astore_3
    //   184: goto -30 -> 154
    //   187: astore_1
    //   188: iconst_0
    //   189: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	am
    //   0	190	1	paramContext	Context
    //   125	57	2	i1	int
    //   4	147	3	localObject1	Object
    //   173	1	3	localException	Exception
    //   183	1	3	localIOException	java.io.IOException
    //   1	1	4	localObject2	Object
    //   132	36	4	localObject3	Object
    //   18	85	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   92	111	132	finally
    //   121	126	132	finally
    //   5	65	145	finally
    //   67	92	145	finally
    //   5	65	166	java/lang/Exception
    //   67	92	166	java/lang/Exception
    //   92	111	173	java/lang/Exception
    //   121	126	173	java/lang/Exception
    //   115	119	177	java/io/IOException
    //   126	130	180	java/io/IOException
    //   150	154	183	java/io/IOException
    //   160	164	187	java/io/IOException
  }
  
  /* Error */
  int i(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 306	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 570	com/tencent/smtt/sdk/am:q	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc_w 388
    //   17: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 600	java/io/File:exists	()Z
    //   25: ifne +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: new 390	java/util/Properties
    //   33: dup
    //   34: invokespecial 391	java/util/Properties:<init>	()V
    //   37: astore 5
    //   39: new 393	java/io/BufferedInputStream
    //   42: dup
    //   43: new 395	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_1
    //   55: aload 5
    //   57: aload_1
    //   58: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   61: aload_1
    //   62: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   65: aload 5
    //   67: ldc_w 1209
    //   70: invokevirtual 1210	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull +9 -> 84
    //   78: aload_1
    //   79: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   82: iconst_0
    //   83: ireturn
    //   84: aload_3
    //   85: invokestatic 1213	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   88: istore_2
    //   89: aload_1
    //   90: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   93: iload_2
    //   94: ireturn
    //   95: astore 4
    //   97: aload_1
    //   98: astore_3
    //   99: aload 4
    //   101: astore_1
    //   102: goto +7 -> 109
    //   105: goto +14 -> 119
    //   108: astore_1
    //   109: aload_3
    //   110: ifnull +7 -> 117
    //   113: aload_3
    //   114: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_1
    //   130: aload 4
    //   132: astore_1
    //   133: goto -14 -> 119
    //   136: astore_3
    //   137: goto -32 -> 105
    //   140: astore_1
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_1
    //   144: iload_2
    //   145: ireturn
    //   146: astore_3
    //   147: goto -30 -> 117
    //   150: astore_1
    //   151: iconst_0
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	am
    //   0	153	1	paramContext	Context
    //   88	57	2	i1	int
    //   4	110	3	localObject1	Object
    //   136	1	3	localException	Exception
    //   146	1	3	localIOException	java.io.IOException
    //   1	1	4	localObject2	Object
    //   95	36	4	localObject3	Object
    //   37	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   55	74	95	finally
    //   84	89	95	finally
    //   5	28	108	finally
    //   30	55	108	finally
    //   5	28	129	java/lang/Exception
    //   30	55	129	java/lang/Exception
    //   55	74	136	java/lang/Exception
    //   84	89	136	java/lang/Exception
    //   78	82	140	java/io/IOException
    //   89	93	143	java/io/IOException
    //   113	117	146	java/io/IOException
    //   123	127	150	java/io/IOException
  }
  
  /* Error */
  int j(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: new 306	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 294	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 388
    //   21: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload 4
    //   27: astore_3
    //   28: aload_1
    //   29: invokevirtual 600	java/io/File:exists	()Z
    //   32: ifne +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload 4
    //   39: astore_3
    //   40: new 390	java/util/Properties
    //   43: dup
    //   44: invokespecial 391	java/util/Properties:<init>	()V
    //   47: astore 6
    //   49: aload 4
    //   51: astore_3
    //   52: new 393	java/io/BufferedInputStream
    //   55: dup
    //   56: new 395	java/io/FileInputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_1
    //   68: aload 6
    //   70: aload_1
    //   71: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   74: aload_1
    //   75: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   78: aload 6
    //   80: ldc_w 1209
    //   83: invokevirtual 1210	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: ifnonnull +46 -> 134
    //   91: aload_1
    //   92: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_1
    //   98: new 216	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   105: astore_3
    //   106: aload_3
    //   107: ldc_w 1517
    //   110: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: aload_1
    //   116: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   119: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: ldc 127
    //   125: aload_3
    //   126: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_3
    //   135: invokestatic 1213	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   138: istore_2
    //   139: getstatic 97	com/tencent/smtt/sdk/am:o	I
    //   142: ifne +7 -> 149
    //   145: iload_2
    //   146: putstatic 97	com/tencent/smtt/sdk/am:o	I
    //   149: aload_1
    //   150: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   153: iload_2
    //   154: ireturn
    //   155: astore_1
    //   156: new 216	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   163: astore_3
    //   164: aload_3
    //   165: ldc_w 1517
    //   168: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_3
    //   173: aload_1
    //   174: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   177: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 127
    //   183: aload_3
    //   184: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: iload_2
    //   191: ireturn
    //   192: astore 4
    //   194: aload_1
    //   195: astore_3
    //   196: aload 4
    //   198: astore_1
    //   199: goto +111 -> 310
    //   202: astore 4
    //   204: goto +12 -> 216
    //   207: astore_1
    //   208: goto +102 -> 310
    //   211: astore 4
    //   213: aload 5
    //   215: astore_1
    //   216: aload_1
    //   217: astore_3
    //   218: new 216	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload 5
    //   231: ldc_w 1520
    //   234: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_1
    //   239: astore_3
    //   240: aload 5
    //   242: aload 4
    //   244: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   247: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_1
    //   252: astore_3
    //   253: ldc 127
    //   255: aload 5
    //   257: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_1
    //   264: ifnull +44 -> 308
    //   267: aload_1
    //   268: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: new 216	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   281: astore_3
    //   282: aload_3
    //   283: ldc_w 1517
    //   286: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_3
    //   291: aload_1
    //   292: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   295: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc 127
    //   301: aload_3
    //   302: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: iconst_0
    //   309: ireturn
    //   310: aload_3
    //   311: ifnull +49 -> 360
    //   314: aload_3
    //   315: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   318: goto +42 -> 360
    //   321: astore_3
    //   322: new 216	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   329: astore 4
    //   331: aload 4
    //   333: ldc_w 1517
    //   336: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 4
    //   342: aload_3
    //   343: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   346: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 127
    //   352: aload 4
    //   354: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_1
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	am
    //   0	362	1	paramContext	Context
    //   138	53	2	i1	int
    //   8	307	3	localObject1	Object
    //   321	22	3	localIOException	java.io.IOException
    //   4	46	4	localObject2	Object
    //   192	5	4	localObject3	Object
    //   202	1	4	localException1	Exception
    //   211	32	4	localException2	Exception
    //   329	24	4	localStringBuilder1	StringBuilder
    //   1	255	5	localStringBuilder2	StringBuilder
    //   47	32	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   91	95	97	java/io/IOException
    //   149	153	155	java/io/IOException
    //   68	87	192	finally
    //   134	149	192	finally
    //   68	87	202	java/lang/Exception
    //   134	149	202	java/lang/Exception
    //   9	25	207	finally
    //   28	35	207	finally
    //   40	49	207	finally
    //   52	68	207	finally
    //   218	227	207	finally
    //   229	238	207	finally
    //   240	251	207	finally
    //   253	263	207	finally
    //   9	25	211	java/lang/Exception
    //   28	35	211	java/lang/Exception
    //   40	49	211	java/lang/Exception
    //   52	68	211	java/lang/Exception
    //   267	271	273	java/io/IOException
    //   314	318	321	java/io/IOException
  }
  
  int k(Context paramContext)
  {
    if (o != 0) {
      return o;
    }
    return j(paramContext);
  }
  
  void l(Context paramContext)
  {
    if (o != 0) {
      return;
    }
    o = j(paramContext);
  }
  
  boolean m(Context paramContext)
  {
    return new File(r(paramContext), "tbs.conf").exists();
  }
  
  /* Error */
  int n(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 495	com/tencent/smtt/sdk/am:x	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: invokevirtual 1063	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   16: istore_3
    //   17: new 216	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: ldc_w 1522
    //   31: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: iload_3
    //   38: invokevirtual 505	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 127
    //   44: aload 4
    //   46: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iload_3
    //   53: ifeq +701 -> 754
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 5
    //   62: aload 5
    //   64: astore 4
    //   66: new 306	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 294	com/tencent/smtt/sdk/am:r	(Landroid/content/Context;)Ljava/io/File;
    //   75: ldc_w 388
    //   78: invokespecial 383	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   81: astore_1
    //   82: aload 5
    //   84: astore 4
    //   86: aload_1
    //   87: invokevirtual 600	java/io/File:exists	()Z
    //   90: istore_3
    //   91: iload_3
    //   92: ifne +63 -> 155
    //   95: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: invokevirtual 1525	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   101: ifeq +48 -> 149
    //   104: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   107: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   110: goto +39 -> 149
    //   113: astore_1
    //   114: new 216	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: ldc_w 1527
    //   128: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload_1
    //   135: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 127
    //   141: aload 4
    //   143: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: aload 5
    //   157: astore 4
    //   159: new 390	java/util/Properties
    //   162: dup
    //   163: invokespecial 391	java/util/Properties:<init>	()V
    //   166: astore 7
    //   168: aload 5
    //   170: astore 4
    //   172: new 393	java/io/BufferedInputStream
    //   175: dup
    //   176: new 395	java/io/FileInputStream
    //   179: dup
    //   180: aload_1
    //   181: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   184: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   187: astore_1
    //   188: aload 7
    //   190: aload_1
    //   191: invokevirtual 404	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   194: aload_1
    //   195: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   198: aload 7
    //   200: ldc_w 1209
    //   203: invokevirtual 1210	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 4
    //   208: aload 4
    //   210: ifnonnull +109 -> 319
    //   213: aload_1
    //   214: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   217: goto +42 -> 259
    //   220: astore_1
    //   221: new 216	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: ldc_w 1529
    //   235: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 4
    //   241: aload_1
    //   242: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   245: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: ldc 127
    //   251: aload 4
    //   253: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   262: invokevirtual 1525	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   265: ifeq +48 -> 313
    //   268: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   271: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   274: goto +39 -> 313
    //   277: astore_1
    //   278: new 216	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   285: astore 4
    //   287: aload 4
    //   289: ldc_w 1527
    //   292: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 4
    //   298: aload_1
    //   299: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 127
    //   305: aload 4
    //   307: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_0
    //   314: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: getstatic 50	com/tencent/smtt/sdk/am:a	Ljava/lang/ThreadLocal;
    //   322: aload 4
    //   324: invokestatic 1213	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   327: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: invokevirtual 251	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   333: getstatic 50	com/tencent/smtt/sdk/am:a	Ljava/lang/ThreadLocal;
    //   336: invokevirtual 1217	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   339: checkcast 242	java/lang/Integer
    //   342: invokevirtual 1220	java/lang/Integer:intValue	()I
    //   345: istore_2
    //   346: aload_1
    //   347: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   350: goto +42 -> 392
    //   353: astore_1
    //   354: new 216	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   361: astore 4
    //   363: aload 4
    //   365: ldc_w 1529
    //   368: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: aload_1
    //   375: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   378: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 127
    //   384: aload 4
    //   386: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   395: invokevirtual 1525	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   398: ifeq +48 -> 446
    //   401: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   404: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   407: goto +39 -> 446
    //   410: astore_1
    //   411: new 216	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   418: astore 4
    //   420: aload 4
    //   422: ldc_w 1527
    //   425: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 4
    //   431: aload_1
    //   432: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 127
    //   438: aload 4
    //   440: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_0
    //   447: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   450: iload_2
    //   451: ireturn
    //   452: astore 5
    //   454: aload_1
    //   455: astore 4
    //   457: aload 5
    //   459: astore_1
    //   460: goto +178 -> 638
    //   463: astore 5
    //   465: goto +12 -> 477
    //   468: astore_1
    //   469: goto +169 -> 638
    //   472: astore 5
    //   474: aload 6
    //   476: astore_1
    //   477: aload_1
    //   478: astore 4
    //   480: new 216	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   487: astore 6
    //   489: aload_1
    //   490: astore 4
    //   492: aload 6
    //   494: ldc_w 1531
    //   497: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: astore 4
    //   504: aload 6
    //   506: aload 5
    //   508: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   511: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_1
    //   516: astore 4
    //   518: ldc 127
    //   520: aload 6
    //   522: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_1
    //   529: ifnull +49 -> 578
    //   532: aload_1
    //   533: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   536: goto +42 -> 578
    //   539: astore_1
    //   540: new 216	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   547: astore 4
    //   549: aload 4
    //   551: ldc_w 1529
    //   554: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 4
    //   560: aload_1
    //   561: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   564: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 127
    //   570: aload 4
    //   572: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   581: invokevirtual 1525	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   584: ifeq +48 -> 632
    //   587: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   590: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   593: goto +39 -> 632
    //   596: astore_1
    //   597: new 216	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   604: astore 4
    //   606: aload 4
    //   608: ldc_w 1527
    //   611: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 4
    //   617: aload_1
    //   618: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: ldc 127
    //   624: aload 4
    //   626: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: aload_0
    //   633: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   636: iconst_0
    //   637: ireturn
    //   638: aload 4
    //   640: ifnull +52 -> 692
    //   643: aload 4
    //   645: invokevirtual 431	java/io/BufferedInputStream:close	()V
    //   648: goto +44 -> 692
    //   651: astore 4
    //   653: new 216	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   660: astore 5
    //   662: aload 5
    //   664: ldc_w 1529
    //   667: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 5
    //   673: aload 4
    //   675: invokevirtual 1518	java/io/IOException:toString	()Ljava/lang/String;
    //   678: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: ldc 127
    //   684: aload 5
    //   686: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   695: invokevirtual 1525	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   698: ifeq +50 -> 748
    //   701: getstatic 41	com/tencent/smtt/sdk/am:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   704: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   707: goto +41 -> 748
    //   710: astore 4
    //   712: new 216	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   719: astore 5
    //   721: aload 5
    //   723: ldc_w 1527
    //   726: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 5
    //   732: aload 4
    //   734: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: ldc 127
    //   740: aload 5
    //   742: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 452	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload_0
    //   749: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   752: aload_1
    //   753: athrow
    //   754: aload_0
    //   755: invokevirtual 531	com/tencent/smtt/sdk/am:b	()V
    //   758: iconst_0
    //   759: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	am
    //   0	760	1	paramContext	Context
    //   345	106	2	i1	int
    //   16	76	3	bool	boolean
    //   24	620	4	localObject1	Object
    //   651	23	4	localIOException	java.io.IOException
    //   710	23	4	localThrowable	Throwable
    //   60	109	5	localObject2	Object
    //   452	6	5	localObject3	Object
    //   463	1	5	localException1	Exception
    //   472	35	5	localException2	Exception
    //   660	81	5	localStringBuilder1	StringBuilder
    //   57	464	6	localStringBuilder2	StringBuilder
    //   166	33	7	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   95	110	113	java/lang/Throwable
    //   213	217	220	java/io/IOException
    //   259	274	277	java/lang/Throwable
    //   346	350	353	java/io/IOException
    //   392	407	410	java/lang/Throwable
    //   188	208	452	finally
    //   319	346	452	finally
    //   188	208	463	java/lang/Exception
    //   319	346	463	java/lang/Exception
    //   66	82	468	finally
    //   86	91	468	finally
    //   159	168	468	finally
    //   172	188	468	finally
    //   480	489	468	finally
    //   492	501	468	finally
    //   504	515	468	finally
    //   518	528	468	finally
    //   66	82	472	java/lang/Exception
    //   86	91	472	java/lang/Exception
    //   159	168	472	java/lang/Exception
    //   172	188	472	java/lang/Exception
    //   532	536	539	java/io/IOException
    //   578	593	596	java/lang/Throwable
    //   643	648	651	java/io/IOException
    //   692	707	710	java/lang/Throwable
  }
  
  public boolean o(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = r(paramContext);
    File localFile2 = q(paramContext);
    try
    {
      k.a(localFile2, true);
      k.a(localFile1, localFile2, new at(this));
      TbsShareManager.b(paramContext);
      TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  void p(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    ai.a(paramContext).a(0);
    ai.a(paramContext).b(0);
    ai.a(paramContext).d(0);
    ai.a(paramContext).a("incrupdate_retry_num", 0);
    if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) != 1)
    {
      ai.a(paramContext).b(0, -1);
      ai.a(paramContext).a("");
      ai.a(paramContext).a("copy_retry_num", 0);
      ai.a(paramContext).c(-1);
      ai.a(paramContext).a(0, -1);
      k.a(u(paramContext), true);
      k.a(w(paramContext), true);
    }
  }
  
  File q(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  File r(Context paramContext)
  {
    return b(null, paramContext);
  }
  
  File s(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  File u(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  File v(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  File w(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_copy_tmp");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  boolean x(Context paramContext)
  {
    try
    {
      this.e += 1;
      if (this.h)
      {
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
        return true;
      }
      this.g = k.b(paramContext, true, "tbslock.txt");
      if (this.g != null)
      {
        this.f = k.a(paramContext, this.g);
        paramContext = this.f;
        if (paramContext == null) {
          return false;
        }
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
        this.h = true;
        return true;
      }
      return false;
    }
    finally {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */