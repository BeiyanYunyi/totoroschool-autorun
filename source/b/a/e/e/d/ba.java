package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import java.util.Iterator;

public final class ba<T, R>
  extends a<T, R>
{
  final h<? super T, ? extends Iterable<? extends R>> b;
  
  public ba(q<T> paramq, h<? super T, ? extends Iterable<? extends R>> paramh)
  {
    super(paramq);
    this.b = paramh;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T, R>
    implements b.a.b.b, s<T>
  {
    final s<? super R> a;
    final h<? super T, ? extends Iterable<? extends R>> b;
    b.a.b.b c;
    
    a(s<? super R> params, h<? super T, ? extends Iterable<? extends R>> paramh)
    {
      this.a = params;
      this.b = paramh;
    }
    
    public void dispose()
    {
      this.c.dispose();
      this.c = d.DISPOSED;
    }
    
    public boolean isDisposed()
    {
      return this.c.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.c == d.DISPOSED) {
        return;
      }
      this.c = d.DISPOSED;
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.c == d.DISPOSED)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.c = d.DISPOSED;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.c == d.DISPOSED) {
        return;
      }
      try
      {
        paramT = ((Iterable)this.b.apply(paramT)).iterator();
        s locals = this.a;
        try
        {
          for (;;)
          {
            boolean bool = paramT.hasNext();
            if (bool) {
              try
              {
                Object localObject = b.a.e.b.b.a(paramT.next(), "The iterator returned a null value");
                locals.onNext(localObject);
              }
              catch (Throwable paramT)
              {
                b.a.c.b.b(paramT);
                this.c.dispose();
                onError(paramT);
                return;
              }
            }
          }
          return;
        }
        catch (Throwable paramT)
        {
          b.a.c.b.b(paramT);
          this.c.dispose();
          onError(paramT);
          return;
        }
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.c.dispose();
        onError(paramT);
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
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */