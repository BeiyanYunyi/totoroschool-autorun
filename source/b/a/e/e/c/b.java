package b.a.e.e.c;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.c.f;
import b.a.h.a;
import b.a.j;
import b.a.l;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T, R>
  extends l<R>
{
  final l<T> a;
  final h<? super T, ? extends j<? extends R>> b;
  final b.a.e.j.i c;
  final int d;
  
  public b(l<T> paraml, h<? super T, ? extends j<? extends R>> paramh, b.a.e.j.i parami, int paramInt)
  {
    this.a = paraml;
    this.b = paramh;
    this.c = parami;
    this.d = paramInt;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    if (!g.a(this.a, this.b, params)) {
      this.a.subscribe(new a(params, this.b, this.d, this.c));
    }
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    volatile boolean done;
    final s<? super R> downstream;
    final b.a.e.j.i errorMode;
    final b.a.e.j.c errors;
    final a<R> inner;
    R item;
    final h<? super T, ? extends j<? extends R>> mapper;
    final f<T> queue;
    volatile int state;
    b.a.b.b upstream;
    
    a(s<? super R> params, h<? super T, ? extends j<? extends R>> paramh, int paramInt, b.a.e.j.i parami)
    {
      this.downstream = params;
      this.mapper = paramh;
      this.errorMode = parami;
      this.errors = new b.a.e.j.c();
      this.inner = new a(this);
      this.queue = new b.a.e.f.c(paramInt);
    }
    
    public void dispose()
    {
      this.cancelled = true;
      this.upstream.dispose();
      this.inner.dispose();
      if (getAndIncrement() == 0)
      {
        this.queue.clear();
        this.item = null;
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.downstream;
      b.a.e.j.i locali = this.errorMode;
      Object localObject1 = this.queue;
      b.a.e.j.c localc = this.errors;
      int i = 1;
      int j;
      do
      {
        for (;;)
        {
          if (this.cancelled)
          {
            ((f)localObject1).clear();
            this.item = null;
            break;
          }
          int k = this.state;
          if ((localc.get() != null) && ((locali == b.a.e.j.i.IMMEDIATE) || ((locali == b.a.e.j.i.BOUNDARY) && (k == 0))))
          {
            ((f)localObject1).clear();
            this.item = null;
            locals.onError(localc.terminate());
            return;
          }
          j = 0;
          if (k == 0)
          {
            boolean bool = this.done;
            localObject2 = ((f)localObject1).poll();
            if (localObject2 == null) {
              j = 1;
            }
            if ((bool) && (j != 0))
            {
              localObject1 = localc.terminate();
              if (localObject1 == null)
              {
                locals.onComplete();
                return;
              }
              locals.onError((Throwable)localObject1);
              return;
            }
            if (j != 0) {
              break;
            }
            try
            {
              localObject2 = (j)b.a.e.b.b.a(this.mapper.apply(localObject2), "The mapper returned a null MaybeSource");
              this.state = 1;
              ((j)localObject2).a(this.inner);
            }
            catch (Throwable localThrowable)
            {
              b.a.c.b.b(localThrowable);
              this.upstream.dispose();
              ((f)localObject1).clear();
              localc.addThrowable(localThrowable);
              locals.onError(localc.terminate());
              return;
            }
          }
          if (k != 2) {
            break;
          }
          Object localObject2 = this.item;
          this.item = null;
          locals.onNext(localObject2);
          this.state = 0;
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    void innerComplete()
    {
      this.state = 0;
      drain();
    }
    
    void innerError(Throwable paramThrowable)
    {
      if (this.errors.addThrowable(paramThrowable))
      {
        if (this.errorMode != b.a.e.j.i.END) {
          this.upstream.dispose();
        }
        this.state = 0;
        drain();
        return;
      }
      a.a(paramThrowable);
    }
    
    void innerSuccess(R paramR)
    {
      this.item = paramR;
      this.state = 2;
      drain();
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
      if (this.errors.addThrowable(paramThrowable))
      {
        if (this.errorMode == b.a.e.j.i.IMMEDIATE) {
          this.inner.dispose();
        }
        this.done = true;
        drain();
        return;
      }
      a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.queue.offer(paramT);
      drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.upstream, paramb))
      {
        this.upstream = paramb;
        this.downstream.onSubscribe(this);
      }
    }
    
    static final class a<R>
      extends AtomicReference<b.a.b.b>
      implements b.a.i<R>
    {
      private static final long serialVersionUID = -3051469169682093892L;
      final b.a<?, R> parent;
      
      a(b.a<?, R> parama)
      {
        this.parent = parama;
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
        this.parent.innerError(paramThrowable);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        d.replace(this, paramb);
      }
      
      public void onSuccess(R paramR)
      {
        this.parent.innerSuccess(paramR);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */