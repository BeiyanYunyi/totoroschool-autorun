package b.a.e.e.d;

import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class eg<T, B>
  extends a<T, l<T>>
{
  final Callable<? extends q<B>> b;
  final int c;
  
  public eg(q<T> paramq, Callable<? extends q<B>> paramCallable, int paramInt)
  {
    super(paramq);
    this.b = paramCallable;
    this.c = paramInt;
  }
  
  public void subscribeActual(s<? super l<T>> params)
  {
    params = new b(params, this.c, this.b);
    this.a.subscribe(params);
  }
  
  static final class a<T, B>
    extends b.a.g.c<B>
  {
    final eg.b<T, B> a;
    boolean b;
    
    a(eg.b<T, B> paramb)
    {
      this.a = paramb;
    }
    
    public void onComplete()
    {
      if (this.b) {
        return;
      }
      this.b = true;
      this.a.innerComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.b)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.b = true;
      this.a.innerError(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      dispose();
      this.a.innerNext(this);
    }
  }
  
  static final class b<T, B>
    extends AtomicInteger
    implements b.a.b.b, s<T>, Runnable
  {
    static final eg.a<Object, Object> BOUNDARY_DISPOSED = new eg.a(null);
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final AtomicReference<eg.a<T, B>> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final s<? super l<T>> downstream;
    final b.a.e.j.c errors;
    final Callable<? extends q<B>> other;
    final b.a.e.f.a<Object> queue;
    final AtomicBoolean stopWindows;
    b.a.b.b upstream;
    b.a.j.d<T> window;
    final AtomicInteger windows;
    
    b(s<? super l<T>> params, int paramInt, Callable<? extends q<B>> paramCallable)
    {
      this.downstream = params;
      this.capacityHint = paramInt;
      this.boundaryObserver = new AtomicReference();
      this.windows = new AtomicInteger(1);
      this.queue = new b.a.e.f.a();
      this.errors = new b.a.e.j.c();
      this.stopWindows = new AtomicBoolean();
      this.other = paramCallable;
    }
    
    public void dispose()
    {
      if (this.stopWindows.compareAndSet(false, true))
      {
        disposeBoundary();
        if (this.windows.decrementAndGet() == 0) {
          this.upstream.dispose();
        }
      }
    }
    
    void disposeBoundary()
    {
      b.a.b.b localb = (b.a.b.b)this.boundaryObserver.getAndSet(BOUNDARY_DISPOSED);
      if ((localb != null) && (localb != BOUNDARY_DISPOSED)) {
        localb.dispose();
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.downstream;
      Object localObject1 = this.queue;
      b.a.e.j.c localc = this.errors;
      int i = 1;
      for (;;)
      {
        if (this.windows.get() == 0)
        {
          ((b.a.e.f.a)localObject1).clear();
          this.window = null;
          return;
        }
        b.a.j.d locald = this.window;
        boolean bool = this.done;
        if ((bool) && (localc.get() != null))
        {
          ((b.a.e.f.a)localObject1).clear();
          localObject1 = localc.terminate();
          if (locald != null)
          {
            this.window = null;
            locald.onError((Throwable)localObject1);
          }
          locals.onError((Throwable)localObject1);
          return;
        }
        Object localObject2 = ((b.a.e.f.a)localObject1).poll();
        int j;
        if (localObject2 == null) {
          j = 1;
        } else {
          j = 0;
        }
        if ((bool) && (j != 0))
        {
          localObject1 = localc.terminate();
          if (localObject1 == null)
          {
            if (locald != null)
            {
              this.window = null;
              locald.onComplete();
            }
            locals.onComplete();
            return;
          }
          if (locald != null)
          {
            this.window = null;
            locald.onError((Throwable)localObject1);
          }
          locals.onError((Throwable)localObject1);
          return;
        }
        if (j != 0)
        {
          j = addAndGet(-i);
          i = j;
          if (j != 0) {}
        }
        else if (localObject2 != NEXT_WINDOW)
        {
          locald.onNext(localObject2);
        }
        else
        {
          if (locald != null)
          {
            this.window = null;
            locald.onComplete();
          }
          if (!this.stopWindows.get())
          {
            locald = b.a.j.d.a(this.capacityHint, this);
            this.window = locald;
            this.windows.getAndIncrement();
            try
            {
              localObject2 = (q)b.a.e.b.b.a(this.other.call(), "The other Callable returned a null ObservableSource");
              eg.a locala = new eg.a(this);
              if (this.boundaryObserver.compareAndSet(null, locala))
              {
                ((q)localObject2).subscribe(locala);
                locals.onNext(locald);
              }
            }
            catch (Throwable localThrowable)
            {
              b.a.c.b.b(localThrowable);
              localc.addThrowable(localThrowable);
              this.done = true;
            }
          }
        }
      }
    }
    
    void innerComplete()
    {
      this.upstream.dispose();
      this.done = true;
      drain();
    }
    
    void innerError(Throwable paramThrowable)
    {
      this.upstream.dispose();
      if (this.errors.addThrowable(paramThrowable))
      {
        this.done = true;
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    void innerNext(eg.a<T, B> parama)
    {
      this.boundaryObserver.compareAndSet(parama, null);
      this.queue.offer(NEXT_WINDOW);
      drain();
    }
    
    public boolean isDisposed()
    {
      return this.stopWindows.get();
    }
    
    public void onComplete()
    {
      disposeBoundary();
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      disposeBoundary();
      if (this.errors.addThrowable(paramThrowable))
      {
        this.done = true;
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.queue.offer(paramT);
      drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (b.a.e.a.d.validate(this.upstream, paramb))
      {
        this.upstream = paramb;
        this.downstream.onSubscribe(this);
        this.queue.offer(NEXT_WINDOW);
        drain();
      }
    }
    
    public void run()
    {
      if (this.windows.decrementAndGet() == 0) {
        this.upstream.dispose();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */