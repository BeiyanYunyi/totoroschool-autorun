package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import java.util.ArrayDeque;

public final class df<T>
  extends a<T, T>
{
  final int b;
  
  public df(q<T> paramq, int paramInt)
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
    private static final long serialVersionUID = -3807491841935125653L;
    final s<? super T> actual;
    b s;
    final int skip;
    
    a(s<? super T> params, int paramInt)
    {
      super();
      this.actual = params;
      this.skip = paramInt;
    }
    
    public void dispose()
    {
      this.s.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.s.isDisposed();
    }
    
    public void onComplete()
    {
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.skip == size()) {
        this.actual.onNext(poll());
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */