package com.amap.api.mapcore.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class iw
{
  iw c;
  byte[] d = null;
  
  iw() {}
  
  iw(iw paramiw)
  {
    this.c = paramiw;
  }
  
  public byte[] a()
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    byte[] arrayOfByte = a(this.d);
    if (this.c != null)
    {
      this.c.c(arrayOfByte);
      return this.c.a();
    }
    return arrayOfByte;
  }
  
  protected abstract byte[] a(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public void b(byte[] paramArrayOfByte) {}
  
  void c(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */