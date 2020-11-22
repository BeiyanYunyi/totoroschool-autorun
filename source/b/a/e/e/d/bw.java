package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;

public final class bw<T, R>
  extends a<T, q<? extends R>>
{
  final h<? super T, ? extends q<? extends R>> b;
  final h<? super Throwable, ? extends q<? extends R>> c;
  final Callable<? extends q<? extends R>> d;
  
  public bw(q<T> paramq, h<? super T, ? extends q<? extends R>> paramh, h<? super Throwable, ? extends q<? extends R>> paramh1, Callable<? extends q<? extends R>> paramCallable)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramh1;
    this.d = paramCallable;
  }
  
  public void subscribeActual(s<? super q<? extends R>> params)
  {
    this.a.subscribe(new a(params, this.b, this.c, this.d));
  }
  
  static final class a<T, R>
    implements b.a.b.b, s<T>
  {
    final s<? super q<? extends R>> a;
    final h<? super T, ? extends q<? extends R>> b;
    final h<? super Throwable, ? extends q<? extends R>> c;
    final Callable<? extends q<? extends R>> d;
    b.a.b.b e;
    
    a(s<? super q<? extends R>> params, h<? super T, ? extends q<? extends R>> paramh, h<? super Throwable, ? extends q<? extends R>> paramh1, Callable<? extends q<? extends R>> paramCallable)
    {
      this.a = params;
      this.b = paramh;
      this.c = paramh1;
      this.d = paramCallable;
    }
    
    public void dispose()
    {
      this.e.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.e.isDisposed();
    }
    
    public void onComplete()
    {
      try
      {
        q localq = (q)b.a.e.b.b.a(this.d.call(), "The onComplete ObservableSource returned is null");
        this.a.onNext(localq);
        this.a.onComplete();
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.a.onError(localThrowable);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        q localq = (q)b.a.e.b.b.a(this.c.apply(paramThrowable), "The onError ObservableSource returned is null");
        this.a.onNext(localq);
        this.a.onComplete();
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.a.onError(new b.a.c.a(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onNext(T paramT)
    {
      try
      {
        paramT = (q)b.a.e.b.b.a(this.b.apply(paramT), "The onNext ObservableSource returned is null");
        this.a.onNext(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.a.onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.e, paramb))
      {
        this.e = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */