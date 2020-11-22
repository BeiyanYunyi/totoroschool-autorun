package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.c.g;
import b.a.e.f.c;
import b.a.e.g.n;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;

public final class cc<T>
  extends a<T, T>
{
  final t b;
  final boolean c;
  final int d;
  
  public cc(q<T> paramq, t paramt, boolean paramBoolean, int paramInt)
  {
    super(paramq);
    this.b = paramt;
    this.c = paramBoolean;
    this.d = paramInt;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    if ((this.b instanceof n))
    {
      this.a.subscribe(params);
      return;
    }
    t.c localc = this.b.a();
    this.a.subscribe(new a(params, localc, this.c, this.d));
  }
  
  static final class a<T>
    extends b.a.e.d.b<T>
    implements s<T>, Runnable
  {
    private static final long serialVersionUID = 6576896619930983584L;
    final s<? super T> actual;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    boolean outputFused;
    g<T> queue;
    b.a.b.b s;
    int sourceMode;
    final t.c worker;
    
    a(s<? super T> params, t.c paramc, boolean paramBoolean, int paramInt)
    {
      this.actual = params;
      this.worker = paramc;
      this.delayError = paramBoolean;
      this.bufferSize = paramInt;
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, s<? super T> params)
    {
      if (this.cancelled)
      {
        this.queue.clear();
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable = this.error;
        if (this.delayError)
        {
          if (paramBoolean2)
          {
            if (localThrowable != null) {
              params.onError(localThrowable);
            } else {
              params.onComplete();
            }
            this.worker.dispose();
            return true;
          }
        }
        else
        {
          if (localThrowable != null)
          {
            this.queue.clear();
            params.onError(localThrowable);
            this.worker.dispose();
            return true;
          }
          if (paramBoolean2)
          {
            params.onComplete();
            this.worker.dispose();
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
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.s.dispose();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
          this.queue.clear();
        }
      }
    }
    
    void drainFused()
    {
      int i = 1;
      int j;
      do
      {
        if (this.cancelled) {
          return;
        }
        boolean bool = this.done;
        Throwable localThrowable = this.error;
        if ((!this.delayError) && (bool) && (localThrowable != null))
        {
          this.actual.onError(this.error);
          this.worker.dispose();
          return;
        }
        this.actual.onNext(null);
        if (bool)
        {
          localThrowable = this.error;
          if (localThrowable != null) {
            this.actual.onError(localThrowable);
          } else {
            this.actual.onComplete();
          }
          this.worker.dispose();
          return;
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    void drainNormal()
    {
      g localg = this.queue;
      s locals = this.actual;
      int i = 1;
      for (;;)
      {
        if (checkTerminated(this.done, localg.isEmpty(), locals)) {
          return;
        }
        boolean bool2 = this.done;
        try
        {
          Object localObject = localg.poll();
          boolean bool1;
          if (localObject == null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (checkTerminated(bool2, bool1, locals)) {
            return;
          }
          if (bool1)
          {
            int j = addAndGet(-i);
            i = j;
            if (j != 0) {}
          }
          else
          {
            locals.onNext(localObject);
          }
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          this.s.dispose();
          localg.clear();
          locals.onError(localThrowable);
          this.worker.dispose();
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public boolean isEmpty()
    {
      return this.queue.isEmpty();
    }
    
    public void onComplete()
    {
      if (this.done) {
        return;
      }
      this.done = true;
      schedule();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.done)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.error = paramThrowable;
      this.done = true;
      schedule();
    }
    
    public void onNext(T paramT)
    {
      if (this.done) {
        return;
      }
      if (this.sourceMode != 2) {
        this.queue.offer(paramT);
      }
      schedule();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        if ((paramb instanceof b.a.e.c.b))
        {
          paramb = (b.a.e.c.b)paramb;
          int i = paramb.requestFusion(7);
          if (i == 1)
          {
            this.sourceMode = i;
            this.queue = paramb;
            this.done = true;
            this.actual.onSubscribe(this);
            schedule();
            return;
          }
          if (i == 2)
          {
            this.sourceMode = i;
            this.queue = paramb;
            this.actual.onSubscribe(this);
            return;
          }
        }
        this.queue = new c(this.bufferSize);
        this.actual.onSubscribe(this);
      }
    }
    
    public T poll()
      throws Exception
    {
      return (T)this.queue.poll();
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
    
    public void run()
    {
      if (this.outputFused)
      {
        drainFused();
        return;
      }
      drainNormal();
    }
    
    void schedule()
    {
      if (getAndIncrement() == 0) {
        this.worker.a(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */