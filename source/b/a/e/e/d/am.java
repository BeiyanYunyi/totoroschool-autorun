package b.a.e.e.d;

import b.a.e.a.d;
import b.a.q;
import b.a.s;

public final class am<T>
  extends a<T, T>
{
  final b.a.d.a b;
  
  public am(q<T> paramq, b.a.d.a parama)
  {
    super(paramq);
    this.b = parama;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends b.a.e.d.b<T>
    implements s<T>
  {
    private static final long serialVersionUID = 4109457741734051389L;
    final s<? super T> actual;
    b.a.b.b d;
    final b.a.d.a onFinally;
    b.a.e.c.b<T> qd;
    boolean syncFused;
    
    a(s<? super T> params, b.a.d.a parama)
    {
      this.actual = params;
      this.onFinally = parama;
    }
    
    public void clear()
    {
      this.qd.clear();
    }
    
    public void dispose()
    {
      this.d.dispose();
      runFinally();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public boolean isEmpty()
    {
      return this.qd.isEmpty();
    }
    
    public void onComplete()
    {
      this.actual.onComplete();
      runFinally();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
      runFinally();
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        if ((paramb instanceof b.a.e.c.b)) {
          this.qd = ((b.a.e.c.b)paramb);
        }
        this.actual.onSubscribe(this);
      }
    }
    
    public T poll()
      throws Exception
    {
      Object localObject = this.qd.poll();
      if ((localObject == null) && (this.syncFused)) {
        runFinally();
      }
      return (T)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      b.a.e.c.b localb = this.qd;
      if ((localb != null) && ((paramInt & 0x4) == 0))
      {
        paramInt = localb.requestFusion(paramInt);
        if (paramInt != 0)
        {
          boolean bool = true;
          if (paramInt != 1) {
            bool = false;
          }
          this.syncFused = bool;
        }
        return paramInt;
      }
      return 0;
    }
    
    void runFinally()
    {
      if (compareAndSet(0, 1)) {
        try
        {
          this.onFinally.a();
          return;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          b.a.h.a.a(localThrowable);
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */