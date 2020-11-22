package b.a.e.j;

import b.a.s;
import java.io.Serializable;
import org.a.c;

public enum n
{
  private n() {}
  
  public static <T> boolean accept(Object paramObject, s<? super T> params)
  {
    if (paramObject == COMPLETE)
    {
      params.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      params.onError(((b)paramObject).e);
      return true;
    }
    params.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean accept(Object paramObject, org.a.b<? super T> paramb)
  {
    if (paramObject == COMPLETE)
    {
      paramb.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramb.onError(((b)paramObject).e);
      return true;
    }
    paramb.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, s<? super T> params)
  {
    if (paramObject == COMPLETE)
    {
      params.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      params.onError(((b)paramObject).e);
      return true;
    }
    if ((paramObject instanceof a))
    {
      params.onSubscribe(((a)paramObject).d);
      return false;
    }
    params.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, org.a.b<? super T> paramb)
  {
    if (paramObject == COMPLETE)
    {
      paramb.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramb.onError(((b)paramObject).e);
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramb.onSubscribe(((c)paramObject).s);
      return false;
    }
    paramb.onNext(paramObject);
    return false;
  }
  
  public static Object complete()
  {
    return COMPLETE;
  }
  
  public static Object disposable(b.a.b.b paramb)
  {
    return new a(paramb);
  }
  
  public static Object error(Throwable paramThrowable)
  {
    return new b(paramThrowable);
  }
  
  public static b.a.b.b getDisposable(Object paramObject)
  {
    return ((a)paramObject).d;
  }
  
  public static Throwable getError(Object paramObject)
  {
    return ((b)paramObject).e;
  }
  
  public static c getSubscription(Object paramObject)
  {
    return ((c)paramObject).s;
  }
  
  public static <T> T getValue(Object paramObject)
  {
    return (T)paramObject;
  }
  
  public static boolean isComplete(Object paramObject)
  {
    return paramObject == COMPLETE;
  }
  
  public static boolean isDisposable(Object paramObject)
  {
    return paramObject instanceof a;
  }
  
  public static boolean isError(Object paramObject)
  {
    return paramObject instanceof b;
  }
  
  public static boolean isSubscription(Object paramObject)
  {
    return paramObject instanceof c;
  }
  
  public static <T> Object next(T paramT)
  {
    return paramT;
  }
  
  public static Object subscription(c paramc)
  {
    return new c(paramc);
  }
  
  public String toString()
  {
    return "NotificationLite.Complete";
  }
  
  static final class a
    implements Serializable
  {
    private static final long serialVersionUID = -7482590109178395495L;
    final b.a.b.b d;
    
    a(b.a.b.b paramb)
    {
      this.d = paramb;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationLite.Disposable[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    implements Serializable
  {
    private static final long serialVersionUID = -8759979445933046293L;
    final Throwable e;
    
    b(Throwable paramThrowable)
    {
      this.e = paramThrowable;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        return b.a.e.b.b.a(this.e, ((b)paramObject).e);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.e.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationLite.Error[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    implements Serializable
  {
    private static final long serialVersionUID = -1322257508628817540L;
    final c s;
    
    c(c paramc)
    {
      this.s = paramc;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationLite.Subscription[");
      localStringBuilder.append(this.s);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */