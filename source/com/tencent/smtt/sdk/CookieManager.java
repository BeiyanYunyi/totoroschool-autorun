package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CookieManager
{
  public static String LOGTAG = "CookieManager";
  private static CookieManager d;
  ArrayList<b> a;
  String b;
  a c = a.a;
  private boolean e = false;
  private boolean f = false;
  
  public static CookieManager getInstance()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new CookieManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static int getROMCookieDBVersion(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      paramContext = paramContext.getSharedPreferences("cookiedb_info", i);
      break;
    }
    return paramContext.getInt("db_version", -1);
  }
  
  public static void setROMCookieDBVersion(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      paramContext = paramContext.getSharedPreferences("cookiedb_info", i);
      break;
    }
    paramContext = paramContext.edit();
    paramContext.putInt("db_version", paramInt);
    paramContext.commit();
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        this.f = true;
        Object localObject1;
        Object localObject3;
        if ((this.a != null) && (this.a.size() != 0))
        {
          localObject1 = bt.a();
          if ((localObject1 != null) && (((bt)localObject1).b()))
          {
            localObject1 = this.a.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject3 = (b)((Iterator)localObject1).next();
          }
        }
        switch (((b)localObject3).a)
        {
        case 2: 
          setCookie(((b)localObject3).b, ((b)localObject3).c);
          break;
        case 1: 
          setCookie(((b)localObject3).b, ((b)localObject3).c, ((b)localObject3).d);
          continue;
          localObject1 = this.a.iterator();
          Object localObject4;
          if (((Iterator)localObject1).hasNext()) {
            localObject4 = (b)((Iterator)localObject1).next();
          }
          switch (((b)localObject4).a)
          {
          case 2: 
            android.webkit.CookieManager.getInstance().setCookie(((b)localObject4).b, ((b)localObject4).c);
            break;
          case 1: 
            if (Build.VERSION.SDK_INT < 21) {
              continue;
            }
            localObject3 = android.webkit.CookieManager.getInstance();
            String str1 = ((b)localObject4).b;
            String str2 = ((b)localObject4).c;
            localObject4 = ((b)localObject4).d;
            r.a(localObject3, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { str1, str2, localObject4 });
            continue;
            this.a.clear();
            return;
            return;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/smtt/sdk/CookieManager:c	Lcom/tencent/smtt/sdk/CookieManager$a;
    //   6: getstatic 31	com/tencent/smtt/sdk/CookieManager$a:a	Lcom/tencent/smtt/sdk/CookieManager$a;
    //   9: if_acmpeq +572 -> 581
    //   12: aload_1
    //   13: ifnull +568 -> 581
    //   16: invokestatic 155	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   19: aload_1
    //   20: ldc -99
    //   22: invokevirtual 161	com/tencent/smtt/sdk/TbsExtensionFunctionManager:canUseFunction	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifeq +556 -> 581
    //   28: aload_0
    //   29: getfield 35	com/tencent/smtt/sdk/CookieManager:e	Z
    //   32: ifeq +6 -> 38
    //   35: goto +546 -> 581
    //   38: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   41: lstore 12
    //   43: lconst_0
    //   44: lstore 10
    //   46: getstatic 169	com/tencent/smtt/sdk/CookieManager:LOGTAG	Ljava/lang/String;
    //   49: astore 14
    //   51: new 171	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   58: astore 15
    //   60: aload 15
    //   62: ldc -82
    //   64: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 15
    //   70: iload_2
    //   71: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 15
    //   77: ldc -73
    //   79: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 15
    //   85: iload_3
    //   86: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 14
    //   92: aload 15
    //   94: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: iload_2
    //   101: ifne +28 -> 129
    //   104: invokestatic 197	com/tencent/smtt/sdk/QbSdk:getIsSysWebViewForcedByOuter	()Z
    //   107: ifne +22 -> 129
    //   110: getstatic 199	com/tencent/smtt/sdk/QbSdk:a	Z
    //   113: ifeq +6 -> 119
    //   116: goto +13 -> 129
    //   119: invokestatic 95	com/tencent/smtt/sdk/bt:a	()Lcom/tencent/smtt/sdk/bt;
    //   122: aload_1
    //   123: invokevirtual 202	com/tencent/smtt/sdk/bt:a	(Landroid/content/Context;)V
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: invokestatic 197	com/tencent/smtt/sdk/QbSdk:getIsSysWebViewForcedByOuter	()Z
    //   132: istore 8
    //   134: iconst_0
    //   135: istore_2
    //   136: iload 8
    //   138: ifne +460 -> 598
    //   141: getstatic 199	com/tencent/smtt/sdk/QbSdk:a	Z
    //   144: ifeq +6 -> 150
    //   147: goto +451 -> 598
    //   150: invokestatic 155	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   153: aload_1
    //   154: ldc -52
    //   156: invokevirtual 161	com/tencent/smtt/sdk/TbsExtensionFunctionManager:canUseFunction	(Landroid/content/Context;Ljava/lang/String;)Z
    //   159: istore 8
    //   161: getstatic 169	com/tencent/smtt/sdk/CookieManager:LOGTAG	Ljava/lang/String;
    //   164: astore 14
    //   166: new 171	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   173: astore 15
    //   175: aload 15
    //   177: ldc -50
    //   179: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 15
    //   185: iload 8
    //   187: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 15
    //   193: ldc -73
    //   195: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 15
    //   201: iload_3
    //   202: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 14
    //   208: aload 15
    //   210: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: invokestatic 155	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   219: aload_1
    //   220: ldc -52
    //   222: iload_3
    //   223: invokevirtual 210	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   226: pop
    //   227: iload 8
    //   229: iload_3
    //   230: if_icmpne +6 -> 236
    //   233: aload_0
    //   234: monitorexit
    //   235: return
    //   236: aload_1
    //   237: invokestatic 215	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   240: invokevirtual 218	com/tencent/smtt/sdk/TbsLogReport:a	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   243: astore 14
    //   245: aload_0
    //   246: getfield 219	com/tencent/smtt/sdk/CookieManager:b	Ljava/lang/String;
    //   249: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifne +213 -> 465
    //   255: invokestatic 230	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   258: aload_1
    //   259: invokevirtual 233	com/tencent/smtt/sdk/am:n	(Landroid/content/Context;)I
    //   262: ifle +22 -> 284
    //   265: invokestatic 230	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   268: aload_1
    //   269: invokevirtual 233	com/tencent/smtt/sdk/am:n	(Landroid/content/Context;)I
    //   272: istore 4
    //   274: iload 4
    //   276: ldc -22
    //   278: if_icmpge +6 -> 284
    //   281: aload_0
    //   282: monitorexit
    //   283: return
    //   284: iload 8
    //   286: ifeq +50 -> 336
    //   289: aload_1
    //   290: invokestatic 238	com/tencent/smtt/sdk/x:d	(Landroid/content/Context;)I
    //   293: istore 6
    //   295: iload 6
    //   297: istore 5
    //   299: iload 6
    //   301: ifle +302 -> 603
    //   304: aload_1
    //   305: invokestatic 240	com/tencent/smtt/sdk/CookieManager:getROMCookieDBVersion	(Landroid/content/Context;)I
    //   308: istore 7
    //   310: iload 6
    //   312: istore 5
    //   314: iload 7
    //   316: istore 4
    //   318: iload 7
    //   320: ifgt +69 -> 389
    //   323: iconst_1
    //   324: istore_2
    //   325: iload 6
    //   327: istore 5
    //   329: iload 7
    //   331: istore 4
    //   333: goto +56 -> 389
    //   336: aload_1
    //   337: invokestatic 238	com/tencent/smtt/sdk/x:d	(Landroid/content/Context;)I
    //   340: istore 6
    //   342: iload 6
    //   344: istore 5
    //   346: iload 6
    //   348: ifle +255 -> 603
    //   351: invokestatic 230	com/tencent/smtt/sdk/am:a	()Lcom/tencent/smtt/sdk/am;
    //   354: aload_1
    //   355: ldc -14
    //   357: invokevirtual 245	com/tencent/smtt/sdk/am:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   360: astore 15
    //   362: aload 15
    //   364: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   367: istore 9
    //   369: iload 6
    //   371: istore 5
    //   373: iload 9
    //   375: ifne +228 -> 603
    //   378: aload 15
    //   380: invokestatic 251	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   383: istore 4
    //   385: iload 6
    //   387: istore 5
    //   389: iload_2
    //   390: ifne +24 -> 414
    //   393: iload 5
    //   395: ifle +8 -> 403
    //   398: iload 4
    //   400: ifgt +14 -> 414
    //   403: aload 14
    //   405: sipush 702
    //   408: invokevirtual 257	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   411: goto +68 -> 479
    //   414: iload 4
    //   416: iload 5
    //   418: if_icmplt +14 -> 432
    //   421: aload 14
    //   423: sipush 703
    //   426: invokevirtual 257	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   429: goto +50 -> 479
    //   432: aload_1
    //   433: aload_0
    //   434: getfield 33	com/tencent/smtt/sdk/CookieManager:c	Lcom/tencent/smtt/sdk/CookieManager$a;
    //   437: aload_0
    //   438: getfield 219	com/tencent/smtt/sdk/CookieManager:b	Ljava/lang/String;
    //   441: iload_2
    //   442: iload_3
    //   443: invokestatic 260	com/tencent/smtt/sdk/x:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/CookieManager$a;Ljava/lang/String;ZZ)V
    //   446: aload 14
    //   448: sipush 704
    //   451: invokevirtual 257	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   454: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   457: lload 12
    //   459: lsub
    //   460: lstore 10
    //   462: goto +17 -> 479
    //   465: aload 14
    //   467: sipush 701
    //   470: invokevirtual 257	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   473: iconst_0
    //   474: istore 5
    //   476: iconst_0
    //   477: istore 4
    //   479: new 171	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   486: astore 15
    //   488: aload 15
    //   490: ldc_w 262
    //   493: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 15
    //   499: iload 8
    //   501: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 15
    //   507: ldc_w 264
    //   510: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 15
    //   516: iload 5
    //   518: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload 15
    //   524: ldc_w 269
    //   527: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 15
    //   533: iload 4
    //   535: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 15
    //   541: ldc_w 271
    //   544: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 15
    //   550: lload 10
    //   552: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 14
    //   558: aload 15
    //   560: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokevirtual 278	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   566: aload_1
    //   567: invokestatic 215	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   570: getstatic 284	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_COOKIE_DB_SWITCH	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   573: aload 14
    //   575: invokevirtual 287	com/tencent/smtt/sdk/TbsLogReport:a	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   578: aload_0
    //   579: monitorexit
    //   580: return
    //   581: aload_0
    //   582: monitorexit
    //   583: return
    //   584: astore_1
    //   585: aload_0
    //   586: monitorexit
    //   587: aload_1
    //   588: athrow
    //   589: astore 15
    //   591: iload 6
    //   593: istore 5
    //   595: goto +8 -> 603
    //   598: iconst_0
    //   599: istore_3
    //   600: goto -450 -> 150
    //   603: iconst_0
    //   604: istore 4
    //   606: goto -217 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	CookieManager
    //   0	609	1	paramContext	Context
    //   0	609	2	paramBoolean1	boolean
    //   0	609	3	paramBoolean2	boolean
    //   272	333	4	i	int
    //   297	297	5	j	int
    //   293	299	6	k	int
    //   308	22	7	m	int
    //   132	368	8	bool1	boolean
    //   367	7	9	bool2	boolean
    //   44	507	10	l1	long
    //   41	417	12	l2	long
    //   49	525	14	localObject1	Object
    //   58	501	15	localObject2	Object
    //   589	1	15	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	12	584	finally
    //   16	35	584	finally
    //   38	43	584	finally
    //   46	100	584	finally
    //   104	116	584	finally
    //   119	126	584	finally
    //   129	134	584	finally
    //   141	147	584	finally
    //   150	227	584	finally
    //   236	274	584	finally
    //   289	295	584	finally
    //   304	310	584	finally
    //   336	342	584	finally
    //   351	369	584	finally
    //   378	385	584	finally
    //   403	411	584	finally
    //   421	429	584	finally
    //   432	462	584	finally
    //   465	473	584	finally
    //   479	578	584	finally
    //   378	385	589	java/lang/Exception
  }
  
  public boolean acceptCookie()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().d();
    }
    return android.webkit.CookieManager.getInstance().acceptCookie();
  }
  
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    try
    {
      Object localObject = bt.a();
      boolean bool;
      if ((localObject != null) && (((bt)localObject).b()))
      {
        localObject = ((bt)localObject).c().b();
        paramWebView = paramWebView.getView();
        paramWebView = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[] { Object.class }, new Object[] { paramWebView });
        if (paramWebView != null)
        {
          bool = ((Boolean)paramWebView).booleanValue();
          return bool;
        }
        return true;
      }
      int i = Build.VERSION.SDK_INT;
      if (i < 21) {
        return true;
      }
      localObject = android.webkit.CookieManager.getInstance();
      paramWebView = paramWebView.getView();
      paramWebView = r.a(localObject, "acceptThirdPartyCookies", new Class[] { android.webkit.WebView.class }, new Object[] { paramWebView });
      if (paramWebView != null)
      {
        bool = ((Boolean)paramWebView).booleanValue();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public void flush()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    r.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
  }
  
  public String getCookie(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().a(paramString);
    }
    try
    {
      paramString = android.webkit.CookieManager.getInstance().getCookie(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean hasCookies()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().h();
    }
    return android.webkit.CookieManager.getInstance().hasCookies();
  }
  
  public void removeAllCookie()
  {
    if (this.a != null) {
      this.a.clear();
    }
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().e();
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    if (this.a != null) {
      this.a.clear();
    }
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    r.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void removeExpiredCookie()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
  }
  
  public void removeSessionCookie()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    r.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    try
    {
      bt localbt = bt.a();
      if ((localbt != null) && (localbt.b())) {
        localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      } else {
        try
        {
          android.webkit.CookieManager.getInstance().setAcceptCookie(paramBoolean);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      return;
    }
    finally {}
  }
  
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    try
    {
      Object localObject = bt.a();
      Class localClass;
      if ((localObject != null) && (((bt)localObject).b()))
      {
        localObject = ((bt)localObject).c().b();
        localClass = Boolean.TYPE;
        paramWebView = paramWebView.getView();
        ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[] { Object.class, localClass }, new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
      }
      else
      {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
          return;
        }
        localObject = android.webkit.CookieManager.getInstance();
        localClass = Boolean.TYPE;
        paramWebView = paramWebView.getView();
        r.a(localObject, "setAcceptThirdPartyCookies", new Class[] { android.webkit.WebView.class, localClass }, new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
      }
      return;
    }
    finally {}
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      setCookie(paramString1, paramString2, false);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    try
    {
      Object localObject = bt.a();
      if ((localObject != null) && (((bt)localObject).b()))
      {
        ((bt)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
      }
      else
      {
        if (!bt.a().d())
        {
          localObject = new b();
          ((b)localObject).a = 1;
          ((b)localObject).b = paramString1;
          ((b)localObject).c = paramString2;
          ((b)localObject).d = paramValueCallback;
          if (this.a == null) {
            this.a = new ArrayList();
          }
          this.a.add(localObject);
        }
        if (this.f)
        {
          int i = Build.VERSION.SDK_INT;
          if (i < 21) {
            return;
          }
          r.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
        }
      }
      return;
    }
    finally {}
  }
  
  public void setCookie(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Object localObject = bt.a();
      if ((localObject != null) && (((bt)localObject).b()))
      {
        ((bt)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
      }
      else
      {
        if ((this.f) || (paramBoolean)) {
          android.webkit.CookieManager.getInstance().setCookie(paramString1, paramString2);
        }
        if (!bt.a().d())
        {
          localObject = new b();
          ((b)localObject).a = 2;
          ((b)localObject).b = paramString1;
          ((b)localObject).c = paramString2;
          ((b)localObject).d = null;
          if (this.a == null) {
            this.a = new ArrayList();
          }
          this.a.add(localObject);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean setCookieCompatialbeMode(Context paramContext, a parama, String paramString, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramContext != null) && (TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")))
    {
      this.c = parama;
      if (paramString != null) {
        this.b = paramString;
      }
      if ((this.c != a.a) && (paramBoolean) && (!bt.a().d())) {
        bt.a().a(paramContext);
      }
      return true;
    }
    return false;
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    Object localObject = bt.a();
    boolean bool;
    if ((localObject != null) && (((bt)localObject).b())) {
      bool = ((bt)localObject).c().a(paramMap);
    } else {
      bool = false;
    }
    if (!bool)
    {
      localObject = paramMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        String[] arrayOfString = (String[])paramMap.get(str);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          setCookie(str, arrayOfString[i]);
          i += 1;
        }
      }
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  class b
  {
    int a;
    String b;
    String c;
    ValueCallback<Boolean> d;
    
    b() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\CookieManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */