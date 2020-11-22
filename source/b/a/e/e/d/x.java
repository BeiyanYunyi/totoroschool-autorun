package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.i;
import b.a.j;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class x<T>
  extends a<T, T>
{
  final j<? extends T> b;
  
  public x(l<T> paraml, j<? extends T> paramj)
  {
    super(paraml);
    this.b = paramj;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends AtomicReference<b>
    implements b, i<T>, s<T>
  {
    private static final long serialVersionUID = -1953724749712440952L;
    final s<? super T> actual;
    boolean inMaybe;
    j<? extends T> other;
    
    a(s<? super T> params, j<? extends T> paramj)
    {
      this.actual = params;
      this.other = paramj;
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
      if (this.inMaybe)
      {
        this.actual.onComplete();
        return;
      }
      this.inMaybe = true;
      d.replace(this, null);
      j localj = this.other;
      this.other = null;
      localj.a(this);
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
      if ((d.setOnce(this, paramb)) && (!this.inMaybe)) {
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */