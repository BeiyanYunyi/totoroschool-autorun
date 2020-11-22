package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.u;
import b.a.v;
import java.util.NoSuchElementException;

public final class ar<T>
  extends u<T>
  implements b.a.e.c.a<T>
{
  final q<T> a;
  final long b;
  final T c;
  
  public ar(q<T> paramq, long paramLong, T paramT)
  {
    this.a = paramq;
    this.b = paramLong;
    this.c = paramT;
  }
  
  public void b(v<? super T> paramv)
  {
    this.a.subscribe(new a(paramv, this.b, this.c));
  }
  
  public l<T> e_()
  {
    return b.a.h.a.a(new ap(this.a, this.b, this.c, true));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final v<? super T> a;
    final long b;
    final T c;
    b d;
    long e;
    boolean f;
    
    a(v<? super T> paramv, long paramLong, T paramT)
    {
      this.a = paramv;
      this.b = paramLong;
      this.c = paramT;
    }
    
    public void dispose()
    {
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.f)
      {
        this.f = true;
        Object localObject = this.c;
        if (localObject != null)
        {
          this.a.onSuccess(localObject);
          return;
        }
        this.a.onError(new NoSuchElementException());
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.f = true;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.f) {
        return;
      }
      long l = this.e;
      if (l == this.b)
      {
        this.f = true;
        this.d.dispose();
        this.a.onSuccess(paramT);
        return;
      }
      this.e = (l + 1L);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */