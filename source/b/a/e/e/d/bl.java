package b.a.e.e.d;

import b.a.b.b;
import b.a.q;
import b.a.s;

public final class bl<T>
  extends a<T, T>
{
  public bl(q<T> paramq)
  {
    super(paramq);
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final s<? super T> a;
    b b;
    
    a(s<? super T> params)
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
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT) {}
    
    public void onSubscribe(b paramb)
    {
      this.b = paramb;
      this.a.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */