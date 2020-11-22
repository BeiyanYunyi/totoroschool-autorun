package c.c;

public final class h
{
  public static h a = new h(0, "horizontal");
  public static h b = new h(255, "vertical");
  public static h c = new h(90, "up 90");
  public static h d = new h(180, "down 90");
  public static h e = new h(45, "up 45");
  public static h f = new h(135, "down 45");
  public static h g = new h(255, "stacked");
  private static h[] j = new h[0];
  private int h;
  private String i;
  
  protected h(int paramInt, String paramString)
  {
    this.h = paramInt;
    this.i = paramString;
    paramString = j;
    j = new h[paramString.length + 1];
    System.arraycopy(paramString, 0, j, 0, paramString.length);
    j[paramString.length] = this;
  }
  
  public static h a(int paramInt)
  {
    int k = 0;
    while (k < j.length)
    {
      if (j[k].a() == paramInt) {
        return j[k];
      }
      k += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.h;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */