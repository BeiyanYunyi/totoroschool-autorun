package c.e;

import c.a.v;
import c.c.g;

public final class f
{
  public static final v a = new a(0, "#");
  public static final v b = new a(1, "0");
  public static final v c = new a(2, "0.00");
  public static final v d = new a(3, "#,##0");
  public static final v e = new a(4, "#,##0.00");
  public static final v f = new a(5, "$#,##0;($#,##0)");
  public static final v g = new a(6, "$#,##0;($#,##0)");
  public static final v h = new a(7, "$#,##0;($#,##0)");
  public static final v i = new a(8, "$#,##0;($#,##0)");
  public static final v j = new a(9, "0%");
  public static final v k = new a(10, "0.00%");
  public static final v l = new a(11, "0.00E00");
  public static final v m = new a(12, "?/?");
  public static final v n = new a(13, "??/??");
  public static final v o = new a(37, "#,##0;(#,##0)");
  public static final v p = new a(38, "#,##0;(#,##0)");
  public static final v q = new a(39, "#,##0.00;(#,##0.00)");
  public static final v r = new a(40, "#,##0.00;(#,##0.00)");
  public static final v s = new a(41, "#,##0;(#,##0)");
  public static final v t = new a(42, "#,##0;(#,##0)");
  public static final v u = new a(43, "#,##0.00;(#,##0.00)");
  public static final v v = new a(44, "#,##0.00;(#,##0.00)");
  public static final v w = new a(46, "#,##0.00;(#,##0.00)");
  public static final v x = new a(48, "##0.0E0");
  public static final v y = new a(49, "@");
  
  private static class a
    implements v, g
  {
    private int a;
    private String b;
    
    public a(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
    
    public void a(int paramInt) {}
    
    public boolean c()
    {
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      return this.a == ((a)paramObject).a;
    }
    
    public int f_()
    {
      return this.a;
    }
    
    public boolean g_()
    {
      return true;
    }
    
    public int hashCode()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */