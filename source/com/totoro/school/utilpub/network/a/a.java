package com.totoro.school.utilpub.network.a;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  public static String a(String paramString)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/ECB/ISO10126Padding");
      localCipher.init(1, new SecretKeySpec(c("www.xtotoro.com/student").getBytes(), "AES"));
      paramString = Base64.encodeToString(localCipher.doFinal(paramString.getBytes("utf-8")), 0).replaceAll("\\r|\\n", "");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(c("www.xtotoro.com/student").getBytes("ASCII"), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/ISO10126Padding");
      localCipher.init(2, localSecretKeySpec);
      paramString = new String(localCipher.doFinal(Base64.decode(paramString, 0)), "utf-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if (paramString.length() > 16) {
      return paramString.substring(0, 16);
    }
    Object localObject = paramString;
    if (paramString.length() < 16)
    {
      int i = paramString.length() - 1;
      for (;;)
      {
        localObject = paramString;
        if (i >= 15) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\000");
        paramString = ((StringBuilder)localObject).toString();
        i += 1;
      }
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */