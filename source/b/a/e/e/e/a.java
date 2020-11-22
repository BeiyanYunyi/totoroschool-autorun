package b.a.e.e.e;

import b.a.d.h;
import b.a.u;
import b.a.v;
import b.a.w;

public final class a<T, R>
  extends u<R>
{
  final w<? extends T> a;
  final h<? super T, ? extends R> b;
  
  public a(w<? extends T> paramw, h<? super T, ? extends R> paramh)
  {
    this.a = paramw;
    this.b = paramh;
  }
  
  protected void b(v<? super R> paramv)
  {
    this.a.a(new a(paramv, this.b));
  }
  
  static final class a<T, R>
    implements v<T>
  {
    final v<? super R> a;
    final h<? super T, ? extends R> b;
    
    a(v<? super R> paramv, h<? super T, ? extends R> paramh)
    {
      this.a = paramv;
      this.b = paramh;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.a.onSubscribe(paramb);
    }
    
    public void onSuccess(T paramT)
    {
      try
      {
        paramT = b.a.e.b.b.a(this.b.apply(paramT), "The mapper function returned a null value.");
        this.a.onSuccess(paramT);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        onError(paramT);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */