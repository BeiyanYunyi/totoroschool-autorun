package c.a;

import c.b.c;

public class p
{
  public static final p a = new p(1, "US", "USA");
  public static final p b = new p(2, "CA", "Canada");
  public static final p c = new p(30, "GR", "Greece");
  public static final p d = new p(31, "NE", "Netherlands");
  public static final p e = new p(32, "BE", "Belgium");
  public static final p f = new p(33, "FR", "France");
  public static final p g = new p(34, "ES", "Spain");
  public static final p h = new p(39, "IT", "Italy");
  public static final p i = new p(41, "CH", "Switzerland");
  public static final p j = new p(44, "UK", "United Kingdowm");
  public static final p k = new p(45, "DK", "Denmark");
  public static final p l = new p(46, "SE", "Sweden");
  public static final p m = new p(47, "NO", "Norway");
  public static final p n = new p(49, "DE", "Germany");
  public static final p o = new p(63, "PH", "Philippines");
  public static final p p = new p(86, "CN", "China");
  public static final p q = new p(91, "IN", "India");
  public static final p r = new p(65535, "??", "Unknown");
  private static c s = c.a(p.class);
  private static p[] w = new p[0];
  private int t;
  private String u;
  private String v;
  
  private p(int paramInt, String paramString1, String paramString2)
  {
    this.t = paramInt;
    this.u = paramString1;
    this.v = paramString2;
    paramString1 = new p[w.length + 1];
    System.arraycopy(w, 0, paramString1, 0, w.length);
    paramString1[w.length] = this;
    w = paramString1;
  }
  
  public static p a(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 2))
    {
      p localp = r;
      int i1 = 0;
      while ((i1 < w.length) && (localp == r))
      {
        if (w[i1].u.equals(paramString)) {
          localp = w[i1];
        }
        i1 += 1;
      }
      return localp;
    }
    s.b("Please specify two character ISO 3166 country code");
    return a;
  }
  
  public int a()
  {
    return this.t;
  }
  
  public String b()
  {
    return this.u;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */