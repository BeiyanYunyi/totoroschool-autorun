package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.nio.channels.FileLock;

class bt
{
  private static bt a;
  private static FileLock e;
  private bu b;
  private boolean c;
  private boolean d;
  
  public static bt a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new bt();
        }
      }
      finally {}
    }
    return a;
  }
  
  public bu a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return c();
  }
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 36
    //   4: ldc 38
    //   6: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: iconst_1
    //   10: invokestatic 49	com/tencent/smtt/sdk/o:a	(Z)Lcom/tencent/smtt/sdk/o;
    //   13: astore 8
    //   15: aload 8
    //   17: aload_1
    //   18: iconst_0
    //   19: iconst_0
    //   20: invokevirtual 52	com/tencent/smtt/sdk/o:b	(Landroid/content/Context;ZZ)V
    //   23: new 54	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   30: astore 7
    //   32: aload 8
    //   34: invokevirtual 58	com/tencent/smtt/sdk/o:b	()Lcom/tencent/smtt/sdk/bh;
    //   37: astore 9
    //   39: aload 8
    //   41: invokevirtual 61	com/tencent/smtt/sdk/o:c	()Z
    //   44: istore_3
    //   45: aconst_null
    //   46: astore 6
    //   48: iload_3
    //   49: ifeq +150 -> 199
    //   52: aload 9
    //   54: ifnull +145 -> 199
    //   57: aload_0
    //   58: getfield 63	com/tencent/smtt/sdk/bt:d	Z
    //   61: ifne +724 -> 785
    //   64: aload_0
    //   65: new 65	com/tencent/smtt/sdk/bu
    //   68: dup
    //   69: aload 9
    //   71: invokevirtual 70	com/tencent/smtt/sdk/bh:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   74: invokespecial 73	com/tencent/smtt/sdk/bu:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   77: putfield 26	com/tencent/smtt/sdk/bt:b	Lcom/tencent/smtt/sdk/bu;
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 26	com/tencent/smtt/sdk/bt:b	Lcom/tencent/smtt/sdk/bu;
    //   85: invokevirtual 75	com/tencent/smtt/sdk/bu:a	()Z
    //   88: putfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   91: aload_0
    //   92: getfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   95: ifne +684 -> 779
    //   98: aload 7
    //   100: ldc 79
    //   102: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: goto +673 -> 779
    //   109: astore 4
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   116: new 54	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   123: astore 5
    //   125: aload 5
    //   127: ldc 85
    //   129: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: aload 4
    //   137: invokestatic 91	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: aload 5
    //   148: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: goto +11 -> 166
    //   158: aload_0
    //   159: iconst_1
    //   160: putfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   163: goto +616 -> 779
    //   166: aload 4
    //   168: astore 5
    //   170: aload_0
    //   171: getfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   174: ifeq +41 -> 215
    //   177: invokestatic 101	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   180: aload_1
    //   181: iconst_1
    //   182: iconst_1
    //   183: invokevirtual 103	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   186: invokestatic 101	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   189: invokevirtual 105	com/tencent/smtt/sdk/CookieManager:a	()V
    //   192: aload 4
    //   194: astore 5
    //   196: goto +19 -> 215
    //   199: aload_0
    //   200: iconst_0
    //   201: putfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   204: aload 7
    //   206: ldc 107
    //   208: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: goto +573 -> 785
    //   215: new 54	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   222: astore 4
    //   224: aload 4
    //   226: ldc 109
    //   228: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 4
    //   234: aload_0
    //   235: getfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   238: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc 36
    //   244: aload 4
    //   246: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: getfield 77	com/tencent/smtt/sdk/bt:c	Z
    //   256: ifne +457 -> 713
    //   259: ldc 36
    //   261: ldc 114
    //   263: invokestatic 116	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 8
    //   268: invokevirtual 61	com/tencent/smtt/sdk/o:c	()Z
    //   271: istore_3
    //   272: iload_3
    //   273: ifeq +321 -> 594
    //   276: aload 9
    //   278: ifnull +316 -> 594
    //   281: aload 5
    //   283: ifnonnull +311 -> 594
    //   286: aload 9
    //   288: invokevirtual 70	com/tencent/smtt/sdk/bh:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   291: astore 5
    //   293: aload 6
    //   295: astore 4
    //   297: aload 5
    //   299: ifnull +22 -> 321
    //   302: aload 5
    //   304: ldc 118
    //   306: ldc 120
    //   308: iconst_0
    //   309: anewarray 122	java/lang/Class
    //   312: iconst_0
    //   313: anewarray 4	java/lang/Object
    //   316: invokevirtual 128	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   319: astore 4
    //   321: aload 4
    //   323: instanceof 34
    //   326: ifeq +84 -> 410
    //   329: aload 4
    //   331: checkcast 34	java/lang/Throwable
    //   334: astore 5
    //   336: new 54	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   343: astore 6
    //   345: aload 6
    //   347: ldc -126
    //   349: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 6
    //   355: aload 5
    //   357: invokevirtual 133	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   360: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 6
    //   366: ldc -121
    //   368: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 6
    //   374: aload 5
    //   376: invokevirtual 139	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   379: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 6
    //   385: ldc -112
    //   387: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 6
    //   393: aload 5
    //   395: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 7
    //   401: aload 6
    //   403: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 4
    //   412: instanceof 146
    //   415: ifeq +49 -> 464
    //   418: new 54	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   425: astore 5
    //   427: aload 5
    //   429: ldc -108
    //   431: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 5
    //   437: aload 4
    //   439: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 7
    //   445: aload 5
    //   447: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: goto +10 -> 464
    //   457: astore 4
    //   459: aload 4
    //   461: invokevirtual 151	java/lang/Throwable:printStackTrace	()V
    //   464: aload 7
    //   466: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: ldc -103
    //   471: invokevirtual 157	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   474: ifeq +66 -> 540
    //   477: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   480: astore 4
    //   482: sipush 408
    //   485: istore_2
    //   486: new 54	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   493: astore 5
    //   495: aload 5
    //   497: ldc -92
    //   499: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 5
    //   505: aload 7
    //   507: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: new 34	java/lang/Throwable
    //   517: dup
    //   518: aload 5
    //   520: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   526: astore 5
    //   528: aload 4
    //   530: aload_1
    //   531: iload_2
    //   532: aload 5
    //   534: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   537: goto +224 -> 761
    //   540: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   543: astore 4
    //   545: sipush 407
    //   548: istore_2
    //   549: new 54	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   556: astore 5
    //   558: aload 5
    //   560: ldc -92
    //   562: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 5
    //   568: aload 7
    //   570: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: new 34	java/lang/Throwable
    //   580: dup
    //   581: aload 5
    //   583: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   589: astore 5
    //   591: goto -63 -> 528
    //   594: aload 8
    //   596: invokevirtual 61	com/tencent/smtt/sdk/o:c	()Z
    //   599: ifeq +63 -> 662
    //   602: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   605: astore 4
    //   607: sipush 409
    //   610: istore_2
    //   611: new 54	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   618: astore 6
    //   620: aload 6
    //   622: ldc -84
    //   624: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 6
    //   630: aload 5
    //   632: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: new 34	java/lang/Throwable
    //   639: dup
    //   640: aload 6
    //   642: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   648: astore 5
    //   650: aload 4
    //   652: aload_1
    //   653: iload_2
    //   654: aload 5
    //   656: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   659: goto +102 -> 761
    //   662: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   665: astore 4
    //   667: sipush 410
    //   670: istore_2
    //   671: new 54	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   678: astore 6
    //   680: aload 6
    //   682: ldc -82
    //   684: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 6
    //   690: aload 5
    //   692: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: new 34	java/lang/Throwable
    //   699: dup
    //   700: aload 6
    //   702: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   708: astore 5
    //   710: goto -60 -> 650
    //   713: new 54	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   720: astore 4
    //   722: aload 4
    //   724: ldc -80
    //   726: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 4
    //   732: getstatic 178	com/tencent/smtt/sdk/bt:e	Ljava/nio/channels/FileLock;
    //   735: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: ldc 36
    //   741: aload 4
    //   743: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: getstatic 178	com/tencent/smtt/sdk/bt:e	Ljava/nio/channels/FileLock;
    //   752: ifnonnull +9 -> 761
    //   755: aload_0
    //   756: aload_1
    //   757: invokevirtual 181	com/tencent/smtt/sdk/bt:b	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   760: pop
    //   761: aload_0
    //   762: iconst_1
    //   763: putfield 63	com/tencent/smtt/sdk/bt:d	Z
    //   766: aload_0
    //   767: monitorexit
    //   768: return
    //   769: astore_1
    //   770: aload_0
    //   771: monitorexit
    //   772: aload_1
    //   773: athrow
    //   774: astore 4
    //   776: goto -618 -> 158
    //   779: aconst_null
    //   780: astore 4
    //   782: goto -616 -> 166
    //   785: aconst_null
    //   786: astore 5
    //   788: goto -573 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	791	0	this	bt
    //   0	791	1	paramContext	Context
    //   485	186	2	i	int
    //   44	229	3	bool	boolean
    //   109	84	4	localThrowable1	Throwable
    //   222	216	4	localObject1	Object
    //   457	3	4	localThrowable2	Throwable
    //   480	262	4	localObject2	Object
    //   774	1	4	localNoSuchMethodException	NoSuchMethodException
    //   780	1	4	localObject3	Object
    //   123	664	5	localObject4	Object
    //   46	655	6	localStringBuilder1	StringBuilder
    //   30	539	7	localStringBuilder2	StringBuilder
    //   13	582	8	localo	o
    //   37	250	9	localbh	bh
    // Exception table:
    //   from	to	target	type
    //   80	106	109	java/lang/Throwable
    //   286	293	457	java/lang/Throwable
    //   302	321	457	java/lang/Throwable
    //   321	410	457	java/lang/Throwable
    //   410	454	457	java/lang/Throwable
    //   2	45	769	finally
    //   57	80	769	finally
    //   80	106	769	finally
    //   111	155	769	finally
    //   158	163	769	finally
    //   170	192	769	finally
    //   199	212	769	finally
    //   215	272	769	finally
    //   286	293	769	finally
    //   302	321	769	finally
    //   321	410	769	finally
    //   410	454	769	finally
    //   459	464	769	finally
    //   464	482	769	finally
    //   486	528	769	finally
    //   528	537	769	finally
    //   540	545	769	finally
    //   549	591	769	finally
    //   594	607	769	finally
    //   611	650	769	finally
    //   650	659	769	finally
    //   662	667	769	finally
    //   671	710	769	finally
    //   713	761	769	finally
    //   761	766	769	finally
    //   80	106	774	java/lang/NoSuchMethodException
  }
  
  public FileLock b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        if (e != null)
        {
          paramContext = e;
          return paramContext;
        }
        e = k.e(paramContext);
        if (e == null)
        {
          paramContext = "init -- sTbsCoreLoadFileLock failed!";
          TbsLog.i("X5CoreEngine", paramContext);
          paramContext = e;
          return paramContext;
        }
      }
      finally {}
      paramContext = "init -- sTbsCoreLoadFileLock succeeded!";
    }
  }
  
  public boolean b()
  {
    if (QbSdk.a) {
      return false;
    }
    return this.c;
  }
  
  public bu c()
  {
    if (QbSdk.a) {
      return null;
    }
    return this.b;
  }
  
  public void c(Context paramContext)
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
    if (e != null) {
      k.a(paramContext, e);
    }
  }
  
  boolean d()
  {
    return this.d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */