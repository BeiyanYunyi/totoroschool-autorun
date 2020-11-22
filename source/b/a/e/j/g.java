package b.a.e.j;

import b.a.h.a;
import b.a.i;
import b.a.s;
import b.a.v;

public enum g
  implements b.a.b.b, b.a.c, b.a.g<Object>, i<Object>, s<Object>, v<Object>, org.a.c
{
  private g() {}
  
  public static <T> s<T> asObserver()
  {
    return INSTANCE;
  }
  
  public static <T> org.a.b<T> asSubscriber()
  {
    return INSTANCE;
  }
  
  public void cancel() {}
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return true;
  }
  
  public void onComplete() {}
  
  public void onError(Throwable paramThrowable)
  {
    a.a(paramThrowable);
  }
  
  public void onNext(Object paramObject) {}
  
  public void onSubscribe(b.a.b.b paramb)
  {
    paramb.dispose();
  }
  
  public void onSubscribe(org.a.c paramc)
  {
    paramc.cancel();
  }
  
  public void onSuccess(Object paramObject) {}
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */