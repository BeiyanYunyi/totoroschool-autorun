package b.a.e.d;

import b.a.e.a.d;
import b.a.e.c.g;
import b.a.e.j.r;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class m<T>
  extends AtomicReference<b.a.b.b>
  implements b.a.b.b, s<T>
{
  private static final long serialVersionUID = -5417183359794346637L;
  volatile boolean done;
  int fusionMode;
  final n<T> parent;
  final int prefetch;
  g<T> queue;
  
  public m(n<T> paramn, int paramInt)
  {
    this.parent = paramn;
    this.prefetch = paramInt;
  }
  
  public void dispose()
  {
    d.dispose(this);
  }
  
  public int fusionMode()
  {
    return this.fusionMode;
  }
  
  public boolean isDisposed()
  {
    return d.isDisposed((b.a.b.b)get());
  }
  
  public boolean isDone()
  {
    return this.done;
  }
  
  public void onComplete()
  {
    this.parent.innerComplete(this);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.parent.innerError(this, paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.fusionMode == 0)
    {
      this.parent.innerNext(this, paramT);
      return;
    }
    this.parent.drain();
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    if (d.setOnce(this, paramb))
    {
      if ((paramb instanceof b.a.e.c.b))
      {
        paramb = (b.a.e.c.b)paramb;
        int i = paramb.requestFusion(3);
        if (i == 1)
        {
          this.fusionMode = i;
          this.queue = paramb;
          this.done = true;
          this.parent.innerComplete(this);
          return;
        }
        if (i == 2)
        {
          this.fusionMode = i;
          this.queue = paramb;
          return;
        }
      }
      this.queue = r.a(-this.prefetch);
    }
  }
  
  public g<T> queue()
  {
    return this.queue;
  }
  
  public void setDone()
  {
    this.done = true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */