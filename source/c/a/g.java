package c.a;

public class g
{
  public static final g a = new g("Consolidate_Area", 0);
  public static final g b = new g("Auto_Open", 1);
  public static final g c = new g("Auto_Open", 2);
  public static final g d = new g("Extract", 3);
  public static final g e = new g("Database", 4);
  public static final g f = new g("Criteria", 5);
  public static final g g = new g("Print_Area", 6);
  public static final g h = new g("Print_Titles", 7);
  public static final g i = new g("Recorder", 8);
  public static final g j = new g("Data_Form", 9);
  public static final g k = new g("Auto_Activate", 10);
  public static final g l = new g("Auto_Deactivate", 11);
  public static final g m = new g("Sheet_Title", 11);
  public static final g n = new g("_FilterDatabase", 13);
  private static g[] q = new g[0];
  private String o;
  private int p;
  
  private g(String paramString, int paramInt)
  {
    this.o = paramString;
    this.p = paramInt;
    paramString = q;
    q = new g[paramString.length + 1];
    System.arraycopy(paramString, 0, q, 0, paramString.length);
    q[paramString.length] = this;
  }
  
  public int a()
  {
    return this.p;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */