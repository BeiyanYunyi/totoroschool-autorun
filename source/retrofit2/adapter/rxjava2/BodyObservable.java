package retrofit2.adapter.rxjava2;

import b.a.l;
import b.a.s;
import retrofit2.Response;

final class BodyObservable<T>
  extends l<T>
{
  private final l<Response<T>> upstream;
  
  BodyObservable(l<Response<T>> paraml)
  {
    this.upstream = paraml;
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.upstream.subscribe(new BodyObserver(params));
  }
  
  private static class BodyObserver<R>
    implements s<Response<R>>
  {
    private final s<? super R> observer;
    private boolean terminated;
    
    BodyObserver(s<? super R> params)
    {
      this.observer = params;
    }
    
    public void onComplete()
    {
      if (!this.terminated) {
        this.observer.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.terminated)
      {
        this.observer.onError(paramThrowable);
        return;
      }
      AssertionError localAssertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
      localAssertionError.initCause(paramThrowable);
      b.a.h.a.a(localAssertionError);
    }
    
    public void onNext(Response<R> paramResponse)
    {
      if (paramResponse.isSuccessful())
      {
        this.observer.onNext(paramResponse.body());
        return;
      }
      this.terminated = true;
      paramResponse = new HttpException(paramResponse);
      try
      {
        this.observer.onError(paramResponse);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        b.a.h.a.a(new b.a.c.a(new Throwable[] { paramResponse, localThrowable }));
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.observer.onSubscribe(paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\adapter\rxjava2\BodyObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */