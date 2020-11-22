package b.a.i;

import java.util.concurrent.TimeUnit;

public final class b<T>
{
  final T a;
  final long b;
  final TimeUnit c;
  
  public b(T paramT, long paramLong, TimeUnit paramTimeUnit)
  {
    this.a = paramT;
    this.b = paramLong;
    this.c = ((TimeUnit)b.a.e.b.b.a(paramTimeUnit, "unit is null"));
  }
  
  public T a()
  {
    return (T)this.a;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof b;
    boolean bool2 = false;
    if (bool1)
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (b.a.e.b.b.a(this.a, ((b)paramObject).a))
      {
        bool1 = bool2;
        if (this.b == ((b)paramObject).b)
        {
          bool1 = bool2;
          if (b.a.e.b.b.a(this.c, ((b)paramObject).c)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i;
    if (this.a != null) {
      i = this.a.hashCode();
    } else {
      i = 0;
    }
    return (i * 31 + (int)(this.b >>> 31 ^ this.b)) * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Timed[time=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", unit=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */