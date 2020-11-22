package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.g.n;
import b.a.l;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class bp
  extends l<Long>
{
  final t a;
  final long b;
  final long c;
  final long d;
  final long e;
  final TimeUnit f;
  
  public bp(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, t paramt)
  {
    this.d = paramLong3;
    this.e = paramLong4;
    this.f = paramTimeUnit;
    this.a = paramt;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public void subscribeActual(s<? super Long> params)
  {
    a locala = new a(params, this.b, this.c);
    params.onSubscribe(locala);
    params = this.a;
    if ((params instanceof n))
    {
      params = params.a();
      locala.setResource(params);
      params.a(locala, this.d, this.e, this.f);
      return;
    }
    locala.setResource(params.a(locala, this.d, this.e, this.f));
  }
  
  static final class a
    extends AtomicReference<b>
    implements b, Runnable
  {
    private static final long serialVersionUID = 1891866368734007884L;
    final s<? super Long> actual;
    long count;
    final long end;
    
    a(s<? super Long> params, long paramLong1, long paramLong2)
    {
      this.actual = params;
      this.count = paramLong1;
      this.end = paramLong2;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return get() == d.DISPOSED;
    }
    
    public void run()
    {
      if (!isDisposed())
      {
        long l = this.count;
        this.actual.onNext(Long.valueOf(l));
        if (l == this.end)
        {
          d.dispose(this);
          this.actual.onComplete();
          return;
        }
        this.count = (l + 1L);
      }
    }
    
    public void setResource(b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */