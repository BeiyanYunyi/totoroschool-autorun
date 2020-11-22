package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.h;
import b.a.i;
import b.a.q;
import b.a.s;

public final class bs<T>
  extends h<T>
{
  final q<T> a;
  
  public bs(q<T> paramq)
  {
    this.a = paramq;
  }
  
  protected void b(i<? super T> parami)
  {
    this.a.subscribe(new a(parami));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final i<? super T> a;
    b b;
    T c;
    
    a(i<? super T> parami)
    {
      this.a = parami;
    }
    
    public void dispose()
    {
      this.b.dispose();
      this.b = d.DISPOSED;
    }
    
    public boolean isDisposed()
    {
      return this.b == d.DISPOSED;
    }
    
    public void onComplete()
    {
      this.b = d.DISPOSED;
      Object localObject = this.c;
      if (localObject != null)
      {
        this.c = null;
        this.a.onSuccess(localObject);
        return;
      }
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.b = d.DISPOSED;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */