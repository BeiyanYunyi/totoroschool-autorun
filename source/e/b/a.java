package e.b;

import e.a.g.f;
import e.s;
import e.u;
import f.c;
import java.io.EOFException;
import java.nio.charset.Charset;

public final class a
  implements u
{
  private static final Charset a = Charset.forName("UTF-8");
  private final b b;
  private volatile a c = a.NONE;
  
  public a()
  {
    this(b.a);
  }
  
  public a(b paramb)
  {
    this.b = paramb;
  }
  
  private boolean a(s params)
  {
    params = params.a("Content-Encoding");
    return (params != null) && (!params.equalsIgnoreCase("identity")) && (!params.equalsIgnoreCase("gzip"));
  }
  
  static boolean a(c paramc)
  {
    for (;;)
    {
      try
      {
        c localc = new c();
        if (paramc.a() < 64L)
        {
          l = paramc.a();
          paramc.a(localc, 0L, l);
          int i = 0;
          if ((i < 16) && (!localc.e()))
          {
            int j = localc.q();
            if (Character.isISOControl(j))
            {
              boolean bool = Character.isWhitespace(j);
              if (!bool) {
                return false;
              }
            }
            i += 1;
            continue;
          }
          return true;
        }
      }
      catch (EOFException paramc)
      {
        return false;
      }
      long l = 64L;
    }
  }
  
  /* Error */
  public e.ac a(e.u.a parama)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	e/b/a:c	Le/b/a$a;
    //   4: astore 12
    //   6: aload_1
    //   7: invokeinterface 105 1 0
    //   12: astore 14
    //   14: aload 12
    //   16: getstatic 42	e/b/a$a:NONE	Le/b/a$a;
    //   19: if_acmpne +12 -> 31
    //   22: aload_1
    //   23: aload 14
    //   25: invokeinterface 108 2 0
    //   30: areturn
    //   31: getstatic 111	e/b/a$a:BODY	Le/b/a$a;
    //   34: astore 13
    //   36: iconst_1
    //   37: istore 4
    //   39: aload 12
    //   41: aload 13
    //   43: if_acmpne +8 -> 51
    //   46: iconst_1
    //   47: istore_2
    //   48: goto +5 -> 53
    //   51: iconst_0
    //   52: istore_2
    //   53: iload_2
    //   54: ifne +19 -> 73
    //   57: aload 12
    //   59: getstatic 114	e/b/a$a:HEADERS	Le/b/a$a;
    //   62: if_acmpne +6 -> 68
    //   65: goto +8 -> 73
    //   68: iconst_0
    //   69: istore_3
    //   70: goto +5 -> 75
    //   73: iconst_1
    //   74: istore_3
    //   75: aload 14
    //   77: invokevirtual 120	e/aa:d	()Le/ab;
    //   80: astore 15
    //   82: aload 15
    //   84: ifnull +6 -> 90
    //   87: goto +6 -> 93
    //   90: iconst_0
    //   91: istore 4
    //   93: aload_1
    //   94: invokeinterface 123 1 0
    //   99: astore 12
    //   101: new 125	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   108: astore 13
    //   110: aload 13
    //   112: ldc -128
    //   114: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 13
    //   120: aload 14
    //   122: invokevirtual 135	e/aa:b	()Ljava/lang/String;
    //   125: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 13
    //   131: bipush 32
    //   133: invokevirtual 138	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 13
    //   139: aload 14
    //   141: invokevirtual 141	e/aa:a	()Le/t;
    //   144: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 12
    //   150: ifnull +43 -> 193
    //   153: new 125	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   160: astore 16
    //   162: aload 16
    //   164: ldc -110
    //   166: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 16
    //   172: aload 12
    //   174: invokeinterface 151 1 0
    //   179: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 16
    //   185: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: astore 12
    //   190: goto +7 -> 197
    //   193: ldc -100
    //   195: astore 12
    //   197: aload 13
    //   199: aload 12
    //   201: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 13
    //   207: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 13
    //   212: aload 13
    //   214: astore 12
    //   216: iload_3
    //   217: ifne +63 -> 280
    //   220: aload 13
    //   222: astore 12
    //   224: iload 4
    //   226: ifeq +54 -> 280
    //   229: new 125	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   236: astore 12
    //   238: aload 12
    //   240: aload 13
    //   242: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 12
    //   248: ldc -98
    //   250: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 12
    //   256: aload 15
    //   258: invokevirtual 163	e/ab:contentLength	()J
    //   261: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 12
    //   267: ldc -88
    //   269: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 12
    //   275: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore 12
    //   280: aload_0
    //   281: getfield 46	e/b/a:b	Le/b/a$b;
    //   284: aload 12
    //   286: invokeinterface 171 2 0
    //   291: iload_3
    //   292: ifeq +595 -> 887
    //   295: iload 4
    //   297: ifeq +115 -> 412
    //   300: aload 15
    //   302: invokevirtual 175	e/ab:contentType	()Le/v;
    //   305: ifnull +49 -> 354
    //   308: aload_0
    //   309: getfield 46	e/b/a:b	Le/b/a$b;
    //   312: astore 12
    //   314: new 125	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   321: astore 13
    //   323: aload 13
    //   325: ldc -79
    //   327: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 13
    //   333: aload 15
    //   335: invokevirtual 175	e/ab:contentType	()Le/v;
    //   338: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 12
    //   344: aload 13
    //   346: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokeinterface 171 2 0
    //   354: aload 15
    //   356: invokevirtual 163	e/ab:contentLength	()J
    //   359: ldc2_w 178
    //   362: lcmp
    //   363: ifeq +49 -> 412
    //   366: aload_0
    //   367: getfield 46	e/b/a:b	Le/b/a$b;
    //   370: astore 12
    //   372: new 125	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   379: astore 13
    //   381: aload 13
    //   383: ldc -75
    //   385: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 13
    //   391: aload 15
    //   393: invokevirtual 163	e/ab:contentLength	()J
    //   396: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 12
    //   402: aload 13
    //   404: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokeinterface 171 2 0
    //   412: aload 14
    //   414: invokevirtual 184	e/aa:c	()Le/s;
    //   417: astore 12
    //   419: aload 12
    //   421: invokevirtual 186	e/s:a	()I
    //   424: istore 6
    //   426: iconst_0
    //   427: istore 5
    //   429: iload 5
    //   431: iload 6
    //   433: if_icmpge +97 -> 530
    //   436: aload 12
    //   438: iload 5
    //   440: invokevirtual 189	e/s:a	(I)Ljava/lang/String;
    //   443: astore 13
    //   445: ldc -65
    //   447: aload 13
    //   449: invokevirtual 62	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   452: ifne +69 -> 521
    //   455: ldc -63
    //   457: aload 13
    //   459: invokevirtual 62	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   462: ifne +59 -> 521
    //   465: aload_0
    //   466: getfield 46	e/b/a:b	Le/b/a$b;
    //   469: astore 16
    //   471: new 125	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   478: astore 17
    //   480: aload 17
    //   482: aload 13
    //   484: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 17
    //   490: ldc -61
    //   492: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 17
    //   498: aload 12
    //   500: iload 5
    //   502: invokevirtual 197	e/s:b	(I)Ljava/lang/String;
    //   505: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 16
    //   511: aload 17
    //   513: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokeinterface 171 2 0
    //   521: iload 5
    //   523: iconst_1
    //   524: iadd
    //   525: istore 5
    //   527: goto -98 -> 429
    //   530: iload_2
    //   531: ifeq +310 -> 841
    //   534: iload 4
    //   536: ifne +6 -> 542
    //   539: goto +302 -> 841
    //   542: aload_0
    //   543: aload 14
    //   545: invokevirtual 184	e/aa:c	()Le/s;
    //   548: invokespecial 199	e/b/a:a	(Le/s;)Z
    //   551: ifeq +60 -> 611
    //   554: aload_0
    //   555: getfield 46	e/b/a:b	Le/b/a$b;
    //   558: astore 12
    //   560: new 125	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   567: astore 13
    //   569: aload 13
    //   571: ldc -55
    //   573: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 13
    //   579: aload 14
    //   581: invokevirtual 135	e/aa:b	()Ljava/lang/String;
    //   584: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 13
    //   590: ldc -53
    //   592: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 12
    //   598: aload 13
    //   600: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokeinterface 171 2 0
    //   608: goto +279 -> 887
    //   611: new 69	f/c
    //   614: dup
    //   615: invokespecial 70	f/c:<init>	()V
    //   618: astore 13
    //   620: aload 15
    //   622: aload 13
    //   624: invokevirtual 207	e/ab:writeTo	(Lf/d;)V
    //   627: getstatic 30	e/b/a:a	Ljava/nio/charset/Charset;
    //   630: astore 12
    //   632: aload 15
    //   634: invokevirtual 175	e/ab:contentType	()Le/v;
    //   637: astore 16
    //   639: aload 16
    //   641: ifnull +13 -> 654
    //   644: aload 16
    //   646: getstatic 30	e/b/a:a	Ljava/nio/charset/Charset;
    //   649: invokevirtual 212	e/v:a	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   652: astore 12
    //   654: aload_0
    //   655: getfield 46	e/b/a:b	Le/b/a$b;
    //   658: ldc -100
    //   660: invokeinterface 171 2 0
    //   665: aload 13
    //   667: invokestatic 214	e/b/a:a	(Lf/c;)Z
    //   670: ifeq +95 -> 765
    //   673: aload_0
    //   674: getfield 46	e/b/a:b	Le/b/a$b;
    //   677: aload 13
    //   679: aload 12
    //   681: invokevirtual 217	f/c:a	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   684: invokeinterface 171 2 0
    //   689: aload_0
    //   690: getfield 46	e/b/a:b	Le/b/a$b;
    //   693: astore 12
    //   695: new 125	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   702: astore 13
    //   704: aload 13
    //   706: ldc -55
    //   708: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 13
    //   714: aload 14
    //   716: invokevirtual 135	e/aa:b	()Ljava/lang/String;
    //   719: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 13
    //   725: ldc -98
    //   727: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload 13
    //   733: aload 15
    //   735: invokevirtual 163	e/ab:contentLength	()J
    //   738: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 13
    //   744: ldc -88
    //   746: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 12
    //   752: aload 13
    //   754: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokeinterface 171 2 0
    //   762: goto +125 -> 887
    //   765: aload_0
    //   766: getfield 46	e/b/a:b	Le/b/a$b;
    //   769: astore 12
    //   771: new 125	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   778: astore 13
    //   780: aload 13
    //   782: ldc -55
    //   784: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload 13
    //   790: aload 14
    //   792: invokevirtual 135	e/aa:b	()Ljava/lang/String;
    //   795: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 13
    //   801: ldc -37
    //   803: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 13
    //   809: aload 15
    //   811: invokevirtual 163	e/ab:contentLength	()J
    //   814: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 13
    //   820: ldc -35
    //   822: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload 12
    //   828: aload 13
    //   830: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokeinterface 171 2 0
    //   838: goto +49 -> 887
    //   841: aload_0
    //   842: getfield 46	e/b/a:b	Le/b/a$b;
    //   845: astore 12
    //   847: new 125	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   854: astore 13
    //   856: aload 13
    //   858: ldc -55
    //   860: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: aload 13
    //   866: aload 14
    //   868: invokevirtual 135	e/aa:b	()Ljava/lang/String;
    //   871: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload 12
    //   877: aload 13
    //   879: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokeinterface 171 2 0
    //   887: invokestatic 226	java/lang/System:nanoTime	()J
    //   890: lstore 7
    //   892: aload_1
    //   893: aload 14
    //   895: invokeinterface 108 2 0
    //   900: astore 15
    //   902: getstatic 232	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   905: invokestatic 226	java/lang/System:nanoTime	()J
    //   908: lload 7
    //   910: lsub
    //   911: invokevirtual 236	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   914: lstore 7
    //   916: aload 15
    //   918: invokevirtual 242	e/ac:g	()Le/ad;
    //   921: astore 16
    //   923: aload 16
    //   925: invokevirtual 245	e/ad:contentLength	()J
    //   928: lstore 9
    //   930: lload 9
    //   932: ldc2_w 178
    //   935: lcmp
    //   936: ifeq +33 -> 969
    //   939: new 125	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   946: astore_1
    //   947: aload_1
    //   948: lload 9
    //   950: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: aload_1
    //   955: ldc -9
    //   957: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload_1
    //   962: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: astore_1
    //   966: goto +6 -> 972
    //   969: ldc -7
    //   971: astore_1
    //   972: aload_0
    //   973: getfield 46	e/b/a:b	Le/b/a$b;
    //   976: astore 13
    //   978: new 125	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   985: astore 14
    //   987: aload 14
    //   989: ldc -5
    //   991: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload 14
    //   997: aload 15
    //   999: invokevirtual 253	e/ac:b	()I
    //   1002: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload 15
    //   1008: invokevirtual 258	e/ac:d	()Ljava/lang/String;
    //   1011: invokevirtual 261	java/lang/String:isEmpty	()Z
    //   1014: ifeq +10 -> 1024
    //   1017: ldc -100
    //   1019: astore 12
    //   1021: goto +38 -> 1059
    //   1024: new 125	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1031: astore 12
    //   1033: aload 12
    //   1035: bipush 32
    //   1037: invokevirtual 138	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload 12
    //   1043: aload 15
    //   1045: invokevirtual 258	e/ac:d	()Ljava/lang/String;
    //   1048: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: pop
    //   1052: aload 12
    //   1054: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: astore 12
    //   1059: aload 14
    //   1061: aload 12
    //   1063: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload 14
    //   1069: bipush 32
    //   1071: invokevirtual 138	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: aload 14
    //   1077: aload 15
    //   1079: invokevirtual 262	e/ac:a	()Le/aa;
    //   1082: invokevirtual 141	e/aa:a	()Le/t;
    //   1085: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1088: pop
    //   1089: aload 14
    //   1091: ldc -98
    //   1093: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: pop
    //   1097: aload 14
    //   1099: lload 7
    //   1101: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1104: pop
    //   1105: aload 14
    //   1107: ldc_w 264
    //   1110: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: iload_3
    //   1115: ifne +46 -> 1161
    //   1118: new 125	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1125: astore 12
    //   1127: aload 12
    //   1129: ldc_w 266
    //   1132: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload 12
    //   1138: aload_1
    //   1139: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload 12
    //   1145: ldc_w 268
    //   1148: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload 12
    //   1154: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: astore_1
    //   1158: goto +6 -> 1164
    //   1161: ldc -100
    //   1163: astore_1
    //   1164: aload 14
    //   1166: aload_1
    //   1167: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: pop
    //   1171: aload 14
    //   1173: bipush 41
    //   1175: invokevirtual 138	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 13
    //   1181: aload 14
    //   1183: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokeinterface 171 2 0
    //   1191: iload_3
    //   1192: ifeq +542 -> 1734
    //   1195: aload 15
    //   1197: invokevirtual 271	e/ac:f	()Le/s;
    //   1200: astore 12
    //   1202: aload 12
    //   1204: invokevirtual 186	e/s:a	()I
    //   1207: istore 4
    //   1209: iconst_0
    //   1210: istore_3
    //   1211: iload_3
    //   1212: iload 4
    //   1214: if_icmpge +67 -> 1281
    //   1217: aload_0
    //   1218: getfield 46	e/b/a:b	Le/b/a$b;
    //   1221: astore_1
    //   1222: new 125	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1229: astore 13
    //   1231: aload 13
    //   1233: aload 12
    //   1235: iload_3
    //   1236: invokevirtual 189	e/s:a	(I)Ljava/lang/String;
    //   1239: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: pop
    //   1243: aload 13
    //   1245: ldc -61
    //   1247: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: pop
    //   1251: aload 13
    //   1253: aload 12
    //   1255: iload_3
    //   1256: invokevirtual 197	e/s:b	(I)Ljava/lang/String;
    //   1259: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: pop
    //   1263: aload_1
    //   1264: aload 13
    //   1266: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokeinterface 171 2 0
    //   1274: iload_3
    //   1275: iconst_1
    //   1276: iadd
    //   1277: istore_3
    //   1278: goto -67 -> 1211
    //   1281: iload_2
    //   1282: ifeq +440 -> 1722
    //   1285: aload 15
    //   1287: invokestatic 276	e/a/c/e:b	(Le/ac;)Z
    //   1290: ifne +6 -> 1296
    //   1293: goto +429 -> 1722
    //   1296: aload_0
    //   1297: aload 15
    //   1299: invokevirtual 271	e/ac:f	()Le/s;
    //   1302: invokespecial 199	e/b/a:a	(Le/s;)Z
    //   1305: ifeq +18 -> 1323
    //   1308: aload_0
    //   1309: getfield 46	e/b/a:b	Le/b/a$b;
    //   1312: ldc_w 278
    //   1315: invokeinterface 171 2 0
    //   1320: aload 15
    //   1322: areturn
    //   1323: aload 16
    //   1325: invokevirtual 282	e/ad:source	()Lf/e;
    //   1328: astore_1
    //   1329: aload_1
    //   1330: ldc2_w 283
    //   1333: invokeinterface 289 3 0
    //   1338: pop
    //   1339: aload_1
    //   1340: invokeinterface 292 1 0
    //   1345: astore_1
    //   1346: ldc 64
    //   1348: aload 12
    //   1350: ldc 49
    //   1352: invokevirtual 54	e/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1355: invokevirtual 62	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1358: istore 11
    //   1360: aconst_null
    //   1361: astore 12
    //   1363: iload 11
    //   1365: ifeq +79 -> 1444
    //   1368: aload_1
    //   1369: invokevirtual 73	f/c:a	()J
    //   1372: invokestatic 298	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1375: astore 13
    //   1377: new 300	f/j
    //   1380: dup
    //   1381: aload_1
    //   1382: invokevirtual 303	f/c:t	()Lf/c;
    //   1385: invokespecial 306	f/j:<init>	(Lf/s;)V
    //   1388: astore_1
    //   1389: new 69	f/c
    //   1392: dup
    //   1393: invokespecial 70	f/c:<init>	()V
    //   1396: astore 14
    //   1398: aload 14
    //   1400: aload_1
    //   1401: invokevirtual 309	f/c:a	(Lf/s;)J
    //   1404: pop2
    //   1405: aload_1
    //   1406: invokevirtual 312	f/j:close	()V
    //   1409: aload 13
    //   1411: astore 12
    //   1413: aload 14
    //   1415: astore_1
    //   1416: goto +31 -> 1447
    //   1419: astore 12
    //   1421: goto +12 -> 1433
    //   1424: astore 13
    //   1426: aload 12
    //   1428: astore_1
    //   1429: aload 13
    //   1431: astore 12
    //   1433: aload_1
    //   1434: ifnull +7 -> 1441
    //   1437: aload_1
    //   1438: invokevirtual 312	f/j:close	()V
    //   1441: aload 12
    //   1443: athrow
    //   1444: aconst_null
    //   1445: astore 12
    //   1447: getstatic 30	e/b/a:a	Ljava/nio/charset/Charset;
    //   1450: astore 13
    //   1452: aload 16
    //   1454: invokevirtual 313	e/ad:contentType	()Le/v;
    //   1457: astore 14
    //   1459: aload 14
    //   1461: ifnull +13 -> 1474
    //   1464: aload 14
    //   1466: getstatic 30	e/b/a:a	Ljava/nio/charset/Charset;
    //   1469: invokevirtual 212	e/v:a	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   1472: astore 13
    //   1474: aload_1
    //   1475: invokestatic 214	e/b/a:a	(Lf/c;)Z
    //   1478: ifne +71 -> 1549
    //   1481: aload_0
    //   1482: getfield 46	e/b/a:b	Le/b/a$b;
    //   1485: ldc -100
    //   1487: invokeinterface 171 2 0
    //   1492: aload_0
    //   1493: getfield 46	e/b/a:b	Le/b/a$b;
    //   1496: astore 12
    //   1498: new 125	java/lang/StringBuilder
    //   1501: dup
    //   1502: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1505: astore 13
    //   1507: aload 13
    //   1509: ldc_w 315
    //   1512: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload 13
    //   1518: aload_1
    //   1519: invokevirtual 73	f/c:a	()J
    //   1522: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload 13
    //   1528: ldc -35
    //   1530: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: aload 12
    //   1536: aload 13
    //   1538: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1541: invokeinterface 171 2 0
    //   1546: aload 15
    //   1548: areturn
    //   1549: lload 9
    //   1551: lconst_0
    //   1552: lcmp
    //   1553: ifeq +32 -> 1585
    //   1556: aload_0
    //   1557: getfield 46	e/b/a:b	Le/b/a$b;
    //   1560: ldc -100
    //   1562: invokeinterface 171 2 0
    //   1567: aload_0
    //   1568: getfield 46	e/b/a:b	Le/b/a$b;
    //   1571: aload_1
    //   1572: invokevirtual 303	f/c:t	()Lf/c;
    //   1575: aload 13
    //   1577: invokevirtual 217	f/c:a	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   1580: invokeinterface 171 2 0
    //   1585: aload 12
    //   1587: ifnull +78 -> 1665
    //   1590: aload_0
    //   1591: getfield 46	e/b/a:b	Le/b/a$b;
    //   1594: astore 13
    //   1596: new 125	java/lang/StringBuilder
    //   1599: dup
    //   1600: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1603: astore 14
    //   1605: aload 14
    //   1607: ldc_w 317
    //   1610: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: pop
    //   1614: aload 14
    //   1616: aload_1
    //   1617: invokevirtual 73	f/c:a	()J
    //   1620: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1623: pop
    //   1624: aload 14
    //   1626: ldc_w 319
    //   1629: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload 14
    //   1635: aload 12
    //   1637: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1640: pop
    //   1641: aload 14
    //   1643: ldc_w 321
    //   1646: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: pop
    //   1650: aload 13
    //   1652: aload 14
    //   1654: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1657: invokeinterface 171 2 0
    //   1662: aload 15
    //   1664: areturn
    //   1665: aload_0
    //   1666: getfield 46	e/b/a:b	Le/b/a$b;
    //   1669: astore 12
    //   1671: new 125	java/lang/StringBuilder
    //   1674: dup
    //   1675: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1678: astore 13
    //   1680: aload 13
    //   1682: ldc_w 317
    //   1685: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: pop
    //   1689: aload 13
    //   1691: aload_1
    //   1692: invokevirtual 73	f/c:a	()J
    //   1695: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1698: pop
    //   1699: aload 13
    //   1701: ldc -88
    //   1703: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1706: pop
    //   1707: aload 12
    //   1709: aload 13
    //   1711: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1714: invokeinterface 171 2 0
    //   1719: aload 15
    //   1721: areturn
    //   1722: aload_0
    //   1723: getfield 46	e/b/a:b	Le/b/a$b;
    //   1726: ldc_w 323
    //   1729: invokeinterface 171 2 0
    //   1734: aload 15
    //   1736: areturn
    //   1737: astore_1
    //   1738: aload_0
    //   1739: getfield 46	e/b/a:b	Le/b/a$b;
    //   1742: astore 12
    //   1744: new 125	java/lang/StringBuilder
    //   1747: dup
    //   1748: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1751: astore 13
    //   1753: aload 13
    //   1755: ldc_w 325
    //   1758: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: pop
    //   1762: aload 13
    //   1764: aload_1
    //   1765: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1768: pop
    //   1769: aload 12
    //   1771: aload 13
    //   1773: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1776: invokeinterface 171 2 0
    //   1781: aload_1
    //   1782: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1783	0	this	a
    //   0	1783	1	parama	e.u.a
    //   47	1235	2	i	int
    //   69	1209	3	j	int
    //   37	1178	4	k	int
    //   427	99	5	m	int
    //   424	10	6	n	int
    //   890	210	7	l1	long
    //   928	622	9	l2	long
    //   1358	6	11	bool	boolean
    //   4	1408	12	localObject1	Object
    //   1419	8	12	localObject2	Object
    //   1431	339	12	localObject3	Object
    //   34	1376	13	localObject4	Object
    //   1424	6	13	localObject5	Object
    //   1450	322	13	localObject6	Object
    //   12	1641	14	localObject7	Object
    //   80	1655	15	localObject8	Object
    //   160	1293	16	localObject9	Object
    //   478	34	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1389	1405	1419	finally
    //   1377	1389	1424	finally
    //   892	902	1737	java/lang/Exception
  }
  
  public a a(a parama)
  {
    if (parama != null)
    {
      this.c = parama;
      return this;
    }
    throw new NullPointerException("level == null. Use Level.NONE instead.");
  }
  
  public static enum a
  {
    static
    {
      BASIC = new a("BASIC", 1);
      HEADERS = new a("HEADERS", 2);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public static final b a = new b()
    {
      public void a(String paramAnonymousString)
      {
        f.c().a(4, paramAnonymousString, null);
      }
    };
    
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */