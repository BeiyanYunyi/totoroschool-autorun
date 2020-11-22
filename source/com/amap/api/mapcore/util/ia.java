package com.amap.api.mapcore.util;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

public class ia
{
  private int a;
  private int b;
  private boolean c;
  private SSLContext d;
  private Proxy e;
  private volatile boolean f = false;
  private long g = -1L;
  private long h = 0L;
  private String i;
  private a j;
  private hx.a k;
  
  ia(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramProxy, paramBoolean, null);
  }
  
  ia(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean, hx.a parama)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = paramProxy;
    this.c = fr.a().b(paramBoolean);
    if (fr.c()) {
      this.c = false;
    }
    this.k = parama;
    b();
    if (this.c) {
      try
      {
        paramProxy = SSLContext.getInstance("TLS");
        paramProxy.init(null, null, null);
        this.d = paramProxy;
      }
      catch (Throwable paramProxy)
      {
        gg.a(paramProxy, "ht", "ne");
      }
    }
    this.j = new a(null);
  }
  
  /* Error */
  private ie a(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
    throws fj, IOException
  {
    // Byte code:
    //   0: ldc 106
    //   2: astore 5
    //   4: aconst_null
    //   5: astore 8
    //   7: aconst_null
    //   8: astore 9
    //   10: aconst_null
    //   11: astore 11
    //   13: aconst_null
    //   14: astore 10
    //   16: aload 5
    //   18: astore 6
    //   20: aload_1
    //   21: invokevirtual 111	java/net/HttpURLConnection:connect	()V
    //   24: aload 5
    //   26: astore 6
    //   28: aload_1
    //   29: invokevirtual 115	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   32: astore 12
    //   34: aload 5
    //   36: astore 6
    //   38: aload_1
    //   39: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   42: istore_3
    //   43: aload 5
    //   45: astore 4
    //   47: aload 12
    //   49: ifnull +65 -> 114
    //   52: aload 5
    //   54: astore 6
    //   56: aload 12
    //   58: ldc 121
    //   60: invokeinterface 127 2 0
    //   65: checkcast 129	java/util/List
    //   68: astore 7
    //   70: aload 5
    //   72: astore 4
    //   74: aload 7
    //   76: ifnull +38 -> 114
    //   79: aload 5
    //   81: astore 4
    //   83: aload 5
    //   85: astore 6
    //   87: aload 7
    //   89: invokeinterface 132 1 0
    //   94: ifle +20 -> 114
    //   97: aload 5
    //   99: astore 6
    //   101: aload 7
    //   103: iconst_0
    //   104: invokeinterface 135 2 0
    //   109: checkcast 137	java/lang/String
    //   112: astore 4
    //   114: iload_3
    //   115: sipush 200
    //   118: if_icmpne +427 -> 545
    //   121: aload 4
    //   123: astore 6
    //   125: new 139	java/io/ByteArrayOutputStream
    //   128: dup
    //   129: invokespecial 140	java/io/ByteArrayOutputStream:<init>	()V
    //   132: astore 5
    //   134: aload_1
    //   135: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   138: astore 6
    //   140: new 146	java/io/PushbackInputStream
    //   143: dup
    //   144: aload 6
    //   146: iconst_2
    //   147: invokespecial 149	java/io/PushbackInputStream:<init>	(Ljava/io/InputStream;I)V
    //   150: astore 7
    //   152: aload 10
    //   154: astore 8
    //   156: aload 11
    //   158: astore 9
    //   160: iconst_2
    //   161: newarray <illegal type>
    //   163: astore_1
    //   164: aload 10
    //   166: astore 8
    //   168: aload 11
    //   170: astore 9
    //   172: aload 7
    //   174: aload_1
    //   175: invokevirtual 153	java/io/PushbackInputStream:read	([B)I
    //   178: pop
    //   179: aload 10
    //   181: astore 8
    //   183: aload 11
    //   185: astore 9
    //   187: aload 7
    //   189: aload_1
    //   190: invokevirtual 157	java/io/PushbackInputStream:unread	([B)V
    //   193: aload_1
    //   194: iconst_0
    //   195: baload
    //   196: bipush 31
    //   198: if_icmpne +661 -> 859
    //   201: aload_1
    //   202: iconst_1
    //   203: baload
    //   204: bipush -117
    //   206: if_icmpne +653 -> 859
    //   209: iload_2
    //   210: ifne +649 -> 859
    //   213: aload 10
    //   215: astore 8
    //   217: aload 11
    //   219: astore 9
    //   221: new 159	java/util/zip/GZIPInputStream
    //   224: dup
    //   225: aload 7
    //   227: invokespecial 162	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   230: astore_1
    //   231: goto +3 -> 234
    //   234: aload_1
    //   235: astore 8
    //   237: aload_1
    //   238: astore 9
    //   240: sipush 1024
    //   243: newarray <illegal type>
    //   245: astore 10
    //   247: aload_1
    //   248: astore 8
    //   250: aload_1
    //   251: astore 9
    //   253: aload_1
    //   254: aload 10
    //   256: invokevirtual 165	java/io/InputStream:read	([B)I
    //   259: istore_3
    //   260: iload_3
    //   261: iconst_m1
    //   262: if_icmpeq +21 -> 283
    //   265: aload_1
    //   266: astore 8
    //   268: aload_1
    //   269: astore 9
    //   271: aload 5
    //   273: aload 10
    //   275: iconst_0
    //   276: iload_3
    //   277: invokevirtual 169	java/io/ByteArrayOutputStream:write	([BII)V
    //   280: goto -33 -> 247
    //   283: aload_1
    //   284: astore 8
    //   286: aload_1
    //   287: astore 9
    //   289: invokestatic 173	com/amap/api/mapcore/util/gk:c	()V
    //   292: aload_1
    //   293: astore 8
    //   295: aload_1
    //   296: astore 9
    //   298: new 175	com/amap/api/mapcore/util/ie
    //   301: dup
    //   302: invokespecial 176	com/amap/api/mapcore/util/ie:<init>	()V
    //   305: astore 10
    //   307: aload_1
    //   308: astore 8
    //   310: aload_1
    //   311: astore 9
    //   313: aload 10
    //   315: aload 5
    //   317: invokevirtual 180	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   320: putfield 183	com/amap/api/mapcore/util/ie:a	[B
    //   323: aload_1
    //   324: astore 8
    //   326: aload_1
    //   327: astore 9
    //   329: aload 10
    //   331: aload 12
    //   333: putfield 186	com/amap/api/mapcore/util/ie:b	Ljava/util/Map;
    //   336: aload_1
    //   337: astore 8
    //   339: aload_1
    //   340: astore 9
    //   342: aload 10
    //   344: aload_0
    //   345: getfield 188	com/amap/api/mapcore/util/ia:i	Ljava/lang/String;
    //   348: putfield 190	com/amap/api/mapcore/util/ie:c	Ljava/lang/String;
    //   351: aload_1
    //   352: astore 8
    //   354: aload_1
    //   355: astore 9
    //   357: aload 10
    //   359: aload 4
    //   361: putfield 192	com/amap/api/mapcore/util/ie:d	Ljava/lang/String;
    //   364: aload 5
    //   366: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   369: goto +14 -> 383
    //   372: astore 4
    //   374: aload 4
    //   376: ldc 87
    //   378: ldc -59
    //   380: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 6
    //   385: ifnull +22 -> 407
    //   388: aload 6
    //   390: invokevirtual 198	java/io/InputStream:close	()V
    //   393: goto +14 -> 407
    //   396: astore 4
    //   398: aload 4
    //   400: ldc 87
    //   402: ldc -59
    //   404: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload 7
    //   409: invokevirtual 199	java/io/PushbackInputStream:close	()V
    //   412: goto +14 -> 426
    //   415: astore 4
    //   417: aload 4
    //   419: ldc 87
    //   421: ldc -59
    //   423: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload_1
    //   427: invokevirtual 198	java/io/InputStream:close	()V
    //   430: aload 10
    //   432: areturn
    //   433: astore_1
    //   434: aload_1
    //   435: ldc 87
    //   437: ldc -59
    //   439: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload 10
    //   444: areturn
    //   445: astore 4
    //   447: aload 8
    //   449: astore_1
    //   450: goto +16 -> 466
    //   453: aload 9
    //   455: astore_1
    //   456: goto +70 -> 526
    //   459: astore 4
    //   461: aconst_null
    //   462: astore_1
    //   463: aload_1
    //   464: astore 7
    //   466: aload 6
    //   468: astore 8
    //   470: aload 4
    //   472: astore 6
    //   474: aload 5
    //   476: astore 4
    //   478: aload 7
    //   480: astore 5
    //   482: aload 8
    //   484: astore 7
    //   486: goto +262 -> 748
    //   489: goto +32 -> 521
    //   492: astore 8
    //   494: aconst_null
    //   495: astore 7
    //   497: aload 7
    //   499: astore_1
    //   500: aload_1
    //   501: astore 6
    //   503: aload 5
    //   505: astore 4
    //   507: aload 6
    //   509: astore 5
    //   511: aload 8
    //   513: astore 6
    //   515: goto +233 -> 748
    //   518: aconst_null
    //   519: astore 6
    //   521: aconst_null
    //   522: astore_1
    //   523: aconst_null
    //   524: astore 7
    //   526: aload 4
    //   528: astore 8
    //   530: aload 5
    //   532: astore 4
    //   534: aload 7
    //   536: astore 5
    //   538: aload 6
    //   540: astore 7
    //   542: goto +188 -> 730
    //   545: aload 4
    //   547: astore 6
    //   549: new 201	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   556: astore 5
    //   558: aload 4
    //   560: astore 6
    //   562: aload 5
    //   564: ldc -52
    //   566: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 4
    //   572: astore 6
    //   574: aload 5
    //   576: aload_1
    //   577: invokevirtual 212	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   580: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 4
    //   586: astore 6
    //   588: aload 5
    //   590: ldc -42
    //   592: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 4
    //   598: astore 6
    //   600: aload 5
    //   602: iload_3
    //   603: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 4
    //   609: astore 6
    //   611: aload 5
    //   613: ldc -37
    //   615: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 4
    //   621: astore 6
    //   623: aload 5
    //   625: aload 4
    //   627: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 4
    //   633: astore 6
    //   635: aload 5
    //   637: ldc -35
    //   639: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 4
    //   645: astore 6
    //   647: aload 5
    //   649: aload_0
    //   650: getfield 188	com/amap/api/mapcore/util/ia:i	Ljava/lang/String;
    //   653: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 4
    //   659: astore 6
    //   661: new 102	com/amap/api/mapcore/util/fj
    //   664: dup
    //   665: aload 5
    //   667: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: aload 4
    //   672: aload_0
    //   673: getfield 188	com/amap/api/mapcore/util/ia:i	Ljava/lang/String;
    //   676: invokespecial 227	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   679: astore_1
    //   680: aload 4
    //   682: astore 6
    //   684: aload_1
    //   685: iload_3
    //   686: invokevirtual 230	com/amap/api/mapcore/util/fj:a	(I)V
    //   689: aload 4
    //   691: astore 6
    //   693: aload_1
    //   694: athrow
    //   695: astore 6
    //   697: aconst_null
    //   698: astore 7
    //   700: aload 7
    //   702: astore_1
    //   703: aload_1
    //   704: astore 5
    //   706: aload 9
    //   708: astore 4
    //   710: goto +38 -> 748
    //   713: aconst_null
    //   714: astore 7
    //   716: aload 7
    //   718: astore_1
    //   719: aload_1
    //   720: astore 5
    //   722: aload 8
    //   724: astore 4
    //   726: aload 6
    //   728: astore 8
    //   730: new 102	com/amap/api/mapcore/util/fj
    //   733: dup
    //   734: ldc -24
    //   736: aload 8
    //   738: aload_0
    //   739: getfield 188	com/amap/api/mapcore/util/ia:i	Ljava/lang/String;
    //   742: invokespecial 227	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   745: athrow
    //   746: astore 6
    //   748: aload 4
    //   750: ifnull +22 -> 772
    //   753: aload 4
    //   755: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   758: goto +14 -> 772
    //   761: astore 4
    //   763: aload 4
    //   765: ldc 87
    //   767: ldc -59
    //   769: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload 7
    //   774: ifnull +22 -> 796
    //   777: aload 7
    //   779: invokevirtual 198	java/io/InputStream:close	()V
    //   782: goto +14 -> 796
    //   785: astore 4
    //   787: aload 4
    //   789: ldc 87
    //   791: ldc -59
    //   793: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   796: aload 5
    //   798: ifnull +22 -> 820
    //   801: aload 5
    //   803: invokevirtual 199	java/io/PushbackInputStream:close	()V
    //   806: goto +14 -> 820
    //   809: astore 4
    //   811: aload 4
    //   813: ldc 87
    //   815: ldc -59
    //   817: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   820: aload_1
    //   821: ifnull +19 -> 840
    //   824: aload_1
    //   825: invokevirtual 198	java/io/InputStream:close	()V
    //   828: goto +12 -> 840
    //   831: astore_1
    //   832: aload_1
    //   833: ldc 87
    //   835: ldc -59
    //   837: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload 6
    //   842: athrow
    //   843: astore_1
    //   844: goto -131 -> 713
    //   847: astore_1
    //   848: goto -330 -> 518
    //   851: astore_1
    //   852: goto -363 -> 489
    //   855: astore_1
    //   856: goto -403 -> 453
    //   859: aload 7
    //   861: astore_1
    //   862: goto -628 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	this	ia
    //   0	865	1	paramHttpURLConnection	HttpURLConnection
    //   0	865	2	paramBoolean	boolean
    //   42	644	3	m	int
    //   45	315	4	localObject1	Object
    //   372	3	4	localThrowable1	Throwable
    //   396	3	4	localThrowable2	Throwable
    //   415	3	4	localThrowable3	Throwable
    //   445	1	4	localObject2	Object
    //   459	12	4	localObject3	Object
    //   476	278	4	localObject4	Object
    //   761	3	4	localThrowable4	Throwable
    //   785	3	4	localThrowable5	Throwable
    //   809	3	4	localThrowable6	Throwable
    //   2	800	5	localObject5	Object
    //   18	674	6	localObject6	Object
    //   695	32	6	localObject7	Object
    //   746	95	6	localObject8	Object
    //   68	792	7	localObject9	Object
    //   5	478	8	localObject10	Object
    //   492	20	8	localObject11	Object
    //   528	209	8	localObject12	Object
    //   8	699	9	localObject13	Object
    //   14	429	10	localObject14	Object
    //   11	207	11	localObject15	Object
    //   32	300	12	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   364	369	372	java/lang/Throwable
    //   388	393	396	java/lang/Throwable
    //   407	412	415	java/lang/Throwable
    //   426	430	433	java/lang/Throwable
    //   160	164	445	finally
    //   172	179	445	finally
    //   187	193	445	finally
    //   221	231	445	finally
    //   240	247	445	finally
    //   253	260	445	finally
    //   271	280	445	finally
    //   289	292	445	finally
    //   298	307	445	finally
    //   313	323	445	finally
    //   329	336	445	finally
    //   342	351	445	finally
    //   357	364	445	finally
    //   140	152	459	finally
    //   134	140	492	finally
    //   20	24	695	finally
    //   28	34	695	finally
    //   38	43	695	finally
    //   56	70	695	finally
    //   87	97	695	finally
    //   101	114	695	finally
    //   125	134	695	finally
    //   549	558	695	finally
    //   562	570	695	finally
    //   574	584	695	finally
    //   588	596	695	finally
    //   600	607	695	finally
    //   611	619	695	finally
    //   623	631	695	finally
    //   635	643	695	finally
    //   647	657	695	finally
    //   661	680	695	finally
    //   684	689	695	finally
    //   693	695	695	finally
    //   730	746	746	finally
    //   753	758	761	java/lang/Throwable
    //   777	782	785	java/lang/Throwable
    //   801	806	809	java/lang/Throwable
    //   824	828	831	java/lang/Throwable
    //   20	24	843	java/io/IOException
    //   28	34	843	java/io/IOException
    //   38	43	843	java/io/IOException
    //   56	70	843	java/io/IOException
    //   87	97	843	java/io/IOException
    //   101	114	843	java/io/IOException
    //   125	134	843	java/io/IOException
    //   549	558	843	java/io/IOException
    //   562	570	843	java/io/IOException
    //   574	584	843	java/io/IOException
    //   588	596	843	java/io/IOException
    //   600	607	843	java/io/IOException
    //   611	619	843	java/io/IOException
    //   623	631	843	java/io/IOException
    //   635	643	843	java/io/IOException
    //   647	657	843	java/io/IOException
    //   661	680	843	java/io/IOException
    //   684	689	843	java/io/IOException
    //   693	695	843	java/io/IOException
    //   134	140	847	java/io/IOException
    //   140	152	851	java/io/IOException
    //   160	164	855	java/io/IOException
    //   172	179	855	java/io/IOException
    //   187	193	855	java/io/IOException
    //   221	231	855	java/io/IOException
    //   240	247	855	java/io/IOException
    //   253	260	855	java/io/IOException
    //   271	280	855	java/io/IOException
    //   289	292	855	java/io/IOException
    //   298	307	855	java/io/IOException
    //   313	323	855	java/io/IOException
    //   329	336	855	java/io/IOException
    //   342	351	855	java/io/IOException
    //   357	364	855	java/io/IOException
  }
  
  private String a(int paramInt, String paramString, Map<String, String> paramMap)
  {
    String str = "";
    if (paramInt == 1) {
      str = hx.b;
    }
    if (TextUtils.isEmpty(str)) {
      return paramString;
    }
    Object localObject = Uri.parse(paramString);
    paramString = ((Uri)localObject).getHost();
    localObject = ((Uri)localObject).buildUpon().encodedAuthority(str).build().toString();
    if (paramMap != null) {
      paramMap.put("targetHost", paramString);
    }
    if (this.c) {
      this.j.b(str);
    }
    return (String)localObject;
  }
  
  private String a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {
      return "";
    }
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
      if (paramHttpURLConnection == null) {
        return "";
      }
      paramHttpURLConnection = (List)paramHttpURLConnection.get("gsid");
      if ((paramHttpURLConnection != null) && (paramHttpURLConnection.size() > 0))
      {
        paramHttpURLConnection = (String)paramHttpURLConnection.get(0);
        return paramHttpURLConnection;
      }
      return "";
    }
    catch (Throwable paramHttpURLConnection)
    {
      for (;;) {}
    }
    return "";
  }
  
  static String a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        String str2 = (String)paramMap.getKey();
        String str1 = (String)paramMap.getValue();
        paramMap = str1;
        if (str1 == null) {
          paramMap = "";
        }
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(URLEncoder.encode(str2));
        localStringBuilder.append("=");
        localStringBuilder.append(URLEncoder.encode(paramMap));
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private void a(Map<String, String> paramMap, HttpURLConnection paramHttpURLConnection)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramHttpURLConnection.addRequestProperty(str, (String)paramMap.get(str));
      }
    }
    try
    {
      paramHttpURLConnection.addRequestProperty("csid", this.i);
    }
    catch (Throwable paramMap)
    {
      gg.a(paramMap, "ht", "adh");
    }
    paramHttpURLConnection.setConnectTimeout(this.a);
    paramHttpURLConnection.setReadTimeout(this.b);
  }
  
  private void b()
  {
    try
    {
      this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
      return;
    }
    catch (Throwable localThrowable)
    {
      gg.a(localThrowable, "ht", "ic");
    }
  }
  
  /* Error */
  ie a(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte, boolean paramBoolean2)
    throws fj
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 13
    //   18: aconst_null
    //   19: astore 14
    //   21: aconst_null
    //   22: astore 15
    //   24: aconst_null
    //   25: astore 16
    //   27: aconst_null
    //   28: astore 7
    //   30: aload_0
    //   31: aload_1
    //   32: iload_2
    //   33: aload_3
    //   34: aload 4
    //   36: iconst_1
    //   37: invokevirtual 375	com/amap/api/mapcore/util/ia:a	(Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   40: astore_1
    //   41: aload 5
    //   43: ifnull +34 -> 77
    //   46: aload 5
    //   48: arraylength
    //   49: ifle +28 -> 77
    //   52: new 377	java/io/DataOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokevirtual 381	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   60: invokespecial 384	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore_3
    //   64: aload_3
    //   65: aload 5
    //   67: invokevirtual 386	java/io/DataOutputStream:write	([B)V
    //   70: aload_3
    //   71: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   74: goto +3 -> 77
    //   77: aload_0
    //   78: aload_1
    //   79: iload 6
    //   81: invokespecial 389	com/amap/api/mapcore/util/ia:a	(Ljava/net/HttpURLConnection;Z)Lcom/amap/api/mapcore/util/ie;
    //   84: astore_3
    //   85: aload_1
    //   86: ifnull +19 -> 105
    //   89: aload_1
    //   90: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   93: aload_3
    //   94: areturn
    //   95: astore_1
    //   96: aload_1
    //   97: ldc 87
    //   99: ldc_w 394
    //   102: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_3
    //   106: areturn
    //   107: astore_1
    //   108: goto +186 -> 294
    //   111: astore_3
    //   112: aload 8
    //   114: astore_1
    //   115: aload_1
    //   116: astore 7
    //   118: aload_3
    //   119: ldc 87
    //   121: ldc_w 394
    //   124: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: astore 7
    //   130: new 102	com/amap/api/mapcore/util/fj
    //   133: dup
    //   134: ldc_w 396
    //   137: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   140: athrow
    //   141: aload_1
    //   142: astore 7
    //   144: aload_3
    //   145: ldc 87
    //   147: ldc_w 394
    //   150: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: astore 7
    //   156: aload_3
    //   157: athrow
    //   158: aload_1
    //   159: astore 7
    //   161: aload_3
    //   162: invokevirtual 401	java/io/IOException:printStackTrace	()V
    //   165: aload_1
    //   166: astore 7
    //   168: new 102	com/amap/api/mapcore/util/fj
    //   171: dup
    //   172: ldc -24
    //   174: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   177: athrow
    //   178: new 102	com/amap/api/mapcore/util/fj
    //   181: dup
    //   182: ldc_w 396
    //   185: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   188: athrow
    //   189: aload_1
    //   190: astore 7
    //   192: aload_3
    //   193: invokevirtual 402	java/net/SocketTimeoutException:printStackTrace	()V
    //   196: aload_1
    //   197: astore 7
    //   199: new 102	com/amap/api/mapcore/util/fj
    //   202: dup
    //   203: ldc_w 404
    //   206: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   209: athrow
    //   210: aload_1
    //   211: astore 7
    //   213: aload_3
    //   214: invokevirtual 405	java/net/SocketException:printStackTrace	()V
    //   217: aload_1
    //   218: astore 7
    //   220: new 102	com/amap/api/mapcore/util/fj
    //   223: dup
    //   224: ldc_w 407
    //   227: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   230: athrow
    //   231: aload_1
    //   232: astore 7
    //   234: aload_3
    //   235: invokevirtual 408	java/net/UnknownHostException:printStackTrace	()V
    //   238: aload_1
    //   239: astore 7
    //   241: new 102	com/amap/api/mapcore/util/fj
    //   244: dup
    //   245: ldc_w 410
    //   248: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   251: athrow
    //   252: aload_1
    //   253: astore 7
    //   255: aload_3
    //   256: invokevirtual 411	java/net/MalformedURLException:printStackTrace	()V
    //   259: aload_1
    //   260: astore 7
    //   262: new 102	com/amap/api/mapcore/util/fj
    //   265: dup
    //   266: ldc_w 413
    //   269: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   272: athrow
    //   273: aload_1
    //   274: astore 7
    //   276: aload_3
    //   277: invokevirtual 414	java/net/ConnectException:printStackTrace	()V
    //   280: aload_1
    //   281: astore 7
    //   283: new 102	com/amap/api/mapcore/util/fj
    //   286: dup
    //   287: ldc_w 416
    //   290: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   293: athrow
    //   294: aload 7
    //   296: ifnull +21 -> 317
    //   299: aload 7
    //   301: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   304: goto +13 -> 317
    //   307: astore_3
    //   308: aload_3
    //   309: ldc 87
    //   311: ldc_w 394
    //   314: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_1
    //   318: athrow
    //   319: astore_1
    //   320: aload 11
    //   322: astore 7
    //   324: goto -146 -> 178
    //   327: astore_3
    //   328: goto +24 -> 352
    //   331: astore_3
    //   332: aload_1
    //   333: astore 7
    //   335: aload_3
    //   336: astore_1
    //   337: goto -43 -> 294
    //   340: astore_3
    //   341: goto -226 -> 115
    //   344: astore_3
    //   345: goto -204 -> 141
    //   348: astore_3
    //   349: goto -191 -> 158
    //   352: aload_1
    //   353: astore 7
    //   355: goto -177 -> 178
    //   358: astore_3
    //   359: goto -170 -> 189
    //   362: astore_3
    //   363: goto -153 -> 210
    //   366: astore_3
    //   367: goto -136 -> 231
    //   370: astore_3
    //   371: goto -119 -> 252
    //   374: astore_3
    //   375: goto -102 -> 273
    //   378: astore_3
    //   379: aload 9
    //   381: astore_1
    //   382: goto -241 -> 141
    //   385: astore_3
    //   386: aload 10
    //   388: astore_1
    //   389: goto -231 -> 158
    //   392: astore_3
    //   393: aload 12
    //   395: astore_1
    //   396: goto -207 -> 189
    //   399: astore_3
    //   400: aload 13
    //   402: astore_1
    //   403: goto -193 -> 210
    //   406: astore_3
    //   407: aload 14
    //   409: astore_1
    //   410: goto -179 -> 231
    //   413: astore_3
    //   414: aload 15
    //   416: astore_1
    //   417: goto -165 -> 252
    //   420: astore_3
    //   421: aload 16
    //   423: astore_1
    //   424: goto -151 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	ia
    //   0	427	1	paramString1	String
    //   0	427	2	paramBoolean1	boolean
    //   0	427	3	paramString2	String
    //   0	427	4	paramMap	Map<String, String>
    //   0	427	5	paramArrayOfByte	byte[]
    //   0	427	6	paramBoolean2	boolean
    //   28	326	7	localObject1	Object
    //   1	112	8	localObject2	Object
    //   4	376	9	localObject3	Object
    //   7	380	10	localObject4	Object
    //   10	311	11	localObject5	Object
    //   13	381	12	localObject6	Object
    //   16	385	13	localObject7	Object
    //   19	389	14	localObject8	Object
    //   22	393	15	localObject9	Object
    //   25	397	16	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/lang/Throwable
    //   30	41	107	finally
    //   118	127	107	finally
    //   130	141	107	finally
    //   144	153	107	finally
    //   156	158	107	finally
    //   161	165	107	finally
    //   168	178	107	finally
    //   178	189	107	finally
    //   192	196	107	finally
    //   199	210	107	finally
    //   213	217	107	finally
    //   220	231	107	finally
    //   234	238	107	finally
    //   241	252	107	finally
    //   255	259	107	finally
    //   262	273	107	finally
    //   276	280	107	finally
    //   283	294	107	finally
    //   30	41	111	java/lang/Throwable
    //   299	304	307	java/lang/Throwable
    //   30	41	319	java/io/InterruptedIOException
    //   46	74	327	java/io/InterruptedIOException
    //   77	85	327	java/io/InterruptedIOException
    //   46	74	331	finally
    //   77	85	331	finally
    //   46	74	340	java/lang/Throwable
    //   77	85	340	java/lang/Throwable
    //   46	74	344	com/amap/api/mapcore/util/fj
    //   77	85	344	com/amap/api/mapcore/util/fj
    //   46	74	348	java/io/IOException
    //   77	85	348	java/io/IOException
    //   46	74	358	java/net/SocketTimeoutException
    //   77	85	358	java/net/SocketTimeoutException
    //   46	74	362	java/net/SocketException
    //   77	85	362	java/net/SocketException
    //   46	74	366	java/net/UnknownHostException
    //   77	85	366	java/net/UnknownHostException
    //   46	74	370	java/net/MalformedURLException
    //   77	85	370	java/net/MalformedURLException
    //   46	74	374	java/net/ConnectException
    //   77	85	374	java/net/ConnectException
    //   30	41	378	com/amap/api/mapcore/util/fj
    //   30	41	385	java/io/IOException
    //   30	41	392	java/net/SocketTimeoutException
    //   30	41	399	java/net/SocketException
    //   30	41	406	java/net/UnknownHostException
    //   30	41	413	java/net/MalformedURLException
    //   30	41	420	java/net/ConnectException
  }
  
  HttpURLConnection a(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap, boolean paramBoolean2)
    throws IOException
  {
    fp.b();
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    Object localObject2 = this.j.a();
    paramMap = (Map<String, String>)localObject2;
    if (paramBoolean1)
    {
      paramMap = (Map<String, String>)localObject2;
      if (!TextUtils.isEmpty(paramString2)) {
        paramMap = this.j.a(paramString2);
      }
    }
    paramString2 = a(hx.a, paramString1, (Map)localObject1);
    paramString1 = paramString2;
    if (this.c) {
      paramString1 = fr.a(paramString2);
    }
    localObject2 = new URL(paramString1);
    if (this.k != null) {
      paramString1 = this.k.a(this.e, (URL)localObject2);
    } else {
      paramString1 = null;
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      if (this.e != null) {
        paramString2 = ((URL)localObject2).openConnection(this.e);
      } else {
        paramString2 = ((URL)localObject2).openConnection();
      }
    }
    if (this.c)
    {
      paramString1 = (HttpsURLConnection)paramString2;
      paramString2 = (HttpsURLConnection)paramString1;
      paramString2.setSSLSocketFactory(this.d.getSocketFactory());
      paramString2.setHostnameVerifier(paramMap);
    }
    else
    {
      paramString1 = (HttpURLConnection)paramString2;
    }
    if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT > 13)) {
      paramString1.setRequestProperty("Connection", "close");
    }
    a((Map)localObject1, paramString1);
    if (paramBoolean2)
    {
      paramString1.setRequestMethod("POST");
      paramString1.setUseCaches(false);
      paramString1.setDoInput(true);
      paramString1.setDoOutput(true);
      return paramString1;
    }
    paramString1.setRequestMethod("GET");
    paramString1.setDoInput(true);
    return paramString1;
  }
  
  /* Error */
  Map<String, String> a(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean2)
    throws fj
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 13
    //   15: aconst_null
    //   16: astore 14
    //   18: aconst_null
    //   19: astore 15
    //   21: aconst_null
    //   22: astore 16
    //   24: aconst_null
    //   25: astore 17
    //   27: aconst_null
    //   28: astore 18
    //   30: aload 18
    //   32: astore 8
    //   34: aload 5
    //   36: invokestatic 500	com/amap/api/mapcore/util/ia:a	(Ljava/util/Map;)Ljava/lang/String;
    //   39: astore 5
    //   41: aload 18
    //   43: astore 8
    //   45: new 502	java/lang/StringBuffer
    //   48: dup
    //   49: invokespecial 503	java/lang/StringBuffer:<init>	()V
    //   52: astore 19
    //   54: aload 18
    //   56: astore 8
    //   58: aload 19
    //   60: aload_1
    //   61: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: aload 5
    //   67: ifnull +28 -> 95
    //   70: aload 18
    //   72: astore 8
    //   74: aload 19
    //   76: ldc_w 508
    //   79: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: aload 18
    //   85: astore 8
    //   87: aload 19
    //   89: aload 5
    //   91: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   94: pop
    //   95: aload 18
    //   97: astore 8
    //   99: aload_0
    //   100: aload 19
    //   102: invokevirtual 509	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   105: iload_2
    //   106: aload_3
    //   107: aload 4
    //   109: iconst_0
    //   110: invokevirtual 375	com/amap/api/mapcore/util/ia:a	(Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   118: sipush 400
    //   121: if_icmpge +91 -> 212
    //   124: new 422	java/util/HashMap
    //   127: dup
    //   128: invokespecial 423	java/util/HashMap:<init>	()V
    //   131: astore_3
    //   132: iconst_0
    //   133: istore 7
    //   135: iload 7
    //   137: bipush 50
    //   139: if_icmpge +50 -> 189
    //   142: aload_1
    //   143: iload 7
    //   145: invokevirtual 513	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   148: astore 4
    //   150: aload 4
    //   152: ifnonnull +6 -> 158
    //   155: goto +34 -> 189
    //   158: aload_1
    //   159: aload 4
    //   161: invokevirtual 516	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore 5
    //   166: aload_3
    //   167: aload 4
    //   169: invokevirtual 357	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   172: aload 5
    //   174: invokeinterface 274 3 0
    //   179: pop
    //   180: iload 7
    //   182: iconst_1
    //   183: iadd
    //   184: istore 7
    //   186: goto -51 -> 135
    //   189: aload_1
    //   190: ifnull +20 -> 210
    //   193: aload_1
    //   194: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   197: aload_3
    //   198: areturn
    //   199: astore_1
    //   200: aload_1
    //   201: ldc_w 518
    //   204: ldc_w 520
    //   207: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_3
    //   211: areturn
    //   212: new 102	com/amap/api/mapcore/util/fj
    //   215: dup
    //   216: ldc_w 522
    //   219: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   222: athrow
    //   223: astore 4
    //   225: aload_1
    //   226: astore_3
    //   227: aload 4
    //   229: astore_1
    //   230: goto +168 -> 398
    //   233: astore_3
    //   234: goto +65 -> 299
    //   237: astore_3
    //   238: aload_1
    //   239: astore 8
    //   241: aload_3
    //   242: astore_1
    //   243: goto +77 -> 320
    //   246: aload_1
    //   247: astore 8
    //   249: goto +73 -> 322
    //   252: aload_1
    //   253: astore 8
    //   255: goto +77 -> 332
    //   258: aload_1
    //   259: astore 8
    //   261: goto +82 -> 343
    //   264: aload_1
    //   265: astore 8
    //   267: goto +87 -> 354
    //   270: aload_1
    //   271: astore 8
    //   273: goto +92 -> 365
    //   276: aload_1
    //   277: astore 8
    //   279: goto +97 -> 376
    //   282: aload_1
    //   283: astore 8
    //   285: goto +102 -> 387
    //   288: astore_1
    //   289: aload 8
    //   291: astore_3
    //   292: goto +106 -> 398
    //   295: astore_3
    //   296: aload 10
    //   298: astore_1
    //   299: aload_1
    //   300: astore 8
    //   302: aload_3
    //   303: invokevirtual 523	java/lang/Throwable:printStackTrace	()V
    //   306: aload_1
    //   307: astore 8
    //   309: new 102	com/amap/api/mapcore/util/fj
    //   312: dup
    //   313: ldc_w 396
    //   316: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   319: athrow
    //   320: aload_1
    //   321: athrow
    //   322: new 102	com/amap/api/mapcore/util/fj
    //   325: dup
    //   326: ldc -24
    //   328: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   331: athrow
    //   332: new 102	com/amap/api/mapcore/util/fj
    //   335: dup
    //   336: ldc_w 396
    //   339: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   342: athrow
    //   343: new 102	com/amap/api/mapcore/util/fj
    //   346: dup
    //   347: ldc_w 404
    //   350: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   353: athrow
    //   354: new 102	com/amap/api/mapcore/util/fj
    //   357: dup
    //   358: ldc_w 407
    //   361: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   364: athrow
    //   365: new 102	com/amap/api/mapcore/util/fj
    //   368: dup
    //   369: ldc_w 410
    //   372: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   375: athrow
    //   376: new 102	com/amap/api/mapcore/util/fj
    //   379: dup
    //   380: ldc_w 413
    //   383: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   386: athrow
    //   387: new 102	com/amap/api/mapcore/util/fj
    //   390: dup
    //   391: ldc_w 416
    //   394: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   397: athrow
    //   398: aload_3
    //   399: ifnull +21 -> 420
    //   402: aload_3
    //   403: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   406: goto +14 -> 420
    //   409: astore_3
    //   410: aload_3
    //   411: ldc_w 518
    //   414: ldc_w 520
    //   417: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload_1
    //   421: athrow
    //   422: astore_1
    //   423: aload 17
    //   425: astore 8
    //   427: goto -40 -> 387
    //   430: astore_1
    //   431: aload 16
    //   433: astore 8
    //   435: goto -59 -> 376
    //   438: astore_1
    //   439: aload 15
    //   441: astore 8
    //   443: goto -78 -> 365
    //   446: astore_1
    //   447: aload 14
    //   449: astore 8
    //   451: goto -97 -> 354
    //   454: astore_1
    //   455: aload 13
    //   457: astore 8
    //   459: goto -116 -> 343
    //   462: astore_1
    //   463: aload 12
    //   465: astore 8
    //   467: goto -135 -> 332
    //   470: astore_1
    //   471: aload 11
    //   473: astore 8
    //   475: goto -153 -> 322
    //   478: astore_3
    //   479: goto -197 -> 282
    //   482: astore_3
    //   483: goto -207 -> 276
    //   486: astore_3
    //   487: goto -217 -> 270
    //   490: astore_3
    //   491: goto -227 -> 264
    //   494: astore_3
    //   495: goto -237 -> 258
    //   498: astore_3
    //   499: goto -247 -> 252
    //   502: astore_3
    //   503: goto -257 -> 246
    //   506: astore_1
    //   507: aload 9
    //   509: astore 8
    //   511: goto -191 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	ia
    //   0	514	1	paramString1	String
    //   0	514	2	paramBoolean1	boolean
    //   0	514	3	paramString2	String
    //   0	514	4	paramMap1	Map<String, String>
    //   0	514	5	paramMap2	Map<String, String>
    //   0	514	6	paramBoolean2	boolean
    //   133	52	7	m	int
    //   32	478	8	localObject1	Object
    //   4	504	9	localObject2	Object
    //   1	296	10	localObject3	Object
    //   7	465	11	localObject4	Object
    //   10	454	12	localObject5	Object
    //   13	443	13	localObject6	Object
    //   16	432	14	localObject7	Object
    //   19	421	15	localObject8	Object
    //   22	410	16	localObject9	Object
    //   25	399	17	localObject10	Object
    //   28	68	18	localObject11	Object
    //   52	49	19	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   193	197	199	java/lang/Throwable
    //   114	132	223	finally
    //   142	150	223	finally
    //   158	180	223	finally
    //   212	223	223	finally
    //   114	132	233	java/lang/Throwable
    //   142	150	233	java/lang/Throwable
    //   158	180	233	java/lang/Throwable
    //   212	223	233	java/lang/Throwable
    //   114	132	237	com/amap/api/mapcore/util/fj
    //   142	150	237	com/amap/api/mapcore/util/fj
    //   158	180	237	com/amap/api/mapcore/util/fj
    //   212	223	237	com/amap/api/mapcore/util/fj
    //   34	41	288	finally
    //   45	54	288	finally
    //   58	65	288	finally
    //   74	83	288	finally
    //   87	95	288	finally
    //   99	114	288	finally
    //   302	306	288	finally
    //   309	320	288	finally
    //   320	322	288	finally
    //   322	332	288	finally
    //   332	343	288	finally
    //   343	354	288	finally
    //   354	365	288	finally
    //   365	376	288	finally
    //   376	387	288	finally
    //   387	398	288	finally
    //   34	41	295	java/lang/Throwable
    //   45	54	295	java/lang/Throwable
    //   58	65	295	java/lang/Throwable
    //   74	83	295	java/lang/Throwable
    //   87	95	295	java/lang/Throwable
    //   99	114	295	java/lang/Throwable
    //   402	406	409	java/lang/Throwable
    //   34	41	422	java/net/ConnectException
    //   45	54	422	java/net/ConnectException
    //   58	65	422	java/net/ConnectException
    //   74	83	422	java/net/ConnectException
    //   87	95	422	java/net/ConnectException
    //   99	114	422	java/net/ConnectException
    //   34	41	430	java/net/MalformedURLException
    //   45	54	430	java/net/MalformedURLException
    //   58	65	430	java/net/MalformedURLException
    //   74	83	430	java/net/MalformedURLException
    //   87	95	430	java/net/MalformedURLException
    //   99	114	430	java/net/MalformedURLException
    //   34	41	438	java/net/UnknownHostException
    //   45	54	438	java/net/UnknownHostException
    //   58	65	438	java/net/UnknownHostException
    //   74	83	438	java/net/UnknownHostException
    //   87	95	438	java/net/UnknownHostException
    //   99	114	438	java/net/UnknownHostException
    //   34	41	446	java/net/SocketException
    //   45	54	446	java/net/SocketException
    //   58	65	446	java/net/SocketException
    //   74	83	446	java/net/SocketException
    //   87	95	446	java/net/SocketException
    //   99	114	446	java/net/SocketException
    //   34	41	454	java/net/SocketTimeoutException
    //   45	54	454	java/net/SocketTimeoutException
    //   58	65	454	java/net/SocketTimeoutException
    //   74	83	454	java/net/SocketTimeoutException
    //   87	95	454	java/net/SocketTimeoutException
    //   99	114	454	java/net/SocketTimeoutException
    //   34	41	462	java/io/InterruptedIOException
    //   45	54	462	java/io/InterruptedIOException
    //   58	65	462	java/io/InterruptedIOException
    //   74	83	462	java/io/InterruptedIOException
    //   87	95	462	java/io/InterruptedIOException
    //   99	114	462	java/io/InterruptedIOException
    //   34	41	470	java/io/IOException
    //   45	54	470	java/io/IOException
    //   58	65	470	java/io/IOException
    //   74	83	470	java/io/IOException
    //   87	95	470	java/io/IOException
    //   99	114	470	java/io/IOException
    //   114	132	478	java/net/ConnectException
    //   142	150	478	java/net/ConnectException
    //   158	180	478	java/net/ConnectException
    //   212	223	478	java/net/ConnectException
    //   114	132	482	java/net/MalformedURLException
    //   142	150	482	java/net/MalformedURLException
    //   158	180	482	java/net/MalformedURLException
    //   212	223	482	java/net/MalformedURLException
    //   114	132	486	java/net/UnknownHostException
    //   142	150	486	java/net/UnknownHostException
    //   158	180	486	java/net/UnknownHostException
    //   212	223	486	java/net/UnknownHostException
    //   114	132	490	java/net/SocketException
    //   142	150	490	java/net/SocketException
    //   158	180	490	java/net/SocketException
    //   212	223	490	java/net/SocketException
    //   114	132	494	java/net/SocketTimeoutException
    //   142	150	494	java/net/SocketTimeoutException
    //   158	180	494	java/net/SocketTimeoutException
    //   212	223	494	java/net/SocketTimeoutException
    //   114	132	498	java/io/InterruptedIOException
    //   142	150	498	java/io/InterruptedIOException
    //   158	180	498	java/io/InterruptedIOException
    //   212	223	498	java/io/InterruptedIOException
    //   114	132	502	java/io/IOException
    //   142	150	502	java/io/IOException
    //   158	180	502	java/io/IOException
    //   212	223	502	java/io/IOException
    //   34	41	506	com/amap/api/mapcore/util/fj
    //   45	54	506	com/amap/api/mapcore/util/fj
    //   58	65	506	com/amap/api/mapcore/util/fj
    //   74	83	506	com/amap/api/mapcore/util/fj
    //   87	95	506	com/amap/api/mapcore/util/fj
    //   99	114	506	com/amap/api/mapcore/util/fj
  }
  
  void a()
  {
    this.f = true;
  }
  
  void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  /* Error */
  void a(String paramString1, boolean paramBoolean, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, byte[] paramArrayOfByte, hz.a parama)
  {
    // Byte code:
    //   0: aload 7
    //   2: ifnonnull +4 -> 6
    //   5: return
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 15
    //   15: aload 5
    //   17: invokestatic 500	com/amap/api/mapcore/util/ia:a	(Ljava/util/Map;)Ljava/lang/String;
    //   20: astore 5
    //   22: new 502	java/lang/StringBuffer
    //   25: dup
    //   26: invokespecial 503	java/lang/StringBuffer:<init>	()V
    //   29: astore 13
    //   31: aload 13
    //   33: aload_1
    //   34: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   37: pop
    //   38: aload 5
    //   40: ifnull +20 -> 60
    //   43: aload 13
    //   45: ldc_w 508
    //   48: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload 13
    //   54: aload 5
    //   56: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   59: pop
    //   60: iconst_1
    //   61: istore 9
    //   63: aload 6
    //   65: ifnull +910 -> 975
    //   68: aload 6
    //   70: arraylength
    //   71: ifle +904 -> 975
    //   74: iconst_1
    //   75: istore 11
    //   77: goto +3 -> 80
    //   80: aload_0
    //   81: aload 13
    //   83: invokevirtual 509	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   86: iload_2
    //   87: aload_3
    //   88: aload 4
    //   90: iload 11
    //   92: invokevirtual 375	com/amap/api/mapcore/util/ia:a	(Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   95: astore 5
    //   97: new 201	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   104: astore_1
    //   105: aload_1
    //   106: ldc_w 528
    //   109: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_1
    //   114: aload_0
    //   115: getfield 48	com/amap/api/mapcore/util/ia:h	J
    //   118: invokevirtual 531	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: ldc_w 350
    //   126: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 5
    //   132: ldc_w 533
    //   135: aload_1
    //   136: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokevirtual 477	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: iload 11
    //   144: ifeq +837 -> 981
    //   147: new 377	java/io/DataOutputStream
    //   150: dup
    //   151: aload 5
    //   153: invokevirtual 381	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   156: invokespecial 384	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   159: astore_1
    //   160: aload_1
    //   161: astore 14
    //   163: aload 16
    //   165: astore 12
    //   167: aload 5
    //   169: astore 13
    //   171: aload_1
    //   172: astore_3
    //   173: aload_1
    //   174: aload 6
    //   176: invokevirtual 386	java/io/DataOutputStream:write	([B)V
    //   179: aload_1
    //   180: astore 14
    //   182: aload 16
    //   184: astore 12
    //   186: aload 5
    //   188: astore 13
    //   190: aload_1
    //   191: astore_3
    //   192: aload_1
    //   193: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   196: goto +3 -> 199
    //   199: aload_1
    //   200: astore 14
    //   202: aload 16
    //   204: astore 12
    //   206: aload 5
    //   208: astore 13
    //   210: aload_1
    //   211: astore_3
    //   212: aload 5
    //   214: invokevirtual 111	java/net/HttpURLConnection:connect	()V
    //   217: aload_1
    //   218: astore 14
    //   220: aload 16
    //   222: astore 12
    //   224: aload 5
    //   226: astore 13
    //   228: aload_1
    //   229: astore_3
    //   230: aload_0
    //   231: aload 5
    //   233: invokespecial 535	com/amap/api/mapcore/util/ia:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   236: astore 4
    //   238: aload_1
    //   239: astore 14
    //   241: aload 16
    //   243: astore 12
    //   245: aload 5
    //   247: astore 13
    //   249: aload_1
    //   250: astore_3
    //   251: aload 5
    //   253: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   256: istore 10
    //   258: iload 10
    //   260: sipush 200
    //   263: if_icmpeq +723 -> 986
    //   266: iconst_1
    //   267: istore 8
    //   269: goto +720 -> 989
    //   272: iload 9
    //   274: iload 8
    //   276: iand
    //   277: ifeq +193 -> 470
    //   280: aload_1
    //   281: astore 14
    //   283: aload 16
    //   285: astore 12
    //   287: aload 5
    //   289: astore 13
    //   291: aload_1
    //   292: astore_3
    //   293: new 201	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   300: astore 6
    //   302: aload_1
    //   303: astore 14
    //   305: aload 16
    //   307: astore 12
    //   309: aload 5
    //   311: astore 13
    //   313: aload_1
    //   314: astore_3
    //   315: aload 6
    //   317: ldc -52
    //   319: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_1
    //   324: astore 14
    //   326: aload 16
    //   328: astore 12
    //   330: aload 5
    //   332: astore 13
    //   334: aload_1
    //   335: astore_3
    //   336: aload 6
    //   338: aload 5
    //   340: invokevirtual 212	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   343: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_1
    //   348: astore 14
    //   350: aload 16
    //   352: astore 12
    //   354: aload 5
    //   356: astore 13
    //   358: aload_1
    //   359: astore_3
    //   360: aload 6
    //   362: ldc -42
    //   364: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_1
    //   369: astore 14
    //   371: aload 16
    //   373: astore 12
    //   375: aload 5
    //   377: astore 13
    //   379: aload_1
    //   380: astore_3
    //   381: aload 6
    //   383: iload 10
    //   385: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_1
    //   390: astore 14
    //   392: aload 16
    //   394: astore 12
    //   396: aload 5
    //   398: astore 13
    //   400: aload_1
    //   401: astore_3
    //   402: aload 7
    //   404: new 102	com/amap/api/mapcore/util/fj
    //   407: dup
    //   408: aload 6
    //   410: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: aload 4
    //   415: aload_0
    //   416: getfield 188	com/amap/api/mapcore/util/ia:i	Ljava/lang/String;
    //   419: invokespecial 227	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   422: invokeinterface 541 2 0
    //   427: aload 5
    //   429: ifnull +21 -> 450
    //   432: aload 5
    //   434: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   437: goto +13 -> 450
    //   440: astore_3
    //   441: aload_3
    //   442: ldc 87
    //   444: ldc_w 543
    //   447: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_1
    //   451: ifnull +18 -> 469
    //   454: aload_1
    //   455: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   458: return
    //   459: astore_1
    //   460: aload_1
    //   461: ldc 87
    //   463: ldc_w 543
    //   466: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   469: return
    //   470: aload_1
    //   471: astore 14
    //   473: aload 16
    //   475: astore 12
    //   477: aload 5
    //   479: astore 13
    //   481: aload_1
    //   482: astore_3
    //   483: aload 5
    //   485: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   488: astore 4
    //   490: sipush 1024
    //   493: newarray <illegal type>
    //   495: astore_3
    //   496: invokestatic 548	java/lang/Thread:interrupted	()Z
    //   499: ifne +117 -> 616
    //   502: aload_0
    //   503: getfield 42	com/amap/api/mapcore/util/ia:f	Z
    //   506: ifne +110 -> 616
    //   509: aload 4
    //   511: aload_3
    //   512: iconst_0
    //   513: sipush 1024
    //   516: invokevirtual 551	java/io/InputStream:read	([BII)I
    //   519: istore 8
    //   521: iload 8
    //   523: ifle +93 -> 616
    //   526: aload_0
    //   527: getfield 46	com/amap/api/mapcore/util/ia:g	J
    //   530: ldc2_w 43
    //   533: lcmp
    //   534: ifeq +15 -> 549
    //   537: aload_0
    //   538: getfield 48	com/amap/api/mapcore/util/ia:h	J
    //   541: aload_0
    //   542: getfield 46	com/amap/api/mapcore/util/ia:g	J
    //   545: lcmp
    //   546: ifge +70 -> 616
    //   549: iload 8
    //   551: sipush 1024
    //   554: if_icmpne +18 -> 572
    //   557: aload 7
    //   559: aload_3
    //   560: aload_0
    //   561: getfield 48	com/amap/api/mapcore/util/ia:h	J
    //   564: invokeinterface 555 4 0
    //   569: goto +32 -> 601
    //   572: iload 8
    //   574: newarray <illegal type>
    //   576: astore 6
    //   578: aload_3
    //   579: iconst_0
    //   580: aload 6
    //   582: iconst_0
    //   583: iload 8
    //   585: invokestatic 561	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   588: aload 7
    //   590: aload 6
    //   592: aload_0
    //   593: getfield 48	com/amap/api/mapcore/util/ia:h	J
    //   596: invokeinterface 555 4 0
    //   601: aload_0
    //   602: aload_0
    //   603: getfield 48	com/amap/api/mapcore/util/ia:h	J
    //   606: iload 8
    //   608: i2l
    //   609: ladd
    //   610: putfield 48	com/amap/api/mapcore/util/ia:h	J
    //   613: goto -117 -> 496
    //   616: aload_0
    //   617: getfield 42	com/amap/api/mapcore/util/ia:f	Z
    //   620: ifeq +13 -> 633
    //   623: aload 7
    //   625: invokeinterface 564 1 0
    //   630: goto +10 -> 640
    //   633: aload 7
    //   635: invokeinterface 567 1 0
    //   640: aload 4
    //   642: ifnull +34 -> 676
    //   645: aload 4
    //   647: invokevirtual 198	java/io/InputStream:close	()V
    //   650: goto +26 -> 676
    //   653: astore_3
    //   654: aload_3
    //   655: ldc 87
    //   657: ldc_w 543
    //   660: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   663: goto +13 -> 676
    //   666: astore_3
    //   667: aload_3
    //   668: ldc 87
    //   670: ldc_w 543
    //   673: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload 5
    //   678: ifnull +21 -> 699
    //   681: aload 5
    //   683: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   686: goto +13 -> 699
    //   689: astore_3
    //   690: aload_3
    //   691: ldc 87
    //   693: ldc_w 543
    //   696: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   699: aload_1
    //   700: ifnull +175 -> 875
    //   703: aload_1
    //   704: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   707: return
    //   708: astore_1
    //   709: aload_1
    //   710: ldc 87
    //   712: ldc_w 543
    //   715: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   718: return
    //   719: astore_3
    //   720: aload 4
    //   722: astore 12
    //   724: goto +163 -> 887
    //   727: astore_3
    //   728: aload 4
    //   730: astore 6
    //   732: aload_3
    //   733: astore 4
    //   735: goto +54 -> 789
    //   738: astore 4
    //   740: aload 15
    //   742: astore 6
    //   744: aload 14
    //   746: astore_1
    //   747: goto +42 -> 789
    //   750: astore_3
    //   751: aconst_null
    //   752: astore_1
    //   753: goto +134 -> 887
    //   756: astore 4
    //   758: aconst_null
    //   759: astore_1
    //   760: aload 15
    //   762: astore 6
    //   764: goto +25 -> 789
    //   767: astore_3
    //   768: aconst_null
    //   769: astore 5
    //   771: aload 5
    //   773: astore_1
    //   774: goto +113 -> 887
    //   777: astore 4
    //   779: aconst_null
    //   780: astore 5
    //   782: aload 5
    //   784: astore_1
    //   785: aload 15
    //   787: astore 6
    //   789: aload 6
    //   791: astore 12
    //   793: aload 5
    //   795: astore 13
    //   797: aload_1
    //   798: astore_3
    //   799: aload 7
    //   801: aload 4
    //   803: invokeinterface 541 2 0
    //   808: aload 6
    //   810: ifnull +34 -> 844
    //   813: aload 6
    //   815: invokevirtual 198	java/io/InputStream:close	()V
    //   818: goto +26 -> 844
    //   821: astore_3
    //   822: aload_3
    //   823: ldc 87
    //   825: ldc_w 543
    //   828: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   831: goto +13 -> 844
    //   834: astore_3
    //   835: aload_3
    //   836: ldc 87
    //   838: ldc_w 543
    //   841: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   844: aload 5
    //   846: ifnull +21 -> 867
    //   849: aload 5
    //   851: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   854: goto +13 -> 867
    //   857: astore_3
    //   858: aload_3
    //   859: ldc 87
    //   861: ldc_w 543
    //   864: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload_1
    //   868: ifnull +7 -> 875
    //   871: aload_1
    //   872: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   875: return
    //   876: astore 4
    //   878: aload_3
    //   879: astore_1
    //   880: aload 13
    //   882: astore 5
    //   884: aload 4
    //   886: astore_3
    //   887: aload 12
    //   889: ifnull +38 -> 927
    //   892: aload 12
    //   894: invokevirtual 198	java/io/InputStream:close	()V
    //   897: goto +30 -> 927
    //   900: astore 4
    //   902: aload 4
    //   904: ldc 87
    //   906: ldc_w 543
    //   909: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   912: goto +15 -> 927
    //   915: astore 4
    //   917: aload 4
    //   919: ldc 87
    //   921: ldc_w 543
    //   924: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   927: aload 5
    //   929: ifnull +23 -> 952
    //   932: aload 5
    //   934: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   937: goto +15 -> 952
    //   940: astore 4
    //   942: aload 4
    //   944: ldc 87
    //   946: ldc_w 543
    //   949: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   952: aload_1
    //   953: ifnull +20 -> 973
    //   956: aload_1
    //   957: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   960: goto +13 -> 973
    //   963: astore_1
    //   964: aload_1
    //   965: ldc 87
    //   967: ldc_w 543
    //   970: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   973: aload_3
    //   974: athrow
    //   975: iconst_0
    //   976: istore 11
    //   978: goto -898 -> 80
    //   981: aconst_null
    //   982: astore_1
    //   983: goto -784 -> 199
    //   986: iconst_0
    //   987: istore 8
    //   989: iload 10
    //   991: sipush 206
    //   994: if_icmpeq +6 -> 1000
    //   997: goto -725 -> 272
    //   1000: iconst_0
    //   1001: istore 9
    //   1003: goto -731 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	ia
    //   0	1006	1	paramString1	String
    //   0	1006	2	paramBoolean	boolean
    //   0	1006	3	paramString2	String
    //   0	1006	4	paramMap1	Map<String, String>
    //   0	1006	5	paramMap2	Map<String, String>
    //   0	1006	6	paramArrayOfByte	byte[]
    //   0	1006	7	parama	hz.a
    //   267	721	8	m	int
    //   61	941	9	n	int
    //   256	739	10	i1	int
    //   75	902	11	bool	boolean
    //   10	883	12	localObject1	Object
    //   29	852	13	localObject2	Object
    //   161	584	14	str	String
    //   13	773	15	localObject3	Object
    //   7	467	16	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   432	437	440	java/lang/Throwable
    //   454	458	459	java/lang/Throwable
    //   645	650	653	java/lang/Throwable
    //   645	650	666	java/io/IOException
    //   681	686	689	java/lang/Throwable
    //   703	707	708	java/lang/Throwable
    //   871	875	708	java/lang/Throwable
    //   490	496	719	finally
    //   496	521	719	finally
    //   526	549	719	finally
    //   557	569	719	finally
    //   572	601	719	finally
    //   601	613	719	finally
    //   616	630	719	finally
    //   633	640	719	finally
    //   490	496	727	java/lang/Throwable
    //   496	521	727	java/lang/Throwable
    //   526	549	727	java/lang/Throwable
    //   557	569	727	java/lang/Throwable
    //   572	601	727	java/lang/Throwable
    //   601	613	727	java/lang/Throwable
    //   616	630	727	java/lang/Throwable
    //   633	640	727	java/lang/Throwable
    //   173	179	738	java/lang/Throwable
    //   192	196	738	java/lang/Throwable
    //   212	217	738	java/lang/Throwable
    //   230	238	738	java/lang/Throwable
    //   251	258	738	java/lang/Throwable
    //   293	302	738	java/lang/Throwable
    //   315	323	738	java/lang/Throwable
    //   336	347	738	java/lang/Throwable
    //   360	368	738	java/lang/Throwable
    //   381	389	738	java/lang/Throwable
    //   402	427	738	java/lang/Throwable
    //   483	490	738	java/lang/Throwable
    //   97	142	750	finally
    //   147	160	750	finally
    //   97	142	756	java/lang/Throwable
    //   147	160	756	java/lang/Throwable
    //   15	38	767	finally
    //   43	60	767	finally
    //   68	74	767	finally
    //   80	97	767	finally
    //   15	38	777	java/lang/Throwable
    //   43	60	777	java/lang/Throwable
    //   68	74	777	java/lang/Throwable
    //   80	97	777	java/lang/Throwable
    //   813	818	821	java/lang/Throwable
    //   813	818	834	java/io/IOException
    //   849	854	857	java/lang/Throwable
    //   173	179	876	finally
    //   192	196	876	finally
    //   212	217	876	finally
    //   230	238	876	finally
    //   251	258	876	finally
    //   293	302	876	finally
    //   315	323	876	finally
    //   336	347	876	finally
    //   360	368	876	finally
    //   381	389	876	finally
    //   402	427	876	finally
    //   483	490	876	finally
    //   799	808	876	finally
    //   892	897	900	java/lang/Throwable
    //   892	897	915	java/io/IOException
    //   932	937	940	java/lang/Throwable
    //   956	960	963	java/lang/Throwable
  }
  
  /* Error */
  ie b(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean2)
    throws fj
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 13
    //   18: aconst_null
    //   19: astore 14
    //   21: aconst_null
    //   22: astore 15
    //   24: aconst_null
    //   25: astore 16
    //   27: aconst_null
    //   28: astore 17
    //   30: aload 17
    //   32: astore 7
    //   34: aload 5
    //   36: invokestatic 500	com/amap/api/mapcore/util/ia:a	(Ljava/util/Map;)Ljava/lang/String;
    //   39: astore 5
    //   41: aload 17
    //   43: astore 7
    //   45: new 502	java/lang/StringBuffer
    //   48: dup
    //   49: invokespecial 503	java/lang/StringBuffer:<init>	()V
    //   52: astore 18
    //   54: aload 17
    //   56: astore 7
    //   58: aload 18
    //   60: aload_1
    //   61: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: aload 5
    //   67: ifnull +28 -> 95
    //   70: aload 17
    //   72: astore 7
    //   74: aload 18
    //   76: ldc_w 508
    //   79: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: aload 17
    //   85: astore 7
    //   87: aload 18
    //   89: aload 5
    //   91: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   94: pop
    //   95: aload 17
    //   97: astore 7
    //   99: aload_0
    //   100: aload 18
    //   102: invokevirtual 509	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   105: iload_2
    //   106: aload_3
    //   107: aload 4
    //   109: iconst_0
    //   110: invokevirtual 375	com/amap/api/mapcore/util/ia:a	(Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   113: astore_1
    //   114: aload_0
    //   115: aload_1
    //   116: iload 6
    //   118: invokespecial 389	com/amap/api/mapcore/util/ia:a	(Ljava/net/HttpURLConnection;Z)Lcom/amap/api/mapcore/util/ie;
    //   121: astore_3
    //   122: aload_1
    //   123: ifnull +19 -> 142
    //   126: aload_1
    //   127: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   130: aload_3
    //   131: areturn
    //   132: astore_1
    //   133: aload_1
    //   134: ldc 87
    //   136: ldc_w 520
    //   139: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_3
    //   143: areturn
    //   144: astore_3
    //   145: aload_1
    //   146: astore 7
    //   148: goto +163 -> 311
    //   151: astore_3
    //   152: goto +60 -> 212
    //   155: astore_3
    //   156: aload_1
    //   157: astore 7
    //   159: goto +74 -> 233
    //   162: aload_1
    //   163: astore 7
    //   165: goto +70 -> 235
    //   168: aload_1
    //   169: astore 7
    //   171: goto +74 -> 245
    //   174: aload_1
    //   175: astore 7
    //   177: goto +79 -> 256
    //   180: aload_1
    //   181: astore 7
    //   183: goto +84 -> 267
    //   186: aload_1
    //   187: astore 7
    //   189: goto +89 -> 278
    //   192: aload_1
    //   193: astore 7
    //   195: goto +94 -> 289
    //   198: aload_1
    //   199: astore 7
    //   201: goto +99 -> 300
    //   204: astore_3
    //   205: goto +106 -> 311
    //   208: astore_3
    //   209: aload 8
    //   211: astore_1
    //   212: aload_1
    //   213: astore 7
    //   215: aload_3
    //   216: invokevirtual 523	java/lang/Throwable:printStackTrace	()V
    //   219: aload_1
    //   220: astore 7
    //   222: new 102	com/amap/api/mapcore/util/fj
    //   225: dup
    //   226: ldc_w 396
    //   229: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   232: athrow
    //   233: aload_3
    //   234: athrow
    //   235: new 102	com/amap/api/mapcore/util/fj
    //   238: dup
    //   239: ldc -24
    //   241: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   244: athrow
    //   245: new 102	com/amap/api/mapcore/util/fj
    //   248: dup
    //   249: ldc_w 396
    //   252: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   255: athrow
    //   256: new 102	com/amap/api/mapcore/util/fj
    //   259: dup
    //   260: ldc_w 404
    //   263: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   266: athrow
    //   267: new 102	com/amap/api/mapcore/util/fj
    //   270: dup
    //   271: ldc_w 407
    //   274: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   277: athrow
    //   278: new 102	com/amap/api/mapcore/util/fj
    //   281: dup
    //   282: ldc_w 410
    //   285: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   288: athrow
    //   289: new 102	com/amap/api/mapcore/util/fj
    //   292: dup
    //   293: ldc_w 413
    //   296: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   299: athrow
    //   300: new 102	com/amap/api/mapcore/util/fj
    //   303: dup
    //   304: ldc_w 416
    //   307: invokespecial 398	com/amap/api/mapcore/util/fj:<init>	(Ljava/lang/String;)V
    //   310: athrow
    //   311: aload 7
    //   313: ifnull +21 -> 334
    //   316: aload 7
    //   318: invokevirtual 392	java/net/HttpURLConnection:disconnect	()V
    //   321: goto +13 -> 334
    //   324: astore_1
    //   325: aload_1
    //   326: ldc 87
    //   328: ldc_w 520
    //   331: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_3
    //   335: athrow
    //   336: astore_1
    //   337: aload 16
    //   339: astore 7
    //   341: goto -41 -> 300
    //   344: astore_1
    //   345: aload 15
    //   347: astore 7
    //   349: goto -60 -> 289
    //   352: astore_1
    //   353: aload 14
    //   355: astore 7
    //   357: goto -79 -> 278
    //   360: astore_1
    //   361: aload 13
    //   363: astore 7
    //   365: goto -98 -> 267
    //   368: astore_1
    //   369: aload 12
    //   371: astore 7
    //   373: goto -117 -> 256
    //   376: astore_1
    //   377: aload 11
    //   379: astore 7
    //   381: goto -136 -> 245
    //   384: astore_1
    //   385: aload 10
    //   387: astore 7
    //   389: goto -154 -> 235
    //   392: astore_3
    //   393: goto -195 -> 198
    //   396: astore_3
    //   397: goto -205 -> 192
    //   400: astore_3
    //   401: goto -215 -> 186
    //   404: astore_3
    //   405: goto -225 -> 180
    //   408: astore_3
    //   409: goto -235 -> 174
    //   412: astore_3
    //   413: goto -245 -> 168
    //   416: astore_3
    //   417: goto -255 -> 162
    //   420: astore_3
    //   421: aload 9
    //   423: astore 7
    //   425: goto -192 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	ia
    //   0	428	1	paramString1	String
    //   0	428	2	paramBoolean1	boolean
    //   0	428	3	paramString2	String
    //   0	428	4	paramMap1	Map<String, String>
    //   0	428	5	paramMap2	Map<String, String>
    //   0	428	6	paramBoolean2	boolean
    //   32	392	7	localObject1	Object
    //   1	209	8	localObject2	Object
    //   4	418	9	localObject3	Object
    //   7	379	10	localObject4	Object
    //   10	368	11	localObject5	Object
    //   13	357	12	localObject6	Object
    //   16	346	13	localObject7	Object
    //   19	335	14	localObject8	Object
    //   22	324	15	localObject9	Object
    //   25	313	16	localObject10	Object
    //   28	68	17	localObject11	Object
    //   52	49	18	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   126	130	132	java/lang/Throwable
    //   114	122	144	finally
    //   114	122	151	java/lang/Throwable
    //   114	122	155	com/amap/api/mapcore/util/fj
    //   34	41	204	finally
    //   45	54	204	finally
    //   58	65	204	finally
    //   74	83	204	finally
    //   87	95	204	finally
    //   99	114	204	finally
    //   215	219	204	finally
    //   222	233	204	finally
    //   233	235	204	finally
    //   235	245	204	finally
    //   245	256	204	finally
    //   256	267	204	finally
    //   267	278	204	finally
    //   278	289	204	finally
    //   289	300	204	finally
    //   300	311	204	finally
    //   34	41	208	java/lang/Throwable
    //   45	54	208	java/lang/Throwable
    //   58	65	208	java/lang/Throwable
    //   74	83	208	java/lang/Throwable
    //   87	95	208	java/lang/Throwable
    //   99	114	208	java/lang/Throwable
    //   316	321	324	java/lang/Throwable
    //   34	41	336	java/net/ConnectException
    //   45	54	336	java/net/ConnectException
    //   58	65	336	java/net/ConnectException
    //   74	83	336	java/net/ConnectException
    //   87	95	336	java/net/ConnectException
    //   99	114	336	java/net/ConnectException
    //   34	41	344	java/net/MalformedURLException
    //   45	54	344	java/net/MalformedURLException
    //   58	65	344	java/net/MalformedURLException
    //   74	83	344	java/net/MalformedURLException
    //   87	95	344	java/net/MalformedURLException
    //   99	114	344	java/net/MalformedURLException
    //   34	41	352	java/net/UnknownHostException
    //   45	54	352	java/net/UnknownHostException
    //   58	65	352	java/net/UnknownHostException
    //   74	83	352	java/net/UnknownHostException
    //   87	95	352	java/net/UnknownHostException
    //   99	114	352	java/net/UnknownHostException
    //   34	41	360	java/net/SocketException
    //   45	54	360	java/net/SocketException
    //   58	65	360	java/net/SocketException
    //   74	83	360	java/net/SocketException
    //   87	95	360	java/net/SocketException
    //   99	114	360	java/net/SocketException
    //   34	41	368	java/net/SocketTimeoutException
    //   45	54	368	java/net/SocketTimeoutException
    //   58	65	368	java/net/SocketTimeoutException
    //   74	83	368	java/net/SocketTimeoutException
    //   87	95	368	java/net/SocketTimeoutException
    //   99	114	368	java/net/SocketTimeoutException
    //   34	41	376	java/io/InterruptedIOException
    //   45	54	376	java/io/InterruptedIOException
    //   58	65	376	java/io/InterruptedIOException
    //   74	83	376	java/io/InterruptedIOException
    //   87	95	376	java/io/InterruptedIOException
    //   99	114	376	java/io/InterruptedIOException
    //   34	41	384	java/io/IOException
    //   45	54	384	java/io/IOException
    //   58	65	384	java/io/IOException
    //   74	83	384	java/io/IOException
    //   87	95	384	java/io/IOException
    //   99	114	384	java/io/IOException
    //   114	122	392	java/net/ConnectException
    //   114	122	396	java/net/MalformedURLException
    //   114	122	400	java/net/UnknownHostException
    //   114	122	404	java/net/SocketException
    //   114	122	408	java/net/SocketTimeoutException
    //   114	122	412	java/io/InterruptedIOException
    //   114	122	416	java/io/IOException
    //   34	41	420	com/amap/api/mapcore/util/fj
    //   45	54	420	com/amap/api/mapcore/util/fj
    //   58	65	420	com/amap/api/mapcore/util/fj
    //   74	83	420	com/amap/api/mapcore/util/fj
    //   87	95	420	com/amap/api/mapcore/util/fj
    //   99	114	420	com/amap/api/mapcore/util/fj
  }
  
  void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  private static class a
  {
    private Vector<ia.b> a = new Vector();
    private volatile ia.b b = new ia.b(null);
    
    public ia.b a()
    {
      return this.b;
    }
    
    public ia.b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return this.b;
      }
      int i = 0;
      while (i < this.a.size())
      {
        localb = (ia.b)this.a.get(i);
        if ((localb != null) && (localb.a().equals(paramString))) {
          return localb;
        }
        i += 1;
      }
      ia.b localb = new ia.b(null);
      localb.b(paramString);
      this.a.add(localb);
      return localb;
    }
    
    public void b(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.b.a(paramString);
    }
  }
  
  private static class b
    implements HostnameVerifier
  {
    private String a;
    private String b;
    
    public String a()
    {
      return this.b;
    }
    
    public void a(String paramString)
    {
      this.a = paramString;
    }
    
    public void b(String paramString)
    {
      this.b = paramString;
    }
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      HostnameVerifier localHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
      if (!TextUtils.isEmpty(this.a)) {
        return this.a.equals(paramString);
      }
      if (!TextUtils.isEmpty(this.b)) {
        return localHostnameVerifier.verify(this.b, paramSSLSession);
      }
      return localHostnameVerifier.verify(paramString, paramSSLSession);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */