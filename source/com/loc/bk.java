package com.loc;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public abstract class bk
  extends bn
{
  protected Context a;
  protected v b;
  
  public bk(Context paramContext, v paramv)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
    this.b = paramv;
  }
  
  protected static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return new byte[] { (byte)(i / 256), (byte)(i % 256) };
  }
  
  /* Error */
  private static byte[] l()
  {
    // Byte code:
    //   0: new 31	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 32	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_0
    //   8: aload_0
    //   9: ldc 34
    //   11: invokestatic 39	com/loc/w:a	(Ljava/lang/String;)[B
    //   14: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   17: aload_0
    //   18: iconst_1
    //   19: newarray <illegal type>
    //   21: dup
    //   22: iconst_0
    //   23: iconst_1
    //   24: bastore
    //   25: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   28: aload_0
    //   29: iconst_1
    //   30: newarray <illegal type>
    //   32: dup
    //   33: iconst_0
    //   34: iconst_0
    //   35: bastore
    //   36: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   39: aload_0
    //   40: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: astore_1
    //   44: aload_0
    //   45: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   48: aload_1
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: ldc 51
    //   54: ldc 53
    //   56: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: goto +30 -> 92
    //   65: astore_1
    //   66: aload_1
    //   67: ldc 51
    //   69: ldc 53
    //   71: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   78: goto +12 -> 90
    //   81: astore_0
    //   82: aload_0
    //   83: ldc 51
    //   85: ldc 53
    //   87: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aconst_null
    //   91: areturn
    //   92: aload_0
    //   93: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   96: goto +12 -> 108
    //   99: astore_0
    //   100: aload_0
    //   101: ldc 51
    //   103: ldc 53
    //   105: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	38	0	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   50	25	0	localThrowable1	Throwable
    //   81	12	0	localThrowable2	Throwable
    //   99	2	0	localThrowable3	Throwable
    //   43	17	1	arrayOfByte	byte[]
    //   61	1	1	localObject	Object
    //   65	44	1	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/lang/Throwable
    //   8	44	61	finally
    //   66	74	61	finally
    //   8	44	65	java/lang/Throwable
    //   74	78	81	java/lang/Throwable
    //   92	96	99	java/lang/Throwable
  }
  
  /* Error */
  private byte[] m()
  {
    // Byte code:
    //   0: new 31	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 32	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: iconst_1
    //   12: newarray <illegal type>
    //   14: dup
    //   15: iconst_0
    //   16: iconst_3
    //   17: bastore
    //   18: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   21: aload_0
    //   22: invokevirtual 63	com/loc/bk:g	()Z
    //   25: ifeq +65 -> 90
    //   28: aload_0
    //   29: getfield 21	com/loc/bk:a	Landroid/content/Context;
    //   32: astore_3
    //   33: aload_0
    //   34: invokevirtual 66	com/loc/bk:i	()Z
    //   37: istore_2
    //   38: aload_0
    //   39: getfield 23	com/loc/bk:b	Lcom/loc/v;
    //   42: ifnull +260 -> 302
    //   45: ldc 68
    //   47: aload_0
    //   48: getfield 23	com/loc/bk:b	Lcom/loc/v;
    //   51: invokevirtual 73	com/loc/v:a	()Ljava/lang/String;
    //   54: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +245 -> 302
    //   60: iconst_1
    //   61: istore_1
    //   62: goto +3 -> 65
    //   65: aload_3
    //   66: iload_2
    //   67: iload_1
    //   68: invokestatic 84	com/loc/n:a	(Landroid/content/Context;ZZ)[B
    //   71: astore_3
    //   72: aload 4
    //   74: aload_3
    //   75: invokestatic 86	com/loc/bk:a	([B)[B
    //   78: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   81: aload 4
    //   83: aload_3
    //   84: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   87: goto +22 -> 109
    //   90: iconst_2
    //   91: newarray <illegal type>
    //   93: astore_3
    //   94: aload_3
    //   95: dup
    //   96: iconst_0
    //   97: ldc 87
    //   99: bastore
    //   100: dup
    //   101: iconst_1
    //   102: ldc 87
    //   104: bastore
    //   105: pop
    //   106: goto -25 -> 81
    //   109: aload_0
    //   110: invokevirtual 90	com/loc/bk:f	()Ljava/lang/String;
    //   113: invokestatic 39	com/loc/w:a	(Ljava/lang/String;)[B
    //   116: astore_3
    //   117: aload_3
    //   118: ifnull +26 -> 144
    //   121: aload_3
    //   122: arraylength
    //   123: ifle +21 -> 144
    //   126: aload 4
    //   128: aload_3
    //   129: invokestatic 86	com/loc/bk:a	([B)[B
    //   132: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   135: aload 4
    //   137: aload_3
    //   138: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   141: goto +22 -> 163
    //   144: iconst_2
    //   145: newarray <illegal type>
    //   147: astore_3
    //   148: aload_3
    //   149: dup
    //   150: iconst_0
    //   151: ldc 87
    //   153: bastore
    //   154: dup
    //   155: iconst_1
    //   156: ldc 87
    //   158: bastore
    //   159: pop
    //   160: goto -25 -> 135
    //   163: aload_0
    //   164: invokevirtual 93	com/loc/bk:h	()Ljava/lang/String;
    //   167: invokestatic 39	com/loc/w:a	(Ljava/lang/String;)[B
    //   170: astore_3
    //   171: aload_3
    //   172: ifnull +26 -> 198
    //   175: aload_3
    //   176: arraylength
    //   177: ifle +21 -> 198
    //   180: aload 4
    //   182: aload_3
    //   183: invokestatic 86	com/loc/bk:a	([B)[B
    //   186: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   189: aload 4
    //   191: aload_3
    //   192: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   195: goto +22 -> 217
    //   198: iconst_2
    //   199: newarray <illegal type>
    //   201: astore_3
    //   202: aload_3
    //   203: dup
    //   204: iconst_0
    //   205: ldc 87
    //   207: bastore
    //   208: dup
    //   209: iconst_1
    //   210: ldc 87
    //   212: bastore
    //   213: pop
    //   214: goto -25 -> 189
    //   217: aload 4
    //   219: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: astore_3
    //   223: aload 4
    //   225: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   228: aload_3
    //   229: areturn
    //   230: astore 4
    //   232: aload 4
    //   234: ldc 51
    //   236: ldc 95
    //   238: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_3
    //   242: areturn
    //   243: astore_3
    //   244: goto +37 -> 281
    //   247: astore_3
    //   248: aload_3
    //   249: ldc 51
    //   251: ldc 97
    //   253: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload 4
    //   258: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   261: goto +12 -> 273
    //   264: astore_3
    //   265: aload_3
    //   266: ldc 51
    //   268: ldc 95
    //   270: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   273: iconst_1
    //   274: newarray <illegal type>
    //   276: dup
    //   277: iconst_0
    //   278: iconst_0
    //   279: bastore
    //   280: areturn
    //   281: aload 4
    //   283: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   286: goto +14 -> 300
    //   289: astore 4
    //   291: aload 4
    //   293: ldc 51
    //   295: ldc 95
    //   297: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload_3
    //   301: athrow
    //   302: iconst_0
    //   303: istore_1
    //   304: goto -239 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	bk
    //   61	243	1	bool1	boolean
    //   37	30	2	bool2	boolean
    //   32	210	3	localObject1	Object
    //   243	1	3	localObject2	Object
    //   247	2	3	localThrowable1	Throwable
    //   264	37	3	localThrowable2	Throwable
    //   7	217	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   230	52	4	localThrowable3	Throwable
    //   289	3	4	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   223	228	230	java/lang/Throwable
    //   9	60	243	finally
    //   65	81	243	finally
    //   81	87	243	finally
    //   90	106	243	finally
    //   109	117	243	finally
    //   121	135	243	finally
    //   135	141	243	finally
    //   144	160	243	finally
    //   163	171	243	finally
    //   175	189	243	finally
    //   189	195	243	finally
    //   198	214	243	finally
    //   217	223	243	finally
    //   248	256	243	finally
    //   9	60	247	java/lang/Throwable
    //   65	81	247	java/lang/Throwable
    //   81	87	247	java/lang/Throwable
    //   90	106	247	java/lang/Throwable
    //   109	117	247	java/lang/Throwable
    //   121	135	247	java/lang/Throwable
    //   135	141	247	java/lang/Throwable
    //   144	160	247	java/lang/Throwable
    //   163	171	247	java/lang/Throwable
    //   175	189	247	java/lang/Throwable
    //   189	195	247	java/lang/Throwable
    //   198	214	247	java/lang/Throwable
    //   217	223	247	java/lang/Throwable
    //   256	261	264	java/lang/Throwable
    //   281	286	289	java/lang/Throwable
  }
  
  /* Error */
  private byte[] n()
  {
    // Byte code:
    //   0: new 31	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 32	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 101	com/loc/bk:a_	()[B
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +57 -> 71
    //   17: aload_2
    //   18: arraylength
    //   19: ifne +6 -> 25
    //   22: goto +49 -> 71
    //   25: aload_1
    //   26: iconst_1
    //   27: newarray <illegal type>
    //   29: dup
    //   30: iconst_0
    //   31: iconst_1
    //   32: bastore
    //   33: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 86	com/loc/bk:a	([B)[B
    //   41: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   49: aload_1
    //   50: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   53: astore_2
    //   54: aload_1
    //   55: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   58: aload_2
    //   59: areturn
    //   60: astore_1
    //   61: aload_1
    //   62: ldc 51
    //   64: ldc 103
    //   66: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_2
    //   70: areturn
    //   71: aload_1
    //   72: iconst_1
    //   73: newarray <illegal type>
    //   75: dup
    //   76: iconst_0
    //   77: iconst_0
    //   78: bastore
    //   79: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   82: aload_1
    //   83: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   86: astore_2
    //   87: aload_1
    //   88: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aload_1
    //   95: ldc 51
    //   97: ldc 103
    //   99: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_2
    //   103: areturn
    //   104: astore_2
    //   105: goto +36 -> 141
    //   108: astore_2
    //   109: aload_2
    //   110: ldc 51
    //   112: ldc 103
    //   114: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   121: goto +12 -> 133
    //   124: astore_1
    //   125: aload_1
    //   126: ldc 51
    //   128: ldc 103
    //   130: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   133: iconst_1
    //   134: newarray <illegal type>
    //   136: dup
    //   137: iconst_0
    //   138: iconst_0
    //   139: bastore
    //   140: areturn
    //   141: aload_1
    //   142: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   145: goto +12 -> 157
    //   148: astore_1
    //   149: aload_1
    //   150: ldc 51
    //   152: ldc 103
    //   154: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_2
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	bk
    //   7	48	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   60	28	1	localThrowable1	Throwable
    //   93	25	1	localThrowable2	Throwable
    //   124	18	1	localThrowable3	Throwable
    //   148	2	1	localThrowable4	Throwable
    //   12	91	2	arrayOfByte	byte[]
    //   104	1	2	localObject	Object
    //   108	50	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   54	58	60	java/lang/Throwable
    //   87	91	93	java/lang/Throwable
    //   8	13	104	finally
    //   17	22	104	finally
    //   25	54	104	finally
    //   71	87	104	finally
    //   109	117	104	finally
    //   8	13	108	java/lang/Throwable
    //   17	22	108	java/lang/Throwable
    //   25	54	108	java/lang/Throwable
    //   71	87	108	java/lang/Throwable
    //   117	121	124	java/lang/Throwable
    //   141	145	148	java/lang/Throwable
  }
  
  /* Error */
  private byte[] o()
  {
    // Byte code:
    //   0: new 31	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 32	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 107	com/loc/bk:e	()[B
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +62 -> 76
    //   17: aload_2
    //   18: arraylength
    //   19: ifne +6 -> 25
    //   22: goto +54 -> 76
    //   25: aload_1
    //   26: iconst_1
    //   27: newarray <illegal type>
    //   29: dup
    //   30: iconst_0
    //   31: iconst_1
    //   32: bastore
    //   33: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   36: aload_2
    //   37: invokestatic 110	com/loc/q:a	([B)[B
    //   40: astore_2
    //   41: aload_1
    //   42: aload_2
    //   43: invokestatic 86	com/loc/bk:a	([B)[B
    //   46: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   54: aload_1
    //   55: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   58: astore_2
    //   59: aload_1
    //   60: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_2
    //   64: areturn
    //   65: astore_1
    //   66: aload_1
    //   67: ldc 51
    //   69: ldc 95
    //   71: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_2
    //   75: areturn
    //   76: aload_1
    //   77: iconst_1
    //   78: newarray <illegal type>
    //   80: dup
    //   81: iconst_0
    //   82: iconst_0
    //   83: bastore
    //   84: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   87: aload_1
    //   88: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   91: astore_2
    //   92: aload_1
    //   93: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_2
    //   97: areturn
    //   98: astore_1
    //   99: aload_1
    //   100: ldc 51
    //   102: ldc 95
    //   104: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_2
    //   108: areturn
    //   109: astore_2
    //   110: goto +36 -> 146
    //   113: astore_2
    //   114: aload_2
    //   115: ldc 51
    //   117: ldc 95
    //   119: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   126: goto +12 -> 138
    //   129: astore_1
    //   130: aload_1
    //   131: ldc 51
    //   133: ldc 95
    //   135: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   138: iconst_1
    //   139: newarray <illegal type>
    //   141: dup
    //   142: iconst_0
    //   143: iconst_0
    //   144: bastore
    //   145: areturn
    //   146: aload_1
    //   147: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   150: goto +12 -> 162
    //   153: astore_1
    //   154: aload_1
    //   155: ldc 51
    //   157: ldc 95
    //   159: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	bk
    //   7	53	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   65	28	1	localThrowable1	Throwable
    //   98	25	1	localThrowable2	Throwable
    //   129	18	1	localThrowable3	Throwable
    //   153	2	1	localThrowable4	Throwable
    //   12	96	2	arrayOfByte	byte[]
    //   109	1	2	localObject	Object
    //   113	50	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   59	63	65	java/lang/Throwable
    //   92	96	98	java/lang/Throwable
    //   8	13	109	finally
    //   17	22	109	finally
    //   25	59	109	finally
    //   76	92	109	finally
    //   114	122	109	finally
    //   8	13	113	java/lang/Throwable
    //   17	22	113	java/lang/Throwable
    //   25	59	113	java/lang/Throwable
    //   76	92	113	java/lang/Throwable
    //   122	126	129	java/lang/Throwable
    //   146	150	153	java/lang/Throwable
  }
  
  public abstract byte[] a_();
  
  public Map<String, String> b_()
  {
    String str1 = l.f(this.a);
    String str2 = n.a();
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder("key=");
    ((StringBuilder)localObject2).append(str1);
    localObject1 = n.a((Context)localObject1, str2, ((StringBuilder)localObject2).toString());
    localObject2 = new HashMap();
    ((Map)localObject2).put("ts", str2);
    ((Map)localObject2).put("key", str1);
    ((Map)localObject2).put("scode", localObject1);
    return (Map<String, String>)localObject2;
  }
  
  /* Error */
  public final byte[] d()
  {
    // Byte code:
    //   0: new 31	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 32	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 155	com/loc/bk:l	()[B
    //   12: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   15: aload_1
    //   16: aload_0
    //   17: invokespecial 157	com/loc/bk:m	()[B
    //   20: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   23: aload_1
    //   24: aload_0
    //   25: invokespecial 159	com/loc/bk:n	()[B
    //   28: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   31: aload_1
    //   32: aload_0
    //   33: invokespecial 161	com/loc/bk:o	()[B
    //   36: invokevirtual 43	java/io/ByteArrayOutputStream:write	([B)V
    //   39: aload_1
    //   40: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_1
    //   51: aload_1
    //   52: ldc 51
    //   54: ldc -93
    //   56: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: goto +30 -> 92
    //   65: astore_2
    //   66: aload_2
    //   67: ldc 51
    //   69: ldc -93
    //   71: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   78: goto +12 -> 90
    //   81: astore_1
    //   82: aload_1
    //   83: ldc 51
    //   85: ldc -93
    //   87: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aconst_null
    //   91: areturn
    //   92: aload_1
    //   93: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   96: goto +12 -> 108
    //   99: astore_1
    //   100: aload_1
    //   101: ldc 51
    //   103: ldc -93
    //   105: invokestatic 58	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	bk
    //   7	38	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   50	25	1	localThrowable1	Throwable
    //   81	12	1	localThrowable2	Throwable
    //   99	2	1	localThrowable3	Throwable
    //   43	17	2	arrayOfByte	byte[]
    //   61	1	2	localObject	Object
    //   65	44	2	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/lang/Throwable
    //   8	44	61	finally
    //   66	74	61	finally
    //   8	44	65	java/lang/Throwable
    //   74	78	81	java/lang/Throwable
    //   92	96	99	java/lang/Throwable
  }
  
  public abstract byte[] e();
  
  protected String f()
  {
    return "2.1";
  }
  
  public boolean g()
  {
    return true;
  }
  
  public String h()
  {
    return String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { this.b.c(), this.b.a() });
  }
  
  protected boolean i()
  {
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */