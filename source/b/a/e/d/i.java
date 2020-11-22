package b.a.e.d;

import b.a.h.a;
import b.a.s;

public class i<T>
  extends b<T>
{
  static final int DISPOSED = 4;
  static final int FUSED_CONSUMED = 32;
  static final int FUSED_EMPTY = 8;
  static final int FUSED_READY = 16;
  static final int TERMINATED = 2;
  private static final long serialVersionUID = -5502432239815349361L;
  protected final s<? super T> actual;
  protected T value;
  
  public i(s<? super T> params)
  {
    this.actual = params;
  }
  
  public final void clear()
  {
    lazySet(32);
    this.value = null;
  }
  
  public final void complete()
  {
    if ((get() & 0x36) != 0) {
      return;
    }
    lazySet(2);
    this.actual.onComplete();
  }
  
  public final void complete(T paramT)
  {
    int i = get();
    if ((i & 0x36) != 0) {
      return;
    }
    s locals = this.actual;
    if (i == 8)
    {
      this.value = paramT;
      lazySet(16);
      locals.onNext(null);
    }
    else
    {
      lazySet(2);
      locals.onNext(paramT);
    }
    if (get() != 4) {
      locals.onComplete();
    }
  }
  
  public void dispose()
  {
    set(4);
    this.value = null;
  }
  
  public final void error(Throwable paramThrowable)
  {
    if ((get() & 0x36) != 0)
    {
      a.a(paramThrowable);
      return;
    }
    lazySet(2);
    this.actual.onError(paramThrowable);
  }
  
  public final boolean isDisposed()
  {
    return get() == 4;
  }
  
  public final boolean isEmpty()
  {
    return get() != 16;
  }
  
  public final T poll()
    throws Exception
  {
    if (get() == 16)
    {
      Object localObject = this.value;
      this.value = null;
      lazySet(32);
      return (T)localObject;
    }
    return null;
  }
  
  public final int requestFusion(int paramInt)
  {
    if ((paramInt & 0x2) != 0)
    {
      lazySet(8);
      return 2;
    }
    return 0;
  }
  
  public final boolean tryDispose()
  {
    return getAndSet(4) != 4;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */