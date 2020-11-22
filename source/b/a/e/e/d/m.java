package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class m<T, U extends Collection<? super T>, Open, Close>
  extends a<T, U>
{
  final Callable<U> b;
  final q<? extends Open> c;
  final h<? super Open, ? extends q<? extends Close>> d;
  
  public m(q<T> paramq, q<? extends Open> paramq1, h<? super Open, ? extends q<? extends Close>> paramh, Callable<U> paramCallable)
  {
    super(paramq);
    this.c = paramq1;
    this.d = paramh;
    this.b = paramCallable;
  }
  
  protected void subscribeActual(s<? super U> params)
  {
    a locala = new a(params, this.c, this.d, this.b);
    params.onSubscribe(locala);
    this.a.subscribe(locala);
  }
  
  static final class a<T, C extends Collection<? super T>, Open, Close>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = -8466418554264089604L;
    final s<? super C> actual;
    final h<? super Open, ? extends q<? extends Close>> bufferClose;
    final q<? extends Open> bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final b.a.e.j.c errors;
    long index;
    final b.a.b.a observers;
    final b.a.e.f.c<C> queue;
    final AtomicReference<b.a.b.b> upstream;
    
    a(s<? super C> params, q<? extends Open> paramq, h<? super Open, ? extends q<? extends Close>> paramh, Callable<C> paramCallable)
    {
      this.actual = params;
      this.bufferSupplier = paramCallable;
      this.bufferOpen = paramq;
      this.bufferClose = paramh;
      this.queue = new b.a.e.f.c(l.bufferSize());
      this.observers = new b.a.b.a();
      this.upstream = new AtomicReference();
      this.buffers = new LinkedHashMap();
      this.errors = new b.a.e.j.c();
    }
    
    void boundaryError(b.a.b.b paramb, Throwable paramThrowable)
    {
      d.dispose(this.upstream);
      this.observers.c(paramb);
      onError(paramThrowable);
    }
    
    void close(m.b<T, C> paramb, long paramLong)
    {
      this.observers.c(paramb);
      int i;
      if (this.observers.a() == 0)
      {
        d.dispose(this.upstream);
        i = 1;
      }
      else
      {
        i = 0;
      }
      try
      {
        if (this.buffers == null) {
          return;
        }
        this.queue.offer(this.buffers.remove(Long.valueOf(paramLong)));
        if (i != 0) {
          this.done = true;
        }
        drain();
        return;
      }
      finally {}
    }
    
    public void dispose()
    {
      if (d.dispose(this.upstream))
      {
        this.cancelled = true;
        this.observers.dispose();
        try
        {
          this.buffers = null;
          if (getAndIncrement() != 0)
          {
            this.queue.clear();
            return;
          }
        }
        finally {}
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.actual;
      b.a.e.f.c localc = this.queue;
      int i = 1;
      for (;;)
      {
        if (this.cancelled)
        {
          localc.clear();
          return;
        }
        boolean bool = this.done;
        if ((bool) && (this.errors.get() != null))
        {
          localc.clear();
          locals.onError(this.errors.terminate());
          return;
        }
        Collection localCollection = (Collection)localc.poll();
        int j;
        if (localCollection == null) {
          j = 1;
        } else {
          j = 0;
        }
        if ((bool) && (j != 0))
        {
          locals.onComplete();
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
          locals.onNext(localCollection);
        }
      }
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)this.upstream.get());
    }
    
    public void onComplete()
    {
      this.observers.dispose();
      try
      {
        Object localObject1 = this.buffers;
        if (localObject1 == null) {
          return;
        }
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Collection localCollection = (Collection)((Iterator)localObject1).next();
          this.queue.offer(localCollection);
        }
        this.buffers = null;
        this.done = true;
        drain();
        return;
      }
      finally {}
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.errors.addThrowable(paramThrowable))
      {
        this.observers.dispose();
        try
        {
          this.buffers = null;
          this.done = true;
          drain();
          return;
        }
        finally {}
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      try
      {
        Object localObject = this.buffers;
        if (localObject == null) {
          return;
        }
        localObject = ((Map)localObject).values().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Collection)((Iterator)localObject).next()).add(paramT);
        }
        return;
      }
      finally {}
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.setOnce(this.upstream, paramb))
      {
        paramb = new a(this);
        this.observers.a(paramb);
        this.bufferOpen.subscribe(paramb);
      }
    }
    
    void open(Open paramOpen)
    {
      try
      {
        Object localObject = (Collection)b.a.e.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
        paramOpen = (q)b.a.e.b.b.a(this.bufferClose.apply(paramOpen), "The bufferClose returned a null ObservableSource");
        long l = this.index;
        this.index = (1L + l);
        try
        {
          Map localMap = this.buffers;
          if (localMap == null) {
            return;
          }
          localMap.put(Long.valueOf(l), localObject);
          localObject = new m.b(this, l);
          this.observers.a((b.a.b.b)localObject);
          paramOpen.subscribe((s)localObject);
          return;
        }
        finally {}
        return;
      }
      catch (Throwable paramOpen)
      {
        b.a.c.b.b(paramOpen);
        d.dispose(this.upstream);
        onError(paramOpen);
      }
    }
    
    void openComplete(a<Open> parama)
    {
      this.observers.c(parama);
      if (this.observers.a() == 0)
      {
        d.dispose(this.upstream);
        this.done = true;
        drain();
      }
    }
    
    static final class a<Open>
      extends AtomicReference<b.a.b.b>
      implements b.a.b.b, s<Open>
    {
      private static final long serialVersionUID = -8498650778633225126L;
      final m.a<?, ?, Open, ?> parent;
      
      a(m.a<?, ?, Open, ?> parama)
      {
        this.parent = parama;
      }
      
      public void dispose()
      {
        d.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return get() == d.DISPOSED;
      }
      
      public void onComplete()
      {
        lazySet(d.DISPOSED);
        this.parent.openComplete(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        lazySet(d.DISPOSED);
        this.parent.boundaryError(this, paramThrowable);
      }
      
      public void onNext(Open paramOpen)
      {
        this.parent.open(paramOpen);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        d.setOnce(this, paramb);
      }
    }
  }
  
  static final class b<T, C extends Collection<? super T>>
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, s<Object>
  {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final m.a<T, C, ?, ?> parent;
    
    b(m.a<T, C, ?, ?> parama, long paramLong)
    {
      this.parent = parama;
      this.index = paramLong;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return get() == d.DISPOSED;
    }
    
    public void onComplete()
    {
      if (get() != d.DISPOSED)
      {
        lazySet(d.DISPOSED);
        this.parent.close(this, this.index);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (get() != d.DISPOSED)
      {
        lazySet(d.DISPOSED);
        this.parent.boundaryError(this, paramThrowable);
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      paramObject = (b.a.b.b)get();
      if (paramObject != d.DISPOSED)
      {
        lazySet(d.DISPOSED);
        ((b.a.b.b)paramObject).dispose();
        this.parent.close(this, this.index);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */