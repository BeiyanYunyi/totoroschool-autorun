package b.a.e.h;

import b.a.e.j.k;
import b.a.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class a<T>
  extends AtomicInteger
  implements g<T>, org.a.c
{
  private static final long serialVersionUID = -4945028590049415624L;
  final org.a.b<? super T> actual;
  volatile boolean done;
  final b.a.e.j.c error;
  final AtomicBoolean once;
  final AtomicLong requested;
  final AtomicReference<org.a.c> s;
  
  public a(org.a.b<? super T> paramb)
  {
    this.actual = paramb;
    this.error = new b.a.e.j.c();
    this.requested = new AtomicLong();
    this.s = new AtomicReference();
    this.once = new AtomicBoolean();
  }
  
  public void cancel()
  {
    if (!this.done) {
      b.a.e.i.b.cancel(this.s);
    }
  }
  
  public void onComplete()
  {
    this.done = true;
    k.a(this.actual, this, this.error);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.done = true;
    k.a(this.actual, paramThrowable, this, this.error);
  }
  
  public void onNext(T paramT)
  {
    k.a(this.actual, paramT, this, this.error);
  }
  
  public void onSubscribe(org.a.c paramc)
  {
    if (this.once.compareAndSet(false, true))
    {
      this.actual.onSubscribe(this);
      b.a.e.i.b.deferredSetOnce(this.s, this.requested, paramc);
      return;
    }
    paramc.cancel();
    cancel();
    onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
  }
  
  public void request(long paramLong)
  {
    if (paramLong <= 0L)
    {
      cancel();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("§3.9 violated: positive request amount required but it was ");
      localStringBuilder.append(paramLong);
      onError(new IllegalArgumentException(localStringBuilder.toString()));
      return;
    }
    b.a.e.i.b.deferredRequest(this.s, this.requested, paramLong);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */