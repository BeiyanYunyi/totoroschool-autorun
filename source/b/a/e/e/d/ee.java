package b.a.e.e.d;

import b.a.b.b;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ee<T, B>
  extends a<T, l<T>>
{
  final q<B> b;
  final int c;
  
  public ee(q<T> paramq, q<B> paramq1, int paramInt)
  {
    super(paramq);
    this.b = paramq1;
    this.c = paramInt;
  }
  
  public void subscribeActual(s<? super l<T>> params)
  {
    b localb = new b(params, this.c);
    params.onSubscribe(localb);
    this.b.subscribe(localb.boundaryObserver);
    this.a.subscribe(localb);
  }
  
  static final class a<T, B>
    extends b.a.g.c<B>
  {
    final ee.b<T, B> a;
    boolean b;
    
    a(ee.b<T, B> paramb)
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
      this.a.innerNext();
    }
  }
  
  static final class b<T, B>
    extends AtomicInteger
    implements b, s<T>, Runnable
  {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final ee.a<T, B> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final s<? super l<T>> downstream;
    final b.a.e.j.c errors;
    final b.a.e.f.a<Object> queue;
    final AtomicBoolean stopWindows;
    final AtomicReference<b> upstream;
    b.a.j.d<T> window;
    final AtomicInteger windows;
    
    b(s<? super l<T>> params, int paramInt)
    {
      this.downstream = params;
      this.capacityHint = paramInt;
      this.boundaryObserver = new ee.a(this);
      this.upstream = new AtomicReference();
      this.windows = new AtomicInteger(1);
      this.queue = new b.a.e.f.a();
      this.errors = new b.a.e.j.c();
      this.stopWindows = new AtomicBoolean();
    }
    
    public void dispose()
    {
      if (this.stopWindows.compareAndSet(false, true))
      {
        this.boundaryObserver.dispose();
        if (this.windows.decrementAndGet() == 0) {
          b.a.e.a.d.dispose(this.upstream);
        }
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
            locals.onNext(locald);
          }
        }
      }
    }
    
    void innerComplete()
    {
      b.a.e.a.d.dispose(this.upstream);
      this.done = true;
      drain();
    }
    
    void innerError(Throwable paramThrowable)
    {
      b.a.e.a.d.dispose(this.upstream);
      if (this.errors.addThrowable(paramThrowable))
      {
        this.done = true;
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    void innerNext()
    {
      this.queue.offer(NEXT_WINDOW);
      drain();
    }
    
    public boolean isDisposed()
    {
      return this.stopWindows.get();
    }
    
    public void onComplete()
    {
      this.boundaryObserver.dispose();
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.boundaryObserver.dispose();
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
    
    public void onSubscribe(b paramb)
    {
      if (b.a.e.a.d.setOnce(this.upstream, paramb)) {
        innerNext();
      }
    }
    
    public void run()
    {
      if (this.windows.decrementAndGet() == 0) {
        b.a.e.a.d.dispose(this.upstream);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */