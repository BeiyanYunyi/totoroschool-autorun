package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class bz
  extends cd
{
  private Context a;
  private String b;
  private aa e;
  private Object[] f;
  
  public bz(Context paramContext, cd paramcd, aa paramaa, String paramString, Object... paramVarArgs)
  {
    super(paramcd);
    this.a = paramContext;
    this.b = paramString;
    this.e = paramaa;
    this.f = paramVarArgs;
  }
  
  private String b()
  {
    try
    {
      String str = String.format(w.c(this.b), this.f);
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      aj.b(localThrowable, "ofm", "gpj");
    }
    return "";
  }
  
  protected final byte[] a(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    paramArrayOfByte = w.a(paramArrayOfByte);
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      return null;
    }
    String str = b();
    str = w.a(this.e.b(w.a(str)));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"pinfo\":\"");
    localStringBuilder.append(str);
    localStringBuilder.append("\",\"els\":[");
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append("]}");
    return w.a(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */