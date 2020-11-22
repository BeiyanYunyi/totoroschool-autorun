package c;

public final class d
{
  public static final d a = new d("Empty");
  public static final d b = new d("Label");
  public static final d c = new d("Number");
  public static final d d = new d("Boolean");
  public static final d e = new d("Error");
  public static final d f = new d("Numerical Formula");
  public static final d g = new d("Date Formula");
  public static final d h = new d("String Formula");
  public static final d i = new d("Boolean Formula");
  public static final d j = new d("Formula Error");
  public static final d k = new d("Date");
  private String l;
  
  private d(String paramString)
  {
    this.l = paramString;
  }
  
  public String toString()
  {
    return this.l;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */