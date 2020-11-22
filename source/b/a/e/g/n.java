package b.a.e.g;

import b.a.b.c;
import b.a.e.a.e;
import b.a.h.a;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
  extends t
{
  private static final n b = new n();
  
  public static n c()
  {
    return b;
  }
  
  public b.a.b.b a(Runnable paramRunnable)
  {
    a.a(paramRunnable).run();
    return e.INSTANCE;
  }
  
  public b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      paramTimeUnit.sleep(paramLong);
      a.a(paramRunnable).run();
    }
    catch (InterruptedException paramRunnable)
    {
      Thread.currentThread().interrupt();
      a.a(paramRunnable);
    }
    return e.INSTANCE;
  }
  
  public t.c a()
  {
    return new c();
  }
  
  static final class a
    implements Runnable
  {
    private final Runnable a;
    private final n.c b;
    private final long c;
    
    a(Runnable paramRunnable, n.c paramc, long paramLong)
    {
      this.a = paramRunnable;
      this.b = paramc;
      this.c = paramLong;
    }
    
    public void run()
    {
      if (!this.b.c)
      {
        long l1 = this.b.a(TimeUnit.MILLISECONDS);
        if (this.c > l1)
        {
          long l2 = this.c;
          try
          {
            Thread.sleep(l2 - l1);
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            a.a(localInterruptedException);
            return;
          }
        }
        if (!this.b.c) {
          this.a.run();
        }
      }
    }
  }
  
  static final class b
    implements Comparable<b>
  {
    final Runnable a;
    final long b;
    final int c;
    volatile boolean d;
    
    b(Runnable paramRunnable, Long paramLong, int paramInt)
    {
      this.a = paramRunnable;
      this.b = paramLong.longValue();
      this.c = paramInt;
    }
    
    public int a(b paramb)
    {
      int i = b.a.e.b.b.a(this.b, paramb.b);
      if (i == 0) {
        return b.a.e.b.b.a(this.c, paramb.c);
      }
      return i;
    }
  }
  
  static final class c
    extends t.c
    implements b.a.b.b
  {
    final PriorityBlockingQueue<n.b> a = new PriorityBlockingQueue();
    final AtomicInteger b = new AtomicInteger();
    volatile boolean c;
    private final AtomicInteger d = new AtomicInteger();
    
    public b.a.b.b a(Runnable paramRunnable)
    {
      return a(paramRunnable, a(TimeUnit.MILLISECONDS));
    }
    
    b.a.b.b a(Runnable paramRunnable, long paramLong)
    {
      if (this.c) {
        return e.INSTANCE;
      }
      paramRunnable = new n.b(paramRunnable, Long.valueOf(paramLong), this.b.incrementAndGet());
      this.a.add(paramRunnable);
      if (this.d.getAndIncrement() == 0)
      {
        int i = 1;
        for (;;)
        {
          if (this.c)
          {
            this.a.clear();
            return e.INSTANCE;
          }
          paramRunnable = (n.b)this.a.poll();
          if (paramRunnable == null)
          {
            int j = this.d.addAndGet(-i);
            i = j;
            if (j == 0) {
              return e.INSTANCE;
            }
          }
          else if (!paramRunnable.d)
          {
            paramRunnable.a.run();
          }
        }
      }
      return c.a(new a(paramRunnable));
    }
    
    public b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      paramLong = a(TimeUnit.MILLISECONDS) + paramTimeUnit.toMillis(paramLong);
      return a(new n.a(paramRunnable, this, paramLong), paramLong);
    }
    
    public void dispose()
    {
      this.c = true;
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    final class a
      implements Runnable
    {
      final n.b a;
      
      a(n.b paramb)
      {
        this.a = paramb;
      }
      
      public void run()
      {
        this.a.d = true;
        n.c.this.a.remove(this.a);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */