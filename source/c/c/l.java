package c.c;

public class l
{
  public static final l a = new l(0, "None");
  public static final l b = new l(1, "Solid");
  public static final l c = new l(2, "Gray 50%");
  public static final l d = new l(3, "Gray 75%");
  public static final l e = new l(4, "Gray 25%");
  public static final l f = new l(5, "Pattern 1");
  public static final l g = new l(6, "Pattern 2");
  public static final l h = new l(7, "Pattern 3");
  public static final l i = new l(8, "Pattern 4");
  public static final l j = new l(9, "Pattern 5");
  public static final l k = new l(10, "Pattern 6");
  public static final l l = new l(11, "Pattern 7");
  public static final l m = new l(12, "Pattern 8");
  public static final l n = new l(13, "Pattern 9");
  public static final l o = new l(14, "Pattern 10");
  public static final l p = new l(15, "Pattern 11");
  public static final l q = new l(16, "Pattern 12");
  public static final l r = new l(17, "Pattern 13");
  public static final l s = new l(18, "Pattern 14");
  private static l[] v = new l[0];
  private int t;
  private String u;
  
  protected l(int paramInt, String paramString)
  {
    this.t = paramInt;
    this.u = paramString;
    paramString = v;
    v = new l[paramString.length + 1];
    System.arraycopy(paramString, 0, v, 0, paramString.length);
    v[paramString.length] = this;
  }
  
  public static l a(int paramInt)
  {
    int i1 = 0;
    while (i1 < v.length)
    {
      if (v[i1].a() == paramInt) {
        return v[i1];
      }
      i1 += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.t;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */