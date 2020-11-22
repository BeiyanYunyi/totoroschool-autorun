package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ak
{
  private static WeakReference<bp> a;
  private static boolean b = true;
  private static WeakReference<cj> c;
  private static WeakReference<cj> d;
  private static String[] e = new String[10];
  private static int f = 0;
  private static boolean g = false;
  private static int h = 0;
  private static v i;
  
  private static v a(Context paramContext, String paramString)
  {
    Object localObject = ah.b(paramContext);
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = new ArrayList();
    }
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return null;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (v)paramContext.next();
        if (ah.a(((v)localObject).f(), paramString)) {
          return (v)localObject;
        }
      }
      if (paramString.contains("com.amap.api.col")) {
        try
        {
          paramContext = w.a();
          return paramContext;
        }
        catch (k paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      if ((paramString.contains("com.amap.co")) || (paramString.contains("com.amap.opensdk.co")) || (paramString.contains("com.amap.location"))) {
        try
        {
          paramContext = w.b();
          paramContext.a(true);
          return paramContext;
        }
        catch (k paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    return null;
  }
  
  /* Error */
  private static String a(List<v> paramList)
  {
    // Byte code:
    //   0: new 114	java/io/File
    //   3: dup
    //   4: ldc 116
    //   6: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: aload 4
    //   13: invokevirtual 122	java/io/File:exists	()Z
    //   16: ifne +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 124	java/io/FileInputStream
    //   24: dup
    //   25: aload 4
    //   27: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore 4
    //   32: aload 4
    //   34: invokevirtual 133	java/io/InputStream:available	()I
    //   37: istore_1
    //   38: iload_1
    //   39: ldc -122
    //   41: if_icmple +14 -> 55
    //   44: aload 4
    //   46: iload_1
    //   47: ldc -122
    //   49: isub
    //   50: i2l
    //   51: invokevirtual 138	java/io/InputStream:skip	(J)J
    //   54: pop2
    //   55: new 140	com/loc/bg
    //   58: dup
    //   59: aload 4
    //   61: getstatic 145	com/loc/bh:a	Ljava/nio/charset/Charset;
    //   64: invokespecial 148	com/loc/bg:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_1
    //   71: aload 7
    //   73: astore 5
    //   75: aload 4
    //   77: astore 6
    //   79: aload 7
    //   81: invokevirtual 151	com/loc/bg:a	()Ljava/lang/String;
    //   84: invokevirtual 154	java/lang/String:trim	()Ljava/lang/String;
    //   87: astore 9
    //   89: iload_1
    //   90: istore_2
    //   91: aload 9
    //   93: astore 8
    //   95: aload 7
    //   97: astore 5
    //   99: aload 4
    //   101: astore 6
    //   103: aload 9
    //   105: ldc -100
    //   107: invokevirtual 86	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +43 -> 153
    //   113: aload 9
    //   115: astore 8
    //   117: aload 7
    //   119: astore 5
    //   121: aload 4
    //   123: astore 6
    //   125: aload 8
    //   127: ldc -98
    //   129: invokevirtual 162	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   132: ifne +557 -> 689
    //   135: aload 7
    //   137: astore 5
    //   139: aload 4
    //   141: astore 6
    //   143: aload 7
    //   145: invokevirtual 151	com/loc/bg:a	()Ljava/lang/String;
    //   148: astore 8
    //   150: goto -33 -> 117
    //   153: aload 7
    //   155: astore 5
    //   157: aload 4
    //   159: astore 6
    //   161: aload 8
    //   163: ldc 52
    //   165: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: istore_3
    //   169: iload_3
    //   170: ifeq +10 -> 180
    //   173: iload_2
    //   174: ifeq +6 -> 180
    //   177: goto +266 -> 443
    //   180: iload_2
    //   181: istore_1
    //   182: iload_2
    //   183: ifeq -112 -> 71
    //   186: aload 7
    //   188: astore 5
    //   190: aload 4
    //   192: astore 6
    //   194: getstatic 31	com/loc/ak:f	I
    //   197: bipush 9
    //   199: if_icmple +15 -> 214
    //   202: aload 7
    //   204: astore 5
    //   206: aload 4
    //   208: astore 6
    //   210: iconst_0
    //   211: putstatic 31	com/loc/ak:f	I
    //   214: aload 7
    //   216: astore 5
    //   218: aload 4
    //   220: astore 6
    //   222: getstatic 29	com/loc/ak:e	[Ljava/lang/String;
    //   225: getstatic 31	com/loc/ak:f	I
    //   228: aload 8
    //   230: aastore
    //   231: aload 7
    //   233: astore 5
    //   235: aload 4
    //   237: astore 6
    //   239: getstatic 31	com/loc/ak:f	I
    //   242: iconst_1
    //   243: iadd
    //   244: putstatic 31	com/loc/ak:f	I
    //   247: goto +22 -> 269
    //   250: astore 9
    //   252: aload 7
    //   254: astore 5
    //   256: aload 4
    //   258: astore 6
    //   260: aload 9
    //   262: ldc -92
    //   264: ldc -90
    //   266: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload 7
    //   271: astore 5
    //   273: aload 4
    //   275: astore 6
    //   277: getstatic 35	com/loc/ak:h	I
    //   280: iconst_5
    //   281: if_icmpne +6 -> 287
    //   284: goto +159 -> 443
    //   287: aload 7
    //   289: astore 5
    //   291: aload 4
    //   293: astore 6
    //   295: getstatic 33	com/loc/ak:g	Z
    //   298: ifne +112 -> 410
    //   301: aload 7
    //   303: astore 5
    //   305: aload 4
    //   307: astore 6
    //   309: aload_0
    //   310: invokeinterface 62 1 0
    //   315: astore 9
    //   317: iload_2
    //   318: istore_1
    //   319: aload 7
    //   321: astore 5
    //   323: aload 4
    //   325: astore 6
    //   327: aload 9
    //   329: invokeinterface 68 1 0
    //   334: ifeq -263 -> 71
    //   337: aload 7
    //   339: astore 5
    //   341: aload 4
    //   343: astore 6
    //   345: aload 9
    //   347: invokeinterface 72 1 0
    //   352: checkcast 74	com/loc/v
    //   355: astore 10
    //   357: aload 7
    //   359: astore 5
    //   361: aload 4
    //   363: astore 6
    //   365: aload 10
    //   367: invokevirtual 77	com/loc/v:f	()[Ljava/lang/String;
    //   370: aload 8
    //   372: invokestatic 173	com/loc/ah:b	([Ljava/lang/String;Ljava/lang/String;)Z
    //   375: istore_3
    //   376: aload 7
    //   378: astore 5
    //   380: aload 4
    //   382: astore 6
    //   384: iload_3
    //   385: putstatic 33	com/loc/ak:g	Z
    //   388: iload_3
    //   389: ifeq -72 -> 317
    //   392: aload 7
    //   394: astore 5
    //   396: aload 4
    //   398: astore 6
    //   400: aload 10
    //   402: putstatic 175	com/loc/ak:i	Lcom/loc/v;
    //   405: iload_2
    //   406: istore_1
    //   407: goto -336 -> 71
    //   410: aload 7
    //   412: astore 5
    //   414: aload 4
    //   416: astore 6
    //   418: getstatic 35	com/loc/ak:h	I
    //   421: iconst_1
    //   422: iadd
    //   423: putstatic 35	com/loc/ak:h	I
    //   426: iload_2
    //   427: istore_1
    //   428: goto -357 -> 71
    //   431: astore 5
    //   433: aload 7
    //   435: astore_0
    //   436: aload 5
    //   438: astore 7
    //   440: goto +78 -> 518
    //   443: aload 7
    //   445: invokevirtual 178	com/loc/bg:close	()V
    //   448: goto +12 -> 460
    //   451: astore_0
    //   452: aload_0
    //   453: ldc -92
    //   455: ldc -76
    //   457: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload 4
    //   462: invokevirtual 181	java/io/InputStream:close	()V
    //   465: goto +196 -> 661
    //   468: astore_0
    //   469: aload_0
    //   470: ldc -92
    //   472: ldc -76
    //   474: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   477: goto +184 -> 661
    //   480: astore_0
    //   481: aconst_null
    //   482: astore 5
    //   484: goto +88 -> 572
    //   487: astore 7
    //   489: aconst_null
    //   490: astore_0
    //   491: goto +27 -> 518
    //   494: aconst_null
    //   495: astore 7
    //   497: goto +132 -> 629
    //   500: astore_0
    //   501: aconst_null
    //   502: astore 5
    //   504: aload 5
    //   506: astore 4
    //   508: goto +64 -> 572
    //   511: astore 7
    //   513: aconst_null
    //   514: astore_0
    //   515: aload_0
    //   516: astore 4
    //   518: aload_0
    //   519: astore 5
    //   521: aload 4
    //   523: astore 6
    //   525: aload 7
    //   527: ldc -92
    //   529: ldc -76
    //   531: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload_0
    //   535: ifnull +19 -> 554
    //   538: aload_0
    //   539: invokevirtual 178	com/loc/bg:close	()V
    //   542: goto +12 -> 554
    //   545: astore_0
    //   546: aload_0
    //   547: ldc -92
    //   549: ldc -76
    //   551: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload 4
    //   556: ifnull +105 -> 661
    //   559: aload 4
    //   561: invokevirtual 181	java/io/InputStream:close	()V
    //   564: goto +97 -> 661
    //   567: astore_0
    //   568: aload 6
    //   570: astore 4
    //   572: aload 5
    //   574: ifnull +22 -> 596
    //   577: aload 5
    //   579: invokevirtual 178	com/loc/bg:close	()V
    //   582: goto +14 -> 596
    //   585: astore 5
    //   587: aload 5
    //   589: ldc -92
    //   591: ldc -76
    //   593: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   596: aload 4
    //   598: ifnull +22 -> 620
    //   601: aload 4
    //   603: invokevirtual 181	java/io/InputStream:close	()V
    //   606: goto +14 -> 620
    //   609: astore 4
    //   611: aload 4
    //   613: ldc -92
    //   615: ldc -76
    //   617: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload_0
    //   621: athrow
    //   622: aconst_null
    //   623: astore 7
    //   625: aload 7
    //   627: astore 4
    //   629: aload 7
    //   631: ifnull +20 -> 651
    //   634: aload 7
    //   636: invokevirtual 178	com/loc/bg:close	()V
    //   639: goto +12 -> 651
    //   642: astore_0
    //   643: aload_0
    //   644: ldc -92
    //   646: ldc -76
    //   648: invokestatic 171	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload 4
    //   653: ifnull +8 -> 661
    //   656: aload 4
    //   658: invokevirtual 181	java/io/InputStream:close	()V
    //   661: getstatic 33	com/loc/ak:g	Z
    //   664: ifeq +7 -> 671
    //   667: invokestatic 183	com/loc/ak:b	()Ljava/lang/String;
    //   670: areturn
    //   671: aconst_null
    //   672: areturn
    //   673: astore_0
    //   674: goto -52 -> 622
    //   677: astore_0
    //   678: goto -184 -> 494
    //   681: astore_0
    //   682: goto -239 -> 443
    //   685: astore_0
    //   686: goto -57 -> 629
    //   689: iconst_1
    //   690: istore_2
    //   691: goto -538 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	paramList	List<v>
    //   37	391	1	j	int
    //   90	601	2	k	int
    //   168	221	3	bool	boolean
    //   9	593	4	localObject1	Object
    //   609	3	4	localThrowable1	Throwable
    //   627	30	4	localObject2	Object
    //   73	340	5	localObject3	Object
    //   431	6	5	localThrowable2	Throwable
    //   482	96	5	localList	List<v>
    //   585	3	5	localThrowable3	Throwable
    //   77	492	6	localObject4	Object
    //   67	377	7	localObject5	Object
    //   487	1	7	localThrowable4	Throwable
    //   495	1	7	localObject6	Object
    //   511	15	7	localThrowable5	Throwable
    //   623	12	7	localObject7	Object
    //   93	278	8	str1	String
    //   87	27	9	str2	String
    //   250	11	9	localThrowable6	Throwable
    //   315	31	9	localIterator	Iterator
    //   355	46	10	localv	v
    // Exception table:
    //   from	to	target	type
    //   194	202	250	java/lang/Throwable
    //   210	214	250	java/lang/Throwable
    //   222	231	250	java/lang/Throwable
    //   239	247	250	java/lang/Throwable
    //   79	89	431	java/lang/Throwable
    //   103	113	431	java/lang/Throwable
    //   125	135	431	java/lang/Throwable
    //   143	150	431	java/lang/Throwable
    //   161	169	431	java/lang/Throwable
    //   260	269	431	java/lang/Throwable
    //   277	284	431	java/lang/Throwable
    //   295	301	431	java/lang/Throwable
    //   309	317	431	java/lang/Throwable
    //   327	337	431	java/lang/Throwable
    //   345	357	431	java/lang/Throwable
    //   365	376	431	java/lang/Throwable
    //   384	388	431	java/lang/Throwable
    //   400	405	431	java/lang/Throwable
    //   418	426	431	java/lang/Throwable
    //   443	448	451	java/lang/Throwable
    //   460	465	468	java/lang/Throwable
    //   559	564	468	java/lang/Throwable
    //   656	661	468	java/lang/Throwable
    //   32	38	480	finally
    //   44	55	480	finally
    //   55	69	480	finally
    //   32	38	487	java/lang/Throwable
    //   44	55	487	java/lang/Throwable
    //   55	69	487	java/lang/Throwable
    //   0	19	500	finally
    //   21	32	500	finally
    //   0	19	511	java/lang/Throwable
    //   21	32	511	java/lang/Throwable
    //   538	542	545	java/lang/Throwable
    //   79	89	567	finally
    //   103	113	567	finally
    //   125	135	567	finally
    //   143	150	567	finally
    //   161	169	567	finally
    //   194	202	567	finally
    //   210	214	567	finally
    //   222	231	567	finally
    //   239	247	567	finally
    //   260	269	567	finally
    //   277	284	567	finally
    //   295	301	567	finally
    //   309	317	567	finally
    //   327	337	567	finally
    //   345	357	567	finally
    //   365	376	567	finally
    //   384	388	567	finally
    //   400	405	567	finally
    //   418	426	567	finally
    //   525	534	567	finally
    //   577	582	585	java/lang/Throwable
    //   601	606	609	java/lang/Throwable
    //   634	639	642	java/lang/Throwable
    //   0	19	673	java/io/FileNotFoundException
    //   21	32	673	java/io/FileNotFoundException
    //   32	38	677	java/io/FileNotFoundException
    //   44	55	677	java/io/FileNotFoundException
    //   55	69	677	java/io/FileNotFoundException
    //   79	89	681	java/io/EOFException
    //   103	113	681	java/io/EOFException
    //   125	135	681	java/io/EOFException
    //   143	150	681	java/io/EOFException
    //   161	169	681	java/io/EOFException
    //   194	202	681	java/io/EOFException
    //   210	214	681	java/io/EOFException
    //   222	231	681	java/io/EOFException
    //   239	247	681	java/io/EOFException
    //   260	269	681	java/io/EOFException
    //   277	284	681	java/io/EOFException
    //   295	301	681	java/io/EOFException
    //   309	317	681	java/io/EOFException
    //   327	337	681	java/io/EOFException
    //   345	357	681	java/io/EOFException
    //   365	376	681	java/io/EOFException
    //   384	388	681	java/io/EOFException
    //   400	405	681	java/io/EOFException
    //   418	426	681	java/io/EOFException
    //   79	89	685	java/io/FileNotFoundException
    //   103	113	685	java/io/FileNotFoundException
    //   125	135	685	java/io/FileNotFoundException
    //   143	150	685	java/io/FileNotFoundException
    //   161	169	685	java/io/FileNotFoundException
    //   194	202	685	java/io/FileNotFoundException
    //   210	214	685	java/io/FileNotFoundException
    //   222	231	685	java/io/FileNotFoundException
    //   239	247	685	java/io/FileNotFoundException
    //   260	269	685	java/io/FileNotFoundException
    //   277	284	685	java/io/FileNotFoundException
    //   295	301	685	java/io/FileNotFoundException
    //   309	317	685	java/io/FileNotFoundException
    //   327	337	685	java/io/FileNotFoundException
    //   345	357	685	java/io/FileNotFoundException
    //   365	376	685	java/io/FileNotFoundException
    //   384	388	685	java/io/FileNotFoundException
    //   400	405	685	java/io/FileNotFoundException
    //   418	426	685	java/io/FileNotFoundException
  }
  
  static void a(Context paramContext)
  {
    Object localObject = ah.b(paramContext);
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = a((List)localObject);
      if ((localObject != null) && (!"".equals(localObject)))
      {
        if (i == null) {
          return;
        }
        a(paramContext, i, 2, "ANR", (String)localObject);
      }
    }
  }
  
  private static void a(Context paramContext, final cj paramcj, final String paramString)
  {
    aj.d().submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          try
          {
            bp localbp = bw.a(ak.a());
            bw.a(this.a, localbp, paramString, 1000, 40960, "1");
            localbp.f = paramcj;
            if (localbp.g == null) {
              localbp.g = new ca(new bz(this.a, new ce(), new z(new ab(new ad())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", new Object[] { l.f(this.a), p.w(this.a), l.c(this.a), Build.MODEL, l.b(this.a), l.d(this.a), Build.VERSION.RELEASE }));
            }
            localbp.h = 3600000;
            bq.a(localbp);
            return;
          }
          finally {}
          return;
        }
        catch (Throwable localThrowable)
        {
          aj.b(localThrowable, "lg", "pul");
        }
      }
    });
  }
  
  private static void a(Context paramContext, v paramv, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = w.a(System.currentTimeMillis());
    paramv = bw.a(paramContext, paramv);
    l.a(paramContext);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramv);
    localStringBuffer.append(",\"timestamp\":\"");
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("\",\"et\":\"");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("\",\"classname\":\"");
    localStringBuffer.append(paramString1);
    localStringBuffer.append("\",");
    localStringBuffer.append("\"detail\":\"");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("\"");
    paramString1 = localStringBuffer.toString();
    if (paramString1 != null)
    {
      if ("".equals(paramString1)) {
        return;
      }
      paramString2 = s.c(paramString2);
      if (paramInt == 1) {
        paramv = ah.b;
      }
      for (;;)
      {
        break;
        if (paramInt == 2)
        {
          paramv = ah.d;
        }
        else
        {
          if (paramInt != 0) {
            break label260;
          }
          paramv = ah.c;
        }
      }
      localObject = bw.a(a);
      bw.a(paramContext, (bp)localObject, paramv, 1000, 40960, "1");
      if (((bp)localObject).e == null) {
        ((bp)localObject).e = new y(new z(new ab(new ad())));
      }
    }
    try
    {
      bq.a(paramString2, w.a(paramString1.replaceAll("\n", "<br/>")), (bp)localObject);
      label260:
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, Throwable paramThrowable, int paramInt, String paramString1, String paramString2)
  {
    String str = w.a(paramThrowable);
    v localv = a(paramContext, str);
    if (!a(localv)) {
      return;
    }
    str = str.replaceAll("\n", "<br/>");
    paramThrowable = paramThrowable.toString();
    if (paramThrowable != null)
    {
      if ("".equals(paramThrowable)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramString1 != null)
      {
        localStringBuilder.append("class:");
        localStringBuilder.append(paramString1);
      }
      if (paramString2 != null)
      {
        localStringBuilder.append(" method:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("$<br/>");
      }
      localStringBuilder.append(str);
      a(paramContext, localv, paramInt, paramThrowable, localStringBuilder.toString());
    }
  }
  
  static void a(v paramv, Context paramContext, String paramString1, String paramString2)
  {
    if (!a(paramv)) {
      return;
    }
    if (paramString1 != null)
    {
      if ("".equals(paramString1)) {
        return;
      }
      a(paramContext, paramv, 1, paramString1, paramString2);
    }
  }
  
  private static boolean a(v paramv)
  {
    return (paramv != null) && (paramv.e());
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        j = f;
        if ((j < 10) && (j <= 9))
        {
          localStringBuilder.append(e[j]);
          j += 1;
          continue;
          if (j < f)
          {
            localStringBuilder.append(e[j]);
            j += 1;
            continue;
          }
          return localStringBuilder.toString();
        }
      }
      catch (Throwable localThrowable)
      {
        aj.b(localThrowable, "alg", "gLI");
      }
      int j = 0;
    }
  }
  
  static void b(Context paramContext)
  {
    ch localch = new ch(b);
    b = false;
    a(paramContext, localch, ah.c);
  }
  
  static void c(Context paramContext)
  {
    if ((c == null) || (c.get() == null)) {
      c = new WeakReference(new ci(paramContext, 3600000, "hKey", new ck(paramContext)));
    }
    a(paramContext, (cj)c.get(), ah.d);
  }
  
  static void d(Context paramContext)
  {
    if ((d == null) || (d.get() == null)) {
      d = new WeakReference(new ci(paramContext, 3600000, "gKey", new ck(paramContext)));
    }
    a(paramContext, (cj)d.get(), ah.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */