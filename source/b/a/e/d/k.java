package b.a.e.d;

import b.a.d.g;
import b.a.d.q;
import b.a.e.a.d;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class k<T>
  extends AtomicReference<b.a.b.b>
  implements b.a.b.b, s<T>
{
  private static final long serialVersionUID = -4403180040475402120L;
  boolean done;
  final b.a.d.a onComplete;
  final g<? super Throwable> onError;
  final q<? super T> onNext;
  
  public k(q<? super T> paramq, g<? super Throwable> paramg, b.a.d.a parama)
  {
    this.onNext = paramq;
    this.onError = paramg;
    this.onComplete = parama;
  }
  
  public void dispose()
  {
    d.dispose(this);
  }
  
  public boolean isDisposed()
  {
    return d.isDisposed((b.a.b.b)get());
  }
  
  public void onComplete()
  {
    if (this.done) {
      return;
    }
    this.done = true;
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
  
  public void onError(Throwable paramThrowable)
  {
    if (this.done)
    {
      b.a.h.a.a(paramThrowable);
      return;
    }
    this.done = true;
    try
    {
      this.onError.accept(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      b.a.h.a.a(new b.a.c.a(new Throwable[] { paramThrowable, localThrowable }));
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.done) {
      return;
    }
    try
    {
      boolean bool = this.onNext.a(paramT);
      if (!bool)
      {
        dispose();
        onComplete();
      }
      return;
    }
    catch (Throwable paramT)
    {
      b.a.c.b.b(paramT);
      dispose();
      onError(paramT);
    }
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    d.setOnce(this, paramb);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */