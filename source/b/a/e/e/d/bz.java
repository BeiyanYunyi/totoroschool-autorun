package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.c.f;
import b.a.i;
import b.a.j;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class bz<T>
  extends a<T, T>
{
  final j<? extends T> b;
  
  public bz(l<T> paraml, j<? extends T> paramj)
  {
    super(paraml);
    this.b = paramj;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    a locala = new a(params);
    params.onSubscribe(locala);
    this.a.subscribe(locala);
    this.b.a(locala.otherObserver);
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b, s<T>
  {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    final s<? super T> actual;
    volatile boolean disposed;
    final b.a.e.j.c error;
    final AtomicReference<b> mainDisposable;
    volatile boolean mainDone;
    final a<T> otherObserver;
    volatile int otherState;
    volatile f<T> queue;
    T singleItem;
    
    a(s<? super T> params)
    {
      this.actual = params;
      this.mainDisposable = new AtomicReference();
      this.otherObserver = new a(this);
      this.error = new b.a.e.j.c();
    }
    
    public void dispose()
    {
      this.disposed = true;
      d.dispose(this.mainDisposable);
      d.dispose(this.otherObserver);
      if (getAndIncrement() == 0)
      {
        this.queue = null;
        this.singleItem = null;
      }
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
      int i = 1;
      for (;;)
      {
        if (this.disposed)
        {
          this.singleItem = null;
          this.queue = null;
          return;
        }
        if (this.error.get() != null)
        {
          this.singleItem = null;
          this.queue = null;
          locals.onError(this.error.terminate());
          return;
        }
        int k = this.otherState;
        int j = k;
        if (k == 1)
        {
          localObject = this.singleItem;
          this.singleItem = null;
          this.otherState = 2;
          locals.onNext(localObject);
          j = 2;
        }
        boolean bool = this.mainDone;
        Object localObject = this.queue;
        if (localObject != null) {
          localObject = ((f)localObject).poll();
        } else {
          localObject = null;
        }
        if (localObject == null) {
          k = 1;
        } else {
          k = 0;
        }
        if ((bool) && (k != 0) && (j == 2))
        {
          this.queue = null;
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
    
    f<T> getOrCreateQueue()
    {
      f localf = this.queue;
      Object localObject = localf;
      if (localf == null)
      {
        localObject = new b.a.e.f.c(l.bufferSize());
        this.queue = ((f)localObject);
      }
      return (f<T>)localObject;
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b)this.mainDisposable.get());
    }
    
    public void onComplete()
    {
      this.mainDone = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.error.addThrowable(paramThrowable))
      {
        d.dispose(this.mainDisposable);
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (compareAndSet(0, 1))
      {
        this.actual.onNext(paramT);
        if (decrementAndGet() != 0) {}
      }
      else
      {
        getOrCreateQueue().offer(paramT);
        if (getAndIncrement() != 0) {
          return;
        }
      }
      drainLoop();
    }
    
    public void onSubscribe(b paramb)
    {
      d.setOnce(this.mainDisposable, paramb);
    }
    
    void otherComplete()
    {
      this.otherState = 2;
      drain();
    }
    
    void otherError(Throwable paramThrowable)
    {
      if (this.error.addThrowable(paramThrowable))
      {
        d.dispose(this.mainDisposable);
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    void otherSuccess(T paramT)
    {
      if (compareAndSet(0, 1))
      {
        this.actual.onNext(paramT);
        this.otherState = 2;
      }
      else
      {
        this.singleItem = paramT;
        this.otherState = 1;
        if (getAndIncrement() != 0) {
          return;
        }
      }
      drainLoop();
    }
    
    static final class a<T>
      extends AtomicReference<b>
      implements i<T>
    {
      private static final long serialVersionUID = -2935427570954647017L;
      final bz.a<T> parent;
      
      a(bz.a<T> parama)
      {
        this.parent = parama;
      }
      
      public void onComplete()
      {
        this.parent.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.otherError(paramThrowable);
      }
      
      public void onSubscribe(b paramb)
      {
        d.setOnce(this, paramb);
      }
      
      public void onSuccess(T paramT)
      {
        this.parent.otherSuccess(paramT);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */