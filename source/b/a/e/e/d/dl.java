package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.c.g;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class dl<T, R>
  extends a<T, R>
{
  final h<? super T, ? extends q<? extends R>> b;
  final int c;
  final boolean d;
  
  public dl(q<T> paramq, h<? super T, ? extends q<? extends R>> paramh, int paramInt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramInt;
    this.d = paramBoolean;
  }
  
  public void subscribeActual(s<? super R> params)
  {
    if (cw.a(this.a, params, this.b)) {
      return;
    }
    this.a.subscribe(new b(params, this.b, this.c, this.d));
  }
  
  static final class a<T, R>
    extends AtomicReference<b.a.b.b>
    implements s<R>
  {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    final long index;
    final dl.b<T, R> parent;
    volatile g<R> queue;
    
    a(dl.b<T, R> paramb, long paramLong, int paramInt)
    {
      this.parent = paramb;
      this.index = paramLong;
      this.bufferSize = paramInt;
    }
    
    public void cancel()
    {
      d.dispose(this);
    }
    
    public void onComplete()
    {
      if (this.index == this.parent.unique)
      {
        this.done = true;
        this.parent.drain();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(this, paramThrowable);
    }
    
    public void onNext(R paramR)
    {
      if (this.index == this.parent.unique)
      {
        if (paramR != null) {
          this.queue.offer(paramR);
        }
        this.parent.drain();
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.setOnce(this, paramb))
      {
        if ((paramb instanceof b.a.e.c.b))
        {
          paramb = (b.a.e.c.b)paramb;
          int i = paramb.requestFusion(7);
          if (i == 1)
          {
            this.queue = paramb;
            this.done = true;
            this.parent.drain();
            return;
          }
          if (i == 2)
          {
            this.queue = paramb;
            return;
          }
        }
        this.queue = new b.a.e.f.c(this.bufferSize);
      }
    }
  }
  
  static final class b<T, R>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    static final dl.a<Object, Object> CANCELLED = new dl.a(null, -1L, 1);
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<dl.a<T, R>> active = new AtomicReference();
    final s<? super R> actual;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final b.a.e.j.c errors;
    final h<? super T, ? extends q<? extends R>> mapper;
    b.a.b.b s;
    volatile long unique;
    
    static
    {
      CANCELLED.cancel();
    }
    
    b(s<? super R> params, h<? super T, ? extends q<? extends R>> paramh, int paramInt, boolean paramBoolean)
    {
      this.actual = params;
      this.mapper = paramh;
      this.bufferSize = paramInt;
      this.delayErrors = paramBoolean;
      this.errors = new b.a.e.j.c();
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.s.dispose();
        disposeInner();
      }
    }
    
    void disposeInner()
    {
      if ((dl.a)this.active.get() != CANCELLED)
      {
        dl.a locala = (dl.a)this.active.getAndSet(CANCELLED);
        if ((locala != CANCELLED) && (locala != null)) {
          locala.cancel();
        }
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.actual;
      AtomicReference localAtomicReference = this.active;
      boolean bool1 = this.delayErrors;
      int j = 1;
      int i;
      label429:
      label448:
      do
      {
        Object localObject1;
        dl.a locala;
        g localg;
        boolean bool2;
        for (;;)
        {
          if (this.cancelled) {
            return;
          }
          if (this.done)
          {
            if (localAtomicReference.get() == null) {
              i = 1;
            } else {
              i = 0;
            }
            if (bool1)
            {
              if (i != 0)
              {
                localObject1 = (Throwable)this.errors.get();
                if (localObject1 != null)
                {
                  locals.onError((Throwable)localObject1);
                  return;
                }
                locals.onComplete();
              }
            }
            else
            {
              if ((Throwable)this.errors.get() != null)
              {
                locals.onError(this.errors.terminate());
                return;
              }
              if (i != 0)
              {
                locals.onComplete();
                return;
              }
            }
          }
          locala = (dl.a)localAtomicReference.get();
          if (locala == null) {
            break label448;
          }
          localg = locala.queue;
          if (localg == null) {
            break label448;
          }
          if (!locala.done) {
            break;
          }
          bool2 = localg.isEmpty();
          if (bool1)
          {
            if (!bool2) {
              break;
            }
            localAtomicReference.compareAndSet(locala, null);
          }
          else
          {
            if ((Throwable)this.errors.get() != null)
            {
              locals.onError(this.errors.terminate());
              return;
            }
            if (!bool2) {
              break;
            }
            localAtomicReference.compareAndSet(locala, null);
          }
        }
        i = 0;
        for (;;)
        {
          if (this.cancelled) {
            return;
          }
          if (locala != localAtomicReference.get()) {}
          Object localObject2;
          int k;
          for (;;)
          {
            i = 1;
            break label429;
            if ((!bool1) && ((Throwable)this.errors.get() != null))
            {
              locals.onError(this.errors.terminate());
              return;
            }
            bool2 = locala.done;
            try
            {
              localObject1 = localg.poll();
            }
            catch (Throwable localThrowable)
            {
              b.a.c.b.b(localThrowable);
              this.errors.addThrowable(localThrowable);
              localAtomicReference.compareAndSet(locala, null);
              if (!bool1)
              {
                disposeInner();
                this.s.dispose();
                this.done = true;
              }
              else
              {
                locala.cancel();
              }
              localObject2 = null;
              i = 1;
            }
            if (localObject2 == null) {
              k = 1;
            } else {
              k = 0;
            }
            if ((!bool2) || (k == 0)) {
              break;
            }
            localAtomicReference.compareAndSet(locala, null);
          }
          if (k != 0)
          {
            if (i == 0) {
              break label448;
            }
            break;
          }
          locals.onNext(localObject2);
        }
        i = addAndGet(-j);
        j = i;
      } while (i != 0);
    }
    
    void innerError(dl.a<T, R> parama, Throwable paramThrowable)
    {
      if ((parama.index == this.unique) && (this.errors.addThrowable(paramThrowable)))
      {
        if (!this.delayErrors) {
          this.s.dispose();
        }
        parama.done = true;
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      if (!this.done)
      {
        this.done = true;
        drain();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if ((!this.done) && (this.errors.addThrowable(paramThrowable)))
      {
        if (!this.delayErrors) {
          disposeInner();
        }
        this.done = true;
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l = this.unique + 1L;
      this.unique = l;
      dl.a locala1 = (dl.a)this.active.get();
      if (locala1 != null) {
        locala1.cancel();
      }
      try
      {
        paramT = (q)b.a.e.b.b.a(this.mapper.apply(paramT), "The ObservableSource returned is null");
        locala1 = new dl.a(this, l, this.bufferSize);
        dl.a locala2;
        do
        {
          locala2 = (dl.a)this.active.get();
          if (locala2 == CANCELLED) {
            return;
          }
        } while (!this.active.compareAndSet(locala2, locala1));
        paramT.subscribe(locala1);
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
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */