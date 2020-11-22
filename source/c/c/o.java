package c.c;

public final class o
{
  public static final o a = new o(0, "none");
  public static final o b = new o(1, "single");
  public static final o c = new o(2, "double");
  public static final o d = new o(33, "single accounting");
  public static final o e = new o(34, "double accounting");
  private static o[] h = new o[0];
  private int f;
  private String g;
  
  protected o(int paramInt, String paramString)
  {
    this.f = paramInt;
    this.g = paramString;
    paramString = h;
    h = new o[paramString.length + 1];
    System.arraycopy(paramString, 0, h, 0, paramString.length);
    h[paramString.length] = this;
  }
  
  public static o a(int paramInt)
  {
    int i = 0;
    while (i < h.length)
    {
      if (h[i].a() == paramInt) {
        return h[i];
      }
      i += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */