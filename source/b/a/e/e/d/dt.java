package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.g.e;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class dt<T>
  extends a<T, T>
{
  final long b;
  final TimeUnit c;
  final t d;
  
  public dt(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    super(paramq);
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.d = paramt;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(new e(params), this.b, this.c, this.d.a()));
  }
  
  static final class a<T>
    extends AtomicReference<b>
    implements b, s<T>, Runnable
  {
    private static final long serialVersionUID = 786994795061867455L;
    final s<? super T> actual;
    boolean done;
    volatile boolean gate;
    b s;
    final long timeout;
    final TimeUnit unit;
    final t.c worker;
    
    a(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t.c paramc)
    {
      this.actual = params;
      this.timeout = paramLong;
      this.unit = paramTimeUnit;
      this.worker = paramc;
    }
    
    public void dispose()
    {
      this.s.dispose();
      this.worker.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.worker.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.done)
      {
        this.done = true;
        this.actual.onComplete();
        this.worker.dispose();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.done)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.done = true;
      this.actual.onError(paramThrowable);
      this.worker.dispose();
    }
    
    public void onNext(T paramT)
    {
      if ((!this.gate) && (!this.done))
      {
        this.gate = true;
        this.actual.onNext(paramT);
        paramT = (b)get();
        if (paramT != null) {
          paramT.dispose();
        }
        d.replace(this, this.worker.a(this, this.timeout, this.unit));
      }
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
    
    public void run()
    {
      this.gate = false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */