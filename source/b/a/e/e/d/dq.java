package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.j.c;
import b.a.e.j.k;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class dq<T, U>
  extends a<T, T>
{
  final q<? extends U> b;
  
  public dq(q<T> paramq, q<? extends U> paramq1)
  {
    super(paramq);
    this.b = paramq1;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    a locala = new a(params);
    params.onSubscribe(locala);
    this.b.subscribe(locala.otherObserver);
    this.a.subscribe(locala);
  }
  
  static final class a<T, U>
    extends AtomicInteger
    implements b, s<T>
  {
    private static final long serialVersionUID = 1418547743690811973L;
    final s<? super T> downstream;
    final c error;
    final a<T, U>.a otherObserver;
    final AtomicReference<b> upstream;
    
    a(s<? super T> params)
    {
      this.downstream = params;
      this.upstream = new AtomicReference();
      this.otherObserver = new a();
      this.error = new c();
    }
    
    public void dispose()
    {
      d.dispose(this.upstream);
      d.dispose(this.otherObserver);
    }
    
    public boolean isDisposed()
    {
      return d.isDisposed((b)this.upstream.get());
    }
    
    public void onComplete()
    {
      d.dispose(this.otherObserver);
      k.a(this.downstream, this, this.error);
    }
    
    public void onError(Throwable paramThrowable)
    {
      d.dispose(this.otherObserver);
      k.a(this.downstream, paramThrowable, this, this.error);
    }
    
    public void onNext(T paramT)
    {
      k.a(this.downstream, paramT, this, this.error);
    }
    
    public void onSubscribe(b paramb)
    {
      d.setOnce(this.upstream, paramb);
    }
    
    void otherComplete()
    {
      d.dispose(this.upstream);
      k.a(this.downstream, this, this.error);
    }
    
    void otherError(Throwable paramThrowable)
    {
      d.dispose(this.upstream);
      k.a(this.downstream, paramThrowable, this, this.error);
    }
    
    final class a
      extends AtomicReference<b>
      implements s<U>
    {
      private static final long serialVersionUID = -8693423678067375039L;
      
      a() {}
      
      public void onComplete()
      {
        dq.a.this.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        dq.a.this.otherError(paramThrowable);
      }
      
      public void onNext(U paramU)
      {
        d.dispose(this);
        dq.a.this.otherComplete();
      }
      
      public void onSubscribe(b paramb)
      {
        d.setOnce(this, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */