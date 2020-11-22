package c.e;

import c.a.v;

public final class c
{
  public static final v a = new a(14, "M/d/yy");
  public static final v b = a;
  public static final v c = new a(15, "d-MMM-yy");
  public static final v d = new a(16, "d-MMM");
  public static final v e = new a(17, "MMM-yy");
  public static final v f = new a(18, "h:mm a");
  public static final v g = new a(19, "h:mm:ss a");
  public static final v h = new a(20, "H:mm");
  public static final v i = new a(21, "H:mm:ss");
  public static final v j = new a(22, "M/d/yy H:mm");
  public static final v k = new a(45, "mm:ss");
  public static final v l = new a(46, "H:mm:ss");
  public static final v m = new a(47, "H:mm:ss");
  
  private static class a
    implements v
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */