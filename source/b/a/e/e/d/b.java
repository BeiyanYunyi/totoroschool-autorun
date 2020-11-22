package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.f.c;
import b.a.q;
import b.a.s;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b<T>
  implements Iterable<T>
{
  final q<? extends T> a;
  final int b;
  
  public b(q<? extends T> paramq, int paramInt)
  {
    this.a = paramq;
    this.b = paramInt;
  }
  
  public Iterator<T> iterator()
  {
    a locala = new a(this.b);
    this.a.subscribe(locala);
    return locala;
  }
  
  static final class a<T>
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, s<T>, Iterator<T>
  {
    private static final long serialVersionUID = 6695226475494099826L;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final Lock lock;
    final c<T> queue;
    
    a(int paramInt)
    {
      this.queue = new c(paramInt);
      this.lock = new ReentrantLock();
      this.condition = this.lock.newCondition();
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    /* Error */
    public boolean hasNext()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 66	b/a/e/e/d/b$a:done	Z
      //   4: istore_1
      //   5: aload_0
      //   6: getfield 40	b/a/e/e/d/b$a:queue	Lb/a/e/f/c;
      //   9: invokevirtual 69	b/a/e/f/c:isEmpty	()Z
      //   12: istore_2
      //   13: iload_1
      //   14: ifeq +23 -> 37
      //   17: aload_0
      //   18: getfield 71	b/a/e/e/d/b$a:error	Ljava/lang/Throwable;
      //   21: astore_3
      //   22: aload_3
      //   23: ifnonnull +9 -> 32
      //   26: iload_2
      //   27: ifeq +10 -> 37
      //   30: iconst_0
      //   31: ireturn
      //   32: aload_3
      //   33: invokestatic 76	b/a/e/j/j:a	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
      //   36: athrow
      //   37: iload_2
      //   38: ifeq +83 -> 121
      //   41: invokestatic 80	b/a/e/j/e:a	()V
      //   44: aload_0
      //   45: getfield 45	b/a/e/e/d/b$a:lock	Ljava/util/concurrent/locks/Lock;
      //   48: invokeinterface 82 1 0
      //   53: aload_0
      //   54: getfield 66	b/a/e/e/d/b$a:done	Z
      //   57: ifne +25 -> 82
      //   60: aload_0
      //   61: getfield 40	b/a/e/e/d/b$a:queue	Lb/a/e/f/c;
      //   64: invokevirtual 69	b/a/e/f/c:isEmpty	()Z
      //   67: ifeq +15 -> 82
      //   70: aload_0
      //   71: getfield 53	b/a/e/e/d/b$a:condition	Ljava/util/concurrent/locks/Condition;
      //   74: invokeinterface 87 1 0
      //   79: goto -26 -> 53
      //   82: aload_0
      //   83: getfield 45	b/a/e/e/d/b$a:lock	Ljava/util/concurrent/locks/Lock;
      //   86: invokeinterface 90 1 0
      //   91: goto -91 -> 0
      //   94: astore_3
      //   95: aload_0
      //   96: getfield 45	b/a/e/e/d/b$a:lock	Ljava/util/concurrent/locks/Lock;
      //   99: invokeinterface 90 1 0
      //   104: aload_3
      //   105: athrow
      //   106: astore_3
      //   107: aload_0
      //   108: invokestatic 60	b/a/e/a/d:dispose	(Ljava/util/concurrent/atomic/AtomicReference;)Z
      //   111: pop
      //   112: aload_0
      //   113: invokevirtual 93	b/a/e/e/d/b$a:signalConsumer	()V
      //   116: aload_3
      //   117: invokestatic 76	b/a/e/j/j:a	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
      //   120: athrow
      //   121: iconst_1
      //   122: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	123	0	this	a
      //   4	10	1	bool1	boolean
      //   12	26	2	bool2	boolean
      //   21	12	3	localThrowable	Throwable
      //   94	11	3	localObject	Object
      //   106	11	3	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   53	79	94	finally
      //   41	53	106	java/lang/InterruptedException
      //   82	91	106	java/lang/InterruptedException
      //   95	106	106	java/lang/InterruptedException
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b.a.b.b)get());
    }
    
    public T next()
    {
      if (hasNext()) {
        return (T)this.queue.poll();
      }
      throw new NoSuchElementException();
    }
    
    public void onComplete()
    {
      this.done = true;
      signalConsumer();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      signalConsumer();
    }
    
    public void onNext(T paramT)
    {
      this.queue.offer(paramT);
      signalConsumer();
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this, paramb);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("remove");
    }
    
    void signalConsumer()
    {
      this.lock.lock();
      try
      {
        this.condition.signalAll();
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */