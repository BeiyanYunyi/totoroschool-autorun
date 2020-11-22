package d.d;

import d.a.o;

public class a
  implements Iterable<Integer>
{
  public static final a a = new a(null);
  private final int b;
  private final int c;
  private final int d;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 != Integer.MIN_VALUE)
      {
        this.b = paramInt1;
        this.c = d.b.a.a(paramInt1, paramInt2, paramInt3);
        this.d = paramInt3;
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation."));
    }
    throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public o d()
  {
    return (o)new b(this.b, this.c, this.d);
  }
  
  public boolean e()
  {
    if (this.d > 0)
    {
      if (this.b <= this.c) {}
    }
    else {
      while (this.b < this.c) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      if ((!e()) || (!((a)paramObject).e()))
      {
        int i = this.b;
        paramObject = (a)paramObject;
        if ((i != ((a)paramObject).b) || (this.c != ((a)paramObject).c) || (this.d != ((a)paramObject).d)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    if (e()) {
      return -1;
    }
    return (this.b * 31 + this.c) * 31 + this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    if (this.d > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("..");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" step ");
    }
    for (int i = this.d;; i = -this.d)
    {
      localStringBuilder.append(i);
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" step ");
    }
  }
  
  public static final class a
  {
    public final a a(int paramInt1, int paramInt2, int paramInt3)
    {
      return new a(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */