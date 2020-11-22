package c.c;

public class c
{
  public static final c a = new c(0, "none");
  public static final c b = new c(1, "thin");
  public static final c c = new c(2, "medium");
  public static final c d = new c(3, "dashed");
  public static final c e = new c(4, "dotted");
  public static final c f = new c(5, "thick");
  public static final c g = new c(6, "double");
  public static final c h = new c(7, "hair");
  public static final c i = new c(8, "medium dashed");
  public static final c j = new c(9, "dash dot");
  public static final c k = new c(10, "medium dash dot");
  public static final c l = new c(11, "Dash dot dot");
  public static final c m = new c(12, "Medium dash dot dot");
  public static final c n = new c(13, "Slanted dash dot");
  private static c[] q = new c[0];
  private int o;
  private String p;
  
  protected c(int paramInt, String paramString)
  {
    this.o = paramInt;
    this.p = paramString;
    paramString = q;
    q = new c[paramString.length + 1];
    System.arraycopy(paramString, 0, q, 0, paramString.length);
    q[paramString.length] = this;
  }
  
  public static c a(int paramInt)
  {
    int i1 = 0;
    while (i1 < q.length)
    {
      if (q[i1].a() == paramInt) {
        return q[i1];
      }
      i1 += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.o;
  }
  
  public String b()
  {
    return this.p;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */