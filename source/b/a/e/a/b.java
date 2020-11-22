package b.a.e.a;

import b.a.d.f;
import b.a.h.a;
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends AtomicReference<f>
  implements b.a.b.b
{
  private static final long serialVersionUID = 5718521705281392066L;
  
  public b(f paramf)
  {
    super(paramf);
  }
  
  public void dispose()
  {
    if (get() != null)
    {
      f localf = (f)getAndSet(null);
      if (localf != null) {
        try
        {
          localf.a();
          return;
        }
        catch (Exception localException)
        {
          b.a.c.b.b(localException);
          a.a(localException);
        }
      }
    }
  }
  
  public boolean isDisposed()
  {
    return get() == null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */