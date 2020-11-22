package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class em<T>
  extends AtomicReference<b>
  implements b, s<T>
{
  private static final long serialVersionUID = -8612022020200669122L;
  final s<? super T> actual;
  final AtomicReference<b> subscription = new AtomicReference();
  
  public em(s<? super T> params)
  {
    this.actual = params;
  }
  
  public void dispose()
  {
    d.dispose(this.subscription);
    d.dispose(this);
  }
  
  public boolean isDisposed()
  {
    return this.subscription.get() == d.DISPOSED;
  }
  
  public void onComplete()
  {
    dispose();
    this.actual.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    dispose();
    this.actual.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.actual.onNext(paramT);
  }
  
  public void onSubscribe(b paramb)
  {
    if (d.setOnce(this.subscription, paramb)) {
      this.actual.onSubscribe(this);
    }
  }
  
  public void setResource(b paramb)
  {
    d.set(this, paramb);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */