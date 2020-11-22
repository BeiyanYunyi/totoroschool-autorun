package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.h;
import b.a.i;
import b.a.l;
import b.a.q;
import b.a.s;

public final class aq<T>
  extends h<T>
  implements b.a.e.c.a<T>
{
  final q<T> a;
  final long b;
  
  public aq(q<T> paramq, long paramLong)
  {
    this.a = paramq;
    this.b = paramLong;
  }
  
  public void b(i<? super T> parami)
  {
    this.a.subscribe(new a(parami, this.b));
  }
  
  public l<T> e_()
  {
    return b.a.h.a.a(new ap(this.a, this.b, null, false));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final i<? super T> a;
    final long b;
    b c;
    long d;
    boolean e;
    
    a(i<? super T> parami, long paramLong)
    {
      this.a = parami;
      this.b = paramLong;
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
      if (!this.e)
      {
        this.e = true;
        this.a.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.e)
      {
        b.a.h.a.a(paramThrowable);
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
      long l = this.d;
      if (l == this.b)
      {
        this.e = true;
        this.c.dispose();
        this.a.onSuccess(paramT);
        return;
      }
      this.d = (l + 1L);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */