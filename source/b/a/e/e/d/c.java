package b.a.e.e.d;

import b.a.e.j.e;
import b.a.e.j.j;
import b.a.h.a;
import b.a.k;
import b.a.l;
import b.a.q;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T>
  implements Iterable<T>
{
  final q<T> a;
  
  public c(q<T> paramq)
  {
    this.a = paramq;
  }
  
  public Iterator<T> iterator()
  {
    a locala = new a();
    l.wrap(this.a).materialize().subscribe(locala);
    return locala;
  }
  
  static final class a<T>
    extends b.a.g.c<k<T>>
    implements Iterator<T>
  {
    k<T> a;
    final Semaphore b = new Semaphore(0);
    final AtomicReference<k<T>> c = new AtomicReference();
    
    public void a(k<T> paramk)
    {
      int i;
      if (this.c.getAndSet(paramk) == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        this.b.release();
      }
    }
    
    public boolean hasNext()
    {
      if ((this.a != null) && (this.a.b())) {
        throw j.a(this.a.e());
      }
      if (this.a == null) {
        try
        {
          e.a();
          this.b.acquire();
          k localk = (k)this.c.getAndSet(null);
          this.a = localk;
          if (localk.b()) {
            throw j.a(localk.e());
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          dispose();
          this.a = k.a(localInterruptedException);
          throw j.a(localInterruptedException);
        }
      }
      return this.a.c();
    }
    
    public T next()
    {
      if (hasNext())
      {
        Object localObject = this.a.d();
        this.a = null;
        return (T)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      a.a(paramThrowable);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read-only iterator.");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */