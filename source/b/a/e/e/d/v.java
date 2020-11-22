package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.c.g;
import b.a.e.d.m;
import b.a.e.d.n;
import b.a.e.j.i;
import b.a.q;
import b.a.s;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class v<T, R>
  extends a<T, R>
{
  final h<? super T, ? extends q<? extends R>> b;
  final i c;
  final int d;
  final int e;
  
  public v(q<T> paramq, h<? super T, ? extends q<? extends R>> paramh, i parami, int paramInt1, int paramInt2)
  {
    super(paramq);
    this.b = paramh;
    this.c = parami;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    this.a.subscribe(new a(params, this.b, this.d, this.e, this.c));
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements b.a.b.b, n<R>, s<T>
  {
    private static final long serialVersionUID = 8080567949447303262L;
    int activeCount;
    final s<? super R> actual;
    volatile boolean cancelled;
    m<R> current;
    b.a.b.b d;
    volatile boolean done;
    final b.a.e.j.c error;
    final i errorMode;
    final h<? super T, ? extends q<? extends R>> mapper;
    final int maxConcurrency;
    final ArrayDeque<m<R>> observers;
    final int prefetch;
    g<T> queue;
    int sourceMode;
    
    a(s<? super R> params, h<? super T, ? extends q<? extends R>> paramh, int paramInt1, int paramInt2, i parami)
    {
      this.actual = params;
      this.mapper = paramh;
      this.maxConcurrency = paramInt1;
      this.prefetch = paramInt2;
      this.errorMode = parami;
      this.error = new b.a.e.j.c();
      this.observers = new ArrayDeque();
    }
    
    public void dispose()
    {
      this.cancelled = true;
      if (getAndIncrement() == 0)
      {
        this.queue.clear();
        disposeAll();
      }
    }
    
    void disposeAll()
    {
      m localm = this.current;
      if (localm != null) {
        localm.dispose();
      }
      for (;;)
      {
        localm = (m)this.observers.poll();
        if (localm == null) {
          return;
        }
        localm.dispose();
      }
    }
    
    public void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      g localg = this.queue;
      ArrayDeque localArrayDeque = this.observers;
      s locals = this.actual;
      i locali = this.errorMode;
      int i = 1;
      int j;
      do
      {
        for (;;)
        {
          j = this.activeCount;
          while (j != this.maxConcurrency)
          {
            if (this.cancelled)
            {
              localg.clear();
              disposeAll();
              return;
            }
            if ((locali == i.IMMEDIATE) && ((Throwable)this.error.get() != null))
            {
              localg.clear();
              disposeAll();
              locals.onError(this.error.terminate());
              return;
            }
            try
            {
              Object localObject1 = localg.poll();
              if (localObject1 != null)
              {
                localObject1 = (q)b.a.e.b.b.a(this.mapper.apply(localObject1), "The mapper returned a null ObservableSource");
                localObject3 = new m(this, this.prefetch);
                localArrayDeque.offer(localObject3);
                ((q)localObject1).subscribe((s)localObject3);
                j += 1;
              }
            }
            catch (Throwable localThrowable1)
            {
              b.a.c.b.b(localThrowable1);
              this.d.dispose();
              localg.clear();
              disposeAll();
              this.error.addThrowable(localThrowable1);
              locals.onError(this.error.terminate());
              return;
            }
          }
          this.activeCount = j;
          if (this.cancelled)
          {
            localg.clear();
            disposeAll();
            return;
          }
          if ((locali == i.IMMEDIATE) && ((Throwable)this.error.get() != null))
          {
            localg.clear();
            disposeAll();
            locals.onError(this.error.terminate());
            return;
          }
          Object localObject3 = this.current;
          Object localObject2 = localObject3;
          if (localObject3 == null)
          {
            if ((locali == i.BOUNDARY) && ((Throwable)this.error.get() != null))
            {
              localg.clear();
              disposeAll();
              locals.onError(this.error.terminate());
              return;
            }
            bool = this.done;
            localObject2 = (m)localArrayDeque.poll();
            if (localObject2 == null) {
              j = 1;
            } else {
              j = 0;
            }
            if ((bool) && (j != 0))
            {
              if ((Throwable)this.error.get() != null)
              {
                localg.clear();
                disposeAll();
                locals.onError(this.error.terminate());
                return;
              }
              locals.onComplete();
              return;
            }
            if (j == 0) {
              this.current = ((m)localObject2);
            }
          }
          if (localObject2 == null) {
            break;
          }
          localObject3 = ((m)localObject2).queue();
          if (this.cancelled)
          {
            localg.clear();
            disposeAll();
            return;
          }
          boolean bool = ((m)localObject2).isDone();
          if ((locali == i.IMMEDIATE) && ((Throwable)this.error.get() != null))
          {
            localg.clear();
            disposeAll();
            locals.onError(this.error.terminate());
            return;
          }
          try
          {
            Object localObject4 = ((g)localObject3).poll();
            if (localObject4 == null) {
              j = 1;
            } else {
              j = 0;
            }
            if ((bool) && (j != 0))
            {
              this.current = null;
              this.activeCount -= 1;
            }
            else
            {
              if (j != 0) {
                break;
              }
              locals.onNext(localObject4);
            }
          }
          catch (Throwable localThrowable2)
          {
            b.a.c.b.b(localThrowable2);
            this.error.addThrowable(localThrowable2);
            this.current = null;
            this.activeCount -= 1;
          }
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public void innerComplete(m<R> paramm)
    {
      paramm.setDone();
      drain();
    }
    
    public void innerError(m<R> paramm, Throwable paramThrowable)
    {
      if (this.error.addThrowable(paramThrowable))
      {
        if (this.errorMode == i.IMMEDIATE) {
          this.d.dispose();
        }
        paramm.setDone();
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void innerNext(m<R> paramm, R paramR)
    {
      paramm.queue().offer(paramR);
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
        this.queue = new b.a.e.f.c(this.prefetch);
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */