package d.d;

public final class c
  extends a
{
  public static final a b = new a(null);
  private static final c c = new c(1, 0);
  
  public c(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public boolean e()
  {
    return a() > b();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      if ((!e()) || (!((c)paramObject).e()))
      {
        int i = a();
        paramObject = (c)paramObject;
        if ((i != ((c)paramObject).a()) || (b() != ((c)paramObject).b())) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public Integer f()
  {
    return Integer.valueOf(a());
  }
  
  public Integer g()
  {
    return Integer.valueOf(b());
  }
  
  public int hashCode()
  {
    if (e()) {
      return -1;
    }
    return a() * 31 + b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("..");
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final c a()
    {
      return c.h();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */