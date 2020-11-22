package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.g;
import b.a.q;
import b.a.s;

public final class dk<T>
  extends a<T, T>
{
  final q<? extends T> b;
  
  public dk(q<T> paramq, q<? extends T> paramq1)
  {
    super(paramq);
    this.b = paramq1;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    a locala = new a(params, this.b);
    params.onSubscribe(locala.c);
    this.a.subscribe(locala);
  }
  
  static final class a<T>
    implements s<T>
  {
    final s<? super T> a;
    final q<? extends T> b;
    final g c;
    boolean d;
    
    a(s<? super T> params, q<? extends T> paramq)
    {
      this.a = params;
      this.b = paramq;
      this.d = true;
      this.c = new g();
    }
    
    public void onComplete()
    {
      if (this.d)
      {
        this.d = false;
        this.b.subscribe(this);
        return;
      }
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.d) {
        this.d = false;
      }
      this.a.onNext(paramT);
    }
    
    public void onSubscribe(b paramb)
    {
      this.c.update(paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */