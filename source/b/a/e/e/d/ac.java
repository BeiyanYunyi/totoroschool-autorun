package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.g.c;
import b.a.g.e;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ac<T, U>
  extends a<T, T>
{
  final h<? super T, ? extends q<U>> b;
  
  public ac(q<T> paramq, h<? super T, ? extends q<U>> paramh)
  {
    super(paramq);
    this.b = paramh;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(new e(params), this.b));
  }
  
  static final class a<T, U>
    implements b.a.b.b, s<T>
  {
    final s<? super T> a;
    final h<? super T, ? extends q<U>> b;
    b.a.b.b c;
    final AtomicReference<b.a.b.b> d = new AtomicReference();
    volatile long e;
    boolean f;
    
    a(s<? super T> params, h<? super T, ? extends q<U>> paramh)
    {
      this.a = params;
      this.b = paramh;
    }
    
    void a(long paramLong, T paramT)
    {
      if (paramLong == this.e) {
        this.a.onNext(paramT);
      }
    }
    
    public void dispose()
    {
      this.c.dispose();
      d.dispose(this.d);
    }
    
    public boolean isDisposed()
    {
      return this.c.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.f) {
        return;
      }
      this.f = true;
      b.a.b.b localb = (b.a.b.b)this.d.get();
      if (localb != d.DISPOSED)
      {
        ((a)localb).a();
        d.dispose(this.d);
        this.a.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      d.dispose(this.d);
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.f) {
        return;
      }
      long l = this.e + 1L;
      this.e = l;
      b.a.b.b localb = (b.a.b.b)this.d.get();
      if (localb != null) {
        localb.dispose();
      }
      try
      {
        q localq = (q)b.a.e.b.b.a(this.b.apply(paramT), "The ObservableSource supplied is null");
        paramT = new a(this, l, paramT);
        if (this.d.compareAndSet(localb, paramT)) {
          localq.subscribe(paramT);
        }
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        dispose();
        this.a.onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        this.a.onSubscribe(this);
      }
    }
    
    static final class a<T, U>
      extends c<U>
    {
      final ac.a<T, U> a;
      final long b;
      final T c;
      boolean d;
      final AtomicBoolean e = new AtomicBoolean();
      
      a(ac.a<T, U> parama, long paramLong, T paramT)
      {
        this.a = parama;
        this.b = paramLong;
        this.c = paramT;
      }
      
      void a()
      {
        if (this.e.compareAndSet(false, true)) {
          this.a.a(this.b, this.c);
        }
      }
      
      public void onComplete()
      {
        if (this.d) {
          return;
        }
        this.d = true;
        a();
      }
      
      public void onError(Throwable paramThrowable)
      {
        if (this.d)
        {
          b.a.h.a.a(paramThrowable);
          return;
        }
        this.d = true;
        this.a.onError(paramThrowable);
      }
      
      public void onNext(U paramU)
      {
        if (this.d) {
          return;
        }
        this.d = true;
        dispose();
        a();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */