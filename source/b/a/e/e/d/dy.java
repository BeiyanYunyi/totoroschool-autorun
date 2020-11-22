package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.l;
import b.a.s;
import b.a.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class dy
  extends l<Long>
{
  final t a;
  final long b;
  final TimeUnit c;
  
  public dy(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.a = paramt;
  }
  
  public void subscribeActual(s<? super Long> params)
  {
    a locala = new a(params);
    params.onSubscribe(locala);
    locala.setResource(this.a.a(locala, this.b, this.c));
  }
  
  static final class a
    extends AtomicReference<b>
    implements b, Runnable
  {
    private static final long serialVersionUID = -2809475196591179431L;
    final s<? super Long> actual;
    
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
      if (!isDisposed())
      {
        this.actual.onNext(Long.valueOf(0L));
        lazySet(e.INSTANCE);
        this.actual.onComplete();
      }
    }
    
    public void setResource(b paramb)
    {
      d.trySet(this, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */