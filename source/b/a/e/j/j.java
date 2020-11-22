package b.a.e.j;

import b.a.c.a;
import java.util.concurrent.atomic.AtomicReference;

public final class j
{
  public static final Throwable a = new a();
  
  public static RuntimeException a(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof Error))
    {
      if ((paramThrowable instanceof RuntimeException)) {
        return (RuntimeException)paramThrowable;
      }
      return new RuntimeException(paramThrowable);
    }
    throw ((Error)paramThrowable);
  }
  
  public static <T> Throwable a(AtomicReference<Throwable> paramAtomicReference)
  {
    Throwable localThrowable2 = (Throwable)paramAtomicReference.get();
    Throwable localThrowable1 = localThrowable2;
    if (localThrowable2 != a) {
      localThrowable1 = (Throwable)paramAtomicReference.getAndSet(a);
    }
    return localThrowable1;
  }
  
  public static <T> boolean a(AtomicReference<Throwable> paramAtomicReference, Throwable paramThrowable)
  {
    Throwable localThrowable;
    Object localObject;
    do
    {
      localThrowable = (Throwable)paramAtomicReference.get();
      if (localThrowable == a) {
        return false;
      }
      if (localThrowable == null) {
        localObject = paramThrowable;
      } else {
        localObject = new a(new Throwable[] { localThrowable, paramThrowable });
      }
    } while (!paramAtomicReference.compareAndSet(localThrowable, localObject));
    return true;
  }
  
  static final class a
    extends Throwable
  {
    private static final long serialVersionUID = -4649703670690200604L;
    
    a()
    {
      super();
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */