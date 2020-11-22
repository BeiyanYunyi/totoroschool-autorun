package retrofit2.adapter.rxjava2;

import b.a.l;
import b.a.s;
import retrofit2.Response;

final class ResultObservable<T>
  extends l<Result<T>>
{
  private final l<Response<T>> upstream;
  
  ResultObservable(l<Response<T>> paraml)
  {
    this.upstream = paraml;
  }
  
  protected void subscribeActual(s<? super Result<T>> params)
  {
    this.upstream.subscribe(new ResultObserver(params));
  }
  
  private static class ResultObserver<R>
    implements s<Response<R>>
  {
    private final s<? super Result<R>> observer;
    
    ResultObserver(s<? super Result<R>> params)
    {
      this.observer = params;
    }
    
    public void onComplete()
    {
      this.observer.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        this.observer.onNext(Result.error(paramThrowable));
        this.observer.onComplete();
        return;
      }
      catch (Throwable paramThrowable)
      {
        try
        {
          this.observer.onError(paramThrowable);
          return;
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          b.a.h.a.a(new b.a.c.a(new Throwable[] { paramThrowable, localThrowable }));
        }
      }
    }
    
    public void onNext(Response<R> paramResponse)
    {
      this.observer.onNext(Result.response(paramResponse));
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      this.observer.onSubscribe(paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\adapter\rxjava2\ResultObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */