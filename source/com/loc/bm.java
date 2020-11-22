package com.loc;

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

public final class bm
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
  private bj.a k;
  
  bm(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramProxy, paramBoolean, (byte)0);
  }
  
  private bm(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean, byte paramByte)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = paramProxy;
    this.c = r.a().b(paramBoolean);
    if (r.b()) {
      this.c = false;
    }
    this.k = null;
    try
    {
      this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }
    catch (Throwable paramProxy)
    {
      ag.a(paramProxy, "ht", "ic");
    }
    if (this.c) {
      try
      {
        paramProxy = SSLContext.getInstance("TLS");
        paramProxy.init(null, null, null);
        this.d = paramProxy;
      }
      catch (Throwable paramProxy)
      {
        ag.a(paramProxy, "ht", "ne");
      }
    }
    this.j = new a((byte)0);
  }
  
  private static String a(HttpURLConnection paramHttpURLConnection)
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
  
  private HttpURLConnection a(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap, boolean paramBoolean2)
    throws IOException
  {
    p.b();
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
    int m = bj.a;
    localObject2 = "";
    if (m == 1) {
      localObject2 = bj.b;
    }
    paramString2 = paramString1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString1 = Uri.parse(paramString1);
      paramString2 = paramString1.getHost();
      paramString1 = paramString1.buildUpon().encodedAuthority((String)localObject2).build().toString();
      if (localObject1 != null) {
        ((Map)localObject1).put("targetHost", paramString2);
      }
      paramString2 = paramString1;
      if (this.c)
      {
        this.j.b((String)localObject2);
        paramString2 = paramString1;
      }
    }
    paramString1 = paramString2;
    if (this.c) {
      paramString1 = r.a(paramString2);
    }
    localObject2 = new URL(paramString1);
    if (this.k != null) {
      paramString1 = this.k.a();
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
      ag.a(paramMap, "ht", "adh");
    }
    paramHttpURLConnection.setConnectTimeout(this.a);
    paramHttpURLConnection.setReadTimeout(this.b);
  }
  
  /* Error */
  private bo b(HttpURLConnection paramHttpURLConnection)
    throws k, IOException
  {
    // Byte code:
    //   0: ldc 81
    //   2: astore 4
    //   4: aconst_null
    //   5: astore 7
    //   7: aconst_null
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 10
    //   13: aconst_null
    //   14: astore 9
    //   16: aload 4
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 350	java/net/HttpURLConnection:connect	()V
    //   24: aload 4
    //   26: astore 5
    //   28: aload_1
    //   29: invokevirtual 129	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   32: astore 11
    //   34: aload 4
    //   36: astore 5
    //   38: aload_1
    //   39: invokevirtual 353	java/net/HttpURLConnection:getResponseCode	()I
    //   42: istore_2
    //   43: aload 4
    //   45: astore_3
    //   46: aload 11
    //   48: ifnull +62 -> 110
    //   51: aload 4
    //   53: astore 5
    //   55: aload 11
    //   57: ldc -125
    //   59: invokeinterface 137 2 0
    //   64: checkcast 139	java/util/List
    //   67: astore 6
    //   69: aload 4
    //   71: astore_3
    //   72: aload 6
    //   74: ifnull +36 -> 110
    //   77: aload 4
    //   79: astore_3
    //   80: aload 4
    //   82: astore 5
    //   84: aload 6
    //   86: invokeinterface 143 1 0
    //   91: ifle +19 -> 110
    //   94: aload 4
    //   96: astore 5
    //   98: aload 6
    //   100: iconst_0
    //   101: invokeinterface 146 2 0
    //   106: checkcast 83	java/lang/String
    //   109: astore_3
    //   110: iload_2
    //   111: sipush 200
    //   114: if_icmpne +400 -> 514
    //   117: aload_3
    //   118: astore 5
    //   120: new 355	java/io/ByteArrayOutputStream
    //   123: dup
    //   124: invokespecial 356	java/io/ByteArrayOutputStream:<init>	()V
    //   127: astore 4
    //   129: aload_1
    //   130: invokevirtual 360	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   133: astore 5
    //   135: new 362	java/io/PushbackInputStream
    //   138: dup
    //   139: aload 5
    //   141: iconst_2
    //   142: invokespecial 365	java/io/PushbackInputStream:<init>	(Ljava/io/InputStream;I)V
    //   145: astore 6
    //   147: aload 9
    //   149: astore 7
    //   151: aload 10
    //   153: astore 8
    //   155: iconst_2
    //   156: newarray <illegal type>
    //   158: astore_1
    //   159: aload 9
    //   161: astore 7
    //   163: aload 10
    //   165: astore 8
    //   167: aload 6
    //   169: aload_1
    //   170: invokevirtual 369	java/io/PushbackInputStream:read	([B)I
    //   173: pop
    //   174: aload 9
    //   176: astore 7
    //   178: aload 10
    //   180: astore 8
    //   182: aload 6
    //   184: aload_1
    //   185: invokevirtual 373	java/io/PushbackInputStream:unread	([B)V
    //   188: aload_1
    //   189: iconst_0
    //   190: baload
    //   191: bipush 31
    //   193: if_icmpne +630 -> 823
    //   196: aload_1
    //   197: iconst_1
    //   198: baload
    //   199: bipush -117
    //   201: if_icmpne +622 -> 823
    //   204: aload 9
    //   206: astore 7
    //   208: aload 10
    //   210: astore 8
    //   212: new 375	java/util/zip/GZIPInputStream
    //   215: dup
    //   216: aload 6
    //   218: invokespecial 378	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   221: astore_1
    //   222: goto +3 -> 225
    //   225: aload_1
    //   226: astore 7
    //   228: aload_1
    //   229: astore 8
    //   231: sipush 1024
    //   234: newarray <illegal type>
    //   236: astore 9
    //   238: aload_1
    //   239: astore 7
    //   241: aload_1
    //   242: astore 8
    //   244: aload_1
    //   245: aload 9
    //   247: invokevirtual 381	java/io/InputStream:read	([B)I
    //   250: istore_2
    //   251: iload_2
    //   252: iconst_m1
    //   253: if_icmpeq +21 -> 274
    //   256: aload_1
    //   257: astore 7
    //   259: aload_1
    //   260: astore 8
    //   262: aload 4
    //   264: aload 9
    //   266: iconst_0
    //   267: iload_2
    //   268: invokevirtual 385	java/io/ByteArrayOutputStream:write	([BII)V
    //   271: goto -33 -> 238
    //   274: aload_1
    //   275: astore 7
    //   277: aload_1
    //   278: astore 8
    //   280: invokestatic 389	com/loc/aj:c	()V
    //   283: aload_1
    //   284: astore 7
    //   286: aload_1
    //   287: astore 8
    //   289: new 391	com/loc/bo
    //   292: dup
    //   293: invokespecial 392	com/loc/bo:<init>	()V
    //   296: astore 9
    //   298: aload_1
    //   299: astore 7
    //   301: aload_1
    //   302: astore 8
    //   304: aload 9
    //   306: aload 4
    //   308: invokevirtual 396	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   311: putfield 399	com/loc/bo:a	[B
    //   314: aload_1
    //   315: astore 7
    //   317: aload_1
    //   318: astore 8
    //   320: aload 9
    //   322: aload 11
    //   324: putfield 402	com/loc/bo:b	Ljava/util/Map;
    //   327: aload_1
    //   328: astore 7
    //   330: aload_1
    //   331: astore 8
    //   333: aload 9
    //   335: aload_0
    //   336: getfield 92	com/loc/bm:i	Ljava/lang/String;
    //   339: putfield 404	com/loc/bo:c	Ljava/lang/String;
    //   342: aload_1
    //   343: astore 7
    //   345: aload_1
    //   346: astore 8
    //   348: aload 9
    //   350: aload_3
    //   351: putfield 406	com/loc/bo:d	Ljava/lang/String;
    //   354: aload 4
    //   356: invokevirtual 408	java/io/ByteArrayOutputStream:close	()V
    //   359: goto +13 -> 372
    //   362: astore_3
    //   363: aload_3
    //   364: ldc 94
    //   366: ldc_w 410
    //   369: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload 5
    //   374: ifnull +21 -> 395
    //   377: aload 5
    //   379: invokevirtual 411	java/io/InputStream:close	()V
    //   382: goto +13 -> 395
    //   385: astore_3
    //   386: aload_3
    //   387: ldc 94
    //   389: ldc_w 410
    //   392: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload 6
    //   397: invokevirtual 412	java/io/PushbackInputStream:close	()V
    //   400: goto +13 -> 413
    //   403: astore_3
    //   404: aload_3
    //   405: ldc 94
    //   407: ldc_w 410
    //   410: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_1
    //   414: invokevirtual 411	java/io/InputStream:close	()V
    //   417: aload 9
    //   419: areturn
    //   420: astore_1
    //   421: aload_1
    //   422: ldc 94
    //   424: ldc_w 410
    //   427: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload 9
    //   432: areturn
    //   433: astore_1
    //   434: aload 7
    //   436: astore_3
    //   437: goto +16 -> 453
    //   440: aload 8
    //   442: astore 7
    //   444: goto +54 -> 498
    //   447: astore_1
    //   448: aconst_null
    //   449: astore_3
    //   450: aload_3
    //   451: astore 6
    //   453: aload 4
    //   455: astore 7
    //   457: aload_1
    //   458: astore 4
    //   460: aload 7
    //   462: astore_1
    //   463: goto +241 -> 704
    //   466: goto +26 -> 492
    //   469: astore 7
    //   471: aconst_null
    //   472: astore_1
    //   473: aload_1
    //   474: astore_3
    //   475: aload_3
    //   476: astore 6
    //   478: aload 4
    //   480: astore 5
    //   482: aload 7
    //   484: astore 4
    //   486: goto +228 -> 714
    //   489: aconst_null
    //   490: astore 5
    //   492: aconst_null
    //   493: astore 7
    //   495: aconst_null
    //   496: astore 6
    //   498: aload 4
    //   500: astore_1
    //   501: aload_3
    //   502: astore 8
    //   504: aload 7
    //   506: astore_3
    //   507: aload 5
    //   509: astore 4
    //   511: goto +166 -> 677
    //   514: aload_3
    //   515: astore 5
    //   517: new 149	java/lang/StringBuilder
    //   520: dup
    //   521: ldc_w 414
    //   524: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   527: astore 4
    //   529: aload_3
    //   530: astore 5
    //   532: aload 4
    //   534: aload_1
    //   535: invokevirtual 418	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   538: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_3
    //   543: astore 5
    //   545: aload 4
    //   547: ldc_w 420
    //   550: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload_3
    //   555: astore 5
    //   557: aload 4
    //   559: iload_2
    //   560: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload_3
    //   565: astore 5
    //   567: aload 4
    //   569: ldc_w 425
    //   572: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload_3
    //   577: astore 5
    //   579: aload 4
    //   581: aload_3
    //   582: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload_3
    //   587: astore 5
    //   589: aload 4
    //   591: ldc_w 427
    //   594: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_3
    //   599: astore 5
    //   601: aload 4
    //   603: aload_0
    //   604: getfield 92	com/loc/bm:i	Ljava/lang/String;
    //   607: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload_3
    //   612: astore 5
    //   614: new 347	com/loc/k
    //   617: dup
    //   618: aload 4
    //   620: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: aload_3
    //   624: aload_0
    //   625: getfield 92	com/loc/bm:i	Ljava/lang/String;
    //   628: invokespecial 430	com/loc/k:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   631: astore_1
    //   632: aload_3
    //   633: astore 5
    //   635: aload_1
    //   636: iload_2
    //   637: invokevirtual 432	com/loc/k:a	(I)V
    //   640: aload_3
    //   641: astore 5
    //   643: aload_1
    //   644: athrow
    //   645: astore 4
    //   647: aconst_null
    //   648: astore_1
    //   649: aload_1
    //   650: astore_3
    //   651: aload_3
    //   652: astore 6
    //   654: aload 8
    //   656: astore 5
    //   658: goto +56 -> 714
    //   661: aconst_null
    //   662: astore 4
    //   664: aload 4
    //   666: astore_3
    //   667: aload_3
    //   668: astore 6
    //   670: aload 7
    //   672: astore_1
    //   673: aload 5
    //   675: astore 8
    //   677: new 347	com/loc/k
    //   680: dup
    //   681: ldc_w 434
    //   684: aload 8
    //   686: aload_0
    //   687: getfield 92	com/loc/bm:i	Ljava/lang/String;
    //   690: invokespecial 430	com/loc/k:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   693: athrow
    //   694: astore 7
    //   696: aload 4
    //   698: astore 5
    //   700: aload 7
    //   702: astore 4
    //   704: aload 5
    //   706: astore 7
    //   708: aload_1
    //   709: astore 5
    //   711: aload 7
    //   713: astore_1
    //   714: aload 5
    //   716: ifnull +23 -> 739
    //   719: aload 5
    //   721: invokevirtual 408	java/io/ByteArrayOutputStream:close	()V
    //   724: goto +15 -> 739
    //   727: astore 5
    //   729: aload 5
    //   731: ldc 94
    //   733: ldc_w 410
    //   736: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   739: aload_1
    //   740: ifnull +20 -> 760
    //   743: aload_1
    //   744: invokevirtual 411	java/io/InputStream:close	()V
    //   747: goto +13 -> 760
    //   750: astore_1
    //   751: aload_1
    //   752: ldc 94
    //   754: ldc_w 410
    //   757: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload 6
    //   762: ifnull +21 -> 783
    //   765: aload 6
    //   767: invokevirtual 412	java/io/PushbackInputStream:close	()V
    //   770: goto +13 -> 783
    //   773: astore_1
    //   774: aload_1
    //   775: ldc 94
    //   777: ldc_w 410
    //   780: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload_3
    //   784: ifnull +20 -> 804
    //   787: aload_3
    //   788: invokevirtual 411	java/io/InputStream:close	()V
    //   791: goto +13 -> 804
    //   794: astore_1
    //   795: aload_1
    //   796: ldc 94
    //   798: ldc_w 410
    //   801: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   804: aload 4
    //   806: athrow
    //   807: astore_1
    //   808: goto -147 -> 661
    //   811: astore_1
    //   812: goto -323 -> 489
    //   815: astore_1
    //   816: goto -350 -> 466
    //   819: astore_1
    //   820: goto -380 -> 440
    //   823: aload 6
    //   825: astore_1
    //   826: goto -601 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	829	0	this	bm
    //   0	829	1	paramHttpURLConnection	HttpURLConnection
    //   42	595	2	m	int
    //   45	306	3	localObject1	Object
    //   362	2	3	localThrowable1	Throwable
    //   385	2	3	localThrowable2	Throwable
    //   403	2	3	localThrowable3	Throwable
    //   436	352	3	localObject2	Object
    //   2	617	4	localObject3	Object
    //   645	1	4	localObject4	Object
    //   662	143	4	localObject5	Object
    //   18	702	5	localObject6	Object
    //   727	3	5	localThrowable4	Throwable
    //   67	757	6	localObject7	Object
    //   5	456	7	localObject8	Object
    //   469	14	7	localObject9	Object
    //   493	178	7	localObject10	Object
    //   694	7	7	localObject11	Object
    //   706	6	7	localObject12	Object
    //   8	677	8	localObject13	Object
    //   14	417	9	localObject14	Object
    //   11	198	10	localObject15	Object
    //   32	291	11	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   354	359	362	java/lang/Throwable
    //   377	382	385	java/lang/Throwable
    //   395	400	403	java/lang/Throwable
    //   413	417	420	java/lang/Throwable
    //   155	159	433	finally
    //   167	174	433	finally
    //   182	188	433	finally
    //   212	222	433	finally
    //   231	238	433	finally
    //   244	251	433	finally
    //   262	271	433	finally
    //   280	283	433	finally
    //   289	298	433	finally
    //   304	314	433	finally
    //   320	327	433	finally
    //   333	342	433	finally
    //   348	354	433	finally
    //   135	147	447	finally
    //   129	135	469	finally
    //   20	24	645	finally
    //   28	34	645	finally
    //   38	43	645	finally
    //   55	69	645	finally
    //   84	94	645	finally
    //   98	110	645	finally
    //   120	129	645	finally
    //   517	529	645	finally
    //   532	542	645	finally
    //   545	554	645	finally
    //   557	564	645	finally
    //   567	576	645	finally
    //   579	586	645	finally
    //   589	598	645	finally
    //   601	611	645	finally
    //   614	632	645	finally
    //   635	640	645	finally
    //   643	645	645	finally
    //   677	694	694	finally
    //   719	724	727	java/lang/Throwable
    //   743	747	750	java/lang/Throwable
    //   765	770	773	java/lang/Throwable
    //   787	791	794	java/lang/Throwable
    //   20	24	807	java/io/IOException
    //   28	34	807	java/io/IOException
    //   38	43	807	java/io/IOException
    //   55	69	807	java/io/IOException
    //   84	94	807	java/io/IOException
    //   98	110	807	java/io/IOException
    //   120	129	807	java/io/IOException
    //   517	529	807	java/io/IOException
    //   532	542	807	java/io/IOException
    //   545	554	807	java/io/IOException
    //   557	564	807	java/io/IOException
    //   567	576	807	java/io/IOException
    //   579	586	807	java/io/IOException
    //   589	598	807	java/io/IOException
    //   601	611	807	java/io/IOException
    //   614	632	807	java/io/IOException
    //   635	640	807	java/io/IOException
    //   643	645	807	java/io/IOException
    //   129	135	811	java/io/IOException
    //   135	147	815	java/io/IOException
    //   155	159	819	java/io/IOException
    //   167	174	819	java/io/IOException
    //   182	188	819	java/io/IOException
    //   212	222	819	java/io/IOException
    //   231	238	819	java/io/IOException
    //   244	251	819	java/io/IOException
    //   262	271	819	java/io/IOException
    //   280	283	819	java/io/IOException
    //   289	298	819	java/io/IOException
    //   304	314	819	java/io/IOException
    //   320	327	819	java/io/IOException
    //   333	342	819	java/io/IOException
    //   348	354	819	java/io/IOException
  }
  
  /* Error */
  final bo a(String paramString1, boolean paramBoolean, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
    throws k
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 13
    //   21: aconst_null
    //   22: astore 14
    //   24: aconst_null
    //   25: astore 15
    //   27: aconst_null
    //   28: astore 6
    //   30: aload_0
    //   31: aload_1
    //   32: iload_2
    //   33: aload_3
    //   34: aload 4
    //   36: iconst_1
    //   37: invokespecial 449	com/loc/bm:a	(Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   40: astore_1
    //   41: aload 5
    //   43: ifnull +34 -> 77
    //   46: aload 5
    //   48: arraylength
    //   49: ifle +28 -> 77
    //   52: new 451	java/io/DataOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokevirtual 455	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   60: invokespecial 458	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore_3
    //   64: aload_3
    //   65: aload 5
    //   67: invokevirtual 460	java/io/DataOutputStream:write	([B)V
    //   70: aload_3
    //   71: invokevirtual 461	java/io/DataOutputStream:close	()V
    //   74: goto +3 -> 77
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 463	com/loc/bm:b	(Ljava/net/HttpURLConnection;)Lcom/loc/bo;
    //   82: astore_3
    //   83: aload_1
    //   84: ifnull +19 -> 103
    //   87: aload_1
    //   88: invokevirtual 466	java/net/HttpURLConnection:disconnect	()V
    //   91: aload_3
    //   92: areturn
    //   93: astore_1
    //   94: aload_1
    //   95: ldc 94
    //   97: ldc_w 468
    //   100: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_3
    //   104: areturn
    //   105: aload_1
    //   106: astore 6
    //   108: goto +75 -> 183
    //   111: astore_1
    //   112: goto +187 -> 299
    //   115: astore_3
    //   116: aload 7
    //   118: astore_1
    //   119: aload_1
    //   120: astore 6
    //   122: aload_3
    //   123: ldc 94
    //   125: ldc_w 468
    //   128: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_1
    //   132: astore 6
    //   134: new 347	com/loc/k
    //   137: dup
    //   138: ldc_w 470
    //   141: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   144: athrow
    //   145: aload_1
    //   146: astore 6
    //   148: aload_3
    //   149: ldc 94
    //   151: ldc_w 468
    //   154: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_1
    //   158: astore 6
    //   160: aload_3
    //   161: athrow
    //   162: aload_1
    //   163: astore 6
    //   165: aload_3
    //   166: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   169: aload_1
    //   170: astore 6
    //   172: new 347	com/loc/k
    //   175: dup
    //   176: ldc_w 434
    //   179: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: new 347	com/loc/k
    //   186: dup
    //   187: ldc_w 470
    //   190: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: aload_1
    //   195: astore 6
    //   197: aload_3
    //   198: invokevirtual 475	java/net/SocketTimeoutException:printStackTrace	()V
    //   201: aload_1
    //   202: astore 6
    //   204: new 347	com/loc/k
    //   207: dup
    //   208: ldc_w 477
    //   211: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   214: athrow
    //   215: aload_1
    //   216: astore 6
    //   218: aload_3
    //   219: invokevirtual 478	java/net/SocketException:printStackTrace	()V
    //   222: aload_1
    //   223: astore 6
    //   225: new 347	com/loc/k
    //   228: dup
    //   229: ldc_w 480
    //   232: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   235: athrow
    //   236: aload_1
    //   237: astore 6
    //   239: aload_3
    //   240: invokevirtual 481	java/net/UnknownHostException:printStackTrace	()V
    //   243: aload_1
    //   244: astore 6
    //   246: new 347	com/loc/k
    //   249: dup
    //   250: ldc_w 483
    //   253: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   256: athrow
    //   257: aload_1
    //   258: astore 6
    //   260: aload_3
    //   261: invokevirtual 484	java/net/MalformedURLException:printStackTrace	()V
    //   264: aload_1
    //   265: astore 6
    //   267: new 347	com/loc/k
    //   270: dup
    //   271: ldc_w 486
    //   274: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   277: athrow
    //   278: aload_1
    //   279: astore 6
    //   281: aload_3
    //   282: invokevirtual 487	java/net/ConnectException:printStackTrace	()V
    //   285: aload_1
    //   286: astore 6
    //   288: new 347	com/loc/k
    //   291: dup
    //   292: ldc_w 489
    //   295: invokespecial 471	com/loc/k:<init>	(Ljava/lang/String;)V
    //   298: athrow
    //   299: aload 6
    //   301: ifnull +21 -> 322
    //   304: aload 6
    //   306: invokevirtual 466	java/net/HttpURLConnection:disconnect	()V
    //   309: goto +13 -> 322
    //   312: astore_3
    //   313: aload_3
    //   314: ldc 94
    //   316: ldc_w 468
    //   319: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_1
    //   323: athrow
    //   324: astore_1
    //   325: aload 10
    //   327: astore 6
    //   329: goto -146 -> 183
    //   332: astore_3
    //   333: goto -228 -> 105
    //   336: astore_3
    //   337: aload_1
    //   338: astore 6
    //   340: aload_3
    //   341: astore_1
    //   342: goto -43 -> 299
    //   345: astore_3
    //   346: goto -227 -> 119
    //   349: astore_3
    //   350: goto -205 -> 145
    //   353: astore_3
    //   354: goto -192 -> 162
    //   357: astore_3
    //   358: goto -164 -> 194
    //   361: astore_3
    //   362: goto -147 -> 215
    //   365: astore_3
    //   366: goto -130 -> 236
    //   369: astore_3
    //   370: goto -113 -> 257
    //   373: astore_3
    //   374: goto -96 -> 278
    //   377: astore_3
    //   378: aload 8
    //   380: astore_1
    //   381: goto -236 -> 145
    //   384: astore_3
    //   385: aload 9
    //   387: astore_1
    //   388: goto -226 -> 162
    //   391: astore_3
    //   392: aload 11
    //   394: astore_1
    //   395: goto -201 -> 194
    //   398: astore_3
    //   399: aload 12
    //   401: astore_1
    //   402: goto -187 -> 215
    //   405: astore_3
    //   406: aload 13
    //   408: astore_1
    //   409: goto -173 -> 236
    //   412: astore_3
    //   413: aload 14
    //   415: astore_1
    //   416: goto -159 -> 257
    //   419: astore_3
    //   420: aload 15
    //   422: astore_1
    //   423: goto -145 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	bm
    //   0	426	1	paramString1	String
    //   0	426	2	paramBoolean	boolean
    //   0	426	3	paramString2	String
    //   0	426	4	paramMap	Map<String, String>
    //   0	426	5	paramArrayOfByte	byte[]
    //   28	311	6	localObject1	Object
    //   1	116	7	localObject2	Object
    //   4	375	8	localObject3	Object
    //   7	379	9	localObject4	Object
    //   10	316	10	localObject5	Object
    //   13	380	11	localObject6	Object
    //   16	384	12	localObject7	Object
    //   19	388	13	localObject8	Object
    //   22	392	14	localObject9	Object
    //   25	396	15	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   87	91	93	java/lang/Throwable
    //   30	41	111	finally
    //   122	131	111	finally
    //   134	145	111	finally
    //   148	157	111	finally
    //   160	162	111	finally
    //   165	169	111	finally
    //   172	183	111	finally
    //   183	194	111	finally
    //   197	201	111	finally
    //   204	215	111	finally
    //   218	222	111	finally
    //   225	236	111	finally
    //   239	243	111	finally
    //   246	257	111	finally
    //   260	264	111	finally
    //   267	278	111	finally
    //   281	285	111	finally
    //   288	299	111	finally
    //   30	41	115	java/lang/Throwable
    //   304	309	312	java/lang/Throwable
    //   30	41	324	java/io/InterruptedIOException
    //   46	74	332	java/io/InterruptedIOException
    //   77	83	332	java/io/InterruptedIOException
    //   46	74	336	finally
    //   77	83	336	finally
    //   46	74	345	java/lang/Throwable
    //   77	83	345	java/lang/Throwable
    //   46	74	349	com/loc/k
    //   77	83	349	com/loc/k
    //   46	74	353	java/io/IOException
    //   77	83	353	java/io/IOException
    //   46	74	357	java/net/SocketTimeoutException
    //   77	83	357	java/net/SocketTimeoutException
    //   46	74	361	java/net/SocketException
    //   77	83	361	java/net/SocketException
    //   46	74	365	java/net/UnknownHostException
    //   77	83	365	java/net/UnknownHostException
    //   46	74	369	java/net/MalformedURLException
    //   77	83	369	java/net/MalformedURLException
    //   46	74	373	java/net/ConnectException
    //   77	83	373	java/net/ConnectException
    //   30	41	377	com/loc/k
    //   30	41	384	java/io/IOException
    //   30	41	391	java/net/SocketTimeoutException
    //   30	41	398	java/net/SocketException
    //   30	41	405	java/net/UnknownHostException
    //   30	41	412	java/net/MalformedURLException
    //   30	41	419	java/net/ConnectException
  }
  
  final void a()
  {
    this.h = 0L;
  }
  
  /* Error */
  final void a(String paramString1, boolean paramBoolean, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, byte[] paramArrayOfByte, bl.a parama)
  {
    // Byte code:
    //   0: aload 7
    //   2: ifnonnull +4 -> 6
    //   5: return
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 14
    //   15: aload 5
    //   17: invokestatic 493	com/loc/bm:a	(Ljava/util/Map;)Ljava/lang/String;
    //   20: astore 5
    //   22: new 495	java/lang/StringBuffer
    //   25: dup
    //   26: invokespecial 496	java/lang/StringBuffer:<init>	()V
    //   29: astore 13
    //   31: aload 13
    //   33: aload_1
    //   34: invokevirtual 499	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   37: pop
    //   38: aload 5
    //   40: ifnull +20 -> 60
    //   43: aload 13
    //   45: ldc_w 501
    //   48: invokevirtual 499	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload 13
    //   54: aload 5
    //   56: invokevirtual 499	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   59: pop
    //   60: iconst_1
    //   61: istore 9
    //   63: aload 6
    //   65: ifnull +875 -> 940
    //   68: aload 6
    //   70: arraylength
    //   71: ifle +869 -> 940
    //   74: iconst_1
    //   75: istore 11
    //   77: goto +3 -> 80
    //   80: aload_0
    //   81: aload 13
    //   83: invokevirtual 502	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   86: iload_2
    //   87: aload_3
    //   88: aload 4
    //   90: iload 11
    //   92: invokespecial 449	com/loc/bm:a	(Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   95: astore 4
    //   97: new 149	java/lang/StringBuilder
    //   100: dup
    //   101: ldc_w 504
    //   104: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: astore_1
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 46	com/loc/bm:h	J
    //   113: invokevirtual 507	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_1
    //   118: ldc 79
    //   120: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: ldc_w 509
    //   129: aload_1
    //   130: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 304	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: iload 11
    //   138: ifeq +808 -> 946
    //   141: new 451	java/io/DataOutputStream
    //   144: dup
    //   145: aload 4
    //   147: invokevirtual 455	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   150: invokespecial 458	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   153: astore_1
    //   154: aload 15
    //   156: astore 5
    //   158: aload 4
    //   160: astore 12
    //   162: aload_1
    //   163: astore_3
    //   164: aload_1
    //   165: astore 13
    //   167: aload_1
    //   168: aload 6
    //   170: invokevirtual 460	java/io/DataOutputStream:write	([B)V
    //   173: aload 15
    //   175: astore 5
    //   177: aload 4
    //   179: astore 12
    //   181: aload_1
    //   182: astore_3
    //   183: aload_1
    //   184: astore 13
    //   186: aload_1
    //   187: invokevirtual 461	java/io/DataOutputStream:close	()V
    //   190: goto +3 -> 193
    //   193: aload 15
    //   195: astore 5
    //   197: aload 4
    //   199: astore 12
    //   201: aload_1
    //   202: astore_3
    //   203: aload_1
    //   204: astore 13
    //   206: aload 4
    //   208: invokevirtual 350	java/net/HttpURLConnection:connect	()V
    //   211: aload 15
    //   213: astore 5
    //   215: aload 4
    //   217: astore 12
    //   219: aload_1
    //   220: astore_3
    //   221: aload_1
    //   222: astore 13
    //   224: aload 4
    //   226: invokestatic 511	com/loc/bm:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   229: astore 6
    //   231: aload 15
    //   233: astore 5
    //   235: aload 4
    //   237: astore 12
    //   239: aload_1
    //   240: astore_3
    //   241: aload_1
    //   242: astore 13
    //   244: aload 4
    //   246: invokevirtual 353	java/net/HttpURLConnection:getResponseCode	()I
    //   249: istore 10
    //   251: iload 10
    //   253: sipush 200
    //   256: if_icmpeq +695 -> 951
    //   259: iconst_1
    //   260: istore 8
    //   262: goto +692 -> 954
    //   265: iload 9
    //   267: iload 8
    //   269: iand
    //   270: ifeq +190 -> 460
    //   273: aload 15
    //   275: astore 5
    //   277: aload 4
    //   279: astore 12
    //   281: aload_1
    //   282: astore_3
    //   283: aload_1
    //   284: astore 13
    //   286: new 149	java/lang/StringBuilder
    //   289: dup
    //   290: ldc_w 414
    //   293: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   296: astore 16
    //   298: aload 15
    //   300: astore 5
    //   302: aload 4
    //   304: astore 12
    //   306: aload_1
    //   307: astore_3
    //   308: aload_1
    //   309: astore 13
    //   311: aload 16
    //   313: aload 4
    //   315: invokevirtual 418	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   318: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 15
    //   324: astore 5
    //   326: aload 4
    //   328: astore 12
    //   330: aload_1
    //   331: astore_3
    //   332: aload_1
    //   333: astore 13
    //   335: aload 16
    //   337: ldc_w 420
    //   340: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 15
    //   346: astore 5
    //   348: aload 4
    //   350: astore 12
    //   352: aload_1
    //   353: astore_3
    //   354: aload_1
    //   355: astore 13
    //   357: aload 16
    //   359: iload 10
    //   361: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 15
    //   367: astore 5
    //   369: aload 4
    //   371: astore 12
    //   373: aload_1
    //   374: astore_3
    //   375: aload_1
    //   376: astore 13
    //   378: new 347	com/loc/k
    //   381: dup
    //   382: aload 16
    //   384: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: aload 6
    //   389: aload_0
    //   390: getfield 92	com/loc/bm:i	Ljava/lang/String;
    //   393: invokespecial 430	com/loc/k:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   396: pop
    //   397: aload 15
    //   399: astore 5
    //   401: aload 4
    //   403: astore 12
    //   405: aload_1
    //   406: astore_3
    //   407: aload_1
    //   408: astore 13
    //   410: aload 7
    //   412: invokeinterface 515 1 0
    //   417: aload 4
    //   419: ifnull +21 -> 440
    //   422: aload 4
    //   424: invokevirtual 466	java/net/HttpURLConnection:disconnect	()V
    //   427: goto +13 -> 440
    //   430: astore_3
    //   431: aload_3
    //   432: ldc 94
    //   434: ldc_w 517
    //   437: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload_1
    //   441: ifnull +18 -> 459
    //   444: aload_1
    //   445: invokevirtual 461	java/io/DataOutputStream:close	()V
    //   448: return
    //   449: astore_1
    //   450: aload_1
    //   451: ldc 94
    //   453: ldc_w 517
    //   456: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   459: return
    //   460: aload 15
    //   462: astore 5
    //   464: aload 4
    //   466: astore 12
    //   468: aload_1
    //   469: astore_3
    //   470: aload_1
    //   471: astore 13
    //   473: aload 4
    //   475: invokevirtual 360	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   478: astore 6
    //   480: sipush 1024
    //   483: newarray <illegal type>
    //   485: astore_3
    //   486: invokestatic 522	java/lang/Thread:interrupted	()Z
    //   489: ifne +117 -> 606
    //   492: aload_0
    //   493: getfield 40	com/loc/bm:f	Z
    //   496: ifne +110 -> 606
    //   499: aload 6
    //   501: aload_3
    //   502: iconst_0
    //   503: sipush 1024
    //   506: invokevirtual 525	java/io/InputStream:read	([BII)I
    //   509: istore 8
    //   511: iload 8
    //   513: ifle +93 -> 606
    //   516: aload_0
    //   517: getfield 44	com/loc/bm:g	J
    //   520: ldc2_w 41
    //   523: lcmp
    //   524: ifeq +15 -> 539
    //   527: aload_0
    //   528: getfield 46	com/loc/bm:h	J
    //   531: aload_0
    //   532: getfield 44	com/loc/bm:g	J
    //   535: lcmp
    //   536: ifge +70 -> 606
    //   539: iload 8
    //   541: sipush 1024
    //   544: if_icmpne +18 -> 562
    //   547: aload 7
    //   549: aload_3
    //   550: aload_0
    //   551: getfield 46	com/loc/bm:h	J
    //   554: invokeinterface 528 4 0
    //   559: goto +32 -> 591
    //   562: iload 8
    //   564: newarray <illegal type>
    //   566: astore 5
    //   568: aload_3
    //   569: iconst_0
    //   570: aload 5
    //   572: iconst_0
    //   573: iload 8
    //   575: invokestatic 534	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   578: aload 7
    //   580: aload 5
    //   582: aload_0
    //   583: getfield 46	com/loc/bm:h	J
    //   586: invokeinterface 528 4 0
    //   591: aload_0
    //   592: aload_0
    //   593: getfield 46	com/loc/bm:h	J
    //   596: iload 8
    //   598: i2l
    //   599: ladd
    //   600: putfield 46	com/loc/bm:h	J
    //   603: goto -117 -> 486
    //   606: aload_0
    //   607: getfield 40	com/loc/bm:f	Z
    //   610: ifeq +13 -> 623
    //   613: aload 7
    //   615: invokeinterface 535 1 0
    //   620: goto +10 -> 630
    //   623: aload 7
    //   625: invokeinterface 536 1 0
    //   630: aload 6
    //   632: ifnull +21 -> 653
    //   635: aload 6
    //   637: invokevirtual 411	java/io/InputStream:close	()V
    //   640: goto +13 -> 653
    //   643: astore_3
    //   644: aload_3
    //   645: ldc 94
    //   647: ldc_w 517
    //   650: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload 4
    //   655: ifnull +21 -> 676
    //   658: aload 4
    //   660: invokevirtual 466	java/net/HttpURLConnection:disconnect	()V
    //   663: goto +13 -> 676
    //   666: astore_3
    //   667: aload_3
    //   668: ldc 94
    //   670: ldc_w 517
    //   673: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload_1
    //   677: ifnull +18 -> 695
    //   680: aload_1
    //   681: invokevirtual 461	java/io/DataOutputStream:close	()V
    //   684: return
    //   685: astore_1
    //   686: aload_1
    //   687: ldc 94
    //   689: ldc_w 517
    //   692: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   695: return
    //   696: astore_3
    //   697: aload 6
    //   699: astore 5
    //   701: goto +143 -> 844
    //   704: goto +46 -> 750
    //   707: astore_3
    //   708: aconst_null
    //   709: astore_1
    //   710: aload 12
    //   712: astore 5
    //   714: goto +130 -> 844
    //   717: aconst_null
    //   718: astore_1
    //   719: aload 14
    //   721: astore 6
    //   723: goto +27 -> 750
    //   726: astore_3
    //   727: aconst_null
    //   728: astore 4
    //   730: aload 4
    //   732: astore_1
    //   733: aload 12
    //   735: astore 5
    //   737: goto +107 -> 844
    //   740: aconst_null
    //   741: astore 4
    //   743: aload 4
    //   745: astore_1
    //   746: aload 14
    //   748: astore 6
    //   750: aload 6
    //   752: astore 5
    //   754: aload 4
    //   756: astore 12
    //   758: aload_1
    //   759: astore_3
    //   760: aload 7
    //   762: invokeinterface 515 1 0
    //   767: aload 6
    //   769: ifnull +21 -> 790
    //   772: aload 6
    //   774: invokevirtual 411	java/io/InputStream:close	()V
    //   777: goto +13 -> 790
    //   780: astore_3
    //   781: aload_3
    //   782: ldc 94
    //   784: ldc_w 517
    //   787: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   790: aload 4
    //   792: ifnull +21 -> 813
    //   795: aload 4
    //   797: invokevirtual 466	java/net/HttpURLConnection:disconnect	()V
    //   800: goto +13 -> 813
    //   803: astore_3
    //   804: aload_3
    //   805: ldc 94
    //   807: ldc_w 517
    //   810: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload_1
    //   814: ifnull +18 -> 832
    //   817: aload_1
    //   818: invokevirtual 461	java/io/DataOutputStream:close	()V
    //   821: return
    //   822: astore_1
    //   823: aload_1
    //   824: ldc 94
    //   826: ldc_w 517
    //   829: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   832: return
    //   833: astore 6
    //   835: aload_3
    //   836: astore_1
    //   837: aload 12
    //   839: astore 4
    //   841: aload 6
    //   843: astore_3
    //   844: aload 5
    //   846: ifnull +23 -> 869
    //   849: aload 5
    //   851: invokevirtual 411	java/io/InputStream:close	()V
    //   854: goto +15 -> 869
    //   857: astore 5
    //   859: aload 5
    //   861: ldc 94
    //   863: ldc_w 517
    //   866: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   869: aload 4
    //   871: ifnull +23 -> 894
    //   874: aload 4
    //   876: invokevirtual 466	java/net/HttpURLConnection:disconnect	()V
    //   879: goto +15 -> 894
    //   882: astore 4
    //   884: aload 4
    //   886: ldc 94
    //   888: ldc_w 517
    //   891: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   894: aload_1
    //   895: ifnull +20 -> 915
    //   898: aload_1
    //   899: invokevirtual 461	java/io/DataOutputStream:close	()V
    //   902: goto +13 -> 915
    //   905: astore_1
    //   906: aload_1
    //   907: ldc 94
    //   909: ldc_w 517
    //   912: invokestatic 101	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   915: aload_3
    //   916: athrow
    //   917: astore_1
    //   918: goto -178 -> 740
    //   921: astore_1
    //   922: goto -205 -> 717
    //   925: astore_1
    //   926: aload 14
    //   928: astore 6
    //   930: aload 13
    //   932: astore_1
    //   933: goto -183 -> 750
    //   936: astore_3
    //   937: goto -233 -> 704
    //   940: iconst_0
    //   941: istore 11
    //   943: goto -863 -> 80
    //   946: aconst_null
    //   947: astore_1
    //   948: goto -755 -> 193
    //   951: iconst_0
    //   952: istore 8
    //   954: iload 10
    //   956: sipush 206
    //   959: if_icmpeq +6 -> 965
    //   962: goto -697 -> 265
    //   965: iconst_0
    //   966: istore 9
    //   968: goto -703 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	971	0	this	bm
    //   0	971	1	paramString1	String
    //   0	971	2	paramBoolean	boolean
    //   0	971	3	paramString2	String
    //   0	971	4	paramMap1	Map<String, String>
    //   0	971	5	paramMap2	Map<String, String>
    //   0	971	6	paramArrayOfByte	byte[]
    //   0	971	7	parama	bl.a
    //   260	693	8	m	int
    //   61	906	9	n	int
    //   249	711	10	i1	int
    //   75	867	11	bool	boolean
    //   10	828	12	localMap	Map<String, String>
    //   29	902	13	localObject1	Object
    //   13	914	14	localObject2	Object
    //   7	454	15	localObject3	Object
    //   296	87	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   422	427	430	java/lang/Throwable
    //   444	448	449	java/lang/Throwable
    //   635	640	643	java/io/IOException
    //   635	640	643	java/lang/Throwable
    //   658	663	666	java/lang/Throwable
    //   680	684	685	java/lang/Throwable
    //   480	486	696	finally
    //   486	511	696	finally
    //   516	539	696	finally
    //   547	559	696	finally
    //   562	591	696	finally
    //   591	603	696	finally
    //   606	620	696	finally
    //   623	630	696	finally
    //   97	136	707	finally
    //   141	154	707	finally
    //   15	38	726	finally
    //   43	60	726	finally
    //   68	74	726	finally
    //   80	97	726	finally
    //   772	777	780	java/io/IOException
    //   772	777	780	java/lang/Throwable
    //   795	800	803	java/lang/Throwable
    //   817	821	822	java/lang/Throwable
    //   167	173	833	finally
    //   186	190	833	finally
    //   206	211	833	finally
    //   224	231	833	finally
    //   244	251	833	finally
    //   286	298	833	finally
    //   311	322	833	finally
    //   335	344	833	finally
    //   357	365	833	finally
    //   378	397	833	finally
    //   410	417	833	finally
    //   473	480	833	finally
    //   760	767	833	finally
    //   849	854	857	java/io/IOException
    //   849	854	857	java/lang/Throwable
    //   874	879	882	java/lang/Throwable
    //   898	902	905	java/lang/Throwable
    //   15	38	917	java/lang/Throwable
    //   43	60	917	java/lang/Throwable
    //   68	74	917	java/lang/Throwable
    //   80	97	917	java/lang/Throwable
    //   97	136	921	java/lang/Throwable
    //   141	154	921	java/lang/Throwable
    //   167	173	925	java/lang/Throwable
    //   186	190	925	java/lang/Throwable
    //   206	211	925	java/lang/Throwable
    //   224	231	925	java/lang/Throwable
    //   244	251	925	java/lang/Throwable
    //   286	298	925	java/lang/Throwable
    //   311	322	925	java/lang/Throwable
    //   335	344	925	java/lang/Throwable
    //   357	365	925	java/lang/Throwable
    //   378	397	925	java/lang/Throwable
    //   410	417	925	java/lang/Throwable
    //   473	480	925	java/lang/Throwable
    //   480	486	936	java/lang/Throwable
    //   486	511	936	java/lang/Throwable
    //   516	539	936	java/lang/Throwable
    //   547	559	936	java/lang/Throwable
    //   562	591	936	java/lang/Throwable
    //   591	603	936	java/lang/Throwable
    //   606	620	936	java/lang/Throwable
    //   623	630	936	java/lang/Throwable
  }
  
  final void b()
  {
    this.g = -1L;
  }
  
  private static final class a
  {
    private Vector<bm.b> a = new Vector();
    private volatile bm.b b = new bm.b((byte)0);
    
    public final bm.b a()
    {
      return this.b;
    }
    
    public final bm.b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return this.b;
      }
      int i = 0;
      while (i < this.a.size())
      {
        localb = (bm.b)this.a.get(i);
        if ((localb != null) && (localb.a().equals(paramString))) {
          return localb;
        }
        i += 1;
      }
      bm.b localb = new bm.b((byte)0);
      localb.b(paramString);
      this.a.add(localb);
      return localb;
    }
    
    public final void b(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.b.a(paramString);
    }
  }
  
  private static final class b
    implements HostnameVerifier
  {
    private String a;
    private String b;
    
    public final String a()
    {
      return this.b;
    }
    
    public final void a(String paramString)
    {
      this.a = paramString;
    }
    
    public final void b(String paramString)
    {
      this.b = paramString;
    }
    
    public final boolean verify(String paramString, SSLSession paramSSLSession)
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */