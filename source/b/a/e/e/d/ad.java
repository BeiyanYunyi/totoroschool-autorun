package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.g.e;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ad<T>
  extends a<T, T>
{
  final long b;
  final TimeUnit c;
  final t d;
  
  public ad(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    super(paramq);
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.d = paramt;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new b(new e(params), this.b, this.c, this.d.a()));
  }
  
  static final class a<T>
    extends AtomicReference<b>
    implements b, Runnable
  {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once = new AtomicBoolean();
    final ad.b<T> parent;
    final T value;
    
    a(T paramT, long paramLong, ad.b<T> paramb)
    {
      this.value = paramT;
      this.idx = paramLong;
      this.parent = paramb;
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
      if (this.once.compareAndSet(false, true)) {
        this.parent.a(this.idx, this.value, this);
      }
    }
    
    public void setResource(b paramb)
    {
      d.replace(this, paramb);
    }
  }
  
  static final class b<T>
    implements b, s<T>
  {
    final s<? super T> a;
    final long b;
    final TimeUnit c;
    final t.c d;
    b e;
    b f;
    volatile long g;
    boolean h;
    
    b(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t.c paramc)
    {
      this.a = params;
      this.b = paramLong;
      this.c = paramTimeUnit;
      this.d = paramc;
    }
    
    void a(long paramLong, T paramT, ad.a<T> parama)
    {
      if (paramLong == this.g)
      {
        this.a.onNext(paramT);
        parama.dispose();
      }
    }
    
    public void dispose()
    {
      this.e.dispose();
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.h) {
        return;
      }
      this.h = true;
      Object localObject = this.f;
      if (localObject != null) {
        ((b)localObject).dispose();
      }
      localObject = (ad.a)localObject;
      if (localObject != null) {
        ((ad.a)localObject).run();
      }
      this.a.onComplete();
      this.d.dispose();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.h)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      b localb = this.f;
      if (localb != null) {
        localb.dispose();
      }
      this.h = true;
      this.a.onError(paramThrowable);
      this.d.dispose();
    }
    
    public void onNext(T paramT)
    {
      if (this.h) {
        return;
      }
      long l = this.g + 1L;
      this.g = l;
      b localb = this.f;
      if (localb != null) {
        localb.dispose();
      }
      paramT = new ad.a(paramT, l, this);
      this.f = paramT;
      paramT.setResource(this.d.a(paramT, this.b, this.c));
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.e, paramb))
      {
        this.e = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */