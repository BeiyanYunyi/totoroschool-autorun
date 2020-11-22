package b.a.e.e.d;

import b.a.e.a.e;
import b.a.e.d.c;
import b.a.l;
import b.a.s;
import java.util.Iterator;

public final class be<T>
  extends l<T>
{
  final Iterable<? extends T> a;
  
  public be(Iterable<? extends T> paramIterable)
  {
    this.a = paramIterable;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    try
    {
      Object localObject = this.a.iterator();
      try
      {
        boolean bool = ((Iterator)localObject).hasNext();
        if (!bool)
        {
          e.complete(params);
          return;
        }
        localObject = new a(params, (Iterator)localObject);
        params.onSubscribe((b.a.b.b)localObject);
        if (!((a)localObject).d) {
          ((a)localObject).a();
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        b.a.c.b.b(localThrowable1);
        e.error(localThrowable1, params);
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      b.a.c.b.b(localThrowable2);
      e.error(localThrowable2, params);
    }
  }
  
  static final class a<T>
    extends c<T>
  {
    final s<? super T> a;
    final Iterator<? extends T> b;
    volatile boolean c;
    boolean d;
    boolean e;
    boolean f;
    
    a(s<? super T> params, Iterator<? extends T> paramIterator)
    {
      this.a = params;
      this.b = paramIterator;
    }
    
    void a()
    {
      for (;;)
      {
        if (isDisposed()) {
          return;
        }
        try
        {
          Object localObject = b.a.e.b.b.a(this.b.next(), "The iterator returned a null value");
          this.a.onNext(localObject);
          if (isDisposed()) {
            return;
          }
          try
          {
            boolean bool = this.b.hasNext();
            if (bool) {
              continue;
            }
            if (!isDisposed()) {
              this.a.onComplete();
            }
            return;
          }
          catch (Throwable localThrowable1)
          {
            b.a.c.b.b(localThrowable1);
            this.a.onError(localThrowable1);
            return;
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          b.a.c.b.b(localThrowable2);
          this.a.onError(localThrowable2);
        }
      }
    }
    
    public void clear()
    {
      this.e = true;
    }
    
    public void dispose()
    {
      this.c = true;
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public boolean isEmpty()
    {
      return this.e;
    }
    
    public T poll()
    {
      if (this.e) {
        return null;
      }
      if (this.f)
      {
        if (!this.b.hasNext())
        {
          this.e = true;
          return null;
        }
      }
      else {
        this.f = true;
      }
      return (T)b.a.e.b.b.a(this.b.next(), "The iterator returned a null value");
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        this.d = true;
        return 1;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */