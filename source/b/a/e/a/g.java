package b.a.e.a;

import b.a.b.b;
import java.util.concurrent.atomic.AtomicReference;

public final class g
  extends AtomicReference<b>
  implements b
{
  private static final long serialVersionUID = -754898800686245608L;
  
  public g() {}
  
  public g(b paramb)
  {
    lazySet(paramb);
  }
  
  public void dispose()
  {
    d.dispose(this);
  }
  
  public boolean isDisposed()
  {
    return d.isDisposed((b)get());
  }
  
  public boolean replace(b paramb)
  {
    return d.replace(this, paramb);
  }
  
  public boolean update(b paramb)
  {
    return d.set(this, paramb);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */