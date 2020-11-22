package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.h;
import b.a.h.a;
import b.a.i;
import b.a.q;
import b.a.s;

public final class dc<T>
  extends h<T>
{
  final q<T> a;
  
  public dc(q<T> paramq)
  {
    this.a = paramq;
  }
  
  public void b(i<? super T> parami)
  {
    this.a.subscribe(new a(parami));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final i<? super T> a;
    b b;
    T c;
    boolean d;
    
    a(i<? super T> parami)
    {
      this.a = parami;
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
      if (this.d) {
        return;
      }
      this.d = true;
      Object localObject = this.c;
      this.c = null;
      if (localObject == null)
      {
        this.a.onComplete();
        return;
      }
      this.a.onSuccess(localObject);
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.d)
      {
        a.a(paramThrowable);
        return;
      }
      this.d = true;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.d) {
        return;
      }
      if (this.c != null)
      {
        this.d = true;
        this.b.dispose();
        this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
      }
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */