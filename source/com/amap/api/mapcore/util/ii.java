package com.amap.api.mapcore.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ii
{
  private static void a(hs paramhs)
  {
    if (paramhs != null) {
      try
      {
        paramhs.f();
        return;
      }
      catch (Throwable paramhs)
      {
        gk.c(paramhs, "ofm", "dlo");
      }
    }
  }
  
  private static void a(hs paramhs, List<String> paramList)
  {
    if (paramhs != null) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          paramhs.c((String)paramList.next());
        }
        paramhs.close();
        return;
      }
      catch (Throwable paramhs)
      {
        gk.c(paramhs, "ofm", "dlo");
      }
    }
  }
  
  /* Error */
  public static void a(ih paramih)
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
    //   14: getfield 58	com/amap/api/mapcore/util/ih:f	Lcom/amap/api/mapcore/util/jc;
    //   17: invokevirtual 62	com/amap/api/mapcore/util/jc:c	()Z
    //   20: ifeq +211 -> 231
    //   23: aload 5
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 58	com/amap/api/mapcore/util/ih:f	Lcom/amap/api/mapcore/util/jc;
    //   30: iconst_1
    //   31: invokevirtual 65	com/amap/api/mapcore/util/jc:a	(Z)V
    //   34: aload 5
    //   36: astore_2
    //   37: new 67	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: getfield 70	com/amap/api/mapcore/util/ih:a	Ljava/lang/String;
    //   45: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: iconst_1
    //   49: iconst_1
    //   50: aload_0
    //   51: getfield 78	com/amap/api/mapcore/util/ih:b	J
    //   54: invokestatic 81	com/amap/api/mapcore/util/hs:a	(Ljava/io/File;IIJ)Lcom/amap/api/mapcore/util/hs;
    //   57: astore_1
    //   58: new 83	java/util/ArrayList
    //   61: dup
    //   62: invokespecial 85	java/util/ArrayList:<init>	()V
    //   65: astore_2
    //   66: aload_1
    //   67: aload_0
    //   68: aload_2
    //   69: invokestatic 88	com/amap/api/mapcore/util/ii:a	(Lcom/amap/api/mapcore/util/hs;Lcom/amap/api/mapcore/util/ih;Ljava/util/List;)[B
    //   72: astore 4
    //   74: aload 4
    //   76: ifnull +128 -> 204
    //   79: aload 4
    //   81: arraylength
    //   82: ifne +6 -> 88
    //   85: goto +119 -> 204
    //   88: new 90	com/amap/api/mapcore/util/gj
    //   91: dup
    //   92: aload 4
    //   94: aload_0
    //   95: getfield 92	com/amap/api/mapcore/util/ih:c	Ljava/lang/String;
    //   98: invokespecial 95	com/amap/api/mapcore/util/gj:<init>	([BLjava/lang/String;)V
    //   101: astore 5
    //   103: new 97	org/json/JSONObject
    //   106: dup
    //   107: new 44	java/lang/String
    //   110: dup
    //   111: invokestatic 102	com/amap/api/mapcore/util/hx:a	()Lcom/amap/api/mapcore/util/hx;
    //   114: aload 5
    //   116: invokevirtual 105	com/amap/api/mapcore/util/hx:b	(Lcom/amap/api/mapcore/util/ic;)[B
    //   119: invokespecial 108	java/lang/String:<init>	([B)V
    //   122: invokespecial 109	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   125: astore 5
    //   127: aload 5
    //   129: ldc 111
    //   131: invokevirtual 114	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   134: ifeq +67 -> 201
    //   137: aload 5
    //   139: ldc 111
    //   141: invokevirtual 118	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   144: iconst_1
    //   145: if_icmpne +56 -> 201
    //   148: aload_0
    //   149: getfield 58	com/amap/api/mapcore/util/ih:f	Lcom/amap/api/mapcore/util/jc;
    //   152: ifnull +18 -> 170
    //   155: aload 4
    //   157: ifnull +13 -> 170
    //   160: aload_0
    //   161: getfield 58	com/amap/api/mapcore/util/ih:f	Lcom/amap/api/mapcore/util/jc;
    //   164: aload 4
    //   166: arraylength
    //   167: invokevirtual 121	com/amap/api/mapcore/util/jc:a	(I)V
    //   170: aload_0
    //   171: getfield 58	com/amap/api/mapcore/util/ih:f	Lcom/amap/api/mapcore/util/jc;
    //   174: invokevirtual 124	com/amap/api/mapcore/util/jc:b	()I
    //   177: ldc 125
    //   179: if_icmpge +13 -> 192
    //   182: aload_1
    //   183: aload_2
    //   184: invokestatic 127	com/amap/api/mapcore/util/ii:a	(Lcom/amap/api/mapcore/util/hs;Ljava/util/List;)V
    //   187: aload_3
    //   188: astore_1
    //   189: goto +42 -> 231
    //   192: aload_1
    //   193: invokestatic 129	com/amap/api/mapcore/util/ii:a	(Lcom/amap/api/mapcore/util/hs;)V
    //   196: aload_3
    //   197: astore_1
    //   198: goto +33 -> 231
    //   201: goto +30 -> 231
    //   204: aload_1
    //   205: ifnull +13 -> 218
    //   208: aload_1
    //   209: invokevirtual 50	com/amap/api/mapcore/util/hs:close	()V
    //   212: return
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   218: return
    //   219: astore_0
    //   220: goto +55 -> 275
    //   223: astore_2
    //   224: aload_1
    //   225: astore_0
    //   226: aload_2
    //   227: astore_1
    //   228: goto +28 -> 256
    //   231: aload_1
    //   232: ifnull +42 -> 274
    //   235: aload_1
    //   236: invokevirtual 50	com/amap/api/mapcore/util/hs:close	()V
    //   239: return
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   245: return
    //   246: astore_0
    //   247: aload_2
    //   248: astore_1
    //   249: goto +26 -> 275
    //   252: astore_1
    //   253: aload 4
    //   255: astore_0
    //   256: aload_0
    //   257: astore_2
    //   258: aload_1
    //   259: ldc -122
    //   261: ldc -120
    //   263: invokestatic 24	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_0
    //   267: ifnull +7 -> 274
    //   270: aload_0
    //   271: invokevirtual 50	com/amap/api/mapcore/util/hs:close	()V
    //   274: return
    //   275: aload_1
    //   276: ifnull +15 -> 291
    //   279: aload_1
    //   280: invokevirtual 50	com/amap/api/mapcore/util/hs:close	()V
    //   283: goto +8 -> 291
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   291: aload_0
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramih	ih
    //   9	240	1	localObject1	Object
    //   252	28	1	localThrowable1	Throwable
    //   286	2	1	localThrowable2	Throwable
    //   12	172	2	localObject2	Object
    //   223	25	2	localThrowable3	Throwable
    //   257	1	2	localih	ih
    //   7	190	3	localObject3	Object
    //   4	250	4	arrayOfByte	byte[]
    //   1	137	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   208	212	213	java/lang/Throwable
    //   58	74	219	finally
    //   79	85	219	finally
    //   88	155	219	finally
    //   160	170	219	finally
    //   170	187	219	finally
    //   192	196	219	finally
    //   58	74	223	java/lang/Throwable
    //   79	85	223	java/lang/Throwable
    //   88	155	223	java/lang/Throwable
    //   160	170	223	java/lang/Throwable
    //   170	187	223	java/lang/Throwable
    //   192	196	223	java/lang/Throwable
    //   235	239	240	java/lang/Throwable
    //   270	274	240	java/lang/Throwable
    //   13	23	246	finally
    //   26	34	246	finally
    //   37	58	246	finally
    //   258	266	246	finally
    //   13	23	252	java/lang/Throwable
    //   26	34	252	java/lang/Throwable
    //   37	58	252	java/lang/Throwable
    //   279	283	286	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte, ih paramih)
    throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: getfield 70	com/amap/api/mapcore/util/ih:a	Ljava/lang/String;
    //   6: aload_0
    //   7: invokestatic 156	com/amap/api/mapcore/util/ii:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: new 67	java/io/File
    //   17: dup
    //   18: aload_2
    //   19: getfield 70	com/amap/api/mapcore/util/ih:a	Ljava/lang/String;
    //   22: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 159	java/io/File:exists	()Z
    //   32: ifne +9 -> 41
    //   35: aload 4
    //   37: invokevirtual 162	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: aload 4
    //   43: iconst_1
    //   44: iconst_1
    //   45: aload_2
    //   46: getfield 78	com/amap/api/mapcore/util/ih:b	J
    //   49: aload_2
    //   50: getfield 166	com/amap/api/mapcore/util/ih:d	I
    //   53: i2l
    //   54: lmul
    //   55: invokestatic 81	com/amap/api/mapcore/util/hs:a	(Ljava/io/File;IIJ)Lcom/amap/api/mapcore/util/hs;
    //   58: astore 4
    //   60: aload 4
    //   62: aload_2
    //   63: getfield 166	com/amap/api/mapcore/util/ih:d	I
    //   66: invokevirtual 167	com/amap/api/mapcore/util/hs:a	(I)V
    //   69: aload_2
    //   70: getfield 171	com/amap/api/mapcore/util/ih:e	Lcom/amap/api/mapcore/util/ga;
    //   73: aload_1
    //   74: invokevirtual 176	com/amap/api/mapcore/util/ga:b	([B)[B
    //   77: astore_1
    //   78: aload 4
    //   80: aload_0
    //   81: invokevirtual 179	com/amap/api/mapcore/util/hs:b	(Ljava/lang/String;)Lcom/amap/api/mapcore/util/hs$a;
    //   84: astore_0
    //   85: aload_0
    //   86: iconst_0
    //   87: invokevirtual 184	com/amap/api/mapcore/util/hs$a:a	(I)Ljava/io/OutputStream;
    //   90: astore_2
    //   91: aload_2
    //   92: aload_1
    //   93: invokevirtual 189	java/io/OutputStream:write	([B)V
    //   96: aload_0
    //   97: invokevirtual 191	com/amap/api/mapcore/util/hs$a:a	()V
    //   100: aload 4
    //   102: invokevirtual 193	com/amap/api/mapcore/util/hs:e	()V
    //   105: aload_2
    //   106: ifnull +15 -> 121
    //   109: aload_2
    //   110: invokevirtual 194	java/io/OutputStream:close	()V
    //   113: goto +8 -> 121
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   121: aload 4
    //   123: ifnull +14 -> 137
    //   126: aload 4
    //   128: invokevirtual 50	com/amap/api/mapcore/util/hs:close	()V
    //   131: return
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   137: return
    //   138: astore_0
    //   139: aload 4
    //   141: astore_1
    //   142: goto +17 -> 159
    //   145: astore_0
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: astore_1
    //   151: goto +8 -> 159
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +15 -> 175
    //   163: aload_2
    //   164: invokevirtual 194	java/io/OutputStream:close	()V
    //   167: goto +8 -> 175
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   175: aload_1
    //   176: ifnull +15 -> 191
    //   179: aload_1
    //   180: invokevirtual 50	com/amap/api/mapcore/util/hs:close	()V
    //   183: goto +8 -> 191
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   191: aload_0
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramString	String
    //   0	193	1	paramArrayOfByte	byte[]
    //   0	193	2	paramih	ih
    //   1	157	3	localObject1	Object
    //   25	124	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   109	113	116	java/lang/Throwable
    //   126	131	132	java/lang/Throwable
    //   91	105	138	finally
    //   60	91	145	finally
    //   2	13	154	finally
    //   14	41	154	finally
    //   41	60	154	finally
    //   163	167	170	java/lang/Throwable
    //   179	183	186	java/lang/Throwable
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
      gk.c(paramString1, "leg", "fet");
    }
    return false;
  }
  
  private static byte[] a(hs paramhs, ih paramih, List<String> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramhs.c();
        if ((localObject != null) && (((File)localObject).exists()))
        {
          localObject = ((File)localObject).list();
          int k = localObject.length;
          i = 0;
          int j = 0;
          if (i < k)
          {
            String str = localObject[i];
            if (!str.contains(".0")) {
              break label148;
            }
            str = str.split("\\.")[0];
            byte[] arrayOfByte = ip.a(paramhs, str, false);
            j += arrayOfByte.length;
            paramList.add(str);
            if (j <= paramih.f.b())
            {
              paramih.g.b(arrayOfByte);
              break label148;
            }
          }
          paramhs = paramih.g.a();
          return paramhs;
        }
      }
      catch (Throwable paramhs)
      {
        gk.c(paramhs, "leg", "gCo");
      }
      return new byte[0];
      label148:
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */