package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.concurrent.atomic.AtomicReference;

public final class dj<T>
  extends a<T, T>
{
  final t b;
  
  public dj(q<T> paramq, t paramt)
  {
    super(paramq);
    this.b = paramt;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    a locala = new a(params);
    params.onSubscribe(locala);
    locala.setDisposable(this.b.a(new b(locala)));
  }
  
  static final class a<T>
    extends AtomicReference<b>
    implements b, s<T>
  {
    private static final long serialVersionUID = 8094547886072529208L;
    final s<? super T> actual;
    final AtomicReference<b> s;
    
    a(s<? super T> params)
    {
      this.actual = params;
      this.s = new AtomicReference();
    }
    
    public void dispose()
    {
      d.dispose(this.s);
      d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b)get());
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
      this.actual.onNext(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      d.setOnce(this.s, paramb);
    }
    
    void setDisposable(b paramb)
    {
      d.setOnce(this, paramb);
    }
  }
  
  final class b
    implements Runnable
  {
    private final dj.a<T> b;
    
    b()
    {
      dj.a locala;
      this.b = locala;
    }
    
    public void run()
    {
      dj.this.a.subscribe(this.b);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */