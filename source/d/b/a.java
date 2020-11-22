package d.b;

public final class a
{
  private static final int a(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  public static final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      if (paramInt1 >= paramInt2) {
        return paramInt2;
      }
      return paramInt2 - b(paramInt2, paramInt1, paramInt3);
    }
    if (paramInt3 < 0)
    {
      if (paramInt1 <= paramInt2) {
        return paramInt2;
      }
      return paramInt2 + b(paramInt1, paramInt2, -paramInt3);
    }
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
  
  private static final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(a(paramInt1, paramInt3) - a(paramInt2, paramInt3), paramInt3);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */