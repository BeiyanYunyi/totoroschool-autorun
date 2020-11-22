package b.a.e.e.d;

import b.a.d.c;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.h.a;
import b.a.l;
import b.a.s;
import java.util.Iterator;

public final class el<T, U, V>
  extends l<V>
{
  final l<? extends T> a;
  final Iterable<U> b;
  final c<? super T, ? super U, ? extends V> c;
  
  public el(l<? extends T> paraml, Iterable<U> paramIterable, c<? super T, ? super U, ? extends V> paramc)
  {
    this.a = paraml;
    this.b = paramIterable;
    this.c = paramc;
  }
  
  public void subscribeActual(s<? super V> params)
  {
    try
    {
      Iterator localIterator = (Iterator)b.a.e.b.b.a(this.b.iterator(), "The iterator returned by other is null");
      try
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
        {
          e.complete(params);
          return;
        }
        this.a.subscribe(new a(params, localIterator, this.c));
        return;
      }
      catch (Throwable localThrowable1)
      {
        b.a.c.b.b(localThrowable1);
        e.error(localThrowable1, params);
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      b.a.c.b.b(localThrowable2);
      e.error(localThrowable2, params);
    }
  }
  
  static final class a<T, U, V>
    implements b.a.b.b, s<T>
  {
    final s<? super V> a;
    final Iterator<U> b;
    final c<? super T, ? super U, ? extends V> c;
    b.a.b.b d;
    boolean e;
    
    a(s<? super V> params, Iterator<U> paramIterator, c<? super T, ? super U, ? extends V> paramc)
    {
      this.a = params;
      this.b = paramIterator;
      this.c = paramc;
    }
    
    void a(Throwable paramThrowable)
    {
      this.e = true;
      this.d.dispose();
      this.a.onError(paramThrowable);
    }
    
    public void dispose()
    {
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.e) {
        return;
      }
      this.e = true;
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.e)
      {
        a.a(paramThrowable);
        return;
      }
      this.e = true;
      this.a.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 41	b/a/e/e/d/el$a:e	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 33	b/a/e/e/d/el$a:b	Ljava/util/Iterator;
      //   12: invokeinterface 70 1 0
      //   17: ldc 72
      //   19: invokestatic 77	b/a/e/b/b:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield 35	b/a/e/e/d/el$a:c	Lb/a/d/c;
      //   27: aload_1
      //   28: aload_3
      //   29: invokeinterface 82 3 0
      //   34: ldc 84
      //   36: invokestatic 77	b/a/e/b/b:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   39: astore_1
      //   40: aload_0
      //   41: getfield 31	b/a/e/e/d/el$a:a	Lb/a/s;
      //   44: aload_1
      //   45: invokeinterface 86 2 0
      //   50: aload_0
      //   51: getfield 33	b/a/e/e/d/el$a:b	Ljava/util/Iterator;
      //   54: invokeinterface 89 1 0
      //   59: istore_2
      //   60: iload_2
      //   61: ifne +26 -> 87
      //   64: aload_0
      //   65: iconst_1
      //   66: putfield 41	b/a/e/e/d/el$a:e	Z
      //   69: aload_0
      //   70: getfield 43	b/a/e/e/d/el$a:d	Lb/a/b/b;
      //   73: invokeinterface 46 1 0
      //   78: aload_0
      //   79: getfield 31	b/a/e/e/d/el$a:a	Lb/a/s;
      //   82: invokeinterface 56 1 0
      //   87: return
      //   88: astore_1
      //   89: aload_1
      //   90: invokestatic 93	b/a/c/b:b	(Ljava/lang/Throwable;)V
      //   93: aload_0
      //   94: aload_1
      //   95: invokevirtual 94	b/a/e/e/d/el$a:a	(Ljava/lang/Throwable;)V
      //   98: return
      //   99: astore_1
      //   100: aload_1
      //   101: invokestatic 93	b/a/c/b:b	(Ljava/lang/Throwable;)V
      //   104: aload_0
      //   105: aload_1
      //   106: invokevirtual 94	b/a/e/e/d/el$a:a	(Ljava/lang/Throwable;)V
      //   109: return
      //   110: astore_1
      //   111: aload_1
      //   112: invokestatic 93	b/a/c/b:b	(Ljava/lang/Throwable;)V
      //   115: aload_0
      //   116: aload_1
      //   117: invokevirtual 94	b/a/e/e/d/el$a:a	(Ljava/lang/Throwable;)V
      //   120: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	121	0	this	a
      //   0	121	1	paramT	T
      //   59	2	2	bool	boolean
      //   22	7	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   50	60	88	java/lang/Throwable
      //   23	40	99	java/lang/Throwable
      //   8	23	110	java/lang/Throwable
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.a.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */