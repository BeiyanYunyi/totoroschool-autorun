package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.e.f.c;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ek<T, R>
  extends l<R>
{
  final q<? extends T>[] a;
  final Iterable<? extends q<? extends T>> b;
  final h<? super Object[], ? extends R> c;
  final int d;
  final boolean e;
  
  public ek(q<? extends T>[] paramArrayOfq, Iterable<? extends q<? extends T>> paramIterable, h<? super Object[], ? extends R> paramh, int paramInt, boolean paramBoolean)
  {
    this.a = paramArrayOfq;
    this.b = paramIterable;
    this.c = paramh;
    this.d = paramInt;
    this.e = paramBoolean;
  }
  
  public void subscribeActual(s<? super R> params)
  {
    Object localObject2 = this.a;
    if (localObject2 == null)
    {
      Object localObject1 = new l[8];
      Iterator localIterator = this.b.iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        q localq = (q)localIterator.next();
        localObject2 = localObject1;
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
    int j = localObject2.length;
    if (j == 0)
    {
      e.complete(params);
      return;
    }
    new a(params, this.c, j, this.e).subscribe((q[])localObject2, this.d);
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements b.a.b.b
  {
    private static final long serialVersionUID = 2983708048395377667L;
    final s<? super R> actual;
    volatile boolean cancelled;
    final boolean delayError;
    final ek.b<T, R>[] observers;
    final T[] row;
    final h<? super Object[], ? extends R> zipper;
    
    a(s<? super R> params, h<? super Object[], ? extends R> paramh, int paramInt, boolean paramBoolean)
    {
      this.actual = params;
      this.zipper = paramh;
      this.observers = new ek.b[paramInt];
      this.row = ((Object[])new Object[paramInt]);
      this.delayError = paramBoolean;
    }
    
    void cancel()
    {
      clear();
      cancelSources();
    }
    
    void cancelSources()
    {
      ek.b[] arrayOfb = this.observers;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].a();
        i += 1;
      }
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, s<? super R> params, boolean paramBoolean3, ek.b<?, ?> paramb)
    {
      if (this.cancelled)
      {
        cancel();
        return true;
      }
      if (paramBoolean1) {
        if (paramBoolean3)
        {
          if (paramBoolean2)
          {
            paramb = paramb.d;
            cancel();
            if (paramb != null)
            {
              params.onError(paramb);
              return true;
            }
            params.onComplete();
            return true;
          }
        }
        else
        {
          paramb = paramb.d;
          if (paramb != null)
          {
            cancel();
            params.onError(paramb);
            return true;
          }
          if (paramBoolean2)
          {
            cancel();
            params.onComplete();
            return true;
          }
        }
      }
      return false;
    }
    
    void clear()
    {
      ek.b[] arrayOfb = this.observers;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].b.clear();
        i += 1;
      }
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() == 0) {
          clear();
        }
      }
    }
    
    public void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      ek.b[] arrayOfb = this.observers;
      s locals = this.actual;
      Object[] arrayOfObject = this.row;
      boolean bool2 = this.delayError;
      int i = 1;
      for (;;)
      {
        int i1 = arrayOfb.length;
        int j = 0;
        int k = 0;
        Object localObject1;
        int n;
        for (int m = 0; j < i1; m = n)
        {
          localObject1 = arrayOfb[j];
          if (arrayOfObject[k] == null)
          {
            boolean bool3 = ((ek.b)localObject1).c;
            Object localObject2 = ((ek.b)localObject1).b.poll();
            boolean bool1;
            if (localObject2 == null) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (checkTerminated(bool3, bool1, locals, bool2, (ek.b)localObject1)) {
              return;
            }
            if (!bool1)
            {
              arrayOfObject[k] = localObject2;
              n = m;
            }
            else
            {
              n = m + 1;
            }
          }
          else
          {
            n = m;
            if (((ek.b)localObject1).c)
            {
              n = m;
              if (!bool2)
              {
                localObject1 = ((ek.b)localObject1).d;
                n = m;
                if (localObject1 != null)
                {
                  cancel();
                  locals.onError((Throwable)localObject1);
                  return;
                }
              }
            }
          }
          k += 1;
          j += 1;
        }
        if (m != 0)
        {
          j = addAndGet(-i);
          i = j;
          if (j != 0) {}
        }
        else
        {
          try
          {
            localObject1 = b.a.e.b.b.a(this.zipper.apply(arrayOfObject.clone()), "The zipper returned a null value");
            locals.onNext(localObject1);
            Arrays.fill(arrayOfObject, null);
          }
          catch (Throwable localThrowable)
          {
            b.a.c.b.b(localThrowable);
            cancel();
            locals.onError(localThrowable);
          }
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void subscribe(q<? extends T>[] paramArrayOfq, int paramInt)
    {
      ek.b[] arrayOfb = this.observers;
      int k = arrayOfb.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        arrayOfb[i] = new ek.b(this, paramInt);
        i += 1;
      }
      lazySet(0);
      this.actual.onSubscribe(this);
      paramInt = j;
      while (paramInt < k)
      {
        if (this.cancelled) {
          return;
        }
        paramArrayOfq[paramInt].subscribe(arrayOfb[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  static final class b<T, R>
    implements s<T>
  {
    final ek.a<T, R> a;
    final c<T> b;
    volatile boolean c;
    Throwable d;
    final AtomicReference<b.a.b.b> e = new AtomicReference();
    
    b(ek.a<T, R> parama, int paramInt)
    {
      this.a = parama;
      this.b = new c(paramInt);
    }
    
    public void a()
    {
      d.dispose(this.e);
    }
    
    public void onComplete()
    {
      this.c = true;
      this.a.drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.d = paramThrowable;
      this.c = true;
      this.a.drain();
    }
    
    public void onNext(T paramT)
    {
      this.b.offer(paramT);
      this.a.drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this.e, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */