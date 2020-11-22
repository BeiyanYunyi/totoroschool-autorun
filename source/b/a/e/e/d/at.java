package b.a.e.e.d;

import b.a.e.a.e;
import b.a.l;
import b.a.s;
import java.util.concurrent.Callable;

public final class at<T>
  extends l<T>
{
  final Callable<? extends Throwable> a;
  
  public at(Callable<? extends Throwable> paramCallable)
  {
    this.a = paramCallable;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    try
    {
      Throwable localThrowable1 = (Throwable)b.a.e.b.b.a(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
    }
    catch (Throwable localThrowable2)
    {
      b.a.c.b.b(localThrowable2);
    }
    e.error(localThrowable2, params);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */