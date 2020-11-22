package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.a.e;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;

public final class r<T, U>
  extends a<T, U>
{
  final Callable<? extends U> b;
  final b.a.d.b<? super U, ? super T> c;
  
  public r(q<T> paramq, Callable<? extends U> paramCallable, b.a.d.b<? super U, ? super T> paramb)
  {
    super(paramq);
    this.b = paramCallable;
    this.c = paramb;
  }
  
  protected void subscribeActual(s<? super U> params)
  {
    try
    {
      Object localObject = b.a.e.b.b.a(this.b.call(), "The initialSupplier returned a null value");
      this.a.subscribe(new a(params, localObject, this.c));
      return;
    }
    catch (Throwable localThrowable)
    {
      e.error(localThrowable, params);
    }
  }
  
  static final class a<T, U>
    implements b.a.b.b, s<T>
  {
    final s<? super U> a;
    final b.a.d.b<? super U, ? super T> b;
    final U c;
    b.a.b.b d;
    boolean e;
    
    a(s<? super U> params, U paramU, b.a.d.b<? super U, ? super T> paramb)
    {
      this.a = params;
      this.b = paramb;
      this.c = paramU;
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
      this.a.onNext(this.c);
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
      try
      {
        this.b.a(this.c, paramT);
        return;
      }
      catch (Throwable paramT)
      {
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
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */