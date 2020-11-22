package b.a.e.d;

import b.a.d.g;
import b.a.e.a.d;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class o<T>
  extends AtomicReference<b.a.b.b>
  implements b.a.b.b, s<T>
{
  private static final long serialVersionUID = -7251123623727029452L;
  final b.a.d.a onComplete;
  final g<? super Throwable> onError;
  final g<? super T> onNext;
  final g<? super b.a.b.b> onSubscribe;
  
  public o(g<? super T> paramg, g<? super Throwable> paramg1, b.a.d.a parama, g<? super b.a.b.b> paramg2)
  {
    this.onNext = paramg;
    this.onError = paramg1;
    this.onComplete = parama;
    this.onSubscribe = paramg2;
  }
  
  public void dispose()
  {
    d.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    return this.onError != b.a.e.b.a.f;
  }
  
  public boolean isDisposed()
  {
    return get() == d.DISPOSED;
  }
  
  public void onComplete()
  {
    if (!isDisposed())
    {
      lazySet(d.DISPOSED);
      try
      {
        this.onComplete.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        b.a.h.a.a(localThrowable);
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!isDisposed())
    {
      lazySet(d.DISPOSED);
      try
      {
        this.onError.accept(paramThrowable);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        b.a.h.a.a(new b.a.c.a(new Throwable[] { paramThrowable, localThrowable }));
        return;
      }
    }
    b.a.h.a.a(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!isDisposed()) {
      try
      {
        this.onNext.accept(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        ((b.a.b.b)get()).dispose();
        onError(paramT);
      }
    }
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    if (d.setOnce(this, paramb)) {
      try
      {
        this.onSubscribe.accept(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        paramb.dispose();
        onError(localThrowable);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */