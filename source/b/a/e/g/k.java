package b.a.e.g;

import b.a.b.b;
import b.a.e.a.c;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class k
  extends AtomicReferenceArray<Object>
  implements b, Runnable, Callable<Object>
{
  static final Object ASYNC_DISPOSED = new Object();
  static final Object DONE = new Object();
  static final int FUTURE_INDEX = 1;
  static final Object PARENT_DISPOSED = new Object();
  static final int PARENT_INDEX = 0;
  static final Object SYNC_DISPOSED = new Object();
  static final int THREAD_INDEX = 2;
  private static final long serialVersionUID = -6120223772001106981L;
  final Runnable actual;
  
  public k(Runnable paramRunnable, c paramc)
  {
    super(3);
    this.actual = paramRunnable;
    lazySet(0, paramc);
  }
  
  public Object call()
  {
    run();
    return null;
  }
  
  public void dispose()
  {
    Object localObject2;
    boolean bool;
    Object localObject1;
    do
    {
      localObject2 = get(1);
      if ((localObject2 == DONE) || (localObject2 == SYNC_DISPOSED) || (localObject2 == ASYNC_DISPOSED)) {
        break;
      }
      if (get(2) != Thread.currentThread()) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        localObject1 = ASYNC_DISPOSED;
      } else {
        localObject1 = SYNC_DISPOSED;
      }
    } while (!compareAndSet(1, localObject2, localObject1));
    if (localObject2 != null) {
      ((Future)localObject2).cancel(bool);
    }
    do
    {
      localObject1 = get(0);
      if ((localObject1 == DONE) || (localObject1 == PARENT_DISPOSED)) {
        break;
      }
      if (localObject1 == null) {
        return;
      }
    } while (!compareAndSet(0, localObject1, PARENT_DISPOSED));
    ((c)localObject1).c(this);
    return;
  }
  
  public boolean isDisposed()
  {
    boolean bool = false;
    Object localObject = get(0);
    if ((localObject == PARENT_DISPOSED) || (localObject == DONE)) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 71	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 55	b/a/e/g/k:lazySet	(ILjava/lang/Object;)V
    //   8: aload_0
    //   9: getfield 51	b/a/e/g/k:actual	Ljava/lang/Runnable;
    //   12: invokeinterface 92 1 0
    //   17: goto +12 -> 29
    //   20: astore_1
    //   21: goto +87 -> 108
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 98	b/a/h/a:a	(Ljava/lang/Throwable;)V
    //   29: aload_0
    //   30: iconst_2
    //   31: aconst_null
    //   32: invokevirtual 55	b/a/e/g/k:lazySet	(ILjava/lang/Object;)V
    //   35: aload_0
    //   36: iconst_0
    //   37: invokevirtual 65	b/a/e/g/k:get	(I)Ljava/lang/Object;
    //   40: astore_1
    //   41: aload_1
    //   42: getstatic 38	b/a/e/g/k:PARENT_DISPOSED	Ljava/lang/Object;
    //   45: if_acmpeq +30 -> 75
    //   48: aload_0
    //   49: iconst_0
    //   50: aload_1
    //   51: getstatic 44	b/a/e/g/k:DONE	Ljava/lang/Object;
    //   54: invokevirtual 75	b/a/e/g/k:compareAndSet	(ILjava/lang/Object;Ljava/lang/Object;)Z
    //   57: ifeq +18 -> 75
    //   60: aload_1
    //   61: ifnull +14 -> 75
    //   64: aload_1
    //   65: checkcast 83	b/a/e/a/c
    //   68: aload_0
    //   69: invokeinterface 87 2 0
    //   74: pop
    //   75: aload_0
    //   76: iconst_1
    //   77: invokevirtual 65	b/a/e/g/k:get	(I)Ljava/lang/Object;
    //   80: astore_1
    //   81: aload_1
    //   82: getstatic 40	b/a/e/g/k:SYNC_DISPOSED	Ljava/lang/Object;
    //   85: if_acmpeq +22 -> 107
    //   88: aload_1
    //   89: getstatic 42	b/a/e/g/k:ASYNC_DISPOSED	Ljava/lang/Object;
    //   92: if_acmpeq +15 -> 107
    //   95: aload_0
    //   96: iconst_1
    //   97: aload_1
    //   98: getstatic 44	b/a/e/g/k:DONE	Ljava/lang/Object;
    //   101: invokevirtual 75	b/a/e/g/k:compareAndSet	(ILjava/lang/Object;Ljava/lang/Object;)Z
    //   104: ifeq -29 -> 75
    //   107: return
    //   108: aload_0
    //   109: iconst_2
    //   110: aconst_null
    //   111: invokevirtual 55	b/a/e/g/k:lazySet	(ILjava/lang/Object;)V
    //   114: aload_0
    //   115: iconst_0
    //   116: invokevirtual 65	b/a/e/g/k:get	(I)Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: getstatic 38	b/a/e/g/k:PARENT_DISPOSED	Ljava/lang/Object;
    //   124: if_acmpeq +30 -> 154
    //   127: aload_0
    //   128: iconst_0
    //   129: aload_2
    //   130: getstatic 44	b/a/e/g/k:DONE	Ljava/lang/Object;
    //   133: invokevirtual 75	b/a/e/g/k:compareAndSet	(ILjava/lang/Object;Ljava/lang/Object;)Z
    //   136: ifeq +18 -> 154
    //   139: aload_2
    //   140: ifnull +14 -> 154
    //   143: aload_2
    //   144: checkcast 83	b/a/e/a/c
    //   147: aload_0
    //   148: invokeinterface 87 2 0
    //   153: pop
    //   154: aload_0
    //   155: iconst_1
    //   156: invokevirtual 65	b/a/e/g/k:get	(I)Ljava/lang/Object;
    //   159: astore_2
    //   160: aload_2
    //   161: getstatic 40	b/a/e/g/k:SYNC_DISPOSED	Ljava/lang/Object;
    //   164: if_acmpeq +25 -> 189
    //   167: aload_2
    //   168: getstatic 42	b/a/e/g/k:ASYNC_DISPOSED	Ljava/lang/Object;
    //   171: if_acmpeq +18 -> 189
    //   174: aload_0
    //   175: iconst_1
    //   176: aload_2
    //   177: getstatic 44	b/a/e/g/k:DONE	Ljava/lang/Object;
    //   180: invokevirtual 75	b/a/e/g/k:compareAndSet	(ILjava/lang/Object;Ljava/lang/Object;)Z
    //   183: ifne +6 -> 189
    //   186: goto -32 -> 154
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	k
    //   20	1	1	localObject1	Object
    //   24	2	1	localThrowable	Throwable
    //   40	150	1	localObject2	Object
    //   119	58	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	20	finally
    //   25	29	20	finally
    //   8	17	24	java/lang/Throwable
  }
  
  public void setFuture(Future<?> paramFuture)
  {
    Object localObject;
    do
    {
      localObject = get(1);
      if (localObject == DONE) {
        return;
      }
      if (localObject == SYNC_DISPOSED)
      {
        paramFuture.cancel(false);
        return;
      }
      if (localObject == ASYNC_DISPOSED)
      {
        paramFuture.cancel(true);
        return;
      }
    } while (!compareAndSet(1, localObject, paramFuture));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */