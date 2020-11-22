package com.tencent.smtt.utils;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static OutputStream a;
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.close();
        return;
      }
      catch (IOException paramOutputStream)
      {
        Log.e("LOG_FILE", "Couldn't close stream!", paramOutputStream);
      }
    }
  }
  
  public static byte[] createHeaderText(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      paramString2 = String.format("%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String createKey()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  public static byte[] encrypt(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("encrypt exception:");
      paramString2.append(paramString1.getMessage());
      Log.e("LOG_FILE", paramString2.toString());
    }
    return null;
  }
  
  public static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("encrypt exception:");
      paramString2.append(paramString1.getMessage());
      Log.e("LOG_FILE", paramString2.toString());
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: aload_3
    //   5: invokestatic 123	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;Ljava/lang/String;)[B
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +8 -> 18
    //   13: aconst_null
    //   14: astore_3
    //   15: goto +5 -> 20
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: invokevirtual 129	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokevirtual 133	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: aload_0
    //   29: invokevirtual 136	java/io/File:isFile	()Z
    //   32: ifeq +31 -> 63
    //   35: aload_0
    //   36: invokevirtual 139	java/io/File:exists	()Z
    //   39: ifeq +24 -> 63
    //   42: aload_0
    //   43: invokevirtual 142	java/io/File:length	()J
    //   46: ldc2_w 143
    //   49: lcmp
    //   50: ifle +13 -> 63
    //   53: aload_0
    //   54: invokevirtual 147	java/io/File:delete	()Z
    //   57: pop
    //   58: aload_0
    //   59: invokevirtual 150	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   66: ifnonnull +23 -> 89
    //   69: new 154	java/io/BufferedOutputStream
    //   72: dup
    //   73: new 156	java/io/FileOutputStream
    //   76: dup
    //   77: aload_0
    //   78: iload 4
    //   80: invokespecial 159	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   83: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: putstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   89: aload_3
    //   90: ifnull +20 -> 110
    //   93: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   96: astore_0
    //   97: aload_3
    //   98: invokevirtual 164	java/lang/String:getBytes	()[B
    //   101: astore_1
    //   102: aload_0
    //   103: aload_1
    //   104: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   107: goto +40 -> 147
    //   110: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   113: aload_2
    //   114: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   117: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   120: aload_1
    //   121: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   124: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   127: astore_0
    //   128: iconst_2
    //   129: newarray <illegal type>
    //   131: astore_1
    //   132: aload_1
    //   133: dup
    //   134: iconst_0
    //   135: ldc -87
    //   137: bastore
    //   138: dup
    //   139: iconst_1
    //   140: ldc -87
    //   142: bastore
    //   143: pop
    //   144: goto -42 -> 102
    //   147: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   150: astore_0
    //   151: aload_0
    //   152: ifnull +46 -> 198
    //   155: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 172	java/io/OutputStream:flush	()V
    //   163: goto +35 -> 198
    //   166: astore_0
    //   167: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +9 -> 181
    //   175: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   178: invokevirtual 172	java/io/OutputStream:flush	()V
    //   181: aload_0
    //   182: athrow
    //   183: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   186: astore_0
    //   187: aload_0
    //   188: ifnull +10 -> 198
    //   191: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   194: astore_0
    //   195: goto -36 -> 159
    //   198: ldc 2
    //   200: monitorexit
    //   201: return
    //   202: astore_0
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload_0
    //   207: athrow
    //   208: astore_0
    //   209: goto -26 -> 183
    //   212: astore_0
    //   213: goto -15 -> 198
    //   216: astore_1
    //   217: goto -36 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramFile	java.io.File
    //   0	220	1	paramString1	String
    //   0	220	2	paramArrayOfByte	byte[]
    //   0	220	3	paramString2	String
    //   0	220	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   20	63	166	finally
    //   63	89	166	finally
    //   93	102	166	finally
    //   102	107	166	finally
    //   110	132	166	finally
    //   3	9	202	finally
    //   147	151	202	finally
    //   155	159	202	finally
    //   159	163	202	finally
    //   167	171	202	finally
    //   175	181	202	finally
    //   181	183	202	finally
    //   183	187	202	finally
    //   191	195	202	finally
    //   20	63	208	java/lang/Throwable
    //   63	89	208	java/lang/Throwable
    //   93	102	208	java/lang/Throwable
    //   102	107	208	java/lang/Throwable
    //   110	132	208	java/lang/Throwable
    //   155	159	212	java/lang/Throwable
    //   159	163	212	java/lang/Throwable
    //   191	195	212	java/lang/Throwable
    //   175	181	216	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\LogFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */