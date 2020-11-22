package b.a.e.j;

import b.a.b.b;
import b.a.e.g.g;
import b.a.h.a;
import java.util.concurrent.CountDownLatch;

public final class e
{
  public static void a()
  {
    if (a.a())
    {
      if ((!(Thread.currentThread() instanceof g)) && (!a.b())) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Attempt to block on a Scheduler ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" that doesn't support blocking operators as they may lead to deadlock");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public static void a(CountDownLatch paramCountDownLatch, b paramb)
  {
    if (paramCountDownLatch.getCount() == 0L) {
      return;
    }
    try
    {
      a();
      paramCountDownLatch.await();
      return;
    }
    catch (InterruptedException paramCountDownLatch)
    {
      paramb.dispose();
      Thread.currentThread().interrupt();
      throw new IllegalStateException("Interrupted while waiting for subscription to complete.", paramCountDownLatch);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */