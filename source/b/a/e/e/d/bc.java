package b.a.e.e.d;

import b.a.e.d.i;
import b.a.h.a;
import b.a.l;
import b.a.s;
import java.util.concurrent.Callable;

public final class bc<T>
  extends l<T>
  implements Callable<T>
{
  final Callable<? extends T> a;
  
  public bc(Callable<? extends T> paramCallable)
  {
    this.a = paramCallable;
  }
  
  public T call()
    throws Exception
  {
    return (T)b.a.e.b.b.a(this.a.call(), "The callable returned a null value");
  }
  
  public void subscribeActual(s<? super T> params)
  {
    i locali = new i(params);
    params.onSubscribe(locali);
    if (locali.isDisposed()) {
      return;
    }
    try
    {
      Object localObject = b.a.e.b.b.a(this.a.call(), "Callable returned null");
      locali.complete(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      if (!locali.isDisposed())
      {
        params.onError(localThrowable);
        return;
      }
      a.a(localThrowable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */