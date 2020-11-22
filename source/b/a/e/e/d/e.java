package b.a.e.e.d;

import b.a.e.j.j;
import b.a.g.c;
import b.a.h.a;
import b.a.k;
import b.a.q;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class e<T>
  implements Iterable<T>
{
  final q<T> a;
  
  public e(q<T> paramq)
  {
    this.a = paramq;
  }
  
  public Iterator<T> iterator()
  {
    b localb = new b();
    return new a(this.a, localb);
  }
  
  static final class a<T>
    implements Iterator<T>
  {
    private final e.b<T> a;
    private final q<T> b;
    private T c;
    private boolean d = true;
    private boolean e = true;
    private Throwable f;
    private boolean g;
    
    a(q<T> paramq, e.b<T> paramb)
    {
      this.b = paramq;
      this.a = paramb;
    }
    
    private boolean a()
    {
      if (!this.g)
      {
        this.g = true;
        this.a.b();
        new bx(this.b).subscribe(this.a);
      }
      try
      {
        k localk = this.a.a();
        if (localk.c())
        {
          this.e = false;
          this.c = localk.d();
          return true;
        }
        this.d = false;
        if (localk.a()) {
          return false;
        }
        this.f = localk.e();
        throw j.a(this.f);
      }
      catch (InterruptedException localInterruptedException)
      {
        this.a.dispose();
        this.f = localInterruptedException;
        throw j.a(localInterruptedException);
      }
    }
    
    public boolean hasNext()
    {
      if (this.f == null)
      {
        boolean bool2 = this.d;
        boolean bool1 = false;
        if (!bool2) {
          return false;
        }
        if ((!this.e) || (a())) {
          bool1 = true;
        }
        return bool1;
      }
      throw j.a(this.f);
    }
    
    public T next()
    {
      if (this.f == null)
      {
        if (hasNext())
        {
          this.e = true;
          return (T)this.c;
        }
        throw new NoSuchElementException("No more elements");
      }
      throw j.a(this.f);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read only iterator");
    }
  }
  
  static final class b<T>
    extends c<k<T>>
  {
    final AtomicInteger a = new AtomicInteger();
    private final BlockingQueue<k<T>> b = new ArrayBlockingQueue(1);
    
    public k<T> a()
      throws InterruptedException
    {
      b();
      b.a.e.j.e.a();
      return (k)this.b.take();
    }
    
    public void a(k<T> paramk)
    {
      k<T> localk = paramk;
      if (this.a.getAndSet(0) != 1)
      {
        if (paramk.c()) {}
      }
      else {
        for (localk = paramk; !this.b.offer(localk); localk = paramk)
        {
          label23:
          paramk = (k)this.b.poll();
          if ((paramk == null) || (paramk.c())) {
            break label23;
          }
        }
      }
    }
    
    void b()
    {
      this.a.set(1);
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      a.a(paramThrowable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */