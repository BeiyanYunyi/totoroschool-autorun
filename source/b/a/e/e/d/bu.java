package b.a.e.e.d;

import b.a.p;
import b.a.q;
import b.a.s;

public final class bu<R, T>
  extends a<T, R>
{
  final p<? extends R, ? super T> b;
  
  public bu(q<T> paramq, p<? extends R, ? super T> paramp)
  {
    super(paramq);
    this.b = paramp;
  }
  
  public void subscribeActual(s<? super R> params)
  {
    try
    {
      params = this.b.a(params);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Operator ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" returned a null Observer");
      params = (s)b.a.e.b.b.a(params, ((StringBuilder)localObject).toString());
      this.a.subscribe(params);
      return;
    }
    catch (Throwable params)
    {
      b.a.c.b.b(params);
      b.a.h.a.a(params);
      Object localObject = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
      ((NullPointerException)localObject).initCause(params);
      throw ((Throwable)localObject);
    }
    catch (NullPointerException params)
    {
      throw params;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */