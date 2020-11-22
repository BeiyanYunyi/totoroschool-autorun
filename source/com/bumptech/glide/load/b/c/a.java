package com.bumptech.glide.load.b.c;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  extends ThreadPoolExecutor
{
  private final AtomicInteger a = new AtomicInteger();
  private final c b;
  
  public a(int paramInt)
  {
    this(paramInt, c.LOG);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, ThreadFactory paramThreadFactory, c paramc)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, new PriorityBlockingQueue(), paramThreadFactory);
    this.b = paramc;
  }
  
  public a(int paramInt, c paramc)
  {
    this(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new a(), paramc);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if ((paramThrowable == null) && ((paramRunnable instanceof Future)))
    {
      paramRunnable = (Future)paramRunnable;
      if ((paramRunnable.isDone()) && (!paramRunnable.isCancelled())) {
        try
        {
          paramRunnable.get();
          return;
        }
        catch (ExecutionException paramRunnable)
        {
          this.b.handle(paramRunnable);
          return;
        }
        catch (InterruptedException paramRunnable)
        {
          this.b.handle(paramRunnable);
        }
      }
    }
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new b(paramRunnable, paramT, this.a.getAndIncrement());
  }
  
  public static class a
    implements ThreadFactory
  {
    int a = 0;
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fifo-pool-thread-");
      localStringBuilder.append(this.a);
      paramRunnable = new Thread(paramRunnable, localStringBuilder.toString())
      {
        public void run()
        {
          Process.setThreadPriority(10);
          super.run();
        }
      };
      this.a += 1;
      return paramRunnable;
    }
  }
  
  static class b<T>
    extends FutureTask<T>
    implements Comparable<b<?>>
  {
    private final int a;
    private final int b;
    
    public b(Runnable paramRunnable, T paramT, int paramInt)
    {
      super(paramT);
      if ((paramRunnable instanceof b))
      {
        this.a = ((b)paramRunnable).b();
        this.b = paramInt;
        return;
      }
      throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
    }
    
    public int a(b<?> paramb)
    {
      int j = this.a - paramb.a;
      int i = j;
      if (j == 0) {
        i = this.b - paramb.b;
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof b;
      boolean bool2 = false;
      if (bool1)
      {
        paramObject = (b)paramObject;
        bool1 = bool2;
        if (this.b == ((b)paramObject).b)
        {
          bool1 = bool2;
          if (this.a == ((b)paramObject).a) {
            bool1 = true;
          }
        }
        return bool1;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a * 31 + this.b;
    }
  }
  
  public static enum c
  {
    private c() {}
    
    protected void handle(Throwable paramThrowable) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */