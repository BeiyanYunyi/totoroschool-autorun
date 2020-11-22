package b.a.e.e.d;

import b.a.d.h;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class aw<T>
  extends a<T, T>
{
  final h<? super T, ? extends b.a.d> b;
  final boolean c;
  
  public aw(q<T> paramq, h<? super T, ? extends b.a.d> paramh, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramBoolean;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b, this.c));
  }
  
  static final class a<T>
    extends b.a.e.d.b<T>
    implements s<T>
  {
    private static final long serialVersionUID = 8443155186132538303L;
    final s<? super T> actual;
    b.a.b.b d;
    final boolean delayErrors;
    volatile boolean disposed;
    final b.a.e.j.c errors;
    final h<? super T, ? extends b.a.d> mapper;
    final b.a.b.a set;
    
    a(s<? super T> params, h<? super T, ? extends b.a.d> paramh, boolean paramBoolean)
    {
      this.actual = params;
      this.mapper = paramh;
      this.delayErrors = paramBoolean;
      this.errors = new b.a.e.j.c();
      this.set = new b.a.b.a();
      lazySet(1);
    }
    
    public void clear() {}
    
    public void dispose()
    {
      this.disposed = true;
      this.d.dispose();
      this.set.dispose();
    }
    
    void innerComplete(a<T>.a parama)
    {
      this.set.c(parama);
      onComplete();
    }
    
    void innerError(a<T>.a parama, Throwable paramThrowable)
    {
      this.set.c(parama);
      onError(paramThrowable);
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public void onComplete()
    {
      if (decrementAndGet() == 0)
      {
        Throwable localThrowable = this.errors.terminate();
        if (localThrowable != null)
        {
          this.actual.onError(localThrowable);
          return;
        }
        this.actual.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.errors.addThrowable(paramThrowable))
      {
        if (this.delayErrors)
        {
          if (decrementAndGet() == 0)
          {
            paramThrowable = this.errors.terminate();
            this.actual.onError(paramThrowable);
          }
        }
        else
        {
          dispose();
          if (getAndSet(0) > 0)
          {
            paramThrowable = this.errors.terminate();
            this.actual.onError(paramThrowable);
          }
        }
      }
      else {
        b.a.h.a.a(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      try
      {
        paramT = (b.a.d)b.a.e.b.b.a(this.mapper.apply(paramT), "The mapper returned a null CompletableSource");
        getAndIncrement();
        a locala = new a();
        if ((!this.disposed) && (this.set.a(locala))) {
          paramT.a(locala);
        }
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.d.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (b.a.e.a.d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.actual.onSubscribe(this);
      }
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return paramInt & 0x2;
    }
    
    final class a
      extends AtomicReference<b.a.b.b>
      implements b.a.b.b, b.a.c
    {
      private static final long serialVersionUID = 8606673141535671828L;
      
      a() {}
      
      public void dispose()
      {
        b.a.e.a.d.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return b.a.e.a.d.isDisposed((b.a.b.b)get());
      }
      
      public void onComplete()
      {
        aw.a.this.innerComplete(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        aw.a.this.innerError(this, paramThrowable);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        b.a.e.a.d.setOnce(this, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */