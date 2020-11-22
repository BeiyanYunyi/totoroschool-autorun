package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.a.e;
import b.a.q;
import b.a.s;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class l<T, U extends Collection<? super T>>
  extends a<T, U>
{
  final int b;
  final int c;
  final Callable<U> d;
  
  public l(q<T> paramq, int paramInt1, int paramInt2, Callable<U> paramCallable)
  {
    super(paramq);
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramCallable;
  }
  
  protected void subscribeActual(s<? super U> params)
  {
    if (this.c == this.b)
    {
      params = new a(params, this.b, this.d);
      if (params.a()) {
        this.a.subscribe(params);
      }
    }
    else
    {
      this.a.subscribe(new b(params, this.b, this.c, this.d));
    }
  }
  
  static final class a<T, U extends Collection<? super T>>
    implements b.a.b.b, s<T>
  {
    final s<? super U> a;
    final int b;
    final Callable<U> c;
    U d;
    int e;
    b.a.b.b f;
    
    a(s<? super U> params, int paramInt, Callable<U> paramCallable)
    {
      this.a = params;
      this.b = paramInt;
      this.c = paramCallable;
    }
    
    boolean a()
    {
      try
      {
        Collection localCollection = (Collection)b.a.e.b.b.a(this.c.call(), "Empty buffer supplied");
        this.d = localCollection;
        return true;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.d = null;
        if (this.f == null)
        {
          e.error(localThrowable, this.a);
        }
        else
        {
          this.f.dispose();
          this.a.onError(localThrowable);
        }
      }
      return false;
    }
    
    public void dispose()
    {
      this.f.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      Collection localCollection = this.d;
      if (localCollection != null)
      {
        this.d = null;
        if (!localCollection.isEmpty()) {
          this.a.onNext(localCollection);
        }
        this.a.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.d = null;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      Collection localCollection = this.d;
      if (localCollection != null)
      {
        localCollection.add(paramT);
        int i = this.e + 1;
        this.e = i;
        if (i >= this.b)
        {
          this.a.onNext(localCollection);
          this.e = 0;
          a();
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.f, paramb))
      {
        this.f = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
  
  static final class b<T, U extends Collection<? super T>>
    extends AtomicBoolean
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = -8223395059921494546L;
    final s<? super U> actual;
    final Callable<U> bufferSupplier;
    final ArrayDeque<U> buffers;
    final int count;
    long index;
    b.a.b.b s;
    final int skip;
    
    b(s<? super U> params, int paramInt1, int paramInt2, Callable<U> paramCallable)
    {
      this.actual = params;
      this.count = paramInt1;
      this.skip = paramInt2;
      this.bufferSupplier = paramCallable;
      this.buffers = new ArrayDeque();
    }
    
    public void dispose()
    {
      this.s.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.s.isDisposed();
    }
    
    public void onComplete()
    {
      while (!this.buffers.isEmpty()) {
        this.actual.onNext(this.buffers.poll());
      }
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.buffers.clear();
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l = this.index;
      this.index = (1L + l);
      if (l % this.skip == 0L) {
        try
        {
          localObject = (Collection)b.a.e.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
          this.buffers.offer(localObject);
        }
        catch (Throwable paramT)
        {
          this.buffers.clear();
          this.s.dispose();
          this.actual.onError(paramT);
          return;
        }
      }
      Object localObject = this.buffers.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Collection localCollection = (Collection)((Iterator)localObject).next();
        localCollection.add(paramT);
        if (this.count <= localCollection.size())
        {
          ((Iterator)localObject).remove();
          this.actual.onNext(localCollection);
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */