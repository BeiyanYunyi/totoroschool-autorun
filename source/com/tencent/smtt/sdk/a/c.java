package com.tencent.smtt.sdk.a;

import a.a;
import android.content.Context;

final class c
  extends Thread
{
  c(String paramString, Context paramContext, a parama)
  {
    super(paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 8
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: getstatic 43	com/tencent/smtt/sdk/a/b:a	[B
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_2
    //   17: ifnonnull +27 -> 44
    //   20: ldc 45
    //   22: ldc 47
    //   24: invokevirtual 53	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   27: putstatic 43	com/tencent/smtt/sdk/a/b:a	[B
    //   30: goto +14 -> 44
    //   33: aconst_null
    //   34: putstatic 43	com/tencent/smtt/sdk/a/b:a	[B
    //   37: ldc 55
    //   39: ldc 57
    //   41: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: getstatic 43	com/tencent/smtt/sdk/a/b:a	[B
    //   47: ifnonnull +11 -> 58
    //   50: ldc 55
    //   52: ldc 65
    //   54: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: return
    //   58: aload_0
    //   59: getfield 12	com/tencent/smtt/sdk/a/c:a	Landroid/content/Context;
    //   62: invokestatic 71	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   65: getfield 75	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   68: ldc 77
    //   70: ldc 79
    //   72: invokeinterface 85 3 0
    //   77: astore 5
    //   79: ldc 79
    //   81: astore_3
    //   82: ldc 79
    //   84: astore_2
    //   85: aload 5
    //   87: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +37 -> 127
    //   93: aload 5
    //   95: iconst_0
    //   96: aload 5
    //   98: ldc 93
    //   100: invokevirtual 97	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   103: invokevirtual 101	java/lang/String:substring	(II)Ljava/lang/String;
    //   106: astore_3
    //   107: aload 5
    //   109: aload 5
    //   111: ldc 93
    //   113: invokevirtual 97	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   116: iconst_1
    //   117: iadd
    //   118: aload 5
    //   120: invokevirtual 105	java/lang/String:length	()I
    //   123: invokevirtual 101	java/lang/String:substring	(II)Ljava/lang/String;
    //   126: astore_2
    //   127: aload_3
    //   128: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +36 -> 167
    //   134: aload_3
    //   135: invokevirtual 105	java/lang/String:length	()I
    //   138: bipush 96
    //   140: if_icmpne +27 -> 167
    //   143: aload_2
    //   144: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne +20 -> 167
    //   150: aload_2
    //   151: invokevirtual 105	java/lang/String:length	()I
    //   154: bipush 24
    //   156: if_icmpeq +6 -> 162
    //   159: goto +8 -> 167
    //   162: iconst_0
    //   163: istore_1
    //   164: goto +5 -> 169
    //   167: iconst_1
    //   168: istore_1
    //   169: invokestatic 110	com/tencent/smtt/utils/v:a	()Lcom/tencent/smtt/utils/v;
    //   172: astore 5
    //   174: iload_1
    //   175: ifeq +40 -> 215
    //   178: new 112	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   185: astore_3
    //   186: aload_3
    //   187: aload 5
    //   189: invokevirtual 117	com/tencent/smtt/utils/v:b	()Ljava/lang/String;
    //   192: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_3
    //   197: invokestatic 126	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   200: invokevirtual 127	com/tencent/smtt/utils/o:b	()Ljava/lang/String;
    //   203: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_3
    //   208: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore_3
    //   212: goto +36 -> 248
    //   215: new 112	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   222: astore 6
    //   224: aload 6
    //   226: aload 5
    //   228: invokevirtual 133	com/tencent/smtt/utils/v:f	()Ljava/lang/String;
    //   231: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 6
    //   237: aload_3
    //   238: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 6
    //   244: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore_3
    //   248: new 135	java/net/URL
    //   251: dup
    //   252: aload_3
    //   253: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
    //   256: invokevirtual 140	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   259: checkcast 142	java/net/HttpURLConnection
    //   262: astore 5
    //   264: aload 5
    //   266: ldc -112
    //   268: invokevirtual 147	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   271: aload 5
    //   273: iconst_1
    //   274: invokevirtual 151	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   277: aload 5
    //   279: iconst_1
    //   280: invokevirtual 154	java/net/HttpURLConnection:setDoInput	(Z)V
    //   283: aload 5
    //   285: iconst_0
    //   286: invokevirtual 157	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   289: aload 5
    //   291: sipush 20000
    //   294: invokevirtual 161	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   297: getstatic 38	android/os/Build$VERSION:SDK_INT	I
    //   300: bipush 13
    //   302: if_icmple +12 -> 314
    //   305: aload 5
    //   307: ldc -93
    //   309: ldc -91
    //   311: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_0
    //   315: getfield 14	com/tencent/smtt/sdk/a/c:b	La/a;
    //   318: aload_0
    //   319: getfield 12	com/tencent/smtt/sdk/a/c:a	Landroid/content/Context;
    //   322: invokestatic 171	com/tencent/smtt/sdk/a/b:b	(La/a;Landroid/content/Context;)Lorg/json/JSONObject;
    //   325: astore_3
    //   326: goto +11 -> 337
    //   329: astore_3
    //   330: aload_3
    //   331: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   334: aload 4
    //   336: astore_3
    //   337: aload_3
    //   338: ifnonnull +11 -> 349
    //   341: ldc 55
    //   343: ldc -80
    //   345: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: return
    //   349: aload_3
    //   350: invokevirtual 179	org/json/JSONObject:toString	()Ljava/lang/String;
    //   353: ldc 47
    //   355: invokevirtual 53	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   358: astore_3
    //   359: iload_1
    //   360: ifeq +14 -> 374
    //   363: invokestatic 126	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   366: aload_3
    //   367: invokevirtual 182	com/tencent/smtt/utils/o:a	([B)[B
    //   370: astore_2
    //   371: goto +9 -> 380
    //   374: aload_3
    //   375: aload_2
    //   376: invokestatic 185	com/tencent/smtt/utils/o:a	([BLjava/lang/String;)[B
    //   379: astore_2
    //   380: aload 5
    //   382: ldc -69
    //   384: ldc -67
    //   386: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 5
    //   391: ldc -65
    //   393: aload_2
    //   394: arraylength
    //   395: invokestatic 195	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   398: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload 5
    //   403: invokevirtual 199	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   406: astore_3
    //   407: aload_3
    //   408: aload_2
    //   409: invokevirtual 205	java/io/OutputStream:write	([B)V
    //   412: aload_3
    //   413: invokevirtual 208	java/io/OutputStream:flush	()V
    //   416: aload 5
    //   418: invokevirtual 211	java/net/HttpURLConnection:getResponseCode	()I
    //   421: sipush 200
    //   424: if_icmpne +4 -> 428
    //   427: return
    //   428: ldc 55
    //   430: ldc -43
    //   432: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: return
    //   436: astore_2
    //   437: new 112	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   444: astore_3
    //   445: aload_3
    //   446: ldc -41
    //   448: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_3
    //   453: aload_2
    //   454: invokevirtual 218	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: ldc 55
    //   463: aload_3
    //   464: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: return
    //   471: astore_2
    //   472: new 112	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   479: astore_3
    //   480: aload_3
    //   481: ldc -36
    //   483: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_3
    //   488: aload_2
    //   489: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: ldc 55
    //   495: aload_3
    //   496: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: return
    //   503: astore_2
    //   504: new 112	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   511: astore_3
    //   512: aload_3
    //   513: ldc -31
    //   515: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_3
    //   520: aload_2
    //   521: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: ldc 55
    //   527: aload_3
    //   528: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: return
    //   535: astore_2
    //   536: new 112	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   543: astore_3
    //   544: aload_3
    //   545: ldc -29
    //   547: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_3
    //   552: aload_2
    //   553: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: ldc 55
    //   559: aload_3
    //   560: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: return
    //   567: astore_2
    //   568: goto -535 -> 33
    //   571: astore_2
    //   572: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	c
    //   163	197	1	i	int
    //   12	397	2	localObject1	Object
    //   436	18	2	localThrowable1	Throwable
    //   471	18	2	localNoClassDefFoundError	NoClassDefFoundError
    //   503	18	2	localAssertionError	AssertionError
    //   535	18	2	localIOException	java.io.IOException
    //   567	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   571	1	2	localThrowable2	Throwable
    //   81	245	3	localObject2	Object
    //   329	2	3	localException	Exception
    //   336	224	3	localObject3	Object
    //   14	321	4	localObject4	Object
    //   77	340	5	localObject5	Object
    //   222	21	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   314	326	329	java/lang/Exception
    //   401	427	436	java/lang/Throwable
    //   428	435	436	java/lang/Throwable
    //   169	174	471	java/lang/NoClassDefFoundError
    //   178	212	471	java/lang/NoClassDefFoundError
    //   215	248	471	java/lang/NoClassDefFoundError
    //   248	271	471	java/lang/NoClassDefFoundError
    //   169	174	503	java/lang/AssertionError
    //   178	212	503	java/lang/AssertionError
    //   215	248	503	java/lang/AssertionError
    //   248	271	503	java/lang/AssertionError
    //   169	174	535	java/io/IOException
    //   178	212	535	java/io/IOException
    //   215	248	535	java/io/IOException
    //   248	271	535	java/io/IOException
    //   20	30	567	java/io/UnsupportedEncodingException
    //   349	359	571	java/lang/Throwable
    //   363	371	571	java/lang/Throwable
    //   374	380	571	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */