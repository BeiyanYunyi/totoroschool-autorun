package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.a.e;
import b.a.q;
import b.a.s;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class dz<T, U extends Collection<? super T>>
  extends a<T, U>
{
  final Callable<U> b;
  
  public dz(q<T> paramq, int paramInt)
  {
    super(paramq);
    this.b = b.a.e.b.a.a(paramInt);
  }
  
  public dz(q<T> paramq, Callable<U> paramCallable)
  {
    super(paramq);
    this.b = paramCallable;
  }
  
  public void subscribeActual(s<? super U> params)
  {
    try
    {
      Collection localCollection = (Collection)b.a.e.b.b.a(this.b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.a.subscribe(new a(params, localCollection));
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, params);
    }
  }
  
  static final class a<T, U extends Collection<? super T>>
    implements b.a.b.b, s<T>
  {
    U a;
    final s<? super U> b;
    b.a.b.b c;
    
    a(s<? super U> params, U paramU)
    {
      this.b = params;
      this.a = paramU;
    }
    
    public void dispose()
    {
      this.c.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.c.isDisposed();
    }
    
    public void onComplete()
    {
      Collection localCollection = this.a;
      this.a = null;
      this.b.onNext(localCollection);
      this.b.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a = null;
      this.b.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.a.add(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        this.b.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */