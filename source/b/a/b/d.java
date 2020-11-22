package b.a.b;

import java.util.concurrent.atomic.AtomicReference;

abstract class d<T>
  extends AtomicReference<T>
  implements b
{
  private static final long serialVersionUID = 6537757548749041217L;
  
  d(T paramT)
  {
    super(b.a.e.b.b.a(paramT, "value is null"));
  }
  
  public final void dispose()
  {
    if (get() != null)
    {
      Object localObject = getAndSet(null);
      if (localObject != null) {
        onDisposed(localObject);
      }
    }
  }
  
  public final boolean isDisposed()
  {
    return get() == null;
  }
  
  protected abstract void onDisposed(T paramT);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */