package b.a.e.f;

import b.a.e.c.f;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
  implements f<T>
{
  private final AtomicReference<a<T>> a = new AtomicReference();
  private final AtomicReference<a<T>> b = new AtomicReference();
  
  public a()
  {
    a locala = new a();
    b(locala);
    a(locala);
  }
  
  a<T> a()
  {
    return (a)this.a.get();
  }
  
  a<T> a(a<T> parama)
  {
    return (a)this.a.getAndSet(parama);
  }
  
  a<T> b()
  {
    return (a)this.b.get();
  }
  
  void b(a<T> parama)
  {
    this.b.lazySet(parama);
  }
  
  a<T> c()
  {
    return (a)this.b.get();
  }
  
  public void clear()
  {
    while ((poll() != null) && (!isEmpty())) {}
  }
  
  public boolean isEmpty()
  {
    return b() == a();
  }
  
  public boolean offer(T paramT)
  {
    if (paramT != null)
    {
      paramT = new a(paramT);
      a(paramT).soNext(paramT);
      return true;
    }
    throw new NullPointerException("Null is not a valid element");
  }
  
  public T poll()
  {
    Object localObject = c();
    a locala = ((a)localObject).lvNext();
    if (locala != null)
    {
      localObject = locala.getAndNullValue();
      b(locala);
      return (T)localObject;
    }
    if (localObject != a())
    {
      do
      {
        locala = ((a)localObject).lvNext();
      } while (locala == null);
      localObject = locala.getAndNullValue();
      b(locala);
      return (T)localObject;
    }
    return null;
  }
  
  static final class a<E>
    extends AtomicReference<a<E>>
  {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;
    
    a() {}
    
    a(E paramE)
    {
      spValue(paramE);
    }
    
    public E getAndNullValue()
    {
      Object localObject = lpValue();
      spValue(null);
      return (E)localObject;
    }
    
    public E lpValue()
    {
      return (E)this.value;
    }
    
    public a<E> lvNext()
    {
      return (a)get();
    }
    
    public void soNext(a<E> parama)
    {
      lazySet(parama);
    }
    
    public void spValue(E paramE)
    {
      this.value = paramE;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */