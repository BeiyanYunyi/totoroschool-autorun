package b.a.e.e.a;

import b.a.e.j.d;
import b.a.f;
import b.a.g;
import java.util.concurrent.atomic.AtomicLong;

public final class e<T>
  extends a<T, T>
{
  public e(f<T> paramf)
  {
    super(paramf);
  }
  
  protected void b(org.a.b<? super T> paramb)
  {
    this.b.a(new a(paramb));
  }
  
  static final class a<T>
    extends AtomicLong
    implements g<T>, org.a.c
  {
    private static final long serialVersionUID = -3176480756392482682L;
    final org.a.b<? super T> actual;
    boolean done;
    org.a.c s;
    
    a(org.a.b<? super T> paramb)
    {
      this.actual = paramb;
    }
    
    public void cancel()
    {
      this.s.cancel();
    }
    
    public void onComplete()
    {
      if (this.done) {
        return;
      }
      this.done = true;
      this.actual.onComplete();
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
    }
    
    public void onNext(T paramT)
    {
      if (this.done) {
        return;
      }
      if (get() != 0L)
      {
        this.actual.onNext(paramT);
        d.b(this, 1L);
        return;
      }
      onError(new b.a.c.c("could not emit value due to lack of requests"));
    }
    
    public void onSubscribe(org.a.c paramc)
    {
      if (b.a.e.i.b.validate(this.s, paramc))
      {
        this.s = paramc;
        this.actual.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
    
    public void request(long paramLong)
    {
      if (b.a.e.i.b.validate(paramLong)) {
        d.a(this, paramLong);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */