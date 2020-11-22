package b.a.e.e.d;

import b.a.d.d;
import b.a.e.a.a;
import b.a.e.f.c;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;

public final class cz<T>
  extends l<Boolean>
{
  final q<? extends T> a;
  final q<? extends T> b;
  final d<? super T, ? super T> c;
  final int d;
  
  public cz(q<? extends T> paramq1, q<? extends T> paramq2, d<? super T, ? super T> paramd, int paramInt)
  {
    this.a = paramq1;
    this.b = paramq2;
    this.c = paramd;
    this.d = paramInt;
  }
  
  public void subscribeActual(s<? super Boolean> params)
  {
    a locala = new a(params, this.d, this.a, this.b, this.c);
    params.onSubscribe(locala);
    locala.subscribe();
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b.a.b.b
  {
    private static final long serialVersionUID = -6178010334400373240L;
    final s<? super Boolean> actual;
    volatile boolean cancelled;
    final d<? super T, ? super T> comparer;
    final q<? extends T> first;
    final cz.b<T>[] observers;
    final a resources;
    final q<? extends T> second;
    T v1;
    T v2;
    
    a(s<? super Boolean> params, int paramInt, q<? extends T> paramq1, q<? extends T> paramq2, d<? super T, ? super T> paramd)
    {
      this.actual = params;
      this.first = paramq1;
      this.second = paramq2;
      this.comparer = paramd;
      params = new cz.b[2];
      this.observers = params;
      params[0] = new cz.b(this, 0, paramInt);
      params[1] = new cz.b(this, 1, paramInt);
      this.resources = new a(2);
    }
    
    void cancel(c<T> paramc1, c<T> paramc2)
    {
      this.cancelled = true;
      paramc1.clear();
      paramc2.clear();
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.resources.dispose();
        if (getAndIncrement() == 0)
        {
          cz.b[] arrayOfb = this.observers;
          arrayOfb[0].b.clear();
          arrayOfb[1].b.clear();
        }
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      Object localObject2 = this.observers;
      Object localObject1 = localObject2[0];
      c localc = ((cz.b)localObject1).b;
      Object localObject3 = localObject2[1];
      localObject2 = ((cz.b)localObject3).b;
      int i = 1;
      int j;
      do
      {
        int k;
        do
        {
          if (this.cancelled)
          {
            localc.clear();
            ((c)localObject2).clear();
            return;
          }
          boolean bool1 = ((cz.b)localObject1).d;
          Throwable localThrowable2;
          if (bool1)
          {
            localThrowable2 = ((cz.b)localObject1).e;
            if (localThrowable2 != null)
            {
              cancel(localc, (c)localObject2);
              this.actual.onError(localThrowable2);
              return;
            }
          }
          boolean bool2 = ((cz.b)localObject3).d;
          if (bool2)
          {
            localThrowable2 = ((cz.b)localObject3).e;
            if (localThrowable2 != null)
            {
              cancel(localc, (c)localObject2);
              this.actual.onError(localThrowable2);
              return;
            }
          }
          if (this.v1 == null) {
            this.v1 = localc.poll();
          }
          if (this.v1 == null) {
            j = 1;
          } else {
            j = 0;
          }
          if (this.v2 == null) {
            this.v2 = ((c)localObject2).poll();
          }
          if (this.v2 == null) {
            k = 1;
          } else {
            k = 0;
          }
          if ((bool1) && (bool2) && (j != 0) && (k != 0))
          {
            this.actual.onNext(Boolean.valueOf(true));
            this.actual.onComplete();
            return;
          }
          if ((bool1) && (bool2) && (j != k))
          {
            cancel(localc, (c)localObject2);
            this.actual.onNext(Boolean.valueOf(false));
            this.actual.onComplete();
            return;
          }
          if ((j == 0) && (k == 0)) {
            try
            {
              bool1 = this.comparer.a(this.v1, this.v2);
              if (!bool1)
              {
                cancel(localc, (c)localObject2);
                this.actual.onNext(Boolean.valueOf(false));
                this.actual.onComplete();
                return;
              }
              this.v1 = null;
              this.v2 = null;
            }
            catch (Throwable localThrowable1)
            {
              b.a.c.b.b(localThrowable1);
              cancel(localc, (c)localObject2);
              this.actual.onError(localThrowable1);
              return;
            }
          }
        } while ((j == 0) && (k == 0));
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    boolean setDisposable(b.a.b.b paramb, int paramInt)
    {
      return this.resources.setResource(paramInt, paramb);
    }
    
    void subscribe()
    {
      cz.b[] arrayOfb = this.observers;
      this.first.subscribe(arrayOfb[0]);
      this.second.subscribe(arrayOfb[1]);
    }
  }
  
  static final class b<T>
    implements s<T>
  {
    final cz.a<T> a;
    final c<T> b;
    final int c;
    volatile boolean d;
    Throwable e;
    
    b(cz.a<T> parama, int paramInt1, int paramInt2)
    {
      this.a = parama;
      this.c = paramInt1;
      this.b = new c(paramInt2);
    }
    
    public void onComplete()
    {
      this.d = true;
      this.a.drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.e = paramThrowable;
      this.d = true;
      this.a.drain();
    }
    
    public void onNext(T paramT)
    {
      this.b.offer(paramT);
      this.a.drain();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.a.setDisposable(paramb, this.c);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */