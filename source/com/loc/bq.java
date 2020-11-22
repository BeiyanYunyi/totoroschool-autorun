package com.loc;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class bq
{
  private static void a(bf parambf, List<String> paramList)
  {
    if (parambf != null) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          parambf.c((String)paramList.next());
        }
        parambf.close();
        return;
      }
      catch (Throwable parambf)
      {
        aj.b(parambf, "ofm", "dlo");
      }
    }
  }
  
  /* Error */
  public static void a(bp parambp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_3
    //   9: astore_1
    //   10: aload 5
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 56	com/loc/bp:f	Lcom/loc/cj;
    //   17: invokevirtual 60	com/loc/cj:c	()Z
    //   20: ifeq +224 -> 244
    //   23: aload 5
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 56	com/loc/bp:f	Lcom/loc/cj;
    //   30: iconst_1
    //   31: invokevirtual 63	com/loc/cj:a	(Z)V
    //   34: aload 5
    //   36: astore_2
    //   37: new 65	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: getfield 68	com/loc/bp:a	Ljava/lang/String;
    //   45: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 75	com/loc/bp:b	J
    //   52: invokestatic 78	com/loc/bf:a	(Ljava/io/File;J)Lcom/loc/bf;
    //   55: astore_1
    //   56: new 80	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 82	java/util/ArrayList:<init>	()V
    //   63: astore_2
    //   64: aload_1
    //   65: aload_0
    //   66: aload_2
    //   67: invokestatic 85	com/loc/bq:a	(Lcom/loc/bf;Lcom/loc/bp;Ljava/util/List;)[B
    //   70: astore 4
    //   72: aload 4
    //   74: ifnull +143 -> 217
    //   77: aload 4
    //   79: arraylength
    //   80: ifne +6 -> 86
    //   83: goto +134 -> 217
    //   86: new 87	com/loc/ai
    //   89: dup
    //   90: aload 4
    //   92: aload_0
    //   93: getfield 89	com/loc/bp:c	Ljava/lang/String;
    //   96: invokespecial 92	com/loc/ai:<init>	([BLjava/lang/String;)V
    //   99: astore 5
    //   101: invokestatic 97	com/loc/bj:a	()Lcom/loc/bj;
    //   104: pop
    //   105: new 99	org/json/JSONObject
    //   108: dup
    //   109: new 26	java/lang/String
    //   112: dup
    //   113: aload 5
    //   115: invokestatic 102	com/loc/bj:b	(Lcom/loc/bn;)[B
    //   118: invokespecial 105	java/lang/String:<init>	([B)V
    //   121: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   124: astore 5
    //   126: aload 5
    //   128: ldc 108
    //   130: invokevirtual 111	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   133: ifeq +81 -> 214
    //   136: aload 5
    //   138: ldc 108
    //   140: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   143: iconst_1
    //   144: if_icmpne +70 -> 214
    //   147: aload_0
    //   148: getfield 56	com/loc/bp:f	Lcom/loc/cj;
    //   151: ifnull +18 -> 169
    //   154: aload 4
    //   156: ifnull +13 -> 169
    //   159: aload_0
    //   160: getfield 56	com/loc/bp:f	Lcom/loc/cj;
    //   163: aload 4
    //   165: arraylength
    //   166: invokevirtual 118	com/loc/cj:a	(I)V
    //   169: aload_0
    //   170: getfield 56	com/loc/bp:f	Lcom/loc/cj;
    //   173: invokevirtual 121	com/loc/cj:b	()I
    //   176: ldc 122
    //   178: if_icmpge +13 -> 191
    //   181: aload_1
    //   182: aload_2
    //   183: invokestatic 124	com/loc/bq:a	(Lcom/loc/bf;Ljava/util/List;)V
    //   186: aload_3
    //   187: astore_1
    //   188: goto +56 -> 244
    //   191: aload_1
    //   192: invokevirtual 127	com/loc/bf:d	()V
    //   195: aload_3
    //   196: astore_1
    //   197: goto +47 -> 244
    //   200: astore_0
    //   201: aload_0
    //   202: ldc 38
    //   204: ldc 40
    //   206: invokestatic 46	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload_3
    //   210: astore_1
    //   211: goto +33 -> 244
    //   214: goto +30 -> 244
    //   217: aload_1
    //   218: ifnull +13 -> 231
    //   221: aload_1
    //   222: invokevirtual 36	com/loc/bf:close	()V
    //   225: return
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   231: return
    //   232: astore_0
    //   233: goto +61 -> 294
    //   236: astore_2
    //   237: aload_1
    //   238: astore_0
    //   239: aload_2
    //   240: astore_1
    //   241: goto +28 -> 269
    //   244: aload_1
    //   245: ifnull +13 -> 258
    //   248: aload_1
    //   249: invokevirtual 36	com/loc/bf:close	()V
    //   252: return
    //   253: astore_0
    //   254: aload_0
    //   255: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   258: return
    //   259: astore_0
    //   260: aload_2
    //   261: astore_1
    //   262: goto +32 -> 294
    //   265: astore_1
    //   266: aload 4
    //   268: astore_0
    //   269: aload_0
    //   270: astore_2
    //   271: aload_1
    //   272: ldc -124
    //   274: ldc -122
    //   276: invokestatic 46	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_0
    //   280: ifnull +13 -> 293
    //   283: aload_0
    //   284: invokevirtual 36	com/loc/bf:close	()V
    //   287: return
    //   288: astore_0
    //   289: aload_0
    //   290: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   293: return
    //   294: aload_1
    //   295: ifnull +15 -> 310
    //   298: aload_1
    //   299: invokevirtual 36	com/loc/bf:close	()V
    //   302: goto +8 -> 310
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   310: aload_0
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	parambp	bp
    //   9	253	1	localObject1	Object
    //   265	34	1	localThrowable1	Throwable
    //   305	2	1	localThrowable2	Throwable
    //   12	171	2	localObject2	Object
    //   236	25	2	localThrowable3	Throwable
    //   270	1	2	localbp	bp
    //   7	203	3	localObject3	Object
    //   4	263	4	arrayOfByte	byte[]
    //   1	136	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   191	195	200	java/lang/Throwable
    //   221	225	226	java/lang/Throwable
    //   56	72	232	finally
    //   77	83	232	finally
    //   86	154	232	finally
    //   159	169	232	finally
    //   169	186	232	finally
    //   191	195	232	finally
    //   201	209	232	finally
    //   56	72	236	java/lang/Throwable
    //   77	83	236	java/lang/Throwable
    //   86	154	236	java/lang/Throwable
    //   159	169	236	java/lang/Throwable
    //   169	186	236	java/lang/Throwable
    //   201	209	236	java/lang/Throwable
    //   248	252	253	java/lang/Throwable
    //   13	23	259	finally
    //   26	34	259	finally
    //   37	56	259	finally
    //   271	279	259	finally
    //   13	23	265	java/lang/Throwable
    //   26	34	265	java/lang/Throwable
    //   37	56	265	java/lang/Throwable
    //   283	287	288	java/lang/Throwable
    //   298	302	305	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte, bp parambp)
    throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: getfield 68	com/loc/bp:a	Ljava/lang/String;
    //   6: aload_0
    //   7: invokestatic 154	com/loc/bq:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: new 65	java/io/File
    //   17: dup
    //   18: aload_2
    //   19: getfield 68	com/loc/bp:a	Ljava/lang/String;
    //   22: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 157	java/io/File:exists	()Z
    //   32: ifne +9 -> 41
    //   35: aload 4
    //   37: invokevirtual 160	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: aload 4
    //   43: aload_2
    //   44: getfield 75	com/loc/bp:b	J
    //   47: aload_2
    //   48: getfield 163	com/loc/bp:d	I
    //   51: i2l
    //   52: lmul
    //   53: invokestatic 78	com/loc/bf:a	(Ljava/io/File;J)Lcom/loc/bf;
    //   56: astore 4
    //   58: aload 4
    //   60: aload_2
    //   61: getfield 163	com/loc/bp:d	I
    //   64: invokevirtual 164	com/loc/bf:a	(I)V
    //   67: aload_2
    //   68: getfield 168	com/loc/bp:e	Lcom/loc/aa;
    //   71: aload_1
    //   72: invokevirtual 173	com/loc/aa:b	([B)[B
    //   75: astore_1
    //   76: aload 4
    //   78: aload_0
    //   79: invokevirtual 176	com/loc/bf:b	(Ljava/lang/String;)Lcom/loc/bf$a;
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 181	com/loc/bf$a:a	()Ljava/io/OutputStream;
    //   87: astore_2
    //   88: aload_2
    //   89: aload_1
    //   90: invokevirtual 186	java/io/OutputStream:write	([B)V
    //   93: aload_0
    //   94: invokevirtual 188	com/loc/bf$a:b	()V
    //   97: aload 4
    //   99: invokevirtual 190	com/loc/bf:c	()V
    //   102: aload_2
    //   103: ifnull +15 -> 118
    //   106: aload_2
    //   107: invokevirtual 191	java/io/OutputStream:close	()V
    //   110: goto +8 -> 118
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   118: aload 4
    //   120: ifnull +14 -> 134
    //   123: aload 4
    //   125: invokevirtual 36	com/loc/bf:close	()V
    //   128: return
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   134: return
    //   135: astore_0
    //   136: aload 4
    //   138: astore_1
    //   139: goto +17 -> 156
    //   142: astore_0
    //   143: aload_3
    //   144: astore_2
    //   145: aload 4
    //   147: astore_1
    //   148: goto +8 -> 156
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_3
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +15 -> 172
    //   160: aload_2
    //   161: invokevirtual 191	java/io/OutputStream:close	()V
    //   164: goto +8 -> 172
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   172: aload_1
    //   173: ifnull +15 -> 188
    //   176: aload_1
    //   177: invokevirtual 36	com/loc/bf:close	()V
    //   180: goto +8 -> 188
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   188: aload_0
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString	String
    //   0	190	1	paramArrayOfByte	byte[]
    //   0	190	2	parambp	bp
    //   1	154	3	localObject1	Object
    //   25	121	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   106	110	113	java/lang/Throwable
    //   123	128	129	java/lang/Throwable
    //   88	102	135	finally
    //   58	88	142	finally
    //   2	13	151	finally
    //   14	41	151	finally
    //   41	58	151	finally
    //   160	164	167	java/lang/Throwable
    //   176	180	183	java/lang/Throwable
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".0");
      boolean bool = new File(paramString1, localStringBuilder.toString()).exists();
      return bool;
    }
    catch (Throwable paramString1)
    {
      aj.b(paramString1, "leg", "fet");
    }
    return false;
  }
  
  private static byte[] a(bf parambf, bp parambp, List<String> paramList)
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        Object localObject = parambf.b();
        if ((localObject != null) && (((File)localObject).exists()))
        {
          localObject = ((File)localObject).list();
          int m = localObject.length;
          i = 0;
          j = 0;
          if (i < m)
          {
            String str = localObject[i];
            k = j;
            if (!str.contains(".0")) {
              break label145;
            }
            str = str.split("\\.")[0];
            byte[] arrayOfByte = bw.a(parambf, str);
            k = j + arrayOfByte.length;
            paramList.add(str);
            if (k <= parambp.f.b())
            {
              parambp.g.b(arrayOfByte);
              break label145;
            }
          }
          parambf = parambp.g.a();
          return parambf;
        }
      }
      catch (Throwable parambf)
      {
        aj.b(parambf, "leg", "gCo");
      }
      return new byte[0];
      label145:
      i += 1;
      int j = k;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */