package b.a.e.d;

import b.a.d.g;
import b.a.e.a.d;
import b.a.e.a.e;
import b.a.s;

public final class j<T>
  implements b.a.b.b, s<T>
{
  final s<? super T> a;
  final g<? super b.a.b.b> b;
  final b.a.d.a c;
  b.a.b.b d;
  
  public j(s<? super T> params, g<? super b.a.b.b> paramg, b.a.d.a parama)
  {
    this.a = params;
    this.b = paramg;
    this.c = parama;
  }
  
  public void dispose()
  {
    try
    {
      this.c.a();
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      b.a.h.a.a(localThrowable);
    }
    this.d.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.d.isDisposed();
  }
  
  public void onComplete()
  {
    if (this.d != d.DISPOSED) {
      this.a.onComplete();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.d != d.DISPOSED)
    {
      this.a.onError(paramThrowable);
      return;
    }
    b.a.h.a.a(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.a.onNext(paramT);
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    try
    {
      this.b.accept(paramb);
      if (d.validate(this.d, paramb))
      {
        this.d = paramb;
        this.a.onSubscribe(this);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      paramb.dispose();
      this.d = d.DISPOSED;
      e.error(localThrowable, this.a);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */