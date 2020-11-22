package c.a;

import c.a.b.t;
import c.b.c;

public final class k
{
  private static c a = c.a(k.class);
  
  public static int a(String paramString)
  {
    int j = e(paramString);
    String str = paramString.toUpperCase();
    int k = paramString.lastIndexOf('!') + 1;
    int i = k;
    if (paramString.charAt(k) == '$') {
      i = k + 1;
    }
    k = j;
    if (paramString.charAt(j - 1) == '$') {
      k = j - 1;
    }
    int m = i;
    j = 0;
    while (m < k)
    {
      int n = j;
      if (m != i) {
        n = (j + 1) * 26;
      }
      j = n + (str.charAt(m) - 'A');
      m += 1;
    }
    return j;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    a(paramInt1, paramInt2, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, t paramt, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(am.a(paramt.b(paramInt1), "'", "''"));
    paramStringBuffer.append('!');
    a(paramInt2, paramInt3, paramStringBuffer);
  }
  
  public static void a(int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    a(paramInt1, paramStringBuffer);
    paramStringBuffer.append(Integer.toString(paramInt2 + 1));
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, t paramt, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(paramt.b(paramInt1));
    paramStringBuffer.append('!');
    a(paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramStringBuffer);
  }
  
  public static void a(int paramInt, StringBuffer paramStringBuffer)
  {
    int j = paramInt / 26;
    int i = paramInt % 26;
    StringBuffer localStringBuffer = new StringBuffer();
    paramInt = j;
    while (paramInt != 0)
    {
      localStringBuffer.append((char)(i + 65));
      i = paramInt % 26 - 1;
      paramInt /= 26;
    }
    localStringBuffer.append((char)(i + 65));
    paramInt = localStringBuffer.length() - 1;
    while (paramInt >= 0)
    {
      paramStringBuffer.append(localStringBuffer.charAt(paramInt));
      paramInt -= 1;
    }
  }
  
  public static void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, StringBuffer paramStringBuffer)
  {
    if (paramBoolean1) {
      paramStringBuffer.append('$');
    }
    a(paramInt1, paramStringBuffer);
    if (paramBoolean2) {
      paramStringBuffer.append('$');
    }
    paramStringBuffer.append(Integer.toString(paramInt2 + 1));
  }
  
  public static int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString.substring(e(paramString)));
      return i - 1;
    }
    catch (NumberFormatException paramString)
    {
      a.a(paramString, paramString);
    }
    return 65535;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = false;
    if (paramString.charAt(0) != '$') {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d(String paramString)
  {
    return paramString.charAt(e(paramString) - 1) != '$';
  }
  
  private static int e(String paramString)
  {
    int j = paramString.lastIndexOf('!') + 1;
    int i = 0;
    while ((i == 0) && (j < paramString.length()))
    {
      int k = paramString.charAt(j);
      if ((k >= 48) && (k <= 57)) {
        i = 1;
      } else {
        j += 1;
      }
    }
    return j;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */