package d.d;

class g
  extends f
{
  public static final a a(int paramInt1, int paramInt2)
  {
    return a.a.a(paramInt1, paramInt2, -1);
  }
  
  public static final c b(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= Integer.MIN_VALUE) {
      return c.b.a();
    }
    return new c(paramInt1, paramInt2 - 1);
  }
  
  public static final int c(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < paramInt2) {
      i = paramInt2;
    }
    return i;
  }
  
  public static final int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    return i;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */