package c.a.b;

import c.a.k;
import c.b.a;
import c.b.c;

class m
  extends b
{
  private static c a = c.a(m.class);
  
  m() {}
  
  m(String paramString)
  {
    int i = paramString.indexOf(":");
    boolean bool;
    if (i != -1) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    String str = paramString.substring(0, i);
    paramString = paramString.substring(i + 1);
    a(k.a(str), k.a(paramString), 0, 65535, k.c(str), k.c(paramString), false, false);
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    k.a(a(), paramStringBuffer);
    paramStringBuffer.append(':');
    k.a(b(), paramStringBuffer);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */