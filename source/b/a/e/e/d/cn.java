package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.g;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;

public final class cn<T>
  extends a<T, T>
{
  final long b;
  
  public cn(l<T> paraml, long paramLong)
  {
    super(paraml);
    this.b = paramLong;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    g localg = new g();
    params.onSubscribe(localg);
    long l2 = this.b;
    long l1 = Long.MAX_VALUE;
    if (l2 != Long.MAX_VALUE) {
      l1 = this.b - 1L;
    }
    new a(params, l1, localg, this.a).subscribeNext();
  }
  
  static final class a<T>
    extends AtomicInteger
    implements s<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final s<? super T> actual;
    long remaining;
    final g sd;
    final q<? extends T> source;
    
    a(s<? super T> params, long paramLong, g paramg, q<? extends T> paramq)
    {
      this.actual = params;
      this.sd = paramg;
      this.source = paramq;
      this.remaining = paramLong;
    }
    
    public void onComplete()
    {
      long l = this.remaining;
      if (l != Long.MAX_VALUE) {
        this.remaining = (l - 1L);
      }
      if (l != 0L)
      {
        subscribeNext();
        return;
      }
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      this.sd.replace(paramb);
    }
    
    void subscribeNext()
    {
      if (getAndIncrement() == 0)
      {
        int i = 1;
        int j;
        do
        {
          if (this.sd.isDisposed()) {
            return;
          }
          this.source.subscribe(this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */