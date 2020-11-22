package b.a;

import b.a.e.a.e;
import b.a.e.a.g;
import b.a.e.g.f;
import b.a.e.j.j;
import b.a.h.a;
import java.util.concurrent.TimeUnit;

public abstract class t
{
  static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
  
  public long a(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }
  
  public b.a.b.b a(Runnable paramRunnable)
  {
    return a(paramRunnable, 0L, TimeUnit.NANOSECONDS);
  }
  
  public b.a.b.b a(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    c localc = a();
    paramRunnable = new b(a.a(paramRunnable), localc);
    paramTimeUnit = localc.a(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
    if (paramTimeUnit == e.INSTANCE) {
      return paramTimeUnit;
    }
    return paramRunnable;
  }
  
  public b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    c localc = a();
    paramRunnable = new a(a.a(paramRunnable), localc);
    localc.a(paramRunnable, paramLong, paramTimeUnit);
    return paramRunnable;
  }
  
  public abstract c a();
  
  public void b() {}
  
  static final class a
    implements b.a.b.b, Runnable
  {
    final Runnable a;
    final t.c b;
    Thread c;
    
    a(Runnable paramRunnable, t.c paramc)
    {
      this.a = paramRunnable;
      this.b = paramc;
    }
    
    public void dispose()
    {
      if ((this.c == Thread.currentThread()) && ((this.b instanceof f)))
      {
        ((f)this.b).b();
        return;
      }
      this.b.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.b.isDisposed();
    }
    
    public void run()
    {
      this.c = Thread.currentThread();
      try
      {
        this.a.run();
        return;
      }
      finally
      {
        dispose();
        this.c = null;
      }
    }
  }
  
  static final class b
    implements b.a.b.b, Runnable
  {
    final Runnable a;
    final t.c b;
    volatile boolean c;
    
    b(Runnable paramRunnable, t.c paramc)
    {
      this.a = paramRunnable;
      this.b = paramc;
    }
    
    public void dispose()
    {
      this.c = true;
      this.b.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public void run()
    {
      if (!this.c) {
        try
        {
          this.a.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          this.b.dispose();
          throw j.a(localThrowable);
        }
      }
    }
  }
  
  public static abstract class c
    implements b.a.b.b
  {
    public long a(TimeUnit paramTimeUnit)
    {
      return paramTimeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
    
    public b.a.b.b a(Runnable paramRunnable)
    {
      return a(paramRunnable, 0L, TimeUnit.NANOSECONDS);
    }
    
    public b.a.b.b a(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      g localg1 = new g();
      g localg2 = new g(localg1);
      paramRunnable = a.a(paramRunnable);
      paramLong2 = paramTimeUnit.toNanos(paramLong2);
      long l = a(TimeUnit.NANOSECONDS);
      paramRunnable = a(new a(l + paramTimeUnit.toNanos(paramLong1), paramRunnable, l, localg2, paramLong2), paramLong1, paramTimeUnit);
      if (paramRunnable == e.INSTANCE) {
        return paramRunnable;
      }
      localg1.replace(paramRunnable);
      return localg2;
    }
    
    public abstract b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit);
    
    final class a
      implements Runnable
    {
      final Runnable a;
      final g b;
      final long c;
      long d;
      long e;
      long f;
      
      a(long paramLong1, Runnable paramRunnable, long paramLong2, g paramg, long paramLong3)
      {
        this.a = paramRunnable;
        this.b = paramg;
        this.c = paramLong3;
        this.e = paramLong2;
        this.f = paramLong1;
      }
      
      public void run()
      {
        this.a.run();
        if (!this.b.isDisposed())
        {
          long l2 = t.c.this.a(TimeUnit.NANOSECONDS);
          long l1;
          long l3;
          if ((t.a + l2 >= this.e) && (l2 < this.e + this.c + t.a))
          {
            l1 = this.f;
            l3 = this.d + 1L;
            this.d = l3;
            l1 += l3 * this.c;
          }
          else
          {
            l1 = this.c + l2;
            l3 = this.c;
            long l4 = this.d + 1L;
            this.d = l4;
            this.f = (l1 - l3 * l4);
          }
          this.e = l2;
          this.b.replace(t.c.this.a(this, l1 - l2, TimeUnit.NANOSECONDS));
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */