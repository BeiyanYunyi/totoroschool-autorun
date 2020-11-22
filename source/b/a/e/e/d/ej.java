package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.e.j.c;
import b.a.e.j.k;
import b.a.q;
import b.a.s;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ej<T, R>
  extends a<T, R>
{
  final q<?>[] b;
  final Iterable<? extends q<?>> c;
  final h<? super Object[], R> d;
  
  public ej(q<T> paramq, Iterable<? extends q<?>> paramIterable, h<? super Object[], R> paramh)
  {
    super(paramq);
    this.b = null;
    this.c = paramIterable;
    this.d = paramh;
  }
  
  public ej(q<T> paramq, q<?>[] paramArrayOfq, h<? super Object[], R> paramh)
  {
    super(paramq);
    this.b = paramArrayOfq;
    this.c = null;
    this.d = paramh;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    Object localObject2 = this.b;
    int j;
    if (localObject2 == null)
    {
      Object localObject1 = new q[8];
      try
      {
        Iterator localIterator = this.c.iterator();
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          q localq = (q)localIterator.next();
          localObject2 = localObject1;
          if (i == localObject1.length) {
            localObject2 = (q[])Arrays.copyOf((Object[])localObject1, (i >> 1) + i);
          }
          localObject2[i] = localq;
          i += 1;
          localObject1 = localObject2;
        }
        j = localObject2.length;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        e.error(localThrowable, params);
        return;
      }
    }
    if (j == 0)
    {
      new bv(this.a, new a()).subscribeActual(params);
      return;
    }
    b localb = new b(params, this.d, j);
    params.onSubscribe(localb);
    localb.subscribe((q[])localObject2, j);
    this.a.subscribe(localb);
  }
  
  final class a
    implements h<T, R>
  {
    a() {}
    
    public R apply(T paramT)
      throws Exception
    {
      return (R)b.a.e.b.b.a(ej.this.d.apply(new Object[] { paramT }), "The combiner returned a null value");
    }
  }
  
  static final class b<T, R>
    extends AtomicInteger
    implements b.a.b.b, s<T>
  {
    private static final long serialVersionUID = 1577321883966341961L;
    final s<? super R> actual;
    final h<? super Object[], R> combiner;
    final AtomicReference<b.a.b.b> d;
    volatile boolean done;
    final c error;
    final ej.c[] observers;
    final AtomicReferenceArray<Object> values;
    
    b(s<? super R> params, h<? super Object[], R> paramh, int paramInt)
    {
      this.actual = params;
      this.combiner = paramh;
      params = new ej.c[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        params[i] = new ej.c(this, i);
        i += 1;
      }
      this.observers = params;
      this.values = new AtomicReferenceArray(paramInt);
      this.d = new AtomicReference();
      this.error = new c();
    }
    
    void cancelAllBut(int paramInt)
    {
      ej.c[] arrayOfc = this.observers;
      int i = 0;
      while (i < arrayOfc.length)
      {
        if (i != paramInt) {
          arrayOfc[i].dispose();
        }
        i += 1;
      }
    }
    
    public void dispose()
    {
      d.dispose(this.d);
      ej.c[] arrayOfc = this.observers;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        arrayOfc[i].dispose();
        i += 1;
      }
    }
    
    void innerComplete(int paramInt, boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        this.done = true;
        cancelAllBut(paramInt);
        k.a(this.actual, this, this.error);
      }
    }
    
    void innerError(int paramInt, Throwable paramThrowable)
    {
      this.done = true;
      d.dispose(this.d);
      cancelAllBut(paramInt);
      k.a(this.actual, paramThrowable, this, this.error);
    }
    
    void innerNext(int paramInt, Object paramObject)
    {
      this.values.set(paramInt, paramObject);
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)this.d.get());
    }
    
    public void onComplete()
    {
      if (!this.done)
      {
        this.done = true;
        cancelAllBut(-1);
        k.a(this.actual, this, this.error);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.done)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.done = true;
      cancelAllBut(-1);
      k.a(this.actual, paramThrowable, this, this.error);
    }
    
    public void onNext(T paramT)
    {
      if (this.done) {
        return;
      }
      AtomicReferenceArray localAtomicReferenceArray = this.values;
      int j = localAtomicReferenceArray.length();
      Object[] arrayOfObject = new Object[j + 1];
      int i = 0;
      arrayOfObject[0] = paramT;
      while (i < j)
      {
        paramT = localAtomicReferenceArray.get(i);
        if (paramT == null) {
          return;
        }
        i += 1;
        arrayOfObject[i] = paramT;
      }
      try
      {
        paramT = b.a.e.b.b.a(this.combiner.apply(arrayOfObject), "combiner returned a null value");
        k.a(this.actual, paramT, this, this.error);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this.d, paramb);
    }
    
    void subscribe(q<?>[] paramArrayOfq, int paramInt)
    {
      ej.c[] arrayOfc = this.observers;
      AtomicReference localAtomicReference = this.d;
      int i = 0;
      while (i < paramInt) {
        if (!d.isDisposed((b.a.b.b)localAtomicReference.get()))
        {
          if (this.done) {
            return;
          }
          paramArrayOfq[i].subscribe(arrayOfc[i]);
          i += 1;
        }
        else {}
      }
    }
  }
  
  static final class c
    extends AtomicReference<b.a.b.b>
    implements s<Object>
  {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final ej.b<?, ?> parent;
    
    c(ej.b<?, ?> paramb, int paramInt)
    {
      this.parent = paramb;
      this.index = paramInt;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public void onComplete()
    {
      this.parent.innerComplete(this.index, this.hasValue);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(this.index, paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      if (!this.hasValue) {
        this.hasValue = true;
      }
      this.parent.innerNext(this.index, paramObject);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */