package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.g.e;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cv<T>
  extends a<T, T>
{
  final q<?> b;
  final boolean c;
  
  public cv(q<T> paramq, q<?> paramq1, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramq1;
    this.c = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    params = new e(params);
    if (this.c)
    {
      this.a.subscribe(new a(params, this.b));
      return;
    }
    this.a.subscribe(new b(params, this.b));
  }
  
  static final class a<T>
    extends cv.c<T>
  {
    private static final long serialVersionUID = -3029755663834015785L;
    volatile boolean done;
    final AtomicInteger wip = new AtomicInteger();
    
    a(s<? super T> params, q<?> paramq)
    {
      super(paramq);
    }
    
    void completeMain()
    {
      this.done = true;
      if (this.wip.getAndIncrement() == 0)
      {
        emit();
        this.actual.onComplete();
      }
    }
    
    void completeOther()
    {
      this.done = true;
      if (this.wip.getAndIncrement() == 0)
      {
        emit();
        this.actual.onComplete();
      }
    }
    
    void run()
    {
      if (this.wip.getAndIncrement() == 0) {
        do
        {
          boolean bool = this.done;
          emit();
          if (bool)
          {
            this.actual.onComplete();
            return;
          }
        } while (this.wip.decrementAndGet() != 0);
      }
    }
  }
  
  static final class b<T>
    extends cv.c<T>
  {
    private static final long serialVersionUID = -3029755663834015785L;
    
    b(s<? super T> params, q<?> paramq)
    {
      super(paramq);
    }
    
    void completeMain()
    {
      this.actual.onComplete();
    }
    
    void completeOther()
    {
      this.actual.onComplete();
    }
    
    void run()
    {
      emit();
    }
  }
  
  static abstract class c<T>
    extends AtomicReference<T>
    implements b, s<T>
  {
    private static final long serialVersionUID = -3517602651313910099L;
    final s<? super T> actual;
    final AtomicReference<b> other = new AtomicReference();
    b s;
    final q<?> sampler;
    
    c(s<? super T> params, q<?> paramq)
    {
      this.actual = params;
      this.sampler = paramq;
    }
    
    public void complete()
    {
      this.s.dispose();
      completeOther();
    }
    
    abstract void completeMain();
    
    abstract void completeOther();
    
    public void dispose()
    {
      d.dispose(this.other);
      this.s.dispose();
    }
    
    void emit()
    {
      Object localObject = getAndSet(null);
      if (localObject != null) {
        this.actual.onNext(localObject);
      }
    }
    
    public void error(Throwable paramThrowable)
    {
      this.s.dispose();
      this.actual.onError(paramThrowable);
    }
    
    public boolean isDisposed()
    {
      return this.other.get() == d.DISPOSED;
    }
    
    public void onComplete()
    {
      d.dispose(this.other);
      completeMain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      d.dispose(this.other);
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      lazySet(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
        if (this.other.get() == null) {
          this.sampler.subscribe(new cv.d(this));
        }
      }
    }
    
    abstract void run();
    
    boolean setOther(b paramb)
    {
      return d.setOnce(this.other, paramb);
    }
  }
  
  static final class d<T>
    implements s<Object>
  {
    final cv.c<T> a;
    
    d(cv.c<T> paramc)
    {
      this.a = paramc;
    }
    
    public void onComplete()
    {
      this.a.complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.error(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      this.a.run();
    }
    
    public void onSubscribe(b paramb)
    {
      this.a.setOther(paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */