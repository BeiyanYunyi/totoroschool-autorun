package b.a;

import b.a.e.d.g;
import b.a.h.a;

public abstract class h<T>
  implements j<T>
{
  public final T a()
  {
    g localg = new g();
    a(localg);
    return (T)localg.b();
  }
  
  public final void a(i<? super T> parami)
  {
    b.a.e.b.b.a(parami, "observer is null");
    parami = a.a(this, parami);
    b.a.e.b.b.a(parami, "observer returned by the RxJavaPlugins hook is null");
    try
    {
      b(parami);
      return;
    }
    catch (Throwable parami)
    {
      b.a.c.b.b(parami);
      NullPointerException localNullPointerException = new NullPointerException("subscribeActual failed");
      localNullPointerException.initCause(parami);
      throw localNullPointerException;
    }
    catch (NullPointerException parami)
    {
      throw parami;
    }
  }
  
  protected abstract void b(i<? super T> parami);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */