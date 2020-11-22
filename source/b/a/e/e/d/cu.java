package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.g.e;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cu<T>
  extends a<T, T>
{
  final long b;
  final TimeUnit c;
  final t d;
  final boolean e;
  
  public cu(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.d = paramt;
    this.e = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    params = new e(params);
    if (this.e)
    {
      this.a.subscribe(new a(params, this.b, this.c, this.d));
      return;
    }
    this.a.subscribe(new b(params, this.b, this.c, this.d));
  }
  
  static final class a<T>
    extends cu.c<T>
  {
    private static final long serialVersionUID = -7139995637533111443L;
    final AtomicInteger wip = new AtomicInteger(1);
    
    a(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      super(paramLong, paramTimeUnit, paramt);
    }
    
    void complete()
    {
      emit();
      if (this.wip.decrementAndGet() == 0) {
        this.actual.onComplete();
      }
    }
    
    public void run()
    {
      if (this.wip.incrementAndGet() == 2)
      {
        emit();
        if (this.wip.decrementAndGet() == 0) {
          this.actual.onComplete();
        }
      }
    }
  }
  
  static final class b<T>
    extends cu.c<T>
  {
    private static final long serialVersionUID = -7139995637533111443L;
    
    b(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      super(paramLong, paramTimeUnit, paramt);
    }
    
    void complete()
    {
      this.actual.onComplete();
    }
    
    public void run()
    {
      emit();
    }
  }
  
  static abstract class c<T>
    extends AtomicReference<T>
    implements b, s<T>, Runnable
  {
    private static final long serialVersionUID = -3517602651313910099L;
    final s<? super T> actual;
    final long period;
    b s;
    final t scheduler;
    final AtomicReference<b> timer = new AtomicReference();
    final TimeUnit unit;
    
    c(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      this.actual = params;
      this.period = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramt;
    }
    
    void cancelTimer()
    {
      d.dispose(this.timer);
    }
    
    abstract void complete();
    
    public void dispose()
    {
      cancelTimer();
      this.s.dispose();
    }
    
    void emit()
    {
      Object localObject = getAndSet(null);
      if (localObject != null) {
        this.actual.onNext(localObject);
      }
    }
    
    public boolean isDisposed()
    {
      return this.s.isDisposed();
    }
    
    public void onComplete()
    {
      cancelTimer();
      complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      cancelTimer();
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      lazySet(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
        paramb = this.scheduler.a(this, this.period, this.period, this.unit);
        d.replace(this.timer, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */