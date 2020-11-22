package d.c.b;

import d.c.a;
import java.lang.annotation.Annotation;
import java.util.List;

public final class c
  implements b, d.e.c<Object>
{
  private final Class<?> a;
  
  public c(Class<?> paramClass)
  {
    this.a = paramClass;
  }
  
  private final Void b()
  {
    throw ((Throwable)new d.c.b());
  }
  
  public Class<?> a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof c)) && (h.a(a.a(this), a.a((d.e.c)paramObject)));
  }
  
  public List<Annotation> getAnnotations()
  {
    b();
    throw null;
  }
  
  public int hashCode()
  {
    return a.a(this).hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a().toString());
    localStringBuilder.append(" (Kotlin reflection is not available)");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */