package com.amap.api.mapcore.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class fs
{
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 18	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 26	java/io/File:isFile	()Z
    //   24: ifeq +95 -> 119
    //   27: aload_0
    //   28: invokevirtual 29	java/io/File:exists	()Z
    //   31: ifne +5 -> 36
    //   34: aconst_null
    //   35: areturn
    //   36: sipush 2048
    //   39: newarray <illegal type>
    //   41: astore 4
    //   43: ldc 31
    //   45: invokestatic 37	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   48: astore 5
    //   50: new 39	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore_2
    //   59: aload_2
    //   60: astore_0
    //   61: aload_2
    //   62: aload 4
    //   64: invokevirtual 46	java/io/FileInputStream:read	([B)I
    //   67: istore_1
    //   68: iload_1
    //   69: iconst_m1
    //   70: if_icmpeq +17 -> 87
    //   73: aload_2
    //   74: astore_0
    //   75: aload 5
    //   77: aload 4
    //   79: iconst_0
    //   80: iload_1
    //   81: invokevirtual 50	java/security/MessageDigest:update	([BII)V
    //   84: goto -25 -> 59
    //   87: aload_2
    //   88: astore_0
    //   89: aload 5
    //   91: invokevirtual 54	java/security/MessageDigest:digest	()[B
    //   94: invokestatic 60	com/amap/api/mapcore/util/fw:e	([B)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_2
    //   99: invokevirtual 64	java/io/FileInputStream:close	()V
    //   102: aload_3
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: ldc 31
    //   108: ldc 66
    //   110: invokestatic 71	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_3
    //   114: areturn
    //   115: astore_3
    //   116: goto +14 -> 130
    //   119: aconst_null
    //   120: areturn
    //   121: astore_0
    //   122: aload_3
    //   123: astore_2
    //   124: goto +42 -> 166
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: astore_0
    //   132: aload_3
    //   133: ldc 31
    //   135: ldc 66
    //   137: invokestatic 71	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_2
    //   141: ifnull +18 -> 159
    //   144: aload_2
    //   145: invokevirtual 64	java/io/FileInputStream:close	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: aload_0
    //   152: ldc 31
    //   154: ldc 66
    //   156: invokestatic 71	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   159: aconst_null
    //   160: areturn
    //   161: astore_3
    //   162: aload_0
    //   163: astore_2
    //   164: aload_3
    //   165: astore_0
    //   166: aload_2
    //   167: ifnull +19 -> 186
    //   170: aload_2
    //   171: invokevirtual 64	java/io/FileInputStream:close	()V
    //   174: goto +12 -> 186
    //   177: astore_2
    //   178: aload_2
    //   179: ldc 31
    //   181: ldc 66
    //   183: invokestatic 71	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramString	String
    //   67	14	1	i	int
    //   58	113	2	localObject1	Object
    //   177	2	2	localIOException	java.io.IOException
    //   1	113	3	str	String
    //   115	8	3	localThrowable1	Throwable
    //   127	6	3	localThrowable2	Throwable
    //   161	4	3	localObject2	Object
    //   41	37	4	arrayOfByte	byte[]
    //   48	42	5	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   98	102	104	java/io/IOException
    //   61	68	115	java/lang/Throwable
    //   75	84	115	java/lang/Throwable
    //   89	98	115	java/lang/Throwable
    //   2	9	121	finally
    //   11	34	121	finally
    //   36	59	121	finally
    //   2	9	127	java/lang/Throwable
    //   11	34	127	java/lang/Throwable
    //   36	59	127	java/lang/Throwable
    //   144	148	150	java/io/IOException
    //   61	68	161	finally
    //   75	84	161	finally
    //   89	98	161	finally
    //   132	140	161	finally
    //   170	174	177	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return fw.e(b(paramArrayOfByte));
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString.update(paramArrayOfByte);
      paramArrayOfByte = paramString.digest();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      gg.a(paramArrayOfByte, "MD5", "gmb");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return fw.e(d(paramString));
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, "MD5");
  }
  
  public static String c(String paramString)
  {
    return fw.f(e(paramString));
  }
  
  public static byte[] d(String paramString)
  {
    try
    {
      paramString = f(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      gg.a(paramString, "MD5", "gmb");
    }
    return new byte[0];
  }
  
  private static byte[] e(String paramString)
  {
    try
    {
      paramString = f(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return new byte[0];
  }
  
  private static byte[] f(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    if (paramString == null) {
      return null;
    }
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.update(fw.a(paramString));
    return localMessageDigest.digest();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */