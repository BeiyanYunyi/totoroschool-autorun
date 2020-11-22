package b.a.e.e.a;

import b.a.e.j.d;
import b.a.g;
import java.util.concurrent.atomic.AtomicLong;

public final class c<T>
  extends a<T, T>
{
  final int c;
  final boolean d;
  final boolean e;
  final b.a.d.a f;
  
  public c(b.a.f<T> paramf, int paramInt, boolean paramBoolean1, boolean paramBoolean2, b.a.d.a parama)
  {
    super(paramf);
    this.c = paramInt;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = parama;
  }
  
  protected void b(org.a.b<? super T> paramb)
  {
    this.b.a(new a(paramb, this.c, this.d, this.e, this.f));
  }
  
  static final class a<T>
    extends b.a.e.i.a<T>
    implements g<T>
  {
    private static final long serialVersionUID = -2514538129242366402L;
    final org.a.b<? super T> actual;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final b.a.d.a onOverflow;
    boolean outputFused;
    final b.a.e.c.f<T> queue;
    final AtomicLong requested = new AtomicLong();
    org.a.c s;
    
    a(org.a.b<? super T> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2, b.a.d.a parama)
    {
      this.actual = paramb;
      this.onOverflow = parama;
      this.delayError = paramBoolean2;
      if (paramBoolean1) {
        paramb = new b.a.e.f.c(paramInt);
      } else {
        paramb = new b.a.e.f.b(paramInt);
      }
      this.queue = paramb;
    }
    
    public void cancel()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
          this.queue.clear();
        }
      }
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, org.a.b<? super T> paramb)
    {
      if (this.cancelled)
      {
        this.queue.clear();
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable;
        if (this.delayError)
        {
          if (paramBoolean2)
          {
            localThrowable = this.error;
            if (localThrowable != null)
            {
              paramb.onError(localThrowable);
              return true;
            }
            paramb.onComplete();
            return true;
          }
        }
        else
        {
          localThrowable = this.error;
          if (localThrowable != null)
          {
            this.queue.clear();
            paramb.onError(localThrowable);
            return true;
          }
          if (paramBoolean2)
          {
            paramb.onComplete();
            return true;
          }
        }
      }
      return false;
    }
    
    public void clear()
    {
      this.queue.clear();
    }
    
    void drain()
    {
      if (getAndIncrement() == 0)
      {
        b.a.e.c.f localf = this.queue;
        org.a.b localb = this.actual;
        int i = 1;
        int j;
        do
        {
          if (checkTerminated(this.done, localf.isEmpty(), localb)) {
            return;
          }
          long l2 = this.requested.get();
          for (long l1 = 0L; l1 != l2; l1 += 1L)
          {
            boolean bool2 = this.done;
            Object localObject = localf.poll();
            boolean bool1;
            if (localObject == null) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (checkTerminated(bool2, bool1, localb)) {
              return;
            }
            if (bool1) {
              break;
            }
            localb.onNext(localObject);
          }
          if ((l1 == l2) && (checkTerminated(this.done, localf.isEmpty(), localb))) {
            return;
          }
          if ((l1 != 0L) && (l2 != Long.MAX_VALUE)) {
            this.requested.addAndGet(-l1);
          }
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      }
    }
    
    public boolean isEmpty()
    {
      return this.queue.isEmpty();
    }
    
    public void onComplete()
    {
      this.done = true;
      if (this.outputFused)
      {
        this.actual.onComplete();
        return;
      }
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      if (this.outputFused)
      {
        this.actual.onError(paramThrowable);
        return;
      }
      drain();
    }
    
    public void onNext(T paramT)
    {
      if (!this.queue.offer(paramT))
      {
        this.s.cancel();
        paramT = new b.a.c.c("Buffer is full");
        try
        {
          this.onOverflow.a();
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          paramT.initCause(localThrowable);
        }
        onError(paramT);
        return;
      }
      if (this.outputFused)
      {
        this.actual.onNext(null);
        return;
      }
      drain();
    }
    
    public void onSubscribe(org.a.c paramc)
    {
      if (b.a.e.i.b.validate(this.s, paramc))
      {
        this.s = paramc;
        this.actual.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
    
    public T poll()
      throws Exception
    {
      return (T)this.queue.poll();
    }
    
    public void request(long paramLong)
    {
      if ((!this.outputFused) && (b.a.e.i.b.validate(paramLong)))
      {
        d.a(this.requested, paramLong);
        drain();
      }
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x2) != 0)
      {
        this.outputFused = true;
        return 2;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */