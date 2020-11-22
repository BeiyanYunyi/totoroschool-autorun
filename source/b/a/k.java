package b.a;

import b.a.e.b.b;
import b.a.e.j.n;

public final class k<T>
{
  static final k<Object> b = new k(null);
  final Object a;
  
  private k(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public static <T> k<T> a(T paramT)
  {
    b.a(paramT, "value is null");
    return new k(paramT);
  }
  
  public static <T> k<T> a(Throwable paramThrowable)
  {
    b.a(paramThrowable, "error is null");
    return new k(n.error(paramThrowable));
  }
  
  public static <T> k<T> f()
  {
    return b;
  }
  
  public boolean a()
  {
    return this.a == null;
  }
  
  public boolean b()
  {
    return n.isError(this.a);
  }
  
  public boolean c()
  {
    Object localObject = this.a;
    return (localObject != null) && (!n.isError(localObject));
  }
  
  public T d()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!n.isError(localObject))) {
      return (T)this.a;
    }
    return null;
  }
  
  public Throwable e()
  {
    Object localObject = this.a;
    if (n.isError(localObject)) {
      return n.getError(localObject);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof k))
    {
      paramObject = (k)paramObject;
      return b.a(this.a, ((k)paramObject).a);
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return "OnCompleteNotification";
    }
    if (n.isError(localObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnErrorNotification[");
      localStringBuilder.append(n.getError(localObject));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnNextNotification[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */