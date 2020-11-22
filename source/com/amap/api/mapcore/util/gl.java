package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class gl
{
  private static WeakReference<ih> a;
  private static boolean b = true;
  private static WeakReference<jc> c;
  private static WeakReference<jc> d;
  private static String[] e = new String[10];
  private static int f = 0;
  private static boolean g = false;
  private static int h = 0;
  private static fv i;
  
  static fv a(Context paramContext, String paramString)
  {
    Object localObject = gh.b(paramContext);
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
        localObject = (fv)paramContext.next();
        if (gh.a(((fv)localObject).g(), paramString)) {
          return (fv)localObject;
        }
      }
      if (paramString.contains("com.amap.api.col")) {
        try
        {
          paramContext = fw.a();
          return paramContext;
        }
        catch (fj paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      if ((paramString.contains("com.amap.co")) || (paramString.contains("com.amap.opensdk.co")) || (paramString.contains("com.amap.location"))) {
        try
        {
          paramContext = fw.b();
          paramContext.a(true);
          return paramContext;
        }
        catch (fj paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      return null;
    }
    return null;
  }
  
  private static String a(Throwable paramThrowable)
  {
    return paramThrowable.toString();
  }
  
  /* Error */
  static String a(List<fv> paramList)
  {
    // Byte code:
    //   0: new 119	java/io/File
    //   3: dup
    //   4: ldc 121
    //   6: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: astore_3
    //   10: aload_3
    //   11: invokevirtual 127	java/io/File:exists	()Z
    //   14: ifne +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new 129	java/io/FileInputStream
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 138	java/io/InputStream:available	()I
    //   32: istore_1
    //   33: iload_1
    //   34: ldc -117
    //   36: if_icmple +13 -> 49
    //   39: aload_3
    //   40: iload_1
    //   41: ldc -117
    //   43: isub
    //   44: i2l
    //   45: invokevirtual 143	java/io/InputStream:skip	(J)J
    //   48: pop2
    //   49: new 145	com/amap/api/mapcore/util/hu
    //   52: dup
    //   53: aload_3
    //   54: getstatic 150	com/amap/api/mapcore/util/hv:a	Ljava/nio/charset/Charset;
    //   57: invokespecial 153	com/amap/api/mapcore/util/hu:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   60: astore 6
    //   62: iconst_0
    //   63: istore_1
    //   64: aload 6
    //   66: astore 4
    //   68: aload_3
    //   69: astore 5
    //   71: aload 6
    //   73: invokevirtual 155	com/amap/api/mapcore/util/hu:a	()Ljava/lang/String;
    //   76: invokevirtual 158	java/lang/String:trim	()Ljava/lang/String;
    //   79: astore 8
    //   81: iload_1
    //   82: istore_2
    //   83: aload 8
    //   85: astore 7
    //   87: aload 6
    //   89: astore 4
    //   91: aload_3
    //   92: astore 5
    //   94: aload 8
    //   96: ldc -96
    //   98: invokevirtual 86	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +41 -> 142
    //   104: aload 8
    //   106: astore 7
    //   108: aload 6
    //   110: astore 4
    //   112: aload_3
    //   113: astore 5
    //   115: aload 7
    //   117: ldc -94
    //   119: invokevirtual 166	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   122: ifne +459 -> 581
    //   125: aload 6
    //   127: astore 4
    //   129: aload_3
    //   130: astore 5
    //   132: aload 6
    //   134: invokevirtual 155	com/amap/api/mapcore/util/hu:a	()Ljava/lang/String;
    //   137: astore 7
    //   139: goto -31 -> 108
    //   142: aload 6
    //   144: astore 4
    //   146: aload_3
    //   147: astore 5
    //   149: aload 7
    //   151: ldc 52
    //   153: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifeq +10 -> 166
    //   159: iload_2
    //   160: ifeq +6 -> 166
    //   163: goto +186 -> 349
    //   166: iload_2
    //   167: istore_1
    //   168: iload_2
    //   169: ifeq -105 -> 64
    //   172: aload 6
    //   174: astore 4
    //   176: aload_3
    //   177: astore 5
    //   179: aload 7
    //   181: invokestatic 168	com/amap/api/mapcore/util/gl:a	(Ljava/lang/String;)V
    //   184: aload 6
    //   186: astore 4
    //   188: aload_3
    //   189: astore 5
    //   191: getstatic 35	com/amap/api/mapcore/util/gl:h	I
    //   194: iconst_5
    //   195: if_icmpne +6 -> 201
    //   198: goto +151 -> 349
    //   201: aload 6
    //   203: astore 4
    //   205: aload_3
    //   206: astore 5
    //   208: getstatic 33	com/amap/api/mapcore/util/gl:g	Z
    //   211: ifne +106 -> 317
    //   214: aload 6
    //   216: astore 4
    //   218: aload_3
    //   219: astore 5
    //   221: aload_0
    //   222: invokeinterface 62 1 0
    //   227: astore 8
    //   229: iload_2
    //   230: istore_1
    //   231: aload 6
    //   233: astore 4
    //   235: aload_3
    //   236: astore 5
    //   238: aload 8
    //   240: invokeinterface 68 1 0
    //   245: ifeq -181 -> 64
    //   248: aload 6
    //   250: astore 4
    //   252: aload_3
    //   253: astore 5
    //   255: aload 8
    //   257: invokeinterface 72 1 0
    //   262: checkcast 74	com/amap/api/mapcore/util/fv
    //   265: astore 9
    //   267: aload 6
    //   269: astore 4
    //   271: aload_3
    //   272: astore 5
    //   274: aload 9
    //   276: invokevirtual 77	com/amap/api/mapcore/util/fv:g	()[Ljava/lang/String;
    //   279: aload 7
    //   281: invokestatic 170	com/amap/api/mapcore/util/gh:b	([Ljava/lang/String;Ljava/lang/String;)Z
    //   284: putstatic 33	com/amap/api/mapcore/util/gl:g	Z
    //   287: aload 6
    //   289: astore 4
    //   291: aload_3
    //   292: astore 5
    //   294: getstatic 33	com/amap/api/mapcore/util/gl:g	Z
    //   297: ifeq -68 -> 229
    //   300: aload 6
    //   302: astore 4
    //   304: aload_3
    //   305: astore 5
    //   307: aload 9
    //   309: putstatic 172	com/amap/api/mapcore/util/gl:i	Lcom/amap/api/mapcore/util/fv;
    //   312: iload_2
    //   313: istore_1
    //   314: goto -250 -> 64
    //   317: aload 6
    //   319: astore 4
    //   321: aload_3
    //   322: astore 5
    //   324: getstatic 35	com/amap/api/mapcore/util/gl:h	I
    //   327: iconst_1
    //   328: iadd
    //   329: putstatic 35	com/amap/api/mapcore/util/gl:h	I
    //   332: iload_2
    //   333: istore_1
    //   334: goto -270 -> 64
    //   337: astore 4
    //   339: aload 6
    //   341: astore_0
    //   342: aload 4
    //   344: astore 6
    //   346: goto +75 -> 421
    //   349: aload 6
    //   351: invokevirtual 175	com/amap/api/mapcore/util/hu:close	()V
    //   354: goto +12 -> 366
    //   357: astore_0
    //   358: aload_0
    //   359: ldc -79
    //   361: ldc -77
    //   363: invokestatic 184	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_3
    //   367: invokevirtual 185	java/io/InputStream:close	()V
    //   370: goto +183 -> 553
    //   373: astore_0
    //   374: aload_0
    //   375: ldc -79
    //   377: ldc -77
    //   379: invokestatic 184	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   382: goto +171 -> 553
    //   385: astore_0
    //   386: aconst_null
    //   387: astore 4
    //   389: goto +82 -> 471
    //   392: astore 6
    //   394: aconst_null
    //   395: astore_0
    //   396: goto +25 -> 421
    //   399: aconst_null
    //   400: astore 6
    //   402: goto +121 -> 523
    //   405: astore_0
    //   406: aconst_null
    //   407: astore 4
    //   409: aload 4
    //   411: astore_3
    //   412: goto +59 -> 471
    //   415: astore 6
    //   417: aconst_null
    //   418: astore_0
    //   419: aload_0
    //   420: astore_3
    //   421: aload_0
    //   422: astore 4
    //   424: aload_3
    //   425: astore 5
    //   427: aload 6
    //   429: ldc -79
    //   431: ldc -77
    //   433: invokestatic 184	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload_0
    //   437: ifnull +19 -> 456
    //   440: aload_0
    //   441: invokevirtual 175	com/amap/api/mapcore/util/hu:close	()V
    //   444: goto +12 -> 456
    //   447: astore_0
    //   448: aload_0
    //   449: ldc -79
    //   451: ldc -77
    //   453: invokestatic 184	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload_3
    //   457: ifnull +96 -> 553
    //   460: aload_3
    //   461: invokevirtual 185	java/io/InputStream:close	()V
    //   464: goto +89 -> 553
    //   467: astore_0
    //   468: aload 5
    //   470: astore_3
    //   471: aload 4
    //   473: ifnull +22 -> 495
    //   476: aload 4
    //   478: invokevirtual 175	com/amap/api/mapcore/util/hu:close	()V
    //   481: goto +14 -> 495
    //   484: astore 4
    //   486: aload 4
    //   488: ldc -79
    //   490: ldc -77
    //   492: invokestatic 184	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   495: aload_3
    //   496: ifnull +19 -> 515
    //   499: aload_3
    //   500: invokevirtual 185	java/io/InputStream:close	()V
    //   503: goto +12 -> 515
    //   506: astore_3
    //   507: aload_3
    //   508: ldc -79
    //   510: ldc -77
    //   512: invokestatic 184	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload_0
    //   516: athrow
    //   517: aconst_null
    //   518: astore 6
    //   520: aload 6
    //   522: astore_3
    //   523: aload 6
    //   525: ifnull +20 -> 545
    //   528: aload 6
    //   530: invokevirtual 175	com/amap/api/mapcore/util/hu:close	()V
    //   533: goto +12 -> 545
    //   536: astore_0
    //   537: aload_0
    //   538: ldc -79
    //   540: ldc -77
    //   542: invokestatic 184	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload_3
    //   546: ifnull +7 -> 553
    //   549: aload_3
    //   550: invokevirtual 185	java/io/InputStream:close	()V
    //   553: getstatic 33	com/amap/api/mapcore/util/gl:g	Z
    //   556: ifeq +7 -> 563
    //   559: invokestatic 187	com/amap/api/mapcore/util/gl:b	()Ljava/lang/String;
    //   562: areturn
    //   563: aconst_null
    //   564: areturn
    //   565: astore_0
    //   566: goto -49 -> 517
    //   569: astore_0
    //   570: goto -171 -> 399
    //   573: astore_0
    //   574: goto -225 -> 349
    //   577: astore_0
    //   578: goto -55 -> 523
    //   581: iconst_1
    //   582: istore_2
    //   583: goto -441 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	paramList	List<fv>
    //   32	302	1	j	int
    //   82	501	2	k	int
    //   9	491	3	localObject1	Object
    //   506	2	3	localThrowable1	Throwable
    //   522	28	3	localObject2	Object
    //   66	254	4	localObject3	Object
    //   337	6	4	localThrowable2	Throwable
    //   387	90	4	localList	List<fv>
    //   484	3	4	localThrowable3	Throwable
    //   69	400	5	localObject4	Object
    //   60	290	6	localObject5	Object
    //   392	1	6	localThrowable4	Throwable
    //   400	1	6	localObject6	Object
    //   415	13	6	localThrowable5	Throwable
    //   518	11	6	localObject7	Object
    //   85	195	7	localObject8	Object
    //   79	177	8	localObject9	Object
    //   265	43	9	localfv	fv
    // Exception table:
    //   from	to	target	type
    //   71	81	337	java/lang/Throwable
    //   94	104	337	java/lang/Throwable
    //   115	125	337	java/lang/Throwable
    //   132	139	337	java/lang/Throwable
    //   149	159	337	java/lang/Throwable
    //   179	184	337	java/lang/Throwable
    //   191	198	337	java/lang/Throwable
    //   208	214	337	java/lang/Throwable
    //   221	229	337	java/lang/Throwable
    //   238	248	337	java/lang/Throwable
    //   255	267	337	java/lang/Throwable
    //   274	287	337	java/lang/Throwable
    //   294	300	337	java/lang/Throwable
    //   307	312	337	java/lang/Throwable
    //   324	332	337	java/lang/Throwable
    //   349	354	357	java/lang/Throwable
    //   366	370	373	java/lang/Throwable
    //   460	464	373	java/lang/Throwable
    //   549	553	373	java/lang/Throwable
    //   28	33	385	finally
    //   39	49	385	finally
    //   49	62	385	finally
    //   28	33	392	java/lang/Throwable
    //   39	49	392	java/lang/Throwable
    //   49	62	392	java/lang/Throwable
    //   0	17	405	finally
    //   19	28	405	finally
    //   0	17	415	java/lang/Throwable
    //   19	28	415	java/lang/Throwable
    //   440	444	447	java/lang/Throwable
    //   71	81	467	finally
    //   94	104	467	finally
    //   115	125	467	finally
    //   132	139	467	finally
    //   149	159	467	finally
    //   179	184	467	finally
    //   191	198	467	finally
    //   208	214	467	finally
    //   221	229	467	finally
    //   238	248	467	finally
    //   255	267	467	finally
    //   274	287	467	finally
    //   294	300	467	finally
    //   307	312	467	finally
    //   324	332	467	finally
    //   427	436	467	finally
    //   476	481	484	java/lang/Throwable
    //   499	503	506	java/lang/Throwable
    //   528	533	536	java/lang/Throwable
    //   0	17	565	java/io/FileNotFoundException
    //   19	28	565	java/io/FileNotFoundException
    //   28	33	569	java/io/FileNotFoundException
    //   39	49	569	java/io/FileNotFoundException
    //   49	62	569	java/io/FileNotFoundException
    //   71	81	573	java/io/EOFException
    //   94	104	573	java/io/EOFException
    //   115	125	573	java/io/EOFException
    //   132	139	573	java/io/EOFException
    //   149	159	573	java/io/EOFException
    //   179	184	573	java/io/EOFException
    //   191	198	573	java/io/EOFException
    //   208	214	573	java/io/EOFException
    //   221	229	573	java/io/EOFException
    //   238	248	573	java/io/EOFException
    //   255	267	573	java/io/EOFException
    //   274	287	573	java/io/EOFException
    //   294	300	573	java/io/EOFException
    //   307	312	573	java/io/EOFException
    //   324	332	573	java/io/EOFException
    //   71	81	577	java/io/FileNotFoundException
    //   94	104	577	java/io/FileNotFoundException
    //   115	125	577	java/io/FileNotFoundException
    //   132	139	577	java/io/FileNotFoundException
    //   149	159	577	java/io/FileNotFoundException
    //   179	184	577	java/io/FileNotFoundException
    //   191	198	577	java/io/FileNotFoundException
    //   208	214	577	java/io/FileNotFoundException
    //   221	229	577	java/io/FileNotFoundException
    //   238	248	577	java/io/FileNotFoundException
    //   255	267	577	java/io/FileNotFoundException
    //   274	287	577	java/io/FileNotFoundException
    //   294	300	577	java/io/FileNotFoundException
    //   307	312	577	java/io/FileNotFoundException
    //   324	332	577	java/io/FileNotFoundException
  }
  
  static void a(Context paramContext)
  {
    Object localObject = gh.b(paramContext);
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
        return;
      }
      return;
    }
  }
  
  private static void a(Context paramContext, fv paramfv, int paramInt, String paramString1, String paramString2)
  {
    String str = ip.a();
    paramfv = ip.a(paramContext, paramfv);
    paramString1 = ip.a(fk.a(paramContext), paramfv, str, paramInt, paramString1, paramString2);
    if (paramString1 != null)
    {
      if ("".equals(paramString1)) {
        return;
      }
      paramString2 = fs.c(paramString2);
      if (paramInt == 1)
      {
        paramfv = gh.b;
      }
      else if (paramInt == 2)
      {
        paramfv = gh.d;
      }
      else
      {
        if (paramInt != 0) {
          break label88;
        }
        paramfv = gh.c;
      }
      a(paramContext, paramString2, paramfv, paramString1);
      return;
      label88:
      return;
    }
  }
  
  public static void a(Context paramContext, fv paramfv, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (paramString2 != null)
    {
      if ("".equals(paramString2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramString2 != null)
      {
        localStringBuilder.append("class:");
        localStringBuilder.append(paramString2);
      }
      if (paramString3 != null)
      {
        localStringBuilder.append(" method:");
        localStringBuilder.append(paramString3);
        localStringBuilder.append("$");
        localStringBuilder.append("<br/>");
      }
      localStringBuilder.append(paramString1);
      a(paramContext, paramfv, paramInt, paramString2, localStringBuilder.toString());
      return;
    }
  }
  
  private static void a(Context paramContext, final jc paramjc, final String paramString)
  {
    gk.d().submit(new Runnable()
    {
      public void run()
      {
        try
        {
          try
          {
            ih localih = ip.a(gl.a());
            ip.a(this.a, localih, paramString, 1000, 40960, "1");
            localih.f = paramjc;
            if (localih.g == null) {
              localih.g = new it(new is(this.a, new ix(), new fz(new gb(new gd())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", new Object[] { fk.f(this.a), fp.w(this.a), fk.c(this.a), Build.MODEL, fk.b(this.a), fk.d(this.a), Build.VERSION.RELEASE }));
            }
            localih.h = 3600000;
            ii.a(localih);
            return;
          }
          finally {}
          return;
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "lg", "pul");
        }
      }
    });
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ih localih = ip.a(a);
    ip.a(paramContext, localih, paramString2, 1000, 40960, "1");
    if (localih.e == null) {
      localih.e = new fy(new fz(new gb(new gd())));
    }
    try
    {
      ii.a(paramString1, fw.a(paramString3.replaceAll("\n", "<br/>")), localih);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, Throwable paramThrowable, int paramInt, String paramString1, String paramString2)
  {
    String str = fw.a(paramThrowable);
    fv localfv = a(paramContext, str);
    if (!a(localfv)) {
      return;
    }
    str = str.replaceAll("\n", "<br/>");
    paramThrowable = a(paramThrowable);
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
        localStringBuilder.append("$");
        localStringBuilder.append("<br/>");
      }
      localStringBuilder.append(str);
      a(paramContext, localfv, paramInt, paramThrowable, localStringBuilder.toString());
      return;
    }
  }
  
  static void a(fv paramfv, Context paramContext, String paramString1, String paramString2)
  {
    if (!a(paramfv)) {
      return;
    }
    if (paramString1 != null)
    {
      if ("".equals(paramString1)) {
        return;
      }
      a(paramContext, paramfv, 1, paramString1, paramString2);
      return;
    }
  }
  
  private static void a(String paramString)
  {
    try
    {
      if (f > 9) {
        f = 0;
      }
      e[f] = paramString;
      f += 1;
      return;
    }
    catch (Throwable paramString)
    {
      gk.c(paramString, "alg", "aDa");
    }
  }
  
  private static boolean a(fv paramfv)
  {
    return (paramfv != null) && (paramfv.f());
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    try
    {
      j = f;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "alg", "gLI");
    }
    localStringBuilder.append(e[j]);
    j += 1;
    for (;;)
    {
      if (j < f)
      {
        localStringBuilder.append(e[j]);
        j += 1;
      }
      else
      {
        return localStringBuilder.toString();
        if ((j < 10) && (j <= 9)) {
          break;
        }
        j = 0;
      }
    }
  }
  
  static void b(Context paramContext)
  {
    ja localja = new ja(b);
    b = false;
    a(paramContext, localja, gh.c);
  }
  
  static void c(Context paramContext)
  {
    if ((c == null) || (c.get() == null)) {
      c = new WeakReference(new jb(paramContext, 3600000, "hKey", new jd(paramContext, false)));
    }
    a(paramContext, (jc)c.get(), gh.d);
  }
  
  static void d(Context paramContext)
  {
    if ((d == null) || (d.get() == null)) {
      d = new WeakReference(new jb(paramContext, 3600000, "gKey", new jd(paramContext, false)));
    }
    a(paramContext, (jc)d.get(), gh.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */