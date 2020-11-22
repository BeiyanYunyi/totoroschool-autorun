package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.e.j.k;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cp<T>
  extends a<T, T>
{
  final h<? super l<Object>, ? extends q<?>> b;
  
  public cp(q<T> paramq, h<? super l<Object>, ? extends q<?>> paramh)
  {
    super(paramq);
    this.b = paramh;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    Object localObject = b.a.j.a.a().b();
    try
    {
      q localq = (q)b.a.e.b.b.a(this.b.apply(localObject), "The handler returned a null ObservableSource");
      localObject = new a(params, (b.a.j.c)localObject, this.a);
      params.onSubscribe((b.a.b.b)localObject);
      localq.subscribe(((a)localObject).inner);
      ((a)localObject).subscribeNext();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, params);
    }
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = 802743776666017014L;
    volatile boolean active;
    final s<? super T> actual;
    final AtomicReference<b.a.b.b> d;
    final b.a.e.j.c error;
    final a<T>.a inner;
    final b.a.j.c<Object> signaller;
    final q<T> source;
    final AtomicInteger wip;
    
    a(s<? super T> params, b.a.j.c<Object> paramc, q<T> paramq)
    {
      this.actual = params;
      this.signaller = paramc;
      this.source = paramq;
      this.wip = new AtomicInteger();
      this.error = new b.a.e.j.c();
      this.inner = new a();
      this.d = new AtomicReference();
    }
    
    public void dispose()
    {
      d.dispose(this.d);
      d.dispose(this.inner);
    }
    
    void innerComplete()
    {
      d.dispose(this.d);
      k.a(this.actual, this, this.error);
    }
    
    void innerError(Throwable paramThrowable)
    {
      d.dispose(this.d);
      k.a(this.actual, paramThrowable, this, this.error);
    }
    
    void innerNext()
    {
      subscribeNext();
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)this.d.get());
    }
    
    public void onComplete()
    {
      this.active = false;
      this.signaller.onNext(Integer.valueOf(0));
    }
    
    public void onError(Throwable paramThrowable)
    {
      d.dispose(this.inner);
      k.a(this.actual, paramThrowable, this, this.error);
    }
    
    public void onNext(T paramT)
    {
      k.a(this.actual, paramT, this, this.error);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.replace(this.d, paramb);
    }
    
    void subscribeNext()
    {
      if (this.wip.getAndIncrement() == 0) {
        do
        {
          if (isDisposed()) {
            return;
          }
          if (!this.active)
          {
            this.active = true;
            this.source.subscribe(this);
          }
        } while (this.wip.decrementAndGet() != 0);
      }
    }
    
    final class a
      extends AtomicReference<b.a.b.b>
      implements s<Object>
    {
      private static final long serialVersionUID = 3254781284376480842L;
      
      a() {}
      
      public void onComplete()
      {
        cp.a.this.innerComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        cp.a.this.innerError(paramThrowable);
      }
      
      public void onNext(Object paramObject)
      {
        cp.a.this.innerNext();
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        d.setOnce(this, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */