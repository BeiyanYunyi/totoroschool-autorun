package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.a.a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class p
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  private static p b;
  private String c;
  private String d;
  private String e;
  
  private p()
  {
    int i = new Random().nextInt(89999999);
    int j = new Random().nextInt(89999999);
    this.e = String.valueOf(i + 10000000);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append(String.valueOf(j + 10000000));
    this.c = localStringBuilder.toString();
  }
  
  public static p a()
  {
    try
    {
      if (b == null) {
        b = new p();
      }
      p localp = b;
      return localp;
    }
    finally {}
  }
  
  private String b(byte[] paramArrayOfByte)
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
  
  public String a(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes();
    for (;;)
    {
      try
      {
        paramString = Cipher.getInstance("RSA/ECB/NoPadding");
      }
      catch (Exception paramString)
      {
        X509EncodedKeySpec localX509EncodedKeySpec;
        continue;
      }
      try
      {
        b();
        paramString = Cipher.getInstance("RSA/ECB/NoPadding");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    localX509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
    paramString.init(1, KeyFactory.getInstance("RSA").generatePublic(localX509EncodedKeySpec));
    return b(paramString.doFinal(arrayOfByte));
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    return a.a(this.e.getBytes(), paramArrayOfByte, 1);
  }
  
  public void b()
  {
    Security.addProvider((Provider)Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
  }
  
  public String c()
  {
    if (this.d == null)
    {
      byte[] arrayOfByte = this.c.getBytes();
      for (;;)
      {
        try
        {
          localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
        }
        catch (Exception localException2)
        {
          Cipher localCipher;
          Object localObject;
          X509EncodedKeySpec localX509EncodedKeySpec;
          continue;
        }
        try
        {
          b();
          localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject = null;
        }
      }
      localX509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
      ((Cipher)localObject).init(1, KeyFactory.getInstance("RSA").generatePublic(localX509EncodedKeySpec));
      this.d = b(((Cipher)localObject).doFinal(arrayOfByte));
    }
    return this.d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */