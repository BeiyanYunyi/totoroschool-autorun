package b.a.e.e.d;

import b.a.d.g;
import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ec<T, D>
  extends l<T>
{
  final Callable<? extends D> a;
  final h<? super D, ? extends q<? extends T>> b;
  final g<? super D> c;
  final boolean d;
  
  public ec(Callable<? extends D> paramCallable, h<? super D, ? extends q<? extends T>> paramh, g<? super D> paramg, boolean paramBoolean)
  {
    this.a = paramCallable;
    this.b = paramh;
    this.c = paramg;
    this.d = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    try
    {
      Object localObject = this.a.call();
      try
      {
        q localq = (q)b.a.e.b.b.a(this.b.apply(localObject), "The sourceSupplier returned a null ObservableSource");
        localq.subscribe(new a(params, localObject, this.c, this.d));
        return;
      }
      catch (Throwable localThrowable3)
      {
        b.a.c.b.b(localThrowable3);
        try
        {
          this.c.accept(localObject);
          e.error(localThrowable3, params);
          return;
        }
        catch (Throwable localThrowable1)
        {
          b.a.c.b.b(localThrowable1);
          e.error(new b.a.c.a(new Throwable[] { localThrowable3, localThrowable1 }), params);
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      b.a.c.b.b(localThrowable2);
      e.error(localThrowable2, params);
    }
  }
  
  static final class a<T, D>
    extends AtomicBoolean
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = 5904473792286235046L;
    final s<? super T> actual;
    final g<? super D> disposer;
    final boolean eager;
    final D resource;
    b.a.b.b s;
    
    a(s<? super T> params, D paramD, g<? super D> paramg, boolean paramBoolean)
    {
      this.actual = params;
      this.resource = paramD;
      this.disposer = paramg;
      this.eager = paramBoolean;
    }
    
    public void dispose()
    {
      disposeAfter();
      this.s.dispose();
    }
    
    void disposeAfter()
    {
      if (compareAndSet(false, true)) {
        try
        {
          this.disposer.accept(this.resource);
          return;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          b.a.h.a.a(localThrowable);
        }
      }
    }
    
    public boolean isDisposed()
    {
      return get();
    }
    
    public void onComplete()
    {
      if (this.eager)
      {
        if (compareAndSet(false, true)) {
          try
          {
            this.disposer.accept(this.resource);
          }
          catch (Throwable localThrowable)
          {
            b.a.c.b.b(localThrowable);
            this.actual.onError(localThrowable);
            return;
          }
        }
        this.s.dispose();
        this.actual.onComplete();
        return;
      }
      this.actual.onComplete();
      this.s.dispose();
      disposeAfter();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.eager)
      {
        Throwable localThrowable1 = paramThrowable;
        b.a.c.a locala;
        if (compareAndSet(false, true)) {
          try
          {
            this.disposer.accept(this.resource);
            localThrowable1 = paramThrowable;
          }
          catch (Throwable localThrowable2)
          {
            b.a.c.b.b(localThrowable2);
            locala = new b.a.c.a(new Throwable[] { paramThrowable, localThrowable2 });
          }
        }
        this.s.dispose();
        this.actual.onError(locala);
        return;
      }
      this.actual.onError(paramThrowable);
      this.s.dispose();
      disposeAfter();
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */