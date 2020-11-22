package org.litepal.util.cipher;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CipherUtil
{
  private static final char[] DIGITS_UPPER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static String aesKey = "LitePalKey";
  
  public static String aesDecrypt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = AESCrypt.decrypt(aesKey, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String aesEncrypt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = AESCrypt.encrypt(aesKey, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String md5Encrypt(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(Charset.defaultCharset()));
      paramString = new String(toHex(localMessageDigest.digest()));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static char[] toHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = DIGITS_UPPER;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar2 = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar2[j] = arrayOfChar1[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar2[m] = arrayOfChar1[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\util\cipher\CipherUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */