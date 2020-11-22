package com.tencent.smtt.sdk;

public class a
{
  public static int a = 600;
  private static int b;
  
  /* Error */
  public static int a()
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/smtt/sdk/a:b	I
    //   3: ifle +7 -> 10
    //   6: getstatic 18	com/tencent/smtt/sdk/a:b	I
    //   9: ireturn
    //   10: iconst_0
    //   11: istore_1
    //   12: iconst_0
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: new 20	java/io/BufferedReader
    //   19: dup
    //   20: new 22	java/io/FileReader
    //   23: dup
    //   24: ldc 24
    //   26: invokespecial 28	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   29: sipush 8192
    //   32: invokespecial 31	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   35: astore 5
    //   37: aload 5
    //   39: astore 4
    //   41: aload 5
    //   43: invokevirtual 35	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 6
    //   48: iload_3
    //   49: istore_0
    //   50: aload 6
    //   52: ifnull +106 -> 158
    //   55: aload 5
    //   57: astore 4
    //   59: aload 6
    //   61: ldc 37
    //   63: invokevirtual 43	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   66: istore_0
    //   67: iconst_m1
    //   68: iload_0
    //   69: if_icmpeq -32 -> 37
    //   72: aload 5
    //   74: astore 4
    //   76: aload 6
    //   78: iload_0
    //   79: ldc 37
    //   81: invokevirtual 46	java/lang/String:length	()I
    //   84: iadd
    //   85: invokevirtual 50	java/lang/String:substring	(I)Ljava/lang/String;
    //   88: invokevirtual 53	java/lang/String:trim	()Ljava/lang/String;
    //   91: astore 6
    //   93: iload_3
    //   94: istore_0
    //   95: aload 6
    //   97: ifnull +61 -> 158
    //   100: iload_3
    //   101: istore_0
    //   102: aload 5
    //   104: astore 4
    //   106: aload 6
    //   108: invokevirtual 46	java/lang/String:length	()I
    //   111: ifeq +47 -> 158
    //   114: iload_3
    //   115: istore_0
    //   116: aload 5
    //   118: astore 4
    //   120: aload 6
    //   122: ldc 55
    //   124: invokevirtual 59	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +31 -> 158
    //   130: aload 5
    //   132: astore 4
    //   134: aload 6
    //   136: iconst_0
    //   137: aload 6
    //   139: ldc 55
    //   141: invokevirtual 43	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   144: invokevirtual 62	java/lang/String:substring	(II)Ljava/lang/String;
    //   147: invokevirtual 53	java/lang/String:trim	()Ljava/lang/String;
    //   150: invokestatic 67	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   153: sipush 1024
    //   156: idiv
    //   157: istore_0
    //   158: iload_0
    //   159: istore_1
    //   160: aload 5
    //   162: invokevirtual 70	java/io/BufferedReader:close	()V
    //   165: goto +92 -> 257
    //   168: astore 4
    //   170: aload 4
    //   172: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   175: iload_1
    //   176: istore_0
    //   177: goto +80 -> 257
    //   180: astore 6
    //   182: goto +21 -> 203
    //   185: astore 6
    //   187: goto +47 -> 234
    //   190: astore 5
    //   192: aconst_null
    //   193: astore 4
    //   195: goto +72 -> 267
    //   198: astore 6
    //   200: aconst_null
    //   201: astore 5
    //   203: aload 5
    //   205: astore 4
    //   207: aload 6
    //   209: invokevirtual 74	java/lang/Throwable:printStackTrace	()V
    //   212: iload_2
    //   213: istore_0
    //   214: aload 5
    //   216: ifnull +41 -> 257
    //   219: aload 5
    //   221: invokevirtual 70	java/io/BufferedReader:close	()V
    //   224: iload_2
    //   225: istore_0
    //   226: goto +31 -> 257
    //   229: astore 6
    //   231: aconst_null
    //   232: astore 5
    //   234: aload 5
    //   236: astore 4
    //   238: aload 6
    //   240: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   243: iload_2
    //   244: istore_0
    //   245: aload 5
    //   247: ifnull +10 -> 257
    //   250: aload 5
    //   252: invokevirtual 70	java/io/BufferedReader:close	()V
    //   255: iload_2
    //   256: istore_0
    //   257: iload_0
    //   258: putstatic 18	com/tencent/smtt/sdk/a:b	I
    //   261: getstatic 18	com/tencent/smtt/sdk/a:b	I
    //   264: ireturn
    //   265: astore 5
    //   267: aload 4
    //   269: ifnull +18 -> 287
    //   272: aload 4
    //   274: invokevirtual 70	java/io/BufferedReader:close	()V
    //   277: goto +10 -> 287
    //   280: astore 4
    //   282: aload 4
    //   284: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   287: aload 5
    //   289: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	209	0	i	int
    //   11	165	1	j	int
    //   13	243	2	k	int
    //   15	100	3	m	int
    //   39	94	4	localBufferedReader1	java.io.BufferedReader
    //   168	3	4	localIOException1	java.io.IOException
    //   193	80	4	localObject1	Object
    //   280	3	4	localIOException2	java.io.IOException
    //   35	126	5	localBufferedReader2	java.io.BufferedReader
    //   190	1	5	localObject2	Object
    //   201	50	5	localObject3	Object
    //   265	23	5	localObject4	Object
    //   46	92	6	str	String
    //   180	1	6	localThrowable1	Throwable
    //   185	1	6	localIOException3	java.io.IOException
    //   198	10	6	localThrowable2	Throwable
    //   229	10	6	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   160	165	168	java/io/IOException
    //   219	224	168	java/io/IOException
    //   250	255	168	java/io/IOException
    //   41	48	180	java/lang/Throwable
    //   59	67	180	java/lang/Throwable
    //   76	93	180	java/lang/Throwable
    //   106	114	180	java/lang/Throwable
    //   120	130	180	java/lang/Throwable
    //   134	158	180	java/lang/Throwable
    //   41	48	185	java/io/IOException
    //   59	67	185	java/io/IOException
    //   76	93	185	java/io/IOException
    //   106	114	185	java/io/IOException
    //   120	130	185	java/io/IOException
    //   134	158	185	java/io/IOException
    //   16	37	190	finally
    //   16	37	198	java/lang/Throwable
    //   16	37	229	java/io/IOException
    //   41	48	265	finally
    //   59	67	265	finally
    //   76	93	265	finally
    //   106	114	265	finally
    //   120	130	265	finally
    //   134	158	265	finally
    //   207	212	265	finally
    //   238	243	265	finally
    //   272	277	280	java/io/IOException
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */