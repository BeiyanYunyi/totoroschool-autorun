package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.h.a;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class t<T, R>
  extends l<R>
{
  final q<? extends T>[] a;
  final Iterable<? extends q<? extends T>> b;
  final h<? super Object[], ? extends R> c;
  final int d;
  final boolean e;
  
  public t(q<? extends T>[] paramArrayOfq, Iterable<? extends q<? extends T>> paramIterable, h<? super Object[], ? extends R> paramh, int paramInt, boolean paramBoolean)
  {
    this.a = paramArrayOfq;
    this.b = paramIterable;
    this.c = paramh;
    this.d = paramInt;
    this.e = paramBoolean;
  }
  
  public void subscribeActual(s<? super R> params)
  {
    Object localObject1 = this.a;
    int i;
    if (localObject1 == null)
    {
      localObject1 = new l[8];
      Iterator localIterator = this.b.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        Object localObject2 = localObject1;
        if (i == localObject1.length)
        {
          localObject2 = new q[(i >> 2) + i];
          System.arraycopy(localObject1, 0, localObject2, 0, i);
        }
        localObject2[i] = localq;
        i += 1;
        localObject1 = localObject2;
      }
    }
    else
    {
      i = localObject1.length;
    }
    if (i == 0)
    {
      e.complete(params);
      return;
    }
    new b(params, this.c, i, this.d, this.e).subscribe((q[])localObject1);
  }
  
  static final class a<T, R>
    extends AtomicReference<b.a.b.b>
    implements s<T>
  {
    private static final long serialVersionUID = -4823716997131257941L;
    final int index;
    final t.b<T, R> parent;
    
    a(t.b<T, R> paramb, int paramInt)
    {
      this.parent = paramb;
      this.index = paramInt;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public void onComplete()
    {
      this.parent.innerComplete(this.index);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(this.index, paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.parent.innerNext(this.index, paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
  
  static final class b<T, R>
    extends AtomicInteger
    implements b.a.b.b
  {
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    final s<? super R> actual;
    volatile boolean cancelled;
    final h<? super Object[], ? extends R> combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final b.a.e.j.c errors = new b.a.e.j.c();
    Object[] latest;
    final t.a<T, R>[] observers;
    final b.a.e.f.c<Object[]> queue;
    
    b(s<? super R> params, h<? super Object[], ? extends R> paramh, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.actual = params;
      this.combiner = paramh;
      this.delayError = paramBoolean;
      this.latest = new Object[paramInt1];
      params = new t.a[paramInt1];
      int i = 0;
      while (i < paramInt1)
      {
        params[i] = new t.a(this, i);
        i += 1;
      }
      this.observers = params;
      this.queue = new b.a.e.f.c(paramInt2);
    }
    
    void cancelSources()
    {
      t.a[] arrayOfa = this.observers;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].dispose();
        i += 1;
      }
    }
    
    void clear(b.a.e.f.c<?> paramc)
    {
      try
      {
        this.latest = null;
        paramc.clear();
        return;
      }
      finally {}
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() == 0) {
          clear(this.queue);
        }
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      Object localObject1 = this.queue;
      s locals = this.actual;
      boolean bool1 = this.delayError;
      int i = 1;
      for (;;)
      {
        if (this.cancelled)
        {
          clear((b.a.e.f.c)localObject1);
          return;
        }
        if ((!bool1) && (this.errors.get() != null))
        {
          cancelSources();
          clear((b.a.e.f.c)localObject1);
          locals.onError(this.errors.terminate());
          return;
        }
        boolean bool2 = this.done;
        Object localObject2 = (Object[])((b.a.e.f.c)localObject1).poll();
        int j;
        if (localObject2 == null) {
          j = 1;
        } else {
          j = 0;
        }
        if ((bool2) && (j != 0))
        {
          clear((b.a.e.f.c)localObject1);
          localObject1 = this.errors.terminate();
          if (localObject1 == null)
          {
            locals.onComplete();
            return;
          }
          locals.onError((Throwable)localObject1);
          return;
        }
        if (j != 0)
        {
          j = addAndGet(-i);
          i = j;
          if (j != 0) {}
        }
        else
        {
          try
          {
            localObject2 = b.a.e.b.b.a(this.combiner.apply(localObject2), "The combiner returned a null value");
            locals.onNext(localObject2);
          }
          catch (Throwable localThrowable)
          {
            b.a.c.b.b(localThrowable);
            this.errors.addThrowable(localThrowable);
            cancelSources();
            clear((b.a.e.f.c)localObject1);
            locals.onError(this.errors.terminate());
          }
        }
      }
    }
    
    void innerComplete(int paramInt)
    {
      for (;;)
      {
        Object[] arrayOfObject;
        try
        {
          arrayOfObject = this.latest;
          if (arrayOfObject != null) {
            break label61;
          }
          return;
        }
        finally {}
        if (paramInt == 0)
        {
          int i = this.complete + 1;
          this.complete = i;
          if (i != arrayOfObject.length) {}
        }
        else
        {
          this.done = true;
        }
        if (paramInt != 0) {
          cancelSources();
        }
        drain();
        return;
        label61:
        if (localObject[paramInt] == null) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
    
    void innerError(int paramInt, Throwable paramThrowable)
    {
      if (this.errors.addThrowable(paramThrowable)) {
        if (!this.delayError) {}
      }
      for (;;)
      {
        try
        {
          paramThrowable = this.latest;
          if (paramThrowable != null) {
            break label89;
          }
          return;
        }
        finally {}
        if (paramInt == 0)
        {
          int i = this.complete + 1;
          this.complete = i;
          if (i != paramThrowable.length) {}
        }
        else
        {
          this.done = true;
        }
        break label71;
        paramInt = 1;
        label71:
        if (paramInt != 0) {
          cancelSources();
        }
        drain();
        return;
        a.a(paramThrowable);
        return;
        label89:
        if (paramThrowable[paramInt] == null) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
    
    void innerNext(int paramInt, T paramT)
    {
      for (;;)
      {
        try
        {
          Object[] arrayOfObject = this.latest;
          if (arrayOfObject == null) {
            return;
          }
          Object localObject = arrayOfObject[paramInt];
          int j = this.active;
          int i = j;
          if (localObject == null)
          {
            i = j + 1;
            this.active = i;
          }
          arrayOfObject[paramInt] = paramT;
          if (i == arrayOfObject.length)
          {
            this.queue.offer(arrayOfObject.clone());
            paramInt = 1;
            if (paramInt != 0) {
              drain();
            }
            return;
          }
        }
        finally {}
        paramInt = 0;
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void subscribe(q<? extends T>[] paramArrayOfq)
    {
      t.a[] arrayOfa = this.observers;
      int j = arrayOfa.length;
      this.actual.onSubscribe(this);
      int i = 0;
      while (i < j) {
        if (!this.done)
        {
          if (this.cancelled) {
            return;
          }
          paramArrayOfq[i].subscribe(arrayOfa[i]);
          i += 1;
        }
        else {}
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */