package b.a.e.g;

import b.a.b.b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class c
  implements b, Callable<Void>
{
  static final FutureTask<Void> f = new FutureTask(b.a.e.b.a.b, null);
  final Runnable a;
  final AtomicReference<Future<?>> b;
  final AtomicReference<Future<?>> c;
  final ExecutorService d;
  Thread e;
  
  c(Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    this.a = paramRunnable;
    this.c = new AtomicReference();
    this.b = new AtomicReference();
    this.d = paramExecutorService;
  }
  
  public Void a()
    throws Exception
  {
    this.e = Thread.currentThread();
    try
    {
      this.a.run();
      b(this.d.submit(this));
      this.e = null;
      return null;
    }
    catch (Throwable localThrowable)
    {
      this.e = null;
      b.a.h.a.a(localThrowable);
    }
    return null;
  }
  
  void a(Future<?> paramFuture)
  {
    Future localFuture;
    do
    {
      localFuture = (Future)this.c.get();
      if (localFuture == f)
      {
        boolean bool;
        if (this.e != Thread.currentThread()) {
          bool = true;
        } else {
          bool = false;
        }
        paramFuture.cancel(bool);
        return;
      }
    } while (!this.c.compareAndSet(localFuture, paramFuture));
  }
  
  void b(Future<?> paramFuture)
  {
    Future localFuture;
    do
    {
      localFuture = (Future)this.b.get();
      if (localFuture == f)
      {
        boolean bool;
        if (this.e != Thread.currentThread()) {
          bool = true;
        } else {
          bool = false;
        }
        paramFuture.cancel(bool);
        return;
      }
    } while (!this.b.compareAndSet(localFuture, paramFuture));
  }
  
  public void dispose()
  {
    Future localFuture = (Future)this.c.getAndSet(f);
    boolean bool2 = false;
    boolean bool1;
    if ((localFuture != null) && (localFuture != f))
    {
      if (this.e != Thread.currentThread()) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localFuture.cancel(bool1);
    }
    localFuture = (Future)this.b.getAndSet(f);
    if ((localFuture != null) && (localFuture != f))
    {
      bool1 = bool2;
      if (this.e != Thread.currentThread()) {
        bool1 = true;
      }
      localFuture.cancel(bool1);
    }
  }
  
  public boolean isDisposed()
  {
    return this.c.get() == f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */