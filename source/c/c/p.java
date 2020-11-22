package c.c;

public class p
{
  public static p a = new p(0, "top");
  public static p b = new p(1, "centre");
  public static p c = new p(2, "bottom");
  public static p d = new p(3, "Justify");
  private static p[] g = new p[0];
  private int e;
  private String f;
  
  protected p(int paramInt, String paramString)
  {
    this.e = paramInt;
    this.f = paramString;
    paramString = g;
    g = new p[paramString.length + 1];
    System.arraycopy(paramString, 0, g, 0, paramString.length);
    g[paramString.length] = this;
  }
  
  public static p a(int paramInt)
  {
    int i = 0;
    while (i < g.length)
    {
      if (g[i].a() == paramInt) {
        return g[i];
      }
      i += 1;
    }
    return c;
  }
  
  public int a()
  {
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */