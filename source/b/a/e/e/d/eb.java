package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.concurrent.atomic.AtomicBoolean;

public final class eb<T>
  extends a<T, T>
{
  final t b;
  
  public eb(q<T> paramq, t paramt)
  {
    super(paramq);
    this.b = paramt;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends AtomicBoolean
    implements b, s<T>
  {
    private static final long serialVersionUID = 1015244841293359600L;
    final s<? super T> actual;
    b s;
    final t scheduler;
    
    a(s<? super T> params, t paramt)
    {
      this.actual = params;
      this.scheduler = paramt;
    }
    
    public void dispose()
    {
      if (compareAndSet(false, true)) {
        this.scheduler.a(new a());
      }
    }
    
    public boolean isDisposed()
    {
      return get();
    }
    
    public void onComplete()
    {
      if (!get()) {
        this.actual.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (get())
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!get()) {
        this.actual.onNext(paramT);
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
    
    final class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        eb.a.this.s.dispose();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */