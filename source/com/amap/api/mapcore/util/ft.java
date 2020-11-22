package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

public class ft
{
  private static String a()
  {
    Object localObject1;
    try
    {
      String str = android.net.Proxy.getDefaultHost();
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "pu", "gdh");
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "null";
    }
    return (String)localObject2;
  }
  
  public static String a(String paramString)
  {
    return fw.c(paramString);
  }
  
  public static java.net.Proxy a(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        return a(paramContext, new URI("http://restapi.amap.com"));
      }
      paramContext = b(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "pu", "gp");
    }
    return null;
  }
  
  private static java.net.Proxy a(Context paramContext, URI paramURI)
  {
    boolean bool = c(paramContext);
    Proxy.Type localType = null;
    if (bool) {
      try
      {
        paramURI = ProxySelector.getDefault().select(paramURI);
        paramContext = localType;
        if (paramURI != null)
        {
          paramContext = localType;
          if (!paramURI.isEmpty())
          {
            paramURI = (java.net.Proxy)paramURI.get(0);
            paramContext = localType;
            if (paramURI != null)
            {
              paramContext = paramURI.type();
              localType = Proxy.Type.DIRECT;
              if (paramContext == localType) {
                return null;
              }
              paramContext = paramURI;
            }
          }
        }
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        gk.c(paramContext, "pu", "gpsc");
      }
    }
    return null;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    return (paramString != null) && (paramString.length() > 0) && (paramInt != -1);
  }
  
  private static int b()
  {
    try
    {
      int i = android.net.Proxy.getDefaultPort();
      return i;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "pu", "gdp");
    }
    return -1;
  }
  
  /* Error */
  private static java.net.Proxy b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 57	com/amap/api/mapcore/util/ft:c	(Landroid/content/Context;)Z
    //   4: ifeq +870 -> 874
    //   7: ldc 107
    //   9: invokestatic 113	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   12: astore 8
    //   14: aload_0
    //   15: invokevirtual 119	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 9
    //   20: iconst_0
    //   21: istore 6
    //   23: iconst_0
    //   24: istore 5
    //   26: bipush 80
    //   28: istore 4
    //   30: aload 9
    //   32: aload 8
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 125	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 8
    //   43: aload 8
    //   45: ifnull +420 -> 465
    //   48: aload 8
    //   50: astore 9
    //   52: aload 8
    //   54: invokeinterface 130 1 0
    //   59: ifeq +406 -> 465
    //   62: aload 8
    //   64: astore 9
    //   66: aload 8
    //   68: aload 8
    //   70: ldc -124
    //   72: invokeinterface 136 2 0
    //   77: invokeinterface 140 2 0
    //   82: astore 11
    //   84: aload 11
    //   86: astore 10
    //   88: aload 11
    //   90: ifnull +17 -> 107
    //   93: aload 8
    //   95: astore 9
    //   97: aload 11
    //   99: getstatic 146	java/util/Locale:US	Ljava/util/Locale;
    //   102: invokevirtual 150	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   105: astore 10
    //   107: aload 10
    //   109: ifnull +202 -> 311
    //   112: aload 8
    //   114: astore 9
    //   116: aload 10
    //   118: ldc -104
    //   120: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   123: ifeq +188 -> 311
    //   126: aload 8
    //   128: astore 9
    //   130: invokestatic 158	com/amap/api/mapcore/util/ft:a	()Ljava/lang/String;
    //   133: astore 10
    //   135: aload 8
    //   137: astore 9
    //   139: invokestatic 160	com/amap/api/mapcore/util/ft:b	()I
    //   142: istore_1
    //   143: iload_1
    //   144: istore_2
    //   145: iload_1
    //   146: istore_3
    //   147: aload 8
    //   149: astore 9
    //   151: aload 10
    //   153: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +34 -> 190
    //   159: iload_1
    //   160: istore_2
    //   161: iload_1
    //   162: istore_3
    //   163: aload 8
    //   165: astore 9
    //   167: aload 10
    //   169: ldc 25
    //   171: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: istore 7
    //   176: iload 7
    //   178: ifne +12 -> 190
    //   181: aload 10
    //   183: astore 9
    //   185: iconst_1
    //   186: istore_2
    //   187: goto +8 -> 195
    //   190: aconst_null
    //   191: astore 9
    //   193: iconst_0
    //   194: istore_2
    //   195: iload_2
    //   196: ifne +61 -> 257
    //   199: iload_1
    //   200: istore_2
    //   201: aload 9
    //   203: astore 10
    //   205: iload_1
    //   206: istore_3
    //   207: aload 9
    //   209: astore 11
    //   211: aload 8
    //   213: astore 9
    //   215: ldc -86
    //   217: invokestatic 172	com/amap/api/mapcore/util/ft:a	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 12
    //   222: aload 12
    //   224: astore_0
    //   225: goto +35 -> 260
    //   228: astore 9
    //   230: iload_2
    //   231: istore_1
    //   232: aload 10
    //   234: astore_0
    //   235: aload 9
    //   237: astore 10
    //   239: goto +288 -> 527
    //   242: astore 12
    //   244: aload 8
    //   246: astore 10
    //   248: iload_3
    //   249: istore_1
    //   250: aload 11
    //   252: astore 8
    //   254: goto +335 -> 589
    //   257: aload 9
    //   259: astore_0
    //   260: aload_0
    //   261: astore 9
    //   263: iload_1
    //   264: istore_2
    //   265: iload_1
    //   266: iconst_m1
    //   267: if_icmpne +9 -> 276
    //   270: iload 4
    //   272: istore_1
    //   273: goto +196 -> 469
    //   276: iload_2
    //   277: istore_1
    //   278: aload 9
    //   280: astore_0
    //   281: goto +188 -> 469
    //   284: astore 10
    //   286: aconst_null
    //   287: astore_0
    //   288: iload_2
    //   289: istore_1
    //   290: goto +237 -> 527
    //   293: astore 12
    //   295: aconst_null
    //   296: astore 9
    //   298: aload 8
    //   300: astore 10
    //   302: iload_3
    //   303: istore_1
    //   304: aload 9
    //   306: astore 8
    //   308: goto +281 -> 589
    //   311: aload 10
    //   313: ifnull +152 -> 465
    //   316: aload 8
    //   318: astore 9
    //   320: aload 10
    //   322: ldc -82
    //   324: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   327: ifeq +138 -> 465
    //   330: aload 8
    //   332: astore 9
    //   334: invokestatic 158	com/amap/api/mapcore/util/ft:a	()Ljava/lang/String;
    //   337: astore 10
    //   339: aload 8
    //   341: astore 9
    //   343: invokestatic 160	com/amap/api/mapcore/util/ft:b	()I
    //   346: istore_1
    //   347: iload_1
    //   348: istore_2
    //   349: iload_1
    //   350: istore_3
    //   351: aload 8
    //   353: astore 9
    //   355: aload 10
    //   357: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +34 -> 394
    //   363: iload_1
    //   364: istore_2
    //   365: iload_1
    //   366: istore_3
    //   367: aload 8
    //   369: astore 9
    //   371: aload 10
    //   373: ldc 25
    //   375: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: istore 7
    //   380: iload 7
    //   382: ifne +12 -> 394
    //   385: aload 10
    //   387: astore 9
    //   389: iconst_1
    //   390: istore_2
    //   391: goto +8 -> 399
    //   394: aconst_null
    //   395: astore 9
    //   397: iconst_0
    //   398: istore_2
    //   399: iload_2
    //   400: ifne +32 -> 432
    //   403: iload_1
    //   404: istore_2
    //   405: aload 9
    //   407: astore 10
    //   409: iload_1
    //   410: istore_3
    //   411: aload 9
    //   413: astore 11
    //   415: aload 8
    //   417: astore 9
    //   419: ldc -80
    //   421: invokestatic 172	com/amap/api/mapcore/util/ft:a	(Ljava/lang/String;)Ljava/lang/String;
    //   424: astore 12
    //   426: aload 12
    //   428: astore_0
    //   429: goto +6 -> 435
    //   432: aload 9
    //   434: astore_0
    //   435: aload_0
    //   436: astore 9
    //   438: iload_1
    //   439: istore_2
    //   440: iload_1
    //   441: iconst_m1
    //   442: if_icmpne -166 -> 276
    //   445: iload 4
    //   447: istore_1
    //   448: goto +21 -> 469
    //   451: astore 10
    //   453: goto +70 -> 523
    //   456: astore 12
    //   458: aload 8
    //   460: astore 10
    //   462: goto +122 -> 584
    //   465: aconst_null
    //   466: astore_0
    //   467: iconst_m1
    //   468: istore_1
    //   469: aload_0
    //   470: astore 9
    //   472: iload_1
    //   473: istore_2
    //   474: aload 8
    //   476: ifnull +326 -> 802
    //   479: aload_0
    //   480: astore 9
    //   482: iload_1
    //   483: istore_2
    //   484: aload 8
    //   486: invokeinterface 180 1 0
    //   491: aload_0
    //   492: astore 9
    //   494: iload_1
    //   495: istore_2
    //   496: goto +306 -> 802
    //   499: astore_0
    //   500: aload_0
    //   501: ldc 15
    //   503: ldc -74
    //   505: invokestatic 23	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   508: goto +294 -> 802
    //   511: astore_0
    //   512: aconst_null
    //   513: astore 9
    //   515: goto +331 -> 846
    //   518: astore 10
    //   520: aconst_null
    //   521: astore 8
    //   523: aconst_null
    //   524: astore_0
    //   525: iconst_m1
    //   526: istore_1
    //   527: aload 8
    //   529: astore 9
    //   531: aload 10
    //   533: ldc 15
    //   535: ldc -72
    //   537: invokestatic 23	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   540: aload 8
    //   542: astore 9
    //   544: aload 10
    //   546: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
    //   549: aload_0
    //   550: astore 9
    //   552: iload_1
    //   553: istore_2
    //   554: aload 8
    //   556: ifnull +246 -> 802
    //   559: aload_0
    //   560: astore 9
    //   562: iload_1
    //   563: istore_2
    //   564: aload 8
    //   566: invokeinterface 180 1 0
    //   571: aload_0
    //   572: astore 9
    //   574: iload_1
    //   575: istore_2
    //   576: goto +226 -> 802
    //   579: astore 12
    //   581: aconst_null
    //   582: astore 10
    //   584: aconst_null
    //   585: astore 8
    //   587: iconst_m1
    //   588: istore_1
    //   589: aload 10
    //   591: astore 9
    //   593: aload 12
    //   595: ldc 15
    //   597: ldc -67
    //   599: invokestatic 23	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload 10
    //   604: astore 9
    //   606: aload_0
    //   607: invokestatic 195	com/amap/api/mapcore/util/fp:u	(Landroid/content/Context;)Ljava/lang/String;
    //   610: astore_0
    //   611: aload_0
    //   612: ifnull +160 -> 772
    //   615: aload 10
    //   617: astore 9
    //   619: aload_0
    //   620: getstatic 146	java/util/Locale:US	Ljava/util/Locale;
    //   623: invokevirtual 150	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   626: astore 11
    //   628: aload 10
    //   630: astore 9
    //   632: invokestatic 158	com/amap/api/mapcore/util/ft:a	()Ljava/lang/String;
    //   635: astore_0
    //   636: aload 10
    //   638: astore 9
    //   640: invokestatic 160	com/amap/api/mapcore/util/ft:b	()I
    //   643: istore_1
    //   644: aload 10
    //   646: astore 9
    //   648: aload 11
    //   650: ldc -104
    //   652: invokevirtual 198	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   655: iconst_m1
    //   656: if_icmpeq +49 -> 705
    //   659: aload 10
    //   661: astore 9
    //   663: aload_0
    //   664: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   667: ifne +209 -> 876
    //   670: aload 10
    //   672: astore 9
    //   674: aload_0
    //   675: ldc 25
    //   677: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifne +196 -> 876
    //   683: iconst_1
    //   684: istore_2
    //   685: goto +3 -> 688
    //   688: iload_2
    //   689: ifne +196 -> 885
    //   692: aload 10
    //   694: astore 9
    //   696: ldc -86
    //   698: invokestatic 172	com/amap/api/mapcore/util/ft:a	(Ljava/lang/String;)Ljava/lang/String;
    //   701: astore_0
    //   702: goto +183 -> 885
    //   705: aload 10
    //   707: astore 9
    //   709: aload 11
    //   711: ldc -82
    //   713: invokevirtual 198	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   716: iconst_m1
    //   717: if_icmpeq +55 -> 772
    //   720: aload 10
    //   722: astore 9
    //   724: aload_0
    //   725: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   728: ifne +171 -> 899
    //   731: aload 10
    //   733: astore 9
    //   735: aload_0
    //   736: ldc 25
    //   738: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   741: ifne +158 -> 899
    //   744: iconst_1
    //   745: istore_2
    //   746: goto +3 -> 749
    //   749: iload 4
    //   751: istore_1
    //   752: iload_2
    //   753: ifne +22 -> 775
    //   756: aload 10
    //   758: astore 9
    //   760: ldc -80
    //   762: invokestatic 172	com/amap/api/mapcore/util/ft:a	(Ljava/lang/String;)Ljava/lang/String;
    //   765: astore_0
    //   766: iload 4
    //   768: istore_1
    //   769: goto +6 -> 775
    //   772: aload 8
    //   774: astore_0
    //   775: aload_0
    //   776: astore 9
    //   778: iload_1
    //   779: istore_2
    //   780: aload 10
    //   782: ifnull +20 -> 802
    //   785: aload_0
    //   786: astore 9
    //   788: iload_1
    //   789: istore_2
    //   790: aload 10
    //   792: invokeinterface 180 1 0
    //   797: iload_1
    //   798: istore_2
    //   799: aload_0
    //   800: astore 9
    //   802: aload 9
    //   804: iload_2
    //   805: invokestatic 200	com/amap/api/mapcore/util/ft:a	(Ljava/lang/String;I)Z
    //   808: ifeq +66 -> 874
    //   811: new 79	java/net/Proxy
    //   814: dup
    //   815: getstatic 203	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   818: aload 9
    //   820: iload_2
    //   821: invokestatic 209	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   824: invokespecial 212	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   827: astore_0
    //   828: aload_0
    //   829: areturn
    //   830: astore_0
    //   831: aload_0
    //   832: ldc 15
    //   834: ldc -42
    //   836: invokestatic 218	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   839: aload_0
    //   840: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
    //   843: aconst_null
    //   844: areturn
    //   845: astore_0
    //   846: aload 9
    //   848: ifnull +24 -> 872
    //   851: aload 9
    //   853: invokeinterface 180 1 0
    //   858: goto +14 -> 872
    //   861: astore 8
    //   863: aload 8
    //   865: ldc 15
    //   867: ldc -74
    //   869: invokestatic 23	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   872: aload_0
    //   873: athrow
    //   874: aconst_null
    //   875: areturn
    //   876: aload 8
    //   878: astore_0
    //   879: iload 5
    //   881: istore_2
    //   882: goto -194 -> 688
    //   885: iload_1
    //   886: iconst_m1
    //   887: if_icmpne +9 -> 896
    //   890: iload 4
    //   892: istore_1
    //   893: goto -118 -> 775
    //   896: goto -121 -> 775
    //   899: aload 8
    //   901: astore_0
    //   902: iload 6
    //   904: istore_2
    //   905: goto -156 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	908	0	paramContext	Context
    //   142	751	1	i	int
    //   144	761	2	j	int
    //   146	265	3	k	int
    //   28	863	4	m	int
    //   24	856	5	n	int
    //   21	882	6	i1	int
    //   174	207	7	bool	boolean
    //   12	761	8	localObject1	Object
    //   861	39	8	localThrowable1	Throwable
    //   18	196	9	localObject2	Object
    //   228	30	9	localThrowable2	Throwable
    //   261	591	9	localObject3	Object
    //   86	161	10	localObject4	Object
    //   284	1	10	localThrowable3	Throwable
    //   300	108	10	localObject5	Object
    //   451	1	10	localThrowable4	Throwable
    //   460	1	10	localObject6	Object
    //   518	27	10	localThrowable5	Throwable
    //   582	209	10	localObject7	Object
    //   82	628	11	localObject8	Object
    //   220	3	12	str1	String
    //   242	1	12	localSecurityException1	SecurityException
    //   293	1	12	localSecurityException2	SecurityException
    //   424	3	12	str2	String
    //   456	1	12	localSecurityException3	SecurityException
    //   579	15	12	localSecurityException4	SecurityException
    // Exception table:
    //   from	to	target	type
    //   215	222	228	java/lang/Throwable
    //   419	426	228	java/lang/Throwable
    //   215	222	242	java/lang/SecurityException
    //   419	426	242	java/lang/SecurityException
    //   151	159	284	java/lang/Throwable
    //   167	176	284	java/lang/Throwable
    //   355	363	284	java/lang/Throwable
    //   371	380	284	java/lang/Throwable
    //   151	159	293	java/lang/SecurityException
    //   167	176	293	java/lang/SecurityException
    //   355	363	293	java/lang/SecurityException
    //   371	380	293	java/lang/SecurityException
    //   52	62	451	java/lang/Throwable
    //   66	84	451	java/lang/Throwable
    //   97	107	451	java/lang/Throwable
    //   116	126	451	java/lang/Throwable
    //   130	135	451	java/lang/Throwable
    //   139	143	451	java/lang/Throwable
    //   320	330	451	java/lang/Throwable
    //   334	339	451	java/lang/Throwable
    //   343	347	451	java/lang/Throwable
    //   52	62	456	java/lang/SecurityException
    //   66	84	456	java/lang/SecurityException
    //   97	107	456	java/lang/SecurityException
    //   116	126	456	java/lang/SecurityException
    //   130	135	456	java/lang/SecurityException
    //   139	143	456	java/lang/SecurityException
    //   320	330	456	java/lang/SecurityException
    //   334	339	456	java/lang/SecurityException
    //   343	347	456	java/lang/SecurityException
    //   484	491	499	java/lang/Throwable
    //   564	571	499	java/lang/Throwable
    //   790	797	499	java/lang/Throwable
    //   30	43	511	finally
    //   30	43	518	java/lang/Throwable
    //   30	43	579	java/lang/SecurityException
    //   802	828	830	java/lang/Throwable
    //   52	62	845	finally
    //   66	84	845	finally
    //   97	107	845	finally
    //   116	126	845	finally
    //   130	135	845	finally
    //   139	143	845	finally
    //   151	159	845	finally
    //   167	176	845	finally
    //   215	222	845	finally
    //   320	330	845	finally
    //   334	339	845	finally
    //   343	347	845	finally
    //   355	363	845	finally
    //   371	380	845	finally
    //   419	426	845	finally
    //   531	540	845	finally
    //   544	549	845	finally
    //   593	602	845	finally
    //   606	611	845	finally
    //   619	628	845	finally
    //   632	636	845	finally
    //   640	644	845	finally
    //   648	659	845	finally
    //   663	670	845	finally
    //   674	683	845	finally
    //   696	702	845	finally
    //   709	720	845	finally
    //   724	731	845	finally
    //   735	744	845	finally
    //   760	766	845	finally
    //   851	858	861	java/lang/Throwable
  }
  
  private static boolean c(Context paramContext)
  {
    return fp.s(paramContext) == 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */