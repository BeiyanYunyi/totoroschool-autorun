package com.loc;

import android.content.Context;
import android.os.Build.VERSION;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

public final class t
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
      aj.b(localThrowable, "pu", "gdh");
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "null";
    }
    return (String)localObject2;
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
      aj.b(paramContext, "pu", "gp");
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
        aj.b(paramContext, "pu", "gpsc");
      }
    }
    return null;
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
      aj.b(localThrowable, "pu", "gdp");
    }
    return -1;
  }
  
  /* Error */
  private static java.net.Proxy b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 52	com/loc/t:c	(Landroid/content/Context;)Z
    //   4: ifeq +893 -> 897
    //   7: ldc 96
    //   9: invokestatic 102	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   12: astore 7
    //   14: aload_0
    //   15: invokevirtual 108	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 8
    //   20: bipush 80
    //   22: istore 4
    //   24: iconst_0
    //   25: istore 5
    //   27: aload 8
    //   29: aload 7
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 114	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 7
    //   40: aload 7
    //   42: ifnull +420 -> 462
    //   45: aload 7
    //   47: astore 8
    //   49: aload 7
    //   51: invokeinterface 119 1 0
    //   56: ifeq +406 -> 462
    //   59: aload 7
    //   61: astore 8
    //   63: aload 7
    //   65: aload 7
    //   67: ldc 121
    //   69: invokeinterface 125 2 0
    //   74: invokeinterface 129 2 0
    //   79: astore 10
    //   81: aload 10
    //   83: astore 9
    //   85: aload 10
    //   87: ifnull +17 -> 104
    //   90: aload 7
    //   92: astore 8
    //   94: aload 10
    //   96: getstatic 135	java/util/Locale:US	Ljava/util/Locale;
    //   99: invokevirtual 141	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   102: astore 9
    //   104: aload 9
    //   106: ifnull +202 -> 308
    //   109: aload 7
    //   111: astore 8
    //   113: aload 9
    //   115: ldc -113
    //   117: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   120: ifeq +188 -> 308
    //   123: aload 7
    //   125: astore 8
    //   127: invokestatic 149	com/loc/t:a	()Ljava/lang/String;
    //   130: astore 9
    //   132: aload 7
    //   134: astore 8
    //   136: invokestatic 151	com/loc/t:b	()I
    //   139: istore_1
    //   140: iload_1
    //   141: istore_2
    //   142: iload_1
    //   143: istore_3
    //   144: aload 7
    //   146: astore 8
    //   148: aload 9
    //   150: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne +34 -> 187
    //   156: iload_1
    //   157: istore_2
    //   158: iload_1
    //   159: istore_3
    //   160: aload 7
    //   162: astore 8
    //   164: aload 9
    //   166: ldc 25
    //   168: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: istore 6
    //   173: iload 6
    //   175: ifne +12 -> 187
    //   178: aload 9
    //   180: astore 8
    //   182: iconst_1
    //   183: istore_2
    //   184: goto +8 -> 192
    //   187: aconst_null
    //   188: astore 8
    //   190: iconst_0
    //   191: istore_2
    //   192: iload_2
    //   193: ifne +61 -> 254
    //   196: iload_1
    //   197: istore_2
    //   198: aload 8
    //   200: astore 9
    //   202: iload_1
    //   203: istore_3
    //   204: aload 8
    //   206: astore 10
    //   208: aload 7
    //   210: astore 8
    //   212: ldc -95
    //   214: invokestatic 166	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 11
    //   219: aload 11
    //   221: astore_0
    //   222: goto +35 -> 257
    //   225: astore 8
    //   227: iload_2
    //   228: istore_1
    //   229: aload 9
    //   231: astore_0
    //   232: aload 8
    //   234: astore 9
    //   236: goto +288 -> 524
    //   239: astore 11
    //   241: aload 7
    //   243: astore 9
    //   245: iload_3
    //   246: istore_1
    //   247: aload 10
    //   249: astore 7
    //   251: goto +335 -> 586
    //   254: aload 8
    //   256: astore_0
    //   257: aload_0
    //   258: astore 8
    //   260: iload_1
    //   261: istore_2
    //   262: iload_1
    //   263: iconst_m1
    //   264: if_icmpne +9 -> 273
    //   267: iload 4
    //   269: istore_1
    //   270: goto +196 -> 466
    //   273: iload_2
    //   274: istore_1
    //   275: aload 8
    //   277: astore_0
    //   278: goto +188 -> 466
    //   281: astore 9
    //   283: aconst_null
    //   284: astore_0
    //   285: iload_2
    //   286: istore_1
    //   287: goto +237 -> 524
    //   290: astore 11
    //   292: aconst_null
    //   293: astore 8
    //   295: aload 7
    //   297: astore 9
    //   299: iload_3
    //   300: istore_1
    //   301: aload 8
    //   303: astore 7
    //   305: goto +281 -> 586
    //   308: aload 9
    //   310: ifnull +152 -> 462
    //   313: aload 7
    //   315: astore 8
    //   317: aload 9
    //   319: ldc -88
    //   321: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   324: ifeq +138 -> 462
    //   327: aload 7
    //   329: astore 8
    //   331: invokestatic 149	com/loc/t:a	()Ljava/lang/String;
    //   334: astore 9
    //   336: aload 7
    //   338: astore 8
    //   340: invokestatic 151	com/loc/t:b	()I
    //   343: istore_1
    //   344: iload_1
    //   345: istore_2
    //   346: iload_1
    //   347: istore_3
    //   348: aload 7
    //   350: astore 8
    //   352: aload 9
    //   354: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +34 -> 391
    //   360: iload_1
    //   361: istore_2
    //   362: iload_1
    //   363: istore_3
    //   364: aload 7
    //   366: astore 8
    //   368: aload 9
    //   370: ldc 25
    //   372: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   375: istore 6
    //   377: iload 6
    //   379: ifne +12 -> 391
    //   382: aload 9
    //   384: astore 8
    //   386: iconst_1
    //   387: istore_2
    //   388: goto +8 -> 396
    //   391: aconst_null
    //   392: astore 8
    //   394: iconst_0
    //   395: istore_2
    //   396: iload_2
    //   397: ifne +32 -> 429
    //   400: iload_1
    //   401: istore_2
    //   402: aload 8
    //   404: astore 9
    //   406: iload_1
    //   407: istore_3
    //   408: aload 8
    //   410: astore 10
    //   412: aload 7
    //   414: astore 8
    //   416: ldc -86
    //   418: invokestatic 166	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   421: astore 11
    //   423: aload 11
    //   425: astore_0
    //   426: goto +6 -> 432
    //   429: aload 8
    //   431: astore_0
    //   432: aload_0
    //   433: astore 8
    //   435: iload_1
    //   436: istore_2
    //   437: iload_1
    //   438: iconst_m1
    //   439: if_icmpne -166 -> 273
    //   442: iload 4
    //   444: istore_1
    //   445: goto +21 -> 466
    //   448: astore 9
    //   450: goto +70 -> 520
    //   453: astore 11
    //   455: aload 7
    //   457: astore 9
    //   459: goto +122 -> 581
    //   462: aconst_null
    //   463: astore_0
    //   464: iconst_m1
    //   465: istore_1
    //   466: iload_1
    //   467: istore_2
    //   468: aload_0
    //   469: astore 8
    //   471: aload 7
    //   473: ifnull +326 -> 799
    //   476: iload_1
    //   477: istore_2
    //   478: aload_0
    //   479: astore 8
    //   481: aload 7
    //   483: invokeinterface 174 1 0
    //   488: iload_1
    //   489: istore_2
    //   490: aload_0
    //   491: astore 8
    //   493: goto +306 -> 799
    //   496: astore_0
    //   497: aload_0
    //   498: ldc 15
    //   500: ldc -80
    //   502: invokestatic 23	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   505: goto +294 -> 799
    //   508: astore_0
    //   509: aconst_null
    //   510: astore 8
    //   512: goto +357 -> 869
    //   515: astore 9
    //   517: aconst_null
    //   518: astore 7
    //   520: aconst_null
    //   521: astore_0
    //   522: iconst_m1
    //   523: istore_1
    //   524: aload 7
    //   526: astore 8
    //   528: aload 9
    //   530: ldc 15
    //   532: ldc -78
    //   534: invokestatic 23	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload 7
    //   539: astore 8
    //   541: aload 9
    //   543: invokevirtual 181	java/lang/Throwable:printStackTrace	()V
    //   546: iload_1
    //   547: istore_2
    //   548: aload_0
    //   549: astore 8
    //   551: aload 7
    //   553: ifnull +246 -> 799
    //   556: iload_1
    //   557: istore_2
    //   558: aload_0
    //   559: astore 8
    //   561: aload 7
    //   563: invokeinterface 174 1 0
    //   568: iload_1
    //   569: istore_2
    //   570: aload_0
    //   571: astore 8
    //   573: goto +226 -> 799
    //   576: astore 11
    //   578: aconst_null
    //   579: astore 9
    //   581: aconst_null
    //   582: astore 7
    //   584: iconst_m1
    //   585: istore_1
    //   586: aload 9
    //   588: astore 8
    //   590: aload 11
    //   592: ldc 15
    //   594: ldc -73
    //   596: invokestatic 23	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   599: aload 9
    //   601: astore 8
    //   603: aload_0
    //   604: invokestatic 189	com/loc/p:u	(Landroid/content/Context;)Ljava/lang/String;
    //   607: astore_0
    //   608: aload_0
    //   609: ifnull +160 -> 769
    //   612: aload 9
    //   614: astore 8
    //   616: aload_0
    //   617: getstatic 135	java/util/Locale:US	Ljava/util/Locale;
    //   620: invokevirtual 141	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   623: astore 10
    //   625: aload 9
    //   627: astore 8
    //   629: invokestatic 149	com/loc/t:a	()Ljava/lang/String;
    //   632: astore_0
    //   633: aload 9
    //   635: astore 8
    //   637: invokestatic 151	com/loc/t:b	()I
    //   640: istore_1
    //   641: aload 9
    //   643: astore 8
    //   645: aload 10
    //   647: ldc -113
    //   649: invokevirtual 192	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   652: iconst_m1
    //   653: if_icmpeq +49 -> 702
    //   656: aload 9
    //   658: astore 8
    //   660: aload_0
    //   661: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   664: ifne +235 -> 899
    //   667: aload 9
    //   669: astore 8
    //   671: aload_0
    //   672: ldc 25
    //   674: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   677: ifne +222 -> 899
    //   680: iconst_1
    //   681: istore_2
    //   682: goto +3 -> 685
    //   685: iload_2
    //   686: ifne +221 -> 907
    //   689: aload 9
    //   691: astore 8
    //   693: ldc -95
    //   695: invokestatic 166	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   698: astore_0
    //   699: goto +208 -> 907
    //   702: aload 9
    //   704: astore 8
    //   706: aload 10
    //   708: ldc -88
    //   710: invokevirtual 192	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   713: iconst_m1
    //   714: if_icmpeq +55 -> 769
    //   717: aload 9
    //   719: astore 8
    //   721: aload_0
    //   722: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   725: ifne +196 -> 921
    //   728: aload 9
    //   730: astore 8
    //   732: aload_0
    //   733: ldc 25
    //   735: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   738: ifne +183 -> 921
    //   741: iconst_1
    //   742: istore_2
    //   743: goto +3 -> 746
    //   746: iload 4
    //   748: istore_1
    //   749: iload_2
    //   750: ifne +22 -> 772
    //   753: aload 9
    //   755: astore 8
    //   757: ldc -86
    //   759: invokestatic 166	com/loc/w:c	(Ljava/lang/String;)Ljava/lang/String;
    //   762: astore_0
    //   763: iload 4
    //   765: istore_1
    //   766: goto +6 -> 772
    //   769: aload 7
    //   771: astore_0
    //   772: iload_1
    //   773: istore_2
    //   774: aload_0
    //   775: astore 8
    //   777: aload 9
    //   779: ifnull +20 -> 799
    //   782: iload_1
    //   783: istore_2
    //   784: aload_0
    //   785: astore 8
    //   787: aload 9
    //   789: invokeinterface 174 1 0
    //   794: aload_0
    //   795: astore 8
    //   797: iload_1
    //   798: istore_2
    //   799: iload 5
    //   801: istore_1
    //   802: aload 8
    //   804: ifnull +27 -> 831
    //   807: iload 5
    //   809: istore_1
    //   810: aload 8
    //   812: invokevirtual 195	java/lang/String:length	()I
    //   815: ifle +16 -> 831
    //   818: iload 5
    //   820: istore_1
    //   821: iload_2
    //   822: iconst_m1
    //   823: if_icmpeq +8 -> 831
    //   826: iconst_1
    //   827: istore_1
    //   828: goto +3 -> 831
    //   831: iload_1
    //   832: ifeq +65 -> 897
    //   835: new 74	java/net/Proxy
    //   838: dup
    //   839: getstatic 198	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   842: aload 8
    //   844: iload_2
    //   845: invokestatic 204	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   848: invokespecial 207	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   851: astore_0
    //   852: aload_0
    //   853: areturn
    //   854: aload_0
    //   855: ldc 15
    //   857: ldc -47
    //   859: invokestatic 213	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   862: aload_0
    //   863: invokevirtual 181	java/lang/Throwable:printStackTrace	()V
    //   866: aconst_null
    //   867: areturn
    //   868: astore_0
    //   869: aload 8
    //   871: ifnull +24 -> 895
    //   874: aload 8
    //   876: invokeinterface 174 1 0
    //   881: goto +14 -> 895
    //   884: astore 7
    //   886: aload 7
    //   888: ldc 15
    //   890: ldc -80
    //   892: invokestatic 23	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   895: aload_0
    //   896: athrow
    //   897: aconst_null
    //   898: areturn
    //   899: aload 7
    //   901: astore_0
    //   902: iconst_0
    //   903: istore_2
    //   904: goto -219 -> 685
    //   907: iload_1
    //   908: iconst_m1
    //   909: if_icmpne +9 -> 918
    //   912: iload 4
    //   914: istore_1
    //   915: goto -143 -> 772
    //   918: goto -146 -> 772
    //   921: aload 7
    //   923: astore_0
    //   924: iconst_0
    //   925: istore_2
    //   926: goto -180 -> 746
    //   929: astore_0
    //   930: goto -76 -> 854
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	933	0	paramContext	Context
    //   139	776	1	i	int
    //   141	785	2	j	int
    //   143	265	3	k	int
    //   22	891	4	m	int
    //   25	794	5	n	int
    //   171	207	6	bool	boolean
    //   12	758	7	localObject1	Object
    //   884	38	7	localThrowable1	Throwable
    //   18	193	8	localObject2	Object
    //   225	30	8	localThrowable2	Throwable
    //   258	617	8	localObject3	Object
    //   83	161	9	localObject4	Object
    //   281	1	9	localThrowable3	Throwable
    //   297	108	9	localObject5	Object
    //   448	1	9	localThrowable4	Throwable
    //   457	1	9	localObject6	Object
    //   515	27	9	localThrowable5	Throwable
    //   579	209	9	localObject7	Object
    //   79	628	10	localObject8	Object
    //   217	3	11	str1	String
    //   239	1	11	localSecurityException1	SecurityException
    //   290	1	11	localSecurityException2	SecurityException
    //   421	3	11	str2	String
    //   453	1	11	localSecurityException3	SecurityException
    //   576	15	11	localSecurityException4	SecurityException
    // Exception table:
    //   from	to	target	type
    //   212	219	225	java/lang/Throwable
    //   416	423	225	java/lang/Throwable
    //   212	219	239	java/lang/SecurityException
    //   416	423	239	java/lang/SecurityException
    //   148	156	281	java/lang/Throwable
    //   164	173	281	java/lang/Throwable
    //   352	360	281	java/lang/Throwable
    //   368	377	281	java/lang/Throwable
    //   148	156	290	java/lang/SecurityException
    //   164	173	290	java/lang/SecurityException
    //   352	360	290	java/lang/SecurityException
    //   368	377	290	java/lang/SecurityException
    //   49	59	448	java/lang/Throwable
    //   63	81	448	java/lang/Throwable
    //   94	104	448	java/lang/Throwable
    //   113	123	448	java/lang/Throwable
    //   127	132	448	java/lang/Throwable
    //   136	140	448	java/lang/Throwable
    //   317	327	448	java/lang/Throwable
    //   331	336	448	java/lang/Throwable
    //   340	344	448	java/lang/Throwable
    //   49	59	453	java/lang/SecurityException
    //   63	81	453	java/lang/SecurityException
    //   94	104	453	java/lang/SecurityException
    //   113	123	453	java/lang/SecurityException
    //   127	132	453	java/lang/SecurityException
    //   136	140	453	java/lang/SecurityException
    //   317	327	453	java/lang/SecurityException
    //   331	336	453	java/lang/SecurityException
    //   340	344	453	java/lang/SecurityException
    //   481	488	496	java/lang/Throwable
    //   561	568	496	java/lang/Throwable
    //   787	794	496	java/lang/Throwable
    //   27	40	508	finally
    //   27	40	515	java/lang/Throwable
    //   27	40	576	java/lang/SecurityException
    //   49	59	868	finally
    //   63	81	868	finally
    //   94	104	868	finally
    //   113	123	868	finally
    //   127	132	868	finally
    //   136	140	868	finally
    //   148	156	868	finally
    //   164	173	868	finally
    //   212	219	868	finally
    //   317	327	868	finally
    //   331	336	868	finally
    //   340	344	868	finally
    //   352	360	868	finally
    //   368	377	868	finally
    //   416	423	868	finally
    //   528	537	868	finally
    //   541	546	868	finally
    //   590	599	868	finally
    //   603	608	868	finally
    //   616	625	868	finally
    //   629	633	868	finally
    //   637	641	868	finally
    //   645	656	868	finally
    //   660	667	868	finally
    //   671	680	868	finally
    //   693	699	868	finally
    //   706	717	868	finally
    //   721	728	868	finally
    //   732	741	868	finally
    //   757	763	868	finally
    //   874	881	884	java/lang/Throwable
    //   810	818	929	java/lang/Throwable
    //   835	852	929	java/lang/Throwable
  }
  
  private static boolean c(Context paramContext)
  {
    return p.s(paramContext) == 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */