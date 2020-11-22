package com.amap.api.mapcore.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class gd
  extends ga
{
  public gd() {}
  
  public gd(ga paramga)
  {
    super(paramga);
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    return fq.a(paramArrayOfByte);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */