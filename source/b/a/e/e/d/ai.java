package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.j.g;
import b.a.q;
import b.a.s;

public final class ai<T>
  extends a<T, T>
{
  public ai(q<T> paramq)
  {
    super(paramq);
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    s<? super T> a;
    b b;
    
    a(s<? super T> params)
    {
      this.a = params;
    }
    
    public void dispose()
    {
      b localb = this.b;
      this.b = g.INSTANCE;
      this.a = g.asObserver();
      localb.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.b.isDisposed();
    }
    
    public void onComplete()
    {
      s locals = this.a;
      this.b = g.INSTANCE;
      this.a = g.asObserver();
      locals.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      s locals = this.a;
      this.b = g.INSTANCE;
      this.a = g.asObserver();
      locals.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.a.onNext(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.b, paramb))
      {
        this.b = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */