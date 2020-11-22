package b.a.e.e.c;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.j.c;
import b.a.h.a;
import b.a.i;
import b.a.j;
import b.a.l;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class e<T, R>
  extends l<R>
{
  final l<T> a;
  final h<? super T, ? extends j<? extends R>> b;
  final boolean c;
  
  public e(l<T> paraml, h<? super T, ? extends j<? extends R>> paramh, boolean paramBoolean)
  {
    this.a = paraml;
    this.b = paramh;
    this.c = paramBoolean;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    if (!g.a(this.a, this.b, params)) {
      this.a.subscribe(new a(params, this.b, this.c));
    }
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    static final a<Object> INNER_DISPOSED = new a(null);
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final s<? super R> downstream;
    final c errors;
    final AtomicReference<a<R>> inner;
    final h<? super T, ? extends j<? extends R>> mapper;
    b.a.b.b upstream;
    
    a(s<? super R> params, h<? super T, ? extends j<? extends R>> paramh, boolean paramBoolean)
    {
      this.downstream = params;
      this.mapper = paramh;
      this.delayErrors = paramBoolean;
      this.errors = new c();
      this.inner = new AtomicReference();
    }
    
    public void dispose()
    {
      this.cancelled = true;
      this.upstream.dispose();
      disposeInner();
    }
    
    void disposeInner()
    {
      a locala = (a)this.inner.getAndSet(INNER_DISPOSED);
      if ((locala != null) && (locala != INNER_DISPOSED)) {
        locala.dispose();
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      s locals = this.downstream;
      Object localObject = this.errors;
      AtomicReference localAtomicReference = this.inner;
      int i = 1;
      int j;
      do
      {
        for (;;)
        {
          if (this.cancelled) {
            return;
          }
          if ((((c)localObject).get() != null) && (!this.delayErrors))
          {
            locals.onError(((c)localObject).terminate());
            return;
          }
          boolean bool = this.done;
          a locala = (a)localAtomicReference.get();
          if (locala == null) {
            j = 1;
          } else {
            j = 0;
          }
          if ((bool) && (j != 0))
          {
            localObject = ((c)localObject).terminate();
            if (localObject != null)
            {
              locals.onError((Throwable)localObject);
              return;
            }
            locals.onComplete();
            return;
          }
          if ((j != 0) || (locala.item == null)) {
            break;
          }
          localAtomicReference.compareAndSet(locala, null);
          locals.onNext(locala.item);
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    void innerComplete(a<R> parama)
    {
      if (this.inner.compareAndSet(parama, null)) {
        drain();
      }
    }
    
    void innerError(a<R> parama, Throwable paramThrowable)
    {
      if ((this.inner.compareAndSet(parama, null)) && (this.errors.addThrowable(paramThrowable)))
      {
        if (!this.delayErrors)
        {
          this.upstream.dispose();
          disposeInner();
        }
        drain();
        return;
      }
      a.a(paramThrowable);
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.errors.addThrowable(paramThrowable))
      {
        if (!this.delayErrors) {
          disposeInner();
        }
        this.done = true;
        drain();
        return;
      }
      a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      a locala1 = (a)this.inner.get();
      if (locala1 != null) {
        locala1.dispose();
      }
      try
      {
        paramT = (j)b.a.e.b.b.a(this.mapper.apply(paramT), "The mapper returned a null MaybeSource");
        locala1 = new a(this);
        a locala2;
        do
        {
          locala2 = (a)this.inner.get();
          if (locala2 == INNER_DISPOSED) {
            return;
          }
        } while (!this.inner.compareAndSet(locala2, locala1));
        paramT.a(locala1);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.upstream.dispose();
        this.inner.getAndSet(INNER_DISPOSED);
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.upstream, paramb))
      {
        this.upstream = paramb;
        this.downstream.onSubscribe(this);
      }
    }
    
    static final class a<R>
      extends AtomicReference<b.a.b.b>
      implements i<R>
    {
      private static final long serialVersionUID = 8042919737683345351L;
      volatile R item;
      final e.a<?, R> parent;
      
      a(e.a<?, R> parama)
      {
        this.parent = parama;
      }
      
      void dispose()
      {
        d.dispose(this);
      }
      
      public void onComplete()
      {
        this.parent.innerComplete(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.innerError(this, paramThrowable);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        d.setOnce(this, paramb);
      }
      
      public void onSuccess(R paramR)
      {
        this.item = paramR;
        this.parent.drain();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */