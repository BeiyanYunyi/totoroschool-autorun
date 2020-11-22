package b.a.e.e.d;

import b.a.d.h;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class cg<T, R>
  extends a<T, R>
{
  final h<? super l<T>, ? extends q<R>> b;
  
  public cg(q<T> paramq, h<? super l<T>, ? extends q<R>> paramh)
  {
    super(paramq);
    this.b = paramh;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    b.a.j.a locala = b.a.j.a.a();
    try
    {
      q localq = (q)b.a.e.b.b.a(this.b.apply(locala), "The selector returned a null ObservableSource");
      params = new b(params);
      localq.subscribe(params);
      this.a.subscribe(new a(locala, params));
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      e.error(localThrowable, params);
    }
  }
  
  static final class a<T, R>
    implements s<T>
  {
    final b.a.j.a<T> a;
    final AtomicReference<b.a.b.b> b;
    
    a(b.a.j.a<T> parama, AtomicReference<b.a.b.b> paramAtomicReference)
    {
      this.a = parama;
      this.b = paramAtomicReference;
    }
    
    public void onComplete()
    {
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.a.onNext(paramT);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this.b, paramb);
    }
  }
  
  static final class b<T, R>
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, s<R>
  {
    private static final long serialVersionUID = 854110278590336484L;
    final s<? super R> actual;
    b.a.b.b d;
    
    b(s<? super R> params)
    {
      this.actual = params;
    }
    
    public void dispose()
    {
      this.d.dispose();
      d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      d.dispose(this);
      this.actual.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      d.dispose(this);
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(R paramR)
    {
      this.actual.onNext(paramR);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.actual.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */