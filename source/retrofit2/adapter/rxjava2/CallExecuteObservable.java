package retrofit2.adapter.rxjava2;

import b.a.l;
import b.a.s;
import retrofit2.Call;
import retrofit2.Response;

final class CallExecuteObservable<T>
  extends l<Response<T>>
{
  private final Call<T> originalCall;
  
  CallExecuteObservable(Call<T> paramCall)
  {
    this.originalCall = paramCall;
  }
  
  protected void subscribeActual(s<? super Response<T>> params)
  {
    Object localObject = this.originalCall.clone();
    CallDisposable localCallDisposable = new CallDisposable((Call)localObject);
    params.onSubscribe(localCallDisposable);
    if (localCallDisposable.isDisposed()) {
      return;
    }
    int i;
    try
    {
      localObject = ((Call)localObject).execute();
      if (!localCallDisposable.isDisposed()) {
        params.onNext(localObject);
      }
      boolean bool = localCallDisposable.isDisposed();
      if (bool) {
        return;
      }
      try
      {
        params.onComplete();
        return;
      }
      catch (Throwable localThrowable1)
      {
        i = 1;
      }
      b.a.c.b.b(localThrowable2);
    }
    catch (Throwable localThrowable2)
    {
      i = 0;
    }
    if (i != 0)
    {
      b.a.h.a.a(localThrowable2);
      return;
    }
    if (!localCallDisposable.isDisposed()) {
      try
      {
        params.onError(localThrowable2);
        return;
      }
      catch (Throwable params)
      {
        b.a.c.b.b(params);
        b.a.h.a.a(new b.a.c.a(new Throwable[] { localThrowable2, params }));
      }
    }
  }
  
  private static final class CallDisposable
    implements b.a.b.b
  {
    private final Call<?> call;
    private volatile boolean disposed;
    
    CallDisposable(Call<?> paramCall)
    {
      this.call = paramCall;
    }
    
    public void dispose()
    {
      this.disposed = true;
      this.call.cancel();
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\adapter\rxjava2\CallExecuteObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */