package b.a.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.j.n;
import b.a.s;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class h<T>
  extends AtomicReference<b>
  implements b, s<T>
{
  public static final Object TERMINATED = new Object();
  private static final long serialVersionUID = -4875965440900746268L;
  final Queue<Object> queue;
  
  public h(Queue<Object> paramQueue)
  {
    this.queue = paramQueue;
  }
  
  public void dispose()
  {
    if (d.dispose(this)) {
      this.queue.offer(TERMINATED);
    }
  }
  
  public boolean isDisposed()
  {
    return get() == d.DISPOSED;
  }
  
  public void onComplete()
  {
    this.queue.offer(n.complete());
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.queue.offer(n.error(paramThrowable));
  }
  
  public void onNext(T paramT)
  {
    this.queue.offer(n.next(paramT));
  }
  
  public void onSubscribe(b paramb)
  {
    d.setOnce(this, paramb);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */