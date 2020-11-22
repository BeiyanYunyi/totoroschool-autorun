package c.a;

import c.b.c;
import c.m;
import java.io.UnsupportedEncodingException;

public final class am
{
  public static String a = "UnicodeLittle";
  private static c b = c.a(am.class);
  
  public static final String a(String paramString1, String paramString2, String paramString3)
  {
    for (int i = paramString1.indexOf(paramString2); i != -1; i = paramString1.indexOf(paramString2, i + paramString3.length()))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramString1.substring(0, i));
      localStringBuffer.append(paramString3);
      localStringBuffer.append(paramString1.substring(paramString2.length() + i));
      paramString1 = localStringBuffer.toString();
    }
    return paramString1;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 *= 2;
    try
    {
      byte[] arrayOfByte = new byte[paramInt1];
      System.arraycopy(paramArrayOfByte, paramInt2, arrayOfByte, 0, paramInt1);
      paramArrayOfByte = new String(arrayOfByte, a);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, m paramm)
  {
    if (paramInt1 == 0) {
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramInt2, paramInt1, paramm.g());
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      b.b(paramArrayOfByte.toString());
    }
    return "";
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = a(paramString);
    System.arraycopy(paramString, 0, paramArrayOfByte, paramInt, paramString.length);
  }
  
  public static byte[] a(String paramString)
  {
    return paramString.getBytes();
  }
  
  public static byte[] a(String paramString, m paramm)
  {
    try
    {
      paramString = paramString.getBytes(paramm.g());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static void b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = b(paramString);
    System.arraycopy(paramString, 0, paramArrayOfByte, paramInt, paramString.length);
  }
  
  public static byte[] b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(a);
      if (arrayOfByte.length == paramString.length() * 2 + 2)
      {
        paramString = new byte[arrayOfByte.length - 2];
        System.arraycopy(arrayOfByte, 2, paramString, 0, paramString.length);
        return paramString;
      }
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */