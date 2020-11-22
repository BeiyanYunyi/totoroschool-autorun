package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.f.c;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class dp<T>
  extends a<T, T>
{
  final long b;
  final long c;
  final TimeUnit d;
  final t e;
  final int f;
  final boolean g;
  
  public dp(q<T> paramq, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt, int paramInt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramTimeUnit;
    this.e = paramt;
    this.f = paramInt;
    this.g = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b, this.c, this.d, this.e, this.f, this.g));
  }
  
  static final class a<T>
    extends AtomicBoolean
    implements b, s<T>
  {
    private static final long serialVersionUID = -5677354903406201275L;
    final s<? super T> actual;
    volatile boolean cancelled;
    final long count;
    b d;
    final boolean delayError;
    Throwable error;
    final c<Object> queue;
    final t scheduler;
    final long time;
    final TimeUnit unit;
    
    a(s<? super T> params, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt, int paramInt, boolean paramBoolean)
    {
      this.actual = params;
      this.count = paramLong1;
      this.time = paramLong2;
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
        this.d.dispose();
        if (compareAndSet(false, true)) {
          this.queue.clear();
        }
      }
    }
    
    void drain()
    {
      if (!compareAndSet(false, true)) {
        return;
      }
      s locals = this.actual;
      Object localObject1 = this.queue;
      boolean bool = this.delayError;
      for (;;)
      {
        if (this.cancelled)
        {
          ((c)localObject1).clear();
          return;
        }
        if (!bool)
        {
          localObject2 = this.error;
          if (localObject2 != null)
          {
            ((c)localObject1).clear();
            locals.onError((Throwable)localObject2);
            return;
          }
        }
        Object localObject2 = ((c)localObject1).poll();
        int i;
        if (localObject2 == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject1 = this.error;
          if (localObject1 != null)
          {
            locals.onError((Throwable)localObject1);
            return;
          }
          locals.onComplete();
          return;
        }
        Object localObject3 = ((c)localObject1).poll();
        if (((Long)localObject2).longValue() >= this.scheduler.a(this.unit) - this.time) {
          locals.onNext(localObject3);
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      drain();
    }
    
    public void onNext(T paramT)
    {
      c localc = this.queue;
      long l1 = this.scheduler.a(this.unit);
      long l2 = this.time;
      long l3 = this.count;
      int i;
      if (l3 == Long.MAX_VALUE) {
        i = 1;
      } else {
        i = 0;
      }
      localc.a(Long.valueOf(l1), paramT);
      while ((!localc.isEmpty()) && ((((Long)localc.a()).longValue() <= l1 - l2) || ((i == 0) && (localc.b() >> 1 > l3))))
      {
        localc.poll();
        localc.poll();
      }
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */