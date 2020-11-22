package b.a.a.a;

import b.a.c.b;
import b.a.d.h;
import b.a.t;
import java.util.concurrent.Callable;

public final class a
{
  private static volatile h<Callable<t>, t> a;
  private static volatile h<t, t> b;
  
  static t a(h<Callable<t>, t> paramh, Callable<t> paramCallable)
  {
    paramh = (t)a(paramh, paramCallable);
    if (paramh != null) {
      return paramh;
    }
    throw new NullPointerException("Scheduler Callable returned null");
  }
  
  public static t a(t paramt)
  {
    if (paramt != null)
    {
      h localh = b;
      if (localh == null) {
        return paramt;
      }
      return (t)a(localh, paramt);
    }
    throw new NullPointerException("scheduler == null");
  }
  
  public static t a(Callable<t> paramCallable)
  {
    if (paramCallable != null)
    {
      h localh = a;
      if (localh == null) {
        return b(paramCallable);
      }
      return a(localh, paramCallable);
    }
    throw new NullPointerException("scheduler == null");
  }
  
  static <T, R> R a(h<T, R> paramh, T paramT)
  {
    try
    {
      paramh = paramh.apply(paramT);
      return paramh;
    }
    catch (Throwable paramh)
    {
      throw b.a(paramh);
    }
  }
  
  static t b(Callable<t> paramCallable)
  {
    try
    {
      paramCallable = (t)paramCallable.call();
      if (paramCallable != null) {
        return paramCallable;
      }
      throw new NullPointerException("Scheduler Callable returned null");
    }
    catch (Throwable paramCallable)
    {
      throw b.a(paramCallable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */