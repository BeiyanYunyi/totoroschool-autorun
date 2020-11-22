package org.litepal.util.cipher;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AESCrypt
{
  private static final String AES_MODE = "AES/CBC/PKCS7Padding";
  private static final String CHARSET = "UTF-8";
  public static boolean DEBUG_LOG_ENABLED = false;
  private static final String HASH_ALGORITHM = "SHA-256";
  private static final String TAG = "AESCrypt";
  private static final byte[] ivBytes = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  private static String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      arrayOfChar2[k] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(k + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static String decrypt(String paramString1, String paramString2)
    throws GeneralSecurityException
  {
    try
    {
      paramString1 = generateKey(paramString1);
      log("base64EncodedCipherText", paramString2);
      paramString2 = Base64.decode(paramString2, 2);
      log("decodedCipherText", paramString2);
      paramString1 = decrypt(paramString1, ivBytes, paramString2);
      log("decryptedBytes", paramString1);
      paramString1 = new String(paramString1, "UTF-8");
      log("message", paramString1);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      if (DEBUG_LOG_ENABLED) {
        Log.e("AESCrypt", "UnsupportedEncodingException ", paramString1);
      }
      throw new GeneralSecurityException(paramString1);
    }
  }
  
  public static byte[] decrypt(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(2, paramSecretKeySpec, new IvParameterSpec(paramArrayOfByte1));
    paramSecretKeySpec = localCipher.doFinal(paramArrayOfByte2);
    log("decryptedBytes", paramSecretKeySpec);
    return paramSecretKeySpec;
  }
  
  public static String encrypt(String paramString1, String paramString2)
    throws GeneralSecurityException
  {
    try
    {
      paramString1 = generateKey(paramString1);
      log("message", paramString2);
      paramString1 = Base64.encodeToString(encrypt(paramString1, ivBytes, paramString2.getBytes("UTF-8")), 2);
      log("Base64.NO_WRAP", paramString1);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      if (DEBUG_LOG_ENABLED) {
        Log.e("AESCrypt", "UnsupportedEncodingException ", paramString1);
      }
      throw new GeneralSecurityException(paramString1);
    }
  }
  
  public static byte[] encrypt(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(1, paramSecretKeySpec, new IvParameterSpec(paramArrayOfByte1));
    paramSecretKeySpec = localCipher.doFinal(paramArrayOfByte2);
    log("cipherText", paramSecretKeySpec);
    return paramSecretKeySpec;
  }
  
  private static SecretKeySpec generateKey(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    paramString = paramString.getBytes("UTF-8");
    localMessageDigest.update(paramString, 0, paramString.length);
    paramString = localMessageDigest.digest();
    log("SHA-256 key ", paramString);
    return new SecretKeySpec(paramString, "AES");
  }
  
  private static void log(String paramString1, String paramString2)
  {
    if (DEBUG_LOG_ENABLED)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("[");
      localStringBuilder.append(paramString2.length());
      localStringBuilder.append("] [");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      Log.d("AESCrypt", localStringBuilder.toString());
    }
  }
  
  private static void log(String paramString, byte[] paramArrayOfByte)
  {
    if (DEBUG_LOG_ENABLED)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("[");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append("] [");
      localStringBuilder.append(bytesToHex(paramArrayOfByte));
      localStringBuilder.append("]");
      Log.d("AESCrypt", localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\util\cipher\AESCrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */