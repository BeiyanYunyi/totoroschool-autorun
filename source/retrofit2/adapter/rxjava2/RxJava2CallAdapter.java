package retrofit2.adapter.rxjava2;

import b.a.l;
import b.a.t;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class RxJava2CallAdapter<R>
  implements CallAdapter<R, Object>
{
  private final boolean isAsync;
  private final boolean isBody;
  private final boolean isCompletable;
  private final boolean isFlowable;
  private final boolean isMaybe;
  private final boolean isResult;
  private final boolean isSingle;
  private final Type responseType;
  @Nullable
  private final t scheduler;
  
  RxJava2CallAdapter(Type paramType, @Nullable t paramt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.responseType = paramType;
    this.scheduler = paramt;
    this.isAsync = paramBoolean1;
    this.isResult = paramBoolean2;
    this.isBody = paramBoolean3;
    this.isFlowable = paramBoolean4;
    this.isSingle = paramBoolean5;
    this.isMaybe = paramBoolean6;
    this.isCompletable = paramBoolean7;
  }
  
  public Object adapt(Call<R> paramCall)
  {
    if (this.isAsync) {
      paramCall = new CallEnqueueObservable(paramCall);
    } else {
      paramCall = new CallExecuteObservable(paramCall);
    }
    if (this.isResult) {
      paramCall = new ResultObservable(paramCall);
    } else if (this.isBody) {
      paramCall = new BodyObservable(paramCall);
    }
    Object localObject = paramCall;
    if (this.scheduler != null) {
      localObject = paramCall.subscribeOn(this.scheduler);
    }
    if (this.isFlowable) {
      return ((l)localObject).toFlowable(b.a.a.LATEST);
    }
    if (this.isSingle) {
      return ((l)localObject).singleOrError();
    }
    if (this.isMaybe) {
      return ((l)localObject).singleElement();
    }
    if (this.isCompletable) {
      return ((l)localObject).ignoreElements();
    }
    return b.a.h.a.a((l)localObject);
  }
  
  public Type responseType()
  {
    return this.responseType;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\adapter\rxjava2\RxJava2CallAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */