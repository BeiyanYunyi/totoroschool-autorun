package b.a.e.e.d;

import b.a.c;
import b.a.l;
import b.a.q;
import b.a.s;

public final class bm<T>
  extends b.a.b
  implements b.a.e.c.a<T>
{
  final q<T> a;
  
  public bm(q<T> paramq)
  {
    this.a = paramq;
  }
  
  public void b(c paramc)
  {
    this.a.subscribe(new a(paramc));
  }
  
  public l<T> e_()
  {
    return b.a.h.a.a(new bl(this.a));
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    final c a;
    b.a.b.b b;
    
    a(c paramc)
    {
      this.a = paramc;
    }
    
    public void dispose()
    {
      this.b.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.b.isDisposed();
    }
    
    public void onComplete()
    {
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT) {}
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.b = paramb;
      this.a.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */