package com.amap.api.mapcore.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class ga
{
  ga a;
  
  ga() {}
  
  ga(ga paramga)
  {
    this.a = paramga;
  }
  
  private byte[] c(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    if (this.a != null) {
      return this.a.b(paramArrayOfByte);
    }
    return paramArrayOfByte;
  }
  
  protected abstract byte[] a(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public byte[] b(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    return a(c(paramArrayOfByte));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */