package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class o
{
  protected static final char[] a = "0123456789abcdef".toCharArray();
  private static String b = "";
  private static byte[] c;
  private static o f = null;
  private static String g;
  private Cipher d = null;
  private Cipher e = null;
  
  private o()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(new Random().nextInt(89999999) + 10000000));
    ((StringBuilder)localObject).append(String.valueOf(new Random().nextInt(89999999) + 10000000));
    ((StringBuilder)localObject).append(String.valueOf(new Random().nextInt(89999999) + 10000000));
    g = ((StringBuilder)localObject).toString();
    localObject = "00000000";
    int i = 0;
    while (i < 12)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(String.valueOf(new Random().nextInt(89999999) + 10000000));
      localObject = localStringBuilder.toString();
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(g);
    c = localStringBuilder.toString().getBytes();
    this.d = Cipher.getInstance("RSA/ECB/NoPadding");
    localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0));
    localObject = KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject);
    this.d.init(1, (Key)localObject);
    b = b(this.d.doFinal(c));
    localObject = new DESedeKeySpec(g.getBytes());
    localObject = SecretKeyFactory.getInstance("DESede").generateSecret((KeySpec)localObject);
    this.e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    this.e.init(1, (Key)localObject);
  }
  
  public static o a()
  {
    try
    {
      if (f == null) {
        f = new o();
      }
      o localo = f;
      return localo;
    }
    catch (Exception localException)
    {
      f = null;
      localException.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    paramString = new DESedeKeySpec(paramString.getBytes());
    paramString = SecretKeyFactory.getInstance("DESede").generateSecret(paramString);
    Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      arrayOfChar[k] = a[(j >>> 4)];
      arrayOfChar[(k + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String c()
  {
    return g;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    return this.e.doFinal(paramArrayOfByte);
  }
  
  public String b()
  {
    return b;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject = g.getBytes();
    try
    {
      localObject = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec((byte[])localObject));
      Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      localCipher.init(2, (Key)localObject);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */