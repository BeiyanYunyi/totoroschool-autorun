package c.a.a;

final class c
{
  public static final c a = new c(0, "Error");
  public static final c b = new c(1, "Unknown");
  public static final c c = new c(2, "EMF");
  public static final c d = new c(3, "WMF");
  public static final c e = new c(4, "PICT");
  public static final c f = new c(5, "JPEG");
  public static final c g = new c(6, "PNG");
  public static final c h = new c(7, "DIB");
  public static final c i = new c(32, "FIRST");
  public static final c j = new c(255, "LAST");
  private static c[] m = new c[0];
  private int k;
  private String l;
  
  private c(int paramInt, String paramString)
  {
    this.k = paramInt;
    this.l = paramString;
    paramString = new c[m.length + 1];
    System.arraycopy(m, 0, paramString, 0, m.length);
    paramString[m.length] = this;
    m = paramString;
  }
  
  public static c a(int paramInt)
  {
    c localc = b;
    int n = 0;
    while (n < m.length)
    {
      if (m[n].k == paramInt) {
        return m[n];
      }
      n += 1;
    }
    return localc;
  }
  
  public int a()
  {
    return this.k;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */