package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class fn
{
  public static String a()
  {
    String str2;
    try
    {
      str2 = String.valueOf(System.currentTimeMillis());
      String str1 = "1";
      try
      {
        if (!fk.a()) {
          str1 = "0";
        }
        int i = str2.length();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2.substring(0, i - 2));
        localStringBuilder.append(str1);
        localStringBuilder.append(str2.substring(i - 1));
        str1 = localStringBuilder.toString();
        return str1;
      }
      catch (Throwable localThrowable1) {}
      gg.a(localThrowable2, "CI", "TS");
    }
    catch (Throwable localThrowable2)
    {
      str2 = null;
    }
    return str2;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      a locala = new a(null);
      locala.d = fk.c(paramContext);
      locala.i = fk.d(paramContext);
      paramContext = a(paramContext, locala);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      gg.a(paramContext, "CI", "IX");
    }
    return null;
  }
  
  private static String a(Context paramContext, a parama)
  {
    return fq.b(b(paramContext, parama));
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = fk.e(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString1.substring(0, paramString1.length() - 3));
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      paramContext = fs.b(localStringBuilder.toString());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      gg.a(paramContext, "CI", "Sco");
    }
    return null;
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = a(paramContext, b(paramContext, false, paramBoolean));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      gg.a(paramContext, "CI", "gCXi");
    }
    return null;
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      byte b;
      if (paramString.getBytes().length > 255) {
        b = -1;
      } else {
        b = (byte)paramString.getBytes().length;
      }
      fw.a(paramByteArrayOutputStream, b, fw.a(paramString));
      return;
    }
    fw.a(paramByteArrayOutputStream, (byte)0, new byte[0]);
  }
  
  private static byte[] a(Context paramContext, ByteArrayOutputStream paramByteArrayOutputStream)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    return b(paramContext, fw.b(paramByteArrayOutputStream.toByteArray()));
  }
  
  public static byte[] a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      paramContext = b(paramContext, b(paramContext, paramBoolean1, paramBoolean2));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      gg.a(paramContext, "CI", "gz");
    }
    return null;
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte)
    throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
  {
    return fq.a(paramArrayOfByte);
  }
  
  private static a b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala = new a(null);
    locala.a = fp.w(paramContext);
    locala.b = fp.n(paramContext);
    Object localObject2 = fp.i(paramContext);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    locala.c = ((String)localObject1);
    locala.d = fk.c(paramContext);
    locala.e = Build.MODEL;
    locala.f = Build.MANUFACTURER;
    locala.g = Build.DEVICE;
    locala.h = fk.b(paramContext);
    locala.i = fk.d(paramContext);
    locala.j = String.valueOf(Build.VERSION.SDK_INT);
    locala.k = fp.y(paramContext);
    locala.l = fp.v(paramContext);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(fp.s(paramContext));
    ((StringBuilder)localObject1).append("");
    locala.m = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(fp.r(paramContext));
    ((StringBuilder)localObject1).append("");
    locala.n = ((StringBuilder)localObject1).toString();
    locala.o = fp.A(paramContext);
    locala.p = fp.q(paramContext);
    if (paramBoolean1) {
      locala.q = "";
    } else {
      locala.q = fp.m(paramContext);
    }
    if (paramBoolean1) {
      locala.r = "";
    } else {
      locala.r = fp.l(paramContext);
    }
    if (paramBoolean1)
    {
      locala.s = "";
      locala.t = "";
    }
    else
    {
      localObject1 = fp.o(paramContext);
      locala.s = localObject1[0];
      locala.t = localObject1[1];
    }
    locala.w = fp.a();
    localObject1 = fp.b(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      locala.x = ((String)localObject1);
    } else {
      locala.x = "";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("aid=");
    ((StringBuilder)localObject1).append(fp.k(paramContext));
    locala.y = ((StringBuilder)localObject1).toString();
    if (((paramBoolean2) && (ge.e)) || (ge.f))
    {
      localObject1 = fp.h(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(locala.y);
        ((StringBuilder)localObject2).append("|oaid=");
        ((StringBuilder)localObject2).append((String)localObject1);
        locala.y = ((StringBuilder)localObject2).toString();
      }
    }
    localObject1 = fp.a(paramContext, ",", true);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(locala.y);
      ((StringBuilder)localObject2).append("|multiImeis=");
      ((StringBuilder)localObject2).append((String)localObject1);
      locala.y = ((StringBuilder)localObject2).toString();
    }
    localObject1 = fp.x(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(locala.y);
      ((StringBuilder)localObject2).append("|meid=");
      ((StringBuilder)localObject2).append((String)localObject1);
      locala.y = ((StringBuilder)localObject2).toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(locala.y);
    ((StringBuilder)localObject1).append("|serial=");
    ((StringBuilder)localObject1).append(fp.j(paramContext));
    locala.y = ((StringBuilder)localObject1).toString();
    localObject1 = fp.a(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(locala.y);
      ((StringBuilder)localObject2).append("|adiuExtras=");
      ((StringBuilder)localObject2).append((String)localObject1);
      locala.y = ((StringBuilder)localObject2).toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(locala.y);
    ((StringBuilder)localObject1).append("|storage=");
    ((StringBuilder)localObject1).append(fp.c());
    ((StringBuilder)localObject1).append("|ram=");
    ((StringBuilder)localObject1).append(fp.z(paramContext));
    ((StringBuilder)localObject1).append("|arch=");
    ((StringBuilder)localObject1).append(fp.d());
    locala.y = ((StringBuilder)localObject1).toString();
    return locala;
  }
  
  public static String b(Context paramContext)
  {
    return a(paramContext, false);
  }
  
  /* Error */
  private static byte[] b(Context paramContext, a parama)
  {
    // Byte code:
    //   0: new 154	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 342	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: aload_1
    //   12: getfield 178	com/amap/api/mapcore/util/fn$a:a	Ljava/lang/String;
    //   15: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   18: aload_3
    //   19: astore_2
    //   20: aload_3
    //   21: aload_1
    //   22: getfield 183	com/amap/api/mapcore/util/fn$a:b	Ljava/lang/String;
    //   25: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: aload_1
    //   32: getfield 189	com/amap/api/mapcore/util/fn$a:c	Ljava/lang/String;
    //   35: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: aload_1
    //   42: getfield 78	com/amap/api/mapcore/util/fn$a:d	Ljava/lang/String;
    //   45: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: aload_1
    //   52: getfield 196	com/amap/api/mapcore/util/fn$a:e	Ljava/lang/String;
    //   55: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   58: aload_3
    //   59: astore_2
    //   60: aload_3
    //   61: aload_1
    //   62: getfield 202	com/amap/api/mapcore/util/fn$a:f	Ljava/lang/String;
    //   65: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: aload_1
    //   72: getfield 208	com/amap/api/mapcore/util/fn$a:g	Ljava/lang/String;
    //   75: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: aload_1
    //   82: getfield 213	com/amap/api/mapcore/util/fn$a:h	Ljava/lang/String;
    //   85: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   88: aload_3
    //   89: astore_2
    //   90: aload_3
    //   91: aload_1
    //   92: getfield 83	com/amap/api/mapcore/util/fn$a:i	Ljava/lang/String;
    //   95: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   98: aload_3
    //   99: astore_2
    //   100: aload_3
    //   101: aload_1
    //   102: getfield 224	com/amap/api/mapcore/util/fn$a:j	Ljava/lang/String;
    //   105: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   108: aload_3
    //   109: astore_2
    //   110: aload_3
    //   111: aload_1
    //   112: getfield 230	com/amap/api/mapcore/util/fn$a:k	Ljava/lang/String;
    //   115: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: aload_1
    //   122: getfield 236	com/amap/api/mapcore/util/fn$a:l	Ljava/lang/String;
    //   125: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   128: aload_3
    //   129: astore_2
    //   130: aload_3
    //   131: aload_1
    //   132: getfield 246	com/amap/api/mapcore/util/fn$a:m	Ljava/lang/String;
    //   135: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   138: aload_3
    //   139: astore_2
    //   140: aload_3
    //   141: aload_1
    //   142: getfield 251	com/amap/api/mapcore/util/fn$a:n	Ljava/lang/String;
    //   145: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   148: aload_3
    //   149: astore_2
    //   150: aload_3
    //   151: aload_1
    //   152: getfield 257	com/amap/api/mapcore/util/fn$a:o	Ljava/lang/String;
    //   155: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   158: aload_3
    //   159: astore_2
    //   160: aload_3
    //   161: aload_1
    //   162: getfield 263	com/amap/api/mapcore/util/fn$a:p	Ljava/lang/String;
    //   165: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   168: aload_3
    //   169: astore_2
    //   170: aload_3
    //   171: aload_1
    //   172: getfield 265	com/amap/api/mapcore/util/fn$a:q	Ljava/lang/String;
    //   175: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   178: aload_3
    //   179: astore_2
    //   180: aload_3
    //   181: aload_1
    //   182: getfield 269	com/amap/api/mapcore/util/fn$a:r	Ljava/lang/String;
    //   185: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   188: aload_3
    //   189: astore_2
    //   190: aload_3
    //   191: aload_1
    //   192: getfield 273	com/amap/api/mapcore/util/fn$a:s	Ljava/lang/String;
    //   195: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   198: aload_3
    //   199: astore_2
    //   200: aload_3
    //   201: aload_1
    //   202: getfield 276	com/amap/api/mapcore/util/fn$a:t	Ljava/lang/String;
    //   205: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   208: aload_3
    //   209: astore_2
    //   210: aload_3
    //   211: aload_1
    //   212: getfield 347	com/amap/api/mapcore/util/fn$a:u	Ljava/lang/String;
    //   215: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   218: aload_3
    //   219: astore_2
    //   220: aload_3
    //   221: aload_1
    //   222: getfield 349	com/amap/api/mapcore/util/fn$a:v	Ljava/lang/String;
    //   225: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   228: aload_3
    //   229: astore_2
    //   230: aload_3
    //   231: aload_1
    //   232: getfield 283	com/amap/api/mapcore/util/fn$a:w	Ljava/lang/String;
    //   235: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   238: aload_3
    //   239: astore_2
    //   240: aload_3
    //   241: aload_1
    //   242: getfield 287	com/amap/api/mapcore/util/fn$a:x	Ljava/lang/String;
    //   245: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   248: aload_3
    //   249: astore_2
    //   250: aload_3
    //   251: aload_1
    //   252: getfield 293	com/amap/api/mapcore/util/fn$a:y	Ljava/lang/String;
    //   255: invokestatic 344	com/amap/api/mapcore/util/fn:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   258: aload_3
    //   259: astore_2
    //   260: aload_0
    //   261: aload_3
    //   262: invokestatic 351	com/amap/api/mapcore/util/fn:a	(Landroid/content/Context;Ljava/io/ByteArrayOutputStream;)[B
    //   265: astore_0
    //   266: aload_3
    //   267: invokevirtual 354	java/io/ByteArrayOutputStream:close	()V
    //   270: aload_0
    //   271: areturn
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 357	java/lang/Throwable:printStackTrace	()V
    //   277: aload_0
    //   278: areturn
    //   279: astore_1
    //   280: aload_3
    //   281: astore_0
    //   282: goto +12 -> 294
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_2
    //   288: goto +35 -> 323
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_0
    //   294: aload_0
    //   295: astore_2
    //   296: aload_1
    //   297: ldc 59
    //   299: ldc_w 359
    //   302: invokestatic 66	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_0
    //   306: ifnull +14 -> 320
    //   309: aload_0
    //   310: invokevirtual 354	java/io/ByteArrayOutputStream:close	()V
    //   313: aconst_null
    //   314: areturn
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 357	java/lang/Throwable:printStackTrace	()V
    //   320: aconst_null
    //   321: areturn
    //   322: astore_0
    //   323: aload_2
    //   324: ifnull +15 -> 339
    //   327: aload_2
    //   328: invokevirtual 354	java/io/ByteArrayOutputStream:close	()V
    //   331: goto +8 -> 339
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 357	java/lang/Throwable:printStackTrace	()V
    //   339: aload_0
    //   340: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramContext	Context
    //   0	341	1	parama	a
    //   9	319	2	localObject	Object
    //   7	274	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   266	270	272	java/lang/Throwable
    //   10	18	279	java/lang/Throwable
    //   20	28	279	java/lang/Throwable
    //   30	38	279	java/lang/Throwable
    //   40	48	279	java/lang/Throwable
    //   50	58	279	java/lang/Throwable
    //   60	68	279	java/lang/Throwable
    //   70	78	279	java/lang/Throwable
    //   80	88	279	java/lang/Throwable
    //   90	98	279	java/lang/Throwable
    //   100	108	279	java/lang/Throwable
    //   110	118	279	java/lang/Throwable
    //   120	128	279	java/lang/Throwable
    //   130	138	279	java/lang/Throwable
    //   140	148	279	java/lang/Throwable
    //   150	158	279	java/lang/Throwable
    //   160	168	279	java/lang/Throwable
    //   170	178	279	java/lang/Throwable
    //   180	188	279	java/lang/Throwable
    //   190	198	279	java/lang/Throwable
    //   200	208	279	java/lang/Throwable
    //   210	218	279	java/lang/Throwable
    //   220	228	279	java/lang/Throwable
    //   230	238	279	java/lang/Throwable
    //   240	248	279	java/lang/Throwable
    //   250	258	279	java/lang/Throwable
    //   260	266	279	java/lang/Throwable
    //   0	8	285	finally
    //   0	8	291	java/lang/Throwable
    //   309	313	315	java/lang/Throwable
    //   10	18	322	finally
    //   20	28	322	finally
    //   30	38	322	finally
    //   40	48	322	finally
    //   50	58	322	finally
    //   60	68	322	finally
    //   70	78	322	finally
    //   80	88	322	finally
    //   90	98	322	finally
    //   100	108	322	finally
    //   110	118	322	finally
    //   120	128	322	finally
    //   130	138	322	finally
    //   140	148	322	finally
    //   150	158	322	finally
    //   160	168	322	finally
    //   170	178	322	finally
    //   180	188	322	finally
    //   190	198	322	finally
    //   200	208	322	finally
    //   210	218	322	finally
    //   220	228	322	finally
    //   230	238	322	finally
    //   240	248	322	finally
    //   250	258	322	finally
    //   260	266	322	finally
    //   296	305	322	finally
    //   327	331	334	java/lang/Throwable
  }
  
  public static byte[] b(Context paramContext, byte[] paramArrayOfByte)
    throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
  {
    paramContext = fw.d();
    if (paramArrayOfByte.length > 117)
    {
      byte[] arrayOfByte = new byte[117];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 117);
      paramContext = fq.a(arrayOfByte, paramContext);
      arrayOfByte = new byte[paramArrayOfByte.length + 128 - 117];
      System.arraycopy(paramContext, 0, arrayOfByte, 0, 128);
      System.arraycopy(paramArrayOfByte, 117, arrayOfByte, 128, paramArrayOfByte.length - 117);
      return arrayOfByte;
    }
    return fq.a(paramArrayOfByte, paramContext);
  }
  
  private static class a
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;
    String v;
    String w;
    String x;
    String y;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */