package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class hd
{
  public static int a(String paramString1, String paramString2)
  {
    int i;
    do
    {
      try
      {
        paramString1 = paramString1.split("\\.");
        paramString2 = paramString2.split("\\.");
        int m = Math.min(paramString1.length, paramString2.length);
        int j = 0;
        i = 0;
        while (j < m)
        {
          int k = paramString1[j].length() - paramString2[j].length();
          i = k;
          if (k == 0)
          {
            k = paramString1[j].compareTo(paramString2[j]);
            i = k;
            if (k == 0)
            {
              j += 1;
              i = k;
              continue;
              i = paramString1.length;
              j = paramString2.length;
              return i - j;
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        gg.a(paramString1, "Utils", "compareVersion");
        return -1;
      }
    } while (i == 0);
    return i;
  }
  
  /* Error */
  static java.security.PublicKey a()
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 55	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   5: astore_2
    //   6: new 57	java/io/ByteArrayInputStream
    //   9: dup
    //   10: ldc 59
    //   12: invokestatic 65	com/amap/api/mapcore/util/fq:b	(Ljava/lang/String;)[B
    //   15: invokespecial 69	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 73	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   26: checkcast 75	java/security/cert/X509Certificate
    //   29: invokevirtual 78	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 81	com/amap/api/mapcore/util/hd:a	(Ljava/io/Closeable;)V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 85	java/lang/Throwable:printStackTrace	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: goto +12 -> 59
    //   50: astore_0
    //   51: aconst_null
    //   52: astore_1
    //   53: goto +34 -> 87
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: aload_2
    //   62: ldc 87
    //   64: ldc 89
    //   66: invokestatic 90	com/amap/api/mapcore/util/hd:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_1
    //   70: invokestatic 81	com/amap/api/mapcore/util/hd:a	(Ljava/io/Closeable;)V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 85	java/lang/Throwable:printStackTrace	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_2
    //   83: aload_0
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: invokestatic 81	com/amap/api/mapcore/util/hd:a	(Ljava/io/Closeable;)V
    //   91: goto +8 -> 99
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 85	java/lang/Throwable:printStackTrace	()V
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	1	0	localObject1	Object
    //   39	2	0	localThrowable1	Throwable
    //   50	1	0	localObject2	Object
    //   60	1	0	localObject3	Object
    //   75	9	0	localThrowable2	Throwable
    //   86	14	0	localObject4	Object
    //   18	70	1	localObject5	Object
    //   94	2	1	localThrowable3	Throwable
    //   5	40	2	localObject6	Object
    //   46	1	2	localThrowable4	Throwable
    //   56	6	2	localThrowable5	Throwable
    //   82	4	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   33	37	39	java/lang/Throwable
    //   21	33	46	java/lang/Throwable
    //   0	19	50	finally
    //   0	19	56	java/lang/Throwable
    //   69	73	75	java/lang/Throwable
    //   21	33	82	finally
    //   61	69	82	finally
    //   87	91	94	java/lang/Throwable
  }
  
  private static void a(Context paramContext, go paramgo, final fv paramfv)
  {
    try
    {
      if (!new File(gw.b(paramContext, paramfv.a(), paramfv.b())).exists())
      {
        if (TextUtils.isEmpty(gw.a(paramContext, paramgo, paramfv))) {
          return;
        }
        hb.b().a().submit(new Runnable()
        {
          public void run()
          {
            try
            {
              gw.a(this.a, paramfv);
              return;
            }
            catch (Throwable localThrowable) {}
          }
        });
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (Throwable paramCloseable)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    gg.a(paramThrowable, paramString1, paramString2);
  }
  
  static void a(List<gz> paramList)
  {
    int j;
    for (int i = 0; i < paramList.size() - 1; i = j)
    {
      j = i + 1;
      int k = j;
      while (k < paramList.size())
      {
        gz localgz1 = (gz)paramList.get(i);
        gz localgz2 = (gz)paramList.get(k);
        String str = localgz1.e();
        if (a(localgz2.e(), str) > 0)
        {
          paramList.set(i, localgz2);
          paramList.set(k, localgz1);
        }
        k += 1;
      }
    }
  }
  
  static boolean a(Context paramContext)
  {
    return fp.s(paramContext) == 1;
  }
  
  static boolean a(Context paramContext, fv paramfv, gv paramgv)
  {
    if (paramgv.e()) {
      return true;
    }
    return fw.a(paramContext, paramgv.f()) ^ true;
  }
  
  private static boolean a(Context paramContext, final go paramgo, final gz paramgz, gv paramgv, final fv paramfv)
  {
    String str1 = paramgv.c;
    String str3 = paramgv.d;
    final String str2 = paramgv.e;
    if ("errorstatus".equals(paramgz.f()))
    {
      a(paramContext, paramgo, paramfv);
      return true;
    }
    paramgz = gw.a(paramContext, paramgv.b);
    if (!new File(paramgz).exists()) {
      return false;
    }
    paramgv = paramgo.b(gz.a(gw.a(paramContext, str1, str3), str1, str3, str2), gz.class);
    if ((paramgv != null) && (paramgv.size() > 0)) {
      return true;
    }
    gw.a(paramContext, str1, paramfv.b());
    try
    {
      hb.b().a().submit(new Runnable()
      {
        public void run()
        {
          try
          {
            gw.a(this.a, paramgo, paramfv, paramgz, str2);
            gw.a(this.a, paramfv);
            return;
          }
          catch (Throwable localThrowable)
          {
            hd.a(localThrowable, "dDownLoad", "processDownloadedFile()");
          }
        }
      });
      return true;
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  static boolean a(Context paramContext, go paramgo, String paramString, fv paramfv)
  {
    return a(paramgo, paramString, gw.a(paramContext, paramString), paramfv);
  }
  
  static boolean a(Context paramContext, gv paramgv, fv paramfv)
  {
    go localgo = new go(paramContext, gy.a());
    if (a(localgo, paramgv)) {
      return true;
    }
    gz localgz = gw.a.a(localgo, paramgv.b);
    if (localgz != null) {
      return a(paramContext, localgo, localgz, paramgv, paramfv);
    }
    return false;
  }
  
  static boolean a(Context paramContext, boolean paramBoolean)
  {
    return (paramBoolean) || (a(paramContext));
  }
  
  static boolean a(fv paramfv, gv paramgv)
  {
    boolean bool2 = false;
    if (paramfv == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramfv.a().equals(paramgv.c))
    {
      bool1 = bool2;
      if (paramfv.b().equals(paramgv.d)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(go paramgo, gv paramgv)
  {
    try
    {
      paramgo = gw.a.a(paramgo, paramgv.c, "used");
      if ((paramgo != null) && (paramgo.size() > 0))
      {
        int i = a(((gz)paramgo.get(0)).e(), paramgv.e);
        if (i > 0) {
          return true;
        }
      }
    }
    catch (Throwable paramgo)
    {
      a(paramgo, "dDownLoad", "isUsed");
    }
    return false;
  }
  
  static boolean a(go paramgo, String paramString1, String paramString2, fv paramfv)
  {
    paramgo = gw.a.a(paramgo, paramString1);
    if (paramgo != null)
    {
      if (!paramfv.b().equals(paramgo.d())) {
        return false;
      }
      if (b(paramString2, paramgo.b())) {
        return true;
      }
    }
    return false;
  }
  
  static boolean a(gv paramgv)
  {
    return (Build.VERSION.SDK_INT >= paramgv.h) && (Build.VERSION.SDK_INT <= paramgv.g);
  }
  
  static boolean b(String paramString1, String paramString2)
  {
    paramString1 = fs.a(paramString1);
    return (paramString1 != null) && (paramString1.equalsIgnoreCase(paramString2));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */