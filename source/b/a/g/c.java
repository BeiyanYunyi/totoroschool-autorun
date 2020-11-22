package b.a.g;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.j.h;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c<T>
  implements b, s<T>
{
  final AtomicReference<b> f = new AtomicReference();
  
  protected void c() {}
  
  public final void dispose()
  {
    d.dispose(this.f);
  }
  
  public final boolean isDisposed()
  {
    return this.f.get() == d.DISPOSED;
  }
  
  public final void onSubscribe(b paramb)
  {
    if (h.a(this.f, paramb, getClass())) {
      c();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */