package b.a.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.j.e;
import b.a.h.a;
import b.a.s;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class l<T>
  extends CountDownLatch
  implements b, s<T>, Future<T>
{
  T a;
  Throwable b;
  final AtomicReference<b> c = new AtomicReference();
  
  public l()
  {
    super(1);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    b localb;
    do
    {
      localb = (b)this.c.get();
      if ((localb == this) || (localb == d.DISPOSED)) {
        break;
      }
    } while (!this.c.compareAndSet(localb, d.DISPOSED));
    if (localb != null) {
      localb.dispose();
    }
    countDown();
    return true;
    return false;
  }
  
  public void dispose() {}
  
  public T get()
    throws InterruptedException, ExecutionException
  {
    if (getCount() != 0L)
    {
      e.a();
      await();
    }
    if (!isCancelled())
    {
      Throwable localThrowable = this.b;
      if (localThrowable == null) {
        return (T)this.a;
      }
      throw new ExecutionException(localThrowable);
    }
    throw new CancellationException();
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    if (getCount() != 0L)
    {
      e.a();
      if (!await(paramLong, paramTimeUnit)) {
        throw new TimeoutException();
      }
    }
    if (!isCancelled())
    {
      paramTimeUnit = this.b;
      if (paramTimeUnit == null) {
        return (T)this.a;
      }
      throw new ExecutionException(paramTimeUnit);
    }
    throw new CancellationException();
  }
  
  public boolean isCancelled()
  {
    return d.isDisposed((b)this.c.get());
  }
  
  public boolean isDisposed()
  {
    return isDone();
  }
  
  public boolean isDone()
  {
    return getCount() == 0L;
  }
  
  public void onComplete()
  {
    if (this.a == null)
    {
      onError(new NoSuchElementException("The source is empty"));
      return;
    }
    b localb;
    do
    {
      localb = (b)this.c.get();
      if (localb == this) {
        break;
      }
      if (localb == d.DISPOSED) {
        return;
      }
    } while (!this.c.compareAndSet(localb, this));
    countDown();
    return;
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.b == null)
    {
      this.b = paramThrowable;
      b localb;
      do
      {
        localb = (b)this.c.get();
        if ((localb == this) || (localb == d.DISPOSED)) {
          break;
        }
      } while (!this.c.compareAndSet(localb, this));
      countDown();
      return;
      a.a(paramThrowable);
      return;
    }
    a.a(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.a != null)
    {
      ((b)this.c.get()).dispose();
      onError(new IndexOutOfBoundsException("More than one element received"));
      return;
    }
    this.a = paramT;
  }
  
  public void onSubscribe(b paramb)
  {
    d.setOnce(this.c, paramb);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */