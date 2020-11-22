package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.q;
import b.a.s;

public final class ce<T>
  extends a<T, T>
{
  final h<? super Throwable, ? extends T> b;
  
  public ce(q<T> paramq, h<? super Throwable, ? extends T> paramh)
  {
    super(paramq);
    this.b = paramh;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final s<? super T> a;
    final h<? super Throwable, ? extends T> b;
    b.a.b.b c;
    
    a(s<? super T> params, h<? super Throwable, ? extends T> paramh)
    {
      this.a = params;
      this.b = paramh;
    }
    
    public void dispose()
    {
      this.c.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.c.isDisposed();
    }
    
    public void onComplete()
    {
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        Object localObject = this.b.apply(paramThrowable);
        if (localObject == null)
        {
          localObject = new NullPointerException("The supplied value is null");
          ((NullPointerException)localObject).initCause(paramThrowable);
          this.a.onError((Throwable)localObject);
          return;
        }
        this.a.onNext(localObject);
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
      this.a.onNext(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */