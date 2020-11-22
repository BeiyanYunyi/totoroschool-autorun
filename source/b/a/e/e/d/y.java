package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.v;
import b.a.w;
import java.util.concurrent.atomic.AtomicReference;

public final class y<T>
  extends a<T, T>
{
  final w<? extends T> b;
  
  public y(l<T> paraml, w<? extends T> paramw)
  {
    super(paraml);
    this.b = paramw;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends AtomicReference<b>
    implements b, s<T>, v<T>
  {
    private static final long serialVersionUID = -1953724749712440952L;
    final s<? super T> actual;
    boolean inSingle;
    w<? extends T> other;
    
    a(s<? super T> params, w<? extends T> paramw)
    {
      this.actual = params;
      this.other = paramw;
    }
    
    public void dispose()
    {
      d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b)get());
    }
    
    public void onComplete()
    {
      this.inSingle = true;
      d.replace(this, null);
      w localw = this.other;
      this.other = null;
      localw.a(this);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      if ((d.setOnce(this, paramb)) && (!this.inSingle)) {
        this.actual.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.actual.onNext(paramT);
      this.actual.onComplete();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */