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

public final class bo
  extends l<Long>
{
  final t a;
  final long b;
  final long c;
  final TimeUnit d;
  
  public bo(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramTimeUnit;
    this.a = paramt;
  }
  
  public void subscribeActual(s<? super Long> params)
  {
    a locala = new a(params);
    params.onSubscribe(locala);
    params = this.a;
    if ((params instanceof n))
    {
      params = params.a();
      locala.setResource(params);
      params.a(locala, this.b, this.c, this.d);
      return;
    }
    locala.setResource(params.a(locala, this.b, this.c, this.d));
  }
  
  static final class a
    extends AtomicReference<b>
    implements b, Runnable
  {
    private static final long serialVersionUID = 346773832286157679L;
    final s<? super Long> actual;
    long count;
    
    a(s<? super Long> params)
    {
      this.actual = params;
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
      if (get() != d.DISPOSED)
      {
        s locals = this.actual;
        long l = this.count;
        this.count = (1L + l);
        locals.onNext(Long.valueOf(l));
      }
    }
    
    public void setResource(b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */