package b.a.e.a;

import b.a.b.b;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class a
  extends AtomicReferenceArray<b>
  implements b
{
  private static final long serialVersionUID = 2746389416410565408L;
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public void dispose()
  {
    int i = 0;
    if (get(0) != d.DISPOSED)
    {
      int j = length();
      while (i < j)
      {
        if ((b)get(i) != d.DISPOSED)
        {
          b localb = (b)getAndSet(i, d.DISPOSED);
          if ((localb != d.DISPOSED) && (localb != null)) {
            localb.dispose();
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean isDisposed()
  {
    boolean bool = false;
    if (get(0) == d.DISPOSED) {
      bool = true;
    }
    return bool;
  }
  
  public b replaceResource(int paramInt, b paramb)
  {
    b localb;
    do
    {
      localb = (b)get(paramInt);
      if (localb == d.DISPOSED)
      {
        paramb.dispose();
        return null;
      }
    } while (!compareAndSet(paramInt, localb, paramb));
    return localb;
  }
  
  public boolean setResource(int paramInt, b paramb)
  {
    b localb;
    do
    {
      localb = (b)get(paramInt);
      if (localb == d.DISPOSED)
      {
        paramb.dispose();
        return false;
      }
    } while (!compareAndSet(paramInt, localb, paramb));
    if (localb != null) {
      localb.dispose();
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */