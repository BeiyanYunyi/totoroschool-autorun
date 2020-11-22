package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.e.f.c;
import b.a.q;
import b.a.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class bi<T, K, V>
  extends a<T, b.a.f.b<K, V>>
{
  final h<? super T, ? extends K> b;
  final h<? super T, ? extends V> c;
  final int d;
  final boolean e;
  
  public bi(q<T> paramq, h<? super T, ? extends K> paramh, h<? super T, ? extends V> paramh1, int paramInt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramh;
    this.c = paramh1;
    this.d = paramInt;
    this.e = paramBoolean;
  }
  
  public void subscribeActual(s<? super b.a.f.b<K, V>> params)
  {
    this.a.subscribe(new a(params, this.b, this.c, this.d, this.e));
  }
  
  public static final class a<T, K, V>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final s<? super b.a.f.b<K, V>> actual;
    final int bufferSize;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    final Map<Object, bi.b<K, V>> groups;
    final h<? super T, ? extends K> keySelector;
    b.a.b.b s;
    final h<? super T, ? extends V> valueSelector;
    
    public a(s<? super b.a.f.b<K, V>> params, h<? super T, ? extends K> paramh, h<? super T, ? extends V> paramh1, int paramInt, boolean paramBoolean)
    {
      this.actual = params;
      this.keySelector = paramh;
      this.valueSelector = paramh1;
      this.bufferSize = paramInt;
      this.delayError = paramBoolean;
      this.groups = new ConcurrentHashMap();
      lazySet(1);
    }
    
    public void cancel(K paramK)
    {
      if (paramK == null) {
        paramK = NULL_KEY;
      }
      this.groups.remove(paramK);
      if (decrementAndGet() == 0) {
        this.s.dispose();
      }
    }
    
    public void dispose()
    {
      if ((this.cancelled.compareAndSet(false, true)) && (decrementAndGet() == 0)) {
        this.s.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled.get();
    }
    
    public void onComplete()
    {
      Object localObject = new ArrayList(this.groups.values());
      this.groups.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bi.b)((Iterator)localObject).next()).a();
      }
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      Object localObject = new ArrayList(this.groups.values());
      this.groups.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bi.b)((Iterator)localObject).next()).a(paramThrowable);
      }
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      try
      {
        Object localObject2 = this.keySelector.apply(paramT);
        Object localObject1;
        if (localObject2 != null) {
          localObject1 = localObject2;
        } else {
          localObject1 = NULL_KEY;
        }
        bi.b localb2 = (bi.b)this.groups.get(localObject1);
        bi.b localb1 = localb2;
        if (localb2 == null)
        {
          if (this.cancelled.get()) {
            return;
          }
          localb1 = bi.b.a(localObject2, this.bufferSize, this, this.delayError);
          this.groups.put(localObject1, localb1);
          getAndIncrement();
          this.actual.onNext(localb1);
        }
        try
        {
          paramT = b.a.e.b.b.a(this.valueSelector.apply(paramT), "The value supplied is null");
          localb1.a(paramT);
          return;
        }
        catch (Throwable paramT)
        {
          b.a.c.b.b(paramT);
          this.s.dispose();
          onError(paramT);
          return;
        }
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.s.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
  
  static final class b<K, T>
    extends b.a.f.b<K, T>
  {
    final bi.c<T, K> a;
    
    protected b(K paramK, bi.c<T, K> paramc)
    {
      super();
      this.a = paramc;
    }
    
    public static <T, K> b<K, T> a(K paramK, int paramInt, bi.a<?, K, T> parama, boolean paramBoolean)
    {
      return new b(paramK, new bi.c(paramInt, parama, paramK, paramBoolean));
    }
    
    public void a()
    {
      this.a.onComplete();
    }
    
    public void a(T paramT)
    {
      this.a.onNext(paramT);
    }
    
    public void a(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    protected void subscribeActual(s<? super T> params)
    {
      this.a.subscribe(params);
    }
  }
  
  static final class c<T, K>
    extends AtomicInteger
    implements b.a.b.b, q<T>
  {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<s<? super T>> actual = new AtomicReference();
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once = new AtomicBoolean();
    final bi.a<?, K, T> parent;
    final c<T> queue;
    
    c(int paramInt, bi.a<?, K, T> parama, K paramK, boolean paramBoolean)
    {
      this.queue = new c(paramInt);
      this.parent = parama;
      this.key = paramK;
      this.delayError = paramBoolean;
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, s<? super T> params, boolean paramBoolean3)
    {
      if (this.cancelled.get())
      {
        this.queue.clear();
        this.parent.cancel(this.key);
        this.actual.lazySet(null);
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable;
        if (paramBoolean3)
        {
          if (paramBoolean2)
          {
            localThrowable = this.error;
            this.actual.lazySet(null);
            if (localThrowable != null)
            {
              params.onError(localThrowable);
              return true;
            }
            params.onComplete();
            return true;
          }
        }
        else
        {
          localThrowable = this.error;
          if (localThrowable != null)
          {
            this.queue.clear();
            this.actual.lazySet(null);
            params.onError(localThrowable);
            return true;
          }
          if (paramBoolean2)
          {
            this.actual.lazySet(null);
            params.onComplete();
            return true;
          }
        }
      }
      return false;
    }
    
    public void dispose()
    {
      if ((this.cancelled.compareAndSet(false, true)) && (getAndIncrement() == 0))
      {
        this.actual.lazySet(null);
        this.parent.cancel(this.key);
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      c localc = this.queue;
      boolean bool2 = this.delayError;
      s locals = (s)this.actual.get();
      int i = 1;
      for (;;)
      {
        if (locals != null) {
          for (;;)
          {
            boolean bool3 = this.done;
            Object localObject = localc.poll();
            boolean bool1;
            if (localObject == null) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (checkTerminated(bool3, bool1, locals, bool2)) {
              return;
            }
            if (bool1) {
              break;
            }
            locals.onNext(localObject);
          }
        }
        int j = addAndGet(-i);
        if (j == 0) {
          return;
        }
        i = j;
        if (locals == null)
        {
          locals = (s)this.actual.get();
          i = j;
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled.get();
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      drain();
    }
    
    public void onNext(T paramT)
    {
      this.queue.offer(paramT);
      drain();
    }
    
    public void subscribe(s<? super T> params)
    {
      if (this.once.compareAndSet(false, true))
      {
        params.onSubscribe(this);
        this.actual.lazySet(params);
        if (this.cancelled.get())
        {
          this.actual.lazySet(null);
          return;
        }
        drain();
        return;
      }
      e.error(new IllegalStateException("Only one Observer allowed!"), params);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */