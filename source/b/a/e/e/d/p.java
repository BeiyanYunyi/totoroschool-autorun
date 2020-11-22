package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.c.f;
import b.a.e.j.r;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class p<T, U extends Collection<? super T>>
  extends a<T, U>
{
  final long b;
  final long c;
  final TimeUnit d;
  final t e;
  final Callable<U> f;
  final int g;
  final boolean h;
  
  public p(q<T> paramq, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt, Callable<U> paramCallable, int paramInt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramTimeUnit;
    this.e = paramt;
    this.f = paramCallable;
    this.g = paramInt;
    this.h = paramBoolean;
  }
  
  protected void subscribeActual(s<? super U> params)
  {
    if ((this.b == this.c) && (this.g == Integer.MAX_VALUE))
    {
      this.a.subscribe(new b(new b.a.g.e(params), this.f, this.b, this.d, this.e));
      return;
    }
    t.c localc = this.e.a();
    if (this.b == this.c)
    {
      this.a.subscribe(new a(new b.a.g.e(params), this.f, this.b, this.d, this.g, this.h, localc));
      return;
    }
    this.a.subscribe(new c(new b.a.g.e(params), this.f, this.b, this.c, this.d, localc));
  }
  
  static final class a<T, U extends Collection<? super T>>
    extends b.a.e.d.p<T, U, U>
    implements b.a.b.b, Runnable
  {
    final Callable<U> g;
    final long h;
    final TimeUnit i;
    final int j;
    final boolean k;
    final t.c l;
    U m;
    b.a.b.b n;
    b.a.b.b o;
    long p;
    long q;
    
    a(s<? super U> params, Callable<U> paramCallable, long paramLong, TimeUnit paramTimeUnit, int paramInt, boolean paramBoolean, t.c paramc)
    {
      super(new b.a.e.f.a());
      this.g = paramCallable;
      this.h = paramLong;
      this.i = paramTimeUnit;
      this.j = paramInt;
      this.k = paramBoolean;
      this.l = paramc;
    }
    
    public void a(s<? super U> params, U paramU)
    {
      params.onNext(paramU);
    }
    
    public void dispose()
    {
      if (!this.c)
      {
        this.c = true;
        this.o.dispose();
        this.l.dispose();
        try
        {
          this.m = null;
          return;
        }
        finally {}
      }
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public void onComplete()
    {
      this.l.dispose();
      try
      {
        Collection localCollection = this.m;
        this.m = null;
        this.b.offer(localCollection);
        this.d = true;
        if (c()) {
          r.a(this.b, this.a, false, this, this);
        }
        return;
      }
      finally {}
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        this.m = null;
        this.a.onError(paramThrowable);
        this.l.dispose();
        return;
      }
      finally {}
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 84	b/a/e/e/d/p$a:m	Ljava/util/Collection;
      //   6: astore_2
      //   7: aload_2
      //   8: ifnonnull +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_2
      //   15: aload_1
      //   16: invokeinterface 119 2 0
      //   21: pop
      //   22: aload_2
      //   23: invokeinterface 123 1 0
      //   28: aload_0
      //   29: getfield 51	b/a/e/e/d/p$a:j	I
      //   32: if_icmpge +6 -> 38
      //   35: aload_0
      //   36: monitorexit
      //   37: return
      //   38: aload_0
      //   39: aconst_null
      //   40: putfield 84	b/a/e/e/d/p$a:m	Ljava/util/Collection;
      //   43: aload_0
      //   44: aload_0
      //   45: getfield 125	b/a/e/e/d/p$a:p	J
      //   48: lconst_1
      //   49: ladd
      //   50: putfield 125	b/a/e/e/d/p$a:p	J
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_0
      //   56: getfield 53	b/a/e/e/d/p$a:k	Z
      //   59: ifeq +12 -> 71
      //   62: aload_0
      //   63: getfield 127	b/a/e/e/d/p$a:n	Lb/a/b/b;
      //   66: invokeinterface 79 1 0
      //   71: aload_0
      //   72: aload_2
      //   73: iconst_0
      //   74: aload_0
      //   75: invokevirtual 130	b/a/e/e/d/p$a:b	(Ljava/lang/Object;ZLb/a/b/b;)V
      //   78: aload_0
      //   79: getfield 45	b/a/e/e/d/p$a:g	Ljava/util/concurrent/Callable;
      //   82: invokeinterface 136 1 0
      //   87: ldc -118
      //   89: invokestatic 143	b/a/e/b/b:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   92: checkcast 61	java/util/Collection
      //   95: astore_1
      //   96: aload_0
      //   97: monitorenter
      //   98: aload_0
      //   99: aload_1
      //   100: putfield 84	b/a/e/e/d/p$a:m	Ljava/util/Collection;
      //   103: aload_0
      //   104: aload_0
      //   105: getfield 145	b/a/e/e/d/p$a:q	J
      //   108: lconst_1
      //   109: ladd
      //   110: putfield 145	b/a/e/e/d/p$a:q	J
      //   113: aload_0
      //   114: monitorexit
      //   115: aload_0
      //   116: getfield 53	b/a/e/e/d/p$a:k	Z
      //   119: ifeq +27 -> 146
      //   122: aload_0
      //   123: aload_0
      //   124: getfield 55	b/a/e/e/d/p$a:l	Lb/a/t$c;
      //   127: aload_0
      //   128: aload_0
      //   129: getfield 47	b/a/e/e/d/p$a:h	J
      //   132: aload_0
      //   133: getfield 47	b/a/e/e/d/p$a:h	J
      //   136: aload_0
      //   137: getfield 49	b/a/e/e/d/p$a:i	Ljava/util/concurrent/TimeUnit;
      //   140: invokevirtual 148	b/a/t$c:a	(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Lb/a/b/b;
      //   143: putfield 127	b/a/e/e/d/p$a:n	Lb/a/b/b;
      //   146: return
      //   147: astore_1
      //   148: aload_0
      //   149: monitorexit
      //   150: aload_1
      //   151: athrow
      //   152: astore_1
      //   153: aload_1
      //   154: invokestatic 152	b/a/c/b:b	(Ljava/lang/Throwable;)V
      //   157: aload_0
      //   158: getfield 105	b/a/e/e/d/p$a:a	Lb/a/s;
      //   161: aload_1
      //   162: invokeinterface 114 2 0
      //   167: aload_0
      //   168: invokevirtual 153	b/a/e/e/d/p$a:dispose	()V
      //   171: return
      //   172: astore_1
      //   173: aload_0
      //   174: monitorexit
      //   175: aload_1
      //   176: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	177	0	this	a
      //   0	177	1	paramT	T
      //   6	67	2	localCollection	Collection
      // Exception table:
      //   from	to	target	type
      //   98	115	147	finally
      //   148	150	147	finally
      //   78	96	152	java/lang/Throwable
      //   2	7	172	finally
      //   11	13	172	finally
      //   14	37	172	finally
      //   38	55	172	finally
      //   173	175	172	finally
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.o, paramb))
      {
        this.o = paramb;
        try
        {
          Collection localCollection = (Collection)b.a.e.b.b.a(this.g.call(), "The buffer supplied is null");
          this.m = localCollection;
          this.a.onSubscribe(this);
          this.n = this.l.a(this, this.h, this.h, this.i);
          return;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          paramb.dispose();
          b.a.e.a.e.error(localThrowable, this.a);
          this.l.dispose();
          return;
        }
      }
    }
    
    public void run()
    {
      try
      {
        Collection localCollection1 = (Collection)b.a.e.b.b.a(this.g.call(), "The bufferSupplier returned a null buffer");
        try
        {
          Collection localCollection2 = this.m;
          if ((localCollection2 != null) && (this.p == this.q))
          {
            this.m = localCollection1;
            b(localCollection2, false, this);
            return;
          }
          return;
        }
        finally {}
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        dispose();
        this.a.onError(localThrowable);
      }
    }
  }
  
  static final class b<T, U extends Collection<? super T>>
    extends b.a.e.d.p<T, U, U>
    implements b.a.b.b, Runnable
  {
    final Callable<U> g;
    final long h;
    final TimeUnit i;
    final t j;
    b.a.b.b k;
    U l;
    final AtomicReference<b.a.b.b> m = new AtomicReference();
    
    b(s<? super U> params, Callable<U> paramCallable, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      super(new b.a.e.f.a());
      this.g = paramCallable;
      this.h = paramLong;
      this.i = paramTimeUnit;
      this.j = paramt;
    }
    
    public void a(s<? super U> params, U paramU)
    {
      this.a.onNext(paramU);
    }
    
    public void dispose()
    {
      d.dispose(this.m);
      this.k.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.m.get() == d.DISPOSED;
    }
    
    public void onComplete()
    {
      try
      {
        Collection localCollection = this.l;
        this.l = null;
        if (localCollection != null)
        {
          this.b.offer(localCollection);
          this.d = true;
          if (c()) {
            r.a(this.b, this.a, false, null, this);
          }
        }
        d.dispose(this.m);
        return;
      }
      finally {}
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        this.l = null;
        this.a.onError(paramThrowable);
        d.dispose(this.m);
        return;
      }
      finally {}
    }
    
    public void onNext(T paramT)
    {
      try
      {
        Collection localCollection = this.l;
        if (localCollection == null) {
          return;
        }
        localCollection.add(paramT);
        return;
      }
      finally {}
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.k, paramb))
      {
        this.k = paramb;
        try
        {
          paramb = (Collection)b.a.e.b.b.a(this.g.call(), "The buffer supplied is null");
          this.l = paramb;
          this.a.onSubscribe(this);
          if (!this.c)
          {
            paramb = this.j.a(this, this.h, this.h, this.i);
            if (!this.m.compareAndSet(null, paramb))
            {
              paramb.dispose();
              return;
            }
          }
        }
        catch (Throwable paramb)
        {
          b.a.c.b.b(paramb);
          dispose();
          b.a.e.a.e.error(paramb, this.a);
          return;
        }
      }
    }
    
    public void run()
    {
      try
      {
        Collection localCollection1 = (Collection)b.a.e.b.b.a(this.g.call(), "The bufferSupplier returned a null buffer");
        try
        {
          Collection localCollection2 = this.l;
          if (localCollection2 != null) {
            this.l = localCollection1;
          }
          if (localCollection2 == null)
          {
            d.dispose(this.m);
            return;
          }
          a(localCollection2, false, this);
          return;
        }
        finally {}
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.a.onError(localThrowable);
        dispose();
      }
    }
  }
  
  static final class c<T, U extends Collection<? super T>>
    extends b.a.e.d.p<T, U, U>
    implements b.a.b.b, Runnable
  {
    final Callable<U> g;
    final long h;
    final long i;
    final TimeUnit j;
    final t.c k;
    final List<U> l;
    b.a.b.b m;
    
    c(s<? super U> params, Callable<U> paramCallable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t.c paramc)
    {
      super(new b.a.e.f.a());
      this.g = paramCallable;
      this.h = paramLong1;
      this.i = paramLong2;
      this.j = paramTimeUnit;
      this.k = paramc;
      this.l = new LinkedList();
    }
    
    public void a(s<? super U> params, U paramU)
    {
      params.onNext(paramU);
    }
    
    public void dispose()
    {
      if (!this.c)
      {
        this.c = true;
        f();
        this.m.dispose();
        this.k.dispose();
      }
    }
    
    void f()
    {
      try
      {
        this.l.clear();
        return;
      }
      finally {}
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public void onComplete()
    {
      try
      {
        Object localObject1 = new ArrayList(this.l);
        this.l.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Collection localCollection = (Collection)((Iterator)localObject1).next();
          this.b.offer(localCollection);
        }
        this.d = true;
        if (c()) {
          r.a(this.b, this.a, false, this.k, this);
        }
        return;
      }
      finally {}
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.d = true;
      f();
      this.a.onError(paramThrowable);
      this.k.dispose();
    }
    
    public void onNext(T paramT)
    {
      try
      {
        Iterator localIterator = this.l.iterator();
        while (localIterator.hasNext()) {
          ((Collection)localIterator.next()).add(paramT);
        }
        return;
      }
      finally {}
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.m, paramb))
      {
        this.m = paramb;
        try
        {
          Collection localCollection = (Collection)b.a.e.b.b.a(this.g.call(), "The buffer supplied is null");
          this.l.add(localCollection);
          this.a.onSubscribe(this);
          this.k.a(this, this.i, this.i, this.j);
          this.k.a(new b(localCollection), this.h, this.j);
          return;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          paramb.dispose();
          b.a.e.a.e.error(localThrowable, this.a);
          this.k.dispose();
          return;
        }
      }
    }
    
    public void run()
    {
      if (this.c) {
        return;
      }
      try
      {
        Collection localCollection = (Collection)b.a.e.b.b.a(this.g.call(), "The bufferSupplier returned a null buffer");
        try
        {
          if (this.c) {
            return;
          }
          this.l.add(localCollection);
          this.k.a(new a(localCollection), this.h, this.j);
          return;
        }
        finally {}
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.a.onError(localThrowable);
        dispose();
      }
    }
    
    final class a
      implements Runnable
    {
      private final U b;
      
      a()
      {
        Collection localCollection;
        this.b = localCollection;
      }
      
      public void run()
      {
        synchronized (p.c.this)
        {
          p.c.this.l.remove(this.b);
          p.c.a(p.c.this, this.b, false, p.c.this.k);
          return;
        }
      }
    }
    
    final class b
      implements Runnable
    {
      private final U b;
      
      b()
      {
        Collection localCollection;
        this.b = localCollection;
      }
      
      public void run()
      {
        synchronized (p.c.this)
        {
          p.c.this.l.remove(this.b);
          p.c.b(p.c.this, this.b, false, p.c.this.k);
          return;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */