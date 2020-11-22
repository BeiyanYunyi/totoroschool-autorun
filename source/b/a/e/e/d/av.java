package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.c.f;
import b.a.e.c.g;
import b.a.e.j.j;
import b.a.q;
import b.a.s;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class av<T, U>
  extends a<T, U>
{
  final h<? super T, ? extends q<? extends U>> b;
  final boolean c;
  final int d;
  final int e;
  
  public av(q<T> paramq, h<? super T, ? extends q<? extends U>> paramh, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void subscribeActual(s<? super U> params)
  {
    if (cw.a(this.a, params, this.b)) {
      return;
    }
    this.a.subscribe(new b(params, this.b, this.c, this.d, this.e));
  }
  
  static final class a<T, U>
    extends AtomicReference<b.a.b.b>
    implements s<U>
  {
    private static final long serialVersionUID = -4606175640614850599L;
    volatile boolean done;
    int fusionMode;
    final long id;
    final av.b<T, U> parent;
    volatile g<U> queue;
    
    a(av.b<T, U> paramb, long paramLong)
    {
      this.id = paramLong;
      this.parent = paramb;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public void onComplete()
    {
      this.done = true;
      this.parent.drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.parent.errors.addThrowable(paramThrowable))
      {
        if (!this.parent.delayErrors) {
          this.parent.disposeAll();
        }
        this.done = true;
        this.parent.drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      if (this.fusionMode == 0)
      {
        this.parent.tryEmit(paramU, this);
        return;
      }
      this.parent.drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if ((d.setOnce(this, paramb)) && ((paramb instanceof b.a.e.c.b)))
      {
        paramb = (b.a.e.c.b)paramb;
        int i = paramb.requestFusion(7);
        if (i == 1)
        {
          this.fusionMode = i;
          this.queue = paramb;
          this.done = true;
          this.parent.drain();
          return;
        }
        if (i == 2)
        {
          this.fusionMode = i;
          this.queue = paramb;
        }
      }
    }
  }
  
  static final class b<T, U>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    static final av.a<?, ?>[] CANCELLED = new av.a[0];
    static final av.a<?, ?>[] EMPTY = new av.a[0];
    private static final long serialVersionUID = -2117620485640801370L;
    final s<? super U> actual;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final b.a.e.j.c errors = new b.a.e.j.c();
    long lastId;
    int lastIndex;
    final h<? super T, ? extends q<? extends U>> mapper;
    final int maxConcurrency;
    final AtomicReference<av.a<?, ?>[]> observers;
    volatile f<U> queue;
    b.a.b.b s;
    Queue<q<? extends U>> sources;
    long uniqueId;
    int wip;
    
    b(s<? super U> params, h<? super T, ? extends q<? extends U>> paramh, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.actual = params;
      this.mapper = paramh;
      this.delayErrors = paramBoolean;
      this.maxConcurrency = paramInt1;
      this.bufferSize = paramInt2;
      if (paramInt1 != Integer.MAX_VALUE) {
        this.sources = new ArrayDeque(paramInt1);
      }
      this.observers = new AtomicReference(EMPTY);
    }
    
    boolean addInner(av.a<T, U> parama)
    {
      av.a[] arrayOfa1;
      av.a[] arrayOfa2;
      do
      {
        arrayOfa1 = (av.a[])this.observers.get();
        if (arrayOfa1 == CANCELLED)
        {
          parama.dispose();
          return false;
        }
        int i = arrayOfa1.length;
        arrayOfa2 = new av.a[i + 1];
        System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, i);
        arrayOfa2[i] = parama;
      } while (!this.observers.compareAndSet(arrayOfa1, arrayOfa2));
      return true;
    }
    
    boolean checkTerminate()
    {
      if (this.cancelled) {
        return true;
      }
      Throwable localThrowable = (Throwable)this.errors.get();
      if ((!this.delayErrors) && (localThrowable != null))
      {
        disposeAll();
        localThrowable = this.errors.terminate();
        if (localThrowable != j.a) {
          this.actual.onError(localThrowable);
        }
        return true;
      }
      return false;
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        if (disposeAll())
        {
          Throwable localThrowable = this.errors.terminate();
          if ((localThrowable != null) && (localThrowable != j.a)) {
            b.a.h.a.a(localThrowable);
          }
        }
      }
    }
    
    boolean disposeAll()
    {
      this.s.dispose();
      av.a[] arrayOfa1 = (av.a[])this.observers.get();
      av.a[] arrayOfa2 = CANCELLED;
      int i = 0;
      if (arrayOfa1 != arrayOfa2)
      {
        arrayOfa1 = (av.a[])this.observers.getAndSet(CANCELLED);
        if (arrayOfa1 != CANCELLED)
        {
          int j = arrayOfa1.length;
          while (i < j)
          {
            arrayOfa1[i].dispose();
            i += 1;
          }
          return true;
        }
      }
      return false;
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
      int n = 1;
      int i;
      label532:
      do
      {
        for (;;)
        {
          if (checkTerminate()) {
            return;
          }
          Object localObject3 = this.queue;
          if (localObject3 != null) {
            for (;;)
            {
              if (checkTerminate()) {
                return;
              }
              localObject4 = ((f)localObject3).poll();
              if (localObject4 == null)
              {
                if (localObject4 == null) {
                  break;
                }
              }
              else {
                locals.onNext(localObject4);
              }
            }
          }
          boolean bool = this.done;
          Object localObject4 = this.queue;
          localObject3 = (av.a[])this.observers.get();
          int i3 = localObject3.length;
          if (this.maxConcurrency != Integer.MAX_VALUE) {
            try
            {
              i = this.sources.size();
            }
            finally {}
          } else {
            i = 0;
          }
          if ((bool) && ((localObject4 == null) || (((f)localObject4).isEmpty())) && (i3 == 0) && (i == 0))
          {
            localObject3 = this.errors.terminate();
            if (localObject3 != j.a)
            {
              if (localObject3 == null)
              {
                ((s)localObject1).onComplete();
                return;
              }
              ((s)localObject1).onError((Throwable)localObject3);
            }
            return;
          }
          if (i3 != 0)
          {
            long l = this.lastId;
            int j = this.lastIndex;
            if (i3 > j)
            {
              i = j;
              if (localObject3[j].id == l) {}
            }
            else
            {
              i = j;
              if (i3 <= j) {
                i = 0;
              }
              j = 0;
              while ((j < i3) && (localObject3[i].id != l))
              {
                k = i + 1;
                i = k;
                if (k == i3) {
                  i = 0;
                }
                j += 1;
              }
              this.lastIndex = i;
              this.lastId = localObject3[i].id;
            }
            j = 0;
            int m = 0;
            int k = i;
            i = m;
            while (j < i3)
            {
              if (checkTerminate()) {
                return;
              }
              localObject4 = localObject3[k];
              for (;;)
              {
                if (checkTerminate()) {
                  return;
                }
                g localg = ((av.a)localObject4).queue;
                if (localg != null) {}
                try
                {
                  do
                  {
                    Object localObject5 = localg.poll();
                    if (localObject5 == null)
                    {
                      if (localObject5 != null) {
                        break;
                      }
                      bool = ((av.a)localObject4).done;
                      localg = ((av.a)localObject4).queue;
                      m = i;
                      if (bool) {
                        if (localg != null)
                        {
                          m = i;
                          if (!localg.isEmpty()) {}
                        }
                        else
                        {
                          removeInner((av.a)localObject4);
                          if (checkTerminate()) {
                            return;
                          }
                          m = 1;
                        }
                      }
                      int i2 = k + 1;
                      i1 = j;
                      i = m;
                      k = i2;
                      if (i2 != i3) {
                        break label532;
                      }
                      k = 0;
                      i1 = j;
                      i = m;
                      break label532;
                    }
                    ((s)localObject1).onNext(localObject5);
                  } while (!checkTerminate());
                  return;
                }
                catch (Throwable localThrowable)
                {
                  b.a.c.b.b(localThrowable);
                  ((av.a)localObject4).dispose();
                  this.errors.addThrowable(localThrowable);
                  if (checkTerminate()) {
                    return;
                  }
                  removeInner((av.a)localObject4);
                  int i1 = j + 1;
                  i = 1;
                  j = i1 + 1;
                }
              }
            }
            this.lastIndex = k;
            this.lastId = localObject3[k].id;
          }
          else
          {
            i = 0;
          }
          if (i != 0)
          {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
              continue;
            }
            try
            {
              localObject3 = (q)this.sources.poll();
              if (localObject3 == null) {
                this.wip -= 1;
              } else {
                subscribeInner((q)localObject3);
              }
            }
            finally {}
          }
        }
        i = addAndGet(-n);
        n = i;
      } while (i != 0);
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      if (this.done) {
        return;
      }
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.done)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
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
      if (this.done) {
        return;
      }
      try
      {
        paramT = (q)b.a.e.b.b.a(this.mapper.apply(paramT), "The mapper returned a null ObservableSource");
        if (this.maxConcurrency != Integer.MAX_VALUE) {
          try
          {
            if (this.wip == this.maxConcurrency)
            {
              this.sources.offer(paramT);
              return;
            }
            this.wip += 1;
          }
          finally {}
        }
        subscribeInner(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.s.dispose();
        onError(paramT);
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
    
    void removeInner(av.a<T, U> parama)
    {
      av.a[] arrayOfa2;
      av.a[] arrayOfa1;
      do
      {
        arrayOfa2 = (av.a[])this.observers.get();
        int m = arrayOfa2.length;
        if (m == 0) {
          return;
        }
        int k = -1;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          if (arrayOfa2[i] == parama)
          {
            j = i;
            break;
          }
          i += 1;
        }
        if (j < 0) {
          return;
        }
        if (m == 1)
        {
          arrayOfa1 = EMPTY;
        }
        else
        {
          arrayOfa1 = new av.a[m - 1];
          System.arraycopy(arrayOfa2, 0, arrayOfa1, 0, j);
          System.arraycopy(arrayOfa2, j + 1, arrayOfa1, j, m - j - 1);
        }
      } while (!this.observers.compareAndSet(arrayOfa2, arrayOfa1));
    }
    
    void subscribeInner(q<? extends U> paramq)
    {
      while ((paramq instanceof Callable))
      {
        if ((!tryEmitScalar((Callable)paramq)) || (this.maxConcurrency == Integer.MAX_VALUE)) {
          return;
        }
        int i = 0;
        try
        {
          paramq = (q)this.sources.poll();
          if (paramq == null)
          {
            this.wip -= 1;
            i = 1;
          }
          if (i != 0)
          {
            drain();
            return;
          }
        }
        finally {}
      }
      long l = this.uniqueId;
      this.uniqueId = (1L + l);
      av.a locala = new av.a(this, l);
      if (addInner(locala)) {
        paramq.subscribe(locala);
      }
    }
    
    void tryEmit(U paramU, av.a<T, U> parama)
    {
      if ((get() == 0) && (compareAndSet(0, 1)))
      {
        this.actual.onNext(paramU);
        if (decrementAndGet() != 0) {}
      }
      else
      {
        g localg = parama.queue;
        Object localObject = localg;
        if (localg == null)
        {
          localObject = new b.a.e.f.c(this.bufferSize);
          parama.queue = ((g)localObject);
        }
        ((g)localObject).offer(paramU);
        if (getAndIncrement() != 0) {
          return;
        }
      }
      drainLoop();
    }
    
    boolean tryEmitScalar(Callable<? extends U> paramCallable)
    {
      try
      {
        Object localObject = paramCallable.call();
        if (localObject == null) {
          return true;
        }
        if ((get() == 0) && (compareAndSet(0, 1)))
        {
          this.actual.onNext(localObject);
          if (decrementAndGet() == 0) {
            return true;
          }
        }
        else
        {
          f localf = this.queue;
          paramCallable = localf;
          if (localf == null)
          {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
              paramCallable = new b.a.e.f.c(this.bufferSize);
            } else {
              paramCallable = new b.a.e.f.b(this.maxConcurrency);
            }
            this.queue = paramCallable;
          }
          if (!paramCallable.offer(localObject))
          {
            onError(new IllegalStateException("Scalar queue full?!"));
            return true;
          }
          if (getAndIncrement() != 0) {
            return false;
          }
        }
        drainLoop();
        return true;
      }
      catch (Throwable paramCallable)
      {
        b.a.c.b.b(paramCallable);
        this.errors.addThrowable(paramCallable);
        drain();
      }
      return true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */