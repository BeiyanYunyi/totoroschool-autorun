package b.a.e.g;

import b.a.b.b;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class a
  extends AtomicReference<Future<?>>
  implements b
{
  protected static final FutureTask<Void> DISPOSED = new FutureTask(b.a.e.b.a.b, null);
  protected static final FutureTask<Void> FINISHED = new FutureTask(b.a.e.b.a.b, null);
  private static final long serialVersionUID = 1811839108042568751L;
  protected final Runnable runnable;
  protected Thread runner;
  
  a(Runnable paramRunnable)
  {
    this.runnable = paramRunnable;
  }
  
  public final void dispose()
  {
    Future localFuture = (Future)get();
    if ((localFuture != FINISHED) && (localFuture != DISPOSED) && (compareAndSet(localFuture, DISPOSED)) && (localFuture != null))
    {
      boolean bool;
      if (this.runner != Thread.currentThread()) {
        bool = true;
      } else {
        bool = false;
      }
      localFuture.cancel(bool);
    }
  }
  
  public Runnable getWrappedRunnable()
  {
    return this.runnable;
  }
  
  public final boolean isDisposed()
  {
    Future localFuture = (Future)get();
    return (localFuture == FINISHED) || (localFuture == DISPOSED);
  }
  
  public final void setFuture(Future<?> paramFuture)
  {
    Future localFuture;
    do
    {
      localFuture = (Future)get();
      if (localFuture == FINISHED) {
        return;
      }
      if (localFuture == DISPOSED)
      {
        boolean bool;
        if (this.runner != Thread.currentThread()) {
          bool = true;
        } else {
          bool = false;
        }
        paramFuture.cancel(bool);
        return;
      }
    } while (!compareAndSet(localFuture, paramFuture));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */