package b.a.e.e.d;

import b.a.d.c;
import b.a.e.a.d;
import b.a.h.a;
import b.a.q;
import b.a.s;
import b.a.u;
import b.a.v;

public final class ck<T, R>
  extends u<R>
{
  final q<T> a;
  final R b;
  final c<R, ? super T, R> c;
  
  public ck(q<T> paramq, R paramR, c<R, ? super T, R> paramc)
  {
    this.a = paramq;
    this.b = paramR;
    this.c = paramc;
  }
  
  protected void b(v<? super R> paramv)
  {
    this.a.subscribe(new a(paramv, this.c, this.b));
  }
  
  static final class a<T, R>
    implements b.a.b.b, s<T>
  {
    final v<? super R> a;
    final c<R, ? super T, R> b;
    R c;
    b.a.b.b d;
    
    a(v<? super R> paramv, c<R, ? super T, R> paramc, R paramR)
    {
      this.a = paramv;
      this.c = paramR;
      this.b = paramc;
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
      Object localObject = this.c;
      if (localObject != null)
      {
        this.c = null;
        this.a.onSuccess(localObject);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.c != null)
      {
        this.c = null;
        this.a.onError(paramThrowable);
        return;
      }
      a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      Object localObject = this.c;
      if (localObject != null) {
        try
        {
          this.c = b.a.e.b.b.a(this.b.a(localObject, paramT), "The reducer returned a null value");
          return;
        }
        catch (Throwable paramT)
        {
          b.a.c.b.b(paramT);
          this.d.dispose();
          onError(paramT);
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */