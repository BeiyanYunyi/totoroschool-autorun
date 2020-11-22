package retrofit2.adapter.rxjava2;

import b.a.l;
import b.a.s;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

final class CallEnqueueObservable<T>
  extends l<Response<T>>
{
  private final Call<T> originalCall;
  
  CallEnqueueObservable(Call<T> paramCall)
  {
    this.originalCall = paramCall;
  }
  
  protected void subscribeActual(s<? super Response<T>> params)
  {
    Call localCall = this.originalCall.clone();
    CallCallback localCallCallback = new CallCallback(localCall, params);
    params.onSubscribe(localCallCallback);
    if (!localCallCallback.isDisposed()) {
      localCall.enqueue(localCallCallback);
    }
  }
  
  private static final class CallCallback<T>
    implements b.a.b.b, Callback<T>
  {
    private final Call<?> call;
    private volatile boolean disposed;
    private final s<? super Response<T>> observer;
    boolean terminated = false;
    
    CallCallback(Call<?> paramCall, s<? super Response<T>> params)
    {
      this.call = paramCall;
      this.observer = params;
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
    
    public void onFailure(Call<T> paramCall, Throwable paramThrowable)
    {
      if (paramCall.isCanceled()) {
        return;
      }
      try
      {
        this.observer.onError(paramThrowable);
        return;
      }
      catch (Throwable paramCall)
      {
        b.a.c.b.b(paramCall);
        b.a.h.a.a(new b.a.c.a(new Throwable[] { paramThrowable, paramCall }));
      }
    }
    
    public void onResponse(Call<T> paramCall, Response<T> paramResponse)
    {
      if (this.disposed) {
        return;
      }
      try
      {
        this.observer.onNext(paramResponse);
        if (!this.disposed)
        {
          this.terminated = true;
          this.observer.onComplete();
          return;
        }
      }
      catch (Throwable paramCall)
      {
        if (this.terminated)
        {
          b.a.h.a.a(paramCall);
          return;
        }
        if (!this.disposed) {
          try
          {
            this.observer.onError(paramCall);
            return;
          }
          catch (Throwable paramResponse)
          {
            b.a.c.b.b(paramResponse);
            b.a.h.a.a(new b.a.c.a(new Throwable[] { paramCall, paramResponse }));
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\adapter\rxjava2\CallEnqueueObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */