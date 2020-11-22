package b.a.g;

import b.a.c;
import b.a.e.a.d;
import b.a.i;
import b.a.s;
import b.a.v;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class f<T>
  extends a<T, f<T>>
  implements b.a.b.b, c, i<T>, s<T>, v<T>
{
  private final s<? super T> i;
  private final AtomicReference<b.a.b.b> j = new AtomicReference();
  private b.a.e.c.b<T> k;
  
  public f()
  {
    this(a.INSTANCE);
  }
  
  public f(s<? super T> params)
  {
    this.i = params;
  }
  
  public final void dispose()
  {
    d.dispose(this.j);
  }
  
  public final boolean isDisposed()
  {
    return d.isDisposed((b.a.b.b)this.j.get());
  }
  
  public void onComplete()
  {
    if (!this.f)
    {
      this.f = true;
      if (this.j.get() == null) {
        this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
      }
    }
    try
    {
      this.e = Thread.currentThread();
      this.d += 1L;
      this.i.onComplete();
      return;
    }
    finally
    {
      this.a.countDown();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.f)
    {
      this.f = true;
      if (this.j.get() == null) {
        this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
      }
    }
    try
    {
      this.e = Thread.currentThread();
      if (paramThrowable == null) {
        this.c.add(new NullPointerException("onError received a null Throwable"));
      } else {
        this.c.add(paramThrowable);
      }
      this.i.onError(paramThrowable);
      return;
    }
    finally
    {
      this.a.countDown();
    }
  }
  
  public void onNext(T paramT)
  {
    if (!this.f)
    {
      this.f = true;
      if (this.j.get() == null) {
        this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
      }
    }
    this.e = Thread.currentThread();
    if (this.h == 2) {
      try
      {
        for (;;)
        {
          paramT = this.k.poll();
          if (paramT == null) {
            break;
          }
          this.b.add(paramT);
        }
        return;
      }
      catch (Throwable paramT)
      {
        this.c.add(paramT);
        this.k.dispose();
      }
    }
    this.b.add(paramT);
    if (paramT == null) {
      this.c.add(new NullPointerException("onNext received a null value"));
    }
    this.i.onNext(paramT);
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    this.e = Thread.currentThread();
    if (paramb == null)
    {
      this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
      return;
    }
    if (!this.j.compareAndSet(null, paramb))
    {
      paramb.dispose();
      if (this.j.get() != d.DISPOSED)
      {
        List localList = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSubscribe received multiple subscriptions: ");
        localStringBuilder.append(paramb);
        localList.add(new IllegalStateException(localStringBuilder.toString()));
      }
      return;
    }
    if ((this.g != 0) && ((paramb instanceof b.a.e.c.b)))
    {
      this.k = ((b.a.e.c.b)paramb);
      int m = this.k.requestFusion(this.g);
      this.h = m;
      if (m == 1)
      {
        this.f = true;
        this.e = Thread.currentThread();
        try
        {
          for (;;)
          {
            paramb = this.k.poll();
            if (paramb == null) {
              break;
            }
            this.b.add(paramb);
          }
          this.d += 1L;
          this.j.lazySet(d.DISPOSED);
          return;
        }
        catch (Throwable paramb)
        {
          this.c.add(paramb);
          return;
        }
      }
    }
    this.i.onSubscribe(paramb);
  }
  
  public void onSuccess(T paramT)
  {
    onNext(paramT);
    onComplete();
  }
  
  static enum a
    implements s<Object>
  {
    private a() {}
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable) {}
    
    public void onNext(Object paramObject) {}
    
    public void onSubscribe(b.a.b.b paramb) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */