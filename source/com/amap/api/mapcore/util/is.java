package com.amap.api.mapcore.util;

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

public class is
  extends iw
{
  private Context a;
  private String b;
  private ga e;
  private Object[] f;
  
  public is(Context paramContext, iw paramiw, ga paramga, String paramString, Object... paramVarArgs)
  {
    super(paramiw);
    this.a = paramContext;
    this.b = paramString;
    this.e = paramga;
    this.f = paramVarArgs;
  }
  
  private String a(Context paramContext)
  {
    try
    {
      paramContext = String.format(fw.c(this.b), this.f);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      gk.c(paramContext, "ofm", "gpj");
    }
    return "";
  }
  
  private String b(Context paramContext)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    paramContext = a(paramContext);
    return fw.a(this.e.b(fw.a(paramContext)));
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
    throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException
  {
    paramArrayOfByte = fw.a(paramArrayOfByte);
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      return null;
    }
    String str = b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"pinfo\":\"");
    localStringBuilder.append(str);
    localStringBuilder.append("\",\"els\":[");
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append("]}");
    return fw.a(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */