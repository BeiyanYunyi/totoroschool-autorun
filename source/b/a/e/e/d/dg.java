package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.f.c;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class dg<T>
  extends a<T, T>
{
  final long b;
  final TimeUnit c;
  final t d;
  final int e;
  final boolean f;
  
  public dg(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, t paramt, int paramInt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.d = paramt;
    this.e = paramInt;
    this.f = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b, this.c, this.d, this.e, this.f));
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b, s<T>
  {
    private static final long serialVersionUID = -5677354903406201275L;
    final s<? super T> actual;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final c<Object> queue;
    b s;
    final t scheduler;
    final long time;
    final TimeUnit unit;
    
    a(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t paramt, int paramInt, boolean paramBoolean)
    {
      this.actual = params;
      this.time = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramt;
      this.queue = new c(paramInt);
      this.delayError = paramBoolean;
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.s.dispose();
        if (getAndIncrement() == 0) {
          this.queue.clear();
        }
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.actual;
      Object localObject1 = this.queue;
      boolean bool1 = this.delayError;
      TimeUnit localTimeUnit = this.unit;
      t localt = this.scheduler;
      long l1 = this.time;
      int j = 1;
      for (;;)
      {
        if (this.cancelled)
        {
          this.queue.clear();
          return;
        }
        boolean bool2 = this.done;
        Object localObject2 = (Long)((c)localObject1).a();
        int i;
        if (localObject2 == null) {
          i = 1;
        } else {
          i = 0;
        }
        long l2 = localt.a(localTimeUnit);
        int k = i;
        if (i == 0)
        {
          k = i;
          if (((Long)localObject2).longValue() > l2 - l1) {
            k = 1;
          }
        }
        if (bool2) {
          if (bool1)
          {
            if (k != 0)
            {
              localObject1 = this.error;
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
            localObject2 = this.error;
            if (localObject2 != null)
            {
              this.queue.clear();
              locals.onError((Throwable)localObject2);
              return;
            }
            if (k != 0)
            {
              locals.onComplete();
              return;
            }
          }
        }
        if (k != 0)
        {
          i = addAndGet(-j);
          j = i;
          if (i != 0) {}
        }
        else
        {
          ((c)localObject1).poll();
          locals.onNext(((c)localObject1).poll());
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
      this.error = paramThrowable;
      this.done = true;
      drain();
    }
    
    public void onNext(T paramT)
    {
      this.queue.a(Long.valueOf(this.scheduler.a(this.unit)), paramT);
      drain();
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */