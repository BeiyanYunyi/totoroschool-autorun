package b.a.e.e.d;

import b.a.d.g;
import b.a.e.c.b;
import b.a.q;
import b.a.s;

public final class al<T>
  extends a<T, T>
{
  final g<? super T> b;
  
  public al(q<T> paramq, g<? super T> paramg)
  {
    super(paramq);
    this.b = paramg;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(new a(params, this.b));
  }
  
  static final class a<T>
    extends b.a.e.d.a<T, T>
  {
    final g<? super T> f;
    
    a(s<? super T> params, g<? super T> paramg)
    {
      super();
      this.f = paramg;
    }
    
    public void onNext(T paramT)
    {
      this.a.onNext(paramT);
      if (this.e == 0) {
        try
        {
          this.f.accept(paramT);
          return;
        }
        catch (Throwable paramT)
        {
          a(paramT);
        }
      }
    }
    
    public T poll()
      throws Exception
    {
      Object localObject = this.c.poll();
      if (localObject != null) {
        this.f.accept(localObject);
      }
      return (T)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      return a(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */