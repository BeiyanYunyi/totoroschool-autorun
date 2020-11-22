package b.a.e.e.d;

import b.a.d.h;
import b.a.e.j.j;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class bq<TLeft, TRight, TLeftEnd, TRightEnd, R>
  extends a<TLeft, R>
{
  final q<? extends TRight> b;
  final h<? super TLeft, ? extends q<TLeftEnd>> c;
  final h<? super TRight, ? extends q<TRightEnd>> d;
  final b.a.d.c<? super TLeft, ? super TRight, ? extends R> e;
  
  public bq(q<TLeft> paramq, q<? extends TRight> paramq1, h<? super TLeft, ? extends q<TLeftEnd>> paramh, h<? super TRight, ? extends q<TRightEnd>> paramh1, b.a.d.c<? super TLeft, ? super TRight, ? extends R> paramc)
  {
    super(paramq);
    this.b = paramq1;
    this.c = paramh;
    this.d = paramh1;
    this.e = paramc;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    a locala = new a(params, this.c, this.d, this.e);
    params.onSubscribe(locala);
    params = new bj.d(locala, true);
    locala.disposables.a(params);
    bj.d locald = new bj.d(locala, false);
    locala.disposables.a(locald);
    this.a.subscribe(params);
    this.b.subscribe(locald);
  }
  
  static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R>
    extends AtomicInteger
    implements b.a.b.b, bj.b
  {
    static final Integer LEFT_CLOSE = Integer.valueOf(3);
    static final Integer LEFT_VALUE = Integer.valueOf(1);
    static final Integer RIGHT_CLOSE = Integer.valueOf(4);
    static final Integer RIGHT_VALUE = Integer.valueOf(2);
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    final s<? super R> actual;
    volatile boolean cancelled;
    final b.a.b.a disposables;
    final AtomicReference<Throwable> error;
    final h<? super TLeft, ? extends q<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, TLeft> lefts;
    final b.a.e.f.c<Object> queue;
    final b.a.d.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final h<? super TRight, ? extends q<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;
    
    a(s<? super R> params, h<? super TLeft, ? extends q<TLeftEnd>> paramh, h<? super TRight, ? extends q<TRightEnd>> paramh1, b.a.d.c<? super TLeft, ? super TRight, ? extends R> paramc)
    {
      this.actual = params;
      this.disposables = new b.a.b.a();
      this.queue = new b.a.e.f.c(l.bufferSize());
      this.lefts = new LinkedHashMap();
      this.rights = new LinkedHashMap();
      this.error = new AtomicReference();
      this.leftEnd = paramh;
      this.rightEnd = paramh1;
      this.resultSelector = paramc;
      this.active = new AtomicInteger(2);
    }
    
    void cancelAll()
    {
      this.disposables.dispose();
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() == 0) {
          this.queue.clear();
        }
      }
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      b.a.e.f.c localc = this.queue;
      s locals = this.actual;
      int i = 1;
      for (;;)
      {
        if (this.cancelled)
        {
          localc.clear();
          return;
        }
        if ((Throwable)this.error.get() != null)
        {
          localc.clear();
          cancelAll();
          errorAll(locals);
          return;
        }
        int j;
        if (this.active.get() == 0) {
          j = 1;
        } else {
          j = 0;
        }
        Object localObject2 = (Integer)localc.poll();
        int k;
        if (localObject2 == null) {
          k = 1;
        } else {
          k = 0;
        }
        if ((j != 0) && (k != 0))
        {
          this.lefts.clear();
          this.rights.clear();
          this.disposables.dispose();
          locals.onComplete();
          return;
        }
        if (k != 0)
        {
          j = addAndGet(-i);
          i = j;
          if (j != 0) {}
        }
        else
        {
          Object localObject1 = localc.poll();
          Object localObject3;
          if (localObject2 == LEFT_VALUE)
          {
            j = this.leftIndex;
            this.leftIndex = (j + 1);
            this.lefts.put(Integer.valueOf(j), localObject1);
            try
            {
              localObject2 = (q)b.a.e.b.b.a(this.leftEnd.apply(localObject1), "The leftEnd returned a null ObservableSource");
              localObject3 = new bj.c(this, true, j);
              this.disposables.a((b.a.b.b)localObject3);
              ((q)localObject2).subscribe((s)localObject3);
              if ((Throwable)this.error.get() != null)
              {
                localc.clear();
                cancelAll();
                errorAll(locals);
                return;
              }
              localObject2 = this.rights.values().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = ((Iterator)localObject2).next();
                try
                {
                  localObject3 = b.a.e.b.b.a(this.resultSelector.a(localObject1, localObject3), "The resultSelector returned a null value");
                  locals.onNext(localObject3);
                }
                catch (Throwable localThrowable1)
                {
                  fail(localThrowable1, locals, localc);
                  return;
                }
              }
              if (localObject2 != RIGHT_VALUE) {
                break label589;
              }
            }
            catch (Throwable localThrowable2)
            {
              fail(localThrowable2, locals, localc);
              return;
            }
          }
          else
          {
            j = this.rightIndex;
            this.rightIndex = (j + 1);
            this.rights.put(Integer.valueOf(j), localThrowable2);
            try
            {
              localObject2 = (q)b.a.e.b.b.a(this.rightEnd.apply(localThrowable2), "The rightEnd returned a null ObservableSource");
              localObject3 = new bj.c(this, false, j);
              this.disposables.a((b.a.b.b)localObject3);
              ((q)localObject2).subscribe((s)localObject3);
              if ((Throwable)this.error.get() != null)
              {
                localc.clear();
                cancelAll();
                errorAll(locals);
                return;
              }
              localObject2 = this.lefts.values().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = ((Iterator)localObject2).next();
                try
                {
                  localObject3 = b.a.e.b.b.a(this.resultSelector.a(localObject3, localThrowable2), "The resultSelector returned a null value");
                  locals.onNext(localObject3);
                }
                catch (Throwable localThrowable3)
                {
                  fail(localThrowable3, locals, localc);
                  return;
                }
              }
              if (localObject2 != LEFT_CLOSE) {
                break label635;
              }
            }
            catch (Throwable localThrowable4)
            {
              fail(localThrowable4, locals, localc);
              return;
            }
            label589:
            bj.c localc1 = (bj.c)localThrowable4;
            this.lefts.remove(Integer.valueOf(localc1.index));
            this.disposables.b(localc1);
            continue;
            label635:
            localc1 = (bj.c)localc1;
            this.rights.remove(Integer.valueOf(localc1.index));
            this.disposables.b(localc1);
          }
        }
      }
    }
    
    void errorAll(s<?> params)
    {
      Throwable localThrowable = j.a(this.error);
      this.lefts.clear();
      this.rights.clear();
      params.onError(localThrowable);
    }
    
    void fail(Throwable paramThrowable, s<?> params, b.a.e.f.c<?> paramc)
    {
      b.a.c.b.b(paramThrowable);
      j.a(this.error, paramThrowable);
      paramc.clear();
      cancelAll();
      errorAll(params);
    }
    
    public void innerClose(boolean paramBoolean, bj.c paramc)
    {
      try
      {
        b.a.e.f.c localc = this.queue;
        Integer localInteger;
        if (paramBoolean) {
          localInteger = LEFT_CLOSE;
        } else {
          localInteger = RIGHT_CLOSE;
        }
        localc.a(localInteger, paramc);
        drain();
        return;
      }
      finally {}
    }
    
    public void innerCloseError(Throwable paramThrowable)
    {
      if (j.a(this.error, paramThrowable))
      {
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void innerComplete(bj.d paramd)
    {
      this.disposables.c(paramd);
      this.active.decrementAndGet();
      drain();
    }
    
    public void innerError(Throwable paramThrowable)
    {
      if (j.a(this.error, paramThrowable))
      {
        this.active.decrementAndGet();
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void innerValue(boolean paramBoolean, Object paramObject)
    {
      try
      {
        b.a.e.f.c localc = this.queue;
        Integer localInteger;
        if (paramBoolean) {
          localInteger = LEFT_VALUE;
        } else {
          localInteger = RIGHT_VALUE;
        }
        localc.a(localInteger, paramObject);
        drain();
        return;
      }
      finally {}
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */