package b.a.e.e.d;

import b.a.d.c;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;

public final class cy<T, R>
  extends a<T, R>
{
  final c<R, ? super T, R> b;
  final Callable<R> c;
  
  public cy(q<T> paramq, Callable<R> paramCallable, c<R, ? super T, R> paramc)
  {
    super(paramq);
    this.b = paramc;
    this.c = paramCallable;
  }
  
  public void subscribeActual(s<? super R> params)
  {
    try
    {
      Object localObject = b.a.e.b.b.a(this.c.call(), "The seed supplied is null");
      this.a.subscribe(new a(params, this.b, localObject));
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, params);
    }
  }
  
  static final class a<T, R>
    implements b.a.b.b, s<T>
  {
    final s<? super R> a;
    final c<R, ? super T, R> b;
    R c;
    b.a.b.b d;
    boolean e;
    
    a(s<? super R> params, c<R, ? super T, R> paramc, R paramR)
    {
      this.a = params;
      this.b = paramc;
      this.c = paramR;
    }
    
    public void dispose()
    {
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.e) {
        return;
      }
      this.e = true;
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.e)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.e = true;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.e) {
        return;
      }
      Object localObject = this.c;
      try
      {
        paramT = b.a.e.b.b.a(this.b.a(localObject, paramT), "The accumulator returned a null value");
        this.c = paramT;
        this.a.onNext(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.d.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.a.onSubscribe(this);
        this.a.onNext(this.c);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */