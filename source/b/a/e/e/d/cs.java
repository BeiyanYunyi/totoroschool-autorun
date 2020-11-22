package b.a.e.e.d;

import b.a.e.a.g;
import b.a.l;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;

public final class cs<T>
  extends a<T, T>
{
  final b.a.d.q<? super Throwable> b;
  final long c;
  
  public cs(l<T> paraml, long paramLong, b.a.d.q<? super Throwable> paramq)
  {
    super(paraml);
    this.b = paramq;
    this.c = paramLong;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    g localg = new g();
    params.onSubscribe(localg);
    new a(params, this.c, this.b, localg, this.a).subscribeNext();
  }
  
  static final class a<T>
    extends AtomicInteger
    implements s<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final s<? super T> actual;
    final b.a.d.q<? super Throwable> predicate;
    long remaining;
    final g sa;
    final b.a.q<? extends T> source;
    
    a(s<? super T> params, long paramLong, b.a.d.q<? super Throwable> paramq, g paramg, b.a.q<? extends T> paramq1)
    {
      this.actual = params;
      this.sa = paramg;
      this.source = paramq1;
      this.predicate = paramq;
      this.remaining = paramLong;
    }
    
    public void onComplete()
    {
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      long l = this.remaining;
      if (l != Long.MAX_VALUE) {
        this.remaining = (l - 1L);
      }
      if (l == 0L)
      {
        this.actual.onError(paramThrowable);
        return;
      }
      try
      {
        boolean bool = this.predicate.a(paramThrowable);
        if (!bool)
        {
          this.actual.onError(paramThrowable);
          return;
        }
        subscribeNext();
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.actual.onError(new b.a.c.a(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.sa.update(paramb);
    }
    
    void subscribeNext()
    {
      if (getAndIncrement() == 0)
      {
        int i = 1;
        int j;
        do
        {
          if (this.sa.isDisposed()) {
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */