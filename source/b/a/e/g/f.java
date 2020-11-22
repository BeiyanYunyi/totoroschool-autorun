package b.a.e.g;

import b.a.b.b;
import b.a.e.a.e;
import b.a.h.a;
import b.a.t.c;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class f
  extends t.c
  implements b
{
  volatile boolean a;
  private final ScheduledExecutorService b;
  
  public f(ThreadFactory paramThreadFactory)
  {
    this.b = l.a(paramThreadFactory);
  }
  
  public b a(Runnable paramRunnable)
  {
    return a(paramRunnable, 0L, null);
  }
  
  public b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.a) {
      return e.INSTANCE;
    }
    return a(paramRunnable, paramLong, paramTimeUnit, null);
  }
  
  public k a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit, b.a.e.a.c paramc)
  {
    k localk = new k(a.a(paramRunnable), paramc);
    if ((paramc != null) && (!paramc.a(localk))) {
      return localk;
    }
    if (paramLong <= 0L) {}
    try
    {
      paramRunnable = this.b.submit(localk);
      break label71;
      paramRunnable = this.b.schedule(localk, paramLong, paramTimeUnit);
      label71:
      localk.setFuture(paramRunnable);
      return localk;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      for (;;) {}
    }
    if (paramc != null) {
      paramc.b(localk);
    }
    a.a(paramRunnable);
    return localk;
  }
  
  public b b(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    paramRunnable = a.a(paramRunnable);
    c localc;
    if (paramLong2 <= 0L)
    {
      localc = new c(paramRunnable, this.b);
      if (paramLong1 > 0L) {}
    }
    try
    {
      paramRunnable = this.b.submit(localc);
      break label62;
      paramRunnable = this.b.schedule(localc, paramLong1, paramTimeUnit);
      label62:
      localc.a(paramRunnable);
      return localc;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      for (;;) {}
    }
    a.a(paramRunnable);
    return e.INSTANCE;
    paramRunnable = new i(paramRunnable);
    try
    {
      paramRunnable.setFuture(this.b.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
      return paramRunnable;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      a.a(paramRunnable);
      return e.INSTANCE;
    }
  }
  
  public b b(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    j localj = new j(a.a(paramRunnable));
    if (paramLong <= 0L) {}
    try
    {
      paramRunnable = this.b.submit(localj);
      break label49;
      paramRunnable = this.b.schedule(localj, paramLong, paramTimeUnit);
      label49:
      localj.setFuture(paramRunnable);
      return localj;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      for (;;) {}
    }
    a.a(paramRunnable);
    return e.INSTANCE;
  }
  
  public void b()
  {
    if (!this.a)
    {
      this.a = true;
      this.b.shutdown();
    }
  }
  
  public void dispose()
  {
    if (!this.a)
    {
      this.a = true;
      this.b.shutdownNow();
    }
  }
  
  public boolean isDisposed()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */