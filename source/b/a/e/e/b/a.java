package b.a.e.e.b;

import b.a.b.b;
import b.a.e.a.d;
import b.a.j;
import b.a.l;
import b.a.s;

public final class a<T>
  extends l<T>
{
  final j<T> a;
  
  public static <T> b.a.i<T> a(s<? super T> params)
  {
    return new a(params);
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.a(a(params));
  }
  
  static final class a<T>
    extends b.a.e.d.i<T>
    implements b.a.i<T>
  {
    private static final long serialVersionUID = 7603343402964826922L;
    b d;
    
    a(s<? super T> params)
    {
      super();
    }
    
    public void dispose()
    {
      super.dispose();
      this.d.dispose();
    }
    
    public void onComplete()
    {
      complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      error(paramThrowable);
    }
    
    public void onSubscribe(b paramb)
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */