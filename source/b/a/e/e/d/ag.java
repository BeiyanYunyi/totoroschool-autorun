package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.g;
import b.a.h.a;
import b.a.l;
import b.a.q;
import b.a.s;

public final class ag<T, U>
  extends l<T>
{
  final q<? extends T> a;
  final q<U> b;
  
  public ag(q<? extends T> paramq, q<U> paramq1)
  {
    this.a = paramq;
    this.b = paramq1;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    g localg = new g();
    params.onSubscribe(localg);
    params = new a(localg, params);
    this.b.subscribe(params);
  }
  
  final class a
    implements s<U>
  {
    final g a;
    final s<? super T> b;
    boolean c;
    
    a(s<? super T> params)
    {
      this.a = params;
      s locals;
      this.b = locals;
    }
    
    public void onComplete()
    {
      if (this.c) {
        return;
      }
      this.c = true;
      ag.this.a.subscribe(new a());
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.c)
      {
        a.a(paramThrowable);
        return;
      }
      this.c = true;
      this.b.onError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      onComplete();
    }
    
    public void onSubscribe(b paramb)
    {
      this.a.update(paramb);
    }
    
    final class a
      implements s<T>
    {
      a() {}
      
      public void onComplete()
      {
        ag.a.this.b.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        ag.a.this.b.onError(paramThrowable);
      }
      
      public void onNext(T paramT)
      {
        ag.a.this.b.onNext(paramT);
      }
      
      public void onSubscribe(b paramb)
      {
        ag.a.this.a.update(paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */