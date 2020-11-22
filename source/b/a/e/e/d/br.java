package b.a.e.e.d;

import b.a.e.c.e;
import b.a.l;
import b.a.s;

public final class br<T>
  extends l<T>
  implements e<T>
{
  private final T a;
  
  public br(T paramT)
  {
    this.a = paramT;
  }
  
  public T call()
  {
    return (T)this.a;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    cw.a locala = new cw.a(params, this.a);
    params.onSubscribe(locala);
    locala.run();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */