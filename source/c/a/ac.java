package c.a;

import c.b.c;
import c.c.g;

public class ac
  extends aq
  implements v, g
{
  public static c a = c.a(ac.class);
  public static final a b = new a(null);
  public static final a c = new a(null);
  private static String[] j = { "dd", "mm", "yy", "hh", "ss", "m/", "/d" };
  private boolean d = false;
  private byte[] e;
  private int f;
  private String g;
  private boolean h;
  private boolean i;
  
  protected ac()
  {
    super(an.G);
  }
  
  protected final String a(String paramString1, String paramString2, String paramString3)
  {
    for (int k = paramString1.indexOf(paramString2); k != -1; k = paramString1.indexOf(paramString2))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramString1.substring(0, k));
      localStringBuffer.append(paramString3);
      localStringBuffer.append(paramString1.substring(k + paramString2.length()));
      paramString1 = localStringBuffer.toString();
    }
    return paramString1;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    this.d = true;
  }
  
  protected final void a(String paramString)
  {
    this.g = paramString;
  }
  
  public byte[] a()
  {
    this.e = new byte[this.g.length() * 2 + 3 + 2];
    ag.a(this.f, this.e, 0);
    ag.a(this.g.length(), this.e, 2);
    this.e[4] = 1;
    am.b(this.g, this.e, 5);
    return this.e;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ac)) {
      return false;
    }
    paramObject = (ac)paramObject;
    if ((this.d) && (((ac)paramObject).d))
    {
      if (this.h == ((ac)paramObject).h)
      {
        if (this.i != ((ac)paramObject).i) {
          return false;
        }
        return this.g.equals(((ac)paramObject).g);
      }
      return false;
    }
    return this.g.equals(((ac)paramObject).g);
  }
  
  public int f_()
  {
    return this.f;
  }
  
  public boolean g_()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return this.g.hashCode();
  }
  
  private static class a {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */