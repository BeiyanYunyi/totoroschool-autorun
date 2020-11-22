package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.a.g;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class dx<T>
  extends a<T, T>
{
  final long b;
  final TimeUnit c;
  final t d;
  final q<? extends T> e;
  
  public dx(l<T> paraml, long paramLong, TimeUnit paramTimeUnit, t paramt, q<? extends T> paramq)
  {
    super(paraml);
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.d = paramt;
    this.e = paramq;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    if (this.e == null)
    {
      localObject = new c(params, this.b, this.c, this.d.a());
      params.onSubscribe((b)localObject);
      ((c)localObject).startTimeout(0L);
      this.a.subscribe((s)localObject);
      return;
    }
    Object localObject = new b(params, this.b, this.c, this.d.a(), this.e);
    params.onSubscribe((b)localObject);
    ((b)localObject).startTimeout(0L);
    this.a.subscribe((s)localObject);
  }
  
  static final class a<T>
    implements s<T>
  {
    final s<? super T> a;
    final AtomicReference<b> b;
    
    a(s<? super T> params, AtomicReference<b> paramAtomicReference)
    {
      this.a = params;
      this.b = paramAtomicReference;
    }
    
    public void onComplete()
    {
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.a.onNext(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      d.replace(this.b, paramb);
    }
  }
  
  static final class b<T>
    extends AtomicReference<b>
    implements b, dx.d, s<T>
  {
    private static final long serialVersionUID = 3764492702657003550L;
    final s<? super T> actual;
    q<? extends T> fallback;
    final AtomicLong index;
    final g task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<b> upstream;
    final t.c worker;
    
    b(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t.c paramc, q<? extends T> paramq)
    {
      this.actual = params;
      this.timeout = paramLong;
      this.unit = paramTimeUnit;
      this.worker = paramc;
      this.fallback = paramq;
      this.task = new g();
      this.index = new AtomicLong();
      this.upstream = new AtomicReference();
    }
    
    public void dispose()
    {
      d.dispose(this.upstream);
      d.dispose(this);
      this.worker.dispose();
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b)get());
    }
    
    public void onComplete()
    {
      if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onComplete();
        this.worker.dispose();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onError(paramThrowable);
        this.worker.dispose();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l1 = this.index.get();
      if (l1 != Long.MAX_VALUE)
      {
        AtomicLong localAtomicLong = this.index;
        long l2 = 1L + l1;
        if (!localAtomicLong.compareAndSet(l1, l2)) {
          return;
        }
        ((b)this.task.get()).dispose();
        this.actual.onNext(paramT);
        startTimeout(l2);
        return;
      }
    }
    
    public void onSubscribe(b paramb)
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
        this.worker.dispose();
      }
    }
    
    void startTimeout(long paramLong)
    {
      this.task.replace(this.worker.a(new dx.e(paramLong, this), this.timeout, this.unit));
    }
  }
  
  static final class c<T>
    extends AtomicLong
    implements b, dx.d, s<T>
  {
    private static final long serialVersionUID = 3764492702657003550L;
    final s<? super T> actual;
    final g task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<b> upstream;
    final t.c worker;
    
    c(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t.c paramc)
    {
      this.actual = params;
      this.timeout = paramLong;
      this.unit = paramTimeUnit;
      this.worker = paramc;
      this.task = new g();
      this.upstream = new AtomicReference();
    }
    
    public void dispose()
    {
      d.dispose(this.upstream);
      this.worker.dispose();
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b)this.upstream.get());
    }
    
    public void onComplete()
    {
      if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onComplete();
        this.worker.dispose();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.task.dispose();
        this.actual.onError(paramThrowable);
        this.worker.dispose();
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
        ((b)this.task.get()).dispose();
        this.actual.onNext(paramT);
        startTimeout(l2);
        return;
      }
    }
    
    public void onSubscribe(b paramb)
    {
      d.setOnce(this.upstream, paramb);
    }
    
    public void onTimeout(long paramLong)
    {
      if (compareAndSet(paramLong, Long.MAX_VALUE))
      {
        d.dispose(this.upstream);
        this.actual.onError(new TimeoutException());
        this.worker.dispose();
      }
    }
    
    void startTimeout(long paramLong)
    {
      this.task.replace(this.worker.a(new dx.e(paramLong, this), this.timeout, this.unit));
    }
  }
  
  static abstract interface d
  {
    public abstract void onTimeout(long paramLong);
  }
  
  static final class e
    implements Runnable
  {
    final dx.d a;
    final long b;
    
    e(long paramLong, dx.d paramd)
    {
      this.b = paramLong;
      this.a = paramd;
    }
    
    public void run()
    {
      this.a.onTimeout(this.b);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */