package b.a.e.g;

import b.a.b.a;
import b.a.e.a.e;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends t
{
  static final b b;
  static final h c;
  static final int d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
  static final c e = new c(new h("RxComputationShutdown"));
  final ThreadFactory f;
  final AtomicReference<b> g;
  
  static
  {
    e.dispose();
    c = new h("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    b = new b(0, c);
    b.b();
  }
  
  public b()
  {
    this(c);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    this.f = paramThreadFactory;
    this.g = new AtomicReference(b);
    b();
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 > 0)
    {
      if (paramInt2 > paramInt1) {
        return paramInt1;
      }
      i = paramInt2;
    }
    return i;
  }
  
  public b.a.b.b a(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return ((b)this.g.get()).a().b(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
  
  public b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return ((b)this.g.get()).a().b(paramRunnable, paramLong, paramTimeUnit);
  }
  
  public t.c a()
  {
    return new a(((b)this.g.get()).a());
  }
  
  public void b()
  {
    b localb = new b(d, this.f);
    if (!this.g.compareAndSet(b, localb)) {
      localb.b();
    }
  }
  
  static final class a
    extends t.c
  {
    volatile boolean a;
    private final b.a.e.a.f b;
    private final a c;
    private final b.a.e.a.f d;
    private final b.c e;
    
    a(b.c paramc)
    {
      this.e = paramc;
      this.b = new b.a.e.a.f();
      this.c = new a();
      this.d = new b.a.e.a.f();
      this.d.a(this.b);
      this.d.a(this.c);
    }
    
    public b.a.b.b a(Runnable paramRunnable)
    {
      if (this.a) {
        return e.INSTANCE;
      }
      return this.e.a(paramRunnable, 0L, TimeUnit.MILLISECONDS, this.b);
    }
    
    public b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.a) {
        return e.INSTANCE;
      }
      return this.e.a(paramRunnable, paramLong, paramTimeUnit, this.c);
    }
    
    public void dispose()
    {
      if (!this.a)
      {
        this.a = true;
        this.d.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.a;
    }
  }
  
  static final class b
  {
    final int a;
    final b.c[] b;
    long c;
    
    b(int paramInt, ThreadFactory paramThreadFactory)
    {
      this.a = paramInt;
      this.b = new b.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.b[i] = new b.c(paramThreadFactory);
        i += 1;
      }
    }
    
    public b.c a()
    {
      int i = this.a;
      if (i == 0) {
        return b.e;
      }
      b.c[] arrayOfc = this.b;
      long l = this.c;
      this.c = (1L + l);
      return arrayOfc[((int)(l % i))];
    }
    
    public void b()
    {
      b.c[] arrayOfc = this.b;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].dispose();
        i += 1;
      }
    }
  }
  
  static final class c
    extends f
  {
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */