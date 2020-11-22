package b.a.e.a;

import b.a.c.e;
import b.a.h.a;
import java.util.concurrent.atomic.AtomicReference;

public enum d
  implements b.a.b.b
{
  private d() {}
  
  public static boolean dispose(AtomicReference<b.a.b.b> paramAtomicReference)
  {
    b.a.b.b localb = (b.a.b.b)paramAtomicReference.get();
    d locald = DISPOSED;
    if (localb != locald)
    {
      paramAtomicReference = (b.a.b.b)paramAtomicReference.getAndSet(locald);
      if (paramAtomicReference != locald)
      {
        if (paramAtomicReference != null) {
          paramAtomicReference.dispose();
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean isDisposed(b.a.b.b paramb)
  {
    return paramb == DISPOSED;
  }
  
  public static boolean replace(AtomicReference<b.a.b.b> paramAtomicReference, b.a.b.b paramb)
  {
    b.a.b.b localb;
    do
    {
      localb = (b.a.b.b)paramAtomicReference.get();
      if (localb == DISPOSED)
      {
        if (paramb != null) {
          paramb.dispose();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localb, paramb));
    return true;
  }
  
  public static void reportDisposableSet()
  {
    a.a(new e("Disposable already set!"));
  }
  
  public static boolean set(AtomicReference<b.a.b.b> paramAtomicReference, b.a.b.b paramb)
  {
    b.a.b.b localb;
    do
    {
      localb = (b.a.b.b)paramAtomicReference.get();
      if (localb == DISPOSED)
      {
        if (paramb != null) {
          paramb.dispose();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localb, paramb));
    if (localb != null) {
      localb.dispose();
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<b.a.b.b> paramAtomicReference, b.a.b.b paramb)
  {
    b.a.e.b.b.a(paramb, "d is null");
    if (!paramAtomicReference.compareAndSet(null, paramb))
    {
      paramb.dispose();
      if (paramAtomicReference.get() != DISPOSED) {
        reportDisposableSet();
      }
      return false;
    }
    return true;
  }
  
  public static boolean trySet(AtomicReference<b.a.b.b> paramAtomicReference, b.a.b.b paramb)
  {
    if (!paramAtomicReference.compareAndSet(null, paramb))
    {
      if (paramAtomicReference.get() == DISPOSED) {
        paramb.dispose();
      }
      return false;
    }
    return true;
  }
  
  public static boolean validate(b.a.b.b paramb1, b.a.b.b paramb2)
  {
    if (paramb2 == null)
    {
      a.a(new NullPointerException("next is null"));
      return false;
    }
    if (paramb1 != null)
    {
      paramb2.dispose();
      reportDisposableSet();
      return false;
    }
    return true;
  }
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */