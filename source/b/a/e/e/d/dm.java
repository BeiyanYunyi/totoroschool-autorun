package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.q;
import b.a.s;

public final class dm<T>
  extends a<T, T>
{
  final long b;
  
  public dm(q<T> paramq, long paramLong)
  {
    super(paramq);
    this.b = paramLong;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final s<? super T> a;
    boolean b;
    b c;
    long d;
    
    a(s<? super T> params, long paramLong)
    {
      this.a = params;
      this.d = paramLong;
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
      if (!this.b)
      {
        this.b = true;
        this.c.dispose();
        this.a.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.b)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.b = true;
      this.c.dispose();
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!this.b)
      {
        long l = this.d;
        this.d = (l - 1L);
        if (l > 0L)
        {
          int i;
          if (this.d == 0L) {
            i = 1;
          } else {
            i = 0;
          }
          this.a.onNext(paramT);
          if (i != 0) {
            onComplete();
          }
        }
      }
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        if (this.d == 0L)
        {
          this.b = true;
          paramb.dispose();
          e.complete(this.a);
          return;
        }
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */