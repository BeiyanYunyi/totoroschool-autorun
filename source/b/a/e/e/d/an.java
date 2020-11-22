package b.a.e.e.d;

import b.a.d.g;
import b.a.e.a.d;
import b.a.q;
import b.a.s;

public final class an<T>
  extends a<T, T>
{
  final g<? super T> b;
  final g<? super Throwable> c;
  final b.a.d.a d;
  final b.a.d.a e;
  
  public an(q<T> paramq, g<? super T> paramg, g<? super Throwable> paramg1, b.a.d.a parama1, b.a.d.a parama2)
  {
    super(paramq);
    this.b = paramg;
    this.c = paramg1;
    this.d = parama1;
    this.e = parama2;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b, this.c, this.d, this.e));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final s<? super T> a;
    final g<? super T> b;
    final g<? super Throwable> c;
    final b.a.d.a d;
    final b.a.d.a e;
    b.a.b.b f;
    boolean g;
    
    a(s<? super T> params, g<? super T> paramg, g<? super Throwable> paramg1, b.a.d.a parama1, b.a.d.a parama2)
    {
      this.a = params;
      this.b = paramg;
      this.c = paramg1;
      this.d = parama1;
      this.e = parama2;
    }
    
    public void dispose()
    {
      this.f.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.g) {
        return;
      }
      try
      {
        this.d.a();
        this.g = true;
        this.a.onComplete();
        try
        {
          this.e.a();
          return;
        }
        catch (Throwable localThrowable1)
        {
          b.a.c.b.b(localThrowable1);
          b.a.h.a.a(localThrowable1);
          return;
        }
        return;
      }
      catch (Throwable localThrowable2)
      {
        b.a.c.b.b(localThrowable2);
        onError(localThrowable2);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.g)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.g = true;
      try
      {
        this.c.accept(paramThrowable);
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        paramThrowable = new b.a.c.a(new Throwable[] { paramThrowable, localThrowable });
      }
      this.a.onError(paramThrowable);
      try
      {
        this.e.a();
        return;
      }
      catch (Throwable paramThrowable)
      {
        b.a.c.b.b(paramThrowable);
        b.a.h.a.a(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (this.g) {
        return;
      }
      try
      {
        this.b.accept(paramT);
        this.a.onNext(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.f.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.f, paramb))
      {
        this.f = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */