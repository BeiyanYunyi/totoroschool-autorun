package c.a.a;

final class ae
{
  public static final ae a = new ae(0);
  public static final ae b = new ae(75);
  public static final ae c = new ae(201);
  public static final ae d = new ae(202);
  public static final ae e = new ae(-1);
  private static ae[] g = new ae[0];
  private int f;
  
  ae(int paramInt)
  {
    this.f = paramInt;
    ae[] arrayOfae = g;
    g = new ae[g.length + 1];
    System.arraycopy(arrayOfae, 0, g, 0, arrayOfae.length);
    g[arrayOfae.length] = this;
  }
  
  static ae a(int paramInt)
  {
    ae localae = e;
    int i = 0;
    int j = 0;
    while ((i < g.length) && (j == 0))
    {
      if (g[i].f == paramInt)
      {
        localae = g[i];
        j = 1;
      }
      i += 1;
    }
    return localae;
  }
  
  public int a()
  {
    return this.f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */