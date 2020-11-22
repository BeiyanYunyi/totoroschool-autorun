package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class cd
{
  cd c;
  byte[] d = null;
  
  cd() {}
  
  cd(cd paramcd)
  {
    this.c = paramcd;
  }
  
  public final byte[] a()
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    byte[] arrayOfByte;
    for (cd localcd = this;; localcd = localcd.c)
    {
      arrayOfByte = localcd.a(localcd.d);
      if (localcd.c == null) {
        break;
      }
      localcd.c.d = arrayOfByte;
    }
    return arrayOfByte;
  }
  
  protected abstract byte[] a(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public void b(byte[] paramArrayOfByte) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */