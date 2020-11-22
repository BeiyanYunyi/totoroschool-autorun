package b.a.e.a;

import b.a.c;
import b.a.e.c.b;
import b.a.i;
import b.a.s;
import b.a.v;

public enum e
  implements b<Object>
{
  private e() {}
  
  public static void complete(c paramc)
  {
    paramc.onSubscribe(INSTANCE);
    paramc.onComplete();
  }
  
  public static void complete(i<?> parami)
  {
    parami.onSubscribe(INSTANCE);
    parami.onComplete();
  }
  
  public static void complete(s<?> params)
  {
    params.onSubscribe(INSTANCE);
    params.onComplete();
  }
  
  public static void error(Throwable paramThrowable, c paramc)
  {
    paramc.onSubscribe(INSTANCE);
    paramc.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, i<?> parami)
  {
    parami.onSubscribe(INSTANCE);
    parami.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, s<?> params)
  {
    params.onSubscribe(INSTANCE);
    params.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, v<?> paramv)
  {
    paramv.onSubscribe(INSTANCE);
    paramv.onError(paramThrowable);
  }
  
  public void clear() {}
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return this == INSTANCE;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean offer(Object paramObject)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public boolean offer(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public Object poll()
    throws Exception
  {
    return null;
  }
  
  public int requestFusion(int paramInt)
  {
    return paramInt & 0x2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */