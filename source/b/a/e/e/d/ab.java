package b.a.e.e.d;

import b.a.d.f;
import b.a.e.a.d;
import b.a.e.c.g;
import b.a.h.a;
import b.a.l;
import b.a.n;
import b.a.o;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ab<T>
  extends l<T>
{
  final o<T> a;
  
  public ab(o<T> paramo)
  {
    this.a = paramo;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    a locala = new a(params);
    params.onSubscribe(locala);
    try
    {
      this.a.a(locala);
      return;
    }
    catch (Throwable params)
    {
      b.a.c.b.b(params);
      locala.onError(params);
    }
  }
  
  static final class a<T>
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, n<T>
  {
    private static final long serialVersionUID = -3434801548987643227L;
    final s<? super T> observer;
    
    a(s<? super T> params)
    {
      this.observer = params;
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
      if (!isDisposed()) {
        try
        {
          this.observer.onComplete();
          return;
        }
        finally
        {
          dispose();
        }
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!tryOnError(paramThrowable)) {
        a.a(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (paramT == null)
      {
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
      }
      if (!isDisposed()) {
        this.observer.onNext(paramT);
      }
    }
    
    public n<T> serialize()
    {
      return new ab.b(this);
    }
    
    public void setCancellable(f paramf)
    {
      setDisposable(new b.a.e.a.b(paramf));
    }
    
    public void setDisposable(b.a.b.b paramb)
    {
      d.set(this, paramb);
    }
    
    public String toString()
    {
      return String.format("%s{%s}", new Object[] { getClass().getSimpleName(), super.toString() });
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      Object localObject = paramThrowable;
      if (paramThrowable == null) {
        localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
      }
      if (!isDisposed()) {
        try
        {
          this.observer.onError((Throwable)localObject);
          return true;
        }
        finally
        {
          dispose();
        }
      }
      return false;
    }
  }
  
  static final class b<T>
    extends AtomicInteger
    implements n<T>
  {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final n<T> emitter;
    final b.a.e.j.c error;
    final b.a.e.f.c<T> queue;
    
    b(n<T> paramn)
    {
      this.emitter = paramn;
      this.error = new b.a.e.j.c();
      this.queue = new b.a.e.f.c(16);
    }
    
    void drain()
    {
      if (getAndIncrement() == 0) {
        drainLoop();
      }
    }
    
    void drainLoop()
    {
      n localn = this.emitter;
      b.a.e.f.c localc = this.queue;
      b.a.e.j.c localc1 = this.error;
      int i = 1;
      for (;;)
      {
        if (localn.isDisposed())
        {
          localc.clear();
          return;
        }
        if (localc1.get() != null)
        {
          localc.clear();
          localn.onError(localc1.terminate());
          return;
        }
        boolean bool = this.done;
        Object localObject = localc.poll();
        int j;
        if (localObject == null) {
          j = 1;
        } else {
          j = 0;
        }
        if ((bool) && (j != 0))
        {
          localn.onComplete();
          return;
        }
        if (j != 0)
        {
          j = addAndGet(-i);
          i = j;
          if (j != 0) {}
        }
        else
        {
          localn.onNext(localObject);
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.emitter.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.emitter.isDisposed())
      {
        if (this.done) {
          return;
        }
        this.done = true;
        drain();
        return;
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!tryOnError(paramThrowable)) {
        a.a(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (!this.emitter.isDisposed())
      {
        if (this.done) {
          return;
        }
        if (paramT == null)
        {
          onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
          return;
        }
        if ((get() == 0) && (compareAndSet(0, 1)))
        {
          this.emitter.onNext(paramT);
          if (decrementAndGet() != 0) {
            break label97;
          }
        }
        synchronized (this.queue)
        {
          ???.offer(paramT);
          if (getAndIncrement() != 0) {
            return;
          }
          label97:
          drainLoop();
          return;
        }
      }
    }
    
    public n<T> serialize()
    {
      return this;
    }
    
    public void setCancellable(f paramf)
    {
      this.emitter.setCancellable(paramf);
    }
    
    public void setDisposable(b.a.b.b paramb)
    {
      this.emitter.setDisposable(paramb);
    }
    
    public String toString()
    {
      return this.emitter.toString();
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      if (!this.emitter.isDisposed())
      {
        if (this.done) {
          return false;
        }
        Object localObject = paramThrowable;
        if (paramThrowable == null) {
          localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.error.addThrowable((Throwable)localObject))
        {
          this.done = true;
          drain();
          return true;
        }
        return false;
      }
      return false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */