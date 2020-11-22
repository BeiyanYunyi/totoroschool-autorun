package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.h.a;
import b.a.q;
import b.a.s;
import b.a.u;
import b.a.v;
import java.util.NoSuchElementException;

public final class dd<T>
  extends u<T>
{
  final q<? extends T> a;
  final T b;
  
  public dd(q<? extends T> paramq, T paramT)
  {
    this.a = paramq;
    this.b = paramT;
  }
  
  public void b(v<? super T> paramv)
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
    boolean e;
    
    a(v<? super T> paramv, T paramT)
    {
      this.a = paramv;
      this.b = paramT;
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
      Object localObject2 = this.d;
      this.d = null;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.b;
      }
      if (localObject1 != null)
      {
        this.a.onSuccess(localObject1);
        return;
      }
      this.a.onError(new NoSuchElementException());
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.e)
      {
        a.a(paramThrowable);
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
      if (this.d != null)
      {
        this.e = true;
        this.c.dispose();
        this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
      }
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */