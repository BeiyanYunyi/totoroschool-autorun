package c.a.b;

import c.b.c;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class y
{
  private static c a = c.a(y.class);
  private HashMap b;
  private HashMap c;
  
  public y(Locale paramLocale)
  {
    ResourceBundle localResourceBundle = ResourceBundle.getBundle("functions", paramLocale);
    x[] arrayOfx = x.d();
    this.b = new HashMap(arrayOfx.length);
    this.c = new HashMap(arrayOfx.length);
    int i = 0;
    while (i < arrayOfx.length)
    {
      x localx = arrayOfx[i];
      paramLocale = localx.b();
      if (paramLocale.length() != 0) {
        paramLocale = localResourceBundle.getString(paramLocale);
      } else {
        paramLocale = null;
      }
      if (paramLocale != null)
      {
        this.b.put(localx, paramLocale);
        this.c.put(paramLocale, localx);
      }
      i += 1;
    }
  }
  
  x a(String paramString)
  {
    return (x)this.c.get(paramString);
  }
  
  String a(x paramx)
  {
    return (String)this.b.get(paramx);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */