package b.a.e.e.d;

import b.a.e.a.g;
import b.a.e.j.m;
import b.a.e.j.n;
import b.a.l;
import b.a.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class q<T>
  extends a<T, T>
{
  final a<T> b;
  final AtomicBoolean c;
  
  private q(l<T> paraml, a<T> parama)
  {
    super(paraml);
    this.b = parama;
    this.c = new AtomicBoolean();
  }
  
  public static <T> l<T> a(l<T> paraml)
  {
    return a(paraml, 16);
  }
  
  public static <T> l<T> a(l<T> paraml, int paramInt)
  {
    b.a.e.b.b.a(paramInt, "capacityHint");
    return b.a.h.a.a(new q(paraml, new a(paraml, paramInt)));
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    b localb = new b(params, this.b);
    params.onSubscribe(localb);
    this.b.a(localb);
    if ((!this.c.get()) && (this.c.compareAndSet(false, true))) {
      this.b.a();
    }
    localb.replay();
  }
  
  static final class a<T>
    extends m
    implements s<T>
  {
    static final q.b[] d = new q.b[0];
    static final q.b[] e = new q.b[0];
    final l<? extends T> a;
    final g b;
    final AtomicReference<q.b<T>[]> c;
    volatile boolean f;
    boolean g;
    
    a(l<? extends T> paraml, int paramInt)
    {
      super();
      this.a = paraml;
      this.c = new AtomicReference(d);
      this.b = new g();
    }
    
    public void a()
    {
      this.a.subscribe(this);
      this.f = true;
    }
    
    public boolean a(q.b<T> paramb)
    {
      q.b[] arrayOfb1;
      q.b[] arrayOfb2;
      do
      {
        arrayOfb1 = (q.b[])this.c.get();
        if (arrayOfb1 == e) {
          return false;
        }
        int i = arrayOfb1.length;
        arrayOfb2 = new q.b[i + 1];
        System.arraycopy(arrayOfb1, 0, arrayOfb2, 0, i);
        arrayOfb2[i] = paramb;
      } while (!this.c.compareAndSet(arrayOfb1, arrayOfb2));
      return true;
    }
    
    public void b(q.b<T> paramb)
    {
      q.b[] arrayOfb2;
      q.b[] arrayOfb1;
      do
      {
        arrayOfb2 = (q.b[])this.c.get();
        int m = arrayOfb2.length;
        if (m == 0) {
          return;
        }
        int k = -1;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          if (arrayOfb2[i].equals(paramb))
          {
            j = i;
            break;
          }
          i += 1;
        }
        if (j < 0) {
          return;
        }
        if (m == 1)
        {
          arrayOfb1 = d;
        }
        else
        {
          arrayOfb1 = new q.b[m - 1];
          System.arraycopy(arrayOfb2, 0, arrayOfb1, 0, j);
          System.arraycopy(arrayOfb2, j + 1, arrayOfb1, j, m - j - 1);
        }
      } while (!this.c.compareAndSet(arrayOfb2, arrayOfb1));
    }
    
    public void onComplete()
    {
      if (!this.g)
      {
        this.g = true;
        a(n.complete());
        this.b.dispose();
        q.b[] arrayOfb = (q.b[])this.c.getAndSet(e);
        int j = arrayOfb.length;
        int i = 0;
        while (i < j)
        {
          arrayOfb[i].replay();
          i += 1;
        }
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.g)
      {
        this.g = true;
        a(n.error(paramThrowable));
        this.b.dispose();
        paramThrowable = (q.b[])this.c.getAndSet(e);
        int j = paramThrowable.length;
        int i = 0;
        while (i < j)
        {
          paramThrowable[i].replay();
          i += 1;
        }
      }
    }
    
    public void onNext(T paramT)
    {
      if (!this.g)
      {
        a(n.next(paramT));
        paramT = (q.b[])this.c.get();
        int j = paramT.length;
        int i = 0;
        while (i < j)
        {
          paramT[i].replay();
          i += 1;
        }
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.b.update(paramb);
    }
  }
  
  static final class b<T>
    extends AtomicInteger
    implements b.a.b.b
  {
    private static final long serialVersionUID = 7058506693698832024L;
    volatile boolean cancelled;
    final s<? super T> child;
    Object[] currentBuffer;
    int currentIndexInBuffer;
    int index;
    final q.a<T> state;
    
    b(s<? super T> params, q.a<T> parama)
    {
      this.child = params;
      this.state = parama;
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.state.b(this);
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void replay()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.child;
      int j = 1;
      int i;
      do
      {
        if (this.cancelled) {
          return;
        }
        int n = this.state.c();
        if (n != 0)
        {
          Object localObject2 = this.currentBuffer;
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = this.state.b();
            this.currentBuffer = ((Object[])localObject1);
          }
          int i1 = localObject1.length - 1;
          int k = this.index;
          i = this.currentIndexInBuffer;
          while (k < n)
          {
            if (this.cancelled) {
              return;
            }
            localObject2 = localObject1;
            int m = i;
            if (i == i1)
            {
              localObject2 = (Object[])localObject1[i1];
              m = 0;
            }
            if (n.accept(localObject2[m], locals)) {
              return;
            }
            i = m + 1;
            k += 1;
            localObject1 = localObject2;
          }
          if (this.cancelled) {
            return;
          }
          this.index = k;
          this.currentIndexInBuffer = i;
          this.currentBuffer = ((Object[])localObject1);
        }
        i = addAndGet(-j);
        j = i;
      } while (i != 0);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */