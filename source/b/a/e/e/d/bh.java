package b.a.e.e.d;

import b.a.d.c;
import b.a.d.g;
import b.a.h.a;
import b.a.l;
import b.a.s;
import java.util.concurrent.Callable;

public final class bh<T, S>
  extends l<T>
{
  final Callable<S> a;
  final c<S, b.a.e<T>, S> b;
  final g<? super S> c;
  
  public bh(Callable<S> paramCallable, c<S, b.a.e<T>, S> paramc, g<? super S> paramg)
  {
    this.a = paramCallable;
    this.b = paramc;
    this.c = paramg;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    try
    {
      Object localObject = this.a.call();
      localObject = new a(params, this.b, this.c, localObject);
      params.onSubscribe((b.a.b.b)localObject);
      ((a)localObject).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      b.a.e.a.e.error(localThrowable, params);
    }
  }
  
  static final class a<T, S>
    implements b.a.b.b, b.a.e<T>
  {
    final s<? super T> a;
    final c<S, ? super b.a.e<T>, S> b;
    final g<? super S> c;
    S d;
    volatile boolean e;
    boolean f;
    boolean g;
    
    a(s<? super T> params, c<S, ? super b.a.e<T>, S> paramc, g<? super S> paramg, S paramS)
    {
      this.a = params;
      this.b = paramc;
      this.c = paramg;
      this.d = paramS;
    }
    
    private void a(S paramS)
    {
      try
      {
        this.c.accept(paramS);
        return;
      }
      catch (Throwable paramS)
      {
        b.a.c.b.b(paramS);
        a.a(paramS);
      }
    }
    
    public void a()
    {
      Object localObject1 = this.d;
      if (this.e)
      {
        this.d = null;
        a(localObject1);
        return;
      }
      c localc = this.b;
      for (;;)
      {
        if (this.e)
        {
          this.d = null;
          a(localObject1);
          return;
        }
        this.g = false;
        try
        {
          Object localObject2 = localc.a(localObject1, this);
          if (this.f)
          {
            this.e = true;
            this.d = null;
            a(localObject2);
            return;
          }
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          this.d = null;
          this.e = true;
          onError(localThrowable);
          a(localObject1);
        }
      }
    }
    
    public void dispose()
    {
      this.e = true;
    }
    
    public boolean isDisposed()
    {
      return this.e;
    }
    
    public void onComplete()
    {
      if (!this.f)
      {
        this.f = true;
        this.a.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f)
      {
        a.a(paramThrowable);
        return;
      }
      Object localObject = paramThrowable;
      if (paramThrowable == null) {
        localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
      }
      this.f = true;
      this.a.onError((Throwable)localObject);
    }
    
    public void onNext(T paramT)
    {
      if (!this.f)
      {
        if (this.g)
        {
          onError(new IllegalStateException("onNext already called in this generate turn"));
          return;
        }
        if (paramT == null)
        {
          onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
          return;
        }
        this.g = true;
        this.a.onNext(paramT);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */