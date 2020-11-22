package b.a.e.e.d;

import b.a.d.g;
import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.e.j.j;
import b.a.e.j.n;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cq<T>
  extends b.a.f.a<T>
  implements b.a.b.b
{
  static final b e = new o();
  final q<T> a;
  final AtomicReference<j<T>> b;
  final b<T> c;
  final q<T> d;
  
  private cq(q<T> paramq1, q<T> paramq2, AtomicReference<j<T>> paramAtomicReference, b<T> paramb)
  {
    this.d = paramq1;
    this.a = paramq2;
    this.b = paramAtomicReference;
    this.c = paramb;
  }
  
  public static <T> b.a.f.a<T> a(b.a.f.a<T> parama, t paramt)
  {
    return b.a.h.a.a(new g(parama, parama.observeOn(paramt)));
  }
  
  public static <T> b.a.f.a<T> a(q<? extends T> paramq)
  {
    return a(paramq, e);
  }
  
  public static <T> b.a.f.a<T> a(q<T> paramq, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return a(paramq);
    }
    return a(paramq, new i(paramInt));
  }
  
  public static <T> b.a.f.a<T> a(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return a(paramq, paramLong, paramTimeUnit, paramt, Integer.MAX_VALUE);
  }
  
  public static <T> b.a.f.a<T> a(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, t paramt, int paramInt)
  {
    return a(paramq, new l(paramInt, paramLong, paramTimeUnit, paramt));
  }
  
  static <T> b.a.f.a<T> a(q<T> paramq, b<T> paramb)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return b.a.h.a.a(new cq(new k(localAtomicReference, paramb), paramq, localAtomicReference, paramb));
  }
  
  public static <U, R> l<R> a(Callable<? extends b.a.f.a<U>> paramCallable, h<? super l<U>, ? extends q<R>> paramh)
  {
    return b.a.h.a.a(new e(paramCallable, paramh));
  }
  
  public void a(g<? super b.a.b.b> paramg)
  {
    j localj2;
    j localj1;
    do
    {
      localj2 = (j)this.b.get();
      if (localj2 != null)
      {
        localj1 = localj2;
        if (!localj2.isDisposed()) {
          break;
        }
      }
      localj1 = new j(this.c.a());
    } while (!this.b.compareAndSet(localj2, localj1));
    int i;
    if ((!localj1.shouldConnect.get()) && (localj1.shouldConnect.compareAndSet(false, true))) {
      i = 1;
    } else {
      i = 0;
    }
    try
    {
      paramg.accept(localj1);
      if (i != 0) {
        this.a.subscribe(localj1);
      }
      return;
    }
    catch (Throwable paramg)
    {
      if (i != 0) {
        localj1.shouldConnect.compareAndSet(true, false);
      }
      b.a.c.b.b(paramg);
      throw j.a(paramg);
    }
  }
  
  public void dispose()
  {
    this.b.lazySet(null);
  }
  
  public boolean isDisposed()
  {
    b.a.b.b localb = (b.a.b.b)this.b.get();
    return (localb == null) || (localb.isDisposed());
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.d.subscribe(params);
  }
  
  static abstract class a<T>
    extends AtomicReference<cq.f>
    implements cq.h<T>
  {
    private static final long serialVersionUID = 2346567790059478686L;
    int size;
    cq.f tail;
    
    a()
    {
      cq.f localf = new cq.f(null);
      this.tail = localf;
      set(localf);
    }
    
    final void addLast(cq.f paramf)
    {
      this.tail.set(paramf);
      this.tail = paramf;
      this.size += 1;
    }
    
    final void collect(Collection<? super T> paramCollection)
    {
      cq.f localf = getHead();
      for (;;)
      {
        localf = (cq.f)localf.get();
        if (localf == null) {
          break;
        }
        Object localObject = leaveTransform(localf.value);
        if (n.isComplete(localObject)) {
          break;
        }
        if (n.isError(localObject)) {
          return;
        }
        paramCollection.add(n.getValue(localObject));
      }
    }
    
    public final void complete()
    {
      addLast(new cq.f(enterTransform(n.complete())));
      truncateFinal();
    }
    
    Object enterTransform(Object paramObject)
    {
      return paramObject;
    }
    
    public final void error(Throwable paramThrowable)
    {
      addLast(new cq.f(enterTransform(n.error(paramThrowable))));
      truncateFinal();
    }
    
    cq.f getHead()
    {
      return (cq.f)get();
    }
    
    boolean hasCompleted()
    {
      return (this.tail.value != null) && (n.isComplete(leaveTransform(this.tail.value)));
    }
    
    boolean hasError()
    {
      return (this.tail.value != null) && (n.isError(leaveTransform(this.tail.value)));
    }
    
    Object leaveTransform(Object paramObject)
    {
      return paramObject;
    }
    
    public final void next(T paramT)
    {
      addLast(new cq.f(enterTransform(n.next(paramT))));
      truncate();
    }
    
    final void removeFirst()
    {
      cq.f localf = (cq.f)((cq.f)get()).get();
      this.size -= 1;
      setFirst(localf);
    }
    
    final void removeSome(int paramInt)
    {
      cq.f localf = (cq.f)get();
      while (paramInt > 0)
      {
        localf = (cq.f)localf.get();
        paramInt -= 1;
        this.size -= 1;
      }
      setFirst(localf);
    }
    
    public final void replay(cq.d<T> paramd)
    {
      if (paramd.getAndIncrement() != 0) {
        return;
      }
      int i = 1;
      int j;
      do
      {
        cq.f localf2 = (cq.f)paramd.index();
        cq.f localf1 = localf2;
        if (localf2 == null)
        {
          localf1 = getHead();
          paramd.index = localf1;
        }
        for (;;)
        {
          if (paramd.isDisposed()) {
            return;
          }
          localf2 = (cq.f)localf1.get();
          if (localf2 == null) {
            break;
          }
          if (n.accept(leaveTransform(localf2.value), paramd.child))
          {
            paramd.index = null;
            return;
          }
          localf1 = localf2;
        }
        paramd.index = localf1;
        j = paramd.addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    final void setFirst(cq.f paramf)
    {
      set(paramf);
    }
    
    final void trimHead()
    {
      cq.f localf1 = (cq.f)get();
      if (localf1.value != null)
      {
        cq.f localf2 = new cq.f(null);
        localf2.lazySet(localf1.get());
        set(localf2);
      }
    }
    
    abstract void truncate();
    
    void truncateFinal()
    {
      trimHead();
    }
  }
  
  static abstract interface b<T>
  {
    public abstract cq.h<T> a();
  }
  
  static final class c<R>
    implements g<b.a.b.b>
  {
    private final em<R> a;
    
    c(em<R> paramem)
    {
      this.a = paramem;
    }
    
    public void a(b.a.b.b paramb)
    {
      this.a.setResource(paramb);
    }
  }
  
  static final class d<T>
    extends AtomicInteger
    implements b.a.b.b
  {
    private static final long serialVersionUID = 2728361546769921047L;
    volatile boolean cancelled;
    final s<? super T> child;
    Object index;
    final cq.j<T> parent;
    
    d(cq.j<T> paramj, s<? super T> params)
    {
      this.parent = paramj;
      this.child = params;
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.parent.remove(this);
      }
    }
    
    <U> U index()
    {
      return (U)this.index;
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
  }
  
  static final class e<R, U>
    extends l<R>
  {
    private final Callable<? extends b.a.f.a<U>> a;
    private final h<? super l<U>, ? extends q<R>> b;
    
    e(Callable<? extends b.a.f.a<U>> paramCallable, h<? super l<U>, ? extends q<R>> paramh)
    {
      this.a = paramCallable;
      this.b = paramh;
    }
    
    protected void subscribeActual(s<? super R> params)
    {
      try
      {
        b.a.f.a locala = (b.a.f.a)b.a.e.b.b.a(this.a.call(), "The connectableFactory returned a null ConnectableObservable");
        q localq = (q)b.a.e.b.b.a(this.b.apply(locala), "The selector returned a null ObservableSource");
        params = new em(params);
        localq.subscribe(params);
        locala.a(new cq.c(params));
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        e.error(localThrowable, params);
      }
    }
  }
  
  static final class f
    extends AtomicReference<f>
  {
    private static final long serialVersionUID = 245354315435971818L;
    final Object value;
    
    f(Object paramObject)
    {
      this.value = paramObject;
    }
  }
  
  static final class g<T>
    extends b.a.f.a<T>
  {
    private final b.a.f.a<T> a;
    private final l<T> b;
    
    g(b.a.f.a<T> parama, l<T> paraml)
    {
      this.a = parama;
      this.b = paraml;
    }
    
    public void a(g<? super b.a.b.b> paramg)
    {
      this.a.a(paramg);
    }
    
    protected void subscribeActual(s<? super T> params)
    {
      this.b.subscribe(params);
    }
  }
  
  static abstract interface h<T>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract void next(T paramT);
    
    public abstract void replay(cq.d<T> paramd);
  }
  
  static final class i<T>
    implements cq.b<T>
  {
    private final int a;
    
    i(int paramInt)
    {
      this.a = paramInt;
    }
    
    public cq.h<T> a()
    {
      return new cq.n(this.a);
    }
  }
  
  static final class j<T>
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, s<T>
  {
    static final cq.d[] EMPTY = new cq.d[0];
    static final cq.d[] TERMINATED = new cq.d[0];
    private static final long serialVersionUID = -533785617179540163L;
    final cq.h<T> buffer;
    boolean done;
    final AtomicReference<cq.d[]> observers;
    final AtomicBoolean shouldConnect;
    
    j(cq.h<T> paramh)
    {
      this.buffer = paramh;
      this.observers = new AtomicReference(EMPTY);
      this.shouldConnect = new AtomicBoolean();
    }
    
    boolean add(cq.d<T> paramd)
    {
      cq.d[] arrayOfd1;
      cq.d[] arrayOfd2;
      do
      {
        arrayOfd1 = (cq.d[])this.observers.get();
        if (arrayOfd1 == TERMINATED) {
          return false;
        }
        int i = arrayOfd1.length;
        arrayOfd2 = new cq.d[i + 1];
        System.arraycopy(arrayOfd1, 0, arrayOfd2, 0, i);
        arrayOfd2[i] = paramd;
      } while (!this.observers.compareAndSet(arrayOfd1, arrayOfd2));
      return true;
    }
    
    public void dispose()
    {
      this.observers.set(TERMINATED);
      d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return this.observers.get() == TERMINATED;
    }
    
    public void onComplete()
    {
      if (!this.done)
      {
        this.done = true;
        this.buffer.complete();
        replayFinal();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.done)
      {
        this.done = true;
        this.buffer.error(paramThrowable);
        replayFinal();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!this.done)
      {
        this.buffer.next(paramT);
        replay();
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.setOnce(this, paramb)) {
        replay();
      }
    }
    
    void remove(cq.d<T> paramd)
    {
      cq.d[] arrayOfd2;
      cq.d[] arrayOfd1;
      do
      {
        arrayOfd2 = (cq.d[])this.observers.get();
        int m = arrayOfd2.length;
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
          if (arrayOfd2[i].equals(paramd))
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
          arrayOfd1 = EMPTY;
        }
        else
        {
          arrayOfd1 = new cq.d[m - 1];
          System.arraycopy(arrayOfd2, 0, arrayOfd1, 0, j);
          System.arraycopy(arrayOfd2, j + 1, arrayOfd1, j, m - j - 1);
        }
      } while (!this.observers.compareAndSet(arrayOfd2, arrayOfd1));
    }
    
    void replay()
    {
      cq.d[] arrayOfd = (cq.d[])this.observers.get();
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        cq.d locald = arrayOfd[i];
        this.buffer.replay(locald);
        i += 1;
      }
    }
    
    void replayFinal()
    {
      cq.d[] arrayOfd = (cq.d[])this.observers.getAndSet(TERMINATED);
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        cq.d locald = arrayOfd[i];
        this.buffer.replay(locald);
        i += 1;
      }
    }
  }
  
  static final class k<T>
    implements q<T>
  {
    private final AtomicReference<cq.j<T>> a;
    private final cq.b<T> b;
    
    k(AtomicReference<cq.j<T>> paramAtomicReference, cq.b<T> paramb)
    {
      this.a = paramAtomicReference;
      this.b = paramb;
    }
    
    public void subscribe(s<? super T> params)
    {
      Object localObject1;
      do
      {
        localObject2 = (cq.j)this.a.get();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new cq.j(this.b.a());
      } while (!this.a.compareAndSet(null, localObject1));
      Object localObject2 = new cq.d((cq.j)localObject1, params);
      params.onSubscribe((b.a.b.b)localObject2);
      ((cq.j)localObject1).add((cq.d)localObject2);
      if (((cq.d)localObject2).isDisposed())
      {
        ((cq.j)localObject1).remove((cq.d)localObject2);
        return;
      }
      ((cq.j)localObject1).buffer.replay((cq.d)localObject2);
    }
  }
  
  static final class l<T>
    implements cq.b<T>
  {
    private final int a;
    private final long b;
    private final TimeUnit c;
    private final t d;
    
    l(int paramInt, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      this.a = paramInt;
      this.b = paramLong;
      this.c = paramTimeUnit;
      this.d = paramt;
    }
    
    public cq.h<T> a()
    {
      return new cq.m(this.a, this.b, this.c, this.d);
    }
  }
  
  static final class m<T>
    extends cq.a<T>
  {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAge;
    final t scheduler;
    final TimeUnit unit;
    
    m(int paramInt, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      this.scheduler = paramt;
      this.limit = paramInt;
      this.maxAge = paramLong;
      this.unit = paramTimeUnit;
    }
    
    Object enterTransform(Object paramObject)
    {
      return new b.a.i.b(paramObject, this.scheduler.a(this.unit), this.unit);
    }
    
    cq.f getHead()
    {
      long l1 = this.scheduler.a(this.unit);
      long l2 = this.maxAge;
      Object localObject2 = (cq.f)get();
      Object localObject3;
      for (Object localObject1 = (cq.f)((cq.f)localObject2).get();; localObject1 = localObject3)
      {
        if (localObject1 == null) {
          return (cq.f)localObject2;
        }
        localObject3 = (b.a.i.b)((cq.f)localObject1).value;
        if (n.isComplete(((b.a.i.b)localObject3).a())) {
          break;
        }
        if (n.isError(((b.a.i.b)localObject3).a())) {
          return (cq.f)localObject2;
        }
        if (((b.a.i.b)localObject3).b() > l1 - l2) {
          break;
        }
        localObject3 = (cq.f)((cq.f)localObject1).get();
        localObject2 = localObject1;
      }
      return (cq.f)localObject2;
    }
    
    Object leaveTransform(Object paramObject)
    {
      return ((b.a.i.b)paramObject).a();
    }
    
    void truncate()
    {
      long l1 = this.scheduler.a(this.unit);
      long l2 = this.maxAge;
      Object localObject2 = (cq.f)get();
      Object localObject1 = (cq.f)((cq.f)localObject2).get();
      int i = 0;
      while (localObject1 != null)
      {
        cq.f localf;
        if (this.size > this.limit)
        {
          i += 1;
          this.size -= 1;
          localf = (cq.f)((cq.f)localObject1).get();
          localObject2 = localObject1;
          localObject1 = localf;
        }
        else
        {
          if (((b.a.i.b)((cq.f)localObject1).value).b() > l1 - l2) {
            break;
          }
          i += 1;
          this.size -= 1;
          localf = (cq.f)((cq.f)localObject1).get();
          localObject2 = localObject1;
          localObject1 = localf;
        }
      }
      if (i != 0) {
        setFirst((cq.f)localObject2);
      }
    }
    
    void truncateFinal()
    {
      long l1 = this.scheduler.a(this.unit);
      long l2 = this.maxAge;
      Object localObject2 = (cq.f)get();
      Object localObject1 = (cq.f)((cq.f)localObject2).get();
      int i = 0;
      while ((localObject1 != null) && (this.size > 1) && (((b.a.i.b)((cq.f)localObject1).value).b() <= l1 - l2))
      {
        i += 1;
        this.size -= 1;
        cq.f localf = (cq.f)((cq.f)localObject1).get();
        localObject2 = localObject1;
        localObject1 = localf;
      }
      if (i != 0) {
        setFirst((cq.f)localObject2);
      }
    }
  }
  
  static final class n<T>
    extends cq.a<T>
  {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;
    
    n(int paramInt)
    {
      this.limit = paramInt;
    }
    
    void truncate()
    {
      if (this.size > this.limit) {
        removeFirst();
      }
    }
  }
  
  static final class o
    implements cq.b<Object>
  {
    public cq.h<Object> a()
    {
      return new cq.p(16);
    }
  }
  
  static final class p<T>
    extends ArrayList<Object>
    implements cq.h<T>
  {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;
    
    p(int paramInt)
    {
      super();
    }
    
    public void complete()
    {
      add(n.complete());
      this.size += 1;
    }
    
    public void error(Throwable paramThrowable)
    {
      add(n.error(paramThrowable));
      this.size += 1;
    }
    
    public void next(T paramT)
    {
      add(n.next(paramT));
      this.size += 1;
    }
    
    public void replay(cq.d<T> paramd)
    {
      if (paramd.getAndIncrement() != 0) {
        return;
      }
      s locals = paramd.child;
      int j = 1;
      int i;
      do
      {
        if (paramd.isDisposed()) {
          return;
        }
        int k = this.size;
        Integer localInteger = (Integer)paramd.index();
        if (localInteger != null) {
          i = localInteger.intValue();
        } else {
          i = 0;
        }
        while (i < k)
        {
          if (n.accept(get(i), locals)) {
            return;
          }
          if (paramd.isDisposed()) {
            return;
          }
          i += 1;
        }
        paramd.index = Integer.valueOf(i);
        i = paramd.addAndGet(-j);
        j = i;
      } while (i != 0);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */