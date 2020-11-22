package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;

public final class z<T>
  extends a<T, Long>
{
  public z(q<T> paramq)
  {
    super(paramq);
  }
  
  public void subscribeActual(s<? super Long> params)
  {
    this.a.subscribe(new a(params));
  }
  
  static final class a
    implements b, s<Object>
  {
    final s<? super Long> a;
    b b;
    long c;
    
    a(s<? super Long> params)
    {
      this.a = params;
    }
    
    public void dispose()
    {
      this.b.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.b.isDisposed();
    }
    
    public void onComplete()
    {
      this.a.onNext(Long.valueOf(this.c));
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      this.c += 1L;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */