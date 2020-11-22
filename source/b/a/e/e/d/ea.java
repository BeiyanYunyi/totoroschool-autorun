package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.a.e;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.u;
import b.a.v;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ea<T, U extends Collection<? super T>>
  extends u<U>
  implements b.a.e.c.a<U>
{
  final q<T> a;
  final Callable<U> b;
  
  public ea(q<T> paramq, int paramInt)
  {
    this.a = paramq;
    this.b = b.a.e.b.a.a(paramInt);
  }
  
  public ea(q<T> paramq, Callable<U> paramCallable)
  {
    this.a = paramq;
    this.b = paramCallable;
  }
  
  public void b(v<? super U> paramv)
  {
    try
    {
      Collection localCollection = (Collection)b.a.e.b.b.a(this.b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.a.subscribe(new a(paramv, localCollection));
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, paramv);
    }
  }
  
  public l<U> e_()
  {
    return b.a.h.a.a(new dz(this.a, this.b));
  }
  
  static final class a<T, U extends Collection<? super T>>
    implements b.a.b.b, s<T>
  {
    final v<? super U> a;
    U b;
    b.a.b.b c;
    
    a(v<? super U> paramv, U paramU)
    {
      this.a = paramv;
      this.b = paramU;
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
      Collection localCollection = this.b;
      this.b = null;
      this.a.onSuccess(localCollection);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.b = null;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.b.add(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */