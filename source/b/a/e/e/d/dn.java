package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import java.util.ArrayDeque;

public final class dn<T>
  extends a<T, T>
{
  final int b;
  
  public dn(q<T> paramq, int paramInt)
  {
    super(paramq);
    this.b = paramInt;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends ArrayDeque<T>
    implements b, s<T>
  {
    private static final long serialVersionUID = 7240042530241604978L;
    final s<? super T> actual;
    volatile boolean cancelled;
    final int count;
    b s;
    
    a(s<? super T> params, int paramInt)
    {
      this.actual = params;
      this.count = paramInt;
    }
    
    public void dispose()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        this.s.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      s locals = this.actual;
      for (;;)
      {
        if (this.cancelled) {
          return;
        }
        Object localObject = poll();
        if (localObject == null)
        {
          if (!this.cancelled) {
            locals.onComplete();
          }
          return;
        }
        locals.onNext(localObject);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.count == size()) {
        poll();
      }
      offer(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.s, paramb))
      {
        this.s = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */