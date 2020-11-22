package b.a.e.e.d;

import b.a.e.a.e;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;

public final class ae<T>
  extends l<T>
{
  final Callable<? extends q<? extends T>> a;
  
  public ae(Callable<? extends q<? extends T>> paramCallable)
  {
    this.a = paramCallable;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    try
    {
      q localq = (q)b.a.e.b.b.a(this.a.call(), "null ObservableSource supplied");
      localq.subscribe(params);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, params);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */