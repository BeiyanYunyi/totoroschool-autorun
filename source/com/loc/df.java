package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import org.json.JSONObject;

public final class df
{
  private static boolean A = true;
  private static int B = -1;
  private static long C = 0L;
  private static ArrayList<String> D = new ArrayList();
  private static int E = -1;
  private static long F = 0L;
  private static ArrayList<String> G = new ArrayList();
  private static String H;
  private static String I;
  private static boolean J = false;
  private static int K = 3000;
  private static int L = 3000;
  private static boolean M = true;
  private static long N = 300000L;
  private static boolean O = false;
  private static long P = 0L;
  private static int Q = 0;
  private static int R = 0;
  private static boolean S = false;
  private static int T = 0;
  private static boolean U = false;
  private static boolean V = false;
  private static boolean W = false;
  private static boolean X = false;
  private static boolean Y = false;
  private static boolean Z = false;
  public static boolean a = true;
  private static int aa = 0;
  private static boolean ab = true;
  private static long ac = -1L;
  private static boolean ad = true;
  private static int ae = 1;
  private static boolean af = true;
  private static int ag = 5;
  private static boolean ah = false;
  private static String ai = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
  private static long aj = 0L;
  static boolean b = false;
  static boolean c = false;
  static int d = 0;
  static long e = 0L;
  static long f = 0L;
  static boolean g = false;
  static boolean h = false;
  static boolean i = false;
  private static boolean j = false;
  private static boolean k = true;
  private static boolean l = false;
  private static long m = 0L;
  private static long n = 0L;
  private static long o = 5000L;
  private static boolean p = false;
  private static int q = 0;
  private static boolean r = false;
  private static int s = 0;
  private static boolean t = false;
  private static boolean u = true;
  private static int v = 1000;
  private static int w = 200;
  private static boolean x = false;
  private static int y = 20;
  private static boolean z = true;
  
  static
  {
    O = false;
    P = 0L;
    Q = 0;
    R = 0;
    S = true;
    T = 80;
    d = 3600000;
    U = false;
    V = true;
    W = false;
    e = 0L;
    f = 0L;
    g = false;
    h = true;
    X = false;
    Y = true;
    Z = false;
    aa = -1;
    i = false;
  }
  
  public static boolean A()
  {
    return ah;
  }
  
  public static boolean B()
  {
    return af;
  }
  
  public static int C()
  {
    return ag;
  }
  
  public static String D()
  {
    return w.c(ai);
  }
  
  public static boolean E()
  {
    return (ad) && (ae > 0);
  }
  
  public static int F()
  {
    return ae;
  }
  
  public static long G()
  {
    return aj;
  }
  
  private static a a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject(paramString);
        if (paramJSONObject == null) {
          break label90;
        }
        paramString = new a();
        try
        {
          paramString.a = m.a(paramJSONObject.optString("b"), false);
          paramString.b = paramJSONObject.optString("t");
          paramString.c = m.a(paramJSONObject.optString("st"), false);
          paramString.d = paramJSONObject.optInt("i", 0);
          return paramString;
        }
        catch (Throwable paramJSONObject) {}
        dg.a(paramJSONObject, "AuthUtil", "getLocateObj");
      }
      catch (Throwable paramJSONObject)
      {
        paramString = null;
      }
      return paramString;
    }
    label90:
    return null;
  }
  
  public static boolean a()
  {
    return p;
  }
  
  public static boolean a(long paramLong)
  {
    long l1 = dn.b();
    return (l) && (l1 - n <= m) && (l1 - paramLong >= o);
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 241	com/loc/df:z	Z
    //   4: iconst_0
    //   5: istore_2
    //   6: aload_0
    //   7: ldc -13
    //   9: ldc -11
    //   11: iconst_0
    //   12: invokestatic 250	com/loc/dm:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   15: putstatic 252	com/loc/df:j	Z
    //   18: aload_0
    //   19: invokestatic 255	com/loc/dg:b	()Lcom/loc/v;
    //   22: invokestatic 257	com/loc/dg:c	()Ljava/lang/String;
    //   25: getstatic 252	com/loc/df:j	Z
    //   28: invokestatic 260	com/loc/m:a	(Landroid/content/Context;Lcom/loc/v;Ljava/lang/String;Z)Lcom/loc/m$a;
    //   31: astore_3
    //   32: iload_2
    //   33: istore_1
    //   34: aload_3
    //   35: ifnull +35 -> 70
    //   38: aload_3
    //   39: invokevirtual 264	com/loc/m$a:a	()Z
    //   42: putstatic 266	com/loc/df:k	Z
    //   45: aload_0
    //   46: aload_3
    //   47: invokestatic 269	com/loc/df:a	(Landroid/content/Context;Lcom/loc/m$a;)Z
    //   50: istore_1
    //   51: goto +19 -> 70
    //   54: astore_0
    //   55: goto +29 -> 84
    //   58: astore_0
    //   59: aload_0
    //   60: ldc -40
    //   62: ldc_w 271
    //   65: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   68: iload_2
    //   69: istore_1
    //   70: invokestatic 230	com/loc/dn:b	()J
    //   73: putstatic 135	com/loc/df:f	J
    //   76: invokestatic 230	com/loc/dn:b	()J
    //   79: putstatic 133	com/loc/df:e	J
    //   82: iload_1
    //   83: ireturn
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramContext	Context
    //   33	50	1	bool1	boolean
    //   5	64	2	bool2	boolean
    //   31	16	3	locala	m.a
    // Exception table:
    //   from	to	target	type
    //   6	32	54	finally
    //   38	51	54	finally
    //   59	68	54	finally
    //   6	32	58	java/lang/Throwable
    //   38	51	58	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    if (!J) {
      return false;
    }
    long l1 = dn.a();
    if (l1 - paramLong < K) {
      return false;
    }
    if (L == -1) {
      return true;
    }
    if (!dn.b(l1, dm.b(paramContext, "pref", "ngpsTime", 0L)))
    {
      try
      {
        SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("pref", 0).edit();
        localEditor.putLong("ngpsTime", l1);
        localEditor.putInt("ngpsCount", 0);
        dm.a(localEditor);
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "AuthUtil", "resetPrefsNGPS");
      }
      dm.a(paramContext, "pref", "ngpsCount", 1);
      return true;
    }
    int i1 = dm.b(paramContext, "pref", "ngpsCount", 0);
    if (i1 < L)
    {
      dm.a(paramContext, "pref", "ngpsCount", i1 + 1);
      return true;
    }
    return false;
  }
  
  /* Error */
  private static boolean a(Context paramContext, m.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 320	com/loc/m$a:g	Lorg/json/JSONObject;
    //   4: astore 6
    //   6: aload 6
    //   8: ifnull +316 -> 324
    //   11: aload 6
    //   13: ldc_w 322
    //   16: bipush 123
    //   18: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   21: bipush 60
    //   23: imul
    //   24: sipush 1000
    //   27: imul
    //   28: putstatic 125	com/loc/df:d	I
    //   31: goto +15 -> 46
    //   34: astore 7
    //   36: aload 7
    //   38: ldc -40
    //   40: ldc_w 324
    //   43: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload 6
    //   48: ldc_w 326
    //   51: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: getstatic 127	com/loc/df:U	Z
    //   57: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   60: putstatic 127	com/loc/df:U	Z
    //   63: goto +15 -> 78
    //   66: astore 7
    //   68: aload 7
    //   70: ldc -40
    //   72: ldc_w 328
    //   75: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 6
    //   80: ldc_w 330
    //   83: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: getstatic 110	com/loc/df:c	Z
    //   89: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   92: istore_3
    //   93: iload_3
    //   94: putstatic 110	com/loc/df:c	Z
    //   97: iload_3
    //   98: ifeq +25 -> 123
    //   101: aload_0
    //   102: ldc_w 332
    //   105: invokestatic 337	com/loc/az:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   108: goto +15 -> 123
    //   111: astore 7
    //   113: aload 7
    //   115: ldc -40
    //   117: ldc_w 339
    //   120: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_0
    //   124: ifnull +55 -> 179
    //   127: aload 6
    //   129: ifnonnull +6 -> 135
    //   132: goto +47 -> 179
    //   135: aload 6
    //   137: ldc_w 341
    //   140: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: getstatic 139	com/loc/df:h	Z
    //   146: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   149: putstatic 139	com/loc/df:h	Z
    //   152: aload_0
    //   153: ldc -13
    //   155: ldc_w 343
    //   158: getstatic 139	com/loc/df:h	Z
    //   161: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   164: goto +15 -> 179
    //   167: astore 7
    //   169: aload 7
    //   171: ldc -40
    //   173: ldc_w 348
    //   176: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 6
    //   181: ldc_w 350
    //   184: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: getstatic 129	com/loc/df:V	Z
    //   190: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   193: putstatic 129	com/loc/df:V	Z
    //   196: aload 6
    //   198: ldc -11
    //   200: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: getstatic 252	com/loc/df:j	Z
    //   206: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   209: putstatic 252	com/loc/df:j	Z
    //   212: aload_0
    //   213: ldc -13
    //   215: ldc -11
    //   217: getstatic 252	com/loc/df:j	Z
    //   220: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   223: aload 6
    //   225: ldc_w 352
    //   228: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: getstatic 151	com/loc/df:ab	Z
    //   234: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   237: putstatic 151	com/loc/df:ab	Z
    //   240: aload_0
    //   241: ldc -13
    //   243: ldc_w 352
    //   246: getstatic 151	com/loc/df:ab	Z
    //   249: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   252: aload 6
    //   254: ldc_w 354
    //   257: invokevirtual 358	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   260: astore 6
    //   262: aload 6
    //   264: ifnull +60 -> 324
    //   267: aload 6
    //   269: invokevirtual 363	org/json/JSONArray:length	()I
    //   272: ifle +52 -> 324
    //   275: iconst_0
    //   276: istore_2
    //   277: iload_2
    //   278: aload 6
    //   280: invokevirtual 363	org/json/JSONArray:length	()I
    //   283: if_icmpge +41 -> 324
    //   286: aload_0
    //   287: aload 6
    //   289: iload_2
    //   290: invokevirtual 367	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   293: invokestatic 370	com/loc/dn:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   296: istore_3
    //   297: iload_3
    //   298: putstatic 131	com/loc/df:W	Z
    //   301: iload_3
    //   302: ifne +22 -> 324
    //   305: iload_2
    //   306: iconst_1
    //   307: iadd
    //   308: istore_2
    //   309: goto -32 -> 277
    //   312: astore 6
    //   314: aload 6
    //   316: ldc -40
    //   318: ldc_w 372
    //   321: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_1
    //   325: getfield 374	com/loc/m$a:h	Lorg/json/JSONObject;
    //   328: astore 6
    //   330: aload 6
    //   332: ifnull +195 -> 527
    //   335: aload 6
    //   337: ldc_w 376
    //   340: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   343: getstatic 378	com/loc/df:A	Z
    //   346: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   349: putstatic 378	com/loc/df:A	Z
    //   352: aload 6
    //   354: ldc_w 380
    //   357: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   360: iconst_0
    //   361: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   364: ifeq +1819 -> 2183
    //   367: getstatic 378	com/loc/df:A	Z
    //   370: ifeq +1813 -> 2183
    //   373: iconst_1
    //   374: istore_3
    //   375: goto +3 -> 378
    //   378: iload_3
    //   379: putstatic 382	com/loc/df:b	Z
    //   382: getstatic 378	com/loc/df:A	Z
    //   385: ifeq +142 -> 527
    //   388: aload 6
    //   390: ldc_w 384
    //   393: getstatic 386	com/loc/df:B	I
    //   396: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   399: putstatic 386	com/loc/df:B	I
    //   402: aload 6
    //   404: ldc_w 388
    //   407: getstatic 390	com/loc/df:C	J
    //   410: invokevirtual 394	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   413: putstatic 390	com/loc/df:C	J
    //   416: aload 6
    //   418: ldc_w 396
    //   421: invokevirtual 358	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   424: astore 6
    //   426: aload 6
    //   428: ifnull +42 -> 470
    //   431: aload 6
    //   433: invokevirtual 363	org/json/JSONArray:length	()I
    //   436: ifle +34 -> 470
    //   439: iconst_0
    //   440: istore_2
    //   441: iload_2
    //   442: aload 6
    //   444: invokevirtual 363	org/json/JSONArray:length	()I
    //   447: if_icmpge +23 -> 470
    //   450: getstatic 90	com/loc/df:D	Ljava/util/ArrayList;
    //   453: aload 6
    //   455: iload_2
    //   456: invokevirtual 367	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   459: invokevirtual 400	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   462: pop
    //   463: iload_2
    //   464: iconst_1
    //   465: iadd
    //   466: istore_2
    //   467: goto -26 -> 441
    //   470: getstatic 386	com/loc/df:B	I
    //   473: iconst_m1
    //   474: if_icmpeq +53 -> 527
    //   477: getstatic 390	com/loc/df:C	J
    //   480: lconst_0
    //   481: lcmp
    //   482: ifeq +45 -> 527
    //   485: aload_0
    //   486: ldc -13
    //   488: ldc_w 402
    //   491: lconst_0
    //   492: invokestatic 279	com/loc/dm:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   495: lstore 4
    //   497: getstatic 390	com/loc/df:C	J
    //   500: lload 4
    //   502: invokestatic 404	com/loc/dn:a	(JJ)Z
    //   505: ifne +22 -> 527
    //   508: aload_0
    //   509: invokestatic 407	com/loc/df:f	(Landroid/content/Context;)V
    //   512: goto +15 -> 527
    //   515: astore 6
    //   517: aload 6
    //   519: ldc -40
    //   521: ldc_w 409
    //   524: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   527: invokestatic 255	com/loc/dg:b	()Lcom/loc/v;
    //   530: astore 6
    //   532: aload_1
    //   533: getfield 412	com/loc/m$a:y	Lcom/loc/m$a$d;
    //   536: astore 9
    //   538: aload 9
    //   540: ifnull +84 -> 624
    //   543: aload 9
    //   545: getfield 415	com/loc/m$a$d:b	Ljava/lang/String;
    //   548: astore 7
    //   550: aload 9
    //   552: getfield 417	com/loc/m$a$d:a	Ljava/lang/String;
    //   555: astore 8
    //   557: aload 9
    //   559: getfield 419	com/loc/m$a$d:c	Ljava/lang/String;
    //   562: astore 9
    //   564: aload 7
    //   566: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   569: ifne +55 -> 624
    //   572: aload 8
    //   574: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   577: ifne +47 -> 624
    //   580: aload 9
    //   582: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: ifeq +6 -> 591
    //   588: goto +36 -> 624
    //   591: new 427	com/loc/au
    //   594: dup
    //   595: aload 8
    //   597: aload 7
    //   599: getstatic 266	com/loc/df:k	Z
    //   602: invokespecial 430	com/loc/au:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   605: astore 7
    //   607: aload 7
    //   609: iconst_1
    //   610: invokevirtual 433	com/loc/au:a	(Z)V
    //   613: aload_0
    //   614: aload 7
    //   616: aload 6
    //   618: invokestatic 436	com/loc/az:b	(Landroid/content/Context;Lcom/loc/au;Lcom/loc/v;)V
    //   621: goto +25 -> 646
    //   624: aload_0
    //   625: aconst_null
    //   626: aload 6
    //   628: invokestatic 436	com/loc/az:b	(Landroid/content/Context;Lcom/loc/au;Lcom/loc/v;)V
    //   631: goto +15 -> 646
    //   634: astore 6
    //   636: aload 6
    //   638: ldc -40
    //   640: ldc_w 438
    //   643: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   646: getstatic 439	com/loc/df:a	Z
    //   649: istore_3
    //   650: iload_3
    //   651: ifeq +103 -> 754
    //   654: aload_1
    //   655: getfield 442	com/loc/m$a:B	Lcom/loc/m$a$c;
    //   658: astore 6
    //   660: aload 6
    //   662: ifnull +92 -> 754
    //   665: aload 6
    //   667: getfield 445	com/loc/m$a$c:a	Ljava/lang/String;
    //   670: putstatic 447	com/loc/df:H	Ljava/lang/String;
    //   673: aload 6
    //   675: getfield 448	com/loc/m$a$c:b	Ljava/lang/String;
    //   678: putstatic 450	com/loc/df:I	Ljava/lang/String;
    //   681: getstatic 447	com/loc/df:H	Ljava/lang/String;
    //   684: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   687: ifne +67 -> 754
    //   690: getstatic 450	com/loc/df:I	Ljava/lang/String;
    //   693: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   696: ifne +58 -> 754
    //   699: new 452	com/loc/o
    //   702: dup
    //   703: aload_0
    //   704: ldc_w 332
    //   707: getstatic 447	com/loc/df:H	Ljava/lang/String;
    //   710: getstatic 450	com/loc/df:I	Ljava/lang/String;
    //   713: invokespecial 455	com/loc/o:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   716: astore 6
    //   718: aload 6
    //   720: getstatic 266	com/loc/df:k	Z
    //   723: invokevirtual 457	com/loc/o:b	(Z)V
    //   726: aload 6
    //   728: getstatic 252	com/loc/df:j	Z
    //   731: invokevirtual 458	com/loc/o:a	(Z)V
    //   734: aload 6
    //   736: invokevirtual 460	com/loc/o:a	()V
    //   739: goto +15 -> 754
    //   742: astore 6
    //   744: aload 6
    //   746: ldc -40
    //   748: ldc_w 462
    //   751: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   754: aload_1
    //   755: getfield 465	com/loc/m$a:x	Lcom/loc/m$a$a;
    //   758: astore 6
    //   760: aload 6
    //   762: ifnull +198 -> 960
    //   765: aload 6
    //   767: getfield 468	com/loc/m$a$a:a	Z
    //   770: putstatic 470	com/loc/df:u	Z
    //   773: aload_0
    //   774: ldc -13
    //   776: ldc_w 472
    //   779: getstatic 470	com/loc/df:u	Z
    //   782: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   785: aload 6
    //   787: getfield 474	com/loc/m$a$a:c	Lorg/json/JSONObject;
    //   790: astore 6
    //   792: aload 6
    //   794: ldc_w 476
    //   797: getstatic 478	com/loc/df:v	I
    //   800: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   803: putstatic 478	com/loc/df:v	I
    //   806: aload 6
    //   808: ldc_w 480
    //   811: getstatic 482	com/loc/df:w	I
    //   814: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   817: istore_2
    //   818: iload_2
    //   819: putstatic 482	com/loc/df:w	I
    //   822: iload_2
    //   823: sipush 500
    //   826: if_icmple +9 -> 835
    //   829: sipush 500
    //   832: putstatic 482	com/loc/df:w	I
    //   835: getstatic 482	com/loc/df:w	I
    //   838: bipush 30
    //   840: if_icmpge +8 -> 848
    //   843: bipush 30
    //   845: putstatic 482	com/loc/df:w	I
    //   848: aload 6
    //   850: ldc_w 484
    //   853: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   856: getstatic 486	com/loc/df:x	Z
    //   859: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   862: putstatic 486	com/loc/df:x	Z
    //   865: aload 6
    //   867: ldc_w 488
    //   870: getstatic 490	com/loc/df:y	I
    //   873: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   876: putstatic 490	com/loc/df:y	I
    //   879: getstatic 478	com/loc/df:v	I
    //   882: getstatic 486	com/loc/df:x	Z
    //   885: getstatic 490	com/loc/df:y	I
    //   888: invokestatic 495	com/loc/bt:a	(IZI)V
    //   891: getstatic 486	com/loc/df:x	Z
    //   894: invokestatic 498	com/loc/bv:a	(Z)V
    //   897: aload_0
    //   898: ldc -13
    //   900: ldc_w 476
    //   903: getstatic 478	com/loc/df:v	I
    //   906: invokestatic 314	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   909: aload_0
    //   910: ldc -13
    //   912: ldc_w 480
    //   915: getstatic 482	com/loc/df:w	I
    //   918: invokestatic 314	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   921: aload_0
    //   922: ldc -13
    //   924: ldc_w 484
    //   927: getstatic 486	com/loc/df:x	Z
    //   930: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   933: aload_0
    //   934: ldc -13
    //   936: ldc_w 488
    //   939: getstatic 490	com/loc/df:y	I
    //   942: invokestatic 314	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   945: goto +15 -> 960
    //   948: astore 6
    //   950: aload 6
    //   952: ldc -40
    //   954: ldc_w 500
    //   957: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   960: aload_1
    //   961: getfield 502	com/loc/m$a:m	Lorg/json/JSONObject;
    //   964: astore 6
    //   966: aload 6
    //   968: ifnull +229 -> 1197
    //   971: aload 6
    //   973: ldc_w 504
    //   976: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   979: iconst_0
    //   980: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   983: ifeq +214 -> 1197
    //   986: aload 6
    //   988: ldc_w 506
    //   991: invokestatic 508	com/loc/df:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/loc/df$a;
    //   994: astore 7
    //   996: aload 7
    //   998: ifnull +37 -> 1035
    //   1001: aload 7
    //   1003: getfield 208	com/loc/df$a:c	Z
    //   1006: putstatic 225	com/loc/df:p	Z
    //   1009: aload 7
    //   1011: getfield 205	com/loc/df$a:b	Ljava/lang/String;
    //   1014: invokestatic 514	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1017: putstatic 516	com/loc/df:q	I
    //   1020: goto +15 -> 1035
    //   1023: astore 7
    //   1025: aload 7
    //   1027: ldc -40
    //   1029: ldc_w 518
    //   1032: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1035: aload 6
    //   1037: ldc_w 520
    //   1040: invokestatic 508	com/loc/df:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/loc/df$a;
    //   1043: astore 7
    //   1045: aload 7
    //   1047: ifnull +56 -> 1103
    //   1050: aload 7
    //   1052: getfield 208	com/loc/df$a:c	Z
    //   1055: putstatic 522	com/loc/df:r	Z
    //   1058: aload 7
    //   1060: getfield 202	com/loc/df$a:a	Z
    //   1063: putstatic 524	com/loc/df:t	Z
    //   1066: aload 7
    //   1068: getfield 205	com/loc/df$a:b	Ljava/lang/String;
    //   1071: invokestatic 514	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1074: putstatic 526	com/loc/df:s	I
    //   1077: goto +15 -> 1092
    //   1080: astore 7
    //   1082: aload 7
    //   1084: ldc -40
    //   1086: ldc_w 528
    //   1089: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1092: getstatic 526	com/loc/df:s	I
    //   1095: iconst_2
    //   1096: if_icmpge +7 -> 1103
    //   1099: iconst_0
    //   1100: putstatic 522	com/loc/df:r	Z
    //   1103: aload 6
    //   1105: ldc_w 530
    //   1108: invokestatic 508	com/loc/df:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/loc/df$a;
    //   1111: astore 6
    //   1113: aload 6
    //   1115: ifnull +82 -> 1197
    //   1118: aload 6
    //   1120: getfield 208	com/loc/df$a:c	Z
    //   1123: istore_3
    //   1124: iload_3
    //   1125: putstatic 232	com/loc/df:l	Z
    //   1128: iload_3
    //   1129: ifeq +22 -> 1151
    //   1132: invokestatic 230	com/loc/dn:b	()J
    //   1135: putstatic 234	com/loc/df:n	J
    //   1138: aload 6
    //   1140: getfield 214	com/loc/df$a:d	I
    //   1143: sipush 1000
    //   1146: imul
    //   1147: i2l
    //   1148: putstatic 238	com/loc/df:o	J
    //   1151: aload 6
    //   1153: getfield 205	com/loc/df$a:b	Ljava/lang/String;
    //   1156: invokestatic 514	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1159: sipush 1000
    //   1162: imul
    //   1163: i2l
    //   1164: putstatic 236	com/loc/df:m	J
    //   1167: goto +30 -> 1197
    //   1170: astore 6
    //   1172: aload 6
    //   1174: ldc -40
    //   1176: ldc_w 532
    //   1179: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1182: goto +15 -> 1197
    //   1185: astore 6
    //   1187: aload 6
    //   1189: ldc -40
    //   1191: ldc_w 534
    //   1194: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1197: aload_1
    //   1198: getfield 536	com/loc/m$a:o	Lorg/json/JSONObject;
    //   1201: astore 6
    //   1203: aload 6
    //   1205: ifnull +84 -> 1289
    //   1208: aload 6
    //   1210: ldc_w 504
    //   1213: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1216: getstatic 98	com/loc/df:J	Z
    //   1219: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1222: istore_3
    //   1223: iload_3
    //   1224: putstatic 98	com/loc/df:J	Z
    //   1227: iload_3
    //   1228: ifeq +61 -> 1289
    //   1231: aload 6
    //   1233: ldc_w 537
    //   1236: iconst_0
    //   1237: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1240: istore_2
    //   1241: iload_2
    //   1242: ifne +12 -> 1254
    //   1245: sipush 3000
    //   1248: putstatic 100	com/loc/df:K	I
    //   1251: goto +11 -> 1262
    //   1254: iload_2
    //   1255: sipush 1000
    //   1258: imul
    //   1259: putstatic 100	com/loc/df:K	I
    //   1262: aload 6
    //   1264: ldc -53
    //   1266: invokevirtual 540	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1269: iconst_2
    //   1270: idiv
    //   1271: putstatic 102	com/loc/df:L	I
    //   1274: goto +15 -> 1289
    //   1277: astore 6
    //   1279: aload 6
    //   1281: ldc -40
    //   1283: ldc_w 542
    //   1286: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1289: aload_1
    //   1290: getfield 544	com/loc/m$a:p	Lorg/json/JSONObject;
    //   1293: astore 6
    //   1295: aload 6
    //   1297: ifnull +84 -> 1381
    //   1300: aload 6
    //   1302: ldc_w 504
    //   1305: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1308: getstatic 104	com/loc/df:M	Z
    //   1311: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1314: istore_3
    //   1315: iload_3
    //   1316: putstatic 104	com/loc/df:M	Z
    //   1319: iload_3
    //   1320: ifeq +22 -> 1342
    //   1323: aload 6
    //   1325: ldc_w 537
    //   1328: sipush 300
    //   1331: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1334: sipush 1000
    //   1337: imul
    //   1338: i2l
    //   1339: putstatic 108	com/loc/df:N	J
    //   1342: aload_0
    //   1343: ldc -13
    //   1345: ldc_w 546
    //   1348: getstatic 104	com/loc/df:M	Z
    //   1351: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1354: aload_0
    //   1355: ldc -13
    //   1357: ldc_w 548
    //   1360: getstatic 108	com/loc/df:N	J
    //   1363: invokestatic 551	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V
    //   1366: goto +15 -> 1381
    //   1369: astore 6
    //   1371: aload 6
    //   1373: ldc -40
    //   1375: ldc_w 553
    //   1378: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1381: aload_1
    //   1382: getfield 555	com/loc/m$a:i	Lorg/json/JSONObject;
    //   1385: astore 6
    //   1387: aload 6
    //   1389: ifnull +55 -> 1444
    //   1392: aload 6
    //   1394: ldc_w 504
    //   1397: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1400: getstatic 120	com/loc/df:S	Z
    //   1403: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1406: istore_3
    //   1407: iload_3
    //   1408: putstatic 120	com/loc/df:S	Z
    //   1411: iload_3
    //   1412: ifeq +32 -> 1444
    //   1415: aload 6
    //   1417: ldc_w 537
    //   1420: getstatic 122	com/loc/df:T	I
    //   1423: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1426: putstatic 122	com/loc/df:T	I
    //   1429: goto +15 -> 1444
    //   1432: astore 6
    //   1434: aload 6
    //   1436: ldc -40
    //   1438: ldc_w 557
    //   1441: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1444: aload_1
    //   1445: getfield 559	com/loc/m$a:w	Lorg/json/JSONObject;
    //   1448: astore_1
    //   1449: aload_1
    //   1450: ifnull +325 -> 1775
    //   1453: aload_1
    //   1454: ldc_w 561
    //   1457: invokevirtual 564	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1460: astore 9
    //   1462: aload 9
    //   1464: ifnull +311 -> 1775
    //   1467: aload 9
    //   1469: ldc_w 504
    //   1472: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1475: getstatic 141	com/loc/df:X	Z
    //   1478: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1481: putstatic 141	com/loc/df:X	Z
    //   1484: ldc_w 380
    //   1487: ldc_w 566
    //   1490: invokestatic 569	com/loc/dg:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/loc/v;
    //   1493: astore 6
    //   1495: getstatic 141	com/loc/df:X	Z
    //   1498: ifeq +183 -> 1681
    //   1501: aload 9
    //   1503: ldc_w 571
    //   1506: iconst_m1
    //   1507: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1510: putstatic 147	com/loc/df:aa	I
    //   1513: aload 9
    //   1515: ldc_w 380
    //   1518: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1521: getstatic 143	com/loc/df:Y	Z
    //   1524: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1527: putstatic 143	com/loc/df:Y	Z
    //   1530: aload 9
    //   1532: ldc_w 573
    //   1535: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1538: getstatic 145	com/loc/df:Z	Z
    //   1541: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1544: putstatic 145	com/loc/df:Z	Z
    //   1547: aload 9
    //   1549: ldc_w 574
    //   1552: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1555: astore 7
    //   1557: aload 9
    //   1559: ldc_w 575
    //   1562: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1565: astore 8
    //   1567: aload 9
    //   1569: ldc_w 576
    //   1572: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1575: astore 9
    //   1577: invokestatic 579	com/loc/ct:a	()Z
    //   1580: ifne +132 -> 1712
    //   1583: aload 9
    //   1585: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1588: ifne +124 -> 1712
    //   1591: aload 8
    //   1593: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1596: ifne +116 -> 1712
    //   1599: aload 7
    //   1601: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1604: ifne +108 -> 1712
    //   1607: new 427	com/loc/au
    //   1610: dup
    //   1611: aload 8
    //   1613: aload 9
    //   1615: getstatic 266	com/loc/df:k	Z
    //   1618: invokespecial 430	com/loc/au:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1621: astore 7
    //   1623: aload 7
    //   1625: getstatic 252	com/loc/df:j	Z
    //   1628: invokevirtual 433	com/loc/au:a	(Z)V
    //   1631: aload_0
    //   1632: aload 7
    //   1634: aload 6
    //   1636: invokestatic 582	com/loc/az:a	(Landroid/content/Context;Lcom/loc/au;Lcom/loc/v;)Z
    //   1639: istore_3
    //   1640: iload_3
    //   1641: iconst_1
    //   1642: ixor
    //   1643: putstatic 149	com/loc/df:i	Z
    //   1646: iload_3
    //   1647: ifeq +65 -> 1712
    //   1650: aload_0
    //   1651: ldc -13
    //   1653: ldc_w 584
    //   1656: iconst_1
    //   1657: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1660: aload_0
    //   1661: ldc -13
    //   1663: ldc_w 586
    //   1666: iconst_0
    //   1667: invokestatic 314	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   1670: aload_0
    //   1671: aload 7
    //   1673: aload 6
    //   1675: invokestatic 436	com/loc/az:b	(Landroid/content/Context;Lcom/loc/au;Lcom/loc/v;)V
    //   1678: goto +34 -> 1712
    //   1681: iconst_0
    //   1682: putstatic 149	com/loc/df:i	Z
    //   1685: iconst_0
    //   1686: putstatic 143	com/loc/df:Y	Z
    //   1689: iconst_0
    //   1690: putstatic 145	com/loc/df:Z	Z
    //   1693: aload_0
    //   1694: aload 6
    //   1696: invokestatic 591	com/loc/dk:a	(Landroid/content/Context;Lcom/loc/v;)Z
    //   1699: ifeq +13 -> 1712
    //   1702: aload_0
    //   1703: ldc_w 380
    //   1706: ldc_w 593
    //   1709: invokestatic 598	com/loc/dl:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1712: aload_0
    //   1713: ldc -13
    //   1715: ldc_w 600
    //   1718: getstatic 141	com/loc/df:X	Z
    //   1721: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1724: aload_0
    //   1725: ldc -13
    //   1727: ldc_w 586
    //   1730: getstatic 149	com/loc/df:i	Z
    //   1733: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1736: aload_0
    //   1737: ldc -13
    //   1739: ldc_w 602
    //   1742: getstatic 143	com/loc/df:Y	Z
    //   1745: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1748: aload_0
    //   1749: ldc -13
    //   1751: ldc_w 604
    //   1754: getstatic 145	com/loc/df:Z	Z
    //   1757: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1760: goto +15 -> 1775
    //   1763: astore 6
    //   1765: aload 6
    //   1767: ldc -40
    //   1769: ldc_w 606
    //   1772: invokestatic 223	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1775: aload_0
    //   1776: ifnull +118 -> 1894
    //   1779: aload_1
    //   1780: ifnonnull +6 -> 1786
    //   1783: goto +111 -> 1894
    //   1786: aload_1
    //   1787: ldc_w 608
    //   1790: invokevirtual 564	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1793: astore 6
    //   1795: aload 6
    //   1797: ifnull +97 -> 1894
    //   1800: aload 6
    //   1802: ldc_w 504
    //   1805: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1808: iconst_0
    //   1809: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1812: ifeq +61 -> 1873
    //   1815: aload 6
    //   1817: ldc_w 610
    //   1820: invokevirtual 358	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1823: astore 7
    //   1825: aload 7
    //   1827: ifnull +25 -> 1852
    //   1830: aload 7
    //   1832: invokevirtual 363	org/json/JSONArray:length	()I
    //   1835: ifle +17 -> 1852
    //   1838: aload 7
    //   1840: invokevirtual 613	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1843: getstatic 618	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1846: invokevirtual 623	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1849: ifeq +24 -> 1873
    //   1852: aload 6
    //   1854: ldc_w 625
    //   1857: bipush 30
    //   1859: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1862: sipush 1000
    //   1865: imul
    //   1866: i2l
    //   1867: putstatic 155	com/loc/df:ac	J
    //   1870: goto +9 -> 1879
    //   1873: ldc2_w 152
    //   1876: putstatic 155	com/loc/df:ac	J
    //   1879: aload_0
    //   1880: ldc -13
    //   1882: ldc_w 627
    //   1885: getstatic 155	com/loc/df:ac	J
    //   1888: invokestatic 551	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V
    //   1891: goto +3 -> 1894
    //   1894: aload_0
    //   1895: ifnull +100 -> 1995
    //   1898: aload_1
    //   1899: ifnonnull +6 -> 1905
    //   1902: goto +93 -> 1995
    //   1905: aload_1
    //   1906: ldc_w 629
    //   1909: invokevirtual 564	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1912: astore 6
    //   1914: aload 6
    //   1916: ifnull +79 -> 1995
    //   1919: aload 6
    //   1921: ldc_w 504
    //   1924: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1927: getstatic 157	com/loc/df:ad	Z
    //   1930: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   1933: istore_3
    //   1934: aload 6
    //   1936: ldc_w 631
    //   1939: getstatic 159	com/loc/df:ae	I
    //   1942: invokevirtual 213	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1945: istore_2
    //   1946: aload 6
    //   1948: ldc_w 388
    //   1951: getstatic 171	com/loc/df:aj	J
    //   1954: invokevirtual 394	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   1957: putstatic 171	com/loc/df:aj	J
    //   1960: aload_0
    //   1961: ldc -13
    //   1963: ldc_w 633
    //   1966: iload_3
    //   1967: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1970: aload_0
    //   1971: ldc -13
    //   1973: ldc_w 635
    //   1976: iload_2
    //   1977: invokestatic 314	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   1980: aload_0
    //   1981: ldc -13
    //   1983: ldc_w 637
    //   1986: getstatic 171	com/loc/df:aj	J
    //   1989: invokestatic 551	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V
    //   1992: goto +3 -> 1995
    //   1995: aload_0
    //   1996: ifnull +149 -> 2145
    //   1999: aload_1
    //   2000: ifnonnull +5 -> 2005
    //   2003: iconst_1
    //   2004: ireturn
    //   2005: aload_1
    //   2006: ldc_w 639
    //   2009: invokevirtual 564	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2012: astore_1
    //   2013: aload_1
    //   2014: ifnull +131 -> 2145
    //   2017: aload_1
    //   2018: ldc_w 504
    //   2021: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2024: iconst_0
    //   2025: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   2028: istore_3
    //   2029: iload_3
    //   2030: putstatic 161	com/loc/df:af	Z
    //   2033: aload_0
    //   2034: ldc -13
    //   2036: ldc_w 641
    //   2039: iload_3
    //   2040: invokestatic 346	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2043: iload_3
    //   2044: ifeq +101 -> 2145
    //   2047: aload_1
    //   2048: ldc_w 643
    //   2051: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2054: astore 6
    //   2056: aload_1
    //   2057: ldc_w 645
    //   2060: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2063: putstatic 169	com/loc/df:ai	Ljava/lang/String;
    //   2066: aload_0
    //   2067: ldc -13
    //   2069: ldc_w 647
    //   2072: getstatic 169	com/loc/df:ai	Ljava/lang/String;
    //   2075: invokestatic 649	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2078: aload 6
    //   2080: iconst_0
    //   2081: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   2084: pop
    //   2085: aload_1
    //   2086: ldc_w 651
    //   2089: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2092: iconst_0
    //   2093: invokestatic 200	com/loc/m:a	(Ljava/lang/String;Z)Z
    //   2096: putstatic 165	com/loc/df:ah	Z
    //   2099: aload_1
    //   2100: ldc_w 653
    //   2103: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2106: astore_1
    //   2107: aload_1
    //   2108: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2111: ifne +34 -> 2145
    //   2114: aload_1
    //   2115: invokestatic 514	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2118: istore_2
    //   2119: iload_2
    //   2120: ifle +25 -> 2145
    //   2123: iload_2
    //   2124: bipush 20
    //   2126: if_icmpge +19 -> 2145
    //   2129: iload_2
    //   2130: putstatic 163	com/loc/df:ag	I
    //   2133: aload_0
    //   2134: ldc -13
    //   2136: ldc_w 655
    //   2139: getstatic 163	com/loc/df:ag	I
    //   2142: invokestatic 314	com/loc/dm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   2145: iconst_1
    //   2146: ireturn
    //   2147: astore 7
    //   2149: goto -1953 -> 196
    //   2152: astore 7
    //   2154: goto -1931 -> 223
    //   2157: astore 7
    //   2159: goto -1907 -> 252
    //   2162: astore 6
    //   2164: goto -1840 -> 324
    //   2167: astore_0
    //   2168: iconst_0
    //   2169: ireturn
    //   2170: astore 6
    //   2172: goto -278 -> 1894
    //   2175: astore 6
    //   2177: goto -182 -> 1995
    //   2180: astore_0
    //   2181: iconst_1
    //   2182: ireturn
    //   2183: iconst_0
    //   2184: istore_3
    //   2185: goto -1807 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2188	0	paramContext	Context
    //   0	2188	1	parama	m.a
    //   276	1854	2	i1	int
    //   92	2093	3	bool	boolean
    //   495	6	4	l1	long
    //   4	284	6	localObject1	Object
    //   312	3	6	localThrowable1	Throwable
    //   328	126	6	localObject2	Object
    //   515	3	6	localThrowable2	Throwable
    //   530	97	6	localv1	v
    //   634	3	6	localThrowable3	Throwable
    //   658	77	6	localObject3	Object
    //   742	3	6	localThrowable4	Throwable
    //   758	108	6	localObject4	Object
    //   948	3	6	localThrowable5	Throwable
    //   964	188	6	localObject5	Object
    //   1170	3	6	localThrowable6	Throwable
    //   1185	3	6	localThrowable7	Throwable
    //   1201	62	6	localJSONObject1	JSONObject
    //   1277	3	6	localThrowable8	Throwable
    //   1293	31	6	localJSONObject2	JSONObject
    //   1369	3	6	localThrowable9	Throwable
    //   1385	31	6	localJSONObject3	JSONObject
    //   1432	3	6	localThrowable10	Throwable
    //   1493	202	6	localv2	v
    //   1763	3	6	localThrowable11	Throwable
    //   1793	286	6	localObject6	Object
    //   2162	1	6	localThrowable12	Throwable
    //   2170	1	6	localThrowable13	Throwable
    //   2175	1	6	localThrowable14	Throwable
    //   34	3	7	localThrowable15	Throwable
    //   66	3	7	localThrowable16	Throwable
    //   111	3	7	localThrowable17	Throwable
    //   167	3	7	localThrowable18	Throwable
    //   548	462	7	localObject7	Object
    //   1023	3	7	localThrowable19	Throwable
    //   1043	24	7	locala	a
    //   1080	3	7	localThrowable20	Throwable
    //   1555	284	7	localObject8	Object
    //   2147	1	7	localThrowable21	Throwable
    //   2152	1	7	localThrowable22	Throwable
    //   2157	1	7	localThrowable23	Throwable
    //   555	1057	8	str	String
    //   536	1078	9	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   11	31	34	java/lang/Throwable
    //   46	63	66	java/lang/Throwable
    //   78	97	111	java/lang/Throwable
    //   101	108	111	java/lang/Throwable
    //   135	164	167	java/lang/Throwable
    //   0	6	312	java/lang/Throwable
    //   36	46	312	java/lang/Throwable
    //   68	78	312	java/lang/Throwable
    //   113	123	312	java/lang/Throwable
    //   169	179	312	java/lang/Throwable
    //   324	330	515	java/lang/Throwable
    //   335	373	515	java/lang/Throwable
    //   378	426	515	java/lang/Throwable
    //   431	439	515	java/lang/Throwable
    //   441	463	515	java/lang/Throwable
    //   470	512	515	java/lang/Throwable
    //   527	538	634	java/lang/Throwable
    //   543	588	634	java/lang/Throwable
    //   591	621	634	java/lang/Throwable
    //   624	631	634	java/lang/Throwable
    //   654	660	742	java/lang/Throwable
    //   665	739	742	java/lang/Throwable
    //   754	760	948	java/lang/Throwable
    //   765	822	948	java/lang/Throwable
    //   829	835	948	java/lang/Throwable
    //   835	848	948	java/lang/Throwable
    //   848	945	948	java/lang/Throwable
    //   1009	1020	1023	java/lang/Throwable
    //   1066	1077	1080	java/lang/Throwable
    //   1151	1167	1170	java/lang/Throwable
    //   960	966	1185	java/lang/Throwable
    //   971	996	1185	java/lang/Throwable
    //   1001	1009	1185	java/lang/Throwable
    //   1025	1035	1185	java/lang/Throwable
    //   1035	1045	1185	java/lang/Throwable
    //   1050	1066	1185	java/lang/Throwable
    //   1082	1092	1185	java/lang/Throwable
    //   1092	1103	1185	java/lang/Throwable
    //   1103	1113	1185	java/lang/Throwable
    //   1118	1128	1185	java/lang/Throwable
    //   1132	1151	1185	java/lang/Throwable
    //   1172	1182	1185	java/lang/Throwable
    //   1197	1203	1277	java/lang/Throwable
    //   1208	1227	1277	java/lang/Throwable
    //   1231	1241	1277	java/lang/Throwable
    //   1245	1251	1277	java/lang/Throwable
    //   1254	1262	1277	java/lang/Throwable
    //   1262	1274	1277	java/lang/Throwable
    //   1289	1295	1369	java/lang/Throwable
    //   1300	1319	1369	java/lang/Throwable
    //   1323	1342	1369	java/lang/Throwable
    //   1342	1366	1369	java/lang/Throwable
    //   1381	1387	1432	java/lang/Throwable
    //   1392	1411	1432	java/lang/Throwable
    //   1415	1429	1432	java/lang/Throwable
    //   1453	1462	1763	java/lang/Throwable
    //   1467	1646	1763	java/lang/Throwable
    //   1650	1678	1763	java/lang/Throwable
    //   1681	1712	1763	java/lang/Throwable
    //   1712	1760	1763	java/lang/Throwable
    //   179	196	2147	java/lang/Throwable
    //   196	223	2152	java/lang/Throwable
    //   223	252	2157	java/lang/Throwable
    //   252	262	2162	java/lang/Throwable
    //   267	275	2162	java/lang/Throwable
    //   277	301	2162	java/lang/Throwable
    //   314	324	2167	java/lang/Throwable
    //   517	527	2167	java/lang/Throwable
    //   636	646	2167	java/lang/Throwable
    //   646	650	2167	java/lang/Throwable
    //   744	754	2167	java/lang/Throwable
    //   950	960	2167	java/lang/Throwable
    //   1187	1197	2167	java/lang/Throwable
    //   1279	1289	2167	java/lang/Throwable
    //   1371	1381	2167	java/lang/Throwable
    //   1434	1444	2167	java/lang/Throwable
    //   1444	1449	2167	java/lang/Throwable
    //   1765	1775	2167	java/lang/Throwable
    //   1786	1795	2170	java/lang/Throwable
    //   1800	1825	2170	java/lang/Throwable
    //   1830	1852	2170	java/lang/Throwable
    //   1852	1870	2170	java/lang/Throwable
    //   1873	1879	2170	java/lang/Throwable
    //   1879	1891	2170	java/lang/Throwable
    //   1905	1914	2175	java/lang/Throwable
    //   1919	1992	2175	java/lang/Throwable
    //   2005	2013	2180	java/lang/Throwable
    //   2017	2043	2180	java/lang/Throwable
    //   2047	2119	2180	java/lang/Throwable
    //   2129	2145	2180	java/lang/Throwable
  }
  
  public static int b()
  {
    return q;
  }
  
  public static boolean b(long paramLong)
  {
    if (!M) {
      return false;
    }
    long l1 = dn.a();
    return (N < 0L) || (l1 - paramLong < N);
  }
  
  public static boolean b(Context paramContext)
  {
    if (!A) {
      return false;
    }
    if (B != -1)
    {
      if (C == 0L) {
        return true;
      }
      long l1 = dm.b(paramContext, "pref", "nowtime", 0L);
      if (!dn.a(C, l1))
      {
        f(paramContext);
        dm.a(paramContext, "pref", "count", 1);
        return true;
      }
      int i1 = dm.b(paramContext, "pref", "count", 0);
      if (i1 < B)
      {
        dm.a(paramContext, "pref", "count", i1 + 1);
        return true;
      }
      return false;
    }
    return true;
  }
  
  public static void c(Context paramContext)
  {
    try
    {
      u = dm.b(paramContext, "pref", "exception", u);
      d(paramContext);
    }
    catch (Throwable localThrowable1)
    {
      dg.a(localThrowable1, "AuthUtil", "loadLastAbleState p1");
    }
    try
    {
      v = dm.b(paramContext, "pref", "fn", v);
      w = dm.b(paramContext, "pref", "mpn", w);
      x = dm.b(paramContext, "pref", "igu", x);
      y = dm.b(paramContext, "pref", "ms", y);
      bt.a(v, x, y);
      bv.a(x);
    }
    catch (Throwable localThrowable7)
    {
      try
      {
        M = dm.b(paramContext, "pref", "ca", M);
        N = dm.b(paramContext, "pref", "ct", N);
      }
      catch (Throwable localThrowable7)
      {
        try
        {
          h = dm.b(paramContext, "pref", "fr", h);
        }
        catch (Throwable localThrowable7)
        {
          try
          {
            X = dm.b(paramContext, "pref", "ok0", X);
            i = dm.b(paramContext, "pref", "ok1", i);
            Y = dm.b(paramContext, "pref", "ok2", Y);
            Z = dm.b(paramContext, "pref", "ok3", Z);
          }
          catch (Throwable localThrowable7)
          {
            try
            {
              ab = dm.b(paramContext, "pref", "asw", ab);
            }
            catch (Throwable localThrowable7)
            {
              try
              {
                ac = dm.b(paramContext, "pref", "awsi", ac);
              }
              catch (Throwable localThrowable7)
              {
                try
                {
                  for (;;)
                  {
                    ad = dm.b(paramContext, "pref", "15ua", ad);
                    ae = dm.b(paramContext, "pref", "15un", ae);
                    aj = dm.b(paramContext, "pref", "15ust", aj);
                    try
                    {
                      af = dm.b(paramContext, "pref", "ok9", af);
                      ag = dm.b(paramContext, "pref", "ok10", ag);
                      ai = dm.b(paramContext, "pref", "ok11", ai);
                      return;
                    }
                    catch (Throwable paramContext) {}
                    localThrowable2 = localThrowable2;
                    continue;
                    localThrowable3 = localThrowable3;
                    continue;
                    localThrowable4 = localThrowable4;
                    continue;
                    localThrowable5 = localThrowable5;
                    continue;
                    localThrowable6 = localThrowable6;
                    continue;
                    localThrowable7 = localThrowable7;
                  }
                }
                catch (Throwable localThrowable8)
                {
                  for (;;) {}
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean c()
  {
    return r;
  }
  
  public static int d()
  {
    return s;
  }
  
  public static void d(Context paramContext)
  {
    try
    {
      v localv = dg.b();
      localv.a(u);
      aj.a(paramContext, localv);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean e()
  {
    return t;
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      if (dn.b() - f >= d)
      {
        g = true;
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "Aps", "isConfigNeedUpdate");
    }
    return false;
  }
  
  public static ArrayList<String> f()
  {
    return D;
  }
  
  private static void f(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("pref", 0).edit();
      paramContext.putLong("nowtime", C);
      paramContext.putInt("count", 0);
      dm.a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "AuthUtil", "resetPrefsBind");
    }
  }
  
  public static boolean g()
  {
    return u;
  }
  
  public static int h()
  {
    return w;
  }
  
  public static boolean i()
  {
    return z;
  }
  
  public static void j()
  {
    z = false;
  }
  
  public static boolean k()
  {
    return J;
  }
  
  public static long l()
  {
    return N;
  }
  
  public static boolean m()
  {
    return M;
  }
  
  public static boolean n()
  {
    return S;
  }
  
  public static int o()
  {
    return T;
  }
  
  public static boolean p()
  {
    return V;
  }
  
  public static boolean q()
  {
    return W;
  }
  
  public static boolean r()
  {
    if (g)
    {
      g = false;
      return true;
    }
    return g;
  }
  
  public static boolean s()
  {
    return h;
  }
  
  public static boolean t()
  {
    return X;
  }
  
  public static boolean u()
  {
    return Z;
  }
  
  public static boolean v()
  {
    return Y;
  }
  
  public static int w()
  {
    return aa;
  }
  
  public static boolean x()
  {
    return i;
  }
  
  public static boolean y()
  {
    return ab;
  }
  
  public static long z()
  {
    return ac;
  }
  
  static final class a
  {
    boolean a = false;
    String b = "0";
    boolean c = false;
    int d = 5;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */