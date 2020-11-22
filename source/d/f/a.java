package d.f;

import d.c.b.h;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T>
  implements b<T>
{
  private final d.c.a.a<T> a;
  private final d.c.a.b<T, T> b;
  
  public a(d.c.a.a<? extends T> parama, d.c.a.b<? super T, ? extends T> paramb)
  {
    this.a = parama;
    this.b = paramb;
  }
  
  public Iterator<T> a()
  {
    return (Iterator)new a(this);
  }
  
  public static final class a
    implements Iterator<T>
  {
    private T b;
    private int c = -2;
    
    private final void a()
    {
      Object localObject1;
      if (this.c == -2)
      {
        localObject1 = a.a(this.a).invoke();
      }
      else
      {
        localObject1 = a.b(this.a);
        Object localObject2 = this.b;
        if (localObject2 == null) {
          h.a();
        }
        localObject1 = ((d.c.a.b)localObject1).invoke(localObject2);
      }
      this.b = localObject1;
      int i;
      if (this.b == null) {
        i = 0;
      } else {
        i = 1;
      }
      this.c = i;
    }
    
    public boolean hasNext()
    {
      if (this.c < 0) {
        a();
      }
      return this.c == 1;
    }
    
    public T next()
    {
      if (this.c < 0) {
        a();
      }
      if (this.c != 0)
      {
        Object localObject = this.b;
        if (localObject != null)
        {
          this.c = -1;
          return (T)localObject;
        }
        throw new d.b("null cannot be cast to non-null type T");
      }
      throw ((Throwable)new NoSuchElementException());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */