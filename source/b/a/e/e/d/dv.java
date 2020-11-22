package b.a.e.e.d;

import b.a.e.a.d;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.concurrent.TimeUnit;

public final class dv<T>
  extends a<T, b.a.i.b<T>>
{
  final t b;
  final TimeUnit c;
  
  public dv(q<T> paramq, TimeUnit paramTimeUnit, t paramt)
  {
    super(paramq);
    this.b = paramt;
    this.c = paramTimeUnit;
  }
  
  public void subscribeActual(s<? super b.a.i.b<T>> params)
  {
    this.a.subscribe(new a(params, this.c, this.b));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final s<? super b.a.i.b<T>> a;
    final TimeUnit b;
    final t c;
    long d;
    b.a.b.b e;
    
    a(s<? super b.a.i.b<T>> params, TimeUnit paramTimeUnit, t paramt)
    {
      this.a = params;
      this.c = paramt;
      this.b = paramTimeUnit;
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
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l1 = this.c.a(this.b);
      long l2 = this.d;
      this.d = l1;
      this.a.onNext(new b.a.i.b(paramT, l1 - l2, this.b));
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.e, paramb))
      {
        this.e = paramb;
        this.d = this.c.a(this.b);
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */