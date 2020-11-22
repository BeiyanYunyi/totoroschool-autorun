package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.k;
import b.a.q;
import b.a.s;

public final class ah<T>
  extends a<k<T>, T>
{
  public ah(q<k<T>> paramq)
  {
    super(paramq);
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params));
  }
  
  static final class a<T>
    implements b, s<k<T>>
  {
    final s<? super T> a;
    boolean b;
    b c;
    
    a(s<? super T> params)
    {
      this.a = params;
    }
    
    public void a(k<T> paramk)
    {
      if (this.b)
      {
        if (paramk.b()) {
          b.a.h.a.a(paramk.e());
        }
        return;
      }
      if (paramk.b())
      {
        this.c.dispose();
        onError(paramk.e());
        return;
      }
      if (paramk.a())
      {
        this.c.dispose();
        onComplete();
        return;
      }
      this.a.onNext(paramk.d());
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
      if (this.b) {
        return;
      }
      this.b = true;
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.b)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.b = true;
      this.a.onError(paramThrowable);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */