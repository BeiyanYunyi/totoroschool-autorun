package b.a.e.e.d;

import b.a.e.j.j;
import b.a.e.j.n;
import b.a.g.b;
import b.a.q;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d<T>
  implements Iterable<T>
{
  final q<T> a;
  final T b;
  
  public d(q<T> paramq, T paramT)
  {
    this.a = paramq;
    this.b = paramT;
  }
  
  public Iterator<T> iterator()
  {
    a locala = new a(this.b);
    this.a.subscribe(locala);
    return locala.a();
  }
  
  static final class a<T>
    extends b<T>
  {
    volatile Object a;
    
    a(T paramT)
    {
      this.a = n.next(paramT);
    }
    
    public a<T>.a a()
    {
      return new a();
    }
    
    public void onComplete()
    {
      this.a = n.complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a = n.error(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.a = n.next(paramT);
    }
    
    final class a
      implements Iterator<T>
    {
      private Object b;
      
      a() {}
      
      public boolean hasNext()
      {
        this.b = d.a.this.a;
        return n.isComplete(this.b) ^ true;
      }
      
      public T next()
      {
        try
        {
          if (this.b == null) {
            this.b = d.a.this.a;
          }
          if (!n.isComplete(this.b))
          {
            if (!n.isError(this.b))
            {
              Object localObject1 = n.getValue(this.b);
              return (T)localObject1;
            }
            throw j.a(n.getError(this.b));
          }
          throw new NoSuchElementException();
        }
        finally
        {
          this.b = null;
        }
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Read only iterator");
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */