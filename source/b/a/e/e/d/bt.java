package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import b.a.u;
import b.a.v;
import java.util.NoSuchElementException;

public final class bt<T>
  extends u<T>
{
  final q<T> a;
  final T b;
  
  public bt(q<T> paramq, T paramT)
  {
    this.a = paramq;
    this.b = paramT;
  }
  
  protected void b(v<? super T> paramv)
  {
    this.a.subscribe(new a(paramv, this.b));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final v<? super T> a;
    final T b;
    b c;
    T d;
    
    a(v<? super T> paramv, T paramT)
    {
      this.a = paramv;
      this.b = paramT;
    }
    
    public void dispose()
    {
      this.c.dispose();
      this.c = d.DISPOSED;
    }
    
    public boolean isDisposed()
    {
      return this.c == d.DISPOSED;
    }
    
    public void onComplete()
    {
      this.c = d.DISPOSED;
      Object localObject = this.d;
      if (localObject != null)
      {
        this.d = null;
        this.a.onSuccess(localObject);
        return;
      }
      localObject = this.b;
      if (localObject != null)
      {
        this.a.onSuccess(localObject);
        return;
      }
      this.a.onError(new NoSuchElementException());
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c = d.DISPOSED;
      this.d = null;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.d = paramT;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */