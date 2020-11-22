package b.a.e.d;

import b.a.b.b;
import b.a.e.j.e;
import b.a.e.j.j;
import b.a.s;
import java.util.concurrent.CountDownLatch;

public abstract class d<T>
  extends CountDownLatch
  implements b, s<T>
{
  T a;
  Throwable b;
  b c;
  volatile boolean d;
  
  public d()
  {
    super(1);
  }
  
  public final T a()
  {
    if (getCount() != 0L) {
      try
      {
        e.a();
        await();
      }
      catch (InterruptedException localInterruptedException)
      {
        dispose();
        throw j.a(localInterruptedException);
      }
    }
    Throwable localThrowable = this.b;
    if (localThrowable == null) {
      return (T)this.a;
    }
    throw j.a(localThrowable);
  }
  
  public final void dispose()
  {
    this.d = true;
    b localb = this.c;
    if (localb != null) {
      localb.dispose();
    }
  }
  
  public final boolean isDisposed()
  {
    return this.d;
  }
  
  public final void onComplete()
  {
    countDown();
  }
  
  public final void onSubscribe(b paramb)
  {
    this.c = paramb;
    if (this.d) {
      paramb.dispose();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */