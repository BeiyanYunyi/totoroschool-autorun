package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.a.e;
import b.a.h.a;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class h<T>
  extends l<T>
{
  final q<? extends T>[] a;
  final Iterable<? extends q<? extends T>> b;
  
  public h(q<? extends T>[] paramArrayOfq, Iterable<? extends q<? extends T>> paramIterable)
  {
    this.a = paramArrayOfq;
    this.b = paramIterable;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    Object localObject2 = this.a;
    int j;
    if (localObject2 == null)
    {
      Object localObject1 = new l[8];
      try
      {
        Iterator localIterator = this.b.iterator();
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          q localq = (q)localIterator.next();
          if (localq == null)
          {
            e.error(new NullPointerException("One of the sources is null"), params);
            return;
          }
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
        j = localObject2.length;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        e.error(localThrowable, params);
        return;
      }
    }
    if (j == 0)
    {
      e.complete(params);
      return;
    }
    if (j == 1)
    {
      localObject2[0].subscribe(params);
      return;
    }
    new a(params, j).a((q[])localObject2);
  }
  
  static final class a<T>
    implements b.a.b.b
  {
    final s<? super T> a;
    final h.b<T>[] b;
    final AtomicInteger c = new AtomicInteger();
    
    a(s<? super T> params, int paramInt)
    {
      this.a = params;
      this.b = new h.b[paramInt];
    }
    
    public void a(q<? extends T>[] paramArrayOfq)
    {
      h.b[] arrayOfb = this.b;
      int m = arrayOfb.length;
      int j = 0;
      int k;
      for (int i = 0; i < m; i = k)
      {
        k = i + 1;
        arrayOfb[i] = new h.b(this, k, this.a);
      }
      this.c.lazySet(0);
      this.a.onSubscribe(this);
      i = j;
      while (i < m)
      {
        if (this.c.get() != 0) {
          return;
        }
        paramArrayOfq[i].subscribe(arrayOfb[i]);
        i += 1;
      }
    }
    
    public boolean a(int paramInt)
    {
      int j = this.c.get();
      int i = 0;
      if (j == 0)
      {
        if (this.c.compareAndSet(0, paramInt))
        {
          h.b[] arrayOfb = this.b;
          int k = arrayOfb.length;
          while (i < k)
          {
            j = i + 1;
            if (j != paramInt) {
              arrayOfb[i].dispose();
            }
            i = j;
          }
          return true;
        }
        return false;
      }
      return j == paramInt;
    }
    
    public void dispose()
    {
      if (this.c.get() != -1)
      {
        this.c.lazySet(-1);
        h.b[] arrayOfb = this.b;
        int j = arrayOfb.length;
        int i = 0;
        while (i < j)
        {
          arrayOfb[i].dispose();
          i += 1;
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.c.get() == -1;
    }
  }
  
  static final class b<T>
    extends AtomicReference<b.a.b.b>
    implements s<T>
  {
    private static final long serialVersionUID = -1185974347409665484L;
    final s<? super T> actual;
    final int index;
    final h.a<T> parent;
    boolean won;
    
    b(h.a<T> parama, int paramInt, s<? super T> params)
    {
      this.parent = parama;
      this.index = paramInt;
      this.actual = params;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public void onComplete()
    {
      if (this.won)
      {
        this.actual.onComplete();
        return;
      }
      if (this.parent.a(this.index))
      {
        this.won = true;
        this.actual.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.won)
      {
        this.actual.onError(paramThrowable);
        return;
      }
      if (this.parent.a(this.index))
      {
        this.won = true;
        this.actual.onError(paramThrowable);
        return;
      }
      a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.won)
      {
        this.actual.onNext(paramT);
        return;
      }
      if (this.parent.a(this.index))
      {
        this.won = true;
        this.actual.onNext(paramT);
        return;
      }
      ((b.a.b.b)get()).dispose();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */