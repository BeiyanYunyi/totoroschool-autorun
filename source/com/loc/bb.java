package com.loc;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class bb
{
  /* Error */
  static java.security.PublicKey a()
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   5: astore_2
    //   6: new 22	java/io/ByteArrayInputStream
    //   9: dup
    //   10: ldc 24
    //   12: invokestatic 30	com/loc/q:b	(Ljava/lang/String;)[B
    //   15: invokespecial 34	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 38	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   26: checkcast 40	java/security/cert/X509Certificate
    //   29: invokevirtual 43	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 46	com/loc/bb:a	(Ljava/io/Closeable;)V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
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
    //   62: ldc 52
    //   64: ldc 54
    //   66: invokestatic 59	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_1
    //   70: invokestatic 46	com/loc/bb:a	(Ljava/io/Closeable;)V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_2
    //   83: aload_0
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: invokestatic 46	com/loc/bb:a	(Ljava/io/Closeable;)V
    //   91: goto +8 -> 99
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
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
  
  static void a(List<ay> paramList)
  {
    int j;
    for (int i = 0; i < paramList.size() - 1; i = j)
    {
      j = i + 1;
      int k = j;
      while (k < paramList.size())
      {
        ay localay1 = (ay)paramList.get(i);
        ay localay2 = (ay)paramList.get(k);
        String str = localay1.e();
        if (b(localay2.e(), str) > 0)
        {
          paramList.set(i, localay2);
          paramList.set(k, localay1);
        }
        k += 1;
      }
    }
  }
  
  private static boolean a(Context paramContext, final an paraman, final ay paramay, au paramau, final v paramv)
  {
    String str1 = paramau.c;
    String str2 = paramau.d;
    final String str3 = paramau.e;
    if ("errorstatus".equals(paramay.f())) {}
    try
    {
      if (!new File(av.b(paramContext, paramv.a(), paramv.b())).exists())
      {
        if (TextUtils.isEmpty(av.a(paramContext, paraman, paramv))) {
          return true;
        }
        ba.b().a().submit(new Runnable()
        {
          public final void run()
          {
            try
            {
              av.a(this.a, paramv);
              return;
            }
            catch (Throwable localThrowable) {}
          }
        });
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      try
      {
        ba.b().a().submit(new Runnable()
        {
          public final void run()
          {
            try
            {
              av.a(this.a, paraman, paramv, paramay, str3);
              av.a(this.a, paramv);
              return;
            }
            catch (Throwable localThrowable)
            {
              ag.a(localThrowable, "dDownLoad", "processDownloadedFile()");
            }
          }
        });
        return true;
      }
      catch (Throwable paramContext) {}
      paramContext = paramContext;
      return true;
    }
    paramay = av.a(paramContext, paramau.b);
    if (!new File(paramay).exists()) {
      return false;
    }
    if (paraman.a(ay.a(av.a(paramContext, str1, str2), str1, str2, str3), ay.class, false).size() > 0) {
      return true;
    }
    av.a(paramContext, str1, paramv.b());
    return true;
  }
  
  static boolean a(Context paramContext, au paramau, v paramv)
  {
    an localan = new an(paramContext, ax.b());
    if (a(localan, paramau)) {
      return true;
    }
    ay localay = av.a.a(localan, paramau.b);
    if (localay != null) {
      return a(paramContext, localan, localay, paramau, paramv);
    }
    return false;
  }
  
  static boolean a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      int i;
      if (p.s(paramContext) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      return i != 0;
    }
    return true;
  }
  
  private static boolean a(an paraman, au paramau)
  {
    try
    {
      paraman = av.a.a(paraman, paramau.c, "used");
      if ((paraman != null) && (paraman.size() > 0))
      {
        int i = b(((ay)paraman.get(0)).e(), paramau.e);
        if (i > 0) {
          return true;
        }
      }
    }
    catch (Throwable paraman)
    {
      ag.a(paraman, "dDownLoad", "isUsed");
    }
    return false;
  }
  
  static boolean a(an paraman, String paramString1, String paramString2, v paramv)
  {
    paraman = av.a.a(paraman, paramString1);
    if (paraman != null)
    {
      if (!paramv.b().equals(paraman.d())) {
        return false;
      }
      if (a(paramString2, paraman.b())) {
        return true;
      }
    }
    return false;
  }
  
  static boolean a(au paramau)
  {
    return (Build.VERSION.SDK_INT >= paramau.g) && (Build.VERSION.SDK_INT <= paramau.f);
  }
  
  static boolean a(v paramv, au paramau)
  {
    if (paramv == null) {
      return false;
    }
    return (paramv.a().equals(paramau.c)) && (paramv.b().equals(paramau.d));
  }
  
  static boolean a(String paramString1, String paramString2)
  {
    paramString1 = s.a(paramString1);
    return (paramString1 != null) && (paramString1.equalsIgnoreCase(paramString2));
  }
  
  private static int b(String paramString1, String paramString2)
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
        ag.a(paramString1, "Utils", "compareVersion");
        return -1;
      }
    } while (i == 0);
    return i;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */