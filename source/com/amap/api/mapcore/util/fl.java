package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class fl
{
  public static int a = -1;
  public static String b = "";
  
  public static a a(Context paramContext, fv paramfv, String paramString, Map<String, String> paramMap)
  {
    return a(paramContext, paramfv, paramString, paramMap, false);
  }
  
  public static a a(Context paramContext, fv paramfv, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    return a(paramContext, paramfv, paramString, paramMap, paramBoolean, "DEF_ID");
  }
  
  /* Error */
  public static a a(Context paramContext, fv paramfv, String paramString1, Map<String, String> paramMap, boolean paramBoolean, String paramString2)
  {
    // Byte code:
    //   0: new 6	com/amap/api/mapcore/util/fl$a
    //   3: dup
    //   4: invokespecial 55	com/amap/api/mapcore/util/fl$a:<init>	()V
    //   7: astore 12
    //   9: aload 12
    //   11: new 57	org/json/JSONObject
    //   14: dup
    //   15: invokespecial 58	org/json/JSONObject:<init>	()V
    //   18: putfield 62	com/amap/api/mapcore/util/fl$a:w	Lorg/json/JSONObject;
    //   21: invokestatic 67	com/amap/api/mapcore/util/fr:a	()Lcom/amap/api/mapcore/util/fr;
    //   24: aload_0
    //   25: invokevirtual 70	com/amap/api/mapcore/util/fr:a	(Landroid/content/Context;)V
    //   28: aconst_null
    //   29: astore 11
    //   31: new 72	com/amap/api/mapcore/util/hx
    //   34: dup
    //   35: invokespecial 73	com/amap/api/mapcore/util/hx:<init>	()V
    //   38: astore 10
    //   40: new 75	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   47: astore 13
    //   49: aload_2
    //   50: astore 9
    //   52: aload 9
    //   54: astore 5
    //   56: aload 13
    //   58: aload_2
    //   59: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 9
    //   65: astore 5
    //   67: aload 13
    //   69: ldc 82
    //   71: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 9
    //   77: astore 5
    //   79: aload 13
    //   81: ldc 84
    //   83: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 9
    //   89: astore 5
    //   91: aload 13
    //   93: ldc 86
    //   95: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 9
    //   101: astore 5
    //   103: aload 13
    //   105: ldc 88
    //   107: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 9
    //   113: astore 5
    //   115: aload 13
    //   117: ldc 86
    //   119: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 9
    //   125: astore 5
    //   127: aload 13
    //   129: ldc 90
    //   131: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 9
    //   137: astore 5
    //   139: aload 13
    //   141: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_2
    //   145: new 26	com/amap/api/mapcore/util/fl$b
    //   148: dup
    //   149: aload_0
    //   150: aload_1
    //   151: aload_2
    //   152: aload_3
    //   153: invokespecial 97	com/amap/api/mapcore/util/fl$b:<init>	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;Ljava/lang/String;Ljava/util/Map;)V
    //   156: astore_3
    //   157: aload 10
    //   159: aload_3
    //   160: aload_3
    //   161: invokevirtual 100	com/amap/api/mapcore/util/fl$b:a	()Z
    //   164: invokevirtual 103	com/amap/api/mapcore/util/hx:a	(Lcom/amap/api/mapcore/util/ic;Z)Lcom/amap/api/mapcore/util/ie;
    //   167: astore 5
    //   169: aload 5
    //   171: ifnull +40 -> 211
    //   174: aload 5
    //   176: getfield 108	com/amap/api/mapcore/util/ie:a	[B
    //   179: astore_3
    //   180: goto +33 -> 213
    //   183: astore 9
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_2
    //   188: astore 10
    //   190: goto +218 -> 408
    //   193: astore 9
    //   195: aconst_null
    //   196: astore_3
    //   197: goto +250 -> 447
    //   200: astore 10
    //   202: aconst_null
    //   203: astore_3
    //   204: aload 5
    //   206: astore 9
    //   208: goto +264 -> 472
    //   211: aconst_null
    //   212: astore_3
    //   213: bipush 16
    //   215: newarray <illegal type>
    //   217: astore 10
    //   219: aload_3
    //   220: arraylength
    //   221: bipush 16
    //   223: isub
    //   224: newarray <illegal type>
    //   226: astore 9
    //   228: aload_3
    //   229: iconst_0
    //   230: aload 10
    //   232: iconst_0
    //   233: bipush 16
    //   235: invokestatic 114	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   238: aload_3
    //   239: bipush 16
    //   241: aload 9
    //   243: iconst_0
    //   244: aload_3
    //   245: arraylength
    //   246: bipush 16
    //   248: isub
    //   249: invokestatic 114	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   252: new 116	javax/crypto/spec/SecretKeySpec
    //   255: dup
    //   256: aload 10
    //   258: ldc 118
    //   260: invokespecial 121	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   263: astore 10
    //   265: ldc 123
    //   267: invokestatic 129	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   270: astore 13
    //   272: aload 13
    //   274: iconst_2
    //   275: aload 10
    //   277: new 131	javax/crypto/spec/IvParameterSpec
    //   280: dup
    //   281: invokestatic 136	com/amap/api/mapcore/util/fw:c	()[B
    //   284: invokespecial 139	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   287: invokevirtual 143	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   290: aload 13
    //   292: aload 9
    //   294: invokevirtual 147	javax/crypto/Cipher:doFinal	([B)[B
    //   297: invokestatic 150	com/amap/api/mapcore/util/fw:a	([B)Ljava/lang/String;
    //   300: astore 9
    //   302: goto +206 -> 508
    //   305: astore 9
    //   307: aload_2
    //   308: astore 10
    //   310: goto +98 -> 408
    //   313: astore 9
    //   315: goto +132 -> 447
    //   318: astore 10
    //   320: aload 5
    //   322: astore 9
    //   324: goto +148 -> 472
    //   327: astore 9
    //   329: aconst_null
    //   330: astore 5
    //   332: aload 5
    //   334: astore_3
    //   335: goto +112 -> 447
    //   338: goto +14 -> 352
    //   341: astore_3
    //   342: goto +26 -> 368
    //   345: astore_3
    //   346: aload 9
    //   348: astore_2
    //   349: goto +19 -> 368
    //   352: aload_2
    //   353: astore 9
    //   355: aload_2
    //   356: astore 5
    //   358: new 48	com/amap/api/mapcore/util/fj
    //   361: dup
    //   362: ldc -104
    //   364: invokespecial 155	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   367: athrow
    //   368: aload_2
    //   369: astore 9
    //   371: aload_2
    //   372: astore 5
    //   374: aload_3
    //   375: athrow
    //   376: astore_2
    //   377: goto +19 -> 396
    //   380: astore 9
    //   382: goto +57 -> 439
    //   385: astore 5
    //   387: goto +76 -> 463
    //   390: astore_3
    //   391: aload_2
    //   392: astore 9
    //   394: aload_3
    //   395: astore_2
    //   396: aconst_null
    //   397: astore_3
    //   398: aload_3
    //   399: astore 5
    //   401: aload 9
    //   403: astore 10
    //   405: aload_2
    //   406: astore 9
    //   408: aload 9
    //   410: ldc -99
    //   412: ldc -97
    //   414: invokestatic 164	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload_0
    //   418: aload_1
    //   419: aload 9
    //   421: invokestatic 167	com/amap/api/mapcore/util/fl:a	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;Ljava/lang/Throwable;)V
    //   424: aload 11
    //   426: astore 9
    //   428: aload 10
    //   430: astore_2
    //   431: goto +77 -> 508
    //   434: astore 9
    //   436: aload_2
    //   437: astore 5
    //   439: aconst_null
    //   440: astore_3
    //   441: aload 5
    //   443: astore_2
    //   444: aload_3
    //   445: astore 5
    //   447: aload_0
    //   448: aload_1
    //   449: aload 9
    //   451: invokestatic 167	com/amap/api/mapcore/util/fl:a	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;Ljava/lang/Throwable;)V
    //   454: aload 11
    //   456: astore 9
    //   458: goto +50 -> 508
    //   461: astore 5
    //   463: aconst_null
    //   464: astore_3
    //   465: aload_3
    //   466: astore 9
    //   468: aload 5
    //   470: astore 10
    //   472: aload 12
    //   474: aload 10
    //   476: invokevirtual 169	com/amap/api/mapcore/util/fj:a	()Ljava/lang/String;
    //   479: putfield 171	com/amap/api/mapcore/util/fl$a:a	Ljava/lang/String;
    //   482: aload_0
    //   483: aload_1
    //   484: aload 10
    //   486: invokevirtual 169	com/amap/api/mapcore/util/fj:a	()Ljava/lang/String;
    //   489: invokestatic 174	com/amap/api/mapcore/util/fl:a	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;Ljava/lang/String;)V
    //   492: aload_1
    //   493: ldc -80
    //   495: aload 10
    //   497: invokestatic 179	com/amap/api/mapcore/util/gk:a	(Lcom/amap/api/mapcore/util/fv;Ljava/lang/String;Lcom/amap/api/mapcore/util/fj;)V
    //   500: aload 9
    //   502: astore 5
    //   504: aload 11
    //   506: astore 9
    //   508: aload_3
    //   509: ifnonnull +6 -> 515
    //   512: aload 12
    //   514: areturn
    //   515: aload 9
    //   517: astore 10
    //   519: aload 9
    //   521: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   524: ifeq +9 -> 533
    //   527: aload_3
    //   528: invokestatic 150	com/amap/api/mapcore/util/fw:a	([B)Ljava/lang/String;
    //   531: astore 10
    //   533: aload 10
    //   535: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   538: ifeq +10 -> 548
    //   541: aload_0
    //   542: aload_1
    //   543: ldc -69
    //   545: invokestatic 174	com/amap/api/mapcore/util/fl:a	(Landroid/content/Context;Lcom/amap/api/mapcore/util/fv;Ljava/lang/String;)V
    //   548: new 57	org/json/JSONObject
    //   551: dup
    //   552: aload 10
    //   554: invokespecial 188	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   557: astore 10
    //   559: aload 10
    //   561: ldc -66
    //   563: invokevirtual 194	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   566: ifeq +808 -> 1374
    //   569: aload 10
    //   571: ldc -66
    //   573: invokevirtual 198	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   576: istore 6
    //   578: iload 6
    //   580: iconst_1
    //   581: if_icmpne +10 -> 591
    //   584: iconst_1
    //   585: putstatic 200	com/amap/api/mapcore/util/fl:a	I
    //   588: goto +120 -> 708
    //   591: iload 6
    //   593: ifne +115 -> 708
    //   596: ldc -54
    //   598: astore_3
    //   599: ldc -52
    //   601: astore 9
    //   603: aload 5
    //   605: ifnull +16 -> 621
    //   608: aload 5
    //   610: getfield 206	com/amap/api/mapcore/util/ie:c	Ljava/lang/String;
    //   613: astore_3
    //   614: aload 5
    //   616: getfield 208	com/amap/api/mapcore/util/ie:d	Ljava/lang/String;
    //   619: astore 9
    //   621: aload_0
    //   622: aload_3
    //   623: aload 9
    //   625: aload 10
    //   627: invokestatic 211	com/amap/api/mapcore/util/fw:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   630: iconst_0
    //   631: putstatic 200	com/amap/api/mapcore/util/fl:a	I
    //   634: aload 10
    //   636: ldc -43
    //   638: invokevirtual 194	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   641: ifeq +13 -> 654
    //   644: aload 10
    //   646: ldc -43
    //   648: invokevirtual 217	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   651: putstatic 219	com/amap/api/mapcore/util/fl:b	Ljava/lang/String;
    //   654: ldc 31
    //   656: astore 5
    //   658: aload 10
    //   660: ldc -35
    //   662: invokevirtual 194	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   665: ifeq +12 -> 677
    //   668: aload 10
    //   670: ldc -35
    //   672: invokevirtual 217	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   675: astore 5
    //   677: aload_1
    //   678: ldc -80
    //   680: getstatic 219	com/amap/api/mapcore/util/fl:b	Ljava/lang/String;
    //   683: aload 9
    //   685: aload_3
    //   686: aload 5
    //   688: invokestatic 224	com/amap/api/mapcore/util/gk:a	(Lcom/amap/api/mapcore/util/fv;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   691: getstatic 200	com/amap/api/mapcore/util/fl:a	I
    //   694: ifne +14 -> 708
    //   697: aload 12
    //   699: getstatic 219	com/amap/api/mapcore/util/fl:b	Ljava/lang/String;
    //   702: putfield 171	com/amap/api/mapcore/util/fl$a:a	Ljava/lang/String;
    //   705: aload 12
    //   707: areturn
    //   708: aload 10
    //   710: ldc -30
    //   712: invokevirtual 194	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   715: ifeq +27 -> 742
    //   718: aload 12
    //   720: aload 10
    //   722: ldc -30
    //   724: invokevirtual 198	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   727: putfield 228	com/amap/api/mapcore/util/fl$a:b	I
    //   730: goto +12 -> 742
    //   733: astore_1
    //   734: aload_1
    //   735: ldc -99
    //   737: ldc -97
    //   739: invokestatic 232	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   742: aload 10
    //   744: ldc -22
    //   746: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   749: ifeq +625 -> 1374
    //   752: new 9	com/amap/api/mapcore/util/fl$a$a
    //   755: dup
    //   756: invokespecial 238	com/amap/api/mapcore/util/fl$a$a:<init>	()V
    //   759: astore_3
    //   760: aload_3
    //   761: iconst_0
    //   762: putfield 241	com/amap/api/mapcore/util/fl$a$a:a	Z
    //   765: aload_3
    //   766: iconst_0
    //   767: putfield 243	com/amap/api/mapcore/util/fl$a$a:b	Z
    //   770: aload 12
    //   772: aload_3
    //   773: putfield 247	com/amap/api/mapcore/util/fl$a:x	Lcom/amap/api/mapcore/util/fl$a$a;
    //   776: aload 10
    //   778: ldc -22
    //   780: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   783: astore_1
    //   784: aload_2
    //   785: ldc 86
    //   787: invokevirtual 257	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   790: astore_2
    //   791: aload_2
    //   792: ifnull +73 -> 865
    //   795: aload_2
    //   796: arraylength
    //   797: ifle +68 -> 865
    //   800: aload_2
    //   801: arraylength
    //   802: istore 7
    //   804: iconst_0
    //   805: istore 6
    //   807: iload 6
    //   809: iload 7
    //   811: if_icmpge +54 -> 865
    //   814: aload_2
    //   815: iload 6
    //   817: aaload
    //   818: astore 5
    //   820: aload_1
    //   821: aload 5
    //   823: invokevirtual 194	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   826: ifeq +20 -> 846
    //   829: aload 12
    //   831: getfield 62	com/amap/api/mapcore/util/fl$a:w	Lorg/json/JSONObject;
    //   834: aload 5
    //   836: aload_1
    //   837: aload 5
    //   839: invokevirtual 261	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   842: invokevirtual 265	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   845: pop
    //   846: iload 6
    //   848: iconst_1
    //   849: iadd
    //   850: istore 6
    //   852: goto -45 -> 807
    //   855: astore_2
    //   856: aload_2
    //   857: ldc -99
    //   859: ldc_w 267
    //   862: invokestatic 232	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   865: aload_1
    //   866: ldc 88
    //   868: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   871: ifeq +25 -> 896
    //   874: aload 12
    //   876: aload_1
    //   877: ldc 88
    //   879: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   882: ldc_w 269
    //   885: invokevirtual 272	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: iconst_0
    //   889: invokestatic 275	com/amap/api/mapcore/util/fl:a	(Ljava/lang/String;Z)Z
    //   892: invokestatic 278	com/amap/api/mapcore/util/fl$a:a	(Lcom/amap/api/mapcore/util/fl$a;Z)Z
    //   895: pop
    //   896: aload_1
    //   897: ldc_w 280
    //   900: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   903: istore 8
    //   905: iload 8
    //   907: ifeq +61 -> 968
    //   910: aload_1
    //   911: ldc_w 280
    //   914: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   917: astore_2
    //   918: aload_3
    //   919: aload_2
    //   920: ldc_w 269
    //   923: invokevirtual 217	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   926: iconst_0
    //   927: invokestatic 275	com/amap/api/mapcore/util/fl:a	(Ljava/lang/String;Z)Z
    //   930: putfield 241	com/amap/api/mapcore/util/fl$a$a:a	Z
    //   933: aload_2
    //   934: ldc_w 282
    //   937: invokevirtual 194	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   940: ifeq +28 -> 968
    //   943: aload_3
    //   944: aload_2
    //   945: ldc_w 282
    //   948: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   951: putfield 284	com/amap/api/mapcore/util/fl$a$a:c	Lorg/json/JSONObject;
    //   954: goto +14 -> 968
    //   957: astore_2
    //   958: aload_2
    //   959: ldc_w 286
    //   962: ldc_w 288
    //   965: invokestatic 232	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   968: aload_1
    //   969: ldc_w 290
    //   972: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   975: ifeq +30 -> 1005
    //   978: aload_1
    //   979: ldc_w 290
    //   982: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   985: astore_2
    //   986: new 17	com/amap/api/mapcore/util/fl$a$d
    //   989: dup
    //   990: invokespecial 291	com/amap/api/mapcore/util/fl$a$d:<init>	()V
    //   993: astore_3
    //   994: aload_2
    //   995: aload_3
    //   996: invokestatic 294	com/amap/api/mapcore/util/fl:a	(Lorg/json/JSONObject;Lcom/amap/api/mapcore/util/fl$a$d;)V
    //   999: aload 12
    //   1001: aload_3
    //   1002: putfield 298	com/amap/api/mapcore/util/fl$a:y	Lcom/amap/api/mapcore/util/fl$a$d;
    //   1005: aload_1
    //   1006: ldc_w 300
    //   1009: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1012: ifeq +30 -> 1042
    //   1015: aload_1
    //   1016: ldc_w 300
    //   1019: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1022: astore_2
    //   1023: new 14	com/amap/api/mapcore/util/fl$a$c
    //   1026: dup
    //   1027: invokespecial 301	com/amap/api/mapcore/util/fl$a$c:<init>	()V
    //   1030: astore_3
    //   1031: aload_2
    //   1032: aload_3
    //   1033: invokestatic 304	com/amap/api/mapcore/util/fl:a	(Lorg/json/JSONObject;Lcom/amap/api/mapcore/util/fl$a$c;)V
    //   1036: aload 12
    //   1038: aload_3
    //   1039: putfield 308	com/amap/api/mapcore/util/fl$a:A	Lcom/amap/api/mapcore/util/fl$a$c;
    //   1042: aload_1
    //   1043: ldc_w 310
    //   1046: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1049: ifeq +30 -> 1079
    //   1052: aload_1
    //   1053: ldc_w 310
    //   1056: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1059: astore_2
    //   1060: new 14	com/amap/api/mapcore/util/fl$a$c
    //   1063: dup
    //   1064: invokespecial 301	com/amap/api/mapcore/util/fl$a$c:<init>	()V
    //   1067: astore_3
    //   1068: aload_2
    //   1069: aload_3
    //   1070: invokestatic 304	com/amap/api/mapcore/util/fl:a	(Lorg/json/JSONObject;Lcom/amap/api/mapcore/util/fl$a$c;)V
    //   1073: aload 12
    //   1075: aload_3
    //   1076: putfield 313	com/amap/api/mapcore/util/fl$a:B	Lcom/amap/api/mapcore/util/fl$a$c;
    //   1079: aload 12
    //   1081: aload_1
    //   1082: invokestatic 316	com/amap/api/mapcore/util/fl:a	(Lcom/amap/api/mapcore/util/fl$a;Lorg/json/JSONObject;)V
    //   1085: aload_1
    //   1086: ldc_w 318
    //   1089: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1092: ifeq +30 -> 1122
    //   1095: aload_1
    //   1096: ldc_w 318
    //   1099: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1102: astore_2
    //   1103: new 23	com/amap/api/mapcore/util/fl$a$f
    //   1106: dup
    //   1107: invokespecial 319	com/amap/api/mapcore/util/fl$a$f:<init>	()V
    //   1110: astore_3
    //   1111: aload_2
    //   1112: aload_3
    //   1113: invokestatic 322	com/amap/api/mapcore/util/fl:a	(Lorg/json/JSONObject;Lcom/amap/api/mapcore/util/fl$a$f;)V
    //   1116: aload 12
    //   1118: aload_3
    //   1119: putfield 326	com/amap/api/mapcore/util/fl$a:G	Lcom/amap/api/mapcore/util/fl$a$f;
    //   1122: aload_1
    //   1123: ldc_w 328
    //   1126: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1129: ifeq +30 -> 1159
    //   1132: aload_1
    //   1133: ldc_w 328
    //   1136: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1139: astore_2
    //   1140: new 20	com/amap/api/mapcore/util/fl$a$e
    //   1143: dup
    //   1144: invokespecial 329	com/amap/api/mapcore/util/fl$a$e:<init>	()V
    //   1147: astore_3
    //   1148: aload_2
    //   1149: aload_3
    //   1150: invokestatic 332	com/amap/api/mapcore/util/fl:a	(Lorg/json/JSONObject;Lcom/amap/api/mapcore/util/fl$a$e;)V
    //   1153: aload 12
    //   1155: aload_3
    //   1156: putfield 336	com/amap/api/mapcore/util/fl$a:z	Lcom/amap/api/mapcore/util/fl$a$e;
    //   1159: aload 12
    //   1161: aload_1
    //   1162: invokestatic 316	com/amap/api/mapcore/util/fl:a	(Lcom/amap/api/mapcore/util/fl$a;Lorg/json/JSONObject;)V
    //   1165: aload_1
    //   1166: ldc_w 338
    //   1169: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1172: ifeq +133 -> 1305
    //   1175: aload_0
    //   1176: invokestatic 343	com/amap/api/mapcore/util/fp:b	(Landroid/content/Context;)Ljava/lang/String;
    //   1179: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1182: ifeq +123 -> 1305
    //   1185: aload_1
    //   1186: ldc_w 338
    //   1189: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1192: astore_3
    //   1193: new 11	com/amap/api/mapcore/util/fl$a$b
    //   1196: dup
    //   1197: invokespecial 344	com/amap/api/mapcore/util/fl$a$b:<init>	()V
    //   1200: astore_2
    //   1201: aload_2
    //   1202: aload_3
    //   1203: ldc_w 269
    //   1206: invokevirtual 272	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1209: iconst_0
    //   1210: invokestatic 275	com/amap/api/mapcore/util/fl:a	(Ljava/lang/String;Z)Z
    //   1213: putfield 345	com/amap/api/mapcore/util/fl$a$b:a	Z
    //   1216: aload_2
    //   1217: aload_3
    //   1218: ldc_w 347
    //   1221: invokevirtual 272	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1224: putfield 348	com/amap/api/mapcore/util/fl$a$b:b	Ljava/lang/String;
    //   1227: aload_2
    //   1228: aload_3
    //   1229: ldc_w 350
    //   1232: invokevirtual 272	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1235: putfield 351	com/amap/api/mapcore/util/fl$a$b:c	Ljava/lang/String;
    //   1238: aload_2
    //   1239: getfield 345	com/amap/api/mapcore/util/fl$a$b:a	Z
    //   1242: ifeq +56 -> 1298
    //   1245: invokestatic 356	com/amap/api/mapcore/util/ge:a	()Lcom/amap/api/mapcore/util/fv;
    //   1248: astore_3
    //   1249: aload_3
    //   1250: ifnull +55 -> 1305
    //   1253: new 358	com/amap/api/mapcore/util/gv
    //   1256: dup
    //   1257: aload_2
    //   1258: getfield 348	com/amap/api/mapcore/util/fl$a$b:b	Ljava/lang/String;
    //   1261: aload_2
    //   1262: getfield 351	com/amap/api/mapcore/util/fl$a$b:c	Ljava/lang/String;
    //   1265: ldc 31
    //   1267: aload 12
    //   1269: invokestatic 361	com/amap/api/mapcore/util/fl$a:a	(Lcom/amap/api/mapcore/util/fl$a;)Z
    //   1272: invokespecial 364	com/amap/api/mapcore/util/gv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1275: astore_2
    //   1276: aload_2
    //   1277: iload 4
    //   1279: invokevirtual 367	com/amap/api/mapcore/util/gv:a	(Z)V
    //   1282: new 369	com/amap/api/mapcore/util/gu
    //   1285: dup
    //   1286: aload_0
    //   1287: aload_2
    //   1288: aload_3
    //   1289: invokespecial 372	com/amap/api/mapcore/util/gu:<init>	(Landroid/content/Context;Lcom/amap/api/mapcore/util/gv;Lcom/amap/api/mapcore/util/fv;)V
    //   1292: invokevirtual 374	com/amap/api/mapcore/util/gu:a	()V
    //   1295: goto +10 -> 1305
    //   1298: aload_0
    //   1299: ldc_w 376
    //   1302: invokestatic 381	com/amap/api/mapcore/util/ha:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   1305: aload_1
    //   1306: ldc 90
    //   1308: invokestatic 237	com/amap/api/mapcore/util/fw:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1311: ifeq +46 -> 1357
    //   1314: aload_1
    //   1315: ldc 90
    //   1317: invokevirtual 251	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1320: astore_2
    //   1321: aload_2
    //   1322: ldc_w 383
    //   1325: invokevirtual 272	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1328: iconst_0
    //   1329: invokestatic 275	com/amap/api/mapcore/util/fl:a	(Ljava/lang/String;Z)Z
    //   1332: istore 4
    //   1334: aload_2
    //   1335: ldc_w 385
    //   1338: invokevirtual 272	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1341: iconst_0
    //   1342: invokestatic 275	com/amap/api/mapcore/util/fl:a	(Ljava/lang/String;Z)Z
    //   1345: istore 8
    //   1347: iload 4
    //   1349: putstatic 387	com/amap/api/mapcore/util/ge:e	Z
    //   1352: iload 8
    //   1354: putstatic 389	com/amap/api/mapcore/util/ge:f	Z
    //   1357: aload_0
    //   1358: aload_1
    //   1359: invokestatic 392	com/amap/api/mapcore/util/fl:a	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   1362: aload 12
    //   1364: areturn
    //   1365: astore_0
    //   1366: aload_0
    //   1367: ldc -99
    //   1369: ldc -97
    //   1371: invokestatic 232	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1374: aload 12
    //   1376: areturn
    //   1377: astore_3
    //   1378: goto -1026 -> 352
    //   1381: astore_2
    //   1382: aload 9
    //   1384: astore_2
    //   1385: goto -1033 -> 352
    //   1388: astore_3
    //   1389: goto -1051 -> 338
    //   1392: astore_3
    //   1393: goto -1025 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1396	0	paramContext	Context
    //   0	1396	1	paramfv	fv
    //   0	1396	2	paramString1	String
    //   0	1396	3	paramMap	Map<String, String>
    //   0	1396	4	paramBoolean	boolean
    //   0	1396	5	paramString2	String
    //   576	275	6	i	int
    //   802	10	7	j	int
    //   903	450	8	bool	boolean
    //   50	86	9	str1	String
    //   183	1	9	localThrowable1	Throwable
    //   193	1	9	localIllegalBlockSizeException1	javax.crypto.IllegalBlockSizeException
    //   206	95	9	localObject1	Object
    //   305	1	9	localThrowable2	Throwable
    //   313	1	9	localIllegalBlockSizeException2	javax.crypto.IllegalBlockSizeException
    //   322	1	9	str2	String
    //   327	20	9	localIllegalBlockSizeException3	javax.crypto.IllegalBlockSizeException
    //   353	17	9	str3	String
    //   380	1	9	localIllegalBlockSizeException4	javax.crypto.IllegalBlockSizeException
    //   392	35	9	localObject2	Object
    //   434	16	9	localIllegalBlockSizeException5	javax.crypto.IllegalBlockSizeException
    //   456	927	9	localObject3	Object
    //   38	151	10	localObject4	Object
    //   200	1	10	localfj1	fj
    //   217	92	10	localObject5	Object
    //   318	1	10	localfj2	fj
    //   403	374	10	localObject6	Object
    //   29	476	11	localObject7	Object
    //   7	1368	12	locala	a
    //   47	244	13	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   174	180	183	java/lang/Throwable
    //   174	180	193	javax/crypto/IllegalBlockSizeException
    //   174	180	200	com/amap/api/mapcore/util/fj
    //   213	302	305	java/lang/Throwable
    //   213	302	313	javax/crypto/IllegalBlockSizeException
    //   213	302	318	com/amap/api/mapcore/util/fj
    //   145	169	327	javax/crypto/IllegalBlockSizeException
    //   145	169	341	com/amap/api/mapcore/util/fj
    //   56	63	345	com/amap/api/mapcore/util/fj
    //   67	75	345	com/amap/api/mapcore/util/fj
    //   79	87	345	com/amap/api/mapcore/util/fj
    //   91	99	345	com/amap/api/mapcore/util/fj
    //   103	111	345	com/amap/api/mapcore/util/fj
    //   115	123	345	com/amap/api/mapcore/util/fj
    //   127	135	345	com/amap/api/mapcore/util/fj
    //   139	145	345	com/amap/api/mapcore/util/fj
    //   358	368	376	java/lang/Throwable
    //   374	376	376	java/lang/Throwable
    //   56	63	380	javax/crypto/IllegalBlockSizeException
    //   67	75	380	javax/crypto/IllegalBlockSizeException
    //   79	87	380	javax/crypto/IllegalBlockSizeException
    //   91	99	380	javax/crypto/IllegalBlockSizeException
    //   103	111	380	javax/crypto/IllegalBlockSizeException
    //   115	123	380	javax/crypto/IllegalBlockSizeException
    //   127	135	380	javax/crypto/IllegalBlockSizeException
    //   139	145	380	javax/crypto/IllegalBlockSizeException
    //   358	368	380	javax/crypto/IllegalBlockSizeException
    //   374	376	380	javax/crypto/IllegalBlockSizeException
    //   358	368	385	com/amap/api/mapcore/util/fj
    //   374	376	385	com/amap/api/mapcore/util/fj
    //   31	40	390	java/lang/Throwable
    //   31	40	434	javax/crypto/IllegalBlockSizeException
    //   40	49	434	javax/crypto/IllegalBlockSizeException
    //   31	40	461	com/amap/api/mapcore/util/fj
    //   708	730	733	java/lang/Throwable
    //   784	791	855	java/lang/Throwable
    //   795	804	855	java/lang/Throwable
    //   820	846	855	java/lang/Throwable
    //   910	954	957	java/lang/Throwable
    //   548	578	1365	java/lang/Throwable
    //   584	588	1365	java/lang/Throwable
    //   608	621	1365	java/lang/Throwable
    //   621	654	1365	java/lang/Throwable
    //   658	677	1365	java/lang/Throwable
    //   677	705	1365	java/lang/Throwable
    //   734	742	1365	java/lang/Throwable
    //   742	784	1365	java/lang/Throwable
    //   856	865	1365	java/lang/Throwable
    //   865	896	1365	java/lang/Throwable
    //   896	905	1365	java/lang/Throwable
    //   958	968	1365	java/lang/Throwable
    //   968	1005	1365	java/lang/Throwable
    //   1005	1042	1365	java/lang/Throwable
    //   1042	1079	1365	java/lang/Throwable
    //   1079	1122	1365	java/lang/Throwable
    //   1122	1159	1365	java/lang/Throwable
    //   1159	1249	1365	java/lang/Throwable
    //   1253	1295	1365	java/lang/Throwable
    //   1298	1305	1365	java/lang/Throwable
    //   1305	1357	1365	java/lang/Throwable
    //   1357	1362	1365	java/lang/Throwable
    //   40	49	1377	java/lang/Throwable
    //   56	63	1381	java/lang/Throwable
    //   67	75	1381	java/lang/Throwable
    //   79	87	1381	java/lang/Throwable
    //   91	99	1381	java/lang/Throwable
    //   103	111	1381	java/lang/Throwable
    //   115	123	1381	java/lang/Throwable
    //   127	135	1381	java/lang/Throwable
    //   139	145	1381	java/lang/Throwable
    //   145	169	1388	java/lang/Throwable
    //   40	49	1392	com/amap/api/mapcore/util/fj
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return "";
    }
    String str2 = "";
    String str1 = str2;
    if (paramJSONObject.has(paramString))
    {
      str1 = str2;
      if (!paramJSONObject.getString(paramString).equals("[]")) {
        str1 = paramJSONObject.optString(paramString);
      }
    }
    return str1;
  }
  
  private static void a(Context paramContext, fv paramfv, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("amap_sdk_auth_fail", "1");
    localHashMap.put("amap_sdk_auth_fail_type", paramString);
    localHashMap.put("amap_sdk_name", paramfv.a());
    localHashMap.put("amap_sdk_version", paramfv.c());
    paramString = new JSONObject(localHashMap).toString();
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramfv = new in(paramContext, paramfv.a(), paramfv.c(), "O016");
      paramfv.a(paramString);
      io.a(paramfv, paramContext);
      return;
    }
    catch (fj paramContext) {}
  }
  
  private static void a(Context paramContext, fv paramfv, Throwable paramThrowable)
  {
    String str = "on exception";
    if (paramThrowable != null) {
      str = paramThrowable.getMessage();
    }
    a(paramContext, paramfv, str);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    fk.a(paramContext, paramString);
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("15K");
      boolean bool = a(paramJSONObject.optString("isTargetAble"), false);
      if (!a(paramJSONObject.optString("able"), false))
      {
        fr.a().b(paramContext);
        return;
      }
      fr.a().a(paramContext, bool);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void a(a parama, JSONObject paramJSONObject)
  {
    try
    {
      if (fw.a(paramJSONObject, "11B")) {
        parama.h = paramJSONObject.getJSONObject("11B");
      }
      if (fw.a(paramJSONObject, "11C")) {
        parama.k = paramJSONObject.getJSONObject("11C");
      }
      if (fw.a(paramJSONObject, "11I")) {
        parama.l = paramJSONObject.getJSONObject("11I");
      }
      if (fw.a(paramJSONObject, "11H")) {
        parama.m = paramJSONObject.getJSONObject("11H");
      }
      if (fw.a(paramJSONObject, "11E")) {
        parama.n = paramJSONObject.getJSONObject("11E");
      }
      if (fw.a(paramJSONObject, "11F")) {
        parama.o = paramJSONObject.getJSONObject("11F");
      }
      if (fw.a(paramJSONObject, "13A")) {
        parama.q = paramJSONObject.getJSONObject("13A");
      }
      if (fw.a(paramJSONObject, "13J")) {
        parama.i = paramJSONObject.getJSONObject("13J");
      }
      if (fw.a(paramJSONObject, "11G")) {
        parama.p = paramJSONObject.getJSONObject("11G");
      }
      if (fw.a(paramJSONObject, "006")) {
        parama.r = paramJSONObject.getJSONObject("006");
      }
      if (fw.a(paramJSONObject, "010")) {
        parama.s = paramJSONObject.getJSONObject("010");
      }
      JSONObject localJSONObject;
      fl.a.b localb;
      if (fw.a(paramJSONObject, "11Z"))
      {
        localJSONObject = paramJSONObject.getJSONObject("11Z");
        localb = new fl.a.b();
        a(localJSONObject, localb);
        parama.C = localb;
      }
      if (fw.a(paramJSONObject, "135")) {
        parama.j = paramJSONObject.getJSONObject("135");
      }
      if (fw.a(paramJSONObject, "13S")) {
        parama.g = paramJSONObject.getJSONObject("13S");
      }
      if (fw.a(paramJSONObject, "121"))
      {
        localJSONObject = paramJSONObject.getJSONObject("121");
        localb = new fl.a.b();
        a(localJSONObject, localb);
        parama.D = localb;
      }
      if (fw.a(paramJSONObject, "122"))
      {
        localJSONObject = paramJSONObject.getJSONObject("122");
        localb = new fl.a.b();
        a(localJSONObject, localb);
        parama.E = localb;
      }
      if (fw.a(paramJSONObject, "123"))
      {
        localJSONObject = paramJSONObject.getJSONObject("123");
        localb = new fl.a.b();
        a(localJSONObject, localb);
        parama.F = localb;
      }
      if (fw.a(paramJSONObject, "011")) {
        parama.c = paramJSONObject.getJSONObject("011");
      }
      if (fw.a(paramJSONObject, "012")) {
        parama.d = paramJSONObject.getJSONObject("012");
      }
      if (fw.a(paramJSONObject, "013")) {
        parama.e = paramJSONObject.getJSONObject("013");
      }
      if (fw.a(paramJSONObject, "014")) {
        parama.f = paramJSONObject.getJSONObject("014");
      }
      if (fw.a(paramJSONObject, "145")) {
        parama.t = paramJSONObject.getJSONObject("145");
      }
      if (fw.a(paramJSONObject, "14B")) {
        parama.u = paramJSONObject.getJSONObject("14B");
      }
      if (fw.a(paramJSONObject, "14D"))
      {
        parama.v = paramJSONObject.getJSONObject("14D");
        return;
      }
    }
    catch (Throwable parama)
    {
      gk.c(parama, "at", "pe");
    }
  }
  
  private static void a(JSONObject paramJSONObject, fl.a.b paramb)
  {
    if (paramb != null) {
      try
      {
        String str1 = a(paramJSONObject, "m");
        String str2 = a(paramJSONObject, "u");
        String str3 = a(paramJSONObject, "v");
        String str4 = a(paramJSONObject, "able");
        paramJSONObject = a(paramJSONObject, "on");
        paramb.c = str1;
        paramb.b = str2;
        paramb.d = str3;
        paramb.a = a(str4, false);
        paramb.e = a(paramJSONObject, true);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        gg.a(paramJSONObject, "at", "pe");
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, fl.a.c paramc)
  {
    if (paramJSONObject != null) {
      try
      {
        String str = a(paramJSONObject, "md5");
        paramJSONObject = a(paramJSONObject, "url");
        paramc.b = str;
        paramc.a = paramJSONObject;
        return;
      }
      catch (Throwable paramJSONObject)
      {
        gg.a(paramJSONObject, "at", "psc");
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, fl.a.d paramd)
  {
    if (paramJSONObject != null) {
      try
      {
        String str1 = a(paramJSONObject, "md5");
        String str2 = a(paramJSONObject, "url");
        paramJSONObject = a(paramJSONObject, "sdkversion");
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          if (TextUtils.isEmpty(paramJSONObject)) {
            return;
          }
          paramd.a = str2;
          paramd.b = str1;
          paramd.c = paramJSONObject;
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        gg.a(paramJSONObject, "at", "psu");
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, fl.a.e parame)
  {
    if (parame != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      parame.a = a(paramJSONObject.optString("able"), false);
      return;
    }
  }
  
  private static void a(JSONObject paramJSONObject, fl.a.f paramf)
  {
    if (paramf != null) {
      try
      {
        String str1 = a(paramJSONObject, "md5");
        String str2 = a(paramJSONObject, "md5info");
        String str3 = a(paramJSONObject, "url");
        String str4 = a(paramJSONObject, "able");
        String str5 = a(paramJSONObject, "on");
        paramJSONObject = a(paramJSONObject, "mobileable");
        paramf.e = str1;
        paramf.f = str2;
        paramf.d = str3;
        paramf.a = a(str4, false);
        paramf.b = a(str5, false);
        paramf.c = a(paramJSONObject, false);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        gg.a(paramJSONObject, "at", "pes");
      }
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramBoolean;
      }
      paramString = URLDecoder.decode(paramString).split("/");
      int i = paramString[(paramString.length - 1)].charAt(4);
      return i % 2 == 1;
    }
    catch (Throwable paramString) {}
    return paramBoolean;
  }
  
  public static class a
  {
    @Deprecated
    public c A;
    public c B;
    public b C;
    public b D;
    public b E;
    public b F;
    public f G;
    private boolean H;
    public String a;
    public int b = -1;
    @Deprecated
    public JSONObject c;
    @Deprecated
    public JSONObject d;
    @Deprecated
    public JSONObject e;
    @Deprecated
    public JSONObject f;
    @Deprecated
    public JSONObject g;
    @Deprecated
    public JSONObject h;
    @Deprecated
    public JSONObject i;
    @Deprecated
    public JSONObject j;
    @Deprecated
    public JSONObject k;
    @Deprecated
    public JSONObject l;
    @Deprecated
    public JSONObject m;
    @Deprecated
    public JSONObject n;
    @Deprecated
    public JSONObject o;
    @Deprecated
    public JSONObject p;
    @Deprecated
    public JSONObject q;
    @Deprecated
    public JSONObject r;
    @Deprecated
    public JSONObject s;
    @Deprecated
    public JSONObject t;
    @Deprecated
    public JSONObject u;
    @Deprecated
    public JSONObject v;
    public JSONObject w;
    public a x;
    public d y;
    public e z;
    
    public boolean a()
    {
      return this.H;
    }
    
    public static class a
    {
      public boolean a;
      public boolean b;
      public JSONObject c;
    }
    
    public static class b
    {
      public boolean a;
      public String b;
      public String c;
      public String d;
      public boolean e;
    }
    
    public static class c
    {
      public String a;
      public String b;
    }
    
    public static class d
    {
      public String a;
      public String b;
      public String c;
    }
    
    public static class e
    {
      public boolean a;
    }
    
    public static class f
    {
      public boolean a;
      public boolean b;
      public boolean c;
      public String d;
      public String e;
      public String f;
    }
  }
  
  static class b
    extends hy
  {
    private String f;
    private Map<String, String> g;
    private boolean h;
    
    b(Context paramContext, fv paramfv, String paramString, Map<String, String> paramMap)
    {
      super(paramfv);
      this.f = paramString;
      this.g = paramMap;
      boolean bool;
      if (Build.VERSION.SDK_INT != 19) {
        bool = true;
      } else {
        bool = false;
      }
      this.h = bool;
    }
    
    private Map<String, String> k()
    {
      Object localObject2 = fp.w(this.d);
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = fp.j(this.d);
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = fs.b(new StringBuilder((String)localObject1).reverse().toString());
      }
      localObject1 = new HashMap();
      ((Map)localObject1).put("authkey", this.f);
      ((Map)localObject1).put("plattype", "android");
      ((Map)localObject1).put("product", this.e.a());
      ((Map)localObject1).put("version", this.e.b());
      ((Map)localObject1).put("output", "json");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append("");
      ((Map)localObject1).put("androidversion", localStringBuilder.toString());
      ((Map)localObject1).put("deviceId", localObject2);
      ((Map)localObject1).put("manufacture", Build.MANUFACTURER);
      if ((this.g != null) && (!this.g.isEmpty())) {
        ((Map)localObject1).putAll(this.g);
      }
      ((Map)localObject1).put("abitype", fw.a(this.d));
      ((Map)localObject1).put("ext", this.e.e());
      return (Map<String, String>)localObject1;
    }
    
    public boolean a()
    {
      return this.h;
    }
    
    public byte[] d()
    {
      return null;
    }
    
    public byte[] e()
    {
      return fw.a(fw.b(k()));
    }
    
    protected String f()
    {
      return "3.0";
    }
    
    public Map<String, String> getRequestHead()
    {
      return null;
    }
    
    public String getURL()
    {
      if (this.h) {
        return "https://restapi.amap.com/v3/iasdkauth";
      }
      return "http://restapi.amap.com/v3/iasdkauth";
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */