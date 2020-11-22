package c.a.b;

import c.a.k;
import c.b.a;

class n
  extends c
{
  private static c.b.c a = c.b.c.a(n.class);
  private t b;
  private int c;
  
  n(String paramString, t paramt)
    throws v
  {
    super(paramt);
    this.b = paramt;
    int j = paramString.lastIndexOf(":");
    boolean bool;
    if (j != -1) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    paramString.substring(0, j);
    String str2 = paramString.substring(j + 1);
    int i = paramString.indexOf('!');
    j = k.a(paramString.substring(i + 1, j));
    String str1 = paramString.substring(0, i);
    str1.lastIndexOf(']');
    paramString = str1;
    if (str1.charAt(0) == '\'')
    {
      paramString = str1;
      if (str1.charAt(str1.length() - 1) == '\'') {
        paramString = str1.substring(1, str1.length() - 1);
      }
    }
    this.c = paramt.b(paramString);
    if (this.c >= 0)
    {
      i = k.a(str2);
      a(this.c, j, i, 0, 65535, true, true, true, true);
      return;
    }
    throw new v(v.SHEET_REF_NOT_FOUND, paramString);
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append('\'');
    paramStringBuffer.append(this.b.b(this.c));
    paramStringBuffer.append('\'');
    paramStringBuffer.append('!');
    k.a(a(), paramStringBuffer);
    paramStringBuffer.append(':');
    k.a(b(), paramStringBuffer);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */