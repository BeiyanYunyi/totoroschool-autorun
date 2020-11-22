package b.a.e.e.a;

import b.a.e.j.d;
import b.a.g;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;

public final class f<T>
  extends a<T, T>
{
  public f(b.a.f<T> paramf)
  {
    super(paramf);
  }
  
  protected void b(org.a.b<? super T> paramb)
  {
    this.b.a(new a(paramb));
  }
  
  static final class a<T>
    extends AtomicInteger
    implements g<T>, c
  {
    private static final long serialVersionUID = 163080509307634843L;
    final org.a.b<? super T> actual;
    volatile boolean cancelled;
    final AtomicReference<T> current = new AtomicReference();
    volatile boolean done;
    Throwable error;
    final AtomicLong requested = new AtomicLong();
    c s;
    
    a(org.a.b<? super T> paramb)
    {
      this.actual = paramb;
    }
    
    public void cancel()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
          this.current.lazySet(null);
        }
      }
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, org.a.b<?> paramb, AtomicReference<T> paramAtomicReference)
    {
      if (this.cancelled)
      {
        paramAtomicReference.lazySet(null);
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable = this.error;
        if (localThrowable != null)
        {
          paramAtomicReference.lazySet(null);
          paramb.onError(localThrowable);
          return true;
        }
        if (paramBoolean2)
        {
          paramb.onComplete();
          return true;
        }
      }
      return false;
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      org.a.b localb = this.actual;
      AtomicLong localAtomicLong = this.requested;
      AtomicReference localAtomicReference = this.current;
      int i = 1;
      int j;
      do
      {
        boolean bool2;
        boolean bool3;
        boolean bool1;
        for (long l1 = 0L;; l1 += 1L)
        {
          long l2 = localAtomicLong.get();
          bool2 = false;
          if (l1 == l2) {
            break;
          }
          bool3 = this.done;
          Object localObject = localAtomicReference.getAndSet(null);
          if (localObject == null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (checkTerminated(bool3, bool1, localb, localAtomicReference)) {
            return;
          }
          if (bool1) {
            break;
          }
          localb.onNext(localObject);
        }
        if (l1 == localAtomicLong.get())
        {
          bool3 = this.done;
          bool1 = bool2;
          if (localAtomicReference.get() == null) {
            bool1 = true;
          }
          if (checkTerminated(bool3, bool1, localb, localAtomicReference)) {
            return;
          }
        }
        if (l1 != 0L) {
          d.b(localAtomicLong, l1);
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      drain();
    }
    
    public void onNext(T paramT)
    {
      this.current.lazySet(paramT);
      drain();
    }
    
    public void onSubscribe(c paramc)
    {
      if (b.a.e.i.b.validate(this.s, paramc))
      {
        this.s = paramc;
        this.actual.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
    
    public void request(long paramLong)
    {
      if (b.a.e.i.b.validate(paramLong))
      {
        d.a(this.requested, paramLong);
        drain();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */