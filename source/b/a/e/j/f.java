package b.a.e.j;

import b.a.d.a;
import b.a.d.g;
import java.util.concurrent.CountDownLatch;

public final class f
  extends CountDownLatch
  implements a, g<Throwable>
{
  public Throwable a;
  
  public f()
  {
    super(1);
  }
  
  public void a()
  {
    countDown();
  }
  
  public void a(Throwable paramThrowable)
  {
    this.a = paramThrowable;
    countDown();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */