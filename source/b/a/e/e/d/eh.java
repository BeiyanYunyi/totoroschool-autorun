package b.a.e.e.d;

import b.a.b.b;
import b.a.e.c.f;
import b.a.e.d.p;
import b.a.e.j.n;
import b.a.g.e;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class eh<T>
  extends a<T, l<T>>
{
  final long b;
  final long c;
  final TimeUnit d;
  final t e;
  final long f;
  final int g;
  final boolean h;
  
  public eh(q<T> paramq, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt, long paramLong3, int paramInt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramTimeUnit;
    this.e = paramt;
    this.f = paramLong3;
    this.g = paramInt;
    this.h = paramBoolean;
  }
  
  public void subscribeActual(s<? super l<T>> params)
  {
    params = new e(params);
    if (this.b == this.c)
    {
      if (this.f == Long.MAX_VALUE)
      {
        this.a.subscribe(new b(params, this.b, this.d, this.e, this.g));
        return;
      }
      this.a.subscribe(new a(params, this.b, this.d, this.e, this.g, this.f, this.h));
      return;
    }
    this.a.subscribe(new c(params, this.b, this.c, this.d, this.e.a(), this.g));
  }
  
  static final class a<T>
    extends p<T, Object, l<T>>
    implements b
  {
    final long g;
    final TimeUnit h;
    final t i;
    final int j;
    final boolean k;
    final long l;
    final t.c m;
    long n;
    long o;
    b p;
    b.a.j.d<T> q;
    volatile boolean r;
    final AtomicReference<b> s = new AtomicReference();
    
    a(s<? super l<T>> params, long paramLong1, TimeUnit paramTimeUnit, t paramt, int paramInt, long paramLong2, boolean paramBoolean)
    {
      super(new b.a.e.f.a());
      this.g = paramLong1;
      this.h = paramTimeUnit;
      this.i = paramt;
      this.j = paramInt;
      this.l = paramLong2;
      this.k = paramBoolean;
      if (paramBoolean)
      {
        this.m = paramt.a();
        return;
      }
      this.m = null;
    }
    
    public void dispose()
    {
      this.c = true;
    }
    
    void f()
    {
      b.a.e.a.d.dispose(this.s);
      t.c localc = this.m;
      if (localc != null) {
        localc.dispose();
      }
    }
    
    void g()
    {
      b.a.e.f.a locala = (b.a.e.f.a)this.b;
      s locals = this.a;
      Object localObject1 = this.q;
      int i1 = 1;
      for (;;)
      {
        if (this.r)
        {
          this.p.dispose();
          locala.clear();
          f();
          return;
        }
        boolean bool1 = this.d;
        Object localObject2 = locala.poll();
        int i2;
        if (localObject2 == null) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        boolean bool2 = localObject2 instanceof a;
        if ((bool1) && ((i2 != 0) || (bool2)))
        {
          this.q = null;
          locala.clear();
          f();
          localObject2 = this.e;
          if (localObject2 != null)
          {
            ((b.a.j.d)localObject1).onError((Throwable)localObject2);
            return;
          }
          ((b.a.j.d)localObject1).onComplete();
          return;
        }
        if (i2 != 0)
        {
          i2 = a(-i1);
          i1 = i2;
          if (i2 != 0) {}
        }
        else if (bool2)
        {
          localObject2 = (a)localObject2;
          if ((this.k) || (this.o == ((a)localObject2).a))
          {
            ((b.a.j.d)localObject1).onComplete();
            this.n = 0L;
            localObject1 = b.a.j.d.a(this.j);
            this.q = ((b.a.j.d)localObject1);
            locals.onNext(localObject1);
          }
        }
        else
        {
          ((b.a.j.d)localObject1).onNext(n.getValue(localObject2));
          long l1 = this.n + 1L;
          if (l1 >= this.l)
          {
            this.o += 1L;
            this.n = 0L;
            ((b.a.j.d)localObject1).onComplete();
            localObject2 = b.a.j.d.a(this.j);
            this.q = ((b.a.j.d)localObject2);
            this.a.onNext(localObject2);
            localObject1 = localObject2;
            if (this.k)
            {
              b localb1 = (b)this.s.get();
              localb1.dispose();
              b localb2 = this.m.a(new a(this.o, this), this.g, this.g, this.h);
              localObject1 = localObject2;
              if (!this.s.compareAndSet(localb1, localb2))
              {
                localb2.dispose();
                localObject1 = localObject2;
              }
            }
          }
          else
          {
            this.n = l1;
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
      this.d = true;
      if (c()) {
        g();
      }
      this.a.onComplete();
      f();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.e = paramThrowable;
      this.d = true;
      if (c()) {
        g();
      }
      this.a.onError(paramThrowable);
      f();
    }
    
    public void onNext(T paramT)
    {
      if (this.r) {
        return;
      }
      if (d())
      {
        b.a.j.d locald = this.q;
        locald.onNext(paramT);
        long l1 = this.n + 1L;
        if (l1 >= this.l)
        {
          this.o += 1L;
          this.n = 0L;
          locald.onComplete();
          paramT = b.a.j.d.a(this.j);
          this.q = paramT;
          this.a.onNext(paramT);
          if (this.k)
          {
            ((b)this.s.get()).dispose();
            paramT = this.m.a(new a(this.o, this), this.g, this.g, this.h);
            b.a.e.a.d.replace(this.s, paramT);
          }
        }
        else
        {
          this.n = l1;
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
    
    public void onSubscribe(b paramb)
    {
      if (b.a.e.a.d.validate(this.p, paramb))
      {
        this.p = paramb;
        paramb = this.a;
        paramb.onSubscribe(this);
        if (this.c) {
          return;
        }
        b.a.j.d locald = b.a.j.d.a(this.j);
        this.q = locald;
        paramb.onNext(locald);
        paramb = new a(this.o, this);
        if (this.k) {
          paramb = this.m.a(paramb, this.g, this.g, this.h);
        } else {
          paramb = this.i.a(paramb, this.g, this.g, this.h);
        }
        b.a.e.a.d.replace(this.s, paramb);
      }
    }
    
    static final class a
      implements Runnable
    {
      final long a;
      final eh.a<?> b;
      
      a(long paramLong, eh.a<?> parama)
      {
        this.a = paramLong;
        this.b = parama;
      }
      
      public void run()
      {
        eh.a locala = this.b;
        if (!eh.a.a(locala))
        {
          eh.a.b(locala).offer(this);
        }
        else
        {
          locala.r = true;
          locala.f();
        }
        if (locala.c()) {
          locala.g();
        }
      }
    }
  }
  
  static final class b<T>
    extends p<T, Object, l<T>>
    implements b, s<T>, Runnable
  {
    static final Object n = new Object();
    final long g;
    final TimeUnit h;
    final t i;
    final int j;
    b k;
    b.a.j.d<T> l;
    final AtomicReference<b> m = new AtomicReference();
    volatile boolean o;
    
    b(s<? super l<T>> params, long paramLong, TimeUnit paramTimeUnit, t paramt, int paramInt)
    {
      super(new b.a.e.f.a());
      this.g = paramLong;
      this.h = paramTimeUnit;
      this.i = paramt;
      this.j = paramInt;
    }
    
    public void dispose()
    {
      this.c = true;
    }
    
    void f()
    {
      b.a.e.a.d.dispose(this.m);
    }
    
    void g()
    {
      Object localObject1 = (b.a.e.f.a)this.b;
      s locals = this.a;
      b.a.j.d locald = this.l;
      int i1 = 1;
      for (;;)
      {
        boolean bool1 = this.o;
        boolean bool2 = this.d;
        Object localObject2 = ((b.a.e.f.a)localObject1).poll();
        if ((bool2) && ((localObject2 == null) || (localObject2 == n)))
        {
          this.l = null;
          ((b.a.e.f.a)localObject1).clear();
          f();
          localObject1 = this.e;
          if (localObject1 != null)
          {
            locald.onError((Throwable)localObject1);
            return;
          }
          locald.onComplete();
          return;
        }
        if (localObject2 == null)
        {
          int i2 = a(-i1);
          i1 = i2;
          if (i2 != 0) {}
        }
        else if (localObject2 == n)
        {
          locald.onComplete();
          if (!bool1)
          {
            locald = b.a.j.d.a(this.j);
            this.l = locald;
            locals.onNext(locald);
          }
          else
          {
            this.k.dispose();
          }
        }
        else
        {
          locald.onNext(n.getValue(localObject2));
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public void onComplete()
    {
      this.d = true;
      if (c()) {
        g();
      }
      f();
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.e = paramThrowable;
      this.d = true;
      if (c()) {
        g();
      }
      f();
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.o) {
        return;
      }
      if (d())
      {
        this.l.onNext(paramT);
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
    
    public void onSubscribe(b paramb)
    {
      if (b.a.e.a.d.validate(this.k, paramb))
      {
        this.k = paramb;
        this.l = b.a.j.d.a(this.j);
        paramb = this.a;
        paramb.onSubscribe(this);
        paramb.onNext(this.l);
        if (!this.c)
        {
          paramb = this.i.a(this, this.g, this.g, this.h);
          b.a.e.a.d.replace(this.m, paramb);
        }
      }
    }
    
    public void run()
    {
      if (this.c)
      {
        this.o = true;
        f();
      }
      this.b.offer(n);
      if (c()) {
        g();
      }
    }
  }
  
  static final class c<T>
    extends p<T, Object, l<T>>
    implements b, Runnable
  {
    final long g;
    final long h;
    final TimeUnit i;
    final t.c j;
    final int k;
    final List<b.a.j.d<T>> l;
    b m;
    volatile boolean n;
    
    c(s<? super l<T>> params, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t.c paramc, int paramInt)
    {
      super(new b.a.e.f.a());
      this.g = paramLong1;
      this.h = paramLong2;
      this.i = paramTimeUnit;
      this.j = paramc;
      this.k = paramInt;
      this.l = new LinkedList();
    }
    
    void a(b.a.j.d<T> paramd)
    {
      this.b.offer(new b(paramd, false));
      if (c()) {
        g();
      }
    }
    
    public void dispose()
    {
      this.c = true;
    }
    
    void f()
    {
      this.j.dispose();
    }
    
    void g()
    {
      Object localObject1 = (b.a.e.f.a)this.b;
      Object localObject2 = this.a;
      List localList = this.l;
      int i1 = 1;
      for (;;)
      {
        if (this.n)
        {
          this.m.dispose();
          f();
          ((b.a.e.f.a)localObject1).clear();
          localList.clear();
          return;
        }
        boolean bool1 = this.d;
        Object localObject3 = ((b.a.e.f.a)localObject1).poll();
        int i2;
        if (localObject3 == null) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        boolean bool2 = localObject3 instanceof b;
        if ((bool1) && ((i2 != 0) || (bool2)))
        {
          ((b.a.e.f.a)localObject1).clear();
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
          f();
          localList.clear();
          return;
        }
        if (i2 != 0)
        {
          i2 = a(-i1);
          i1 = i2;
          if (i2 != 0) {}
        }
        else if (bool2)
        {
          localObject3 = (b)localObject3;
          if (((b)localObject3).b)
          {
            if (!this.c)
            {
              localObject3 = b.a.j.d.a(this.k);
              localList.add(localObject3);
              ((s)localObject2).onNext(localObject3);
              this.j.a(new a((b.a.j.d)localObject3), this.g, this.i);
            }
          }
          else
          {
            localList.remove(((b)localObject3).a);
            ((b)localObject3).a.onComplete();
            if ((localList.isEmpty()) && (this.c)) {
              this.n = true;
            }
          }
        }
        else
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext()) {
            ((b.a.j.d)localIterator.next()).onNext(localObject3);
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
      this.d = true;
      if (c()) {
        g();
      }
      this.a.onComplete();
      f();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.e = paramThrowable;
      this.d = true;
      if (c()) {
        g();
      }
      this.a.onError(paramThrowable);
      f();
    }
    
    public void onNext(T paramT)
    {
      if (d())
      {
        Iterator localIterator = this.l.iterator();
        while (localIterator.hasNext()) {
          ((b.a.j.d)localIterator.next()).onNext(paramT);
        }
        if (a(-1) != 0) {}
      }
      else
      {
        this.b.offer(paramT);
        if (!c()) {
          return;
        }
      }
      g();
    }
    
    public void onSubscribe(b paramb)
    {
      if (b.a.e.a.d.validate(this.m, paramb))
      {
        this.m = paramb;
        this.a.onSubscribe(this);
        if (this.c) {
          return;
        }
        paramb = b.a.j.d.a(this.k);
        this.l.add(paramb);
        this.a.onNext(paramb);
        this.j.a(new a(paramb), this.g, this.i);
        this.j.a(this, this.h, this.h, this.i);
      }
    }
    
    public void run()
    {
      b localb = new b(b.a.j.d.a(this.k), true);
      if (!this.c) {
        this.b.offer(localb);
      }
      if (c()) {
        g();
      }
    }
    
    final class a
      implements Runnable
    {
      private final b.a.j.d<T> b;
      
      a()
      {
        b.a.j.d locald;
        this.b = locald;
      }
      
      public void run()
      {
        eh.c.this.a(this.b);
      }
    }
    
    static final class b<T>
    {
      final b.a.j.d<T> a;
      final boolean b;
      
      b(b.a.j.d<T> paramd, boolean paramBoolean)
      {
        this.a = paramd;
        this.b = paramBoolean;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */