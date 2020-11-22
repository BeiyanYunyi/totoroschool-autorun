package d.c.b;

import d.e.e;

public class k
{
  public d.e.c a(Class paramClass)
  {
    return new c(paramClass);
  }
  
  public e a(g paramg)
  {
    return paramg;
  }
  
  public String a(f paramf)
  {
    String str = paramf.getClass().getGenericInterfaces()[0].toString();
    paramf = str;
    if (str.startsWith("kotlin.jvm.functions.")) {
      paramf = str.substring("kotlin.jvm.functions.".length());
    }
    return paramf;
  }
  
  public String a(i parami)
  {
    return a(parami);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */