package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.c;
import java.util.UnknownFormatConversionException;

public class g
{
  static int a = 5;
  static int b = 16;
  static char[] c = new char[b];
  static String d = "dex2oat-cmdline";
  static long e = 4096L;
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = new c(paramString);
    paramContext.a(c);
    int i = c[a];
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    paramContext.a(bool);
    paramContext.a(e);
    return a(new String(a(paramContext)));
  }
  
  private static String a(String paramString)
  {
    paramString = paramString.split(new String("\000"));
    int j;
    for (int i = 0; i < paramString.length; i = j + 1)
    {
      j = i + 1;
      Object localObject = paramString[i];
      String str = paramString[j];
      if (((String)localObject).equals(d)) {
        return str;
      }
    }
    return "";
  }
  
  public static char[] a(c paramc)
  {
    char[] arrayOfChar1 = new char[4];
    char[] arrayOfChar2 = new char[4];
    paramc.a(arrayOfChar1);
    if ((arrayOfChar1[0] == 'o') && (arrayOfChar1[1] == 'a') && (arrayOfChar1[2] == 't'))
    {
      paramc.a(arrayOfChar2);
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      if (arrayOfChar2[1] <= '4')
      {
        paramc.b();
        paramc.b();
        paramc.b();
      }
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      paramc.b();
      arrayOfChar1 = new char[paramc.b()];
      paramc.a(arrayOfChar1);
      return arrayOfChar1;
    }
    throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[] { Character.valueOf(arrayOfChar1[0]), Character.valueOf(arrayOfChar1[1]), Character.valueOf(arrayOfChar1[2]) }));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */