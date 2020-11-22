package e;

import e.a.b.d;
import e.a.b.g;
import e.a.b.g.a;
import e.a.g.f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class j
{
  private static final Executor d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), e.a.c.a("OkHttp ConnectionPool", true));
  final d a = new d();
  boolean b;
  private final int e;
  private final long f;
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      for (;;)
      {
        long l1 = j.this.a(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
        long l2;
        if (l1 > 0L) {
          l2 = l1 / 1000000L;
        }
        try
        {
          synchronized (j.this)
          {
            j.this.wait(l2, (int)(l1 - 1000000L * l2));
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
      throw ((Throwable)localObject);
    }
  };
  private final Deque<e.a.b.c> h = new ArrayDeque();
  
  public j()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public j(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.e = paramInt;
    this.f = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L) {
      return;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("keepAliveDuration <= 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  private int a(e.a.b.c paramc, long paramLong)
  {
    List localList = paramc.d;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject1 = (Reference)localList.get(i);
      if (((Reference)localObject1).get() != null)
      {
        i += 1;
      }
      else
      {
        localObject1 = (g.a)localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("A connection to ");
        ((StringBuilder)localObject2).append(paramc.b().a().a());
        ((StringBuilder)localObject2).append(" was leaked. Did you forget to close a response body?");
        localObject2 = ((StringBuilder)localObject2).toString();
        f.c().a((String)localObject2, ((g.a)localObject1).a);
        localList.remove(i);
        paramc.a = true;
        if (localList.isEmpty())
        {
          paramc.e = (paramLong - this.f);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  long a(long paramLong)
  {
    try
    {
      Iterator localIterator = this.h.iterator();
      long l1 = Long.MIN_VALUE;
      Object localObject1 = null;
      int i = 0;
      int j = 0;
      while (localIterator.hasNext())
      {
        e.a.b.c localc = (e.a.b.c)localIterator.next();
        if (a(localc, paramLong) > 0)
        {
          j += 1;
        }
        else
        {
          int k = i + 1;
          long l2 = paramLong - localc.e;
          i = k;
          if (l2 > l1)
          {
            localObject1 = localc;
            l1 = l2;
            i = k;
          }
        }
      }
      if ((l1 < this.f) && (i <= this.e))
      {
        if (i > 0)
        {
          paramLong = this.f;
          return paramLong - l1;
        }
        if (j > 0)
        {
          paramLong = this.f;
          return paramLong;
        }
        this.b = false;
        return -1L;
      }
      this.h.remove(localObject1);
      e.a.c.a(((e.a.b.c)localObject1).d());
      return 0L;
    }
    finally {}
  }
  
  @Nullable
  e.a.b.c a(a parama, g paramg, ae paramae)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      e.a.b.c localc = (e.a.b.c)localIterator.next();
      if (localc.a(parama, paramae))
      {
        paramg.a(localc, true);
        return localc;
      }
    }
    return null;
  }
  
  @Nullable
  Socket a(a parama, g paramg)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      e.a.b.c localc = (e.a.b.c)localIterator.next();
      if ((localc.a(parama, null)) && (localc.f()) && (localc != paramg.c())) {
        return paramg.a(localc);
      }
    }
    return null;
  }
  
  void a(e.a.b.c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (!this.b)
    {
      this.b = true;
      d.execute(this.g);
    }
    this.h.add(paramc);
  }
  
  boolean b(e.a.b.c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if ((!paramc.a) && (this.e != 0))
    {
      notifyAll();
      return false;
    }
    this.h.remove(paramc);
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */