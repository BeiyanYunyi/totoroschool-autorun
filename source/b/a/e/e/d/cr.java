package b.a.e.e.d;

import b.a.d.d;
import b.a.e.a.g;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;

public final class cr<T>
  extends a<T, T>
{
  final d<? super Integer, ? super Throwable> b;
  
  public cr(l<T> paraml, d<? super Integer, ? super Throwable> paramd)
  {
    super(paraml);
    this.b = paramd;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    g localg = new g();
    params.onSubscribe(localg);
    new a(params, this.b, localg, this.a).subscribeNext();
  }
  
  static final class a<T>
    extends AtomicInteger
    implements s<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final s<? super T> actual;
    final d<? super Integer, ? super Throwable> predicate;
    int retries;
    final g sa;
    final q<? extends T> source;
    
    a(s<? super T> params, d<? super Integer, ? super Throwable> paramd, g paramg, q<? extends T> paramq)
    {
      this.actual = params;
      this.sa = paramg;
      this.source = paramq;
      this.predicate = paramd;
    }
    
    public void onComplete()
    {
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        d locald = this.predicate;
        int i = this.retries + 1;
        this.retries = i;
        boolean bool = locald.a(Integer.valueOf(i), paramThrowable);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */