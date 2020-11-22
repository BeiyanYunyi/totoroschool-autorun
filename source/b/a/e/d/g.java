package b.a.e.d;

import b.a.b.b;
import b.a.c;
import b.a.e.j.e;
import b.a.e.j.j;
import b.a.i;
import b.a.v;
import java.util.concurrent.CountDownLatch;

public final class g<T>
  extends CountDownLatch
  implements c, i<T>, v<T>
{
  T a;
  Throwable b;
  b c;
  volatile boolean d;
  
  public g()
  {
    super(1);
  }
  
  void a()
  {
    this.d = true;
    b localb = this.c;
    if (localb != null) {
      localb.dispose();
    }
  }
  
  public T b()
  {
    if (getCount() != 0L) {
      try
      {
        e.a();
        await();
      }
      catch (InterruptedException localInterruptedException)
      {
        a();
        throw j.a(localInterruptedException);
      }
    }
    Throwable localThrowable = this.b;
    if (localThrowable == null) {
      return (T)this.a;
    }
    throw j.a(localThrowable);
  }
  
  public void onComplete()
  {
    countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.b = paramThrowable;
    countDown();
  }
  
  public void onSubscribe(b paramb)
  {
    this.c = paramb;
    if (this.d) {
      paramb.dispose();
    }
  }
  
  public void onSuccess(T paramT)
  {
    this.a = paramT;
    countDown();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */