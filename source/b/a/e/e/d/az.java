package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.v;
import b.a.w;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class az<T, R>
  extends a<T, R>
{
  final h<? super T, ? extends w<? extends R>> b;
  final boolean c;
  
  public az(q<T> paramq, h<? super T, ? extends w<? extends R>> paramh, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramBoolean;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    this.a.subscribe(new a(params, this.b, this.c));
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    final s<? super R> actual;
    volatile boolean cancelled;
    b.a.b.b d;
    final boolean delayErrors;
    final b.a.e.j.c errors;
    final h<? super T, ? extends w<? extends R>> mapper;
    final AtomicReference<b.a.e.f.c<R>> queue;
    final b.a.b.a set;
    
    a(s<? super R> params, h<? super T, ? extends w<? extends R>> paramh, boolean paramBoolean)
    {
      this.actual = params;
      this.mapper = paramh;
      this.delayErrors = paramBoolean;
      this.set = new b.a.b.a();
      this.errors = new b.a.e.j.c();
      this.active = new AtomicInteger(1);
      this.queue = new AtomicReference();
    }
    
    void clear()
    {
      b.a.e.f.c localc = (b.a.e.f.c)this.queue.get();
      if (localc != null) {
        localc.clear();
      }
    }
    
    public void dispose()
    {
      this.cancelled = true;
      this.d.dispose();
      this.set.dispose();
    }
    
    void drain()
    {
      if (getAndIncrement() == 0) {
        drainLoop();
      }
    }
    
    void drainLoop()
    {
      s locals = this.actual;
      AtomicInteger localAtomicInteger = this.active;
      AtomicReference localAtomicReference = this.queue;
      int i = 1;
      for (;;)
      {
        if (this.cancelled)
        {
          clear();
          return;
        }
        if ((!this.delayErrors) && ((Throwable)this.errors.get() != null))
        {
          localObject = this.errors.terminate();
          clear();
          locals.onError((Throwable)localObject);
          return;
        }
        int j = localAtomicInteger.get();
        int k = 0;
        if (j == 0) {
          j = 1;
        } else {
          j = 0;
        }
        Object localObject = (b.a.e.f.c)localAtomicReference.get();
        if (localObject != null) {
          localObject = ((b.a.e.f.c)localObject).poll();
        } else {
          localObject = null;
        }
        if (localObject == null) {
          k = 1;
        }
        if ((j != 0) && (k != 0))
        {
          localObject = this.errors.terminate();
          if (localObject != null)
          {
            locals.onError((Throwable)localObject);
            return;
          }
          locals.onComplete();
          return;
        }
        if (k != 0)
        {
          j = addAndGet(-i);
          i = j;
          if (j != 0) {}
        }
        else
        {
          locals.onNext(localObject);
        }
      }
    }
    
    b.a.e.f.c<R> getOrCreateQueue()
    {
      b.a.e.f.c localc;
      do
      {
        localc = (b.a.e.f.c)this.queue.get();
        if (localc != null) {
          return localc;
        }
        localc = new b.a.e.f.c(l.bufferSize());
      } while (!this.queue.compareAndSet(null, localc));
      return localc;
    }
    
    void innerError(a<T, R>.a parama, Throwable paramThrowable)
    {
      this.set.c(parama);
      if (this.errors.addThrowable(paramThrowable))
      {
        if (!this.delayErrors)
        {
          this.d.dispose();
          this.set.dispose();
        }
        this.active.decrementAndGet();
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    void innerSuccess(a<T, R>.a arg1, R paramR)
    {
      this.set.c(???);
      if (get() == 0)
      {
        int i = 1;
        if (compareAndSet(0, 1))
        {
          this.actual.onNext(paramR);
          if (this.active.decrementAndGet() != 0) {
            i = 0;
          }
          ??? = (b.a.e.f.c)this.queue.get();
          if ((i != 0) && ((??? == null) || (???.isEmpty())))
          {
            ??? = this.errors.terminate();
            if (??? != null)
            {
              this.actual.onError(???);
              return;
            }
            this.actual.onComplete();
            return;
          }
          if (decrementAndGet() != 0) {
            break label150;
          }
          return;
        }
      }
      synchronized (getOrCreateQueue())
      {
        ???.offer(paramR);
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
          return;
        }
        label150:
        drainLoop();
        return;
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      this.active.decrementAndGet();
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.active.decrementAndGet();
      if (this.errors.addThrowable(paramThrowable))
      {
        if (!this.delayErrors) {
          this.set.dispose();
        }
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      try
      {
        paramT = (w)b.a.e.b.b.a(this.mapper.apply(paramT), "The mapper returned a null SingleSource");
        this.active.getAndIncrement();
        a locala = new a();
        if ((!this.cancelled) && (this.set.a(locala))) {
          paramT.a(locala);
        }
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.d.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.actual.onSubscribe(this);
      }
    }
    
    final class a
      extends AtomicReference<b.a.b.b>
      implements b.a.b.b, v<R>
    {
      private static final long serialVersionUID = -502562646270949838L;
      
      a() {}
      
      public void dispose()
      {
        d.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return d.isDisposed((b.a.b.b)get());
      }
      
      public void onError(Throwable paramThrowable)
      {
        az.a.this.innerError(this, paramThrowable);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        d.setOnce(this, paramb);
      }
      
      public void onSuccess(R paramR)
      {
        az.a.this.innerSuccess(this, paramR);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */