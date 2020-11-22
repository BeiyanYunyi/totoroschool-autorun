package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.l;
import b.a.s;
import b.a.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class cm<T>
  extends l<T>
{
  final b.a.f.a<T> a;
  final int b;
  final long c;
  final TimeUnit d;
  final t e;
  a f;
  
  public cm(b.a.f.a<T> parama)
  {
    this(parama, 1, 0L, TimeUnit.NANOSECONDS, b.a.i.a.c());
  }
  
  public cm(b.a.f.a<T> parama, int paramInt, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    this.a = parama;
    this.b = paramInt;
    this.c = paramLong;
    this.d = paramTimeUnit;
    this.e = paramt;
  }
  
  void a(a parama)
  {
    try
    {
      if (this.f == null) {
        return;
      }
      long l = parama.subscriberCount - 1L;
      parama.subscriberCount = l;
      if ((l == 0L) && (parama.connected))
      {
        if (this.c == 0L)
        {
          c(parama);
          return;
        }
        b.a.e.a.g localg = new b.a.e.a.g();
        parama.timer = localg;
        localg.replace(this.e.a(parama, this.c, this.d));
        return;
      }
      return;
    }
    finally {}
  }
  
  void b(a parama)
  {
    try
    {
      if (this.f != null)
      {
        this.f = null;
        if (parama.timer != null) {
          parama.timer.dispose();
        }
        if ((this.a instanceof b)) {
          ((b)this.a).dispose();
        }
      }
      return;
    }
    finally {}
  }
  
  void c(a parama)
  {
    try
    {
      if ((parama.subscriberCount == 0L) && (parama == this.f))
      {
        this.f = null;
        d.dispose(parama);
        if ((this.a instanceof b)) {
          ((b)this.a).dispose();
        }
      }
      return;
    }
    finally {}
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    for (;;)
    {
      try
      {
        a locala2 = this.f;
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a(this);
          this.f = locala1;
        }
        long l = locala1.subscriberCount;
        if ((l == 0L) && (locala1.timer != null)) {
          locala1.timer.dispose();
        }
        l += 1L;
        locala1.subscriberCount = l;
        boolean bool = locala1.connected;
        i = 1;
        if ((!bool) && (l == this.b))
        {
          locala1.connected = true;
          this.a.subscribe(new b(params, this, locala1));
          if (i != 0) {
            this.a.a(locala1);
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  static final class a
    extends AtomicReference<b>
    implements b.a.d.g<b>, Runnable
  {
    private static final long serialVersionUID = -4552101107598366241L;
    boolean connected;
    final cm<?> parent;
    long subscriberCount;
    b timer;
    
    a(cm<?> paramcm)
    {
      this.parent = paramcm;
    }
    
    public void accept(b paramb)
      throws Exception
    {
      d.replace(this, paramb);
    }
    
    public void run()
    {
      this.parent.c(this);
    }
  }
  
  static final class b<T>
    extends AtomicBoolean
    implements b, s<T>
  {
    private static final long serialVersionUID = -7419642935409022375L;
    final s<? super T> actual;
    final cm.a connection;
    final cm<T> parent;
    b upstream;
    
    b(s<? super T> params, cm<T> paramcm, cm.a parama)
    {
      this.actual = params;
      this.parent = paramcm;
      this.connection = parama;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
      if (compareAndSet(false, true)) {
        this.parent.a(this.connection);
      }
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      if (compareAndSet(false, true))
      {
        this.parent.b(this.connection);
        this.actual.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (compareAndSet(false, true))
      {
        this.parent.b(this.connection);
        this.actual.onError(paramThrowable);
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.upstream, paramb))
      {
        this.upstream = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */