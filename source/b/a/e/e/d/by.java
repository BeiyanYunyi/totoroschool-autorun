package b.a.e.e.d;

import b.a.b.b;
import b.a.e.j.k;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class by<T>
  extends a<T, T>
{
  final b.a.d b;
  
  public by(l<T> paraml, b.a.d paramd)
  {
    super(paraml);
    this.b = paramd;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    a locala = new a(params);
    params.onSubscribe(locala);
    this.a.subscribe(locala);
    this.b.a(locala.otherObserver);
  }
  
  static final class a<T>
    extends AtomicInteger
    implements b, s<T>
  {
    private static final long serialVersionUID = -4592979584110982903L;
    final s<? super T> actual;
    final b.a.e.j.c error;
    final AtomicReference<b> mainDisposable;
    volatile boolean mainDone;
    volatile boolean otherDone;
    final a otherObserver;
    
    a(s<? super T> params)
    {
      this.actual = params;
      this.mainDisposable = new AtomicReference();
      this.otherObserver = new a(this);
      this.error = new b.a.e.j.c();
    }
    
    public void dispose()
    {
      b.a.e.a.d.dispose(this.mainDisposable);
      b.a.e.a.d.dispose(this.otherObserver);
    }
    
    public boolean isDisposed()
    {
      return b.a.e.a.d.isDisposed((b)this.mainDisposable.get());
    }
    
    public void onComplete()
    {
      this.mainDone = true;
      if (this.otherDone) {
        k.a(this.actual, this, this.error);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      b.a.e.a.d.dispose(this.mainDisposable);
      k.a(this.actual, paramThrowable, this, this.error);
    }
    
    public void onNext(T paramT)
    {
      k.a(this.actual, paramT, this, this.error);
    }
    
    public void onSubscribe(b paramb)
    {
      b.a.e.a.d.setOnce(this.mainDisposable, paramb);
    }
    
    void otherComplete()
    {
      this.otherDone = true;
      if (this.mainDone) {
        k.a(this.actual, this, this.error);
      }
    }
    
    void otherError(Throwable paramThrowable)
    {
      b.a.e.a.d.dispose(this.mainDisposable);
      k.a(this.actual, paramThrowable, this, this.error);
    }
    
    static final class a
      extends AtomicReference<b>
      implements b.a.c
    {
      private static final long serialVersionUID = -2935427570954647017L;
      final by.a<?> parent;
      
      a(by.a<?> parama)
      {
        this.parent = parama;
      }
      
      public void onComplete()
      {
        this.parent.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.otherError(paramThrowable);
      }
      
      public void onSubscribe(b paramb)
      {
        b.a.e.a.d.setOnce(this, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */