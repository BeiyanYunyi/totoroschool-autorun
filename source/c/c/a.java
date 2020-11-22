package c.c;

public class a
{
  public static a a = new a(0, "general");
  public static a b = new a(1, "left");
  public static a c = new a(2, "centre");
  public static a d = new a(3, "right");
  public static a e = new a(4, "fill");
  public static a f = new a(5, "justify");
  private static a[] i = new a[0];
  private int g;
  private String h;
  
  protected a(int paramInt, String paramString)
  {
    this.g = paramInt;
    this.h = paramString;
    paramString = i;
    i = new a[paramString.length + 1];
    System.arraycopy(paramString, 0, i, 0, paramString.length);
    i[paramString.length] = this;
  }
  
  public static a a(int paramInt)
  {
    int j = 0;
    while (j < i.length)
    {
      if (i[j].a() == paramInt) {
        return i[j];
      }
      j += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */