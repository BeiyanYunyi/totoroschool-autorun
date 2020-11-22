package c.a.a;

final class w
{
  public static final w a = new w(0);
  public static final w b = new w(61440);
  public static final w c = new w(61441);
  public static final w d = new w(61442);
  public static final w e = new w(61443);
  public static final w f = new w(61444);
  public static final w g = new w(61446);
  public static final w h = new w(61447);
  public static final w i = new w(61448);
  public static final w j = new w(61449);
  public static final w k = new w(61450);
  public static final w l = new w(61451);
  public static final w m = new w(61456);
  public static final w n = new w(61457);
  public static final w o = new w(61453);
  public static final w p = new w(61726);
  private static w[] r = new w[0];
  private int q;
  
  private w(int paramInt)
  {
    this.q = paramInt;
    w[] arrayOfw = new w[r.length + 1];
    System.arraycopy(r, 0, arrayOfw, 0, r.length);
    arrayOfw[r.length] = this;
    r = arrayOfw;
  }
  
  public static w a(int paramInt)
  {
    w localw = a;
    int i1 = 0;
    while (i1 < r.length)
    {
      if (paramInt == r[i1].q) {
        return r[i1];
      }
      i1 += 1;
    }
    return localw;
  }
  
  public int a()
  {
    return this.q;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */