package b.a.e.g;

import b.a.b.a;
import b.a.b.b;
import b.a.e.a.e;
import b.a.t;
import b.a.t.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d
  extends t
{
  static final h b;
  static final h c;
  static final c d;
  static final a g;
  private static final TimeUnit h = TimeUnit.SECONDS;
  final ThreadFactory e;
  final AtomicReference<a> f;
  
  static
  {
    d = new c(new h("RxCachedThreadSchedulerShutdown"));
    d.dispose();
    int i = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
    b = new h("RxCachedThreadScheduler", i);
    c = new h("RxCachedWorkerPoolEvictor", i);
    g = new a(0L, null, b);
    g.d();
  }
  
  public d()
  {
    this(b);
  }
  
  public d(ThreadFactory paramThreadFactory)
  {
    this.e = paramThreadFactory;
    this.f = new AtomicReference(g);
    b();
  }
  
  public t.c a()
  {
    return new b((a)this.f.get());
  }
  
  public void b()
  {
    a locala = new a(60L, h, this.e);
    if (!this.f.compareAndSet(g, locala)) {
      locala.d();
    }
  }
  
  static final class a
    implements Runnable
  {
    final a a;
    private final long b;
    private final ConcurrentLinkedQueue<d.c> c;
    private final ScheduledExecutorService d;
    private final Future<?> e;
    private final ThreadFactory f;
    
    a(long paramLong, TimeUnit paramTimeUnit, ThreadFactory paramThreadFactory)
    {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toNanos(paramLong);
      } else {
        paramLong = 0L;
      }
      this.b = paramLong;
      this.c = new ConcurrentLinkedQueue();
      this.a = new a();
      this.f = paramThreadFactory;
      Object localObject = null;
      if (paramTimeUnit != null)
      {
        paramTimeUnit = Executors.newScheduledThreadPool(1, d.c);
        paramThreadFactory = paramTimeUnit.scheduleWithFixedDelay(this, this.b, this.b, TimeUnit.NANOSECONDS);
      }
      else
      {
        paramThreadFactory = null;
        paramTimeUnit = (TimeUnit)localObject;
      }
      this.d = paramTimeUnit;
      this.e = paramThreadFactory;
    }
    
    d.c a()
    {
      if (this.a.isDisposed()) {
        return d.d;
      }
      while (!this.c.isEmpty())
      {
        localc = (d.c)this.c.poll();
        if (localc != null) {
          return localc;
        }
      }
      d.c localc = new d.c(this.f);
      this.a.a(localc);
      return localc;
    }
    
    void a(d.c paramc)
    {
      paramc.a(c() + this.b);
      this.c.offer(paramc);
    }
    
    void b()
    {
      if (!this.c.isEmpty())
      {
        long l = c();
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          d.c localc = (d.c)localIterator.next();
          if (localc.a() > l) {
            break;
          }
          if (this.c.remove(localc)) {
            this.a.b(localc);
          }
        }
      }
    }
    
    long c()
    {
      return System.nanoTime();
    }
    
    void d()
    {
      this.a.dispose();
      if (this.e != null) {
        this.e.cancel(true);
      }
      if (this.d != null) {
        this.d.shutdownNow();
      }
    }
    
    public void run()
    {
      b();
    }
  }
  
  static final class b
    extends t.c
  {
    final AtomicBoolean a = new AtomicBoolean();
    private final a b;
    private final d.a c;
    private final d.c d;
    
    b(d.a parama)
    {
      this.c = parama;
      this.b = new a();
      this.d = parama.a();
    }
    
    public b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.b.isDisposed()) {
        return e.INSTANCE;
      }
      return this.d.a(paramRunnable, paramLong, paramTimeUnit, this.b);
    }
    
    public void dispose()
    {
      if (this.a.compareAndSet(false, true))
      {
        this.b.dispose();
        this.c.a(this.d);
      }
    }
    
    public boolean isDisposed()
    {
      return this.a.get();
    }
  }
  
  static final class c
    extends f
  {
    private long b = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
    
    public long a()
    {
      return this.b;
    }
    
    public void a(long paramLong)
    {
      this.b = paramLong;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */