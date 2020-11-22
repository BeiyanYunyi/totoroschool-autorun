package com.tencent.smtt.sdk.a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class d
{
  public static int a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    if (paramContext == null) {
      return 3;
    }
    Object localObject1 = paramString;
    if (!a(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("http://");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    try
    {
      Object localObject3 = Uri.parse((String)localObject1);
      if (localObject3 == null) {
        return 2;
      }
      localObject1 = a(paramContext);
      if (((a)localObject1).a == -1) {
        return 4;
      }
      if ((((a)localObject1).a == 2) && (((a)localObject1).b < 33)) {
        return 5;
      }
      Object localObject2 = new Intent("android.intent.action.VIEW");
      if (((a)localObject1).a == 2)
      {
        if ((((a)localObject1).b >= 33) && (((a)localObject1).b <= 39)) {
          paramString = "com.tencent.mtt";
        }
        for (localObject1 = "com.tencent.mtt.MainActivity";; localObject1 = "com.tencent.mtt.SplashActivity")
        {
          ((Intent)localObject2).setClassName(paramString, (String)localObject1);
          paramString = (String)localObject2;
          break label464;
          if ((((a)localObject1).b < 40) || (((a)localObject1).b > 45)) {
            break;
          }
          paramString = "com.tencent.mtt";
        }
        paramString = (String)localObject2;
        if (((a)localObject1).b >= 46)
        {
          localObject1 = new Intent("com.tencent.QQBrowser.action.VIEW");
          localObject2 = a(paramContext, (Uri)localObject3);
          paramString = (String)localObject1;
          if (localObject2 != null)
          {
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty(((b)localObject2).a))
            {
              paramString = (String)localObject1;
              localObject1 = localObject2;
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          paramString.setClassName(((b)localObject1).b, ((b)localObject1).a);
          break label464;
          if (((a)localObject1).a == 1)
          {
            if (((a)localObject1).b == 1)
            {
              paramString = "com.tencent.qbx5";
              localObject1 = "com.tencent.qbx5.MainActivity";
              break;
            }
            paramString = (String)localObject2;
            if (((a)localObject1).b != 2) {
              break label464;
            }
            paramString = "com.tencent.qbx5";
            localObject1 = "com.tencent.qbx5.SplashActivity";
            break;
          }
          if (((a)localObject1).a == 0)
          {
            if ((((a)localObject1).b >= 4) && (((a)localObject1).b <= 6))
            {
              paramString = "com.tencent.qbx";
              localObject1 = "com.tencent.qbx.SplashActivity";
              break;
            }
            paramString = (String)localObject2;
            if (((a)localObject1).b <= 6) {
              break label464;
            }
            localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
            localObject1 = a(paramContext, (Uri)localObject3);
            paramString = (String)localObject2;
            if (localObject1 == null) {
              break label464;
            }
            paramString = (String)localObject2;
            if (TextUtils.isEmpty(((b)localObject1).a)) {
              break label464;
            }
            paramString = (String)localObject2;
            continue;
          }
          localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
          localObject1 = a(paramContext, (Uri)localObject3);
          paramString = (String)localObject2;
          if (localObject1 == null) {
            break label464;
          }
          paramString = (String)localObject2;
          if (TextUtils.isEmpty(((b)localObject1).a)) {
            break label464;
          }
          paramString = (String)localObject2;
        }
      }
      label464:
      paramString.setData((Uri)localObject3);
      if (paramHashMap != null)
      {
        localObject1 = paramHashMap.keySet();
        if (localObject1 != null)
        {
          localObject1 = ((Set)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            localObject3 = (String)paramHashMap.get(localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              paramString.putExtra((String)localObject2, (String)localObject3);
            }
          }
        }
      }
      return 4;
    }
    catch (Exception paramContext)
    {
      try
      {
        paramString.putExtra("loginType", d(paramContext));
        paramString.addFlags(268435456);
        if (paramWebView != null)
        {
          paramString.putExtra("AnchorPoint", new Point(paramWebView.getScrollX(), paramWebView.getScrollY()));
          paramString.putExtra("ContentSize", new Point(paramWebView.getContentWidth(), paramWebView.getContentHeight()));
        }
        paramContext.startActivity(paramString);
        return 0;
      }
      catch (ActivityNotFoundException paramContext) {}
      paramContext = paramContext;
      return 2;
    }
  }
  
  public static int a(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2, WebView paramWebView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    j = 0;
    try
    {
      localObject = paramContext.getPackageManager();
      if (localObject != null)
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.mtt", 0);
        if (localObject != null)
        {
          i = ((PackageInfo)localObject).versionCode;
          if (i > 601000) {
            i = 1;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      for (;;) {}
    }
    i = 0;
    try
    {
      localObject = URLEncoder.encode(paramString1, "UTF-8");
      if (i != 0) {
        paramString1 = (String)localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i != 0) {
      localObject = ",encoded=1";
    } else {
      localObject = "";
    }
    localStringBuilder.append("mttbrowser://url=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",product=");
    localStringBuilder.append("TBS");
    localStringBuilder.append(",packagename=");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append(",from=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",version=");
    localStringBuilder.append("3.6.0.1315");
    localStringBuilder.append((String)localObject);
    return a(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
  }
  
  /* Error */
  public static a a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 233	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: ldc -21
    //   6: iconst_0
    //   7: invokevirtual 239	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: ldc -15
    //   12: iconst_0
    //   13: invokeinterface 247 3 0
    //   18: istore_1
    //   19: new 6	com/tencent/smtt/sdk/a/d$a
    //   22: dup
    //   23: invokespecial 248	com/tencent/smtt/sdk/a/d$a:<init>	()V
    //   26: astore 4
    //   28: iload_1
    //   29: ifeq +6 -> 35
    //   32: aload 4
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 183	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   39: astore 5
    //   41: aload 5
    //   43: ldc 57
    //   45: iconst_0
    //   46: invokevirtual 189	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   49: astore_3
    //   50: aload 4
    //   52: iconst_2
    //   53: putfield 46	com/tencent/smtt/sdk/a/d$a:a	I
    //   56: aload 4
    //   58: ldc 57
    //   60: putfield 251	com/tencent/smtt/sdk/a/d$a:e	Ljava/lang/String;
    //   63: aload 4
    //   65: ldc -3
    //   67: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: ifnull +90 -> 163
    //   76: aload_3
    //   77: astore_2
    //   78: aload_3
    //   79: getfield 194	android/content/pm/PackageInfo:versionCode	I
    //   82: ldc_w 257
    //   85: if_icmple +78 -> 163
    //   88: aload 4
    //   90: aload_3
    //   91: getfield 194	android/content/pm/PackageInfo:versionCode	I
    //   94: putfield 48	com/tencent/smtt/sdk/a/d$a:b	I
    //   97: new 20	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: aload 4
    //   108: getfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   111: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: aload_3
    //   117: getfield 260	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   120: ldc_w 262
    //   123: ldc -49
    //   125: invokevirtual 265	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload_2
    //   135: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   141: aload 4
    //   143: aload_3
    //   144: getfield 260	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   147: ldc_w 262
    //   150: ldc -49
    //   152: invokevirtual 265	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 267	com/tencent/smtt/sdk/a/d$a:d	Ljava/lang/String;
    //   158: aload 4
    //   160: areturn
    //   161: aconst_null
    //   162: astore_2
    //   163: aload 5
    //   165: ldc 89
    //   167: iconst_0
    //   168: invokevirtual 189	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   171: astore_3
    //   172: aload 4
    //   174: iconst_0
    //   175: putfield 46	com/tencent/smtt/sdk/a/d$a:a	I
    //   178: aload 4
    //   180: ldc 89
    //   182: putfield 251	com/tencent/smtt/sdk/a/d$a:e	Ljava/lang/String;
    //   185: aload 4
    //   187: ldc_w 269
    //   190: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   193: aload_3
    //   194: astore_0
    //   195: goto +170 -> 365
    //   198: aload 5
    //   200: ldc 83
    //   202: iconst_0
    //   203: invokevirtual 189	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   206: astore_3
    //   207: aload 4
    //   209: iconst_1
    //   210: putfield 46	com/tencent/smtt/sdk/a/d$a:a	I
    //   213: aload 4
    //   215: ldc 83
    //   217: putfield 251	com/tencent/smtt/sdk/a/d$a:e	Ljava/lang/String;
    //   220: aload 4
    //   222: ldc_w 271
    //   225: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   228: aload_3
    //   229: astore_0
    //   230: goto +135 -> 365
    //   233: aload 5
    //   235: ldc 57
    //   237: iconst_0
    //   238: invokevirtual 189	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   241: astore_3
    //   242: aload 4
    //   244: ldc 57
    //   246: putfield 251	com/tencent/smtt/sdk/a/d$a:e	Ljava/lang/String;
    //   249: aload 4
    //   251: iconst_2
    //   252: putfield 46	com/tencent/smtt/sdk/a/d$a:a	I
    //   255: aload 4
    //   257: ldc -3
    //   259: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   262: aload_3
    //   263: astore_0
    //   264: goto +101 -> 365
    //   267: aload 5
    //   269: ldc_w 273
    //   272: iconst_0
    //   273: invokevirtual 189	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   276: astore_3
    //   277: aload 4
    //   279: ldc_w 273
    //   282: putfield 251	com/tencent/smtt/sdk/a/d$a:e	Ljava/lang/String;
    //   285: aload 4
    //   287: iconst_2
    //   288: putfield 46	com/tencent/smtt/sdk/a/d$a:a	I
    //   291: aload 4
    //   293: ldc -3
    //   295: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   298: aload_3
    //   299: astore_0
    //   300: goto -70 -> 230
    //   303: aload_0
    //   304: ldc_w 275
    //   307: invokestatic 40	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   310: invokestatic 70	com/tencent/smtt/sdk/a/d:a	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/smtt/sdk/a/d$b;
    //   313: astore_3
    //   314: aload_2
    //   315: astore_0
    //   316: aload_3
    //   317: ifnull -87 -> 230
    //   320: aload_2
    //   321: astore_0
    //   322: aload_3
    //   323: getfield 81	com/tencent/smtt/sdk/a/d$b:b	Ljava/lang/String;
    //   326: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   329: ifne -99 -> 230
    //   332: aload 5
    //   334: aload_3
    //   335: getfield 81	com/tencent/smtt/sdk/a/d$b:b	Ljava/lang/String;
    //   338: iconst_0
    //   339: invokevirtual 189	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   342: astore_0
    //   343: aload 4
    //   345: aload_3
    //   346: getfield 81	com/tencent/smtt/sdk/a/d$b:b	Ljava/lang/String;
    //   349: putfield 251	com/tencent/smtt/sdk/a/d$a:e	Ljava/lang/String;
    //   352: aload 4
    //   354: iconst_2
    //   355: putfield 46	com/tencent/smtt/sdk/a/d$a:a	I
    //   358: aload 4
    //   360: ldc -3
    //   362: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   365: aload_0
    //   366: ifnull +73 -> 439
    //   369: aload 4
    //   371: aload_0
    //   372: getfield 194	android/content/pm/PackageInfo:versionCode	I
    //   375: putfield 48	com/tencent/smtt/sdk/a/d$a:b	I
    //   378: new 20	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   385: astore_2
    //   386: aload_2
    //   387: aload 4
    //   389: getfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   392: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: aload_0
    //   398: getfield 260	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   401: ldc_w 262
    //   404: ldc -49
    //   406: invokevirtual 265	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   409: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 4
    //   415: aload_2
    //   416: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: putfield 256	com/tencent/smtt/sdk/a/d$a:c	Ljava/lang/String;
    //   422: aload 4
    //   424: aload_0
    //   425: getfield 260	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   428: ldc_w 262
    //   431: ldc -49
    //   433: invokevirtual 265	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   436: putfield 267	com/tencent/smtt/sdk/a/d$a:d	Ljava/lang/String;
    //   439: aload 4
    //   441: areturn
    //   442: astore_0
    //   443: aload 4
    //   445: areturn
    //   446: astore_2
    //   447: goto -286 -> 161
    //   450: astore_2
    //   451: aload_3
    //   452: astore_2
    //   453: goto -290 -> 163
    //   456: astore_3
    //   457: goto -259 -> 198
    //   460: astore_2
    //   461: aload_3
    //   462: astore_2
    //   463: goto -265 -> 198
    //   466: astore_3
    //   467: goto -234 -> 233
    //   470: astore_2
    //   471: aload_3
    //   472: astore_2
    //   473: goto -240 -> 233
    //   476: astore_3
    //   477: goto -210 -> 267
    //   480: astore_2
    //   481: aload_3
    //   482: astore_2
    //   483: goto -216 -> 267
    //   486: astore_3
    //   487: goto -184 -> 303
    //   490: astore_2
    //   491: aload_3
    //   492: astore_2
    //   493: goto -190 -> 303
    //   496: astore_0
    //   497: aload_2
    //   498: astore_0
    //   499: goto -269 -> 230
    //   502: astore_2
    //   503: goto -138 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramContext	Context
    //   18	11	1	bool	boolean
    //   71	345	2	localObject1	Object
    //   446	1	2	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   450	1	2	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   452	1	2	localObject2	Object
    //   460	1	2	localNameNotFoundException3	android.content.pm.PackageManager.NameNotFoundException
    //   462	1	2	localNameNotFoundException4	android.content.pm.PackageManager.NameNotFoundException
    //   470	1	2	localNameNotFoundException5	android.content.pm.PackageManager.NameNotFoundException
    //   472	1	2	localNameNotFoundException6	android.content.pm.PackageManager.NameNotFoundException
    //   480	1	2	localNameNotFoundException7	android.content.pm.PackageManager.NameNotFoundException
    //   482	1	2	localNameNotFoundException8	android.content.pm.PackageManager.NameNotFoundException
    //   490	1	2	localException1	Exception
    //   492	6	2	localException2	Exception
    //   502	1	2	localException3	Exception
    //   49	403	3	localObject3	Object
    //   456	6	3	localNameNotFoundException9	android.content.pm.PackageManager.NameNotFoundException
    //   466	6	3	localNameNotFoundException10	android.content.pm.PackageManager.NameNotFoundException
    //   476	6	3	localNameNotFoundException11	android.content.pm.PackageManager.NameNotFoundException
    //   486	6	3	localException4	Exception
    //   26	418	4	locala	a
    //   39	294	5	localPackageManager	PackageManager
    // Exception table:
    //   from	to	target	type
    //   35	41	442	java/lang/Exception
    //   41	50	442	java/lang/Exception
    //   50	70	442	java/lang/Exception
    //   78	158	442	java/lang/Exception
    //   163	172	442	java/lang/Exception
    //   172	193	442	java/lang/Exception
    //   198	207	442	java/lang/Exception
    //   207	228	442	java/lang/Exception
    //   233	242	442	java/lang/Exception
    //   242	262	442	java/lang/Exception
    //   369	439	442	java/lang/Exception
    //   41	50	446	android/content/pm/PackageManager$NameNotFoundException
    //   50	70	450	android/content/pm/PackageManager$NameNotFoundException
    //   78	158	450	android/content/pm/PackageManager$NameNotFoundException
    //   163	172	456	android/content/pm/PackageManager$NameNotFoundException
    //   172	193	460	android/content/pm/PackageManager$NameNotFoundException
    //   198	207	466	android/content/pm/PackageManager$NameNotFoundException
    //   207	228	470	android/content/pm/PackageManager$NameNotFoundException
    //   233	242	476	android/content/pm/PackageManager$NameNotFoundException
    //   242	262	480	android/content/pm/PackageManager$NameNotFoundException
    //   267	277	486	java/lang/Exception
    //   277	298	490	java/lang/Exception
    //   303	314	496	java/lang/Exception
    //   322	343	496	java/lang/Exception
    //   343	365	502	java/lang/Exception
  }
  
  private static b a(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0) {
      return null;
    }
    paramContext = new b(null);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    return paramContext;
  }
  
  public static boolean a(Context paramContext, long paramLong1, long paramLong2)
  {
    paramContext = a(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.d).longValue();
      if (l >= paramLong1) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    if (paramContext.b >= paramLong2) {
      return true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        if (paramHashMap != null)
        {
          localObject = paramHashMap.keySet();
          if (localObject != null)
          {
            localObject = ((Set)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              String str1 = (String)((Iterator)localObject).next();
              String str2 = (String)paramHashMap.get(str1);
              if (TextUtils.isEmpty(str2)) {
                continue;
              }
              localIntent.putExtra(str1, str2);
              continue;
            }
          }
        }
        Object localObject = new File(paramString1);
        localIntent.putExtra("key_reader_sdk_id", 3);
        localIntent.putExtra("key_reader_sdk_type", paramInt);
        if (paramInt == 0)
        {
          paramHashMap = "key_reader_sdk_path";
          localIntent.putExtra(paramHashMap, paramString1);
          localIntent.putExtra("key_reader_sdk_format", paramString2);
          paramString1 = Uri.fromFile((File)localObject);
          paramHashMap = new StringBuilder();
          paramHashMap.append("mtt/");
          paramHashMap.append(paramString2);
          localIntent.setDataAndType(paramString1, paramHashMap.toString());
          localIntent.putExtra("loginType", d(paramContext.getApplicationContext()));
          if (paramBundle != null) {
            localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
          }
          paramContext.startActivity(localIntent);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      if (paramInt == 1) {
        paramHashMap = "key_reader_sdk_url";
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = Uri.parse(paramString);
    paramString = new Intent("android.intent.action.VIEW");
    paramString.setFlags(268435456);
    paramString.setDataAndType((Uri)localObject, "video/*");
    if (paramHashMap != null)
    {
      localObject = paramHashMap.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramHashMap.get(str1);
          if (!TextUtils.isEmpty(str2)) {
            paramString.putExtra(str1, str2);
          }
        }
      }
    }
    try
    {
      paramString.putExtra("loginType", d(paramContext));
      paramString.setComponent(new ComponentName("com.tencent.mtt", "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
      paramContext.startActivity(paramString);
      i = 1;
    }
    catch (Throwable paramHashMap)
    {
      int i;
      for (;;) {}
    }
    i = 0;
    if (i == 0) {
      try
      {
        paramString.setComponent(null);
        paramContext.startActivity(paramString);
        return true;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = paramString.trim();
      int i = paramString.toLowerCase().indexOf("://");
      int j = paramString.toLowerCase().indexOf('.');
      if ((i > 0) && (j > 0) && (i > j)) {
        return false;
      }
      return paramString.toLowerCase().contains("://");
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext).a != -1;
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.d).longValue();
      if (l >= 6001500L) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    if (paramContext.b >= 601500) {
      return true;
    }
    return bool;
  }
  
  private static int d(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      return 13;
    }
    if (paramContext.equals("com.qzone")) {
      return 14;
    }
    if (paramContext.equals("com.tencent.WBlog")) {
      return 15;
    }
    if (paramContext.equals("com.tencent.mm")) {
      return 24;
    }
    return 26;
  }
  
  public static class a
  {
    public int a = -1;
    public int b = -1;
    public String c = "";
    public String d = "0";
    public String e = null;
  }
  
  private static class b
  {
    public String a = "";
    public String b = "";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */