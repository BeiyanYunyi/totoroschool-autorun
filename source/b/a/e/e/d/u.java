package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.c.g;
import b.a.e.j.i;
import b.a.g.e;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class u<T, U>
  extends a<T, U>
{
  final h<? super T, ? extends q<? extends U>> b;
  final int c;
  final i d;
  
  public u(q<T> paramq, h<? super T, ? extends q<? extends U>> paramh, int paramInt, i parami)
  {
    super(paramq);
    this.b = paramh;
    this.d = parami;
    this.c = Math.max(8, paramInt);
  }
  
  public void subscribeActual(s<? super U> params)
  {
    if (cw.a(this.a, params, this.b)) {
      return;
    }
    if (this.d == i.IMMEDIATE)
    {
      params = new e(params);
      this.a.subscribe(new b(params, this.b, this.c));
      return;
    }
    q localq = this.a;
    h localh = this.b;
    int i = this.c;
    boolean bool;
    if (this.d == i.END) {
      bool = true;
    } else {
      bool = false;
    }
    localq.subscribe(new a(params, localh, i, bool));
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final s<? super R> actual;
    final int bufferSize;
    volatile boolean cancelled;
    b.a.b.b d;
    volatile boolean done;
    final b.a.e.j.c error;
    final h<? super T, ? extends q<? extends R>> mapper;
    final a<R> observer;
    g<T> queue;
    int sourceMode;
    final boolean tillTheEnd;
    
    a(s<? super R> params, h<? super T, ? extends q<? extends R>> paramh, int paramInt, boolean paramBoolean)
    {
      this.actual = params;
      this.mapper = paramh;
      this.bufferSize = paramInt;
      this.tillTheEnd = paramBoolean;
      this.error = new b.a.e.j.c();
      this.observer = new a(params, this);
    }
    
    public void dispose()
    {
      this.cancelled = true;
      this.d.dispose();
      this.observer.dispose();
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.actual;
      g localg = this.queue;
      Object localObject1 = this.error;
      while (!this.active)
      {
        if (this.cancelled)
        {
          localg.clear();
          return;
        }
        if ((!this.tillTheEnd) && ((Throwable)((b.a.e.j.c)localObject1).get() != null))
        {
          localg.clear();
          this.cancelled = true;
          locals.onError(((b.a.e.j.c)localObject1).terminate());
          return;
        }
        boolean bool = this.done;
        try
        {
          Object localObject2 = localg.poll();
          int i;
          if (localObject2 == null) {
            i = 1;
          } else {
            i = 0;
          }
          if ((bool) && (i != 0))
          {
            this.cancelled = true;
            localObject1 = ((b.a.e.j.c)localObject1).terminate();
            if (localObject1 != null)
            {
              locals.onError((Throwable)localObject1);
              return;
            }
            locals.onComplete();
            return;
          }
          if (i == 0) {
            try
            {
              localObject2 = (q)b.a.e.b.b.a(this.mapper.apply(localObject2), "The mapper returned a null ObservableSource");
              if ((localObject2 instanceof Callable))
              {
                try
                {
                  localObject2 = ((Callable)localObject2).call();
                  if ((localObject2 == null) || (this.cancelled)) {
                    continue;
                  }
                  locals.onNext(localObject2);
                }
                catch (Throwable localThrowable2)
                {
                  b.a.c.b.b(localThrowable2);
                  ((b.a.e.j.c)localObject1).addThrowable(localThrowable2);
                }
                continue;
              }
              this.active = true;
              localThrowable2.subscribe(this.observer);
            }
            catch (Throwable localThrowable3)
            {
              b.a.c.b.b(localThrowable3);
              this.cancelled = true;
              this.d.dispose();
              localg.clear();
              ((b.a.e.j.c)localObject1).addThrowable(localThrowable3);
              locals.onError(((b.a.e.j.c)localObject1).terminate());
              return;
            }
          } else if (decrementAndGet() != 0) {}
        }
        catch (Throwable localThrowable1)
        {
          b.a.c.b.b(localThrowable1);
          this.cancelled = true;
          this.d.dispose();
          ((b.a.e.j.c)localObject1).addThrowable(localThrowable1);
          locals.onError(((b.a.e.j.c)localObject1).terminate());
          return;
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.error.addThrowable(paramThrowable))
      {
        this.done = true;
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.sourceMode == 0) {
        this.queue.offer(paramT);
      }
      drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        if ((paramb instanceof b.a.e.c.b))
        {
          paramb = (b.a.e.c.b)paramb;
          int i = paramb.requestFusion(3);
          if (i == 1)
          {
            this.sourceMode = i;
            this.queue = paramb;
            this.done = true;
            this.actual.onSubscribe(this);
            drain();
            return;
          }
          if (i == 2)
          {
            this.sourceMode = i;
            this.queue = paramb;
            this.actual.onSubscribe(this);
            return;
          }
        }
        this.queue = new b.a.e.f.c(this.bufferSize);
        this.actual.onSubscribe(this);
      }
    }
    
    static final class a<R>
      extends AtomicReference<b.a.b.b>
      implements s<R>
    {
      private static final long serialVersionUID = 2620149119579502636L;
      final s<? super R> actual;
      final u.a<?, R> parent;
      
      a(s<? super R> params, u.a<?, R> parama)
      {
        this.actual = params;
        this.parent = parama;
      }
      
      void dispose()
      {
        d.dispose(this);
      }
      
      public void onComplete()
      {
        u.a locala = this.parent;
        locala.active = false;
        locala.drain();
      }
      
      public void onError(Throwable paramThrowable)
      {
        u.a locala = this.parent;
        if (locala.error.addThrowable(paramThrowable))
        {
          if (!locala.tillTheEnd) {
            locala.d.dispose();
          }
          locala.active = false;
          locala.drain();
          return;
        }
        b.a.h.a.a(paramThrowable);
      }
      
      public void onNext(R paramR)
      {
        this.actual.onNext(paramR);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        d.replace(this, paramb);
      }
    }
  }
  
  static final class b<T, U>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = 8828587559905699186L;
    volatile boolean active;
    final s<? super U> actual;
    final int bufferSize;
    volatile boolean disposed;
    volatile boolean done;
    int fusionMode;
    final a<U> inner;
    final h<? super T, ? extends q<? extends U>> mapper;
    g<T> queue;
    b.a.b.b s;
    
    b(s<? super U> params, h<? super T, ? extends q<? extends U>> paramh, int paramInt)
    {
      this.actual = params;
      this.mapper = paramh;
      this.bufferSize = paramInt;
      this.inner = new a(params, this);
    }
    
    public void dispose()
    {
      this.disposed = true;
      this.inner.dispose();
      this.s.dispose();
      if (getAndIncrement() == 0) {
        this.queue.clear();
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      for (;;)
      {
        if (this.disposed)
        {
          this.queue.clear();
          return;
        }
        if (!this.active)
        {
          boolean bool = this.done;
          try
          {
            Object localObject = this.queue.poll();
            int i;
            if (localObject == null) {
              i = 1;
            } else {
              i = 0;
            }
            if ((bool) && (i != 0))
            {
              this.disposed = true;
              this.actual.onComplete();
              return;
            }
            if (i == 0) {
              try
              {
                localObject = (q)b.a.e.b.b.a(this.mapper.apply(localObject), "The mapper returned a null ObservableSource");
                this.active = true;
                ((q)localObject).subscribe(this.inner);
              }
              catch (Throwable localThrowable1)
              {
                b.a.c.b.b(localThrowable1);
                dispose();
                this.queue.clear();
                this.actual.onError(localThrowable1);
                return;
              }
            }
            if (decrementAndGet() != 0) {}
          }
          catch (Throwable localThrowable2)
          {
            b.a.c.b.b(localThrowable2);
            dispose();
            this.queue.clear();
            this.actual.onError(localThrowable2);
            return;
          }
        }
      }
    }
    
    void innerComplete()
    {
      this.active = false;
      drain();
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
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
      this.done = true;
      dispose();
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.done) {
        return;
      }
      if (this.fusionMode == 0) {
        this.queue.offer(paramT);
      }
      drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        if ((paramb instanceof b.a.e.c.b))
        {
          paramb = (b.a.e.c.b)paramb;
          int i = paramb.requestFusion(3);
          if (i == 1)
          {
            this.fusionMode = i;
            this.queue = paramb;
            this.done = true;
            this.actual.onSubscribe(this);
            drain();
            return;
          }
          if (i == 2)
          {
            this.fusionMode = i;
            this.queue = paramb;
            this.actual.onSubscribe(this);
            return;
          }
        }
        this.queue = new b.a.e.f.c(this.bufferSize);
        this.actual.onSubscribe(this);
      }
    }
    
    static final class a<U>
      extends AtomicReference<b.a.b.b>
      implements s<U>
    {
      private static final long serialVersionUID = -7449079488798789337L;
      final s<? super U> actual;
      final u.b<?, ?> parent;
      
      a(s<? super U> params, u.b<?, ?> paramb)
      {
        this.actual = params;
        this.parent = paramb;
      }
      
      void dispose()
      {
        d.dispose(this);
      }
      
      public void onComplete()
      {
        this.parent.innerComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.dispose();
        this.actual.onError(paramThrowable);
      }
      
      public void onNext(U paramU)
      {
        this.actual.onNext(paramU);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        d.set(this, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */