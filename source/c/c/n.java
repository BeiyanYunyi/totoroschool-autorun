package c.c;

public final class n
{
  public static final n a = new n(0, "normal");
  public static final n b = new n(1, "super");
  public static final n c = new n(2, "sub");
  private static n[] f = new n[0];
  private int d;
  private String e;
  
  protected n(int paramInt, String paramString)
  {
    this.d = paramInt;
    this.e = paramString;
    paramString = f;
    f = new n[paramString.length + 1];
    System.arraycopy(paramString, 0, f, 0, paramString.length);
    f[paramString.length] = this;
  }
  
  public static n a(int paramInt)
  {
    int i = 0;
    while (i < f.length)
    {
      if (f[i].a() == paramInt) {
        return f[i];
      }
      i += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */