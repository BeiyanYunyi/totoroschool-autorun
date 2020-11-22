package b.a.e.g;

import b.a.b.b;
import b.a.e.a.e;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class m
  extends t
{
  static final h d = new h("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
  static final ScheduledExecutorService e = Executors.newScheduledThreadPool(0);
  final ThreadFactory b;
  final AtomicReference<ScheduledExecutorService> c = new AtomicReference();
  
  static
  {
    e.shutdown();
  }
  
  public m()
  {
    this(d);
  }
  
  public m(ThreadFactory paramThreadFactory)
  {
    this.b = paramThreadFactory;
    this.c.lazySet(a(paramThreadFactory));
  }
  
  static ScheduledExecutorService a(ThreadFactory paramThreadFactory)
  {
    return l.a(paramThreadFactory);
  }
  
  public b a(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    Object localObject = b.a.h.a.a(paramRunnable);
    if (paramLong2 <= 0L)
    {
      paramRunnable = (ScheduledExecutorService)this.c.get();
      localObject = new c((Runnable)localObject, paramRunnable);
      if (paramLong1 > 0L) {}
    }
    try
    {
      paramRunnable = paramRunnable.submit((Callable)localObject);
      break label66;
      paramRunnable = paramRunnable.schedule((Callable)localObject, paramLong1, paramTimeUnit);
      label66:
      ((c)localObject).a(paramRunnable);
      return (b)localObject;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      for (;;) {}
    }
    b.a.h.a.a(paramRunnable);
    return e.INSTANCE;
    paramRunnable = new i((Runnable)localObject);
    try
    {
      paramRunnable.setFuture(((ScheduledExecutorService)this.c.get()).scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
      return paramRunnable;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      b.a.h.a.a(paramRunnable);
      return e.INSTANCE;
    }
  }
  
  public b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    j localj = new j(b.a.h.a.a(paramRunnable));
    if (paramLong <= 0L) {}
    try
    {
      paramRunnable = ((ScheduledExecutorService)this.c.get()).submit(localj);
      break label61;
      paramRunnable = ((ScheduledExecutorService)this.c.get()).schedule(localj, paramLong, paramTimeUnit);
      label61:
      localj.setFuture(paramRunnable);
      return localj;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      for (;;) {}
    }
    b.a.h.a.a(paramRunnable);
    return e.INSTANCE;
  }
  
  public t.c a()
  {
    return new a((ScheduledExecutorService)this.c.get());
  }
  
  public void b()
  {
    Object localObject1 = null;
    ScheduledExecutorService localScheduledExecutorService;
    Object localObject2;
    do
    {
      localScheduledExecutorService = (ScheduledExecutorService)this.c.get();
      if (localScheduledExecutorService != e)
      {
        if (localObject1 != null) {
          ((ScheduledExecutorService)localObject1).shutdown();
        }
        return;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = a(this.b);
      }
      localObject1 = localObject2;
    } while (!this.c.compareAndSet(localScheduledExecutorService, localObject2));
  }
  
  static final class a
    extends t.c
  {
    final ScheduledExecutorService a;
    final b.a.b.a b;
    volatile boolean c;
    
    a(ScheduledExecutorService paramScheduledExecutorService)
    {
      this.a = paramScheduledExecutorService;
      this.b = new b.a.b.a();
    }
    
    public b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.c) {
        return e.INSTANCE;
      }
      k localk = new k(b.a.h.a.a(paramRunnable), this.b);
      this.b.a(localk);
      if (paramLong <= 0L) {}
      try
      {
        paramRunnable = this.a.submit(localk);
        break label74;
        paramRunnable = this.a.schedule(localk, paramLong, paramTimeUnit);
        label74:
        localk.setFuture(paramRunnable);
        return localk;
      }
      catch (RejectedExecutionException paramRunnable)
      {
        for (;;) {}
      }
      dispose();
      b.a.h.a.a(paramRunnable);
      return e.INSTANCE;
    }
    
    public void dispose()
    {
      if (!this.c)
      {
        this.c = true;
        this.b.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */