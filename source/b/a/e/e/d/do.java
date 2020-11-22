package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;

public final class do<T>
  extends a<T, T>
{
  public do(q<T> paramq)
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
    T c;
    
    a(s<? super T> params)
    {
      this.a = params;
    }
    
    void a()
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        this.c = null;
        this.a.onNext(localObject);
      }
      this.a.onComplete();
    }
    
    public void dispose()
    {
      this.c = null;
      this.b.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.b.isDisposed();
    }
    
    public void onComplete()
    {
      a();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c = null;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.c = paramT;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */