package b.a.e.e.d;

import b.a.d.c;
import b.a.e.a.d;
import b.a.g.e;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class ei<T, U, R>
  extends a<T, R>
{
  final c<? super T, ? super U, ? extends R> b;
  final q<? extends U> c;
  
  public ei(q<T> paramq, c<? super T, ? super U, ? extends R> paramc, q<? extends U> paramq1)
  {
    super(paramq);
    this.b = paramc;
    this.c = paramq1;
  }
  
  public void subscribeActual(s<? super R> params)
  {
    params = new e(params);
    b localb = new b(params, this.b);
    params.onSubscribe(localb);
    this.c.subscribe(new a(localb));
    this.a.subscribe(localb);
  }
  
  final class a
    implements s<U>
  {
    private final ei.b<T, U, R> b;
    
    a()
    {
      ei.b localb;
      this.b = localb;
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      this.b.otherError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      this.b.lazySet(paramU);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.b.setOther(paramb);
    }
  }
  
  static final class b<T, U, R>
    extends AtomicReference<U>
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = -312246233408980075L;
    final s<? super R> actual;
    final c<? super T, ? super U, ? extends R> combiner;
    final AtomicReference<b.a.b.b> other = new AtomicReference();
    final AtomicReference<b.a.b.b> s = new AtomicReference();
    
    b(s<? super R> params, c<? super T, ? super U, ? extends R> paramc)
    {
      this.actual = params;
      this.combiner = paramc;
    }
    
    public void dispose()
    {
      d.dispose(this.s);
      d.dispose(this.other);
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)this.s.get());
    }
    
    public void onComplete()
    {
      d.dispose(this.other);
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      d.dispose(this.other);
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      Object localObject = get();
      if (localObject != null) {
        try
        {
          paramT = b.a.e.b.b.a(this.combiner.a(paramT, localObject), "The combiner returned a null value");
          this.actual.onNext(paramT);
          return;
        }
        catch (Throwable paramT)
        {
          b.a.c.b.b(paramT);
          dispose();
          this.actual.onError(paramT);
          return;
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this.s, paramb);
    }
    
    public void otherError(Throwable paramThrowable)
    {
      d.dispose(this.s);
      this.actual.onError(paramThrowable);
    }
    
    public boolean setOther(b.a.b.b paramb)
    {
      return d.setOnce(this.other, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */