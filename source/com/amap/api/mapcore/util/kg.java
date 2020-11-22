package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.Certificate;

public final class kg
{
  private static PublicKey a;
  
  /* Error */
  private static PublicKey a()
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   5: astore_2
    //   6: new 22	java/io/ByteArrayInputStream
    //   9: dup
    //   10: ldc 24
    //   12: invokestatic 30	com/amap/api/mapcore/util/fq:b	(Ljava/lang/String;)[B
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
    //   34: invokestatic 46	com/amap/api/mapcore/util/kg:a	(Ljava/io/Closeable;)V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 49	java/lang/Throwable:printStackTrace	()V
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
    //   62: ldc 51
    //   64: ldc 53
    //   66: invokestatic 58	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_1
    //   70: invokestatic 46	com/amap/api/mapcore/util/kg:a	(Ljava/io/Closeable;)V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 49	java/lang/Throwable:printStackTrace	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_2
    //   83: aload_0
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: invokestatic 46	com/amap/api/mapcore/util/kg:a	(Ljava/io/Closeable;)V
    //   91: goto +8 -> 99
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 49	java/lang/Throwable:printStackTrace	()V
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
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
    return;
  }
  
  /* Error */
  private static void a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 72	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: sipush 8192
    //   14: newarray <illegal type>
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 78	java/io/InputStream:read	([B)I
    //   22: istore_2
    //   23: iload_2
    //   24: ifgt -7 -> 17
    //   27: aload_0
    //   28: invokestatic 46	com/amap/api/mapcore/util/kg:a	(Ljava/io/Closeable;)V
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: astore_3
    //   35: aload_1
    //   36: astore_0
    //   37: goto +30 -> 67
    //   40: astore_1
    //   41: goto +11 -> 52
    //   44: astore_0
    //   45: goto +22 -> 67
    //   48: astore_1
    //   49: aload 4
    //   51: astore_0
    //   52: aload_0
    //   53: astore_3
    //   54: aload_1
    //   55: ldc 80
    //   57: ldc 82
    //   59: invokestatic 58	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: invokestatic 46	com/amap/api/mapcore/util/kg:a	(Ljava/io/Closeable;)V
    //   66: return
    //   67: aload_3
    //   68: invokestatic 46	com/amap/api/mapcore/util/kg:a	(Ljava/io/Closeable;)V
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramJarFile	java.util.jar.JarFile
    //   0	73	1	paramJarEntry	java.util.jar.JarEntry
    //   22	2	2	i	int
    //   4	64	3	localJarFile	java.util.jar.JarFile
    //   1	49	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	17	32	finally
    //   17	23	32	finally
    //   11	17	40	java/lang/Throwable
    //   17	23	40	java/lang/Throwable
    //   5	11	44	finally
    //   54	62	44	finally
    //   5	11	48	java/lang/Throwable
  }
  
  /* Error */
  private static boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: getstatic 86	com/amap/api/mapcore/util/kg:a	Ljava/security/PublicKey;
    //   10: ifnonnull +11 -> 21
    //   13: aload_3
    //   14: astore_2
    //   15: invokestatic 88	com/amap/api/mapcore/util/kg:a	()Ljava/security/PublicKey;
    //   18: putstatic 86	com/amap/api/mapcore/util/kg:a	Ljava/security/PublicKey;
    //   21: aload_3
    //   22: astore_2
    //   23: new 68	java/util/jar/JarFile
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 91	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 95	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +9 -> 47
    //   41: aload_0
    //   42: invokevirtual 96	java/util/jar/JarFile:close	()V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_2
    //   48: invokeinterface 102 1 0
    //   53: ifeq +67 -> 120
    //   56: aload_2
    //   57: invokeinterface 106 1 0
    //   62: checkcast 108	java/util/jar/JarEntry
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 112	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   70: ifnull -23 -> 47
    //   73: aload_3
    //   74: invokevirtual 112	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   77: ldc 114
    //   79: invokevirtual 120	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   82: ifeq -35 -> 47
    //   85: aload_0
    //   86: aload_3
    //   87: invokestatic 122	com/amap/api/mapcore/util/kg:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)V
    //   90: aload_3
    //   91: invokevirtual 126	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   94: astore_3
    //   95: aload_3
    //   96: ifnonnull +9 -> 105
    //   99: aload_0
    //   100: invokevirtual 96	java/util/jar/JarFile:close	()V
    //   103: iconst_0
    //   104: ireturn
    //   105: aload_3
    //   106: invokestatic 129	com/amap/api/mapcore/util/kg:a	([Ljava/security/cert/Certificate;)Z
    //   109: istore_1
    //   110: iload_1
    //   111: ifne -64 -> 47
    //   114: aload_0
    //   115: invokevirtual 96	java/util/jar/JarFile:close	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload_0
    //   121: invokevirtual 96	java/util/jar/JarFile:close	()V
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_2
    //   127: goto +39 -> 166
    //   130: astore_3
    //   131: goto +15 -> 146
    //   134: astore_3
    //   135: aload_2
    //   136: astore_0
    //   137: aload_3
    //   138: astore_2
    //   139: goto +27 -> 166
    //   142: astore_3
    //   143: aload 4
    //   145: astore_0
    //   146: aload_0
    //   147: astore_2
    //   148: aload_3
    //   149: ldc 80
    //   151: ldc -125
    //   153: invokestatic 58	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 96	java/util/jar/JarFile:close	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 96	java/util/jar/JarFile:close	()V
    //   174: aload_2
    //   175: athrow
    //   176: astore_0
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_0
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_0
    //   186: goto -62 -> 124
    //   189: astore_0
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: goto -19 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramFile	File
    //   109	2	1	bool	boolean
    //   6	51	2	localObject1	Object
    //   126	10	2	localObject2	Object
    //   138	37	2	localObject3	Object
    //   4	102	3	localObject4	Object
    //   130	1	3	localThrowable1	Throwable
    //   134	4	3	localObject5	Object
    //   142	7	3	localThrowable2	Throwable
    //   1	143	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   32	37	126	finally
    //   47	95	126	finally
    //   105	110	126	finally
    //   32	37	130	java/lang/Throwable
    //   47	95	130	java/lang/Throwable
    //   105	110	130	java/lang/Throwable
    //   7	13	134	finally
    //   15	21	134	finally
    //   23	32	134	finally
    //   148	156	134	finally
    //   7	13	142	java/lang/Throwable
    //   15	21	142	java/lang/Throwable
    //   23	32	142	java/lang/Throwable
    //   41	45	176	java/lang/Throwable
    //   99	103	179	java/lang/Throwable
    //   114	118	182	java/lang/Throwable
    //   120	124	185	java/lang/Throwable
    //   160	164	189	java/lang/Throwable
    //   170	174	192	java/lang/Throwable
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = a(new File(paramString));
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private static boolean a(Certificate[] paramArrayOfCertificate)
  {
    try
    {
      if (paramArrayOfCertificate.length > 0)
      {
        int i = paramArrayOfCertificate.length - 1;
        if (i >= 0)
        {
          paramArrayOfCertificate[i].verify(a);
          return true;
        }
      }
    }
    catch (Throwable paramArrayOfCertificate)
    {
      gg.a(paramArrayOfCertificate, "DyLoader", "check");
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */