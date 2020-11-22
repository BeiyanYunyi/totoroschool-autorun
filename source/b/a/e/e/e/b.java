package b.a.e.e.e;

import b.a.e.a.d;
import b.a.e.d.i;
import b.a.l;
import b.a.s;
import b.a.v;
import b.a.w;

public final class b<T>
  extends l<T>
{
  final w<? extends T> a;
  
  public b(w<? extends T> paramw)
  {
    this.a = paramw;
  }
  
  public static <T> v<T> a(s<? super T> params)
  {
    return new a(params);
  }
  
  public void subscribeActual(s<? super T> params)
  {
    this.a.a(a(params));
  }
  
  static final class a<T>
    extends i<T>
    implements v<T>
  {
    private static final long serialVersionUID = 3786543492451018833L;
    b.a.b.b d;
    
    a(s<? super T> params)
    {
      super();
    }
    
    public void dispose()
    {
      super.dispose();
      this.d.dispose();
    }
    
    public void onError(Throwable paramThrowable)
    {
      error(paramThrowable);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.actual.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      complete(paramT);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */