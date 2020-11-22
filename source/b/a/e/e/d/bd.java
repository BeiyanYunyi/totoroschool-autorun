package b.a.e.e.d;

import b.a.e.d.i;
import b.a.l;
import b.a.s;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class bd<T>
  extends l<T>
{
  final Future<? extends T> a;
  final long b;
  final TimeUnit c;
  
  public bd(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    this.a = paramFuture;
    this.b = paramLong;
    this.c = paramTimeUnit;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    i locali = new i(params);
    params.onSubscribe(locali);
    if (!locali.isDisposed()) {
      try
      {
        if (this.c != null) {
          localObject = this.a.get(this.b, this.c);
        } else {
          localObject = this.a.get();
        }
        Object localObject = b.a.e.b.b.a(localObject, "Future returned null");
        locali.complete(localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        if (!locali.isDisposed()) {
          params.onError(localThrowable);
        }
        return;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */