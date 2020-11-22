package c.a.b;

public class u
{
  public static final u a = new u(255, "?");
  public static final u b = new u(0, "#NULL!");
  public static final u c = new u(7, "#DIV/0!");
  public static final u d = new u(15, "#VALUE!");
  public static final u e = new u(23, "#REF!");
  public static final u f = new u(29, "#NAME?");
  public static final u g = new u(36, "#NUM!");
  public static final u h = new u(42, "#N/A!");
  private static u[] k = new u[0];
  private int i;
  private String j;
  
  u(int paramInt, String paramString)
  {
    this.i = paramInt;
    this.j = paramString;
    paramString = new u[k.length + 1];
    System.arraycopy(k, 0, paramString, 0, k.length);
    paramString[k.length] = this;
    k = paramString;
  }
  
  public static u a(int paramInt)
  {
    u localu = a;
    int m = 0;
    int n = 0;
    while ((m < k.length) && (n == 0))
    {
      if (k[m].i == paramInt)
      {
        localu = k[m];
        n = 1;
      }
      m += 1;
    }
    return localu;
  }
  
  public static u a(String paramString)
  {
    u localu = a;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return localu;
      }
      int m = 0;
      int n = 0;
      while ((m < k.length) && (n == 0))
      {
        if (k[m].j.equals(paramString))
        {
          localu = k[m];
          n = 1;
        }
        m += 1;
      }
      return localu;
    }
    return localu;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public String b()
  {
    return this.j;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */