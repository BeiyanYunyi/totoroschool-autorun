package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.u;
import b.a.v;

public final class aa<T>
  extends u<Long>
  implements b.a.e.c.a<Long>
{
  final q<T> a;
  
  public aa(q<T> paramq)
  {
    this.a = paramq;
  }
  
  public void b(v<? super Long> paramv)
  {
    this.a.subscribe(new a(paramv));
  }
  
  public l<Long> e_()
  {
    return b.a.h.a.a(new z(this.a));
  }
  
  static final class a
    implements b, s<Object>
  {
    final v<? super Long> a;
    b b;
    long c;
    
    a(v<? super Long> paramv)
    {
      this.a = paramv;
    }
    
    public void dispose()
    {
      this.b.dispose();
      this.b = d.DISPOSED;
    }
    
    public boolean isDisposed()
    {
      return this.b.isDisposed();
    }
    
    public void onComplete()
    {
      this.b = d.DISPOSED;
      this.a.onSuccess(Long.valueOf(this.c));
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.b = d.DISPOSED;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */