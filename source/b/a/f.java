package b.a;

import b.a.e.e.a.c;
import b.a.e.e.a.d;

public abstract class f<T>
  implements org.a.a<T>
{
  static final int a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
  
  public static int a()
  {
    return a;
  }
  
  public final f<T> a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new c(this, paramInt, paramBoolean2, paramBoolean1, b.a.e.b.a.c));
  }
  
  public final void a(g<? super T> paramg)
  {
    b.a.e.b.b.a(paramg, "s is null");
    try
    {
      paramg = b.a.h.a.a(this, paramg);
      b.a.e.b.b.a(paramg, "Plugin returned null Subscriber");
      b(paramg);
      return;
    }
    catch (Throwable paramg)
    {
      b.a.c.b.b(paramg);
      b.a.h.a.a(paramg);
      NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
      localNullPointerException.initCause(paramg);
      throw localNullPointerException;
    }
    catch (NullPointerException paramg)
    {
      throw paramg;
    }
  }
  
  public final void a(org.a.b<? super T> paramb)
  {
    if ((paramb instanceof g))
    {
      a((g)paramb);
      return;
    }
    b.a.e.b.b.a(paramb, "s is null");
    a(new b.a.e.h.a(paramb));
  }
  
  public final f<T> b()
  {
    return a(a(), false, true);
  }
  
  protected abstract void b(org.a.b<? super T> paramb);
  
  public final f<T> c()
  {
    return b.a.h.a.a(new d(this));
  }
  
  public final f<T> d()
  {
    return b.a.h.a.a(new b.a.e.e.a.f(this));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */