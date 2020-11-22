package b.a.e.e.d;

import b.a.d.c;
import b.a.e.a.d;
import b.a.h;
import b.a.h.a;
import b.a.i;
import b.a.q;
import b.a.s;

public final class cj<T>
  extends h<T>
{
  final q<T> a;
  final c<T, T, T> b;
  
  public cj(q<T> paramq, c<T, T, T> paramc)
  {
    this.a = paramq;
    this.b = paramc;
  }
  
  protected void b(i<? super T> parami)
  {
    this.a.subscribe(new a(parami, this.b));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final i<? super T> a;
    final c<T, T, T> b;
    boolean c;
    T d;
    b.a.b.b e;
    
    a(i<? super T> parami, c<T, T, T> paramc)
    {
      this.a = parami;
      this.b = paramc;
    }
    
    public void dispose()
    {
      this.e.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.e.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.c) {
        return;
      }
      this.c = true;
      Object localObject = this.d;
      this.d = null;
      if (localObject != null)
      {
        this.a.onSuccess(localObject);
        return;
      }
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.c)
      {
        a.a(paramThrowable);
        return;
      }
      this.c = true;
      this.d = null;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!this.c)
      {
        Object localObject = this.d;
        if (localObject == null)
        {
          this.d = paramT;
          return;
        }
        try
        {
          this.d = b.a.e.b.b.a(this.b.a(localObject, paramT), "The reducer returned a null value");
          return;
        }
        catch (Throwable paramT)
        {
          b.a.c.b.b(paramT);
          this.e.dispose();
          onError(paramT);
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.e, paramb))
      {
        this.e = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */