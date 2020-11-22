package b.a;

import b.a.h.a;

public abstract class b
  implements d
{
  private static NullPointerException a(Throwable paramThrowable)
  {
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    return localNullPointerException;
  }
  
  public final void a(c paramc)
  {
    b.a.e.b.b.a(paramc, "s is null");
    try
    {
      b(a.a(this, paramc));
      return;
    }
    catch (Throwable paramc)
    {
      b.a.c.b.b(paramc);
      a.a(paramc);
      throw a(paramc);
    }
    catch (NullPointerException paramc)
    {
      throw paramc;
    }
  }
  
  protected abstract void b(c paramc);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */