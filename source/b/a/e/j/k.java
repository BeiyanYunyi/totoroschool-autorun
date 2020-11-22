package b.a.e.j;

import b.a.h.a;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.b;

public final class k
{
  public static <T> void a(s<? super T> params, T paramT, AtomicInteger paramAtomicInteger, c paramc)
  {
    if ((paramAtomicInteger.get() == 0) && (paramAtomicInteger.compareAndSet(0, 1)))
    {
      params.onNext(paramT);
      if (paramAtomicInteger.decrementAndGet() != 0)
      {
        paramT = paramc.terminate();
        if (paramT != null)
        {
          params.onError(paramT);
          return;
        }
        params.onComplete();
      }
    }
  }
  
  public static void a(s<?> params, Throwable paramThrowable, AtomicInteger paramAtomicInteger, c paramc)
  {
    if (paramc.addThrowable(paramThrowable))
    {
      if (paramAtomicInteger.getAndIncrement() == 0) {
        params.onError(paramc.terminate());
      }
    }
    else {
      a.a(paramThrowable);
    }
  }
  
  public static void a(s<?> params, AtomicInteger paramAtomicInteger, c paramc)
  {
    if (paramAtomicInteger.getAndIncrement() == 0)
    {
      paramAtomicInteger = paramc.terminate();
      if (paramAtomicInteger != null)
      {
        params.onError(paramAtomicInteger);
        return;
      }
      params.onComplete();
    }
  }
  
  public static <T> void a(b<? super T> paramb, T paramT, AtomicInteger paramAtomicInteger, c paramc)
  {
    if ((paramAtomicInteger.get() == 0) && (paramAtomicInteger.compareAndSet(0, 1)))
    {
      paramb.onNext(paramT);
      if (paramAtomicInteger.decrementAndGet() != 0)
      {
        paramT = paramc.terminate();
        if (paramT != null)
        {
          paramb.onError(paramT);
          return;
        }
        paramb.onComplete();
      }
    }
  }
  
  public static void a(b<?> paramb, Throwable paramThrowable, AtomicInteger paramAtomicInteger, c paramc)
  {
    if (paramc.addThrowable(paramThrowable))
    {
      if (paramAtomicInteger.getAndIncrement() == 0) {
        paramb.onError(paramc.terminate());
      }
    }
    else {
      a.a(paramThrowable);
    }
  }
  
  public static void a(b<?> paramb, AtomicInteger paramAtomicInteger, c paramc)
  {
    if (paramAtomicInteger.getAndIncrement() == 0)
    {
      paramAtomicInteger = paramc.terminate();
      if (paramAtomicInteger != null)
      {
        paramb.onError(paramAtomicInteger);
        return;
      }
      paramb.onComplete();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */