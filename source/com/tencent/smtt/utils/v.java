package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class v
{
  private static v c;
  private Context a = null;
  private File b = null;
  private String d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
  private String f = "http://wup.imtt.qq.com:8080";
  private String g = "http://log.tbs.qq.com/ajax?c=dl&k=";
  private String h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String j = "http://mqqad.html5.qq.com/adjs";
  private String k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
  
  @TargetApi(11)
  private v(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    g();
  }
  
  public static v a()
  {
    try
    {
      v localv = c;
      return localv;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static v a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new v(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 97	com/tencent/smtt/utils/v:h	()Ljava/io/File;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +13 -> 21
    //   11: ldc 67
    //   13: ldc 99
    //   15: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: new 103	java/io/BufferedInputStream
    //   24: dup
    //   25: new 105	java/io/FileInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: new 113	java/util/Properties
    //   42: dup
    //   43: invokespecial 114	java/util/Properties:<init>	()V
    //   46: astore_3
    //   47: aload_2
    //   48: astore_1
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 117	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_2
    //   55: astore_1
    //   56: aload_3
    //   57: ldc 119
    //   59: ldc 121
    //   61: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 4
    //   66: aload_2
    //   67: astore_1
    //   68: ldc 121
    //   70: aload 4
    //   72: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifne +11 -> 86
    //   78: aload_2
    //   79: astore_1
    //   80: aload_0
    //   81: aload 4
    //   83: putfield 37	com/tencent/smtt/utils/v:d	Ljava/lang/String;
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: ldc -123
    //   91: ldc 121
    //   93: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload_2
    //   99: astore_1
    //   100: ldc 121
    //   102: aload 4
    //   104: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +11 -> 118
    //   110: aload_2
    //   111: astore_1
    //   112: aload_0
    //   113: aload 4
    //   115: putfield 45	com/tencent/smtt/utils/v:f	Ljava/lang/String;
    //   118: aload_2
    //   119: astore_1
    //   120: aload_3
    //   121: ldc -121
    //   123: ldc 121
    //   125: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 4
    //   130: aload_2
    //   131: astore_1
    //   132: ldc 121
    //   134: aload 4
    //   136: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifne +11 -> 150
    //   142: aload_2
    //   143: astore_1
    //   144: aload_0
    //   145: aload 4
    //   147: putfield 49	com/tencent/smtt/utils/v:g	Ljava/lang/String;
    //   150: aload_2
    //   151: astore_1
    //   152: aload_3
    //   153: ldc -119
    //   155: ldc 121
    //   157: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 4
    //   162: aload_2
    //   163: astore_1
    //   164: ldc 121
    //   166: aload 4
    //   168: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +11 -> 182
    //   174: aload_2
    //   175: astore_1
    //   176: aload_0
    //   177: aload 4
    //   179: putfield 53	com/tencent/smtt/utils/v:h	Ljava/lang/String;
    //   182: aload_2
    //   183: astore_1
    //   184: aload_3
    //   185: ldc -117
    //   187: ldc 121
    //   189: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 4
    //   194: aload_2
    //   195: astore_1
    //   196: ldc 121
    //   198: aload 4
    //   200: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   203: ifne +11 -> 214
    //   206: aload_2
    //   207: astore_1
    //   208: aload_0
    //   209: aload 4
    //   211: putfield 57	com/tencent/smtt/utils/v:i	Ljava/lang/String;
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: ldc -115
    //   219: ldc 121
    //   221: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 4
    //   226: aload_2
    //   227: astore_1
    //   228: ldc 121
    //   230: aload 4
    //   232: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifne +11 -> 246
    //   238: aload_2
    //   239: astore_1
    //   240: aload_0
    //   241: aload 4
    //   243: putfield 61	com/tencent/smtt/utils/v:j	Ljava/lang/String;
    //   246: aload_2
    //   247: astore_1
    //   248: aload_3
    //   249: ldc -113
    //   251: ldc 121
    //   253: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   256: astore 4
    //   258: aload_2
    //   259: astore_1
    //   260: ldc 121
    //   262: aload 4
    //   264: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifne +11 -> 278
    //   270: aload_2
    //   271: astore_1
    //   272: aload_0
    //   273: aload 4
    //   275: putfield 65	com/tencent/smtt/utils/v:k	Ljava/lang/String;
    //   278: aload_2
    //   279: astore_1
    //   280: aload_3
    //   281: ldc -111
    //   283: ldc 121
    //   285: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   288: astore_3
    //   289: aload_2
    //   290: astore_1
    //   291: ldc 121
    //   293: aload_3
    //   294: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   297: ifne +10 -> 307
    //   300: aload_2
    //   301: astore_1
    //   302: aload_0
    //   303: aload_3
    //   304: putfield 41	com/tencent/smtt/utils/v:e	Ljava/lang/String;
    //   307: aload_2
    //   308: invokevirtual 148	java/io/BufferedInputStream:close	()V
    //   311: goto +107 -> 418
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   319: goto +99 -> 418
    //   322: astore_3
    //   323: goto +12 -> 335
    //   326: astore_1
    //   327: aconst_null
    //   328: astore_2
    //   329: goto +97 -> 426
    //   332: astore_3
    //   333: aconst_null
    //   334: astore_2
    //   335: aload_2
    //   336: astore_1
    //   337: new 153	java/io/StringWriter
    //   340: dup
    //   341: invokespecial 154	java/io/StringWriter:<init>	()V
    //   344: astore 4
    //   346: aload_2
    //   347: astore_1
    //   348: aload_3
    //   349: new 156	java/io/PrintWriter
    //   352: dup
    //   353: aload 4
    //   355: invokespecial 159	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   358: invokevirtual 162	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   361: aload_2
    //   362: astore_1
    //   363: new 164	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   370: astore_3
    //   371: aload_2
    //   372: astore_1
    //   373: aload_3
    //   374: ldc -89
    //   376: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_2
    //   381: astore_1
    //   382: aload_3
    //   383: aload 4
    //   385: invokevirtual 175	java/io/StringWriter:toString	()Ljava/lang/String;
    //   388: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_2
    //   393: astore_1
    //   394: ldc 67
    //   396: aload_3
    //   397: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_2
    //   404: ifnull +14 -> 418
    //   407: aload_2
    //   408: invokevirtual 148	java/io/BufferedInputStream:close	()V
    //   411: goto +7 -> 418
    //   414: astore_1
    //   415: goto -100 -> 315
    //   418: aload_0
    //   419: monitorexit
    //   420: return
    //   421: astore_3
    //   422: aload_1
    //   423: astore_2
    //   424: aload_3
    //   425: astore_1
    //   426: aload_2
    //   427: ifnull +19 -> 446
    //   430: aload_2
    //   431: invokevirtual 148	java/io/BufferedInputStream:close	()V
    //   434: goto +12 -> 446
    //   437: astore_1
    //   438: goto +10 -> 448
    //   441: astore_2
    //   442: aload_2
    //   443: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   446: aload_1
    //   447: athrow
    //   448: aload_0
    //   449: monitorexit
    //   450: aload_1
    //   451: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	v
    //   6	296	1	localObject1	Object
    //   314	2	1	localIOException1	java.io.IOException
    //   326	1	1	localObject2	Object
    //   336	58	1	localObject3	Object
    //   414	9	1	localIOException2	java.io.IOException
    //   425	1	1	localObject4	Object
    //   437	14	1	localObject5	Object
    //   36	395	2	localObject6	Object
    //   441	2	2	localIOException3	java.io.IOException
    //   46	258	3	localObject7	Object
    //   322	1	3	localThrowable1	Throwable
    //   332	17	3	localThrowable2	Throwable
    //   370	27	3	localStringBuilder	StringBuilder
    //   421	4	3	localObject8	Object
    //   64	320	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   307	311	314	java/io/IOException
    //   39	47	322	java/lang/Throwable
    //   49	54	322	java/lang/Throwable
    //   56	66	322	java/lang/Throwable
    //   68	78	322	java/lang/Throwable
    //   80	86	322	java/lang/Throwable
    //   88	98	322	java/lang/Throwable
    //   100	110	322	java/lang/Throwable
    //   112	118	322	java/lang/Throwable
    //   120	130	322	java/lang/Throwable
    //   132	142	322	java/lang/Throwable
    //   144	150	322	java/lang/Throwable
    //   152	162	322	java/lang/Throwable
    //   164	174	322	java/lang/Throwable
    //   176	182	322	java/lang/Throwable
    //   184	194	322	java/lang/Throwable
    //   196	206	322	java/lang/Throwable
    //   208	214	322	java/lang/Throwable
    //   216	226	322	java/lang/Throwable
    //   228	238	322	java/lang/Throwable
    //   240	246	322	java/lang/Throwable
    //   248	258	322	java/lang/Throwable
    //   260	270	322	java/lang/Throwable
    //   272	278	322	java/lang/Throwable
    //   280	289	322	java/lang/Throwable
    //   291	300	322	java/lang/Throwable
    //   302	307	322	java/lang/Throwable
    //   2	7	326	finally
    //   11	18	326	finally
    //   21	37	326	finally
    //   2	7	332	java/lang/Throwable
    //   11	18	332	java/lang/Throwable
    //   21	37	332	java/lang/Throwable
    //   407	411	414	java/io/IOException
    //   39	47	421	finally
    //   49	54	421	finally
    //   56	66	421	finally
    //   68	78	421	finally
    //   80	86	421	finally
    //   88	98	421	finally
    //   100	110	421	finally
    //   112	118	421	finally
    //   120	130	421	finally
    //   132	142	421	finally
    //   144	150	421	finally
    //   152	162	421	finally
    //   164	174	421	finally
    //   176	182	421	finally
    //   184	194	421	finally
    //   196	206	421	finally
    //   208	214	421	finally
    //   216	226	421	finally
    //   228	238	421	finally
    //   240	246	421	finally
    //   248	258	421	finally
    //   260	270	421	finally
    //   272	278	421	finally
    //   280	289	421	finally
    //   291	300	421	finally
    //   302	307	421	finally
    //   337	346	421	finally
    //   348	361	421	finally
    //   363	371	421	finally
    //   373	380	421	finally
    //   382	392	421	finally
    //   394	403	421	finally
    //   307	311	437	finally
    //   315	319	437	finally
    //   407	411	437	finally
    //   430	434	437	finally
    //   442	446	437	finally
    //   446	448	437	finally
    //   430	434	441	java/io/IOException
  }
  
  private File h()
  {
    StringWriter localStringWriter = null;
    Object localObject;
    try
    {
      if (this.b == null)
      {
        this.b = new File(k.a(this.a, 5));
        if (this.b == null) {
          break label207;
        }
        if (!this.b.isDirectory()) {
          return null;
        }
      }
      localObject = new File(this.b, "tbsnet.conf");
      StringBuilder localStringBuilder1;
      if (!((File)localObject).exists())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Get file(");
        localStringBuilder1.append(((File)localObject).getCanonicalPath());
        localStringBuilder1.append(") failed!");
        TbsLog.e("TbsCommonConfig", localStringBuilder1.toString());
        return null;
      }
      try
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("pathc:");
        localStringBuilder1.append(((File)localObject).getCanonicalPath());
        TbsLog.w("TbsCommonConfig", localStringBuilder1.toString());
        return (File)localObject;
      }
      catch (Throwable localThrowable1) {}
      localStringWriter = new StringWriter();
    }
    catch (Throwable localThrowable2)
    {
      localObject = localStringWriter;
    }
    localThrowable2.printStackTrace(new PrintWriter(localStringWriter));
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("exceptions occurred2:");
    localStringBuilder2.append(localStringWriter.toString());
    TbsLog.e("TbsCommonConfig", localStringBuilder2.toString());
    return (File)localObject;
    label207:
    return null;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */