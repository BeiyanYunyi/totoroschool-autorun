package b.a.e.e.d;

import b.a.d.c;
import b.a.e.a.e;
import b.a.q;
import b.a.u;
import b.a.v;
import java.util.concurrent.Callable;

public final class cl<T, R>
  extends u<R>
{
  final q<T> a;
  final Callable<R> b;
  final c<R, ? super T, R> c;
  
  public cl(q<T> paramq, Callable<R> paramCallable, c<R, ? super T, R> paramc)
  {
    this.a = paramq;
    this.b = paramCallable;
    this.c = paramc;
  }
  
  protected void b(v<? super R> paramv)
  {
    try
    {
      Object localObject = b.a.e.b.b.a(this.b.call(), "The seedSupplier returned a null value");
      this.a.subscribe(new ck.a(paramv, this.c, localObject));
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, paramv);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */