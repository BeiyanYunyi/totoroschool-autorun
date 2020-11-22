package e.a.c;

import e.aa;
import e.ac;
import e.l;
import e.m;
import e.s;
import e.t;
import f.f;
import java.util.List;

public final class e
{
  private static final f a = f.encodeUtf8("\"\\");
  private static final f b = f.encodeUtf8("\t ,=");
  
  public static int a(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((i != 32) && (i != 9)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    while (paramInt < paramString1.length())
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt)) != -1) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static long a(ac paramac)
  {
    return a(paramac.f());
  }
  
  public static long a(s params)
  {
    return a(params.a("Content-Length"));
  }
  
  private static long a(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static void a(m paramm, t paramt, s params)
  {
    if (paramm == m.a) {
      return;
    }
    params = l.a(paramt, params);
    if (params.isEmpty()) {
      return;
    }
    paramm.a(paramt, params);
  }
  
  public static int b(String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      if (l < 0L) {
        return 0;
      }
      return (int)l;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static boolean b(ac paramac)
  {
    if (paramac.a().b().equals("HEAD")) {
      return false;
    }
    int i = paramac.b();
    if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
      return true;
    }
    if (a(paramac) == -1L) {
      return "chunked".equalsIgnoreCase(paramac.a("Transfer-Encoding"));
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */