package c.a;

import c.b.c;
import c.m;

public class y
{
  private static c a = c.a(y.class);
  private static byte b = 1;
  private static byte c = 2;
  private static byte d = 3;
  private static byte e = 4;
  private static byte f = 5;
  
  public static byte[] a(String paramString, m paramm)
  {
    if (paramString.startsWith("http:")) {
      return c(paramString, paramm);
    }
    return b(paramString, paramm);
  }
  
  private static byte[] b(String paramString, m paramm)
  {
    i locali = new i();
    int i;
    if (paramString.charAt(1) == ':')
    {
      locali.a(b);
      locali.a((byte)paramString.charAt(0));
      i = 2;
    }
    else
    {
      if ((paramString.charAt(0) == '\\') || (paramString.charAt(0) == '/')) {
        locali.a(c);
      }
      i = 0;
    }
    for (;;)
    {
      if (paramString.charAt(i) != '\\')
      {
        int j = i;
        if (paramString.charAt(i) != '/')
        {
          while (j < paramString.length())
          {
            i = paramString.indexOf('/', j);
            int k = paramString.indexOf('\\', j);
            if ((i != -1) && (k != -1)) {
              i = Math.min(i, k);
            } else if ((i != -1) && (k != -1)) {
              i = 0;
            } else {
              i = Math.max(i, k);
            }
            String str;
            if (i == -1)
            {
              str = paramString.substring(j);
              i = paramString.length();
            }
            else
            {
              str = paramString.substring(j, i);
              i += 1;
            }
            if (!str.equals(".")) {
              if (str.equals("..")) {
                locali.a(e);
              } else {
                locali.a(am.a(str, paramm));
              }
            }
            if (i < paramString.length()) {
              locali.a(d);
            }
            j = i;
          }
          return locali.a();
        }
      }
      i += 1;
    }
  }
  
  private static byte[] c(String paramString, m paramm)
  {
    i locali = new i();
    locali.a(f);
    locali.a((byte)paramString.length());
    locali.a(am.a(paramString, paramm));
    return locali.a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */