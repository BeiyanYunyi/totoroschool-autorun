package b.a.e.e.d;

import b.a.d.e;
import b.a.e.a.g;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;

public final class co<T>
  extends a<T, T>
{
  final e b;
  
  public co(l<T> paraml, e parame)
  {
    super(paraml);
    this.b = parame;
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
    final g sd;
    final q<? extends T> source;
    final e stop;
    
    a(s<? super T> params, e parame, g paramg, q<? extends T> paramq)
    {
      this.actual = params;
      this.sd = paramg;
      this.source = paramq;
      this.stop = parame;
    }
    
    public void onComplete()
    {
      try
      {
        boolean bool = this.stop.a();
        if (bool)
        {
          this.actual.onComplete();
          return;
        }
        subscribeNext();
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.actual.onError(localThrowable);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
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
          this.source.subscribe(this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */