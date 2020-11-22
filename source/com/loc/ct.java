package com.loc;

import android.content.Context;
import android.net.wifi.ScanResult;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

public final class ct
{
  boolean a = false;
  boolean b = false;
  private Context c;
  private Object d = null;
  private int e = -1;
  private boolean f = false;
  
  public ct(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private static String a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sv", "4.8.0");
      localJSONObject.put("als", "S128DF1572465B890OE3F7A13167KLEI");
      localJSONObject.put("pn", l.c(paramContext));
      localJSONObject.put("ak", l.f(paramContext));
      localJSONObject.put("ud", p.i(paramContext));
      localJSONObject.put("au", p.b(paramContext));
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static String a(cs paramcs)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramcs != null)
      {
        cr localcr = paramcs.c();
        paramcs = paramcs.d();
        if (localcr != null) {
          localJSONObject.put("mainCgi", localcr.a());
        }
        if (paramcs != null) {
          localJSONObject.put("mainCgi2", paramcs.a());
        }
        paramcs = localJSONObject.toString();
        return paramcs;
      }
    }
    catch (Throwable paramcs)
    {
      dg.a(paramcs, "APSCoManager", "buildCgiJsonStr");
    }
    return null;
  }
  
  private void a(cs paramcs, List<ScanResult> paramList, co paramco, int paramInt)
  {
    try
    {
      if (!e()) {
        return;
      }
      if (!dn.a(paramco)) {
        return;
      }
      f();
      if (this.d != null)
      {
        paramcs = a(paramcs);
        paramList = a(paramList);
        if (paramInt == 1)
        {
          dj.a(this.d, "trainingFps", new Class[] { String.class, ScanResult[].class }, new Object[] { paramcs, paramList });
        }
        else
        {
          if (paramInt != 2) {
            break label177;
          }
          Class localClass1 = Double.TYPE;
          Class localClass2 = Double.TYPE;
          double d1 = paramco.getLatitude();
          double d2 = paramco.getLongitude();
          dj.a(this.d, "correctOfflineLocation", new Class[] { String.class, ScanResult[].class, localClass1, localClass2 }, new Object[] { paramcs, paramList, Double.valueOf(d1), Double.valueOf(d2) });
        }
        this.b = true;
      }
      label177:
      return;
    }
    catch (Throwable paramList)
    {
      paramco = new StringBuilder("action-");
      if (1 == paramInt) {
        paramcs = "training";
      } else {
        paramcs = "correct";
      }
      paramco.append(paramcs);
      dg.a(paramList, "APSCoManager", paramco.toString());
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = paramString2;
    if (!paramString2.endsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append((String)localObject);
    paramString2.append(paramString3);
    paramString2 = paramString2.toString();
    dn.e((String)localObject);
    dn.b(paramString1, paramString2);
  }
  
  public static boolean a()
  {
    try
    {
      Class.forName("com.amap.opensdk.co.CoManager");
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static ScanResult[] a(List<ScanResult> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          ScanResult[] arrayOfScanResult = new ScanResult[paramList.size()];
          int i = 0;
          while (i < paramList.size())
          {
            arrayOfScanResult[i] = ((ScanResult)paramList.get(i));
            i += 1;
          }
          return arrayOfScanResult;
        }
      }
      catch (Throwable paramList)
      {
        dg.a(paramList, "APSCoManager", "buildScanResults");
      }
    }
    return null;
  }
  
  private boolean e()
  {
    if (!df.t())
    {
      d();
      return false;
    }
    if (!df.u())
    {
      if (this.b)
      {
        try
        {
          if (this.d != null) {
            dj.a(this.d, "destroyOfflineLoc", new Object[0]);
          }
        }
        catch (Throwable localThrowable)
        {
          dg.a(localThrowable, "APSCoManager", "destroyOffline");
        }
        this.b = false;
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   4: ifnonnull +682 -> 686
    //   7: aload_0
    //   8: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   11: ldc -30
    //   13: ldc -28
    //   15: iconst_0
    //   16: invokestatic 233	com/loc/dm:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   19: istore_1
    //   20: aload_0
    //   21: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   24: ldc -30
    //   26: ldc -21
    //   28: lconst_0
    //   29: invokestatic 238	com/loc/dm:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   32: lstore_2
    //   33: iload_1
    //   34: ifeq +22 -> 56
    //   37: lload_2
    //   38: lconst_0
    //   39: lcmp
    //   40: ifeq +16 -> 56
    //   43: invokestatic 244	java/lang/System:currentTimeMillis	()J
    //   46: lload_2
    //   47: lsub
    //   48: ldc2_w 245
    //   51: lcmp
    //   52: ifge +4 -> 56
    //   55: return
    //   56: aload_0
    //   57: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   60: ldc -30
    //   62: ldc -28
    //   64: iload_1
    //   65: iconst_1
    //   66: iadd
    //   67: invokestatic 249	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   70: aload_0
    //   71: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   74: ldc -30
    //   76: ldc -21
    //   78: invokestatic 244	java/lang/System:currentTimeMillis	()J
    //   81: invokestatic 252	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V
    //   84: invokestatic 254	com/loc/ct:a	()Z
    //   87: ifeq +80 -> 167
    //   90: aload_0
    //   91: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   94: astore 6
    //   96: aload_0
    //   97: ldc -68
    //   99: invokestatic 192	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   102: iconst_1
    //   103: anewarray 121	java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: ldc_w 256
    //   111: aastore
    //   112: invokevirtual 260	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload 6
    //   123: aastore
    //   124: invokevirtual 266	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   127: putfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   130: aload_0
    //   131: invokespecial 269	com/loc/ct:g	()V
    //   134: aload_0
    //   135: getfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   138: ldc_w 271
    //   141: iconst_0
    //   142: anewarray 4	java/lang/Object
    //   145: invokestatic 222	com/loc/dj:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: goto +502 -> 651
    //   152: astore 6
    //   154: aload 6
    //   156: ldc 94
    //   158: ldc_w 273
    //   161: invokestatic 101	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   164: goto +487 -> 651
    //   167: aload_0
    //   168: getfield 29	com/loc/ct:f	Z
    //   171: ifne +452 -> 623
    //   174: invokestatic 276	com/loc/df:x	()Z
    //   177: ifeq +446 -> 623
    //   180: ldc_w 278
    //   183: ldc_w 280
    //   186: invokestatic 283	com/loc/dg:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/loc/v;
    //   189: astore 8
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   196: aload 8
    //   198: invokestatic 288	com/loc/dk:a	(Landroid/content/Context;Lcom/loc/v;)Z
    //   201: putfield 29	com/loc/ct:f	Z
    //   204: aload_0
    //   205: getfield 29	com/loc/ct:f	Z
    //   208: istore 4
    //   210: iload 4
    //   212: ifeq +411 -> 623
    //   215: aload_0
    //   216: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   219: aload 8
    //   221: invokestatic 293	com/loc/az:a	(Landroid/content/Context;Lcom/loc/v;)Ljava/lang/String;
    //   224: astore 9
    //   226: aload 9
    //   228: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: istore 4
    //   233: aconst_null
    //   234: astore 6
    //   236: iload 4
    //   238: ifeq +6 -> 244
    //   241: goto +298 -> 539
    //   244: new 301	java/lang/StringBuffer
    //   247: dup
    //   248: invokespecial 302	java/lang/StringBuffer:<init>	()V
    //   251: astore 7
    //   253: new 153	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   260: astore 10
    //   262: aload 10
    //   264: aload_0
    //   265: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   268: invokevirtual 306	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   271: invokevirtual 310	android/content/Context:getFilesDir	()Ljava/io/File;
    //   274: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   277: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: getstatic 176	java/io/File:separator	Ljava/lang/String;
    //   286: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 10
    //   292: ldc_w 315
    //   295: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 10
    //   301: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: astore 10
    //   306: aload 9
    //   308: aload 9
    //   310: getstatic 176	java/io/File:separator	Ljava/lang/String;
    //   313: invokevirtual 319	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   316: iconst_1
    //   317: iadd
    //   318: aload 9
    //   320: ldc_w 321
    //   323: invokevirtual 319	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   326: invokevirtual 325	java/lang/String:substring	(II)Ljava/lang/String;
    //   329: astore 11
    //   331: aload 10
    //   333: aload 11
    //   335: invokestatic 328	com/loc/dn:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   338: istore 4
    //   340: aload_0
    //   341: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   344: ldc -30
    //   346: ldc_w 330
    //   349: iconst_0
    //   350: invokestatic 333	com/loc/dm:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   353: istore 5
    //   355: iload 4
    //   357: ifeq +8 -> 365
    //   360: iload 5
    //   362: ifeq +25 -> 387
    //   365: aload_0
    //   366: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   369: ldc -30
    //   371: ldc_w 330
    //   374: iconst_0
    //   375: invokestatic 336	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   378: aload 9
    //   380: aload 10
    //   382: aload 11
    //   384: invokestatic 338	com/loc/ct:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   391: invokestatic 342	com/loc/w:a	(Landroid/content/Context;)Ljava/lang/String;
    //   394: astore 12
    //   396: aload 12
    //   398: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifeq +6 -> 407
    //   404: goto +135 -> 539
    //   407: aload 7
    //   409: aload 10
    //   411: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   414: pop
    //   415: aload 7
    //   417: getstatic 176	java/io/File:separator	Ljava/lang/String;
    //   420: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   423: pop
    //   424: aload 7
    //   426: aload 11
    //   428: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   431: pop
    //   432: aload 7
    //   434: getstatic 176	java/io/File:separator	Ljava/lang/String;
    //   437: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   440: pop
    //   441: aload 7
    //   443: ldc_w 347
    //   446: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   449: pop
    //   450: aload 7
    //   452: getstatic 176	java/io/File:separator	Ljava/lang/String;
    //   455: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   458: pop
    //   459: aload 7
    //   461: aload 12
    //   463: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   466: pop
    //   467: aload 7
    //   469: getstatic 176	java/io/File:separator	Ljava/lang/String;
    //   472: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   475: pop
    //   476: aload 7
    //   478: ldc_w 349
    //   481: invokevirtual 345	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   484: pop
    //   485: aload 7
    //   487: invokevirtual 350	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   490: astore 7
    //   492: new 172	java/io/File
    //   495: dup
    //   496: aload 7
    //   498: invokespecial 351	java/io/File:<init>	(Ljava/lang/String;)V
    //   501: astore 12
    //   503: aload 12
    //   505: invokevirtual 354	java/io/File:exists	()Z
    //   508: ifne +12 -> 520
    //   511: aload 9
    //   513: aload 10
    //   515: aload 11
    //   517: invokestatic 338	com/loc/ct:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload 12
    //   522: invokevirtual 354	java/io/File:exists	()Z
    //   525: istore 4
    //   527: iload 4
    //   529: ifne +6 -> 535
    //   532: goto +7 -> 539
    //   535: aload 7
    //   537: astore 6
    //   539: aload_0
    //   540: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   543: astore 7
    //   545: aload_0
    //   546: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   549: astore 9
    //   551: aload_0
    //   552: aload 7
    //   554: aload 8
    //   556: ldc -68
    //   558: aconst_null
    //   559: iconst_1
    //   560: anewarray 121	java/lang/Class
    //   563: dup
    //   564: iconst_0
    //   565: ldc_w 256
    //   568: aastore
    //   569: iconst_1
    //   570: anewarray 4	java/lang/Object
    //   573: dup
    //   574: iconst_0
    //   575: aload 9
    //   577: aastore
    //   578: invokestatic 357	com/loc/az:a	(Landroid/content/Context;Lcom/loc/v;Ljava/lang/String;Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   581: putfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   584: aload_0
    //   585: invokespecial 269	com/loc/ct:g	()V
    //   588: aload_0
    //   589: getfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   592: ifnull +31 -> 623
    //   595: aload 6
    //   597: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   600: ifne +23 -> 623
    //   603: aload_0
    //   604: getfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   607: ldc_w 359
    //   610: iconst_1
    //   611: anewarray 4	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: aload 6
    //   618: aastore
    //   619: invokestatic 222	com/loc/dj:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   622: pop
    //   623: aload_0
    //   624: iconst_1
    //   625: putfield 29	com/loc/ct:f	Z
    //   628: goto +23 -> 651
    //   631: astore 6
    //   633: goto +45 -> 678
    //   636: astore 6
    //   638: aload 6
    //   640: ldc 94
    //   642: ldc_w 361
    //   645: invokestatic 101	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   648: goto -25 -> 623
    //   651: aload_0
    //   652: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   655: ldc -30
    //   657: ldc -28
    //   659: iconst_0
    //   660: invokestatic 249	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   663: aload_0
    //   664: getfield 31	com/loc/ct:c	Landroid/content/Context;
    //   667: ldc -30
    //   669: ldc -21
    //   671: lconst_0
    //   672: invokestatic 252	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V
    //   675: goto +11 -> 686
    //   678: aload_0
    //   679: iconst_1
    //   680: putfield 29	com/loc/ct:f	Z
    //   683: aload 6
    //   685: athrow
    //   686: invokestatic 364	com/loc/df:w	()I
    //   689: istore_1
    //   690: aload_0
    //   691: getfield 27	com/loc/ct:e	I
    //   694: iload_1
    //   695: if_icmpne +4 -> 699
    //   698: return
    //   699: aload_0
    //   700: iload_1
    //   701: putfield 27	com/loc/ct:e	I
    //   704: aload_0
    //   705: getfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   708: ifnull +25 -> 733
    //   711: aload_0
    //   712: getfield 21	com/loc/ct:d	Ljava/lang/Object;
    //   715: ldc_w 366
    //   718: iconst_1
    //   719: anewarray 4	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: iload_1
    //   725: invokestatic 371	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   728: aastore
    //   729: invokestatic 222	com/loc/dj:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   732: pop
    //   733: return
    //   734: astore 6
    //   736: aload 6
    //   738: ldc 94
    //   740: ldc_w 373
    //   743: invokestatic 101	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   746: return
    //   747: astore 6
    //   749: aload 6
    //   751: ldc 94
    //   753: ldc_w 375
    //   756: invokestatic 101	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   759: return
    //   760: astore 6
    //   762: goto -139 -> 623
    //   765: astore 7
    //   767: goto -183 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	this	ct
    //   19	706	1	i	int
    //   32	15	2	l	long
    //   208	320	4	bool1	boolean
    //   353	8	5	bool2	boolean
    //   94	28	6	localContext	Context
    //   152	3	6	localThrowable1	Throwable
    //   234	383	6	localObject1	Object
    //   631	1	6	localObject2	Object
    //   636	48	6	localThrowable2	Throwable
    //   734	3	6	localThrowable3	Throwable
    //   747	3	6	localThrowable4	Throwable
    //   760	1	6	localThrowable5	Throwable
    //   251	302	7	localObject3	Object
    //   765	1	7	localThrowable6	Throwable
    //   189	366	8	localv	v
    //   224	352	9	localObject4	Object
    //   260	254	10	localObject5	Object
    //   329	187	11	str	String
    //   394	127	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   90	149	152	java/lang/Throwable
    //   167	210	631	finally
    //   215	233	631	finally
    //   244	355	631	finally
    //   365	387	631	finally
    //   387	404	631	finally
    //   407	520	631	finally
    //   520	527	631	finally
    //   539	584	631	finally
    //   584	623	631	finally
    //   638	648	631	finally
    //   167	210	636	java/lang/Throwable
    //   686	698	734	java/lang/Throwable
    //   699	733	734	java/lang/Throwable
    //   0	33	747	java/lang/Throwable
    //   43	55	747	java/lang/Throwable
    //   56	90	747	java/lang/Throwable
    //   154	164	747	java/lang/Throwable
    //   623	628	747	java/lang/Throwable
    //   651	675	747	java/lang/Throwable
    //   678	686	747	java/lang/Throwable
    //   736	746	747	java/lang/Throwable
    //   215	233	760	java/lang/Throwable
    //   244	355	760	java/lang/Throwable
    //   365	387	760	java/lang/Throwable
    //   387	404	760	java/lang/Throwable
    //   407	520	760	java/lang/Throwable
    //   520	527	760	java/lang/Throwable
    //   584	623	760	java/lang/Throwable
    //   539	584	765	java/lang/Throwable
  }
  
  private void g()
  {
    try
    {
      if (this.c == null) {
        return;
      }
      String str = a(this.c);
      if (this.d != null) {
        dj.a(this.d, "init", new Object[] { str });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "APSCoManager", "setConfig");
    }
  }
  
  public final co a(cs paramcs, List<ScanResult> paramList, co paramco)
  {
    try
    {
      if (!e()) {
        return paramco;
      }
      if ((paramco != null) && (paramco.getErrorCode() == 7)) {
        return paramco;
      }
      f();
      if (this.d != null)
      {
        this.b = true;
        paramcs = a(paramcs);
        paramList = a(paramList);
        Object localObject = Boolean.TYPE;
        paramcs = dj.a(this.d, "getOfflineLoc", new Class[] { String.class, ScanResult[].class, localObject }, new Object[] { paramcs, paramList, Boolean.valueOf(false) });
        if (paramcs != null)
        {
          paramcs = new JSONObject((String)paramcs);
          paramList = new co("lbs");
          paramList.b(paramcs);
          if (dn.a(paramList))
          {
            localObject = new StringBuffer();
            if (paramList.e().equals("file")) {
              paramcs = "基站离线定位";
            }
            for (;;)
            {
              ((StringBuffer)localObject).append(paramcs);
              break;
              if (paramList.e().equals("wifioff"))
              {
                paramcs = "WIFI离线定位";
              }
              else
              {
                ((StringBuffer)localObject).append("离线定位，");
                paramcs = paramList.e();
              }
            }
            if (paramco != null)
            {
              paramcs = new StringBuilder("，在线定位失败原因:");
              paramcs.append(paramco.getErrorInfo());
              ((StringBuffer)localObject).append(paramcs.toString());
            }
            paramList.setTrustedLevel(2);
            paramList.setLocationDetail(((StringBuffer)localObject).toString());
            paramList.setLocationType(8);
          }
          return paramList;
        }
      }
    }
    catch (Throwable paramcs)
    {
      dg.a(paramcs, "APSCoManager", "getOffLoc");
    }
    return paramco;
  }
  
  public final void b()
  {
    try
    {
      if (!df.t())
      {
        d();
        return;
      }
      if (!df.v())
      {
        boolean bool = this.a;
        if (bool)
        {
          try
          {
            if (this.d != null) {
              dj.a(this.d, "destroyCollect", new Object[0]);
            }
          }
          catch (Throwable localThrowable1)
          {
            dg.a(localThrowable1, "APSCoManager", "destroyCollection");
          }
          this.a = false;
        }
      }
      else
      {
        if (this.a) {
          return;
        }
        f();
        if (this.d != null)
        {
          dj.a(this.d, "startCollect", new Object[0]);
          this.a = true;
        }
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      dg.a(localThrowable2, "APSCoManager", "startCollection");
      return;
    }
  }
  
  public final void b(cs paramcs, List<ScanResult> paramList, co paramco)
  {
    try
    {
      a(paramcs, paramList, paramco, 1);
      return;
    }
    catch (Throwable paramcs)
    {
      dg.a(paramcs, "APSCoManager", "trainingFps");
    }
  }
  
  public final String c()
  {
    try
    {
      if (!df.t())
      {
        d();
        return null;
      }
      if (this.d != null)
      {
        String str = (String)dj.a(this.d, "getCollectVersion", new Object[0]);
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "APSCoManager", "getCollectionVersion");
    }
    return null;
  }
  
  public final void c(cs paramcs, List<ScanResult> paramList, co paramco)
  {
    try
    {
      a(paramcs, paramList, paramco, 2);
      return;
    }
    catch (Throwable paramcs)
    {
      dg.a(paramcs, "APSCoManager", "correctOffLoc");
    }
  }
  
  public final void d()
  {
    try
    {
      if (this.d != null) {
        dj.a(this.d, "destroy", new Object[0]);
      }
      this.a = false;
      this.b = false;
      this.d = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "APSCoManager", "destroy");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */