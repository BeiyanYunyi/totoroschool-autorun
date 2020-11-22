package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;

public final class de<T>
  extends a<T, T>
{
  final long b;
  
  public de(q<T> paramq, long paramLong)
  {
    super(paramq);
    this.b = paramLong;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final s<? super T> a;
    long b;
    b c;
    
    a(s<? super T> params, long paramLong)
    {
      this.a = params;
      this.b = paramLong;
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
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.b != 0L)
      {
        this.b -= 1L;
        return;
      }
      this.a.onNext(paramT);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */