package b.a.e.e.d;

import b.a.d.h;
import b.a.e.c.f;
import b.a.e.d.p;
import b.a.e.j.n;
import b.a.g.c;
import b.a.g.e;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ef<T, B, V>
  extends a<T, l<T>>
{
  final q<B> b;
  final h<? super B, ? extends q<V>> c;
  final int d;
  
  public ef(q<T> paramq, q<B> paramq1, h<? super B, ? extends q<V>> paramh, int paramInt)
  {
    super(paramq);
    this.b = paramq1;
    this.c = paramh;
    this.d = paramInt;
  }
  
  public void subscribeActual(s<? super l<T>> params)
  {
    this.a.subscribe(new c(new e(params), this.b, this.c, this.d));
  }
  
  static final class a<T, V>
    extends c<V>
  {
    final ef.c<T, ?, V> a;
    final b.a.j.d<T> b;
    boolean c;
    
    a(ef.c<T, ?, V> paramc, b.a.j.d<T> paramd)
    {
      this.a = paramc;
      this.b = paramd;
    }
    
    public void onComplete()
    {
      if (this.c) {
        return;
      }
      this.c = true;
      this.a.a(this);
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.c)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.c = true;
      this.a.a(paramThrowable);
    }
    
    public void onNext(V paramV)
    {
      dispose();
      onComplete();
    }
  }
  
  static final class b<T, B>
    extends c<B>
  {
    final ef.c<T, B, ?> a;
    
    b(ef.c<T, B, ?> paramc)
    {
      this.a = paramc;
    }
    
    public void onComplete()
    {
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.a(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      this.a.a(paramB);
    }
  }
  
  static final class c<T, B, V>
    extends p<T, Object, l<T>>
    implements b.a.b.b
  {
    final q<B> g;
    final h<? super B, ? extends q<V>> h;
    final int i;
    final b.a.b.a j;
    b.a.b.b k;
    final AtomicReference<b.a.b.b> l = new AtomicReference();
    final List<b.a.j.d<T>> m;
    final AtomicLong n = new AtomicLong();
    
    c(s<? super l<T>> params, q<B> paramq, h<? super B, ? extends q<V>> paramh, int paramInt)
    {
      super(new b.a.e.f.a());
      this.g = paramq;
      this.h = paramh;
      this.i = paramInt;
      this.j = new b.a.b.a();
      this.m = new ArrayList();
      this.n.lazySet(1L);
    }
    
    void a(ef.a<T, V> parama)
    {
      this.j.c(parama);
      this.b.offer(new ef.d(parama.b, null));
      if (c()) {
        g();
      }
    }
    
    public void a(s<? super l<T>> params, Object paramObject) {}
    
    void a(B paramB)
    {
      this.b.offer(new ef.d(null, paramB));
      if (c()) {
        g();
      }
    }
    
    void a(Throwable paramThrowable)
    {
      this.k.dispose();
      this.j.dispose();
      onError(paramThrowable);
    }
    
    public void dispose()
    {
      this.c = true;
    }
    
    void f()
    {
      this.j.dispose();
      b.a.e.a.d.dispose(this.l);
    }
    
    void g()
    {
      Object localObject1 = (b.a.e.f.a)this.b;
      Object localObject2 = this.a;
      List localList = this.m;
      int i1 = 1;
      for (;;)
      {
        boolean bool = this.d;
        Object localObject3 = ((b.a.e.f.a)localObject1).poll();
        int i2;
        if (localObject3 == null) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if ((bool) && (i2 != 0))
        {
          f();
          localObject1 = this.e;
          if (localObject1 != null)
          {
            localObject2 = localList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((b.a.j.d)((Iterator)localObject2).next()).onError((Throwable)localObject1);
            }
          }
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((b.a.j.d)((Iterator)localObject1).next()).onComplete();
          }
          localList.clear();
          return;
        }
        if (i2 != 0)
        {
          i2 = a(-i1);
          i1 = i2;
          if (i2 != 0) {}
        }
        else
        {
          Object localObject4;
          if ((localObject3 instanceof ef.d))
          {
            localObject4 = (ef.d)localObject3;
            if (((ef.d)localObject4).a != null)
            {
              if (localList.remove(((ef.d)localObject4).a))
              {
                ((ef.d)localObject4).a.onComplete();
                if (this.n.decrementAndGet() == 0L) {
                  f();
                }
              }
            }
            else if (!this.c)
            {
              localObject3 = b.a.j.d.a(this.i);
              localList.add(localObject3);
              ((s)localObject2).onNext(localObject3);
              try
              {
                localObject4 = (q)b.a.e.b.b.a(this.h.apply(((ef.d)localObject4).b), "The ObservableSource supplied is null");
                localObject3 = new ef.a(this, (b.a.j.d)localObject3);
                if (!this.j.a((b.a.b.b)localObject3)) {
                  continue;
                }
                this.n.getAndIncrement();
                ((q)localObject4).subscribe((s)localObject3);
              }
              catch (Throwable localThrowable)
              {
                b.a.c.b.b(localThrowable);
                this.c = true;
                ((s)localObject2).onError(localThrowable);
              }
            }
          }
          else
          {
            localObject4 = localList.iterator();
            while (((Iterator)localObject4).hasNext()) {
              ((b.a.j.d)((Iterator)localObject4).next()).onNext(n.getValue(localThrowable));
            }
          }
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public void onComplete()
    {
      if (this.d) {
        return;
      }
      this.d = true;
      if (c()) {
        g();
      }
      if (this.n.decrementAndGet() == 0L) {
        this.j.dispose();
      }
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.d)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.e = paramThrowable;
      this.d = true;
      if (c()) {
        g();
      }
      if (this.n.decrementAndGet() == 0L) {
        this.j.dispose();
      }
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (d())
      {
        Iterator localIterator = this.m.iterator();
        while (localIterator.hasNext()) {
          ((b.a.j.d)localIterator.next()).onNext(paramT);
        }
        if (a(-1) != 0) {}
      }
      else
      {
        this.b.offer(n.next(paramT));
        if (!c()) {
          return;
        }
      }
      g();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (b.a.e.a.d.validate(this.k, paramb))
      {
        this.k = paramb;
        this.a.onSubscribe(this);
        if (this.c) {
          return;
        }
        paramb = new ef.b(this);
        if (this.l.compareAndSet(null, paramb))
        {
          this.n.getAndIncrement();
          this.g.subscribe(paramb);
        }
      }
    }
  }
  
  static final class d<T, B>
  {
    final b.a.j.d<T> a;
    final B b;
    
    d(b.a.j.d<T> paramd, B paramB)
    {
      this.a = paramd;
      this.b = paramB;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */