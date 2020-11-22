package b.a.e.e.d;

import b.a.d.c;
import b.a.e.a.d;
import b.a.q;
import b.a.s;

public final class cx<T>
  extends a<T, T>
{
  final c<T, T, T> b;
  
  public cx(q<T> paramq, c<T, T, T> paramc)
  {
    super(paramq);
    this.b = paramc;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final s<? super T> a;
    final c<T, T, T> b;
    b.a.b.b c;
    T d;
    boolean e;
    
    a(s<? super T> params, c<T, T, T> paramc)
    {
      this.a = params;
      this.b = paramc;
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
      if (this.e) {
        return;
      }
      this.e = true;
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.e)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.e = true;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.e) {
        return;
      }
      s locals = this.a;
      Object localObject = this.d;
      if (localObject == null)
      {
        this.d = paramT;
        locals.onNext(paramT);
        return;
      }
      try
      {
        paramT = b.a.e.b.b.a(this.b.a(localObject, paramT), "The value returned by the accumulator is null");
        this.d = paramT;
        locals.onNext(paramT);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */