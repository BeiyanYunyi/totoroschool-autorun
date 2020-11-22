package b.a.e.e.c;

import b.a.d.h;
import b.a.e.j.i;
import b.a.e.j.j;
import b.a.l;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
  extends b.a.b
{
  final l<T> a;
  final h<? super T, ? extends b.a.d> b;
  final i c;
  final int d;
  
  public a(l<T> paraml, h<? super T, ? extends b.a.d> paramh, i parami, int paramInt)
  {
    this.a = paraml;
    this.b = paramh;
    this.c = parami;
    this.d = paramInt;
  }
  
  protected void b(b.a.c paramc)
  {
    if (!g.a(this.a, this.b, paramc)) {
      this.a.subscribe(new a(paramc, this.b, this.c, this.d));
    }
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    volatile boolean disposed;
    volatile boolean done;
    final b.a.c downstream;
    final i errorMode;
    final b.a.e.j.c errors;
    final a inner;
    final h<? super T, ? extends b.a.d> mapper;
    final int prefetch;
    b.a.e.c.g<T> queue;
    b.a.b.b upstream;
    
    a(b.a.c paramc, h<? super T, ? extends b.a.d> paramh, i parami, int paramInt)
    {
      this.downstream = paramc;
      this.mapper = paramh;
      this.errorMode = parami;
      this.prefetch = paramInt;
      this.errors = new b.a.e.j.c();
      this.inner = new a(this);
    }
    
    public void dispose()
    {
      this.disposed = true;
      this.upstream.dispose();
      this.inner.dispose();
      if (getAndIncrement() == 0) {
        this.queue.clear();
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      b.a.e.j.c localc = this.errors;
      i locali = this.errorMode;
      do
      {
        if (this.disposed)
        {
          this.queue.clear();
          return;
        }
        if (!this.active)
        {
          if ((locali == i.BOUNDARY) && (localc.get() != null))
          {
            this.disposed = true;
            this.queue.clear();
            localObject1 = localc.terminate();
            this.downstream.onError((Throwable)localObject1);
            return;
          }
          boolean bool = this.done;
          Object localObject1 = null;
          try
          {
            Object localObject2 = this.queue.poll();
            int i;
            if (localObject2 != null)
            {
              localObject1 = (b.a.d)b.a.e.b.b.a(this.mapper.apply(localObject2), "The mapper returned a null CompletableSource");
              i = 0;
            }
            else
            {
              i = 1;
            }
            if ((bool) && (i != 0))
            {
              this.disposed = true;
              localObject1 = localc.terminate();
              if (localObject1 != null)
              {
                this.downstream.onError((Throwable)localObject1);
                return;
              }
              this.downstream.onComplete();
              return;
            }
            if (i == 0)
            {
              this.active = true;
              ((b.a.d)localObject1).a(this.inner);
            }
          }
          catch (Throwable localThrowable1)
          {
            b.a.c.b.b(localThrowable1);
            this.disposed = true;
            this.queue.clear();
            this.upstream.dispose();
            localc.addThrowable(localThrowable1);
            Throwable localThrowable2 = localc.terminate();
            this.downstream.onError(localThrowable2);
            return;
          }
        }
      } while (decrementAndGet() != 0);
    }
    
    void innerComplete()
    {
      this.active = false;
      drain();
    }
    
    void innerError(Throwable paramThrowable)
    {
      if (this.errors.addThrowable(paramThrowable))
      {
        if (this.errorMode == i.IMMEDIATE)
        {
          this.disposed = true;
          this.upstream.dispose();
          paramThrowable = this.errors.terminate();
          if (paramThrowable != j.a) {
            this.downstream.onError(paramThrowable);
          }
          if (getAndIncrement() == 0) {
            this.queue.clear();
          }
        }
        else
        {
          this.active = false;
          drain();
        }
      }
      else {
        b.a.h.a.a(paramThrowable);
      }
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.errors.addThrowable(paramThrowable))
      {
        if (this.errorMode == i.IMMEDIATE)
        {
          this.disposed = true;
          this.inner.dispose();
          paramThrowable = this.errors.terminate();
          if (paramThrowable != j.a) {
            this.downstream.onError(paramThrowable);
          }
          if (getAndIncrement() == 0) {
            this.queue.clear();
          }
        }
        else
        {
          this.done = true;
          drain();
        }
      }
      else {
        b.a.h.a.a(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (paramT != null) {
        this.queue.offer(paramT);
      }
      drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (b.a.e.a.d.validate(this.upstream, paramb))
      {
        this.upstream = paramb;
        if ((paramb instanceof b.a.e.c.b))
        {
          paramb = (b.a.e.c.b)paramb;
          int i = paramb.requestFusion(3);
          if (i == 1)
          {
            this.queue = paramb;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
          }
          if (i == 2)
          {
            this.queue = paramb;
            this.downstream.onSubscribe(this);
            return;
          }
        }
        this.queue = new b.a.e.f.c(this.prefetch);
        this.downstream.onSubscribe(this);
      }
    }
    
    static final class a
      extends AtomicReference<b.a.b.b>
      implements b.a.c
    {
      private static final long serialVersionUID = 5638352172918776687L;
      final a.a<?> parent;
      
      a(a.a<?> parama)
      {
        this.parent = parama;
      }
      
      void dispose()
      {
        b.a.e.a.d.dispose(this);
      }
      
      public void onComplete()
      {
        this.parent.innerComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.innerError(paramThrowable);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        b.a.e.a.d.replace(this, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */