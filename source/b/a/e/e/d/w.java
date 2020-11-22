package b.a.e.e.d;

import b.a.b.b;
import b.a.c;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class w<T>
  extends a<T, T>
{
  final b.a.d b;
  
  public w(l<T> paraml, b.a.d paramd)
  {
    super(paraml);
    this.b = paramd;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends AtomicReference<b>
    implements b, c, s<T>
  {
    private static final long serialVersionUID = -1953724749712440952L;
    final s<? super T> actual;
    boolean inCompletable;
    b.a.d other;
    
    a(s<? super T> params, b.a.d paramd)
    {
      this.actual = params;
      this.other = paramd;
    }
    
    public void dispose()
    {
      b.a.e.a.d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return b.a.e.a.d.isDisposed((b)get());
    }
    
    public void onComplete()
    {
      if (this.inCompletable)
      {
        this.actual.onComplete();
        return;
      }
      this.inCompletable = true;
      b.a.e.a.d.replace(this, null);
      b.a.d locald = this.other;
      this.other = null;
      locald.a(this);
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
      if ((b.a.e.a.d.setOnce(this, paramb)) && (!this.inCompletable)) {
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */