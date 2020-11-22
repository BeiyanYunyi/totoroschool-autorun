package b.a.j;

import b.a.e.a.e;
import b.a.e.c.g;
import b.a.h.a;
import b.a.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T>
  extends c<T>
{
  final b.a.e.f.c<T> a;
  final AtomicReference<s<? super T>> b;
  final AtomicReference<Runnable> c;
  final boolean d;
  volatile boolean e;
  volatile boolean f;
  Throwable g;
  final AtomicBoolean h;
  final b.a.e.d.b<T> i;
  boolean j;
  
  d(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    this.a = new b.a.e.f.c(b.a.e.b.b.a(paramInt, "capacityHint"));
    this.c = new AtomicReference(b.a.e.b.b.a(paramRunnable, "onTerminate"));
    this.d = paramBoolean;
    this.b = new AtomicReference();
    this.h = new AtomicBoolean();
    this.i = new a();
  }
  
  d(int paramInt, boolean paramBoolean)
  {
    this.a = new b.a.e.f.c(b.a.e.b.b.a(paramInt, "capacityHint"));
    this.c = new AtomicReference();
    this.d = paramBoolean;
    this.b = new AtomicReference();
    this.h = new AtomicBoolean();
    this.i = new a();
  }
  
  public static <T> d<T> a()
  {
    return new d(bufferSize(), true);
  }
  
  public static <T> d<T> a(int paramInt)
  {
    return new d(paramInt, true);
  }
  
  public static <T> d<T> a(int paramInt, Runnable paramRunnable)
  {
    return new d(paramInt, paramRunnable, true);
  }
  
  void a(s<? super T> params)
  {
    b.a.e.f.c localc = this.a;
    boolean bool1 = this.d;
    int k = 1;
    int n = 1;
    for (;;)
    {
      if (this.e)
      {
        this.b.lazySet(null);
        localc.clear();
        return;
      }
      boolean bool2 = this.f;
      Object localObject = this.a.poll();
      int i1;
      if (localObject == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int m = k;
      if (bool2)
      {
        m = k;
        if ((bool1 ^ true))
        {
          m = k;
          if (k != 0)
          {
            if (a(localc, params)) {
              return;
            }
            m = 0;
          }
        }
        if (i1 != 0)
        {
          c(params);
          return;
        }
      }
      if (i1 != 0)
      {
        i1 = this.i.addAndGet(-n);
        k = m;
        n = i1;
        if (i1 != 0) {}
      }
      else
      {
        params.onNext(localObject);
        k = m;
      }
    }
  }
  
  boolean a(g<T> paramg, s<? super T> params)
  {
    Throwable localThrowable = this.g;
    if (localThrowable != null)
    {
      this.b.lazySet(null);
      paramg.clear();
      params.onError(localThrowable);
      return true;
    }
    return false;
  }
  
  void b(s<? super T> params)
  {
    b.a.e.f.c localc = this.a;
    boolean bool1 = this.d;
    int k = 1;
    int m;
    do
    {
      if (this.e)
      {
        this.b.lazySet(null);
        localc.clear();
        return;
      }
      boolean bool2 = this.f;
      if (((bool1 ^ true)) && (bool2) && (a(localc, params))) {
        return;
      }
      params.onNext(null);
      if (bool2)
      {
        c(params);
        return;
      }
      m = this.i.addAndGet(-k);
      k = m;
    } while (m != 0);
  }
  
  void c()
  {
    Runnable localRunnable = (Runnable)this.c.get();
    if ((localRunnable != null) && (this.c.compareAndSet(localRunnable, null))) {
      localRunnable.run();
    }
  }
  
  void c(s<? super T> params)
  {
    this.b.lazySet(null);
    Throwable localThrowable = this.g;
    if (localThrowable != null)
    {
      params.onError(localThrowable);
      return;
    }
    params.onComplete();
  }
  
  void d()
  {
    if (this.i.getAndIncrement() != 0) {
      return;
    }
    s locals = (s)this.b.get();
    int k = 1;
    for (;;)
    {
      if (locals != null)
      {
        if (this.j)
        {
          b(locals);
          return;
        }
        a(locals);
        return;
      }
      k = this.i.addAndGet(-k);
      if (k == 0) {
        return;
      }
      locals = (s)this.b.get();
    }
  }
  
  public void onComplete()
  {
    if (!this.f)
    {
      if (this.e) {
        return;
      }
      this.f = true;
      c();
      d();
      return;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    b.a.e.b.b.a(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    if ((!this.f) && (!this.e))
    {
      this.g = paramThrowable;
      this.f = true;
      c();
      d();
      return;
    }
    a.a(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    b.a.e.b.b.a(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (!this.f)
    {
      if (this.e) {
        return;
      }
      this.a.offer(paramT);
      d();
      return;
    }
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    if ((this.f) || (this.e)) {
      paramb.dispose();
    }
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    if ((!this.h.get()) && (this.h.compareAndSet(false, true)))
    {
      params.onSubscribe(this.i);
      this.b.lazySet(params);
      if (this.e)
      {
        this.b.lazySet(null);
        return;
      }
      d();
      return;
    }
    e.error(new IllegalStateException("Only a single observer allowed."), params);
  }
  
  final class a
    extends b.a.e.d.b<T>
  {
    private static final long serialVersionUID = 7926949470189395511L;
    
    a() {}
    
    public void clear()
    {
      d.this.a.clear();
    }
    
    public void dispose()
    {
      if (!d.this.e)
      {
        d.this.e = true;
        d.this.c();
        d.this.b.lazySet(null);
        if (d.this.i.getAndIncrement() == 0)
        {
          d.this.b.lazySet(null);
          d.this.a.clear();
        }
      }
    }
    
    public boolean isDisposed()
    {
      return d.this.e;
    }
    
    public boolean isEmpty()
    {
      return d.this.a.isEmpty();
    }
    
    public T poll()
      throws Exception
    {
      return (T)d.this.a.poll();
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x2) != 0)
      {
        d.this.j = true;
        return 2;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */