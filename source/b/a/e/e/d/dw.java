package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.g;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class dw<T, U, V>
  extends a<T, T>
{
  final q<U> b;
  final h<? super T, ? extends q<V>> c;
  final q<? extends T> d;
  
  public dw(l<T> paraml, q<U> paramq, h<? super T, ? extends q<V>> paramh, q<? extends T> paramq1)
  {
    super(paraml);
    this.b = paramq;
    this.c = paramh;
    this.d = paramq1;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    if (this.d == null)
    {
      localObject = new c(params, this.c);
      params.onSubscribe((b.a.b.b)localObject);
      ((c)localObject).startFirstTimeout(this.b);
      this.a.subscribe((s)localObject);
      return;
    }
    Object localObject = new b(params, this.c, this.d);
    params.onSubscribe((b.a.b.b)localObject);
    ((b)localObject).startFirstTimeout(this.b);
    this.a.subscribe((s)localObject);
  }
  
  static final class a
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, s<Object>
  {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final dw.d parent;
    
    a(long paramLong, dw.d paramd)
    {
      this.idx = paramLong;
      this.parent = paramd;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)get());
    }
    
    public void onComplete()
    {
      if (get() != d.DISPOSED)
      {
        lazySet(d.DISPOSED);
        this.parent.onTimeout(this.idx);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (get() != d.DISPOSED)
      {
        lazySet(d.DISPOSED);
        this.parent.onTimeoutError(this.idx, paramThrowable);
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      paramObject = (b.a.b.b)get();
      if (paramObject != d.DISPOSED)
      {
        ((b.a.b.b)paramObject).dispose();
        lazySet(d.DISPOSED);
        this.parent.onTimeout(this.idx);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
  
  static final class b<T>
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, dw.d, s<T>
  {
    private static final long serialVersionUID = -7508389464265974549L;
    final s<? super T> actual;
    q<? extends T> fallback;
    final AtomicLong index;
    final h<? super T, ? extends q<?>> itemTimeoutIndicator;
    final g task;
    final AtomicReference<b.a.b.b> upstream;
    
    b(s<? super T> params, h<? super T, ? extends q<?>> paramh, q<? extends T> paramq)
    {
      this.actual = params;
      this.itemTimeoutIndicator = paramh;
      this.task = new g();
      this.fallback = paramq;
      this.index = new AtomicLong();
      this.upstream = new AtomicReference();
    }
    
    public void dispose()
    {
      d.dispose(this.upstream);
      d.dispose(this);
      this.task.dispose();
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)get());
    }
    
    public void onComplete()
    {
      if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onComplete();
        this.task.dispose();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onError(paramThrowable);
        this.task.dispose();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l1 = this.index.get();
      if (l1 != Long.MAX_VALUE)
      {
        Object localObject = this.index;
        long l2 = 1L + l1;
        if (!((AtomicLong)localObject).compareAndSet(l1, l2)) {
          return;
        }
        localObject = (b.a.b.b)this.task.get();
        if (localObject != null) {
          ((b.a.b.b)localObject).dispose();
        }
        this.actual.onNext(paramT);
        try
        {
          paramT = (q)b.a.e.b.b.a(this.itemTimeoutIndicator.apply(paramT), "The itemTimeoutIndicator returned a null ObservableSource.");
          localObject = new dw.a(l2, this);
          if (this.task.replace((b.a.b.b)localObject)) {
            paramT.subscribe((s)localObject);
          }
          return;
        }
        catch (Throwable paramT)
        {
          b.a.c.b.b(paramT);
          ((b.a.b.b)this.upstream.get()).dispose();
          this.index.getAndSet(Long.MAX_VALUE);
          this.actual.onError(paramT);
          return;
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this.upstream, paramb);
    }
    
    public void onTimeout(long paramLong)
    {
      if (this.index.compareAndSet(paramLong, Long.MAX_VALUE))
      {
        d.dispose(this.upstream);
        q localq = this.fallback;
        this.fallback = null;
        localq.subscribe(new dx.a(this.actual, this));
      }
    }
    
    public void onTimeoutError(long paramLong, Throwable paramThrowable)
    {
      if (this.index.compareAndSet(paramLong, Long.MAX_VALUE))
      {
        d.dispose(this);
        this.actual.onError(paramThrowable);
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    void startFirstTimeout(q<?> paramq)
    {
      if (paramq != null)
      {
        dw.a locala = new dw.a(0L, this);
        if (this.task.replace(locala)) {
          paramq.subscribe(locala);
        }
      }
    }
  }
  
  static final class c<T>
    extends AtomicLong
    implements b.a.b.b, dw.d, s<T>
  {
    private static final long serialVersionUID = 3764492702657003550L;
    final s<? super T> actual;
    final h<? super T, ? extends q<?>> itemTimeoutIndicator;
    final g task;
    final AtomicReference<b.a.b.b> upstream;
    
    c(s<? super T> params, h<? super T, ? extends q<?>> paramh)
    {
      this.actual = params;
      this.itemTimeoutIndicator = paramh;
      this.task = new g();
      this.upstream = new AtomicReference();
    }
    
    public void dispose()
    {
      d.dispose(this.upstream);
      this.task.dispose();
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)this.upstream.get());
    }
    
    public void onComplete()
    {
      if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onError(paramThrowable);
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l1 = get();
      if (l1 != Long.MAX_VALUE)
      {
        long l2 = 1L + l1;
        if (!compareAndSet(l1, l2)) {
          return;
        }
        Object localObject = (b.a.b.b)this.task.get();
        if (localObject != null) {
          ((b.a.b.b)localObject).dispose();
        }
        this.actual.onNext(paramT);
        try
        {
          paramT = (q)b.a.e.b.b.a(this.itemTimeoutIndicator.apply(paramT), "The itemTimeoutIndicator returned a null ObservableSource.");
          localObject = new dw.a(l2, this);
          if (this.task.replace((b.a.b.b)localObject)) {
            paramT.subscribe((s)localObject);
          }
          return;
        }
        catch (Throwable paramT)
        {
          b.a.c.b.b(paramT);
          ((b.a.b.b)this.upstream.get()).dispose();
          getAndSet(Long.MAX_VALUE);
          this.actual.onError(paramT);
          return;
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this.upstream, paramb);
    }
    
    public void onTimeout(long paramLong)
    {
      if (compareAndSet(paramLong, Long.MAX_VALUE))
      {
        d.dispose(this.upstream);
        this.actual.onError(new TimeoutException());
      }
    }
    
    public void onTimeoutError(long paramLong, Throwable paramThrowable)
    {
      if (compareAndSet(paramLong, Long.MAX_VALUE))
      {
        d.dispose(this.upstream);
        this.actual.onError(paramThrowable);
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    void startFirstTimeout(q<?> paramq)
    {
      if (paramq != null)
      {
        dw.a locala = new dw.a(0L, this);
        if (this.task.replace(locala)) {
          paramq.subscribe(locala);
        }
      }
    }
  }
  
  static abstract interface d
    extends dx.d
  {
    public abstract void onTimeoutError(long paramLong, Throwable paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */