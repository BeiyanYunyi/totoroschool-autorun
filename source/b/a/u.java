package b.a;

import b.a.d.h;
import b.a.e.d.g;

public abstract class u<T>
  implements w<T>
{
  public final <R> u<R> a(h<? super T, ? extends R> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new b.a.e.e.e.a(this, paramh));
  }
  
  public final T a()
  {
    g localg = new g();
    a(localg);
    return (T)localg.b();
  }
  
  public final void a(v<? super T> paramv)
  {
    b.a.e.b.b.a(paramv, "subscriber is null");
    paramv = b.a.h.a.a(this, paramv);
    b.a.e.b.b.a(paramv, "subscriber returned by the RxJavaPlugins hook is null");
    try
    {
      b(paramv);
      return;
    }
    catch (Throwable paramv)
    {
      b.a.c.b.b(paramv);
      NullPointerException localNullPointerException = new NullPointerException("subscribeActual failed");
      localNullPointerException.initCause(paramv);
      throw localNullPointerException;
    }
    catch (NullPointerException paramv)
    {
      throw paramv;
    }
  }
  
  public final l<T> b()
  {
    if ((this instanceof b.a.e.c.a)) {
      return ((b.a.e.c.a)this).e_();
    }
    return b.a.h.a.a(new b.a.e.e.e.b(this));
  }
  
  protected abstract void b(v<? super T> paramv);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */