package e.a.c;

import e.aa;
import e.t;
import java.net.Proxy.Type;

public final class i
{
  public static String a(aa paramaa, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramaa.b());
    localStringBuilder.append(' ');
    if (b(paramaa, paramType)) {
      localStringBuilder.append(paramaa.a());
    } else {
      localStringBuilder.append(a(paramaa.a()));
    }
    localStringBuilder.append(" HTTP/1.1");
    return localStringBuilder.toString();
  }
  
  public static String a(t paramt)
  {
    String str1 = paramt.h();
    String str2 = paramt.k();
    paramt = str1;
    if (str2 != null)
    {
      paramt = new StringBuilder();
      paramt.append(str1);
      paramt.append('?');
      paramt.append(str2);
      paramt = paramt.toString();
    }
    return paramt;
  }
  
  private static boolean b(aa paramaa, Proxy.Type paramType)
  {
    return (!paramaa.g()) && (paramType == Proxy.Type.HTTP);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */