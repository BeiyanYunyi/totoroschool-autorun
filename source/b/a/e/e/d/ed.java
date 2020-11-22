package b.a.e.e.d;

import b.a.b.b;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ed<T>
  extends a<T, l<T>>
{
  final long b;
  final long c;
  final int d;
  
  public ed(q<T> paramq, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramq);
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramInt;
  }
  
  public void subscribeActual(s<? super l<T>> params)
  {
    if (this.b == this.c)
    {
      this.a.subscribe(new a(params, this.b, this.d));
      return;
    }
    this.a.subscribe(new b(params, this.b, this.c, this.d));
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b, s<T>, Runnable
  {
    private static final long serialVersionUID = -7481782523886138128L;
    final s<? super l<T>> actual;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    b s;
    long size;
    b.a.j.d<T> window;
    
    a(s<? super l<T>> params, long paramLong, int paramInt)
    {
      this.actual = params;
      this.count = paramLong;
      this.capacityHint = paramInt;
    }
    
    public void dispose()
    {
      this.cancelled = true;
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      b.a.j.d locald = this.window;
      if (locald != null)
      {
        this.window = null;
        locald.onComplete();
      }
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      b.a.j.d locald = this.window;
      if (locald != null)
      {
        this.window = null;
        locald.onError(paramThrowable);
      }
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      b.a.j.d locald2 = this.window;
      b.a.j.d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = locald2;
        if (!this.cancelled)
        {
          locald1 = b.a.j.d.a(this.capacityHint, this);
          this.window = locald1;
          this.actual.onNext(locald1);
        }
      }
      if (locald1 != null)
      {
        locald1.onNext(paramT);
        long l = this.size + 1L;
        this.size = l;
        if (l >= this.count)
        {
          this.size = 0L;
          this.window = null;
          locald1.onComplete();
          if (this.cancelled) {
            this.s.dispose();
          }
        }
      }
    }
    
    public void onSubscribe(b paramb)
    {
      if (b.a.e.a.d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
    
    public void run()
    {
      if (this.cancelled) {
        this.s.dispose();
      }
    }
  }
  
  static final class b<T>
    extends AtomicBoolean
    implements b, s<T>, Runnable
  {
    private static final long serialVersionUID = 3366976432059579510L;
    final s<? super l<T>> actual;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    long firstEmission;
    long index;
    b s;
    final long skip;
    final ArrayDeque<b.a.j.d<T>> windows;
    final AtomicInteger wip = new AtomicInteger();
    
    b(s<? super l<T>> params, long paramLong1, long paramLong2, int paramInt)
    {
      this.actual = params;
      this.count = paramLong1;
      this.skip = paramLong2;
      this.capacityHint = paramInt;
      this.windows = new ArrayDeque();
    }
    
    public void dispose()
    {
      this.cancelled = true;
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      ArrayDeque localArrayDeque = this.windows;
      while (!localArrayDeque.isEmpty()) {
        ((b.a.j.d)localArrayDeque.poll()).onComplete();
      }
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      ArrayDeque localArrayDeque = this.windows;
      while (!localArrayDeque.isEmpty()) {
        ((b.a.j.d)localArrayDeque.poll()).onError(paramThrowable);
      }
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      ArrayDeque localArrayDeque = this.windows;
      long l1 = this.index;
      long l2 = this.skip;
      if ((l1 % l2 == 0L) && (!this.cancelled))
      {
        this.wip.getAndIncrement();
        localObject = b.a.j.d.a(this.capacityHint, this);
        localArrayDeque.offer(localObject);
        this.actual.onNext(localObject);
      }
      long l3 = this.firstEmission + 1L;
      Object localObject = localArrayDeque.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a.j.d)((Iterator)localObject).next()).onNext(paramT);
      }
      if (l3 >= this.count)
      {
        ((b.a.j.d)localArrayDeque.poll()).onComplete();
        if ((localArrayDeque.isEmpty()) && (this.cancelled))
        {
          this.s.dispose();
          return;
        }
        this.firstEmission = (l3 - l2);
      }
      else
      {
        this.firstEmission = l3;
      }
      this.index = (l1 + 1L);
    }
    
    public void onSubscribe(b paramb)
    {
      if (b.a.e.a.d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
    
    public void run()
    {
      if ((this.wip.decrementAndGet() == 0) && (this.cancelled)) {
        this.s.dispose();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */