package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.e;
import b.a.h.a;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class cw
{
  public static <T, U> l<U> a(T paramT, h<? super T, ? extends q<? extends U>> paramh)
  {
    return a.a(new b(paramT, paramh));
  }
  
  public static <T, R> boolean a(q<T> paramq, s<? super R> params, h<? super T, ? extends q<? extends R>> paramh)
  {
    if ((paramq instanceof Callable)) {
      try
      {
        paramq = ((Callable)paramq).call();
        if (paramq == null)
        {
          e.complete(params);
          return true;
        }
        try
        {
          paramq = (q)b.a.e.b.b.a(paramh.apply(paramq), "The mapper returned a null ObservableSource");
          if ((paramq instanceof Callable)) {
            try
            {
              paramq = ((Callable)paramq).call();
              if (paramq == null)
              {
                e.complete(params);
                return true;
              }
              paramq = new a(params, paramq);
              params.onSubscribe(paramq);
              paramq.run();
              return true;
            }
            catch (Throwable paramq)
            {
              b.a.c.b.b(paramq);
              e.error(paramq, params);
              return true;
            }
          }
          paramq.subscribe(params);
          return true;
        }
        catch (Throwable paramq)
        {
          b.a.c.b.b(paramq);
          e.error(paramq, params);
          return true;
        }
        return false;
      }
      catch (Throwable paramq)
      {
        b.a.c.b.b(paramq);
        e.error(paramq, params);
        return true;
      }
    }
  }
  
  public static final class a<T>
    extends AtomicInteger
    implements b.a.e.c.b<T>, Runnable
  {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final s<? super T> observer;
    final T value;
    
    public a(s<? super T> params, T paramT)
    {
      this.observer = params;
      this.value = paramT;
    }
    
    public void clear()
    {
      lazySet(3);
    }
    
    public void dispose()
    {
      set(3);
    }
    
    public boolean isDisposed()
    {
      return get() == 3;
    }
    
    public boolean isEmpty()
    {
      return get() != 1;
    }
    
    public boolean offer(T paramT)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public boolean offer(T paramT1, T paramT2)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public T poll()
      throws Exception
    {
      if (get() == 1)
      {
        lazySet(3);
        return (T)this.value;
      }
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        lazySet(1);
        return 1;
      }
      return 0;
    }
    
    public void run()
    {
      if ((get() == 0) && (compareAndSet(0, 2)))
      {
        this.observer.onNext(this.value);
        if (get() == 2)
        {
          lazySet(3);
          this.observer.onComplete();
        }
      }
    }
  }
  
  static final class b<T, R>
    extends l<R>
  {
    final T a;
    final h<? super T, ? extends q<? extends R>> b;
    
    b(T paramT, h<? super T, ? extends q<? extends R>> paramh)
    {
      this.a = paramT;
      this.b = paramh;
    }
    
    public void subscribeActual(s<? super R> params)
    {
      try
      {
        Object localObject = (q)b.a.e.b.b.a(this.b.apply(this.a), "The mapper returned a null ObservableSource");
        if ((localObject instanceof Callable)) {
          try
          {
            localObject = ((Callable)localObject).call();
            if (localObject == null)
            {
              e.complete(params);
              return;
            }
            localObject = new cw.a(params, localObject);
            params.onSubscribe((b.a.b.b)localObject);
            ((cw.a)localObject).run();
            return;
          }
          catch (Throwable localThrowable1)
          {
            b.a.c.b.b(localThrowable1);
            e.error(localThrowable1, params);
            return;
          }
        }
        localThrowable1.subscribe(params);
        return;
      }
      catch (Throwable localThrowable2)
      {
        e.error(localThrowable2, params);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */