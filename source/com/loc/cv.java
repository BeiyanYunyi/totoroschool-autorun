package com.loc;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class cv
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final byte[] b = { 0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1 };
  private static final IvParameterSpec c = new IvParameterSpec(b);
  
  public static String a(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() == 0) {
          return null;
        }
        String str = a("SHA1", paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramString);
        paramString = a("MD5", localStringBuilder.toString());
        return paramString;
      }
      catch (Throwable paramString)
      {
        dg.a(paramString, "Encrypt", "generatorKey");
      }
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    try
    {
      paramString1 = s.a(paramString2.getBytes("UTF-8"), paramString1);
      int j = paramString1.length;
      paramString2 = new StringBuilder(j * 2);
      int i = 0;
      while (i < j)
      {
        paramString2.append(a[(paramString1[i] >> 4 & 0xF)]);
        paramString2.append(a[(paramString1[i] & 0xF)]);
        i += 1;
      }
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      dg.a(paramString1, "Encrypt", "encode");
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    try
    {
      Object localObject = new byte[16];
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 16];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 16);
      System.arraycopy(paramArrayOfByte, 16, arrayOfByte, 0, paramArrayOfByte.length - 16);
      localObject = new SecretKeySpec((byte[])localObject, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, (Key)localObject, new IvParameterSpec(w.c()));
      arrayOfByte = localCipher.doFinal(arrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      if (paramArrayOfByte != null) {
        i = paramArrayOfByte.length;
      }
      paramArrayOfByte = new StringBuilder("decryptRsponse length = ");
      paramArrayOfByte.append(i);
      dg.a(localThrowable, "Encrypt", paramArrayOfByte.toString());
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    try
    {
      paramString = new PKCS8EncodedKeySpec(q.b(paramString));
      paramString = KeyFactory.getInstance("RSA").generatePrivate(paramString);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, paramString);
      int k = paramArrayOfByte.length;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      int j = 0;
      for (;;)
      {
        int m = k - i;
        if (m <= 0) {
          break;
        }
        if (m > 245) {
          paramString = localCipher.doFinal(paramArrayOfByte, i, 245);
        } else {
          paramString = localCipher.doFinal(paramArrayOfByte, i, m);
        }
        localByteArrayOutputStream.write(paramString, 0, paramString.length);
        j += 1;
        i = j * 245;
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    finally {}
  }
  
  private static SecretKeySpec b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuffer(16);
    for (;;)
    {
      paramString.append(str);
      if (paramString.length() >= 16) {
        break;
      }
      str = "0";
    }
    if (paramString.length() > 16) {
      paramString.setLength(16);
    }
    try
    {
      paramString = paramString.toString().getBytes("UTF-8");
    }
    catch (Throwable paramString)
    {
      dg.a(paramString, "Encrypt", "createKey");
      paramString = null;
    }
    return new SecretKeySpec(paramString, "AES");
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = b(paramString);
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(w.c());
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, paramString, localIvParameterSpec);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      dg.a(paramArrayOfByte, "Encrypt", "aesEncrypt");
    }
    return null;
  }
  
  public static byte[] c(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = b(paramString);
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(w.c());
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, paramString, localIvParameterSpec);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      dg.a(paramArrayOfByte, "Encrypt", "aesDecrypt");
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */