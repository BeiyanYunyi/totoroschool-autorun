package b.a.e.e.d;

import b.a.d.h;
import b.a.q;
import b.a.s;

public final class bv<T, U>
  extends a<T, U>
{
  final h<? super T, ? extends U> b;
  
  public bv(q<T> paramq, h<? super T, ? extends U> paramh)
  {
    super(paramq);
    this.b = paramh;
  }
  
  public void subscribeActual(s<? super U> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T, U>
    extends b.a.e.d.a<T, U>
  {
    final h<? super T, ? extends U> f;
    
    a(s<? super U> params, h<? super T, ? extends U> paramh)
    {
      super();
      this.f = paramh;
    }
    
    public void onNext(T paramT)
    {
      if (this.d) {
        return;
      }
      if (this.e != 0)
      {
        this.a.onNext(null);
        return;
      }
      try
      {
        paramT = b.a.e.b.b.a(this.f.apply(paramT), "The mapper function returned a null value.");
        this.a.onNext(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        a(paramT);
      }
    }
    
    public U poll()
      throws Exception
    {
      Object localObject = this.c.poll();
      if (localObject != null) {
        return (U)b.a.e.b.b.a(this.f.apply(localObject), "The mapper function returned a null value.");
      }
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return a(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */