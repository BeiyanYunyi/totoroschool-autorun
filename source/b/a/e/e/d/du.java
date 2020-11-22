package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class du<T>
  extends a<T, T>
{
  final long b;
  final TimeUnit c;
  final t d;
  final boolean e;
  
  public du(l<T> paraml, long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    super(paraml);
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.d = paramt;
    this.e = paramBoolean;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b, this.c, this.d.a(), this.e));
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b, s<T>, Runnable
  {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final s<? super T> downstream;
    final boolean emitLast;
    Throwable error;
    final AtomicReference<T> latest;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    b upstream;
    final t.c worker;
    
    a(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t.c paramc, boolean paramBoolean)
    {
      this.downstream = params;
      this.timeout = paramLong;
      this.unit = paramTimeUnit;
      this.worker = paramc;
      this.emitLast = paramBoolean;
      this.latest = new AtomicReference();
    }
    
    public void dispose()
    {
      this.cancelled = true;
      this.upstream.dispose();
      this.worker.dispose();
      if (getAndIncrement() == 0) {
        this.latest.lazySet(null);
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      Object localObject = this.latest;
      s locals = this.downstream;
      int i = 1;
      for (;;)
      {
        if (this.cancelled)
        {
          ((AtomicReference)localObject).lazySet(null);
          return;
        }
        boolean bool = this.done;
        if ((bool) && (this.error != null))
        {
          ((AtomicReference)localObject).lazySet(null);
          locals.onError(this.error);
          this.worker.dispose();
          return;
        }
        if (((AtomicReference)localObject).get() == null) {
          j = 1;
        } else {
          j = 0;
        }
        if (bool)
        {
          localObject = ((AtomicReference)localObject).getAndSet(null);
          if ((j == 0) && (this.emitLast)) {
            locals.onNext(localObject);
          }
          locals.onComplete();
          this.worker.dispose();
          return;
        }
        if (j != 0)
        {
          if (this.timerFired)
          {
            this.timerRunning = false;
            this.timerFired = false;
          }
        }
        else {
          if ((!this.timerRunning) || (this.timerFired)) {
            break label194;
          }
        }
        int j = addAndGet(-i);
        i = j;
        if (j == 0)
        {
          return;
          label194:
          locals.onNext(((AtomicReference)localObject).getAndSet(null));
          this.timerFired = false;
          this.timerRunning = true;
          this.worker.a(this, this.timeout, this.unit);
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
      this.latest.set(paramT);
      drain();
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.upstream, paramb))
      {
        this.upstream = paramb;
        this.downstream.onSubscribe(this);
      }
    }
    
    public void run()
    {
      this.timerFired = true;
      drain();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */