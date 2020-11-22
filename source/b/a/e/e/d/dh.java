package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.g.e;
import b.a.q;
import b.a.s;

public final class dh<T, U>
  extends a<T, T>
{
  final q<U> b;
  
  public dh(q<T> paramq, q<U> paramq1)
  {
    super(paramq);
    this.b = paramq1;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    params = new e(params);
    b.a.e.a.a locala = new b.a.e.a.a(2);
    params.onSubscribe(locala);
    b localb = new b(params, locala);
    this.b.subscribe(new a(locala, localb, params));
    this.a.subscribe(localb);
  }
  
  final class a
    implements s<U>
  {
    b a;
    private final b.a.e.a.a c;
    private final dh.b<T> d;
    private final e<T> e;
    
    a(dh.b<T> paramb, e<T> parame)
    {
      this.c = paramb;
      this.d = parame;
      e locale;
      this.e = locale;
    }
    
    public void onComplete()
    {
      this.d.d = true;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.dispose();
      this.e.onError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      this.a.dispose();
      this.d.d = true;
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.a, paramb))
      {
        this.a = paramb;
        this.c.setResource(1, paramb);
      }
    }
  }
  
  static final class b<T>
    implements s<T>
  {
    final s<? super T> a;
    final b.a.e.a.a b;
    b c;
    volatile boolean d;
    boolean e;
    
    b(s<? super T> params, b.a.e.a.a parama)
    {
      this.a = params;
      this.b = parama;
    }
    
    public void onComplete()
    {
      this.b.dispose();
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.b.dispose();
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.e)
      {
        this.a.onNext(paramT);
        return;
      }
      if (this.d)
      {
        this.e = true;
        this.a.onNext(paramT);
      }
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.c, paramb))
      {
        this.c = paramb;
        this.b.setResource(0, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */