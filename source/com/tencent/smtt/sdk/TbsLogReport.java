package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.s;
import com.tencent.smtt.utils.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

class TbsLogReport
{
  private static TbsLogReport a;
  private Handler b = null;
  private Context c;
  private boolean d = false;
  
  private TbsLogReport(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    paramContext = new HandlerThread("TbsLogReportThread");
    paramContext.start();
    this.b = new aw(this, paramContext.getLooper());
  }
  
  public static TbsLogReport a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TbsLogReport(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  private String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, TbsLogInfo paramTbsLogInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt));
    localStringBuilder.append(a(b.c(this.c)));
    localStringBuilder.append(a(s.a(this.c)));
    localStringBuilder.append(a(am.a().n(this.c)));
    Object localObject1 = Build.MODEL;
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      SharedPreferences localSharedPreferences;
      int i;
      for (;;) {}
    }
    localStringBuilder.append(a((String)localObject1));
    localObject1 = this.c.getPackageName();
    localStringBuilder.append(a((String)localObject1));
    if ("com.tencent.mm".equals(localObject1)) {}
    for (localObject1 = a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));; localObject1 = a(b.b(this.c)))
    {
      localStringBuilder.append((String)localObject1);
      break;
    }
    localStringBuilder.append(a(a(TbsLogInfo.a(paramTbsLogInfo))));
    localStringBuilder.append(a(TbsLogInfo.b(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.c(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.d(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.e(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.f(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.g(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.h(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.i(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.j(paramTbsLogInfo)));
    localStringBuilder.append(b(TbsLogInfo.k(paramTbsLogInfo)));
    localStringBuilder.append(b(TbsLogInfo.l(paramTbsLogInfo)));
    localStringBuilder.append(b(TbsLogInfo.m(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.n(paramTbsLogInfo)));
    localStringBuilder.append(a(paramTbsLogInfo.a));
    localStringBuilder.append(a(TbsLogInfo.o(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsLogInfo.p(paramTbsLogInfo)));
    localStringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt("tbs_download_version", 0)));
    localStringBuilder.append(a(b.f(this.c)));
    localStringBuilder.append(a("3.6.0.1315_43612"));
    localStringBuilder.append(false);
    localSharedPreferences = i();
    localObject1 = f();
    localObject2 = new JSONArray();
    paramTbsLogInfo = (TbsLogInfo)localObject1;
    if (((JSONArray)localObject2).length() >= 5)
    {
      i = 4;
      while (i >= 1)
      {
        try
        {
          ((JSONArray)localObject2).put(((JSONArray)localObject1).get(((JSONArray)localObject2).length() - i));
        }
        catch (Exception paramTbsLogInfo)
        {
          for (;;) {}
        }
        TbsLog.e("upload", "JSONArray transform error!");
        i -= 1;
      }
      paramTbsLogInfo = (TbsLogInfo)localObject2;
    }
    paramTbsLogInfo.put(localStringBuilder.toString());
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putString("tbs_download_upload", paramTbsLogInfo.toString());
    ((SharedPreferences.Editor)localObject1).commit();
    if ((this.d) || (paramInt != EventType.TYPE_LOAD.a)) {
      g();
    }
  }
  
  private void a(int paramInt, TbsLogInfo paramTbsLogInfo, EventType paramEventType)
  {
    paramTbsLogInfo.setErrorCode(paramInt);
    paramTbsLogInfo.setEventTime(System.currentTimeMillis());
    QbSdk.m.onInstallFinish(paramInt);
    a(paramEventType, paramTbsLogInfo);
  }
  
  private String b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  private JSONArray f()
  {
    Object localObject = i().getString("tbs_download_upload", null);
    if (localObject == null) {
      return new JSONArray();
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      if (((JSONArray)localObject).length() > 5)
      {
        JSONArray localJSONArray = new JSONArray();
        int i = ((JSONArray)localObject).length() - 1;
        if (i > ((JSONArray)localObject).length() - 5)
        {
          localJSONArray.put(((JSONArray)localObject).get(i));
          return localJSONArray;
        }
      }
      return (JSONArray)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return new JSONArray();
  }
  
  private void g()
  {
    Object localObject1;
    if ((QbSdk.n != null) && (QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false"))) {
      localObject1 = "upload";
    }
    for (Object localObject2 = "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";; localObject2 = "[TbsApkDownloadStat.reportDownloadStat] no data")
    {
      TbsLog.i((String)localObject1, (String)localObject2);
      return;
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
      localObject1 = f();
      if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[TbsApkDownloadStat.reportDownloadStat] jsonArray:");
        ((StringBuilder)localObject2).append(localObject1);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
        try
        {
          localObject1 = n.a(v.a(this.c).c(), ((JSONArray)localObject1).toString().getBytes("utf-8"), new ay(this), true);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[TbsApkDownloadStat.reportDownloadStat] response:");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" testcase: ");
          ((StringBuilder)localObject2).append(-1);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
      }
      String str = "TbsDownload";
    }
  }
  
  private void h()
  {
    SharedPreferences.Editor localEditor = i().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private SharedPreferences i()
  {
    return this.c.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public TbsLogInfo a()
  {
    return new TbsLogInfo(null);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, EventType.TYPE_INSTALL);
  }
  
  public void a(int paramInt, String paramString, EventType paramEventType)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error occured in installation, errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString(), true);
    }
    Object localObject = a();
    ((TbsLogInfo)localObject).setFailDetail(paramString);
    a(paramInt, (TbsLogInfo)localObject, paramEventType);
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    TbsLogInfo localTbsLogInfo = a();
    localTbsLogInfo.setFailDetail(paramThrowable);
    a(paramInt, localTbsLogInfo, EventType.TYPE_INSTALL);
  }
  
  public void a(EventType paramEventType, TbsLogInfo paramTbsLogInfo)
  {
    try
    {
      paramTbsLogInfo = (TbsLogInfo)paramTbsLogInfo.clone();
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 600;
      localMessage.arg1 = paramEventType.a;
      localMessage.obj = paramTbsLogInfo;
      this.b.sendMessage(localMessage);
      return;
    }
    catch (Throwable paramEventType)
    {
      paramTbsLogInfo = new StringBuilder();
      paramTbsLogInfo.append("[TbsLogReport.eventReport] error, message=");
      paramTbsLogInfo.append(paramEventType.getMessage());
      TbsLog.w("upload", paramTbsLogInfo.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b()
  {
    this.b.sendEmptyMessage(601);
  }
  
  public void b(int paramInt, String paramString)
  {
    TbsLogInfo localTbsLogInfo = a();
    localTbsLogInfo.setErrorCode(paramInt);
    localTbsLogInfo.setEventTime(System.currentTimeMillis());
    localTbsLogInfo.setFailDetail(paramString);
    a(EventType.TYPE_LOAD, localTbsLogInfo);
  }
  
  public void b(int paramInt, Throwable paramThrowable)
  {
    Object localObject = "NULL";
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg: ");
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      ((StringBuilder)localObject).append("; err: ");
      ((StringBuilder)localObject).append(paramThrowable);
      ((StringBuilder)localObject).append("; cause: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramThrowable.getCause()));
      localObject = ((StringBuilder)localObject).toString();
      paramThrowable = (Throwable)localObject;
      if (((String)localObject).length() > 1024) {
        paramThrowable = ((String)localObject).substring(0, 1024);
      }
      localObject = paramThrowable;
    }
    b(paramInt, (String)localObject);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: getstatic 343	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   3: ifnull +47 -> 50
    //   6: getstatic 343	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   9: getstatic 346	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   12: invokeinterface 351 2 0
    //   17: ifeq +33 -> 50
    //   20: getstatic 343	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   23: getstatic 346	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   26: invokeinterface 354 2 0
    //   31: ldc_w 356
    //   34: invokevirtual 357	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +13 -> 50
    //   40: ldc_w 266
    //   43: ldc_w 500
    //   46: invokestatic 361	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: return
    //   50: aload_0
    //   51: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   54: invokestatic 505	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   57: iconst_3
    //   58: if_icmpeq +4 -> 62
    //   61: return
    //   62: invokestatic 508	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnonnull +4 -> 73
    //   72: return
    //   73: invokestatic 513	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   76: invokevirtual 515	com/tencent/smtt/utils/o:b	()Ljava/lang/String;
    //   79: astore 11
    //   81: aload_0
    //   82: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   85: invokestatic 115	com/tencent/smtt/utils/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   93: invokestatic 238	com/tencent/smtt/utils/b:f	(Landroid/content/Context;)Ljava/lang/String;
    //   96: astore_2
    //   97: aload_3
    //   98: invokevirtual 518	java/lang/String:getBytes	()[B
    //   101: astore 4
    //   103: aload_2
    //   104: invokevirtual 518	java/lang/String:getBytes	()[B
    //   107: astore_3
    //   108: invokestatic 513	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   111: aload 4
    //   113: invokevirtual 521	com/tencent/smtt/utils/o:a	([B)[B
    //   116: astore_2
    //   117: invokestatic 513	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   120: aload_3
    //   121: invokevirtual 521	com/tencent/smtt/utils/o:a	([B)[B
    //   124: astore 4
    //   126: aload 4
    //   128: astore_3
    //   129: goto +6 -> 135
    //   132: aload 4
    //   134: astore_2
    //   135: aload_2
    //   136: invokestatic 524	com/tencent/smtt/utils/o:b	([B)Ljava/lang/String;
    //   139: astore_2
    //   140: aload_3
    //   141: invokestatic 524	com/tencent/smtt/utils/o:b	([B)Ljava/lang/String;
    //   144: astore_3
    //   145: new 65	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   152: astore 4
    //   154: aload 4
    //   156: aload_0
    //   157: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   160: invokestatic 375	com/tencent/smtt/utils/v:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/v;
    //   163: invokevirtual 526	com/tencent/smtt/utils/v:e	()Ljava/lang/String;
    //   166: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 4
    //   172: aload_2
    //   173: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: ldc_w 528
    //   182: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: aload_3
    //   189: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 4
    //   195: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 12
    //   200: new 530	java/util/HashMap
    //   203: dup
    //   204: invokespecial 531	java/util/HashMap:<init>	()V
    //   207: astore 13
    //   209: aload 13
    //   211: ldc_w 533
    //   214: ldc_w 535
    //   217: invokeinterface 538 3 0
    //   222: pop
    //   223: aload 13
    //   225: ldc_w 540
    //   228: ldc -116
    //   230: invokeinterface 538 3 0
    //   235: pop
    //   236: aload 13
    //   238: ldc_w 542
    //   241: aload_0
    //   242: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   245: invokestatic 121	com/tencent/smtt/utils/s:a	(Landroid/content/Context;)Ljava/lang/String;
    //   248: invokeinterface 538 3 0
    //   253: pop
    //   254: aconst_null
    //   255: astore 4
    //   257: aconst_null
    //   258: astore 10
    //   260: new 544	java/io/File
    //   263: dup
    //   264: getstatic 548	com/tencent/smtt/utils/k:a	Ljava/lang/String;
    //   267: invokespecial 549	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: pop
    //   271: new 65	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: getstatic 548	com/tencent/smtt/utils/k:a	Ljava/lang/String;
    //   283: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_2
    //   288: ldc_w 551
    //   291: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: new 12	com/tencent/smtt/sdk/TbsLogReport$a
    //   298: dup
    //   299: aload 5
    //   301: aload_2
    //   302: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokespecial 553	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: invokevirtual 555	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   311: new 544	java/io/File
    //   314: dup
    //   315: getstatic 548	com/tencent/smtt/utils/k:a	Ljava/lang/String;
    //   318: ldc_w 557
    //   321: invokespecial 558	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: astore_2
    //   325: new 560	java/io/FileInputStream
    //   328: dup
    //   329: aload_2
    //   330: invokespecial 563	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   333: astore_3
    //   334: sipush 8192
    //   337: newarray <illegal type>
    //   339: astore 5
    //   341: new 565	java/io/ByteArrayOutputStream
    //   344: dup
    //   345: invokespecial 566	java/io/ByteArrayOutputStream:<init>	()V
    //   348: astore 9
    //   350: aload_2
    //   351: astore 4
    //   353: aload_3
    //   354: astore 6
    //   356: aload 9
    //   358: astore 7
    //   360: aload_3
    //   361: aload 5
    //   363: invokevirtual 570	java/io/FileInputStream:read	([B)I
    //   366: istore_1
    //   367: iload_1
    //   368: iconst_m1
    //   369: if_icmpeq +25 -> 394
    //   372: aload_2
    //   373: astore 4
    //   375: aload_3
    //   376: astore 6
    //   378: aload 9
    //   380: astore 7
    //   382: aload 9
    //   384: aload 5
    //   386: iconst_0
    //   387: iload_1
    //   388: invokevirtual 574	java/io/ByteArrayOutputStream:write	([BII)V
    //   391: goto -41 -> 350
    //   394: aload_2
    //   395: astore 4
    //   397: aload_3
    //   398: astore 6
    //   400: aload 9
    //   402: astore 7
    //   404: aload 9
    //   406: invokevirtual 577	java/io/ByteArrayOutputStream:flush	()V
    //   409: aload_2
    //   410: astore 4
    //   412: aload_3
    //   413: astore 6
    //   415: aload 9
    //   417: astore 7
    //   419: invokestatic 513	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   422: aload 9
    //   424: invokevirtual 580	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   427: invokevirtual 521	com/tencent/smtt/utils/o:a	([B)[B
    //   430: astore 5
    //   432: aload_3
    //   433: invokevirtual 583	java/io/FileInputStream:close	()V
    //   436: aload 9
    //   438: invokevirtual 584	java/io/ByteArrayOutputStream:close	()V
    //   441: aload_2
    //   442: invokevirtual 587	java/io/File:delete	()Z
    //   445: pop
    //   446: aload 5
    //   448: astore_2
    //   449: goto +125 -> 574
    //   452: astore 8
    //   454: aload_2
    //   455: astore 5
    //   457: aload 9
    //   459: astore_2
    //   460: goto +66 -> 526
    //   463: astore 5
    //   465: aconst_null
    //   466: astore 7
    //   468: goto +165 -> 633
    //   471: astore 8
    //   473: aconst_null
    //   474: astore 4
    //   476: aload_2
    //   477: astore 5
    //   479: aload 4
    //   481: astore_2
    //   482: goto +44 -> 526
    //   485: astore 5
    //   487: aconst_null
    //   488: astore 7
    //   490: aload 4
    //   492: astore_3
    //   493: goto +140 -> 633
    //   496: astore 8
    //   498: aload_2
    //   499: astore 5
    //   501: goto +21 -> 522
    //   504: astore 5
    //   506: aconst_null
    //   507: astore_2
    //   508: aload_2
    //   509: astore 7
    //   511: aload 4
    //   513: astore_3
    //   514: goto +119 -> 633
    //   517: astore 8
    //   519: aconst_null
    //   520: astore 5
    //   522: aconst_null
    //   523: astore_3
    //   524: aconst_null
    //   525: astore_2
    //   526: aload 5
    //   528: astore 4
    //   530: aload_3
    //   531: astore 6
    //   533: aload_2
    //   534: astore 7
    //   536: aload 8
    //   538: invokevirtual 588	java/lang/Exception:printStackTrace	()V
    //   541: aload_3
    //   542: ifnull +7 -> 549
    //   545: aload_3
    //   546: invokevirtual 583	java/io/FileInputStream:close	()V
    //   549: aload_2
    //   550: ifnull +7 -> 557
    //   553: aload_2
    //   554: invokevirtual 584	java/io/ByteArrayOutputStream:close	()V
    //   557: aload 10
    //   559: astore_2
    //   560: aload 5
    //   562: ifnull +12 -> 574
    //   565: aload 5
    //   567: invokevirtual 587	java/io/File:delete	()Z
    //   570: pop
    //   571: aload 10
    //   573: astore_2
    //   574: new 65	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   581: astore_3
    //   582: aload_3
    //   583: aload 12
    //   585: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload_3
    //   590: ldc_w 590
    //   593: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload_3
    //   598: aload 11
    //   600: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload_3
    //   605: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: aload 13
    //   610: aload_2
    //   611: new 592	com/tencent/smtt/sdk/ax
    //   614: dup
    //   615: aload_0
    //   616: invokespecial 593	com/tencent/smtt/sdk/ax:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   619: iconst_0
    //   620: invokestatic 596	com/tencent/smtt/utils/n:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/n$a;Z)Ljava/lang/String;
    //   623: pop
    //   624: return
    //   625: astore 5
    //   627: aload 6
    //   629: astore_3
    //   630: aload 4
    //   632: astore_2
    //   633: aload_3
    //   634: ifnull +7 -> 641
    //   637: aload_3
    //   638: invokevirtual 583	java/io/FileInputStream:close	()V
    //   641: aload 7
    //   643: ifnull +8 -> 651
    //   646: aload 7
    //   648: invokevirtual 584	java/io/ByteArrayOutputStream:close	()V
    //   651: aload_2
    //   652: ifnull +8 -> 660
    //   655: aload_2
    //   656: invokevirtual 587	java/io/File:delete	()Z
    //   659: pop
    //   660: aload 5
    //   662: athrow
    //   663: astore_2
    //   664: goto -532 -> 132
    //   667: astore 4
    //   669: goto -534 -> 135
    //   672: astore_3
    //   673: goto -237 -> 436
    //   676: astore_3
    //   677: goto -236 -> 441
    //   680: astore_3
    //   681: goto -132 -> 549
    //   684: astore_2
    //   685: goto -128 -> 557
    //   688: astore_3
    //   689: goto -48 -> 641
    //   692: astore_3
    //   693: goto -42 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	this	TbsLogReport
    //   366	22	1	i	int
    //   96	560	2	localObject1	Object
    //   663	1	2	localException1	Exception
    //   684	1	2	localException2	Exception
    //   88	550	3	localObject2	Object
    //   672	1	3	localException3	Exception
    //   676	1	3	localException4	Exception
    //   680	1	3	localException5	Exception
    //   688	1	3	localException6	Exception
    //   692	1	3	localException7	Exception
    //   101	530	4	localObject3	Object
    //   667	1	4	localException8	Exception
    //   65	391	5	localObject4	Object
    //   463	1	5	localObject5	Object
    //   477	1	5	localObject6	Object
    //   485	1	5	localObject7	Object
    //   499	1	5	localObject8	Object
    //   504	1	5	localObject9	Object
    //   520	46	5	localObject10	Object
    //   625	36	5	localObject11	Object
    //   354	274	6	localObject12	Object
    //   358	289	7	localObject13	Object
    //   452	1	8	localException9	Exception
    //   471	1	8	localException10	Exception
    //   496	1	8	localException11	Exception
    //   517	20	8	localException12	Exception
    //   348	110	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   258	314	10	localObject14	Object
    //   79	520	11	str1	String
    //   198	386	12	str2	String
    //   207	402	13	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   360	367	452	java/lang/Exception
    //   382	391	452	java/lang/Exception
    //   404	409	452	java/lang/Exception
    //   419	432	452	java/lang/Exception
    //   334	350	463	finally
    //   334	350	471	java/lang/Exception
    //   325	334	485	finally
    //   325	334	496	java/lang/Exception
    //   260	325	504	finally
    //   260	325	517	java/lang/Exception
    //   360	367	625	finally
    //   382	391	625	finally
    //   404	409	625	finally
    //   419	432	625	finally
    //   536	541	625	finally
    //   108	117	663	java/lang/Exception
    //   117	126	667	java/lang/Exception
    //   432	436	672	java/lang/Exception
    //   436	441	676	java/lang/Exception
    //   545	549	680	java/lang/Exception
    //   553	557	684	java/lang/Exception
    //   637	641	688	java/lang/Exception
    //   646	651	692	java/lang/Exception
  }
  
  public void d()
  {
    try
    {
      SharedPreferences.Editor localEditor = i().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public static enum EventType
  {
    int a;
    
    static
    {
      TYPE_DOWNLOAD_DECOUPLE = new EventType("TYPE_DOWNLOAD_DECOUPLE", 3, 3);
      TYPE_INSTALL_DECOUPLE = new EventType("TYPE_INSTALL_DECOUPLE", 4, 4);
    }
    
    private EventType(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static class TbsLogInfo
    implements Cloneable
  {
    int a;
    private long b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private String i;
    private int j;
    private int k;
    private long l;
    private long m;
    private int n;
    private String o;
    private String p;
    private long q;
    
    private TbsLogInfo()
    {
      resetArgs();
    }
    
    protected Object clone()
    {
      try
      {
        Object localObject = super.clone();
        return localObject;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return this;
    }
    
    public int getDownFinalFlag()
    {
      return this.k;
    }
    
    public void resetArgs()
    {
      this.b = 0L;
      this.c = null;
      this.d = null;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 2;
      this.i = "unknown";
      this.j = 0;
      this.k = 2;
      this.l = 0L;
      this.m = 0L;
      this.n = 1;
      this.a = 0;
      this.o = null;
      this.p = null;
      this.q = 0L;
    }
    
    public void setApn(String paramString)
    {
      this.i = paramString;
    }
    
    public void setCheckErrorDetail(String paramString)
    {
      setErrorCode(108);
      this.o = paramString;
    }
    
    public void setDownConsumeTime(long paramLong)
    {
      this.m += paramLong;
    }
    
    public void setDownFinalFlag(int paramInt)
    {
      this.k = paramInt;
    }
    
    public void setDownloadCancel(int paramInt)
    {
      this.g = paramInt;
    }
    
    public void setDownloadSize(long paramLong)
    {
      this.q += paramLong;
    }
    
    public void setDownloadUrl(String paramString)
    {
      if (this.c == null) {}
      for (;;)
      {
        this.c = paramString;
        return;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.c);
        localStringBuilder.append(";");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
    }
    
    public void setErrorCode(int paramInt)
    {
      if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error occured, errorCode:");
        localStringBuilder.append(paramInt);
        TbsLog.i("TbsDownload", localStringBuilder.toString(), true);
      }
      if (paramInt == 111) {
        TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
      }
      this.a = paramInt;
    }
    
    public void setEventTime(long paramLong)
    {
      this.b = paramLong;
    }
    
    public void setFailDetail(String paramString)
    {
      if (paramString == null) {
        return;
      }
      String str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
      this.p = str;
    }
    
    public void setFailDetail(Throwable paramThrowable)
    {
      if (paramThrowable == null)
      {
        this.p = "";
        return;
      }
      String str = Log.getStackTraceString(paramThrowable);
      paramThrowable = str;
      if (str.length() > 1024) {
        paramThrowable = str.substring(0, 1024);
      }
      this.p = paramThrowable;
    }
    
    public void setHttpCode(int paramInt)
    {
      this.e = paramInt;
    }
    
    public void setNetworkChange(int paramInt)
    {
      this.n = paramInt;
    }
    
    public void setNetworkType(int paramInt)
    {
      this.j = paramInt;
    }
    
    public void setPatchUpdateFlag(int paramInt)
    {
      this.f = paramInt;
    }
    
    public void setPkgSize(long paramLong)
    {
      this.l = paramLong;
    }
    
    public void setResolveIp(String paramString)
    {
      this.d = paramString;
    }
    
    public void setUnpkgFlag(int paramInt)
    {
      this.h = paramInt;
    }
  }
  
  private static class a
  {
    private final String a;
    private final String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    /* Error */
    private static void a(java.io.File paramFile)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore_3
      //   5: new 26	java/io/RandomAccessFile
      //   8: dup
      //   9: aload_0
      //   10: ldc 28
      //   12: invokespecial 31	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   15: astore_0
      //   16: ldc 33
      //   18: iconst_2
      //   19: invokestatic 39	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
      //   22: istore_1
      //   23: aload_0
      //   24: ldc2_w 40
      //   27: invokevirtual 45	java/io/RandomAccessFile:seek	(J)V
      //   30: aload_0
      //   31: invokevirtual 49	java/io/RandomAccessFile:read	()I
      //   34: istore_2
      //   35: iload_2
      //   36: iload_1
      //   37: iand
      //   38: ifle +23 -> 61
      //   41: aload_0
      //   42: ldc2_w 40
      //   45: invokevirtual 45	java/io/RandomAccessFile:seek	(J)V
      //   48: aload_0
      //   49: iload_1
      //   50: iconst_m1
      //   51: ixor
      //   52: sipush 255
      //   55: iand
      //   56: iload_2
      //   57: iand
      //   58: invokevirtual 53	java/io/RandomAccessFile:write	(I)V
      //   61: aload_0
      //   62: invokevirtual 56	java/io/RandomAccessFile:close	()V
      //   65: return
      //   66: astore_3
      //   67: goto +45 -> 112
      //   70: astore 4
      //   72: goto +18 -> 90
      //   75: astore 4
      //   77: aload_3
      //   78: astore_0
      //   79: aload 4
      //   81: astore_3
      //   82: goto +30 -> 112
      //   85: astore 4
      //   87: aload 5
      //   89: astore_0
      //   90: aload_0
      //   91: astore_3
      //   92: aload 4
      //   94: invokevirtual 59	java/lang/Exception:printStackTrace	()V
      //   97: aload_0
      //   98: ifnull +13 -> 111
      //   101: aload_0
      //   102: invokevirtual 56	java/io/RandomAccessFile:close	()V
      //   105: return
      //   106: astore_0
      //   107: aload_0
      //   108: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   111: return
      //   112: aload_0
      //   113: ifnull +15 -> 128
      //   116: aload_0
      //   117: invokevirtual 56	java/io/RandomAccessFile:close	()V
      //   120: goto +8 -> 128
      //   123: astore_0
      //   124: aload_0
      //   125: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   128: aload_3
      //   129: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	130	0	paramFile	java.io.File
      //   22	30	1	i	int
      //   34	24	2	j	int
      //   4	1	3	localObject1	Object
      //   66	12	3	localObject2	Object
      //   81	48	3	localObject3	Object
      //   70	1	4	localException1	Exception
      //   75	5	4	localObject4	Object
      //   85	8	4	localException2	Exception
      //   1	87	5	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   16	35	66	finally
      //   41	61	66	finally
      //   16	35	70	java/lang/Exception
      //   41	61	70	java/lang/Exception
      //   5	16	75	finally
      //   92	97	75	finally
      //   5	16	85	java/lang/Exception
      //   61	65	106	java/io/IOException
      //   101	105	106	java/io/IOException
      //   116	120	123	java/io/IOException
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: new 62	java/io/FileOutputStream
      //   3: dup
      //   4: aload_0
      //   5: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
      //   8: invokespecial 65	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   11: astore_3
      //   12: new 67	java/util/zip/ZipOutputStream
      //   15: dup
      //   16: new 69	java/io/BufferedOutputStream
      //   19: dup
      //   20: aload_3
      //   21: invokespecial 72	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   24: invokespecial 73	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   27: astore 7
      //   29: aload_3
      //   30: astore 4
      //   32: aload 7
      //   34: astore 5
      //   36: sipush 2048
      //   39: newarray <illegal type>
      //   41: astore 8
      //   43: aload_3
      //   44: astore 4
      //   46: aload 7
      //   48: astore 5
      //   50: aload_0
      //   51: getfield 16	com/tencent/smtt/sdk/TbsLogReport$a:a	Ljava/lang/String;
      //   54: astore 9
      //   56: new 75	java/io/FileInputStream
      //   59: dup
      //   60: aload 9
      //   62: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   65: astore_2
      //   66: new 78	java/io/BufferedInputStream
      //   69: dup
      //   70: aload_2
      //   71: sipush 2048
      //   74: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   77: astore 6
      //   79: aload_2
      //   80: astore 4
      //   82: aload 6
      //   84: astore 5
      //   86: aload 7
      //   88: new 83	java/util/zip/ZipEntry
      //   91: dup
      //   92: aload 9
      //   94: aload 9
      //   96: ldc 85
      //   98: invokevirtual 91	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   101: iconst_1
      //   102: iadd
      //   103: invokevirtual 95	java/lang/String:substring	(I)Ljava/lang/String;
      //   106: invokespecial 96	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   109: invokevirtual 100	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   112: aload_2
      //   113: astore 4
      //   115: aload 6
      //   117: astore 5
      //   119: aload 6
      //   121: aload 8
      //   123: iconst_0
      //   124: sipush 2048
      //   127: invokevirtual 103	java/io/BufferedInputStream:read	([BII)I
      //   130: istore_1
      //   131: iload_1
      //   132: iconst_m1
      //   133: if_icmpeq +22 -> 155
      //   136: aload_2
      //   137: astore 4
      //   139: aload 6
      //   141: astore 5
      //   143: aload 7
      //   145: aload 8
      //   147: iconst_0
      //   148: iload_1
      //   149: invokevirtual 106	java/util/zip/ZipOutputStream:write	([BII)V
      //   152: goto -40 -> 112
      //   155: aload_2
      //   156: astore 4
      //   158: aload 6
      //   160: astore 5
      //   162: aload 7
      //   164: invokevirtual 109	java/util/zip/ZipOutputStream:flush	()V
      //   167: aload_2
      //   168: astore 4
      //   170: aload 6
      //   172: astore 5
      //   174: aload 7
      //   176: invokevirtual 112	java/util/zip/ZipOutputStream:closeEntry	()V
      //   179: aload_3
      //   180: astore 4
      //   182: aload 7
      //   184: astore 5
      //   186: aload 6
      //   188: invokevirtual 113	java/io/BufferedInputStream:close	()V
      //   191: goto +17 -> 208
      //   194: astore 6
      //   196: aload_3
      //   197: astore 4
      //   199: aload 7
      //   201: astore 5
      //   203: aload 6
      //   205: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   208: aload_3
      //   209: astore 4
      //   211: aload 7
      //   213: astore 5
      //   215: aload_2
      //   216: invokevirtual 114	java/io/FileInputStream:close	()V
      //   219: goto +126 -> 345
      //   222: astore_2
      //   223: aload_3
      //   224: astore 4
      //   226: aload 7
      //   228: astore 5
      //   230: aload_2
      //   231: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   234: goto +111 -> 345
      //   237: astore 8
      //   239: goto +38 -> 277
      //   242: astore 4
      //   244: goto +12 -> 256
      //   247: astore 4
      //   249: goto +21 -> 270
      //   252: astore 4
      //   254: aconst_null
      //   255: astore_2
      //   256: aconst_null
      //   257: astore 8
      //   259: aload 4
      //   261: astore 6
      //   263: goto +130 -> 393
      //   266: astore 4
      //   268: aconst_null
      //   269: astore_2
      //   270: aconst_null
      //   271: astore 6
      //   273: aload 4
      //   275: astore 8
      //   277: aload_2
      //   278: astore 4
      //   280: aload 6
      //   282: astore 5
      //   284: aload 8
      //   286: invokevirtual 59	java/lang/Exception:printStackTrace	()V
      //   289: aload 6
      //   291: ifnull +32 -> 323
      //   294: aload_3
      //   295: astore 4
      //   297: aload 7
      //   299: astore 5
      //   301: aload 6
      //   303: invokevirtual 113	java/io/BufferedInputStream:close	()V
      //   306: goto +17 -> 323
      //   309: astore 6
      //   311: aload_3
      //   312: astore 4
      //   314: aload 7
      //   316: astore 5
      //   318: aload 6
      //   320: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   323: aload_2
      //   324: ifnull +21 -> 345
      //   327: aload_3
      //   328: astore 4
      //   330: aload 7
      //   332: astore 5
      //   334: aload_2
      //   335: invokevirtual 114	java/io/FileInputStream:close	()V
      //   338: goto +7 -> 345
      //   341: astore_2
      //   342: goto -119 -> 223
      //   345: aload_3
      //   346: astore 4
      //   348: aload 7
      //   350: astore 5
      //   352: new 116	java/io/File
      //   355: dup
      //   356: aload_0
      //   357: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
      //   360: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
      //   363: invokestatic 119	com/tencent/smtt/sdk/TbsLogReport$a:a	(Ljava/io/File;)V
      //   366: aload 7
      //   368: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
      //   371: goto +8 -> 379
      //   374: astore_2
      //   375: aload_2
      //   376: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   379: aload_3
      //   380: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   383: return
      //   384: astore 6
      //   386: aload 5
      //   388: astore 8
      //   390: aload 4
      //   392: astore_2
      //   393: aload 8
      //   395: ifnull +32 -> 427
      //   398: aload_3
      //   399: astore 4
      //   401: aload 7
      //   403: astore 5
      //   405: aload 8
      //   407: invokevirtual 113	java/io/BufferedInputStream:close	()V
      //   410: goto +17 -> 427
      //   413: astore 8
      //   415: aload_3
      //   416: astore 4
      //   418: aload 7
      //   420: astore 5
      //   422: aload 8
      //   424: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   427: aload_2
      //   428: ifnull +29 -> 457
      //   431: aload_3
      //   432: astore 4
      //   434: aload 7
      //   436: astore 5
      //   438: aload_2
      //   439: invokevirtual 114	java/io/FileInputStream:close	()V
      //   442: goto +15 -> 457
      //   445: astore_2
      //   446: aload_3
      //   447: astore 4
      //   449: aload 7
      //   451: astore 5
      //   453: aload_2
      //   454: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   457: aload_3
      //   458: astore 4
      //   460: aload 7
      //   462: astore 5
      //   464: aload 6
      //   466: athrow
      //   467: astore 6
      //   469: aload 7
      //   471: astore_2
      //   472: goto +33 -> 505
      //   475: astore_2
      //   476: aconst_null
      //   477: astore 5
      //   479: goto +72 -> 551
      //   482: astore 6
      //   484: aconst_null
      //   485: astore_2
      //   486: goto +19 -> 505
      //   489: astore_2
      //   490: aconst_null
      //   491: astore 5
      //   493: aload 5
      //   495: astore_3
      //   496: goto +55 -> 551
      //   499: astore 6
      //   501: aconst_null
      //   502: astore_2
      //   503: aload_2
      //   504: astore_3
      //   505: aload_3
      //   506: astore 4
      //   508: aload_2
      //   509: astore 5
      //   511: aload 6
      //   513: invokevirtual 59	java/lang/Exception:printStackTrace	()V
      //   516: aload_2
      //   517: ifnull +15 -> 532
      //   520: aload_2
      //   521: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
      //   524: goto +8 -> 532
      //   527: astore_2
      //   528: aload_2
      //   529: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   532: aload_3
      //   533: ifnull +13 -> 546
      //   536: aload_3
      //   537: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   540: return
      //   541: astore_2
      //   542: aload_2
      //   543: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   546: return
      //   547: astore_2
      //   548: aload 4
      //   550: astore_3
      //   551: aload 5
      //   553: ifnull +18 -> 571
      //   556: aload 5
      //   558: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
      //   561: goto +10 -> 571
      //   564: astore 4
      //   566: aload 4
      //   568: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   571: aload_3
      //   572: ifnull +15 -> 587
      //   575: aload_3
      //   576: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   579: goto +8 -> 587
      //   582: astore_3
      //   583: aload_3
      //   584: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   587: aload_2
      //   588: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	589	0	this	a
      //   130	19	1	i	int
      //   65	151	2	localFileInputStream	java.io.FileInputStream
      //   222	9	2	localIOException1	java.io.IOException
      //   255	80	2	localObject1	Object
      //   341	1	2	localIOException2	java.io.IOException
      //   374	2	2	localIOException3	java.io.IOException
      //   392	47	2	localObject2	Object
      //   445	9	2	localIOException4	java.io.IOException
      //   471	1	2	localZipOutputStream1	java.util.zip.ZipOutputStream
      //   475	1	2	localObject3	Object
      //   485	1	2	localObject4	Object
      //   489	1	2	localObject5	Object
      //   502	19	2	localObject6	Object
      //   527	2	2	localIOException5	java.io.IOException
      //   541	2	2	localIOException6	java.io.IOException
      //   547	41	2	localObject7	Object
      //   11	565	3	localObject8	Object
      //   582	2	3	localIOException7	java.io.IOException
      //   30	195	4	localObject9	Object
      //   242	1	4	localObject10	Object
      //   247	1	4	localException1	Exception
      //   252	8	4	localObject11	Object
      //   266	8	4	localException2	Exception
      //   278	271	4	localObject12	Object
      //   564	3	4	localIOException8	java.io.IOException
      //   34	523	5	localObject13	Object
      //   77	110	6	localBufferedInputStream	java.io.BufferedInputStream
      //   194	10	6	localIOException9	java.io.IOException
      //   261	41	6	localObject14	Object
      //   309	10	6	localIOException10	java.io.IOException
      //   384	81	6	localObject15	Object
      //   467	1	6	localException3	Exception
      //   482	1	6	localException4	Exception
      //   499	13	6	localException5	Exception
      //   27	443	7	localZipOutputStream2	java.util.zip.ZipOutputStream
      //   41	105	8	arrayOfByte	byte[]
      //   237	1	8	localException6	Exception
      //   257	149	8	localObject16	Object
      //   413	10	8	localIOException11	java.io.IOException
      //   54	41	9	str	String
      // Exception table:
      //   from	to	target	type
      //   186	191	194	java/io/IOException
      //   215	219	222	java/io/IOException
      //   86	112	237	java/lang/Exception
      //   119	131	237	java/lang/Exception
      //   143	152	237	java/lang/Exception
      //   162	167	237	java/lang/Exception
      //   174	179	237	java/lang/Exception
      //   66	79	242	finally
      //   66	79	247	java/lang/Exception
      //   56	66	252	finally
      //   56	66	266	java/lang/Exception
      //   301	306	309	java/io/IOException
      //   334	338	341	java/io/IOException
      //   366	371	374	java/io/IOException
      //   86	112	384	finally
      //   119	131	384	finally
      //   143	152	384	finally
      //   162	167	384	finally
      //   174	179	384	finally
      //   284	289	384	finally
      //   405	410	413	java/io/IOException
      //   438	442	445	java/io/IOException
      //   36	43	467	java/lang/Exception
      //   50	56	467	java/lang/Exception
      //   186	191	467	java/lang/Exception
      //   203	208	467	java/lang/Exception
      //   215	219	467	java/lang/Exception
      //   230	234	467	java/lang/Exception
      //   301	306	467	java/lang/Exception
      //   318	323	467	java/lang/Exception
      //   334	338	467	java/lang/Exception
      //   352	366	467	java/lang/Exception
      //   405	410	467	java/lang/Exception
      //   422	427	467	java/lang/Exception
      //   438	442	467	java/lang/Exception
      //   453	457	467	java/lang/Exception
      //   464	467	467	java/lang/Exception
      //   12	29	475	finally
      //   12	29	482	java/lang/Exception
      //   0	12	489	finally
      //   0	12	499	java/lang/Exception
      //   520	524	527	java/io/IOException
      //   379	383	541	java/io/IOException
      //   536	540	541	java/io/IOException
      //   36	43	547	finally
      //   50	56	547	finally
      //   186	191	547	finally
      //   203	208	547	finally
      //   215	219	547	finally
      //   230	234	547	finally
      //   301	306	547	finally
      //   318	323	547	finally
      //   334	338	547	finally
      //   352	366	547	finally
      //   405	410	547	finally
      //   422	427	547	finally
      //   438	442	547	finally
      //   453	457	547	finally
      //   464	467	547	finally
      //   511	516	547	finally
      //   556	561	564	java/io/IOException
      //   575	579	582	java/io/IOException
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsLogReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */